package com.example.social;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignupController {
    private final ProviderSignInUtils signInUtils;

    @Autowired
    UserService userService;

    @Autowired
    public SignupController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        signInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

    @RequestMapping(value = "/signup")
    public String signup(WebRequest request) {
        Connection<?> connection = signInUtils.getConnectionFromSession(request);
        if (connection != null) {
            authenticate(connection);
            signInUtils.doPostSignUp(userService.findByUserId(connection.getKey().getProviderUserId()).getUserId(), request);
        }
        return "redirect:/";
    }

    public void authenticate(Connection<?> connection) {
        UserProfile userProfile = connection.fetchUserProfile();
        String id = connection.getKey().getProviderUserId();
        saveToBase(userProfile, id);
        String username = userProfile.getName();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    public void saveToBase (UserProfile userProfile, String id){
        User user = new User();
        user.setUserId(id);
        user.setName(userProfile.getName());
        userService.save(user);
    }
}
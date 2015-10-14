package com.ipowertec.abigear.presentation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipowertec.abigear.domain.user.User;
import com.ipowertec.abigear.service.user.UserService;

@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;
    
    @RequestMapping("/home")
    public ModelAndView getHomePage() {
        LOGGER.debug("Getting home page");

        Long id = 1L;
        Optional<User> optional = userService.getUserById(id);

        Map<String, User> models = new HashMap<String, User>();
        models.put("user", optional.get());

        return new ModelAndView("home", models);
    }
}

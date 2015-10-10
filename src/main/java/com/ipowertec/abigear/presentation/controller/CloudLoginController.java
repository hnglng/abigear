package com.ipowertec.abigear.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CloudLoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudLoginController.class);

    @RequestMapping("/cloud/login")
    public ModelAndView getHomePage() {
        LOGGER.debug("Getting cloud login ...");
        return new ModelAndView("cloud-login");
    }
}

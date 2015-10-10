package com.ipowertec.abigear.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalCenterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalCenterController.class);

    //@RequestMapping("/personalcenter")
    public ModelAndView getHomePage() {
        LOGGER.debug("Getting personal center page");

        return new ModelAndView("personalcenter");
    }
}

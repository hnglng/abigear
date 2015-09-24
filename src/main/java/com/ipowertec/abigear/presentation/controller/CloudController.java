package com.ipowertec.abigear.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipowertec.abigear.service.cloud.CloudService;

@Controller
public class CloudController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudController.class);

    @Autowired
    private CloudService cloudService;

    @RequestMapping("/cloud")
    public ModelAndView getHomePage() {
        LOGGER.debug("Getting cloud center ...");
        return new ModelAndView("cloud");
    }
}

package com.school.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.config.AppConstants;
import com.school.management.config.UriConstants;
import com.school.management.model.EmailModel;
import com.school.management.model.SmResponseStatus;
import com.school.management.service.EmailService;

@RestController
@RequestMapping(value = UriConstants.NOTIFICATION)
@CrossOrigin( origins = {"http://dev.cloudscripts.co.in", "http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
public class NotificationController {
	public static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = UriConstants.SEND_EMAIL, method = RequestMethod.POST, produces = AppConstants.JSON)
	public SmResponseStatus sendEmail(@RequestBody EmailModel emailModel) {

		logger.info("Request received to send email [{}]");
		String message = "email sent";
		try {
			emailService.sendEmail(emailModel);

		} catch (Exception e) {
			message = String.format("Failed to send email " + e.getMessage());
			logger.error(message);
		}
		return new SmResponseStatus(message);
	}
}

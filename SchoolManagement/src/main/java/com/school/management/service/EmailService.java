package com.school.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.school.management.core.CustomException;
import com.school.management.model.EmailModel;

/**
 * 
 * @author Pavan.Pawar
 *
 *         This class is used to send email
 */
@Service
public class EmailService {

	@Value("${email.from}")
	private String from;

	public static final Logger logger = LoggerFactory.getLogger(EmailService.class);

	static final String TEXTBODY = "sorry html email not supported on your client";

	public void sendEmail(EmailModel emailModel) throws CustomException {

		try {
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withRegion(Regions.US_EAST_1).build();
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(
							new Destination()
									.withToAddresses(
											emailModel
													.getToEmailId()))
					.withMessage(new Message()
							.withBody(new Body()
									.withHtml(new Content().withCharset("UTF-8").withData(emailModel.getBody()))
									.withText(new Content().withCharset("UTF-8").withData(TEXTBODY)))
							.withSubject(new Content().withCharset("UTF-8").withData(emailModel.getSubject())))
					.withSource(from);

			client.sendEmail(request);
			logger.info("Email sent!");
		} catch (Exception ex) {
			logger.error("The email was not sent. Error message: ", ex);
			throw new CustomException(ex.getMessage());

		}
	}
}

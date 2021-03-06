package com.school.management.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.util.StringUtils;
import com.school.management.model.SmsModel;

/**
 * 
 * @author Pavan.Pawar
 *
 */
@Service
public class SmsService {

	@Value("${sms.server}")
	private String smsServerUrl;

	@Value("${sms.senderId}")
	private String smsSenderID;

	@Value("${sms.prodSenderId}")
	private String prodSenderId;

	@Value("${sms.envoriment}")
	private String envoriment;

	@Value("${sms.prodserver}")
	private String smsServerProdUrl;

	private static final String API_KEY_SYSTEM_PROPERTY = "sms.apikey";

	private static final String SMS_USERNAME_SYSTEM_PROPERTY = "sms.usrname";

	private static final String SMS_PASSWORD_SYSTEM_PROPERTY = "sms.password";

	public static final Logger logger = LoggerFactory.getLogger(SmsService.class);

	public String sendSms(SmsModel smsModel) {
		String result = null;
		try {
			String systemApikay = StringUtils.trim(System.getProperty(API_KEY_SYSTEM_PROPERTY));

			String userName = "username=" + StringUtils.trim(System.getProperty(SMS_USERNAME_SYSTEM_PROPERTY));

			String password = "&password=" + StringUtils.trim(System.getProperty(SMS_PASSWORD_SYSTEM_PROPERTY));

			String apiKey;

			apiKey = "apikey=" + URLEncoder.encode(systemApikay, "UTF-8");
			//String message = "&message=" + URLEncoder.encode(smsModel.getBody(), "UTF-8");
			String message = "&message=" + smsModel.getBody();
			String sender = "&sender=" + URLEncoder.encode(smsSenderID, "UTF-8");
			//String numbers = "&numbers=" + URLEncoder.encode(smsModel.getPhonenumber(), "UTF-8");
			String numbers = "&numbers=" + smsModel.getPhonenumber();

			String prodSender = "&sender=" + URLEncoder.encode(prodSenderId, "UTF-8");
			//String enableProdUnicod = "&unicode=1";
			String uri = "";
			if (envoriment.equalsIgnoreCase("dev")) {

				uri = smsServerUrl + "/send/?" + apiKey + numbers + message + sender;
			} else if (envoriment.equalsIgnoreCase("prod")) {
				uri = smsServerProdUrl + "/pushsms.php?" + userName + password + prodSender + numbers + message;
			
			}

			logger.debug("sms url:" + uri);
			RestTemplate restTemplate = new RestTemplate();
			result = restTemplate.getForObject(uri, String.class);
			logger.info(result);

		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			result = e.getMessage();
		}

		return result;
	}
}

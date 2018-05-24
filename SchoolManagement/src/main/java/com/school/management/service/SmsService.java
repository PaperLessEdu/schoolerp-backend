package com.school.management.service;

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

	private static final String API_KEY_SYSTEM_PROPERTY = "sms.apikey";

	public static final Logger logger = LoggerFactory.getLogger(SmsService.class);

	public String sendSms(SmsModel smsModel) {
		String systemApikay = StringUtils.trim(System.getProperty(API_KEY_SYSTEM_PROPERTY));

		String apiKey = "apikey=" + systemApikay;
		String message = "&message=" + smsModel.getBody();
		String sender = "&sender=" + smsSenderID;
		String numbers = "&numbers=" + smsModel.getPhonenumber();
		final String uri = smsServerUrl + "send/?" + apiKey + numbers + message + sender;

		logger.debug("sms url:" + uri);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		logger.info(result);
		return result;
	}
}

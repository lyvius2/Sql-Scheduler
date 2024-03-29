package com.sql.scheduler.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 메일 발송
	 * @param message
	 */
	public void sendMail(SimpleMailMessage message) {
		mailSender.send(message);
	}
}

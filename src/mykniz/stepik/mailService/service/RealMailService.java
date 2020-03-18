package mykniz.stepik.mailService.service;

import mykniz.stepik.mailService.mail.Sendable;

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}

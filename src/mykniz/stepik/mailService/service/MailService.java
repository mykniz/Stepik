package mykniz.stepik.mailService.service;

import mykniz.stepik.mailService.mail.Sendable;

public interface MailService {
    Sendable processMail(Sendable mail);
}

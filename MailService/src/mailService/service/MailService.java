package mailService.service;

import mailService.mail.Sendable;

public interface MailService {
    Sendable processMail(Sendable mail);
}

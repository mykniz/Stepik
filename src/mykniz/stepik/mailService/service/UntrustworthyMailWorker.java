package mykniz.stepik.mailService.service;

import mykniz.stepik.mailService.mail.Sendable;

public class UntrustworthyMailWorker implements MailService {
    private final MailService[] MAIL_SERVICES;
    RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(final MailService[] MAIL_SERVICES) {
        this.MAIL_SERVICES = MAIL_SERVICES.clone();
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService m : MAIL_SERVICES) {
            mail = m.processMail(mail);
        }
        mail = realMailService.processMail(mail);
        return mail;
    }

    public MailService getRealMailService() {
        return realMailService;
    }
}

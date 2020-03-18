package mailService.service;

import mailService.mail.MailPackage;
import mailService.mail.Sendable;

public class Inspector implements MailService {
    private final String WEAPONS = "weapons";
    private final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage originalMail = (MailPackage) mail;
            if (originalMail.getContent().getContent().contains(WEAPONS) || originalMail.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            } else if (originalMail.getContent().getContent().contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }

    public class StolenPackageException extends RuntimeException{
        public StolenPackageException() {
            super();
        }
    }

    public class IllegalPackageException extends RuntimeException{
        public IllegalPackageException() {
            super();
        }
    }
}

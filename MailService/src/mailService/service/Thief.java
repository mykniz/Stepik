package mailService.service;

import mailService.mail.MailPackage;
import mailService.mail.Package;
import mailService.mail.Sendable;

public class Thief implements MailService {
    private final int MIN_PRICE;
    private int totalStolenValue = 0;

    public Thief(final int MIN_PRICE) {
        this.MIN_PRICE = MIN_PRICE;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable processedMail;

        if (mail instanceof MailPackage) {
            MailPackage originalMail = (MailPackage) mail;
            int price = originalMail.getContent().getPrice();
            if (price < MIN_PRICE) {
                processedMail = originalMail;
            } else {
                Package pkg = new Package("stones instead of " + originalMail.getContent().getContent(), 0);
                processedMail = new MailPackage(originalMail.getFrom(), originalMail.getTo(), pkg);
                totalStolenValue += price;
            }
        } else {
            processedMail = mail;
        }

        return processedMail;
    }

    public int getStolenValue() {
        return totalStolenValue;
    }
}

package mykniz.stepik.mailService.service;

import mykniz.stepik.mailService.mail.MailMessage;
import mykniz.stepik.mailService.mail.Sendable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Spy implements MailService {
    private final String AUSTIN_POWERS = "Austin Powers";
    private final Logger LOGGER;

    public Spy(final Logger LOGGER) {
        this.LOGGER = LOGGER;
    }

    @Override
    public Sendable processMail(Sendable mail) {

        if (mail instanceof MailMessage) {
            MailMessage msg = (MailMessage) mail;
            if (mail.getTo() == AUSTIN_POWERS || mail.getFrom() == AUSTIN_POWERS) {
                LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{msg.getFrom(), msg.getTo(), msg.getMessage()});
            } else {
                LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                        new Object[]{msg.getFrom(), msg.getTo()});
            }
        }
        return mail;
    }
}

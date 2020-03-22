package mailService;

import mailService.mail.*;
import mailService.mail.Package;
import mailService.service.*;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Sendable[] mailTraffic = new Sendable[] {
                new LogIt(new TimeIt(new MailMessage("Navalny", "Putin", "Make the Russia free again"))),
                new MailMessage("Sobchak", "Dud", "Wanna talk"),
                new MailMessage("Austin Powers", "James Bond", "Wasted"),
                new MailPackage("Trump", "Merkel", new Package("money",1000)),
                new MailPackage("Putin", "Asad", new Package("weapons",10000)),
                new MailPackage("Nick", "Egor", new Package("change",1)),
        };

        final Logger LOGGER = Logger.getLogger("SpyLogger");

        MailService[] mailServices = new MailService[]{
                new Spy(LOGGER),
                new Thief(10),
                //new Inspector(),
        };

        UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(mailServices);

        for (Sendable mail : mailTraffic) {
            System.out.println(mail.getFrom());
            untrustworthyMailWorker.processMail(mail);
            Thief thief = (Thief) mailServices[1];
            System.out.println("Total stolen value is: " + thief.getStolenValue());
        }
    }
}

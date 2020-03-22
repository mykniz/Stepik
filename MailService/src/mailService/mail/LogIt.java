package mailService.mail;

public class LogIt implements Sendable {
    private Sendable sendable;

    public LogIt (Sendable sendable) {
        this.sendable = sendable;
    }

    @Override
    public String getFrom() {
        String s;
        System.out.println("Start method getFrom");
        s = this.sendable.getFrom();
        System.out.println("End method getFrom");
        return s;
    }

    @Override
    public String getTo() {
        String s;
        System.out.println("Start method getTo");
        s = this.sendable.getTo();
        System.out.println("End method getTo");
        return s;
    }
}

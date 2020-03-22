package mailService.mail;

public class TimeIt implements Sendable{
    private Sendable sendable;

    public TimeIt(Sendable sendable) {
        this.sendable = sendable;
    }

    @Override
    public String getFrom() {
        String s;
        long startTime = System.nanoTime();
        s = this.sendable.getFrom();
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Execution time of getFrom is " + elapsedTime);
        return s;
    }

    @Override
    public String getTo() {
        String s;
        long startTime = System.nanoTime();
        s = this.sendable.getTo();
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Execution time of getTo is " + elapsedTime);
        return s;
    }
}

//package creational;

// Product interface
interface Notification {
    void send(String message);
}

class SmsNotification implements Notification {
    public void send(String message) { System.out.println("SMS sent: " + message); }
}
class EmailNotification implements Notification {
    public void send(String message) { System.out.println("Email sent: " + message); }
}

// Factory
class NotificationFactory {
    public static Notification create(String type) {
        if ("sms".equalsIgnoreCase(type)) return new SmsNotification();
        if ("email".equalsIgnoreCase(type)) return new EmailNotification();
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.create("sms");
        Notification n2 = NotificationFactory.create("email");
        n1.send("Hello via SMS");
        n2.send("Hello via Email");
    }
}

//package behavioural;

import java.util.ArrayList;
import java.util.List;

// Subject
class NewsAgency {
    private final List<NewsListener> listeners = new ArrayList<>();
    private String news;

    public void addListener(NewsListener l) { listeners.add(l); }
    public void removeListener(NewsListener l) { listeners.remove(l); }
    public void setNews(String news) {
        this.news = news;
        notifyAllListeners();
    }
    private void notifyAllListeners() {
        for (NewsListener l : listeners) l.update(news);
    }
}

// Observer interface
interface NewsListener {
    void update(String news);
}

// Concrete observer
class PhoneDisplay implements NewsListener {
    private final String name;
    public PhoneDisplay(String name) { this.name = name; }
    @Override public void update(String news) {
        System.out.println("[" + name + " display] Breaking: " + news);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        PhoneDisplay alice = new PhoneDisplay("Alice");
        PhoneDisplay bob = new PhoneDisplay("Bob");
        agency.addListener(alice);
        agency.addListener(bob);

        agency.setNews("Mars rover transmitted a selfie!");
        agency.removeListener(bob);
        agency.setNews("Solar storm expected tonight.");
    }
}

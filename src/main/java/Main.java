import event.Event;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("login", "asdf");
//        data.put("alert", "asdf");
//        data.put("logout", "asdf");
//        data.put("transaction", "asdf");

        Monitor monitor = new Monitor(data);
        Event event = monitor.identifyEvent();
        System.out.println(event.getName());
    }
}

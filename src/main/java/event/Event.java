package event;

import java.util.Map;

public class Event {
    Map<String, String> data;

    public Event(Map<String, String> data){
        this.data = data;
    }

    public String getName(){
        return "Event class";
    }

    public boolean is_accept_condition(){
        return false;
    }
}

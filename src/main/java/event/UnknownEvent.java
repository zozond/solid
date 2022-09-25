package event;

import java.util.Map;

public class UnknownEvent extends Event {
    public UnknownEvent(Map<String, String> data) {
        super(data);
    }

    @Override
    public boolean is_accept_condition() {
        return false;
    }

    @Override
    public String getName() {
        return "UnknownEvent class";
    }
}

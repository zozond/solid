package event;

import java.util.Map;

public class LogoutEvent extends Event {
    public LogoutEvent(Map<String, String> data) {
        super(data);
    }

    @Override
    public boolean is_accept_condition() {
        return this.data.get("logout") != null;
    }

    @Override
    public String getName() {
        return "LogoutEvent class";
    }
}

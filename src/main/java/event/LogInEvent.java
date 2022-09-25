package event;

import java.util.Map;

public class LogInEvent extends Event {
    public LogInEvent(Map<String, String> data) {
        super(data);
    }

    @Override
    public boolean is_accept_condition() {
        return this.data.get("login") != null;
    }

    @Override
    public String getName() {
        return "LogInEvent class";
    }
}

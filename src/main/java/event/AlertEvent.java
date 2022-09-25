package event;

import java.util.Map;

public class AlertEvent extends Event{
    public AlertEvent(Map<String, String> data) {
        super(data);
    }

    @Override
    public String getName() {
        return "AlertEvent";
    }

    @Override
    public boolean is_accept_condition() {
        if(this.data.getOrDefault("alert", "").equals("")){
            return false;
        }else{
            return true;
        }
    }
}

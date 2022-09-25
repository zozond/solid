package event;

import java.util.Map;

public class TransactionEvent extends Event {

    public TransactionEvent(Map<String, String> data) {
        super(data);
    }

    @Override
    public boolean is_accept_condition() {
        return this.data.get("transaction") != null;
    }

    @Override
    public String getName() {
        return "TransactionEvent class";
    }

}

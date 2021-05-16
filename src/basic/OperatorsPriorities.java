package basic;

import java.util.HashMap;
import java.util.Map;


// Класс, хранящий приоритеты операций.

class OperatorsPriorities implements AbstractOperatorsPriorities {

    private Map<String, Integer> map;

    OperatorsPriorities(HashMap<String, Integer> map) {
        this.map = map;
    }

    OperatorsPriorities() {
        map = new HashMap<>();
    }

    @Override
    public Integer getPriority(String operator) {
        return map.get(operator);
    }

    @Override
    public void addOperator(String operator, int priority) {
        map.put(operator, priority);
    }

    @Override
    public void deleteOperator(String operator) {
        map.remove(operator);
    }
}

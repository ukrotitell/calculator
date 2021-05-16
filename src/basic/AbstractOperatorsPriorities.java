package basic;

public interface AbstractOperatorsPriorities {

    Integer getPriority(String operator);

    void addOperator(String operator, int priority);

    void deleteOperator(String operator);
}

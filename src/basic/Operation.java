package basic;


import java.util.EmptyStackException;

public class Operation {


    public String getResult(String expression) {
        if (expression.equals("")) {
            return "No math expression specified!";
        }

        AbstractOperatorsPriorities priorities = new OperatorsPriorities();
        priorities.addOperator("+", 1);
        priorities.addOperator("-", 1);
        priorities.addOperator("*", 2);
        priorities.addOperator("/", 2);

        AbstractStringIterator iterator = new StringIterator(expression);

        Calculator calculator = new Calculator(priorities, iterator);
        Double result;
        try {
            result = calculator.getResult();

        } catch (NullPointerException | EmptyStackException e) {
            return "Incorrect math expression";
        }

        return String.format("%.2f", result);
    }
}

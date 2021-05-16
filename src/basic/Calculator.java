package basic;

import java.util.EmptyStackException;
import java.util.Stack;


class Calculator {

    private AbstractOperatorsPriorities priorities;


    private AbstractStringIterator iterator;


     // Стек для хранения операндов.

    private Stack<Double> numbers;


     // Стек для хранения операторов.

    private Stack<String> operators;


    Calculator(AbstractOperatorsPriorities priorities, AbstractStringIterator iterator) {
        this.priorities = priorities;
        this.iterator = iterator;
        numbers = new Stack<>();
        operators = new Stack<>();
    }


    Double getResult() throws NullPointerException, EmptyStackException {
        while(iterator.hasNext()) {
            String element = iterator.next();

            try {
                double number = Double.parseDouble(element);
                numbers.push(number);
            } catch(NumberFormatException e) {
                if(element.equals("(")) {
                    operators.push(element);
                } else if(element.equals(")")) {
                    while(!operators.peek().equals("("))
                        calculate();
                    operators.pop();
                } else {
                    if(operators.empty()) {
                        operators.push(element);
                    } else {
                        Integer priority = priorities.getPriority(element);

                        while(!operators.empty() && !operators.peek().equals("(") && !operators.peek().equals(")") &&
                                priority <= priorities.getPriority(operators.peek())) {
                            calculate();
                        }

                        operators.push(element);
                    }
                }
            }
        }

        while(!operators.empty()) {
            calculate();
        }

        return numbers.pop();
    }


//      Производит операцию, ассоциированную с первым оператором из стека операторов,
//      над двумя первыми операндами из стека операндов.
//
//      Использованные операнды и опертор удаляются из соответствующих стеков,
//      а результат операции помещается в стек операндов.

    private void calculate() throws EmptyStackException {
        String operator = operators.pop();
        Double n2 = numbers.pop();
        Double n1 = numbers.pop();
        Double result = null;

        switch(operator) {
            case "+":
                result =  n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
        }

        numbers.push(result);
    }
}

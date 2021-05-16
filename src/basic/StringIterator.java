package basic;


  //Итератор для строки, содержащей математическое выражение.

class StringIterator implements AbstractStringIterator {

    private String string;


    private int currentIndex;


    StringIterator(String string) {
        this.string = string.replace(" ", "");
        currentIndex = 0;
    }


    @Override
    public boolean hasNext() {
        return  string != null &&
                !string.isEmpty() &&
                currentIndex < string.length();
    }


    @Override
    public String next() {
        StringBuilder operand = new StringBuilder();
        char element = string.charAt(currentIndex);

        while(Character.isDigit(element) || element == '.' || (currentIndex == 0 && element == '-') ||
                (currentIndex > 0 && string.charAt(currentIndex - 1) == '(' && element == '-')) {
            operand.append(element);
            currentIndex++;

            if(currentIndex == string.length())
                return operand.toString();

            element = string.charAt(currentIndex);
        }

        if(operand.length() != 0)
            return operand.toString();

        currentIndex++;
        return Character.toString(element);
    }
}

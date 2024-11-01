package stos;

class Rpn {
    public Stack stack =  new Stack();
    private String[] elements;
    private boolean isCorrect = true;


    public Rpn(String[] elements) {
        this.elements = elements;
    }
  

    public void setIsCorrectToFalse() {
        isCorrect = false;
    }


    public boolean getIsCorrect() {
        return isCorrect;
    }


    public void calculate(String element, int a, int b) {
        
        if (element.equals("+")) {
            stack.checkAndPush(b + a);
        } else if (element.equals("-")) {
            stack.checkAndPush(b - a);
        } else if (element.equals("*")) {
            stack.checkAndPush(b * a);
        } 
    } 

    public void result() {
        if (getIsCorrect() && stack.getTopOfStack() == 0) {
            System.out.println("Wynik: " + stack.peek());
        } else {
            throw new RuntimeException("Błąd w wyrażeniu");
        }
    }


    public void stackHandling() {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals("+") || this.elements[i].equals("-") || this.elements[i].equals("*")) {
                if (stack.isNotEmpty()) {
                    int a = stack.pop();
                    if (stack.isNotEmpty()) {
                        int b = stack.pop();
                        calculate(this.elements[i], a, b);
                    } else {
                        setIsCorrectToFalse();
                        throw new RuntimeException("Za mało liczb na stosie - błędne wyrażenie");
                    }
                } else {
                    setIsCorrectToFalse();
                    throw new RuntimeException("Za mało liczb na stosie - błędne wyrażenie");
                 }    

            } else {
                try {
                    int number = Integer.parseInt(this.elements[i]);
                    stack.checkAndPush(number);
                } catch (NumberFormatException e) {
                    setIsCorrectToFalse();
                    throw new RuntimeException("Nieprawidłowa wartość wyrażenia");
                }
            }
        }
        result();
    }
}
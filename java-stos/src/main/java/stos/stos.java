package stos;

class Stack{
    private int baseSize = 10;
    private int[] stackArray = new int[baseSize];
	private int topOfStack = -1;

    public int getStackArray() {
		return stackArray.length;
	}

    public int getTopOfStack() {
        return topOfStack;
    }

    public int getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(int baseSize) {
        this.baseSize = baseSize;
    }

  
    public void setTopOfStack(int topOfStack) {
        this.topOfStack = topOfStack;
    }

    public boolean isNotFull(){
        if(getTopOfStack() == getStackArray() - 1 ){
           return false;
        }
        else {
            return true;
        }      
    }

    public void push(int value){
            stackArray[++topOfStack] = value;
    }


    public boolean isNotEmpty(){
        if(topOfStack < 0){
            throw new RuntimeException("Stos pusty");
        }
        else {
            return true;
        }
    }

    public int pop() {
        int value = stackArray[topOfStack];
        stackArray[topOfStack--] = 0;
        return value;		
	}
    

    public int peek(){
        return stackArray[topOfStack];
    }

    public void resize() {
        int arraySize = getStackArray();
        int newSize = arraySize + getBaseSize();
        int[] newStack = new int[newSize];
        for (int i = 0; i < arraySize; i++) {
            newStack[i] = stackArray[i];
        }
        stackArray = newStack;
    }

    public void checkAndPush(int number) {
        try {
            if (isNotFull()) {
                push(number);
            } else {
                resize();
                push(number);
            }
        } catch (Exception e) {
            throw new RuntimeException("Błąd stosu");
        }
    }    

}
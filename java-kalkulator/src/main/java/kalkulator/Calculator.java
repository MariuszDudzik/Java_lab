package kalkulator;

public class Calculator {
	private double state = 0;
	private double memory = 0;
	private boolean findError = false;

	public boolean isError() {
        return this.findError; 
    }

    public void clearError() {
        this.findError = false;
    }

	public void setError() {
		this.findError = true;
	}

	public double getState() {
		return this.state;
	}

	public void setState(double state) {
		this.state = state;
	}

	public void add(double value){
		if (isError()) {
			throw new RuntimeException("Błąd operacji stan błędu");
		}
		this.state += value;
		if (Double.isInfinite(this.state)) {
			setError();
			throw new RuntimeException("Przekroczono zakres po dodaniu.");
		}
	}
	

	public void mult(double value){
		if (isError()) {
			throw new RuntimeException("Błąd operacji stan błędu");
		}
		this.state *= value;
		if (Double.isInfinite(this.state)) {
			setError();
			throw new RuntimeException("Przekroczono zakres po mnożeniu.");
		}
	}

	public void div(double value){
		if (isError()) {
			throw new RuntimeException("Błąd operacji stan błędu");
		}
		if (value == 0) {
			setError();
			throw new RuntimeException("Nie można podzielić przez zero");
		}
		this.state /= value;
	}

	public void pow(double value){
		if (isError()) {
			throw new RuntimeException("Błąd operacji stan błędu");
		}
		this.state = Math.pow(this.state, value);
		if (Double.isInfinite(this.state)) {
			setError();
			throw new RuntimeException("Przekroczono zakres po potęgowaniu.");
		}
	}

	public void setMemory(){
		this.memory = this.state;
	}

	public double getMemory(){
		return this.memory;
	}

	public void clearMemory(){
		this.memory = 0;
	}

	public void isdigit(String value){
		if (value == null) {
			setError();
			throw new RuntimeException("Wprowadzono niepoprawną wartość");
		}

		try {
			Double.parseDouble(value);
		} 
		catch(NumberFormatException e) {
			setError();
			throw new RuntimeException("Wprowadzono niepoprawną wartość");
		}
	}
}

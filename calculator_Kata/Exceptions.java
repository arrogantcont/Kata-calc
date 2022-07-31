package calculator_Kata;

public class Exceptions extends Exception {
    public Exceptions() {
    }
    
    public Exceptions(String message){
        this();
        System.out.println(message);
    }
}

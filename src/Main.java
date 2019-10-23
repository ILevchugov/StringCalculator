
public class Main {
    public static void main (String[] args) throws OperationException{
        Postfix postfix = new Postfix();
        Calculator calculator = new Calculator();
        String str1 = "5*(6+1)/7-5";
        System.out.println(postfix.toPostfix(str1));
        System.out.println(calculator.calculate(postfix.toPostfix(str1)));
    }
}

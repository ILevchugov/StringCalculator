import java.util.Stack;
import static java.lang.Character.isDigit;

public class Calculator {

    public String calculate(String postfixExpression){
        String [] symbols = postfixExpression.split(" ");
        Stack <String> stack = new Stack<>();
        for (int i = 0; i < symbols.length; i++){
            if (isNumber(symbols[i])){
                stack.push(symbols[i]);
            } else{
                stack.push(String.valueOf(count(stack, symbols[i])));
            }

        }
        return stack.pop();
    }
    private boolean isNumber(String str){
        if (str == null || str.length() == 0) return false;
        int i = 0;
        if (str.charAt(0)=='-'){
            if (str.length()==1) return false;
            i=1;
        }
        while (i<str.length()){
            if (!isDigit(str.charAt(i))) return false;
            i++;
        }
        return true;
    }
    private double count(Stack <String> operands, String operations ){
        switch (operations){
            case "*" : return Double.parseDouble(operands.pop()) * Double.parseDouble(operands.pop());
            case "/" :
                double x = Double.parseDouble(operands.pop());
                double y = Double.parseDouble(operands.pop());
                return y/x;

            case "+" : return Double.parseDouble(operands.pop()) + Double.parseDouble(operands.pop());
            case "-" :
                 x = Double.parseDouble(operands.pop());
                 y = Double.parseDouble(operands.pop());
                return y-x;
        }
        return 0;
    }
}
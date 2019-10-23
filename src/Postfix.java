import java.util.Stack;
import static java.lang.Character.isDigit;

public class Postfix {
    public String toPostfix(String infix) throws OperationException{
        StringBuilder postfixBuild = new StringBuilder();
        Stack<Character> bracket = new Stack<>();
        for (int i = 0; i < infix.length(); i++){
            if (isDigit(infix.charAt(i))){
                while (isDigit(infix.charAt(i))|| infix.charAt(i)=='.') {
                    postfixBuild.append(infix.charAt(i));
                    i++;
                    if (i == infix.length()) break;
                }
                postfixBuild.append(" ");
                i--;
            } else if (infix.charAt(i)=='(') bracket.push(infix.charAt(i));
                    else if (infix.charAt(i) == ')'){
                        while (bracket.peek()!='('){
                            postfixBuild.append(bracket.pop())
                                        .append(" ");
                        }
                        bracket.pop();
            } else {
                        while (!bracket.empty() && priorityOf(infix.charAt(i))<=priorityOf(bracket.peek())){
                            postfixBuild.append(bracket.pop())
                                        .append(" ");
                        }
                        bracket.push(infix.charAt(i));
            }

        }
        while (!bracket.empty()){
            postfixBuild.append(bracket.pop())
                        .append(" ");
        }
        return postfixBuild.toString();
    }



    private int priorityOf(char operation) throws OperationException {
        switch (operation){
            case '*' : return 5;
            case '/' : return 5;
            case '+' : return 4;
            case '-' : return 4;
            case '=' : return 3;
            case ')' : return 2;
            case '(' : return 1;
            default: throw new OperationException("Wrong operation", operation);
        }

    }
}

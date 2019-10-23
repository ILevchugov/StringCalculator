public class OperationException extends Exception{
    private char operation;
    public OperationException(String message, char operation ){
        super(message);
        this.operation = operation;
    }
}

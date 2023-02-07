public class NoDebtException extends Exception {
    public NoDebtException() {
        super("The customer has no debt");
    }
}
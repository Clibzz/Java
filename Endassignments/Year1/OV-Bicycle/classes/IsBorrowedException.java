public class IsBorrowedException extends Exception {
    public IsBorrowedException() {
        super("The bicycle is currently borrowed");
    }
}
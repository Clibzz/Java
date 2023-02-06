public class IsNotBorrowedException extends Exception {
    public IsNotBorrowedException() {
        super("The bicycle is currently not borrowed");
    }
}

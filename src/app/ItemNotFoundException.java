package app;

/**
 * A {@link ItemNotFoundException} is thrown at runtime when a data item is searched for but not found.
 */
public class ItemNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ItemNotFoundException() {
    super();
  }

  public ItemNotFoundException(String message) {
    super(message);
  }
}

package kata.supermarket.enums;

/**
 * The Enum DiscountTypeEnum.
 */
public enum DiscountTypeEnum {

  /** The DS 2 for 1. */
  DS2For1("Buy one get one free"),
  /** The DS 3 for 2. */
  DS3For2("Buy three get one free");

  /** The description. */
  private String description;

  /**
   * Instantiates a new discount type enum.
   *
   * @param description the description
   */
  private DiscountTypeEnum(String description) {
    this.description = description;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}

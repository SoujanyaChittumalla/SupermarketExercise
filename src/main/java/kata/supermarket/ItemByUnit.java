package kata.supermarket;

import java.math.BigDecimal;

/**
 * Class for items added to basket by units
 */
public class ItemByUnit implements Item<ItemByUnit> {

  /** The product. */
  private final UnitProduct product;

  /** The total units. */
  private int totalUnits;

  /**
   * Instantiates a new item by unit.
   *
   * @param product the product
   * @param totalUnits the total units
   */
  ItemByUnit(final UnitProduct product, int totalUnits) {
    this.product = product;
    this.totalUnits = totalUnits;
  }

  /**
   * Original price.
   *
   * @return the big decimal
   */
  public BigDecimal originalPrice() {
    return product.pricePerUnit().multiply(BigDecimal.valueOf(totalUnits));
  }

  /**
   * Gets the total units.
   *
   * @return the total units
   */
  public int getTotalUnits() {
    return totalUnits;
  }

  /**
   * Gets the product.
   *
   * @return the product
   */
  public Product getProduct() {
    return product;
  }

  /**
   * Gets the.
   *
   * @return the item by unit
   */
  public ItemByUnit get() {
    return this;
  }

}

package kata.supermarket;

import java.math.BigDecimal;
import kata.supermarket.discount.schemes.DiscountScheme;

/**
 * Class for products measured in units
 */
public class UnitProduct extends Product {

  /** The price per unit. */
  private final BigDecimal pricePerUnit;

  /**
   * Instantiates a new unit product.
   *
   * @param pricePerUnit the price per unit
   */
  public UnitProduct(final BigDecimal pricePerUnit) {
    this(pricePerUnit, null);
  }

  /**
   * Instantiates a new unit product.
   *
   * @param pricePerUnit the price per unit
   * @param discountScheme the discount scheme
   */
  public UnitProduct(final BigDecimal pricePerUnit, final DiscountScheme discountScheme) {
    super(discountScheme);
    this.pricePerUnit = pricePerUnit;
  }

  /**
   * Price per unit.
   *
   * @return the big decimal
   */
  public BigDecimal pricePerUnit() {
    return pricePerUnit;
  }

  /**
   * One of.
   *
   * @return the item
   */
  public Item<ItemByUnit> oneOf() {
    return new ItemByUnit(this, 1);
  }

  /**
   * Quantity.
   *
   * @param unitCount the unit count
   * @return the item
   */
  public Item<ItemByUnit> quantity(int unitCount) {
    return new ItemByUnit(this, unitCount);
  }
}

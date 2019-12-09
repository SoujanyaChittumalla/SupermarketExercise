package kata.supermarket;

import java.math.BigDecimal;
import kata.supermarket.discount.schemes.DiscountScheme;

/**
 * Class for products measured by weight
 */
public class WeighedProduct extends Product {

  /** The price per kilo. */
  private final BigDecimal pricePerKilo;

  /**
   * Instantiates a new weighed product.
   *
   * @param pricePerKilo the price per kilo
   */
  public WeighedProduct(final BigDecimal pricePerKilo) {
    this(pricePerKilo, null);
  }

  /**
   * Instantiates a new weighed product.
   *
   * @param pricePerKilo the price per kilo
   * @param discountSchemes the discount schemes
   */
  public WeighedProduct(final BigDecimal pricePerKilo, final DiscountScheme discountSchemes) {
    super(discountSchemes);
    this.pricePerKilo = pricePerKilo;
  }

  /**
   * Price per kilo.
   *
   * @return the big decimal
   */
  BigDecimal pricePerKilo() {
    return pricePerKilo;
  }

  /**
   * Weighing.
   *
   * @param kilos the kilos
   * @return the item
   */
  public Item<ItemByWeight> weighing(final BigDecimal kilos) {
    return new ItemByWeight(this, kilos);
  }
}

package kata.supermarket;

import java.math.BigDecimal;

/**
 * The Class for items added to basket by weight
 */
public class ItemByWeight implements Item<ItemByWeight> {

  /** The product. */
  private final WeighedProduct product;

  /** The weight in kilos. */
  private final BigDecimal weightInKilos;

  /**
   * Instantiates a new item by weight.
   *
   * @param product the product
   * @param weightInKilos the weight in kilos
   */
  ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
    this.product = product;
    this.weightInKilos = weightInKilos;
  }

  /**
   * Original price.
   *
   * @return the big decimal
   */
  public BigDecimal originalPrice() {
    return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
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
   * @return the item by weight
   */
  public ItemByWeight get() {
    return this;
  }
}

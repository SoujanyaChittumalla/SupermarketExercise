package kata.supermarket;

import kata.supermarket.discount.schemes.DiscountScheme;

/**
 * Super class for Product
 * 
 * @author Soujanya.Chittumalla
 *
 */
public class Product {

  /** The discount scheme. */
  private DiscountScheme discountScheme;

  /**
   * 
   * @param discountScheme
   */
  public Product(DiscountScheme discountScheme) {
    this.discountScheme = discountScheme;
  }

  /**
   * Gets the discount scheme.
   *
   * @return the discount scheme
   */
  public DiscountScheme getDiscountScheme() {
    return discountScheme;
  }

}

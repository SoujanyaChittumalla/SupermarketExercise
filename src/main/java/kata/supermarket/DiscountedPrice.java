package kata.supermarket;

import java.math.BigDecimal;
import kata.supermarket.enums.DiscountTypeEnum;

/**
 * Represents discounted price with the type of offer applied
 */
public class DiscountedPrice {

  /** The discount type enum. */
  private DiscountTypeEnum discountTypeEnum;

  /** The dicounted total price. */
  private BigDecimal dicountedTotalPrice;

  /**
   * Instantiates a new discounted price.
   *
   * @param discountTypeEnum the discount type enum
   * @param dicountedTotalPrice the dicounted total price
   */
  public DiscountedPrice(DiscountTypeEnum discountTypeEnum, BigDecimal dicountedTotalPrice) {
    this.discountTypeEnum = discountTypeEnum;
    this.dicountedTotalPrice = dicountedTotalPrice;
  }

  /**
   * Gets the discount type enum.
   *
   * @return the discount type enum
   */
  public DiscountTypeEnum getDiscountTypeEnum() {
    return discountTypeEnum;
  }

  /**
   * Gets the dicounted total price.
   *
   * @return the dicounted total price
   */
  public BigDecimal getDicountedTotalPrice() {
    return dicountedTotalPrice;
  }
}

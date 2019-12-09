package kata.supermarket.price.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import kata.supermarket.Item;
import kata.supermarket.discount.calculator.DiscountCalculator;
import kata.supermarket.discount.calculator.SimpleDiscountCalculator;

/**
 * The Class BasketPriceCalculator.
 */
public class BasketPriceCalculator implements PriceCalculator {

  /** The items. */
  private final List<Item<?>> items;

  /**
   * Instantiates a new basket price calculator.
   *
   * @param items the items
   */
  public BasketPriceCalculator(List<Item<?>> items) {
    this.items = items;
  }

  /**
   * Gets the discount calculator.
   *
   * @return the discount calculator
   */
  // TODO: Spring inject DiscountCalculator
  public DiscountCalculator getDiscountCalculator() {
    return new SimpleDiscountCalculator();
  }

  /**
   * Subtotal of original price of basket items.
   *
   * @return the big decimal
   */
  private BigDecimal subtotal() {
    return items.stream().map(Item::originalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
  }

  /**
   * Aggregated discounted price of all basket items
   *
   * @return the big decimal
   */
  private BigDecimal discounts() {
    return getDiscountCalculator().apply(this.items);
  }

  /**
   * Calculates net basket price after applying discounts.
   *
   * @return the big decimal
   */
  public BigDecimal calculate() {
    return subtotal().subtract(discounts());
  }

}

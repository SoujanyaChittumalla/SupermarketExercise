package kata.supermarket.discount.calculator;

import java.math.BigDecimal;
import java.util.List;
import kata.supermarket.Item;

/**
 * The Interface DiscountCalculator.
 */
public interface DiscountCalculator {

  /**
   * Calculates discounted price for the basket items
   *
   * @param basketItems the basket items
   * @return the big decimal
   */
  public BigDecimal apply(final List<Item<?>> basketItems);
}

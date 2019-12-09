package kata.supermarket.discount.schemes;

import kata.supermarket.DiscountedPrice;
import kata.supermarket.Item;

/**
 * The Interface DiscountScheme.
 */
public interface DiscountScheme {

  /**
   * Calculate discount price for the basket item based on the applied discount scheme
   *
   * @param basketItem the basket item
   * @return the discounted price
   */
  public DiscountedPrice calculateDiscountPrice(Item<?> basketItem);

}

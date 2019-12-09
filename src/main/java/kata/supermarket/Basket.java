package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kata.supermarket.price.calculator.BasketPriceCalculator;
import kata.supermarket.price.calculator.PriceCalculator;

/**
 * The Class Basket.
 */
public class Basket {

  /** The items. */
  private final List<Item<?>> items;

  /**
   * Instantiates a new basket.
   */
  public Basket() {
    this.items = new ArrayList<>();
  }

  /**
   * Adds the.
   *
   * @param item the item
   */
  public void add(final Item<?> item) {
    this.items.add(item);
  }

  /**
   * Items.
   *
   * @return the list
   */
  List<Item<?>> items() {
    return Collections.unmodifiableList(items);
  }

  /**
   * Gets the basket price calculator.
   *
   * @return the basket price calculator
   */
  public PriceCalculator getBasketPriceCalculator() {
    return new BasketPriceCalculator(items());
  }

  /**
   * Total.
   *
   * @return the big decimal
   */
  public BigDecimal total() {
    return getBasketPriceCalculator().calculate();
  }
}

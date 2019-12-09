package kata.supermarket.discount.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kata.supermarket.DiscountedPrice;
import kata.supermarket.Item;
import kata.supermarket.discount.schemes.DiscountScheme;

/**
 * This class calculates and returns aggregated discount by applying the discount scheme for the passed in basket items.
 */
public class SimpleDiscountCalculator implements DiscountCalculator {

  /**
   * {@inheritDoc}
   *
   */
  public BigDecimal apply(final List<Item<?>> basketItems) {
    List<DiscountedPrice> discountedPrices = new ArrayList<DiscountedPrice>();
    basketItems.forEach(it -> {
      DiscountScheme discountScheme = it.getProduct().getDiscountScheme();
      if (discountScheme != null) {
        DiscountedPrice discountedPrice = discountScheme.calculateDiscountPrice(it);
        discountedPrices.add(discountedPrice);
      }
    });

    return discountedPrices.stream().map(DiscountedPrice::getDicountedTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO)
        .setScale(2, RoundingMode.HALF_UP);
  }

}

package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The Class UnitProductTest.
 */
class UnitProductTest {

  /**
   * Item by unit has expected price from product.
   *
   * @param pricePerUnit the price per unit
   * @param unitQty the unit qty
   * @param expectedPrice the expected price
   */
  @ParameterizedTest(name = "Verify UnitProduct returns expected price #{index} with [{arguments}]")
  @MethodSource
  void itemByUnitHasExpectedPriceFromProduct(String pricePerUnit, int unitQty, String expectedPrice) {
    Item<ItemByUnit> itemByUnit = new UnitProduct(new BigDecimal(pricePerUnit)).quantity(unitQty);
    assertEquals(new BigDecimal(expectedPrice), itemByUnit.originalPrice());
  }

  /**
   * Item by unit has expected price from product.
   *
   * @return the stream
   */
  static Stream<Arguments> itemByUnitHasExpectedPriceFromProduct() {
    return Stream.of(Arguments.of("2.49", 1, "2.49"), Arguments.of("2.49", 2, "4.98"), Arguments.of("2.49", -1, "-2.49"),
        Arguments.of("100.00", 0, "0.00"), Arguments.of("99.99", 2, "199.98"));
  }

}

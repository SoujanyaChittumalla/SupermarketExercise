package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The Class WeighedProductTest.
 */
class WeighedProductTest {

  /**
   * Item from weighed product has expected unit price.
   *
   * @param pricePerKilo the price per kilo
   * @param weightInKilos the weight in kilos
   * @param expectedPrice the expected price
   */
  @ParameterizedTest(name = "{0}")
  @MethodSource
  void itemFromWeighedProductHasExpectedUnitPrice(String pricePerKilo, String weightInKilos, String expectedPrice) {
    final WeighedProduct weighedProduct = new WeighedProduct(new BigDecimal(pricePerKilo));
    final Item<ItemByWeight> weighedItem = weighedProduct.weighing(new BigDecimal(weightInKilos));
    assertEquals(new BigDecimal(expectedPrice), weighedItem.originalPrice());
  }

  /**
   * Item from weighed product has expected unit price.
   *
   * @return the stream
   */
  static Stream<Arguments> itemFromWeighedProductHasExpectedUnitPrice() {
    return Stream.of(Arguments.of("100.00", "1.00", "100.00"), Arguments.of("100.00", "0.33333", "33.33"),
        Arguments.of("100.00", "0.33335", "33.34"), Arguments.of("100.00", "0", "0.00"), Arguments.of("99.99", "0.2", "20.00"));
  }

}

package kata.supermarket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductTest {

  /**
   * Item by unit has expected price from product.
   *
   * @param pricePerUnit the price per unit
   * @param unitQty the unit qty
   * @param expectedPrice the expected price
   */
  @ParameterizedTest(name = "Verify Product holding UnitProduct returns expected price #{index} with [{arguments}]")
  @MethodSource
  void itemByUnitHasExpectedPriceFromProduct(String pricePerUnit, int unitQty, String expectedPrice) {
    final Product unitProduct = new UnitProduct(new BigDecimal(pricePerUnit));
    final Item<ItemByUnit> itemByUnit = ((UnitProduct) unitProduct).quantity(unitQty);
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

  /**
   * Item by weighed has expected price from product.
   *
   * @param pricePerKilo the price per kilo
   * @param weightInKilos the weight in kilos
   * @param expectedPrice the expected price
   */
  @ParameterizedTest(name = "Verify Product holding WeighedProduct returns expected price #{index} with [{arguments}]")
  @MethodSource
  void itemByWeighedHasExpectedPriceFromProduct(String pricePerKilo, String weightInKilos, String expectedPrice) {
    final Product weighedProduct = new WeighedProduct(new BigDecimal(pricePerKilo));
    final Item<ItemByWeight> weighedItem = ((WeighedProduct) weighedProduct).weighing(new BigDecimal(weightInKilos));
    assertEquals(new BigDecimal(expectedPrice), weighedItem.originalPrice());
  }

  /**
   * Item by weighed has expected price from product.
   *
   * @return the stream
   */
  static Stream<Arguments> itemByWeighedHasExpectedPriceFromProduct() {
    return Stream.of(Arguments.of("100.00", "1.00", "100.00"), Arguments.of("100.00", "0.33333", "33.33"),
        Arguments.of("100.00", "0.33335", "33.34"), Arguments.of("100.00", "0", "0.00"), Arguments.of("99.99", "0.2", "20.00"));
  }
}

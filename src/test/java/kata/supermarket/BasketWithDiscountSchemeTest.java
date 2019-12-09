package kata.supermarket;

import static kata.supermarket.enums.DiscountTypeEnum.DS2For1;
import static kata.supermarket.enums.DiscountTypeEnum.DS3For2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kata.supermarket.discount.schemes.DiscountScheme;
import kata.supermarket.discount.schemes.MultiUnitDiscountScheme;

/**
 * Test class to verify basket with discount scheme return expected total price
 */
class BasketWithDiscountSchemeTest {

  /** The discount scheme 2 for 1. */
  static DiscountScheme discountScheme2For1 = null;

  /** The discount scheme 3 for 2. */
  static DiscountScheme discountScheme3For2 = null;

  /**
   * Sets the up.
   */
  @BeforeAll
  public static void setUp() {
    discountScheme2For1 = new MultiUnitDiscountScheme(2, 1, DS2For1);
    discountScheme3For2 = new MultiUnitDiscountScheme(3, 2, DS3For2);
  }

  /**
   * Basket provides total value.
   *
   * @param description the description
   * @param expectedTotal the expected total
   * @param items the items
   */
  @DisplayName("basket provides its total value with discount scheme applied when containing...")
  @MethodSource
  @ParameterizedTest(name = "#{index} with [{arguments}]")
  void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item<?>> items) {
    final Basket basket = new Basket();
    items.forEach(basket::add);
    assertEquals(new BigDecimal(expectedTotal), basket.total());
  }

  /**
   * Basket provides total value.
   *
   * @return the stream
   */
  static Stream<Arguments> basketProvidesTotalValue() {
    return Stream.of(itemsWithOneUnitAnd2For1Discount(), itemsWithMultipleUnitsAnd2For1Discount("2.04", 2),
        itemsWithMultipleUnitsAnd2For1Discount("4.08", 3), itemsWithMultipleUnitsAnd2For1Discount("53.04", 51),
        itemsWithOneUnitAnd3For2Discount(), itemsWithMultipleUnitsAnd3For2Discount("4.08", 2),
        itemsWithMultipleUnitsAnd3For2Discount("4.08", 3), itemsWithMultipleUnitsAnd3For2Discount("6.12", 4),
        itemsWithMultipleUnitsAnd3For2Discount("69.36", 51));
  }

  /**
   * Items with one unit and 2 for 1 discount.
   *
   * @return the arguments
   */
  private static Arguments itemsWithOneUnitAnd2For1Discount() {
    return Arguments.of("items with one unit and 2 For 1", "2.04",
        Arrays.asList(packOfDigestivesWith2For1(1, discountScheme2For1), aPintOfMilkWith2For1(1, discountScheme2For1)));
  }

  /**
   * Items with multiple units and 2 for 1 discount.
   *
   * @param expectedPrice the expected price
   * @param qty the qty
   * @return the arguments
   */
  private static Arguments itemsWithMultipleUnitsAnd2For1Discount(String expectedPrice, int qty) {
    return Arguments.of("items with multiple units and 2 For 1", expectedPrice,
        Arrays.asList(packOfDigestivesWith2For1(qty, discountScheme2For1), aPintOfMilkWith2For1(qty, discountScheme2For1)));
  }

  /**
   * Items with one unit and 3 for 2 discount.
   *
   * @return the arguments
   */
  private static Arguments itemsWithOneUnitAnd3For2Discount() {
    return Arguments.of("items with one unit and 3 For 2", "2.04",
        Arrays.asList(packOfDigestivesWith2For1(1, discountScheme3For2), aPintOfMilkWith2For1(1, discountScheme3For2)));
  }

  /**
   * Items with multiple units and 3 for 2 discount.
   *
   * @param expectedPrice the expected price
   * @param qty the qty
   * @return the arguments
   */
  private static Arguments itemsWithMultipleUnitsAnd3For2Discount(String expectedPrice, int qty) {
    return Arguments.of("items with multiple units and 3 For 2", expectedPrice,
        Arrays.asList(packOfDigestivesWith2For1(qty, discountScheme3For2), aPintOfMilkWith2For1(qty, discountScheme3For2)));
  }

  /**
   * A pint of milk with 2 for 1.
   *
   * @param qty the qty
   * @param discountScheme the discount scheme
   * @return the item
   */
  private static Item<ItemByUnit> aPintOfMilkWith2For1(int qty, DiscountScheme discountScheme) {
    return new UnitProduct(new BigDecimal("0.49"), discountScheme).quantity(qty);
  }

  /**
   * Pack of digestives with 2 for 1.
   *
   * @param qty the qty
   * @param discountScheme the discount scheme
   * @return the item
   */
  private static Item<ItemByUnit> packOfDigestivesWith2For1(int qty, DiscountScheme discountScheme) {
    return new UnitProduct(new BigDecimal("1.55"), discountScheme).quantity(qty);
  }


}

package kata.supermarket.discount.schemes;

import static kata.supermarket.enums.DiscountTypeEnum.DS2For1;
import static kata.supermarket.enums.DiscountTypeEnum.DS3For2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import kata.supermarket.DiscountedPrice;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.UnitProduct;

/**
 * Verify multi-unit discount schemes returns expected discounted price for a basket item
 */
public class MultiUnitDiscountSchemeTest {

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
   * Verify 2 for 1 discount scheme discounted price.
   *
   * @param description the description
   * @param expectedDiscountedTotal the expected discounted total
   * @param basketItem the basket item
   */
  @DisplayName("calculates 2For1 discounted price for basket item ")
  @MethodSource
  @ParameterizedTest(name = "#{index} with [{arguments}]")
  public void verify2For1DiscountSchemeDiscountedPrice(String description, String expectedDiscountedTotal, Item<?> basketItem) {
    DiscountedPrice actualDiscountedPrice = discountScheme2For1.calculateDiscountPrice(basketItem);
    assertEquals(new BigDecimal(expectedDiscountedTotal), actualDiscountedPrice.getDicountedTotalPrice());
    assertEquals(DS2For1, actualDiscountedPrice.getDiscountTypeEnum());
  }


  /**
   * Verify 2 for 1 discount scheme discounted price.
   *
   * @return the stream
   */
  static Stream<Arguments> verify2For1DiscountSchemeDiscountedPrice() {
    return Stream.of(itemWithOneUnitAnd2For1Discount(), itemWithMultipleUnitsAnd2For1Discount("1.55", 2),
        itemWithMultipleUnitsAnd2For1Discount("1.55", 3), itemWithMultipleUnitsAnd2For1Discount("38.75", 51));
  }

  /**
   * Verify 3 for 2 discount scheme discounted price.
   *
   * @param description the description
   * @param expectedDiscountedTotal the expected discounted total
   * @param basketItem the basket item
   */
  @DisplayName("calculates 3For2 discounted price for basket item ")
  @MethodSource
  @ParameterizedTest(name = "#{index} with [{arguments}]")
  public void verify3For2DiscountSchemeDiscountedPrice(String description, String expectedDiscountedTotal, Item<?> basketItem) {
    DiscountedPrice actualDiscountedPrice = discountScheme3For2.calculateDiscountPrice(basketItem);
    assertEquals(new BigDecimal(expectedDiscountedTotal), actualDiscountedPrice.getDicountedTotalPrice());
    assertEquals(DS3For2, actualDiscountedPrice.getDiscountTypeEnum());
  }


  /**
   * Verify 3 for 2 discount scheme discounted price.
   *
   * @return the stream
   */
  static Stream<Arguments> verify3For2DiscountSchemeDiscountedPrice() {
    return Stream.of(itemWithOneUnitAnd3For2Discount(), itemWithMultipleUnitsAnd3For2Discount("0.00", 2),
        itemWithMultipleUnitsAnd3For2Discount("0.49", 3), itemWithMultipleUnitsAnd3For2Discount("0.49", 4),
        itemWithMultipleUnitsAnd3For2Discount("8.33", 51));
  }


  /**
   * Item with one unit and 2 for 1 discount.
   *
   * @return the arguments
   */
  private static Arguments itemWithOneUnitAnd2For1Discount() {
    return Arguments.of("item with one unit and 2 For 1", "0.00", packOfDigestivesWith2For1(1, discountScheme2For1));
  }


  /**
   * Item with multiple units and 2 for 1 discount.
   *
   * @param expectedPrice the expected price
   * @param qty the qty
   * @return the arguments
   */
  private static Arguments itemWithMultipleUnitsAnd2For1Discount(String expectedPrice, int qty) {
    return Arguments.of("item with multiple units and 2 For 1", expectedPrice, packOfDigestivesWith2For1(qty, discountScheme2For1));
  }


  /**
   * Item with one unit and 3 for 2 discount.
   *
   * @return the arguments
   */
  private static Arguments itemWithOneUnitAnd3For2Discount() {
    return Arguments.of("item with one unit and 3 For 2", "0.00", aPintOfMilkWith2For1(1, discountScheme3For2));
  }


  /**
   * Item with multiple units and 3 for 2 discount.
   *
   * @param expectedPrice the expected price
   * @param qty the qty
   * @return the arguments
   */
  private static Arguments itemWithMultipleUnitsAnd3For2Discount(String expectedPrice, int qty) {
    return Arguments.of("item with multiple units and 3 For 2", expectedPrice, aPintOfMilkWith2For1(qty, discountScheme3For2));
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

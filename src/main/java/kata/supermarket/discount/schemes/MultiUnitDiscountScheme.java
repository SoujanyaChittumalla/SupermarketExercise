package kata.supermarket.discount.schemes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kata.supermarket.DiscountedPrice;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.UnitProduct;
import kata.supermarket.enums.DiscountTypeEnum;

/**
 * This discount scheme is applied on product added to basket as units. It calculates discounted units based on the discount scheme applied
 * and returns discounted price for the basket item.
 */
public class MultiUnitDiscountScheme implements DiscountScheme {

  /** The bundle units. */
  private int bundleUnits;

  /** The paid units. */
  private int paidUnits;

  /** The discount type enum. */
  private DiscountTypeEnum discountTypeEnum;

  /**
   * Instantiates a new multi unit discount scheme.
   *
   * @param bundleUnits the bundle units
   * @param paidUnits the paid units
   * @param discountTypeEnum the discount type enum
   */
  public MultiUnitDiscountScheme(int bundleUnits, int paidUnits, DiscountTypeEnum discountTypeEnum) {
    this.bundleUnits = bundleUnits;
    this.paidUnits = paidUnits;
    this.discountTypeEnum = discountTypeEnum;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public DiscountedPrice calculateDiscountPrice(Item<?> basketItem) {

    ItemByUnit itemByUnit = (ItemByUnit) basketItem.get();
    BigDecimal discountedPrice = new BigDecimal(0.00);
    if (itemByUnit.getTotalUnits() >= bundleUnits) {

      int itemGroups = itemByUnit.getTotalUnits() / bundleUnits;
      int totalPaidUnitsAfterDiscount = (itemGroups * paidUnits) + (itemByUnit.getTotalUnits() % bundleUnits);
      int totalDiscountedUnits = itemByUnit.getTotalUnits() - totalPaidUnitsAfterDiscount;
      UnitProduct unitProduct = (UnitProduct) itemByUnit.getProduct();
      discountedPrice = BigDecimal.valueOf(totalDiscountedUnits).multiply(unitProduct.pricePerUnit());
    }
    return new DiscountedPrice(discountTypeEnum, discountedPrice.setScale(2, RoundingMode.HALF_UP));
  }

}

package kata.supermarket;

import java.math.BigDecimal;

public interface Item<T> {
  T get();

  BigDecimal originalPrice();

  Product getProduct();
}

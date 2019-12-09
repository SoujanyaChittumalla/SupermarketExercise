# Notes

Solution includes implementation for below discount schemes:
- Buy one, get one free
- Buy three items for the price of two

## Solution summary:
- __Item__ modified as generic interface to accept parameterized types __ItemByUnit__ or __ItemByWeight__  
- __ItemByUnit__ modified to include number of units 
- __Product__ modified as __UnitProduct__. Product is updated as the base class for UnitProduct and WeighedProduct
- New __Product__ updated to hold __DiscountScheme__
- Created __DiscountScheme__ interface which provides method to calculate discounted price for supplied basket items. Different implementations of discount schemes can be introduced based on the offers specific to product unit or by weight.
- Created __MultiUnitDiscountScheme__ an implementation of __DiscountScheme__ to provide discounted price for a basket item by unit based promotional offers like 2for1, 3for2 etc. Method __calculateDiscountPrice__ accepts a basket item and determines number of  discounted units out of the total units of basket item based on the offer type(2for1, 3for2 etc). It returns total price for discounted units.
- Created __DiscountCalculator__ interface to provide different implementations of calculating aggregated discounted price for all basket items. A __SimpleDiscountCalculator__ is implemented to apply DiscountScheme for all the basket items and aggregated the discounted price for all basket items.
- Moved basket price calculation logic from Basket to __BasketPriceCalculator__ which is an implementation of PriceCalculator to provide calculated net basket price after reducing discounted price. Instantiates DiscountCalculator(this should have been spring injected) and hand overs discount calculation responsibility



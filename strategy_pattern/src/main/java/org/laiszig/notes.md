Many algorithms can be decomposed into higher and lower level parts.

* Making tea can be decomposed into:
  * The process of making a hot beverage (boil water, pour into cup); and
  * Tea-specific things(put teabag into water)
* The high-level algorithm can then be reused for making coffee or hot chocolate
  * Supported by beverage-specific strategies


Strategy: enables the exact behavior of a system to be selected either at run-time
(dynamic) or compile-time (static)

Also known as _policy_ (esp. in the C++ world).


SUMMARY

- Define algorithm at a high level
- Define the interface you expect each strategy to follow
- Provide for either dynamic or static composition of strategy in the overal algorithm
The Factory Method pattern suggests that you replace direct object construction calls
(using the new operator) with calls to a special _factory_ method.

The objects are still created via the new operator, but it's being
called from within the factory method. 


How to implement:

1. Make all products follow the same interface. The interface should
declare methods that make sense in every product.
2. Add an empty factory method inside the creator class. The return type 
of the method should match the common product interface.
3. In the creator's code find all references to product constructors. 
One by one replace them with calls to the factory method, while extracting the product 
creation code into the factory method.
4. Now, create a set of creator subclasses for each type of product listed in the
factory method. Override the method in the subclasses and extract the appropriate
bits of construction code from the base method.
5. If there are too many product types, and it doesn't make sense to create subclasses for all of them,
you can reuse the control parameter from the base class in the subclasses.
/**
 * Java is pass by value by default.
 * 
 * Pass by Value : The copy value is directly passed as the argument of the
 * method any changes made to that argument value in that method does'nt change
 * the original value.
 * 
 * Pass by Reference : The copy of refernce of the value (the address of the
 * value) is directly passed into the method and the changes made to that
 * variable will be reflected in the original value. Since the original variable
 * and the passed variable is actually pointing to the address of the variable
 * so the changes made is reflected in original as well.
 * 
 * For Primitive types -> In java the original value is not affected as directly
 * the value is passed.
 * For non-primitive types (Objects) -> The address of the object is passed as
 * value into the method so any change will be reflected in the original as they
 * point to same memory location.
 * 
 * Java always passes a copy of the value:
 * 
 * For primitives, it passes the value directly.
 * For objects, it passes the value of the reference (memory address) pointing
 * to the object.
 * When you change the state of the object, you're working with the same object
 * in memory. But when you reassign the reference, you're only changing the copy
 * of the reference, leaving the original untouched.
 */

class Example {

    String name;

    Example(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Example obj = new Example("Kartik"); // assigned the new value Kartik
        int k = 10;
        modifyObj(obj, k); // passing obj's address as value and passing k's value
        System.out.println(obj.name); // output will be "Modified"
    }

    public static void modifyObj(Example obj, int a) {
        a = 50; // primitive types new memory will be allocated the original will not be
                // affected.
        obj.name = "Modified"; // this will reflect in the original as well (address of the object is passed as
                               // value);
        obj = new Example("new value"); // this will not affect orginal value and as this new create new reference

    }
}
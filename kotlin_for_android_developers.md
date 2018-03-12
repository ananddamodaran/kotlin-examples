- Kotlin for Android Studio
- Install Android Studio
- Install Kotlin Plugin
- Anko
- Extension Functions
- Classes and Functions
	* Classes have unique default constructors
	* declare init block
	* Class inheritance
		- By default , class always extends from Any
		- Classes are closed by default(final)
- Functions
	* Functions in Kotlin always return a value
 	* If we don’t specify, it will return Unit which is similar to void.
 	* default value in parameters which prevents the need of function overloading
	* named arguments can be used to write the name of the argument preceding the value to specify which one you want.
- String templates - ${user.name}
- Property naming
- New keyword is not required to instantiate an object
- In Kotlin everything is an object.
- Basic Types: Integers, Floats, Double, Characters
- Variables can be defined as mutable(var) or immutable (val)
- No need to specify object types, they will be inferred from the value.
- Properties are equivalent to fields in Java but more powerful
- default getters() and setters()
- Custom getter or setter - *field* - a reserved word required when property needs to access its own value 
- **Anko and Extenstion Functions**
    * Anko main purpose is the generation of UI layouts by using code instead of XML
    * Anko uses extension functions
    * Extension function is a function that adds a new behaviour to a class, even if we don't have access to the source code of that class.
- Data Classes
    * used to avoid boilerplate we need in Java to create POJO
    * extra functions - equals() , hashCode() , copy()
    * declaration destructuring
- Parsing Data
    *  


//variables can be declared outside the main() method at the beggining of our program -> top level variables
val myTopLevelConstant = 359

//fun is used to declare functions
fun kotlinIntro() {
    println("Hello world")

    //variables -> val for read-only, recommended for default declarations
    val maxSpeed = 180
    val age = 30
    age = 20 //'val' cannot be reassigned

    //variables -> var for mutable
    var customers = 10
    customers = 8
    println(customers)

    //string templates
    println("there are $customers customers")
    println("there are ${customers +1 } customers")

    //basic types-----------------------------------------------------------------------
    val year: Int = 2020    //Integers: Byte, Short, Int, Long
    val score: UInt = 100u  //Unsigned integerts: UByte, UShort, UInt, ULong
    val currentTemp: Float = 24.5f  //floating-point float
    val price: Double = 19.99       //floating-point double
    val isEnabled: Boolean = false  //boolean
    val separator: Char = ','       //characters
    val message: String = "Hello Kotlin"

    //variable can be declare without initialization
    val d: Int
    //initialization
    d = 3

    //variable explcitly typed and initialized
    val e: String = "Kotlin"

    //not inilialized variable can not be read
    val e: Int
    println(e)  //'d' must be initialized

    //collections------------------------------------------------------------------------

    //List store items in the order they are added and allow for duplicates
    val readOnlyFruitList = listOf("apple", "banana", "citrus")
    println(readOnlyFruitListList)

    //mutable list with explicit type declaration
    val fruits: MutableList<String> = mutableListOf("apple", "banana", "citrus")
    println(fruits)

    //cast mutable list to readonly-list
    val fruitsLocked: List<String> = fruits

    //accessing items
    println("The second fruit is ${readOnlyFruitList[1]}")
    println("Firts fruit is ${readOnlyFruitList.first()}")
    println("Last fruit is ${readOnlyFruitList.last()}")

    println("There are total of ${readOnlyFruitList.count()} fruits")


    val mutableReadonlyList = listOf("one", "two", "three")
    mutableReadonlyList.add("four") //modification is allowed
    mutableReadonlyList = listOf("five", "six") //reassignment is not allowed
    

}




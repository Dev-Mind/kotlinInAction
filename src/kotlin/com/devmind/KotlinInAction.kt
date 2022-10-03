package com.devmind

import java.time.LocalDate

fun kotlinInAction() {












    fun main(args: Array<String>) {
        println("Hello EMSE")
    }



    // fun -> function
    // kotlin avoid boilerplate :
    //                     => no semicolon,
    //                     => as typescript arguments
    //                     => everything is public by default
    //                     => no need to define void type





















    // In Kotlin values are immutable
    val test1 = 23
    // If you want mutable data you have to use
    var test2 = "Test"


    // test1 = 3    // => error test1 is immutable
    test2 = "Test2"

    // As you can see no need to define the type. When Kotlin can guess it





















    val test3: String

    // Kotlin is null proof
    // test3 = null              // => error

    // If a value can be zero, it is up to you to predict it
    val test4: String?
    test4 = null


    // test3 = test4                  // => error
    // test3 = test4!!                  // => error on runtime NPE




















    //you don't need to set the return type
    fun country() = "Morocco"

    println("Hello ${country()}")     // string template  => Hello Morocco

    // You can set default settings
    fun add(one: Int, two: Int = 2) = one + two

    println(add(10))               //  => 12
    println(add(10, 4))        //  => 14





























    // Data class. No need to waste time defining POJOs anymore... Everything we have seen applies:
    //    default immutable and non-nullable properties
    //    default values
    data class User(val name: String,
                    val birthYear: Int,
                    val satisfaction: Int = 5,
                    val hobby: String? = null)


    // No  new to define a new instance
    val user1 = User("Guillaume", 1977)
    val user2 = User("Federer", 1981, hobby = "tennis")

    // No need to generate, getter, setter , equals hashcode
    println("${user1.name} a ${LocalDate.now().year - user1.birthYear} ans")       //  => Guillaume a 41 ans

    // and you have some nice feature to copy a data class and keep immutability ...



















    // function extension is useful when you do not manage a class or a function
    fun User.age() = LocalDate.now().year - this.birthYear

    println("${user1.name} a ${user1.age()} ans")   //  => Guillaume a 45 ans


























    // Higher order functions, a function can be a parameter
    fun wrap(block: () -> Unit){
        println("*****")
        block()
        println("*****")
    }

    wrap {
        println(add(10))
    }













    // It's used a lot in Android. Example with view-bound and mutable object
    data class Text(var value: String = "", var color: String = "#000000")

    val text = Text().apply {
        println(this.toString())           // => Text(value=, color=#000000)

        value = "Value"
        color = "#FF0000"
    }

    println(text.toString())               // => Text(value=Value, color=#FF0000)








    // The other use case is to simplify the management of streams compared to Java
    val users = listOf(user1, user2)


    users.map { it.name }.forEach { println(it) }



















}

fun main(args: Array<String>) {
    kotlinInAction()
}


package com.devmind

import java.time.LocalDate

fun kotlinInAction() {












    fun main(args: Array<String>) {
        println("Hello Devoxx Morocco")
    }

    // fun -> function
    // kotlin évite le boilerplate :
    //                     => point virgule,
    //                     => arguments à la typescript
    //                     => tout est public par défaut
    //                     => pas besoin de définir un type void





















    // En Kotlin les valeurs sont immuables
    val test1 = 23
    // Si vous voulez une donnée mutable vous devez utiliser
    var test2 = "Test"


    // test1 = 3    // => erreur test1 est immutable
    test2 = "Test2"






















    // Comme vous pouvez le voir pas besoin de définir le type. Quand Kotlin peut le deviner
    // vous n'avez pas besoin de le donner
    val test3: String

    // Kotlin est null proof
    // test3 = null              // => erreur

    // Si une valeur peut être nulle c'est à vous de le prévoir
    val test4: String?
    test4 = null


    // test3 = test4                  // => erreur
    // test3 = test4!!                  // => erreur à l'excution NPE




















    // vous n'avez pas besoin de définir le type de retour
    fun country() = "Morocco"

    println("Hello ${country()}")     // string template  => Hello Morocco

    // Vous pouvez définir des paramètres par défaut
    fun add(one: Int, two: Int = 2) = one + two

    println(add(10))               //  => 12
    println(add(10, 4))        //  => 14





























    // Data class. Plus besoin de perdre du temps à définir des POJO... Tout ce qu'on a vu s'applique :
    //    propriétés immutables et non nullables par défaut
    //    valeurs par défaut
    data class User(val name: String,
                    val birthYear: Int,
                    val satisfaction: Int = 5,
                    val hobby: String? = null)


    // Pas de new
    val user1 = User("Guillaume", 1977)
    val user2 = User("Federer", 1981, hobby = "tennis")

    // Pas besoin de génerer, getter, setter , equals hashcode
    println("${user1.name} a ${LocalDate.now().year - user1.birthYear} ans")       //  => Guillaume a 41 ans





















    // Extension de fonction utile quand on ne maitrise pas la fonction
    fun User.age() = LocalDate.now().year - this.birthYear

    println("${user1.name} a ${user1.age()} ans")   //  => Guillaume a 41 ans


























    // Fonctions d'ordre supérieures, une fonction peut être un paramètre
    fun wrap(block: () -> Unit){
        println("*****")
        block()
        println("*****")
    }

    wrap {
        println(add(10))
    }













    // C'est beaucoup utilisé dans Android. Exemple avec un objet lié à la vue et mutable
    data class Text(var value: String = "", var color: String = "#000000")

    val text = Text().apply {
        println(this.toString())           // => Text(value=, color=#000000)

        value = "Value"
        color = "#FF0000"
    }

    println(text.toString())               // => Text(value=Value, color=#FF0000)








    // L'autre cas d'utlisation est de simplifier la gestion des stream par rapport à Java
    val users = listOf(user1, user2)


    users.map { it.name }.forEach { println(it) }



















}

fun main(args: Array<String>) {
    kotlinInAction()
}


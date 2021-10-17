package org.wit.placemark.console.main

import mu.KotlinLogging
import org.wit.placemark.console.models.CollegeModel

private val logger = KotlinLogging.logger {}

var collegeName : String = ""
var collegeAddress : String = ""

var college = CollegeModel()

val colleges = ArrayList<CollegeModel>()

fun main(args: Array<String>){
    logger.info { "Launching UniBase Console App" }
    println("|| WELCOME TO UNIBASE ||")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> addCollege()
            2 -> addCourse()
            3 -> addModule()
            4 -> listColleges()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    logger.info { "Shutting Down Placemark Console App" }
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. Add University/College: ")
    println(" 2. Add a Course: ")
    println(" 3. Add a Module: ")
    println(" 4. List Colleges: ")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun addCollege(){
//    println("You Chose Add College")

    println(" -- Add College -- ")
    println()
    print("Enter College Name : ")
    college.name = readLine()!!
    print("Enter College Eircode: ")
    college.address = readLine()!!
//    println("You entered [ ${college.name} ] for College Name and [ ${college.address} ] for College Eircode")

    if (college.name.isNotEmpty() && college.address.isNotEmpty()) {
        colleges.add(college.copy())
        logger.info("Placemark Added : [ $college ]")
    }
    else
        logger.info("Placemark Not Added")
}

fun updateCollege() {
    println(" -- Update College -- ")
    println()
    print("Enter a new Title for [ " + college.name + " ] : ")
    college.name = readLine()!!
    print("Enter a new Description for [ " + college.address + " ] : ")
    college.address = readLine()!!
    println("You updated [ " + college.name + " ] for title " +
            "and [ " + college.address + " ] for description")
}

fun listColleges() {
    println(" -- List All Colleges -- ")
    println()
//    colleges.forEach { logger.info("${it}") }
    val sortedColleges = colleges.sortedBy { it.name }
    sortedColleges.forEach { logger.info("${it}")}
    for(i in sortedColleges)
        println("College Name: " + i.name + "\nCollege Address: " + i.address + "\n")
}


fun addCourse(){
    println("You Chose Add Course")
}


fun addModule(){
    println("You Chose Add Module")
}
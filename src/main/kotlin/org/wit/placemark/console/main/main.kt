package org.wit.placemark.console.main

import mu.KotlinLogging
import org.wit.placemark.console.models.CollegeModel
import org.wit.placemark.console.models.CourseModel

private val logger = KotlinLogging.logger {}

var collegeName : String = ""
var collegeAddress : String = ""

var college = CollegeModel()
var course = CourseModel()

val colleges = ArrayList<CollegeModel>()
//val courses = ArrayList<CourseModel>()

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

    println(" -- Add College -- " +
            "")
    println()
    print("Enter College Name : ")
    college.name = readLine()!!
    print("Enter College Eircode: ")
    college.address = readLine()!!
//    college.id++
//    println("You entered [ ${college.name} ] for College Name and [ ${college.address} ] for College Eircode")

    if (college.name.isNotEmpty() && college.address.isNotEmpty()) {
        college.id = colleges.size.toLong()
        colleges.add(college.copy())
        logger.info("College Added : [ $college ]")
    }
    else
        logger.info("College Not Added")
}

fun addCourse() {
    println(" -- Add Course -- " + "")
    println()
    listColleges()
    print("Enter College Name : ")
    var clge: Long = readLine()!!.toLong()

    print("Enter Course Name: ")
    course.name = readLine()!!
    print("Enter Course Description: ")
    course.description = readLine()!!
    print("Enter Number of Years: ")
    course.years = readLine()!!.toInt()
    if (course.name.isNotEmpty() && course.description.isNotEmpty()) {
        do{
            print(colleges.get(clge.toInt()))
            colleges.get(clge.toInt()).courses.add(course.copy())
        }while(college.id == clge)
        logger.info("Course Added to ${college.name}: [ ${course.name} ]")
    } else
        logger.info("Course Not Added")
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
        println("College Name: " + i.name + "\nCollege Address: " + i.address + "\nCollege ID: " + i.id + "\n" + i.courses + "\n")
}

fun addModule(){
    println("You Chose Add Module")
}
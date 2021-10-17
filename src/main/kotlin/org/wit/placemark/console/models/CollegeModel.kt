package org.wit.placemark.console.models

data class CollegeModel(
    var id: Long = 0,
    var name: String = "",
    var address: String = ""
)

fun toString(): String {
    val name: String = "";
    val address: String = "";
    val id: Long = 0;
    return "College Name: $name \n" +
            "College Eircode: $address \n" +
            "College ID: $id \n" +
            "\n"
}

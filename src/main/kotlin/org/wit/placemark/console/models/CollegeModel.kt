package org.wit.placemark.console.models

data class CollegeModel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    val courses: ArrayList<CourseModel> = ArrayList<CourseModel>()
//    var course: CourseModel = CourseModel(),
)

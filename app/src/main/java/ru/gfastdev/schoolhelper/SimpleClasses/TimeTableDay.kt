package ru.gfastdev.schoolhelper.SimpleClasses

class TimeTableDay {
    var l : ArrayList<SchoolSubject>

    constructor(vararg x: SchoolSubject){
        l = x.toCollection(ArrayList(x.size))
    }

    constructor() {
        l = ArrayList(0)
    }
}
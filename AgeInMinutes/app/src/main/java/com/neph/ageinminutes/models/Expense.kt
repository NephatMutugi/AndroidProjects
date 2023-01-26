package com.neph.ageinminutes.models

class Expense {
    var id: Int
    var name: String
    var amount: Double
    var date: String

    constructor(id: Int, name: String, amount: Double, date: String) {
        this.id = id
        this.name = name
        this.amount = amount
        this.date = date
    }
}
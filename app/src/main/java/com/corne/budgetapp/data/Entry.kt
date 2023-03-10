package com.corne.budgetapp.data

data class Entry(
    var entryID: String? = null,
    var vatID: String? = null,
    var monthID: String? = null,
    var balID: String? = null,
    var name: String? = null,
    var price: Double? = null
) {
}
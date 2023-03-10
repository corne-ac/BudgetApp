package com.corne.budgetapp.data

import com.google.firebase.database.Exclude

data class Month(
    var monthID: String? = null,
    var month: String? = null,
    var year: Int? = null
) {
}
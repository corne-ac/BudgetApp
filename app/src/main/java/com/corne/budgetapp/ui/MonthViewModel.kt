package com.corne.budgetapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.corne.budgetapp.data.Month
import com.corne.budgetapp.data.NODE_MONTH
import com.google.firebase.database.FirebaseDatabase

class MonthViewModel: ViewModel() {
    private val dbMonths = FirebaseDatabase.getInstance().getReference(NODE_MONTH)

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> get() = _result

    fun addMonth(month: Month) {
        month.monthID = dbMonths.push().key
        dbMonths.child(month.monthID!!).setValue(month).addOnCompleteListener {
            if (it.isSuccessful) {
                _result.value = null //If null, data committed successfully
            } else {
                _result.value = it.exception
            }
        }
    }
}
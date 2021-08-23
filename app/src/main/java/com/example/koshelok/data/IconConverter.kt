package com.example.koshelok.data

import com.example.koshelok.R
import javax.inject.Inject

class IconConverter @Inject constructor() {

    fun convertNumberToDrawableId(number: Int): Int{
        return when(number){
            CAPITALIZATION -> R.drawable.capitalization
            FLY -> R.drawable.fly
            JEWELRY -> R.drawable.jewelry
            PRESENT -> R.drawable.present
            RESTAURANT -> R.drawable.restaurant
            SALARY -> R.drawable.salary
            SUPERMARKET -> R.drawable.supermarket
            else -> R.drawable.salary
        }
    }

    fun convertDrawableIdToNumber(drawableId: Int): Int{
        return when(drawableId){
            R.drawable.capitalization -> CAPITALIZATION
            R.drawable.fly -> FLY
            R.drawable.jewelry -> JEWELRY
            R.drawable.present -> PRESENT
            R.drawable.restaurant -> RESTAURANT
            R.drawable.salary -> SALARY
            R.drawable.supermarket -> SUPERMARKET
            else -> R.drawable.salary
        }
    }

    private companion object{
        const val CAPITALIZATION = 0
        const val FLY = 1
        const val JEWELRY = 2
        const val PRESENT = 3
        const val RESTAURANT = 4
        const val SALARY = 5
        const val SUPERMARKET = 6
    }
}

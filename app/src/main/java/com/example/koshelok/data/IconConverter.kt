package com.example.koshelok.data

import com.example.koshelok.R
import javax.inject.Inject

class IconConverter @Inject constructor() {

    @Suppress("LongMethod", "ComplexMethod")
    fun convertNumberToDrawableId(number: Int): Int {
        return when (number) {
            CAPITALIZATION -> R.drawable.capitalization
            FLY -> R.drawable.fly
            JEWELRY -> R.drawable.jewelry
            PRESENT -> R.drawable.present
            RESTAURANT -> R.drawable.restaurant
            SALARY -> R.drawable.salary
            SUPERMARKET -> R.drawable.supermarket
            BANK -> R.drawable.ic_bank
            CAR -> R.drawable.ic_car
            CLOTHES -> R.drawable.ic_clothes
            COFFEE -> R.drawable.ic_coffee
            COMMUNAL -> R.drawable.ic_communal
            CONSTRUCTION -> R.drawable.ic_construction
            EDUCATION -> R.drawable.ic_education
            ENTERTAIMENTS -> R.drawable.ic_entertainments
            FRIENDS -> R.drawable.ic_friends
            GAMES -> R.drawable.ic_games
            INTERNET -> R.drawable.ic_internet
            MEDICINE -> R.drawable.ic_medicine
            MEDICINES -> R.drawable.ic_medicines
            MOVIE -> R.drawable.ic_movie
            MUSIC -> R.drawable.ic_music
            PETS -> R.drawable.ic_pets
            PHONE -> R.drawable.ic_phone
            REST -> R.drawable.ic_rest
            SAVINGS -> R.drawable.ic_savings
            SPORT -> R.drawable.ic_sport
            TRANSPORT -> R.drawable.ic_transport
            TV -> R.drawable.ic_tv
            WIFI -> R.drawable.ic_wifi
            else -> R.drawable.salary
        }
    }

    @Suppress("LongMethod", "ComplexMethod")
    fun convertDrawableIdToNumber(drawableId: Int): Int {
        return when (drawableId) {
            R.drawable.capitalization -> CAPITALIZATION
            R.drawable.fly -> FLY
            R.drawable.jewelry -> JEWELRY
            R.drawable.present -> PRESENT
            R.drawable.restaurant -> RESTAURANT
            R.drawable.salary -> SALARY
            R.drawable.supermarket -> SUPERMARKET
            R.drawable.ic_wifi -> WIFI
            R.drawable.ic_transport -> TRANSPORT
            R.drawable.ic_tv -> TV
            R.drawable.ic_rent -> RENT
            R.drawable.ic_sport -> SPORT
            R.drawable.ic_savings -> SAVINGS
            R.drawable.ic_rest -> REST
            R.drawable.ic_phone -> PHONE
            R.drawable.ic_medicines -> MEDICINES
            R.drawable.ic_pets -> PETS
            R.drawable.ic_music -> MUSIC
            R.drawable.ic_movie -> MOVIE
            R.drawable.ic_medicine -> MEDICINE
            R.drawable.ic_internet -> INTERNET
            R.drawable.ic_games -> GAMES
            R.drawable.ic_friends -> FRIENDS
            R.drawable.ic_entertainments -> ENTERTAIMENTS
            R.drawable.ic_education -> EDUCATION
            R.drawable.ic_construction -> CONSTRUCTION
            R.drawable.ic_communal -> COMMUNAL
            R.drawable.ic_coffee -> COFFEE
            R.drawable.ic_clothes -> CLOTHES
            R.drawable.ic_car -> CAR
            R.drawable.ic_bank -> BANK
            else -> R.drawable.salary
        }
    }

    private companion object {
        const val CAPITALIZATION = 0
        const val FLY = 1
        const val JEWELRY = 2
        const val PRESENT = 3
        const val RESTAURANT = 4
        const val SALARY = 5
        const val SUPERMARKET = 6
        const val BANK = 7
        const val CAR = 8
        const val CLOTHES = 9
        const val COFFEE = 10
        const val COMMUNAL = 11
        const val CONSTRUCTION = 12
        const val EDUCATION = 13
        const val ENTERTAIMENTS = 14
        const val FRIENDS = 15
        const val GAMES = 16
        const val INTERNET = 17
        const val MEDICINE = 18
        const val MEDICINES = 19
        const val MOVIE = 20
        const val MUSIC = 21
        const val PETS = 22
        const val PHONE = 23
        const val REST = 24
        const val SAVINGS = 25
        const val SPORT = 26
        const val TRANSPORT = 27
        const val TV = 28
        const val WIFI = 29
        const val RENT = 30
    }
}

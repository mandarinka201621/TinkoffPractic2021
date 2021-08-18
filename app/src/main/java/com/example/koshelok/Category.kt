package com.example.koshelok

sealed class Category {

    abstract val icon: Int
    abstract val typeOperation: Int
    abstract val color: Int

    sealed class Income : Category() {

        class Salary(
            override val color: Int = R.color.background_income_icon,
        ) : Income() {
            override val icon: Int = R.drawable.salary
            override val typeOperation: Int = R.string.salary_text
        }

        class PartTime(
            override val color: Int = R.color.background_income_icon
        ) : Income() {
            override val icon: Int = R.drawable.salary
            override val typeOperation: Int = R.string.part_time_text
        }

        class Present(
            override val color: Int = R.color.background_income_icon
        ) : Income() {
            override val icon: Int = R.drawable.present
            override val typeOperation: Int = R.string.present_text

        }

        class Capitalization(
            override val color: Int = R.color.background_income_icon
        ) : Income() {
            override val icon: Int = R.drawable.capitalization
            override val typeOperation: Int = R.string.capitalization_text
        }

    }

    sealed class Consumption : Category() {
        class Supermarket(override val color: Int = R.color.background_card) : Consumption() {
            override val icon: Int = R.drawable.supermarket
            override val typeOperation: Int = R.string.supermarket_text
        }

        class Fly(override val color: Int = R.color.background_card) : Consumption() {
            override val icon: Int = R.drawable.fly
            override val typeOperation: Int = R.string.fly_text
        }

        class Jewelry(override val color: Int = R.color.background_card) : Consumption() {
            override val icon: Int = R.drawable.jewelry
            override val typeOperation: Int = R.string.jewelry_text
        }

        class Restaurant(override val color: Int = R.color.background_card) : Consumption() {
            override val icon: Int = R.drawable.restaurant
            override val typeOperation: Int = R.string.restaurant
        }
    }
}

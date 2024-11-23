package com.example.funfacts.data


sealed class UserDataUiEvents         //Event Class
{
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class AnimalSelected(val animalValue: String) : UserDataUiEvents()
}
package com.example.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacts.R
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.ui.AnimalCard
import com.example.funfacts.ui.ButtonComponent
import com.example.funfacts.ui.TextComponent
import com.example.funfacts.ui.TextFieldComponent
import com.example.funfacts.ui.TopBar
import com.example.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, showWelcomeScreen:(valuesPair: Pair<String, String>)->Unit)
{
    Surface(modifier = Modifier.fillMaxSize())
    {
       Column(modifier=Modifier.fillMaxSize().padding(18.dp))
       {
           TopBar("Hi there \uD83D\uDE0A")

           TextComponent("Let's learn about you !", 24.sp)

           Spacer(modifier =Modifier.size(20.dp))

           TextComponent("This app will prepare a details based on the input provided by you!",
               18.sp)

           Spacer(modifier =Modifier.size(60.dp))

           TextComponent("Name", 18.sp)

           Spacer(modifier =Modifier.size(10.dp))

           TextFieldComponent(onTextChanged = {
               userInputViewModel.onEvents(UserDataUiEvents.UserNameEntered(it))
           })

           Spacer(modifier =Modifier.size(20.dp))

           TextComponent("What do you like", 18.sp)

           Row(modifier=Modifier.fillMaxWidth())
           {
               AnimalCard(image =  R.drawable.cat, animalSelected =
               {
                   userInputViewModel.onEvents(UserDataUiEvents.AnimalSelected(it))
               }, selected =  userInputViewModel.uiState.value.animalSelected=="Cat")

               AnimalCard(image =  R.drawable.dog, animalSelected =
               {
                   userInputViewModel.onEvents(UserDataUiEvents.AnimalSelected(it))
               }, selected = userInputViewModel.uiState.value.animalSelected=="Dog")
           }

           Spacer(modifier = Modifier.weight(1f))

           if(userInputViewModel.isValidState())
           {
               ButtonComponent(
                   goToDetailsScreen =
                   { showWelcomeScreen(Pair(
                       userInputViewModel.uiState.value.nameEntered,
                       userInputViewModel.uiState.value.animalSelected))})
           }


       }
    }
}
/*
@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}
*/
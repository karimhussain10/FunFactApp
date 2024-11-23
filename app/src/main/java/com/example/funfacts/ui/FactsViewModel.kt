package com.example.funfacts.ui
import androidx.lifecycle.ViewModel

class FactsViewModel: ViewModel()
{
    fun generateRandomFacts(selectedAnimal: String): String
    {
        return if(selectedAnimal=="Dog") {
            getDogFacts().random()
        } else{
            getCatFacts().random()
        }


    }
  fun getDogFacts(): List<String>
  {

      val getDogFacts = listOf(
          "There is a town in Minnesota with a Dog as their Mayor. Duke won the popular vote and was made Honorary Mayor of Cormorant, Minn in 2014. ",
          "According to a study done by Cornell University, dogs were domesticated around 9,000 and 34,000 years ago. ",
          "Dogs can be trained to detect Cancer in humans. ",
          "Dogs have three eyelids. The third eyelid called a 'haw, is used to help keep the eye lubricated.",
          "Just like your fingerprint is unique to you, a dog's noseprint is entirely their own and there is no other like it.",
          "While we commonly refer to dogs as colorblind this isn't exactly true. They can still see some colors we just don't entirely know how they perceive these colors."

      )
      return getDogFacts
  }

    fun getCatFacts() :List<String>
    {
          val getCatFacts = listOf("Cats are believed to be the only mammals who don’t taste sweetness.",
              "Cats are nearsighted, but their peripheral vision and night vision are much better than that of humans",
              "Cats can jump up to six times their length.",
              "Cats have 230 bones, while humans only have 206.",
              "Cats have nearly twice the amount of neurons in their cerebral cortex as dogs.",
              "Cats’ rough tongues can lick a bone clean of any shred of meat.",
              "Cats use their long tails to balance themselves when they’re jumping or walking along narrow ledges.",
              "Male cats are more likely to be left-pawed, while female cats are more likely to be right-pawed.",
              "If your cat approaches you with a straight, almost vibrating tail, this means that she is extremely happy to see you.")
          return getCatFacts

      }

}
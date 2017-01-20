package types

import attaques._

trait Normal extends Types{
   override def prendreDegat(attaque : Attaque) : Int = {
      return attaque.degats
  }
}
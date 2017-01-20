package types

import attaques._

trait Elektrik extends Types{
  
   override def prendreDegat(attaque : Attaque) : Int = {
      return attaque.degats
  }
  
}
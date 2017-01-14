package types

import attaques._

trait Plante extends Types{
  
  override def prendreDegat(attaque : Attaque) : Int = {
    if(attaque.isInstanceOf[Eau]){
      return attaque.degats/2
    }else if(attaque.isInstanceOf[Feu]){
      return attaque.degats * 2
    }else
      return attaque.degats
  }
  
}
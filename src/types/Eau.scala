package types

import attaques._

trait Eau extends Types{
  
  override def prendreDegat(attaque : Attaque) : Int = {
    if(attaque.isInstanceOf[Feu] || attaque.isInstanceOf[Eau]){
      return attaque.degats/2
    }else if(attaque.isInstanceOf[Plante] || attaque.isInstanceOf[Elektrik]){
      return attaque.degats * 2
    }else
      return attaque.degats
  }
  
}
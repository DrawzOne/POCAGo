package types

import attaques._

trait Feu extends Types{
  
  
  override def prendreDegat(attaque : Attaque) : Int = {
    if(attaque.isInstanceOf[Feu] || attaque.isInstanceOf[Plante]){
      return attaque.degats/2
    }else if(attaque.isInstanceOf[Eau]){
      return attaque.degats * 2
    }else
      return attaque.degats
  }
}
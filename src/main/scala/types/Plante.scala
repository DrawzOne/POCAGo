package types

import attaques._

trait Plante extends Types{
  
  override def prendreDegat(attaque : Attaque) : Int = {
    if(attaque.isInstanceOf[AttEau]){
      return attaque.degats/2
    }else if(attaque.isInstanceOf[AttFeu] || attaque.isInstanceOf[AttVol]){
      return attaque.degats * 2
    }else
      return attaque.degats
  }
  
}
package types

import attaques._

trait Eau extends Types{
  
  override def prendreDegat(attaque : Attaque) : Int = {
    if(attaque.isInstanceOf[AttFeu] || attaque.isInstanceOf[AttEau]){
      return attaque.degats/2
    }else if(attaque.isInstanceOf[AttPlante] || attaque.isInstanceOf[AttElektrik]){
      return attaque.degats * 2
    }else
      return attaque.degats
  }
  
}
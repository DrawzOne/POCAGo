package types

import attaques._

trait Vol extends Types{
  
  override def prendreDegat(attaque : Attaque) : Int = {
     if(attaque.isInstanceOf[AttElektrik]){
      return attaque.degats * 2
    }else
      return attaque.degats
  
  }
  
}
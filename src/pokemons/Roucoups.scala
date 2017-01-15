package pokemons

import attaques._
import types.Vol

class Roucoups(niveau : Integer) 
extends Pokemon("Roucoups", niveau, 3*niveau + 19 , 10) with Vol {
  
  val attaque1 = new AttNormal("Pigeon", niveau*2 + 5)
  val attaque2 = new AttVol("Roucoulement", niveau*2 + 8)

  attaques(0) = attaque1
  attaques(1) = attaque2
  
  def evolution1() : Boolean = {
    if(niveau == 7){
      nom = "Roucarnage" 
      pointsDeVie += 20
      pointsDeVieMax += 20
      attaques(0).degats += 10
      attaques(1).degats += 10
      return true
    }
    return false
  }
  
 
override def monterDeNiv() = {
      super.monterDeNiv()
      if(evolution1()){
        println("Ouah ton pokémon évolue... il devient un " + nom + " ! il est devenu beaucoup plus fort !!!")
      }
  }
}
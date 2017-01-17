package pokemons

import attaques._
import types._

class Pikachu(niv : Integer) 
extends Pokemon("Pikachu", niv, 3*niv + 22 , niv/2 + 20) with Elektrik {
 
  val attaque1 = new AttNormal("queue de fer", niveau*2 + 9)
  val attaque2 = new AttElektrik("tonnerre", niveau*2 + 13)
   
  attaques(0) = attaque1
  attaques(1) = attaque2
  
  def evolution1() : Boolean = {
    if(niveau == 7){
      nom = "Raichu" 
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
package pokemons

import attaques._
import types.Feu

class Salameche(niveau : Integer) 
extends Pokemon("Salameche", niveau, 3*niveau + 29 , niveau/2 + 24) with Feu{
  
  
  val attaque1 = new AttNormal("Coup de Boule", niveau*2 + 7)
  val attaque2 = new AttFeu("Flammeche", niveau*2 + 10)
  

  attaques(0) = attaque1
  attaques(1) = attaque2
  
  def evolution1() : Boolean = {
    if(niveau == 6){
      nom = "Salameche" 
      pointsDeVie += 20
      pointsDeVieMax += 20
      attaques(0).degats += 10
      attaques(1).degats += 10
      return true
    }
    return false
  }
  
def evolution2() : Boolean = {
    if(niveau == 9){
      nom = "Dracaufeu"
      pointsDeVieMax += 23
      attaques(0).degats += 12
      attaques(1).degats += 12
      return true
    }
    return false
  }
 
override def monterDeNiv() = {
      super.monterDeNiv()
      if(evolution1() || evolution2()){
        println("Ouah ton pokémon évolue... il devient un " + nom + " ! il est devenu beaucoup plus fort !!!")
      }
  }
}
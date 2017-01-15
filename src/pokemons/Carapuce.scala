package pokemons

import attaques._
import types.Eau

class Carapuce(niv : Integer) 
      extends Pokemon("Carapuce",  niv, 3*niv + 31 , 23) with Eau{
  
  val attaque2 = new AttEau("pistolet à eau", niveau*2 + 10)
  val attaque1 = new AttNormal("griffe", niveau*2 + 6)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
  
def evolution1() : Boolean = {
    if(niveau == 6){
      nom = "Carabaffe" 
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
      nom = "Tortank"
      pointsDeVieMax += 20
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
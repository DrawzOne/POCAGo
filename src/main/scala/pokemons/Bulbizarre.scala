package pokemons

import attaques._
import types.Plante

class Bulbizarre(niv : Integer) 
      extends Pokemon("Bulbizarre", niv, 3*niv + 30 , niv/2 + 18) with Plante{
  
  
  val attaque1 = new AttNormal("frottement", niveau*2 + 7)
  val attaque2 = new AttPlante("fouet lianes", niveau*2 + 10)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
  
  def evolution1() : Boolean = {
    if(niveau == 6){
      nom = "Herbizarre" 
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
      nom = "Florizarre"
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
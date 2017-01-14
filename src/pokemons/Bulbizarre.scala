package pokemons

import attaques._
import types.Plante

class Bulbizarre(niveau : Integer) 
      extends Pokemon("Bulbizarre", niveau, 3*niveau + 15 , 20) with Plante{
  
  
  val attaque1 = new AttNormal("frottement", 25)
  val attaque2 = new AttPlante("fouet lianes", 40)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
}
package pokemons

import attaques._
import types.Plante

class Bulbizarre(niveau : Integer) 
      extends Pokemon("Bulbizarre", niveau, 3*niveau + 30 , 20) with Plante{
  
  
  val attaque1 = new AttNormal("frottement", niveau*2 + 7)
  val attaque2 = new AttPlante("fouet lianes", niveau*2 + 10)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
}
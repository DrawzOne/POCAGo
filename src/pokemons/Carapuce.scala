package pokemons

import attaques._
import types.Eau

class Carapuce(niveau : Integer) 
      extends Pokemon("Carapuce",  niveau, 3*niveau + 22 , 23) with Eau{
  
  val attaque1 = new AttEau("pistolet à eau", 25)
  val attaque2 = new AttNormal("griffe", 40)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
package pokemons

import attaques._
import types.Eau

class Carapuce(niveau : Integer) 
      extends Pokemon("Carapuce",  niveau, 3*niveau + 31 , 23) with Eau{
  
  val attaque2 = new AttEau("pistolet à eau", niveau*2 + 10)
  val attaque1 = new AttNormal("griffe", niveau*2 + 6)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
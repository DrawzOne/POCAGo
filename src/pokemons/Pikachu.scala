package pokemons

import attaques._
import types._

class Pikachu(niveau : Integer) 
extends Pokemon("Pikachu", niveau, 3*niveau + 22 , 30) with Elektrik {
 
  val attaque1 = new AttNormal("queue de fer", niveau*2 + 9)
  val attaque2 = new AttElektrik("tonnerre", niveau*2 + 13)
   
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
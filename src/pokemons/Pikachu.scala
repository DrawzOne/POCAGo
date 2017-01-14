package pokemons

import attaques._
import types._

class Pikachu(niveau : Integer) 
extends Pokemon("Pikachu", niveau, 3*niveau + 10 , 30) with Elektrik {
 
  val attaque1 = new AttNormal("queue de fer", 22)
  val attaque2 = new AttElektrik("tonnerre", 40)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
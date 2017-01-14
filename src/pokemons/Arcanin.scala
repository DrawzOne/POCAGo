package pokemons
import types._
import attaques._


class Arcanin(niveau : Integer) 
      extends Pokemon("Arcanin",  niveau, 3*niveau + 20, 40) with Feu{
  

  val attaque1 = new AttNormal("charge", 20)
  val attaque2 = new AttFeu("déflagration", 40)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
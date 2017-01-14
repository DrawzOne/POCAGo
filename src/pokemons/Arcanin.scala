package pokemons
import types._
import attaques._


class Arcanin(niveau : Integer) 
      extends Pokemon("Arcanin",  niveau, 3*niveau + 35, 40) with Feu{
  

  val attaque1 = new AttNormal("charge", niveau*2 + 8)
  val attaque2 = new AttFeu("déflagration", niveau*2 + 15)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
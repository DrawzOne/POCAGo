package pokemons
import types._
import attaques._


class Arcanin(niv : Integer) 
      extends Pokemon("Arcanin",  niv, 3*niv + 35, niv/2 + 30) with Feu{
  

  val attaque1 = new AttNormal("charge", niveau*2 + 8)
  val attaque2 = new AttFeu("déflagration", niveau*2 + 15)
  
  attaques(0) = attaque1
  attaques(1) = attaque2
  
}
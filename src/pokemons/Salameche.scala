package pokemons

import attaques._
import types.Feu

class Salameche(niveau : Integer) 
extends Pokemon("Salameche", niveau, 3*niveau + 29 , 35) with Feu{
  
  
  val attaque1 = new AttNormal("Coup de Boule", niveau*2 + 7)
  val attaque2 = new AttFeu("Flammeche", niveau*2 + 10)
  

  attaques(0) = attaque1
  attaques(1) = attaque2
}
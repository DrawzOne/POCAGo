package pokemons

import attaques._
import types.Feu

class Salameche(niveau : Integer) 
extends Pokemon("Salameche", niveau, 3*niveau + 18 , 35) with Feu{
  
  
  val attaque1 = new AttNormal("Coup de Boule", 25)
  val attaque2 = new AttFeu("Flammeche", 30)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
}
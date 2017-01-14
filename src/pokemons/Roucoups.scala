package pokemons

import attaques._
import types.Vol

class Roucoups(niveau : Integer) 
extends Pokemon("Roucoups", niveau, 3*niveau + 8 , 10) with Vol {
  
  val attaque1 = new AttNormal("Pigeon", 25)
  val attaque2 = new AttVol("Roucoulement", 40)
  
  val attaques = new Array[Attaque](2) 
  attaques(0) = attaque1
  attaques(1) = attaque2
}
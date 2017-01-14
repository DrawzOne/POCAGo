package pokemons

import attaques._
import types.Vol

class Roucoups(niveau : Integer) 
extends Pokemon("Roucoups", niveau, 3*niveau + 19 , 10) with Vol {
  
  val attaque1 = new AttNormal("Pigeon", niveau*2 + 5)
  val attaque2 = new AttVol("Roucoulement", niveau*2 + 8)

  attaques(0) = attaque1
  attaques(1) = attaque2
}
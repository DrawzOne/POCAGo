package attaques

import types._



abstract class Attaque(_nom : String, _degats : Int) extends Serializable {
  val nom = _nom
  var degats = _degats
  
}
package pokemons

import types._

abstract class Pokemon(_nom: String,  _niveau: Integer, _pointsDeVie: Integer, _difficulte : Integer) extends Serializable {
  var difficulte = _difficulte //difficulte pour capturer le pokémon
  val nom = _nom
  var niveau = _niveau
  var experience = 0
  var pointsDeVie = _pointsDeVie
  var pointsDeVieMax = pointsDeVie
  
  def combattre(p : Pokemon) : Unit = {
    pointsDeVie = pointsDeVie - 20
    progressionCombat(p)
  }
  
  def progressionCombat(p : Pokemon) : Unit = { 
    experience = experience + p.difficulte
  }
  
  def monterDeNiv() = {
    niveau += 1
    pointsDeVieMax += 5
    experience = 0
    difficulte = (5/4)*difficulte
  }
  
  def gagnerVie(n : Integer) = {
    if( (pointsDeVie + n) > pointsDeVieMax) pointsDeVie = pointsDeVieMax
    else pointsDeVie = pointsDeVie + n
  }
  
  override def toString : String =
     "(" + "Nom du pokémon : " + nom +  " Niveau : " + niveau + " Points de vie : " + pointsDeVie + " Difficulté : " + difficulte + ")"

   
}
package pokemons

import types._
import attaques._

abstract class Pokemon(_nom: String,  _niveau: Integer, _pointsDeVie: Integer, _difficulte : Integer) extends Serializable with Types {
  var difficulte = _difficulte //difficulte pour capturer le pokémon et experience acquise si victoire contre Pokémon
  val nom = _nom
  var niveau = _niveau
  var experience = 0
  var pointsDeVie = _pointsDeVie
  var pointsDeVieMax = pointsDeVie
  val attaques = new Array[Attaque](2)
  
  def combattre(p : Pokemon) : Unit = {
    pointsDeVie = pointsDeVie - 20
    progressionCombat(p)
  }
  
  def progressionCombat(p : Pokemon) : Unit = { 
    experience = experience + p.difficulte
    println(nom + " a gagné " + p.difficulte + " points d'experiences suite a ce combat")
  }
  
  def monterDeNiv() = {
    if(experience > niveau * 10){
      niveau += 1
      pointsDeVie += 5
      pointsDeVieMax += 5
      experience = 0
      difficulte = (5/4)*difficulte
      println(nom + " est monté d'un niveau, il passe au niveau " + niveau)
    }
  }
  
  def gagnerVie(n : Integer) = {
    if( (pointsDeVie + n) > pointsDeVieMax) pointsDeVie = pointsDeVieMax
    else pointsDeVie = pointsDeVie + n
  }
  
  def encaisserAttaque (attaque : Attaque) = {
    pointsDeVie -= prendreDegat(attaque)
    if (pointsDeVie < 0){
      pointsDeVie = 0
    }
  }
  
  def afficherAttaques () = {
    println(" Choisi ton attaque : 1. " + attaques(0).nom + " 2. " + attaques(1).nom )  
  }
  
  override def toString : String =
     "(" + "Nom du pokémon : " + nom +  " Niveau : " + niveau + " Points de vie : " + pointsDeVie + " Difficulté : " + difficulte + ")"

   
}
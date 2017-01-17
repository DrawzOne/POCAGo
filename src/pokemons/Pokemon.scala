package pokemons

import types._
import attaques._

abstract class Pokemon(_nom: String,  _niveau: Integer, _pointsDeVie: Integer, _difficulte : Integer) extends Serializable with Types {
  var difficulte = _difficulte //difficulte pour capturer le pokémon et experience acquise si victoire contre Pokémon
  var nom = _nom
  var niveau = _niveau
  var experience = 0
  var pointsDeVie = _pointsDeVie
  var pointsDeVieMax = pointsDeVie
  var attaques = new Array[Attaque](2)
  

  
  
  def progressionCombat(p : Pokemon) : Unit = { 
    experience = experience + p.difficulte * 2
    println(nom + " a gagné " + p.difficulte*2 + " points d'experiences suite a ce combat")
  }
  
  def monterDeNiv() = {
    if(experience >= niveau * 10){
      niveau += 1
      pointsDeVie += 5
      pointsDeVieMax += 5
      experience = 0
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
     "Nom du pokémon : " + nom +  "   niveau : " + niveau + "   points de vie : " + pointsDeVie + "/" + pointsDeVieMax + "   XP : " + experience + "/" + niveau*10

   
}
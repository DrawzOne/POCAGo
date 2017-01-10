import util.Random

abstract class Player() {
  val pseudo: String
  var argent = 100
  var positionX = 0
  var positionY = 0
  
  var map : Map = new Map(3, 3)
  map.tab(0)(0) = new Case(null, new Pokemon("A", "Eau", 1, 100, 10), false)
  map.tab(0)(1) = new Case(new Pokeball("P1", 25), null, false)
  map.tab(0)(2) = new Case(null, null, false)
  map.tab(1)(0) = new Case(new Pokeball("P2", 25), null, false)
  map.tab(1)(1) = new Case(null, null, false)
  map.tab(1)(2) = new Case(null, null, true)
  map.tab(2)(0) = new Case(null, null, false)
  map.tab(2)(1) = new Case(null, new Pokemon("C", "Terre", 2, 75, 1), false)
  map.tab(2)(2) = new Case(null, new Pokemon("B", "Feu", 5, 88, 50), false)
  
  /* var caseActuelle : Case = new Case(null, null, true) */
  val inventaire : Inventaire
  val pokemons : List[Pokemon]
  
  def monter()= {
    map.tab(positionX)(positionY).isJoueur = false
    positionY = positionY + 1
    map.tab(positionX)(positionY).isJoueur = true
  }  
  def descendre() = {
    map.tab(positionX)(positionY).isJoueur = false
    positionY = positionY - 1
    map.tab(positionX)(positionY).isJoueur = true
  } 
  def droite() = {
    map.tab(positionX)(positionY).isJoueur = false
    positionX = positionX + 1
    map.tab(positionX)(positionY).isJoueur = true
  }
  def gauche() = {
    map.tab(positionX)(positionY).isJoueur = false
    positionX = positionX - 1
    map.tab(positionX)(positionY).isJoueur = true
  }
  
  def lancerPokeball(p : Pokemon) : Boolean = { 
    if(inventaire.retirerPokeball()) { 
      if (Random.nextInt(100) > p.difficulte) { 
        return true
      }
      else return false
    }
    return false
  }
  
  def capturerPokemon(p : Pokemon) : Boolean = {
      if (lancerPokeball(p)) {
        pokemons :+ p
        return true
      }
      else return false
  } 
      
  
}
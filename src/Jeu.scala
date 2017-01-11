

class Jeu {
  
  var map : Map = new Map(3, 3)  
  
  def generateMap ()={
  map.tab(0)(0) = new Case(null, new Pokemon("A", "Eau", 1, 100, 10), false)
  map.tab(0)(1) = new Case(new Pokeball("P1", 25), null, false)
  map.tab(0)(2) = new Case(null, null, false)
  map.tab(1)(0) = new Case(new Pokeball("P2", 25), null, false)
  map.tab(1)(1) = new Case(null, null, false)
  map.tab(1)(2) = new Case(null, null, true)
  map.tab(2)(0) = new Case(null, null, false)
  map.tab(2)(1) = new Case(null, new Pokemon("C", "Terre", 2, 75, 1), false)
  map.tab(2)(2) = new Case(null, new Pokemon("B", "Feu", 5, 88, 50), false)
  }
  
  def afficherMap () = {
    for (i <- 0 to 2)
     for (j <- 0 to 2)
       map.tab(i)(j).afficherCase()
  }
  
    
  def monter(P : Player)= {
    map.tab(P.positionX)(P.positionY).isJoueur = false
    P.positionY = P.positionY + 1
    map.tab(P.positionX)(P.positionY).isJoueur = true
  }  
  
  def descendre(P : Player) = {
    map.tab(P.positionX)(P.positionY).isJoueur = false
    P.positionY = P.positionY - 1
    map.tab(P.positionX)(P.positionY).isJoueur = true
  } 
 
  def droite(P : Player) = {
    map.tab(P.positionX)(P.positionY).isJoueur = false
    P.positionX = P.positionX + 1
    map.tab(P.positionX)(P.positionY).isJoueur = true
  }
  
  def gauche(P : Player) = {
    map.tab(P.positionX)(P.positionY).isJoueur = false
    P.positionX = P.positionX - 1
    map.tab(P.positionX)(P.positionY).isJoueur = true
  }
  
  
  def main(args: Array[String]) {
     val scanner = new java.util.Scanner(System.in)
     val line = scanner.nextLine()
     var Player1 : Player1 = new Player1(line, null, null)
     generateMap()
     afficherMap()
  }  
}
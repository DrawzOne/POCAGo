import util.Random

abstract class Player(  val pseudo: String, var inventaire : Inventaire, var pokemons : List[Pokemon],
                       var argent : Int = 100
                      ,var positionX : Int = 0 ,var positionY : Int = 0
                       ) {


  

  
  /* var caseActuelle : Case = new Case(null, null, true) */


  
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
 
  def abandonnerPokemon(p : Pokemon) : Boolean = {
      for (pok <- pokemons) if (pok.equals(p)) {
        pokemons.filter(_ != p)
        return true
      }
      return false
  }
  
  def afficherPokemons () = {
    if (pokemons == null){
      println("Tu n'as pas de pokémon")
    }else{
      pokemons.foreach(println)
    }
  }
  
  override def toString : String =
     "(" + "Nom du joueur : " + pseudo + "Argent : " + argent + "Abscisse : " + positionX + "Ordonnée : " + positionY + ")"

     
}
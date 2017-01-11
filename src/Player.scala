import util.Random

abstract class Player(  val pseudo: String,var inventaire : Inventaire, var pokemons : List[Pokemon],
                       var argent : Integer = 100
                      ,var positionX : Integer = 0 ,var positionY : Integer = 0
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
 
  
}
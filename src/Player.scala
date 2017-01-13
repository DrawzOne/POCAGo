import util.Random
import collection.mutable
import pokemons.Pokemon


abstract class Player(  var pseudo: String, val inventaire : Inventaire
                       ,var argent : Int = 100
                      ,var positionX : Int = 0 ,var positionY : Int = 0
                       ) extends Serializable{

    def setPseudo(name: String) = { pseudo = name }

  
    val pokemons = mutable.ListBuffer[Pokemon]()
  
  /* var caseActuelle : Case = new Case(null, null, true) */


  
  def lancerPokeball(p : Pokemon) : Boolean = { 
    if(inventaire.retirerPokeball()) { 
      val rand = Random.nextInt(100)
      println(" " + rand)
      if (rand > p.difficulte) { 
        return true
      }else{
        println("Oh non le pokémon s'est échappe de la pokéball " )
        return false
      }
          
    }
    println("Tu n'as pas de pokéball pauvre " + this.pseudo)
   return false
  }
  
  def capturerPokemon(p : Pokemon) : Boolean = {
      if (lancerPokeball(p)) {
        pokemons += p
        
        //send.socket
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
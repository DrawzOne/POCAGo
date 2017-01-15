import util.Random
import collection.mutable
import pokemons.Pokemon
import attaques._

abstract class Player(  var pseudo: String, val inventaire : Inventaire
                       ,var argent : Int = 100
                      ,var positionX : Int = 0 ,var positionY : Int = 0
                       ) extends Serializable{

    def setPseudo(name: String) = { pseudo = name }

  
    val pokemons = mutable.ListBuffer[Pokemon]()
    val pokemonsValide = mutable.ListBuffer[Pokemon]()
  
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
        pokemonsValide += p
        
        //send.socket
        return true
      }
      else return false
  } 
 
  def isPokemonValide(pok : Pokemon) = {

    if(pok.pointsDeVie == 0){
        pokemonsValide -= pok
      }  
  }
  
  def soignerPokemons(){
    for(pok <- pokemons){
      if(pok.pointsDeVie == 0)
        pokemonsValide += pok
      pok.pointsDeVie = pok.pointsDeVieMax
    }
  }
  def abandonnerPokemon(p : Pokemon) : Boolean = {
      for (pok <- pokemons) if (pok.equals(p)) {
        pokemons.filter(_ != p)
        return true
      }
      return false
  }
  
  def afficherPokemons () = {
    if (!isPokemons()){
      println("Tu n'as pas de pokémon")
    }else{
      pokemons.foreach(println)
    }
  }
  
    def afficherPokemonsValide() = {
      var i = 1
      for (pok <- pokemonsValide){

          println(i + ". " + pok.nom)
          i += 1
        
      }
    }
    
    def choisirPokemon() : Pokemon = {
      println("Choisi ton pokémon qui va combattre")
      afficherPokemonsValide()
      val scanner = new java.util.Scanner(System.in)
      val choix = scanner.nextLine()
      
      return pokemonsValide(choix.toInt - 1)
      
      
    }
  
  def isPokemonValide() : Boolean = {
    for(pok <- pokemons) {
      if (pok != null && pok.pointsDeVie > 0) return true
    }
    return false
  }
  
  def isPokemons() : Boolean = {
    for(pok <- pokemons) {
      if (pok != null) return true
    }
    return false
  }

  
  override def toString : String =
     "(" + "Nom du joueur : " + pseudo + "Argent : " + argent + "Abscisse : " + positionX + "Ordonnée : " + positionY + ")"

     
}
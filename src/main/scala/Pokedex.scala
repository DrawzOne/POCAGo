import pokemons.Pokemon

abstract class Pokedex {
  
  val pokemons : List[Pokemon]
  
  def afficherPokedex() : Unit = {
    pokemons.foreach(println)
  }
  
}
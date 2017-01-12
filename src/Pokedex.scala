abstract class Pokedex {
  val pokemons : List[Pokemon]
  
  def print(args : List[_]) : Unit = {
    args.foreach(println)
  }
  
}
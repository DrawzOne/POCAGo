import pokemons._

class Player1(nom : String, inv : Inventaire) extends Player(nom, inv) with Serializable {
  val Pikachu = new Pikachu(5)
  pokemons += Pikachu
  pokemonsValide += Pikachu
  
}
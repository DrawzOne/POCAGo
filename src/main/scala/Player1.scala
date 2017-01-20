import pokemons._

class Player1(nom : String, inv : Inventaire) extends Player(nom, inv) with Serializable {
  val Pikachu = new Pikachu(6)
  Pikachu.experience = 45
  val Carapuce = new Carapuce(5)
  val bulbi = new Bulbizarre(5)
  pokemons += bulbi
  pokemons += Pikachu
  pokemons += Carapuce
  pokemonsValide += Pikachu
  pokemonsValide += Carapuce
  pokemonsValide += bulbi
  
}
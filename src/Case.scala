import pokemons._



class Case(_objet : Objet, _pokemon : Pokemon, _isJoueur : Boolean, _Cp : Boolean) extends Serializable  {
  var objet = _objet
  var pokemon = _pokemon
  var isJoueur = _isJoueur
  var centrePokemon = _Cp
  
  
  def afficherCase () = {
    print(if (isJoueur) "| P |" else if (centrePokemon) "| C |" else "|   |")
  }
  
}
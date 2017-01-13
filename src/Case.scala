import pokemons.Pokemon


class Case(_objet : Objet, _pokemon : Pokemon, _isJoueur : Boolean) extends Serializable  {
  var objet = _objet
  var pokemon = _pokemon
  var isJoueur = _isJoueur
  
  def afficherCase () = {
    print(if (isJoueur == true) "| P |" else "|   |")
  }
  
}
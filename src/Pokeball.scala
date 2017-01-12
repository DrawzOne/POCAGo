class Pokeball(_nom: String, _prix : Integer) extends Objet(_nom: String) {
  var prix = _prix
  
  override def toString : String =
     "(" + "Nom de la Pokéball : " + _nom + "Prix : " + _prix + ")"

  
}
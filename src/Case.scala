class Case(_objet : Objet, _pokemon : Pokemon, _isJoueur : Boolean)   {
  val objet = _objet
  val pokemon = _pokemon
  var isJoueur = _isJoueur
  
  def afficherCase () = {
    println(if (isJoueur == true) "| |" else "|P|")
  }
  
}
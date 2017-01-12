abstract class Objet(val _nom: String) {
  val nom = _nom
  
  override def toString : String =
     "(" + "Nom de l'objet : " + nom + ")"
  
}
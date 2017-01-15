import collection.mutable


class Inventaire() extends Serializable{

  val valeurMax : Int = 10
  var valeur : Int = 0
  var objets = mutable.ListBuffer[Objet]()
  
  def estVide() : Boolean = {
    for(objet <- objets) {
      if (objet != null) return false
    }
    return true
  }
  
  def compteurObjets() : Integer = {
    if(estVide()) return 0
    for(objet <- objets) {
      valeur = valeur + 1
    }
    return valeur
  }
  
  def retirerPokeball() : Boolean = {
    for (objet <- objets) if (objet.isInstanceOf[Pokeball]) {
      objets -= objet
      return true
    }
    return false
  }
  
  def ajouterObjet(O : Objet) : Boolean = {
    if (valeur < valeurMax) {
      objets += O
      valeur += 1
      return true
    }
    return false
  }
  
  def afficherInventaire() : Unit = {
    if (estVide()){
      println("Ton inventaire est vide")
    }else {
      objets.foreach(println)
    }
  }
  
  
}
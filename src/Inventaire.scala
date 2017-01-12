class Inventaire {
  val objets : List[Objet] = null
  val valeurMax : Integer = 10
  var valeur : Integer = 0
  
  def estVide() : Boolean = {
    for(objet <- objets) {
      if (objet != null) return true
    }
    return false
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
      objets.filter(_ != objet)
      return true
    }
    return false
  }
  
  def ajouterPokeball(_nom : String, _prix : Integer) : Boolean = {
    if (valeur < valeurMax) {
      objets :+ new Pokeball(_nom, _prix)
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
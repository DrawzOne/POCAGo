class Pokemon(_nom: String, _type: String, _niveau: Integer, _pointsDeVie: Integer, _difficulte : Integer) {
  var difficulte = _difficulte
  val nom = _nom
  val Type = _type
  var niveau = _niveau
  var experience = 0
  var pointsDeVieMax = _pointsDeVie
  var pointsDeVie = pointsDeVieMax
  
  def progressionCombat (p : Pokemon) : Unit = { 
    experience = experience + p.difficulte
  }
  
  def monterDeNiv () = {
    niveau += 1
    pointsDeVieMax += 5
    experience = 0
    difficulte = (5/4)*difficulte
  }
   
}
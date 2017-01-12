class Map(val _x : Integer, val _y : Integer) {
  val x = _x
  val y = _y
  var tab = Array.ofDim[Case](x, y)

  
  def generateMap ()={
  tab(0)(0) = new Case(null, new Pokemon("", "Eau", 1, 100, 1), true)
  tab(0)(1) = new Case(new Pokeball("Pokeball", 25), null, false)
  tab(0)(2) = new Case(null, null, false)
  tab(1)(0) = new Case(new Pokeball("Pokeball", 25), null, false)
  tab(1)(1) = new Case(null, null, false)
  tab(1)(2) = new Case(null, null, false)
  tab(2)(0) = new Case(null, null, false)
  tab(2)(1) = new Case(null, new Pokemon("C", "Terre", 2, 75, 1), false)
  tab(2)(2) = new Case(null, new Pokemon("B", "Feu", 5, 88, 50), false)
  }
  
  
  
  def afficherMap () = {
    for (i <- 0 to 2){
      print("\n")
      for (j <- 0 to 2){
       tab(j)(i).afficherCase()
      }
    }
  }

}
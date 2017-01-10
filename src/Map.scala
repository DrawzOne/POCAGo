class Map(val _x : Integer, val _y : Integer) {
  val x = _x
  val y = _y
  var tab = Array.ofDim[Case](x, y)
  /*
  def generateMap () = {
    tab(0)(0) = new Case(null, new Pokemon("A", "Eau", 1, 100, 10), false)
    tab(4)(6) = new Case(null, new Pokemon("B", "Feu", 5, 88, 50), false)
    tab(3)(5) = new Case(null, new Pokemon("C", "Terre", 2, 75, 1), false)
    tab(1)(2) = new Case(null, null, true)
    tab(0)(1) = new Case(new Pokeball("P1", 25), null, false)
    tab(1)(0) = new Case(new Pokeball("P2", 25), null, false)
  }
  */
}
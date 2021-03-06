import util.Random
import pokemons._


class Map(val _x : Integer, val _y : Integer) extends Serializable{
  val x = _x
  val y = _y
  var tab = Array.ofDim[Case](x, y)

  
  
  def genererMap () = {
    for (i <- 0 to x-1){
      for(j <- 0 to y-1){
        tab(i)(j) = new Case(null, null, false, false)
      }
    }

  }
  
  
  /*
  def generateMap ()={
  tab(0)(0) = new Case(null, new Arcanin( 1), true)
  tab(0)(1) = new Case(new Pokeball("Pokeball", 25), null, false)
  tab(0)(2) = new Case(null, null, false)
  tab(1)(0) = new Case(new Pokeball("Pokeball", 25), null, false)
  tab(1)(1) = new Case(null, null, false)
  tab(1)(2) = new Case(null, null, false)
  tab(2)(0) = new Case(null, null, false)
  tab(2)(1) = new Case(null, new Pikachu(4), false)
  tab(2)(2) = new Case(null, new Carapuce(3), false)
  }*/
  
  
  
  def afficherMap () = {
    for (i <- 0 to x-1){
      print("\n")
      for (j <- 0 to y-1){
       tab(j)(i).afficherCase()
      }
      print("->")
    }
  }

  
  def placerCentrePokemon() = {

    var cp = (x*y)/20
    var x1 = 0
    var y1 = 0
    var posx = 0
    var posy = 0
    
    
    while (cp > 0){
      posx = Random.nextInt(x) 
      posy = Random.nextInt(y) 
      if(!tab(posx)(posy).centrePokemon && tab(posx)(posy).pokemon == null){
        tab(posx)(posy).centrePokemon = true
        cp -= 1
      }
    }
  }
  
   def placerPokemon (P : Pokemon) = {
     var posx = 0
     var posy = 0
     var cond = true
     while (cond){
       posx = Random.nextInt(x)
       posy = Random.nextInt(y)
       if(tab(posx)(posy).pokemon == null){
          tab(posx)(posy).pokemon = P
          cond = false
       }
     }
   }
  
   def placerPokemons (nivMax : Int) ={
    var Arcanin = (x*y)/50 // nombre d'arcanin à placer
    var Bulbizarre = (x*y)/20
    var Carapuce = (x*y)/20
    var Pikachu = (x*y)/30
    var Roucoups = (x*y)/8
    var Salameche = (x*y)/20
    var posx = 0
    var posy = 0
    var niv= 0
    
    while (Arcanin > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Arcanin(niv)
        Arcanin -= 1
      }
    }
    while (Salameche > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Salameche(niv)
        Salameche -= 1
      }
    }
    while (Pikachu > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Pikachu(niv)
        Pikachu -= 1
      }
    }
    while (Roucoups > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Roucoups(niv)
        Roucoups-= 1
      }
     }
    
    while (Carapuce > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Carapuce(niv)
        Carapuce -= 1
      }
    }  
    while (Bulbizarre > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      niv = Random.nextInt(nivMax) + 1
      if(tab(posx)(posy).pokemon == null){
        tab(posx)(posy).pokemon = new Bulbizarre(niv)
        Bulbizarre -= 1
      }
    }  
  }
 
  def placerObjets() = {
    var pokeball = (x*y)/3
    var posx = 0
    var posy = 0
    
    
    while (pokeball > 0){
      posx = Random.nextInt(x)
      posy = Random.nextInt(y)
      if(tab(posx)(posy).objet == null){
        tab(posx)(posy).objet = new Pokeball("Pokeball", 25)
        pokeball -= 1
      }
    }
    
  }

}


class Jeu {
  
  
  val tailleX = 3
  val tailleY = 3
  var map : Map = new Map(tailleX, tailleY)  
  

  
    
  def monter(P : Player)= {
    if(P.positionY == 0){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY - 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  }  
  
  def descendre(P : Player) = {
    if(P.positionY == 2){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY + 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  } 
 
  def droite(P : Player) = {
    if(P.positionX == 2){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionX = P.positionX + 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  }
  
  def gauche(P : Player) = {
    if(P.positionX == 0){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionX = P.positionX - 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  }
  
      
    def seDeplacer(P : Player) = {
      var dir = 0
      while(dir == 0){
        dir = 1
        print("Quelle direction voulez vous prendre ? \n Droite (d) / Gauche (g) / Haut (h) / Bas (b)\n")
        val scanner = new java.util.Scanner(System.in)
        val direction = scanner.nextLine()
        direction match {
          case "d" => (droite(P))
          case "g" => (gauche(P))
          case "h" => (monter(P))
          case "b" => (descendre(P))
          case _ => dir = 0
        }
      }
    }
  
    def jouer () = {
     val action : String = " "
     println("Bienvenu dans Pokémon Go ! Veuillez choisir votre nom de joueur :")
     val scanner = new java.util.Scanner(System.in)
     val line = scanner.nextLine()
     println("Eh bien mon cher " + line + " es tu pret à vivre l'aventure de ta vie et capturer les pokémons les plus rare ?")
     var Player1 : Player1 = new Player1(line, null, null)
     map.generateMap()
     map.afficherMap()
     while (action != "e"){
       print("\nQue veux tu faire maintenant ?\n Se déplacer (d) / Consulter inventaire (i) / Consulter pokémons (p) / Sortir (s)\n")
       val scanner = new java.util.Scanner(System.in)
       val action = scanner.nextLine()
       action match {
         case "d" => seDeplacer(Player1) 
         case "i" => Player1.inventaire.afficherInventaire()
         case "p" => Player1.afficherPokemons()
         case "s" => sys.exit
         map.afficherMap()
        
       }
     }
  
  }
  

}
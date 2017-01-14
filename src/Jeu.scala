import pokemons.Pokemon


class Jeu extends Serializable{
  
  
  val tailleX = 10
  val tailleY = 10
  var map : Map = new Map(tailleX, tailleY)  
  var Player1 : Player1 = new Player1("", new Inventaire())
  

  
    
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
    if(P.positionY == tailleY){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY + 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  } 
 
  def droite(P : Player) = {
    if(P.positionX == tailleX){
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
        print("Quelle direction veux-tu prendre ? \n Droite (d) / Gauche (g) / Haut (h) / Bas (b)\n")
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
    
    def trouverObjet(P : Player) = {
      if (map.tab(P.positionX)(P.positionY).objet!=null){
        val objet : Objet = map.tab(P.positionX)(P.positionY).objet
        if(P.inventaire.ajouterObjet(objet)){
          map.tab(P.positionX)(P.positionY).objet = null
          println("\nTu as trouvé un(e) " + objet.nom + " il s'ajoute à ton inventaire ")
        }else {
          println("Tu as trouvé un " + objet.nom + " malheureusement plus de place dans l'inventaire")
        }
      }
    }
    
    def rencontrerPokemon(P : Player){
        if (map.tab(P.positionX)(P.positionY).pokemon!=null){
          val pokemon : Pokemon = map.tab(P.positionX)(P.positionY).pokemon
          println("Ouah tu as rencontré un " + pokemon.nom + " Veux tu le capturer ? (O/n)")
          val scanner = new java.util.Scanner(System.in)
          val reponse = scanner.nextLine()
          if(reponse == "O") {
            if(P.capturerPokemon(pokemon)){
              map.tab(P.positionX)(P.positionY).pokemon = null
              println("Felicitations tu as capture " +pokemon.nom)
            }
          }
        }
        
      
    }
  
    def jouer () = {
     val action : String = " "
     println("Bienvenu dans Pokémon Go ! Choisis ton magnifique nom de joueur mon ami :")
     val scanner = new java.util.Scanner(System.in)
     val line = scanner.nextLine()
     Player1.pseudo = line
     println("Eh bien mon cher " + line + " es tu pret à vivre l'aventure de ta vie et capturer les pokémons les plus rare ?")

     map.genererMap()
     map.placerPokemons()
     map.placerObjets()
     var cond = "";
     while (cond != "q"){
       map.afficherMap()
       trouverObjet(Player1)
       rencontrerPokemon(Player1)
       print("\nQue veux tu faire maintenant ?\n Se déplacer (d) / Consulter inventaire (i) / Consulter pokémons (p) / Quitter (q)\n")
       val scanner = new java.util.Scanner(System.in)
       val action = scanner.nextLine()
       action match {
         case "d" => seDeplacer(Player1) 
         case "i" => Player1.inventaire.afficherInventaire()
         case "p" => Player1.afficherPokemons()
         case "q" => cond = "q"
         case _ => println("Ce n'est pas une action valide")
         
        
       }
     }
  
  }
  

}
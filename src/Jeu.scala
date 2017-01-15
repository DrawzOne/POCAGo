import pokemons.Pokemon
import attaques._

class Jeu() extends Serializable{
  
  
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
    if(P.positionY == tailleY - 1){
      println("Impossible")
    }else{
      map.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY + 1
      map.tab(P.positionX)(P.positionY).isJoueur = true
    }
  } 
 
  def droite(P : Player) = {
    if(P.positionX == tailleX - 1){
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
          println("\nOuah tu as rencontré un " + pokemon.nom + " ! Veux tu le capturer(cap) le combattre (com) ou tout simplement l'ignorer (i)")
          val scanner = new java.util.Scanner(System.in)
          val reponse = scanner.nextLine()
          if(reponse == "cap") {
            if(P.capturerPokemon(pokemon)){
              map.tab(P.positionX)(P.positionY).pokemon = null
              println("Felicitations tu as capture " +pokemon.nom)
            }else {
              map.placerPokemon(pokemon)
            }
          }else if(reponse == "com"){
             if(!P.isPokemonValide())
               if(!P.isPokemons())
                 println("Tu n'as pas de pokemon pour combattre, il faut d'abord en capturer un")
               else
                 println("Tes pokémons sont tous ko, il faut d'abord les soigner pour pouvoir les faire combattre")
             else{
               val monPokemon = P.choisirPokemon()
               val combat : Combat = new Combat(monPokemon, pokemon)
               if(combat.combatPokemonSauvage()){
                 map.tab(P.positionX)(P.positionY).pokemon = null
                 
               }else {
                 Player1.isPokemonValide(monPokemon)
                 map.placerPokemon(pokemon)
               }
              
             }
          }
        }
        
      
    }
    
    def EntrerCentrePokemon(P : Player){
      if (map.tab(P.positionX)(P.positionY).centrePokemon){
        println("\nBienvenu dans le centre Pokémon, nous allons soigner vos Pokémons")
        P.soignerPokemons()
        println("Vos pokémons ont recuperé l'ensemble de leurs points de  vie. Au plaisir de vous revoir")
      }
    }
    
    
    def intro() = {
     if(Player1.pseudo == ""){
       println("Bienvenu dans Pokémon Go ! Choisis ton magnifique nom de joueur mon ami :")
       val scanner = new java.util.Scanner(System.in)
       val line = scanner.nextLine()
       Player1.pseudo = line
       println("Eh bien mon cher " + Player1.pseudo + " es tu pret à vivre l'aventure de ta vie et capturer les pokémons les plus rare ?")
       println("\nDans ce monde fabuleux, de petites créatures appelées Pokemon se dissimulent.")
       println("Ton but en tant que dresseur sera d'en capturer le maximum puis les faire combattre contre d'autre pokémons sauvages")
       println("afin qu'ils puissent monter en niveau. Pour pouvoir les capturer tu trouveras des pokéballs sur ton chemin") 
       println("N'hésite surtout pas à passer dans les centres pokémons pour soigner tes pokémons blessés")
     }else {
       println("Re la bienvenue " + Player1.pseudo + ". Tu nous as bien manqué")
     }
    
    }

    
  
    def jouer () = {
     val action : String = " "

     intro()
     map.genererMap()
     map.tab(Player1.positionX)(Player1.positionY).isJoueur = true
     map.placerPokemons()
     map.placerObjets()
     map.placerCentrePokemon()
     var cond = "";
     
     while (cond != "q"){
       map.afficherMap()
       trouverObjet(Player1)
       rencontrerPokemon(Player1)
       EntrerCentrePokemon(Player1)
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
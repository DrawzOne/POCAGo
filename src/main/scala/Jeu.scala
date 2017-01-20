import pokemons._
import attaques._

class Jeu() extends Serializable{
  
  
  val tailleX = 10
  val tailleY = 10
  var mapByUser : Map = null
  var map : Map = new Map(tailleX, tailleY)  
  var currentMap : Map = map
  var Player1 : Player1 = new Player1("", new Inventaire())
  
  
  
  
 
  def monter(P : Player)= {
    if(P.positionY == 0){
      println("Impossible")
    }else{
      currentMap.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY - 1
      currentMap.tab(P.positionX)(P.positionY).isJoueur = true
    }
  }  
  
  def descendre(P : Player) = {
    if(P.positionY == currentMap.y - 1){
      println("Impossible")
    }else{
      currentMap.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionY = P.positionY + 1
      currentMap.tab(P.positionX)(P.positionY).isJoueur = true
    }
  } 
 
  def droite(P : Player) = {
    if(P.positionX == currentMap.x - 1){
      changerMap()
    }else{
      currentMap.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionX = P.positionX + 1
      currentMap.tab(P.positionX)(P.positionY).isJoueur = true
    }
  }
  
  def gauche(P : Player) = {
    if(P.positionX == 0){
      println("Impossible")
    }else{
      currentMap.tab(P.positionX)(P.positionY).isJoueur = false
      P.positionX = P.positionX - 1
     currentMap.tab(P.positionX)(P.positionY).isJoueur = true
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
        currentMap.afficherMap()
      }
    }
    
    def trouverObjet(P : Player) : Boolean = {
      if (currentMap.tab(P.positionX)(P.positionY).objet!=null){
        val objet : Objet = currentMap.tab(P.positionX)(P.positionY).objet

        if(P.inventaire.ajouterObjet(objet)){
          currentMap.tab(P.positionX)(P.positionY).objet = null
          println("\nTu as trouvé un(e) " + objet.nom + " il s'ajoute à ton inventaire ")
          
        }else {
          println("Tu as trouvé un " + objet.nom + " malheureusement plus de place dans l'inventaire")
         
        }
        return true
      }
      return false
    }
    
    def rencontrerPokemon(P : Player) : Boolean ={
        if (currentMap.tab(P.positionX)(P.positionY).pokemon!=null){
          val pokemon : Pokemon = currentMap.tab(P.positionX)(P.positionY).pokemon
          println("\nOuah tu as rencontré un " + pokemon.nom + " de niveau " + pokemon.niveau + " ! Veux tu le capturer(cap) le combattre (com) ou tout simplement l'ignorer (i)")
          val scanner = new java.util.Scanner(System.in)
          val reponse = scanner.nextLine()
          if(reponse == "cap") {
            if(P.capturerPokemon(pokemon)){
              currentMap.tab(P.positionX)(P.positionY).pokemon = null
              println("Felicitations tu as capture " +pokemon.nom)
            }else {
              currentMap.placerPokemon(pokemon)
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
                 currentMap.tab(P.positionX)(P.positionY).pokemon = null
                 
               }else {
                 Player1.isPokemonValide(monPokemon)
                 currentMap.placerPokemon(pokemon)
               }
              
             }
          }
          return true
        }
        return false
      
    }
    
    def entrerCentrePokemon(P : Player) : Boolean = {
      if (currentMap.tab(P.positionX)(P.positionY).centrePokemon){
        println("\nBienvenu dans le centre Pokémon, nous allons soigner vos Pokémons")
        P.soignerPokemons()
        println("Vos pokémons ont recuperé l'ensemble de leurs points de  vie. Au plaisir de vous revoir")
        return true
      }
      return false
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
       println("afin qu'ils puissent monter en niveau. Pour pouvoir les capturer nous t'avons laissé une pokéball dans ton intenvaire. Tu en trouveras d'autre sur ton chemin") 
       println("N'hésite surtout pas à passer dans les centres pokémons pour soigner tes pokémons blessés")
       println("\nAh et j'oubliais, je te confie mon Pikachu, maintenant que je suis un dresseur à la retraite j'en ai plus besoin. Je compte sur toi pour en prendre soin !")
       
     }else {
       println("Re la bienvenue " + Player1.pseudo + ". Tu nous as bien manqué")
     }
      val scanner = new java.util.Scanner(System.in)
      val line = scanner.nextLine()

    
    }
    
    def creerMap() = {
     map.genererMap()
     map.tab(Player1.positionX)(Player1.positionY).isJoueur = true
     map.placerPokemons(5)
     map.placerObjets()
     map.placerCentrePokemon()
     currentMap.afficherMap()
    }
    
    def extensionMap (long : Int, nivMax : Int) = { 
      mapByUser = new Map(long, long)
      mapByUser.genererMap()
      mapByUser.placerPokemons(nivMax)
      mapByUser.placerObjets()
      mapByUser.placerCentrePokemon()
      Player1.positionX = 0
      mapByUser.tab(Player1.positionX)(Player1.positionY).isJoueur = true
      
      currentMap = mapByUser
      
    }
    
    def changerMap() = {
      println("Tu es arrive au bout de la carte, tu peux maintenant créer ta propre carte ou sinon continuer dans celle ci")
      println("Alors veux tu créer ta propre carte ? (O/n)")
      val scanner = new java.util.Scanner(System.in)
      val rep = scanner.nextLine()
      var long = 0
      var nivMax = 100
      if ( rep == "O"){
       while(long <= 3){
        println("Choisis la longueur de ta carte. Elle doit etre plus grande que 3")
        long = scanner.nextInt()
       }
       while(nivMax >= 100){
        println("Choisis le niveau maximum des pokémons que tu veux rencontrer. Doit etre inferieur a 100")
        nivMax = scanner.nextInt()
       }
        extensionMap(long, nivMax)
        println("Eh bien bienvenu dans ta propre ville " + Player1.pseudo)
      }
      
    }

    
    def event () = {
      val b1 = trouverObjet(Player1)
      val b2 = rencontrerPokemon(Player1)
      val b3 = entrerCentrePokemon(Player1)
      if(b1 || b2 || b3){
         val scanner = new java.util.Scanner(System.in)
         scanner.nextLine()
         currentMap.afficherMap()
       }
      
    }
  
    def jouer () = {
     val action : String = " "

     intro()
     creerMap()

     val scanner = new java.util.Scanner(System.in)
     var cond = "";
     while (cond != "q"){
       event()
       print("\nQue veux tu faire maintenant ?\n Se déplacer (d) / Consulter inventaire (i) / Consulter pokémons (p) / Quitter (q)\n")
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
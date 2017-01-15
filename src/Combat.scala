import pokemons._
import attaques._
import util.Random

class Combat (val p1 : Pokemon, val p2 : Pokemon) {
 
    def choisirAttaque (p : Pokemon) : Attaque = {
     println("\nAu tour de " + p.nom + " d'attaquer")
     p.afficherAttaques()
     val scanner = new java.util.Scanner(System.in)
     val choix = scanner.nextLine()
     if( choix == "1"){
       return p.attaques(0)
     }else if (choix == "2"){
       return p.attaques(1)
     }else 
        println("Ce n'est pas un chiffre valide")
        return choisirAttaque(p)
       
     
    }
    

  
    
    
    def combatPokemon () = {
      println("Le combat oppose " +p1.nom+" avec " +p1.pointsDeVie +" de vie et "+p2.nom+" avec "+p2.pointsDeVie + " de vie")
      var attaque1 : Attaque = null
      var attaque2 : Attaque = null
      while(p1.pointsDeVie > 0 && p2.pointsDeVie > 0){
        attaque1 = choisirAttaque(p1) 
        println(p1.nom + " attaque " + attaque1.nom)        
        p2.encaisserAttaque(attaque1) 
        println("Les points de vie de " + p2.nom + " passent à " + p2.pointsDeVie)
        if(p2.pointsDeVie > 0){
          attaque2 = choisirAttaque(p2)
          println(p2.nom + " attaque " + attaque2.nom) 
          p1.encaisserAttaque(attaque2)
          println("Les points de vie de " + p1.nom + " passent à " + p1.pointsDeVie)
        }
        
        if (p1.pointsDeVie == 0){
          println(p1.nom + " est KO " + p2.nom + " remporte le combat")
          p2.progressionCombat(p1)
          p2.monterDeNiv()

        }
        else if (p2.pointsDeVie == 0){
          println(p2.nom + " est KO " + p1.nom + " remporte le combat")
          p1.progressionCombat(p2)
          p1.monterDeNiv()

        }
      }
    }
    
    def combatPokemonSauvage () : Boolean = {
      println("Le combat oppose " +p1.nom+" avec " +p1.pointsDeVie +" de vie et un "+p2.nom+" sauvage avec "+p2.pointsDeVie + " de vie")
      var attaque1 : Attaque = null
      var attaque2 : Attaque = null
      while(p1.pointsDeVie > 0 && p2.pointsDeVie > 0){
        attaque1 = choisirAttaque(p1) 
        println(p1.nom + " attaque " + attaque1.nom)        
        p2.encaisserAttaque(attaque1) 
        println("Les points de vie de " + p2.nom + " sauvage passent à " + p2.pointsDeVie)
       
        if(p2.pointsDeVie > 0){
          attaque2 = p2.attaques(Random.nextInt(2))
          println("\n" + p2.nom + " sauvage attaque " + attaque2.nom) 
          p1.encaisserAttaque(attaque2)
          println("Les points de vie de " + p1.nom + " passent à " + p1.pointsDeVie)
        }
        
        if (p1.pointsDeVie == 0){
          println("\n" +p1.nom + " est KO " + p2.nom + " sauvage remporte le combat")          
          return false

        }
        else if (p2.pointsDeVie == 0){
          println("\n"+p2.nom + " sauvage est KO " + p1.nom + " remporte le combat")
          p1.progressionCombat(p2)
          p1.monterDeNiv()
          return true
        }
        
      }
      return true
    }
    
    
    
}
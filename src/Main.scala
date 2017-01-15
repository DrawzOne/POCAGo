import scala.swing._
import scala.swing.BorderPanel.Position._
import event._
import java.awt.{ Color, Graphics2D }
import scala.util.Random
import java.io._

import pokemons._

object Main extends App{
  
  //def main(args: Array[String]) {
     

    var Jeu : Jeu = new Jeu()
    Jeu.jouer()
    
    val charge = new ObjectOutputStream(new FileOutputStream("../Sauvegarde"))    
    charge.writeObject(Jeu)
    charge.close
    
    val lire = new ObjectInputStream(new FileInputStream("../Sauvegarde"))
    val stock = lire.readObject.asInstanceOf[Jeu]
    stock.jouer()
    charge.writeObject(stock)
    lire.close
    

    

    
   
     
  //} 
  /*
  extends SimpleSwingApplication
  
  def top = new MainFrame { // top is a required method
    title = "Pokemon Go"

    // declare Components here
    val label = new Label {
      text = "Bonjour"
      font = new Font("Ariel", java.awt.Font.ITALIC, 24)
    }
    contents = new BorderPanel { 
      add(new Button("Nouvelle partie!"))
    }
                Button ("Charger la partie")(println("on charge la partie"))
    menuBar = new MenuBar{
      contents += new Menu("Menu"){
        contents += new MenuItem("Pokédex"){
          
        }
        contents += new MenuItem(Action("Inventaire"){
          
        })
        contents += new MenuItem(Action("Sauvegarder"){
          
        })
      }
    }
    size = new Dimension (700, 700)
    centerOnScreen()
    

  }
       
      
  def map = new MainFrame { 
    title = "Pokemon Go"

    // declare Components here
    val label = new Label {
      text = "Bonjour"
      font = new Font("Ariel", java.awt.Font.ITALIC, 24)
    }
    contents = Button ("Nouvelle partie!")(Jeu.jouer())
               Button ("Charger la partie")(println("on charge la partie"))
    size = new Dimension (700, 700)
    centerOnScreen()
    

  }
}*/

  

}
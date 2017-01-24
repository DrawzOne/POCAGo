import java.util._;
import java.io._;

import java.io.FileOutputStream
import java.io.BufferedOutputStream
import java.nio.file.{Files, Paths}

object Main extends App{
  

  
     

    var Jeu : Jeu = new Jeu()
    Jeu.jouer()
    
    /*val charge = new ObjectOutputStream(new FileOutputStream("../Sauvegarde"))    
    charge.writeObject(Jeu)
    charge.close
    
    val lire = new ObjectInputStream(new FileInputStream("../Sauvegarde"))
    val stock = lire.readObject.asInstanceOf[Jeu]
    stock.jouer()
    charge.writeObject(stock)
    lire.close
    */
    
    
    
    var data = ToString.toByteArray(new Player1("A", new Inventaire()));
    System.out.println("Encoded serialized version");
    var some : Player1 = ToString.fromByteArray(data).asInstanceOf[Player1];
    System.out.println("\n\nReconstituted object");
    System.out.println(some);
    
   
    val bos = new BufferedOutputStream(new FileOutputStream("Données.dat"))
    Stream.continually(bos.write(data))
    bos.close()
  
    val byteArray = Files.readAllBytes(Paths.get("/Données.dat"))
    ToString.fromByteArray(byteArray)
}

    
    

    

    
   
    

  

}
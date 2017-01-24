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
    
    
    

    


    /*
    val byteArray = Files.readAllBytes(Paths.get("../Données.dat"))

    var Sauvegarde : Jeu = ToString.fromByteArray(byteArray)
    Sauvegarde.jouer()
    
    var data = ToString.toByteArray(Sauvegarde);
    val bos = new BufferedOutputStream(new FileOutputStream("../Données.dat"))
    Stream.continually(bos.write(data))
    bos.close()
    println("Encoded serialized version");
    var some : Jeu = ToString.fromByteArray(data).asInstanceOf[Jeu];
    println("\n\nReconstituted object");
 	*/
    
}

    
    

    

    
   
    

  


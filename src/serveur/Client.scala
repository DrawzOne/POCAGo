/*import java.net._
import java.io._
import scala.io._
import swing._
import Swing._
import scala.actors.Actor


object Client {
    
  
    
    val socket = new Socket(InetAddress.getByName("localhost"), 19999)
    var in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
    val out = new PrintStream(socket.getOutputStream)
    println("Client initialized:")
    actors.Actor.actor{
      while(true){
        if(in.ready){
          val output = in.readLine
          println(output)
        }
      }
    }
    while(true){
      
    }

  
}*/

/*
package serveur

import java.net.ServerSocket
import java.net.Socket
import java.io.BufferedInputStream
import java.io.PrintStream
import java.io.InputStream
import java.io.BufferedOutputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import collection.mutable 

object serveursimple {
  



 case class User(sock :Socket, is : InputStream, ps :PrintStream, name : String)
  
  def main(args : Array[String]) : Unit = {
    val users = mutable.Buffer[User]()
    val ss  = new ServerSocket (4444)
    actors.Actor.actor{    
      while(true) {
      val sock = ss.accept()
      val is = new BufferedInputStream(sock.getInputStream())
      val os = new PrintStream(new BufferedOutputStream(sock.getOutputStream()))
      users += User(sock, is, os, name)
      }
    }

  }
} 
*/


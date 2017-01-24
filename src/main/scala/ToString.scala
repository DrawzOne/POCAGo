import java.util._;
import java.io._;
 

object ToString {
 
    /** Read the object from Base64 string. */
    def fromByteArray(data: Array[Byte]) : Jeu = {
        var ois:ObjectInputStream = new ObjectInputStream( 
                                        new ByteArrayInputStream(  data ) );
        var o: Jeu  = ois.readObject().asInstanceOf[Jeu];
        ois.close();
        return o;
    }
 
    /** Write the object to a Base64 string. */
    def toByteArray(o:Serializable ): Array[Byte] = {
        var baos:ByteArrayOutputStream = new ByteArrayOutputStream();
        var oos:ObjectOutputStream = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return baos.toByteArray();
    }
}
/*import scala.slick.session.Database
import Database.threadLocalSession
import slick.jdbc.{StaticQuery => Q, GetResult}
import javax.sql.DataSource
import Q.interpolation
 
class DefaultPlayerDAO(dataSource: DataSource) extends PlayerDAO {

/* Maven dependency à inclure dans le fichier "pom.xml" */
/*
<dependency>
	<groupId>
		com.typesafe.slick
	</groupId>
	<artifactId>
		slick_2.10
	</artifactId>
	<version>
		1.0.0
	</version>
 </dependency>
*/

/* Tables de la base de données */
val createTablePlayer =
    sql"""
	CREATE TABLE Player (
	       id_Player : INT NOT NULL,
	       pseudo : VARCHAR(30),
	       nombrePokeball : INT
	       argent : INT,
	       positionX : INT,
	       positionY : INT,
	       PRIMARY KEY(id_Player)
	       )
     """".update.quick

val createTablePokemon =
    sql"""
	CREATE TABLE Pokemon (
	       id_Pokemon : INT NOT NULL,
	       nom : VARCHAR(30),
	       Type : VARCHAR(30),
	       niveau : INT,
	       pointsDeVie : INT,
	       difficulte : INT,
	       PRIMARY KEY(id_Pokemon)
	       )
    """.update.quick

val createTablePlayer_Pokemon =
    sql"""
	CREATE TABLE Player_Pokemon (
	       FOREIGN KEY (id_Player) REFERENCES Player(id_Player)
	       FOREIGN KEY (id_Pokemon) REFERENCES Pokemon(id_Pokemon)
	       )
    """.update.quick

val createTablePokeball =
    sql"""
	CREATE TABLE Pokeball (
	       nom : VARCHAR(30),
	       prix : INT
	       )
    """".update.quick
 
  lazy val BDD = Database.forDataSource(dataSource)

  def getInfosPlayerById(id : Int) : Seq[Player] = {
    BDD.withSession {
      "
	select *
	from Player
	where id_Player = $id
      ".as[Player]
    }
  }
 
  def getPseudoById(id : Int) : String = {
    BDD.withSession {
      sql"""
	select pseudo
	from Player
	where id_Player = $id
      """.as[String]
    }
  }
 
  def getPokemonsByPlayerId(id : Int): Seq[Pokemon] = {
    BDD.withSession(
      sql"
	select Player.pseudo, Pokemon.nom
	from Player, Pokemon, Player_Pokemon
	where Player_Pokemon.id_Player = $id
      ".list
    )
  }

  def getPositionsByPlayerId(id: Int) : String = {
    BDD.withSession(
      sql"
	select positionX, positionY
	from Player
	where id_Player = $id
      ".as[String]
    )
  }
 
  def deletePokemonByIds(idPl : Int, idPo : Int) : Unit = {
    BDD.withSession(
      sqlu"
	delete *
	from Player_Pokemon
	where Player_Pokemon.id_Player = $idPl and Player_Pokemon.id_Pokemon = $idPo
      "
    )
  }
 
}*/
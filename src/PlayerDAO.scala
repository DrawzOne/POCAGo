import pokemons._

trait PlayerDAO {
  def getInfosPlayerById(id : Int) : Seq[Player]

  def getPseudoById(id : Int) : String
  
  def getPokemonsByPlayerId(id : Int) : Seq[Pokemon]
  
  def getPositionsByPlayerId(id : Int) : String
 
  def deletePokemonById(idPl : Int, idPo : Int) : Unit
}
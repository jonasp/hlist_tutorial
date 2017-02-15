trait WorldIsFlat
trait GodExists

type ChurchIsRight = (WorldIsFlat, GodExists)

implicit val churchIsRight = (new WorldIsFlat {}, new GodExists {})

implicit def worldIsReallyFlat: WorldIsFlat = ???

implicitly[WorldIsFlat]

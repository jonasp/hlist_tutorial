// Logic programming

// We can state facts or assumptions just by creating a type

trait WorldIsSphere
trait SunInCenter

// Proving things is done by writing a program which type checks
// c.f. propositions as types

val worldIsSphere: WorldIsSphere = new WorldIsSphere {}
val sunInCenter: SunInCenter = new SunInCenter {}

// these two were easy because they were
// simply the assumptions we started with.

// Let us now define the standard logic combinators
// and is straightforward and is simply the tuple (A, B)
def and[A, B](a: A, b: B): (A, B) = (a, b)

// for or we need to work a bit harder because
// we need to construct it from either A or B
def orLeft[A, B](a: A): Either[A, B] = Left(a)
def orRight[A, B](b: B): Either[A, B] = Right(b)

// Then we can say that we have a heliocentric worldview if the world
// is a sphere and the sun is in the center.

type HeliocentricWorldview = (WorldIsSphere, SunInCenter)

// can we prove that based on our assumptions? easy.

val heliocentricWorldview: HeliocentricWorldview =
  (worldIsSphere, sunInCenter)


// Also we say that we have probebly heliocentric worldview if we assume
// either that the world is a sphere or the sun is in the center - this
// example is not the best maybe...

type ProbablyHeliocentric = Either[WorldIsSphere, SunInCenter]

val probablyHeliocentric1: ProbablyHeliocentric = orLeft(worldIsSphere)
val probablyHeliocentric2: ProbablyHeliocentric = orRight(sunInCenter)


// What we did until now is that we constructed the proofs ourselves because
// we wrote explicit implementations which explicitly referenced known
// assumptions. We can use the implicit scope to let the compiler find the
// correct assumptions for us.

// first we make all our assumptions implicit
implicit val a1 = heliocentricWorldview
implicit val a2 = sunInCenter

// we then need to lift our combinators to use implicits and create new
// implicits from them
implicit def implAnd[A, B](implicit a: A, b: B): (A, B) = and(a,b)
implicit def implOrLeft[A, B](implicit a: A): Either[A, B] = orLeft(a)
implicit def implOrRight[A, B](implicit b: B): Either[A, B] = orRight(b)

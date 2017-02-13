import $ivy.`com.chuusai::shapeless:2.3.2`; import shapeless._

sealed trait Color
case class Blue() extends Color
case class Green() extends Color
case class Red() extends Color
case class White() extends Color
case class Yellow() extends Color

sealed trait Nationality
case class Dane() extends Nationality
case class German() extends Nationality
case class Englishman() extends Nationality
case class Swede() extends Nationality
case class Norwegian() extends Nationality

sealed trait Drink
case class Beer() extends Drink
case class Coffee() extends Drink
case class Milk() extends Drink
case class Tea() extends Drink
case class Water() extends Drink

sealed trait Smoke
case class Blend() extends Smoke
case class BlueMaster() extends Smoke
case class PallMall() extends Smoke
case class Prince() extends Smoke

sealed trait Pet
case class Birds() extends Pet
case class Cats() extends Pet
case class Dogs() extends Pet
case class Fish() extends Pet
case class Horses() extends Pet

trait House[
  N <: Nationality,
  C <: Color,
  D <: Drink,
  S <: Smoke,
  P <: Pet]

// type Street = HList

// trait Lives[N <: Nationality, C <: Color]
// trait Keeps[N <: Nationality, P <: Pet]
// trait Drinks[N <: Nationality, D <: Drink]
// trait NextTo[H1 <: House[_, _, _, _, _], H2 <: House[_, _, _, _, _]]
//
// implicit val c1 = new Lives[Englishman, Red] {}
// implicit val c2 = new Keeps[Swede, Dogs] {}
// implicit val c3 = new Drinks[Dane, Tea] {}
// implicit val c4 =
//   new NextTo[House[Green, _, _, _, _], House[White, _, _, _, _]] {}
// implicit val c5 = new 

// implicit val empty = HNil
//
// implicit def c1[D <: Drink, S <: Smoke, P <: Pet](
//     implicit rest: Street): Street =
//   new House[Englishman, Red, D, S, P] {} :: rest
//
// // implicit def c2(implicit rest: Street): Street =
// //   new House[Swe]
//
// implicitly[
//   House[Englishman, Red, Tea, Blend, Dogs] :: HNil
// ](c1[Tea, Blend, Dogs])

sealed trait Nat
trait Zero extends Nat
trait Succ[N <: Nat] extends Nat

type _0 = Zero
type _1 = Succ[_0]
type _2 = Succ[_1]
type _3 = Succ[_2]
type _4 = Succ[_3]
type _5 = Succ[_4]
type _6 = Succ[_5]
type _7 = Succ[_6]
type _8 = Succ[_7]
type _9 = Succ[_8]

trait Diff[A <: Nat, B <: Nat] {
  type Out <: Nat
}

object Diff {
  type Aux[A <: Nat, B <: Nat, Out0 <: Nat] =
    Diff[A, B] { type Out = Out0 }

  implicit def diffZero[A <: Nat]: ??? = ???

  implicit def diffPred[A <: Nat, B <: Nat, C <: Nat](???): ??? = ???
}

implicitly[Diff.Aux[_5, _3, _2]]

trait Nat
trait Zero extends Nat
trait Succ[N <: Nat] extends Nat

trait Diff[A <: Nat, B <: Nat] {
  type Out <: Nat
}

object Diff {
  type Aux[A <: Nat, B <: Nat, Out0 <: Nat] =
    Diff[A, B] { type Out = Out0 }

  implicit def diffZero[N <: Nat]: Aux[N, Zero, N] =
    new Diff[N, Zero] { type Out = N }
}

val ev = implicitly[Diff.Aux[Succ[Zero], Zero, Succ[Zero]]]
println(ev)

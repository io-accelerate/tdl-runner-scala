package io.accelerate

import java.util
import io.accelerate.client.queue.abstractions.ParamAccessor
import io.accelerate.solutions.CHK.Checkout
import io.accelerate.solutions.FIZ.FizzBuzz
import io.accelerate.solutions.HLO.Hello
import io.accelerate.solutions.SUM.Sum

//noinspection ZeroIndexToHead
object EntryPointMapping {

  def sum(p: util.List[ParamAccessor]): AnyRef = Sum.sum(p.get(0).getAsInteger, p.get(1).getAsInteger).asInstanceOf[AnyRef]
  def hello(p: util.List[ParamAccessor]): AnyRef = Hello.hello(p.get(0).getAsString).asInstanceOf[AnyRef]
  def fizz_buzz(p: util.List[ParamAccessor]): AnyRef = FizzBuzz.fizzBuzz(p.get(0).getAsInteger).asInstanceOf[AnyRef]
  def checkout(p: util.List[ParamAccessor]): AnyRef = Checkout.checkout(p.get(0).getAsString).asInstanceOf[AnyRef]

}

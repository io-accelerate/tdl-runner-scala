package io.accelerate

import java.util
import com.google.gson.JsonElement
import io.accelerate.solutions.ARRS.ArraySum
import io.accelerate.solutions.CHK.Checkout
import io.accelerate.solutions.CHL.Checklite
import io.accelerate.solutions.FIZ.FizzBuzz
import io.accelerate.solutions.HLO.Hello
import io.accelerate.solutions.IRNG.IntRange
import io.accelerate.solutions.SUM.Sum

import scala.jdk.CollectionConverters.*
import scala.collection.mutable.ListBuffer

//noinspection ZeroIndexToHead
object EntryPointMapping {

  def sum(p: util.List[JsonElement]): AnyRef = Sum.sum(p.get(0).getAsInt, p.get(1).getAsInt).asInstanceOf[AnyRef]
  def hello(p: util.List[JsonElement]): AnyRef = Hello.hello(p.get(0).getAsString).asInstanceOf[AnyRef]
  def array_sum(p: util.List[JsonElement]): AnyRef = {
    var intArray = new ListBuffer[Int]()
    p.get(0).getAsJsonArray.forEach(jsonElement => intArray += jsonElement.getAsInt)
    ArraySum.sum(intArray.toList).asInstanceOf[AnyRef]
  }
  def int_range(p: util.List[JsonElement]): AnyRef = {
    IntRange.generate(p.get(0).getAsInt, p.get(1).getAsInt).asJava.asInstanceOf[AnyRef]
  }
  def fizz_buzz(p: util.List[JsonElement]): AnyRef = FizzBuzz.fizzBuzz(p.get(0).getAsInt).asInstanceOf[AnyRef]
  def checkout(p: util.List[JsonElement]): AnyRef = Checkout.checkout(p.get(0).getAsString).asInstanceOf[AnyRef]
  def checklite(p: util.List[JsonElement]): AnyRef = Checklite.checklite(p.get(0).getAsString).asInstanceOf[AnyRef]

}

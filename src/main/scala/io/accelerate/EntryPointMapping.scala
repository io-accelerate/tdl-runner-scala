package io.accelerate

import io.accelerate.client.queue.abstractions.ParamAccessor
import io.accelerate.solutions.CHK.CheckoutSolution
import io.accelerate.solutions.DMO.{DemoRound1Solution, DemoRound2Solution, DemoRound3Solution, DemoRound4n5Solution, InventoryItem}
import io.accelerate.solutions.FIZ.FizzBuzzSolution
import io.accelerate.solutions.HLO.HelloSolution
import io.accelerate.solutions.RBT.RabbitHoleSolution
import io.accelerate.solutions.SUM.SumSolution

/**
 * This class maps an RPC event to a method call.
 * It converts the parameters into the right format.
 *
 * We have chosen to map events to instance methods
 * to allow for better test coverage computation.
 *
 * Mapping events to static methods might have also worked but
 * that would have resulted in uncovered default constructors.
 */
class EntryPointMapping {
  private val sumSolution = new SumSolution()
  private val helloSolution = new HelloSolution()
  private val fizzBuzzSolution = new FizzBuzzSolution()
  private val checkoutSolution = new CheckoutSolution()
  private val rabbitHoleSolution = new RabbitHoleSolution()
  private val demoRound1Solution = new DemoRound1Solution()
  private val demoRound2Solution = new DemoRound2Solution()
  private val demoRound3Solution = new DemoRound3Solution()
  private val demoRound4n5Solution = new DemoRound4n5Solution()

  def sum(p: java.util.List[ParamAccessor]): Any = {
    sumSolution.sum(p.get(0).getAsInteger, p.get(1).getAsInteger)
  }

  def hello(p: java.util.List[ParamAccessor]): Any = {
    helloSolution.hello(p.get(0).getAsString)
  }
  
  def fizzBuzz(p: java.util.List[ParamAccessor]): Any = {
    fizzBuzzSolution.fizzBuzz(p.get(0).getAsInteger)
  }

  def checkout(p: java.util.List[ParamAccessor]): Any = {
    checkoutSolution.checkout(p.get(0).getAsString)
  }

  def rabbitHole(p: java.util.List[ParamAccessor]): Any = {
    rabbitHoleSolution.rabbitHole(
      p.get(0).getAsInteger,
      p.get(1).getAsInteger,
      p.get(2).getAsString,
      p.get(3).getAsMapOf(classOf[String])
    )
  }


  // Demo Round 1
  
  def increment(p: java.util.List[ParamAccessor]): Any = {
    demoRound1Solution.increment(p.get(0).getAsInteger)
  }

  def toUppercase(p: java.util.List[ParamAccessor]): Any = {
    demoRound1Solution.toUppercase(p.get(0).getAsString)
  }

  def letterToSanta(p: java.util.List[ParamAccessor]): Any = {
    demoRound1Solution.letterToSanta
  }

  def countLines(p: java.util.List[ParamAccessor]): Any = {
    demoRound1Solution.countLines(p.get(0).getAsString)
  }
  
  // Demo Round 2

  def arraySum(p: java.util.List[ParamAccessor]): Any = {
    demoRound2Solution.arraySum(p.get(0).getAsListOf(classOf[Integer]))
  }

  def intRange(p: java.util.List[ParamAccessor]): Any = {
    demoRound2Solution.intRange(p.get(0).getAsInteger, p.get(1).getAsInteger)
  }

  def filterPass(p: java.util.List[ParamAccessor]): Any = {
    demoRound2Solution.filterPass(p.get(0).getAsListOf(classOf[Integer]), p.get(1).getAsInteger)
  }
  
  // Demo Round 3

  def inventoryAdd(p: java.util.List[ParamAccessor]): Any = {
    demoRound3Solution.inventoryAdd(p.get(0).getAsObject(classOf[InventoryItem]), p.get(1).getAsInteger)
  }

  def inventorySize(p: java.util.List[ParamAccessor]): Any = {
    demoRound3Solution.inventorySize
  }

  def inventoryGet(p: java.util.List[ParamAccessor]): Any = {
    demoRound3Solution.inventoryGet(p.get(0).getAsString)
  }

  // Demo Round 4 and 5

  def waves(p: java.util.List[ParamAccessor]): Any = {
    demoRound4n5Solution.waves(p.get(0).getAsInteger)
  }
}

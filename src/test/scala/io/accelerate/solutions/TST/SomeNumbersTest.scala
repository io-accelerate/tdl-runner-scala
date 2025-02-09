package io.accelerate.solutions.TST

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SomeNumbersTest extends AnyFlatSpec with Matchers {

  "One" should "return 1" in {
    One.apply() shouldBe 1
  }
}

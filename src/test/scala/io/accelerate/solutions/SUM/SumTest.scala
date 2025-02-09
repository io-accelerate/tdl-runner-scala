package io.accelerate.solutions.SUM

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SumTest extends AnyFlatSpec with Matchers {

  "Sum" should "compute sum" in {
    Sum.sum(1, 2) shouldBe 3
  }
}

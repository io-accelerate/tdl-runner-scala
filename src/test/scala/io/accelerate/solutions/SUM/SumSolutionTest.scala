package io.accelerate.solutions.SUM

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SumSolutionTest extends AnyFlatSpec with Matchers {

  "Sum" should "compute sum" in {
    SumSolution.sum(1, 2) shouldBe 3
  }
}

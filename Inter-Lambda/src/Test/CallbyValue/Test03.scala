package Test.CallbyValue

import Test.{ejecutarInterprete, evaluarResultado}

case object Test03 extends App{
  //Arrage
  val input = "(λf.(f λx.λy.x) ((λx.λy.λf.((f x) y) a) b))"
  val output = "Expresión reducida: a"

  //Action
  val expresionReducida = ejecutarInterprete(input, "set call-by-value")

  //Assert
  val resultado = evaluarResultado(output, expresionReducida)
  println("TEST 03:")
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")
}


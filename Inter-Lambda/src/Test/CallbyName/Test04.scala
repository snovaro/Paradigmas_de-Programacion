package Test.CallbyName

import Test.*
case object Test04 extends App{
  //Arrage
  val input = "(λx.λx.(y x) z)"
  val output = "Expresión reducida: λx.(y x)"

  //Action
  val expresionReducida = ejecutarInterprete(input,"set call-by-name")

  //Assert
  val resultado = evaluarResultado(output, expresionReducida)
  println("TEST 04:")
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")
}






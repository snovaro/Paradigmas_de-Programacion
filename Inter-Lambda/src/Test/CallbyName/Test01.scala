package Test.CallbyName

import Test.*

case object Test01 extends App{
  //Arrage
  val input = "(λx.λy.y (λx.(x x) λx.(x x)))"
  val output = "Expresión reducida: λy.y"

  //Action
  val expresionReducida = ejecutarInterprete(input,"set call-by-name")

  //Assert
  val resultado = evaluarResultado(output,expresionReducida)
  println("TEST 01:")
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
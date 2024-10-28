package Test.CallbyName

import Test.*
case object Test02 extends App{
  //Arrage
  val input = "(λx.λy.x y)"
  val output = "Expresión reducida: λy*.y"

  //Action
  val expresionReducida = ejecutarInterprete(input,"set call-by-name")
  
  //Assert
  val resultado = evaluarResultado(output, expresionReducida)
  println("TEST 02:")
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")
}


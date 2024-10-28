package Test.FreeVariables

import Test.{ejecutarInterprete, evaluarResultado}

object Test03 extends App{
  //Arrage
  //input sacado de la guia de funcional
  val input = "(x λz.(x λw.((w z) y)))"
  val output = "Variables libres: {x ,y}"

  //Action
  val variablesLibres = ejecutarInterprete(input, "set free-variables")

  //Assert
  val resultado = evaluarResultado(output, variablesLibres)
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
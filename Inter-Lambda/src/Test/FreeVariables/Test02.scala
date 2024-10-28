package Test.FreeVariables

import Test.{ejecutarInterprete, evaluarResultado}

object Test02 extends App{
  //Arrage
  //input sacado de la guia de funcional
  val input = "λx.((x y) λz.(x z))"
  val output = "Variables libres: {y}"

  //Action
  val variablesLibres = ejecutarInterprete(input, "set free-variables")
  

  //Assert
  val resultado = evaluarResultado(output, variablesLibres)
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
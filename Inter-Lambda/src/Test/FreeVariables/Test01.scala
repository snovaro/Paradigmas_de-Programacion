package Test.FreeVariables

import Test.{ejecutarInterprete, evaluarResultado}

object Test01 extends App{
  //Arrage
  val input = "(λf.λx.(y x) z)"
  val output = "Variables libres: {y ,z}"

  //Action
  val variablesLibres = ejecutarInterprete(input, "set free-variables")
 

  //Assert
  val resultado = evaluarResultado(output, variablesLibres)
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
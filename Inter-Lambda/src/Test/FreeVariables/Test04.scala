package Test.FreeVariables

import Test.{ejecutarInterprete, evaluarResultado}

object Test04 extends App{
  //Arrage

  val input = "λx.λy.(y x)"
  val output = "Variables libres: No se encontraron variables libres en esta expresión"

  //Action
  val variablesLibres = ejecutarInterprete(input, "set free-variables")
  
  //Assert
  val resultado = evaluarResultado(output, variablesLibres)
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
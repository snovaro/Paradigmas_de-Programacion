package Test.CallbyValue

import Test.{ejecutarInterprete, evaluarResultado}

case object Test01 extends App{
  //Arrage
  val input = "(λx.λy.y (λx.(x x) λx.(x x)))"
  val output = "Debe romper por ser infinito"
  
  println("TEST 01(RECURSION INFINITA):")
  printf("Input: %s\n", input)
  
  //Action
  val expresionReducida = ejecutarInterprete(input, "set call-by-value")

  //Assert
  val resultado = evaluarResultado(output, expresionReducida)
  
  //DATO, ESTE TEST ROMPE POR LLAMARSE INFINITAS VECES, CUMPLE CON EL ENUNCIADO
  
  println(s"Resultado esperado para el input '$input' : '$output'  es = '$resultado'")

}
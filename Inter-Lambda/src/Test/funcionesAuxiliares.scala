package Test

import Disenio.Lexer.leerInputDeUsuario
import Disenio.Parser.parsearTokens
import Disenio.Parser.parsearExpresionAString
import Disenio.Reductor.reductorSegunModo

def ejecutarInterprete(input:String,modo: String): String = {
  val listadoDeTokens = leerInputDeUsuario(input)
  val parseado = parsearTokens(listadoDeTokens)
  val resultado = reductorSegunModo(modo,parseado)
  resultado
}

def evaluarResultado(output:String, resultado:String): Boolean = {
  output == resultado
}

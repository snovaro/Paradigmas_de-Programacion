package Disenio.Reductor

import Disenio.Parser.*
import Disenio.Auxiliares.*
def reductorSegunModo(modo:String, expresion:Expresion): String = modo match {
    case FREEVARIABLES =>
      // Funciones para hacer el free variable
      val fvariables = freeVariables(expresion)
      "Variables libres: " + imprimirListaVariables(fvariables)
    case CALLBYNAME =>
      // Funciones para hacer reduccion call-by-name
      val reducida = reductorCallByName(expresion)
      "Expresión reducida: " + parsearExpresionAString(reducida)
    case CALLBYVALUE =>
      // Funciones para hacer reduccion call-by-value
      val reducida = reductorCallByValue(expresion)
      "Expresión reducida: " + parsearExpresionAString(reducida)    
}
def imprimirListaVariables(fvariables: List[String]): String={
  fvariables match
    case List() => "No se encontraron variables libres en esta expresión"
    case _ => "{" + fvariables.reduce((x,y)=> x + " ," + y) + "}"
}
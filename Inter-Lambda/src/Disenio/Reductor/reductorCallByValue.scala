package Disenio.Reductor

import Disenio.Parser.*
import Disenio.Auxiliares.*

def reduccionBetaCBV(expr: Expresion, variable: Variable, reemplazo: Expresion): Expresion = expr match {
  case Variable(valor) if valor == variable.e => reemplazo
  case Abs(vLigada, contenido) if vLigada != variable => Abs(vLigada, reduccionBetaCBV(contenido, variable, reemplazo))
  case Aps(e1, e2) => Aps(reduccionBetaCBV(e1, variable, reemplazo), reduccionBetaCBV(e2, variable, reemplazo))
  case _ => expr
}

def reductorCallByValue(expr: Expresion): Expresion = expr match {
  case Aps(Abs(variable:Variable, contenido), arg) =>
    val reducedArg = reductorCallByValue(arg)
    val nuevoContenido = conversionAlfaGeneral(contenido, freeVariables(reducedArg))
    reductorCallByValue(reduccionBetaCBV(nuevoContenido, variable, reducedArg))
  case Abs(vLigada, contenido) => Abs(vLigada, reductorCallByValue(contenido))
  case Aps(e1, e2) =>
    val reducedE1 = reductorCallByValue(e1)
    val reducedE2 = reductorCallByValue(e2)
    (reducedE1, reducedE2) match {
      case (Abs(variable, contenido), argumento) => reductorCallByValue(Aps(reducedE1, reducedE2))
      case _ => Aps(reducedE1, reducedE2)
    }
  case Variable(_) => expr
}

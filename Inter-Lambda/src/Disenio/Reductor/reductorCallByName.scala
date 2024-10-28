package Disenio.Reductor

import Disenio.Parser.*
import Disenio.Auxiliares.*

def callByName(e1: Expresion, e2: Expresion): Expresion = e1 match {
    case Variable(v) => Aps(e1, reductorCallByName(e2))
    case Abs(vLigada, contenido) =>
      val nuevoContenido = conversionAlfaGeneral(contenido, freeVariables(e2))
      reductorCallByName(reduccionBetaCBN(parsearExpresionAString(vLigada), nuevoContenido, e2))
    case Aps(e1, e3) =>
      val expresion = callByName(e1, e3)
      expresion match {
        case Aps(exp1, exp2) => Aps(expresion, reductorCallByName(e2))
        case _ => callByName(expresion, e2)
      }
}
def reductorCallByName(expresion: Expresion): Expresion = expresion match {
  case Variable(_) => expresion
  case Aps(exp1, exp2) => callByName(reductorCallByName(exp1), exp2)
  case Abs(vLigada, contenido) => Abs(vLigada, reductorCallByName(contenido))
}

def reduccionBetaCBN(vLigada: String, expresion: Expresion, reemplazo: Expresion): Expresion = expresion match {
  case Variable(valor) if valor == vLigada => reemplazo
  case Variable(valor) => expresion
  case Abs(variable, contenido) if parsearExpresionAString(variable) == vLigada => expresion
  case Abs(variable, contenido) =>
    Abs(variable, reduccionBetaCBN(vLigada, contenido, reemplazo))
  case Aps(e1, e2) => Aps(reduccionBetaCBN(vLigada, e1, reemplazo), reduccionBetaCBN(vLigada, e2, reemplazo))
}
package Disenio.Auxiliares

import Disenio.Parser.*

def conversionAlfa(expresion: Expresion, vLigada: String): Expresion = {
  val nuevoNombre = vLigada + SIGNOCONVALFA
  expresion match {
    case Variable(valor) if valor == vLigada => Variable(nuevoNombre)
    case Abs(variable, contenido) if parsearExpresionAString(variable) == vLigada =>
      Abs(Variable(nuevoNombre), conversionAlfa(contenido, vLigada))
    case Abs(variable, contenido) => Abs(variable, conversionAlfa(contenido, vLigada))
    case Aps(e1, e2) => Aps(conversionAlfa(e1, vLigada), conversionAlfa(e2, vLigada))
    case _ => expresion
  }
}

def conversionAlfaGeneral(expresion: Expresion, VLibres2daExpresion: List[String]): Expresion = {
  expresion match {
    case Variable(valor) => Variable(valor)
    case Abs(variable, contenido) if VLibres2daExpresion.contains(parsearExpresionAString(variable)) =>
      val nuevoNombreVLigada = parsearExpresionAString(variable) + SIGNOCONVALFA
      Abs(Variable(nuevoNombreVLigada), conversionAlfaGeneral(conversionAlfa(contenido, parsearExpresionAString(variable)), VLibres2daExpresion))
    case Abs(variable, contenido) => Abs(variable, conversionAlfaGeneral(contenido, VLibres2daExpresion))
    case Aps(e1, e2) => Aps(conversionAlfaGeneral(e1, VLibres2daExpresion), conversionAlfaGeneral(e2, VLibres2daExpresion))
  }
}
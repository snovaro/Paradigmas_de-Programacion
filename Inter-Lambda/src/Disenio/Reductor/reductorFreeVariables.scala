package Disenio.Reductor

import Disenio.Parser.*
def freeVariables(exp: Expresion): List[String] = {
  exp match
    case Variable(v) => List(v)
    case Aps(exp1, exp2) => unirVariables(freeVariables(exp1), freeVariables(exp2))
    case Abs(vLigada, contenido) => quitarVariable(freeVariables(vLigada), freeVariables(contenido))
}
def unirVariables(vExp1: List[String], vExp2: List[String]): List[String] = {
  vExp1.appendedAll(vExp2)
    .groupBy(x => x)
    .keys
    .toList
}
def quitarVariable(vLigada: List[String], variables: List[String]): List[String] = {
  variables
    .filter(x => !vLigada.contains(x))
}


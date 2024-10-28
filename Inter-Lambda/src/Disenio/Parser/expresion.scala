package Disenio.Parser

sealed trait Expresion

case class Abs(variable: Expresion,contenido: Expresion) extends Expresion
case class Aps(e1:Expresion, e2: Expresion) extends Expresion
case class Variable(e: String) extends Expresion



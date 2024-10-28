package Disenio.Lexer

sealed trait Token

case object Lambda extends Token
case object Dot extends Token
case class  Var(value: String) extends Token
case object Space extends Token
case object Lpar extends Token
case object Rpar extends Token
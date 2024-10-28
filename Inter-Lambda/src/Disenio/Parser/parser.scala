package Disenio.Parser

import Disenio.Lexer.*

private def _parsearTokensRec(tokens: List[Token]): (Expresion, List[Token]) = tokens match {
  case Lambda :: Var(value) :: Dot :: restoDeTokensAParsear =>
    val (contenido, restoDeTokensRestantes) = _parsearTokensRec(restoDeTokensAParsear)
    (Abs(Variable(value), contenido), restoDeTokensRestantes)
  case Lpar :: restoDeTokensAParsear =>
    val (expresion1, tokensDespuesDeE1) = _parsearTokensRec(restoDeTokensAParsear)
    tokensDespuesDeE1 match {
      case Space :: tokensDespuesDelEspacio =>
        val (expresion2, tokensDespuesDeE2) = _parsearTokensRec(tokensDespuesDelEspacio)
        tokensDespuesDeE2 match {
          case Rpar :: remainingTokens => (Aps(expresion1, expresion2), remainingTokens)
        }
    }
  case Var(value) :: restoDeTokensAParsear => (Variable(value), restoDeTokensAParsear)
}
def parsearTokens(tokens: List[Token]): Expresion = {
  val (expr, _) = _parsearTokensRec(tokens)
  expr
}
def parsearExpresionAString(expr: Expresion): String = expr match {
  case Abs(variable:Variable,contenido) => s"λ${parsearExpresionAString(variable)}.${parsearExpresionAString(contenido)}"
  case Aps(exprs1,exprs2) => s"(${parsearExpresionAString(exprs1)} ${parsearExpresionAString(exprs2)})"
  case Variable(value) => value
}
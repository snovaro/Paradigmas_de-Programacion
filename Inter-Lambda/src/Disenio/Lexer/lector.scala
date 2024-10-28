package Disenio.Lexer

def leerInputDeUsuario(expresionLambda: String): List[Token] = {
  val exps = expresionLambda.toList.map(x => x.toString)
  _leerInputUsuarioRec(exps)
}

private def _leerInputUsuarioRec(tokens: List[String]): List[Token] = { tokens match {
    case Nil => List()
    case x::xs => val op = x match {
        case "λ" => Lambda
        case "." => Dot
        case " " => Space
        case "(" => Lpar
        case ")" => Rpar
        case _ => Var(x)
    }
      op::_leerInputUsuarioRec(xs)
    }
}


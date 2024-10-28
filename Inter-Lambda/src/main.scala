import Disenio.Lexer.*
import Disenio.Parser.*
import Disenio.Reductor.*
import Disenio.Auxiliares.*
import scala.io.StdIn

def inputDeUsuario(modo: String): Unit = {
  printf("\nActualmente se encuentra en el modo: %s\n", modo)
  println("Por favor, ingrese una EXPRESION LAMBDA o SETEE UN NUEVO MODO (ingrese 'help' para conocer los modos disponibles): ")
  val input = StdIn.readLine()
  input match {
    case CALLBYNAME =>
      inputDeUsuario(input)
    case CALLBYVALUE =>
      inputDeUsuario(input)
    case FREEVARIABLES =>
      inputDeUsuario(input)
    case SALIR => println("Adios!")
    case AYUDA => printf("" +
      "%s: Para reducir la expresión mediante el método call-by-name\n" +
      "%s : Para reducir la expresión mediante el método call-by-value\n" +
      "%s : Para hallar las variables libres de la expresión\n", CALLBYNAME, CALLBYVALUE, FREEVARIABLES)
      inputDeUsuario(modo)
    case "" =>
      printf("No ingreso nada, si quiere salir escriba '%s'", SALIR)
      inputDeUsuario(modo)
    case _ =>
      val ListaDeTokens = leerInputDeUsuario(input);
      val expresion = parsearTokens(ListaDeTokens)
      println(reductorSegunModo(modo, expresion))
      inputDeUsuario(modo)
  }
}

@main
def main(): Unit = {
  println("BIENVENIDO AL INTERPRETE DE CALCULO LAMBDA! :)")
  inputDeUsuario(CALLBYNAME)
}
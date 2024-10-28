package org.example;

import org.example.Casilla.*;
import org.example.Estado.EnJuego;
import org.example.Estado.EstadoJugador;
import org.example.Propiedades.*;

import java.util.*;

public class ConfiguracionDePartida {
    private final int montoInicioJuego;
    private final int montoDeLlegadaFinal;
    private final int montoDeLibertad;
    private final int montoDeLoteria;
    private final int montoDeMulta;
    private final int cantCasillaLoteria;
    private final int cantCasillaMulta;
    private final int cantCasillaDePaso;
    private final int cantGruposDeADos;
    private final int cantGruposDeATres;
    private final int cantEstaciones;
    private final int porcentajeAlquiler;
    private final int porcentajeDeAumentoTransporte;
    private final int porcentajeHipoteca;
    private int tamanioTablero;
    private Tablero tablero;
    private List<Jugador> jugadores;
    private List<List<Object>> grupoYprecios;
    private List<List<Object>> estaciones;
    private Banco banco;
    private List<GrupoPropiedad> grupos;
    private int pos_inicio;
    private int pos_comisaria;
    private int pos_carcel;

    public ConfiguracionDePartida(HashMap<String,String> jugadoresInput) {
        this.montoInicioJuego = 1500;
        this.montoDeLlegadaFinal = 1000;
        this.montoDeLibertad = 200;
        this.montoDeLoteria = 800;
        this.montoDeMulta = 100;
        this.cantCasillaLoteria = 3;
        this.cantCasillaMulta = 3;
        this.cantCasillaDePaso = 5;
        this.cantGruposDeADos = 2;
        this.cantGruposDeATres = 6;
        this.cantEstaciones = 4;
        this.porcentajeAlquiler = 50; // el alquiler representa un 50% de lo que costo adquirir el comprable
        this.porcentajeDeAumentoTransporte = 25; // por cada transporte adquirido, aumenta el pasaje un 25%
        this.porcentajeHipoteca = 40; // cuando hipotecas una propiedad, te pagan un 40% del valor de compra de esa propiedad
        setJugadores(jugadoresInput);
        setBanco();
        setGruposYPrecios();
        setEstaciones();
        calcularCantCasillas();
        establecerCasillasObligatorias();
        crearTablero();
    }

    private void establecerCasillasObligatorias() {
        this.pos_inicio = 0; // primer esquina
        this.pos_comisaria = this.tamanioTablero /4; // segunda esquina
        this.pos_carcel = this.tamanioTablero * 3 / 4; // cuarta esquina
    }

    private void setBanco() {
        this.banco = new Banco(montoDeLibertad, montoInicioJuego, montoDeLlegadaFinal, jugadores);
    }
    private void setGruposYPrecios() {
        List<List<Object>> grupoYprecios = new ArrayList<>();
        agregarGruposYPrecios(grupoYprecios, "Flores", "Flores Norte",110, "Flores Sur",120, "Flores Centro",130);
        agregarGruposYPrecios(grupoYprecios, "Balvanera", "Balvanera Norte",130, "Balvanera Sur",140, "Balvanera Centro",150);
        agregarGruposYPrecios(grupoYprecios, "Boedo",  "Boedo Norte",15, "Boedo Sur",160, "Boedo Centro",170);
        agregarGruposYPrecios(grupoYprecios, "Almagro", "Almagro Norte",170, "Almagro Sur",180, "Almagro Centro",190);
        agregarGruposYPrecios(grupoYprecios, "Caballito", "Caballito Norte",200, "Caballito Sur",210, "Caballito Centro",220);
        agregarGruposYPrecios(grupoYprecios, "Montserrat", "Montserrat Norte",220, "Montserrat Sur",230, "Montserrat Centro",240);
        agregarGruposYPrecios(grupoYprecios, "Colegiales", "Colegiales Norte",240, "Colegiales Sur",250, "Colegiales Centro",260);
        agregarGruposYPrecios(grupoYprecios, "Recoleta", "Recoleta Norte",260, "Recoleta Sur",270, "Recoleta Centro",280);
        agregarGruposYPrecios(grupoYprecios, "Palermo", "Palermo Norte",280, "Palermo Sur",290, "Palermo Centro",300);
        agregarGruposYPrecios(grupoYprecios, "Belgrano", "Belgrano Norte",300, "Belgrano Sur",310, "Belgrano Centro",320);
        agregarGruposYPrecios(grupoYprecios, "Puerto Madero", "Puerto Madero Norte",320, "Puerto Madero Sur",330,"Puerto Madero Centro",340);
        this.grupoYprecios = grupoYprecios;
    }

    private void agregarGruposYPrecios(List<List<Object>> grupoYPrecios, String nombreGrupo, String nombreProp1, int precioProp1, String nombreProp2, int precioProp2, String nombreProp3, int precioProp3){
        grupoYPrecios.add(Arrays.asList(nombreGrupo, Arrays.asList(Arrays.asList(nombreProp1, precioProp1), Arrays.asList(nombreProp2, precioProp2), Arrays.asList(nombreProp3, precioProp3))));
    }
    private void setEstaciones() {
        List<List<Object>> estaciones = new ArrayList<>();
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Mitre", 200))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Roca", 220))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Sarmiento", 240))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("San Martín", 260))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Urquiza", 280))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Belgrano Sur", 300))));
        estaciones.add(Arrays.asList("Transporte",(Arrays.asList("Belgrano Norte", 320))));
        this.estaciones = estaciones;
    }
    private void calcularCantCasillas() {
        // 1 comisaria, 1 carcel, 1 inicio/llegada no son configurables
        this.tamanioTablero = this.cantCasillaLoteria + this.cantCasillaDePaso + (this.cantGruposDeATres * 3) + (this.cantGruposDeADos * 2) + this.cantCasillaMulta + 1 + 1 + 1;
    }
    private void setJugadores(HashMap<String,String> jugadoresInput) {
        List<Jugador> jugadores = null;
        for (Map.Entry<String,String> jugador : jugadoresInput.entrySet()) {
            String colorJugador = jugador.getKey();
            String nombreJugador = jugador.getValue();
            Jugador jugadorAGuardar = new Jugador(nombreJugador, colorJugador);
            new EnJuego(banco).activarEstado(jugadorAGuardar);
            jugadores.add(jugadorAGuardar);
        }
        Collections.shuffle(jugadores);
        this.jugadores = jugadores;
    }

    private void crearTablero() {
        List<Casilla> casillas = crearCasillas();
        Tablero tablero = agregarCasillasAlTablero(casillas);
        this.tablero = tablero;
    }
    private List<Casilla> crearCasillas() {
        List<Casilla> casillas = new ArrayList<>();
        crearCasillasLoteria(casillas);
        crearCasillasMulta(casillas);
        crearCasillasDePaso(casillas);
        crearCasillasHospedaje(casillas);
        crearCasillasTransporte(casillas);
        Collections.shuffle(casillas); //casillas = shuffleCasillas(casillas);
        // Las siguientes posiciones no son configurables:
        crearCasillaInicio(casillas);
        crearCasillaCarcel(casillas);
        crearCasillaComisaria(casillas);
        return casillas;
    }
    private void crearCasillasLoteria(List<Casilla> casillas) {
        for (int i = 0; i < this.cantCasillaLoteria; i++) {
            casillas.add(new CasillaDeLoteria(montoDeLoteria, banco));
        }
    }
    private void crearCasillasMulta(List<Casilla> casillas) {
        for (int i = 0; i < this.cantCasillaMulta; i++) {
            casillas.add(new CasillaDeMulta(montoDeMulta, banco));
        }
    }
    private void crearCasillasDePaso(List<Casilla> casillas) {
        for (int i = 0; i < this.cantCasillaDePaso; i++) {
            casillas.add(null);
        }
    }
    private void crearCasillasHospedaje(List<Casilla> casillas) {
        List<Hospedaje> hospedajes = new ArrayList<>();
        for (List<Object> grupo : this.grupoYprecios) {
            String nombreGrupo = grupo.get(0).toString();
            for (int i = 1; i< grupo.size(); i++) {
                List<Object> parametros = (List<Object>) grupo.get(i);
                String nombreHospedaje = (String) parametros.get(0);
                int valorCompraHospedaje = (int) parametros.get(1);
                Hospedaje nuevoHospedaje = new Hospedaje(valorCompraHospedaje, valorCompraHospedaje * porcentajeHipoteca/100, valorCompraHospedaje * porcentajeAlquiler/100, nombreHospedaje, grupo, banco);
                hospedajes.add(nuevoHospedaje);
                casillas.add(new CasillaComprable(nuevoHospedaje, banco));

            }
            grupos.add(new GrupoPropiedad(hospedajes, nombreGrupo, hospedajes.size()));
        }
    }
    private void crearCasillasTransporte(List<Casilla> casillas) {
        for (int i = 0; i < this.cantEstaciones; i++) {
            List<Object> estacion = this.estaciones.get(i);
            List<Object> nombreYPrecio = (List<Object>) estacion.get(1);
            String nombre = (String) nombreYPrecio.get(0);
            int valorCompra = (int) nombreYPrecio.get(1);
            int valorHipoteca = valorCompra * porcentajeHipoteca / 100;
            int valorAlquiler = valorCompra * porcentajeAlquiler / 100;
            Transporte transporte = new Transporte(nombre, valorCompra, valorHipoteca, valorAlquiler, (String) estacion.get(0), banco, this.cantEstaciones, this.porcentajeDeAumentoTransporte);
            casillas.add(new CasillaComprable(transporte, banco));
        }
    }
    private void crearCasillaInicio(List<Casilla> casillas) {
        casillas.add(pos_inicio, null);
    }
    private void crearCasillaCarcel(List<Casilla> casillas) {
        casillas.add(pos_carcel, new CasillaIrPreso(banco));
    }
    private void crearCasillaComisaria(List<Casilla> casillas) {
        casillas.add(pos_comisaria, null);
    }
    private Tablero agregarCasillasAlTablero(List<Casilla> casillas) {
        HashMap<Integer, Casilla> casillasHashMap = new HashMap<>();
        for (int pos = 0; pos < this.tamanioTablero; pos++) {
            Casilla casilla = casillas.get(pos);
            casillasHashMap.put(pos, casilla);
        }
        return new Tablero(casillasHashMap, this.grupos, this.pos_comisaria);
    }

    private List<Casilla> shuffleCasillas(List<Casilla> casillas){
        // habria que mejorar el algoritmo de mezcla para intercalar propiedades con no propiedades
        List<Casilla> casillasMezcladas = new ArrayList<>();
        int cantCasillasNoPropiedad = cantCasillaLoteria + cantCasillaMulta + cantCasillaDePaso + cantEstaciones;
        int cantCasillasPropiedad = casillas.size() - cantCasillasNoPropiedad;
        int cantGrupos = cantGruposDeADos + cantGruposDeATres;
        for (int i = 0; i < cantCasillasNoPropiedad ; i++){
            casillasMezcladas.add(casillas.get(i));
        }
        Collections.shuffle(casillasMezcladas);
        for (int i = cantCasillasNoPropiedad; i < casillas.size(); i++){
            Casilla casillaPropiedad = casillas.get(i);
            int posicion = i - cantCasillasNoPropiedad ;
            casillasMezcladas.add(posicion,casillaPropiedad);
        }
        return casillas;
    }

    ///////////////////// METODOS PUBLICOS /////////////////////
    public List<Jugador> getJugadores(){
        return this.jugadores;
    }
    public Tablero getTablero(){
        return this.tablero;
    }

}

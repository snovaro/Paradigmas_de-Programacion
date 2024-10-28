# Inter-Lambda - Entrega

Trabajo práctico grupal de la materia Paradigmas de la Programación (TB025) - Cátedra Cano

**Consigna:** Ver en [Consigna.pdf](Consigna.pdf)

## Informe

Ver [Informe](Informe.pdf)

## Instalación de dependencias

### Versión de JDK

El proyecto utiliza OpenJDK 22.0.1, para verificar la version de java actual:
```bash
java -version
```
Si la version instalada no es 22 o superior, ejecuta los siguientes comandos:
```bash
sudo apt-get update
sudo apt-get install openjdk-22-jdk
```

### Versión de SDK

El proyecto utiliza scala-sdk-3.3.3, para verificar la version de scala actual:
```bash
scala -version
```
Si la version instalada no es  o superior, ejecuta los siguientes comandos:
```bash
sudo apt-get update
sudo apt-get install scala-sdk-3.3.3
```


### Maven  << CHEQUEAR SI USAMOS MAVEN O NO EN ESTE TP>>

El proyecto utiliza maven para simplificar y automatizar el proceso de compilación, gestión de dependencias y despliegue de aplicaciones. Verificar si está instalado:
```bash
mvn -v
```
Si maven no está instalado:
```bash
sudo apt-get update
sudo apt-get install maven
```

### Makefile

Para ejecutar el proyecto debe asegurarse que tiene instalado el programa **make**:
```bash
make --version
```
Si no se encuentra instalado, ejecutar los siguientes comandos:
```bash
sudo apt-get update
sudo apt-get install make
```

## Comandos
Para compilar el programa:
```c
make build
```
Para compilar y ejecutar el programa:
```c
make run
```
Para limpiar archivos compilados:
```c
make clean
```
**OBSERVACIÓN:** Para el correcto funcionamiento del comando debe estar posicionado en el directorio del proyecto _"./src"_

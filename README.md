# Introduction 
Esta es una aplicacion hecha con java 8 y spring boot con maven, actualmente contiene unos servicios rest que permiten crear un usuario y modificarlo, tiene un metodo para generacion de captcha, tiene un metodo para encriptacion de codigo, esto es apenas un inicio de lo que quiere llegar a ser, puesto que su principal objetivo es poder ser una aplicacion que evalue los algoritmos ingresados en pantalla correspondiente a unos enunciados propuestos, que pueda servir no solo como una ayuda pedagogica si no tambien un juez de programacion en linea.


# Getting Started
Para poder ejecutar y/o seguir con el desarrollo del aplicativo hay que tener en cuenta lo siguiente:
1.	Installation process
    -se debe tener instalado java 1.8 en la maquina localmente
    -se debe instalar un IDE de desarrollo java, para mi caso estoy usando eclipse oxygen, entonces para instalar las herramientas de spring voy a help y despues marketplace y le doy buscar spring tools y la instalo
    -despues de tener spring tools ya puedo desplegar el proyecto desde eclipse ya que el proyecto tiene embebido tomcat.
2.	Software dependencies
    -es obligatorio java 1.8. 
    -debe tener una base de datos de donde recuperar la informacion y estos datos de conexion deben de estar en el archivo .properties de spring
3.	Latest releases
    -N/A
4.	API references

# Test
  Para probar que todo funciona correctamente, clonamos el proyecto, lo importamos en el IDE como proyecto maven existente, 
  desplegamos el servidor, y probamos las url con un cliente apropiado, recomiendo postman de google chrome o jmeter para probar, en estos clientes
  ponemos por ejemplo http://localhost:8080/getUsers y en caso de que hayan datos deben de retornarlos corractamente.
  Es importante resaltar que la aplicacion apunta a una base de datos, entonces para que se pueda interactuar con la aplicacion debemos de contar con ella.
  En este mismo repositorio expongo la base de datos llamada ucompilerDatabase

# Build
En tiempo de desarrollo podemos utilizar el proyecto clonado y continuar con la construccion del software, para produccion generamos un ear o un war

# Contribute
Jorge Suaza
Edward Alexis Ortiz
Jorge Andres Maturana
Yuly Murillo


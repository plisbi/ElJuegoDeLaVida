ElJuegoDeLaVida
===============

Julia


Este proyecto de el Juego de la Vida consta de dos enum y cinco clases.

Los enum son Celula, que nos da el estado de las celulas 
y PatronesEnum, que contiene tanto los nombres como el array de celulas de cada patrón.

La primera clase es la de Inicio que es un frame en el que nos indica el nombre del juego,
un botón para comenzar (llama a la clase Selección) y otro por si queremos salir.

La segunda clase es la de Selección. Es un frame que nos da algunas opcciones con respecto
a qué queremos que nos muestre en el espacio celular. Una primera opcion nos muestra un espacio
celular con un tamaño fijo y un patrón de inicio aleatorio. 
La segunda opción "Crea tu propio espacio celular", nos deja elegir mediante dos slider
el tamaño del espacio celular. Y con dos botones te permite elegir si quieres dibujar tu
un patrón propio o si quieres que se genere automáticamente.
La tercera y última opcion te genera un patrón celular predeterminado,
al que llamamos "patrón". Se puede elegir entre varios patrones que son los que estén en
el enum PatronesEnum.
Una vez elegida cualquiera de estas tres opciones, esta ventana se cerrara llamando a otra ventana
llamada Ventana2.

Ventana2 es una clase que tambien nos crea una ventana.
Consta de dos partes un menu, que nos permitira realizar ciertas funciones con el espacio celular.
Y tambien volver a la ventana anterior (Seleccion) o salir.
Por otro lado contiene un Jpane que será la clase Panel1.

La clase Panel1 nos dibuja las celulas teniendo en cuenta los metodos que estan definidos
en la clase EspacioCelular. También crea un metodo que permite que la evolución de un EspacioCelular
pueda pararse y continuar (hilo).

La clase EspacioCelular incluye los enum de Celula dentro de una matriz dependiendo de los valores
que hayamos dado anteriormente, tanto de alto y ancho de la matriz como patrones. Y además decide
cual es el comportamiento de las celulas en la siguiente generación.


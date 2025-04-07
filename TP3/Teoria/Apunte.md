# Estructura de datos fundamentales - Unidad 3

## Crisis del software

## ¿Porque nace la ingeneria de softaware?
 La *crisis del software* fue el detonante que llevó al surgimiento de la *Ingeniería del Software* como disciplina formal. 
A partir de los años 1960 y 1970, quedó claro que el desarrollo de software no podía seguir siendo un proceso artesanal y ad hoc, sino que necesitaba métodos sistemáticos, técnicas estandarizadas y principios científicos para garantizar calidad, eficiencia y mantenibilidad.

## Arreglos
¿Como declarar un arreglo?
```java
elementType[] arrayName = {initialValue0, initialValue...}
```
Imagen de *Agregar*:
Desplazamiento de arreglo para ingresar un nuevo elemento. Se realiza con un ciclo

Imagen de *Extraer*
Eleminar un elemento, para eso tenemenos q decrementar el arreglo para rellenar el array, sin que quede vacio. Se realiza con un ciclo

*Ordenar un arreglo*
Se explica con la grafica de abajo
Tambien existen algoritmos para este tipos de casos de reordenamiento. Burble Sort, Selection Sort, InsertionSort (la que nos mostro el profe)
Mas eficientes: MergeSort (Lo usaremos en clase) y Quick Sort

¿Que metodos nos interesa a nosotros para trabajar en array?
*equals* en un arreglo compara las referencias de ambos arreglo no los elementos y devuelve un boolean si es true o falase. *Acordarse que un arreglo es una REFERENCIA*
*toString(A)* convierte un arreglo en un string(una cadena)
*sort(A)* me arregla un array
*binarySeach(A, x)* es un tipo de algoritmo que se divide en la mitad cada tras paso para encontrar un elemento

Arreglo bidimensional (Matriz)



### Arreglo dinamico (cambia el tamaño)
    




## Listas
### Listas simplemente enlazadas
de tal modo tiene referencia a una lista, y esta referencia de la lista es al comienzo de la lista, luego tiene un enlace al comienzo de la lista, en objetos como seria? seria como referencia por acceso a una direccion de memoria a otro direccion de memoria

#### ¿Para q sirve una lista?

para armar pilas, colas, etc.

#### ¿Que es mejor un array y lista?

depende del problema
### Listas doblemente enlazada

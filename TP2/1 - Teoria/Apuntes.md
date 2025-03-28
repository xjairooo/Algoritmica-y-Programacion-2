# Programación Orientada a Objetos (POO) - Guía Completa

## 📘 Capítulo 1: Introduccion de POO

### 🔍 Explicación
La POO organiza el código en **objetos** que contienen:
- **Atributos**: Datos del objeto (`private` por encapsulamiento)
- **Métodos**: Comportamientos/funciones
- **Constructores**: Inicializan objetos

### Objetivos clave
- **Robustez**: Manejar errores o entradas inesperadas.
- **Adaptabilidad**: Funcionar en diferentes entornos (ej: cambios de hardware). Osea que se pueda correr en distintas plataformas.
- **Reusabilidad**: Reutilizar código en distintos proyectos.

### 💻 Ejemplo: Clase `Persona`
```java
/**
 * Clase que representa un coche con sus características básicas.
 * Ejemplo didáctico de POO (encapsulamiento, métodos, constructor)
 */
public class Coche {
    
    // 🛡️ ATRIBUTOS PRIVADOS (Encapsulamiento)
    private String marca;
    private String modelo;
    private int velocidadActual;
    private boolean estaEncendido;
    
    // � CONSTRUCTOR (Inicializa el objeto)
    /**
     * Crea una instancia de Coche
     * @param marca Marca del coche (ej: "Toyota")
     * @param modelo Modelo del coche (ej: "Corolla")
     */
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = 0;  // Inicialmente detenido
        this.estaEncendido = false; // Apagado al crear
    }
    
    // � MÉTODOS PÚBLICOS (Comportamiento)
    
    /**
     * Enciende el motor del coche
     */
    public void encender() {
        this.estaEncendido = true;
        System.out.println("¡Motor encendido!");
    }
    
    /**
     * Acelera el coche aumentando su velocidad
     * @param incremento Cantidad de km/h a acelerar
     */
    public void acelerar(int incremento) {
        if (estaEncendido) {
            velocidadActual += incremento;
            System.out.println("Acelerando a " + velocidadActual + " km/h");
        } else {
            System.out.println("No se puede acelerar, el coche está apagado");
        }
    }
    
    /**
     * Muestra información del coche
     * @return Datos formateados del coche
     */
    public String obtenerInfo() {
        return marca + " " + modelo + 
               " | Velocidad: " + velocidadActual + 
               " | Estado: " + (estaEncendido ? "Encendido" : "Apagado");
    }
    
    // 🔮 Método principal para probar la clase
    public static void main(String[] args) {
        // Crear instancia (objeto)
        Coche miCoche = new Coche("Toyota", "Corolla");
        
        // Usar métodos
        System.out.println(miCoche.obtenerInfo());
        miCoche.encender();
        miCoche.acelerar(30);
        System.out.println(miCoche.obtenerInfo());
    }
} 
```
---

## 📘 Capítulo 2: Tipos Abstractos de Datos

### 1. Concepto de TAD

Un **Tipo Abstracto de Datos (TAD)** es un modelo teórico que define:

- **Datos**: El tipo de información que almacena
- **Operaciones**: Las acciones que pueden realizarse sobre esos datos
- **Comportamiento**: Cómo deben funcionar esas operaciones

Características principales:
- **Abstracción**: Oculta los detalles de implementación
- **Interfaz pública**: Operaciones visibles al usuario
- **Múltiples implementaciones**: Un mismo TAD puede implementarse de diferentes formas

### 2. Ejemplo: TAD Pila (Stack)

#### Operaciones clave:

| Operación | Descripción |
|-----------|-------------|
| `push()`  | Agrega un elemento en la parte superior (tope) , seria la interfaz publica|
| `pop()`   | Elimina y devuelve el elemento del tope |
| `peek()`  | Devuelve el elemento del tope sin eliminarlo |
| `isEmpty()`| Verifica si la pila está vacía |
| `size()`  | Devuelve el número de elementos |

#### Implementación en Java:

```java
public interface PilaTAD<T> {
    void push(T elemento);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}

public class PilaArrayList<T> implements PilaTAD<T> {
    private ArrayList<T> elementos = new ArrayList<>();
    
    public void push(T elemento) {
        elementos.add(elemento);
    }
    
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return elementos.remove(elementos.size()-1);
    }
    
    // ... otras operaciones ...
}
```

### 3. Ejemplo: TAD Cola (Queue)

#### Operaciones clave:

| Operación  | Descripción |
|------------|-------------|
| `enqueue()` | Agrega un elemento al final (cola) |
| `dequeue()` | Elimina y devuelve el primer elemento (frente) |
| `front()`   | Devuelve el primer elemento sin eliminarlo |
| `isEmpty()` | Verifica si la cola está vacía |
| `size()`    | Devuelve el número de elementos |

#### Implementación en Java:

```java
public interface ColaTAD<T> {
    void enqueue(T elemento);
    T dequeue();
    T front();
    boolean isEmpty();
    int size();
}
```
### 4. Ejemplo: TAD Lista (List)

#### Operaciones clave:
|Operación	| Descripción|
|-----------|------------|
|`add()` | Inserta un elemento en una posición|
|`remove()` |	Elimina un elemento de una posición|
|`get()` |	Obtiene un elemento de una posición|
|`set()` |	Modifica un elemento en una posición|
|`size()` |	Devuelve el número de elementos|
|`isEmpty()` |	Verifica si la lista está vacía|

### 5. Comparación de TADs comunes

| TAD   | Estructura                 | Orden de acceso                     | Operaciones típicas       |
|-------|----------------------------|-------------------------------------|---------------------------|
| Pila  | LIFO (Last-In-First-Out)   | Último en entrar, primero en salir  | push, pop, peek           |
| Cola  | FIFO (First-In-First-Out)  | Primero en entrar, primero en salir | enqueue, dequeue, front   |
| Lista | Secuencia ordenada         | Acceso por posición                 | add, remove, get, set     |

### 6. Beneficios de usar TADs

- **Encapsulamiento**: Oculta detalles de implementación
- **Reusabilidad**: Mismo TAD puede tener múltiples implementaciones
- **Mantenibilidad**: Facilita cambios en la implementación
- **Claridad**: Separa el "qué" del "cómo"

### 7. Ejemplo de uso

```java
public class Main {
    public static void main(String[] args) {
        // Usando el TAD Pila
        PilaTAD<Integer> pila = new PilaArrayList<>();
        pila.push(10);
        pila.push(20);
        System.out.println(pila.pop()); // 20
        
        // Usando el TAD Cola
        ColaTAD<String> cola = new ColaLinkedList<>();
        cola.enqueue("A");
        cola.enqueue("B");
        System.out.println(cola.dequeue()); // A
    }
}
```
### 8. Conclusion 
Los TADs son fundamentales en programación porque:

- Proporcionan abstracción sobre estructuras de datos

- Definen contratos claros de operaciones

- Permiten múltiples implementaciones

- Facilitan el desarrollo de software mantenible

En Java, los TADs se implementan típicamente usando interfaces y clases concretas.

### Definición de Encapsulamiento en POO

#### 🛡️ ¿Qué es el Encapsulamiento?

El **encapsulamiento** es uno de los 4 pilares fundamentales de la Programación Orientada a Objetos (POO) que consiste en:

1. **Ocultar** los detalles internos de implementación de una clase
2. **Proteger** los datos mediante modificadores de acceso
3. **Exponer** solo una interfaz controlada al exterior

#### 🔒 Características Clave

| Principio               | Descripción                                                                 |
|-------------------------|-----------------------------------------------------------------------------|
| **Protección de datos** | Los atributos se declaran como `private`                                    |
| **Acceso controlado**   | Se usan métodos públicos (`getters/setters`) para interactuar con los datos |
| **Autonomía**           | La clase gestiona su propio estado internamente                             |

#### 📌 Ejemplo en Java

```java
public class CuentaBancaria {
    // Atributos encapsulados (privados)
    private double saldo;
    private String titular;

    // Interfaz pública controlada
    public void depositar(double monto) {
        if(monto > 0) {
            this.saldo += monto;
        }
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.titular;
    }
}
```
## 📚 Capitulo 3: Lenguaje de modelado unificado/UnifiedModeling Language (UML)

•Un diagrama de clase tiene tres porciones.
1. El nombre de la clase
2. Las variables de instancia recomendadas
3. Los métodos de clases recomendados.

**Imagen dentro del PDF**

## 🏗️ Capitulo 4: Constructor

### 📚 ¿Qué es un Constructor?
Un **constructor** es un método especial que:
- ✅ Se ejecuta **automáticamente** al crear un objeto (`new Clase()`)
- ✅ **Inicializa** los atributos del objeto
- ✅ Tiene el **mismo nombre** que la clase
- ✅ **No tiene** tipo de retorno (ni `void`)

### 🛠️ Ejemplo Básico (Java)

```java
public class Coche {
    // Atributos
    private String marca;
    private String color;
    
    // Constructor
    public Coche(String marca, String color) {
        this.marca = marca;
        this.color = color;
        System.out.println("¡Coche creado!");
    }
    
    // Método normal
    public void acelerar() {
        System.out.println("Acelerando...");
    }
}

// Uso:
Coche miCoche = new Coche("Toyota", "Rojo"); 
// Output: "¡Coche creado!"
```
### Tipos de constructores
1. **Por defecto** (automatico si no hay otros)
```java
public Coche() {
    // Atributos quedan con valores por defecto
    // marca = null, color = null
}
```
2. **Con parametros** (el mas comun)
```java
public Coche(String m, String c) {
    marca = m;
    color = c;
}
```
3. **Copia** (clona otro objeto)
```java
public Coche(Coche otro) {
    this.marca = otro.marca;
    this.color = otro.color;
}
```
### 📌 Reglas Clave
- Puedes tener múltiples constructores (sobrecarga)

- Si defines cualquier constructor, Java ya no provee el por defecto

- Usa `this()` para llamar a otro constructor de la misma clase

## Capitulo 5: Herencia y Poli

** DIAGRAMA UML DE HERENCIA IMAGEN**
### 1. Herencia: 📦 → 📦📦
**"Los hijos heredan características de los padres"**

- Permite crear nuevas clases basadas en clases existentes
- La clase hija obtiene todos los campos y métodos de la padre
- Se usa `extends` en Java

**Ejemplo:**  
```java
class Animal {  // Padre
    void comer() { System.out.println("Comiendo..."); }
}

class Perro extends Animal {  // Hijo
    void ladrar() { System.out.println("Guau!"); }
}

// Uso:
Perro firulais = new Perro();
firulais.comer();  // Heredado de Animal
firulais.ladrar(); // Método propio
```
### 🎭 Polimorfismo en Java

#### 📌 Definición
**"Una interfaz, múltiples formas"**  
Permite que objetos de diferentes clases sean tratados como objetos de una clase padre común, pero manteniendo su comportamiento específico.

#### ✨ Características principales
- Objetos de subclases pueden tratarse como objetos de la superclase
- El mismo método se comporta diferente en cada subclase
- Se implementa mediante:
  - Sobreescritura de métodos (`@Override`)
  - Clases abstractas
  - Interfaces

#### 💻 Ejemplo práctico

```java
// Clase padre
class Animal {
    void hacerSonido() {
        System.out.println("...");
    }
}

// Subclases
class Gato extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Miau!");
    }
}

class Vaca extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("Muuu!");
    }
}

class Pollo extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("¡Pío pío!");
    }
}

// Uso polimórfico
public class Main {
    public static void main(String[] args) {
        Animal[] granja = {
            new Gato(),
            new Vaca(),
            new Pollo()
        };
        
        for (Animal animal : granja) {
            animal.hacerSonido
        }
    }
}     
```   
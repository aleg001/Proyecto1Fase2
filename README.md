# UVG 2021 <img src="https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif" width="30px">
## Algoritmos y Estructuras de Datos || Seccion 30
### Alejandro Gomez (20347), Ana Paola de Leon Molina (20361), Marco Antonio Jurado (20381)

El presente repositorio se creó como parte del proyecto numero 1 de Estructuras de Datos. Corresponde a un intérprete de LISP en Java. El trabajo realizado cumple 
con los siguientes requerimientos. En cuanto a la realizacion del interpréte, se optó por hacer que el usuario ingrese todo el código en una misma línea de
texto, como se presenta en el siguiente ejemplo:
```lisp
(defun factorial (n) (cond (eq n 0) (1) (* n (factorial (- n 1)))))

```
Se presenta a continuación algunos ejemplos de código funcional dentro del intérprete.


Casos aritméticos:
- [x] Suma 
```lisp 
(+ 5 3) 
```

- [x] Resta 
```lisp 
(- 3 1)
```

- [x] Multiplicacion 
```lisp 
(* 4 3) 
```

- [x] Division 
```lisp 
(/ 15 5)
```

Declaracion de variables
 
```lisp 
( defvar x 3)
```



Operaciones con variables 
- [x] Operaciones con números de 1 dígito.
```lisp 
( + x 2 )
```


Declaracion de funciones

- [x] Declarar y utilizar funciones
```lisp 
( defun resta ( a b ) ( - a b ) )
 ( resta ( 1 2 ) )
```

Predicados

- [x] ATOM 
```lisp 
( atom 2 )
```
- [x] LIST 
```lisp 
(list 1 2 3)
```
- [x] > 
```lisp 
(> 3 2)
```
- [x] < 
```lisp 
(< 4 2)
```
- [x] EQUALS 
```lisp 
(eq 0 1)
```
- [x] COND 
```lisp 
( cond ( eq 1 2 ) ( + 1 2 ) ( - 1 2 ) )
```

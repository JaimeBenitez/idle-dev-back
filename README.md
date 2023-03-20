# idle-dev-back
Backend del proyecto de fin de grado

## Cambios realizados con respecto a la rama anterior

**BASE DE DATOS**

-Nuevos datos

-Corregidos errores en algunas relaciones erroneas y añadidos algunos campos olvidados

- Cambiados los tipos de diversos campos de int-bigint a float

**CÓDIGO**

- Añadidos todos los repositorios

- Añadida la configuración del modelMapper

- Añadidos dtos de usuario, empresa, lenguaje y mejora

- Añadido control de errores 404

- Añadidos todos los controladores vacios

- Añadido Crud completo de empresa, estas son las empresas que el jugador podrá desbloquear en el juego


| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/empresas`                                | Muestra todas las empresas                                              | GET      |
|`/empresa/{id}`                            | Muestra una empresa concreta                                            | GET      |

**Empresa será solo de lectura, no se podrán modificar sus datos desde un cliente.**

- Añadido Crud completo de Mejora, estas son las mejoras para los diversos lenguajes que el jugador irá desbloqueando en el juego

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/mejoras`                                 | Muestra todas las mejoras                                               | GET      |
|`/mejora/{id}`                             | Muestra una mejora concreta                                             | GET      |
 
**Al igual que empresa, mejora sera solo de lectura y no podra ser modificada por el cliente**

- Añadido Crud completo de Lenguaje, estos son los generadores de recurso principales del juego y se irán desbloqueando a medida que se avance en el juego

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/lenguajes`                               | Muestra todos los lenguajes                                             | GET      |
|`/lenguaje/{id}`                           | Muestra un lenguaje concreto                                            | GET      |
|`/lenguaje/{id}/mejoras`                   | Muestra las mejoras de un lenguaje concreto                             | GET      |

**Nuevamente, al igual que empresa y mejora, estos seran datos solo de lectura**

- Añadido Crud completo de Usuario, estos son los datos de usuario y login

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/usuarios`                                | Muestra todos los usuarios(vendrá bien para una posible clasificación)  | GET      |
|`/usuario/{id}`                            | Muestra un usuario concreto                                             | GET      |
|`/usuario/{id}`                            | Añade un nuevo usuario(registro)                                        | POST     |
|`/usuario/{id}`                            | Actualiza los datos de un usuario(p.e. cambio contraseña)               | PUT      |

**Como en el resto de este proyecto, el delete no está contemplado en ningún CRUD**

## Por hacer

**BASE DE DATOS**


- Terminar de hacer ajustes en cuanto a los diversos constraints
- insertar todos los datos en las diversas tablas
- Hacer comprobaciones de que todos los tipos de cada campo se ajustan a lo necesario
- Si el campo JSON da demasiados problemas valorar la posibilidad de convertir dicho campo en una lista de mejoras, lo que crearia otra relación N:M entre trabajador y mejora

**CÓDIGO**

- EndPoint en lenguaje que permita sacar a los trabajadores de cada lenguaje, algo asi:

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/lenguaje/{id}/trabajadores`              | Muestra todos los trabajadores de un lenguaje concreto                  | GET      |


- Crud de Trabajador, estos son los que podrán conseguir las mejoras para los diversos lenguajes

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/trabajador`                              | Muestra todos los trabajadores                                          | GET      |
|`/trabajador/{id}`                         | Muestra un trabajador concreto                                          | GET      |
|`/trabajador/{id}`                         | Añade un nuevo trabajador                                               | POST     |
|`/trabajador/{id}`                         | Actualiza los datos de un usuario(p.e. las mejoras adquiridas)          | PUT      |

**NOTA: Las propiedades de los trabajadores serán generadas aleatoriamente al comprar uno**

- Crud Lenguaje_Partida, aqui se guardan los datos sobre los lenguajes que posee el jugador en su partida

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/lenguajePorPartida/{id}`                 | Crea un nuevo registro de lenguaje en una partida                       | POST     |
|`/lenguajePorPartida/{id}`                 | Actualiza la informacion de un lenguaje en una partida (Guardar Partida)| PUT      |

**En principio ninguna de las tablas intermedias tendra gets, ya que esa información se sacará directamente desde Partida mediante el uso de DTOs**


- Crud Empresa_Partida, aqui se guardan los datos sobre las empresas que posee el jugador en su partida

| Endpoint                                  | Resultado                                                               | Método   |
|------------------------------------------ |-------------------------------------------------------------------------|:--------:|
|`/empresaPorPartida/{id}`                  | Crea un nuevo registro de empresa en una partida                        | POST     |
|`/empresaPorPartida/{id}`                  | Actualiza la informacion de una empresa en una partida (Guardar partida)| PUT      |


- Crud Trabajador_Lenguaje, aqui se guardan los datos sobre los trabajadores que afectan a cada lenguaje

| Endpoint                                  | Resultado                                                                | Método   |
|------------------------------------------ |--------------------------------------------------------------------------|:--------:|
|`/trabajadorPorPartida/{id}`               | Crea un nuevo registro de trabajador en un lenguaje                      | POST     |
|`/trabajadorPorPartida/{id}`               | Actualiza la informacion de un trabajador en un lenguaje(Guardar partida)| PUT      |

**Al igual que en los 2 casos anteriores, no son necesarios GETs aqui ya que esta info se recuperará mediante DTO en la tabla de Lenguaje**

- Crud Partida, aqui se guardan todos los datos generales de la partida, ademas sirve de punto de union para toda la base de datos y aqui es donde se
usaran DTOs para recuperar todos los datos de la partida(Trabajadores obtenidos, lenguajes y empresas)


- Crud Lenguaje_Partida, aqui se guardan los datos sobre los lenguajes que posee el jugador en su partida

| Endpoint                                  | Resultado                                                                             | Método   |
|------------------------------------------ |---------------------------------------------------------------------------------------|:--------:|
|`/partida/{id}`                            | Aqui se recuperarán los datos de una partida, es aqui donde se usara el DTO completo  | GET      |
|`/partida/{id}`                            | Crea  los datos de una partida nueva                                                  | POST     |
|`/partida/{id}`                            | Actualiza la informacion de una partida(Guardar partida)                              | PUT      |

**En principio partida no tendrá un get de la lista completa ya que un posible leaderboard se haria desde la tabla usuario, aunque es algo aun a decidir**

- Resto de DTOs, servicios y recursos necesarios




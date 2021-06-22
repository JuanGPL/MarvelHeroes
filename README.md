# Marvel Heroes

La presente aplicación Android pretende satisfacer los requisitos indicados en el documento de la prueba técnica.

## Nota importante
Por seguridad se ha omitido el fichero `data/marvelApi.properties` que contiene las claves para poder hacer las peticiones a la API de Marvel.
Para compilar el proyecto es necesario añadirlo con las claves.
El fichero tiene la siguiente estructura:
```bash
publicKey="yourPublicKeyHere"
privateKey="yourPrivateKeyHere"
```

## Pantallas
### Splash
- Se ha utilizado MotionLayout para crear una animación del logotipo

### Listado de héroes
- La app muestra un listado de Heroes Marvel que se van solicitando más a medida que se va llegando al final del listado, puesto que la API los entrega mediante paginación. Se ha dejado la paginación por defecto (20 items por petición).
- Los items que no tienen suficiente información (el criterio seguido ha sido sin foto y sin descripción) no se ha permitido la navegación al detalle y se le ha añadido un mensaje de "Próximamente".
- Al pulsar un item se navega al detalle del héroe seleccionado.

### Detalle del héroe
- Se muestra una imagen en alta resolución, el nombre y cuatro pestañas (descripción, cómics, series e historias)
- Cada pestaña muestra un fragment con el contenido correspondiente, además el cambio de pestaña se puede hacer deslizando el dedo o bien tocando directamente en la pestaña.
- La animación del cambio de pantalla se ha hecho con ViewPager2.

## Arquitectura
- Se ha utilizado Clean Architecture, separando cada una de las capas en módulos independientes.
- La capa de presentación se ha desarrollado siguiendo el patrón MVVM.
- Para comunicar las distintas capas se ha usado Koin como librería de inyección de dependencias.

## Observaciones
- Se ha priorizado la legibilidad del código frente a la brevedad.
- Se ha evitado en la medida de lo posible la duplicidad de código.
- Se han hecho unit test de gran parte del código intentando comtemplar tanto casos de éxito como de error.
- El detalle del héroe se podía haber optimizado aprovechando la información cacheada de la lista, pues la respuesta de la petición del detalle es la misma que en la del listado. Se ha obviado por seguir el guión de la prueba y usar las dos peticiones.
- Se han añadido algunas peticiones adicionales para obtener todos los comics, series e historias en el detalle siguiendo la misma mecánica de recarga activa al llegar al final del scroll.

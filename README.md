# App Ventas - Aplicación Móvil Android

Esta es la aplicación móvil del Sistema de Ventas. Permite a los usuarios registrar una orden de venta (cabecera y detalle) mediante un formulario, enviando los datos a una API REST.

## Tecnologías utilizadas
* Java
* Android Studio
* Retrofit 2 (Consumo de API REST)
* Json (Conversión de JSON)

## Cómo ejecutar
1. Clona este repositorio y ábrelo en Android Studio.
2. Asegúrate de tener la API REST (Spring Boot) en ejecución.
3. En el archivo `network/RetrofitClient.java`, verifica que la `BASE_URL` apunte a la dirección correcta de tu API (por defecto usa `http://10.0.2.2:8080/` para emuladores).
4. Ejecuta la aplicación en un emulador o dispositivo físico.

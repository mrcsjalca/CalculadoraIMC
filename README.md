# BMI JetPack Composer

Calculadora de índice de masa corporal para Android, hecha con **Kotlin** y **Jetpack Compose**

## Captura del programa
<img width="332" height="747" alt="image" src="https://github.com/user-attachments/assets/23c3bbad-3e16-4dc1-9733-5000a3fb2185" />


## Qué hace

1. Pide un nombre.
2. Permite ajustar el peso (kg) con los botones **+** y **-**.
3. Permite ajustar la altura (100–250 cm) con un **Slider**.
4. Al pulsar **Calcular** muestra el BMI con 1 decimal.

Fórmula: `BMI = peso (kg) / altura (m)²`

## Tecnologías

- Kotlin
- Jetpack Compose
- Material 3 (`Card`, `OutlinedTextField`, `Button`, `Slider`)
- Android Studio

## Estructura

```
app/src/main/java/org/insbaixcamp/bmijetpackcomposer/
├── MainActivity.kt          # Activity + pantalla BMIScreen + Preview
└── ui/theme/
    ├── BMIStyles.kt         # Colores, formas y espaciados (el "CSS" del proyecto)
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

## Estilos

Compose no usa CSS. Los estilos se centralizan en el `object BMIStyles`:

| Propiedad | Uso |
|---|---|
| `Background` | Fondo de la pantalla |
| `Primary` | Botones y slider |
| `CardBackground` | Fondo de la tarjeta |
| `TextDark` | Color del texto |
| `CardShape` / `ButtonShape` | Esquinas redondeadas |
| `ScreenPadding` / `Spacing` | Márgenes y separación |

Para cambiar el aspecto, edita solo los valores de `BMIStyles.kt`.

## Cómo ejecutarlo

1. Clona el repositorio y ábrelo en Android Studio.
2. Espera a que termine la sincronización de Gradle.
3. Elige un emulador (por ejemplo *Medium Phone*) o un móvil conectado.
4. Pulsa **Run** ▶.

Para ver la pantalla sin ejecutar, abre `MainActivity.kt` en modo **Split** y revisa `BMIScreenPreview`.


package nelson.rsfred.hubapp.ui.theme

import androidx.compose.ui.graphics.Color
import nelson.rsfred.hubapp.ui.theme.Palette

// Background is the vivid orange itself (#FC9500), not a darkened/desaturated version of it.
// Cards and panels (surfaceContainer*) are rendered in near-white/cream so they read as
// clearly distinct "floating" elements on the orange canvas, instead of risking blending
// into it with another shade of orange. Buttons and text use a dark near-black for contrast
// against both the orange background and the light cards.
val AppPalette = Palette(
    primary = Color(0xFF1A0F00),
    onPrimary = Color(0xFFFFE8C2),
    primaryContainer = Color(0xFFFFCE85),
    onPrimaryContainer = Color(0xFF1A0F00),

    secondary = Color(0xFFD35400),
    onSecondary = Color(0xFF1A0F00),
    secondaryContainer = Color(0xFFFFE8C2),
    onSecondaryContainer = Color(0xFF1A0F00),

    tertiary = Color(0xFFFDC300),
    onTertiary = Color(0xFF1A0F00),
    tertiaryContainer = Color(0xFFFFF3E0),
    onTertiaryContainer = Color(0xFF1A0F00),

    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),

    background = Color(0xFFFC9500),
    onBackground = Color(0xFF1A0F00),

    surface = Color(0xFFFC9500),
    onSurface = Color(0xFF1A0F00),

    surfaceVariant = Color(0xFFFFDCA3),
    onSurfaceVariant = Color(0xFF4A2E12),

    surfaceTint = Color(0xFF1A0F00),
    surfaceDim = Color(0xFFFC9500),
    surfaceBright = Color(0xFFFFFFFF),

    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFFFF3E0),
    surfaceContainer = Color(0xFFFFE8C2),
    surfaceContainerHigh = Color(0xFFFFDCA3),
    surfaceContainerHighest = Color(0xFFFFCE85),

    outline = Color(0xFFC98A3E),
    outlineVariant = Color(0xFFFFDCA3),

    inverseSurface = Color(0xFF1A0F00),
    inverseOnSurface = Color(0xFFFFE8C2),
    inversePrimary = Color(0xFFFC9500),

    scrim = Color(0xFF000000),
)

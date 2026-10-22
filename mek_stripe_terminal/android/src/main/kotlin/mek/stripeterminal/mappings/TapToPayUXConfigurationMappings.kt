package mek.stripeterminal.mappings

import TapToPayUxConfigurationApi
import com.stripe.stripeterminal.external.models.TapToPayUxConfiguration
import TapToPayUxConfigurationColorSchemeApi
import TapToPayUxConfigurationTapZoneApi
import TapToPayUxConfigurationTapZoneIndicatorApi
import TapToPayUxConfigurationDarkModeApi


fun TapToPayUxConfigurationApi.toHost(): TapToPayUxConfiguration {
    val builder = TapToPayUxConfiguration.Builder();
    if (tapZone != null) builder.tapZone(tapZone.toHost())
    if (colors != null) builder.colorScheme(colors.toHost())
    if (darkMode != null) builder.theme(darkMode.toHost())
    return builder.build()
}

fun TapToPayUxConfigurationTapZoneApi.toHost(): TapToPayUxConfiguration.TapZone {
    val xBias = position?.xBias?.toFloat()
    val yBias = position?.yBias?.toFloat()
    return when (indicator) {
        TapToPayUxConfigurationTapZoneIndicatorApi.LEFT ->
            if (yBias != null) TapToPayUxConfiguration.TapZone.Left(yBias)
            else TapToPayUxConfiguration.TapZone.Left()
        TapToPayUxConfigurationTapZoneIndicatorApi.RIGHT ->
            if (yBias != null) TapToPayUxConfiguration.TapZone.Right(yBias)
            else TapToPayUxConfiguration.TapZone.Right()
        TapToPayUxConfigurationTapZoneIndicatorApi.ABOVE ->
            if (xBias != null) TapToPayUxConfiguration.TapZone.Above(xBias)
            else TapToPayUxConfiguration.TapZone.Above()
        TapToPayUxConfigurationTapZoneIndicatorApi.BELOW ->
            if (xBias != null) TapToPayUxConfiguration.TapZone.Below(xBias)
            else TapToPayUxConfiguration.TapZone.Below()
        TapToPayUxConfigurationTapZoneIndicatorApi.FRONT ->
            if (xBias != null && yBias != null) TapToPayUxConfiguration.TapZone.Front(xBias, yBias)
            else TapToPayUxConfiguration.TapZone.Front()
        TapToPayUxConfigurationTapZoneIndicatorApi.BEHIND ->
            if (xBias != null && yBias != null) TapToPayUxConfiguration.TapZone.Behind(xBias, yBias)
            else TapToPayUxConfiguration.TapZone.Behind()
        null -> TapToPayUxConfiguration.TapZone.Default
    }
}

fun TapToPayUxConfigurationColorSchemeApi.toHost(): TapToPayUxConfiguration.ColorScheme {
    val builder = TapToPayUxConfiguration.ColorScheme.Builder()
    if (primary != null) builder.primary(TapToPayUxConfiguration.Color.Value(primary.toInt()))
    if (success != null) builder.success(TapToPayUxConfiguration.Color.Value(success.toInt()))
    if (error != null) builder.primary(TapToPayUxConfiguration.Color.Value(error.toInt()))
    return builder.build()
}

fun TapToPayUxConfigurationDarkModeApi.toHost(): TapToPayUxConfiguration.Theme {
    return when (this) {
        TapToPayUxConfigurationDarkModeApi.SYSTEM -> TapToPayUxConfiguration.Theme.SYSTEM
        TapToPayUxConfigurationDarkModeApi.LIGHT -> TapToPayUxConfiguration.Theme.LIGHT
        TapToPayUxConfigurationDarkModeApi.DARK -> TapToPayUxConfiguration.Theme.DARK
    }
}

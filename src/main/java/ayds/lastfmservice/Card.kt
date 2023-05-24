package ayds.lastfmservice

sealed class Card {
    data class LastFMCard(
        val name: String,
        val info: String,
        val url: String,
        val source: Int,
        val sourceLogoUrl: String,
        var isLocallyStored: Boolean = false
    ) : Card()

    object EmptyCard : Card()
}


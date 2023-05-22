package ayds.lastfmservice

sealed class Artist {
    data class LastFMArtist(
        val name: String,
        val info: String,
        val url: String,
        val source: Int,
        var isLocallyStored: Boolean = false
    ) : Artist()

    object EmptyArtist : Artist()
}


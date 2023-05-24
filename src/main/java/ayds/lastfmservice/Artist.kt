package ayds.lastfmservice

sealed class Artist {
    data class LastFMArtist(
        val name: String,
        val info: String,
        val url: String,
    ) : Artist()

}


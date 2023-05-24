package ayds.lastfmservice

const val URL_IMAGE_LASTFM = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

sealed class Artist {
    data class LastFMArtist(
        val name: String,
        val info: String,
        val url: String,
        val urlImageLastFM: String = URL_IMAGE_LASTFM
    ) : Artist()

}


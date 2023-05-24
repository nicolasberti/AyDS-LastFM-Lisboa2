package ayds.lastfmservice

import retrofit2.Response

interface ArtistService {
    fun getArtist(artist: String): Artist.LastFMArtist?
}

internal class ArtistServiceImpl(
    private val lastFMAPI: LastFMAPI,
    private val lastFMToArtistResolver: LastFMToArtistResolver
): ArtistService {
    override fun getArtist(artist: String): Artist.LastFMArtist? {
        val callResponse = getSongFromService(artist)
        return lastFMToArtistResolver.getArtistFromExternalData(callResponse.body())
    }

    private fun getSongFromService(artistName: String): Response<String> {
        return lastFMAPI.getArtistInfo(artistName).execute()
    }
}
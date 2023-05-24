package ayds.lastfmservice

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val LASTFM_URL = "https://ws.audioscrobbler.com/2.0/"

object LastFMInjector {

    private lateinit var lastFMAPI: LastFMAPI
    private lateinit var lastFMToArtistResolver: LastFMToArtistResolver
    private lateinit var artistService: ArtistService

    fun getService(): ArtistService {
        initializeLastFMService()
        return artistService
    }

    private fun initializeLastFMService() {
        lastFMAPI = getLastFMAPI()
        lastFMToArtistResolver = JsonToArtistResolver()
        artistService =
            ArtistServiceImpl(lastFMAPI, lastFMToArtistResolver)
    }

    private fun getLastFMAPI(): LastFMAPI {
        return Retrofit.Builder()
            .baseUrl(LASTFM_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(LastFMAPI::class.java)
    }


}
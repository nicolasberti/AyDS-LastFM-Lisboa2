package ayds.lastfmservice.external

import ayds.lastfmservice.Card
import com.google.gson.Gson
import com.google.gson.JsonObject

interface LastFMToArtistResolver {
    fun getArtistFromExternalData(serviceData: String?): Card.LastFMCard?
}

private const val JSON_ARTIST = "artist"
private const val ARTIST_NAME = "name"
private const val ARTIST_BIO = "bio"
private const val ARTIST_BIO_CONTENT = "content"
private const val ARTIST_SOURCE = "url"

class JsonToArtistResolver : LastFMToArtistResolver {

    override fun getArtistFromExternalData(serviceData: String?): Card.LastFMCard? {
        return serviceData?.getArtist()?.let { item ->
            Card.LastFMCard(
                item.getName(),
                item.getBioContent(),
                item.getUrl(),
                1
            )
        }
    }

    private fun String?.getArtist(): JsonObject {
        val jsonServiceData = Gson().fromJson(this, JsonObject::class.java)
        val jsonArtist = jsonServiceData[JSON_ARTIST]
        return jsonArtist.asJsonObject
    }

    private fun JsonObject.getBioContent(): String {
        val artistBio = this[ayds.lastfmservice.external.ARTIST_BIO].asJsonObject
        val artistBioContent = artistBio[ayds.lastfmservice.external.ARTIST_BIO_CONTENT]
        return artistBioContent.asString
    }

    private fun JsonObject.getUrl(): String {
        val artistUrl = this[ayds.lastfmservice.external.ARTIST_SOURCE]
        return artistUrl.asString
    }

    private fun JsonObject.getName(): String {
        val artistName = this[ayds.lastfmservice.external.ARTIST_NAME]
        return artistName.asString
    }


}
# LastFMService (Lisboa2)

¿Cómo utilizar el submódulo?

1. Importar el injector y la clase que brinda el servicio.
```
import ayds.lastfmservice.LastFMInjector
import ayds.lastfmservice.ArtistService
```

2. Solicitarle al injector la instancia de la clase. Este devolverá una instancia de "ArtistService"

```
artistService = LastFMInjector.getService();
```

3. Utilizar la única función de la clase
```
@artist: nombre del artista
getArtist(artist: String): Artist.LastFMArtist?
```
La función devolverá un objeto de tipo LastFMArtist en caso de encontrar en la API dicho artista o null en caso de no encontrarlo.

La clase LastFMArtist tiene los siguientes atributos:
```
name: String -> Nombre del artista
info: String -> Biografía del artista
url: String -> URL del artitulo de LastFM sobre el artista
```
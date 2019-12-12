package org.superbiz.moviefun.albumsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private String albumsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumUrl, RestOperations restOperations) {
        this.albumsUrl = albumUrl;

        this.restOperations = restOperations;
    }


    public void addAlbum(AlbumInfo album) {

        restOperations.postForEntity(albumsUrl, album, null, AlbumInfo.class);

    }


    public AlbumInfo find(long id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl + "/"+ id);

        logger.info("Calling URL {} using reference {}" , builder.toUriString(), id);

        return restOperations.getForObject(builder.toUriString(), AlbumInfo.class);


    }

    public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }


}

package org.superbiz.moviefun.albumsapi;

public class AlbumInfo {

    private Long id;

    private String artist;
    private String title;
    private int year;
    private int rating;

    public AlbumInfo() {
    }
    public AlbumInfo(String artist, String title, int year, int rating) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean hasId() {
        return id != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumInfo)) return false;

        AlbumInfo albumInfo = (AlbumInfo) o;

        if (getYear() != albumInfo.getYear()) return false;
        if (getArtist() != null ? !getArtist().equals(albumInfo.getArtist()) : albumInfo.getArtist() != null)
            return false;
        return getTitle() != null ? getTitle().equals(albumInfo.getTitle()) : albumInfo.getTitle() == null;
    }

    @Override
    public int hashCode() {
        int result = getArtist() != null ? getArtist().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getYear();
        return result;
    }

    @Override
    public String toString() {
        return "AlbumInfo{" +
              ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}

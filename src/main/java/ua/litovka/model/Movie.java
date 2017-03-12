package ua.litovka.model;

/**
 * Created by SergLion on 21.02.2017.
 */
public class Movie extends Entity<Integer> {
    private String title;
    private String description;
    private Long duration;

    public Movie(String title, String description, Long duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        if (!super.equals(o)) return false;

        Movie movie = (Movie) o;

        if (getTitle() != null ? !getTitle().equals(movie.getTitle()) : movie.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(movie.getDescription()) : movie.getDescription() != null)
            return false;
        return getDuration() != null ? getDuration().equals(movie.getDuration()) : movie.getDuration() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                "} ";
    }
}

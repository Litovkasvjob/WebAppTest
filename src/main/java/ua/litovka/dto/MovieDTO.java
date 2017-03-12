package ua.litovka.dto;


import ua.litovka.model.Entity;

/**
 * Created by SergLion on 22.02.2017.
 */
public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private long duration;

    public MovieDTO() {
    }

    public MovieDTO(String title, String description, long duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieDTO)) return false;
        if (!super.equals(o)) return false;

        MovieDTO movieDTO = (MovieDTO) o;

        if (getDuration() != movieDTO.getDuration()) return false;
        if (getTitle() != null ? !getTitle().equals(movieDTO.getTitle()) : movieDTO.getTitle() != null) return false;
        return getDescription() != null ? getDescription().equals(movieDTO.getDescription()) : movieDTO.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (int) (getDuration() ^ (getDuration() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                "} " ;
    }
}


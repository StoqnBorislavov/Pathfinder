package pathfinder.model.entity;

import pathfinder.model.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    private String gpxCoordinates;
    private LevelEnum levelEnum;
    private String description;
    private String name;
    private User author;
    private String videoUrl;
    private Set<Category> categories;

    public Route() {
    }

    @Column(columnDefinition = "LONGTEXT")
    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "level_enum")
    @Enumerated(EnumType.STRING)
    public LevelEnum getLevelEnum() {
        return levelEnum;
    }

    public Route setLevelEnum(LevelEnum level) {
        this.levelEnum = level;
        return this;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}

package pathfinder.model.service;

import pathfinder.model.entity.Category;
import pathfinder.model.entity.Picture;
import pathfinder.model.entity.User;
import pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

public class RouteSerivceModel {

    private Long id;
    private String gpxCoordinates;
    private LevelEnum level;
    private String description;
    private String name;
    private User author;
    private String videoUrl;
    private Set<Category> categories;
    private Set<Picture> pictures;

    public RouteSerivceModel() {
    }

    public Long getId() {
        return id;
    }

    public RouteSerivceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteSerivceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteSerivceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteSerivceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteSerivceModel setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public RouteSerivceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteSerivceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public RouteSerivceModel setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public RouteSerivceModel setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }
}

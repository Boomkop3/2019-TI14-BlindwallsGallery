package com.appsfromholland.blindwallsgallery;

public class Mural {
    private String author;
    private String description;
    private String imageUrl;

    public Mural(String author, String description, String imageUrl) {
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Mural{" +
                "author='" + author + '\'' +
                '}';
    }
}

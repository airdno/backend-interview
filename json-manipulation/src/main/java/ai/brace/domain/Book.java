package ai.brace.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Book implements Cloneable {
    Map<String, Object> map;

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("uuid")
    @Expose
    private UUID uuid;
    @SerializedName("lastModified")
    @Expose
    private Double lastModified;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("translator")
    @Expose
    private String translator;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("textArray")
    @Expose
    private List<TextArray> textArray;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Double getLastModified() {
        return lastModified;
    }

    public void setLastModified(Double lastModified) {
        this.lastModified = lastModified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<TextArray> getTextArray() {
        return textArray;
    }

    public void setTextArray(List<TextArray> textArray) {
        Collections.sort(textArray);
        this.textArray = textArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return uuid.equals(book.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public Book copy() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}

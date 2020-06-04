package ai.brace.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TextArray implements Comparable<TextArray> {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("textdata")
    @Expose
    private String textdata;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TextArray withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTextdata() {
        return textdata;
    }

    public void setTextdata(String textdata) {
        this.textdata = textdata;
    }

    public TextArray withTextdata(String textdata) {
        this.textdata = textdata;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextArray textArray = (TextArray) o;
        return id.equals(textArray.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(TextArray o) {
        return getId().compareTo(o.getId());
    }
}

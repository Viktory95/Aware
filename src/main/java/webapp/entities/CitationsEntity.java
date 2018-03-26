package webapp.entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "citations", schema = "aware_schema", catalog = "postgres")
public class CitationsEntity {
    private long citationId;
    private String text;
    private BigInteger popularity;
    private String name;
    private long userId;
    private long likes;
    private long dislikes;

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "citation_id", nullable = false)
    public long getCitationId() {
        return citationId;
    }

    public void setCitationId(long citation_id) {
        this.citationId = citation_id;
    }

    @Basic
    @Column(name = "text", nullable = false, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "popularity", nullable = true, precision = 0)
    public BigInteger getPopularity() {
        return popularity;
    }

    public void setPopularity(BigInteger popularity) {
        this.popularity = popularity;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitationsEntity that = (CitationsEntity) o;

        if (citationId != that.citationId) return false;
        if (userId != that.userId) return false;
        if (likes != that.likes) return false;
        if (dislikes != that.dislikes) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (text != null ? !name.equals(that.name) : that.name != null) return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (citationId ^ (citationId >>> 32));
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (likes ^ (likes >>> 32));
        result = 31 * result + (int) (dislikes ^ (dislikes >>> 32));
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CitationsEntity{" +
                "citationId=" + citationId +
                ", text='" + text + '\'' +
                ", popularity=" + popularity +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }
}

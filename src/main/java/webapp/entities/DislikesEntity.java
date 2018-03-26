package webapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "dislikes", schema = "aware_schema", catalog = "postgres")
public class DislikesEntity {
    private long dislikeId;
    private long userId;
    private long citationId;

    @Id
    @Column(name = "dislike_id", nullable = false)
    public long getDislikeId() {
        return dislikeId;
    }

    public void setDislikeId(long dislikeId) {
        this.dislikeId = dislikeId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "citation_id", nullable = false)
    public long getCitationId() {
        return citationId;
    }

    public void setCitationId(long citationId) {
        this.citationId = citationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DislikesEntity that = (DislikesEntity) o;

        if (dislikeId != that.dislikeId) return false;
        if (userId != that.userId) return false;
        if (citationId != that.citationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (dislikeId ^ (dislikeId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (citationId ^ (citationId >>> 32));
        return result;
    }
}

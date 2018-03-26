package webapp.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "likes", schema = "aware_schema", catalog = "postgres")
public class LikesEntity {
    private long likeId;
    private long userId;
    private long citationId;

    @Basic
    @Column(name = "like_id", nullable = false)
    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
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

        LikesEntity that = (LikesEntity) o;

        //if (likeId != that.likeId) return false;
        if (userId != that.userId) return false;
        if (citationId != that.citationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (likeId ^ (likeId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (citationId ^ (citationId >>> 32));
        return result;
    }
}

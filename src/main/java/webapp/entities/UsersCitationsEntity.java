package webapp.entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "users_citations", schema = "aware_schema", catalog = "postgres")
public class UsersCitationsEntity {
    private long citationUserId;
    private long userId;
    private long citationId;
    private BigInteger like;
    private BigInteger shared;

    @Id
    @Column(name = "citation_user_id", nullable = false)
    public long getCitationUserId() {
        return citationUserId;
    }

    public void setCitationUserId(long citation_user_id) {
        this.citationUserId = citation_user_id;
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

    @Basic
    @Column(name = "like", nullable = true, precision = 0)
    public BigInteger getLike() {
        return like;
    }

    public void setLike(BigInteger like) {
        this.like = like;
    }

    @Basic
    @Column(name = "shared", nullable = true, precision = 0)
    public BigInteger getShared() {
        return shared;
    }

    public void setShared(BigInteger shared) {
        this.shared = shared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersCitationsEntity that = (UsersCitationsEntity) o;

        if (citationUserId != that.citationUserId) return false;
        if (userId != that.userId) return false;
        if (citationId != that.citationId) return false;
        if (like != null ? !like.equals(that.like) : that.like != null) return false;
        if (shared != null ? !shared.equals(that.shared) : that.shared != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (citationUserId ^ (citationUserId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (citationId ^ (citationId >>> 32));
        result = 31 * result + (like != null ? like.hashCode() : 0);
        result = 31 * result + (shared != null ? shared.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UsersCitationsEntity{" +
                "citationUserId=" + citationUserId +
                ", userId=" + userId +
                ", citationId=" + citationId +
                ", like=" + like +
                ", shared=" + shared +
                '}';
    }
}

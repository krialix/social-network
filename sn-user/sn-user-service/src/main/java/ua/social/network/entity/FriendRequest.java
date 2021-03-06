package ua.social.network.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mykola Yashchenko
 */
@Getter
@Setter
@Entity
@Table(name = "friend_requests", uniqueConstraints = {
        @UniqueConstraint(name = "uc_users_unique_from_to", columnNames = { "from_id", "to_id" }),
        @UniqueConstraint(name = "uc_users_unique_to_from", columnNames = { "to_id", "from_id" })
})
@Immutable
public class FriendRequest extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "from_id", nullable = false)
    private User from;

    @ManyToOne(optional = false)
    @JoinColumn(name = "to_id", nullable = false)
    private User to;

}

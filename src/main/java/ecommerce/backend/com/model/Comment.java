package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Lob
    @Column(name = "content", nullable = false, length = 65535)
    private String content;

    @Column(name = "createTime", nullable = false, length = 19)
    private Timestamp createTime;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "commentParent")
    private List<Comment> commentList;

    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment commentParent;

    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}

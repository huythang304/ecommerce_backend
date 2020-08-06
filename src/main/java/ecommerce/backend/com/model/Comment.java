package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "comment")
@Data
@NoArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Lob
    @Column(name = "content", nullable = false, length = 65535)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "createTime", nullable = false, length = 19)
    private Date createTime;

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

package ecommerce.backend.com.model;

import ecommerce.backend.com.util.DateUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "category", uniqueConstraints = { @UniqueConstraint(columnNames = "name"),
        @UniqueConstraint(columnNames = "metaTitle") })
@Data
@NoArgsConstructor
public class Category implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 150)
    @NotBlank(message = "Tên Thể Loại không được để trống")
    private String name;

    @Column(name = "metaTitle", unique = true, nullable = false, length = 150)
    private String metaTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Category categoryParent;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "createTime", length = 19)
    private Date createTime;

    @Column(name = "status")
    private Integer status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryParent")
    private List<Category> categoryList;

    @PrePersist
    public void prePersist() {
        if (createTime == null) {
            createTime = DateUtils.getCurrentDate();
        }
        if (status == null) {
            status = 1;
        }
    }
}

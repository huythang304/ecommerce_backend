package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "product", uniqueConstraints = {})
@Data
@NoArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "createTime", length = 19)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "updateTime", length = 19)
    private Date updateTime;

    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @Column(name = "status")
    private Integer status;
}

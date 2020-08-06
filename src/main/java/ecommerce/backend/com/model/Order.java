package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "order")
@Data
@NoArgsConstructor
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Lob
    @Column(name = "address", nullable = false, length = 65535)
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "createTime", nullable = false, length = 19)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "cancelledTime", length = 19)
    private Date cancelledTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "confirmTime", length = 19)
    private Date confirmTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "shippedTime", length = 19)
    private Date shippedTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "payTime", length = 19)
    private Date payTime;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "completeTime", length = 19)
    private Date completeTime;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}

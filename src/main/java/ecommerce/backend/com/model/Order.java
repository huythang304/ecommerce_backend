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

    @Column(name = "createTime", nullable = false, length = 19)
    private Timestamp createTime;

    @Column(name = "cancelledTime", length = 19)
    private Timestamp cancelledTime;

    @Column(name = "confirmTime", length = 19)
    private Timestamp confirmTime;

    @Column(name = "shipped_time", length = 19)
    private Timestamp shippedTime;

    @Column(name = "payTime", length = 19)
    private Timestamp payTime;

    @Column(name = "completeTime", length = 19)
    private Timestamp completeTime;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}

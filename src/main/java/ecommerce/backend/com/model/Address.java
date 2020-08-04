package ecommerce.backend.com.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "address", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Lob
    @Column(name = "address", nullable = false, length = 65535)
    private String address;

    @Column(name = "logistics_status", nullable = false)
    private boolean logisticsStatus;

    @Column(name = "status", nullable = false)
    private boolean status;

    @JoinColumn(name = "wardId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Ward ward;

    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User user;
}

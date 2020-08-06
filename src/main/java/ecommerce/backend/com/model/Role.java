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
@Table(name = "role", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
@NoArgsConstructor
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

}
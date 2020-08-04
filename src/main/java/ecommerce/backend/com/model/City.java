package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "code", length = 20)
    private String code;

    @OneToMany(mappedBy = "city")
    private List<District> districtList;
}

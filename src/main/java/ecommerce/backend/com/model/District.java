package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Entity
@Table(name = "district")
@Data
@NoArgsConstructor
public class District implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "prefix", length = 20)
    private String prefix;

    @JoinColumn(name = "cityId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private City city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private List<Ward> wardList;
}

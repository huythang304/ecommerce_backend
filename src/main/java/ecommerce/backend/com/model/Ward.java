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
@Table(name = "ward")
@Data
@NoArgsConstructor
public class Ward implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "prefix", length = 20)
    private String prefix;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ward")
    private List<Address> addressList;

    @JoinColumn(name = "districtId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;
}

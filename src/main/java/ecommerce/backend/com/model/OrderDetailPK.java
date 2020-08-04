package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Embeddable
@Data
@NoArgsConstructor
public class OrderDetailPK implements java.io.Serializable {

    @Column(name = "orderId", nullable = false)
    private long orderId;

    @Column(name = "productId", nullable = false)
    private long productId;
}

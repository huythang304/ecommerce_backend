package ecommerce.backend.com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */

@Embeddable
@Data
@NoArgsConstructor
public class OrderDetailPK implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "orderId", nullable = false)
    private long orderId;

    @Column(name = "productId", nullable = false)
    private long productId;
}

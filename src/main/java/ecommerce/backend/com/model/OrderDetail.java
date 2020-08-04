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
@Table(name = "order_detail")
@Data
@NoArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "orderId", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "productId", nullable = false)) })
    protected OrderDetailPK orderDetailPK;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false, precision = 10, scale = 0)
    private long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false, insertable = false, updatable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false, insertable = false, updatable = false)
    private Product product;
}

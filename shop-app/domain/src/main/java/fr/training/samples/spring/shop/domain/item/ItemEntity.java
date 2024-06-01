package fr.training.samples.spring.shop.domain.item;

import java.util.Set;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * @author Badr NASS
 *
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity extends AbstractBaseEntity {

    /**
     * itemVO of type ItemVO
     */
    @Valid
	@Embedded
    private ItemVO itemVO;

    /**
	 * orders of type Set<OrderEntity>
	 */
	@ManyToMany(mappedBy = "items")
	private Set<OrderEntity> orders;

    /**
     * 
     */
    public ItemEntity() {
        super();
    }

    /**
     * @param itemVO
     */
    public ItemEntity(final ItemVO itemVO) {
        this.itemVO = itemVO;
    }


	public ItemEntity(String id) {
		this.id = id;
	}

	/**
	 * @return
	 */
    public ItemVO getItemVO() {
        return itemVO;
    }

    /**
     * @return
     */
	public Set<OrderEntity> getOrders() {
        return orders;
    }

    /**
     * @param itemVO
     */
    public void setItemVO(final ItemVO itemVO) {
        this.itemVO = itemVO;
    }

    /**
     * @param orders
     */
	public void setOrders(final Set<OrderEntity> orders) {
        this.orders = orders;
    }
}

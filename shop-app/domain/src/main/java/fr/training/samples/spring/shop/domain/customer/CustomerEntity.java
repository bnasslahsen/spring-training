package fr.training.samples.spring.shop.domain.customer;

import java.util.Set;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.order.OrderEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

/**
 * @author Badr NASS
 *
 */
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity extends AbstractBaseEntity {

    /**
     * customerVO of type CustomerVO
     */
    @Valid
	@Embedded
    private CustomerVO customerVO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<OrderEntity> orders;

    /**
     * 
     */
    public CustomerEntity() {
        super();
    }

    /**
     * @param customerVO
     */
    public CustomerEntity(final CustomerVO customerVO) {
        this.customerVO = customerVO;
    }

    /**
     * @return
     */
    public CustomerVO getCustomerVO() {
        return customerVO;
    }

    /**
     * @param customerVO
     */
    public void setCustomerVO(final CustomerVO customerVO) {
        this.customerVO = customerVO;
    }


	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
    public String toString() {
        return "CustomerEntity [customerVO=" + customerVO + ", toString()=" + super.toString() + "]";
    }


}
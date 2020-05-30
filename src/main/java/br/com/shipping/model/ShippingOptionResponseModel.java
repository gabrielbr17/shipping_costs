package br.com.shipping.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ShippingOptionResponseModel {

	private String name;
	private String type;
	private BigDecimal cost;
	private LocalDateTime estimated_date;

	public ShippingOptionResponseModel(ShippingOptionModel shippingOptionModel) {
		this.name = shippingOptionModel.getName();
		this.type = shippingOptionModel.getType();
		this.cost = shippingOptionModel.getCost();
		this.estimated_date = shippingOptionModel.getEstimatedWithDate();
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public LocalDateTime getEstimated_date() {
		return estimated_date;
	}

	public static List<ShippingOptionResponseModel> converter(List<ShippingOptionModel> shippingOptionResponseModel) {
		return shippingOptionResponseModel.stream().map(ShippingOptionResponseModel::new).collect(Collectors.toList());
	}

}

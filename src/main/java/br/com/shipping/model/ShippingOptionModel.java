package br.com.shipping.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.shipping.util.ShippingUtil;

public class ShippingOptionModel {

	private String name;
	private String type;
	private BigDecimal cost;
	
	@JsonProperty("estimated_days")
	private Integer estimatedDays;

	public ShippingOptionModel() {
	}

	public ShippingOptionModel(String name, String type, BigDecimal cost, Integer estimatedDays) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.estimatedDays = estimatedDays;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getEstimatedDays() {
		return estimatedDays;
	}

	public void setEstimatedDays(Integer estimatedDays) {
		this.estimatedDays = estimatedDays;
	}

	public LocalDateTime getEstimatedWithDate() {
		return new ShippingUtil().getBusinessDay(this.estimatedDays).with(LocalTime.MIN);
	}

	public BigDecimal getRealCost() {
		
		if (this.cost != null && this.estimatedDays != null) {
			return cost.add(new BigDecimal(estimatedDays)).divide(new BigDecimal(2), new MathContext(4));
		}
		
		return BigDecimal.ZERO;
	}

}

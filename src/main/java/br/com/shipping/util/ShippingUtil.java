package br.com.shipping.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.shipping.model.ShippingOptionModel;
import br.com.shipping.model.ShippingOptionResponseModel;

public class ShippingUtil {

	public List<ShippingOptionResponseModel> verifyBestOption(List<ShippingOptionModel> shippingOptionModel) {

		if (shippingOptionModel == null || (shippingOptionModel != null && shippingOptionModel.isEmpty())) {
			return new ArrayList<ShippingOptionResponseModel>();
		}

		Collections.sort(shippingOptionModel, Comparator.comparing(ShippingOptionModel::getCost)
				.thenComparing(ShippingOptionModel::getEstimatedDays));

		// shippingOptionModel.sort(Comparator.comparing(ShippingOptionModel::getRealCost));

		return ShippingOptionResponseModel.converter(shippingOptionModel);
	}
	
	
	public LocalDateTime getBusinessDay(Integer estimatedDays) {
		LocalDateTime date = LocalDateTime.now();
		if (estimatedDays < 1) {
			return date;
		}

		LocalDateTime result = date;
		int addedDays = 0;
		while (addedDays < estimatedDays) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}

		return result;

	}

}

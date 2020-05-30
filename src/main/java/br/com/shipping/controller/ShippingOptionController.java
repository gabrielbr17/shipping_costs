package br.com.shipping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.shipping.model.ShippingOptionModel;
import br.com.shipping.model.ShippingOptionResponseModel;
import br.com.shipping.util.ShippingUtil;

@RestController
public class ShippingOptionController {

	@ResponseBody
	@PostMapping(path = "/getShippingOrder")
	public List<ShippingOptionResponseModel> getShippingOrder(@RequestBody List<ShippingOptionModel> shippingModel) {
		return new ShippingUtil().verifyBestOption(shippingModel);
	}

}

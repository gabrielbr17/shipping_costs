package br.com.shipping.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ShippingOptionController.class)
class ShippingOptionControllerTest {

	private static final String oneRequest = "[{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_days\":3},{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":10,\"estimated_days\":3},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_days\":3}]";
	private static final String oneResponse = "[{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_date\":\"2020-06-03T00:00:00\"},{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":10,\"estimated_date\":\"2020-06-03T00:00:00\"},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_date\":\"2020-06-03T00:00:00\"}]";

	private static final String twoRequest = "[{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_days\":5},{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":10,\"estimated_days\":3},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_days\":3}]";
	private static final String twoResponse = "[{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":10,\"estimated_date\":\"2020-06-03T00:00:00\"},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_date\":\"2020-06-03T00:00:00\"},{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_date\":\"2020-06-05T00:00:00\"}]";

	private static final String threeRequest = "[{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":6,\"estimated_days\":6},{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":5,\"estimated_days\":6},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_days\":6}]";
	private static final String threeResponse = "[{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":5,\"estimated_date\":\"2020-06-08T00:00:00\"},{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":6,\"estimated_date\":\"2020-06-08T00:00:00\"},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":10,\"estimated_date\":\"2020-06-08T00:00:00\"}]";

	private static final String fourRequest = "[{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_days\":5},{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":5,\"estimated_days\":3},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":7,\"estimated_days\":2}]";
	private static final String fourResponse = "[{\"name\":\"Option 2\",\"type\":\"Custom\",\"cost\":5,\"estimated_date\":\"2020-06-03T00:00:00\"},{\"name\":\"Option 3\",\"type\":\"Pickup\",\"cost\":7,\"estimated_date\":\"2020-06-02T00:00:00\"},{\"name\":\"Option 1\",\"type\":\"Delivery\",\"cost\":10,\"estimated_date\":\"2020-06-05T00:00:00\"}]";

	private static final String fiveRequest = "[]";
	private static final String fiveResponse = "[]";

	@Autowired
	private MockMvc mock;

	@Test
	void getShippingOrderOne() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getShippingOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(oneRequest);
		mock.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(oneResponse));
		
	}

	@Test
	void getShippingOrderTwo() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getShippingOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(twoRequest);
		mock.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(twoResponse));
	}

	@Test
	void getShippingOrderThree() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getShippingOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(threeRequest);
		mock.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(threeResponse));
	}

	@Test
	void getShippingOrderFour() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getShippingOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(fourRequest);
		mock.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(fourResponse));

	}

	@Test
	void getShippingOrderFive() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/getShippingOrder")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(fiveRequest);
		mock.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(fiveResponse));

	}

}

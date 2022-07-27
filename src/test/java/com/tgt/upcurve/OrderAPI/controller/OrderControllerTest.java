package com.tgt.upcurve.OrderAPI.controller;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.utility.JsonUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static final String URI_FETCH_CUSTOMER_ID_ORDER_ID = "/order_api/v1/fetch_order_by_id/{customer_id}/{order_id}";
    private static final String URI_SAVE = "/order_api/v1/";
    private static final String ORDER_JSON_FILE_PATH = "/orderData.json";

    @Test
    public void testFetchByCustomerIdAndOrderId() throws Exception {
        String orderString = JsonUtility.getResourceAsString(ORDER_JSON_FILE_PATH);
        MvcResult responseSave = mockMvc.perform(post(URI_SAVE)
                        .content(orderString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String savedResponse = responseSave.getResponse().getContentAsString();

        MvcResult responseFetch = mockMvc.perform(get(URI_FETCH_CUSTOMER_ID_ORDER_ID, 20, 200)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String fetchedResponse = responseFetch.getResponse().getContentAsString();

        Order savedOrder = JsonUtility.readValue(savedResponse, Order.class);
        Order fetchedOrder = JsonUtility.readValue(fetchedResponse, Order.class);
        Assertions.assertEquals(savedOrder.getOrderId(), fetchedOrder.getOrderId());
        Assertions.assertEquals(savedOrder.getCustomerId(), fetchedOrder.getCustomerId());
        Assertions.assertEquals(savedOrder.getStoreId(), fetchedOrder.getStoreId());
        Assertions.assertEquals(savedOrder.getOrderAmount(), fetchedOrder.getOrderAmount());
        Assertions.assertEquals(savedOrder.getOrderItems().size(), fetchedOrder.getOrderItems().size());
    }
}

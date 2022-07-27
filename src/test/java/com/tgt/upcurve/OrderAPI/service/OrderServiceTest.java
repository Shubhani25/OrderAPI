package com.tgt.upcurve.OrderAPI.service;

import com.tgt.upcurve.OrderAPI.OrderApiApplication;
import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.utility.JsonUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OrderApiApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    private static final String ORDER_JSON_FILE_PATH = "/orderData.json";

    @Test
    public void testFindByCustomerIdAndOrderId() throws Exception {
        Order order = JsonUtility.getOrderRequest(ORDER_JSON_FILE_PATH);
        Order savedOrder = orderService.saveOrder(order);
        Order existingOrder = orderService.fetchOrderByCustomerIdAndOrderId(20, 200);
        assert existingOrder != null;
    }
}

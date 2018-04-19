package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Aspect
@Component
public class OrderProcessWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(order, userId)")
    public void logEvent(OrderDto order, Long userId) {
        LOGGER.info("Args: \nuserId:" + userId.toString() + "\norder: "
                + order.getItems().stream()
                .map(p -> p.getProductId().toString() + " " + p.getQuantity() + "[pcs]")
                .collect(Collectors.joining(",")));
    }
}
package com.kishorek.services;

import com.kishorek.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CheckoutGrpcService extends CheckoutGrpc.CheckoutImplBase implements BaseGrpcService {
    @Override
    public void initCheckout(CheckoutRequest request, StreamObserver<CheckoutResponse> responseObserver) {
        System.out.println(request);
        double total = calculateTotal(request);
        double tax = calculateTax(total);
        String paymentResponse = generateResponse(request.getPaymentMethod());

        responseObserver.onNext(CheckoutResponse.newBuilder().setTotal(total).setTax(tax).setPaymentUpdate(paymentResponse).build());
        responseObserver.onCompleted();
    }

    private String generateResponse(PaymentMethod paymentMethod) {
       return switch (paymentMethod){
           case PAY_CREDIT_CARD -> "Enter your credit card information";
           case PAY_PAYPAL -> "Proceed to Paypal website";
           case PAY_BANK -> "Continue to bank website";
           case UNRECOGNIZED -> "Invalid payment request received";
       };
    }

    private double calculateTax(double total){
        return total*0.07;
    }

    private double calculateTotal(CheckoutRequest request){
        double totalTax = request.getOrderList().stream().map((Order order)->{
            return fetchProductPrice(order.getProduct().getId())*0.01*order.getQty();
        }).reduce(0.0,(a,b)->a+b);

        return totalTax;
    }

    private double fetchProductPrice(String productId){
        return new Random().nextDouble(100,200);
    }
}

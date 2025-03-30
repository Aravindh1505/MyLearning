package com.aravindh.mylearning

fun main() {

    val orderProcessor = OrderProcessor(PayPalProcessor())
    orderProcessor.processOrder("Paypal")

    val orderProcessor1 = OrderProcessor(CreditCardProcessor())
    orderProcessor1.processOrder("Credit Card")

}

interface PaymentProcessor {
    fun processPayment(order: String?)
}

class CreditCardProcessor : PaymentProcessor {
    override fun processPayment(order: String?) {
        println("Processing credit card payment for order: $order")
    }

}

class PayPalProcessor : PaymentProcessor {
    override fun processPayment(order: String?) {
        println("Processing PayPal payment for order: $order")
    }

}

class OrderProcessor(private val paymentProcessor: PaymentProcessor) {
    fun processOrder(order: String?) {
        paymentProcessor.processPayment(order) // Delegate payment processing
    }
}


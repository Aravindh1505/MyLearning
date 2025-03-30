package com.aravindh.mylearning

fun main() {

    val customerRepository = CustomerRepositoryImpl()
    val emailService = EmailServiceImpl()
    val customerService = CustomerService(customerRepository, emailService)
    val customer = Customer(1, "John Doe")
    customerService.saveCustomer(customer)

}

/*------------------------------------------------------------*/

class CustomerService(
    private val customerRepository: CustomerRepository,
    private val emailService: EmailService
) {

    fun saveCustomer(customer: Customer) {
        customerRepository.save(customer)
        emailService.send(customer)
    }
}

/*------------------------------------------------------------*/

data class Customer(val id: Int, val name: String)

/*------------------------------------------------------------*/

interface CustomerRepository {
    fun save(customer: Customer)
}

interface EmailService {
    fun send(customer: Customer)
}

/*------------------------------------------------------------*/

class CustomerRepositoryImpl : CustomerRepository {
    override fun save(customer: Customer) {
        println("Saving customer: $customer")
    }
}

class EmailServiceImpl : EmailService {
    override fun send(customer: Customer) {
        println("Sending email to customer: $customer")
    }
}

/*------------------------------------------------------------*/


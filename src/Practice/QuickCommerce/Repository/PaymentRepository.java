package Practice.QuickCommerce.Repository;

import Practice.QuickCommerce.Models.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();
    private Long paymentIdCounter = 1L;


    public Payment save(Payment payment){
        if(payment.getPaymentId() == null){
            payment.setPaymentId(paymentIdCounter++);
        }
        payments.add(payment);
        return payment;
    }

    public Optional<Payment> findByOrderId(Long orderId){
        return payments.stream().filter(payment -> payment.getOrderId().equals(orderId)).findFirst();
    }
}

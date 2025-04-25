package Practice.QuickCommerce.Service;

import Practice.QuickCommerce.Models.Payment;
import Practice.QuickCommerce.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService (PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Payment payment){
        if(payment.getPaymentType().equals( "CARD")){
            payment.setStatus("PENDING");
        }
        else{
            payment.setStatus("PROCESSED");
        }
        return paymentRepository.save(payment);
    }

    public Payment findPaymentByOrderId(Long orderId){
        return paymentRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public boolean processRefund(Long orderId){
        Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        if(payment.getStatus().equals("REFUNDED")){
            throw new RuntimeException("payment already refunded");
        }
        payment.setStatus("REFUNDED");
        paymentRepository.save(payment);
        return true;
    }
}

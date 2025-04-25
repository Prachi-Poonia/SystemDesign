package Practice.QuickCommerce.Controller;

import Practice.QuickCommerce.Models.Payment;
import Practice.QuickCommerce.Service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Payment> getPaymentByOrderId(@PathVariable Long orderId){
        return ResponseEntity.ok(paymentService.findPaymentByOrderId(orderId));
    }

    @PatchMapping("/process")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.processPayment(payment));
    }

    @PostMapping("/{orderId}/refund")
    public ResponseEntity<String> processRefund(@PathVariable Long orderId){
        paymentService.processRefund(orderId);
        return ResponseEntity.ok("Order amount refunded successfully");
    }
}

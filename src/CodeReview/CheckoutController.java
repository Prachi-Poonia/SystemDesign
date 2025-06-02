/*
package CodeReview;

import java.security.Authentication; // wrong import statement
import java.security. Principal;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

//
desription -  Adding a new version of the basket checkout that stops the user
from checking out if they don't have available balance in their wallet.
The authorisation is controlled using a paramater so we can use it internally
in service to service calls. Calls the wallet-service over HTTP to get the
balance and then to pay
//

@RequestMapping ("/v3/baskets/")
@RestController
public class CheckoutController {

    @Autowired //Field Injection using Autowired is discouraged -> You can't inject mocks easily in unit tests because the field is private and there's no constructor or setter to set it, also constructor injection marks fields as final, making it mandatory to initialise
    public WalletService walletService;

    @Autowired
    public BasketRepository basketRepository; // use constructor injection or @RequiredArgsConstructor instead

    public static final Logger logger = LoggerFactory.getLogger(CheckoutController.class); // have a logger but it is not being used, add meaningful log statements like logger.info("User {} checking out basket {}", auth.getName(), basketId);

    @PutMapping (value = "/new/{basketId}/v2/checkout/confirm")
    //consistent naming -> basketId
    public String checkoutBasket(@PathVariable String basketid , @RequestParam boolean isInternal, Authentication auth, @RequestParam String walletId){

        boolean canAccess = true;
        //logical error -> !isInternal AND auth check not OR
        if(!isInternal || auth.getPrincipal().getName() != null){
            List<Basket> bList = basketRepository.findByUsername(auth.getPrincipal().getName());
            boolean ownsBasket = false;
            bList.stream().forEach(b -> {
                if(b.getId() == basketId){ // for string comparison use .equals()
                    ownsBasket = true;
                }
                //ownBasket is defined outside the lambda and modified inside, instead used boolean ownsBasket = bList.stream().anyMatch(b -> b.getId().equals(basketId));
            });
            if(!ownsBasket) canAccess = false;
        }


        if (!canAccess) return "NOT-ALLOWED"; // add response codes instead -> ResponseEntity.status(HttpStatus.FORBIDDEN).body("NOT_ALLOWED);

        if (walletId == null) {
            var basketOptional = basketRepository.findById(basketId);
            walletId = basketOptional.get().getUserWallet();
        }

        Wallet wallet = walletService.getWallet(walletId);
        Optional.ofNullable (wallet).orElseThrow(); // throw with context -> Optional.ofNullable (wallet).orElseThrow(()-> new IllegalStateException("Wallet not found"));
        double balance = wallet.getBalance();

        var basketOptional = basketRepository.findById(basketId); // no null check here , Basket basket = basketOptional.orElseThrow(() -> new Runtime Exception("Basket not found"));
        // findById() calls are being made twice, call once and store the results
        if (balance > basketOptional.get().getTotal()){
            basketRepository.changeStatus(basketId, "SEND_FOR_DELIVERY");
            walletService.reduceBalance(walletId, basketOptional.get().getTotal());
        } else{
            return "INSUFFICIENT_FUNDS";
        }

        return "OK";

    }
}
*/

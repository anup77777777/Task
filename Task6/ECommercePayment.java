abstract class Payment {
    abstract boolean validatePaymentDetails();
    abstract void makePayment(double amount);

    public void processPayment(double amount) {
        if (validatePaymentDetails()) {
            makePayment(amount);
        } else {
            System.out.println("Payment validation failed.\n");
        }
    }
}
class CreditCardPayment extends Payment {
    String cardNumber, cardHolder, expiryDate;

    CreditCardPayment(String cardNumber, String cardHolder, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    boolean validatePaymentDetails() {
        System.out.println("Validating Credit Card...");
        return cardNumber.length() == 16; 
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.\n");
    }
}
class PayPalPayment extends Payment {
    String email, password;

    PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    boolean validatePaymentDetails() {
        System.out.println("Validating PayPal account...");
        return email.contains("@") && password.length() >= 6;
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.\n");
    }
}

class BankTransferPayment extends Payment {
    String accountNumber, bankCode;

    BankTransferPayment(String accountNumber, String bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    @Override
    boolean validatePaymentDetails() {
        System.out.println("Validating Bank Transfer...");
        return accountNumber.length() == 10 && bankCode.length() == 6;
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Paid " + amount + " via Bank Transfer.\n");
    }
}
public class ECommercePayment {
    public static void main(String[] args) {
        Payment creditCard = new CreditCardPayment("1234567890123456", "John Doe", "12/26");
        Payment paypal = new PayPalPayment("john@example.com", "securePass");
        Payment bankTransfer = new BankTransferPayment("1234567890", "111222");

        creditCard.processPayment(1500.0);
        paypal.processPayment(800.0);
        bankTransfer.processPayment(2200.0);
    }
}

package ru.netology.courseprojectmoneytransfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Transaction {

    private String cardFromNumber; //16
    private String cardFromValidTill; //5
    private String cardFromCVV; //3
    private String cardToNumber; //16
    private Amount amount;

    @Override
    public String toString() {
        return "Transaction{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", amount=" + amount.getValue() +
                ", commission=" + (amount.calcCommission()) +
                '}';
    }

    public boolean checkTransaction() {
        if (this.cardFromNumber.length() == 16 && this.cardToNumber.length() == 16 &&
                this.getCardFromCVV().length() == 3 && this.cardFromValidTill.length() == 5) {
            return true;
        } else {
            return false;
        }
    }

}

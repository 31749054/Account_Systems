package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;
import za.ac.nwu.as.domain.persistence.ACC_TRANSACTION;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTransactionDto implements Serializable {

    private Long ACC_TRANS_ID;
    private String AccountTypeByMnemonic;
    private Long MILES_ADDED;
    private Long MILES_USED;
    private LocalDate TRANSACTION_DATE;
    private Long CLIENT_ID;

//    public AccountTransactionDto() {
//    }

    public AccountTransactionDto(Long ACC_TRANS_ID, String accountTypeByMnemonic, Long miles_added, Long miles_used, LocalDate transaction_date, Long client_id){

        this.AccountTypeByMnemonic = accountTypeByMnemonic;
        this.MILES_ADDED = miles_added;
        this.MILES_USED = miles_used;
        this.TRANSACTION_DATE = transaction_date;
        this.CLIENT_ID = client_id;
    }

    public AccountTransactionDto(ACC_TRANSACTION accTransaction){
        this.ACC_TRANS_ID = accTransaction.getACC_TRANS_ID();
        this.AccountTypeByMnemonic = accTransaction.getACC_TYPE_ID().getMNEMONIC();
        this.MILES_ADDED = accTransaction.getMILES_ADDED();
        this.MILES_USED = accTransaction.getMILES_USED();
        this.TRANSACTION_DATE = accTransaction.getTRANSACTION_DATE();
        this.CLIENT_ID = accTransaction.getCLIENT_ID();

    }
    public AccountTransactionDto() {
    }


    public ACC_TRANSACTION buildAccountTransaction(ACC_TYPE accountType){
        return new ACC_TRANSACTION(this.getACC_TRANS_ID(),accountType,this.getMILES_ADDED(),this.getMILES_USED(),this.getTRANSACTION_DATE(),this.getCLIENT_ID());
    }

    public Long getACC_TRANS_ID() {
        return ACC_TRANS_ID;
    }

    public void setACC_TRANS_ID(Long ACC_TRANS_ID) {
        this.ACC_TRANS_ID = ACC_TRANS_ID;
    }

    public String getAccountTypeByMnemonic() {
        return AccountTypeByMnemonic;
    }

    public void setAccountTypeByMnemonic(String accountTypeByMnemonic) {
        AccountTypeByMnemonic = accountTypeByMnemonic;
    }

    public Long getMILES_ADDED() {
        return MILES_ADDED;
    }

    public void setMILES_ADDED(Long MILES_ADDED) {
        this.MILES_ADDED = MILES_ADDED;
    }

    public Long getMILES_USED() {
        return MILES_USED;
    }

    public void setMILES_USED(Long MILES_USED) {
        this.MILES_USED = MILES_USED;
    }

    public LocalDate getTRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }

    public void setTRANSACTION_DATE(LocalDate TRANSACTION_DATE) {
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }

    public Long getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(Long CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(ACC_TRANS_ID, that.ACC_TRANS_ID) && Objects.equals(AccountTypeByMnemonic, that.AccountTypeByMnemonic) && Objects.equals(MILES_ADDED, that.MILES_ADDED) && Objects.equals(MILES_USED, that.MILES_USED) && Objects.equals(TRANSACTION_DATE, that.TRANSACTION_DATE) && Objects.equals(CLIENT_ID, that.CLIENT_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACC_TRANS_ID, AccountTypeByMnemonic, MILES_ADDED, MILES_USED, TRANSACTION_DATE, CLIENT_ID);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "ACC_TRANS_ID=" + ACC_TRANS_ID +
                ", AccountTypeByMnemonic='" + AccountTypeByMnemonic + '\'' +
                ", MILES_ADDED=" + MILES_ADDED +
                ", MILES_USED=" + MILES_USED +
                ", TRANSACTION_DATE=" + TRANSACTION_DATE +
                ", CLIENT_ID=" + CLIENT_ID +
                '}';
    }

    //    //LINKING
//    public String getAccountTypeByMnemonic() {
//        return null;
//    }

//
//
//    public Long getACC_TRANS_ID() {return ACC_TRANS_ID;}
//    public void setACC_TRANS_ID(Long ACC_TRANS_ID) {
//        this.ACC_TRANS_ID = ACC_TRANS_ID;
//    }
//
//    public String getAccountTypeByMnemonic(){
//        return AccountTypeByMnemonic;
//    }
//
//    public ACC_TYPE getACC_TYPE_ID() {
//        return accountTypeByMnemonic;
//    }
//    public void setACC_TYPE_ID(ACC_TYPE ACC_TYPE_ID) {
//        this.accountTypeByMnemonic = ACC_TYPE_ID;
//    }
//
//    public Long getMILES_ADDED() {
//        return MILES_ADDED;
//    }
//    public void setMILES_ADDED(Long MILES_ADDED) {
//        this.MILES_ADDED = MILES_ADDED;
//    }
//
//    public Long getMILES_USED() {
//        return MILES_USED;
//    }
//    public void setMILES_USED(Long MILES_USED) {
//        this.MILES_USED = MILES_USED;
//    }
//
//    public LocalDate getTRANSACTION_DATE() {
//        return TRANSACTION_DATE;
//    }
//    public void setTRANSACTION_DATE(LocalDate TRANSACTION_DATE) {
//        this.TRANSACTION_DATE = TRANSACTION_DATE;
//    }
//
//    public Long getCLIENT_ID() {
//        return CLIENT_ID;
//    }
//    public void setCLIENT_ID(Long CLIENT_ID) {
//        this.CLIENT_ID = CLIENT_ID;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ACC_TRANSACTION that = (ACC_TRANSACTION) o;
//        return Objects.equals(ACC_TRANS_ID, that.getACC_TRANS_ID() ) && Objects.equals(ACC_TYPE_ID, that.getACC_TYPE_ID()) && Objects.equals(MILES_ADDED, that.getMILES_ADDED()) && Objects.equals(MILES_USED, that.getMILES_USED()) && Objects.equals(TRANSACTION_DATE, that.getTRANSACTION_DATE()) && Objects.equals(CLIENT_ID, that.getCLIENT_ID());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(ACC_TRANS_ID, ACC_TYPE_ID, MILES_ADDED, MILES_USED, TRANSACTION_DATE, CLIENT_ID);
//    }
//
//    @Override
//    public String toString() {
//        return "AccountTransactionDto{" +
//                "ACC_TRANS_ID=" + ACC_TRANS_ID +
//                ", ACC_TYPE_ID=" + ACC_TYPE_ID +
//                ", MILES_ADDED=" + MILES_ADDED +
//                ", MILES_USED=" + MILES_USED +
//                ", TRANSACTION_DATE=" + TRANSACTION_DATE +
//                ", CLIENT_ID=" + CLIENT_ID +
//                '}';
//    }


}

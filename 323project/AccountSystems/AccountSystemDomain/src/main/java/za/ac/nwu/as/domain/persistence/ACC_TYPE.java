package za.ac.nwu.as.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACC_TYPE" ,schema = "DiscoveryRewardsCmpg323")
public class ACC_TYPE implements Serializable {


    @Id
    @SequenceGenerator(name = "ACC_TYPE_SEQ1", sequenceName = "DiscoveryRewardsCmpg323.ACC_TYPE_SEQ1",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TYPE_SEQ1")

    private Long ACC_TYPE_ID;
    private String MNEMONIC;
    private String ACC_TYPE_NAME;
    private LocalDate CREATION_DATE;

    private Set<ACC_TRANSACTION> acc_transactions;

    public ACC_TYPE(Long ACC_TYPE_ID, String MNEMONIC, String ACC_TYPE_NAME, LocalDate CREATION_DATE) {
        this.ACC_TYPE_ID = ACC_TYPE_ID;
        this.MNEMONIC = MNEMONIC;
        this.ACC_TYPE_NAME = ACC_TYPE_NAME;
        this.CREATION_DATE = CREATION_DATE;

    }

    public ACC_TYPE() {
    }

    public ACC_TYPE(String mnemonic, String acc_type_name, LocalDate creation_date) {
    }


    @Column(name = "ACC_TYPE_ID")
    public Long getACC_TYPE_ID() {
        return ACC_TYPE_ID;
    }
    public void setACC_TYPE_ID(Long ACC_TYPE_ID) {this.ACC_TYPE_ID = ACC_TYPE_ID;}

    @Column(name = "MNEMONIC")
    public String getMNEMONIC() {
        return MNEMONIC;
    }

    public void setMNEMONIC(String MNEMONIC) {
        this.MNEMONIC = MNEMONIC;
    }
    @Column(name = "ACC_TYPE_NAME")
    public String getACC_TYPE_NAME() {
        return ACC_TYPE_NAME;
    }

    @OneToMany(targetEntity = ACC_TRANSACTION.class, fetch = FetchType.LAZY, mappedBy = "ACC_TYPE_ID",orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<ACC_TRANSACTION> getAcc_transactions(){
        return acc_transactions;
    }

    public void setAcc_transactions(Set<ACC_TRANSACTION> accountTransactions) {
        this.acc_transactions = accountTransactions;
    }

    public void setACC_TYPE_NAME(String ACC_TYPE_NAME) {
        this.ACC_TYPE_NAME = ACC_TYPE_NAME;
    }
    @Column(name = "CREATION_DATE")
    public LocalDate getCREATION_DATE() {
        return CREATION_DATE;
    }

    public void setCREATION_DATE(LocalDate CREATION_DATE) {
        this.CREATION_DATE = CREATION_DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACC_TYPE acc_type = (ACC_TYPE) o;
        return Objects.equals(ACC_TYPE_ID, acc_type.ACC_TYPE_ID) && Objects.equals(MNEMONIC, acc_type.MNEMONIC) && Objects.equals(ACC_TYPE_NAME, acc_type.ACC_TYPE_NAME) && Objects.equals(CREATION_DATE, acc_type.CREATION_DATE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACC_TYPE_ID, MNEMONIC, ACC_TYPE_NAME, CREATION_DATE );
    }

    @Override
    public String toString() {
        return "ACC_TYPE{" +
                "ACC_TYPE_ID=" + ACC_TYPE_ID +
                ", MNEMONIC='" + MNEMONIC + '\'' +
                ", ACC_TYPE_NAME='" + ACC_TYPE_NAME + '\'' +
                ", CREATION_DATE=" + CREATION_DATE +
                '}';
    }
}

package za.ac.nwu.as.domain.persistence;



import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACC_TRANSACTION",schema = "JOHAN")
public class ACC_TRANSACTION implements Serializable {

    private Long ACC_TRANS_ID;
    private ACC_TYPE ACC_TYPE_ID;
    private Long MILES_ADDED;
    private Long MILES_USED;
    private LocalDate TRANSACTION_DATE;
    private Long CLIENT_ID;

    public ACC_TRANSACTION(Long ACC_TRANS_ID, ACC_TYPE ACC_TYPE_ID, Long MILES_ADDED, Long MILES_USED, LocalDate TRANSACTION_DATE, Long CLIENT_ID) {
        this.ACC_TRANS_ID = ACC_TRANS_ID;
        this.ACC_TYPE_ID = ACC_TYPE_ID;
        this.MILES_ADDED = MILES_ADDED;
        this.MILES_USED = MILES_USED;
        this.TRANSACTION_DATE = TRANSACTION_DATE;
        this.CLIENT_ID = CLIENT_ID;
    }

    public ACC_TRANSACTION() {
    }

    @Id
    @SequenceGenerator(name = "ACC_TRANSACTION_SEQ", sequenceName = "JOHAN.ACC_TRANSACTION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TRANSACTION_SEQ")


    @Column(name = "ACC_TRANS_ID")
    public Long getACC_TRANS_ID() {
        return ACC_TRANS_ID;
    }

    public void setACC_TRANS_ID(Long ACC_TRANS_ID) {
        this.ACC_TRANS_ID = ACC_TRANS_ID;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACC_TYPE_ID")
    public ACC_TYPE getACC_TYPE_ID() {
        return ACC_TYPE_ID;
    }







//    @OneToOne(targetEntity = ACC_TRANSACTION.class, fetch = FetchType.LAZY, mappedBy = "acc_Transaction"){
//        public ACC_TRANSACTION get{
//            return getCLIENT_ID();
//        }
//    }








    public void setACC_TYPE_ID(ACC_TYPE ACC_TYPE_ID) {
        this.ACC_TYPE_ID = ACC_TYPE_ID;
    }
    @Column(name = "MILES_ADDED")
    public Long getMILES_ADDED() {
        return MILES_ADDED;
    }

    public void setMILES_ADDED(Long MILES_ADDED) {
        this.MILES_ADDED = MILES_ADDED;
    }
    @Column(name = "MILES_USED")
    public Long getMILES_USED() {
        return MILES_USED;
    }

    public void setMILES_USED(Long MILES_USED) {
        this.MILES_USED = MILES_USED;
    }
    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }

    public void setTRANSACTION_DATE(LocalDate TRANSACTION_DATE) {
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }
    @Column(name = "CLIENT_ID")
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
        ACC_TRANSACTION that = (ACC_TRANSACTION) o;
        return Objects.equals(ACC_TRANS_ID, that.ACC_TRANS_ID) && Objects.equals(ACC_TYPE_ID, that.ACC_TYPE_ID) && Objects.equals(MILES_ADDED, that.MILES_ADDED) && Objects.equals(MILES_USED, that.MILES_USED) && Objects.equals(TRANSACTION_DATE, that.TRANSACTION_DATE) && Objects.equals(CLIENT_ID, that.CLIENT_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACC_TRANS_ID, ACC_TYPE_ID, MILES_ADDED, MILES_USED, TRANSACTION_DATE, CLIENT_ID);
    }

    @Override
    public String toString() {
        return "ACC_TRANSACTION{" +
                "ACC_TRANS_ID=" + ACC_TRANS_ID +
                ", ACC_TYPE_ID=" + ACC_TYPE_ID +
                ", MILES_ADDED=" + MILES_ADDED +
                ", MILES_USED=" + MILES_USED +
                ", TRANSACTION_DATE=" + TRANSACTION_DATE +
                ", CLIENT_ID=" + CLIENT_ID +
                '}';
    }
}

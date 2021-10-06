package za.ac.nwu.as.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;
import io.swagger.annotations.ApiModel;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;
import java.io.Serializable;


@ApiModel(value = "ACC_TYPE", description = "a dto that represents ACC_TYPE" )
public class AccountTypeDto implements Serializable{

        private String MNEMONIC;
        private String ACC_TYPE_NAME;
        private LocalDate CREATION_DATE;

        public AccountTypeDto() {
        }

        public AccountTypeDto(String MNEMONIC, String ACC_TYPE_NAME, LocalDate CREATION_DATE) {
            this.MNEMONIC = MNEMONIC;
            this.ACC_TYPE_NAME = ACC_TYPE_NAME;
            this.CREATION_DATE = CREATION_DATE;
        }


        public AccountTypeDto(ACC_TYPE accountType) {
            this.setACC_TYPE_NAME(accountType.getACC_TYPE_NAME());
            this.setCREATION_DATE(accountType.getCREATION_DATE());
            this.setMNEMONIC(accountType.getMNEMONIC());
        }


        @ApiModelProperty(position = 1,
                value = "AccountType Mnemonic",
                name = "Mnemonic",
                notes = "Uniquely identifies the account type",
                dataType = "java.lang.String",
                example = "MILES",
                required = true)
        public String getMNEMONIC() {
            return MNEMONIC;
        }
        public void setMNEMONIC(String MNEMONIC) {
            this.MNEMONIC = MNEMONIC;
        }


        @ApiModelProperty(position = 2,
                value = "AccountType Name",
                name = "Name",
                notes = "The name of the AccountType",
                dataType = "java.lang.String",
                example = "Miles",
                allowEmptyValue = false,
                required = true)
        public String getACC_TYPE_NAME() {
            return ACC_TYPE_NAME;
        }
        public void setACC_TYPE_NAME(String ACC_TYPE_NAME) {
            this.ACC_TYPE_NAME = ACC_TYPE_NAME;
        }


        @ApiModelProperty(position = 3,
                value = "AccountType Creation Date",
                name = "CreationDate",
                notes = "This is the date on which the AccountType was created",
                dataType = "java.lang.String",
                example = "2020-01-01",
                allowEmptyValue = true,
                required = false)

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
            ACC_TYPE that = (ACC_TYPE) o;
            return Objects.equals(MNEMONIC, that.getMNEMONIC() ) && Objects.equals(ACC_TYPE_NAME, that.getACC_TYPE_NAME()) && Objects.equals(CREATION_DATE, that.getCREATION_DATE());
        }

        @JsonIgnore
        public ACC_TYPE getAccountType() {
            return new ACC_TYPE(getMNEMONIC(), getACC_TYPE_NAME(), getCREATION_DATE());
        }

        @Override
        public int hashCode() {
            return Objects.hash(MNEMONIC, ACC_TYPE_NAME, CREATION_DATE);
        }

        @Override
        public String toString() {
            return "AccountTypeDto{" +
                    "MNEMONIC='" + MNEMONIC + '\'' +
                    ", ACC_TYPE_NAME='" + ACC_TYPE_NAME + '\'' +
                    ", CREATION_DATE=" + CREATION_DATE +
                    '}';
        }

}


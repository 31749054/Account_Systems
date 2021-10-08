package za.ac.nwu.as.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.AccountTypeDto;
import za.ac.nwu.as.domain.persistence.ACC_TYPE;
import za.ac.nwu.as.repo.persistence.AccountTypeRepository;
import za.ac.nwu.as.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository){
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes(){

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try{
            for (ACC_TYPE acc_type : accountTypeRepository.findAll()){
                accountTypeDtos.add(new AccountTypeDto(acc_type));
            }
        } catch (Exception e) {
            //TODO : Log
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountTypeDtos;
    }


    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto){
        ACC_TYPE acc_type = accountTypeRepository.save(accountTypeDto.getAccountType());
        return new AccountTypeDto(acc_type);
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic (String mnemonic) {
        try {
            ACC_TYPE acc_type = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(acc_type);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the db", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic) {

        return null;
    }


    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            ACC_TYPE acc_type = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(acc_type);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the db", e);
        }
    }




//    @Override
//    public AccountTypeDto getAccountTypeDtoByMnemonic (String mnemonic) {
//
//           return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
//
//    }


}

package za.ac.nwu.as.translator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.as.repo.config.RepositoryConfig;
import za.ac.nwu.as.repo.persistence.AccountTypeRepository;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {"za.ac.nwu.as.translator"})
public class TranslatorConfig {

}

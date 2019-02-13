package com.logica.pocblockchaintest.configuration;

import com.logica.pocblockchaintest.model.Transaction;
import com.logica.pocblockchaintest.model.Transaction3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;

import java.io.IOException;
import java.math.BigInteger;

@Configuration
@EnableWebMvc
@EnableConfigurationProperties(value = Web3jProperties.class)
public class WebjConfig implements InitializingBean, DisposableBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebjConfig.class);

    public static final String contractAddress = "0x4c99a6b29b0d7184bf6bea42a178675f2971f00f";
    public static final String PRIVATE_KEY = "e712822f556bbbcee0c55648c000702b7a77c2868e5cc0084dc2b1848b040ef4";

    @Autowired
    Web3jProperties web3jProperties;

    @Autowired
    Web3j web3j;

    @Autowired
    Admin admin;

    @Bean
    @Primary
    public Web3j build()
    {
        return Web3j.build(new HttpService(web3jProperties.getUrl()));
//        return Web3j.build(new IpcService("C:\\Blockchain\\chaindata\\"))
    }

    @Bean
    public Admin buildAdmin(){
        return Admin.build(new HttpService(web3jProperties.getUrl()));
    }

//    public static Credentials credentialsEth() throws IOException, CipherException {
//        Credentials credentials =
//                WalletUtils.loadCredentials(
//                        "pass1234",
//                        "C:\\Blockchain\\chaindata\\keystore\\UTC--2019-02-11T06-50-21.184680100Z--8d164afd6082171a970bb0ecdf5390e14c6600b1");
//        LOGGER.info("Credentials loaded");
//        return credentials;
//    }

    public static Credentials credentials(String privatekey)
    {
        return Credentials.create(privatekey);
    }

    public static ContractGasProvider contractGasProvider()
    {
        return new ContractGasProvider()
        {
            @Override
            public BigInteger getGasPrice(String contractFunc)
            {
                return BigInteger.valueOf(22000000000L);
            }

            @Override
            public BigInteger getGasPrice()
            {
                return BigInteger.valueOf(22000000000L);
            }

            @Override
            public BigInteger getGasLimit(String contractFunc)
            {
                return BigInteger.valueOf(6721975);
            }

            @Override
            public BigInteger getGasLimit()
            {
                return BigInteger.valueOf(6721975);
            }
        };
    }

    @Bean
    public Transaction loadContract() throws IOException, CipherException
    {
        LOGGER.info("Loading Contract from contract address: {}", contractAddress);
        return Transaction.load(contractAddress, build(), credentials(PRIVATE_KEY), contractGasProvider());
//        return Transaction1.load(contractAddress, build(), credentialsEth(), contractGasProvider());
    }

    @Override
    public void afterPropertiesSet() throws Exception{
//        String contractAddress = Transaction.deploy(web3j, credentials(PRIVATE_KEY), contractGasProvider()).send().getContractAddress();
////        String contractAddress = Transaction1.deploy(web3j, credentialsEth(), contractGasProvider()).send().getContractAddress();
//        LOGGER.info("Contract Address: "+contractAddress);
    }

    @Override
    public void destroy() throws Exception
    {
        web3j.shutdown();
    }

}

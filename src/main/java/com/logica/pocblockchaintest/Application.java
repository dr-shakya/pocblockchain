package com.logica.pocblockchaintest;

public class Application {
//
//    public final static String PRIVATE_KEY = "b9ebb18959989080e60ba98775da10a21aad3a431bb5c0b0e3ba2cb388947488";
//
//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main() throws Exception {
//        new Application().run();
//    }
//
//    public Credentials getCredentialsFromPrivateKey(){
//        return Credentials.create(PRIVATE_KEY);
//    }
//
//    private void run() throws Exception {
//        // We start by creating a new web3j instance to connect to remote nodes on the network.
//        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:8545"));
//        log.info("Connected to Ethereum client version: "
//                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
//
//        //get the credentials
//        Credentials credentials =
//                WalletUtils.loadCredentials(
//                        "pass1234",
//                        "C:\\Blockchain\\chaindata\\keystore\\UTC--2019-02-08T05-00-14.988962700Z--c3a1af339fa73ff1b78b4d627d029db04e6b2e48");
//        log.info("Credentials loaded");
//
////        Credentials credentials = getCredentialsFromPrivateKey();
//
//        ContractGasProvider contractGasProvider = new ContractGasProvider() {
//            @Override
//            public BigInteger getGasPrice(String contractFunc) {
//                return BigInteger.valueOf(2000000000);
//            }
//
//            @Override
//            public BigInteger getGasPrice() {
//                return null;
//            }
//
//            @Override
//            public BigInteger getGasLimit(String contractFunc) {
//                return BigInteger.valueOf(6721975);
//            }
//
//            @Override
//            public BigInteger getGasLimit() {
//                return null;
//            }
//        };
//
//        //Deploy the smart contract
//        log.info("Deploying smart contract");
//        Transaction1 contract = Transaction1.deploy(web3j, credentials, contractGasProvider).send();
//        String contractAddress = contract.getContractAddress();
//        log.info("Smart contract deployed to address "+contractAddress);
//
//

//        TransactionReceipt transactionReceipt = contract.addBank("Global").send();
//        log.info("Transaction1 block number is {}", transactionReceipt);
//
//        RemoteCall<Tuple3<BigInteger, String, String>> result = contract.getBank(transactionReceipt.getContractAddress());
//        log.info(String.valueOf(result));
    }
}

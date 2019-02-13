package com.logica.pocblockchaintest.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class Transaction1 extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5061100b806100206000396000f3fe608060405234801561001057600080fd5b50600436106100a5576000357c010000000000000000000000000000000000000000000000000000000090048063b53ea15c11610078578063b53ea15c14610232578063cb949e51146102ea578063d4d0a4bd146103a5578063e65c9e75146103ad576100a5565b806312065fe0146100aa5780632e44715d146100c457806383e0c31d146100cc57806396ed5d861461018a575b600080fd5b6100b2610461565b60408051918252519081900360200190f35b6100b26105a0565b6100f2600480360360208110156100e257600080fd5b5035600160a060020a03166105a6565b604051808481526020018060200183600160a060020a0316600160a060020a03168152602001828103825284818151815260200191508051906020019080838360005b8381101561014d578181015183820152602001610135565b50505050905090810190601f16801561017a5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b610230600480360360208110156101a057600080fd5b8101906020810181356401000000008111156101bb57600080fd5b8201836020820111156101cd57600080fd5b803590602001918460018302840111640100000000831117156101ef57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955061069e945050505050565b005b6102306004803603606081101561024857600080fd5b600160a060020a03823516919081019060408101602082013564010000000081111561027357600080fd5b82018360208201111561028557600080fd5b803590602001918460018302840111640100000000831117156102a757600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050913592506107a6915050565b6103106004803603602081101561030057600080fd5b5035600160a060020a0316610934565b60408051858152908101839052600160a060020a038216606082015260806020808301828152865192840192909252855160a084019187019080838360005b8381101561036757818101518382015260200161034f565b50505050905090810190601f1680156103945780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b610230610aa7565b610230600480360360608110156103c357600080fd5b8101906020810181356401000000008111156103de57600080fd5b8201836020820111156103f057600080fd5b8035906020019184600183028401116401000000008311171561041257600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505082359350505060200135600160a060020a0316610c01565b3360009081526005602052604081205460ff1615156001146104bb576040805160e560020a62461bcd0281526020600482015260176024820152600080516020610fc0833981519152604482015290519081900360640190fd5b6104c3610e6a565b33600090815260046020908152604091829020825160808101845281548152600180830180548651600293821615610100026000190190911692909204601f81018690048602830186019096528582529194929385810193919291908301828280156105705780601f1061054557610100808354040283529160200191610570565b820191906000526020600020905b81548152906001019060200180831161055357829003601f168201915b505050918352505060028201546020820152600390910154600160a060020a031660409182015201519150505b90565b60005490565b6000606060006105b4610e9c565b600160a060020a03851660009081526001602081815260409283902083516060810185528154815281840180548651600296821615610100026000190190911695909504601f810185900485028601850190965285855290949193858401939092908301828280156106675780601f1061063c57610100808354040283529160200191610667565b820191906000526020600020905b81548152906001019060200180831161064a57829003601f168201915b505050918352505060029190910154600160a060020a03166020918201528151908201516040909201519097919650945092505050565b3360009081526002602052604090205460ff1615610706576040805160e560020a62461bcd02815260206004820152601360248201527f42616e6b20616c72656164792065786973747300000000000000000000000000604482015290519081900360640190fd5b6000805460019081018083556040805160608101825291825260208083018681523384840181905286528482529190942082518155905180519294919361075593908501929190910190610ec7565b506040918201516002918201805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0390921691909117905533600090815260209190915220805460ff1916600117905550565b3360009081526005602052604090205460ff161515600114610800576040805160e560020a62461bcd0281526020600482015260176024820152600080516020610fc0833981519152604482015290519081900360640190fd5b600160a060020a03831660009081526002602052604090205460ff161515600114610863576040805160e560020a62461bcd0281526020600482015260136024820152600080516020610fa0833981519152604482015290519081900360640190fd5b604080516080810182528381526020808201849052600160a060020a03861692820192909252336060820152600680546001810180835560009290925282518051929460049092027ff652222313e28459528d920b65115c16c04f3efc82aaedc97be59f3f377c0d3f01926108db9284920190610ec7565b5060208201516001820155604082015160028201805473ffffffffffffffffffffffffffffffffffffffff19908116600160a060020a039384161790915560609093015160039092018054909316911617905550505050565b600160a060020a0381166000908152600560205260408120546060908290819060ff16151560011461099e576040805160e560020a62461bcd0281526020600482015260176024820152600080516020610fc0833981519152604482015290519081900360640190fd5b6109a6610e6a565b600160a060020a038616600090815260046020908152604091829020825160808101845281548152600180830180548651600293821615610100026000190190911692909204601f8101869004860283018601909652858252919492938581019391929190830182828015610a5c5780601f10610a3157610100808354040283529160200191610a5c565b820191906000526020600020905b815481529060010190602001808311610a3f57829003601f168201915b50505091835250506002820154602080830191909152600390920154600160a060020a0316604091820152825191830151908301516060909301519199909850919650945092505050565b3360009081526002602052604090205460ff161515600114610b01576040805160e560020a62461bcd0281526020600482015260136024820152600080516020610fa0833981519152604482015290519081900360640190fd5b60005b600654811015610bfe576006805433919083908110610b1f57fe5b6000918252602090912060026004909202010154600160a060020a03161415610bf657610b97600682815481101515610b5457fe5b906000526020600020906004020160010154600683815481101515610b7557fe5b6000918252602090912060036004909202010154600160a060020a0316610d8a565b6006805482908110610ba557fe5b60009182526020822060049091020190610bbf8282610f45565b506000600182015560028101805473ffffffffffffffffffffffffffffffffffffffff199081169091556003909101805490911690555b600101610b04565b50565b3360009081526002602052604090205460ff161515600114610c5b576040805160e560020a62461bcd0281526020600482015260136024820152600080516020610fa0833981519152604482015290519081900360640190fd5b600160a060020a03811660009081526005602052604090205460ff1615610ccc576040805160e560020a62461bcd02815260206004820152601760248201527f437573746f6d657220616c726561647920657869737473000000000000000000604482015290519081900360640190fd5b60038054600190810191829055604080516080810182529283526020808401878152848301879052600160a060020a038616606086018190526000908152600483529290922084518155915180519293610d2e93908501929190910190610ec7565b5060408281015160028301556060909201516003909101805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03928316179055919091166000908152600560205220805460ff191660011790555050565b3360009081526002602052604090205460ff161515600114610de4576040805160e560020a62461bcd0281526020600482015260136024820152600080516020610fa0833981519152604482015290519081900360640190fd5b600160a060020a03811660009081526005602052604090205460ff161515600114610e47576040805160e560020a62461bcd0281526020600482015260176024820152600080516020610fc0833981519152604482015290519081900360640190fd5b600160a060020a0316600090815260046020526040902060020180549091019055565b6080604051908101604052806000815260200160608152602001600081526020016000600160a060020a031681525090565b60606040519081016040528060008152602001606081526020016000600160a060020a031681525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610f0857805160ff1916838001178555610f35565b82800160010185558215610f35579182015b82811115610f35578251825591602001919060010190610f1a565b50610f41929150610f85565b5090565b50805460018160011615610100020316600290046000825580601f10610f6b5750610bfe565b601f016020900490600052602060002090810190610bfe91905b61059d91905b80821115610f415760008155600101610f8b56fe42616e6b20646f6573206e6f7420657869737400000000000000000000000000437573746f6d657220646f6573206e6f74206578697374000000000000000000a165627a7a723058206d02b151212c22b38a5290f9485b28b324ec5b378c4c4a60e74cae0ab70859da0029";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETBANKCOUNT = "getBankCount";

    public static final String FUNC_GETBANK = "getBank";

    public static final String FUNC_ADDBANK = "addBank";

    public static final String FUNC_REQUESTBALANCEUPDATE = "requestBalanceUpdate";

    public static final String FUNC_GETCUSTOMER = "getCustomer";

    public static final String FUNC_VERIFYSTATEMENT = "verifyStatement";

    public static final String FUNC_ADDCUSTOMER = "addCustomer";

    @Deprecated
    protected Transaction1(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Transaction1(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Transaction1(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Transaction1(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getBankCount() {
        final Function function = new Function(FUNC_GETBANKCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<BigInteger, String, String>> getBank(String _bankAddress) {
        final Function function = new Function(FUNC_GETBANK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_bankAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, String>>(
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addBank(String _bankName) {
        final Function function = new Function(
                FUNC_ADDBANK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> requestBalanceUpdate(String _toAddress, String _message, BigInteger _balance) {
        final Function function = new Function(
                FUNC_REQUESTBALANCEUPDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_toAddress), 
                new org.web3j.abi.datatypes.Utf8String(_message), 
                new org.web3j.abi.datatypes.generated.Uint256(_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple4<BigInteger, String, BigInteger, String>> getCustomer(String _customerAddress) {
        final Function function = new Function(FUNC_GETCUSTOMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_customerAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple4<BigInteger, String, BigInteger, String>>(
                new Callable<Tuple4<BigInteger, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> verifyStatement() {
        final Function function = new Function(
                FUNC_VERIFYSTATEMENT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addCustomer(String _customerName, BigInteger balance, String _customerAddress) {
        final Function function = new Function(
                FUNC_ADDCUSTOMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_customerName), 
                new org.web3j.abi.datatypes.generated.Uint256(balance), 
                new org.web3j.abi.datatypes.Address(_customerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Transaction1 load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction1(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Transaction1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction1(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Transaction1 load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Transaction1(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Transaction1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Transaction1(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Transaction1> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction1.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction1> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction1.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Transaction1> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction1.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction1> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction1.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}

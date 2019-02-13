pragma solidity 0.5.3;

contract Transaction{

    struct Bank{
        uint bankId;
        string bankName;
        string accountPassword;
        address bankAddress;
        // uint customerCount;
    }

    struct Customer{
        uint customerId;
        string customerName;
        string accountPassword;
        uint balance;
        address customerAddress;
    }

    struct Statement{
        string message;
        uint balance;
        string bankName;
        string customerName;
    }

    uint private bankCount;
    uint private customerCount;

    mapping(string=>Bank) private banks;
    mapping(string=>Customer) private customers;
    Statement[] statements;

    mapping(string=>bool) private bankExists;
    mapping(string=>bool) private customerExists;

    string[] private bankNames;
    string[] private customerNames;

    event CustomerInfo(string customerName, uint balance);

    //set the bank
    function setBank(string memory _bankName, string memory _accountPassword, address _bankAddress) public {
        require(bankExists[_bankName]==false, "Bank already exists");
        bankCount++;
        banks[_bankName] = Bank(bankCount, _bankName, _accountPassword, _bankAddress);

        bankExists[_bankName] = true;
        bankNames.push(_bankName);
    }

    //set customer
    function setCustomer(string memory _bankName, string memory _customerName, string memory _accountPassword, uint _balance, address _customerAddress) public {
        require(bankExists[_bankName]==true, "Bank does not exist");

        customerCount++;
        customers[_customerName] = Customer(customerCount, _customerName, _accountPassword, _balance, _customerAddress);

        customerExists[_customerName] = true;
        customerNames.push(_customerName);

    }

    //customer request for balance update
     function requestBalanceUpdate(string memory _customerName, string memory _bankName, string memory _message, uint _balance) public {
        //verity if customer and bank exists
        require(customerExists[_customerName]==true, "Customer does not exist");
        require(bankExists[_bankName]==true, "Bank does not exist");

        statements.push(Statement(_message, _balance, _bankName, _customerName));
    }

    //bank verifies customer statement
    function verifyStatement(string memory _bankName) public {
        require(bankExists[_bankName]==true, "Bank does not exist");
        for(uint i=0; i<statements.length; i++){
            if(getBankId(statements[i].bankName) == getBankId(_bankName)){
                updateBalance(statements[i].balance, statements[i].customerName);

                delete statements[i];
            }

        }
    }
    function updateBalance(uint _balance, string memory _customerName) private {
        require(customerExists[_customerName] == true, "Customer does not exist");
        customers[_customerName].balance += _balance;
        emit CustomerInfo(customers[_customerName].customerName, customers[_customerName].balance);
    }

    function getBankId(string memory _bankName) public view returns (uint) {
        require(bankExists[_bankName]==true, "Bank does not exist");
        return banks[_bankName].bankId;

    }

    function getBank(string memory _bankName) public view returns (uint id, string memory name, address addr){
        require(bankExists[_bankName]==true, "Bank does not exist");
        Bank memory bank = banks[_bankName];
        return (bank.bankId, bank.bankName, bank.bankAddress);
    }


    //get customer balance
    function getBalance(string memory _customerName) public view returns (uint _balance){
        require(customerExists[_customerName]==true, "Customer does not exist");
        Customer memory customer = customers[_customerName];
        return (customer.balance);
    }

    //get customer information
    function getCustomer(string memory _customerName) public view returns (uint, string memory, uint, address){
        require(customerExists[_customerName]==true, "Customer does not exist");
        Customer memory c = customers[_customerName];
        return (c.customerId, c.customerName, c.balance, c.customerAddress);
    }
}
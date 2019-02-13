pragma solidity 0.5.3;

contract Transaction{

    struct Bank{
        uint bankId;
        string bankName;
        address bankAdmin;
        // Statement[] statement;
    }

    struct Customer{
        uint customerId;
        string customerName;
        uint balance;
        address customerAddress;
    }

    struct Statement{
        string message;
        uint balance;
        address toAddress;
        address fromAddress;
    }

    // address private bankAdmin;
    uint private bankCount;
    mapping(address=>Bank) private banks;
    mapping(address=>bool) private bankExists;

    uint private customerCount;
    mapping(address=>Customer) private customers;
    mapping(address=>bool) private customerExists;

    // mapping(address=>Statement) private statements;
    Statement[] statements;


    function addBank(string memory _bankName) public {
        //check if bank already exists
        require(bankExists[msg.sender] == false, "Bank already exists");

        bankCount++; //to use as bank id
        banks[msg.sender] = Bank(bankCount, _bankName, msg.sender);

        bankExists[msg.sender] = true;
    }

    function getBankCount() public view returns (uint) {
        return bankCount;
    }

    function getBank(address _bankAddress) public view returns (uint id, string memory name, address addr){
        Bank memory bank = banks[_bankAddress];
        return (bank.bankId, bank.bankName, bank.bankAdmin);
    }

    function addCustomer(string memory _customerName, uint balance, address _customerAddress) public {
        //verify if bank exists
        require(bankExists[msg.sender] == true, "Bank does not exist");
        //verify if customer already exists
        require(customerExists[_customerAddress] == false, "Customer already exists");

        customerCount++;
        customers[_customerAddress] = Customer(customerCount, _customerName, balance, _customerAddress);

        customerExists[_customerAddress] = true;
    }

    function requestBalanceUpdate(address _toAddress, string memory _message, uint _balance) public {
        //verity if customer and bank exists
        require(customerExists[msg.sender]==true, "Customer does not exist");
        require(bankExists[_toAddress]==true, "Bank does not exist");

        statements.push(Statement(_message, _balance, _toAddress, msg.sender));
    }

    function getCustomer(address _customerAddress) public view returns (uint id, string memory name, uint bal, address addr){
        require(customerExists[_customerAddress]==true, "Customer does not exist");
        Customer memory customer = customers[_customerAddress];
        return (customer.customerId, customer.customerName, customer.balance, customer.customerAddress);
    }

    function getBalance() public view returns (uint _balance){
        require(customerExists[msg.sender]==true, "Customer does not exist");
        Customer memory customer = customers[msg.sender];
        return (customer.balance);
    }

    function verifyStatement() public {
        require(bankExists[msg.sender]==true, "Bank does not exist");
        for(uint i=0; i<statements.length; i++){
            if(statements[i].toAddress == msg.sender){
                updateBalance(statements[i].balance, statements[i].fromAddress);
                delete statements[i];
            }

        }
    }

    function updateBalance(uint _balance, address _fromAddress) private {
        require(bankExists[msg.sender] == true, "Bank does not exist");
        require(customerExists[_fromAddress] == true, "Customer does not exist");
        customers[_fromAddress].balance += _balance;
    }

}
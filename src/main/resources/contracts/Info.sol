pragma solidity ^0.5.3;

contract Info {

    struct Bank {
        uint bankId;
        string bankName;
        string accountPassword;
        address bankAddress;
    }


    struct Customer {
        uint customerId;
        string customerName;
        string customerSex;
        string permanentAddress; //location
        uint wardNumber;
        address customerAddress; //unique address
        string accountPassword;
    }

    struct Access {
        string bankName;
        string customerName;
        uint allowedAccess;
    }

    uint private bankCount;
    uint private customerCount;

    mapping(string=>Bank) private banks;
    mapping(string=>Customer) private customers;

    mapping(string=>bool) private bankExists;
    mapping(string=>bool) private customerExists;

    // add bank
    function setBank(string memory _bankName, string memory _accountPassword, address _bankAddress) public {
        require(bankExists[_bankName]==false, "Bank already exists");
        bankCount++;
        banks[_bankName] = Bank(bankCount, _bankName, _accountPassword, _bankAddress);

        bankExists[_bankName] = true;
    }

    // add customer
    function setCustomer(string memory _bankName, string memory _customerName, string memory _customerSex, string memory _permanentAddress, uint _wardNumber, address _customerAddress, string memory _accountPassword) public {
        require(bankExists[_bankName]==true, "Bank does not exists");
        require(customerExists[_customerName]==false, "Customer already exists");

        customerCount++;
        customers[_customerName] = Customer(customerCount, _customerName, _customerSex, _permanentAddress, _wardNumber, _customerAddress, _accountPassword);

        customerExists[_customerName] = true;
    }

    function getBank(string memory _bankName) public view returns (uint id, string memory name, address addr){
        require(bankExists[_bankName]==true, "Bank does not exist");
        Bank memory bank = banks[_bankName];
        return (bank.bankId, bank.bankName, bank.bankAddress);
    }

    //get customer information
    function getCustomer(string memory _customerName) public view returns (uint id, string memory name, string memory sex, string memory permanentAddress, uint wardNumber, address customerAddress){
        require(customerExists[_customerName]==true, "Customer does not exist");
        Customer memory c = customers[_customerName];
        return (c.customerId, c.customerName, c.customerSex, c.permanentAddress, c.wardNumber, c.customerAddress);
    }

    //request access

    //allow access

    //revoke access

    //check access

}
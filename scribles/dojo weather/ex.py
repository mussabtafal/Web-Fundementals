from array import array


class BankAccount:
    def __init__(self, int_rate = 0.01, balance = 0): 
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self
		
    def withdraw(self, amount):
        if (self.balance - amount) < 0 :
            self.balance -= 5
            print("Insufficient funds: Charging a $5 fee")
        else:
            self.balance -= amount
        return self	
    
    def display_account_info(self):
        print(self.balance)
        return self
    
    def yield_interest(self):
        account_rate = self.balance * self.int_rate
        self.balance += account_rate
        return self

class User:
    def __init__(self, name, email, accounts):
        self.name = name
        self.email = email
        array = []
        for i in range (0,accounts,1):
            array.append(BankAccount(int_rate=0.02, balance = 0))
        self.account = array

    def make_withdrawal(self, amount, i):
        if i is True:
            self.account[i].withdraw(amount)
            return self

    def make_deposit(self, amount,i):
        if i is True:	
            self.account[i].deposit(amount)
            return self
    
    def display_user_balance(self, i):
        if i is True:
            print(self.name, self.account[i].balance)
            return self

mussab = User("Mussab Taffal", "mussab_tafal@hotmail.com", 10)

mussab.make_deposit(3000,10)
mussab.display_user_balance(10)








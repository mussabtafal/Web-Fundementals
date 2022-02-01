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
    def __init__(self, name, email):
        self.name = name
        self.email = email
        # array = []
        # for i in range (0,accounts,1):
        # array.append(BankAccount(int_rate=0.02, balance = 0))
        self.account =[BankAccount(int_rate=0.02, balance = 0)]

    def make_withdrawal(self, amount, i):
        self.account[i].withdraw(amount)
        return self

    def make_deposit(self, amount,i):
        self.account[i].deposit(amount)
        return self
    
    def display_user_balance(self, i):
        print(self.name, self.account[i].balance)
        return self

    def new_account(self):
        self.account.append(BankAccount(int_rate=0.02, balance = 0))
        return self

mussab = User("Mussab Taffal", "mussab_tafal@hotmail.com")

mussab.make_deposit(800, 0).display_user_balance(0)
mussab.new_account().make_deposit(200, 1).display_user_balance(1).new_account().make_deposit(150,2).display_user_balance(2)

mussab.display_user_balance(1)







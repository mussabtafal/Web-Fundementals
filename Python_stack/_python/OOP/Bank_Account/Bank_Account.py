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
    
bank_account1 = BankAccount(0.015, 500)
bank_account2 = BankAccount(0.025)

bank_account1.deposit(400).deposit(250).deposit(1100).withdraw(1300).yield_interest().display_account_info()
bank_account2.deposit(700).deposit(1150).withdraw(200).withdraw(550).withdraw(600).withdraw(150).yield_interest().display_account_info()




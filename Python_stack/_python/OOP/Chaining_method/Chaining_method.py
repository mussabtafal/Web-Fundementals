class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    # adding the withdrawal method
    def make_withdrawal(self, amount):
        self.account_balance -= amount
        return self	

    def make_deposit(self, amount):	
        self.account_balance += amount
        return self
    
    def display_user_balance(self):
        print(self.name, self.account_balance)
        return self
    
    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        print(self.name, "=", ahmad.account_balance)
        print(other_user.name, "=", other_user.account_balance)

mussab = User("Mussab Taffal", "mussab_tafal@hotmail.com")
mohammed = User("Mohammed Omair", "Omair@hotmail.com")
ahmad = User("Ahmad Abdelqader", "AhmedA@hotmail.com")

mussab.make_deposit(300).make_deposit(250).make_deposit(450).make_withdrawal(600).display_user_balance()
mohammed.make_deposit(750).make_deposit(150).make_withdrawal(300).make_withdrawal(600).display_user_balance()
ahmad.make_deposit(1250).make_withdrawal(100).make_withdrawal(200).make_withdrawal(300).display_user_balance()

ahmad.transfer_money(mussab, 200)





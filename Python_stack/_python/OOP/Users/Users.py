class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    # adding the withdrawal method
    def make_withdrawal(self, amount):
        self.account_balance -= amount	

    def make_deposit(self, amount):	
        self.account_balance += amount
    
    def display_user_balance(self):
        print(self.name, self.account_balance)
    
    def transfer_money(self, other_user, amount):
        self.account_balance -= amount
        other_user.account_balance += amount
        print(self.name, "=", ahmad.account_balance)
        print(other_user.name, "=", other_user.account_balance)

mussab = User("Mussab Taffal", "mussab_tafal@hotmail.com")
mohammed = User("Mohammed Omair", "Omair@hotmail.com")
ahmad = User("Ahmad Abdelqader", "AhmedA@hotmail.com")

mussab.make_deposit(300)
mussab.make_deposit(250)
mussab.make_deposit(450)
mussab.make_withdrawal(600)
mussab.display_user_balance()

mohammed.make_deposit(750)
mohammed.make_deposit(150)
mohammed.make_withdrawal(300)
mohammed.make_withdrawal(600)
mohammed.display_user_balance()

ahmad.make_deposit(1250)
ahmad.make_withdrawal(100)
ahmad.make_withdrawal(200)
ahmad.make_withdrawal(300)
ahmad.display_user_balance()

ahmad.transfer_money(mussab, 200)





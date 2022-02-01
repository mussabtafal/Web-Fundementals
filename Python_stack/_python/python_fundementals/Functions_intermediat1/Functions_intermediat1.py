def beCheerful(name='', repeat=2):		# set defaults when declaring the parameters
	print(f"good morning {name}\n" * repeat)
beCheerful()				# output: good morning (repeated on 2 lines)
beCheerful("tim")		# output: good morning tim (repeated on 2 lines)
beCheerful(name="john")			# output: good morning john (repeated on 2 lines)
beCheerful(repeat=6)			# output: good morning (repeated on 6 lines)
beCheerful(name="michael", repeat=5)	# output: good morning michael (repeated on 5 lines)
# NOTE: argument order doesn't matter if we are explicit when sending in our arguments!
beCheerful(repeat=3, name="kb")		# output: good morning kb (repeated on 3 lines)

import random
def randInt(min = 0, max = 100):
    if max > min and max > 0:
        num = random.random() * (max-min) + min
    return round(num)


print(randInt()) 		# should print a random integer between 0 to 100
print(randInt(max=50)) 	# should print a random integer between 0 to 50
print(randInt(min=50)) 	# should print a random integer between 50 to 100
print(randInt(min=50, max=500))    # should print a random integer between 50 and 500


class Node: 
    def __init__ (self,data):
        self.data = data
        self.next = None

class linkedlist:
    def __init__ (self):
        self.head = None

    def insertNodeAtTail (self,newelement):
        newNode = Node(newelement)
        if self.head == None:
                self.head = newNode
                return
        else:
            temp = self.head
            while temp.next != None:
                    temp = temp.next
            temp.next = newNode
            return            
    def PrintList(self):
        temp = self.head
        if(temp != None):
            print("The list contains:")
            while (temp != None):
                print(temp.data)
                temp = temp.next
        else:
            print("The list is empty.")
    def addatmiddel(self,data,position):
        newnode=Node(data)
        prev = self.head
        curr = newnode
        count = 1
        if position < 0:
            print("add valid number")
        if self.head == None:
                self.head = newnode
        else :
            while count != position :
                prev = prev.next
                count +=1
            curr.next = prev.next
            prev.next = curr

Mylist = linkedlist()
Mylist.insertNodeAtTail(141)
Mylist.insertNodeAtTail(142)
Mylist.insertNodeAtTail(143)
Mylist.insertNodeAtTail(144)
Mylist.insertNodeAtTail(145)
Mylist.insertNodeAtTail(146)
Mylist.addatmiddel(66,3)
Mylist.PrintList()


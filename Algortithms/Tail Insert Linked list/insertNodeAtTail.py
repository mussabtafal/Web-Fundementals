class Node: 
    def __init__ (self,data):
        self.data = data
        self.next = None

class linkedlist:
    def __init__ (self):
        self.head = None

    def insertNodeAtTail (self, newelement):
        newNode = Node(newelement)
        if self.head == None:
                self.head = newNode
        else:
            temp = self.head
            while temp.next != None:
                    temp = temp.next
                    temp.next = newNode
            
    def PrintList(self):
        temp = self.head
        if(temp != None):
            print("The list contains:", end=" ")
            while (temp != None):
                print(temp.data, end=" ")
                temp = temp.next
            print()
        else:
            print("The list is empty.")

Mylist = linkedlist()
Mylist.insertNodeAtTail(141)
Mylist.insertNodeAtTail(142)
Mylist.insertNodeAtTail(143)
Mylist.PrintList()
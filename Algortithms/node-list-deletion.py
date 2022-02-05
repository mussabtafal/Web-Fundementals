
class Node:

	def __init__(self, data):
		self.data = data
		self.next = None

class LinkedList:

	def __init__(self):
		self.head = None

	def push(self, new_data):
		new_node = Node(new_data)
		new_node.next = self.head
		self.head = new_node


    def Delete(self, position):
        currentPos = 0
        prevNode = None
        node = self.head
        while currentPos < position:
            currentPos = currentPos+1
            prevNode = node
            node = node.next

        if prevNode is not None:
            prevNode.next = node.next
            return self.head
        else:
            n = node.next
            node.next = None
            return n

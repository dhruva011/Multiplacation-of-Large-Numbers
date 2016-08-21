import java.util.*;
class Linked{
	int value;
	Linked next;
}

class AccessList{
	Linked head = null;
	int carry = 0;
	
	void insertEnd(int value){
	if(head == null){
	Linked obj = new Linked();
	obj.value = value;
	obj.next = null;
	head = obj;
	//System.out.println("Inserted head was null:");
	}
	else{
	Linked ptr=head;
	while(ptr.next!=null){
	ptr= ptr.next;
	}
	Linked obj = new Linked();
	obj.value = value;
	obj.next = null;
	ptr.next=obj;
	//System.out.println("Inserted head was not null:");
	
	}
	}
	void insertAndUpdate(int j,int i,int value)
	{
		//System.out.println("Index  = "+i + " Value = "+value);
		if(i == 0)
		{	
		//Only Insert
			if(head==null){
				Linked obj = new Linked();
				obj.value = value;
				obj.next = null;
				head=obj;
				return ;
			}
			Linked ptr=head;
			while(ptr.next!=null){
			ptr= ptr.next;
			}
		Linked obj = new Linked();
		obj.value = value;
		obj.next = null;
		ptr.next=obj;
			return;
		}
		else{
			// Update from index
			Linked ptr=head;
			int count=0;
			while(count<(i+j)){
				count++;
				ptr= ptr.next;
			}
			//System.out.println("ptr= "+ptr);
			if(ptr!=null){
			//System.out.println("I am referring to a node which has data = "+ptr.value);
			int data = ptr.value+value+carry;
			carry = data/10;
			int base = data%10;
			ptr.value = base;
			}
		}
	}
	
	
	void traverse(){
	Linked ptr = head;
	while(ptr!=null){
	System.out.println(ptr.value);
	ptr=ptr.next;
	}
	}
}

class Main{
	public static void main(String[] args){
	
	Scanner in = new Scanner(System.in);
	AccessList  listN1 = new AccessList();
	AccessList  listN2 = new AccessList();
	System.out.println("Enter First Number = ");
	String num1 = in.next();
	System.out.println("Enter Second Number = ");
	String num2 = in.next();
	
	char[] n1 = num1.toCharArray();
	char[] n2 = num2.toCharArray();
	
	for(int i = n1.length-1;i>=0;i--){
	listN1.insertEnd((int)n1[i]-48);
	}
	//System.out.println("Traversing 1st list");
	//listN1.traverse();
	
	for(int i = n2.length-1;i>=0;i--){
	listN2.insertEnd((int)n2[i]-48);
	}
	//System.out.println("Traversing 1st list");
	//listN2.traverse();
	
	System.out.println("Multiplied List ");
	Linked head = multiply(listN1.head,listN2.head);
	//AccessList y = new AccessList();
	//y.head = x;
	System.out.println("Output is = ");
	print(head);
	}
	
	static void print(Linked head){
		if(head == null || (head.next == null &&head.value == 0))
			return;
		else{
			print(head.next);
			System.out.print(head.value);
		}
	}
	
	
	
	static Linked multiply(Linked num1Head,Linked num2Head){
	Linked ptrNum2 = num2Head; // head of 2nd num list
	AccessList mulResult = new AccessList();
	int n2count = 0;
	
	while(ptrNum2!=null){
		//System.out.println("outer loop count = "+n2count);
	int value = ptrNum2.value;
	Linked ptrNum1 = num1Head; // head of firt num list
	int carry = 0;
	int n1count = 0;
	
		while(ptrNum1!=null){
			//System.out.println("inner loop count = "+n1count);
			int data = ptrNum1.value;
			int mul = data*value;
			//System.out.println("multiplying = "+data+" and "+value);
			int base = mul%10;
			//System.out.println("count value i e index is and value inserting in ll = "+ n2count +" "+(base+carry));
			mulResult.insertAndUpdate(n1count,n2count,base+carry);
			carry = mul/10;
			n1count++;
			ptrNum1 = ptrNum1.next;
		}
	
		
		mulResult.insertEnd(carry);
		
	n2count++;
	
	ptrNum2 = ptrNum2.next;
	}
	
	return mulResult.head;
	}
}
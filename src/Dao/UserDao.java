package Dao;

import java.util.Arrays;

import Entity.User;

public class UserDao {
	
	//����һ���洢User���͵�����
	static User[] arr = new User[20];
	static {
//		�����û�  ��ֵ������
		User user1 = new User("1", "mark", "123");
		User user2 = new User("2", "neil", "234");
		User user3 = new User("3", "sam", "345");
		User user4 = new User("4", "billy", "456");
		User user5 = new User("5", "jack", "567");
		User user6 = new User("6", "alex", "678");
		User user7 = new User("7", "halana", "789");
		arr[0] = user1;
		arr[1] = user2;
		arr[2] = user3;
		arr[3] = user4;
		arr[4] = user5;
		arr[5] = user6;
		arr[6] = user7;
	}
	
//ע��
	public boolean Register(User re){
			for (int i = 0; i < arr.length; i++) {
				//��arrΪ�յõط���ǰ̨���ݸ�ֵ
				if(arr[i] == null) {
					arr[i] = re;
					break;
				}
				//��ֹ�ظ�
				if(arr[i].getUsername().equals(re.getUsername()))
					return false;
			}
			return true;
		}
	
	
//��¼��
public boolean login (String name,String pwd){
	for (int j = 0; j < arr.length; j++) {
		
		if(arr[j]!=null && arr[j].getUsername().equals(name)&&arr[j].getUserPassword().equals(pwd)) {
			return true;
		}
	}
	        return false;
	
}

//ͨ��������ѯ������Ϣ��
//public User[] selectByName(String name) {
//	
//	for (int i = 0; i < arr.length; i++) {
//		if(arr[i]!=null && arr[i].getUsername().equals(name)) {
//			return arr;
//		}
//	}
//	return null;
//}
public User selectByName(User n) {
	
	for (int i = 0; i < arr.length; i++) {
		if(arr[i]!=null&&arr[i].getUsername().equals(n.getUsername())) {
			return arr[i];
		}
	}
	return null;
}



	
//��ѯID�Ƿ���ڣ�
public boolean selectById(String id){
	for (int j = 0; j < arr.length; j++) {
		if (arr[j]!=null && arr[j].getUserid().equals(id)) {
			return true;
		}
	}
	        return false;
}

//�ؼ��֣����֣���ѯ
public User[] selectByKey(String key) {
	//��һ��СͰ
	User arr2[]=new User[9];
	int index=0;
	for (int i = 0; i < arr2.length; i++) {
			
		if(arr[i]!=null&&arr[i].getUsername().contains(key)) {
			//����������Ͱ�Ķ�����СͰ
			arr2[index]=arr[i];
			//���������ٵ��������Ǵ�Ͱ��ô�������
			index++;
			} 
		}
	//���СͰ�ĵ�һ��Ϊ�գ�˵��СͰ�ڴ�Ͱ��û�õ�����
		if(null==arr2[0]) {
			return null;
		}
		return arr2;
	
}


//дһ����ѯ���з���һ������
	public User[] selectAll() {
		return arr;
	}
//һ��ҪдtoString
	@Override
	public String toString() {
		return "UserDao [selectAll()=" + Arrays.toString(selectAll()) + "]";
	}


// ������Ϣ
	public boolean Update(User update) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getUsername().equals(update.getUsername())) {

				arr[i] = update;
			}

		}

		return false;
	}

	
//ɾ����
public boolean Delete (String name){
for (int j = 0; j < arr.length; j++) {
	arr[j] = null;	
	System.out.println("ɾ���ɹ�");
	break;
	
}
return false;

}





}





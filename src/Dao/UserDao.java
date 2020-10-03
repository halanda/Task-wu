package Dao;

import java.util.Arrays;

import Entity.User;

public class UserDao {
	
	//定义一个存储User类型的数组
	static User[] arr = new User[20];
	static {
//		创建用户  赋值给数组
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
	
//注册
	public boolean Register(User re){
			for (int i = 0; i < arr.length; i++) {
				//在arr为空得地方把前台数据赋值
				if(arr[i] == null) {
					arr[i] = re;
					break;
				}
				//防止重复
				if(arr[i].getUsername().equals(re.getUsername()))
					return false;
			}
			return true;
		}
	
	
//登录：
public boolean login (String name,String pwd){
	for (int j = 0; j < arr.length; j++) {
		
		if(arr[j]!=null && arr[j].getUsername().equals(name)&&arr[j].getUserPassword().equals(pwd)) {
			return true;
		}
	}
	        return false;
	
}

//通过姓名查询所有信息：
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



	
//查询ID是否存在：
public boolean selectById(String id){
	for (int j = 0; j < arr.length; j++) {
		if (arr[j]!=null && arr[j].getUserid().equals(id)) {
			return true;
		}
	}
	        return false;
}

//关键字（名字）查询
public User[] selectByKey(String key) {
	//做一个小桶
	User arr2[]=new User[9];
	int index=0;
	for (int i = 0; i < arr2.length; i++) {
			
		if(arr[i]!=null&&arr[i].getUsername().contains(key)) {
			//满足条件大桶的东西给小桶
			arr2[index]=arr[i];
			//满足条件再递增，但是大桶怎么都会递增
			index++;
			} 
		}
	//如果小桶的第一个为空，说明小桶在大桶里没拿到东西
		if(null==arr2[0]) {
			return null;
		}
		return arr2;
	
}


//写一个查询所有返回一个数组
	public User[] selectAll() {
		return arr;
	}
//一定要写toString
	@Override
	public String toString() {
		return "UserDao [selectAll()=" + Arrays.toString(selectAll()) + "]";
	}


// 更改信息
	public boolean Update(User update) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getUsername().equals(update.getUsername())) {

				arr[i] = update;
			}

		}

		return false;
	}

	
//删除：
public boolean Delete (String name){
for (int j = 0; j < arr.length; j++) {
	arr[j] = null;	
	System.out.println("删除成功");
	break;
	
}
return false;

}





}





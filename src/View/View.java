package View;

import java.util.Scanner;
import Dao.UserDao;
import Entity.User;

public class View {
	public static void main(String[] args) {
		User user = new User();

		System.out.println("欢迎您,使用本软件");
		System.out.println("请选择：1 注册 2 登录 ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		UserDao userdao = new UserDao();
//注册信息
		if (input == 1) {
			System.out.println("欢迎来到注册界面");
			User u1 = new User();
			System.out.println("请创建用户名 ");
			u1.setUsername(sc.next());
			System.out.println("请创建您的密码 ");
			u1.setUserPassword(sc.next());

			if (userdao.Register(u1)) {
				System.out.println("注册成功");
			} else {
				System.out.println("该用户名已存在，注册失败");

				System.out.println("重新创建用户名请输入1, 放弃注册请输入2");
				int zhuce = sc.nextInt();
				if (zhuce == 1) {

					while (zhuce == 1) {
						System.out.println("请创建用户名 ");
						u1.setUsername(sc.next());
						System.out.println("请创建您的密码 ");
						u1.setUserPassword(sc.next());

						if (userdao.Register(u1)) {
							System.out.println("注册成功");
							break;
						} else {
							System.out.println("该用户名已存在，注册失败");

						}

					}

				} else {
					System.out.println("感谢您本次使用");
				}
			}
		}
//登录
		else if (input == 2) {
			System.out.println("请输入用户名");

			Scanner scan = new Scanner(System.in);

			String name = scan.nextLine();

			System.out.println("请输入密码");

			String pwd = scan.nextLine();

			if (userdao.login(name, pwd)) {
				System.out.println("欢迎使用，登录成功");
				
				System.out.println("请选择想要查询的方法:1通过名字查询所有信息 2通过id查询是否存在 3.关键字查询 4.查询所有 5.更改信息");
				input =sc.nextInt();
//通过名字查询所有信息
				if(input == 1) {
					System.out.println("请输入名字");
					user.setUsername(sc.next());
////下面那行没懂
//					userdao.selectByName(name);
//                    if(user!=null) {
//					System.out.println(user.toString());	
//					}
//				}
				User userSelected=userdao.selectByName(user);
				if(userSelected != null) {
					System.out.println(userSelected.toString());
				}
				else {
					System.out.println("查无此人");
					
				}

			}

				
				
//查询ID是否存在：
				else if (input == 2) {
					System.out.println("请输入ID");
					String id;
					id = sc.next();
					if (userdao.selectById(id)) {
						System.out.println("该用户存在");
					} else {
						System.out.println("该用户不存在");
					}
				}
//关键字查询
				else if (input == 3) {
					System.out.println("请输入关键字");
					User[] selectbykey = userdao.selectByKey(sc.next());
					// 这部排空是为了找得到关键字
					if (null != selectbykey) {
						for (int i = 0; i < selectbykey.length; i++) {
							// 小桶得空空间排除掉结束运行然后打印数组，不排的话会报空指针
							if (null == selectbykey[i]) {
								break;
							}
							System.out.println(selectbykey[i].toString());
						}
					} else {
						System.out.println("检索不到关键字，请重新输入");
					}

				}
			
//查询所有；
				else if(input==4) {
				User[]selectall = userdao.selectAll();
				if (userdao!=null) {
					for (int i = 0;  i< selectall.length; i++) {
						if (selectall[i]==null) {
							break;
						}
						System.out.println(selectall[i].toString());
					}

				}
				}
				else if(userdao == null) {
					System.out.println("查无数据");
				}
//更改信息	
				else if (input == 5) {
					// 目的：通过用户输入的名字反馈给他原本信息
					// 要求客户输入name
					System.out.println("请输入name");

					// 把前台得到的name传到后台
					user.setUsername(sc.next());
					// 直接打印整个方法运行的tostring
					// 得到了原本的信息
					System.out.println(userdao.selectByName(user).toString());
   				    System.out.println("修改信息请输入1，删除信息请输入2");
   				 int t = sc.nextInt();
   				    if(t==1) {
// 修改密码
   					 System.out.println("输入新密码");
   				
   					//接收到新输入的密码
//						
   					 user.setUserPassword(sc.next());
   					userdao.Update(user);
   					 System.out.println(user.toString());
   					
   					

   					 
   					}	 
					else if (t == 2) {
						userdao.Delete(user.toString());

					}
				}

			}

		}
				
//登录好几回之后成功的方案
			 else {
				System.out.println("用户名或密码错误,请输入2重新登陆");

				int denglu = sc.nextInt();
				while (denglu == 2) {
					System.out.println("请输入用户名");

					Scanner scan1 = new Scanner(System.in);

					String name1 = scan1.nextLine();

					System.out.println("请输入密码");

					String pwd1 = scan1.nextLine();

					if (userdao.login(name1, pwd1)) {
						System.out.println("欢迎使用，登录成功");

						break;

				} else {
					System.out.println("用户名或密码错误,请重新输入");
				}

			}

		}

	}

}

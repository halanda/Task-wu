package View;

import java.util.Scanner;
import Dao.UserDao;
import Entity.User;

public class View {
	public static void main(String[] args) {
		User user = new User();

		System.out.println("��ӭ��,ʹ�ñ����");
		System.out.println("��ѡ��1 ע�� 2 ��¼ ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		UserDao userdao = new UserDao();
//ע����Ϣ
		if (input == 1) {
			System.out.println("��ӭ����ע�����");
			User u1 = new User();
			System.out.println("�봴���û��� ");
			u1.setUsername(sc.next());
			System.out.println("�봴���������� ");
			u1.setUserPassword(sc.next());

			if (userdao.Register(u1)) {
				System.out.println("ע��ɹ�");
			} else {
				System.out.println("���û����Ѵ��ڣ�ע��ʧ��");

				System.out.println("���´����û���������1, ����ע��������2");
				int zhuce = sc.nextInt();
				if (zhuce == 1) {

					while (zhuce == 1) {
						System.out.println("�봴���û��� ");
						u1.setUsername(sc.next());
						System.out.println("�봴���������� ");
						u1.setUserPassword(sc.next());

						if (userdao.Register(u1)) {
							System.out.println("ע��ɹ�");
							break;
						} else {
							System.out.println("���û����Ѵ��ڣ�ע��ʧ��");

						}

					}

				} else {
					System.out.println("��л������ʹ��");
				}
			}
		}
//��¼
		else if (input == 2) {
			System.out.println("�������û���");

			Scanner scan = new Scanner(System.in);

			String name = scan.nextLine();

			System.out.println("����������");

			String pwd = scan.nextLine();

			if (userdao.login(name, pwd)) {
				System.out.println("��ӭʹ�ã���¼�ɹ�");
				
				System.out.println("��ѡ����Ҫ��ѯ�ķ���:1ͨ�����ֲ�ѯ������Ϣ 2ͨ��id��ѯ�Ƿ���� 3.�ؼ��ֲ�ѯ 4.��ѯ���� 5.������Ϣ");
				input =sc.nextInt();
//ͨ�����ֲ�ѯ������Ϣ
				if(input == 1) {
					System.out.println("����������");
					user.setUsername(sc.next());
////��������û��
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
					System.out.println("���޴���");
					
				}

			}

				
				
//��ѯID�Ƿ���ڣ�
				else if (input == 2) {
					System.out.println("������ID");
					String id;
					id = sc.next();
					if (userdao.selectById(id)) {
						System.out.println("���û�����");
					} else {
						System.out.println("���û�������");
					}
				}
//�ؼ��ֲ�ѯ
				else if (input == 3) {
					System.out.println("������ؼ���");
					User[] selectbykey = userdao.selectByKey(sc.next());
					// �ⲿ�ſ���Ϊ���ҵõ��ؼ���
					if (null != selectbykey) {
						for (int i = 0; i < selectbykey.length; i++) {
							// СͰ�ÿտռ��ų�����������Ȼ���ӡ���飬���ŵĻ��ᱨ��ָ��
							if (null == selectbykey[i]) {
								break;
							}
							System.out.println(selectbykey[i].toString());
						}
					} else {
						System.out.println("���������ؼ��֣�����������");
					}

				}
			
//��ѯ���У�
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
					System.out.println("��������");
				}
//������Ϣ	
				else if (input == 5) {
					// Ŀ�ģ�ͨ���û���������ַ�������ԭ����Ϣ
					// Ҫ��ͻ�����name
					System.out.println("������name");

					// ��ǰ̨�õ���name������̨
					user.setUsername(sc.next());
					// ֱ�Ӵ�ӡ�����������е�tostring
					// �õ���ԭ������Ϣ
					System.out.println(userdao.selectByName(user).toString());
   				    System.out.println("�޸���Ϣ������1��ɾ����Ϣ������2");
   				 int t = sc.nextInt();
   				    if(t==1) {
// �޸�����
   					 System.out.println("����������");
   				
   					//���յ������������
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
				
//��¼�ü���֮��ɹ��ķ���
			 else {
				System.out.println("�û������������,������2���µ�½");

				int denglu = sc.nextInt();
				while (denglu == 2) {
					System.out.println("�������û���");

					Scanner scan1 = new Scanner(System.in);

					String name1 = scan1.nextLine();

					System.out.println("����������");

					String pwd1 = scan1.nextLine();

					if (userdao.login(name1, pwd1)) {
						System.out.println("��ӭʹ�ã���¼�ɹ�");

						break;

				} else {
					System.out.println("�û������������,����������");
				}

			}

		}

	}

}

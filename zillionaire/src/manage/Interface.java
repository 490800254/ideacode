package manage;

import Users.Users;

import java.util.Scanner;

public class Interface {
    public static Users u = new Users();
    public static int ZD(){
        int b = 0;
        System.out.println("欢迎登陆大富翁游戏：");
        System.out.println("1.登录      2.注册");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("请输入账号：");
                int num = sc.nextInt();
                System.out.println("请输入密码：");
                int password = sc.nextInt();
                b = Managa.DengLu(num,password,Managa.arr);
                break;
            case 2:
                System.out.println("请输入用户名：");
                String id = sc.next();
                System.out.println("请输入账号：");
                num = sc.nextInt();
                System.out.println("请输入密码：");
                password = sc.nextInt();
                u = Managa.ZhuCe(id,password,num);
                Managa.arr.add(u);
                Interface.ZD();
                break;
        }
        return b;
    }
    public static void ZX(int aa){
        Users ul = (Users)Managa.arr.get(aa);
        System.out.println("欢迎" + ul.getId()+",请选择您接下来的操作：");
        System.out.println("1.抽奖");
        System.out.println("2.修改密码");
        System.out.println("3.删除");
        System.out.println("4.退出");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch(a){
            case 1:
                Managa.ChouJiang(aa);
                break;
            case 2:
                Managa.XuiGai(aa);
                break;
            case 3:
                Managa.ShanChu(aa);
                break;
            case 4:
                System.out.println("欢迎您下次使用！");
                ZD();
        }
    }
}

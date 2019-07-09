package manage;

import Users.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Managa {
    Users[] u;
    public static List arr = new ArrayList();

    //注册
    public  static Users ZhuCe(String id,int password,int num){
        Users u = new Users();
        u.setId(id);
        u.setPassword(password);
        u.setNum(num);
        return u;
    }

    //登录
   public static int DengLu(int num,int password,List arr){
       int c = 0;
        for(int i=0;i<arr.size();i++){
            Users ul = (Users)arr.get(i);
            if(num == ul.getNum()){
                if(password==ul.getPassword()){
                    System.out.println("登陆成功！");
                    System.out.println("您的用户名为：" + ul.getId());
                    System.out.println("您的账号为：" + ul.getNum());
                    System.out.println("您的金额为：" + ul.getMoney());
                    c = i;
                    Interface.ZX(i);
                }else{
                    System.out.println("密码错误！请重新登录！");
                    Interface.ZD();
                }
            }else if(i == arr.size()-1){
                System.out.println("查无此人！请重新登录！");
                Interface.ZD();
            }else {
                continue;
            }
        }
        return c;
    }

    //抽奖
    public static void ChouJiang(int aa){
        int a;
        Users ul = (Users)arr.get(aa);
        a = (int)(Math.random()*3+1);
        System.out.println("您抽取的随机数字为：" + a);
        switch (a){
            case 1:
                System.out.println("奖励为金额增加100！");
                ul.setMoney(ul.getMoney()+100);
                System.out.println("当前金额为：" + ul.getMoney());
                break;
            case 2:
                System.out.println("奖励为金额增加500！");
                ul.setMoney(ul.getMoney()+500);
                System.out.println("当前金额为：" + ul.getMoney());
                break;
            case 3:
                System.out.println("奖励为金额增加1000！");
                ul.setMoney(ul.getMoney()+1000);
                System.out.println("当前金额为：" + ul.getMoney());
                break;
        }
        Interface.ZX(aa);
    }

    //修改密码
    public static void XuiGai(int aa) {
        Users ul = (Users)arr.get(aa);
        System.out.println("请输入您当前密码：");
        Scanner sc = new Scanner(System.in);
        int password = sc.nextInt();
        if (password != ul.getPassword()) {
            System.out.println("您输入的密码有误，请重新输入！");
            XuiGai(aa);
        }else{
            sc = new Scanner(System.in);
            System.out.println("请输入您修改后的密码：");
            int password1 = sc.nextInt();
            System.out.println("请再一次确认您输入的密码：");
            int password2 = sc.nextInt();
            if (password1 == password2) {
                ul.setPassword(password1);
                System.out.println("您的用户名为：" +ul.getId());
                System.out.println("您的账号为：" +ul.getNum());
                System.out.println("您的密码为：" + ul.getPassword());
                Interface.ZX(aa);
            } else {
                System.out.println("您输入的密码有误，请重新输入！");
                XuiGai(aa);
            }
        }
    }

    //删除账号
    public static void ShanChu(int aa){
        System.out.println("您想使用哪种方法查询您要删除的账号：");
        System.out.println("1.查找用户名");
        System.out.println("2.查找账号");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        switch (x){
            case 1:
                System.out.println("请输入您要查找的用户名：");
                String id = sc.next();
                for(int i=0;i<arr.size();i++){
                    Users ul = (Users)arr.get(i);
                    if(id.equals(ul.getId())){
                        System.out.println("您所查找的用户已找到：");
                        System.out.println("用户名：" + ul.getId());
                        System.out.println("账号" + ul.getNum());
                        System.out.println("金额" + ul.getMoney());
                        System.out.println("您确定要删除此用户吗？");
                        System.out.println("1.是       2.否");
                        sc = new Scanner(System.in);
                        x = sc.nextInt();
                        switch (x){
                            case 1:
                                ul.setId(null);
                                ul.setPassword(0);
                                ul.setNum(0);
                                System.out.println("删除成功！");
                                break;
                            case 2:
                                break;
                        }
                        Interface.ZX(aa);
                        break;
                    }else {
                        System.out.println("查无此人！");
                        Interface.ZX(aa);
                        break;
                    }
                }
            case 2:
                System.out.println("请输入您要查找的账号：");
                int num = sc.nextInt();
                for(int i=0;i<arr.size();i++){
                    Users ul = (Users)arr.get(i);
                    if(num == ul.getNum()){
                        System.out.println("您所查找的用户已找到：");
                        System.out.println("用户名：" + ul.getId());
                        System.out.println("账号" + ul.getNum());
                        System.out.println("金额" + ul.getMoney());
                        System.out.println("您确定要删除此用户吗？");
                        System.out.println("1.是       2.否");
                        sc = new Scanner(System.in);
                        x = sc.nextInt();
                        switch (x){
                            case 1:
                                ul.setId(null);
                                ul.setPassword(0);
                                ul.setNum(0);
                                System.out.println("删除成功！");
                                break;
                            case 2:
                                break;
                        }
                        Interface.ZX(aa);
                        break;
                    }else {
                        System.out.println("查无此人！");
                        Interface.ZX(aa);
                        break;
                    }
                }
        }
    }

    //退出
}

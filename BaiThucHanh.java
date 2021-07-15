/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaiThucHanh {

    public static void main(String[] args) {
        try {
            ConnectDatabase db=new ConnectDatabase();
            db.connectDataBase();
             List<SanPham> listSP =  db.SanPhams();
       
        listSP.forEach(e -> System.out.println(e));
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--------------------------------");
        System.out.print("Nhập tên loại sản phẩm cần thêm: ");
        String NameSP = sc.nextLine();
        db.insertLoaiSP(NameSP);
        List<LoaiSanPham> listLSP = db.LoaiSanPhams();
        System.out.printf("%-15s%-30s\n","Mã loại SP","Tên Loại SP");
        listLSP.forEach(e-> System.out.println(e));
        } catch (Exception e) {
        }
    }
   
}


﻿use master 
go
create database SP
go
use SP
go
create table LoaiSanPham(
MaLoaiSP int identity(1,1) primary key,
TenLoaiSP nvarchar(50)
)
go
create table SanPham(
MaSP int identity(1,1) primary key,
TenSP nvarchar(50),
NhaSanXuat nvarchar (50),
MaLoaiSP int,
constraint fk foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP)
)
go
insert into LoaiSanPham values (N'TiVi'), (N'Điện thoại') 
go 

insert into SanPham values (N'TiVi Sony',N'Sony',1), (N'TiVi SamSung',N'SamSung',1), 
(N'Điện thoại Oppo A37',N'Oppo',2), (N'Điện thoại Oppo A50',N'Oppo',2), (N'Điện thoại SamSung S10',N'SamSung',2)
go
select * from LoaiSanPham
select * from SanPham
CREATE DATABASE BookStore;

USE BookStore;
CREATE TABLE tacgia (
    matacgia VARCHAR(255) PRIMARY KEY NOT NULL,
    hoten NVARCHAR(255),
    ngaysinh DATE,
	tieusu TEXT
);

CREATE TABLE theloai (
    matheloai VARCHAR(50) PRIMARY KEY NOT NULL,
    tentheoloai VARCHAR(255),
);

CREATE TABLE sanpham (
    masanpham VARCHAR(50) PRIMARY KEY NOT NULL,
    tensanpham VARCHAR(255),
	matacgia VARCHAR(255), 
	namxuatban INT,
	gianhap FLOAT,
	giagoc FLOAT,
	giaban FLOAT,
	soluong FLOAT,
	matheloai VARCHAR(50),
	ngonngu NVARCHAR(255),
	mota TEXT,
	FOREIGN KEY (matacgia) REFERENCES tacgia(matacgia),
	FOREIGN KEY (matheloai) REFERENCES theloai(matheloai)
);
CREATE TABLE khachhang (
    makhachhang VARCHAR(255) PRIMARY KEY NOT NULL,
    tendangnhap VARCHAR(50),
	matkhau VARCHAR(512),
	hoten NVARCHAR (255),
	gioitinh NVARCHAR(10),
	diachi NVARCHAR(512),
	diachinhanhang VARCHAR(512),
	diachimuahang VARCHAR(512),
	ngaysinh DATE,
	sodienthoai VARCHAR(255),
	email VARCHAR(255),
	dangkynhantin TINYINT,
	maxacthuc varchar(100),
	thoigianhieuluc DATETIME,
	trangthaixacthuc TINYINT
);

CREATE TABLE donhang (
    madonhang VARCHAR(50) PRIMARY KEY NOT NULL,
    makhachhang VARCHAR(255),
	diachimuahang NVARCHAR(512),
	diachinhanhang NVARCHAR(512),
	trangthai VARCHAR(50),
	hinhthucthanhtoan VARCHAR(255),
	sotienthanhtoan VARCHAR(50),
	sothienconthieu VARCHAR(50),
	trangthaithanhtoan VARCHAR(255),
	ngaydathang DATE,
	ngaygiaohang DATE
	FOREIGN KEY (makhachhang) REFERENCES khachhang(makhachhang)
);
CREATE TABLE chitietdonhang (
    machitietdonhang VARCHAR(50) PRIMARY KEY NOT NULL,
    madonhang VARCHAR(50),
	masanpham VARCHAR(50),
	soluong FLOAT,
	giagoc FLOAT,
	giamgia FLOAT,
	giaban FLOAT,
	thueVAT FLOAT,
	tongtien FLOAT,
	FOREIGN KEY (madonhang) REFERENCES donhang(madonhang),
	FOREIGN KEY (masanpham) REFERENCES sanpham(masanpham)
);

drop database  BookStore
INSERT INTO tacgia (matacgia, hoten, ngaysinh, tieusu) VALUES
('TG001', N'Nguyễn Nhật Ánh', '1955-03-07', N'Tác giả của nhiều tác phẩm văn học nổi tiếng như Kính vạn hoa, Làm bác sĩ, Chạy trốn nơi cuối con đường,...'),
('TG002', N'Nguyễn Du', '1765-11-06', N'Nhà thơ, nhà văn nổi tiếng thời Lê trung hưng, Nguyễn Ánh'),
('TG003', N'Nam Cao', '1917-11-21', N'Tên thật là Trần Hữu Tri'),
('TG004', N'Tô Hoài', '1920-02-17', N'Tên thật là Trần Ngọc Hoài');

INSERT INTO theloai (matheloai, tentheoloai) VALUES
('TL001', N'Truyện ngắn'),
('TL002', N'Tiểu thuyết'),
('TL003', N'Trinh thám'),
('TL004', N'Trẻ em');

INSERT INTO sanpham (masanpham, tensanpham, matacgia, namxuatban, gianhap, giagoc ,giaban, soluong, matheloai, ngonngu, mota) VALUES
('SP001', N'Kính Vạn Hoa', 'TG001', 1994, 80000, 95000, 100000, 1000, 'TL001', N'Tiếng Việt', N'Truyện ngắn nổi tiếng của tác giả Nguyễn Nhật Ánh'),
('SP002', N'Truyện Kiều', 'TG002', 1820, 50000, 65000, 80000, 500, 'TL002', N'Tiếng Việt', N'Tiểu thuyết kinh điển của văn học Việt Nam'),
('SP003', N'Tiếng chim hót trong bụi mận gai', 'TG003', 1951, 120000, 150000,200000, 300, 'TL001', N'Tiếng Việt', N'Truyện ngắn nổi tiếng của tác giả Nam Cao'),
('SP004', N'Chuyện đêm muộn', 'TG004', 1964, 90000, 110000,150000, 200, 'TL001', N'Tiếng Việt', N'Truyện ngắn của Tô Hoài');

INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hoten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhantin)
VALUES
('KH001', 'user1', 'password1', 'Nguyen Van A', N'Nam', '123 Nguyen Trai, Quan 1, TP. Ho Chi Minh', '456 Le Loi, Quan 3, TP. Ho Chi Minh', '789 Nguyen Hue, Quan 1, TP. Ho Chi Minh', '1990-01-01', '0901234567','use1@gmail.com', 1),
('KH002', 'user2', 'password2', 'Tran Thi B', N'Nữ', '456 Nguyen Trai, Quan 1, TP. Ho Chi Minh', '123 Le Loi, Quan 3, TP. Ho Chi Minh', '789 Vo Van Tan, Quan 3, TP. Ho Chi Minh', '1995-02-15', '0907654321','use2@gmail.com', 0),
('KH003', 'user3', 'password3', 'Pham Van C', N'Nam', '789 Le Lai, Quan 1, TP. Ho Chi Minh', '456 Le Duan, Quan 1, TP. Ho Chi Minh', '123 Nguyen Van Cu, Quan 5, TP. Ho Chi Minh', '2000-05-20', '0908888888','use3@gmail.com', 1),
('KH004', 'user4', 'password4', 'Le Thi D', N'Nữ', '111 Bui Vien, Quan 1, TP. Ho Chi Minh', '222 Pham Ngu Lao, Quan 1, TP. Ho Chi Minh', '333 Vo Van Kiet, Quan 1, TP. Ho Chi Minh', '1998-12-25', '0909999999','use4@gmail.com', 0);

INSERT INTO donhang (madonhang, makhachhang, diachimuahang, diachinhanhang, trangthai, hinhthucthanhtoan, sotienthanhtoan, sothienconthieu, trangthaithanhtoan, ngaydathang, ngaygiaohang)
VALUES 
('DH001', 'KH001', '123 Đường 1, Quận 1, TP.HCM', '456 Đường 2, Quận 2, TP.HCM', 'Đang giao', 'COD', '250000', '0', 'Chưa thanh toán', '2023-04-22', '2023-04-25'),
('DH002', 'KH002', '789 Đường 3, Quận 3, TP.HCM', '012 Đường 4, Quận 4, TP.HCM', 'Đã giao', 'Online', '1200000', '0', 'Đã thanh toán', '2023-04-21', '2023-04-23'),
('DH003', 'KH003', '456 Đường 5, Quận 5, TP.HCM', '789 Đường 6, Quận 6, TP.HCM', 'Đang xử lý', 'Credit card', '350000', '0', 'Chưa thanh toán', '2023-04-22', NULL),
('DH004', 'KH002', '012 Đường 4, Quận 4, TP.HCM', '456 Đường 5, Quận 5, TP.HCM', 'Chờ xử lý', 'COD', '650000', '0', 'Chưa thanh toán', '2023-04-23', NULL);

INSERT INTO chitietdonhang (machitietdonhang, madonhang, masanpham, soluong, giagoc, giamgia, thueVAT, tongtien)
VALUES 
('CTDH001', 'DH001', 'SP001', '1', '250000', '0', '0.1', '275000'),
('CTDH002', 'DH001', 'SP002', '2', '350000', '0', '0.1', '770000'),
('CTDH003', 'DH002', 'SP004', '1', '1200000', '0', '0.1', '1320000'),
('CTDH004', 'DH003', 'SP003', '1', '350000', '0', '0.1', '385000'),
('CTDH005', 'DH004', 'SP002', '2', '350000', '50000', '0.1', '700000')

select * from khachhang
INSERT INTO tacgia VALUES ('TG005','','','')
SELECT * FROM sanpham

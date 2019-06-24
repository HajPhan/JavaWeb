package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ProductDetails", schema = "SaleOnline", catalog = "")
public class ProductDetailsEntity {
    private int productId;
    private String doPhanGiaiManHinh;
    private String cameraTruoc;
    private String cameraSau;
    private String tocDoCpu;
    private String soNhan;
    private String chipset;
    private String ram;
    private String gpu;
    private String rom;
    private String kichThuoc;
    private String congNgheManHinh;
    private String mauManHinh;
    private String chuanManHinh;
    private String congNgheCamUng;
    private String matKinhManHinh;
    private String videoCall;
    private String doPhanGiaiTruoc;
    private String thongTinKhac;
    private String doPhanGiaiSau;
    private String quayPhim;
    private String denFlash;
    private String chupAnhNangCao;
    private String danhBaLuTru;
    private String theNhoNgoai;
    private String hoTroTheNhoToiDa;
    private String kieuDang;
    private String chatLieu;
    private String trongluong;
    private String khaNangChongNuoc;
    private String loaiPin;
    private String dungLuongPin;
    private String pinCoTheThaoRoi;
    private String thoGianCho;
    private String thoiGianDamThoai;
    private String cheDoSac;
    private String manginternet;
    private String wifi;
    private String hoTroSim;
    private String kheCamSim;
    private String gps;
    private String bluetooth;
    private String nfc;
    private String ketNoiUsb;
    private String congKetNoiKhac;
    private String congSac;
    private String jackTaiKhe;
    private String xemPhim;
    private String ngheNhac;
    private String ghiAm;
    private String fmRadio;
    private String denPin;
    private String ungDungKhac;

    @Id
    @Column(name = "product_Id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "DoPhanGiaiManHinh")
    public String getDoPhanGiaiManHinh() {
        return doPhanGiaiManHinh;
    }

    public void setDoPhanGiaiManHinh(String doPhanGiaiManHinh) {
        this.doPhanGiaiManHinh = doPhanGiaiManHinh;
    }

    @Basic
    @Column(name = "CameraTruoc")
    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    @Basic
    @Column(name = "CameraSau")
    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    @Basic
    @Column(name = "TocDoCpu")
    public String getTocDoCpu() {
        return tocDoCpu;
    }

    public void setTocDoCpu(String tocDoCpu) {
        this.tocDoCpu = tocDoCpu;
    }

    @Basic
    @Column(name = "SoNhan")
    public String getSoNhan() {
        return soNhan;
    }

    public void setSoNhan(String soNhan) {
        this.soNhan = soNhan;
    }

    @Basic
    @Column(name = "Chipset")
    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Basic
    @Column(name = "Ram")
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Basic
    @Column(name = "Gpu")
    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    @Basic
    @Column(name = "Rom")
    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    @Basic
    @Column(name = "KichThuoc")
    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    @Basic
    @Column(name = "CongNgheManHinh")
    public String getCongNgheManHinh() {
        return congNgheManHinh;
    }

    public void setCongNgheManHinh(String congNgheManHinh) {
        this.congNgheManHinh = congNgheManHinh;
    }

    @Basic
    @Column(name = "MauManHinh")
    public String getMauManHinh() {
        return mauManHinh;
    }

    public void setMauManHinh(String mauManHinh) {
        this.mauManHinh = mauManHinh;
    }

    @Basic
    @Column(name = "ChuanManHinh")
    public String getChuanManHinh() {
        return chuanManHinh;
    }

    public void setChuanManHinh(String chuanManHinh) {
        this.chuanManHinh = chuanManHinh;
    }

    @Basic
    @Column(name = "CongNgheCamUng")
    public String getCongNgheCamUng() {
        return congNgheCamUng;
    }

    public void setCongNgheCamUng(String congNgheCamUng) {
        this.congNgheCamUng = congNgheCamUng;
    }

    @Basic
    @Column(name = "MatKinhManHinh")
    public String getMatKinhManHinh() {
        return matKinhManHinh;
    }

    public void setMatKinhManHinh(String matKinhManHinh) {
        this.matKinhManHinh = matKinhManHinh;
    }

    @Basic
    @Column(name = "VideoCall")
    public String getVideoCall() {
        return videoCall;
    }

    public void setVideoCall(String videoCall) {
        this.videoCall = videoCall;
    }

    @Basic
    @Column(name = "DoPhanGiaiTruoc")
    public String getDoPhanGiaiTruoc() {
        return doPhanGiaiTruoc;
    }

    public void setDoPhanGiaiTruoc(String doPhanGiaiTruoc) {
        this.doPhanGiaiTruoc = doPhanGiaiTruoc;
    }

    @Basic
    @Column(name = "ThongTinKhac")
    public String getThongTinKhac() {
        return thongTinKhac;
    }

    public void setThongTinKhac(String thongTinKhac) {
        this.thongTinKhac = thongTinKhac;
    }

    @Basic
    @Column(name = "DoPhanGiaiSau")
    public String getDoPhanGiaiSau() {
        return doPhanGiaiSau;
    }

    public void setDoPhanGiaiSau(String doPhanGiaiSau) {
        this.doPhanGiaiSau = doPhanGiaiSau;
    }

    @Basic
    @Column(name = "QuayPhim")
    public String getQuayPhim() {
        return quayPhim;
    }

    public void setQuayPhim(String quayPhim) {
        this.quayPhim = quayPhim;
    }

    @Basic
    @Column(name = "DenFlash")
    public String getDenFlash() {
        return denFlash;
    }

    public void setDenFlash(String denFlash) {
        this.denFlash = denFlash;
    }

    @Basic
    @Column(name = "ChupAnhNangCao")
    public String getChupAnhNangCao() {
        return chupAnhNangCao;
    }

    public void setChupAnhNangCao(String chupAnhNangCao) {
        this.chupAnhNangCao = chupAnhNangCao;
    }

    @Basic
    @Column(name = "DanhBaLuTru")
    public String getDanhBaLuTru() {
        return danhBaLuTru;
    }

    public void setDanhBaLuTru(String danhBaLuTru) {
        this.danhBaLuTru = danhBaLuTru;
    }

    @Basic
    @Column(name = "TheNhoNgoai")
    public String getTheNhoNgoai() {
        return theNhoNgoai;
    }

    public void setTheNhoNgoai(String theNhoNgoai) {
        this.theNhoNgoai = theNhoNgoai;
    }

    @Basic
    @Column(name = "HoTroTheNhoToiDa")
    public String getHoTroTheNhoToiDa() {
        return hoTroTheNhoToiDa;
    }

    public void setHoTroTheNhoToiDa(String hoTroTheNhoToiDa) {
        this.hoTroTheNhoToiDa = hoTroTheNhoToiDa;
    }

    @Basic
    @Column(name = "KieuDang")
    public String getKieuDang() {
        return kieuDang;
    }

    public void setKieuDang(String kieuDang) {
        this.kieuDang = kieuDang;
    }

    @Basic
    @Column(name = "ChatLieu")
    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    @Basic
    @Column(name = "Trongluong")
    public String getTrongluong() {
        return trongluong;
    }

    public void setTrongluong(String trongluong) {
        this.trongluong = trongluong;
    }

    @Basic
    @Column(name = "KhaNangChongNuoc")
    public String getKhaNangChongNuoc() {
        return khaNangChongNuoc;
    }

    public void setKhaNangChongNuoc(String khaNangChongNuoc) {
        this.khaNangChongNuoc = khaNangChongNuoc;
    }

    @Basic
    @Column(name = "LoaiPin")
    public String getLoaiPin() {
        return loaiPin;
    }

    public void setLoaiPin(String loaiPin) {
        this.loaiPin = loaiPin;
    }

    @Basic
    @Column(name = "DungLuongPin")
    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    @Basic
    @Column(name = "PinCoTheThaoRoi")
    public String getPinCoTheThaoRoi() {
        return pinCoTheThaoRoi;
    }

    public void setPinCoTheThaoRoi(String pinCoTheThaoRoi) {
        this.pinCoTheThaoRoi = pinCoTheThaoRoi;
    }

    @Basic
    @Column(name = "ThoGianCho")
    public String getThoGianCho() {
        return thoGianCho;
    }

    public void setThoGianCho(String thoGianCho) {
        this.thoGianCho = thoGianCho;
    }

    @Basic
    @Column(name = "ThoiGianDamThoai")
    public String getThoiGianDamThoai() {
        return thoiGianDamThoai;
    }

    public void setThoiGianDamThoai(String thoiGianDamThoai) {
        this.thoiGianDamThoai = thoiGianDamThoai;
    }

    @Basic
    @Column(name = "CheDoSac")
    public String getCheDoSac() {
        return cheDoSac;
    }

    public void setCheDoSac(String cheDoSac) {
        this.cheDoSac = cheDoSac;
    }

    @Basic
    @Column(name = "Manginternet")
    public String getManginternet() {
        return manginternet;
    }

    public void setManginternet(String manginternet) {
        this.manginternet = manginternet;
    }

    @Basic
    @Column(name = "Wifi")
    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    @Basic
    @Column(name = "HoTroSim")
    public String getHoTroSim() {
        return hoTroSim;
    }

    public void setHoTroSim(String hoTroSim) {
        this.hoTroSim = hoTroSim;
    }

    @Basic
    @Column(name = "KheCamSim")
    public String getKheCamSim() {
        return kheCamSim;
    }

    public void setKheCamSim(String kheCamSim) {
        this.kheCamSim = kheCamSim;
    }

    @Basic
    @Column(name = "GPS")
    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    @Basic
    @Column(name = "Bluetooth")
    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    @Basic
    @Column(name = "NFC")
    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    @Basic
    @Column(name = "KetNoiUsb")
    public String getKetNoiUsb() {
        return ketNoiUsb;
    }

    public void setKetNoiUsb(String ketNoiUsb) {
        this.ketNoiUsb = ketNoiUsb;
    }

    @Basic
    @Column(name = "CongKetNoiKhac")
    public String getCongKetNoiKhac() {
        return congKetNoiKhac;
    }

    public void setCongKetNoiKhac(String congKetNoiKhac) {
        this.congKetNoiKhac = congKetNoiKhac;
    }

    @Basic
    @Column(name = "CongSac")
    public String getCongSac() {
        return congSac;
    }

    public void setCongSac(String congSac) {
        this.congSac = congSac;
    }

    @Basic
    @Column(name = "JackTaiKhe")
    public String getJackTaiKhe() {
        return jackTaiKhe;
    }

    public void setJackTaiKhe(String jackTaiKhe) {
        this.jackTaiKhe = jackTaiKhe;
    }

    @Basic
    @Column(name = "XemPhim")
    public String getXemPhim() {
        return xemPhim;
    }

    public void setXemPhim(String xemPhim) {
        this.xemPhim = xemPhim;
    }

    @Basic
    @Column(name = "NgheNhac")
    public String getNgheNhac() {
        return ngheNhac;
    }

    public void setNgheNhac(String ngheNhac) {
        this.ngheNhac = ngheNhac;
    }

    @Basic
    @Column(name = "GhiAm")
    public String getGhiAm() {
        return ghiAm;
    }

    public void setGhiAm(String ghiAm) {
        this.ghiAm = ghiAm;
    }

    @Basic
    @Column(name = "FMRadio")
    public String getFmRadio() {
        return fmRadio;
    }

    public void setFmRadio(String fmRadio) {
        this.fmRadio = fmRadio;
    }

    @Basic
    @Column(name = "DenPin")
    public String getDenPin() {
        return denPin;
    }

    public void setDenPin(String denPin) {
        this.denPin = denPin;
    }

    @Basic
    @Column(name = "UngDungKhac")
    public String getUngDungKhac() {
        return ungDungKhac;
    }

    public void setUngDungKhac(String ungDungKhac) {
        this.ungDungKhac = ungDungKhac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailsEntity that = (ProductDetailsEntity) o;
        return productId == that.productId &&
                Objects.equals(doPhanGiaiManHinh, that.doPhanGiaiManHinh) &&
                Objects.equals(cameraTruoc, that.cameraTruoc) &&
                Objects.equals(cameraSau, that.cameraSau) &&
                Objects.equals(tocDoCpu, that.tocDoCpu) &&
                Objects.equals(soNhan, that.soNhan) &&
                Objects.equals(chipset, that.chipset) &&
                Objects.equals(ram, that.ram) &&
                Objects.equals(gpu, that.gpu) &&
                Objects.equals(rom, that.rom) &&
                Objects.equals(kichThuoc, that.kichThuoc) &&
                Objects.equals(congNgheManHinh, that.congNgheManHinh) &&
                Objects.equals(mauManHinh, that.mauManHinh) &&
                Objects.equals(chuanManHinh, that.chuanManHinh) &&
                Objects.equals(congNgheCamUng, that.congNgheCamUng) &&
                Objects.equals(matKinhManHinh, that.matKinhManHinh) &&
                Objects.equals(videoCall, that.videoCall) &&
                Objects.equals(doPhanGiaiTruoc, that.doPhanGiaiTruoc) &&
                Objects.equals(thongTinKhac, that.thongTinKhac) &&
                Objects.equals(doPhanGiaiSau, that.doPhanGiaiSau) &&
                Objects.equals(quayPhim, that.quayPhim) &&
                Objects.equals(denFlash, that.denFlash) &&
                Objects.equals(chupAnhNangCao, that.chupAnhNangCao) &&
                Objects.equals(danhBaLuTru, that.danhBaLuTru) &&
                Objects.equals(theNhoNgoai, that.theNhoNgoai) &&
                Objects.equals(hoTroTheNhoToiDa, that.hoTroTheNhoToiDa) &&
                Objects.equals(kieuDang, that.kieuDang) &&
                Objects.equals(chatLieu, that.chatLieu) &&
                Objects.equals(trongluong, that.trongluong) &&
                Objects.equals(khaNangChongNuoc, that.khaNangChongNuoc) &&
                Objects.equals(loaiPin, that.loaiPin) &&
                Objects.equals(dungLuongPin, that.dungLuongPin) &&
                Objects.equals(pinCoTheThaoRoi, that.pinCoTheThaoRoi) &&
                Objects.equals(thoGianCho, that.thoGianCho) &&
                Objects.equals(thoiGianDamThoai, that.thoiGianDamThoai) &&
                Objects.equals(cheDoSac, that.cheDoSac) &&
                Objects.equals(manginternet, that.manginternet) &&
                Objects.equals(wifi, that.wifi) &&
                Objects.equals(hoTroSim, that.hoTroSim) &&
                Objects.equals(kheCamSim, that.kheCamSim) &&
                Objects.equals(gps, that.gps) &&
                Objects.equals(bluetooth, that.bluetooth) &&
                Objects.equals(nfc, that.nfc) &&
                Objects.equals(ketNoiUsb, that.ketNoiUsb) &&
                Objects.equals(congKetNoiKhac, that.congKetNoiKhac) &&
                Objects.equals(congSac, that.congSac) &&
                Objects.equals(jackTaiKhe, that.jackTaiKhe) &&
                Objects.equals(xemPhim, that.xemPhim) &&
                Objects.equals(ngheNhac, that.ngheNhac) &&
                Objects.equals(ghiAm, that.ghiAm) &&
                Objects.equals(fmRadio, that.fmRadio) &&
                Objects.equals(denPin, that.denPin) &&
                Objects.equals(ungDungKhac, that.ungDungKhac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, doPhanGiaiManHinh, cameraTruoc, cameraSau, tocDoCpu, soNhan, chipset, ram, gpu, rom, kichThuoc, congNgheManHinh, mauManHinh, chuanManHinh, congNgheCamUng, matKinhManHinh, videoCall, doPhanGiaiTruoc, thongTinKhac, doPhanGiaiSau, quayPhim, denFlash, chupAnhNangCao, danhBaLuTru, theNhoNgoai, hoTroTheNhoToiDa, kieuDang, chatLieu, trongluong, khaNangChongNuoc, loaiPin, dungLuongPin, pinCoTheThaoRoi, thoGianCho, thoiGianDamThoai, cheDoSac, manginternet, wifi, hoTroSim, kheCamSim, gps, bluetooth, nfc, ketNoiUsb, congKetNoiKhac, congSac, jackTaiKhe, xemPhim, ngheNhac, ghiAm, fmRadio, denPin, ungDungKhac);
    }
}

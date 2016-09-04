package main;

import java.io.IOException;

import core.SmallBinaryFile;

public class Tes {
	public static void main (String[] args) throws IOException {
		Encryptor enc = new Encryptor();
		SmallBinaryFile sf = new SmallBinaryFile();
		
		byte[] s = sf.readByte("C:/Users/muhtarh/Pictures/download.jpg");
		byte[] e = enc.encrypt(s, "maros", 1);
		sf.writeByte(e, "C:/Users/muhtarh/Pictures/download_enc.jpg");
		
		byte[] sdec = sf.readByte("C:/Users/muhtarh/Pictures/download_enc.jpg");
		byte[] df = enc.decrypt(sdec, "maros", 1);
		sf.writeByte(df, "C:/Users/muhtarh/Pictures/download_dec.jpg");
		
		String pltx = "halo nama saya & ^ shd - dj = **";
		String ef = enc.encrypt(pltx, "maros", 1);
		System.out.println(ef);
		String dff = enc.decrypt(ef, "maros", 1);
		System.out.println(dff);
		
	}
}

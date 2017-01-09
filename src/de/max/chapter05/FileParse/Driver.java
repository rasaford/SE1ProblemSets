package de.max.chapter05.FileParse;

public class Driver {
	public static void main(String[] args)
	{
		String dir = "/usr/bin/firefox";
		String dir2 = "C:\\programms\\openvpn\\conf\\hdm.ovpn";
		String dir3 = "..\\..\\..\\..\\..\\..\\..\\..\\openvpn\\conf\\hdm.ovpn";
		FileInfo a = new FileInfo(dir);
		a.printInfo();
		System.out.println();
		FileInfo b = new FileInfo(dir2);
		b.printInfo();
		System.out.println();
		FileInfo c = new FileInfo(dir3);
		c.printInfo();
		
	}
}

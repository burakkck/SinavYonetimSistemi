package com.sinavgirisbelgesi.servlet.admin;

import java.util.ArrayList;

public class SiraKontrol{
	public static int kontrol(ArrayList<Integer> siralar, int sira){
		int deger = 0;
		if(siralar.size() > 0){
			for (int j = 0;j < siralar.size(); j++) {
				if (siralar.get(j) == sira) {
					deger = 0;
					break;
				}else{
					deger = 1;
				}
			}
		}
		else {
			deger = 1;
		}
		return deger;
	}
}
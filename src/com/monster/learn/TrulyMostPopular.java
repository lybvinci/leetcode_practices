package com.monster.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TrulyMostPopular {
	//59.07%
	public String[] trulyMostPopular(String[] names, String[] synonyms) {
		//用hashmap表存频率，字典序就是按顺序一次比较每个字符大小
		Map<String, Integer> map = new HashMap<>();
		Map<String, String> nmap = new HashMap<>();
		//统计频率
		for(String name : names){
				int index1 = name.indexOf('('), index2 = name.indexOf(')');
				map.put(name.substring(0, index1), Integer.parseInt(name.substring(index1 + 1, index2)));
				//System.out.println(name.substring(0, index1) + " " + Integer.parseInt(name.substring(index1 + 1, index2)));
		}
		//字典序小的在后，大的都在前
		for(String name : synonyms){
				int index = name.indexOf(','), i = 0;
				String str1 = name.substring(1, index), str2 = name.substring(index + 1, name.length() - 1);
				while (nmap.containsKey(str1)) {   //找str1祖宗
						str1 = nmap.get(str1);
				}
				while (nmap.containsKey(str2)) {   //找str2祖宗
						str2 = nmap.get(str2);
				}
				if(!str1.equals(str2)){   //祖宗不同，要合并
						int frequency = map.getOrDefault(str1, 0) + map.getOrDefault(str2, 0);    //出现次数是两者之和
						String trulyName = str1.compareTo(str2) < 0 ? str1 : str2;
						String nickName = str1.compareTo(str2) < 0 ? str2 : str1;
						nmap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
						map.remove(nickName);       //更新一下数据
						map.put(trulyName, frequency);
				}
		}
		int i = 0;
		String[] strs = new String[map.size()];
		for(String name : map.keySet()){
				StringBuffer sb = new StringBuffer(name);
				sb.append("(");
				sb.append(map.get(name));
				sb.append(")");
				strs[i++] = sb.toString();
		}  
		return strs;
	}	

	public static void main(String[] args) {
		TrulyMostPopular tmp = new TrulyMostPopular();
		tmp.trulyMostPopular(new String[] {"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)" },
				new String[]{"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"});
	}
}

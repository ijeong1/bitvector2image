package bitvector2image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class bitvector2image {
	public static void main(String[] args) {
		//File Load
		try {
			File file = new File("C:\\Users\\J\\Desktop\\Research\\CNN\\Data\\KDDTrain+.txt"); //Windows
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			int linenumber = 1;
			
			//while (linenumber<125973) {
			while (linenumber < 125973) {
				int sbits[] = new int[512]; //464
				for(int i = 464;i<512;i++) {
					sbits[i] = 0;
				}
				line = bufferedReader.readLine();
				//split a comma-separated string into array
				String[] elephantList = line.split(",");
				for(int i = 0 ; i<elephantList.length;i++) {
					if(i==0) { //#1 Duration
						//Min 0, MAX 42908
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = (float)xValue/(float)42908;
						if(newX <= 0.1) {
							sbits[0] = 1;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[0] = 0;
							sbits[1] = 1;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 1;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 1;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 1;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 1;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 1;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 1;
							sbits[8] = 0;
							sbits[9] = 0;
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 1;
							sbits[9] = 0;
						}else if(newX > 0.9 && newX <= 1) {
							sbits[0] = 0;
							sbits[1] = 0;
							sbits[2] = 0;
							sbits[3] = 0;
							sbits[4] = 0;
							sbits[5] = 0;
							sbits[6] = 0;
							sbits[7] = 0;
							sbits[8] = 0;
							sbits[9] = 1;
						}
						else {
							System.out.println("Error0");
							System.exit(0);
						}
					}
					if(i==1) { //TCP, UDP, ICMP
						if(elephantList[i].matches("tcp")) {
							sbits[10] = 1;
							sbits[11] = 0;
							sbits[12] = 0;
						}else if(elephantList[i].matches("udp")){
							sbits[10] = 0;
							sbits[11] = 1;
							sbits[12] = 0;
						}else if(elephantList[i].matches("icmp")){
							sbits[01] = 0;
							sbits[11] = 0;
							sbits[12] = 1;
						}else {
							System.out.println("Error1");
							System.exit(0);
						}
					}
					
					if(i==2) { //Service Type
						int [] temp = serviceTypeToIntArray(elephantList[i]);
						sbits[13] = temp[0]; //1
						sbits[14] = temp[1]; //2
						sbits[15] = temp[2]; //3
						sbits[16] = temp[3]; //4
						sbits[17] = temp[4]; //5
						sbits[18] = temp[5]; //6
						sbits[19] = temp[6]; //7
						sbits[20] = temp[7]; //8
						sbits[21] = temp[8]; //9
						sbits[22] = temp[9]; //10

						sbits[23] = temp[10]; //11
						sbits[24] = temp[11]; //12
						sbits[25] = temp[12]; //13
						sbits[26] = temp[13]; //14
						sbits[27] = temp[14]; //15
						sbits[28] = temp[15]; //16
						sbits[29] = temp[16]; //17
						sbits[30] = temp[17]; //18
						sbits[31] = temp[18]; //19
						sbits[32] = temp[19]; //20

						sbits[33] = temp[20]; //21
						sbits[34] = temp[21]; //22
						sbits[35] = temp[22]; //23
						sbits[36] = temp[23]; //24
						sbits[37] = temp[24]; //25
						sbits[38] = temp[25]; //26
						sbits[39] = temp[26]; //27
						sbits[40] = temp[27]; //28
						sbits[41] = temp[28]; //29
						sbits[42] = temp[29]; //30

						sbits[43] = temp[30]; //31
						sbits[44] = temp[31]; //32
						sbits[45] = temp[32]; //33
						sbits[46] = temp[33]; //34
						sbits[47] = temp[34]; //35
						sbits[48] = temp[35]; //36
						sbits[49] = temp[36]; //37
						sbits[50] = temp[37]; //38
						sbits[51] = temp[38]; //39
						sbits[52] = temp[39]; //40

						sbits[53] = temp[40]; //41
						sbits[54] = temp[41]; //42
						sbits[55] = temp[42]; //43
						sbits[56] = temp[43]; //44
						sbits[57] = temp[44]; //45
						sbits[58] = temp[45]; //46
						sbits[59] = temp[46]; //47
						sbits[60] = temp[47]; //48
						sbits[61] = temp[48]; //49
						sbits[62] = temp[49]; //50

						sbits[63] = temp[50]; //51
						sbits[64] = temp[51]; //52
						sbits[65] = temp[52]; //53
						sbits[66] = temp[53]; //54
						sbits[67] = temp[54]; //55
						sbits[68] = temp[55]; //56
						sbits[69] = temp[56]; //57
						sbits[70] = temp[57]; //58
						sbits[71] = temp[58]; //59
						sbits[72] = temp[59]; //60

						sbits[73] = temp[60]; //61
						sbits[74] = temp[61]; //62
						sbits[75] = temp[62]; //63
						sbits[76] = temp[63]; //64
						sbits[77] = temp[64]; //65
						sbits[78] = temp[65]; //66
						sbits[79] = temp[66]; //67
						sbits[80] = temp[67]; //68
						sbits[81] = temp[68]; //69
						sbits[82] = temp[69]; //70
					}
					//Column 4 Flag
					if(i==3) { //Flag
						if(elephantList[i].matches("SF")) {
							
							sbits[83] = 1; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("S0")){
							
							sbits[83] = 0; //1
							sbits[84] = 1; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("REJ")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 1; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("RSTR")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 1; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("SH")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 1; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("RSTO")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 1; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("S1")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 1; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("RSTOS0")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 1; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("S3")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 1; //9
							sbits[92] = 0; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("S2")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 1; //10
							sbits[93] = 0; //11
							
						}else if(elephantList[i].matches("OTH")){
							
							sbits[83] = 0; //1
							sbits[84] = 0; //2
							sbits[85] = 0; //3
							sbits[86] = 0; //4
							sbits[87] = 0; //5
							sbits[88] = 0; //6
							sbits[89] = 0; //7
							sbits[90] = 0; //8
							sbits[91] = 0; //9
							sbits[92] = 0; //10
							sbits[93] = 1; //11
						}else {
							System.out.println("Error3");
							System.exit(0);
						}
					}
					//Column 5
					if(i==4) {
						// Max 1379963888
						// Min 0//Min 0, MAX 42908
						// float newX = (float)xValue - MinValue/(float)42908 - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = (float)xValue/(float)1379963888;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[94] 	= 1; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 1; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 1; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 1; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 1; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 1; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 1; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 1; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 1; //9
							sbits[103] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[94] 	= 0; //1
							sbits[95] 	= 0; //2
							sbits[96] 	= 0; //3
							sbits[97] 	= 0; //4
							sbits[98] 	= 0; //5
							sbits[99] 	= 0; //6
							sbits[100] 	= 0; //7
							sbits[101] 	= 0; //8
							sbits[102] 	= 0; //9
							sbits[103] 	= 1; //10
						}else {
							System.out.println("Error4");
							System.exit(0);
						}
					}
					// Column 6
					if(i==5) {
						// Max 1309937401
						// Min 0
						// float newX = (float)xValue - MinValue/(float)42908 - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = (float)xValue/(float)1309937401;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[104] 	= 1; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 1; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 1; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 1; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 1; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 1; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 1; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 1; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 1; //9
							sbits[113] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[104] 	= 0; //1
							sbits[105] 	= 0; //2
							sbits[106] 	= 0; //3
							sbits[107] 	= 0; //4
							sbits[108] 	= 0; //5
							sbits[109] 	= 0; //6
							sbits[110] 	= 0; //7
							sbits[111] 	= 0; //8
							sbits[112] 	= 0; //9
							sbits[113] 	= 1; //10
						}else {
							System.out.println("Error5");
							System.exit(0);
						}
					}
					if(i==6) { //Column 7
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/1;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[114] 	= 1; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 1; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 1; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 1; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 1; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 1; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 1; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 1; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 1; //9
							sbits[123] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[114] 	= 0; //1
							sbits[115] 	= 0; //2
							sbits[116] 	= 0; //3
							sbits[117] 	= 0; //4
							sbits[118] 	= 0; //5
							sbits[119] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[121] 	= 0; //8
							sbits[122] 	= 0; //9
							sbits[123] 	= 1; //10
						}else {
							System.out.println("Error6");
							System.exit(0);
						}
					}
					if(i==7) { //Column 8
						// Max 3
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/3;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[124] 	= 1; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[120] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 1; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 1; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 1; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 1; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 1; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 1; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 1; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 1; //9
							sbits[133] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[124] 	= 0; //1
							sbits[125] 	= 0; //2
							sbits[126] 	= 0; //3
							sbits[127] 	= 0; //4
							sbits[128] 	= 0; //5
							sbits[129] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[131] 	= 0; //8
							sbits[132] 	= 0; //9
							sbits[133] 	= 1; //10
						}else {
							System.out.println("Error7");
							System.exit(0);
						}
					}
					
					if(i==8) { //Column 9
						// Max 3
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/3;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[134] 	= 1; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[130] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 1; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 1; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 1; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 1; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 1; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 1; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 1; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 1; //9
							sbits[143] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[134] 	= 0; //1
							sbits[135] 	= 0; //2
							sbits[136] 	= 0; //3
							sbits[137] 	= 0; //4
							sbits[138] 	= 0; //5
							sbits[139] 	= 0; //6
							sbits[140] 	= 0; //7
							sbits[141] 	= 0; //8
							sbits[142] 	= 0; //9
							sbits[143] 	= 1; //10
						}else {
							System.out.println("Error8");
							System.exit(0);
						}
					}
					// Column 10
					if(i==9) {
						// Max 77
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/77;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[144] 	= 1; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 1; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 1; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 1; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 1; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 1; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 1; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 1; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 1; //9
							sbits[153] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[144] 	= 0; //1
							sbits[145] 	= 0; //2
							sbits[146] 	= 0; //3
							sbits[147] 	= 0; //4
							sbits[148] 	= 0; //5
							sbits[149] 	= 0; //6
							sbits[150] 	= 0; //7
							sbits[151] 	= 0; //8
							sbits[152] 	= 0; //9
							sbits[153] 	= 1; //10
						}else {
							System.out.println("Error9");
							System.exit(0);
						}
					}
					//Column 11
					if(i==10) {
						// Max 5
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/5;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[154] 	= 1; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 1; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 1; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 1; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 1; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 1; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 1; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 1; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 1; //9
							sbits[163] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[154] 	= 0; //1
							sbits[155] 	= 0; //2
							sbits[156] 	= 0; //3
							sbits[157] 	= 0; //4
							sbits[158] 	= 0; //5
							sbits[159] 	= 0; //6
							sbits[160] 	= 0; //7
							sbits[161] 	= 0; //8
							sbits[162] 	= 0; //9
							sbits[163] 	= 1; //10
						}else {
							System.out.println("Error10");
							System.exit(0);
						}
					}
					
					//Column 12 (164~173)
					if(i==11) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/1;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[164] 	= 1; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 1; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 1; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 1; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 1; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 1; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 1; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 1; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 1; //9
							sbits[173] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[164] 	= 0; //1
							sbits[165] 	= 0; //2
							sbits[166] 	= 0; //3
							sbits[167] 	= 0; //4
							sbits[168] 	= 0; //5
							sbits[169] 	= 0; //6
							sbits[170] 	= 0; //7
							sbits[171] 	= 0; //8
							sbits[172] 	= 0; //9
							sbits[173] 	= 1; //10
						}else {
							System.out.println("Error11");
							System.exit(0);
						}
					}
					
					//Column 13 (174~183)
					if(i==12) {
						// Max 7479
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/7479;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[174] 	= 1; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 1; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 1; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 1; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 1; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 1; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 1; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 1; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 1; //9
							sbits[183] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[174] 	= 0; //1
							sbits[175] 	= 0; //2
							sbits[176] 	= 0; //3
							sbits[177] 	= 0; //4
							sbits[178] 	= 0; //5
							sbits[179] 	= 0; //6
							sbits[180] 	= 0; //7
							sbits[181] 	= 0; //8
							sbits[182] 	= 0; //9
							sbits[183] 	= 1; //10
						}else {
							System.out.println("Error12");
							System.exit(0);
						}
					}
					
					//Column 14 (184~193)
					if(i==13) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/1;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[184] 	= 1; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 1; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 1; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 1; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 1; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 1; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 1; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 1; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 1; //9
							sbits[193] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[184] 	= 0; //1
							sbits[185] 	= 0; //2
							sbits[186] 	= 0; //3
							sbits[187] 	= 0; //4
							sbits[188] 	= 0; //5
							sbits[189] 	= 0; //6
							sbits[190] 	= 0; //7
							sbits[191] 	= 0; //8
							sbits[192] 	= 0; //9
							sbits[193] 	= 1; //10
						}else {
							System.out.println("Error13");
							System.exit(0);
						}
					}
					
					//Column 15 (194~203)
					if(i==14) {
						// Max 2
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/2;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[194] 	= 1; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 1; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 1; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 1; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 1; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 1; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 1; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 1; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 1; //9
							sbits[203] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[194] 	= 0; //1
							sbits[195] 	= 0; //2
							sbits[196] 	= 0; //3
							sbits[197] 	= 0; //4
							sbits[198] 	= 0; //5
							sbits[199] 	= 0; //6
							sbits[200] 	= 0; //7
							sbits[201] 	= 0; //8
							sbits[202] 	= 0; //9
							sbits[203] 	= 1; //10
						}else {
							System.out.println("Error14");
							System.exit(0);
						}
					}
					
					//Column 16 (204~213)
					if(i==15) {
						// Max 7468
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/7468;
						//System.out.print(newX);
						if(newX <= 0.1) {
							sbits[204] 	= 1; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 1; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 1; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 1; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 1; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 1; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 1; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 1; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 1; //9
							sbits[213] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {
							sbits[204] 	= 0; //1
							sbits[205] 	= 0; //2
							sbits[206] 	= 0; //3
							sbits[207] 	= 0; //4
							sbits[208] 	= 0; //5
							sbits[209] 	= 0; //6
							sbits[210] 	= 0; //7
							sbits[211] 	= 0; //8
							sbits[212] 	= 0; //9
							sbits[213] 	= 1; //10
						}else {
							System.out.println("Error15");
							System.exit(0);
						}
					}
					
					//Column 17 (214~223)
					if(i==16) {
						// Max 43
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/43;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[214] 	= 1; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 1; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 1; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 1; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 1; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 1; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 1; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 1; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 1; //9
							sbits[223] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[214] 	= 0; //1
							sbits[215] 	= 0; //2
							sbits[216] 	= 0; //3
							sbits[217] 	= 0; //4
							sbits[218] 	= 0; //5
							sbits[219] 	= 0; //6
							sbits[220] 	= 0; //7
							sbits[221] 	= 0; //8
							sbits[222] 	= 0; //9
							sbits[223] 	= 1; //10
						}else {
							System.out.println("Error16");
							System.exit(0);
						}
					}
					
					//Column 18 (224~233)
					if(i==17) {
						// Max 2
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/2;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[224] 	= 1; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 1; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 1; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 1; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 1; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 1; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 1; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 1; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 1; //9
							sbits[233] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[224] 	= 0; //1
							sbits[225] 	= 0; //2
							sbits[226] 	= 0; //3
							sbits[227]	= 0; //4
							sbits[228] 	= 0; //5
							sbits[229] 	= 0; //6
							sbits[230] 	= 0; //7
							sbits[231] 	= 0; //8
							sbits[232] 	= 0; //9
							sbits[233] 	= 1; //10
						}else {
							System.out.println("Error17");
							System.exit(0);
						}
					}
					
					//Column 19 (234~243)
					if(i==18) {
						// Max 9
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/9;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[234] 	= 1; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 1; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 1; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 1; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 1; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 1; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 1; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 1; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 1; //9
							sbits[243] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[234] 	= 0; //1
							sbits[235] 	= 0; //2
							sbits[236] 	= 0; //3
							sbits[237]	= 0; //4
							sbits[238] 	= 0; //5
							sbits[239] 	= 0; //6
							sbits[240] 	= 0; //7
							sbits[241] 	= 0; //8
							sbits[242] 	= 0; //9
							sbits[243] 	= 1; //10
						}else {		
							System.out.println("Error18");	
							System.exit(0);	
						}
					}
					
					//Column 20 (244~253)
					if(i==19) {
						// Max 0
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						sbits[244] 	= 1; //1
						sbits[245] 	= 0; //2
						sbits[246] 	= 0; //3
						sbits[247]	= 0; //4
						sbits[248] 	= 0; //5
						sbits[249] 	= 0; //6
						sbits[250] 	= 0; //7
						sbits[251] 	= 0; //8
						sbits[252] 	= 0; //9
						sbits[253] 	= 0; //10
					}
					
					//Column 21 (254~263)
					if(i==20) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						
						if(xValue == 0) {
							sbits[254] 	= 1; //1
							sbits[255] 	= 0; //2
							sbits[256] 	= 0; //3
							sbits[257]	= 0; //4
							sbits[258] 	= 0; //5
							sbits[259] 	= 0; //6
							sbits[260] 	= 0; //7
							sbits[261] 	= 0; //8
							sbits[262] 	= 0; //9
							sbits[263] 	= 0; //10
						}else if(xValue == 1) {
							sbits[254] 	= 0; //1
							sbits[255] 	= 0; //2
							sbits[256] 	= 0; //3
							sbits[257]	= 0; //4
							sbits[258] 	= 0; //5
							sbits[259] 	= 0; //6
							sbits[260] 	= 0; //7
							sbits[261] 	= 0; //8
							sbits[262] 	= 0; //9
							sbits[263] 	= 1; //10
						}else {
							System.out.println("Error20");	
							System.exit(0);	
						}
					}
					
					//Column 22 (264~273)
					if(i==21) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						
						if(xValue == 0) {
							sbits[264] 	= 1; //1
							sbits[265] 	= 0; //2
							sbits[266] 	= 0; //3
							sbits[267]	= 0; //4
							sbits[268] 	= 0; //5
							sbits[269] 	= 0; //6
							sbits[270] 	= 0; //7
							sbits[271] 	= 0; //8
							sbits[272] 	= 0; //9
							sbits[273] 	= 0; //10
						}else if(xValue == 1) {
							sbits[264] 	= 0; //1
							sbits[265] 	= 0; //2
							sbits[266] 	= 0; //3
							sbits[267]	= 0; //4
							sbits[268] 	= 0; //5
							sbits[269] 	= 0; //6
							sbits[270] 	= 0; //7
							sbits[271] 	= 0; //8
							sbits[272] 	= 0; //9
							sbits[273] 	= 1; //10
						}else {
							System.out.println("Error21");	
							System.exit(0);	
						}	
					}
					
					//Column 23 (274~283)
					if(i==22) {
						// Max 511
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/511;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[274] 	= 1; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 1; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 1; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 1; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 1; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 1; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 1; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 1; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 1; //9
							sbits[283] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[274] 	= 0; //1
							sbits[275] 	= 0; //2
							sbits[276] 	= 0; //3
							sbits[277]	= 0; //4
							sbits[278] 	= 0; //5
							sbits[279] 	= 0; //6
							sbits[280] 	= 0; //7
							sbits[281] 	= 0; //8
							sbits[282] 	= 0; //9
							sbits[283] 	= 1; //10
						}else {		
							System.out.println("Error22");	
							System.exit(0);	
						}
					}
					
					//Column 24 (284~293)
					if(i==23) {
						// Max 511
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						int xValue = Integer.parseInt(elephantList[i]);
						float newX = xValue/511;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[284] 	= 1; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 1; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 1; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 1; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 1; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 1; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 1; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 1; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 1; //9
							sbits[293] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[284] 	= 0; //1
							sbits[285] 	= 0; //2
							sbits[286] 	= 0; //3
							sbits[287]	= 0; //4
							sbits[288] 	= 0; //5
							sbits[289] 	= 0; //6
							sbits[290] 	= 0; //7
							sbits[291] 	= 0; //8
							sbits[292] 	= 0; //9
							sbits[293] 	= 1; //10
						}else {		
							System.out.println("Error23");	
							System.exit(0);	
						}
					}
					
					//Column 25 (294~303)
					if(i==24) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						//int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[294] 	= 1; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 1; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 1; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 1; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 1; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 1; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 1; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 1; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 1; //9
							sbits[303] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[294] 	= 0; //1
							sbits[295] 	= 0; //2
							sbits[296] 	= 0; //3
							sbits[297]	= 0; //4
							sbits[298] 	= 0; //5
							sbits[299] 	= 0; //6
							sbits[300] 	= 0; //7
							sbits[301] 	= 0; //8
							sbits[302] 	= 0; //9
							sbits[303] 	= 1; //10
						}else {		
							System.out.println("Error24");	
							System.exit(0);	
						}
					}
					
					//Column 26 (304~313)
					if(i==25) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						//int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[304] 	= 1; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 1; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 1; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 1; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 1; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 1; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 1; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 1; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 1; //9
							sbits[313] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[304] 	= 0; //1
							sbits[305] 	= 0; //2
							sbits[306] 	= 0; //3
							sbits[307]	= 0; //4
							sbits[308] 	= 0; //5
							sbits[309] 	= 0; //6
							sbits[310] 	= 0; //7
							sbits[311] 	= 0; //8
							sbits[312] 	= 0; //9
							sbits[313] 	= 1; //10
						}else {		
							System.out.println("Error25");	
							System.exit(0);	
						}
					}
					
					//Column 27 (314~323)
					if(i==26) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[314] 	= 1; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 1; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 1; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 1; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 1; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 1; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 1; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 1; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 1; //9
							sbits[323] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[314] 	= 0; //1
							sbits[315] 	= 0; //2
							sbits[316] 	= 0; //3
							sbits[317]	= 0; //4
							sbits[318] 	= 0; //5
							sbits[319] 	= 0; //6
							sbits[320] 	= 0; //7
							sbits[321] 	= 0; //8
							sbits[322] 	= 0; //9
							sbits[323] 	= 1; //10
						}else {		
							System.out.println("Error26");	
							System.exit(0);	
						}
					}
					
					//Column 28 (324~333)
					if(i==27) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[324] 	= 1; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 1; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 1; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 1; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 1; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 1; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 1; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 1; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 1; //9
							sbits[333] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[324] 	= 0; //1
							sbits[325] 	= 0; //2
							sbits[326] 	= 0; //3
							sbits[327]	= 0; //4
							sbits[328] 	= 0; //5
							sbits[329] 	= 0; //6
							sbits[330] 	= 0; //7
							sbits[331] 	= 0; //8
							sbits[332] 	= 0; //9
							sbits[333] 	= 1; //10
						}else {		
							System.out.println("Error27");	
							System.exit(0);	
						}
					}
					
					//Column 29 (334~343)
					if(i==28) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[334] 	= 1; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 1; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 1; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 1; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 1; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 1; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 1; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 1; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 1; //9
							sbits[343] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[334] 	= 0; //1
							sbits[335] 	= 0; //2
							sbits[336] 	= 0; //3
							sbits[337]	= 0; //4
							sbits[338] 	= 0; //5
							sbits[339] 	= 0; //6
							sbits[340] 	= 0; //7
							sbits[341] 	= 0; //8
							sbits[342] 	= 0; //9
							sbits[343] 	= 1; //10
						}else {		
							System.out.println("Error28");	
							System.exit(0);	
						}
					}
					
					//Column 30 (344~353)
					if(i==29) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[344] 	= 1; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 1; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 1; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 1; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 1; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 1; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 1; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 1; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 1; //9
							sbits[353] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[344] 	= 0; //1
							sbits[345] 	= 0; //2
							sbits[346] 	= 0; //3
							sbits[347]	= 0; //4
							sbits[348] 	= 0; //5
							sbits[349] 	= 0; //6
							sbits[350] 	= 0; //7
							sbits[351] 	= 0; //8
							sbits[352] 	= 0; //9
							sbits[353] 	= 1; //10
						}else {		
							System.out.println("Error29");	
							System.exit(0);	
						}
					}
					
					//Column 31 (354~363)
					if(i==30) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[354] 	= 1; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 1; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 1; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 1; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 1; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 1; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 1; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 1; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 1; //9
							sbits[363] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[354] 	= 0; //1
							sbits[355] 	= 0; //2
							sbits[356] 	= 0; //3
							sbits[357]	= 0; //4
							sbits[358] 	= 0; //5
							sbits[359] 	= 0; //6
							sbits[360] 	= 0; //7
							sbits[361] 	= 0; //8
							sbits[362] 	= 0; //9
							sbits[363] 	= 1; //10
						}else {		
							System.out.println("Error30");	
							System.exit(0);	
						}
					}
					
					//Column 32 (364~373)
					if(i==31) {
						// Max 255
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue/255;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[364] 	= 1; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 1; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 1; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 1; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 1; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 1; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 1; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 1; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 1; //9
							sbits[373] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[364] 	= 0; //1
							sbits[365] 	= 0; //2
							sbits[366] 	= 0; //3
							sbits[367]	= 0; //4
							sbits[368] 	= 0; //5
							sbits[369] 	= 0; //6
							sbits[370] 	= 0; //7
							sbits[371] 	= 0; //8
							sbits[372] 	= 0; //9
							sbits[373] 	= 1; //10
						}else {		
							System.out.println("Error31");	
							System.exit(0);	
						}
					}
					
					//Column 33 (374~383)
					if(i==32) {
						// Max 255
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue/255;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[374] 	= 1; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 1; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 1; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 1; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 1; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 1; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 1; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 1; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 1; //9
							sbits[383] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[374] 	= 0; //1
							sbits[375] 	= 0; //2
							sbits[376] 	= 0; //3
							sbits[377]	= 0; //4
							sbits[378] 	= 0; //5
							sbits[379] 	= 0; //6
							sbits[380] 	= 0; //7
							sbits[381] 	= 0; //8
							sbits[382] 	= 0; //9
							sbits[383] 	= 1; //10
						}else {		
							System.out.println("Error32");	
							System.exit(0);	
						}
					}
					
					//Column 34 (384~393)
					if(i==33) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[384] 	= 1; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 1; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 1; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 1; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 1; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 1; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 1; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 1; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 1; //9
							sbits[393] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[384] 	= 0; //1
							sbits[385] 	= 0; //2
							sbits[386] 	= 0; //3
							sbits[387]	= 0; //4
							sbits[388] 	= 0; //5
							sbits[389] 	= 0; //6
							sbits[390] 	= 0; //7
							sbits[391] 	= 0; //8
							sbits[392] 	= 0; //9
							sbits[393] 	= 1; //10
						}else {		
							System.out.println("Error33");	
							System.exit(0);	
						}
					}
					
					//Column 35 (394~403)
					if(i==34) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[394] 	= 1; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 1; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 1; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 1; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 1; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 1; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 1; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 1; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 1; //9
							sbits[403] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[394] 	= 0; //1
							sbits[395] 	= 0; //2
							sbits[396] 	= 0; //3
							sbits[397]	= 0; //4
							sbits[398] 	= 0; //5
							sbits[399] 	= 0; //6
							sbits[400] 	= 0; //7
							sbits[401] 	= 0; //8
							sbits[402] 	= 0; //9
							sbits[403] 	= 1; //10
						}else {		
							System.out.println("Error34");	
							System.exit(0);
						}
					}
					
					//Column 36 (404~413)
					if(i==35) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[404] 	= 1; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 1; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 1; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 1; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 1; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 1; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 1; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 1; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 1; //9
							sbits[413] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[404] 	= 0; //1
							sbits[405] 	= 0; //2
							sbits[406] 	= 0; //3
							sbits[407]	= 0; //4
							sbits[408] 	= 0; //5
							sbits[409] 	= 0; //6
							sbits[410] 	= 0; //7
							sbits[411] 	= 0; //8
							sbits[412] 	= 0; //9
							sbits[413] 	= 1; //10
						}else {		
							System.out.println("Error35");	
							System.exit(0);	
						}
					}
					
					//Column 37 (414~423)
					if(i==36) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[414] 	= 1; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 1; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 1; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 1; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 1; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 1; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 1; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 1; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 1; //9
							sbits[423] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[414] 	= 0; //1
							sbits[415] 	= 0; //2
							sbits[416] 	= 0; //3
							sbits[417]	= 0; //4
							sbits[418] 	= 0; //5
							sbits[419] 	= 0; //6
							sbits[420] 	= 0; //7
							sbits[421] 	= 0; //8
							sbits[422] 	= 0; //9
							sbits[423] 	= 1; //10
						}else {		
							System.out.println("Error36");	
							System.exit(0);	
						}
					}
					
					//Column 38 (424~433)
					if(i==37) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[424] 	= 1; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 1; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 1; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 1; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 1; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 1; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 1; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 1; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 1; //9
							sbits[433] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[424] 	= 0; //1
							sbits[425] 	= 0; //2
							sbits[426] 	= 0; //3
							sbits[427]	= 0; //4
							sbits[428] 	= 0; //5
							sbits[429] 	= 0; //6
							sbits[430] 	= 0; //7
							sbits[431] 	= 0; //8
							sbits[432] 	= 0; //9
							sbits[433] 	= 1; //10
						}else {		
							System.out.println("Error37");	
							System.exit(0);	
						}
					}
					
					//Column 39 (434~443)
					if(i==38) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[434] 	= 1; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 1; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 1; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 1; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 1; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 1; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 1; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 1; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 1; //9
							sbits[443] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[434] 	= 0; //1
							sbits[435] 	= 0; //2
							sbits[436] 	= 0; //3
							sbits[437]	= 0; //4
							sbits[438] 	= 0; //5
							sbits[439] 	= 0; //6
							sbits[440] 	= 0; //7
							sbits[441] 	= 0; //8
							sbits[442] 	= 0; //9
							sbits[443] 	= 1; //10
						}else {		
							System.out.println("Error38");	
							System.exit(0);	
						}
					}
					
					//Column 40 (444~453)
					if(i==39) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[444] 	= 1; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 1; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 1; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 1; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 1; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 1; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 1; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 1; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 1; //9
							sbits[453] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[444] 	= 0; //1
							sbits[445] 	= 0; //2
							sbits[446] 	= 0; //3
							sbits[447]	= 0; //4
							sbits[448] 	= 0; //5
							sbits[449] 	= 0; //6
							sbits[450] 	= 0; //7
							sbits[451] 	= 0; //8
							sbits[452] 	= 0; //9
							sbits[453] 	= 1; //10
						}else {		
							System.out.println("Error39");	
							System.exit(0);	
						}
					}
					
					//Column 41 (454~463)
					if(i==40) {
						// Max 1
						// Min 0
						// float newX = (float)xValue - MinValue/(float)MaxValue - MinValue;
						// int xValue = Integer.parseInt(elephantList[i]);
						float xValue = Float.parseFloat(elephantList[i]);
						float newX = xValue;
						//System.out.print(newX);
						if(newX <= 0.1) {								
							sbits[454] 	= 1; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.1 && newX <= 0.2) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 1; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.2 && newX <= 0.3) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 1; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.3 && newX <=0.4) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 1; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.4 && newX <=0.5) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 1; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.5 && newX <=0.6) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 1; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.6 && newX <=0.7) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 1; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.7 && newX <=0.8) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 1; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.8 && newX <=0.9) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 1; //9
							sbits[463] 	= 0; //10
						}else if(newX > 0.9 && newX <= 1) {		
							sbits[454] 	= 0; //1
							sbits[455] 	= 0; //2
							sbits[456] 	= 0; //3
							sbits[457]	= 0; //4
							sbits[458] 	= 0; //5
							sbits[459] 	= 0; //6
							sbits[460] 	= 0; //7
							sbits[461] 	= 0; //8
							sbits[462] 	= 0; //9
							sbits[463] 	= 1; //10
						}else {		
							System.out.println("Error40");	
							System.exit(0);	
						}
					}
				}
				System.out.print("Line: " + linenumber + " - ");
				
				
				//Image output
				//Image making
				byte[] bytes = encodeToByteArray(sbits);
				// Create an image type grayscale
				BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_BYTE_GRAY);

				// Get the backing pixels, and copy into it
				//byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
				byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
				System.arraycopy(bytes, 0, data, 0, bytes.length);
				
				// Write it out:
				
				try {
					ImageIO.write(image, "jpg", new File("C:\\Users\\J\\Desktop\\Research\\CNN\\img_data\\" + linenumber + ".jpg")); //Windows
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Image Output end
				
				linenumber++;
				System.out.print("\n");
			}
			fileReader.close();
			System.out.println("Process Ended");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static int[] serviceTypeToIntArray(String service) {
		int resultarray[] = new int[70];
		if(service.matches("ftp_data")) { // ftp_data 1
			resultarray[0] = 1; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("other")) { //other 2
			resultarray[0] = 0; //1
			resultarray[1] = 1; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("private")) { //private 3
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 1; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("http")) { //http 4
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 1; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("remote_job")) { //remote_job 5
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 1; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("name")) { // name 6
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 1; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("netbios_ns")) { // netbios_ns 7
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 1; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("eco_i")) { // eco_i 8
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 1; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("mtp")) { // mtp 9
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 1; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("telnet")) { // telnet 10
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 1; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("finger")) { // finger 11
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 1; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("domain_u")) { // domain_u 12
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 1; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("supdup")) { // supdup 13
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 1; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("uucp_path")) { // uucp_path 14
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 1; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("Z39_50")) { // Z39_50 15
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 1; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("smtp")) { // smtp 16
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 1; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("csnet_ns")) { // csnet_ns 17
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 1; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("uucp")) { // uucp 18
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 1; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("netbios_dgm")) { // netbios_dgm 19
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 1; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("urp_i")) { // urp_i 20
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 1; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("auth")) { // auth 21
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 1; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("domain")) { // domain 22
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 1; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ftp")) { // ftp 23
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 1; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("bgp")) { // bgp 24
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 1; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ldap")) { // ldap 25
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 1; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ecr_i")) { // ecr_i 26
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 1; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("gopher")) { // gopher 27
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 1; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("vmnet")) { // vmnet 28
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 1; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("systat")) { // systat 29
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 1; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("http_443")) { // http_443 30
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 1; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("efs")) { // efs 31
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 1; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("whois")) { // whois 32
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 1; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("imap4")) { // imap4 33
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 1; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("iso_tsap")) { // iso_tsap 34
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 1; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("echo")) { // echo 35
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 1; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("klogin")) { // klogin 36
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 1; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("link")) { // link 37
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 1; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("sunrpc")) { // sunrpc 38
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 1; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("login")) { // login 39
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 1; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("kshell")) { // kshell 40
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 1; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("sql_net")) { // sql_net 41
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 1; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("time")) { // time 42
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 1; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("hostnames")) { // hostnames 43
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 1; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("exec")) { // exec 44
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 1; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ntp_u")) { // ntp_u 45
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 1; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("discard")) { // discard 46
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 1; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("nntp")) { // nntp 47
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 1; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("courier")) { // courier 48
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 1; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ctf")) { // ctf 49
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 1; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("ssh")) { // ssh 50
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 1; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("daytime")) { // daytime 51
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 1; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("shell")) { // shell 52
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 1; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("netstat")) { // netstat 53
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 1; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("pop_3")) { // pop_3 54
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 1; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("nnsp")) { // nnsp 55
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 1; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("IRC")) { // IRC 56
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 1; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("pop_2")) { // pop_2 57
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 1; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("printer")) { // printer 58
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 1; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("tim_i")) { // tim_i 59
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 1; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("pm_dump")) { // pm_dump 60
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 1; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("red_i")) { // red_i 61
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 1; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("netbios_ssn")) { // netbios_ssn 62
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 1; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("rje")) { // rje 63
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 1; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("X11")) { // X11 64
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 1; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("urh_i")) { // urh_i 65
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 1; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("http_8001")) { // http_8001 66
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 1; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("aol")) { // aol 67
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 1; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("http_2784")) { // http_2784 68
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 1; //68
			resultarray[68] = 0; //69
			resultarray[69] = 0; //70
		}else if(service.matches("tftp_u")) { // tftp_u 69
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 1; //69
			resultarray[69] = 0; //70
		}else if(service.matches("harvest")) { // harvest 70
			resultarray[0] = 0; //1
			resultarray[1] = 0; //2
			resultarray[2] = 0; //3
			resultarray[3] = 0; //4
			resultarray[4] = 0; //5
			resultarray[5] = 0; //6
			resultarray[6] = 0; //7
			resultarray[7] = 0; //8
			resultarray[8] = 0; //9
			resultarray[9] = 0; //10

			resultarray[10] = 0; //11
			resultarray[11] = 0; //12
			resultarray[12] = 0; //13
			resultarray[13] = 0; //14
			resultarray[14] = 0; //15
			resultarray[15] = 0; //16
			resultarray[16] = 0; //17
			resultarray[17] = 0; //18
			resultarray[18] = 0; //19
			resultarray[19] = 0; //20

			resultarray[20] = 0; //21
			resultarray[21] = 0; //22
			resultarray[22] = 0; //23
			resultarray[23] = 0; //24
			resultarray[24] = 0; //25
			resultarray[25] = 0; //26
			resultarray[26] = 0; //27
			resultarray[27] = 0; //28
			resultarray[28] = 0; //29
			resultarray[29] = 0; //30

			resultarray[30] = 0; //31
			resultarray[31] = 0; //32
			resultarray[32] = 0; //33
			resultarray[33] = 0; //34
			resultarray[34] = 0; //35
			resultarray[35] = 0; //36
			resultarray[36] = 0; //37
			resultarray[37] = 0; //38
			resultarray[38] = 0; //39
			resultarray[39] = 0; //40

			resultarray[40] = 0; //41
			resultarray[41] = 0; //42
			resultarray[42] = 0; //43
			resultarray[43] = 0; //44
			resultarray[44] = 0; //45
			resultarray[45] = 0; //46
			resultarray[46] = 0; //47
			resultarray[47] = 0; //48
			resultarray[48] = 0; //49
			resultarray[49] = 0; //50

			resultarray[50] = 0; //51
			resultarray[51] = 0; //52
			resultarray[52] = 0; //53
			resultarray[53] = 0; //54
			resultarray[54] = 0; //55
			resultarray[55] = 0; //56
			resultarray[56] = 0; //57
			resultarray[57] = 0; //58
			resultarray[58] = 0; //59
			resultarray[59] = 0; //60

			resultarray[60] = 0; //61
			resultarray[61] = 0; //62
			resultarray[62] = 0; //63
			resultarray[63] = 0; //64
			resultarray[64] = 0; //65
			resultarray[65] = 0; //66
			resultarray[66] = 0; //67
			resultarray[67] = 0; //68
			resultarray[68] = 0; //69
			resultarray[69] = 1; //70
		}
		return resultarray;
	}
	
	private static byte[] encodeToByteArray(int[] bits) {
        byte[] results = new byte[(bits.length + 7) / 8];
        int byteValue = 0;
        int index;
        for (index = 0; index < bits.length; index++) {

            byteValue = (byteValue << 1) | bits[index];

            if (index %8 == 7) {
                results[index / 8] = (byte) byteValue;
            }
        }

        if (index % 8 != 0) {
            results[index / 8] = (byte) (byteValue << (8 - (index % 8)));
        }

        return results;
    }
}

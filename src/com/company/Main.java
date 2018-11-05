package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "abcabcdabmnsxy";
        ArrayList<String> arrayList = new ArrayList<>();                                    //{1}
        cutString(arrayList, str);                                                          //{2}
        int max = arrayList.get(0).length();                                                //{3}
        String result = arrayList.get(0);                                                   //{4}
        for(int i = 1; i < arrayList.size(); i++){                                          //{5}
            if(arrayList.get(i).length() > max){                                            //{6}
                max = arrayList.get(i).length();                                                //{6.1}
                result = arrayList.get(i);                                                      //{6.2}
            }
        }
        System.out.println(result);                                                         //{9}
    }

    public static ArrayList<String> cutString(ArrayList<String> arrayList, String str){
        int count = 0;                                                                          //{2.1}
        for(int i = 0; i < str.length() - 1; i++){                                              //{2.2}
            if(str.charAt(i) > str.charAt(i+1)){                                                //{2.3}
                String temp = str.substring(i-count, i+1);                                          //{2.3.1}
                arrayList.add(temp);                                                                //{2.3.2}
                count = 0;                                                                          //{2.3.3}
            }else{                                                                              //{2.3}
                count++;                                                                            //{2.3.1}
                if(i == str.length() - 2){                                                          //{2.3.2}
                    String temp = str.substring(i+1-count, str.length());                               //{2.3.2.1}
                    arrayList.add(temp);                                                                //{2.3.2.2}
                }
            }
        }
        return arrayList;                                                                       //{2.4}
    }

    /*
    n là số vòng lặp thực hiện
    Thời gian thực hiện bước 1 là O(1)
    Thời gian thực hiện bước 2 là: O(n-1)
        Bước 2.1 mất O(1)
        Bước 2.2 mất O((n-1)*1) = O(n-1)
            Bước 2.3 mất O(1)
    Thời gian thực hiện bước 3,4 là O(1)
    Thời gian thực hiện bước 5 là: O(n-1)
    Thời gian thực hiện bước 6 là: O(1)

    => Thời gian thực hiện bài toán là O((n-1)*(n-1))
    Kết quả tốt nhât là 3 khi chuỗi có 2 chuỗi con
     */
}

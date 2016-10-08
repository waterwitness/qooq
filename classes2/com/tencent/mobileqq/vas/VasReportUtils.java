package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;

public class VasReportUtils
{
  public static final String A = "10";
  public static final String B = "11";
  public static final String C = "1";
  public static final String D = "2";
  public static final String E = "3";
  public static final String F = "4";
  public static final String G = "5";
  public static final String H = "6";
  public static final String I = "7";
  public static final String J = "8";
  public static final String K = "9";
  public static final String L = "10";
  public static final String M = "1";
  public static final String N = "2";
  public static final String O = "3";
  public static final String P = "4";
  public static final String a = "emotionType";
  public static final String b = "downloadfactoryType";
  public static final String c = "emotionActionSend";
  public static final String d = "emotionActionDownload";
  public static final String e = "emotionActionAIO";
  public static final String f = "emotionActionFav";
  public static final String g = "emotionAcitonPanel";
  public static final String h = "1";
  public static final String i = "2";
  public static final String j = "3";
  public static final String k = "4";
  public static final String l = "5";
  public static final String m = "6";
  public static final String n = "7";
  public static final String o = "8";
  public static final String p = "9";
  public static final String q = "10";
  public static final String r = "1";
  public static final String s = "2";
  public static final String t = "3";
  public static final String u = "4";
  public static final String v = "5";
  public static final String w = "6";
  public static final String x = "7";
  public static final String y = "8";
  public static final String z = "9";
  
  public VasReportUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    paramString6 = new StringBuilder();
    paramString6.append(paramString1).append("|");
    paramString6.append(paramString2).append("|");
    paramString6.append(paramString3).append("|");
    paramString6.append(paramString4).append("|");
    paramString6.append(paramString5).append("|");
    paramString6.append(paramString7).append("|");
    paramString6.append(paramString8).append("|");
    paramString6.append(paramString9).append("|");
    paramString6.append(paramString10);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_errorcode_report", paramString6.toString(), true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\VasReportUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
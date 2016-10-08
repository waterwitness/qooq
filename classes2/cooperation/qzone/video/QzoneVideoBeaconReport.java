package cooperation.qzone.video;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QzoneVideoBeaconReport
{
  public static final String A = "qzone_video_trim";
  public static final String B = "0";
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
  public static final String M = "11";
  public static final String N = "12";
  public static final String O = "13";
  public static final String P = "14";
  public static final String Q = "15";
  public static final String R = "22";
  public static final String S = "trim_success";
  public static final String T = "16";
  public static final String U = "17";
  public static final String V = "trim_hw_support";
  public static final String W = "18";
  public static final String X = "19";
  public static final String Y = "trim_hw_success";
  public static final String Z = "20";
  public static final String a = "qzone_video_entrance";
  public static final String aA = "1";
  public static final String aB = "record_success";
  public static final String aC = "0";
  public static final String aD = "1";
  public static final String aE = "play_local_video";
  public static final String aF = "play_local_video_success";
  public static final String aG = "0";
  public static final String aH = "4";
  public static final String aI = "1";
  public static final String aJ = "2";
  public static final String aK = "3";
  public static final String aa = "21";
  public static final String ab = "trim_sw_success";
  public static final String ac = "20";
  public static final String ad = "21";
  public static final String ae = "trim_retry_res";
  public static final String af = "23";
  public static final String ag = "24";
  public static final String ah = "25";
  public static final String ai = "trim_retry_num";
  public static final String aj = "qzone_video_record";
  public static final String ak = "0";
  public static final String al = "1";
  public static final String am = "2";
  public static final String an = "3";
  public static final String ao = "4";
  public static final String ap = "5";
  public static final String aq = "6";
  public static final String ar = "7";
  public static final String as = "8";
  public static final String at = "9";
  public static final String au = "10";
  public static final String av = "record_hw_success";
  public static final String aw = "0";
  public static final String ax = "1";
  public static final String ay = "record_sw_success";
  public static final String az = "0";
  public static final String b = "0";
  public static final String c = "1";
  public static final String d = "2";
  public static final String e = "3";
  public static final String f = "4";
  public static final String g = "5";
  public static final String h = "qzone_video_recordtrim";
  public static final String i = "0";
  public static final String j = "1";
  public static final String k = "1000";
  public static final String l = "1001";
  public static final String m = "1002";
  public static final String n = "1003";
  public static final String o = "1004";
  public static final String p = "1005";
  public static final String q = "1006";
  public static final String r = "qzone_video_publishactivity";
  public static final String s = "0";
  public static final String t = "1";
  public static final String u = "2";
  public static final String v = "qzone_video_uploadstart";
  public static final String w = "qzone_video_uploadhqueue";
  public static final String x = "0";
  public static final String y = "-2";
  public static final String z = "-1";
  
  public QzoneVideoBeaconReport()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", paramString3);
    localHashMap.put("reserve", paramString4);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " resultCode:" + paramString3 + " reserve:" + paramString4);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString3, paramString4);
    localHashMap.put("reserve", paramString5);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2 + " key:" + paramString3 + " value:" + paramString4 + ", reserve:" + paramString5);
    }
  }
  
  public static void a(String paramString1, String paramString2, HashMap paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramHashMap);
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString1, paramString2, true, 0L, 0L, localHashMap, null);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVideoBeaconReport", 2, "event:" + paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\QzoneVideoBeaconReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
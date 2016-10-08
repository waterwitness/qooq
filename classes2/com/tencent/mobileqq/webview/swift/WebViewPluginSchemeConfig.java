package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.HashMap;

public class WebViewPluginSchemeConfig
{
  public static final String A = "qqfav";
  public static final String B = "mqqc2b";
  public static final long a = 1L;
  public static final String a = "http";
  public static final HashMap a;
  public static final long b = 2L;
  public static final String b = "https";
  public static final long c = 4L;
  public static final String c = "javascript";
  public static final long d = 8L;
  public static final String d = "data";
  public static final long e = 16L;
  public static final String e = "file";
  public static final long f = 32L;
  public static final String f = "jsbridge";
  public static final long g = 64L;
  public static final String g = "openapi";
  public static final long h = 128L;
  public static final String h = "pay";
  public static final long i = 256L;
  public static final String i = "qqvip";
  public static final long j = 512L;
  public static final String j = "qqjsbridge";
  public static final long k = 1024L;
  public static final String k = "tel";
  public static final long l = 2048L;
  public static final String l = "sms";
  public static final long m = 4096L;
  public static final String m = "mqqapi";
  public static final long n = 8192L;
  public static final String n = "mqqopensdkapi";
  public static final long o = 16384L;
  public static final String o = "mqqmdpass";
  public static final long p = 32768L;
  public static final String p = "mqq";
  public static final long q = 65536L;
  public static final String q = "qapp";
  public static final long r = 131072L;
  public static final String r = "mqqflyticket";
  public static final long s = 262144L;
  public static final String s = "mqqwpa";
  public static final long t = 524288L;
  public static final String t = "wtloginmqq";
  public static final long u = 1048576L;
  public static final String u = "qqwifi";
  public static final long v = 2097152L;
  public static final String v = "apollo";
  public static final long w = 4194304L;
  public static final String w = "mqqverifycode";
  public static final long x = 8388608L;
  public static final String x = "mqqconnect";
  public static final long y = 4294967295L;
  public static final String y = "mqqvoipivr";
  public static final String z = "mqqdevlock";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new HashMap();
    a.put(WebViewJumpPlugin.a, Long.valueOf(4294967295L));
    a.put("Qzone", Long.valueOf(4294967295L));
    a.put("qzDynamicAlbum", Long.valueOf(4294967295L));
    a.put("QZImagePicker", Long.valueOf(4294967295L));
    a.put("qzlive", Long.valueOf(4294967295L));
    a.put("PublicAccountJs", Long.valueOf(4L));
    a.put("offline", Long.valueOf(3L));
    a.put(PtloginPlugin.class.getSimpleName(), Long.valueOf(3L));
    a.put(QzonePlugin.a, Long.valueOf(11L));
    a.put(SosoPlugin.a, Long.valueOf(3L));
    a.put("qqmusic", Long.valueOf(3L));
    a.put("emoji", Long.valueOf(32L));
    a.put("msgRoam", Long.valueOf(1L));
    a.put("qw.pay", Long.valueOf(32L));
    a.put("common", Long.valueOf(32L));
    a.put("mqqc2b", Long.valueOf(8388608L));
  }
  
  static String a(long paramLong)
  {
    String str = "";
    if (paramLong == 1L) {
      str = "http";
    }
    do
    {
      return str;
      if (paramLong == 2L) {
        return "https";
      }
      if (paramLong == 4L) {
        return "publicaccount";
      }
      if (paramLong == 8L) {
        return "pay";
      }
      if (paramLong == 16L) {
        return "qqvip";
      }
      if (paramLong == 32L) {
        return "qqjsbridge";
      }
      if (paramLong == 64L) {
        return "tel";
      }
      if (paramLong == 128L) {
        return "sms";
      }
      if (paramLong == 256L) {
        return "mqqapi";
      }
      if (paramLong == 512L) {
        return "mqqopensdkapi";
      }
      if (paramLong == 1024L) {
        return "mqqmdpass";
      }
      if (paramLong == 2048L) {
        return "mqq";
      }
      if (paramLong == 4096L) {
        return "qapp";
      }
      if (paramLong == 8192L) {
        return "mqqflyticket";
      }
      if (paramLong == 16384L) {
        return "mqqwpa";
      }
      if (paramLong == 32768L) {
        return "wtloginmqq";
      }
      if (paramLong == 65536L) {
        return "qqwifi";
      }
      if (paramLong == 131072L) {
        return "apollo";
      }
      if (paramLong == 262144L) {
        return "mqqverifycode";
      }
      if (paramLong == 524288L) {
        return "mqqconnect";
      }
      if (paramLong == 1048576L) {
        return "mqqvoipivr";
      }
      if (paramLong == 2097152L) {
        return "mqqdevlock";
      }
      if (paramLong == 4194304L) {
        return "qqfav";
      }
    } while (paramLong != 8388608L);
    return "mqqc2b";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\WebViewPluginSchemeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
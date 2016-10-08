package com.tencent.kingkong;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kfb;

public class ReportThread
  extends Thread
{
  public static final int a = 0;
  public static final String a = "KingKongReportThread";
  private static final boolean a = true;
  public static final int b = 1;
  public static final String b = "KEY_TYPE";
  public static final String c = "KEY_INDEX";
  public static final String d = "KEY_SUBINDEX";
  public static final String e = "KEY_EXTRAINFO";
  public Looper a;
  public Object a;
  public kfb a;
  
  public ReportThread()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static String a(String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder1;
      int i;
      StringBuilder localStringBuilder2;
      try
      {
        localStringBuilder1 = Utils.a();
        localStringBuilder1.append(paramString);
      }
      finally {}
      try
      {
        paramString = Build.HARDWARE;
        if (paramString != null) {
          localStringBuilder1.append("&hardware=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.BRAND;
        if (paramString != null) {
          localStringBuilder1.append("&pb=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        i = Build.VERSION.SDK_INT;
        if (i != -1) {
          localStringBuilder1.append("&ps=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
        }
        paramString = DataReport.a();
        if (paramString != null) {
          localStringBuilder1.append("&av=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.b();
        if (paramString != null) {
          localStringBuilder1.append("&pn=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.c();
        if (paramString != null) {
          localStringBuilder1.append("&amn=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.d();
        if (paramString != null) {
          localStringBuilder1.append("&amv=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.e();
        if (paramString != null) {
          localStringBuilder1.append("&nm=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        i = DataReport.a();
        if (i != -1) {
          localStringBuilder1.append("&bl=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
        }
        i = DataReport.b();
        if (i != -1) {
          localStringBuilder1.append("&bt=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
        }
        i = DataReport.c();
        if (i != -1) {
          localStringBuilder1.append("&bv=").append(URLEncoder.encode(Integer.toString(i), "UTF-8"));
        }
        paramString = DataReport.f();
        if (paramString != null) {
          localStringBuilder1.append("&cr=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.g();
        if (paramString != null) {
          localStringBuilder1.append("&cl=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.h();
        if (paramString != null) {
          localStringBuilder1.append("&gn=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.i();
        if (paramString != null) {
          localStringBuilder1.append("&gv=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.j();
        if (paramString != null) {
          localStringBuilder1.append("&imsi=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.k();
        if (paramString != null) {
          localStringBuilder1.append("&ip_addr=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.l();
        if (paramString != null) {
          localStringBuilder1.append("&re=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.m();
        if (paramString != null) {
          localStringBuilder1.append("&rt=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.n();
        if (paramString != null) {
          localStringBuilder1.append("&st=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        localStringBuilder2 = localStringBuilder1.append("&root=");
        if (!DataReport.a()) {
          continue;
        }
        paramString = "1";
        localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
        localStringBuilder2 = localStringBuilder1.append("&ams=");
        if (!DataReport.b()) {
          break label1049;
        }
        paramString = "1";
      }
      catch (Exception paramString) {}catch (NoClassDefFoundError paramString) {}catch (NoSuchMethodError paramString) {}catch (UnsupportedEncodingException paramString)
      {
        continue;
        label1049:
        paramString = "0";
        continue;
        paramString = "0";
        continue;
        label1063:
        paramString = "0";
        continue;
        label1070:
        paramString = "0";
        continue;
        label1077:
        paramString = "0";
        continue;
        label1084:
        paramString = "0";
        continue;
        label1091:
        paramString = "0";
        continue;
        label1098:
        paramString = "0";
        continue;
        label1105:
        paramString = "0";
        continue;
        label1112:
        paramString = "0";
      }
    }
    localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
    localStringBuilder2 = localStringBuilder1.append("&btls=");
    if (DataReport.c())
    {
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&bts=");
      if (!DataReport.d()) {
        break label1063;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gls=");
      if (!DataReport.e()) {
        break label1070;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gs=");
      if (!DataReport.f()) {
        break label1077;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&gss=");
      if (!DataReport.g()) {
        break label1084;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ns=");
      if (!DataReport.h()) {
        break label1091;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&pe=");
      if (!DataReport.i()) {
        break label1098;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ts=");
      if (!DataReport.j()) {
        break label1105;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&uas=");
      if (!DataReport.k()) {
        break label1112;
      }
      paramString = "1";
      localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
      localStringBuilder2 = localStringBuilder1.append("&ws=");
      if (DataReport.l()) {}
      for (paramString = "1";; paramString = "0")
      {
        localStringBuilder2.append(URLEncoder.encode(paramString, "UTF-8"));
        paramString = DataReport.o();
        if (paramString != null) {
          localStringBuilder1.append("&qu=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.p();
        if (paramString != null) {
          localStringBuilder1.append("&android_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.MODEL;
        if (paramString != null) {
          localStringBuilder1.append("&pm=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = Build.VERSION.RELEASE;
        if (paramString != null) {
          localStringBuilder1.append("&pr=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.q();
        if (paramString != null) {
          localStringBuilder1.append("&mac=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.r();
        if (paramString != null) {
          localStringBuilder1.append("&device_id=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = DataReport.s();
        if (paramString != null) {
          localStringBuilder1.append("&nt=").append(URLEncoder.encode(paramString, "UTF-8"));
        }
        paramString = localStringBuilder1.toString();
        return paramString;
        paramString = "0";
        break;
      }
    }
  }
  
  private static String c(String paramString)
  {
    try
    {
      String str2 = Utils.a(16);
      String str1 = EncryptUtilsForQQ.a(new String(str2));
      paramString = new String(EncryptUtilsForQQ.a(str2, paramString));
      paramString = "paramStr=" + URLEncoder.encode(paramString, "UTF-8") + "&key=" + URLEncoder.encode(str1, "UTF-8") + "&visibility=2";
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsLooper != null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_AndroidOsLooper != null)
        {
          this.jdField_a_of_type_AndroidOsLooper.quit();
          this.jdField_a_of_type_Kfb.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_Kfb = null;
          this.jdField_a_of_type_AndroidOsLooper = null;
        }
        return;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Kfb == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Kfb != null)
      {
        Message localMessage = this.jdField_a_of_type_Kfb.obtainMessage();
        Bundle localBundle = new Bundle();
        localBundle.putInt("KEY_TYPE", paramInt1);
        localBundle.putInt("KEY_INDEX", paramInt2);
        localBundle.putInt("KEY_SUBINDEX", paramInt3);
        localBundle.putString("KEY_EXTRAINFO", paramString);
        localMessage.setData(localBundle);
        this.jdField_a_of_type_Kfb.sendMessage(localMessage);
      }
      return;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.jdField_a_of_type_Kfb = new kfb();
    this.jdField_a_of_type_AndroidOsLooper = Looper.myLooper();
    Process.setThreadPriority(11);
    Common.Log.a("KingKongReportThread", "ReportThread " + Process.myTid() + " priority : " + Process.getThreadPriority(Process.myTid()));
    Looper.loop();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\ReportThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
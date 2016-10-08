package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mobileqq.msf.core.c.c;
import com.tencent.mobileqq.msf.core.c.m;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.QLog.a;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class f
{
  static String a = "MSF.C.LogManager";
  static boolean b = true;
  static int c = 0;
  static boolean d = false;
  static long e = 0L;
  static String f = "log_manager_sp";
  static boolean g = false;
  static String h = "http://misc.3g.qq.com/g/mqqcl/upload.jsp";
  static String i = "http://misc.3g.qq.com/g/mqqcl/creport.jsp";
  private static final int j = 10000;
  private static long k;
  private static Handler l = new g(Looper.getMainLooper());
  private static final BroadcastReceiver m = new h();
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "zip file start");
    }
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt1, paramInt2 - 1, paramInt3, paramInt4, 0, 0);
    long l2 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(paramInt5, paramInt6 - 1, paramInt7, paramInt8, 0, 0);
    long l4 = ((Calendar)localObject1).getTimeInMillis();
    long l1 = System.currentTimeMillis();
    if (l4 >= l1) {
      ((Calendar)localObject1).setTimeInMillis(l1);
    }
    localObject3 = new HashSet();
    int i1 = 0;
    l1 = l2;
    int n;
    long l3;
    do
    {
      localObject1 = QLog.getLogFileFormatter().format(Long.valueOf(l1));
      ((HashSet)localObject3).add(localObject1);
      n = i1;
      if (i1 == 0) {
        n = ((String)localObject1).length();
      }
      l3 = l1 + 3600000L;
      i1 = n;
      l1 = l3;
    } while (l3 <= l4);
    ArrayList localArrayList = new ArrayList();
    File localFile = new File(QLog.getLogPath());
    Object localObject4;
    int i2;
    String str;
    if (localFile.exists())
    {
      localObject4 = localFile.listFiles();
      if (localObject4 != null)
      {
        i2 = localObject4.length;
        i1 = 0;
        if (i1 < i2)
        {
          str = localObject4[i1];
          localObject2 = str.getName();
          if (((String)localObject2).endsWith(".log")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);
          }
          for (;;)
          {
            if ((((String)localObject1).startsWith(QLog.packageName)) && (((HashSet)localObject3).contains(((String)localObject1).substring(((String)localObject1).length() - n)))) {
              localArrayList.add(new QLog.a(str.getPath()));
            }
            i1 += 1;
            break;
            if (((String)localObject2).endsWith(".log.zip"))
            {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 8);
            }
            else
            {
              localObject1 = localObject2;
              if (((String)localObject2).endsWith(".qlog")) {
                localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 5);
              }
            }
          }
        }
      }
    }
    else
    {
      localFile.mkdirs();
    }
    Object localObject2 = new File(QLog.getOldLogPath());
    if (((File)localObject2).exists())
    {
      localObject1 = ((File)localObject2).listFiles();
      if (localObject1 != null)
      {
        i2 = localObject1.length;
        i1 = 0;
        while (i1 < i2)
        {
          localObject4 = localObject1[i1];
          str = ((File)localObject4).getName();
          if ((str.startsWith(QLog.packageName)) && (((HashSet)localObject3).contains(str.substring(str.length() - n))))
          {
            localObject4 = new QLog.a(((File)localObject4).getPath());
            ((QLog.a)localObject4).a = ".old";
            localArrayList.add(localObject4);
          }
          i1 += 1;
        }
      }
    }
    localObject3 = null;
    for (;;)
    {
      try
      {
        if (localFile.exists()) {
          localObject1 = new QLog.a(localFile, "FileList.log");
        }
      }
      catch (Exception localException2)
      {
        boolean bool;
        label861:
        localObject1 = localObject3;
        continue;
      }
      try
      {
        localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
        if (localObject3 != null)
        {
          if (((File)localObject2).exists())
          {
            localObject2 = ((File)localObject2).listFiles();
            if (localObject2 != null)
            {
              i1 = localObject2.length;
              n = 0;
              if (n < i1)
              {
                localObject4 = localObject2[n];
                ((BufferedWriter)localObject3).write(((File)localObject4).getName() + "\n");
                n += 1;
                continue;
              }
            }
          }
          localObject2 = localFile.listFiles();
          if (localObject2 != null)
          {
            i1 = localObject2.length;
            n = 0;
            if (n < i1)
            {
              localFile = localObject2[n];
              ((BufferedWriter)localObject3).write(localFile.getName() + "\n");
              n += 1;
              continue;
            }
          }
        }
        ((BufferedWriter)localObject3).flush();
        ((BufferedWriter)localObject3).close();
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(l2);
        ((Calendar)localObject1).set(11, 0);
        ((Calendar)localObject1).set(12, 0);
        ((Calendar)localObject1).set(13, 0);
        ((Calendar)localObject1).set(14, 0);
        l1 = ((Calendar)localObject1).getTimeInMillis();
        localObject1 = null;
        if ((!d) || (e != l1))
        {
          localObject1 = c.a(l1, 86400000L + l1);
          if (QLog.isColorLevel())
          {
            localObject2 = a;
            localObject3 = new StringBuilder().append("get user 24h netflow ");
            if (localObject1 != null) {
              continue;
            }
            bool = false;
            QLog.d((String)localObject2, 2, bool);
          }
        }
        if (localObject1 != null)
        {
          d = true;
          e = l1;
          localArrayList.add(localObject1);
        }
        com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.i, paramString, com.tencent.mobileqq.msf.core.b.a.d, false, new Object[0]);
        localObject1 = QLog.getLogPath() + String.format("%d_%d_%d_%d--%d_%d_%d_%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8) });
        paramInt1 = -1;
      }
      catch (Exception localException3)
      {
        continue;
      }
    }
    paramInt1 += 1;
    if (paramInt1 != 0) {}
    for (paramString = (String)localObject1 + "_" + paramInt1 + ".zip";; paramString = (String)localObject1 + ".zip")
    {
      if (new File(paramString).exists()) {
        break label1302;
      }
      a(localArrayList, paramString);
      return paramString;
      localFile.mkdir();
      localObject1 = new QLog.a(localFile, "FileList.log");
      try
      {
        localObject3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream((File)localObject1)));
        if (((File)localObject2).exists())
        {
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 != null)
          {
            i1 = localObject2.length;
            n = 0;
            while (n < i1)
            {
              localFile = localObject2[n];
              ((BufferedWriter)localObject3).write(localFile.getName() + "\n");
              n += 1;
            }
          }
        }
        else
        {
          ((BufferedWriter)localObject3).write("no log file in old and new path.");
        }
        ((BufferedWriter)localObject3).flush();
        ((BufferedWriter)localObject3).close();
      }
      catch (Exception localException1) {}
      QLog.d(a, 1, "read Log file list error. " + localException1, localException1);
      break;
      bool = true;
      break label861;
    }
  }
  
  public static void a()
  {
    try
    {
      if (!g)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(m, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "LogManager inited.");
        }
        g = true;
      }
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt, File paramFile, long paramLong, String paramString)
    throws Exception
  {
    if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
      BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
    }
    int i1 = 1;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "want send size " + paramFile.length());
    }
    if (paramFile.length() % BaseConstants.REPORTLOGONCEMAXSIZE > 0L) {}
    for (int n = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L); n > BaseConstants.REPORTLOGMAXPACKAGECOUNT; n = (int)(paramFile.length() / BaseConstants.REPORTLOGONCEMAXSIZE))
    {
      a(paramInt, m(), "report size is too big " + paramFile.length(), MsfSdkUtils.insertMtype("reportLog", h), 1, n);
      com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.i, paramString, com.tencent.mobileqq.msf.core.b.a.g, true, new Object[] { Long.valueOf(paramFile.length()) });
      return;
    }
    while (l1 < paramFile.length())
    {
      long l3 = paramFile.length() - l1;
      long l2 = l3;
      if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
        l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
      }
      a(paramInt, m(), paramFile, MsfSdkUtils.insertMtype("reportLog", h), i1, n, l1, l2, false, "", "", paramLong);
      l1 += l2;
      i1 += 1;
    }
    com.tencent.mobileqq.msf.core.b.b.a(paramLong);
    com.tencent.mobileqq.msf.core.b.a.a(com.tencent.mobileqq.msf.core.b.a.i, paramString, com.tencent.mobileqq.msf.core.b.a.f, true, new Object[] { Long.valueOf(paramFile.length()) });
  }
  
  private static void a(int paramInt1, String paramString1, File paramFile, String paramString2, int paramInt2, int paramInt3, long paramLong1, long paramLong2, boolean paramBoolean, String paramString3, String paramString4, long paramLong3)
    throws Exception
  {
    n.c();
    Object localObject1 = MsfSdkUtils.getLoginedAccountList().iterator();
    Object localObject2;
    for (String str = ""; ((Iterator)localObject1).hasNext(); str = str + ((SimpleAccount)localObject2).getUin() + ",") {
      localObject2 = (SimpleAccount)((Iterator)localObject1).next();
    }
    for (;;)
    {
      try
      {
        paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
      }
      finally
      {
        continue;
        paramLong1 = 0L;
      }
      try
      {
        paramString2.setDoInput(true);
        paramString2.setDoOutput(true);
        paramString2.setUseCaches(false);
        paramString2.setRequestMethod("POST");
        paramString2.setRequestProperty("Charset", "UTF-8");
        paramString2.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + paramString1);
        localObject1 = new DataOutputStream(paramString2.getOutputStream());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=appid\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=os\r\n\r\n");
        ((StringBuilder)localObject2).append(Build.VERSION.SDK);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=model\r\n\r\n");
        ((StringBuilder)localObject2).append(Build.MODEL + "|" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
        ((StringBuilder)localObject2).append(paramFile.getName());
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=imei\r\n\r\n");
        ((StringBuilder)localObject2).append(n.d());
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=logFormat\r\n\r\n");
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=gzip\r\n\r\n");
        ((StringBuilder)localObject2).append("true");
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("\r\n");
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=seq\r\n\r\n");
        ((StringBuilder)localObject2).append(paramLong3);
        ((StringBuilder)localObject2).append("\r\n");
        if (paramBoolean)
        {
          ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
          ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=cmdstr\r\n\r\n");
          ((StringBuilder)localObject2).append(paramString3);
          ((StringBuilder)localObject2).append("\r\n");
          ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
          ((StringBuilder)localObject2).append("Content-Disposition: form-data; name=opinfo\r\n\r\n");
          ((StringBuilder)localObject2).append(paramString4);
          ((StringBuilder)localObject2).append("\r\n");
        }
        ((StringBuilder)localObject2).append("--").append(paramString1).append("\r\n");
        ((StringBuilder)localObject2).append("Content-Disposition:form-data;name=logFile;filename=\"" + paramFile.getName() + "\"\r\n");
        ((StringBuilder)localObject2).append("Content-Type: application/x-zip-compressed\r\n\r\n");
        ((DataOutputStream)localObject1).write(((StringBuilder)localObject2).toString().getBytes("UTF-8"));
        paramString3 = new FileInputStream(paramFile);
        try
        {
          paramString4 = new byte['倀'];
          if (paramLong1 <= 0L) {
            continue;
          }
          paramString3.skip(paramLong1);
        }
        finally
        {
          paramString3.close();
        }
        paramInt1 = paramString3.read(paramString4, 0, 20480);
        if (paramInt1 != -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "read " + paramInt1 + " from " + paramFile.getName());
          }
          if (paramInt1 + paramLong1 <= paramLong2) {
            continue;
          }
          paramLong2 -= paramLong1;
          ((DataOutputStream)localObject1).write(paramString4, 0, (int)paramLong2);
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "send " + (paramLong1 + paramLong2));
          }
        }
        paramString3.close();
        ((DataOutputStream)localObject1).write("\r\n".getBytes());
        ((DataOutputStream)localObject1).write(("--" + paramString1 + "--\r\n").getBytes());
        ((DataOutputStream)localObject1).flush();
        ((DataOutputStream)localObject1).close();
        a(paramString2);
        if (paramString2 != null) {
          paramString2.disconnect();
        }
        if (MsfCore.SysVerSion >= 14) {
          TrafficStats.clearThreadStatsTag();
        }
        return;
        ((DataOutputStream)localObject1).write(paramString4, 0, paramInt1);
        paramLong3 = paramLong1 + paramInt1;
        paramLong1 = paramLong3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(a, 2, "send " + paramLong3);
        paramLong1 = paramLong3;
        continue;
        paramFile = finally;
      }
      finally
      {
        paramString1 = paramString2;
        if (paramString1 != null) {
          paramString1.disconnect();
        }
        if (MsfCore.SysVerSion >= 14) {
          TrafficStats.clearThreadStatsTag();
        }
      }
    }
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    n.c();
    Object localObject = MsfSdkUtils.getLoginedAccountList().iterator();
    SimpleAccount localSimpleAccount;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localSimpleAccount.getUin() + ",") {
      localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=appid\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=os\r\n\r\n");
    ((StringBuilder)localObject).append(Build.VERSION.SDK);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=model\r\n\r\n");
    ((StringBuilder)localObject).append(Build.MODEL + "|" + Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=errormsg\r\n\r\n");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileKey\r\n\r\n");
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=imei\r\n\r\n");
    ((StringBuilder)localObject).append(n.d());
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileSeq\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=fileMaxSeq\r\n\r\n");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--").append(paramString1).append("\r\n");
    ((StringBuilder)localObject).append("Content-Disposition: form-data; name=clientuins\r\n\r\n");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\r\n");
    ((StringBuilder)localObject).append("--" + paramString1 + "--\r\n");
    paramDataOutputStream.flush();
    paramDataOutputStream.close();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    label199:
    label213:
    do
    {
      for (;;)
      {
        return;
        paramString1 = new File(paramString1);
        if (!paramString1.exists()) {
          break;
        }
        int i1;
        long l1;
        int n;
        for (;;)
        {
          try
          {
            if (BaseConstants.REPORTLOGONCEMAXSIZE < 1024L) {
              BaseConstants.REPORTLOGONCEMAXSIZE = 1024L;
            }
            i1 = 1;
            l1 = 0L;
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "want send size " + paramString1.length());
            }
            if (paramString1.length() % BaseConstants.REPORTLOGONCEMAXSIZE <= 0L) {
              break label199;
            }
            n = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE + 1L);
            if (n <= BaseConstants.REPORTLOGMAXPACKAGECOUNT) {
              break label213;
            }
            a(paramInt, m(), "report size is too big " + paramString1.length(), MsfSdkUtils.insertMtype("reportLog", i), 1, n);
            return;
          }
          catch (Exception paramString1) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(a, 2, "report log error " + paramString1, paramString1);
          return;
          n = (int)(paramString1.length() / BaseConstants.REPORTLOGONCEMAXSIZE);
        }
        while (l1 < paramString1.length())
        {
          long l3 = paramString1.length() - l1;
          long l2 = l3;
          if (l3 > BaseConstants.REPORTLOGONCEMAXSIZE) {
            l2 = BaseConstants.REPORTLOGONCEMAXSIZE;
          }
          a(paramInt, m(), paramString1, i, i1, n, l1, l2, true, paramString2, paramString3, 0L);
          l1 += l2;
          i1 += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "logName is not existed.");
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3)
    throws Exception
  {
    String str = null;
    try
    {
      paramString3 = (HttpURLConnection)new URL(paramString3).openConnection();
      str = paramString3;
      paramString3.setDoInput(true);
      str = paramString3;
      paramString3.setDoOutput(true);
      str = paramString3;
      paramString3.setUseCaches(false);
      str = paramString3;
      paramString3.setRequestMethod("POST");
      str = paramString3;
      paramString3.setRequestProperty("Charset", "UTF-8");
      str = paramString3;
      paramString3.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + paramString1);
      str = paramString3;
      a(paramInt1, paramString1, paramString2, paramInt2, paramInt3, new DataOutputStream(paramString3.getOutputStream()));
      str = paramString3;
      a(paramString3);
      return;
    }
    finally
    {
      if (str != null) {
        str.disconnect();
      }
      if (MsfCore.SysVerSion >= 14) {
        TrafficStats.clearThreadStatsTag();
      }
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      paramHttpURLConnection = paramHttpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int n = paramHttpURLConnection.read(arrayOfByte, 0, 1024);
        if (n == -1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "read " + new String(arrayOfByte, 0, n));
        }
      }
    }
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    try
    {
      paramString = new FileOutputStream(new File(paramString));
      ZipOutputStream localZipOutputStream = new ZipOutputStream(paramString);
      int n = 0;
      Iterator localIterator;
      QLog.a locala;
      long l3;
      byte[] arrayOfByte;
      long l1;
      int i1;
      long l2;
      boolean bool;
      for (;;) {}
    }
    catch (IOException paramArrayList)
    {
      try
      {
        localIterator = paramArrayList.iterator();
        if (localIterator.hasNext())
        {
          locala = (QLog.a)localIterator.next();
          if (locala.exists())
          {
            localZipOutputStream.putNextEntry(new ZipEntry(locala.getName() + locala.a));
            localZipOutputStream.setLevel(9);
            l3 = locala.length();
            paramArrayList = new FileInputStream(locala);
          }
        }
        else
        {
          for (;;)
          {
            try
            {
              arrayOfByte = new byte['倀'];
              l1 = 0L;
              i1 = paramArrayList.read(arrayOfByte, 0, 20480);
              if (i1 != -1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(a, 2, "read " + i1 + " from " + locala.getName());
                }
                localZipOutputStream.write(arrayOfByte, 0, i1);
                n = 1;
                l2 = l1 + i1;
                l1 = l2;
                if (l2 >= l3) {
                  n = 1;
                }
              }
            }
            finally
            {
              paramArrayList.close();
              localZipOutputStream.flush();
              localZipOutputStream.closeEntry();
            }
          }
        }
      }
      catch (IOException paramArrayList)
      {
        paramArrayList.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, " zip file error " + paramArrayList, paramArrayList);
        }
        paramString.close();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, " file out stream close.");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, "zip file finish");
          }
          return;
          if (n != 0) {
            localZipOutputStream.close();
          }
          paramArrayList = new File(QLog.getLogPath(), "com.tencent.mobileqq_NETFLOW.log");
          if ((paramArrayList != null) && (paramArrayList.exists()))
          {
            bool = paramArrayList.delete();
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "netflow file has been deleted: " + bool);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, " zip stream close.");
          }
          paramString.close();
          if (QLog.isColorLevel())
          {
            QLog.d(a, 2, " file out stream close.");
            continue;
            paramArrayList = paramArrayList;
            paramArrayList.printStackTrace();
          }
        }
      }
      finally
      {
        paramString.close();
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, " file out stream close.");
        }
      }
    }
  }
  
  private static String b(File paramFile)
  {
    String str = QLog.getLogPath() + paramFile.getName();
    paramFile = str;
    if (str.endsWith(".log")) {
      paramFile = str.substring(0, str.indexOf(".log"));
    }
    return paramFile + ".qlog";
  }
  
  public static void b()
  {
    for (;;)
    {
      int i2;
      String str;
      int i1;
      try
      {
        Object localObject1 = BaseApplication.getContext().getSharedPreferences(f, 0);
        l1 = ((SharedPreferences)localObject1).getLong("lastReportTime", 0L);
        bool1 = ((SharedPreferences)localObject1).getBoolean("opened", false);
        l2 = System.currentTimeMillis();
        if ((l1 != 0L) && (l2 - l1 <= 86400000L)) {
          break;
        }
        ((SharedPreferences)localObject1).edit().putLong("lastReportTime", l2).commit();
        localObject1 = new File(QLog.getLogPath());
        if (((File)localObject1).exists())
        {
          n = 0;
          l1 = 0L;
          localObject4 = "";
          l3 = 0L;
          File[] arrayOfFile = ((File)localObject1).listFiles();
          if ((arrayOfFile != null) && (arrayOfFile.length > 0))
          {
            int i3 = arrayOfFile.length;
            i2 = 0;
            localObject1 = "";
            localObject3 = "";
            l2 = 0L;
            if (i2 < i3)
            {
              localObject5 = arrayOfFile[i2];
              str = ((File)localObject5).getName();
              if ((!str.endsWith(".log")) && (!str.endsWith(".qlog")) && (!str.endsWith(".log.zip"))) {
                break label1067;
              }
              i1 = n + 1;
              l4 = ((File)localObject5).length();
              l2 = ((File)localObject5).length() + l2;
              if (l1 >= l4) {
                break label1062;
              }
              localObject5 = ((File)localObject5).getName();
              l1 = l4;
              boolean bool2 = str.startsWith(QLog.packageName);
              if (!bool2) {
                break label1039;
              }
              Object localObject7 = localObject1;
              Object localObject6 = localObject3;
              try
              {
                n = str.length();
                localObject7 = localObject1;
                localObject6 = localObject3;
                if (str.endsWith(".log"))
                {
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                  n = str.indexOf(".log");
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                  str = str.substring(str.indexOf(".", str.indexOf("mobileqq")) + 1, n);
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                  if (((String)localObject3).equals("")) {
                    break label1088;
                  }
                  localObject4 = localObject3;
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                  if (str.compareTo((String)localObject3) < 0) {
                    break label1088;
                  }
                  localObject7 = localObject1;
                  localObject6 = localObject4;
                  if (((String)localObject1).equals("")) {
                    break label1094;
                  }
                  localObject3 = localObject1;
                  localObject7 = localObject1;
                  localObject6 = localObject4;
                  if (str.compareTo((String)localObject1) > 0) {
                    break label1094;
                  }
                  localObject7 = localObject3;
                  localObject6 = localObject4;
                  localObject1 = new SimpleDateFormat("yy.MM.dd.HH");
                  localObject7 = localObject3;
                  localObject6 = localObject4;
                  l3 = (((SimpleDateFormat)localObject1).parse((String)localObject3).getTime() - ((SimpleDateFormat)localObject1).parse((String)localObject4).getTime()) / 3600000L + 1L;
                  l4 = l2;
                  n = i1;
                  localObject1 = localObject3;
                  localObject3 = localObject4;
                  l2 = l3;
                  l3 = l1;
                  l1 = l4;
                  break label1100;
                }
                localObject7 = localObject1;
                localObject6 = localObject3;
                if (str.endsWith(".qlog"))
                {
                  localObject7 = localObject1;
                  localObject6 = localObject3;
                  n = str.indexOf(".qlog");
                  continue;
                }
                localObject7 = localObject1;
                localObject6 = localObject3;
                if (!str.endsWith(".log.zip")) {
                  continue;
                }
                localObject7 = localObject1;
                localObject6 = localObject3;
                n = str.indexOf(".log.zip");
                continue;
                localObject5 = new HashMap();
              }
              catch (ParseException localParseException)
              {
                localParseException.printStackTrace();
                l3 = -1L;
                l4 = l2;
                n = i1;
                localObject2 = localObject7;
                localObject3 = localObject6;
                l2 = l3;
                l3 = l1;
                l1 = l4;
              }
            }
            ((HashMap)localObject5).put("fileCount", "" + n);
            ((HashMap)localObject5).put("sizeTotal", "" + l2);
            ((HashMap)localObject5).put("sizeMax", "" + l1);
            ((HashMap)localObject5).put("maxSizeName", "" + (String)localObject4);
            ((HashMap)localObject5).put("startLogTime", "" + (String)localObject3);
            ((HashMap)localObject5).put("endLogTime", "" + (String)localObject2);
            ((HashMap)localObject5).put("logHours", "" + l3);
            ((HashMap)localObject5).put("sdcardsize", "" + n());
            ((HashMap)localObject5).put("freesize", "" + o());
            ((HashMap)localObject5).put("compressed", "" + com.tencent.mobileqq.msf.core.a.a.q());
            ((HashMap)localObject5).put("logLevel", "" + QLog.getUIN_REPORTLOG_LEVEL());
            ((HashMap)localObject5).put("account", "" + MsfService.getCore().getAccountCenter().i());
            ((HashMap)localObject5).put("logTestOpened", "" + bool1);
            MsfService.getCore().getStatReporter().a("msflogInfo2", bool1, l3, l2, (Map)localObject5, false, false);
            return;
          }
        }
        Object localObject2 = MsfService.getCore().getStatReporter();
        if (!QLog.isColorLevel())
        {
          bool1 = true;
          ((m)localObject2).a("msflogInfoEmpty", bool1, 0L, 0L, null, false, false);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label1039:
      long l4 = l2;
      int n = i1;
      long l2 = l3;
      long l3 = l1;
      long l1 = l4;
      break label1100;
      label1062:
      Object localObject5 = localObject4;
      continue;
      label1067:
      l4 = l2;
      l2 = l3;
      localObject5 = localObject4;
      l3 = l1;
      l1 = l4;
      break label1100;
      label1088:
      Object localObject4 = str;
      continue;
      label1094:
      Object localObject3 = str;
      continue;
      label1100:
      i2 += 1;
      l4 = l3;
      localObject4 = localObject5;
      l3 = l2;
      l2 = l1;
      l1 = l4;
    }
  }
  
  private static boolean c(File paramFile)
  {
    ZipOutputStream localZipOutputStream;
    try
    {
      localZipOutputStream = new ZipOutputStream(new FileOutputStream(new File(b(paramFile))));
      localZipOutputStream.setLevel(com.tencent.mobileqq.msf.core.a.a.bf());
      byte[] arrayOfByte = new byte['Ѐ'];
      ZipEntry localZipEntry = new ZipEntry(paramFile.getName());
      localZipEntry.setSize(paramFile.length());
      localZipEntry.setTime(paramFile.lastModified());
      localZipOutputStream.putNextEntry(localZipEntry);
      paramFile = new BufferedInputStream(new FileInputStream(paramFile));
      for (;;)
      {
        int n = paramFile.read(arrayOfByte, 0, 1024);
        if (n == -1) {
          break;
        }
        localZipOutputStream.write(arrayOfByte, 0, n);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return false;
    }
    localZipOutputStream.close();
    return true;
  }
  
  private static boolean i()
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.s()) {
        return false;
      }
      SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(f, 0);
      if (localSharedPreferences.getBoolean("opened", false)) {
        return true;
      }
      long l1 = Long.parseLong(MsfService.getCore().getAccountCenter().i());
      if ((com.tencent.mobileqq.msf.core.a.a.r()) && (l1 % 2L == 0L))
      {
        localSharedPreferences.edit().putBoolean("opened", true).commit();
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  private static void j()
  {
    i locali = new i();
    locali.setName("delLogThread");
    locali.start();
  }
  
  private static String k()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() - 3600000L);
    return new SimpleDateFormat("yy.MM.dd.HH").format(localCalendar.getTime());
  }
  
  private static void l()
  {
    k localk = new k();
    localk.setName("delLogThread");
    localk.start();
  }
  
  private static String m()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int n = 0;
    while (n < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      n += 1;
    }
    return str;
  }
  
  private static long n()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int n = localStatFs.getBlockCount();
      return n * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  private static long o()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      int n = localStatFs.getAvailableBlocks();
      return n * l1;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\core\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
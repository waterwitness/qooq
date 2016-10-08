package com.tencent.mfsdk.LeakInspector;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kfx;

public class DumpMemInfoHandler
{
  public static final int a = 0;
  public static final String a = "/Tencent/MobileQQ/log/";
  public static final String[] a;
  public static final int b = 1;
  private static final String b = "LeakInspector";
  public static final int c = 2;
  private static final String c = "com.tencent.mobileqq";
  public static final int d = 3;
  private static String d;
  public static final int e = 4;
  private static final String e = "android.permission.DUMP";
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = 11;
  public static final int m = 12;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = "";
    a = new String[] { "NATIVE", "DALVIK", "CURSOR", "ASHMEM", "OTHER_DEV", "SO_MMAP", "JAR_MMAP", "APK_MMAP", "TTF_MMAP", "DEX_MMAP", "OTHER_MMAP", "UNKNOWN" };
    String str = Environment.getExternalStorageDirectory().getPath();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (!str.endsWith("/")) {
        localObject = str + "/";
      }
      d = (String)localObject + "/Tencent/MobileQQ/log/";
      localObject = new File(d);
      if ((!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
        ((File)localObject).mkdirs();
      }
    }
  }
  
  public static int a(String paramString, List paramList1, List paramList2)
  {
    int i5 = 0;
    int i6 = 0;
    int i3 = 0;
    int i1 = 0;
    int i2 = 0;
    long l1 = 0L;
    Object localObject1 = "";
    int n = 0;
    for (;;)
    {
      if (new File(paramString).exists()) {
        n = 1;
      }
      for (;;)
      {
        if (n == 0) {
          return 0;
        }
        try
        {
          Thread.sleep(500L);
          if (n >= 10)
          {
            n = 0;
            continue;
            BufferedReader localBufferedReader = new BufferedReader(new FileReader(paramString));
            Object localObject2 = localBufferedReader.readLine();
            if (localObject2 == null)
            {
              localBufferedReader.close();
              return 0;
              while (i6 == 0)
              {
                int i7 = 0;
                if (((String)localObject2).length() < 1)
                {
                  n = 11;
                }
                else
                {
                  long l3;
                  if ((((String)localObject2).length() > 30) && (((String)localObject2).charAt(8) == '-') && (((String)localObject2).charAt(17) == ' '))
                  {
                    paramString = ((String)localObject2).split(" ");
                    localObject2 = paramString[0].split("-");
                    l3 = Long.parseLong(localObject2[0], 16);
                    long l2 = Long.parseLong(localObject2[1], 16);
                    i4 = 5;
                    while ((i4 < paramString.length) && (paramString[i4].equals(""))) {
                      i4 += 1;
                    }
                    if (i4 < paramString.length)
                    {
                      paramString = paramString[i4];
                      label244:
                      i4 = paramString.length();
                      if (!paramString.equals("[heap]")) {
                        break label441;
                      }
                      n = 0;
                      label262:
                      l1 = l2;
                      i4 = n;
                      n = i3;
                      label274:
                      localObject2 = localBufferedReader.readLine();
                      if (localObject2 != null) {
                        break label628;
                      }
                      i6 = 1;
                      label289:
                      if (i7 != 0) {
                        break label999;
                      }
                      localObject1 = (Map)paramList2.get(i4);
                      if (!((Map)localObject1).containsKey(paramString)) {
                        break label961;
                      }
                      ((Map)localObject1).put(paramString, Integer.valueOf(((Integer)((Map)localObject1).get(paramString)).intValue() + n));
                    }
                  }
                  for (;;)
                  {
                    localObject1 = (DumpMemInfoHandler.StatFields)paramList1.get(i4);
                    ((DumpMemInfoHandler.StatFields)localObject1).a += n;
                    localObject1 = (DumpMemInfoHandler.StatFields)paramList1.get(i4);
                    ((DumpMemInfoHandler.StatFields)localObject1).b += i2;
                    localObject1 = (DumpMemInfoHandler.StatFields)paramList1.get(i4);
                    ((DumpMemInfoHandler.StatFields)localObject1).c += i1;
                    i5 += n;
                    localObject1 = paramString;
                    i3 = n;
                    n = i4;
                    break;
                    paramString = "";
                    break label244;
                    label441:
                    if (paramString.startsWith("/dev/ashmem/dalvik-"))
                    {
                      n = 1;
                      break label262;
                    }
                    if (paramString.startsWith("/dev/ashmem/CursorWindow"))
                    {
                      n = 2;
                      break label262;
                    }
                    if (paramString.startsWith("/dev/ashmem/"))
                    {
                      n = 3;
                      break label262;
                    }
                    if (paramString.startsWith("/dev/"))
                    {
                      n = 4;
                      break label262;
                    }
                    if (paramString.endsWith(".so"))
                    {
                      n = 5;
                      break label262;
                    }
                    if (paramString.endsWith(".jar"))
                    {
                      n = 6;
                      break label262;
                    }
                    if (paramString.endsWith(".apk"))
                    {
                      n = 7;
                      break label262;
                    }
                    if (paramString.endsWith(".ttf"))
                    {
                      n = 8;
                      break label262;
                    }
                    if (paramString.endsWith(".dex"))
                    {
                      n = 9;
                      break label262;
                    }
                    if (i4 > 0)
                    {
                      n = 10;
                      break label262;
                    }
                    if ((l3 != l1) || (n != 5)) {
                      break label1025;
                    }
                    n = 5;
                    paramString = (String)localObject1;
                    break label262;
                    i7 = 1;
                    i4 = 11;
                    n = i3;
                    break label274;
                    label628:
                    String[] arrayOfString = ((String)localObject2).split(" ");
                    String str = arrayOfString[0];
                    i8 = 0;
                    i3 = 1;
                    try
                    {
                      while ((i3 < arrayOfString.length) && (arrayOfString[i3].equals(""))) {
                        i3 += 1;
                      }
                      if (i3 >= arrayOfString.length) {
                        break label734;
                      }
                      i3 = Integer.parseInt(arrayOfString[i3]);
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        label697:
                        i3 = i8;
                      }
                    }
                    if (str.equals("Size:"))
                    {
                      i3 = i2;
                      i2 = n;
                      n = i3;
                    }
                    for (;;)
                    {
                      i3 = i2;
                      i2 = n;
                      n = i3;
                      break;
                      label734:
                      i3 = 0;
                      break label697;
                      if (str.equals("Rss:"))
                      {
                        i3 = n;
                        n = i2;
                        i2 = i3;
                      }
                      else if (str.equals("Pss:"))
                      {
                        n = i2;
                        i2 = i3;
                      }
                      else if (str.equals("Shared_Clean:"))
                      {
                        i3 = n;
                        n = i2;
                        i2 = i3;
                      }
                      else if (str.equals("Shared_Dirty:"))
                      {
                        i1 = i3;
                        i3 = i2;
                        i2 = n;
                        n = i3;
                      }
                      else if (str.equals("Private_Clean:"))
                      {
                        i3 = n;
                        n = i2;
                        i2 = i3;
                      }
                      else if (str.equals("Private_Dirty:"))
                      {
                        i2 = n;
                        n = i3;
                      }
                      else
                      {
                        if (!str.equals("Referenced:")) {
                          break label916;
                        }
                        i3 = n;
                        n = i2;
                        i2 = i3;
                      }
                    }
                    label916:
                    if ((((String)localObject2).length() <= 30) || (((String)localObject2).charAt(8) != '-') || (((String)localObject2).charAt(17) != ' ')) {
                      break label1010;
                    }
                    System.out.println((String)localObject2);
                    break label289;
                    label961:
                    ((Map)localObject1).put(paramString, Integer.valueOf(n));
                  }
                }
              }
              localBufferedReader.close();
              return i5;
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            int i4;
            int i8;
            continue;
            label999:
            i3 = n;
            n = i4;
            continue;
            label1010:
            i3 = n;
            n = i2;
            i2 = i3;
            continue;
            label1025:
            n = 11;
            continue;
            n = 11;
            paramString = "";
          }
          n += 1;
        }
      }
    }
  }
  
  public static String a()
  {
    String str = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str = d + "thread_mobileqq" + str + ".trace";
    int i2 = Thread.activeCount();
    if (i2 == 0) {
      return "";
    }
    Object localObject = new Thread[i2];
    Thread.enumerate((Thread[])localObject);
    StringBuilder localStringBuilder = new StringBuilder(i2 * 1024);
    int n = 0;
    if (n < i2)
    {
      StackTraceElement[] arrayOfStackTraceElement = localObject[n];
      if (arrayOfStackTraceElement == null) {}
      for (;;)
      {
        n += 1;
        break;
        if (arrayOfStackTraceElement.isAlive())
        {
          localStringBuilder.append("thread name: ");
          localStringBuilder.append(arrayOfStackTraceElement.getName());
          localStringBuilder.append("\n");
          arrayOfStackTraceElement = arrayOfStackTraceElement.getStackTrace();
          if (arrayOfStackTraceElement != null)
          {
            int i1 = 0;
            while (i1 < arrayOfStackTraceElement.length)
            {
              localStringBuilder.append(" at ");
              localStringBuilder.append(arrayOfStackTraceElement[i1].toString());
              localStringBuilder.append("\n");
              i1 += 1;
            }
          }
        }
        localStringBuilder.append("\n");
      }
    }
    try
    {
      localObject = new FileWriter(str, false);
      ((FileWriter)localObject).write(localStringBuilder.toString());
      ((FileWriter)localObject).close();
      return str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private static String a(long paramLong)
  {
    String str1 = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/" + BaseApplicationImpl.getContext().getPackageName().replace(".", "/") + "/";
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    localObject = TimeFormatterUtils.a(((Calendar)localObject).getTimeInMillis(), "yy.MM.dd.HH");
    String str2 = MsfSdkUtils.getProcessName(BaseApplicationImpl.getContext());
    return str1 + str2.replace(":", "_") + "." + (String)localObject + ".log";
  }
  
  private static String a(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    try
    {
      String str = "/proc/" + paramRunningAppProcessInfo.pid + "/smaps";
      ArrayList localArrayList1 = new ArrayList(12);
      ArrayList localArrayList2 = new ArrayList(12);
      int n = 0;
      while (n < 12)
      {
        DumpMemInfoHandler.StatFields localStatFields = new DumpMemInfoHandler.StatFields();
        HashMap localHashMap = new HashMap();
        localArrayList1.add(localStatFields);
        localArrayList2.add(localHashMap);
        n += 1;
      }
      n = a(str, localArrayList1, localArrayList2);
      if (n > 0) {
        return a(paramRunningAppProcessInfo.processName, localArrayList1, localArrayList2, n, paramString);
      }
      return "";
    }
    catch (Throwable paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "generateDetailMemory", paramRunningAppProcessInfo);
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String[] arrayOfString;
    String str;
    do
    {
      return paramString;
      arrayOfString = paramString.split(":");
      paramString = arrayOfString[0].split("\\.");
      str = paramString[(paramString.length - 1)];
      paramString = str;
    } while (arrayOfString.length <= 1);
    return str + "_" + arrayOfString[1];
  }
  
  public static String a(String paramString1, List paramList1, List paramList2, int paramInt, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString2 + " smaps begin] =======\n");
    localStringBuffer.append(String.format("TotalPss%8dK\n", new Object[] { Integer.valueOf(paramInt) }));
    paramInt = 0;
    while (paramInt < paramList1.size())
    {
      localStringBuffer.append(String.format("\n\n%-11s    %dK\n", new Object[] { a[paramInt], Long.valueOf(((DumpMemInfoHandler.StatFields)paramList1.get(paramInt)).a) }));
      if (((Map)paramList2.get(paramInt)).size() > 0)
      {
        Map.Entry[] arrayOfEntry = a((Map)paramList2.get(paramInt));
        int n = 0;
        while (n < arrayOfEntry.length)
        {
          localStringBuffer.append(String.format("%10dK    %s\n", new Object[] { arrayOfEntry[n].getValue(), arrayOfEntry[n].getKey() }));
          n += 1;
        }
      }
      paramInt += 1;
    }
    localStringBuffer.append("\n====== [" + paramString1 + " smaps end] =======\n");
    paramList1 = localStringBuffer.toString();
    if (QLog.isColorLevel()) {
      QLog.i("LeakInspector", 2, paramList1);
    }
    paramString1 = d + "dump_" + a(paramString1) + "_" + paramString2 + ".smaps";
    paramList2 = new BufferedWriter(new FileWriter(paramString1));
    paramList2.write(paramList1);
    paramList2.close();
    return paramString1;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList(10);
    String str1 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (((ActivityManager.RunningAppProcessInfo)localObject).processName.startsWith("com.tencent.mobileqq"))
      {
        String str2 = a((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
        localObject = b((ActivityManager.RunningAppProcessInfo)localObject, str1);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\n====== [" + paramString1 + " " + paramString3 + " meminfo begin] =======\n");
    localStringBuffer.append(FileUtils.a(new File(paramString2)));
    localStringBuffer.append("\n====== [" + paramString1 + " meminfo end] =======\n");
    if (QLog.isColorLevel()) {
      QLog.i("LeakInspector", 2, localStringBuffer.toString());
    }
  }
  
  public static Object[] a(String paramString)
  {
    if (!"mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
      return new Object[] { Boolean.valueOf(false), null };
    }
    Object localObject;
    boolean bool;
    try
    {
      localObject = b(paramString);
      bool = ((Boolean)localObject[0]).booleanValue();
      localObject = (String)localObject[1];
      if (!bool) {
        return new Object[] { Boolean.valueOf(false), null };
      }
    }
    catch (Throwable paramString)
    {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, "dumpQQMemory", paramString);
      }
      paramString = "";
      for (;;)
      {
        return new Object[] { Boolean.valueOf(bool), paramString };
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(a());
        localArrayList.addAll(b());
        localArrayList.add(b());
        localArrayList.add(a());
        localArrayList.add(localObject);
        paramString = a(localArrayList, paramString);
        bool = ((Boolean)paramString[0]).booleanValue();
        try
        {
          paramString = (String)paramString[1];
        }
        catch (Throwable paramString) {}
      }
    }
  }
  
  public static Object[] a(List paramList, String paramString)
  {
    Object localObject1 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    paramString = d + "dump_" + paramString + "_" + (String)localObject1 + ".zip";
    for (;;)
    {
      try
      {
        localObject1 = new BufferedOutputStream(new FileOutputStream(new File(paramString)));
        localZipOutputStream = new ZipOutputStream((OutputStream)localObject1);
        n = 0;
      }
      catch (Exception paramList)
      {
        ZipOutputStream localZipOutputStream;
        int n;
        long l3;
        Iterator localIterator;
        boolean bool1;
        boolean bool2 = false;
        continue;
      }
      try
      {
        l3 = System.currentTimeMillis();
        localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject2 = new File((String)localIterator.next());
          if (!((File)localObject2).exists()) {
            continue;
          }
          localZipOutputStream.putNextEntry(new ZipEntry(((File)localObject2).getName()));
          localZipOutputStream.setLevel(9);
          long l4 = ((File)localObject2).length();
          localObject2 = new FileInputStream((File)localObject2);
          try
          {
            byte[] arrayOfByte = new byte['倀'];
            long l1 = 0L;
            int i2 = ((FileInputStream)localObject2).read(arrayOfByte, 0, 20480);
            if (i2 != -1)
            {
              localZipOutputStream.write(arrayOfByte, 0, i2);
              int i1 = 1;
              n = 1;
              long l2 = l1 + i2;
              l1 = l2;
              if (l2 < l4) {
                continue;
              }
              n = i1;
            }
          }
          finally
          {
            ((FileInputStream)localObject2).close();
            localZipOutputStream.flush();
            localZipOutputStream.closeEntry();
          }
        }
      }
      catch (IOException paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LeakInspector", 2, "zipFiles", paramList);
        }
        if (localObject1 != null)
        {
          try
          {
            ((BufferedOutputStream)localObject1).close();
            bool1 = false;
          }
          catch (IOException paramList)
          {
            boolean bool3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("LeakInspector", 2, "zipFiles", paramList);
            bool1 = false;
            continue;
          }
          return new Object[] { Boolean.valueOf(bool1), paramString };
          if (n != 0) {
            localZipOutputStream.close();
          }
          if (QLog.isColorLevel()) {
            QLog.d("LeakInspector", 2, "zip used " + (System.currentTimeMillis() - l3) + " ms covered " + paramList.size() + " files");
          }
          bool3 = true;
          bool2 = true;
          bool1 = bool2;
          if (localObject1 == null) {
            continue;
          }
          try
          {
            ((BufferedOutputStream)localObject1).close();
            bool1 = bool2;
          }
          catch (IOException paramList)
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("LeakInspector", 2, "zipFiles", paramList);
            bool1 = bool2;
          }
          catch (Exception paramList)
          {
            bool2 = bool3;
          }
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("LeakInspector", 2, "zipFiles", paramList);
          bool1 = bool2;
          continue;
        }
      }
      finally
      {
        if (localObject1 != null) {}
        try
        {
          ((BufferedOutputStream)localObject1).close();
          throw paramList;
        }
        catch (IOException localIOException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("LeakInspector", 2, "zipFiles", localIOException);
          continue;
        }
        bool1 = false;
        continue;
      }
    }
  }
  
  private static Map.Entry[] a(Map paramMap)
  {
    paramMap = paramMap.entrySet();
    paramMap = (Map.Entry[])paramMap.toArray(new Map.Entry[paramMap.size()]);
    Arrays.sort(paramMap, new kfx());
    return paramMap;
  }
  
  public static String b()
  {
    String str1 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    str1 = "trace_mobileqq" + str1 + ".trace";
    int n = 0;
    for (int i1 = 0;; i1 = i2)
    {
      if ((n >= 3) || (i1 != 0)) {
        break label138;
      }
      try
      {
        Runtime.getRuntime().exec("chmod 777 /data/anr");
        Runtime.getRuntime().exec("rm /data/anr/traces.txt");
        Runtime.getRuntime().exec("kill -3 " + Process.myPid());
        i2 = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          int i2 = i1;
          if (QLog.isColorLevel())
          {
            QLog.d("LeakInspector", 2, "generateTraces", localIOException);
            i2 = i1;
          }
        }
      }
      n += 1;
    }
    label138:
    if (i1 != 0)
    {
      n = 0;
      boolean bool = false;
      for (;;)
      {
        if ((n < 3) && (!bool))
        {
          String str2 = FileUtils.a(new File("/data/anr/traces.txt"));
          if (str2 != null) {
            bool = FileUtils.a(d, str1, str2);
          }
          if (!bool) {}
          try
          {
            Thread.sleep(1000L);
            n += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("LeakInspector", 2, "InterruptedException", localInterruptedException);
              }
            }
          }
        }
      }
    }
    return d + str1;
  }
  
  private static String b(ActivityManager.RunningAppProcessInfo paramRunningAppProcessInfo, String paramString)
  {
    String str1 = d + a(paramRunningAppProcessInfo.processName) + paramString + ".meminfo";
    try
    {
      if (BaseApplicationImpl.a.checkPermission("android.permission.DUMP", paramRunningAppProcessInfo.pid, paramRunningAppProcessInfo.uid) == 0) {}
      for (int n = 1;; n = 0)
      {
        if (n != 0)
        {
          String str2 = "dumpsys meminfo " + paramRunningAppProcessInfo.processName + " > " + str1;
          Runtime.getRuntime().exec(str2);
          a(paramRunningAppProcessInfo.processName, str1, paramString);
        }
        return str1;
      }
      return "";
    }
    catch (IOException paramRunningAppProcessInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LeakInspector", 2, "generateMemInfo", paramRunningAppProcessInfo);
      }
    }
  }
  
  public static List b()
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    localArrayList.add(a(l1));
    localArrayList.add(a(l1 - 3600000L));
    localArrayList.add(AppConstants.bn + "log.txt");
    return localArrayList;
  }
  
  public static Object[] b(String paramString)
  {
    Object localObject = "";
    if (QLog.isColorLevel()) {
      QLog.d("LeakInspector", 2, "ReportLog dumpHprof : " + paramString);
    }
    String str2 = TimeFormatterUtils.a(System.currentTimeMillis(), "yy-MM-dd_HH.mm.ss");
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/MobileQQ/log/");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      String str1 = ((File)localObject).getAbsolutePath();
      localObject = str1;
      if (!str1.endsWith("/")) {
        localObject = str1 + "/";
      }
    }
    for (paramString = (String)localObject + "dump_" + paramString + "_" + str2 + ".hprof";; paramString = (String)localObject)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        Debug.dumpHprofData(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("LeakInspector", 2, "dump used " + (System.currentTimeMillis() - l1) + " ms");
        }
        bool = true;
        return new Object[] { Boolean.valueOf(bool), paramString };
      }
      catch (IOException localIOException)
      {
        localObject = paramString;
        if (QLog.isColorLevel())
        {
          QLog.e("LeakInspector", 2, "generateHprof", localIOException);
          localObject = paramString;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mfsdk\LeakInspector\DumpMemInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
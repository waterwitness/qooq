package com.tencent.mobileqq.testassister;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import uyn;
import uyo;
import uyp;
import uyq;

public class ShareAppLogHelper
  implements Runnable
{
  public static final int a = 0;
  public static final String a = "/data/anr/traces.txt";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "logs_zip_";
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  public static final int f = 10485760;
  private static final int g = 1000;
  private static final int h = 1001;
  private static final int i = 1002;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener;
  volatile Object jdField_a_of_type_JavaLangObject;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean;
  private Time jdField_b_of_type_AndroidTextFormatTime;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  
  public ShareAppLogHelper(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{2}.\\d{2}.\\d{2}.\\d{2}");
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidOsHandler = new uyn(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = (Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/");
    this.d = (Environment.getExternalStorageDirectory().getPath() + "/tencent/com/tencent/mobileqq/");
  }
  
  private int a()
  {
    int k = 0;
    Object localObject = new File(this.c);
    int j;
    if (!((File)localObject).exists()) {
      j = -1;
    }
    do
    {
      return j;
      a();
      localObject = ((File)localObject).listFiles(new uyo(this));
      if ((localObject != null) && (localObject.length > 0))
      {
        int m = localObject.length;
        j = 0;
        while (j < m)
        {
          ShareAppLogHelper.LogFile localLogFile = new ShareAppLogHelper.LogFile(localObject[j].getPath());
          this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile);
          j += 1;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new ShareAppLogHelper.LogFile("/data/anr/traces.txt");
        if ((((ShareAppLogHelper.LogFile)localObject).exists()) && (((ShareAppLogHelper.LogFile)localObject).length() > 0L)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break;
      }
      j = k;
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() > 0);
    return -2;
  }
  
  private Time a(String paramString)
  {
    paramString = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find())
    {
      paramString = a(paramString.group(), "\\.");
      if (paramString != null)
      {
        if (paramString.year < 100) {
          paramString.year += 2000;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static Time a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(paramString2);
      if (paramString1.length == 4)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        paramString2.hour = Integer.parseInt(paramString1[3]);
        return paramString2;
      }
      if (paramString1.length == 3)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String a(Time paramTime)
  {
    return String.format("%4d_%2d_%2d_%2d", new Object[] { Integer.valueOf(paramTime.year), Integer.valueOf(paramTime.month + 1), Integer.valueOf(paramTime.monthDay), Integer.valueOf(paramTime.hour) });
  }
  
  private String a(Time paramTime1, Time paramTime2)
  {
    return "logs_zip_" + a(paramTime1) + "-" + a(paramTime2) + ".zip";
  }
  
  private void a()
  {
    Object localObject = new File(this.d);
    if (((File)localObject).exists())
    {
      localObject = ((File)localObject).listFiles(new uyp(this));
      if ((localObject != null) && (localObject.length > 0))
      {
        int k = localObject.length;
        int j = 0;
        while (j < k)
        {
          ShareAppLogHelper.LogFile localLogFile = new ShareAppLogHelper.LogFile(localObject[j].getPath());
          localLogFile.stuffix = ".old";
          this.jdField_a_of_type_JavaUtilArrayList.add(localLogFile);
          j += 1;
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(String paramString)
  {
    new uyq(this, paramString).start();
  }
  
  private int b()
  {
    this.e = (this.c + a(this.jdField_a_of_type_AndroidTextFormatTime, this.jdField_b_of_type_AndroidTextFormatTime));
    ZipOutputStream localZipOutputStream;
    for (;;)
    {
      try
      {
        File localFile = new File(this.e);
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(localFile));
        byte[] arrayOfByte = new byte['Ѐ'];
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject = (ShareAppLogHelper.LogFile)localIterator.next();
        ZipEntry localZipEntry = new ZipEntry(((ShareAppLogHelper.LogFile)localObject).getName() + ((ShareAppLogHelper.LogFile)localObject).stuffix);
        localZipEntry.setSize(((ShareAppLogHelper.LogFile)localObject).length());
        localZipEntry.setTime(((ShareAppLogHelper.LogFile)localObject).lastModified());
        localZipOutputStream.putNextEntry(localZipEntry);
        localObject = new BufferedInputStream(new FileInputStream((File)localObject));
        int j = ((InputStream)localObject).read(arrayOfByte, 0, 1024);
        if (j != -1) {
          localZipOutputStream.write(arrayOfByte, 0, j);
        } else {
          ((InputStream)localObject).close();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -3;
      }
    }
    localZipOutputStream.close();
    long l = localException.length();
    if (l >= 10485760L) {
      return 1;
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidTextFormatTime = null;
    this.jdField_b_of_type_AndroidTextFormatTime = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private void b(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1002;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1000;
    if (paramString == null) {}
    for (localMessage.obj = "";; localMessage.obj = paramString)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return "Failed!";
    case -1: 
      return "日志路径不存在！";
    case -2: 
      return "没有符合条件的日志文件！";
    case -3: 
      return "压缩失败！";
    }
    return "你的日志大小已经超过1M，确认发送？";
  }
  
  public void a(ShareAppLogHelper.OnGetLocalLogListener paramOnGetLocalLogListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = paramOnGetLocalLogListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean a(Time paramTime1, Time paramTime2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidTextFormatTime = paramTime1;
    this.jdField_b_of_type_AndroidTextFormatTime = paramTime2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    new Thread(this).start();
    return true;
  }
  
  public void run()
  {
    int j = a();
    if (j != 0)
    {
      a(j);
      b();
      return;
    }
    j = b();
    if (j == 1)
    {
      b(j);
      c();
      if (!this.jdField_b_of_type_Boolean) {
        b(this.e);
      }
    }
    for (;;)
    {
      b();
      return;
      a(this.e);
      continue;
      if (j == 0) {
        b(this.e);
      } else {
        a(j);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\testassister\ShareAppLogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
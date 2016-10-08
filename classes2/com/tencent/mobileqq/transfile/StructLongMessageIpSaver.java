package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StructLongMessageIpSaver
  implements INetInfoHandler
{
  public static final String a = "StructLongMessageIpSaver";
  private static final String d = AppConstants.cP + "longMsgList.ini";
  private static final String e = AppConstants.cP + "longMsgList.tmp";
  private int a;
  private String b;
  private String c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructLongMessageIpSaver()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.a(), this);
    d();
    b();
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("^http://((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(:(\\d{1,4}|[1-5]\\d\\d\\d\\d|6[0-4]\\d\\d\\d|65[0-4]\\d\\d|655[0-2]\\d|6553[0-5]))?/$").matcher(paramString).matches();
  }
  
  private void b()
  {
    try
    {
      Object localObject = FileUtils.a(d);
      if (((File)localObject).length() == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageIpSaver", 2, "read file failed, f.length() == 0");
        }
      }
      else
      {
        localObject = new BufferedReader(new InputStreamReader(new FileInputStream((File)localObject)));
        this.b = ((BufferedReader)localObject).readLine();
        this.c = ((BufferedReader)localObject).readLine();
        ((BufferedReader)localObject).close();
        if ((this.b == null) || (!a(this.b))) {
          this.b = null;
        }
        if ((this.c == null) || (!a(this.c)))
        {
          this.c = null;
          return;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageIpSaver", 2, "readFromFile failed, File Not Found");
      }
      localFileNotFoundException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongMessageIpSaver", 2, "readFromFile failed, IOException");
      }
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    try
    {
      localFile1 = FileUtils.a(d);
      if (localFile1.exists()) {
        localFile1.delete();
      }
      if ((this.b == null) && (this.c == null)) {
        return;
      }
      localFile2 = FileUtils.a(e);
      if (localFile2.exists()) {
        localFile2.delete();
      }
      localFile2.createNewFile();
      localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localFile2)));
      if (this.b == null) {
        break label162;
      }
      str1 = this.b;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        File localFile1;
        File localFile2;
        BufferedWriter localBufferedWriter;
        String str1;
        if (QLog.isColorLevel()) {
          QLog.d("StructLongMessageIpSaver", 2, "readFromFile failed, File Not Found");
        }
        localFileNotFoundException.printStackTrace();
        return;
        String str2 = "";
        continue;
        str2 = "";
      }
    }
    catch (Exception localException)
    {
      label162:
      if (!QLog.isColorLevel()) {
        break label189;
      }
      QLog.d("StructLongMessageIpSaver", 2, "readFromFile failed, IOException");
      label189:
      localException.printStackTrace();
    }
    localBufferedWriter.write(str1);
    localBufferedWriter.write("\n");
    if (this.c != null)
    {
      str1 = this.c;
      localBufferedWriter.write(str1);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      localFile2.renameTo(localFile1);
      return;
    }
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        int i = NetworkUtil.b(BaseApplicationImpl.getContext());
        switch (i)
        {
        default: 
          return;
        }
      }
      finally {}
      this.a = 2;
      continue;
      this.a = 1;
    }
  }
  
  public int a()
  {
    try
    {
      int i = this.a;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String a()
  {
    switch (this.a)
    {
    default: 
      return null;
    case 1: 
      return this.c;
    }
    return this.b;
  }
  
  public void a()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void a(ServerAddr paramServerAddr)
  {
    if (paramServerAddr == null) {}
    int j;
    do
    {
      return;
      j = 0;
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("http://").append(paramServerAddr.a);
      if (paramServerAddr.b != 80) {
        localStringBuilder.append(":").append(paramServerAddr.b);
      }
      localStringBuilder.append("/");
      paramServerAddr = localStringBuilder.toString();
      int i = j;
      if (this.b != null)
      {
        i = j;
        if (this.b.equals(paramServerAddr))
        {
          this.b = null;
          i = 1;
        }
      }
      j = i;
      if (this.c != null)
      {
        j = i;
        if (this.c.equals(paramServerAddr))
        {
          this.c = null;
          j = 1;
        }
      }
    } while (j == 0);
    c();
  }
  
  public void b(ServerAddr paramServerAddr)
  {
    if ((paramServerAddr != null) && (this.a != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("http://").append(paramServerAddr.a);
      if (paramServerAddr.b != 80) {
        localStringBuilder.append(":").append(paramServerAddr.b);
      }
      localStringBuilder.append("/");
      paramServerAddr = localStringBuilder.toString();
      if (this.a != 1) {
        break label89;
      }
      this.c = paramServerAddr;
    }
    for (;;)
    {
      c();
      return;
      label89:
      if (this.a == 2) {
        this.b = paramServerAddr;
      }
    }
  }
  
  public void onNetMobile2None()
  {
    try
    {
      this.a = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    try
    {
      this.a = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    try
    {
      this.a = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    try
    {
      this.a = 2;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    try
    {
      this.a = 1;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void onNetWifi2None()
  {
    try
    {
      this.a = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\StructLongMessageIpSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpContinueDownloadFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener
{
  private static final long jdField_a_of_type_Long = 50L;
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^\\d]*(\\d+)\\-(\\d+)/(\\d+)[^\\d]*");
  private static final int aH = 100;
  private static final String jdField_d_of_type_JavaLangString;
  private static final String jdField_e_of_type_JavaLangString = "http://i.gtimg.cn";
  protected QQAppInterface a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_b_of_type_Long;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private long jdField_c_of_type_Long;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private Map jdField_d_of_type_JavaUtilMap = new HashMap();
  private Map jdField_e_of_type_JavaUtilMap;
  private Map f = new HashMap();
  private long j;
  private long k = -1L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_d_of_type_JavaLangString = HttpContinueDownloadFileProcessor.class.getSimpleName();
  }
  
  public HttpContinueDownloadFileProcessor(String paramString1, String paramString2, long paramLong, TransFileController paramTransFileController)
  {
    super(paramTransFileController);
    this.e = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((paramString1 == null) || (paramString1.trim().length() == 0) || (paramString2 == null) || (paramString2.trim().length() == 0)) {
      throw new IllegalArgumentException("url and filePath must not be empty");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg("", paramString1, 1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong;
    if (paramLong % 2048L == 0L) {}
    for (paramLong /= 2048L;; paramLong = paramLong / 2048L + 1L)
    {
      this.jdField_b_of_type_Long = (paramLong / 100L);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "perPkgNum is:" + this.jdField_b_of_type_Long);
      }
      return;
    }
  }
  
  public static File a(String paramString)
  {
    return new File(paramString + ".tmp");
  }
  
  private void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  private void a(Exception paramException)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k)) {}
    for (String str1 = "report_theme_file_download";; str1 = "report_copycat_theme_file_download")
    {
      HashMap localHashMap = new HashMap();
      int m = this.aU;
      String str3 = this.bc;
      String str2 = str3;
      int i = m;
      if (paramException != null)
      {
        str2 = str3;
        i = m;
        if ((paramException instanceof HttpContinueDownloadFileProcessor.ThemeDownloadException))
        {
          paramException = (HttpContinueDownloadFileProcessor.ThemeDownloadException)paramException;
          i = HttpContinueDownloadFileProcessor.ThemeDownloadException.access$000(paramException);
          str2 = paramException.getMessage();
        }
      }
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put("param_FailMsg", str2);
      localHashMap.put("theme_url", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, false, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.trim().startsWith("http://i.gtimg.cn"));
  }
  
  private long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    Matcher localMatcher;
    do
    {
      return (long[])localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "contentRange is:" + paramString);
      }
      localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
      localObject1 = localObject2;
    } while (!localMatcher.matches());
    int m = localMatcher.groupCount();
    paramString = new long[m];
    int i = 1;
    for (;;)
    {
      localObject1 = paramString;
      if (i > m) {
        break;
      }
      paramString[(i - 1)] = Long.parseLong(localMatcher.group(i));
      i += 1;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      if ((paramString1.exists()) && (paramString1.isDirectory()))
      {
        paramString1 = paramString1.listFiles();
        if (paramString1.length > 0)
        {
          int i = 0;
          while (i < paramString1.length)
          {
            String str = paramString1[i].getName();
            if ((str.startsWith(paramString2)) && (str.endsWith(".tmp"))) {
              paramString1[i].delete();
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public static void c(String paramString)
  {
    new File(paramString + ".tmp").delete();
  }
  
  private void e()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k)) {}
    for (String str = "report_theme_file_download";; str = "report_copycat_theme_file_download")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("theme_url", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str, true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start download using " + jdField_d_of_type_JavaLangString);
    }
    boolean bool;
    try
    {
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k, null, this, true);
      localHttpMsg.b(5);
      localHttpMsg.a(true);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp");
      File localFile = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.getParentFile();
      if ((localFile == null) || (localFile.exists())) {
        break label256;
      }
      bool = localFile.mkdirs();
      if (!bool) {
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89069, "failed to make dirs " + localFile.getAbsolutePath());
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "start download failed", localException);
      }
      a(9003, localException.getMessage());
      b(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, jdField_d_of_type_JavaLangString + "make dirs failed,stop download" + bool);
    }
    label256:
    this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    localException.a("Accept-Encoding", "identity");
    long l = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = l;
    localException.a("Range", "bytes=" + l + "-");
    localException.a("Accept", "application/octet-stream");
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start download success,url is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k + ",filePath is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ",fileLength is:" + l);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start send msg to HttpCommunicator");
    }
    this.jdField_d_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
    localException.d = 131072;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException);
    d(2001);
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    for (boolean bool = false;; bool = true)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject2 = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramHttpMsg1);
        localObject3 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
        Boolean localBoolean = (Boolean)this.jdField_c_of_type_JavaUtilMap.get(paramHttpMsg1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("result is:");
          if ((paramHttpMsg2.c() == 200) || (paramHttpMsg2.c() == 206)) {
            continue;
          }
          QLog.d("ThemeDownloadTrace", 2, bool + ",transferedSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + ",requestPause is:" + localObject2 + ",requestStop is:" + localObject3 + ",hasError is:" + localBoolean);
        }
        if (((localObject2 != null) && (((Boolean)localObject2).booleanValue())) || ((localObject3 != null) && (((Boolean)localObject3).booleanValue()))) {
          return;
        }
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          return;
        }
      }
      try
      {
        if (this.k != -1L) {
          break label501;
        }
        if (paramHttpMsg2.c() != 206) {
          break label717;
        }
        localObject2 = paramHttpMsg2.a("content-range");
        localObject3 = a((String)localObject2);
        if ((localObject3 == null) || (localObject3.length < 3)) {
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89065, "Content-Range is illegal,contentRange is:" + (String)localObject2);
        }
      }
      catch (Exception paramHttpMsg2)
      {
        if ((paramHttpMsg2 instanceof HttpContinueDownloadFileProcessor.ThemeDownloadException)) {
          this.f.put(paramHttpMsg1, paramHttpMsg2);
        }
        throw new RuntimeException(paramHttpMsg2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long != localObject3[2]) {
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89066, "fileSize not equal content length,content length is:" + localObject3[2] + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp", true));
      this.k = (localObject3[2] - localObject3[0]);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "totalLen is:" + this.k);
      }
      label501:
      Object localObject2 = paramHttpMsg2.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.write((byte[])localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      ((FileMsg)localObject2).f += paramHttpMsg2.a().length;
      this.j += paramHttpMsg2.a().length;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "thisTimeReadByteNum is:" + this.j + ",totalLen is:" + this.k);
      }
      if (this.j == this.k)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        paramHttpMsg2 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.renameTo(paramHttpMsg2))
        {
          this.e.put(paramHttpMsg1, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.setLastModified(System.currentTimeMillis());
          d(2003);
          e();
        }
      }
      for (;;)
      {
        return;
        label717:
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.f = 0L;
        this.k = paramHttpMsg2.a();
        if (this.k != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long) {
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89066, "fileSize not equal content length,content length is:" + this.k + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp", false));
        break;
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89067, "rename file failed,file path is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        if (this.j > this.k)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "thisTimeReadByteNum less than totalLen,thisTimeReadByteNum is:" + this.j + ",totalLen is:" + this.k);
          }
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89068, "data that server send is wrong,thisTimeReadByteNum is:" + this.j + ",thisTimeTotalByteNum is:" + this.k);
        }
        if (this.jdField_b_of_type_Long < 2L)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.flush();
          h();
        }
        else
        {
          this.jdField_c_of_type_Long += 1L;
          if (this.jdField_c_of_type_Long >= this.jdField_b_of_type_Long)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.flush();
            h();
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, jdField_d_of_type_JavaLangString + " statusChanged(),status is:" + paramInt);
    }
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg arg2)
  {
    do
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.e.put(paramHttpMsg1, Boolean.TRUE);
        if (this.aU != 9037) {
          this.jdField_c_of_type_JavaUtilMap.put(paramHttpMsg1, Boolean.TRUE);
        }
        Boolean localBoolean1 = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramHttpMsg1);
        Boolean localBoolean2 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
        if (((localBoolean1 != null) && (localBoolean1.booleanValue())) || ((localBoolean2 != null) && (localBoolean2.booleanValue()))) {}
        do
        {
          ??? = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramHttpMsg1);
          localBoolean1 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
          if (((??? == null) || (!???.booleanValue())) && ((localBoolean1 == null) || (!localBoolean1.booleanValue()))) {
            break;
          }
          return;
          a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        } while (this.aU == 9037);
        d(2005);
      }
    } while (this.aU == 9037);
    a((Exception)this.f.get(paramHttpMsg1));
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean f()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        if ((Boolean)this.jdField_d_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null)
        {
          bool = true;
          this.e.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          return bool;
        }
        if ((Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null) {
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean g()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        if ((Boolean)this.jdField_d_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null)
        {
          bool = true;
          this.e.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          return bool;
        }
        if ((Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null) {
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean h()
  {
    Boolean localBoolean1 = (Boolean)this.jdField_d_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    Boolean localBoolean2 = (Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    if (localBoolean1 == null) {
      return false;
    }
    return localBoolean2 == null;
  }
  
  public void i() {}
  
  public void j()
  {
    f();
  }
  
  public void k()
  {
    g();
  }
  
  protected void l() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\HttpContinueDownloadFileProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
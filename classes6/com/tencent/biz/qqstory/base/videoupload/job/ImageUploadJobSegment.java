package com.tencent.biz.qqstory.base.videoupload.job;

import android.util.Base64;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.MonitorReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.utils.AssertUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageUploadJobSegment
  extends JobSegment
{
  public static final int a = 90;
  public static final String a = "Q.qqstory.publish:ImageUploadJobSegment";
  public static final int b = 1048576;
  public static final String b = "http://upload.now.qq.com/cgi-bin/bar/upload/base64image";
  public static final int c = 1;
  public static final String c = "&";
  public static final int d = 2;
  public static final int e = 3;
  public long a;
  public DataOutputStream a;
  public HttpURLConnection a;
  public URL a;
  public Map a;
  public Map b;
  public String d;
  public int f;
  
  public ImageUploadJobSegment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
  }
  
  private long a(DataOutputStream paramDataOutputStream, Map paramMap)
  {
    if (paramMap.size() > 0) {}
    long l;
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.assertTrue(bool, "you must have a file");
      Iterator localIterator = paramMap.keySet().iterator();
      l = 0L;
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        paramDataOutputStream.writeBytes(str1 + "=");
        str1 = URLEncoder.encode(new String(a(str2)));
        paramDataOutputStream.writeBytes(str1);
        if (localIterator.hasNext()) {
          paramDataOutputStream.writeBytes("&");
        }
        l = str1.length() + l;
        SLog.b("Q.qqstory.publish:ImageUploadJobSegment", "upload bitmap encode size:%d KB", Long.valueOf(l / 1024L));
      }
    }
    return l;
  }
  
  private FileUploadRspData a(JobContext paramJobContext, String paramString)
  {
    localFileUploadRspData = new FileUploadRspData();
    localFileUploadRspData.i = paramString;
    long l1 = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_JavaNetURL = new URL("http://upload.now.qq.com/cgi-bin/bar/upload/base64image");
      a("type", "2");
      if (this.f == 2) {
        a("tojpg", "0");
      }
      a("platform", "android");
      a("version", "5.6.0.438");
      b("base64_code", paramString);
      long l2;
      return localFileUploadRspData;
    }
    catch (MalformedURLException paramJobContext)
    {
      for (;;)
      {
        try
        {
          paramJobContext = a(paramJobContext);
          paramString = QQStoryContext.a();
          paramString.a(true, NetworkUtil.b(paramString.a()), 196610, 100001, this.jdField_a_of_type_Long);
          paramJobContext = new String(paramJobContext);
          SLog.b("Q.qqstory.publish:ImageUploadJobSegment", "get upload respond:" + paramJobContext);
        }
        catch (Exception paramJobContext)
        {
          SLog.b("Q.qqstory.publish:ImageUploadJobSegment", "send data exception", paramJobContext);
          localFileUploadRspData.jdField_a_of_type_Int = 940011;
          localFileUploadRspData.g = ("send data exception:" + paramJobContext.getMessage());
          return localFileUploadRspData;
        }
        try
        {
          paramJobContext = new JSONObject(paramJobContext);
          localFileUploadRspData.jdField_a_of_type_Int = paramJobContext.getInt("retcode");
          localFileUploadRspData.g = paramJobContext.optString("tips");
          paramJobContext = paramJobContext.optJSONObject("result");
          if (paramJobContext != null)
          {
            localFileUploadRspData.h = paramJobContext.optString("url");
            localFileUploadRspData.jdField_b_of_type_Int = paramJobContext.optInt("w");
            localFileUploadRspData.c = paramJobContext.optInt("h");
          }
          l2 = System.currentTimeMillis();
          localFileUploadRspData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          localFileUploadRspData.jdField_b_of_type_Long = (l2 - l1);
          return localFileUploadRspData;
        }
        catch (JSONException paramJobContext)
        {
          SLog.b("Q.qqstory.publish:ImageUploadJobSegment", "decode data exception", paramJobContext);
          localFileUploadRspData.jdField_a_of_type_Int = 940011;
          localFileUploadRspData.g = ("decode data exception:" + paramJobContext.getMessage());
        }
      }
      paramJobContext = paramJobContext;
      SLog.b("Q.qqstory.publish:ImageUploadJobSegment", "upload image", paramJobContext);
      localFileUploadRspData.jdField_a_of_type_Int = 940010;
      localFileUploadRspData.g = paramJobContext.toString();
      return localFileUploadRspData;
    }
  }
  
  private String a(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8");
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaNetHttpURLConnection = ((HttpURLConnection)this.jdField_a_of_type_JavaNetURL.openConnection());
    b();
    this.jdField_a_of_type_JavaNetHttpURLConnection.setDoInput(true);
    this.jdField_a_of_type_JavaNetHttpURLConnection.setDoOutput(true);
    this.jdField_a_of_type_JavaNetHttpURLConnection.setUseCaches(false);
    this.jdField_a_of_type_JavaNetHttpURLConnection.setConnectTimeout(10000);
    this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestMethod("POST");
    this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  }
  
  private void a(DataOutputStream paramDataOutputStream, Map paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      paramDataOutputStream.writeBytes(str1 + "=");
      paramDataOutputStream.writeBytes(str2);
      paramDataOutputStream.writeBytes("&");
    }
  }
  
  private byte[] a(JobContext paramJobContext)
  {
    paramJobContext.publishJobProgress(Integer.valueOf(0));
    a();
    this.jdField_a_of_type_JavaNetHttpURLConnection.connect();
    this.jdField_a_of_type_JavaIoDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaNetHttpURLConnection.getOutputStream());
    a(this.jdField_a_of_type_JavaIoDataOutputStream, this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_Long = a(this.jdField_a_of_type_JavaIoDataOutputStream, this.b);
    InputStream localInputStream = this.jdField_a_of_type_JavaNetHttpURLConnection.getInputStream();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localInputStream.read();
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(i);
    }
    paramJobContext.publishJobProgress(Integer.valueOf(100));
    this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
    return localByteArrayOutputStream.toByteArray();
  }
  
  private byte[] a(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      SLog.d("Q.qqstory.publish:ImageUploadJobSegment", "file not exist %s", new Object[] { paramString });
      throw new IOException("file not exist");
    }
    int i = (int)((File)localObject).length();
    if (i <= 0) {
      throw new IOException("file no length");
    }
    paramString = new FileInputStream(paramString);
    localObject = new byte[i];
    int j = paramString.read((byte[])localObject, 0, localObject.length);
    paramString.close();
    if (j != i)
    {
      SLog.d("Q.qqstory.publish:ImageUploadJobSegment", "file not complete count:%d size:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      throw new IOException("read file fail");
    }
    return Base64.encode((byte[])localObject, 0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaNetHttpURLConnection.setRequestProperty("Cookie", this.d);
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaIoDataOutputStream.writeBytes("--&--\r\n");
    this.jdField_a_of_type_JavaIoDataOutputStream.writeBytes("\r\n");
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    this.d = QQStoryContext.a().b();
    int i = 0;
    FileUploadRspData localFileUploadRspData = a(paramJobContext, paramString);
    String str;
    if (this.f == 2)
    {
      str = "publish_mask";
      label33:
      StoryReportor.b("publish_story", str, 0, localFileUploadRspData.jdField_a_of_type_Int, new String[] { String.valueOf(localFileUploadRspData.jdField_a_of_type_Long), String.valueOf(localFileUploadRspData.jdField_b_of_type_Long), StoryReportor.a(BaseApplication.getContext()) });
      if ((localFileUploadRspData.jdField_a_of_type_Int != 0) && (i < 3)) {
        break label148;
      }
      SLog.d("Q.qqstory.publish:ImageUploadJobSegment", "upload file end %s", new Object[] { localFileUploadRspData });
      SLog.c("Q.qqstory.publish:ImageUploadJobSegment", "upload file finish");
      if (localFileUploadRspData.jdField_a_of_type_Int != 0) {
        break label177;
      }
      MonitorReport.a(2444476);
    }
    for (;;)
    {
      super.notifyResult(localFileUploadRspData);
      return;
      str = "publish_thumbnail";
      break label33;
      label148:
      i += 1;
      SLog.d("Q.qqstory.publish:ImageUploadJobSegment", "upload file retry times %d", new Object[] { Integer.valueOf(i) });
      break;
      label177:
      MonitorReport.a(2444475);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaNetURL = new URL(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.b.put(paramString1, paramString2);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\job\ImageUploadJobSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
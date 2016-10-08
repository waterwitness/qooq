package cooperation.huangye.download;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.dataline.util.HttpUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import ycy;
import ycz;

public class HYDownloadAsyncTask
  extends AsyncTask
{
  private static final int jdField_a_of_type_Int = 1;
  private static final Handler jdField_a_of_type_AndroidOsHandler = new ycz(null);
  private String jdField_a_of_type_JavaLangString = HYDownloadAsyncTask.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private HttpGet a(DownloadParams paramDownloadParams, DownloadResult paramDownloadResult)
  {
    try
    {
      localObject = new HttpGet(paramDownloadParams.jdField_a_of_type_JavaLangString);
      paramDownloadResult = (DownloadResult)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          paramDownloadResult.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        paramDownloadResult = null;
        continue;
        paramDownloadResult.setHeader("Net-type", "gprs");
      }
    }
    if (paramDownloadResult != null) {
      if (NetworkUtil.i(BaseApplication.getContext()))
      {
        paramDownloadResult.setHeader("Net-type", "Wifi");
        if (paramDownloadParams.jdField_a_of_type_JavaUtilHashMap == null) {
          return paramDownloadResult;
        }
        paramDownloadParams = paramDownloadParams.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (paramDownloadParams.hasNext())
        {
          localObject = (Map.Entry)paramDownloadParams.next();
          paramDownloadResult.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return paramDownloadResult;
  }
  
  private boolean a(DownloadResult paramDownloadResult, HttpEntity paramHttpEntity, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    try
    {
      paramHttpEntity = paramHttpEntity.getContent();
      if (paramHttpEntity == null)
      {
        i = 0;
        if (paramHttpEntity == null) {}
      }
    }
    catch (IOException paramHttpEntity)
    {
      try
      {
        for (;;)
        {
          paramHttpEntity.close();
          if (i != paramInt) {
            break;
          }
          bool = true;
          if (!bool) {
            break label235;
          }
          paramDownloadResult.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          paramDownloadResult.jdField_a_of_type_Long = paramInt;
          paramDownloadResult.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          paramDownloadResult.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            paramDownloadResult.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
          }
          paramHttpEntity = null;
        }
        byte[] arrayOfByte2 = new byte['ࠀ'];
        i = 0;
        for (;;)
        {
          try
          {
            j = paramHttpEntity.read(arrayOfByte2);
            if (j > 0) {}
          }
          catch (IOException localIOException)
          {
            paramDownloadResult.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              paramDownloadResult.jdField_a_of_type_JavaLangString = localIOException.toString();
            }
            int j = 0;
            continue;
            if (i + j > paramInt)
            {
              i += j;
              break;
            }
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
            i += j;
          }
        }
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          int i;
          paramHttpEntity.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label235:
          paramDownloadResult.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            paramDownloadResult.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            paramDownloadResult.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    DownloadParams localDownloadParams;
    while (localIterator.hasNext())
    {
      localDownloadParams = (DownloadParams)localIterator.next();
      localDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult = new DownloadResult();
      localDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_a_of_type_Int = -1;
    }
    if (HttpUtil.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = HttpUtil.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localDownloadParams = (DownloadParams)localIterator.next();
        k = m;
        if (localDownloadParams.k != m)
        {
          k = localDownloadParams.k;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localDownloadParams.l != i)
        {
          m = localDownloadParams.l;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localDownloadParams.j;
        if (!isCancelled()) {
          break;
        }
      }
      if ((QLog.isColorLevel()) && (!paramVarArgs.equals(""))) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramVarArgs);
      }
      return Integer.valueOf(j);
    }
    long l1 = System.currentTimeMillis();
    if (isCancelled()) {
      n = i;
    }
    label264:
    do
    {
      j += 1;
      long l2 = System.currentTimeMillis();
      localDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_b_of_type_Long = (l2 - l1);
      localDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult.jdField_b_of_type_Int = (localDownloadParams.j - n);
      paramVarArgs = paramVarArgs + localDownloadParams.toString() + ", ";
      b(localDownloadParams);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new ycy(this, new DownloadParams[] { localDownloadParams })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localDownloadParams));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = NetworkUtil.h(BaseApplication.getContext());
          if (!bool) {
            break label445;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        i = n;
      }
      n = i - 1;
      if (i <= 0) {
        break label264;
      }
      break;
      label445:
      n -= 1;
    }
  }
  
  public void a(DownloadParams paramDownloadParams) {}
  
  protected void a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null)
    {
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  protected boolean a(HttpClient paramHttpClient, DownloadParams paramDownloadParams)
  {
    DownloadResult localDownloadResult = paramDownloadParams.jdField_a_of_type_CooperationHuangyeDownloadDownloadResult;
    localDownloadResult.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(paramDownloadParams, localDownloadResult);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localDownloadResult.jdField_a_of_type_Boolean;
      paramDownloadParams = null;
      try
      {
        paramHttpClient = paramHttpClient.execute(localHttpGet);
        if (paramHttpClient == null) {
          return false;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramHttpClient = paramDownloadParams;
          if (localIOException != null)
          {
            localDownloadResult.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = paramDownloadParams;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = paramDownloadParams;
          if (localException != null)
          {
            localDownloadResult.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = paramDownloadParams;
          }
        }
        paramDownloadParams = paramHttpClient.getEntity();
        if (paramDownloadParams == null)
        {
          localDownloadResult.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)paramDownloadParams.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localDownloadResult.jdField_a_of_type_Int = 2;
              localDownloadResult.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label186:
              if (localDownloadResult.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            paramDownloadParams.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localDownloadResult.jdField_a_of_type_Boolean = a(localDownloadResult, paramDownloadParams, j);
            break label186;
            localDownloadResult.jdField_a_of_type_Int = 2;
            localDownloadResult.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label186;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(DownloadParams paramDownloadParams) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\huangye\download\HYDownloadAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
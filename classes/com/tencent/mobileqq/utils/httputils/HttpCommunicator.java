package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;
import wdw;
import wdx;

public class HttpCommunicator
  implements SSCMTimer.SSCMTimerObserver
{
  public static final int a = 5;
  private static long jdField_a_of_type_Long = 0L;
  public static final boolean a = true;
  public static final int b = 500;
  private static long jdField_b_of_type_Long = 1L;
  private static final String jdField_b_of_type_JavaLangString = "Q.richmedia.HttpCommunicator";
  public static final int c = 5;
  private static final String jdField_c_of_type_JavaLangString = "content-length zero";
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  public static final int i = 5;
  public static final int j = 6;
  private HttpCommunicator.PriorityQueue jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue = new HttpCommunicator.PriorityQueue();
  private IHttpCommunicatorFlowCount jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount;
  private Object jdField_a_of_type_JavaLangObject = new ReentrantLock();
  String jdField_a_of_type_JavaLangString = null;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private wdx[] jdField_a_of_type_ArrayOfWdx;
  boolean jdField_b_of_type_Boolean = true;
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile boolean d;
  private boolean e;
  private int k;
  private final int l = 4;
  private final int m;
  private int n;
  private int o;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HttpCommunicator(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount = paramIHttpCommunicatorFlowCount;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.m = paramInt;
    this.n = 4;
    this.o = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  private HttpURLConnection a(HttpMsg paramHttpMsg)
  {
    Object localObject1 = paramHttpMsg.a();
    String str1 = (String)paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.remove("mType");
    String str2;
    int i6;
    int i3;
    int i1;
    label46:
    Object localObject2;
    int i2;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i6 = android.net.Proxy.getDefaultPort();
      i3 = 0;
      i1 = 0;
      if ((i1 != 0) || (i3 >= 2)) {
        break label939;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label947;
      }
      i2 = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = PkgTools.f((String)localObject1);
      paramHttpMsg.jdField_g_of_type_Boolean = PkgTools.d.equals(str3);
      if (!str3.equals(this.jdField_a_of_type_JavaLangString))
      {
        if ((i2 == 1) || (str3.equals(PkgTools.d))) {
          this.jdField_b_of_type_Boolean = false;
        }
      }
      else
      {
        label145:
        if ((i2 == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.jdField_b_of_type_Boolean = true;
        }
        if ((str2 == null) || (i6 <= 0)) {
          break label941;
        }
      }
      label280:
      label939:
      label941:
      for (int i4 = 1;; i4 = 0)
      {
        int i7;
        Object localObject3;
        int i5;
        if ((!this.jdField_b_of_type_Boolean) && (i4 != 0)) {
          if ((str3.equals(PkgTools.d)) || (str3.equals(PkgTools.f)) || (str3.equals(PkgTools.h))) {
            if (!paramHttpMsg.jdField_h_of_type_Boolean) {
              switch (paramHttpMsg.j)
              {
              default: 
                localObject1 = PkgTools.b(str1, str2, i6);
                i1 = 1;
                paramHttpMsg.jdField_f_of_type_Int = i2;
                i7 = NetworkCenter.a().a();
                if (paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam == null)
                {
                  localObject3 = RichMediaStrategy.a(i7);
                  i5 = ((RichMediaStrategy.NetPolicy)localObject3).d();
                  if ("POST".equals(paramHttpMsg.e())) {
                    i2 = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(i5);
          ((HttpURLConnection)localObject1).setReadTimeout(i2);
          a(paramHttpMsg, "gettingConn", "getConnection type:" + i7 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i6 + " last apnType:" + this.jdField_a_of_type_JavaLangString + " forceDirect:" + this.jdField_b_of_type_Boolean + ",connectTimeOut:" + i5 + ",readTimeout:" + i2);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = paramHttpMsg.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.jdField_b_of_type_Boolean = true;
          break label145;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i1 = 0;
          break label280;
          localObject1 = PkgTools.a(str1, str2, i6);
          i1 = 1;
          break label280;
          localObject1 = PkgTools.b(str1, str2, i6);
          i1 = 1;
          break label280;
          if (str3.equals(PkgTools.b))
          {
            localObject1 = PkgTools.a(str1, str2, i6);
            i1 = 1;
            break label280;
          }
          localObject1 = PkgTools.a(str1, str2, i6);
          i1 = 1;
          break label280;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i1 = 0;
          break label280;
          i2 = ((RichMediaStrategy.NetPolicy)localObject3).e();
          continue;
          i5 = paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.b(i7);
          i2 = paramHttpMsg.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam.a(i7);
        }
        if (paramHttpMsg.e().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (paramHttpMsg.b() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramHttpMsg.b().length);
          }
        }
        paramHttpMsg.ak = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i1 = 1;
        }
        catch (Exception localException)
        {
          while (i4 != 0) {
            if ((i1 != 0) && (i4 != 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = true;
            }
            else if ((i4 != 0) && (i1 == 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (i4 == 0) {
              break;
            }
            if ((i1 != 0) && (i4 != 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = true;
            }
            else if ((i4 != 0) && (i1 == 0))
            {
              i1 = 0;
              this.jdField_b_of_type_Boolean = false;
            }
            else
            {
              i1 = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.jdField_a_of_type_JavaLangString = str3;
        i3 += 1;
        break label46;
        return (HttpURLConnection)localObject1;
      }
      label947:
      i2 = -1;
    }
  }
  
  private void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
      }
      paramHttpMsg1.a().a(paramHttpMsg1, paramHttpMsg2, paramInt);
    }
  }
  
  public static long b()
  {
    return jdField_b_of_type_Long;
  }
  
  public int a()
  {
    return this.m;
  }
  
  int a(int paramInt)
  {
    switch (paramInt % 5)
    {
    case 0: 
    default: 
      return 404;
    case 1: 
      return 416;
    case 2: 
      return 302;
    case 3: 
      return 501;
    }
    return 400;
  }
  
  public int a(HttpMsg paramHttpMsg)
  {
    int i1 = -1;
    int i3 = this.m;
    int i2 = 1;
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
      {
        paramHttpMsg.a(9366, -1, "close");
        paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        i3 = i1;
        return i3;
      }
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i3)
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          paramHttpMsg.jdField_g_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          i3 = i1;
          if (i2 == 0) {
            break;
          }
          a("sendMsg");
          return i1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((paramHttpMsg != null) && (paramHttpMsg.a() != null))
        {
          paramHttpMsg.a(9367, -1, "queen full");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
        }
      }
      i2 = 0;
    }
  }
  
  Exception a(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return new Exception("inject Exception");
    case 0: 
      return new SocketTimeoutException("inject sockettimeout");
    case 1: 
      return new PortUnreachableException("inject PortUnreachableException");
    case 2: 
      return new ConnectException("inject ConnectException");
    case 3: 
      return new NoRouteToHostException("inject NoRouteToHostException");
    case 4: 
      return new IllegalArgumentException("inject IllegalArgumentException");
    case 5: 
      return new IllegalStateException("inject IllegalStateException");
    case 6: 
      return new IOException("inject IOException");
    case 7: 
      return new IOException("preempted by higher msg");
    case 8: 
      return new IOException("HttpCommunicator closed or msg caceled!");
    }
    return new IOException("content-length zero");
  }
  
  public void a()
  {
    int i1 = 0;
    if ((this.d) || (this.jdField_c_of_type_Boolean)) {
      throw new IllegalStateException("HttpCommunicator already in using or disposed!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Boolean = true;
      this.o = 0;
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.b();
      this.jdField_a_of_type_ArrayOfWdx = new wdx[4];
      while (i1 < 4)
      {
        HandlerThread localHandlerThread = new HandlerThread("httpcommunicator_norm_" + i1, 5);
        localHandlerThread.start();
        this.jdField_a_of_type_ArrayOfWdx[i1] = new wdx(this, localHandlerThread.getLooper());
        this.jdField_a_of_type_ArrayOfWdx[i1].jdField_a_of_type_Int = i1;
        i1 += 1;
      }
      i1 = NetworkCenter.a().a();
      if ((i1 == 2) || (i1 == 3))
      {
        this.n = 3;
        return;
      }
      this.n = 4;
    }
  }
  
  public void a(int paramInt)
  {
    localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.n = 4;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.n);
        }
        a("netChange");
        return;
      }
      finally {}
      this.n = 3;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  void a(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpURLConnection == null) || (paramHttpMsg == null)) {
      return;
    }
    paramHttpMsg.c(paramInt);
    paramHttpMsg.b("Content-Type", paramHttpURLConnection.getContentType());
    paramHttpMsg.al = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramHttpMsg.b("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramHttpMsg.b("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramHttpMsg.b("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramHttpMsg.b("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramHttpMsg.b("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramHttpMsg.b("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      paramHttpMsg.b("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramHttpMsg.b("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramHttpMsg.b("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramHttpMsg.b("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramHttpMsg.jdField_a_of_type_Long = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i1;
    if (str != null) {
      i1 = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramHttpMsg.jdField_a_of_type_Long = Long.valueOf(str.substring(i1 + 1)).longValue();
        paramHttpMsg.jdField_b_of_type_Long = paramHttpURLConnection.getContentLength();
        a(paramHttpMsg, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramHttpMsg.jdField_a_of_type_Long + ",totalBlockLen:" + paramHttpMsg.jdField_b_of_type_Long);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramHttpMsg.jdField_a_of_type_Long = paramHttpURLConnection.getContentLength();
      paramHttpMsg.jdField_b_of_type_Long = paramHttpMsg.jdField_a_of_type_Long;
    }
  }
  
  void a(long paramLong, int paramInt)
  {
    int i1 = 4;
    int i2 = (int)(2L * paramLong / 90000L);
    if (i2 > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i1 + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i1 = i2;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
      paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    RichMediaUtil.a(RichMediaUtil.b(paramHttpMsg.jdField_e_of_type_Int), paramHttpMsg.e().equals("POST"), RichMediaUtil.c(paramHttpMsg.jdField_d_of_type_Int), paramHttpMsg.ai, paramString1, paramString2);
  }
  
  public void a(HttpMsg paramHttpMsg, wdx paramwdx)
  {
    int i1 = 0;
    if ((paramHttpMsg != null) && (paramwdx != null)) {
      try
      {
        a(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.b() == null) {}
        for (;;)
        {
          a(90000L, i1);
          a(paramwdx);
          paramHttpMsg.a(9014, 0, "response timeout");
          paramHttpMsg.a().b(paramHttpMsg, paramHttpMsg);
          return;
          i1 = paramHttpMsg.b().length;
        }
        return;
      }
      catch (Exception paramHttpMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg, wdx paramwdx, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 399	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 4
    //   18: aconst_null
    //   19: astore 11
    //   21: aconst_null
    //   22: astore 9
    //   24: iconst_m1
    //   25: istore 14
    //   27: lconst_0
    //   28: lstore 21
    //   30: lconst_0
    //   31: lstore 23
    //   33: iconst_0
    //   34: istore 31
    //   36: iconst_0
    //   37: istore 18
    //   39: iconst_0
    //   40: istore 17
    //   42: aload_0
    //   43: aload_1
    //   44: aconst_null
    //   45: iconst_1
    //   46: iload_3
    //   47: invokespecial 674	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   50: iconst_0
    //   51: istore 16
    //   53: iconst_0
    //   54: istore 31
    //   56: aconst_null
    //   57: astore 6
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 676
    //   64: ldc_w 631
    //   67: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: aload_2
    //   72: aload_1
    //   73: invokevirtual 679	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lwdx;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   76: aload_0
    //   77: aload_1
    //   78: invokespecial 681	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   81: astore 7
    //   83: aload 7
    //   85: astore 5
    //   87: aload_1
    //   88: aload 5
    //   90: putfield 684	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaNetHttpURLConnection	Ljava/net/HttpURLConnection;
    //   93: aload_1
    //   94: invokestatic 429	android/os/SystemClock:uptimeMillis	()J
    //   97: putfield 686	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   100: aload_0
    //   101: aload_1
    //   102: ldc_w 688
    //   105: ldc_w 631
    //   108: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   111: iconst_1
    //   112: istore 31
    //   114: invokestatic 691	java/lang/System:currentTimeMillis	()J
    //   117: pop2
    //   118: aload_1
    //   119: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   122: ldc -11
    //   124: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifeq +4732 -> 4859
    //   130: new 693	wdv
    //   133: dup
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial 696	wdv:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lwdx;)V
    //   140: astore 7
    //   142: aload_0
    //   143: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload 7
    //   148: ldc2_w 610
    //   151: invokevirtual 702	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 367	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()[B
    //   159: astore 13
    //   161: aload 5
    //   163: invokevirtual 706	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   166: astore 6
    //   168: aload_0
    //   169: aload_1
    //   170: ldc_w 708
    //   173: new 261	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 710
    //   183: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 13
    //   188: arraylength
    //   189: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   192: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   198: iconst_0
    //   199: istore 15
    //   201: iload 15
    //   203: aload 13
    //   205: arraylength
    //   206: if_icmpge +46 -> 252
    //   209: aload_0
    //   210: aload_2
    //   211: aload_1
    //   212: invokevirtual 679	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lwdx;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   215: aload 6
    //   217: aload 13
    //   219: iload 15
    //   221: sipush 10240
    //   224: aload 13
    //   226: arraylength
    //   227: iload 15
    //   229: isub
    //   230: invokestatic 716	java/lang/Math:min	(II)I
    //   233: invokevirtual 722	java/io/OutputStream:write	([BII)V
    //   236: aload 6
    //   238: invokevirtual 725	java/io/OutputStream:flush	()V
    //   241: iload 15
    //   243: sipush 10240
    //   246: iadd
    //   247: istore 15
    //   249: goto -48 -> 201
    //   252: aload_2
    //   253: ifnull +13 -> 266
    //   256: aload_2
    //   257: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   260: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   263: ifne +14 -> 277
    //   266: aload_0
    //   267: aload_1
    //   268: ldc_w 732
    //   271: ldc_w 631
    //   274: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload 5
    //   279: invokevirtual 736	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   282: invokevirtual 737	java/net/URL:toString	()Ljava/lang/String;
    //   285: invokevirtual 740	java/lang/String:length	()I
    //   288: i2l
    //   289: lstore 25
    //   291: aload 13
    //   293: arraylength
    //   294: istore 15
    //   296: lload 21
    //   298: iload 15
    //   300: i2l
    //   301: ldc2_w 741
    //   304: lload 25
    //   306: ladd
    //   307: ladd
    //   308: ladd
    //   309: lstore 21
    //   311: aload_0
    //   312: aload_2
    //   313: aload_1
    //   314: invokevirtual 679	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lwdx;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   317: aload 5
    //   319: invokevirtual 745	java/net/HttpURLConnection:getResponseCode	()I
    //   322: istore 15
    //   324: aload_0
    //   325: iload 15
    //   327: aload 5
    //   329: aload_1
    //   330: invokevirtual 747	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   333: aload_2
    //   334: ifnull +231 -> 565
    //   337: aload_2
    //   338: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   341: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   344: istore 32
    //   346: iload 32
    //   348: ifeq +217 -> 565
    //   351: iload 15
    //   353: sipush 200
    //   356: if_icmpeq +11 -> 367
    //   359: iload 15
    //   361: sipush 206
    //   364: if_icmpne +31 -> 395
    //   367: aload_0
    //   368: aload_1
    //   369: ldc_w 749
    //   372: new 261	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 751
    //   382: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: iconst_0
    //   386: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_2
    //   396: ifnull +13 -> 409
    //   399: aload_2
    //   400: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   403: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   406: ifne +47 -> 453
    //   409: aload_0
    //   410: aload_1
    //   411: ldc_w 753
    //   414: new 261	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 755
    //   424: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   431: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 759
    //   437: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   444: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   453: aload_0
    //   454: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   457: ifnull +17 -> 474
    //   460: aload 7
    //   462: ifnull +12 -> 474
    //   465: aload_0
    //   466: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   469: aload 7
    //   471: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   474: lload 21
    //   476: lconst_0
    //   477: ladd
    //   478: lstore 21
    //   480: lload 21
    //   482: lconst_0
    //   483: lcmp
    //   484: ifeq +25 -> 509
    //   487: aload_1
    //   488: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   491: ldc -11
    //   493: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +58 -> 554
    //   499: iconst_1
    //   500: istore_3
    //   501: aload_0
    //   502: aload_1
    //   503: iload_3
    //   504: lload 21
    //   506: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   509: iconst_0
    //   510: ifeq +11 -> 521
    //   513: new 770	java/lang/NullPointerException
    //   516: dup
    //   517: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   520: athrow
    //   521: iconst_0
    //   522: ifeq +11 -> 533
    //   525: new 770	java/lang/NullPointerException
    //   528: dup
    //   529: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   532: athrow
    //   533: aload 6
    //   535: ifnull +8 -> 543
    //   538: aload 6
    //   540: invokevirtual 773	java/io/OutputStream:close	()V
    //   543: aload 5
    //   545: ifnull +8 -> 553
    //   548: aload 5
    //   550: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   553: return
    //   554: iconst_0
    //   555: istore_3
    //   556: goto -55 -> 501
    //   559: astore_1
    //   560: aload_1
    //   561: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   564: return
    //   565: aload_0
    //   566: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   569: ifnull +17 -> 586
    //   572: aload 7
    //   574: ifnull +12 -> 586
    //   577: aload_0
    //   578: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   581: aload 7
    //   583: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   586: aload_0
    //   587: aload_1
    //   588: ldc_w 778
    //   591: new 261	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   598: ldc_w 780
    //   601: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: iload 15
    //   606: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   615: iload 15
    //   617: sipush 302
    //   620: if_icmpeq +11 -> 631
    //   623: iload 15
    //   625: sipush 301
    //   628: if_icmpne +1138 -> 1766
    //   631: iload 16
    //   633: iconst_5
    //   634: if_icmpge +843 -> 1477
    //   637: aload_0
    //   638: aload_1
    //   639: ldc_w 782
    //   642: new 261	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 784
    //   652: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: getfield 378	com/tencent/mobileqq/utils/httputils/HttpMsg:ak	Ljava/lang/String;
    //   659: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc_w 786
    //   665: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_1
    //   669: getfield 544	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   672: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload 5
    //   683: ldc_w 788
    //   686: invokevirtual 549	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   689: astore 13
    //   691: aload 13
    //   693: ifnull +312 -> 1005
    //   696: aload 6
    //   698: ifnull +8 -> 706
    //   701: aload 6
    //   703: invokevirtual 773	java/io/OutputStream:close	()V
    //   706: aload 5
    //   708: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   711: aload_1
    //   712: invokevirtual 790	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Z
    //   715: ifne +226 -> 941
    //   718: aload 12
    //   720: aload 13
    //   722: invokeinterface 791 2 0
    //   727: iload 15
    //   729: sipush 200
    //   732: if_icmpeq +11 -> 743
    //   735: iload 15
    //   737: sipush 206
    //   740: if_icmpne +31 -> 771
    //   743: aload_0
    //   744: aload_1
    //   745: ldc_w 749
    //   748: new 261	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 751
    //   758: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: iconst_0
    //   762: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload_2
    //   772: ifnull +13 -> 785
    //   775: aload_2
    //   776: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   779: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   782: ifne +47 -> 829
    //   785: aload_0
    //   786: aload_1
    //   787: ldc_w 753
    //   790: new 261	java/lang/StringBuilder
    //   793: dup
    //   794: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   797: ldc_w 755
    //   800: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: aload_1
    //   804: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   807: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: ldc_w 759
    //   813: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload_1
    //   817: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   820: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   829: aload_0
    //   830: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   833: ifnull +17 -> 850
    //   836: aload 7
    //   838: ifnull +12 -> 850
    //   841: aload_0
    //   842: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   845: aload 7
    //   847: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   850: lload 21
    //   852: lconst_0
    //   853: ladd
    //   854: lstore 21
    //   856: lload 21
    //   858: lconst_0
    //   859: lcmp
    //   860: ifeq +25 -> 885
    //   863: aload_1
    //   864: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   867: ldc -11
    //   869: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   872: ifeq +64 -> 936
    //   875: iconst_1
    //   876: istore_3
    //   877: aload_0
    //   878: aload_1
    //   879: iload_3
    //   880: lload 21
    //   882: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   885: iconst_0
    //   886: ifeq +11 -> 897
    //   889: new 770	java/lang/NullPointerException
    //   892: dup
    //   893: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   896: athrow
    //   897: iconst_0
    //   898: ifeq +11 -> 909
    //   901: new 770	java/lang/NullPointerException
    //   904: dup
    //   905: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   908: athrow
    //   909: aload 6
    //   911: ifnull +8 -> 919
    //   914: aload 6
    //   916: invokevirtual 773	java/io/OutputStream:close	()V
    //   919: aload 5
    //   921: ifnull -368 -> 553
    //   924: aload 5
    //   926: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   929: return
    //   930: astore_1
    //   931: aload_1
    //   932: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   935: return
    //   936: iconst_0
    //   937: istore_3
    //   938: goto -61 -> 877
    //   941: aload_1
    //   942: getfield 792	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_c_of_type_Boolean	Z
    //   945: ifeq +12 -> 957
    //   948: aload 12
    //   950: aload 13
    //   952: invokeinterface 791 2 0
    //   957: aload_1
    //   958: ldc_w 794
    //   961: aload_1
    //   962: invokevirtual 141	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Ljava/lang/String;
    //   965: invokevirtual 796	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   968: aload_1
    //   969: aload 13
    //   971: invokevirtual 797	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)V
    //   974: aload_1
    //   975: ldc_w 799
    //   978: invokevirtual 801	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   981: iload 16
    //   983: iconst_1
    //   984: iadd
    //   985: istore 16
    //   987: iload 15
    //   989: istore 14
    //   991: aload 6
    //   993: astore 4
    //   995: iconst_1
    //   996: istore 31
    //   998: aload 7
    //   1000: astore 6
    //   1002: goto -943 -> 59
    //   1005: new 478	java/io/IOException
    //   1008: dup
    //   1009: ldc_w 803
    //   1012: invokespecial 481	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1015: athrow
    //   1016: astore 10
    //   1018: aload 7
    //   1020: astore 9
    //   1022: iconst_0
    //   1023: istore 16
    //   1025: iconst_1
    //   1026: istore_3
    //   1027: lconst_0
    //   1028: lstore 25
    //   1030: iload 15
    //   1032: istore 14
    //   1034: aload 5
    //   1036: astore 4
    //   1038: aconst_null
    //   1039: astore 5
    //   1041: aconst_null
    //   1042: astore 8
    //   1044: aload 6
    //   1046: astore 7
    //   1048: aload 5
    //   1050: astore 6
    //   1052: lload 21
    //   1054: lstore 23
    //   1056: lload 25
    //   1058: lstore 21
    //   1060: iload 16
    //   1062: istore 15
    //   1064: aload 9
    //   1066: astore 5
    //   1068: aload 10
    //   1070: astore 9
    //   1072: iconst_1
    //   1073: istore 16
    //   1075: aload 9
    //   1077: instanceof 478
    //   1080: istore 31
    //   1082: iload 31
    //   1084: ifeq +62 -> 1146
    //   1087: aload 4
    //   1089: ifnull +57 -> 1146
    //   1092: aconst_null
    //   1093: astore 11
    //   1095: aload 4
    //   1097: invokevirtual 807	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1100: astore 10
    //   1102: aload 10
    //   1104: astore 11
    //   1106: sipush 10240
    //   1109: newarray <illegal type>
    //   1111: astore 13
    //   1113: aload 10
    //   1115: ifnull +21 -> 1136
    //   1118: aload 10
    //   1120: astore 11
    //   1122: aload 10
    //   1124: aload 13
    //   1126: invokevirtual 813	java/io/InputStream:read	([B)I
    //   1129: istore 17
    //   1131: iload 17
    //   1133: ifgt -15 -> 1118
    //   1136: aload 10
    //   1138: ifnull +8 -> 1146
    //   1141: aload 10
    //   1143: invokevirtual 814	java/io/InputStream:close	()V
    //   1146: aload_0
    //   1147: iload_3
    //   1148: iload 14
    //   1150: aload 4
    //   1152: aload_1
    //   1153: aload 9
    //   1155: invokevirtual 817	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1158: iload_3
    //   1159: ifeq +48 -> 1207
    //   1162: iload 14
    //   1164: sipush 200
    //   1167: if_icmpeq +11 -> 1178
    //   1170: iload 14
    //   1172: sipush 206
    //   1175: if_icmpne +32 -> 1207
    //   1178: aload_0
    //   1179: aload_1
    //   1180: ldc_w 749
    //   1183: new 261	java/lang/StringBuilder
    //   1186: dup
    //   1187: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1190: ldc_w 751
    //   1193: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: iload 15
    //   1198: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1207: aload_2
    //   1208: ifnull +13 -> 1221
    //   1211: aload_2
    //   1212: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1215: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1218: ifne +101 -> 1319
    //   1221: aload_0
    //   1222: aload_1
    //   1223: ldc_w 753
    //   1226: new 261	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1233: ldc_w 755
    //   1236: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: aload_1
    //   1240: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1243: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: ldc_w 759
    //   1249: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: aload_1
    //   1253: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1256: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1262: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1265: aload_1
    //   1266: getfield 819	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Int	I
    //   1269: sipush 56009
    //   1272: if_icmpne +47 -> 1319
    //   1275: aload_0
    //   1276: aload_1
    //   1277: ldc_w 821
    //   1280: new 261	java/lang/StringBuilder
    //   1283: dup
    //   1284: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1287: ldc_w 784
    //   1290: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: aload_1
    //   1294: getfield 378	com/tencent/mobileqq/utils/httputils/HttpMsg:ak	Ljava/lang/String;
    //   1297: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: ldc_w 786
    //   1303: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: aload_1
    //   1307: getfield 544	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   1310: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1319: aload_0
    //   1320: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1323: ifnull +17 -> 1340
    //   1326: aload 5
    //   1328: ifnull +12 -> 1340
    //   1331: aload_0
    //   1332: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1335: aload 5
    //   1337: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1340: lload 23
    //   1342: lload 21
    //   1344: ladd
    //   1345: lstore 21
    //   1347: lload 21
    //   1349: lconst_0
    //   1350: lcmp
    //   1351: ifeq +25 -> 1376
    //   1354: aload_1
    //   1355: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1358: ldc -11
    //   1360: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1363: ifeq +2533 -> 3896
    //   1366: iconst_1
    //   1367: istore_3
    //   1368: aload_0
    //   1369: aload_1
    //   1370: iload_3
    //   1371: lload 21
    //   1373: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1376: aload 6
    //   1378: ifnull +8 -> 1386
    //   1381: aload 6
    //   1383: invokevirtual 824	java/io/ByteArrayOutputStream:close	()V
    //   1386: aload 8
    //   1388: ifnull +8 -> 1396
    //   1391: aload 8
    //   1393: invokevirtual 814	java/io/InputStream:close	()V
    //   1396: aload 7
    //   1398: ifnull +8 -> 1406
    //   1401: aload 7
    //   1403: invokevirtual 773	java/io/OutputStream:close	()V
    //   1406: iload 16
    //   1408: istore 14
    //   1410: aload 4
    //   1412: ifnull +12 -> 1424
    //   1415: aload 4
    //   1417: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   1420: iload 16
    //   1422: istore 14
    //   1424: aload_2
    //   1425: ifnull +13 -> 1438
    //   1428: aload_2
    //   1429: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1432: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1435: ifne -882 -> 553
    //   1438: aload_1
    //   1439: getfield 638	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1442: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1445: ifne -892 -> 553
    //   1448: iload 14
    //   1450: ifeq +2478 -> 3928
    //   1453: aload 12
    //   1455: aload_1
    //   1456: aload_1
    //   1457: invokeinterface 419 3 0
    //   1462: return
    //   1463: astore_2
    //   1464: aload_0
    //   1465: aload_1
    //   1466: ldc_w 826
    //   1469: aload_2
    //   1470: invokestatic 832	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1473: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1476: return
    //   1477: new 134	java/lang/Exception
    //   1480: dup
    //   1481: ldc_w 834
    //   1484: invokespecial 446	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1487: athrow
    //   1488: astore 4
    //   1490: iconst_0
    //   1491: istore 14
    //   1493: iload 31
    //   1495: istore_3
    //   1496: iload 17
    //   1498: istore 16
    //   1500: iload_3
    //   1501: ifeq +48 -> 1549
    //   1504: iload 15
    //   1506: sipush 200
    //   1509: if_icmpeq +11 -> 1520
    //   1512: iload 15
    //   1514: sipush 206
    //   1517: if_icmpne +32 -> 1549
    //   1520: aload_0
    //   1521: aload_1
    //   1522: ldc_w 749
    //   1525: new 261	java/lang/StringBuilder
    //   1528: dup
    //   1529: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1532: ldc_w 751
    //   1535: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: iload 16
    //   1540: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1546: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1549: aload_2
    //   1550: ifnull +13 -> 1563
    //   1553: aload_2
    //   1554: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1557: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1560: ifne +106 -> 1666
    //   1563: aload_0
    //   1564: aload_1
    //   1565: ldc_w 753
    //   1568: new 261	java/lang/StringBuilder
    //   1571: dup
    //   1572: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1575: ldc_w 755
    //   1578: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1581: aload_1
    //   1582: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1585: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 759
    //   1591: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload_1
    //   1595: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1598: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1604: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1607: iload 14
    //   1609: ifeq +57 -> 1666
    //   1612: aload_1
    //   1613: getfield 819	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Int	I
    //   1616: sipush 56009
    //   1619: if_icmpne +47 -> 1666
    //   1622: aload_0
    //   1623: aload_1
    //   1624: ldc_w 821
    //   1627: new 261	java/lang/StringBuilder
    //   1630: dup
    //   1631: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1634: ldc_w 784
    //   1637: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1640: aload_1
    //   1641: getfield 378	com/tencent/mobileqq/utils/httputils/HttpMsg:ak	Ljava/lang/String;
    //   1644: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1647: ldc_w 786
    //   1650: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: aload_1
    //   1654: getfield 544	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   1657: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1663: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1666: aload_0
    //   1667: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1670: ifnull +17 -> 1687
    //   1673: aload 7
    //   1675: ifnull +12 -> 1687
    //   1678: aload_0
    //   1679: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1682: aload 7
    //   1684: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1687: lload 21
    //   1689: lload 23
    //   1691: ladd
    //   1692: lstore 21
    //   1694: lload 21
    //   1696: lconst_0
    //   1697: lcmp
    //   1698: ifeq +25 -> 1723
    //   1701: aload_1
    //   1702: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   1705: ldc -11
    //   1707: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1710: ifeq +2205 -> 3915
    //   1713: iconst_1
    //   1714: istore_3
    //   1715: aload_0
    //   1716: aload_1
    //   1717: iload_3
    //   1718: lload 21
    //   1720: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1723: aload 9
    //   1725: ifnull +8 -> 1733
    //   1728: aload 9
    //   1730: invokevirtual 824	java/io/ByteArrayOutputStream:close	()V
    //   1733: aload 8
    //   1735: ifnull +8 -> 1743
    //   1738: aload 8
    //   1740: invokevirtual 814	java/io/InputStream:close	()V
    //   1743: aload 6
    //   1745: ifnull +8 -> 1753
    //   1748: aload 6
    //   1750: invokevirtual 773	java/io/OutputStream:close	()V
    //   1753: aload 5
    //   1755: ifnull +8 -> 1763
    //   1758: aload 5
    //   1760: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   1763: aload 4
    //   1765: athrow
    //   1766: aload_0
    //   1767: aload_1
    //   1768: aconst_null
    //   1769: iconst_2
    //   1770: iload_3
    //   1771: invokespecial 674	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;IZ)V
    //   1774: iload 15
    //   1776: sipush 200
    //   1779: if_icmpeq +11 -> 1790
    //   1782: iload 15
    //   1784: sipush 206
    //   1787: if_icmpne +1650 -> 3437
    //   1790: aload 5
    //   1792: invokevirtual 536	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1795: astore 4
    //   1797: aload 4
    //   1799: ifnonnull +280 -> 2079
    //   1802: ldc_w 631
    //   1805: astore 4
    //   1807: iload_3
    //   1808: ifne +281 -> 2089
    //   1811: aload_1
    //   1812: getfield 835	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_b_of_type_Boolean	Z
    //   1815: ifeq +274 -> 2089
    //   1818: aload 4
    //   1820: ldc_w 837
    //   1823: invokevirtual 840	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1826: iconst_m1
    //   1827: if_icmpne +15 -> 1842
    //   1830: aload 4
    //   1832: ldc_w 842
    //   1835: invokevirtual 840	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1838: iconst_m1
    //   1839: if_icmpeq +250 -> 2089
    //   1842: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1845: ifeq +18 -> 1863
    //   1848: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1851: ifeq +12 -> 1863
    //   1854: ldc 19
    //   1856: iconst_2
    //   1857: ldc_w 844
    //   1860: invokestatic 411	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1863: aload_0
    //   1864: aload_1
    //   1865: aload_2
    //   1866: iconst_1
    //   1867: invokevirtual 846	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lwdx;Z)V
    //   1870: iload 15
    //   1872: sipush 200
    //   1875: if_icmpeq +11 -> 1886
    //   1878: iload 15
    //   1880: sipush 206
    //   1883: if_icmpne +31 -> 1914
    //   1886: aload_0
    //   1887: aload_1
    //   1888: ldc_w 749
    //   1891: new 261	java/lang/StringBuilder
    //   1894: dup
    //   1895: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1898: ldc_w 751
    //   1901: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1904: iconst_0
    //   1905: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1908: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1914: aload_2
    //   1915: ifnull +13 -> 1928
    //   1918: aload_2
    //   1919: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1922: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1925: ifne +47 -> 1972
    //   1928: aload_0
    //   1929: aload_1
    //   1930: ldc_w 753
    //   1933: new 261	java/lang/StringBuilder
    //   1936: dup
    //   1937: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   1940: ldc_w 755
    //   1943: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: aload_1
    //   1947: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   1950: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: ldc_w 759
    //   1956: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: aload_1
    //   1960: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   1963: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1972: aload_0
    //   1973: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1976: ifnull +17 -> 1993
    //   1979: aload 7
    //   1981: ifnull +12 -> 1993
    //   1984: aload_0
    //   1985: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   1988: aload 7
    //   1990: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1993: lload 21
    //   1995: lconst_0
    //   1996: ladd
    //   1997: lstore 21
    //   1999: lload 21
    //   2001: lconst_0
    //   2002: lcmp
    //   2003: ifeq +25 -> 2028
    //   2006: aload_1
    //   2007: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2010: ldc -11
    //   2012: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2015: ifeq +2855 -> 4870
    //   2018: iconst_1
    //   2019: istore_3
    //   2020: aload_0
    //   2021: aload_1
    //   2022: iload_3
    //   2023: lload 21
    //   2025: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2028: iconst_0
    //   2029: ifeq +11 -> 2040
    //   2032: new 770	java/lang/NullPointerException
    //   2035: dup
    //   2036: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   2039: athrow
    //   2040: iconst_0
    //   2041: ifeq +11 -> 2052
    //   2044: new 770	java/lang/NullPointerException
    //   2047: dup
    //   2048: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   2051: athrow
    //   2052: aload 6
    //   2054: ifnull +8 -> 2062
    //   2057: aload 6
    //   2059: invokevirtual 773	java/io/OutputStream:close	()V
    //   2062: aload 5
    //   2064: ifnull -1511 -> 553
    //   2067: aload 5
    //   2069: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   2072: return
    //   2073: astore_1
    //   2074: aload_1
    //   2075: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   2078: return
    //   2079: aload 4
    //   2081: invokevirtual 849	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2084: astore 4
    //   2086: goto -279 -> 1807
    //   2089: aload_1
    //   2090: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2093: ifnull +224 -> 2317
    //   2096: aload_1
    //   2097: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2100: arraylength
    //   2101: ifle +216 -> 2317
    //   2104: aload 4
    //   2106: invokevirtual 740	java/lang/String:length	()I
    //   2109: ifle +208 -> 2317
    //   2112: iconst_0
    //   2113: istore 18
    //   2115: aload_1
    //   2116: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2119: arraylength
    //   2120: iconst_1
    //   2121: if_icmpne +100 -> 2221
    //   2124: aload_1
    //   2125: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2128: iconst_0
    //   2129: aaload
    //   2130: ifnull +91 -> 2221
    //   2133: aload_1
    //   2134: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2137: iconst_0
    //   2138: aaload
    //   2139: invokevirtual 849	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2142: ldc_w 854
    //   2145: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2148: ifeq +73 -> 2221
    //   2151: iconst_1
    //   2152: istore 14
    //   2154: iload 14
    //   2156: ifne +161 -> 2317
    //   2159: new 261	java/lang/StringBuilder
    //   2162: dup
    //   2163: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   2166: astore 11
    //   2168: aload_1
    //   2169: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2172: astore 13
    //   2174: aload 13
    //   2176: arraylength
    //   2177: istore 16
    //   2179: iconst_0
    //   2180: istore 14
    //   2182: iload 14
    //   2184: iload 16
    //   2186: if_icmpge +88 -> 2274
    //   2189: aload 13
    //   2191: iload 14
    //   2193: aaload
    //   2194: astore 10
    //   2196: aload 10
    //   2198: ifnull +2677 -> 4875
    //   2201: aload 11
    //   2203: aload 10
    //   2205: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2208: pop
    //   2209: aload 11
    //   2211: ldc_w 856
    //   2214: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: pop
    //   2218: goto +2657 -> 4875
    //   2221: aload_1
    //   2222: getfield 852	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   2225: astore 11
    //   2227: aload 11
    //   2229: arraylength
    //   2230: istore 19
    //   2232: iconst_0
    //   2233: istore 16
    //   2235: iload 18
    //   2237: istore 14
    //   2239: iload 16
    //   2241: iload 19
    //   2243: if_icmpge -89 -> 2154
    //   2246: aload 11
    //   2248: iload 16
    //   2250: aaload
    //   2251: astore 10
    //   2253: aload 10
    //   2255: ifnull +2629 -> 4884
    //   2258: aload 4
    //   2260: aload 10
    //   2262: invokevirtual 860	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2265: ifeq +2619 -> 4884
    //   2268: iconst_1
    //   2269: istore 14
    //   2271: goto -117 -> 2154
    //   2274: new 478	java/io/IOException
    //   2277: dup
    //   2278: new 261	java/lang/StringBuilder
    //   2281: dup
    //   2282: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   2285: ldc_w 862
    //   2288: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: aload 4
    //   2293: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2296: ldc_w 864
    //   2299: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: aload 11
    //   2304: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2307: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2310: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2313: invokespecial 481	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2316: athrow
    //   2317: aload_1
    //   2318: getfield 570	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2321: lconst_0
    //   2322: lcmp
    //   2323: ifne +25 -> 2348
    //   2326: aload_1
    //   2327: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   2330: ldc -11
    //   2332: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2335: ifne +13 -> 2348
    //   2338: new 478	java/io/IOException
    //   2341: dup
    //   2342: ldc 22
    //   2344: invokespecial 481	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2347: athrow
    //   2348: aload_0
    //   2349: aload_1
    //   2350: ldc_w 866
    //   2353: new 261	java/lang/StringBuilder
    //   2356: dup
    //   2357: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   2360: ldc_w 868
    //   2363: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: aload_1
    //   2367: getfield 570	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2370: invokevirtual 601	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2373: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2376: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2379: aload_1
    //   2380: getfield 686	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2383: lconst_0
    //   2384: lcmp
    //   2385: ifeq +15 -> 2400
    //   2388: aload_1
    //   2389: invokestatic 429	android/os/SystemClock:uptimeMillis	()J
    //   2392: aload_1
    //   2393: getfield 686	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_d_of_type_Long	J
    //   2396: lsub
    //   2397: putfield 870	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_e_of_type_Long	J
    //   2400: aload 12
    //   2402: aload_1
    //   2403: aload_1
    //   2404: iconst_3
    //   2405: invokeinterface 404 4 0
    //   2410: istore_3
    //   2411: iload_3
    //   2412: ifeq +2432 -> 4844
    //   2415: lconst_0
    //   2416: ldc2_w 741
    //   2419: ladd
    //   2420: lstore 23
    //   2422: aload 5
    //   2424: invokevirtual 873	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2427: astore 4
    //   2429: invokestatic 879	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2432: astore 10
    //   2434: invokestatic 882	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2437: astore 8
    //   2439: aload_1
    //   2440: getfield 884	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Boolean	Z
    //   2443: ifeq +251 -> 2694
    //   2446: aload_1
    //   2447: invokevirtual 886	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   2450: ifne +244 -> 2694
    //   2453: new 888	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream
    //   2456: dup
    //   2457: aload 8
    //   2459: aload_1
    //   2460: getfield 570	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_a_of_type_Long	J
    //   2463: l2i
    //   2464: invokespecial 891	com/tencent/mobileqq/utils/PoolingByteArrayOutputStream:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2467: astore 8
    //   2469: aload_1
    //   2470: getfield 884	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Boolean	Z
    //   2473: ifeq +286 -> 2759
    //   2476: aload 10
    //   2478: sipush 10240
    //   2481: invokevirtual 895	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2484: astore 9
    //   2486: iconst_0
    //   2487: istore 16
    //   2489: iconst_0
    //   2490: istore 14
    //   2492: iload 14
    //   2494: istore 18
    //   2496: lload 23
    //   2498: lstore 25
    //   2500: iload 14
    //   2502: istore 19
    //   2504: lload 23
    //   2506: lstore 27
    //   2508: aload 4
    //   2510: aload 9
    //   2512: iload 16
    //   2514: aload 9
    //   2516: arraylength
    //   2517: iload 16
    //   2519: isub
    //   2520: invokevirtual 898	java/io/InputStream:read	([BII)I
    //   2523: istore 17
    //   2525: iload 17
    //   2527: ifle +279 -> 2806
    //   2530: iload 14
    //   2532: istore 18
    //   2534: lload 23
    //   2536: lstore 25
    //   2538: iload 14
    //   2540: istore 19
    //   2542: lload 23
    //   2544: lstore 27
    //   2546: aload_0
    //   2547: aload_2
    //   2548: aload_1
    //   2549: invokevirtual 679	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lwdx;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2552: lload 23
    //   2554: iload 17
    //   2556: i2l
    //   2557: ladd
    //   2558: lstore 29
    //   2560: iload 16
    //   2562: iload 17
    //   2564: iadd
    //   2565: istore 20
    //   2567: iload 14
    //   2569: iload 17
    //   2571: iadd
    //   2572: istore 17
    //   2574: iload 17
    //   2576: istore 14
    //   2578: lload 29
    //   2580: lstore 23
    //   2582: iload 20
    //   2584: istore 16
    //   2586: iload 17
    //   2588: istore 18
    //   2590: lload 29
    //   2592: lstore 25
    //   2594: iload 17
    //   2596: istore 19
    //   2598: lload 29
    //   2600: lstore 27
    //   2602: iload 20
    //   2604: aload 9
    //   2606: arraylength
    //   2607: if_icmplt -115 -> 2492
    //   2610: iload 17
    //   2612: istore 18
    //   2614: lload 29
    //   2616: lstore 25
    //   2618: iload 17
    //   2620: istore 19
    //   2622: lload 29
    //   2624: lstore 27
    //   2626: aload_1
    //   2627: invokevirtual 886	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   2630: ifeq +139 -> 2769
    //   2633: iload 17
    //   2635: istore 18
    //   2637: lload 29
    //   2639: lstore 25
    //   2641: iload 17
    //   2643: istore 19
    //   2645: lload 29
    //   2647: lstore 27
    //   2649: aload_1
    //   2650: aload 9
    //   2652: invokevirtual 901	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   2655: iload 17
    //   2657: istore 18
    //   2659: lload 29
    //   2661: lstore 25
    //   2663: iload 17
    //   2665: istore 19
    //   2667: lload 29
    //   2669: lstore 27
    //   2671: aload 12
    //   2673: aload_1
    //   2674: aload_1
    //   2675: invokeinterface 903 3 0
    //   2680: iconst_0
    //   2681: istore 16
    //   2683: iload 17
    //   2685: istore 14
    //   2687: lload 29
    //   2689: lstore 23
    //   2691: goto -199 -> 2492
    //   2694: new 823	java/io/ByteArrayOutputStream
    //   2697: dup
    //   2698: invokespecial 904	java/io/ByteArrayOutputStream:<init>	()V
    //   2701: astore 8
    //   2703: goto -234 -> 2469
    //   2706: astore 9
    //   2708: iconst_0
    //   2709: istore 16
    //   2711: lload 23
    //   2713: lstore 25
    //   2715: aload 6
    //   2717: astore 10
    //   2719: aload 4
    //   2721: astore 8
    //   2723: aload 5
    //   2725: astore 4
    //   2727: iload 15
    //   2729: istore 14
    //   2731: iconst_1
    //   2732: istore_3
    //   2733: aload 7
    //   2735: astore 5
    //   2737: aconst_null
    //   2738: astore 6
    //   2740: lload 21
    //   2742: lstore 23
    //   2744: iload 16
    //   2746: istore 15
    //   2748: lload 25
    //   2750: lstore 21
    //   2752: aload 10
    //   2754: astore 7
    //   2756: goto -1684 -> 1072
    //   2759: sipush 10240
    //   2762: newarray <illegal type>
    //   2764: astore 9
    //   2766: goto -280 -> 2486
    //   2769: iload 17
    //   2771: istore 18
    //   2773: lload 29
    //   2775: lstore 25
    //   2777: iload 17
    //   2779: istore 19
    //   2781: lload 29
    //   2783: lstore 27
    //   2785: aload 8
    //   2787: aload 9
    //   2789: invokevirtual 906	java/io/ByteArrayOutputStream:write	([B)V
    //   2792: iconst_0
    //   2793: istore 16
    //   2795: iload 17
    //   2797: istore 14
    //   2799: lload 29
    //   2801: lstore 23
    //   2803: goto -311 -> 2492
    //   2806: iload 14
    //   2808: istore 18
    //   2810: lload 23
    //   2812: lstore 25
    //   2814: iload 14
    //   2816: istore 19
    //   2818: lload 23
    //   2820: lstore 27
    //   2822: aload_1
    //   2823: invokevirtual 886	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()Z
    //   2826: ifeq +455 -> 3281
    //   2829: iload 16
    //   2831: ifle +99 -> 2930
    //   2834: iload 14
    //   2836: istore 18
    //   2838: lload 23
    //   2840: lstore 25
    //   2842: iload 14
    //   2844: istore 19
    //   2846: lload 23
    //   2848: lstore 27
    //   2850: iload 16
    //   2852: newarray <illegal type>
    //   2854: astore 11
    //   2856: iload 14
    //   2858: istore 18
    //   2860: lload 23
    //   2862: lstore 25
    //   2864: iload 14
    //   2866: istore 19
    //   2868: lload 23
    //   2870: lstore 27
    //   2872: aload 9
    //   2874: iconst_0
    //   2875: aload 11
    //   2877: iconst_0
    //   2878: iload 16
    //   2880: invokestatic 910	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2883: iload 14
    //   2885: istore 18
    //   2887: lload 23
    //   2889: lstore 25
    //   2891: iload 14
    //   2893: istore 19
    //   2895: lload 23
    //   2897: lstore 27
    //   2899: aload_1
    //   2900: aload 11
    //   2902: invokevirtual 901	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   2905: iload 14
    //   2907: istore 18
    //   2909: lload 23
    //   2911: lstore 25
    //   2913: iload 14
    //   2915: istore 19
    //   2917: lload 23
    //   2919: lstore 27
    //   2921: aload 12
    //   2923: aload_1
    //   2924: aload_1
    //   2925: invokeinterface 903 3 0
    //   2930: iload 14
    //   2932: istore 18
    //   2934: lload 23
    //   2936: lstore 25
    //   2938: iload 14
    //   2940: istore 19
    //   2942: lload 23
    //   2944: lstore 27
    //   2946: aload_1
    //   2947: getfield 884	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_f_of_type_Boolean	Z
    //   2950: ifeq +26 -> 2976
    //   2953: iload 14
    //   2955: istore 18
    //   2957: lload 23
    //   2959: lstore 25
    //   2961: iload 14
    //   2963: istore 19
    //   2965: lload 23
    //   2967: lstore 27
    //   2969: aload 10
    //   2971: aload 9
    //   2973: invokevirtual 913	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   2976: iload 14
    //   2978: istore 18
    //   2980: lload 23
    //   2982: lstore 25
    //   2984: iload 14
    //   2986: istore 19
    //   2988: lload 23
    //   2990: lstore 27
    //   2992: aload 8
    //   2994: invokevirtual 824	java/io/ByteArrayOutputStream:close	()V
    //   2997: aload 12
    //   2999: aload_1
    //   3000: aload_1
    //   3001: iconst_4
    //   3002: invokeinterface 404 4 0
    //   3007: pop
    //   3008: iconst_0
    //   3009: istore 17
    //   3011: iload 14
    //   3013: istore 16
    //   3015: iload 17
    //   3017: istore 14
    //   3019: iload 15
    //   3021: sipush 200
    //   3024: if_icmpeq +11 -> 3035
    //   3027: iload 15
    //   3029: sipush 206
    //   3032: if_icmpne +32 -> 3064
    //   3035: aload_0
    //   3036: aload_1
    //   3037: ldc_w 749
    //   3040: new 261	java/lang/StringBuilder
    //   3043: dup
    //   3044: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   3047: ldc_w 751
    //   3050: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3053: iload 16
    //   3055: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3058: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3061: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3064: aload_2
    //   3065: ifnull +13 -> 3078
    //   3068: aload_2
    //   3069: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3072: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3075: ifne +106 -> 3181
    //   3078: aload_0
    //   3079: aload_1
    //   3080: ldc_w 753
    //   3083: new 261	java/lang/StringBuilder
    //   3086: dup
    //   3087: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   3090: ldc_w 755
    //   3093: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3096: aload_1
    //   3097: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3100: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: ldc_w 759
    //   3106: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3109: aload_1
    //   3110: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3113: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3116: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3119: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3122: iload 14
    //   3124: ifeq +57 -> 3181
    //   3127: aload_1
    //   3128: getfield 819	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Int	I
    //   3131: sipush 56009
    //   3134: if_icmpne +47 -> 3181
    //   3137: aload_0
    //   3138: aload_1
    //   3139: ldc_w 821
    //   3142: new 261	java/lang/StringBuilder
    //   3145: dup
    //   3146: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   3149: ldc_w 784
    //   3152: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3155: aload_1
    //   3156: getfield 378	com/tencent/mobileqq/utils/httputils/HttpMsg:ak	Ljava/lang/String;
    //   3159: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: ldc_w 786
    //   3165: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: aload_1
    //   3169: getfield 544	com/tencent/mobileqq/utils/httputils/HttpMsg:al	Ljava/lang/String;
    //   3172: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3178: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3181: aload_0
    //   3182: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3185: ifnull +17 -> 3202
    //   3188: aload 7
    //   3190: ifnull +12 -> 3202
    //   3193: aload_0
    //   3194: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3197: aload 7
    //   3199: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3202: lload 21
    //   3204: lload 23
    //   3206: ladd
    //   3207: lstore 21
    //   3209: lload 21
    //   3211: lconst_0
    //   3212: lcmp
    //   3213: ifeq +25 -> 3238
    //   3216: aload_1
    //   3217: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   3220: ldc -11
    //   3222: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3225: ifeq +562 -> 3787
    //   3228: iconst_1
    //   3229: istore_3
    //   3230: aload_0
    //   3231: aload_1
    //   3232: iload_3
    //   3233: lload 21
    //   3235: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3238: aload 8
    //   3240: ifnull +8 -> 3248
    //   3243: aload 8
    //   3245: invokevirtual 824	java/io/ByteArrayOutputStream:close	()V
    //   3248: aload 4
    //   3250: ifnull +8 -> 3258
    //   3253: aload 4
    //   3255: invokevirtual 814	java/io/InputStream:close	()V
    //   3258: aload 6
    //   3260: ifnull +8 -> 3268
    //   3263: aload 6
    //   3265: invokevirtual 773	java/io/OutputStream:close	()V
    //   3268: aload 5
    //   3270: ifnull +8 -> 3278
    //   3273: aload 5
    //   3275: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   3278: goto -1854 -> 1424
    //   3281: iload 16
    //   3283: ifle +29 -> 3312
    //   3286: iload 14
    //   3288: istore 18
    //   3290: lload 23
    //   3292: lstore 25
    //   3294: iload 14
    //   3296: istore 19
    //   3298: lload 23
    //   3300: lstore 27
    //   3302: aload 8
    //   3304: aload 9
    //   3306: iconst_0
    //   3307: iload 16
    //   3309: invokevirtual 914	java/io/ByteArrayOutputStream:write	([BII)V
    //   3312: iload 14
    //   3314: istore 18
    //   3316: lload 23
    //   3318: lstore 25
    //   3320: iload 14
    //   3322: istore 19
    //   3324: lload 23
    //   3326: lstore 27
    //   3328: aload 8
    //   3330: invokevirtual 915	java/io/ByteArrayOutputStream:flush	()V
    //   3333: iload 14
    //   3335: istore 18
    //   3337: lload 23
    //   3339: lstore 25
    //   3341: iload 14
    //   3343: istore 19
    //   3345: lload 23
    //   3347: lstore 27
    //   3349: aload_1
    //   3350: aload 8
    //   3352: invokevirtual 918	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3355: invokevirtual 901	com/tencent/mobileqq/utils/httputils/HttpMsg:a	([B)V
    //   3358: iload 14
    //   3360: istore 18
    //   3362: lload 23
    //   3364: lstore 25
    //   3366: iload 14
    //   3368: istore 19
    //   3370: lload 23
    //   3372: lstore 27
    //   3374: aload 12
    //   3376: aload_1
    //   3377: aload_1
    //   3378: invokeinterface 903 3 0
    //   3383: goto -453 -> 2930
    //   3386: astore 9
    //   3388: aload 6
    //   3390: astore 10
    //   3392: aload 4
    //   3394: astore 11
    //   3396: iload 15
    //   3398: istore 14
    //   3400: iconst_1
    //   3401: istore_3
    //   3402: aload 5
    //   3404: astore 4
    //   3406: aload 8
    //   3408: astore 6
    //   3410: lload 21
    //   3412: lstore 23
    //   3414: aload 7
    //   3416: astore 5
    //   3418: iload 18
    //   3420: istore 15
    //   3422: lload 25
    //   3424: lstore 21
    //   3426: aload 10
    //   3428: astore 7
    //   3430: aload 11
    //   3432: astore 8
    //   3434: goto -2362 -> 1072
    //   3437: aload_1
    //   3438: getfield 207	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_g_of_type_Boolean	Z
    //   3441: ifeq +300 -> 3741
    //   3444: aload_1
    //   3445: getfield 219	com/tencent/mobileqq/utils/httputils/HttpMsg:j	I
    //   3448: ifeq +293 -> 3741
    //   3451: aload_1
    //   3452: getfield 217	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Boolean	Z
    //   3455: ifne +286 -> 3741
    //   3458: aload_0
    //   3459: aload_1
    //   3460: ldc_w 920
    //   3463: ldc_w 922
    //   3466: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3469: aload_1
    //   3470: iconst_1
    //   3471: putfield 217	com/tencent/mobileqq/utils/httputils/HttpMsg:jdField_h_of_type_Boolean	Z
    //   3474: aload_0
    //   3475: aload_1
    //   3476: aload_2
    //   3477: iconst_0
    //   3478: invokevirtual 846	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lwdx;Z)V
    //   3481: new 148	java/util/HashMap
    //   3484: dup
    //   3485: invokespecial 612	java/util/HashMap:<init>	()V
    //   3488: astore 4
    //   3490: aload 4
    //   3492: ldc_w 614
    //   3495: aload_1
    //   3496: getfield 219	com/tencent/mobileqq/utils/httputils/HttpMsg:j	I
    //   3499: invokestatic 616	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3502: invokevirtual 620	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3505: pop
    //   3506: invokestatic 174	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3509: invokestatic 627	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3512: aconst_null
    //   3513: ldc_w 924
    //   3516: iconst_0
    //   3517: lconst_0
    //   3518: lconst_0
    //   3519: aload 4
    //   3521: ldc_w 631
    //   3524: invokevirtual 634	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3527: iload 15
    //   3529: sipush 200
    //   3532: if_icmpeq +11 -> 3543
    //   3535: iload 15
    //   3537: sipush 206
    //   3540: if_icmpne +31 -> 3571
    //   3543: aload_0
    //   3544: aload_1
    //   3545: ldc_w 749
    //   3548: new 261	java/lang/StringBuilder
    //   3551: dup
    //   3552: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   3555: ldc_w 751
    //   3558: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: iconst_0
    //   3562: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3565: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3568: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3571: aload_2
    //   3572: ifnull +13 -> 3585
    //   3575: aload_2
    //   3576: getfield 727	wdx:jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3579: invokevirtual 730	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3582: ifne +47 -> 3629
    //   3585: aload_0
    //   3586: aload_1
    //   3587: ldc_w 753
    //   3590: new 261	java/lang/StringBuilder
    //   3593: dup
    //   3594: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   3597: ldc_w 755
    //   3600: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3603: aload_1
    //   3604: invokevirtual 757	com/tencent/mobileqq/utils/httputils/HttpMsg:d	()Ljava/lang/String;
    //   3607: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3610: ldc_w 759
    //   3613: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3616: aload_1
    //   3617: invokevirtual 761	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()Ljava/lang/String;
    //   3620: invokevirtual 268	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3623: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3626: invokevirtual 297	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3629: aload_0
    //   3630: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3633: ifnull +17 -> 3650
    //   3636: aload 7
    //   3638: ifnull +12 -> 3650
    //   3641: aload_0
    //   3642: getfield 496	com/tencent/mobileqq/utils/httputils/HttpCommunicator:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   3645: aload 7
    //   3647: invokevirtual 765	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3650: lload 21
    //   3652: lconst_0
    //   3653: ladd
    //   3654: lstore 21
    //   3656: lload 21
    //   3658: lconst_0
    //   3659: lcmp
    //   3660: ifeq +25 -> 3685
    //   3663: aload_1
    //   3664: invokevirtual 247	com/tencent/mobileqq/utils/httputils/HttpMsg:e	()Ljava/lang/String;
    //   3667: ldc -11
    //   3669: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3672: ifeq +64 -> 3736
    //   3675: iconst_1
    //   3676: istore_3
    //   3677: aload_0
    //   3678: aload_1
    //   3679: iload_3
    //   3680: lload 21
    //   3682: invokevirtual 768	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3685: iconst_0
    //   3686: ifeq +11 -> 3697
    //   3689: new 770	java/lang/NullPointerException
    //   3692: dup
    //   3693: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   3696: athrow
    //   3697: iconst_0
    //   3698: ifeq +11 -> 3709
    //   3701: new 770	java/lang/NullPointerException
    //   3704: dup
    //   3705: invokespecial 771	java/lang/NullPointerException:<init>	()V
    //   3708: athrow
    //   3709: aload 6
    //   3711: ifnull +8 -> 3719
    //   3714: aload 6
    //   3716: invokevirtual 773	java/io/OutputStream:close	()V
    //   3719: aload 5
    //   3721: ifnull -3168 -> 553
    //   3724: aload 5
    //   3726: invokevirtual 776	java/net/HttpURLConnection:disconnect	()V
    //   3729: return
    //   3730: astore_1
    //   3731: aload_1
    //   3732: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   3735: return
    //   3736: iconst_0
    //   3737: istore_3
    //   3738: goto -61 -> 3677
    //   3741: iconst_1
    //   3742: istore 14
    //   3744: iconst_1
    //   3745: istore 16
    //   3747: aload_0
    //   3748: iload 15
    //   3750: aload 5
    //   3752: aload_1
    //   3753: invokevirtual 926	com/tencent/mobileqq/utils/httputils/HttpCommunicator:b	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3756: iload 18
    //   3758: istore 16
    //   3760: aload 11
    //   3762: astore 8
    //   3764: aload 10
    //   3766: astore 4
    //   3768: goto -749 -> 3019
    //   3771: astore 4
    //   3773: iload 16
    //   3775: istore 14
    //   3777: iload 17
    //   3779: istore 16
    //   3781: iload 31
    //   3783: istore_3
    //   3784: goto -2284 -> 1500
    //   3787: iconst_0
    //   3788: istore_3
    //   3789: goto -559 -> 3230
    //   3792: astore 4
    //   3794: aload 4
    //   3796: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   3799: goto -2375 -> 1424
    //   3802: astore 10
    //   3804: aload 11
    //   3806: ifnull -2660 -> 1146
    //   3809: aload 11
    //   3811: invokevirtual 814	java/io/InputStream:close	()V
    //   3814: goto -2668 -> 1146
    //   3817: astore 10
    //   3819: goto -2673 -> 1146
    //   3822: astore 9
    //   3824: aconst_null
    //   3825: astore 10
    //   3827: aload 10
    //   3829: ifnull +8 -> 3837
    //   3832: aload 10
    //   3834: invokevirtual 814	java/io/InputStream:close	()V
    //   3837: aload 9
    //   3839: athrow
    //   3840: astore 11
    //   3842: iload 14
    //   3844: istore 17
    //   3846: aload 6
    //   3848: astore 9
    //   3850: aload 7
    //   3852: astore 6
    //   3854: aload 4
    //   3856: astore 10
    //   3858: lload 21
    //   3860: lstore 25
    //   3862: iconst_1
    //   3863: istore 14
    //   3865: lload 23
    //   3867: lstore 21
    //   3869: aload 11
    //   3871: astore 4
    //   3873: aload 5
    //   3875: astore 7
    //   3877: iload 15
    //   3879: istore 16
    //   3881: lload 25
    //   3883: lstore 23
    //   3885: iload 17
    //   3887: istore 15
    //   3889: aload 10
    //   3891: astore 5
    //   3893: goto -2393 -> 1500
    //   3896: iconst_0
    //   3897: istore_3
    //   3898: goto -2530 -> 1368
    //   3901: astore 4
    //   3903: aload 4
    //   3905: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   3908: iload 16
    //   3910: istore 14
    //   3912: goto -2488 -> 1424
    //   3915: iconst_0
    //   3916: istore_3
    //   3917: goto -2202 -> 1715
    //   3920: astore_1
    //   3921: aload_1
    //   3922: invokevirtual 606	java/lang/Exception:printStackTrace	()V
    //   3925: goto -2162 -> 1763
    //   3928: aload 12
    //   3930: aload_1
    //   3931: aload_1
    //   3932: iconst_5
    //   3933: invokeinterface 404 4 0
    //   3938: pop
    //   3939: return
    //   3940: astore_1
    //   3941: goto -3420 -> 521
    //   3944: astore_1
    //   3945: goto -3412 -> 533
    //   3948: astore_1
    //   3949: goto -3406 -> 543
    //   3952: astore_1
    //   3953: goto -3056 -> 897
    //   3956: astore_1
    //   3957: goto -3048 -> 909
    //   3960: astore_1
    //   3961: goto -3042 -> 919
    //   3964: astore_1
    //   3965: goto -1925 -> 2040
    //   3968: astore_1
    //   3969: goto -1917 -> 2052
    //   3972: astore_1
    //   3973: goto -1911 -> 2062
    //   3976: astore_1
    //   3977: goto -280 -> 3697
    //   3980: astore_1
    //   3981: goto -272 -> 3709
    //   3984: astore_1
    //   3985: goto -266 -> 3719
    //   3988: astore 7
    //   3990: goto -742 -> 3248
    //   3993: astore 4
    //   3995: goto -737 -> 3258
    //   3998: astore 4
    //   4000: goto -732 -> 3268
    //   4003: astore 10
    //   4005: goto -2859 -> 1146
    //   4008: astore 10
    //   4010: goto -173 -> 3837
    //   4013: astore 5
    //   4015: goto -2629 -> 1386
    //   4018: astore 5
    //   4020: goto -2624 -> 1396
    //   4023: astore 5
    //   4025: goto -2619 -> 1406
    //   4028: astore_1
    //   4029: goto -2296 -> 1733
    //   4032: astore_1
    //   4033: goto -2290 -> 1743
    //   4036: astore_1
    //   4037: goto -2284 -> 1753
    //   4040: astore 4
    //   4042: aconst_null
    //   4043: astore 7
    //   4045: iconst_0
    //   4046: istore_3
    //   4047: lconst_0
    //   4048: lstore 21
    //   4050: iconst_m1
    //   4051: istore 15
    //   4053: aconst_null
    //   4054: astore 6
    //   4056: aconst_null
    //   4057: astore 5
    //   4059: iconst_0
    //   4060: istore 14
    //   4062: iload 17
    //   4064: istore 16
    //   4066: goto -2566 -> 1500
    //   4069: astore 4
    //   4071: iload 14
    //   4073: istore 15
    //   4075: iconst_0
    //   4076: istore 14
    //   4078: iload 17
    //   4080: istore 16
    //   4082: iload 31
    //   4084: istore_3
    //   4085: goto -2585 -> 1500
    //   4088: astore 4
    //   4090: iload 14
    //   4092: istore 15
    //   4094: iconst_0
    //   4095: istore 14
    //   4097: iload 17
    //   4099: istore 16
    //   4101: iload 31
    //   4103: istore_3
    //   4104: goto -2604 -> 1500
    //   4107: astore 10
    //   4109: aload 6
    //   4111: astore 7
    //   4113: iload 31
    //   4115: istore_3
    //   4116: iload 14
    //   4118: istore 15
    //   4120: aload 4
    //   4122: astore 6
    //   4124: aload 10
    //   4126: astore 4
    //   4128: iconst_0
    //   4129: istore 14
    //   4131: iload 17
    //   4133: istore 16
    //   4135: goto -2635 -> 1500
    //   4138: astore 10
    //   4140: aload 6
    //   4142: astore 7
    //   4144: iload 31
    //   4146: istore_3
    //   4147: iload 14
    //   4149: istore 15
    //   4151: aload 4
    //   4153: astore 6
    //   4155: iconst_0
    //   4156: istore 14
    //   4158: aload 10
    //   4160: astore 4
    //   4162: iload 17
    //   4164: istore 16
    //   4166: goto -2666 -> 1500
    //   4169: astore 10
    //   4171: aload 6
    //   4173: astore 7
    //   4175: iload 14
    //   4177: istore 15
    //   4179: aload 4
    //   4181: astore 6
    //   4183: iconst_0
    //   4184: istore 14
    //   4186: aload 10
    //   4188: astore 4
    //   4190: iload 17
    //   4192: istore 16
    //   4194: iload 31
    //   4196: istore_3
    //   4197: goto -2697 -> 1500
    //   4200: astore 10
    //   4202: iload 14
    //   4204: istore 15
    //   4206: aload 4
    //   4208: astore 6
    //   4210: aload 10
    //   4212: astore 4
    //   4214: iconst_0
    //   4215: istore 14
    //   4217: iload 17
    //   4219: istore 16
    //   4221: iload 31
    //   4223: istore_3
    //   4224: goto -2724 -> 1500
    //   4227: astore 4
    //   4229: iconst_0
    //   4230: istore 14
    //   4232: iload 17
    //   4234: istore 16
    //   4236: iload 31
    //   4238: istore_3
    //   4239: goto -2739 -> 1500
    //   4242: astore 10
    //   4244: aload 4
    //   4246: astore 8
    //   4248: iconst_0
    //   4249: istore 14
    //   4251: aload 10
    //   4253: astore 4
    //   4255: iload 17
    //   4257: istore 16
    //   4259: iload 31
    //   4261: istore_3
    //   4262: goto -2762 -> 1500
    //   4265: astore 10
    //   4267: aload 8
    //   4269: astore 9
    //   4271: aload 4
    //   4273: astore 8
    //   4275: iconst_0
    //   4276: istore 14
    //   4278: aload 10
    //   4280: astore 4
    //   4282: iload 17
    //   4284: istore 16
    //   4286: iload 31
    //   4288: istore_3
    //   4289: goto -2789 -> 1500
    //   4292: astore 10
    //   4294: iload 19
    //   4296: istore 16
    //   4298: lload 27
    //   4300: lstore 23
    //   4302: aload 8
    //   4304: astore 9
    //   4306: aload 4
    //   4308: astore 8
    //   4310: iconst_0
    //   4311: istore 14
    //   4313: aload 10
    //   4315: astore 4
    //   4317: iload 31
    //   4319: istore_3
    //   4320: goto -2820 -> 1500
    //   4323: astore 10
    //   4325: iload 14
    //   4327: istore 16
    //   4329: aload 8
    //   4331: astore 9
    //   4333: aload 4
    //   4335: astore 8
    //   4337: aload 10
    //   4339: astore 4
    //   4341: iconst_0
    //   4342: istore 14
    //   4344: iload 31
    //   4346: istore_3
    //   4347: goto -2847 -> 1500
    //   4350: astore 9
    //   4352: goto -525 -> 3827
    //   4355: astore 9
    //   4357: lconst_0
    //   4358: lstore 21
    //   4360: aconst_null
    //   4361: astore 6
    //   4363: aconst_null
    //   4364: astore 7
    //   4366: aconst_null
    //   4367: astore 8
    //   4369: aconst_null
    //   4370: astore 5
    //   4372: lconst_0
    //   4373: lstore 23
    //   4375: iconst_m1
    //   4376: istore 14
    //   4378: aconst_null
    //   4379: astore 4
    //   4381: iconst_0
    //   4382: istore 15
    //   4384: iload 31
    //   4386: istore_3
    //   4387: goto -3315 -> 1072
    //   4390: astore 9
    //   4392: aload 7
    //   4394: astore 8
    //   4396: iconst_0
    //   4397: istore 15
    //   4399: lconst_0
    //   4400: lstore 25
    //   4402: lload 21
    //   4404: lstore 23
    //   4406: aload 6
    //   4408: astore 7
    //   4410: aconst_null
    //   4411: astore 10
    //   4413: iconst_1
    //   4414: istore_3
    //   4415: aload 5
    //   4417: astore 4
    //   4419: aconst_null
    //   4420: astore 6
    //   4422: aload 8
    //   4424: astore 5
    //   4426: lload 25
    //   4428: lstore 21
    //   4430: aload 10
    //   4432: astore 8
    //   4434: goto -3362 -> 1072
    //   4437: astore 9
    //   4439: iconst_0
    //   4440: istore 15
    //   4442: iconst_1
    //   4443: istore_3
    //   4444: lconst_0
    //   4445: lstore 25
    //   4447: aload 5
    //   4449: astore 4
    //   4451: aconst_null
    //   4452: astore 11
    //   4454: aload 6
    //   4456: astore 8
    //   4458: aconst_null
    //   4459: astore 10
    //   4461: lload 21
    //   4463: lstore 23
    //   4465: aload 7
    //   4467: astore 5
    //   4469: lload 25
    //   4471: lstore 21
    //   4473: aload 11
    //   4475: astore 6
    //   4477: aload 8
    //   4479: astore 7
    //   4481: aload 10
    //   4483: astore 8
    //   4485: goto -3413 -> 1072
    //   4488: astore 9
    //   4490: lconst_0
    //   4491: lstore 25
    //   4493: aconst_null
    //   4494: astore 10
    //   4496: aload 4
    //   4498: astore 7
    //   4500: aconst_null
    //   4501: astore 8
    //   4503: iload 31
    //   4505: istore_3
    //   4506: lload 21
    //   4508: lstore 23
    //   4510: aload 5
    //   4512: astore 4
    //   4514: iconst_0
    //   4515: istore 15
    //   4517: aload 6
    //   4519: astore 5
    //   4521: lload 25
    //   4523: lstore 21
    //   4525: aload 10
    //   4527: astore 6
    //   4529: goto -3457 -> 1072
    //   4532: astore 9
    //   4534: iconst_0
    //   4535: istore 15
    //   4537: lconst_0
    //   4538: lstore 25
    //   4540: aconst_null
    //   4541: astore 10
    //   4543: lload 21
    //   4545: lstore 23
    //   4547: aload 4
    //   4549: astore 7
    //   4551: aconst_null
    //   4552: astore 8
    //   4554: aload 5
    //   4556: astore 4
    //   4558: iload 31
    //   4560: istore_3
    //   4561: aload 6
    //   4563: astore 5
    //   4565: lload 25
    //   4567: lstore 21
    //   4569: aload 10
    //   4571: astore 6
    //   4573: goto -3501 -> 1072
    //   4576: astore 9
    //   4578: iconst_0
    //   4579: istore 15
    //   4581: lconst_0
    //   4582: lstore 25
    //   4584: lload 21
    //   4586: lstore 23
    //   4588: aload 4
    //   4590: astore 7
    //   4592: aconst_null
    //   4593: astore 8
    //   4595: aload 5
    //   4597: astore 4
    //   4599: iconst_1
    //   4600: istore_3
    //   4601: aconst_null
    //   4602: astore 10
    //   4604: aload 6
    //   4606: astore 5
    //   4608: lload 25
    //   4610: lstore 21
    //   4612: aload 10
    //   4614: astore 6
    //   4616: goto -3544 -> 1072
    //   4619: astore 9
    //   4621: iconst_0
    //   4622: istore 15
    //   4624: iconst_1
    //   4625: istore_3
    //   4626: lconst_0
    //   4627: lstore 25
    //   4629: lload 21
    //   4631: lstore 23
    //   4633: aconst_null
    //   4634: astore 6
    //   4636: aload 4
    //   4638: astore 8
    //   4640: aconst_null
    //   4641: astore 10
    //   4643: aload 5
    //   4645: astore 4
    //   4647: aload 7
    //   4649: astore 5
    //   4651: lload 25
    //   4653: lstore 21
    //   4655: aload 8
    //   4657: astore 7
    //   4659: aload 10
    //   4661: astore 8
    //   4663: goto -3591 -> 1072
    //   4666: astore 9
    //   4668: aload 7
    //   4670: astore 8
    //   4672: iconst_0
    //   4673: istore 16
    //   4675: lload 23
    //   4677: lstore 25
    //   4679: aload 6
    //   4681: astore 7
    //   4683: aconst_null
    //   4684: astore 10
    //   4686: aload 5
    //   4688: astore 4
    //   4690: iconst_1
    //   4691: istore_3
    //   4692: lload 21
    //   4694: lstore 23
    //   4696: iload 15
    //   4698: istore 14
    //   4700: aconst_null
    //   4701: astore 6
    //   4703: aload 8
    //   4705: astore 5
    //   4707: iload 16
    //   4709: istore 15
    //   4711: lload 25
    //   4713: lstore 21
    //   4715: aload 10
    //   4717: astore 8
    //   4719: goto -3647 -> 1072
    //   4722: astore 9
    //   4724: iconst_0
    //   4725: istore 16
    //   4727: aload 6
    //   4729: astore 10
    //   4731: aload 4
    //   4733: astore 11
    //   4735: aload 5
    //   4737: astore 4
    //   4739: iload 15
    //   4741: istore 14
    //   4743: iconst_1
    //   4744: istore_3
    //   4745: aload 7
    //   4747: astore 5
    //   4749: aload 8
    //   4751: astore 6
    //   4753: lload 21
    //   4755: lstore 25
    //   4757: iload 16
    //   4759: istore 15
    //   4761: lload 23
    //   4763: lstore 21
    //   4765: lload 25
    //   4767: lstore 23
    //   4769: aload 10
    //   4771: astore 7
    //   4773: aload 11
    //   4775: astore 8
    //   4777: goto -3705 -> 1072
    //   4780: astore 9
    //   4782: aload 7
    //   4784: astore 11
    //   4786: iload 14
    //   4788: istore 16
    //   4790: aload 6
    //   4792: astore 7
    //   4794: aload 4
    //   4796: astore 10
    //   4798: iload 15
    //   4800: istore 14
    //   4802: iconst_1
    //   4803: istore_3
    //   4804: lload 21
    //   4806: lstore 25
    //   4808: aload 8
    //   4810: astore 6
    //   4812: aload 5
    //   4814: astore 4
    //   4816: aload 11
    //   4818: astore 5
    //   4820: iload 16
    //   4822: istore 15
    //   4824: lload 23
    //   4826: lstore 21
    //   4828: lload 25
    //   4830: lstore 23
    //   4832: aload 10
    //   4834: astore 8
    //   4836: goto -3764 -> 1072
    //   4839: astore 4
    //   4841: goto -4130 -> 711
    //   4844: iconst_0
    //   4845: istore 14
    //   4847: lconst_0
    //   4848: lstore 23
    //   4850: aconst_null
    //   4851: astore 8
    //   4853: aconst_null
    //   4854: astore 4
    //   4856: goto -1859 -> 2997
    //   4859: aload 6
    //   4861: astore 7
    //   4863: aload 4
    //   4865: astore 6
    //   4867: goto -4556 -> 311
    //   4870: iconst_0
    //   4871: istore_3
    //   4872: goto -2852 -> 2020
    //   4875: iload 14
    //   4877: iconst_1
    //   4878: iadd
    //   4879: istore 14
    //   4881: goto -2699 -> 2182
    //   4884: iload 16
    //   4886: iconst_1
    //   4887: iadd
    //   4888: istore 16
    //   4890: goto -2655 -> 2235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4893	0	this	HttpCommunicator
    //   0	4893	1	paramHttpMsg	HttpMsg
    //   0	4893	2	paramwdx	wdx
    //   0	4893	3	paramBoolean	boolean
    //   16	1400	4	localObject1	Object
    //   1488	276	4	localObject2	Object
    //   1795	1972	4	localObject3	Object
    //   3771	1	4	localObject4	Object
    //   3792	63	4	localException1	Exception
    //   3871	1	4	localObject5	Object
    //   3901	3	4	localException2	Exception
    //   3993	1	4	localIOException1	IOException
    //   3998	1	4	localIOException2	IOException
    //   4040	1	4	localObject6	Object
    //   4069	1	4	localObject7	Object
    //   4088	33	4	localObject8	Object
    //   4126	87	4	localObject9	Object
    //   4227	18	4	localObject10	Object
    //   4253	562	4	localObject11	Object
    //   4839	1	4	localThrowable1	Throwable
    //   4854	10	4	localObject12	Object
    //   7	3885	5	localObject13	Object
    //   4013	1	5	localIOException3	IOException
    //   4018	1	5	localIOException4	IOException
    //   4023	1	5	localIOException5	IOException
    //   4057	762	5	localObject14	Object
    //   57	4809	6	localObject15	Object
    //   81	3795	7	localObject16	Object
    //   3988	1	7	localIOException6	IOException
    //   4043	819	7	localObject17	Object
    //   13	4839	8	localObject18	Object
    //   22	2629	9	localObject19	Object
    //   2706	1	9	localThrowable2	Throwable
    //   2764	541	9	arrayOfByte	byte[]
    //   3386	1	9	localThrowable3	Throwable
    //   3822	16	9	localObject20	Object
    //   3848	484	9	localObject21	Object
    //   4350	1	9	localObject22	Object
    //   4355	1	9	localThrowable4	Throwable
    //   4390	1	9	localThrowable5	Throwable
    //   4437	1	9	localThrowable6	Throwable
    //   4488	1	9	localThrowable7	Throwable
    //   4532	1	9	localThrowable8	Throwable
    //   4576	1	9	localThrowable9	Throwable
    //   4619	1	9	localThrowable10	Throwable
    //   4666	1	9	localThrowable11	Throwable
    //   4722	1	9	localThrowable12	Throwable
    //   4780	1	9	localThrowable13	Throwable
    //   10	1	10	localObject23	Object
    //   1016	53	10	localThrowable14	Throwable
    //   1100	2665	10	localObject24	Object
    //   3802	1	10	localException3	Exception
    //   3817	1	10	localIOException7	IOException
    //   3825	65	10	localObject25	Object
    //   4003	1	10	localIOException8	IOException
    //   4008	1	10	localIOException9	IOException
    //   4107	18	10	localObject26	Object
    //   4138	21	10	localObject27	Object
    //   4169	18	10	localObject28	Object
    //   4200	11	10	localObject29	Object
    //   4242	10	10	localObject30	Object
    //   4265	14	10	localObject31	Object
    //   4292	22	10	localObject32	Object
    //   4323	15	10	localObject33	Object
    //   4411	422	10	localObject34	Object
    //   19	3791	11	localObject35	Object
    //   3840	30	11	localObject36	Object
    //   4452	365	11	localObject37	Object
    //   4	3925	12	localIHttpCommunicatorListener	IHttpCommunicatorListener
    //   159	2031	13	localObject38	Object
    //   25	4855	14	i1	int
    //   199	4624	15	i2	int
    //   51	4838	16	i3	int
    //   40	4243	17	i4	int
    //   37	3720	18	i5	int
    //   2230	2065	19	i6	int
    //   2565	43	20	i7	int
    //   28	4799	21	l1	long
    //   31	4818	23	l2	long
    //   289	4540	25	l3	long
    //   2506	1793	27	l4	long
    //   2558	242	29	l5	long
    //   34	4525	31	bool1	boolean
    //   344	3	32	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   453	460	559	java/lang/Exception
    //   465	474	559	java/lang/Exception
    //   487	499	559	java/lang/Exception
    //   501	509	559	java/lang/Exception
    //   513	521	559	java/lang/Exception
    //   525	533	559	java/lang/Exception
    //   538	543	559	java/lang/Exception
    //   548	553	559	java/lang/Exception
    //   829	836	930	java/lang/Exception
    //   841	850	930	java/lang/Exception
    //   863	875	930	java/lang/Exception
    //   877	885	930	java/lang/Exception
    //   889	897	930	java/lang/Exception
    //   901	909	930	java/lang/Exception
    //   914	919	930	java/lang/Exception
    //   924	929	930	java/lang/Exception
    //   324	333	1016	java/lang/Throwable
    //   337	346	1016	java/lang/Throwable
    //   565	572	1016	java/lang/Throwable
    //   577	586	1016	java/lang/Throwable
    //   586	615	1016	java/lang/Throwable
    //   637	691	1016	java/lang/Throwable
    //   711	727	1016	java/lang/Throwable
    //   941	957	1016	java/lang/Throwable
    //   957	981	1016	java/lang/Throwable
    //   1005	1016	1016	java/lang/Throwable
    //   1477	1488	1016	java/lang/Throwable
    //   1766	1774	1016	java/lang/Throwable
    //   1790	1797	1016	java/lang/Throwable
    //   1811	1842	1016	java/lang/Throwable
    //   1842	1863	1016	java/lang/Throwable
    //   1863	1870	1016	java/lang/Throwable
    //   2079	2086	1016	java/lang/Throwable
    //   2089	2112	1016	java/lang/Throwable
    //   2115	2151	1016	java/lang/Throwable
    //   2159	2179	1016	java/lang/Throwable
    //   2201	2218	1016	java/lang/Throwable
    //   2221	2232	1016	java/lang/Throwable
    //   2258	2268	1016	java/lang/Throwable
    //   2274	2317	1016	java/lang/Throwable
    //   2317	2348	1016	java/lang/Throwable
    //   2348	2400	1016	java/lang/Throwable
    //   2400	2411	1016	java/lang/Throwable
    //   3437	3527	1016	java/lang/Throwable
    //   3747	3756	1016	java/lang/Throwable
    //   1453	1462	1463	java/lang/Exception
    //   3928	3939	1463	java/lang/Exception
    //   324	333	1488	finally
    //   337	346	1488	finally
    //   565	572	1488	finally
    //   577	586	1488	finally
    //   586	615	1488	finally
    //   637	691	1488	finally
    //   701	706	1488	finally
    //   706	711	1488	finally
    //   711	727	1488	finally
    //   941	957	1488	finally
    //   957	981	1488	finally
    //   1005	1016	1488	finally
    //   1477	1488	1488	finally
    //   1766	1774	1488	finally
    //   1790	1797	1488	finally
    //   1811	1842	1488	finally
    //   1842	1863	1488	finally
    //   1863	1870	1488	finally
    //   2079	2086	1488	finally
    //   2089	2112	1488	finally
    //   2115	2151	1488	finally
    //   2159	2179	1488	finally
    //   2201	2218	1488	finally
    //   2221	2232	1488	finally
    //   2258	2268	1488	finally
    //   2274	2317	1488	finally
    //   2317	2348	1488	finally
    //   2348	2400	1488	finally
    //   2400	2411	1488	finally
    //   3437	3527	1488	finally
    //   1972	1979	2073	java/lang/Exception
    //   1984	1993	2073	java/lang/Exception
    //   2006	2018	2073	java/lang/Exception
    //   2020	2028	2073	java/lang/Exception
    //   2032	2040	2073	java/lang/Exception
    //   2044	2052	2073	java/lang/Exception
    //   2057	2062	2073	java/lang/Exception
    //   2067	2072	2073	java/lang/Exception
    //   2429	2469	2706	java/lang/Throwable
    //   2694	2703	2706	java/lang/Throwable
    //   2508	2525	3386	java/lang/Throwable
    //   2546	2552	3386	java/lang/Throwable
    //   2602	2610	3386	java/lang/Throwable
    //   2626	2633	3386	java/lang/Throwable
    //   2649	2655	3386	java/lang/Throwable
    //   2671	2680	3386	java/lang/Throwable
    //   2785	2792	3386	java/lang/Throwable
    //   2822	2829	3386	java/lang/Throwable
    //   2850	2856	3386	java/lang/Throwable
    //   2872	2883	3386	java/lang/Throwable
    //   2899	2905	3386	java/lang/Throwable
    //   2921	2930	3386	java/lang/Throwable
    //   2946	2953	3386	java/lang/Throwable
    //   2969	2976	3386	java/lang/Throwable
    //   2992	2997	3386	java/lang/Throwable
    //   3302	3312	3386	java/lang/Throwable
    //   3328	3333	3386	java/lang/Throwable
    //   3349	3358	3386	java/lang/Throwable
    //   3374	3383	3386	java/lang/Throwable
    //   3629	3636	3730	java/lang/Exception
    //   3641	3650	3730	java/lang/Exception
    //   3663	3675	3730	java/lang/Exception
    //   3677	3685	3730	java/lang/Exception
    //   3689	3697	3730	java/lang/Exception
    //   3701	3709	3730	java/lang/Exception
    //   3714	3719	3730	java/lang/Exception
    //   3724	3729	3730	java/lang/Exception
    //   3747	3756	3771	finally
    //   3181	3188	3792	java/lang/Exception
    //   3193	3202	3792	java/lang/Exception
    //   3216	3228	3792	java/lang/Exception
    //   3230	3238	3792	java/lang/Exception
    //   3243	3248	3792	java/lang/Exception
    //   3253	3258	3792	java/lang/Exception
    //   3263	3268	3792	java/lang/Exception
    //   3273	3278	3792	java/lang/Exception
    //   1095	1102	3802	java/lang/Exception
    //   1106	1113	3802	java/lang/Exception
    //   1122	1131	3802	java/lang/Exception
    //   3809	3814	3817	java/io/IOException
    //   1095	1102	3822	finally
    //   1075	1082	3840	finally
    //   1141	1146	3840	finally
    //   1146	1158	3840	finally
    //   3809	3814	3840	finally
    //   3832	3837	3840	finally
    //   3837	3840	3840	finally
    //   1319	1326	3901	java/lang/Exception
    //   1331	1340	3901	java/lang/Exception
    //   1354	1366	3901	java/lang/Exception
    //   1368	1376	3901	java/lang/Exception
    //   1381	1386	3901	java/lang/Exception
    //   1391	1396	3901	java/lang/Exception
    //   1401	1406	3901	java/lang/Exception
    //   1415	1420	3901	java/lang/Exception
    //   1666	1673	3920	java/lang/Exception
    //   1678	1687	3920	java/lang/Exception
    //   1701	1713	3920	java/lang/Exception
    //   1715	1723	3920	java/lang/Exception
    //   1728	1733	3920	java/lang/Exception
    //   1738	1743	3920	java/lang/Exception
    //   1748	1753	3920	java/lang/Exception
    //   1758	1763	3920	java/lang/Exception
    //   513	521	3940	java/io/IOException
    //   525	533	3944	java/io/IOException
    //   538	543	3948	java/io/IOException
    //   889	897	3952	java/io/IOException
    //   901	909	3956	java/io/IOException
    //   914	919	3960	java/io/IOException
    //   2032	2040	3964	java/io/IOException
    //   2044	2052	3968	java/io/IOException
    //   2057	2062	3972	java/io/IOException
    //   3689	3697	3976	java/io/IOException
    //   3701	3709	3980	java/io/IOException
    //   3714	3719	3984	java/io/IOException
    //   3243	3248	3988	java/io/IOException
    //   3253	3258	3993	java/io/IOException
    //   3263	3268	3998	java/io/IOException
    //   1141	1146	4003	java/io/IOException
    //   3832	3837	4008	java/io/IOException
    //   1381	1386	4013	java/io/IOException
    //   1391	1396	4018	java/io/IOException
    //   1401	1406	4023	java/io/IOException
    //   1728	1733	4028	java/io/IOException
    //   1738	1743	4032	java/io/IOException
    //   1748	1753	4036	java/io/IOException
    //   42	50	4040	finally
    //   168	198	4069	finally
    //   201	241	4069	finally
    //   256	266	4069	finally
    //   266	277	4069	finally
    //   277	296	4069	finally
    //   311	324	4088	finally
    //   59	83	4107	finally
    //   87	111	4138	finally
    //   114	142	4169	finally
    //   142	168	4200	finally
    //   2422	2429	4227	finally
    //   2429	2469	4242	finally
    //   2694	2703	4242	finally
    //   2469	2486	4265	finally
    //   2759	2766	4265	finally
    //   2508	2525	4292	finally
    //   2546	2552	4292	finally
    //   2602	2610	4292	finally
    //   2626	2633	4292	finally
    //   2649	2655	4292	finally
    //   2671	2680	4292	finally
    //   2785	2792	4292	finally
    //   2822	2829	4292	finally
    //   2850	2856	4292	finally
    //   2872	2883	4292	finally
    //   2899	2905	4292	finally
    //   2921	2930	4292	finally
    //   2946	2953	4292	finally
    //   2969	2976	4292	finally
    //   2992	2997	4292	finally
    //   3302	3312	4292	finally
    //   3328	3333	4292	finally
    //   3349	3358	4292	finally
    //   3374	3383	4292	finally
    //   2997	3008	4323	finally
    //   1106	1113	4350	finally
    //   1122	1131	4350	finally
    //   42	50	4355	java/lang/Throwable
    //   168	198	4390	java/lang/Throwable
    //   201	241	4390	java/lang/Throwable
    //   256	266	4390	java/lang/Throwable
    //   266	277	4390	java/lang/Throwable
    //   277	296	4390	java/lang/Throwable
    //   311	324	4437	java/lang/Throwable
    //   59	83	4488	java/lang/Throwable
    //   87	111	4532	java/lang/Throwable
    //   114	142	4576	java/lang/Throwable
    //   142	168	4619	java/lang/Throwable
    //   2422	2429	4666	java/lang/Throwable
    //   2469	2486	4722	java/lang/Throwable
    //   2759	2766	4722	java/lang/Throwable
    //   2997	3008	4780	java/lang/Throwable
    //   701	706	4839	java/lang/Throwable
    //   706	711	4839	java/lang/Throwable
  }
  
  protected void a(HttpMsg paramHttpMsg, boolean paramBoolean, long paramLong)
  {
    paramHttpMsg.i = ((int)paramLong);
    int i1 = paramHttpMsg.jdField_d_of_type_Int;
    int i2 = paramHttpMsg.jdField_e_of_type_Int;
    int i3 = paramHttpMsg.jdField_f_of_type_Int;
    if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorFlowCount.a(paramBoolean, i3, i1, i2, paramLong);
    }
  }
  
  public void a(String paramString)
  {
    int i1 = 0;
    if (this.d) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() + " mConcurrentRunningMsgs:" + this.o + " mConcurrentLimit:" + this.n + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() == 0) {
        return;
      }
    }
    wdx[] arrayOfwdx;
    int i2;
    if (this.o < this.n)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(false);
      if (paramString != null)
      {
        arrayOfwdx = this.jdField_a_of_type_ArrayOfWdx;
        i2 = arrayOfwdx.length;
      }
    }
    for (;;)
    {
      wdx localwdx;
      HttpMsg localHttpMsg;
      if (i1 < i2)
      {
        localwdx = arrayOfwdx[i1];
        localHttpMsg = localwdx.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
        if (localwdx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
          break label265;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramString);
        paramString.b();
        localwdx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        localwdx.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = paramString;
        localwdx.a(paramString);
        this.o += 1;
        paramString.jdField_h_of_type_Long = (SystemClock.uptimeMillis() - paramString.jdField_g_of_type_Long);
        if (QLog.isColorLevel()) {
          a(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label265:
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!localwdx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localHttpMsg == null) || (localHttpMsg.b() <= paramString.b())) {
          break;
        }
        localwdx.a();
      }
      i1 += 1;
    }
  }
  
  public void a(wdx paramwdx)
  {
    if (this.d) {}
    int i1;
    do
    {
      do
      {
        return;
      } while (paramwdx == null);
      paramwdx.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      i1 = paramwdx.jdField_a_of_type_Int;
      if ((i1 >= 0) && (i1 < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i1, 5);
        ((HandlerThread)???).start();
        wdx localwdx = new wdx(this, ((HandlerThread)???).getLooper());
        localwdx.jdField_a_of_type_Int = i1;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ArrayOfWdx[i1] = localwdx;
          if (paramwdx.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            this.o -= 1;
          }
          a("replaceNewThread index:" + i1);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i1);
  }
  
  void a(wdx paramwdx, HttpMsg paramHttpMsg)
  {
    if (!this.jdField_c_of_type_Boolean) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramwdx != null) && (paramwdx.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      a(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  void a(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramHttpMsg.a(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramHttpMsg.a(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.a(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = BaseTransProcessor.a("Q", -9531L);
        paramHttpMsg.b(HttpMsg.am, paramHttpURLConnection);
        paramHttpMsg.a(56009, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramHttpMsg.a(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramHttpMsg.a(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramHttpMsg.a(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        if ((paramThrowable instanceof ConnectException))
        {
          paramHttpMsg.a(9052, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramHttpMsg.a(9053, paramInt, paramThrowable.toString());
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramHttpMsg.a(9054, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.a(9051, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramHttpMsg.a(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramHttpMsg.a(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + 45531;
      }
      for (;;)
      {
        paramHttpMsg.a(9047, paramInt, paramThrowable);
        paramHttpMsg.b(HttpMsg.am, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + 45534;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + 45533;
          } else {
            paramHttpURLConnection = "N_" + 45532;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + 45531;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + 45530;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            paramHttpMsg.a(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + 45529;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramHttpMsg.a(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      paramHttpMsg.a(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      paramHttpMsg.a(9059, paramInt, paramHttpURLConnection);
      return;
    }
    paramHttpMsg.a(9322, paramInt, Log.getStackTraceString(paramThrowable));
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public int b()
  {
    return 4;
  }
  
  public int b(HttpMsg paramHttpMsg)
  {
    int i1 = this.m;
    int i2 = -1;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((!this.d) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a() < i1))
        {
          i1 = this.k + 1;
          this.k = i1;
          paramHttpMsg.a(i1);
          this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(paramHttpMsg);
          paramHttpMsg.a().a(paramHttpMsg, null, 0);
          i1 = this.k;
          ??? = new Object();
          paramHttpMsg.jdField_a_of_type_JavaLangObject = ???;
          paramHttpMsg.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
          a("sendMsgSync");
          if (paramHttpMsg.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i1;
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i1 = i2;
        continue;
        paramHttpMsg = finally;
        throw paramHttpMsg;
      }
      catch (InterruptedException paramHttpMsg)
      {
        for (;;)
        {
          paramHttpMsg.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void b()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close.async doclose");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new wdw(this));
  }
  
  void b(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = BaseTransProcessor.b(paramInt, l1);
        paramHttpMsg.b(HttpMsg.am, paramHttpURLConnection);
        paramHttpMsg.a(56009, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = paramHttpMsg.a();
      if ((localIHttpCommunicatorListener instanceof BaseTransProcessor)) {
        ((BaseTransProcessor)localIHttpCommunicatorListener).a(2, 9014, "sscm http timeout");
      }
      paramHttpMsg.a().b(paramHttpMsg, null);
    }
  }
  
  public void c()
  {
    int i1 = 0;
    long l1;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      l1 = System.currentTimeMillis();
      HttpMsg localHttpMsg;
      do
      {
        localHttpMsg = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a(true);
        if (localHttpMsg == null) {
          break;
        }
      } while ((localHttpMsg == null) || (localHttpMsg.a() == null));
      localHttpMsg.a(9366, -1, "httpcommunicator_close");
      localHttpMsg.a().b(localHttpMsg, localHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator$PriorityQueue.a();
    wdx[] arrayOfwdx = this.jdField_a_of_type_ArrayOfWdx;
    int i2 = arrayOfwdx.length;
    while (i1 < i2)
    {
      arrayOfwdx[i1].sendEmptyMessage(1);
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfWdx = null;
    this.o = 0;
    this.n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l1));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\utils\httputils\HttpCommunicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
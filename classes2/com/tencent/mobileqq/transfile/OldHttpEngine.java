package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine
  implements INetEngine
{
  private static volatile int jdField_a_of_type_Int = -1;
  public static final String a = "Q.richmedia.OldHttpEngine";
  HttpCommunicator jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public OldHttpEngine(HttpCommunicator paramHttpCommunicator, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.OldHttpEngine", 2, "construct " + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = paramHttpCommunicator;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private HttpMsg a(NetReq paramNetReq)
  {
    if (paramNetReq == null) {
      return null;
    }
    HttpNetReq localHttpNetReq;
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if ((paramNetReq.j == 0) && ((paramNetReq instanceof HttpNetReq)))
    {
      localHttpNetReq = (HttpNetReq)paramNetReq;
      localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)localHttpNetReq.jdField_a_of_type_JavaLangObject;
      if ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
        return null;
      }
      localObject1 = localHttpNetReq.jdField_a_of_type_JavaLangString;
      if (!localHttpNetReq.jdField_a_of_type_Boolean) {
        break label613;
      }
      localObject3 = InnerDns.a(localHttpNetReq.jdField_a_of_type_JavaLangString);
      localObject2 = InnerDns.a().a((String)localObject3, 1002);
      localObject2 = InnerDns.a(localHttpNetReq.jdField_a_of_type_JavaLangString, (String)localObject2);
      if ((localObject2 == null) || (((String)localObject2).equals(localHttpNetReq.jdField_a_of_type_JavaLangString))) {
        break label613;
      }
      if (!StringUtil.b((String)localObject3)) {
        paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("host", localObject3);
      }
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "NeedIpConnect url=" + localHttpNetReq.jdField_a_of_type_JavaLangString + " ipUrl=" + (String)localObject2);
        localObject1 = localObject2;
      }
    }
    label427:
    label613:
    for (;;)
    {
      localObject2 = new HttpMsg((String)localObject1, localHttpNetReq.jdField_a_of_type_ArrayOfByte, localOldHttpCommunicatorListner);
      if (localHttpNetReq.jdField_c_of_type_Int == 0) {}
      for (localObject1 = "GET";; localObject1 = "POST")
      {
        ((HttpMsg)localObject2).c((String)localObject1);
        localObject1 = localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          ((HttpMsg)localObject2).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
        }
      }
      ((HttpMsg)localObject2).jdField_c_of_type_Boolean = localHttpNetReq.jdField_b_of_type_Boolean;
      ((HttpMsg)localObject2).ai = paramNetReq.d;
      ((HttpMsg)localObject2).jdField_e_of_type_Int = paramNetReq.o;
      ((HttpMsg)localObject2).d = paramNetReq.n;
      ((HttpMsg)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam = localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileRichMediaStrategy$OldEngineDPCProfile$TimeoutParam;
      ((HttpMsg)localObject2).jdField_a_of_type_ArrayOfJavaLangString = localHttpNetReq.jdField_a_of_type_ArrayOfJavaLangString;
      ((HttpMsg)localObject2).f = localHttpNetReq.j;
      ((HttpMsg)localObject2).jdField_e_of_type_Boolean = paramNetReq.g;
      if (jdField_a_of_type_Int == -1) {
        b();
      }
      switch (jdField_a_of_type_Int)
      {
      }
      for (;;)
      {
        if (paramNetReq.m == 1)
        {
          ((HttpMsg)localObject2).jdField_b_of_type_Int = 201;
          if ((localHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) || (localHttpNetReq.jdField_b_of_type_JavaLangString != null)) {
            ((HttpMsg)localObject2).a(true);
          }
          localOldHttpCommunicatorListner.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject2);
        }
        try
        {
          paramNetReq = new URL(((HttpMsg)localObject2).a());
          localObject1 = localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
          ((NetResp)localObject1).jdField_a_of_type_JavaUtilHashMap.put("serverip", paramNetReq.getHost());
          ((NetResp)localObject1).jdField_a_of_type_JavaUtilHashMap.put("param_url", ((HttpMsg)localObject2).a());
          return (HttpMsg)localObject2;
          if (localHttpNetReq.jdField_c_of_type_Boolean)
          {
            ((HttpMsg)localObject2).j = jdField_a_of_type_Int;
            continue;
            ((HttpMsg)localObject2).j = (jdField_a_of_type_Int / 4);
            continue;
            if (paramNetReq.m == 2)
            {
              ((HttpMsg)localObject2).jdField_b_of_type_Int = 202;
              break label427;
            }
            if (paramNetReq.m != 0) {
              break label427;
            }
            ((HttpMsg)localObject2).jdField_b_of_type_Int = 200;
          }
        }
        catch (Exception paramNetReq)
        {
          for (;;)
          {
            paramNetReq.printStackTrace();
          }
        }
      }
      if (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
      {
        paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9302, "not support by HttpOldEngine", null);
        paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
      }
      return null;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return RichMediaStrategy.a(paramInt);
  }
  
  private static String b(NetReq paramNetReq, String paramString1, String paramString2)
  {
    if ((paramNetReq.c != null) && (paramNetReq.c.length() > 0)) {
      return paramNetReq.c;
    }
    return paramString1 + "." + MD5.toMD5(RichMediaUtil.a(paramString2, false)) + ".tmp";
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Int >= 0) {}
    for (;;)
    {
      return;
      Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 5) {}
      }
      try
      {
        jdField_a_of_type_Int = Integer.valueOf(localObject[4]).intValue();
        if (jdField_a_of_type_Int == -1) {
          jdField_a_of_type_Int = 1;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.richmedia.OldHttpEngine", 2, "[initCmwapConnectionTypeFromDpc]: " + jdField_a_of_type_Int);
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public NetResp a(NetReq paramNetReq)
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "destroy " + this);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator = null;
    }
  }
  
  public void a(NetReq paramNetReq)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    Object localObject3;
    if ((paramNetReq != null) && (paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null))
    {
      j = 0;
      localObject1 = localObject2;
      i = j;
      if ((paramNetReq instanceof HttpNetReq))
      {
        localObject3 = (HttpNetReq)paramNetReq;
        localObject1 = localObject2;
        i = j;
        if (((HttpNetReq)localObject3).jdField_c_of_type_Int == 0)
        {
          localObject1 = localObject2;
          i = j;
          if (paramNetReq.jdField_b_of_type_JavaLangString != null)
          {
            localObject1 = b(paramNetReq, paramNetReq.jdField_b_of_type_JavaLangString, ((HttpNetReq)localObject3).jdField_a_of_type_JavaLangString);
            paramNetReq.e = ((String)localObject1);
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(localObject1, localObject1) == null) {
              break label329;
            }
          }
        }
      }
    }
    label190:
    label329:
    for (int i = 1;; i = j)
    {
      if ((paramNetReq.j == 0) && ((paramNetReq instanceof HttpNetReq)))
      {
        localObject2 = (HttpNetReq)paramNetReq;
        ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileNetResp = new NetResp((NetReq)localObject2);
        localObject3 = new OldHttpEngine.OldHttpCommunicatorListner(this);
        ((HttpNetReq)localObject2).jdField_a_of_type_JavaLangObject = localObject3;
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject2);
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_a_of_type_ComTencentMobileqqTransfileNetResp = ((HttpNetReq)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject3).b();
        if ((paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_e_of_type_Int == 2) && (!((OldHttpEngine.OldHttpCommunicatorListner)localObject3).jdField_b_of_type_Boolean)) {
          break label190;
        }
        OldHttpEngine.OldHttpCommunicatorListner.a((OldHttpEngine.OldHttpCommunicatorListner)localObject3);
      }
      do
      {
        return;
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.richmedia.OldHttpEngine", 2, "sendReq:" + paramNetReq + " _id:" + paramNetReq.d + " isDownloading _key:" + (String)localObject1);
          }
          paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_e_of_type_Int = 3;
          OldHttpEngine.OldHttpCommunicatorListner.a((OldHttpEngine.OldHttpCommunicatorListner)localObject3);
          return;
        }
        c(paramNetReq);
        return;
      } while (!QLog.isColorLevel());
      localObject2 = new StringBuilder().append("req:").append(paramNetReq).append(" callback:");
      if (paramNetReq == null) {}
      for (paramNetReq = (NetReq)localObject1;; paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener)
      {
        QLog.e("Q.richmedia.OldHttpEngine", 2, paramNetReq);
        return;
      }
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg != null) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(paramHttpMsg);
    }
  }
  
  public void b(NetReq paramNetReq)
  {
    if (paramNetReq == null) {}
    do
    {
      return;
      if (paramNetReq.e != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramNetReq.e);
      }
    } while (!OldHttpEngine.OldHttpCommunicatorListner.class.isInstance(paramNetReq.jdField_a_of_type_JavaLangObject));
    Object localObject = (HttpNetReq)paramNetReq;
    int i = paramNetReq.o;
    boolean bool;
    if (((HttpNetReq)localObject).jdField_c_of_type_Int == 1) {
      bool = true;
    }
    for (;;)
    {
      RichMediaUtil.a(i, bool, paramNetReq.n, paramNetReq.d, "cancelReq", "");
      localObject = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel())
      {
        QLog.d("OldHttpEngine", 2, "cancelReq ====== listener = " + localObject);
        if (localObject != null) {
          QLog.d("OldHttpEngine", 2, "cancelReq ====== listener.mIsCancelled = " + ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
        }
      }
      if (localObject == null) {
        break;
      }
      ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      HttpMsg localHttpMsg = ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator != null)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpCommunicator.a(localHttpMsg);
      }
      try
      {
        if ((paramNetReq.jdField_b_of_type_JavaLangString != null) && (((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream != null)) {
          ((OldHttpEngine.OldHttpCommunicatorListner)localObject).jdField_a_of_type_JavaIoOutputStream.close();
        }
        ((OldHttpEngine.OldHttpCommunicatorListner)localObject).a();
        return;
        bool = false;
      }
      catch (IOException paramNetReq)
      {
        for (;;)
        {
          paramNetReq.printStackTrace();
        }
      }
    }
  }
  
  public void c(NetReq paramNetReq)
  {
    OldHttpEngine.OldHttpCommunicatorListner localOldHttpCommunicatorListner;
    do
    {
      try
      {
        HttpMsg localHttpMsg1 = a(paramNetReq);
        localOldHttpCommunicatorListner = (OldHttpEngine.OldHttpCommunicatorListner)paramNetReq.jdField_a_of_type_JavaLangObject;
        if ((localHttpMsg1 != null) && (localOldHttpCommunicatorListner != null))
        {
          NetResp localNetResp = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
          localNetResp.h += 1;
          localOldHttpCommunicatorListner.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            a(localHttpMsg1);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          System.gc();
          try
          {
            HttpMsg localHttpMsg2 = a(paramNetReq);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.richmedia.OldHttpEngine", 2, "OOM in makeNewHttpMsgFromNetReq", localOutOfMemoryError2);
            }
            Object localObject = null;
          }
        }
        paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
        paramNetReq.f = 9366;
        paramNetReq.jdField_a_of_type_JavaLangString = "oldengine close";
        paramNetReq.jdField_e_of_type_Int = 1;
        OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
        return;
      }
    } while ((localOldHttpCommunicatorListner == null) || (localOldHttpCommunicatorListner.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()));
    paramNetReq = paramNetReq.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    paramNetReq.f = 9369;
    paramNetReq.jdField_a_of_type_JavaLangString = "Out of memory";
    paramNetReq.jdField_e_of_type_Int = 1;
    OldHttpEngine.OldHttpCommunicatorListner.a(localOldHttpCommunicatorListner);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\OldHttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
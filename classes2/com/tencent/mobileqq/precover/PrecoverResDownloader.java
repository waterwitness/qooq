package com.tencent.mobileqq.precover;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import tuq;

public class PrecoverResDownloader
  implements INetEngine.INetEngineListener
{
  private static INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new tuq();
  public static final String a = "PrecoverResDownloader";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PrecoverManager jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private List jdField_a_of_type_JavaUtilList = new Vector();
  private Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PrecoverResDownloader(QQAppInterface paramQQAppInterface, PrecoverManager paramPrecoverManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager = paramPrecoverManager;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private boolean a(PrecoverResource paramPrecoverResource)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource == null)
      {
        localObject = "null";
        QLog.d("PrecoverResDownloader", 2, new Object[] { "isNeedDownload, resource=", localObject });
      }
    }
    else
    {
      if (paramPrecoverResource != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, "isNeedDownload, resource == null");
      }
    }
    for (;;)
    {
      return false;
      localObject = paramPrecoverResource;
      break;
      label57:
      if (TextUtils.isEmpty(paramPrecoverResource.businessId))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, businessId is empty");
          return false;
        }
      }
      else if (TextUtils.isEmpty(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is empty");
          return false;
        }
      }
      else if (this.jdField_a_of_type_JavaUtilSet.contains(paramPrecoverResource.md5))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverResDownloader", 2, "isNeedDownload, md5 is in set");
          return false;
        }
      }
      else {
        try
        {
          boolean bool = PrecoverUtils.a(paramPrecoverResource.businessId, paramPrecoverResource.md5);
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload. file exist=" + bool + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
          if (!bool) {}
          for (bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Throwable localThrowable)
        {
          QLog.i("PrecoverResDownloader", 1, "isNeedDownload.exception happen.e=" + localThrowable.getMessage() + ", md5=" + paramPrecoverResource.md5 + ", businessid=" + paramPrecoverResource.businessId + ", resId=" + paramPrecoverResource.resId);
        }
      }
    }
    localThrowable.printStackTrace();
    return false;
  }
  
  private boolean b(PrecoverResource paramPrecoverResource)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager.a(paramPrecoverResource));
  }
  
  public PrecoverResDownloader.LongPair a(String paramString)
  {
    return (PrecoverResDownloader.LongPair)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(PrecoverListener paramPrecoverListener)
  {
    if (paramPrecoverListener == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramPrecoverListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramPrecoverListener);
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    Object localObject1 = null;
    if (paramNetReq == null)
    {
      QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, req is null");
      return;
    }
    paramNetReq = paramNetReq.a();
    if ((paramNetReq != null) && ((paramNetReq instanceof Object[])) && (((Object[])paramNetReq).length >= 2))
    {
      localObject1 = (Object[])paramNetReq;
      paramNetReq = (PrecoverResource)localObject1[0];
      localObject1 = localObject1[1];
    }
    for (;;)
    {
      if (paramNetReq == null)
      {
        QLog.d("PrecoverResDownloader", 1, "onUpdateProgeress, resource is null");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverResDownloader", 2, new Object[] { "onUpdateProgeress, resource=", paramNetReq, ", userData=", localObject1, ", currOffSet=", Long.valueOf(paramLong1), ", totalLen=", Long.valueOf(paramLong2) });
      }
      PrecoverResDownloader.LongPair localLongPair = (PrecoverResDownloader.LongPair)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramNetReq.md5);
      Object localObject2 = localLongPair;
      if (localLongPair == null) {
        localObject2 = new PrecoverResDownloader.LongPair();
      }
      ((PrecoverResDownloader.LongPair)localObject2).a = paramLong2;
      ((PrecoverResDownloader.LongPair)localObject2).b = paramLong1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramNetReq.md5, localObject2);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = (PrecoverListener)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject2 != null) {
          ((PrecoverListener)localObject2).a(paramNetReq, localObject1, paramLong1, paramLong2);
        }
        i += 1;
      }
      break;
      paramNetReq = null;
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    int i;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    int j;
    File localFile;
    String str1;
    label55:
    Object localObject2;
    Object localObject3;
    int k;
    if (paramNetResp.e == 0)
    {
      i = 1;
      localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      localObject1 = localHttpNetReq.a();
      j = paramNetResp.f;
      localFile = new File(localHttpNetReq.b);
      if (paramNetResp.jdField_a_of_type_JavaLangString != null) {
        break label442;
      }
      str1 = "0";
      if ((localObject1 == null) || (!(localObject1 instanceof Object[])) || (((Object[])localObject1).length < 3)) {
        break label476;
      }
      localObject2 = (Object[])localObject1;
      localObject1 = (PrecoverResource)localObject2[0];
      localObject2 = localObject2[1];
      if (i == 0) {
        break label450;
      }
      localObject3 = PortalUtils.a(localFile.getAbsolutePath());
      if (((PrecoverResource)localObject1).md5.equalsIgnoreCase((String)localObject3)) {
        break label739;
      }
      k = -6103066;
      localFile.delete();
      i = 0;
      QLog.i("PrecoverResDownloader", 1, "onResp.md5 verify fail.md5=" + ((PrecoverResource)localObject1).md5 + ",calMD5=" + (String)localObject3);
    }
    for (;;)
    {
      j = k;
      int m = i;
      if (i != 0)
      {
        j = k;
        m = i;
        if (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager.a((PrecoverResource)localObject1);
          m = i;
          j = k;
        }
      }
      label226:
      if (this.jdField_a_of_type_JavaUtilSet.contains(((PrecoverResource)localObject1).md5)) {
        this.jdField_a_of_type_JavaUtilSet.remove(((PrecoverResource)localObject1).md5);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(((PrecoverResource)localObject1).md5)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(((PrecoverResource)localObject1).md5);
      }
      i = m;
      label286:
      String str2;
      if (QLog.isColorLevel())
      {
        str2 = localHttpNetReq.jdField_a_of_type_JavaLangString;
        k = paramNetResp.e;
        if (localObject1 != null) {
          break label512;
        }
      }
      label442:
      label450:
      label476:
      label512:
      for (localObject3 = "null";; localObject3 = localObject1)
      {
        QLog.d("PrecoverResDownloader", 2, new Object[] { "onResp.url=", str2, ", result=", Integer.valueOf(k), ", errCode=", Integer.valueOf(j), ", resource=", localObject3 });
        k = 0;
        while (k < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (PrecoverListener)this.jdField_a_of_type_JavaUtilList.get(k);
          if (localObject3 != null) {
            ((PrecoverListener)localObject3).a(j, str1, (PrecoverResource)localObject1, localObject2);
          }
          k += 1;
        }
        i = 0;
        break;
        str1 = paramNetResp.jdField_a_of_type_JavaLangString;
        break label55;
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        m = i;
        break label226;
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        QLog.i("PrecoverResDownloader", 1, "onResp objects == null || objects not instanceof Object[] || ((Object[]) objects).length < 3");
        localObject1 = null;
        localObject2 = null;
        break label286;
      }
      if (i == 0)
      {
        localObject3 = new StringBuilder().append("onResp.url=").append(localHttpNetReq.jdField_a_of_type_JavaLangString).append(", result=").append(paramNetResp.e).append(", errCode=").append(j).append(",md5 = ");
        if (localObject1 == null)
        {
          localObject2 = "null";
          QLog.i("PrecoverResDownloader", 1, (String)localObject2 + ", errDesc=" + str1);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager != null) {
          break label705;
        }
        localObject2 = null;
        label620:
        if ((localObject2 == null) || (localObject1 == null)) {
          break label729;
        }
        if ((paramNetResp.jdField_a_of_type_JavaUtilHashMap == null) || (!paramNetResp.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason"))) {
          break label717;
        }
        paramNetResp = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
        label663:
        if ((i == 0) || (!localFile.exists())) {
          break label723;
        }
      }
      label705:
      label717:
      label723:
      for (long l = localFile.length();; l = 0L)
      {
        ((PrecoverReporter)localObject2).a((PrecoverResource)localObject1, j, str1, paramNetResp, l);
        return;
        localObject2 = ((PrecoverResource)localObject1).md5;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager.a();
        break label620;
        paramNetResp = "0";
        break label663;
      }
      label729:
      QLog.i("PrecoverResDownloader", 1, "onResp，reporter or resource is null");
      return;
      label739:
      k = j;
    }
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject)
  {
    return a(paramPrecoverResource, paramObject, false);
  }
  
  public boolean a(PrecoverResource paramPrecoverResource, Object paramObject, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      if (paramPrecoverResource != null) {
        break label82;
      }
      localObject1 = "null";
      if (paramObject != null) {
        break label88;
      }
    }
    label82:
    label88:
    for (Object localObject2 = "null";; localObject2 = paramObject)
    {
      QLog.d("PrecoverResDownloader", 2, new Object[] { "resource=", localObject1, ", userData=", localObject2, ", checkControl=", Boolean.valueOf(paramBoolean) });
      if (paramPrecoverResource != null) {
        break label94;
      }
      QLog.d("PrecoverResDownloader", 1, "download, resource is null");
      return false;
      localObject1 = paramPrecoverResource;
      break;
    }
    label94:
    if (!paramPrecoverResource.isValid())
    {
      QLog.d("PrecoverResDownloader", 1, "download, resource.isValid() return false");
      return false;
    }
    if (!a(paramPrecoverResource))
    {
      QLog.d("PrecoverResDownloader", 1, "download, isNeedDownload() return false");
      return false;
    }
    if ((paramBoolean) && (!b(paramPrecoverResource)))
    {
      QLog.d("PrecoverResDownloader", 1, "download, canDownload() return false");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramPrecoverResource.md5);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramPrecoverResource.md5, new PrecoverResDownloader.LongPair());
    Object localObject1 = new HttpNetReq();
    ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = paramPrecoverResource.url;
    ((HttpNetReq)localObject1).c = 0;
    ((HttpNetReq)localObject1).b = PrecoverUtils.a(paramPrecoverResource.businessId, paramPrecoverResource.md5);
    ((HttpNetReq)localObject1).m = 2;
    ((HttpNetReq)localObject1).a(new Object[] { paramPrecoverResource, paramObject, Boolean.valueOf(paramBoolean) });
    ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject1);
    return true;
  }
  
  public void b(PrecoverListener paramPrecoverListener)
  {
    if (paramPrecoverListener == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramPrecoverListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\PrecoverResDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
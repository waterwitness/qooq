package com.tencent.mobileqq.precover.ipc;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.precover.PrecoverListener;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverResDownloader;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import tus;

public class PrecoverIPCServer
  implements PrecoverListener
{
  private static PrecoverIPCServer jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCServer;
  public static final String a = "PrecoverIPCServer";
  public static final String b = "PrecoverIPCServer_MODEL";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PrecoverManager jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  
  private PrecoverIPCServer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new tus(this, "PrecoverIPCServer_MODEL");
    if ((BaseApplicationImpl.a().a() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.a().a());
      this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager = ((PrecoverManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(178));
      this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager.a().a(this);
    }
  }
  
  public static PrecoverIPCServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCServer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCServer == null) {
        jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCServer = new PrecoverIPCServer();
      }
      return jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCServer;
    }
    finally {}
  }
  
  private EIPCResult a(Bundle paramBundle, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getString("businessId");
    String str = paramBundle.getString("md5");
    if (TextUtils.isEmpty(str))
    {
      localObject1 = EIPCResult.createResult(10, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverIPCServer", 2, "getResource, md5 emtpy");
      }
      paramBundle.putInt("callbackId", paramInt);
      return (EIPCResult)localObject1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager.b((String)localObject2, str);
      if (localObject1 == null) {
        break label100;
      }
      paramBundle.putParcelable("resource", (Parcelable)localObject1);
      localObject1 = EIPCResult.createSuccessResult(paramBundle);
    }
    for (;;)
    {
      paramBundle.putInt("callbackId", paramInt);
      return (EIPCResult)localObject1;
      label100:
      localObject2 = EIPCResult.createResult(12, paramBundle);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("PrecoverIPCServer", 2, "getResource, RESULT_RESOURCE_NOT_FOUND");
        localObject1 = localObject2;
      }
    }
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
  
  public void a(int paramInt, String paramString, PrecoverResource paramPrecoverResource, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Object[])) && ("PrecoverIPCServer_MODEL".equals(((Object[])(Object[])paramObject)[0])))
    {
      int i = ((Integer)((Object[])(Object[])paramObject)[1]).intValue();
      paramObject = new Bundle();
      ((Bundle)paramObject).putString("key_action", PrecoverIPCConstans.b);
      ((Bundle)paramObject).putParcelable("resource", paramPrecoverResource);
      ((Bundle)paramObject).putInt("errCode", paramInt);
      ((Bundle)paramObject).putString("errDesc", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverIPCServer", 2, "onDownloadFinish, errCode=" + paramInt + ", errDesc=" + paramString + ", resource" + paramPrecoverResource);
      }
      this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule.callbackResult(i, EIPCResult.createSuccessResult((Bundle)paramObject));
    }
  }
  
  public void a(PrecoverResource paramPrecoverResource, Object paramObject, long paramLong1, long paramLong2) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\ipc\PrecoverIPCServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
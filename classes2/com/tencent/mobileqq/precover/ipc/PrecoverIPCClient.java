package com.tencent.mobileqq.precover.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.precover.PrecoverResDownloader.LongPair;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;
import java.util.Vector;
import tur;

public class PrecoverIPCClient
{
  private static PrecoverIPCClient jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCClient;
  public static final String a = "";
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback;
  private List jdField_a_of_type_JavaUtilList;
  
  public PrecoverIPCClient()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new Vector();
    this.jdField_a_of_type_EipcEIPCResultCallback = new tur(this);
  }
  
  public static PrecoverIPCClient a()
  {
    if (jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCClient == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCClient == null) {
        jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCClient = new PrecoverIPCClient();
      }
      return jdField_a_of_type_ComTencentMobileqqPrecoverIpcPrecoverIPCClient;
    }
    finally {}
  }
  
  public PrecoverResource a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "getResource, md5=" + paramString2 + ", businessId=" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return null;
      Bundle localBundle = new Bundle();
      localBundle.putString("md5", paramString2);
      localBundle.putString("businessId", paramString1);
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("PrecoverIPCServer_MODEL", PrecoverIPCConstans.a, localBundle);
    } while ((paramString1 == null) || (!paramString1.isSuccess()));
    return (PrecoverResource)paramString1.data.getParcelable("resource");
  }
  
  public PrecoverResDownloader.LongPair a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "download, md5=" + paramString2 + ", businessId=" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      Bundle localBundle = new Bundle();
      localBundle.putString("md5", paramString2);
      localBundle.putString("businessId", paramString1);
      paramString1 = QIPCClientHelper.getInstance().getClient().callServer("PrecoverIPCServer_MODEL", PrecoverIPCConstans.c, localBundle);
    } while ((paramString1 == null) || (!paramString1.isSuccess()) || (paramString1.data == null));
    paramString2 = new PrecoverResDownloader.LongPair();
    paramString2.a = paramString1.data.getLong("key_total", -1L);
    paramString2.b = paramString1.data.getLong("key_loaded", -1L);
    return paramString2;
  }
  
  public void a(PrecoverIPCListener paramPrecoverIPCListener)
  {
    if (paramPrecoverIPCListener == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramPrecoverIPCListener)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramPrecoverIPCListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "download, md5=" + paramString2 + ", businessId=" + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("md5", paramString2);
    localBundle.putString("businessId", paramString1);
    QIPCClientHelper.getInstance().getClient().callServer("PrecoverIPCServer_MODEL", PrecoverIPCConstans.b, localBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  public void b(PrecoverIPCListener paramPrecoverIPCListener)
  {
    if (paramPrecoverIPCListener == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramPrecoverIPCListener);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\precover\ipc\PrecoverIPCClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.open.downloadnew;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCModule;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import wwj;
import wwk;

public class DownloaderGetCodeServer
{
  private static DownloaderGetCodeServer jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
  public static final String a = "DownloaderWriteCodeIPC";
  public static final String b = "Module_DownloaderGetCodeServer";
  public static final String c = "DownloaderWriteCodeIPC_Action__GetCode";
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  private Map jdField_a_of_type_JavaUtilMap;
  private wwk jdField_a_of_type_Wwk;
  
  private DownloaderGetCodeServer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new wwj(this, "Module_DownloaderGetCodeServer");
    this.jdField_a_of_type_Wwk = new wwk(this, null);
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.a().a() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.a().a();
    }
    return null;
  }
  
  public static DownloaderGetCodeServer a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer == null) {}
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer = new DownloaderGetCodeServer();
      return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeServer;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\DownloaderGetCodeServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
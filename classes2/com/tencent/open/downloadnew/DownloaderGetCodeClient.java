package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.base.LogUtility;
import eipc.EIPCResultCallback;
import wwi;

public class DownloaderGetCodeClient
{
  private static DownloaderGetCodeClient jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
  private static final String jdField_a_of_type_JavaLangString = "DownloaderGetCodeClient";
  private ApkGetCodeListener jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener;
  private EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback;
  
  private DownloaderGetCodeClient()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_EipcEIPCResultCallback = new wwi(this);
  }
  
  public static DownloaderGetCodeClient a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient == null) {}
    try
    {
      jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient = new DownloaderGetCodeClient();
      return jdField_a_of_type_ComTencentOpenDownloadnewDownloaderGetCodeClient;
    }
    finally {}
  }
  
  public void a(ApkGetCodeListener paramApkGetCodeListener)
  {
    this.jdField_a_of_type_ComTencentOpenDownloadnewApkGetCodeListener = paramApkGetCodeListener;
  }
  
  public void a(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("PackageName", paramString);
    localBundle.putInt("VersionCode", paramInt);
    LogUtility.c("DownloaderGetCodeClient", paramString + "_" + paramInt + " begin getApkCode ......");
    QIPCClientHelper.getInstance().callServer("Module_DownloaderGetCodeServer", "DownloaderWriteCodeIPC_Action__GetCode", localBundle, this.jdField_a_of_type_EipcEIPCResultCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\DownloaderGetCodeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
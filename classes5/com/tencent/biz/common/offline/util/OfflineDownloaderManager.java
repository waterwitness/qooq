package com.tencent.biz.common.offline.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OfflineDownloaderManager
{
  private static OfflineDownloaderManager jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloaderManager = new OfflineDownloaderManager();
  private IOfflineDownloader jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = new OfflineDownloader();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static OfflineDownloaderManager a()
  {
    return jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloaderManager;
  }
  
  public IOfflineDownloader a()
  {
    return this.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader;
  }
  
  public void a(IOfflineDownloader paramIOfflineDownloader)
  {
    this.jdField_a_of_type_ComTencentBizCommonOfflineUtilIOfflineDownloader = paramIOfflineDownloader;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\offline\util\OfflineDownloaderManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
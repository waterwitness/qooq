package com.tencent.biz.pubaccount.reactnative;

import com.tencent.bitapp.BitAppAbilityUtils;
import com.tencent.bitapp.bundle.IBundleListener;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.rn.RNAppManager;
import com.tencent.qphone.base.util.QLog;
import hwb;

public class ReadInjoyRNManager
  extends RNAppManager
{
  public static IBundleListener a;
  static IRNPreDownloadListener jdField_a_of_type_ComTencentBitappPreDownloadIRNPreDownloadListener;
  static final String jdField_a_of_type_JavaLangString = ReadInjoyRNManager.class.getSimpleName();
  static boolean jdField_a_of_type_Boolean = true;
  private static AppInterface b;
  public static boolean b;
  public static boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ReadInjoyRNManager(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    jdField_b_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a(jdField_b_of_type_ComTencentCommonAppAppInterface, false, ReadInjoyPackageFactroy.class);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    if (!RNPreDownloadFacade.a()) {}
    do
    {
      do
      {
        return;
        if (!RNAppManager.a(paramAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "other RNapp is running , preLoadBundle exit");
      return;
      if ((jdField_a_of_type_Boolean) && (!jdField_b_of_type_Boolean) && (BitAppAbilityUtils.e())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "preLoadBundle not need");
    return;
    ThreadManager.a(new hwb(paramInt1, paramInt2), 5, null, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((BitAppInstanceManager.mReactInstanceManager != null) && (RNPreDownloadFacade.a())) {
      BitAppInstanceManager.getInstance().onDestroy();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\reactnative\ReadInjoyRNManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
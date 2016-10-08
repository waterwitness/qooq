package com.tencent.mobileqq.nearby.rn;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.uimanager.UIManagerModuleConstantsHelper;
import com.facebook.react.views.text.ReactTextShadowNode;
import com.tencent.bitapp.BitAppAbilityUtils;
import com.tencent.bitapp.bundle.IBundleListener;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.preDownload.IRNPreDownloadListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.rn.QAvatarHelper;
import com.tencent.mobileqq.rn.QQBaseModule;
import com.tencent.mobileqq.rn.RCTAvatarViewManager;
import com.tencent.mobileqq.rn.RNAppManager;
import java.lang.ref.WeakReference;
import tpm;

public class NearbyRNAppManager
  extends RNAppManager
{
  static int jdField_a_of_type_Int;
  public static IBundleListener a;
  public static IRNPreDownloadListener a;
  public static final String a;
  static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  static boolean jdField_a_of_type_Boolean = true;
  public static boolean b;
  public static boolean c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyRNAppManager.class.getSimpleName();
  }
  
  public NearbyRNAppManager(NearbyAppInterface paramNearbyAppInterface)
  {
    super(paramNearbyAppInterface);
    if ((jdField_a_of_type_JavaLangRefWeakReference == null) || (jdField_a_of_type_JavaLangRefWeakReference.get() != paramNearbyAppInterface)) {
      jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyAppInterface);
    }
    float f1 = FontSettingManager.a.density;
    float f2 = FontSettingManager.a.scaledDensity;
    if (f1 > f2)
    {
      ReactTextShadowNode.sExtendWidth = (int)(f1 / f2 * 12.0F);
      if (ReactTextShadowNode.sExtendWidth > 20) {
        ReactTextShadowNode.sExtendWidth = 20;
      }
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "NearbyRNAppManager", Integer.valueOf(ReactTextShadowNode.sExtendWidth), Float.valueOf(f1), Float.valueOf(f2) });
    }
    UIManagerModuleConstantsHelper.addViewManager(RCTAvatarViewManager.class);
    UIManagerModuleConstantsHelper.addViewManager(NearbyScrollViewManager.class);
    a(paramNearbyAppInterface, false, NearbyPackageFactroy.class);
    if ((BitAppInstanceManager.getInstance() != null) && (NearbyUtils.b())) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "pre init BitAppInstanceManager" });
    }
    c = false;
  }
  
  public static AppInterface a()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (AppInterface)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int += 1;
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "enterRN", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public static void a(DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null)
    {
      localBitAppInstanceManager.onResume(paramDefaultHardwareBackBtnHandler);
      QQBaseModule.sendActivityResumeEvent(localBitAppInstanceManager.getCurrentReactContext(), null);
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "resumeRN", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    if (RNAppManager.a(paramAppInterface)) {
      if (NearbyUtils.b()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "other RNapp is running , preLoadBundle exit" });
      }
    }
    do
    {
      return;
      if (NearbyUtils.b()) {
        NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "preLoadBundle", Boolean.valueOf(c), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(SystemClock.elapsedRealtime()) });
      }
      if ((jdField_a_of_type_Boolean) && (!c) && (BitAppAbilityUtils.e())) {
        break;
      }
    } while (!NearbyUtils.b());
    NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "preLoadBundle not need" });
    return;
    ThreadManager.a(new tpm(paramAppInterface, paramInt1, paramInt2), 5, null, false);
  }
  
  public static void b()
  {
    jdField_a_of_type_Int -= 1;
    if (jdField_a_of_type_Int == 0) {
      QAvatarHelper.a();
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "leaveRN", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public static void c()
  {
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null)
    {
      localBitAppInstanceManager.onPause();
      QQBaseModule.sendActivityPauseEvent(localBitAppInstanceManager.getCurrentReactContext(), null);
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a(jdField_a_of_type_JavaLangString, new Object[] { "pauseRN", Integer.valueOf(jdField_a_of_type_Int) });
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c = true;
    BitAppInstanceManager localBitAppInstanceManager = BitAppInstanceManager.getInstance();
    if (localBitAppInstanceManager != null) {
      localBitAppInstanceManager.onDestroy();
    }
    jdField_a_of_type_JavaLangRefWeakReference = null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\rn\NearbyRNAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
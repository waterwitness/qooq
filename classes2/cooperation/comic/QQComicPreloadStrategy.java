package cooperation.comic;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

public class QQComicPreloadStrategy
  extends PluginPreloadStrategy
{
  private static final String d = "QQComicPreloadStrategy";
  public final PluginPreloadReportUtils.HitRateHelper a;
  private boolean b;
  private String e;
  private int i;
  
  QQComicPreloadStrategy(int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.i = 0;
    this.e = "";
    this.jdField_b_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = "comic_plugin.apk";
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper = new PluginPreloadReportUtils.HitRateHelper(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramInt == 6) {
      this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_leba_preload", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
    }
    do
    {
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_activity_preload", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
        return;
      }
    } while (paramInt != 9999);
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("comic_web_preload", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
  }
  
  private String a()
  {
    return this.e;
  }
  
  protected void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("isPreloadProcess", true);
    localIntent.putExtra("preloadEntry", this.jdField_c_of_type_Int);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = "comic_plugin.apk";
    localPluginParams.d = "comic_plugin";
    localPluginParams.jdField_a_of_type_JavaLangString = BaseApplicationImpl.a().a().getAccount();
    localPluginParams.e = "com.qqcomic.app.VipPreloadComicProcess";
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.a(this.i, a(), this.d);
    localPluginParams.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession;
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.a(BaseApplicationImpl.getContext(), localPluginParams);
  }
  
  protected boolean a(PluginPreloader.ExtraResult paramExtraResult)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24|0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length < 4) {}
    }
    for (boolean bool = "1".equals(localObject[2]);; bool = false)
    {
      if (paramExtraResult != null)
      {
        paramExtraResult.jdField_a_of_type_Int = 2;
        if (!bool) {
          break label132;
        }
      }
      label132:
      for (localObject = "preload:ok:dpc";; localObject = "preload:fail:dpc")
      {
        paramExtraResult.jdField_a_of_type_JavaLangString = ((String)localObject);
        paramExtraResult = (QQComicPreloadManager)BaseApplicationImpl.a().a().getManager(141);
        if (paramExtraResult != null)
        {
          paramExtraResult.a();
          if (paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)
          {
            this.jdField_a_of_type_Int = ((PluginPreloadStrategy.PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_c_of_type_Int;
            this.jdField_b_of_type_Boolean = ((PluginPreloadStrategy.PreloadServerParam)paramExtraResult.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_b_of_type_Boolean;
          }
        }
        return bool;
      }
    }
  }
  
  protected boolean b(PluginPreloader.ExtraResult paramExtraResult)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramExtraResult == null) {
      paramExtraResult = new PluginPreloader.ExtraResult();
    }
    for (;;)
    {
      QQComicPreloadManager localQQComicPreloadManager = (QQComicPreloadManager)BaseApplicationImpl.a().a().getManager(141);
      int j;
      if (localQQComicPreloadManager != null) {
        if ((localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null) && (((PluginPreloadStrategy.PreloadServerParam)localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).jdField_a_of_type_Boolean))
        {
          j = 1;
          if (this.jdField_c_of_type_Int != 5) {
            break label213;
          }
          if ((j != 0) && (localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1)) {
            break label159;
          }
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          label100:
          bool2 = bool1;
          if (localQQComicPreloadManager.b.get() != null) {
            this.d = ((PluginPreloadStrategy.PreloadPublicParam)localQQComicPreloadManager.b.get()).jdField_a_of_type_Int;
          }
        }
      }
      for (bool2 = bool1;; bool2 = false)
      {
        this.i = paramExtraResult.jdField_a_of_type_Int;
        this.e = paramExtraResult.jdField_a_of_type_JavaLangString;
        return bool2;
        j = 0;
        break;
        label159:
        if (localQQComicPreloadManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          if (!bool1) {
            break label199;
          }
          paramExtraResult.jdField_a_of_type_Int = 2;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:publicaccount";
          break;
        }
        label199:
        paramExtraResult.jdField_a_of_type_Int = 2;
        paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:publicaccount";
        break label100;
        label213:
        if (this.jdField_c_of_type_Int == 6)
        {
          if ((j != 0) && (localQQComicPreloadManager.b.get() != null))
          {
            bool1 = a((PluginPreloadStrategy.PreloadPublicParam)localQQComicPreloadManager.b.get(), String.valueOf(1113), localQQComicPreloadManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.android.animation", localQQComicPreloadManager.a(), localQQComicPreloadManager.a(), localQQComicPreloadManager.a(), paramExtraResult);
            break label100;
          }
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:normal";
          bool1 = false;
          break label100;
        }
        if (this.jdField_c_of_type_Int == 9999)
        {
          paramExtraResult.jdField_a_of_type_Int = 1;
          paramExtraResult.jdField_a_of_type_JavaLangString = "preload:ok:web";
          break label100;
        }
        paramExtraResult.jdField_a_of_type_Int = 1;
        paramExtraResult.jdField_a_of_type_JavaLangString = "preload:fail:unknownentry";
        bool1 = false;
        break label100;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\QQComicPreloadStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
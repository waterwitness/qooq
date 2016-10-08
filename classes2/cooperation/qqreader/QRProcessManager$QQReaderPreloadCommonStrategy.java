package cooperation.qqreader;

import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.comic.PluginPreloadReportUtils.HitRateHelper;
import cooperation.comic.PluginPreloadStrategy;
import cooperation.comic.PluginPreloader.ExtraResult;

public class QRProcessManager$QQReaderPreloadCommonStrategy
  extends PluginPreloadStrategy
{
  public final PluginPreloadReportUtils.HitRateHelper a;
  private String d;
  
  public QRProcessManager$QQReaderPreloadCommonStrategy(QRProcessManager paramQRProcessManager, int paramInt, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_JavaLangString = "noreason";
    this.jdField_b_of_type_JavaLangString = "com.tencent.mobileqq:tool";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = "qqreaderplugin.apk";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper = new PluginPreloadReportUtils.HitRateHelper(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper.a = new PreloadProcHitPluginSession(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
  }
  
  protected void a()
  {
    this.jdField_d_of_type_JavaLangString = "preload:ok:common";
    QRProcessManager.a(this.jdField_a_of_type_CooperationQqreaderQRProcessManager, this.jdField_a_of_type_CooperationComicPluginPreloadReportUtils$HitRateHelper, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
  }
  
  protected boolean a(PluginPreloader.ExtraResult paramExtraResult)
  {
    boolean bool = QRProcessManager.a(this.jdField_a_of_type_CooperationQqreaderQRProcessManager);
    if (bool) {}
    for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
    {
      this.jdField_d_of_type_JavaLangString = str;
      if (paramExtraResult != null)
      {
        paramExtraResult.jdField_a_of_type_Int = 2;
        paramExtraResult.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      }
      return bool;
    }
  }
  
  protected boolean b(PluginPreloader.ExtraResult paramExtraResult)
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRProcessManager$QQReaderPreloadCommonStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
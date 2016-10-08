import com.tencent.mobileqq.activity.richmedia.PTVOperatingGuideActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class pcv
  implements Runnable
{
  public pcv(PTVOperatingGuideActivity paramPTVOperatingGuideActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPTVOperatingGuideActivity, 232, null, this.jdField_a_of_type_JavaLangString, new pcw(this), null);
    PTVOperatingGuideActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPTVOperatingGuideActivity, localQQCustomDialog);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
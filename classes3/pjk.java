import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class pjk
  implements Runnable
{
  public pjk(ShortVideoPlayActivity paramShortVideoPlayActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, 232, null, this.jdField_a_of_type_JavaLangString, new pjl(this), null);
    ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, localQQCustomDialog);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
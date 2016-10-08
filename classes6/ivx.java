import android.view.WindowManager.BadTokenException;
import com.tencent.biz.qqstory.takevideo.NewStoryRMViewSTInterface;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ivx
  implements Runnable
{
  public ivx(NewStoryRMViewSTInterface paramNewStoryRMViewSTInterface, String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 2002) {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface.a.getString(2131362953);
    }
    localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface.a, 230).setMessage((CharSequence)localObject).setPositiveButton(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface.a.getString(2131362952), new ivy(this));
    try
    {
      ((QQCustomDialog)localObject).setCancelable(false);
      ((QQCustomDialog)localObject).show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.qqstory.record.NewStoryRMViewSTInterface", 2, "", localBadTokenException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
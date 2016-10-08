import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rct
  implements Runnable
{
  public rct(BaseMsgBoxActivity paramBaseMsgBoxActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity.a.a() == -1) && (this.jdField_a_of_type_Boolean)) {
      BaseMsgBoxActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingBaseMsgBoxActivity);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
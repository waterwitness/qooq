import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;

public class gws
  implements Runnable
{
  public gws(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((NetworkUtil.a(MultiVideoEnterPageActivity.a(this.a)) == 0) && (!this.a.jdField_a_of_type_Boolean))
    {
      MultiVideoEnterPageActivity.e(this.a);
      MultiVideoEnterPageActivity.a(this.a, 0, 2130968685);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, this.a.jdField_a_of_type_Long, 22, 0);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
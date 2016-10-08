import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.BlessResultActivity.VideoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.util.MqqWeakReferenceHandler;

public class ofx
  implements Runnable
{
  public ofx(BlessResultActivity paramBlessResultActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessResultActivity$VideoInfo = new BlessResultActivity.VideoInfo(this.a.h);
    this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1000);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ofx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
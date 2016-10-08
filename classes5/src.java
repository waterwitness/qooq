import android.widget.ProgressBar;
import com.tencent.mobileqq.freshnews.MyFreshNewsActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class src
  implements Runnable
{
  public src(MyFreshNewsActivity paramMyFreshNewsActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsActivity.a.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsActivity.a.setVisibility(4);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\src.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
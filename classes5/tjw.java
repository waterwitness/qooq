import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.widget.MonitorSizeChangeHSV.IOnSizeChangeCallback;

public class tjw
  implements MonitorSizeChangeHSV.IOnSizeChangeCallback
{
  public tjw(ChooseInterestTagActivity paramChooseInterestTagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ChooseInterestTagActivity.a(this.a).post(new tjx(this, paramInt1));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
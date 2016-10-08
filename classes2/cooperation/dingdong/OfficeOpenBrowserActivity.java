package cooperation.dingdong;

import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class OfficeOpenBrowserActivity
  extends QQBrowserActivity
{
  public OfficeOpenBrowserActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if ((this.rightViewText != null) && (this.rightViewText.getVisibility() == 0))
    {
      this.rightViewText.setText("");
      this.rightViewText.setVisibility(8);
    }
    return bool;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\OfficeOpenBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
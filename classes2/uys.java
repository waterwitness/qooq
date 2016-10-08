import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;

public class uys
  implements CompoundButton.OnCheckedChangeListener
{
  public uys(ShareAppLogActivity paramShareAppLogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    do
    {
      return;
      new ShareAppLogHelper.LogFile("/data/anr/traces.txt");
    } while (!paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
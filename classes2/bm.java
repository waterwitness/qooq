import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class bm
  implements CompoundButton.OnCheckedChangeListener
{
  public bm(LiteAdvanceActivity paramLiteAdvanceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.a(this.a, paramBoolean);
    LiteAdvanceActivity.a(this.a, LiteAdvanceActivity.a(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
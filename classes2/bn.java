import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.dataline.activities.LiteAdvanceActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class bn
  implements CompoundButton.OnCheckedChangeListener
{
  public bn(LiteAdvanceActivity paramLiteAdvanceActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LiteAdvanceActivity.b(this.a, paramBoolean);
    LiteAdvanceActivity.b(this.a, LiteAdvanceActivity.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.widget.ImageButton;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.util.InputMethodUtil;

public class vip
  implements Runnable
{
  public vip(TroopBarReplyActivity paramTroopBarReplyActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    InputMethodUtil.a(this.a.jdField_a_of_type_AndroidWidgetEditText);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
    this.a.b.setSelected(false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
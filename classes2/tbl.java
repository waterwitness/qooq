import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.utils.DisplayUtils;

public class tbl
  implements Runnable
{
  public tbl(MagicfaceViewController paramMagicfaceViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.c.getLayoutParams();
    localLayoutParams.rightMargin = ((int)DisplayUtils.a(this.a.a.a(), 10.0F));
    this.a.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
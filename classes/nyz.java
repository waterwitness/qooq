import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nyz
  implements Runnable
{
  public nyz(MultiForwardChatPie paramMultiForwardChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MultiForwardChatPie.a(this.a).setVisibility(0);
    MultiForwardChatPie.a(this.a).setText(2131367668);
    this.a.b.setText(this.a.an);
    this.a.w();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
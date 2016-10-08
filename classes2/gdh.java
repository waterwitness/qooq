import android.widget.Button;
import android.widget.ImageView;
import com.tencent.arrange.ui.CreateArrageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gdh
  implements Runnable
{
  public gdh(CreateArrageActivity paramCreateArrageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!CreateArrageActivity.a(this.a)) && (CreateArrageActivity.a(this.a) != null))
    {
      CreateArrageActivity.a(this.a).setVisibility(0);
      CreateArrageActivity.a(this.a).setImageResource(2130838983);
      if (CreateArrageActivity.a(this.a) != null) {
        CreateArrageActivity.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\gdh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
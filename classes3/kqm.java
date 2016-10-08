import android.widget.CursorAdapter;
import com.tencent.mobileqq.activity.BaseSystemActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kqm
  implements Runnable
{
  public kqm(BaseSystemActivity paramBaseSystemActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.getCursor() != null) {
      this.a.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
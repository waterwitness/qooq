import android.app.Dialog;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kjk
  implements Runnable
{
  kjk(kjj paramkjj)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    AddRequestActivity.a(this.a.a).dismiss();
    this.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;

public class uic
  extends UniPayHandler.UniPayUpdateListener
{
  public uic(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update()
  {
    this.a.runOnUiThread(new uid(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
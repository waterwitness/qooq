import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatusEditText;

public class uil
  implements Runnable
{
  public uil(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EditActivity.a(this.a).requestFocus();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
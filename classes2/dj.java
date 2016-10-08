import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class dj
  implements Runnable
{
  public dj(DatalineSessionAdapter paramDatalineSessionAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    DatalineSessionAdapter.a(this.a, true);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
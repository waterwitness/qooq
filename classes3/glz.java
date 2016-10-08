import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.random.ui.RandomMultiActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glz
  implements RandomController.RandomListener
{
  public glz(RandomMultiActivity paramRandomMultiActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.runOnUiThread(new gma(this));
  }
  
  public void b()
  {
    RandomMultiActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.av.random.ui.RandomDoubleActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class glb
  implements RandomController.RandomListener
{
  public glb(RandomDoubleActivity paramRandomDoubleActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.a.runOnUiThread(new glc(this));
  }
  
  public void b()
  {
    RandomDoubleActivity.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\glb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomController.RandomListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

class gkg
  implements Runnable
{
  gkg(gkf paramgkf)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    while (i < this.a.a.a.size())
    {
      ((RandomController.RandomListener)this.a.a.a.get(i)).a();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gkg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
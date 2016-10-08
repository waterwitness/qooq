import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class hhe
  implements Runnable
{
  public hhe(ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((hgp)this.a.get(i)).a();
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
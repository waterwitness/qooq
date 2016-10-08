import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.MyAppApi;

public final class wuz
  implements Runnable
{
  public wuz(Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MyAppApi.a().b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wuz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
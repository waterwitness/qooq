import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class ufi
  implements Runnable
{
  public ufi(SharedPreferences paramSharedPreferences)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.edit().putBoolean("new_red_point_received", true).commit();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ufi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
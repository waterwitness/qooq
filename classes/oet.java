import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oet
  implements Runnable
{
  public oet(LightalkBlueTipsBar paramLightalkBlueTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = LightalkBlueTipsBar.a(this.a).getPreferences();
    if (((SharedPreferences)localObject).getInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).a(), 5) != 5)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("LT_tip_show_times" + LightalkBlueTipsBar.a(this.a).a(), 5);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
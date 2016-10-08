import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mck
  implements Runnable
{
  public mck(QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.getSharedPreferences(this.a.getPackageName() + "_preferences", 4).edit();
    localEditor.putInt("webview_add_fav_guide_show_count", 3);
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
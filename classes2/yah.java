import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.comic.VipComicJumpActivity;

public class yah
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private yah(VipComicJumpActivity paramVipComicJumpActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.c = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    paramContext = paramIntent.getStringExtra("pluginsdk_launchReceiver");
    String str = paramIntent.getAction();
    if (((!TextUtils.isEmpty(str)) && ("com.tencent.mobileqq.PreLoadComicProcess".equals(str))) || ((paramContext != null) && (paramContext.equals("com.qqcomic.app.VipPreloadComicProcess"))))
    {
      if (!this.a.b)
      {
        this.a.a.removeMessages(1004);
        this.a.b = true;
        this.a.c = false;
        this.a.c();
      }
      if (QLog.isColorLevel()) {
        QLog.d(VipComicJumpActivity.e, 2, "comic process has launched");
      }
    }
    while ((this.c == null) || (!this.c.equalsIgnoreCase("comic_plugin.apk"))) {
      return;
    }
    this.e = paramIntent.getStringExtra("pluginsdk_launchActivity");
    this.f = paramIntent.getStringExtra("pluginsdk_extraInfo");
    if (QLog.isColorLevel()) {
      QLog.d(VipComicJumpActivity.e, 2, "LaunchCompletedObserver.onReceive: " + this.c);
    }
    if ((this.f != null) && ("success".equals(this.f))) {
      VipComicJumpActivity.a(this.a, 0);
    }
    for (;;)
    {
      this.a.finish();
      return;
      VipComicJumpActivity.a(this.a, -2);
      if (QLog.isColorLevel()) {
        QLog.d(VipComicJumpActivity.e, 2, "LaunchCompletedObserver.onReceive mExtraInfo: " + this.f);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
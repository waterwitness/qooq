import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ListView;

class liz
  implements Runnable
{
  liz(liy paramliy)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    FontSettingActivity.a(this.a.a).setAdapter(null);
    FontSettingActivity.a(this.a.a).setAdapter(FontSettingActivity.a(this.a.a));
    FontSettingManager.a(this.a.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\liz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.plugin.QZonePluginManger;

public class yoh
  implements Runnable
{
  public yoh(QZonePluginManger paramQZonePluginManger)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    QZonePluginManger.a(this.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yoh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
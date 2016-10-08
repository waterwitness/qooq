import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.readinjoy.ReadInJoyPluginInstallActivity;

public class ysj
  implements Runnable
{
  public ysj(ReadInJoyPluginInstallActivity paramReadInJoyPluginInstallActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ReadInJoyPluginInstallActivity.a(this.a, "initPluginManager");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ysj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
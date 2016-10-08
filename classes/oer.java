import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oer
  implements Runnable
{
  public oer(LightalkBlueTipsBar paramLightalkBlueTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    LightalkBlueTipsBarData localLightalkBlueTipsBarData = LightalkBlueTipsBarData.a();
    if (localLightalkBlueTipsBarData != null)
    {
      this.a.b = localLightalkBlueTipsBarData.e;
      this.a.c = localLightalkBlueTipsBarData.f;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GreetWording;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class qbl
  implements Runnable
{
  public qbl(NearbyGrayTipsManager.GreetWording paramGreetWording1, NearbyGrayTipsManager.GreetWording paramGreetWording2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = NearbyGrayTipsManager.GreetWording.getPath(this.a.id);
    NearbyGrayTipsManager.a(this.a, str);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
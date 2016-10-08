import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper;

public class nzo
  implements Runnable
{
  public nzo(NearbyChatPie paramNearbyChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (!NearbyChatPie.b(this.a)) {
      this.a.j();
    }
    if (this.a.a == null) {
      this.a.a = new NearbyChatFlowerHelper(this.a);
    }
    this.a.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
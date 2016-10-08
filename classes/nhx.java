import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nhx
  implements Runnable
{
  public nhx(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    ArkUIView localArkUIView = this.a.a;
    if (localArkUIView != null) {
      localArkUIView.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
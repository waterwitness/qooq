import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.concurrent.locks.Lock;

public class nik
  implements Runnable
{
  public nik(ArkUIView paramArkUIView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.b.lock();
    if (!ArkUIView.a(this.a).isEmpty())
    {
      Rect localRect = ArkContainerWrapper.a(ArkUIView.a(this.a), ArkUIView.a(this.a));
      this.a.invalidate(localRect.left, localRect.top, localRect.right, localRect.bottom);
      ArkUIView.a(this.a).setEmpty();
    }
    this.a.b.unlock();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
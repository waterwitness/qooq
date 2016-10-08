import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class nig
  implements Runnable
{
  public nig(ArkContainerWrapper paramArkContainerWrapper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.SetContainerCallback(null);
      this.a.a.DetachBitmap(null);
      if (QLog.isColorLevel()) {
        QLog.e("ark.rect", 2, String.format("detachView.3.wrapper: %s", new Object[] { this.a.toString() }));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
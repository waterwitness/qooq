import com.tencent.av.core.IVideoEventListener;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ghe
  implements Runnable
{
  public ghe(VcControllerImpl paramVcControllerImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.mEventListener != null) {
      this.a.mEventListener.b(this.a.mPreviewW, this.a.mPreviewH);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ghe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
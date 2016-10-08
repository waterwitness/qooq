import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gop
  extends OrientationEventListener
{
  public gop(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
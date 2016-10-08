import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.NewStoryCoverMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class ium
  extends SimpleObserver
{
  public ium(NewStoryCoverMgr paramNewStoryCoverMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
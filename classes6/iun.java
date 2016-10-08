import android.graphics.Bitmap;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.NewStoryCoverMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.SimpleObserver;

public class iun
  extends SimpleObserver
{
  public iun(NewStoryCoverMgr paramNewStoryCoverMgr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    SLog.b("NewStoryCoverMgr", "generateCoverPictureBlur success");
  }
  
  public void onError(Error paramError)
  {
    super.onError(paramError);
    SLog.d("NewStoryCoverMgr", "generateCoverPictureBlur failed");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
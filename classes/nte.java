import android.os.Handler;
import android.os.Looper;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class nte
  implements VideoDrawable.OnPlayRepeatListener
{
  AIOGalleryAdapter a;
  
  public nte(AIOGalleryAdapter paramAIOGalleryAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramAIOGalleryAdapter;
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ntf(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
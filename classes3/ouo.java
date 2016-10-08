import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ouo
  implements PreloadImgManager.OnSingleDownloadCallback
{
  public ouo(QzoneHbFragment paramQzoneHbFragment)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void a(Bitmap paramBitmap)
  {
    paramBitmap = QzoneHbFragment.a(this.a).obtainMessage();
    paramBitmap.what = 100;
    QzoneHbFragment.a(this.a).sendMessage(paramBitmap);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ouo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
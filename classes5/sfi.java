import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sfi
  implements FileManagerUtil.IGetVideoCallback
{
  public sfi(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.b(this.a).runOnUiThread(new sfj(this, paramBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
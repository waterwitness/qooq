import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopLocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sgt
  implements FileManagerUtil.IGetVideoCallback
{
  public sgt(TroopLocalVideoFileView paramTroopLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    paramBitmap = TroopLocalVideoFileView.a(this.a, paramBitmap);
    TroopLocalVideoFileView.a(this.a).runOnUiThread(new sgu(this, paramBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfs
  implements FileManagerUtil.IGetVideoCallback
{
  sfs(sfp paramsfp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.g(this.a.a).runOnUiThread(new sft(this, paramBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
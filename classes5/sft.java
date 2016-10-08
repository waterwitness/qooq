import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sft
  implements Runnable
{
  sft(sfs paramsfs, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((LocalVideoFileView.a(this.jdField_a_of_type_Sfs.a.a) != null) && (LocalVideoFileView.a(this.jdField_a_of_type_Sfs.a.a) != null) && (!LocalVideoFileView.a(this.jdField_a_of_type_Sfs.a.a).a()))
    {
      if (Build.VERSION.SDK_INT > 18) {
        LocalVideoFileView.a(this.jdField_a_of_type_Sfs.a.a).setBackground(new BitmapDrawable(LocalVideoFileView.f(this.jdField_a_of_type_Sfs.a.a).getApplication().getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      }
    }
    else {
      return;
    }
    LocalVideoFileView.a(this.jdField_a_of_type_Sfs.a.a).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
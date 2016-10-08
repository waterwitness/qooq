import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.view.SurfaceView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfj
  implements Runnable
{
  sfj(sfi paramsfi, Bitmap paramBitmap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a) != null) && (LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a) != null) && (!LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a).a()))
    {
      if (Build.VERSION.SDK_INT > 17) {
        LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a).setBackground(new BitmapDrawable(LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a).getApplication().getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      }
    }
    else {
      return;
    }
    LocalVideoFileView.a(this.jdField_a_of_type_Sfi.a).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
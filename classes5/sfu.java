import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class sfu
  implements SurfaceHolder.Callback
{
  public sfu(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalVideoFileView", 1, "surfaceChanged is called!,and width:" + paramInt2 + ",height:" + paramInt3);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    int j = 1;
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalVideoFileView", 1, "surfaceCreated is called!");
    }
    LocalVideoFileView.b(this.a, true);
    for (;;)
    {
      try
      {
        paramSurfaceHolder = paramSurfaceHolder.getSurface();
        if (paramSurfaceHolder == null) {
          return;
        }
        if (Build.VERSION.SDK_INT < 14)
        {
          i = 1;
          if (paramSurfaceHolder.isValid()) {
            break label82;
          }
          if ((j == 0) || (i != 0)) {
            break;
          }
          QLog.e("LocalVideoFileView", 1, "Surface is invalid!");
          return;
        }
      }
      catch (Exception paramSurfaceHolder)
      {
        paramSurfaceHolder.printStackTrace();
        return;
      }
      int i = 0;
      continue;
      label82:
      j = 0;
    }
    LocalVideoFileView.d(this.a);
    if (LocalVideoFileView.a(this.a) != 0) {
      LocalVideoFileView.a(this.a).a(LocalVideoFileView.a(this.a));
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    LocalVideoFileView.b(this.a, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("LocalVideoFileView", 1, "surfaceDestroyed is called!");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
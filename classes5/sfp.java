import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class sfp
  implements Runnable
{
  public sfp(LocalVideoFileView paramLocalVideoFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (LocalVideoFileView.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "initVarView delay run, but musicService is null");
      }
      return;
    }
    LocalVideoFileView.a(this.a).a(LocalVideoFileView.a(this.a), new sfq(this));
    if ((LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a))) && (LocalVideoFileView.a(this.a) == 0)) {}
    for (int i = LocalVideoFileView.a(this.a).b();; i = LocalVideoFileView.a(this.a))
    {
      if (LocalVideoFileView.a(this.a).getBackground() == null)
      {
        localObject = new DisplayMetrics();
        LocalVideoFileView.e(this.a).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        int j = ((DisplayMetrics)localObject).widthPixels;
        int k = ((DisplayMetrics)localObject).heightPixels;
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!LocalVideoFileView.a(this.a).a())
        {
          bool1 = bool2;
          if (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a))) {
            bool1 = false;
          }
        }
        FileManagerUtil.a(LocalVideoFileView.a(this.a), bool1, j, k, LocalVideoFileView.a(this.a) * 1000, new sfs(this));
      }
      Object localObject = LocalVideoFileView.a(this.a, i);
      LocalVideoFileView.a(this.a).setText((CharSequence)localObject);
      LocalVideoFileView.a(this.a).setProgress(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
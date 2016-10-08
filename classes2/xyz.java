import android.graphics.Rect;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BScanCodeActivity;

public class xyz
  implements Runnable
{
  public xyz(C2BScanCodeActivity paramC2BScanCodeActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
    {
      this.a.a.setText("摄像头被占用，请稍候");
      return;
    }
    Rect localRect = this.a.a();
    C2BScanCodeActivity.a(this.a).setViewFinder(localRect.left, localRect.top, localRect.right, localRect.bottom);
    C2BScanCodeActivity.a(this.a).b();
    this.a.d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xyz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
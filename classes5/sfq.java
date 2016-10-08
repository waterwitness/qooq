import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView.IGetTotalTime;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class sfq
  implements LocalVideoFileView.IGetTotalTime
{
  sfq(sfp paramsfp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    LocalVideoFileView.d(this.a.a).runOnUiThread(new sfr(this, paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
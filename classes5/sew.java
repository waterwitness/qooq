import android.app.Activity;
import android.text.format.Time;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView.IGetTotalTime;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class sew
  implements LocalVideoFileView.IGetTotalTime
{
  public sew(LocalMusicFileView paramLocalMusicFileView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Time();
    ((Time)localObject).set(paramInt);
    localObject = ((Time)localObject).format("%M:%S");
    LocalMusicFileView.a(this.a).runOnUiThread(new sex(this, (String)localObject, paramInt));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
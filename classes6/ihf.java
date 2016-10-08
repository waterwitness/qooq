import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DumpDialog;
import com.tencent.biz.qqstory.base.preload.IVideoPreloader.OnPreloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

public class ihf
  implements IVideoPreloader.OnPreloadListener
{
  private ihf(DumpDialog paramDumpDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(String paramString1, int paramInt, String paramString2) {}
  
  public void a(String paramString1, int paramInt, String paramString2, ErrorMessage paramErrorMessage)
  {
    if (this.a.a != null) {
      new Handler(Looper.getMainLooper()).post(new ihj(this, paramString1, paramErrorMessage));
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      new Handler(Looper.getMainLooper()).post(new ihh(this, paramString1, paramFile));
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, File paramFile, int paramInt2) {}
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      new Handler(Looper.getMainLooper()).post(new ihg(this, paramString1));
    }
  }
  
  public void b(String paramString1, int paramInt, String paramString2, File paramFile)
  {
    if ((paramInt == 0) && (this.a.a != null)) {
      new Handler(Looper.getMainLooper()).post(new ihi(this, paramString1, paramFile));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
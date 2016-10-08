import android.util.Log;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.LyricViewScrollListener;

public class szr
  implements LyricViewScroll.LyricViewScrollListener
{
  public szr(LyricViewController paramLyricViewController)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt)
  {
    this.a.a = true;
    this.a.d(paramInt);
  }
  
  public void b(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.a.c(paramInt);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\szr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
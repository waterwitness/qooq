import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail;

public class tad
  implements Runnable
{
  public tad(LyricViewInternalDetail paramLyricViewInternalDetail)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\tad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
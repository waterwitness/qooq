import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.BitAppViewGroup;
import com.tencent.bitapp.preDownload.DefaultRNPreDownloadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hdp
  extends DefaultRNPreDownloadListener
{
  public hdp(BitAppViewGroup paramBitAppViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    UiThreadUtil.runOnUiThread(new hdq(this));
  }
  
  public void a(int paramInt)
  {
    UiThreadUtil.runOnUiThread(new hdr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\hdp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
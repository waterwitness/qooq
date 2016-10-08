import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class iay
  implements VideoPlayManager.VideoStatusListener
{
  public iay(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    ReadInJoyBaseAdapter.a(this.a).postDelayed(new iaz(this, paramVideoPlayParam), 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
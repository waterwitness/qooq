import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class hzy
  implements Runnable
{
  hzy(hzu paramhzu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (VideoPlayManager.a(this.a.a) != null) {
      VideoPlayManager.a(this.a.a).a(VideoPlayManager.a(this.a.a));
    }
    this.a.a.b(0);
    if (VideoPlayManager.a(this.a.a) != null)
    {
      if (VideoPlayManager.a(this.a.a).a != null) {
        VideoPlayManager.a(this.a.a).a.setVisibility(0);
      }
      if (VideoPlayManager.a(this.a.a).jdField_b_of_type_AndroidWidgetFrameLayout != null) {
        VideoPlayManager.a(this.a.a).jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      VideoPlayManager.a(this.a.a).d = -1;
      VideoPlayManager.a(this.a.a).jdField_b_of_type_Long = 0L;
      VideoPlayManager.a(this.a.a, null);
    }
    if (VideoPlayManager.a(this.a.a) != null)
    {
      VideoPlayManager.a(this.a.a).l();
      VideoPlayManager.a(this.a.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
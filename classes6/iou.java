import android.util.SparseArray;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.playvideo.CustomViewPager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.GestureHandler;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.SwitchVideoListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoControlListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class iou
  extends GestureDetector.SimpleOnGestureListener
{
  static final double jdField_a_of_type_Double = 0.5235987755982988D;
  
  private iou(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f2;
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      if (Math.abs(f1) <= Math.abs(f2)) {
        break label123;
      }
      if (Math.abs(Math.asin(Math.abs(f2) / Math.sqrt(f2 * f2 + f1 * f1))) < 0.5235987755982988D)
      {
        if (f1 >= 0.0F) {
          break label108;
        }
        StoryPlayVideoActivity.a(this.a).a();
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      label108:
      StoryPlayVideoActivity.a(this.a).d();
      continue;
      label123:
      if (f2 > 0.0F) {
        StoryPlayVideoActivity.a(this.a).b();
      } else {
        StoryPlayVideoActivity.a(this.a).c();
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.b(this.a.K);
    if (this.a.K == StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() - 1)
    {
      if (StoryPlayVideoActivity.a(this.a))
      {
        this.a.c();
        this.a.a();
      }
      for (;;)
      {
        paramMotionEvent = this.a;
        paramMotionEvent.K += 1;
        return false;
        this.a.f = true;
      }
    }
    ReportController.b(this.a.app, "dc00899", "grp_story", "", "play_video", "clk_next", 0, 0, "1", "", "", "");
    StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter, -1);
    paramMotionEvent = this.a;
    paramMotionEvent.K += 1;
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$SwitchVideoListener.a(this.a.K);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setCurrentItem(this.a.K, false);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iou.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
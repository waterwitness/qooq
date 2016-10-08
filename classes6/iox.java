import android.os.Handler;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class iox
  implements Runnable
{
  private iox(StoryPlayVideoActivity paramStoryPlayVideoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 20L);
    Object localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
    int i1;
    int i2;
    int i;
    int k;
    int n;
    int j;
    int m;
    int i3;
    if (localObject != null)
    {
      i1 = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
      i2 = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      i = StoryPlayVideoActivity.c(this.a);
      k = 0;
      n = StoryPlayVideoActivity.b(this.a);
      j = this.a.K;
      if ((i2 > 0) && (((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0)) {
        ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(4);
      }
      if (this.a.J != 4) {
        break label397;
      }
      k = j;
      j = i;
      m = 0;
      i = k;
      k = m;
      if (k >= this.a.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label667;
      }
      localObject = (iow)this.a.jdField_a_of_type_JavaUtilArrayList.get(k);
      i3 = ((iow)localObject).jdField_a_of_type_Int;
      m = ((iow)localObject).b;
      if (i - i3 >= 0) {
        break label377;
      }
      j = 0;
      n = 0;
      if (n < i)
      {
        if (n < ((iow)localObject).jdField_a_of_type_JavaUtilArrayList.size())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((iow)localObject).jdField_a_of_type_JavaUtilArrayList.get(n);
          j = (int)(j + localStoryVideoItem.mVideoDuration);
        }
        for (;;)
        {
          n += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "RefreshProgressRunnable index out of bound,j = " + n + ", friendData.mStoryVideoItemList.size() = " + ((iow)localObject).jdField_a_of_type_JavaUtilArrayList.size() + ", friendData.mTotalVideoCount = " + ((iow)localObject).jdField_a_of_type_Int + ",i = " + k + ", mRecentFriendStoryDataList.size() = " + this.a.jdField_a_of_type_JavaUtilArrayList.size());
          }
        }
      }
      k = j + i2;
      j = i3;
    }
    for (;;)
    {
      label343:
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(j);
      if (i2 > i1) {}
      for (n = i1;; n = i2)
      {
        if ((n < 0) || (i1 <= 0))
        {
          return;
          label377:
          k += 1;
          i -= i3;
          j = m;
          break;
          label397:
          m = 0;
          while (m < this.a.K)
          {
            localObject = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(m);
            k = (int)(k + ((StoryVideoItem)localObject).mVideoDuration);
            m += 1;
          }
          n = StoryPlayVideoActivity.b(this.a);
          m = i;
          i = j;
          k += i2;
          j = n;
          break label343;
        }
        if ((StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() == 1) || (j <= 1))
        {
          this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(i, n * 100 / i1);
          return;
        }
        float f1 = k / m;
        float f2 = n / i1;
        k = j - i;
        j = k;
        if (k > 99) {
          j = 99;
        }
        if (j == 1) {
          f1 = 1.0F;
        }
        for (;;)
        {
          if ((this.a.J == 3) || (this.a.J == 7))
          {
            f1 = 1.0F;
            this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setShowMaxCount(1);
          }
          this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(i, n * 100 / i1);
          if ((f1 == 0.0F) || (f2 == 0.0F) || (f1 > 1.0F) || (f2 <= 1.0F)) {
            break;
          }
          return;
        }
      }
      label667:
      k = 0;
      m = j;
      j = n;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\iox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
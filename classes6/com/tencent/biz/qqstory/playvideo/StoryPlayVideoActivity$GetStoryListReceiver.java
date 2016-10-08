package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import iot;
import iow;
import java.util.ArrayList;
import java.util.List;

public class StoryPlayVideoActivity$GetStoryListReceiver
  extends QQUIEventReceiver
{
  public StoryPlayVideoActivity$GetStoryListReceiver(StoryPlayVideoActivity paramStoryPlayVideoActivity1, StoryPlayVideoActivity paramStoryPlayVideoActivity2)
  {
    super(paramStoryPlayVideoActivity2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(StoryPlayVideoActivity paramStoryPlayVideoActivity, DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent paramPlayerVideoListEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, "GetStoryListReceiver");
    }
    if (!this.a.t.equals(paramPlayerVideoListEvent.jdField_a_of_type_JavaLangString)) {}
    label859:
    label1190:
    do
    {
      long l;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
              if (paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
              {
                if (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() > 0)
                {
                  this.a.c = true;
                  return;
                }
                if (paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode == 880001)
                {
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(0);
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnRetryClickListener(new iot(this));
                }
                for (;;)
                {
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
                  return;
                  if ((this.a.J == 6) || (this.a.J == 9) || (this.a.J == 10))
                  {
                    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
                    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setText("该话题已下线");
                  }
                }
              }
              this.a.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry = paramPlayerVideoListEvent.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry;
              if ((paramPlayerVideoListEvent.jdField_b_of_type_Boolean == true) && (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() == 0))
              {
                if (this.a.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry != null)
                {
                  this.a.c();
                  this.a.a();
                  return;
                }
                if (this.a.J == 8)
                {
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView = new ContentEmptyView(this.a, this.a.jdField_b_of_type_Long, this.a.u);
                  if (this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null) {
                    this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, this.a.jdField_b_of_type_Boolean);
                  }
                  this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcViewContentEmptyView, -1, -1);
                }
                if ((this.a.J == 3) || (this.a.J == 7))
                {
                  paramStoryPlayVideoActivity = (StoryManager)SuperManager.a(5);
                  paramPlayerVideoListEvent = paramStoryPlayVideoActivity.a(this.a.A);
                  if (paramPlayerVideoListEvent != null)
                  {
                    paramPlayerVideoListEvent.mHasRelatedVideo = 0;
                    paramStoryPlayVideoActivity.a(this.a.A, paramPlayerVideoListEvent);
                  }
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
                  return;
                }
                if ((this.a.J == 6) || (this.a.J == 9) || (this.a.J == 10))
                {
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setText("该话题已下线");
                  this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
                  return;
                }
                if (this.a.J == 4) {}
                this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
                return;
              }
              if ((paramPlayerVideoListEvent.jdField_a_of_type_Boolean) || (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() != 0)) {
                break;
              }
              if ((this.a.J == 3) || (this.a.J == 7))
              {
                paramStoryPlayVideoActivity = (StoryManager)SuperManager.a(5);
                paramPlayerVideoListEvent = paramStoryPlayVideoActivity.a(this.a.A);
                if (paramPlayerVideoListEvent != null)
                {
                  paramPlayerVideoListEvent.mHasRelatedVideo = 0;
                  paramStoryPlayVideoActivity.a(this.a.A, paramPlayerVideoListEvent);
                }
                this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
                return;
              }
              if ((this.a.J == 6) || (this.a.J == 9) || (this.a.J == 10))
              {
                this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
                this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setText("该话题已下线");
              }
              this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
            } while (!QLog.isColorLevel());
            QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "奇怪的事情发生了,不应该进到这里, mVideoMode:" + this.a.J + ",uin:" + this.a.jdField_b_of_type_Long);
            return;
            l = paramPlayerVideoListEvent.jdField_a_of_type_Long;
          } while ((paramStoryPlayVideoActivity != this.a) || (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList == null) || (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList.size() <= 0));
          if (this.a.J != 4) {
            break;
          }
        } while (this.a.T >= this.a.jdField_a_of_type_JavaUtilArrayList.size());
        paramStoryPlayVideoActivity = (iow)this.a.jdField_a_of_type_JavaUtilArrayList.get(this.a.T);
      } while ((paramStoryPlayVideoActivity.jdField_a_of_type_Long != l) || (paramStoryPlayVideoActivity.jdField_a_of_type_Boolean));
      if (paramStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList == null)
      {
        paramStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        if (paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList != null) {
          paramStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.addAll(paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList);
        }
        paramStoryPlayVideoActivity.b = ((int)paramPlayerVideoListEvent.c);
        paramStoryPlayVideoActivity.jdField_a_of_type_Int = paramPlayerVideoListEvent.jdField_a_of_type_Int;
        paramStoryPlayVideoActivity.jdField_a_of_type_Boolean = paramPlayerVideoListEvent.jdField_b_of_type_Boolean;
        if (paramStoryPlayVideoActivity.jdField_a_of_type_Boolean)
        {
          paramStoryPlayVideoActivity = this.a;
          paramStoryPlayVideoActivity.T += 1;
          if (this.a.T < this.a.jdField_a_of_type_ArrayOfLong.length)
          {
            paramStoryPlayVideoActivity = new iow(null);
            paramStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            paramStoryPlayVideoActivity.jdField_a_of_type_Long = this.a.jdField_a_of_type_ArrayOfLong[this.a.T];
            this.a.jdField_a_of_type_JavaUtilArrayList.add(paramStoryPlayVideoActivity);
            this.a.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(4, paramStoryPlayVideoActivity.jdField_a_of_type_Long, this.a.t);
            this.a.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
          }
        }
      }
      for (;;)
      {
        this.a.e = true;
        if (this.a.J != 4) {
          break label1190;
        }
        StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).clear();
        int i = 0;
        while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
        {
          StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).addAll(((iow)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaUtilArrayList);
          i += 1;
        }
        paramStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.clear();
        break label859;
        if (this.a.c) {
          break;
        }
        this.a.jdField_b_of_type_JavaUtilList = paramPlayerVideoListEvent.jdField_a_of_type_JavaUtilList;
        StoryPlayVideoActivity.a(this.a, (int)paramPlayerVideoListEvent.c);
        StoryPlayVideoActivity.b(this.a, paramPlayerVideoListEvent.jdField_a_of_type_Int);
        this.a.c = paramPlayerVideoListEvent.jdField_b_of_type_Boolean;
      }
      StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).clear();
      StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).addAll(this.a.jdField_b_of_type_JavaUtilList);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.notifyDataSetChanged();
      this.a.f = false;
      this.a.e = false;
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 20L);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(StoryPlayVideoActivity.a(this.a));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(StoryPlayVideoActivity.a(this.a), 20L);
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(StoryPlayVideoActivity.b(this.a));
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(0);
    } while ((StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter) == null) || (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() <= 0));
    this.a.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter));
  }
  
  public Class acceptEventClass()
  {
    return DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent.class;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$GetStoryListReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
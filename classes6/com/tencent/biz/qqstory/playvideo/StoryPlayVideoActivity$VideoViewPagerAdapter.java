package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.HotTopicItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatchVideoHandler;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.qphone.base.util.QLog;
import iov;
import iow;
import ioy;
import ioz;
import ipa;
import ipb;
import ipc;
import ipd;
import ipf;
import iph;
import ipj;
import ipk;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryPlayVideoActivity$VideoViewPagerAdapter
  extends PagerAdapter
  implements ViewPager.OnPageChangeListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private WatchVideoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler;
  public StoryNewGuideDialog a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public StoryPlayVideoActivity$VideoViewPagerAdapter(StoryPlayVideoActivity paramStoryPlayVideoActivity, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler = new WatchVideoHandler();
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private int a(long paramLong)
  {
    return (int)((System.currentTimeMillis() - paramLong) * 100L / 86400000L);
  }
  
  private void a(int paramInt)
  {
    Object localObject2 = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject2 == null) {}
    TextureVideoView localTextureVideoView;
    Object localObject1;
    ImageView localImageView;
    QQStoryLoadingView localQQStoryLoadingView;
    StoryVideoItem localStoryVideoItem;
    do
    {
      return;
      localTextureVideoView = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
      localObject1 = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView;
      localImageView = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_f_of_type_AndroidWidgetImageView;
      localQQStoryLoadingView = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView;
      localObject2 = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView;
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "start play  index = " + paramInt + ", mCurrentIndex = " + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K + ", mIsPlaying=" + localStoryVideoItem.mIsPlaying);
      }
    } while (paramInt != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
    if (localStoryVideoItem.mIsPlaying == 0)
    {
      localTextureVideoView.setVisibility(0);
      ((ImageView)localObject1).setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.mVideoUrl, localStoryVideoItem.mLocalVideoPath);
      if ((localObject1 == null) || (!((String)localObject1).startsWith("file://"))) {
        break label824;
      }
      localObject1 = ((String)localObject1).substring(7);
    }
    label721:
    label824:
    for (;;)
    {
      localTextureVideoView.setOnInfoListener(new ioy(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, paramInt, localTextureVideoView, localImageView, localQQStoryLoadingView));
      localTextureVideoView.setOnPreparedListener(new iov(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, paramInt, localImageView, localQQStoryLoadingView));
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "只有网络url, 等待下载， vid:" + localStoryVideoItem.mVid + ",videoUrl:" + localStoryVideoItem.mVideoUrl);
        }
        StoryPlayVideoActivity.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, System.currentTimeMillis());
        localQQStoryLoadingView.setVisibility(0);
        return;
      }
      localTextureVideoView.setVideoPath((String)localObject1);
      localQQStoryLoadingView.setVisibility(4);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "prepared video. vid = " + localStoryVideoItem.mVid + " localPath = " + localStoryVideoItem.mLocalVideoPath);
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "storyVideoItemIndex = " + paramInt + ", mCurrentIndex = " + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "storyVideoItem.mIsPlaying = " + localStoryVideoItem.mIsPlaying + ", mIsVideoListEnd = " + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_c_of_type_Boolean);
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "before start time:" + System.currentTimeMillis());
      }
      localTextureVideoView.start();
      localStoryVideoItem.mIsPlaying = 1;
      int j;
      int i;
      int k;
      if ((localStoryVideoItem.mOwnerUid != QQStoryContext.a().a()) && (localStoryVideoItem.mOwnerUid != 0L))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 4)
        {
          j = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K;
          i = 0;
          if (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.size())
          {
            k = ((iow)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int;
            if (j - k >= 0) {
              break label721;
            }
            if (j + 1 == k) {
              StoryListUtils.a(((iow)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long);
            }
          }
        }
        this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerWatchVideoHandler.a(localStoryVideoItem.mVid, localStoryVideoItem.mOwnerUid);
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "Do play video. vid = " + localStoryVideoItem.mVid + " localPath = " + localStoryVideoItem.mLocalVideoPath);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_AndroidOsHandler.post(new ioz(this, localQQStoryLoadingView, (QQStoryVideoPlayerErrorView)localObject2, paramInt, localStoryVideoItem));
        return;
        j -= k;
        i += 1;
        break;
        if (localStoryVideoItem.mIsPlaying == 2)
        {
          localTextureVideoView.setVisibility(4);
          ((ImageView)localObject1).setVisibility(4);
          localTextureVideoView.start();
          localStoryVideoItem.mIsPlaying = 1;
        }
        else if ((localStoryVideoItem.mIsPlaying == 1) && (!localTextureVideoView.isPlaying()))
        {
          localTextureVideoView.start();
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "Do play video. not playing, start, videoIndex:" + paramInt);
          }
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.isResume()) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$SwitchVideoListener.a(paramInt);
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "onPageSelected: i:" + paramInt + ", i >= mStoryVideoItems.size(=" + this.jdField_a_of_type_JavaUtilList.size() + ")");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.j(paramInt);
        if (!StoryPlayVideoActivity.a((StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)))
        {
          if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K >= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K < this.jdField_a_of_type_AndroidUtilSparseArray.size()))
          {
            localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
            if (localObject != null)
            {
              localObject = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
              if (((TextureVideoView)localObject).isPlaying()) {
                ((TextureVideoView)localObject).a();
              }
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K = paramInt;
          Object localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
          if ((localObject != null) && (((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null))
          {
            a(paramInt);
            QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "onPageSelected:start play");
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(StoryPlayVideoActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity));
          localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt - 1);
          if (localObject != null)
          {
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(8);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
            ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt - 1)).mIsPlaying = 0;
          }
          localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt + 1);
          if (localObject != null)
          {
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVisibility(8);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
            ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt + 1)).mIsPlaying = 0;
          }
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null)
          {
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 4) {
              break label556;
            }
            int j = paramInt;
            while (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.size())
            {
              localObject = (iow)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaUtilArrayList.get(i);
              if (j - ((iow)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0)
              {
                j -= ((iow)localObject).jdField_a_of_type_JavaUtilArrayList.size();
                i += 1;
              }
              else if (!((iow)localObject).jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b(j);
              }
            }
          }
          while (QLog.isColorLevel())
          {
            QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "onPageSelected end time:" + System.currentTimeMillis() + ", index:" + paramInt);
            return;
            label556:
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b(paramInt);
          }
        }
      }
    }
  }
  
  public StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.size() <= this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K) {
      return null;
    }
    return (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
  }
  
  public String a(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark)) {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark;
      }
      String str;
      do
      {
        return (String)localObject;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick)) {
          return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick;
        }
        str = QQStoryContext.a().a(String.valueOf(paramLong));
        localObject = str;
      } while (!TextUtils.isEmpty(str));
    }
    do
    {
      return null;
      localObject = ((UserManager)SuperManager.a(2)).c(paramLong);
      if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).remark))) {
        return ((QQUserUIItem)localObject).remark;
      }
      if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        return ((QQUserUIItem)localObject).nickName;
      }
      localObject = QQStoryContext.a().a(String.valueOf(paramLong));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    return (String)localObject;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.S = paramInt2;
    StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localVideoViewHolder == null) {
      return;
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(paramInt1);
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.g.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        return;
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    case 5: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.g.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        return;
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    case 1: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.g.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
      {
        if (localStoryVideoItem.hasRelativeVideo())
        {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
          localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      return;
    case 2: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.g.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(0);
      return;
    case 4: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.g.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 6: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.g.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        return;
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    case 7: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841529);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.g.setText("分享");
      localVideoViewHolder.g.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x)) {
        localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
        if (TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
          break label1167;
        }
        if (!localStoryVideoItem.hasRelativeVideo()) {
          break;
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
        localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      return;
    case 8: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.g.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
      {
        if (localStoryVideoItem.hasRelativeVideo())
        {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
          localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      return;
    case 9: 
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130841529);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      localVideoViewHolder.g.setText("分享");
      localVideoViewHolder.g.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
      if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
      {
        if (localStoryVideoItem.hasRelativeVideo())
        {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
          localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
          return;
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      return;
    case 10: 
      label1167:
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localVideoViewHolder.g.setVisibility(8);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
      localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x)) {
        localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
        if (TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
          break label1735;
        }
        if (!localStoryVideoItem.hasRelativeVideo()) {
          break;
        }
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
        localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      label1735:
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      return;
    }
    localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    localVideoViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    localVideoViewHolder.g.setVisibility(8);
    localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setVisibility(8);
    localVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localVideoViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setVisibility(4);
    if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
    {
      if (localStoryVideoItem.hasRelativeVideo())
      {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(0);
        localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
      localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    localVideoViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(4);
    localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setVisibility(4);
  }
  
  public void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K) {}
    StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder;
    StoryConfigManager localStoryConfigManager;
    do
    {
      do
      {
        do
        {
          return;
          localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        } while (localVideoViewHolder == null);
        localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
        if ((localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.getVisibility() == 0) && (paramStoryVideoItem.hasRelativeVideo()) && (!localStoryConfigManager.b()))
        {
          localVideoViewHolder.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new ipb(this, localVideoViewHolder), 3000L);
          localStoryConfigManager.b(true);
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.getCount() <= 1) || (localStoryConfigManager.a()));
      if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)) {
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog != null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog = new StoryNewGuideDialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.a("左右滑动可切换日迹");
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.setOnDismissListener(new ipc(this, localVideoViewHolder));
    this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.show();
    localStoryConfigManager.a(true);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramStoryVideoItem);
  }
  
  public void a(StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramVideoViewHolder == null) || (paramQQUserUIItem == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramQQUserUIItem.remark)) {
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.remark);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, paramVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView, null, paramQQUserUIItem.headUrl, true);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null) || (!HttpUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.authTypeIcon))) {
        break;
      }
      StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getResources(), paramVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.authTypeIcon);
      return;
      paramVideoViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQUserUIItem.nickName);
    }
  }
  
  public void a(String paramString, File paramFile)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.size())
      {
        if (!paramString.equals(((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(i)).mVid)) {
          break label120;
        }
        if (paramFile != null)
        {
          ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(i)).mLocalVideoPath = paramFile.getPath();
          ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(i)).mIsPlaying = 0;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K == i) {
          a(i);
        }
      }
      return;
      label120:
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.size())
      {
        if (!paramString1.equals(((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(i)).mVid)) {
          break label103;
        }
        StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localVideoViewHolder != null)
        {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(0);
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnRetryClickListener(new ipa(this, localVideoViewHolder, paramString1, paramString2));
        }
      }
      return;
      label103:
      i += 1;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.notifyDataSetChanged();
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (!localStoryVideoItem.mVid.equals(paramString)) {
          break label93;
        }
        this.jdField_a_of_type_JavaUtilList.remove(localStoryVideoItem);
        StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity);
        bool1 = bool2;
        if (i == this.jdField_a_of_type_JavaUtilList.size()) {
          bool1 = true;
        }
      }
      return bool1;
      label93:
      i += 1;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    paramViewGroup.removeView((View)paramObject);
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_AndroidUtilSparseArray.size()))
    {
      paramViewGroup = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)) {
        paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
      }
      if ((paramViewGroup != null) && (paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView != null)) {
        paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.c();
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
        ((StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).mIsPlaying = 0;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, null);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.e) {
      return -1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = (View)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (localObject1 != null) {
        break label2073;
      }
      localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904503, paramViewGroup, false);
      localObject1 = new StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302980));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302972));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131302982));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302983));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_e_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302985));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).g = ((TextView)((View)localObject2).findViewById(2131302984));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302977));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131302973));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131300662));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131302979));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView = ((StoryDownloadView)((View)localObject2).findViewById(2131302981));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131302933));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131302978));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView = ((ExploreAnimalView)((View)localObject2).findViewById(2131302986));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)((View)localObject2).findViewById(2131302976));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)((View)localObject2).findViewById(2131302968));
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131302987));
      localObject3 = (LinearLayout)((View)localObject2).findViewById(2131302971);
      localObject4 = new TextureVideoView(paramViewGroup.getContext());
      ((LinearLayout)localObject3).addView((View)localObject4, -1, -1);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = ((TextureVideoView)localObject4);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject3);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setWhiteMode(true);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).g.setOnClickListener(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView.setOnClickListener(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setOnClickListener(this);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      ((View)localObject2).setTag(localObject1);
    }
    for (;;)
    {
      localObject4 = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)((View)localObject2).getTag();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView);
      ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_Int = paramInt;
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localObject1 = null;
      localObject3 = null;
      if (StoryPlayVideoActivity.a(localStoryVideoItem))
      {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
        switch (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J)
        {
        default: 
          a(paramInt, 1);
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 2) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_Boolean)) {
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_d_of_type_AndroidWidgetImageView.performClick();
        }
        paramViewGroup.addView((View)localObject2, -1, -1);
        return localObject2;
        localObject1 = null;
        break;
        localStoryVideoItem.mIsPlaying = 0;
        QQStoryContext.a();
        localObject3 = (UserManager)SuperManager.a(2);
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 1) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 2))
        {
          localObject1 = ((UserManager)localObject3).c(localStoryVideoItem.mOwnerUid);
          if ((localObject1 != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject1).remark)))
          {
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject1).remark);
            label682:
            ThreadManager.a(new ipd(this, localStoryVideoItem, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4), 8, null, true);
            label701:
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_c_of_type_AndroidWidgetTextView.setText(StoryListUtils.a(localStoryVideoItem.mCreateTime));
            StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4, localStoryVideoItem.mVideoWidth, localStoryVideoItem.mVideoHeight);
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_f_of_type_AndroidWidgetImageView, localStoryVideoItem.mVideoLocalThumbnailPath, localStoryVideoItem.mVideoThumbnailUrl, false);
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetImageView, localStoryVideoItem.mLocalMaskPath, localStoryVideoItem.getDownloadMaskUrl(), false);
            if (QLog.isDevelopLevel())
            {
              QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "azrael: setCover: localPath = " + localStoryVideoItem.mVideoLocalThumbnailPath + ", url=" + localStoryVideoItem.mVideoThumbnailUrl);
              QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "azrael: setMask: localPath = " + localStoryVideoItem.mLocalMaskPath + ", url=" + localStoryVideoItem.getDownloadMaskUrl());
            }
            if (!TextUtils.isEmpty(localStoryVideoItem.mLabel))
            {
              ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_d_of_type_AndroidWidgetTextView.setText(String.format("#%s", new Object[] { localStoryVideoItem.mLabel }));
              ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.setText(String.format("探索 #%s", new Object[] { localStoryVideoItem.mLabel }));
            }
            if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 3) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 7)) {
              break label1840;
            }
            if (!TextUtils.isEmpty(localStoryVideoItem.mLabel)) {
              ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_e_of_type_AndroidWidgetTextView.setText(String.format("#%s", new Object[] { localStoryVideoItem.mLabel }));
            }
            label1013:
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject4);
            localObject3 = new ipk(this, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4, paramInt);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setText(StoryVideoItem.getViewCountString(localStoryVideoItem.mViewCount));
            if (localStoryVideoItem.mViewCount == 0) {
              break label1907;
            }
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener((View.OnClickListener)localObject3);
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener((View.OnClickListener)localObject3);
          }
        }
        for (;;)
        {
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnCompletionListener(new StoryPlayVideoActivity.VideoViewPagerAdapter.VideoOnCompletionListener(this, paramInt));
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnErrorListener(new StoryPlayVideoActivity.VideoViewPagerAdapter.VideoOnErrorListener(this, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4, localStoryVideoItem));
          localObject3 = localObject1;
          if (this.jdField_a_of_type_JavaUtilList.get(paramInt) == null) {
            break;
          }
          if (paramInt == 0) {
            StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, System.currentTimeMillis());
          }
          a(paramInt);
          localObject3 = localObject1;
          break;
          if ((localObject1 != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject1).nickName)))
          {
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject1).nickName);
            break label682;
          }
          localObject3 = QQStoryContext.a().a(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_Long));
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label682;
          }
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          break label682;
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 8)
          {
            if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null)
            {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark)) {
                ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark);
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView, null, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.headUrl, true);
                StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getResources(), ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.authTypeIcon);
                break;
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick))
                {
                  ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick);
                }
                else
                {
                  localObject3 = QQStoryContext.a().a(String.valueOf(localStoryVideoItem.mOwnerUid));
                  if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                    ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                  }
                }
              }
            }
            localObject3 = ((UserManager)localObject3).c(localStoryVideoItem.mOwnerUid);
            if ((localObject3 != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject3).remark))) {
              ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject3).remark);
            }
            for (;;)
            {
              localObject1 = localObject3;
              if (localObject3 == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView, null, ((QQUserUIItem)localObject3).headUrl, true);
              StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getResources(), ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, ((QQUserUIItem)localObject3).symbolUrl);
              localObject1 = localObject3;
              break;
              if ((localObject3 != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject3).nickName)))
              {
                ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject3).nickName);
              }
              else
              {
                localObject1 = QQStoryContext.a().a(String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_b_of_type_Long));
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
                }
              }
            }
          }
          localObject1 = ((UserManager)localObject3).c(localStoryVideoItem.mOwnerUid);
          if (localObject1 != null)
          {
            if (!TextUtils.isEmpty(((QQUserUIItem)localObject1).remark)) {
              ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject1).remark);
            }
            for (;;)
            {
              if (!((QQUserUIItem)localObject1).isVip) {
                break label1752;
              }
              this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_c_of_type_AndroidWidgetImageView, null, ((QQUserUIItem)localObject1).headUrl, true);
              StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.getResources(), ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView, ((QQUserUIItem)localObject1).symbolUrl);
              break;
              if ((localObject1 != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject1).nickName)))
              {
                ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText(((QQUserUIItem)localObject1).nickName);
              }
              else
              {
                localObject3 = QQStoryContext.a().a(String.valueOf(localStoryVideoItem.mOwnerUid));
                if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                  ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
                }
              }
            }
            label1752:
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
            ThreadManager.a(new ipf(this, localStoryVideoItem, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4), 8, null, true);
            break label701;
          }
          localObject3 = QQStoryContext.a().a(String.valueOf(localStoryVideoItem.mOwnerUid));
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          }
          ThreadManager.a(new iph(this, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4), 8, null, true);
          break label701;
          label1840:
          if (((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 6) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 9) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 10)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x))) {
            break label1013;
          }
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x);
          break label1013;
          label1907:
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(null);
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject4).jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
        }
        a(paramInt, 0);
        continue;
        if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip))
        {
          a(paramInt, 8);
        }
        else
        {
          a(paramInt, 1);
          continue;
          a(paramInt, 4);
          continue;
          a(paramInt, 5);
          continue;
          a(paramInt, 6);
          continue;
          if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip))
          {
            a(paramInt, 9);
          }
          else
          {
            a(paramInt, 7);
            continue;
            if ((localObject3 != null) && (((QQUserUIItem)localObject3).isVip))
            {
              a(paramInt, 11);
            }
            else
            {
              a(paramInt, 10);
              continue;
              a(paramInt, 8);
            }
          }
        }
      }
      label2073:
      localObject2 = localObject1;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
    if (localObject2 == null) {}
    Object localObject1;
    String str2;
    label131:
    do
    {
      do
      {
        return;
        localObject1 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.jdField_a_of_type_JavaUtilList.get(((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2).jdField_a_of_type_Int);
        str2 = ((StoryVideoItem)localObject1).mVid;
        switch (paramView.getId())
        {
        case 2131302978: 
        case 2131302979: 
        case 2131302982: 
        case 2131302983: 
        default: 
          return;
        case 2131302977: 
          if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 1) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 2)) {
            break label933;
          }
          paramView = "1";
          ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "clk_head", 0, 0, paramView, "", "", str2);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.P = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.O;
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(1);
          if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 8) {
            break label959;
          }
        }
      } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo == null);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, false, 3);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 4) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 5))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.a(((StoryVideoItem)localObject1).mOwnerUid, str2);
        ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "clk_comment", 0, 0, "", "", "", str2);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 6) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J != 9));
    paramView = ((StoryManager)SuperManager.a(5)).a();
    int i;
    if (paramView != null)
    {
      i = 0;
      if (i < paramView.size()) {
        if (((HotTopicItem)paramView.get(i)).topicId != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_c_of_type_Long) {}
      }
    }
    for (paramView = (HotTopicItem)paramView.get(i);; paramView = null)
    {
      MessageForQQStory localMessageForQQStory = new MessageForQQStory();
      localMessageForQQStory.srcName = "日迹";
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x;
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.y;
      String str1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.z;
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.R;
      if (paramView != null)
      {
        localObject2 = paramView.topicName;
        localObject1 = paramView.topicCover;
        str1 = paramView.topicLogo;
        i = paramView.topicColor;
      }
      for (paramView = str1;; paramView = str1)
      {
        localMessageForQQStory.brief = ((String)localObject2);
        localMessageForQQStory.coverImgUrl = ((String)localObject1);
        localMessageForQQStory.logoImgUrl = paramView;
        localMessageForQQStory.srcAction = "mqqapi://qstory/open?src_type=internal&version=1";
        try
        {
          localMessageForQQStory.msgAction = String.format("mqqapi://qstory/opentopic?src_type=app&version=1&topicid=%d&topicname=%s&topiccover=%s&topiclogo=%s&topiccolor=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_c_of_type_Long), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x, URLEncoder.encode((String)localObject1, "utf-8"), URLEncoder.encode(paramView, "utf-8"), Integer.valueOf(i) });
          localMessageForQQStory.authorName = "";
          localMessageForQQStory.briefBgColor = i;
          TroopShareUtility.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, localMessageForQQStory, 2001);
          ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "ugc_video", "share", 0, 0, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_c_of_type_Long + "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K + "", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.x + "", str2);
          return;
          i += 1;
        }
        catch (UnsupportedEncodingException paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, "share topic obj:" + QLog.getStackTraceString(paramView));
            }
          }
        }
        StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject2, str2);
        ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "clk_delete", 0, 0, "", "", "", str2);
        return;
        StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, (StoryVideoItem)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "clk_download", 0, 0, "", "", "", ((StoryVideoItem)localObject1).mVid);
        return;
        StoryPlayVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, ((StoryVideoItem)localObject1).mLabel, ((StoryVideoItem)localObject1).mVid);
        ReportController.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app, "dc00899", "grp_story", "", "play_video", "clk_discover", 0, 0, "1", "", "", ((StoryVideoItem)localObject1).mVid);
        return;
        label933:
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 8)
        {
          paramView = "3";
          break label131;
        }
        paramView = "2";
        break label131;
        label959:
        paramView = ((UserManager)SuperManager.a(2)).c(((StoryVideoItem)localObject1).mOwnerUid);
        if (paramView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.app);
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog;
          localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo;
          if (!paramView.isVip) {}
          for (bool1 = true;; bool1 = false)
          {
            ((InfoCardDialog)localObject1).a((UserInfo)localObject2, false, 3, bool1, str2);
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.setOnDismissListener(new ipj(this));
            return;
          }
        }
        localObject1 = new UserInfo();
        ((UserInfo)localObject1).unionId = paramView.unionId;
        ((UserInfo)localObject1).type = 1;
        ((UserInfo)localObject1).headUrl = paramView.headUrl;
        ((UserInfo)localObject1).authTypeIcon = paramView.symbolUrl;
        ((UserInfo)localObject1).nick = paramView.nickName;
        ((UserInfo)localObject1).remark = paramView.remark;
        ((UserInfo)localObject1).uid = paramView.uid;
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog;
        boolean bool2 = paramView.isVip;
        if (!paramView.isVip) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ((InfoCardDialog)localObject2).a((UserInfo)localObject1, bool2, 3, bool1, str2);
          break;
        }
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.J == 2) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.getCount() == 1)) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.isResume())
      {
        this.b = -1;
        return;
      }
    } while (paramInt == this.jdField_a_of_type_Int);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
      if (this.b != -1)
      {
        if (this.b == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K) {
          break label116;
        }
        b(this.b);
      }
      label116:
      Object localObject;
      for (;;)
      {
        this.b = -1;
        break;
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K >= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K < this.jdField_a_of_type_AndroidUtilSparseArray.size()))
        {
          localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
          if (localObject != null)
          {
            localObject = ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
            if (!((TextureVideoView)localObject).isPlaying()) {
              ((TextureVideoView)localObject).start();
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K >= 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K < this.jdField_a_of_type_AndroidUtilSparseArray.size()))
      {
        localObject = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K);
        if (localObject != null) {
          ((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
        }
      }
      this.b = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.K;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "onPageSelected time:" + System.currentTimeMillis() + ", index:" + paramInt);
    }
    if (this.b != -1)
    {
      if (this.b < paramInt) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.c(this.b);
      }
      while (this.b == paramInt)
      {
        b(paramInt);
        this.b = -1;
        return;
        if (this.b > paramInt) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.d(this.b);
        }
      }
      this.b = paramInt;
      return;
    }
    b(paramInt);
    this.b = -1;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity$VideoViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
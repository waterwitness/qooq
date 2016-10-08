package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.preload.pgc.PGCPlayingListPreloader;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import inq;
import int;
import inv;
import inw;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoCoverView
  extends BaseCoverView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnVideoPreparedListener, Runnable
{
  protected long a;
  protected QQStoryHandler a;
  public PGCPlayingListPreloader a;
  public BaseContentPagerView a;
  public TextureVideoView a;
  protected QQAppInterface a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory a;
  protected IVideoViewBase a;
  public final String a;
  protected long b;
  public String b;
  public boolean b;
  protected int c;
  protected long c;
  protected boolean c;
  private int d;
  protected ImageView d;
  public boolean d;
  protected boolean e;
  
  public VideoCoverView(Context paramContext, Story paramStory, BaseContentPagerView paramBaseContentPagerView)
  {
    super(paramContext, paramStory);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = ("." + getClass().getSimpleName());
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView = paramBaseContentPagerView;
    i();
    this.jdField_d_of_type_AndroidWidgetImageView = new URLImageView(getContext());
    super.addView(this.jdField_d_of_type_AndroidWidgetImageView, 0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_d_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramStory = new RelativeLayout.LayoutParams(-1, -1);
    paramStory.addRule(13);
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase != null)
    {
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setLayoutParams(paramStory);
      super.addView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase, 0);
    }
    for (;;)
    {
      if ((paramContext instanceof QQStoryContentActivity))
      {
        paramContext = (QQStoryContentActivity)paramContext;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramContext.app;
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(98));
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader = paramContext.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader;
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setLayoutParams(paramStory);
        super.addView(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView, 0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid);
      }
      str = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.coverUrl);
      if (!TextUtils.isEmpty(str)) {
        break label199;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc" + this.jdField_a_of_type_JavaLangString, 2, "onResume fetchCurrentVideo filePath=" + str);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader.a(new inq(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 2");
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    label199:
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_JavaLangString = str;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(e(this), str, 0L, 0L);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(this.jdField_b_of_type_JavaLangString);
        }
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 3");
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView == null);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
  }
  
  public String a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      i = 1;
    }
    return String.valueOf(i);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(0);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
    {
      StoryReportor.b("story_play", "cover_video_play", 0, 0, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "", b() });
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 5");
      }
      b(true);
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      return true;
    }
    return false;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo != null)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid;
    }
    return "";
  }
  
  public void b()
  {
    super.b();
    j();
  }
  
  protected boolean b()
  {
    if (this.jdField_d_of_type_Int == 0)
    {
      this.jdField_d_of_type_Int += 1;
      b(true);
      return true;
    }
    QQStoryContentActivity localQQStoryContentActivity = (QQStoryContentActivity)super.getContext();
    super.post(new int(this, localQQStoryContentActivity));
    if (QLog.isDevelopLevel()) {
      QLog.e("Q.qqstory.VideoCoverView", 4, "OnError:" + this.jdField_b_of_type_JavaLangString);
    }
    StoryReportor.a("play_page_title", "fail", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
    StoryReportor.b("story_play", "cover_video_play", 0, 1, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "3", b() });
    return true;
  }
  
  public void c()
  {
    super.c();
    this.jdField_d_of_type_Boolean = true;
    SplitedProgressBar localSplitedProgressBar = this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
    int j = this.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_c_of_type_Long > 0L)) {}
    for (int i = (int)(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition() * 100 / this.jdField_c_of_type_Long);; i = 0)
    {
      localSplitedProgressBar.setProgress(j, i);
      super.postDelayed(this, 50L);
      if (!this.e) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!this.jdField_b_of_type_Boolean)
    {
      b(false);
      StoryReportor.b("story_play", "cover_video_play", 0, 1, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "1", b() });
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.pgc", 2, "mNicknameText VISIBLE 4");
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.nick);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    e();
    StoryReportor.a("play_page_title", "pgc_vv", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
  
  public void d()
  {
    super.d();
    if (!this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      }
      f();
    } while (this.jdField_b_of_type_Long <= 0L);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "VideoCoverView: onPause");
    }
    StoryReportor.a("play_page_title", "time", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, System.currentTimeMillis() - this.jdField_b_of_type_Long + "", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
    StoryReportor.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), 2, this.jdField_c_of_type_Long, System.currentTimeMillis() - this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 3);
    this.jdField_c_of_type_Int = 0;
  }
  
  public void g()
  {
    this.e = true;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.screenshotUrl))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.screenshotUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  public void h()
  {
    this.e = false;
    c();
  }
  
  protected void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = new TextureVideoView(getContext());
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnPreparedListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnInfoListener(this);
    StoryReportor.b("story_play", "cover_video_play", 0, 0, new String[] { a(), StoryReportor.a(super.getContext().getApplicationContext()), "", b() });
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
    }
  }
  
  protected void k()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
      }
      if (this.jdField_b_of_type_Long > 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "VideoCoverView: onCompletion");
        }
        QQStoryContentActivity localQQStoryContentActivity = (QQStoryContentActivity)getContext();
        StoryReportor.a("play_page_title", "time", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, System.currentTimeMillis() - this.jdField_b_of_type_Long + "", StoryReportor.a(getContext()) });
        StoryReportor.a("play_page_title", "pgc_vv", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
        StoryReportor.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), 2, this.jdField_c_of_type_Long, System.currentTimeMillis() - this.jdField_b_of_type_Long, this.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 3);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_c_of_type_Int = 0;
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseContentPagerView.setEnableChangePage(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    QQStoryContentActivity localQQStoryContentActivity = (QQStoryContentActivity)getContext();
    e();
    if (!localQQStoryContentActivity.jdField_g_of_type_Boolean)
    {
      localQQStoryContentActivity.jdField_g_of_type_Boolean = true;
      long l = System.currentTimeMillis();
      int i = (int)(l - localQQStoryContentActivity.jdField_b_of_type_Long);
      int j = (int)((localQQStoryContentActivity.jdField_c_of_type_Long - localQQStoryContentActivity.jdField_b_of_type_Long) * 100L / i);
      int k = (int)((localQQStoryContentActivity.d - localQQStoryContentActivity.jdField_c_of_type_Long) * 100L / i);
      int m = (int)((l - localQQStoryContentActivity.d) * 100L / i);
      StoryReportor.b("story_time", "pgc_open_content", 0, i, new String[] { j + "", k + "", m + "" });
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    JSONObject localJSONObject;
    if (!this.jdField_c_of_type_Boolean)
    {
      StoryReportor.a("play_page_title", "suc", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "1", StoryReportor.a(getContext()) });
      StoryReportor.a("play_page_title", "pgc_vv", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", StoryReportor.a(getContext()) });
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("load_time", this.jdField_c_of_type_Int);
      localJSONObject.put("network", StoryReportor.a(getContext()));
      StoryReportor.a("play_page_title", "load_js", localQQStoryContentActivity.jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, localJSONObject.toString(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    k();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    k();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "MediaPlayer onError==>what:" + paramInt1 + "|extra:" + paramInt2);
    }
    return b();
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "TVK_IMediaPlayer onError==>i:%d, i1:%d, i2:%d, s:%s");
    }
    return b();
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 3) && (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    post(new inw(this));
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    post(new inv(this));
  }
  
  public void run()
  {
    if (((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) || ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()))) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          continue;
        }
        l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          continue;
        }
        l2 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
        SplitedProgressBar localSplitedProgressBar = this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
        int j = this.jdField_b_of_type_Int;
        if (l2 <= 0L) {
          continue;
        }
        i = (int)(l2 * 100L / l1);
        localSplitedProgressBar.setProgress(j, i);
        if ((this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) && (l2 > 100L)) {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        long l1;
        long l2;
        int i;
        continue;
      }
      if (this.jdField_d_of_type_Boolean) {
        super.postDelayed(this, 50L);
      }
      return;
      l1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
      continue;
      i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      l2 = i;
      continue;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\VideoCoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
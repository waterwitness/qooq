package com.tencent.biz.qqstory.pgc.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.pgc.model.StoryVideoDes;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.model.VideoInfo;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import imu;
import imv;
import imw;
import imx;
import imy;
import imz;
import ina;
import inb;
import inc;
import ind;
import ine;
import inf;
import ing;
import inh;
import ini;
import inj;
import ink;
import inl;
import inm;
import inn;
import ino;
import inp;

public class VideoContentView
  extends BaseContentPagerView
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, INetInfoHandler, Runnable
{
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public long a;
  protected SensorEventListener a;
  protected SensorManager a;
  public ImageButton a;
  public SeekBar a;
  public TextView a;
  private QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public TextureVideoView a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public TVK_PlayerVideoInfo a;
  protected long b;
  protected ImageButton b;
  public ImageView b;
  public TextView b;
  public String b;
  public long c;
  public View c;
  public TextView c;
  public long d;
  protected View d;
  protected boolean d;
  public int e;
  public long e;
  public View e;
  public boolean e;
  protected int f;
  public View f;
  protected boolean f;
  protected int g;
  protected View g;
  public boolean g;
  protected boolean h;
  protected boolean i;
  protected boolean j;
  private int k;
  protected boolean k;
  boolean l;
  public boolean m;
  
  public VideoContentView(Context paramContext, Story paramStory, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramStory, paramOnClickListener);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_Int = 0;
    this.h = true;
    this.l = false;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new inb(this);
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new ind(this);
    if (!TextUtils.isEmpty(paramStory.contentTips))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips(paramStory.contentTips);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewBaseCoverView.setTips("观看");
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout1 = new RelativeLayout(getContext());
    RelativeLayout localRelativeLayout2 = (RelativeLayout)LayoutInflater.from(getContext()).inflate(2130904471, this, false);
    this.jdField_c_of_type_AndroidViewView = localRelativeLayout2.findViewById(2131302841);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)localRelativeLayout2.findViewById(2131302843));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localRelativeLayout2.findViewById(2131302842));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout2.findViewById(2131302844));
    this.jdField_e_of_type_AndroidViewView = localRelativeLayout2.findViewById(2131298741);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)localRelativeLayout2.findViewById(2131302849));
    this.jdField_f_of_type_AndroidViewView = localRelativeLayout2.findViewById(2131297156);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout2.findViewById(2131302729));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localRelativeLayout2.findViewById(2131302838));
    this.jdField_b_of_type_AndroidWidgetImageView = new URLImageView(getContext());
    localRelativeLayout2.addView(this.jdField_b_of_type_AndroidWidgetImageView, 0);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    j();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localRelativeLayout2.addView(this.jdField_d_of_type_AndroidViewView, 0);
    }
    for (;;)
    {
      localRelativeLayout1.addView(localRelativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_g_of_type_AndroidViewView = localRelativeLayout2;
      return localRelativeLayout1;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setLayoutParams(localLayoutParams);
        localRelativeLayout2.addView(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView, 0);
      }
    }
  }
  
  public String a()
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      n = 1;
    }
    return String.valueOf(n);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1)
    {
      if ((this.h) && (NetworkUtil.b(getContext()) == 1)) {
        this.jdField_g_of_type_Boolean = true;
      }
      if (this.jdField_g_of_type_Boolean)
      {
        q();
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.h = false;
      this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getContext().getApplicationContext().getSystemService("sensor"));
      Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, localSensor, 1);
      AppNetConnInfo.registerConnectionChangeReceiver(getContext().getApplicationContext(), this);
      if (!this.jdField_k_of_type_Boolean)
      {
        StoryReportor.a("play_page_share", "exp", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.contentType, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", "" });
        this.jdField_k_of_type_Boolean = true;
      }
      this.jdField_d_of_type_Long = 0L;
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 0L)) {
          this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()) && (this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 0L)) {
          this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
      {
        this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
        this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      }
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.jdField_d_of_type_Long > 0L)
      {
        StoryReportor.a("play_page_video", "time", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_d_of_type_Long + "", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
        StoryReportor.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), 3, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 4);
      }
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo != null)
    {
      this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
      this.l = false;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label103;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramVideoInfo.jdField_b_of_type_JavaLangString, 0L, 0L, null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = true;
      if ((this.i) && (this.jdField_j_of_type_Int == 1) && (this.jdField_g_of_type_Boolean))
      {
        q();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this, 500L);
      }
      return;
      label103:
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(paramVideoInfo.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes != null)) {
      return this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid;
    }
    return "";
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean b()
  {
    return (this.jdField_j_of_type_Int == 0) || (this.jdField_c_of_type_AndroidViewView.getVisibility() != 0) || (this.jdField_e_of_type_Boolean);
  }
  
  public boolean b(int paramInt)
  {
    return false;
  }
  
  public void c()
  {
    super.c();
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.videoCover))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
      localObject = URLDrawable.getDrawable(ThumbnailUrlHelper.a(getContext(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.videoCover), (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new ink(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new inl(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new inm(this));
    }
    label235:
    label320:
    label388:
    do
    {
      break label320;
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new imv(this));
      this.jdField_f_of_type_AndroidViewView.setOnTouchListener(new imw(this));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnTouchListener(new imx(this));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.title))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(new imy(this));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
        if ((NetworkUtil.b(getContext()) == 1) && (!this.jdField_f_of_type_Boolean))
        {
          localObject = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.videoUrl;
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          this.l = false;
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
            break label388;
          }
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), (String)localObject, 0L, 0L, null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
        }
      }
      for (;;)
      {
        this.jdField_f_of_type_Boolean = true;
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnPreparedListener(new inn(this));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnCompletionListener(new ino(this));
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setOnErrorListener(new inp(this));
        break;
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        break label235;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath((String)localObject);
        }
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
  }
  
  public boolean c()
  {
    post(new inj(this));
    StoryReportor.b("story_play", "content_video_play", 0, 1, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "3", b() });
    this.l = false;
    StoryReportor.a("play_page_video", "fail", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
    return true;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this);
    if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.a();
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public void e()
  {
    super.e();
    this.i = true;
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    if ((this.jdField_j_of_type_Int == 1) && (this.jdField_g_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label145;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(this.jdField_g_of_type_Int);
    }
    for (;;)
    {
      q();
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(true);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (this.jdField_j_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)getContext().getApplicationContext().getSystemService("sensor"));
        Sensor localSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, localSensor, 1);
        AppNetConnInfo.registerConnectionChangeReceiver(getContext().getApplicationContext(), this);
      }
      this.jdField_d_of_type_Long = 0L;
      return;
      label145:
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo(this.jdField_g_of_type_Int);
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (this.jdField_j_of_type_Int == 1) && (this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 0L)) {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
      }
      this.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
      if (this.jdField_a_of_type_AndroidHardwareSensorManager != null)
      {
        this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener);
        this.jdField_a_of_type_AndroidHardwareSensorManager = null;
      }
      if (this.jdField_j_of_type_Int == 1) {
        AppNetConnInfo.unregisterNetInfoHandler(this);
      }
      if ((this.jdField_j_of_type_Int == 1) && (this.jdField_d_of_type_Long > 0L))
      {
        StoryReportor.a("play_page_video", "time", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_d_of_type_Long + "", this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
        StoryReportor.a(this.jdField_a_of_type_Int, 3, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.user.type, 3, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, this.jdField_k_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId);
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 4);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()) && (this.jdField_j_of_type_Int == 1) && (this.jdField_c_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_c_of_type_Long > 0L)) {
          this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
        }
        this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      }
    }
  }
  
  protected void g()
  {
    post(new inc(this));
  }
  
  protected void j()
  {
    if (TVK_SDKMgr.isInstalled(getContext().getApplicationContext()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      this.jdField_d_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(getContext()));
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getContext(), (IVideoViewBase)this.jdField_d_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setXYaxis(0);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = new TextureVideoView(getContext());
  }
  
  public void k()
  {
    int n = getWidth();
    int i1 = getHeight();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(n, i1);
    localLayoutParams.rightMargin = (-(i1 - n));
    localLayoutParams.addRule(13);
    this.jdField_g_of_type_AndroidViewView.setRotation(0.0F);
    this.jdField_g_of_type_AndroidViewView.setTranslationY(0.0F);
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_j_of_type_Boolean = false;
  }
  
  public void l()
  {
    int n = getWidth();
    int i1 = getHeight();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, n);
    localLayoutParams.rightMargin = (-(i1 - n));
    localLayoutParams.addRule(13);
    this.jdField_g_of_type_AndroidViewView.setRotation(-90.0F);
    this.jdField_g_of_type_AndroidViewView.setTranslationY((i1 - n) / 2);
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_j_of_type_Boolean = true;
  }
  
  public void m()
  {
    int n = getWidth();
    int i1 = getHeight();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i1, n);
    localLayoutParams.rightMargin = (-(i1 - n));
    localLayoutParams.addRule(13);
    this.jdField_g_of_type_AndroidViewView.setRotation(90.0F);
    this.jdField_g_of_type_AndroidViewView.setTranslationY((i1 - n) / 2);
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_j_of_type_Boolean = true;
  }
  
  protected void n()
  {
    if ((this.i) && (this.jdField_j_of_type_Int == 1) && (this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void o()
  {
    post(new imu(this));
    this.l = true;
    n();
    if ((this.jdField_k_of_type_Int == 0) && (this.jdField_b_of_type_Long > 0L)) {
      this.jdField_k_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_b_of_type_Long));
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    QQStoryContentActivity localQQStoryContentActivity = (QQStoryContentActivity)getContext();
    StoryReportor.a("play_page_video", "suc", localQQStoryContentActivity.jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", StoryReportor.a(getContext()) });
    if (this.jdField_k_of_type_Int < 0) {
      this.jdField_k_of_type_Int = 0;
    }
    StoryReportor.a("play_page_video", "load", localQQStoryContentActivity.jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "" + this.jdField_k_of_type_Int, StoryReportor.a(getContext()) });
    StoryReportor.a("play_page_video", "pgc_vv", localQQStoryContentActivity.jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageButton)
    {
      if ((!this.jdField_a_of_type_AndroidWidgetImageButton.isSelected()) && (!NetworkUtil.h(getContext())))
      {
        QQToast.a(getContext(), "当前网络不可用，请检查你的网络设置", 0).a();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
    }
    else {
      return;
    }
    if ((NetworkUtil.b(getContext()) != 1) && (!this.jdField_a_of_type_AndroidWidgetImageButton.isSelected()) && (!this.m))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "网络提醒", "你当前处于非WIFI网络，观看视频将会产生流量费用。", "取消", "继续观看", new imz(this), new ina(this)).show();
      return;
    }
    if (!this.jdField_a_of_type_AndroidWidgetImageButton.isSelected())
    {
      q();
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (this.jdField_a_of_type_AndroidWidgetImageButton.isSelected()) {
        break label342;
      }
    }
    label342:
    for (boolean bool = true;; bool = false)
    {
      paramView.setSelected(bool);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      StoryReportor.a("play_page_video", "play", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_g_of_type_Boolean = false;
        if ((this.jdField_c_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_c_of_type_Long <= 0L)) {
          break;
        }
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_c_of_type_Long;
        break;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
        }
      }
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    post(new inh(this));
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    post(new ini(this));
  }
  
  public void onNetWifi2None() {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break label29;
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      label29:
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo(paramInt);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_d_of_type_Boolean = true;
    StoryReportor.a("play_page_video", "progress", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(getContext()), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.coverInfo.vid });
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void p()
  {
    post(new inf(this));
    this.l = false;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void q()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    int n;
    if (this.jdField_f_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        if (this.l)
        {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.resumeDownload();
          this.jdField_g_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this, 500L);
          if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
            break label262;
          }
          if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion() != 0L) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion() != this.jdField_e_of_type_Long)) {
            break label257;
          }
          n = 1;
        }
      }
    }
    for (;;)
    {
      if (n != 0) {
        StoryReportor.a("play_page_video", "pgc_vv", ((QQStoryContentActivity)getContext()).jdField_g_of_type_Int, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, "", StoryReportor.a(getContext()) });
      }
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      return;
      if (this.jdField_b_of_type_JavaLangString == null) {
        break;
      }
      this.l = false;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, 0L, 0L, null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
      break;
      label257:
      n = 0;
      continue;
      label262:
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition() == this.jdField_e_of_type_Long))
        {
          n = 1;
        }
        else
        {
          n = 0;
          continue;
          StoryReportor.b("story_play", "content_video_play", 0, 0, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "0", b() });
          String str = this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.videoUrl;
          if (!TextUtils.isEmpty(str))
          {
            this.jdField_b_of_type_JavaLangString = str;
            this.l = false;
            if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
              this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getContext(), str, 0L, 0L, null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
            }
            for (;;)
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this, 500L);
              this.jdField_f_of_type_Boolean = true;
              return;
              if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
              {
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.setVideoPath(str);
                this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
              }
            }
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid))
          {
            this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(new String[] { this.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.videoDes.vid });
            return;
          }
          StoryReportor.b("story_play", "content_video_play", 0, 1, new String[] { a(), StoryReportor.a(getContext().getApplicationContext()), "1", b() });
        }
      }
      else {
        n = 0;
      }
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();; bool = false)
    {
      if (bool)
      {
        if (this.m)
        {
          QQToast.a(getContext(), "你正在使用运营商网络", 0).a();
          return;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
        this.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "网络提醒", "你当前处于非WIFI网络，观看视频将会产生流量费用。", "取消", "继续观看", new ine(this), new ing(this)).show();
        return;
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pauseDownload();
      }
      QQToast.a(getContext(), "你正在使用运营商网络", 0).a();
      return;
    }
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
        l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
        int n = (int)l1;
        int i1 = (int)(this.jdField_e_of_type_Long / 1000L);
        String str = String.format("%02d:%02d", new Object[] { Integer.valueOf(i1 / 60), Integer.valueOf(i1 % 60) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(n);
        }
        if (this.jdField_f_of_type_Int == n) {
          continue;
        }
        this.jdField_f_of_type_Int = n;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      catch (Exception localException)
      {
        long l1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localException));
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this, 500L);
      if ((this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L) && (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      l1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\VideoContentView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
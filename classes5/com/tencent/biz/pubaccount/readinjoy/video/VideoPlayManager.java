package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.VideoAudioManager;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.Pair;
import hzu;
import iac;
import iad;
import iae;
import iag;
import iah;
import iai;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlayManager
  implements VideoPluginInstall.OnVideoPluginInstallListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final int h = 10;
  private static final int i = 3;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private VideoAudioManager jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  private VideoPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoStatusListener;
  private VideoPlayerWrapper.MediaPlayListenerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
  private VideoPluginInstall jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall;
  private VideoPreloadMgr jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr;
  public ArrayList a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private List jdField_a_of_type_JavaUtilList;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boolean jdField_a_of_type_Boolean;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private boolean jdField_b_of_type_Boolean;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_c_of_type_Boolean;
  
  public VideoPlayManager(Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter = new hzu(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new iah(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new iai(this);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : create a new manager !");
    }
    VideoVolumeControl.a().a(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = new VideoAudioManager(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = new VideoPluginInstall(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(localLinearInterpolator);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130839553);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130839556);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramActivity.getResources().getDrawable(2130839555);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b();
    }
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
    {
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      if (paramBoolean) {
        this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(j), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper);
      }
      return j;
    }
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    }
    return 0L;
  }
  
  public Bitmap a(int paramInt)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Pair localPair = (Pair)((Iterator)localObject).next();
      if (paramInt == ((Integer)localPair.first).intValue())
      {
        localObject = (Bitmap)localPair.second;
        this.jdField_b_of_type_JavaUtilArrayList.remove(localPair);
        return (Bitmap)localObject;
      }
    }
    return null;
  }
  
  public VideoPlayManager.VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
  }
  
  public VideoPlayManager.VideoPlayParam a(long paramLong)
  {
    return (VideoPlayManager.VideoPlayParam)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
  }
  
  public VideoPlayerWrapper a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr.a(paramVideoPlayParam);
    if (localVideoPlayerWrapper != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload] getVideoPlayer use PreReadyPool instance! articleId:" + paramVideoPlayParam.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_JavaUtilList.add(new WeakReference(localVideoPlayerWrapper));
      return localVideoPlayerWrapper;
    }
    paramVideoPlayParam = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext());
    paramVideoPlayParam.a(this.jdField_a_of_type_AndroidAppActivity);
    paramVideoPlayParam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper$MediaPlayListenerAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "getVideoPlayer new instant!");
    }
    this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramVideoPlayParam));
    return paramVideoPlayParam;
  }
  
  public void a()
  {
    c(false);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout.getAnimation() != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout.getAnimation().setAnimationListener(null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long, paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "stop , from : " + paramInt);
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.g();
        a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
        }
        b(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "add play state button , type : " + paramInt1);
    }
    Object localObject1;
    int j;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = (ResizeURLImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296590);
      if (localObject1 != null) {
        break label487;
      }
      localObject1 = new ResizeURLImageView(this.jdField_a_of_type_AndroidAppActivity);
      ((ResizeURLImageView)localObject1).setVisibility(0);
      ((ResizeURLImageView)localObject1).setId(2131296590);
      j = AIOUtils.a(62.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localObject2 = new FrameLayout.LayoutParams(j, j);
      ((FrameLayout.LayoutParams)localObject2).gravity = 17;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      j = 0;
    }
    for (;;)
    {
      if (j == 0)
      {
        ((ResizeURLImageView)localObject1).setVisibility(0);
        ((ResizeURLImageView)localObject1).setImageBitmap(null);
        ((ResizeURLImageView)localObject1).clearAnimation();
        ((ResizeURLImageView)localObject1).setTag(Integer.valueOf(paramInt1));
        switch (paramInt1)
        {
        default: 
          ((ResizeURLImageView)localObject1).setImageResource(2130839556);
        }
      }
      for (;;)
      {
        localObject2 = (ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296592);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
          ((ImageView)localObject2).setId(2131296592);
          ((ImageView)localObject2).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841361));
          ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          ((ImageView)localObject2).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
          paramInt1 = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          ((ImageView)localObject2).setPadding(paramInt1, paramInt1, paramInt1, AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          localObject1 = new FrameLayout.LayoutParams(AIOUtils.a(45.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(43.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((FrameLayout.LayoutParams)localObject1).gravity = 85;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          VideoVolumeControl.a().a((ImageView)localObject2);
          VideoVolumeControl.a().a(VideoVolumeControl.a().a(), "init view set mute itself addPlayStateButtonToVideo");
          localObject1 = localObject2;
          if (this.jdField_c_of_type_Boolean)
          {
            localObject1 = localObject2;
            if (!VideoVolumeControl.a().a())
            {
              localObject1 = localObject2;
              if (VideoVolumeControl.a().b())
              {
                this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a("init feeds");
                this.jdField_c_of_type_Boolean = false;
                localObject1 = localObject2;
              }
            }
          }
        }
        ((ImageView)localObject1).setVisibility(4);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "addPlayStateButtonToVideo set volumeView invisible");
        }
        return;
        label487:
        if ((((ResizeURLImageView)localObject1).getTag() == null) || (((Integer)((ResizeURLImageView)localObject1).getTag()).intValue() != paramInt1)) {
          break label925;
        }
        ((ResizeURLImageView)localObject1).setVisibility(0);
        if (paramInt1 == 1) {
          ((ResizeURLImageView)localObject1).startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
        }
        j = 1;
        break;
        ((ResizeURLImageView)localObject1).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        continue;
        ((ResizeURLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if ((paramInt2 != 0) && (paramInt3 != 0))
        {
          if (paramInt2 == 123) {
            if (paramInt3 == 103) {
              localObject1 = "网络异常：" + paramInt2 + "-" + paramInt3;
            }
          }
          for (;;)
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, (CharSequence)localObject1, 1).a();
            break;
            localObject1 = "视频加载失败，请稍后重试：" + paramInt2 + "-" + paramInt3;
            continue;
            if (paramInt2 == 122)
            {
              if (paramInt1 == 204) {
                localObject1 = "网络异常：" + paramInt2 + "-" + paramInt3;
              } else if (paramInt1 == 202) {
                localObject1 = "视频源已删除：" + paramInt2 + "-" + paramInt3;
              } else {
                localObject1 = "视频加载失败，请稍后重试：" + paramInt2 + "-" + paramInt3;
              }
            }
            else if (paramInt2 == 101)
            {
              if (paramInt1 == 80) {
                localObject1 = "因版权限制、无法观看：" + paramInt2 + "-" + paramInt3;
              } else {
                localObject1 = "视频加载失败，请稍后重试：" + paramInt2 + "-" + paramInt3;
              }
            }
            else {
              localObject1 = "视频加载失败，请稍后重试：" + paramInt2 + "-" + paramInt3;
            }
          }
          ((ResizeURLImageView)localObject1).setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
          ((ResizeURLImageView)localObject1).startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
        }
      }
      label925:
      j = 0;
    }
  }
  
  public void a(int paramInt, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {}
    label44:
    label54:
    label64:
    label79:
    label89:
    label200:
    label207:
    label213:
    label221:
    label229:
    label237:
    label330:
    for (;;)
    {
      return;
      long l1;
      Long localLong;
      String str1;
      int j;
      String str2;
      long l2;
      long l3;
      if (paramVideoPlayParam != null)
      {
        l1 = paramVideoPlayParam.jdField_a_of_type_Long;
        localLong = Long.valueOf(l1);
        if (paramVideoPlayParam == null) {
          break label200;
        }
        str1 = paramVideoPlayParam.jdField_a_of_type_JavaLangString;
        if (paramVideoPlayParam == null) {
          break label207;
        }
        j = paramVideoPlayParam.e;
        if (paramVideoPlayParam == null) {
          break label213;
        }
        str2 = paramVideoPlayParam.jdField_d_of_type_JavaLangString;
        if (paramVideoPlayParam == null) {
          break label221;
        }
        l1 = paramVideoPlayParam.jdField_a_of_type_Int * 1000;
        if (paramVideoPlayParam == null) {
          break label229;
        }
        l2 = paramVideoPlayParam.jdField_b_of_type_Long;
        if (paramVideoPlayParam == null) {
          break label237;
        }
        l3 = paramVideoPlayParam.jdField_d_of_type_Long;
        paramVideoPlayParam = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      for (;;)
      {
        if (!paramVideoPlayParam.hasNext()) {
          break label330;
        }
        VideoPlayStatusChangeListenner localVideoPlayStatusChangeListenner = (VideoPlayStatusChangeListenner)paramVideoPlayParam.next();
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          localVideoPlayStatusChangeListenner.d(l3, Long.valueOf(l1), Long.valueOf(l2), localLong, str1, j, str2);
          continue;
          l1 = -1L;
          break;
          str1 = "";
          break label44;
          j = -1;
          break label54;
          str2 = "";
          break label64;
          l1 = -1L;
          break label79;
          l2 = -1L;
          break label89;
          l3 = -1L;
          break;
        case 1: 
          localVideoPlayStatusChangeListenner.c(l3, Long.valueOf(l1), Long.valueOf(l2), localLong, str1, j, str2);
          break;
        case 2: 
          localVideoPlayStatusChangeListenner.a(l3, Long.valueOf(l1), Long.valueOf(l2), localLong, str1, j, str2);
          break;
        case 3: 
          localVideoPlayStatusChangeListenner.b(l3, Long.valueOf(l1), Long.valueOf(l2), localLong, str1, j, str2);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      VideoPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
      a(1);
      localVideoPlayParam.jdField_b_of_type_Long = paramInt;
      a(localVideoPlayParam);
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "resume(): playVideo ");
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "player stop [async]  stopID : " + paramLong + ", from : " + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long == paramLong))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long = a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.setKeepScreenOn(false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427379));
      }
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      b(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
      {
        localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        localReadinjoyVideoReportData.jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long == 0L)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long / this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
    }
    while (!QLog.isColorLevel())
    {
      ReadinjoyVideoReportData localReadinjoyVideoReportData;
      return;
    }
    QLog.d("Q.readinjoy.video", 2, "stop : current player is null or articleID is not equal!");
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    int j = 0;
    while (j < paramViewGroup.getChildCount())
    {
      View localView = paramViewGroup.getChildAt(j);
      Animation localAnimation = localView.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      localView.clearAnimation();
      j += 1;
    }
    paramViewGroup.removeAllViews();
  }
  
  public void a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "playVideo in call return");
      }
      return;
    }
    try
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "start install tencent sdk plugin");
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
        b(1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.a();
        return;
      }
    }
    catch (Exception paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "play video start ! id : " + paramVideoPlayParam.jdField_a_of_type_Long + ", vid : " + paramVideoPlayParam.jdField_a_of_type_JavaLangString + ", position : " + paramVideoPlayParam.jdField_b_of_type_Long);
    }
    Object localObject1 = a(paramVideoPlayParam);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = ((VideoPlayerWrapper)localObject1);
    paramVideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.setKeepScreenOn(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    Object localObject2 = (AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio");
    if (!VideoVolumeControl.a().a()) {
      ((AudioManager)localObject2).requestAudioFocus(null, 3, 1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d())
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.readinjoy.video", 2, "[preload] mVideoPlayerWrapper.isReady()!  just return!");
      }
      a(paramVideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout);
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : get videoView Fail !");
        }
        b(2);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      ((View)localObject1).setId(2131296588);
      ((View)localObject1).setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427409));
      paramVideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a((IVideoViewBase)localObject1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.d();
      localObject1 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject1).setDuration(800L);
      ((AlphaAnimation)localObject1).setFillEnabled(true);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      ((AlphaAnimation)localObject1).setAnimationListener(new iac(this, paramVideoPlayParam));
      paramVideoPlayParam.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation((Animation)localObject1);
      d();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.g);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr.a() != null)
        {
          paramVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr.a();
          paramVideoPlayParam.b += 1;
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
    a(paramVideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout);
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : get videoView Fail !");
      }
      b(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
      return;
    }
    paramVideoPlayParam.jdField_a_of_type_AndroidViewView = ((View)localObject2);
    ((View)localObject2).setId(2131296588);
    paramVideoPlayParam.jdField_b_of_type_AndroidWidgetFrameLayout.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new iad(this), 1000L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a((IVideoViewBase)localObject2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = SystemClock.uptimeMillis();
    ThreadManager.b(new iae(this, (VideoPlayerWrapper)localObject1, paramVideoPlayParam));
  }
  
  public void a(VideoPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoStatusListener = paramVideoStatusListener;
  }
  
  public void a(VideoPlayStatusChangeListenner paramVideoPlayStatusChangeListenner)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoPlayStatusChangeListenner);
    }
  }
  
  public void a(VideoPreloadMgr paramVideoPreloadMgr)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr = paramVideoPreloadMgr;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.a().setOutputMute(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b());
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (paramInt == ((Integer)((Pair)localIterator.next()).first).intValue()) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c();
    }
    return -1;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam == null) {
      return -1L;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (b())
    {
      if (!VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity)) {
        break label33;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "VideoPlayManager onResume,in call return");
      }
    }
    return;
    label33:
    d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    a(3, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, 0, 0);
  }
  
  public void b(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramVideoPlayParam.jdField_a_of_type_Long), paramVideoPlayParam);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "install tencent video sdk success!");
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "install tencent video sdk fail!");
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new iag(this));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "VideoPlayManager : destroy !");
    }
    a(7);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.l();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = null;
    }
    ThirdVidoeManager.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPluginInstall = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    VideoVolumeControl.a().b(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.c();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((WeakReference)localIterator.next()).get();
      if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.jdField_a_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "VideoPlayerWrapper : " + localVideoPlayerWrapper.toString() + " not release");
        }
        localVideoPlayerWrapper.l();
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.f();
      if (!NetworkUtil.i(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.j();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Long = a();
      if (paramBoolean) {
        b(0);
      }
      ReadinjoyVideoReportData localReadinjoyVideoReportData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      localReadinjoyVideoReportData.jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
    }
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e());
  }
  
  public void d()
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localObject1 = (ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296590);
      if ((localObject1 == null) || (((ImageView)localObject1).getVisibility() != 0)) {
        break label353;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "remove play state btn success! type : " + String.valueOf(((ImageView)localObject1).getTag()));
      }
      localObject2 = ((ImageView)localObject1).getAnimation();
      if (localObject2 != null) {
        ((Animation)localObject2).cancel();
      }
      ((ImageView)localObject1).clearAnimation();
      ((ImageView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      localObject2 = (ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296592);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
        ((ImageView)localObject2).setId(2131296592);
        ((ImageView)localObject2).setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841361));
        ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject2).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        int j = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        ((ImageView)localObject2).setPadding(j, j, j, AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localObject1 = new FrameLayout.LayoutParams(AIOUtils.a(45.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), AIOUtils.a(43.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((FrameLayout.LayoutParams)localObject1).gravity = 85;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        VideoVolumeControl.a().a((ImageView)localObject2);
        VideoVolumeControl.a().a(VideoVolumeControl.a().a(), "init view set mute itself removePlayStateButtonFromVideo");
        localObject1 = localObject2;
        if (this.jdField_c_of_type_Boolean)
        {
          localObject1 = localObject2;
          if (!VideoVolumeControl.a().a())
          {
            localObject1 = localObject2;
            if (VideoVolumeControl.a().b())
            {
              this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a("init feed");
              this.jdField_c_of_type_Boolean = false;
              localObject1 = localObject2;
            }
          }
        }
      }
      ((ImageView)localObject1).setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.e("Q.readinjoy.video", 2, "removePlayStateButtonFromVideo, show volume view");
      }
      return;
      label353:
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "remove play state btn fail, not btn in screen!");
      }
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "onUnVisiable() isPlaying()=" + a() + ", isOpening()=" + c());
    }
    if (a()) {
      a();
    }
    while (!c()) {
      return;
    }
    a(8);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.video", 2, "onVisiable() isPause()=" + b());
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = SystemClock.uptimeMillis();
    }
    if (b()) {
      b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\video\VideoPlayManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnVideoDownloadListener;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.WatcherListPagerLoader;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserVideoInfo;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.playvideo.player.ExploreAnimalView;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryDownloadView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AnimationUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowFromData;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ioa;
import iob;
import ioc;
import iod;
import ioe;
import iof;
import iog;
import ioh;
import ioi;
import ioj;
import iok;
import iol;
import ioo;
import iop;
import ioq;
import ior;
import ios;
import iou;
import iow;
import iox;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryPlayVideoActivity
  extends QQStoryBaseActivity
  implements DragFrameLayout.OnDraggingListener
{
  public static final int A = 1;
  public static final int B = 2;
  public static final String B = "消息发送失败，请稍后重试";
  public static final int C = 3;
  public static String C = "StorySvc.video_comment";
  public static final int D = 2000;
  public static String D = "StorySvc.get_video_info";
  public static final int E = 2001;
  public static final int L = 0;
  public static final int M = 1;
  public static final int N = 2;
  public static final int a = 880001;
  protected static final String a = "Q.qqstory.player.StoryPlayVideoActivity";
  public static final int b = 0;
  public static final String b = "EXTRA_VIDEO_ID_LIST";
  public static final int c = 1;
  public static final String c = "EXTRA_VIDEO_MODE";
  public static final int d = 2;
  public static final String d = "EXTRA_USER_UIN";
  public static final int e = 3;
  public static final String e = "EXTRA_CURRENT_INDEX";
  public static final int f = 4;
  protected static final String f = "EXTRA_VIDEO_LABEL";
  public static final int g = 5;
  public static final String g = "extra_default_title";
  public static final int h = 6;
  public static final String h = "extra_is_open_watchlist";
  public static final int i = 7;
  public static final String i = "extra_single_video_item";
  public static final int j = 8;
  public static final String j = "extra_recent_uin_list";
  public static final int k = 9;
  public static final String k = "extra_video_id";
  public static final int l = 10;
  public static final String l = "extra_topic_id";
  public static final int m = 20;
  public static final String m = "extra_topic_name";
  public static final int n = 0;
  public static final String n = "extra_topic_cover";
  public static final int o = 1;
  public static final String o = "extra_topic_logo";
  public static final int p = 2;
  public static final String p = "extra_topic_color";
  public static final int q = 3;
  public static final String q = "extra_vid";
  public static final int r = 4;
  public static final String r = "extra_union_id";
  public static final int s = 5;
  public static final String s = "extra_is_show_info_card";
  public static final int t = 6;
  public static final int u = 7;
  public static final int v = 8;
  public static final int w = 9;
  public static final int x = 10;
  public static final int y = 11;
  public static final int z = 0;
  protected String A;
  protected int F;
  protected int G;
  protected int H;
  protected int I;
  public int J;
  public int K;
  public int O = 0;
  public int P;
  protected int Q;
  protected int R;
  protected int S = 0;
  protected int T;
  private int W;
  private int X;
  long jdField_a_of_type_Long = 0L;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  public Handler a;
  public GestureDetector a;
  protected View a;
  public ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  private QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ior(this);
  public PlayingListPreloader.OnVideoDownloadListener a;
  public PlayingListPreloader a;
  protected LiveVideoEntry a;
  public DefaultPlayerVideoListSynchronizer a;
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  public WatcherListPagerLoader a;
  public UserInfo a;
  public ContentEmptyView a;
  public InfoCardDialog a;
  public CustomViewPager a;
  public QQStoryVideoPlayerErrorView a;
  private StoryPlayVideoActivity.GestureHandler jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$GestureHandler = new iob(this);
  public StoryPlayVideoActivity.SwitchVideoListener a;
  public StoryPlayVideoActivity.VideoControlListener a;
  public StoryPlayVideoActivity.VideoViewPagerAdapter a;
  protected TextureVideoView a;
  public QQStoryWatcherListView a;
  protected FFmpeg a;
  public SplitedProgressBar a;
  public DragFrameLayout a;
  public QQStoryLoadingView a;
  protected Runnable a;
  protected WeakReference a;
  public ArrayList a;
  protected HashMap a;
  protected List a;
  protected boolean a;
  protected long[] a;
  public long b;
  protected ImageView b;
  private Runnable b;
  public List b;
  public boolean b;
  protected long c;
  protected boolean c;
  private long d;
  protected boolean d;
  private long e;
  public boolean e;
  private long f;
  public boolean f;
  public final String t = System.currentTimeMillis() + "";
  protected String u;
  protected String v;
  protected String w;
  protected String x;
  protected String y;
  protected String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StoryPlayVideoActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaLangRunnable = new iox(this, null);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader = new PlayingListPreloader();
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$SwitchVideoListener = new ioa(this);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener = new ioj(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = new iol(this);
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new ios(this);
    this.jdField_b_of_type_JavaLangRunnable = new ioi(this);
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    try
    {
      if (paramString.startsWith("file://")) {
        str = paramString.substring(7);
      }
      localObject1 = localObject2;
      if (str.length() > 0)
      {
        localObject1 = localObject2;
        if (!str.toLowerCase().startsWith("http://")) {
          localObject1 = BitmapFactory.decodeFile(str);
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "DecodeFile OutOfMemoryError:" + paramString.getMessage());
      return null;
    }
    catch (Exception paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "DecodeFile exception:" + paramString.getMessage());
    }
    return (Bitmap)localObject1;
    return null;
  }
  
  private StoryVideoItem a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = new StoryVideoItem();
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.id = -1L;
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLabel = "加载中";
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    String str = "";
    if ((paramStoryVideoItem.mTitle != null) && (paramStoryVideoItem.mTitle.length() > 0)) {
      paramStoryVideoItem = paramStoryVideoItem.mTitle;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        paramStoryVideoItem = str;
      } while (this.v == null);
      paramStoryVideoItem = str;
    } while (this.v.length() <= 0);
    return this.v;
  }
  
  private void a(int paramInt, String paramString)
  {
    StoryDownloadView localStoryDownloadView = (StoryDownloadView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localStoryDownloadView != null) {}
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      localStoryDownloadView.setWhiteMode(true);
      localStoryDownloadView.setVisibility(0);
      localStoryDownloadView.a();
      return;
    case 2: 
      StoryReportor.a("play_video", "down_suc", 0, 0, new String[] { "", "", "", paramString });
      QQToast.a(getApplicationContext(), 2, "已保存到本地相册", 0).a();
      localStoryDownloadView.a(true);
      return;
    }
    StoryReportor.a("play_video", "down_fail", 0, 0, new String[] { "", "", "", paramString });
    QQToast.a(getApplicationContext(), 1, "保存失败，请稍后重试", 0).a();
    localStoryDownloadView.b(true);
  }
  
  public static void a(Activity paramActivity, int paramInt, long paramLong, String paramString, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", paramInt);
    localIntent.putExtra("EXTRA_USER_UIN", paramLong);
    localIntent.putExtra("extra_default_title", paramString);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 6);
    localIntent.putExtra("extra_topic_id", paramLong);
    localIntent.putExtra("extra_topic_name", paramString);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 8);
    localIntent.putExtra("EXTRA_USER_UIN", paramLong);
    localIntent.putExtra("extra_union_id", paramString);
    localIntent.putExtra("extra_is_show_info_card", paramBoolean);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 0);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString, boolean paramBoolean, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 2);
    localIntent.putExtra("EXTRA_USER_UIN", paramLong);
    localIntent.putExtra("extra_is_open_watchlist", paramBoolean);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", localArrayList);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 3);
    localIntent.putExtra("EXTRA_VIDEO_LABEL", paramString1);
    localIntent.putExtra("extra_vid", paramString2);
    paramActivity.startActivityForResult(localIntent, 2000);
    paramActivity.overridePendingTransition(2130968592, 2130968621);
  }
  
  public static void a(Activity paramActivity, ArrayList paramArrayList, String paramString, View paramView)
  {
    long[] arrayOfLong = new long[paramArrayList.size()];
    int i1 = 0;
    while (i1 < arrayOfLong.length)
    {
      arrayOfLong[i1] = ((Long)paramArrayList.get(i1)).longValue();
      i1 += 1;
    }
    paramArrayList = new Intent(paramActivity, StoryPlayVideoActivity.class);
    paramArrayList.putExtra("EXTRA_VIDEO_MODE", 4);
    paramArrayList.putExtra("extra_recent_uin_list", arrayOfLong);
    paramArrayList.putExtra("extra_default_title", paramString);
    AnimationUtils.b(paramActivity, paramArrayList, paramView);
  }
  
  public static void a(Resources paramResources, TextView paramTextView, String paramString)
  {
    boolean bool = false;
    if ((paramResources == null) || (paramTextView == null) || (!HttpUtil.a(paramString))) {
      if (QLog.isColorLevel())
      {
        paramResources = new StringBuilder().append("setAuthIcon fail：textView is null ? ");
        if (paramTextView == null) {
          bool = true;
        }
        QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, bool + ", url = " + paramString);
      }
    }
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int i1 = AIOUtils.a(16.0F, paramResources);
        localURLDrawableOptions.mRequestHeight = i1;
        localURLDrawableOptions.mRequestWidth = i1;
        paramResources = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramResources.getStatus() == 2) {
          paramResources.restartDownload();
        }
        paramResources.setBounds(0, 0, i1, i1);
        paramTextView.setCompoundDrawablePadding(8);
        paramTextView.setCompoundDrawables(null, null, paramResources, null);
        return;
      }
      catch (Exception paramResources) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, QLog.getStackTraceString(paramResources));
  }
  
  private void a(StoryVideoItem paramStoryVideoItem)
  {
    String str = AppConstants.bt + FFmpegUtils.b(paramStoryVideoItem.mVid);
    Object localObject = QQStoryConstant.s + paramStoryVideoItem.mVid + ".mp4";
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.a(getApplicationContext());
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a()) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(str)) {
        a(1, paramStoryVideoItem.mVid);
      }
    }
    for (;;)
    {
      return;
      QQToast.a(BaseApplication.getContext(), 1, "已有其他下载任务在执行，请稍候", 0).a();
      return;
      if (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath))
      {
        a(3, paramStoryVideoItem.mVid);
        return;
      }
      if (FileUtils.c(str))
      {
        a(2, paramStoryVideoItem.mVid);
        return;
      }
      if (FileUtils.c((String)localObject))
      {
        if (FileUtils.a(getBaseContext(), (String)localObject, str))
        {
          a(2, paramStoryVideoItem.mVid);
          return;
        }
        a(3, paramStoryVideoItem.mVid);
        return;
      }
      if (TextUtils.isEmpty(paramStoryVideoItem.mLocalMaskPath))
      {
        if (FileUtils.a(getBaseContext(), paramStoryVideoItem.mLocalVideoPath, str))
        {
          a(2, paramStoryVideoItem.mVid);
          return;
        }
        a(3, paramStoryVideoItem.mVid);
        return;
      }
      try
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a();
        if ((localObject == null) || (((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView == null))
        {
          a(3, paramStoryVideoItem.mVid);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("FFmepg", 2, "FFmpeg watermark video bug holder == null or holder.mDownloadBtn == null");
        }
      }
      catch (Exception localException)
      {
        a(3, paramStoryVideoItem.mVid);
        QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, localException.getMessage());
        return;
      }
    }
    localObject = new StoryPlayVideoActivity.ExecuteDownloadResponseCallback(((StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryDownloadView, localException, paramStoryVideoItem);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(localException);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(paramStoryVideoItem.mLocalMaskPath, paramStoryVideoItem.mLocalVideoPath, localException, paramStoryVideoItem.mVideoWidth, paramStoryVideoItem.mVideoHeight, (FFmpegExecuteResponseCallback)localObject);
  }
  
  private void a(StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "azrael: \t发现一个没有传 videoWidth 和videoHeight 的!");
      }
      return;
    }
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i5 = ((DisplayMetrics)localObject).widthPixels;
    int i6 = ((DisplayMetrics)localObject).heightPixels;
    double d1 = 1.0D * paramInt1 / paramInt2;
    int i3;
    int i1;
    int i4;
    int i2;
    if (1.0D * i5 / i6 >= d1)
    {
      i3 = (int)(i5 / d1);
      i1 = (int)(1.0D * (i6 - i3) / 2.0D + 0.5D);
      i4 = i5;
      i2 = 0;
      label120:
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.qqstory.player.StoryPlayVideoActivity", 2, "azrael: layoutImage: \tscreenWidth: " + i5 + ", screenHeight: " + i6 + "\n\t\t videoWidth: " + paramInt1 + ", videoHeight:" + paramInt2 + "\n\t\t layoutWidth: " + i4 + ", layoutHeight:" + i3 + "\n\t\t leftMargin: " + i2 + ", topMargin: " + i1);
      }
      localObject = new View[3];
      localObject[0] = paramVideoViewHolder.jdField_a_of_type_AndroidViewView;
      localObject[1] = paramVideoViewHolder.f;
      localObject[2] = paramVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView;
      paramInt2 = localObject.length;
      paramInt1 = 0;
      label264:
      if (paramInt1 < paramInt2)
      {
        paramVideoViewHolder = localObject[paramInt1];
        if (paramVideoViewHolder != null) {
          break label323;
        }
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break label264;
      break;
      i4 = (int)(d1 * i6);
      i2 = (int)(1.0D * (i5 - i4) / 2.0D + 0.5D);
      i3 = i6;
      i1 = 0;
      break label120;
      label323:
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramVideoViewHolder.getLayoutParams();
      localLayoutParams.width = i4;
      localLayoutParams.height = i3;
      localLayoutParams.leftMargin = i2;
      localLayoutParams.rightMargin = i2;
      localLayoutParams.topMargin = i1;
      localLayoutParams.bottomMargin = i1;
      paramVideoViewHolder.setLayoutParams(localLayoutParams);
    }
  }
  
  private void a(StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder, String paramString)
  {
    this.P = this.O;
    a(1);
    paramVideoViewHolder = new iog(this, paramString);
    paramString = DialogUtil.a(this, 230);
    paramString.setMessage("确认删除该日迹？");
    paramString.setNegativeButton(2131367262, paramVideoViewHolder);
    paramString.setPositiveButton("删除", paramVideoViewHolder);
    paramString.setCancelable(false);
    paramString.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramString.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 10);
    localIntent.putExtra("extra_topic_id", paramLong);
    localIntent.putExtra("extra_topic_name", paramString);
    ReportController.b(paramQQAppInterface, "dc00899", "grp_story", "", "ugc_video", "clk_obj", 0, 0, paramLong + "", "", paramString + "", "");
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 2130968621);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 9);
    localIntent.putExtra("extra_topic_id", paramLong);
    localIntent.putExtra("extra_topic_name", paramString1);
    localIntent.putExtra("extra_topic_cover", paramString2);
    localIntent.putExtra("extra_topic_logo", paramString3);
    localIntent.putExtra("extra_topic_color", paramInt);
    ReportController.b(paramQQAppInterface, "dc00899", "grp_story", "", "ugc_video", "clk_obj", 0, 0, paramLong + "", "", paramString1 + "", "");
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 2130968621);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, long paramLong)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      b(paramActivity, paramString, paramLong);
      return;
    }
    b(paramQQAppInterface, paramActivity, paramLong, paramString);
  }
  
  private void a(String paramString)
  {
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(this.K);
    if (localStoryVideoItem == null) {
      return;
    }
    String str = ((UserManager)SuperManager.a(2)).a(localStoryVideoItem.mOwnerUid);
    qqstory_service.ReqComment localReqComment = new qqstory_service.ReqComment();
    localReqComment.author_union_id.set(ByteStringMicro.copyFromUtf8(str));
    if (!TextUtils.isEmpty(paramString)) {
      localReqComment.comment_content.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    localReqComment.cover.set(ByteStringMicro.copyFromUtf8(localStoryVideoItem.mVideoThumbnailUrl));
    localReqComment.createTime.set(localStoryVideoItem.mCreateTime / 1000L);
    localReqComment.title.set(ByteStringMicro.copyFromUtf8(localStoryVideoItem.mOwnerUid + ""));
    paramString = new SimpleDateFormat("M月d日 HH:mm");
    localReqComment.summary.set(ByteStringMicro.copyFromUtf8(paramString.format(new Long(localStoryVideoItem.mCreateTime))));
    localReqComment.vid.set(ByteStringMicro.copyFromUtf8(localStoryVideoItem.mVid));
    long l1 = System.currentTimeMillis();
    ProtoUtils.a(this.app, new ioe(this, l1), localReqComment.toByteArray(), C);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      if (this.J == 6) {
        b(this, paramString1, paramString2);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      a(this, paramString1, paramString2);
      return;
    }
    QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "label 是空的也进入到 exploreVideos 里面了, 出bug了吗? ");
  }
  
  private static void b(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 5);
    localIntent.putExtra("extra_video_id", paramString);
    localIntent.putExtra("EXTRA_USER_UIN", paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", localArrayList);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968592, 0);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 7);
    localIntent.putExtra("EXTRA_VIDEO_LABEL", paramString1);
    localIntent.putExtra("extra_vid", paramString2);
    paramActivity.startActivityForResult(localIntent, 2000);
    paramActivity.overridePendingTransition(2130968592, 2130968621);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, long paramLong, String paramString)
  {
    qqstory_service.ReqGetUserVideoInfo localReqGetUserVideoInfo = new qqstory_service.ReqGetUserVideoInfo();
    localReqGetUserVideoInfo.vid.set(ByteStringMicro.copyFromUtf8(paramString));
    ProtoUtils.a(paramQQAppInterface, new iof(System.currentTimeMillis(), paramActivity, paramString, paramLong), localReqGetUserVideoInfo.toByteArray(), D);
  }
  
  private static boolean b(StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.id == -1L;
  }
  
  private boolean e()
  {
    if (this.J == 4) {
      return this.T >= this.jdField_a_of_type_ArrayOfLong.length;
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  public void a()
  {
    if (!this.i)
    {
      finish();
      return;
    }
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, 0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(this.F, this.G, this.H, this.I, 300, new iok(this));
  }
  
  public void a(int paramInt)
  {
    this.O = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size())) {}
    StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder;
    StoryVideoItem localStoryVideoItem;
    int i1;
    label85:
    do
    {
      do
      {
        return;
        localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(paramInt1);
        localStoryVideoItem = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(paramInt1);
      } while (localVideoViewHolder == null);
      i1 = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
      if (paramInt2 != 1) {
        break;
      }
      i1 = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration();
      if (QLog.isColorLevel()) {
        QLog.i("reportviewvideo", 2, this.J + "," + i1 + "," + localStoryVideoItem.mOwnerUid + "," + localStoryVideoItem.mVid);
      }
    } while (i1 <= 0);
    String str = "1";
    switch (this.J)
    {
    default: 
      label216:
      ReportController.b(this.app, "dc00899", "grp_story", "", "play_video", "exp", 0, 0, str, i1 + "", localStoryVideoItem.mOwnerUid + "", "");
    }
    for (;;)
    {
      long l1;
      long l2;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("author_id", localStoryVideoItem.mOwnerUid + "");
        if (this.J != 8) {
          break label1096;
        }
        str = "3";
        localJSONObject.put("author_type", str);
        localJSONObject.put("video_type", "1");
        localJSONObject.put("video_time", localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration() + "");
        localJSONObject.put("play_time", i1 + "");
        if ((this.jdField_f_of_type_Long <= this.jdField_d_of_type_Long) || (this.e <= this.jdField_f_of_type_Long)) {
          break label1153;
        }
        l1 = this.e - this.jdField_f_of_type_Long;
        localJSONObject.put("load_time", l1 + "");
        paramInt1 = 1;
        switch (this.J)
        {
        case 1: 
          ReportController.b(this.app, "dc00899", "grp_story", "", "play_video", "video_all_js", paramInt1, paramInt2, localJSONObject.toString(), "", "", localStoryVideoItem.mVid);
          ReportController.b(this.app, "dc00899", "grp_story", "", "play_video", "video_property", paramInt1, paramInt2, localStoryVideoItem.mOwnerUid + "", str, "1", localStoryVideoItem.mVid);
          ReportController.b(this.app, "dc00899", "grp_story", "", "play_video", "video_time", paramInt1, paramInt2, localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getDuration() + "", i1 + "", l1 + "", localStoryVideoItem.mVid);
          ReportController.b(this.app, "dc00899", "grp_story_engineer", "", "play_video", "play_done", 0, 0, "0", "", "", localStoryVideoItem.mVid);
          if (this.e <= this.jdField_d_of_type_Long) {
            break label1220;
          }
          l2 = this.e - this.jdField_d_of_type_Long;
          ReportController.b(this.app, "dc00899", "grp_story_engineer", "", "play_video", "local_load_time", 0, 0, l2 + "", l1 + "", "", localStoryVideoItem.mVid);
          return;
        }
      }
      catch (JSONException localJSONException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "reportViewVideo exception:" + QLog.getStackTraceString(localJSONException));
      return;
      Object localObject = "1";
      break label216;
      localObject = "2";
      break label216;
      localObject = "3";
      break label216;
      localObject = "4";
      break label216;
      ReportController.b(this.app, "dc00899", "grp_story", "", "ugc_video", "play_topic", 0, 0, this.jdField_c_of_type_Long + "", paramInt1 + "", this.x, localStoryVideoItem.mVid);
      localObject = "5";
      break label216;
      localObject = "6";
      break label216;
      localObject = "7";
      break label216;
      ReportController.b(this.app, "dc00899", "grp_story", "", "ugc_video", "play_discover", 0, 0, this.jdField_c_of_type_Long + "", this.A, localStoryVideoItem.mVid, "");
      localObject = "7";
      break label216;
      localObject = "8";
      break label216;
      label1096:
      if (this.J == 6)
      {
        localObject = "5";
      }
      else
      {
        localObject = ((UserManager)SuperManager.a(2)).c(localStoryVideoItem.mOwnerUid);
        if (localObject != null)
        {
          if (((QQUserUIItem)localObject).isVip) {
            localObject = "3";
          }
        }
        else
        {
          localObject = "1";
          continue;
          label1153:
          l1 = 0L;
          continue;
          paramInt1 = 1;
          continue;
          paramInt1 = 2;
          continue;
          paramInt1 = 3;
          continue;
          paramInt1 = 4;
          continue;
          paramInt1 = 5;
          continue;
          paramInt1 = 6;
          continue;
          paramInt1 = 6;
          continue;
          paramInt1 = 7;
          continue;
          paramInt1 = 11;
          continue;
          paramInt1 = 15;
          continue;
          paramInt1 = 16;
          continue;
          label1220:
          l2 = 0L;
          continue;
          break label85;
          continue;
        }
        localObject = "1";
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 0.0F;
    float f2 = 1.0F - (paramInt3 - paramInt5) / DisplayUtil.a(this, 60.0F);
    if (f2 < 0.0F) {}
    for (;;)
    {
      ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, f1);
      return;
      f1 = f2;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    this.P = this.O;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("draftID", paramLong + "_" + this.jdField_a_of_type_Long);
    ((Bundle)localObject).putInt("maxContentLength", 100);
    localObject = new QQStoryCommentDialog(this, (Bundle)localObject);
    ((QQStoryCommentDialog)localObject).setOnDismissListener(new ioc(this));
    ((QQStoryCommentDialog)localObject).a(new iod(this, paramString));
    ((QQStoryCommentDialog)localObject).show();
    a(1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > DisplayUtil.a(this, 60.0F))
    {
      if (this.i) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.f(this.K);
        return;
        finish();
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.jdField_a_of_type_AndroidViewView), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
  
  public void a(StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder paramVideoViewHolder, String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    paramVideoViewHolder = (ActionSheet)ActionSheetHelper.b(this, null);
    paramVideoViewHolder.a("欺诈骗钱", 5);
    paramVideoViewHolder.a("色情暴力", 5);
    paramVideoViewHolder.a("广告骚扰", 5);
    paramVideoViewHolder.a("其他", 5);
    paramVideoViewHolder.d(2131367262);
    paramVideoViewHolder.a(new ioh(this, paramString, paramVideoViewHolder));
    paramVideoViewHolder.setOnDismissListener(paramOnDismissListener);
    if (!paramVideoViewHolder.isShowing()) {
      paramVideoViewHolder.show();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ImageView paramImageView, String paramString1, String paramString2, boolean paramBoolean)
  {
    Bitmap localBitmap = a(paramString1);
    if ((localBitmap == null) && (paramString1 != null) && (QLog.isColorLevel())) {
      QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "setImageView: has localPath, and createBitmap failure! ");
    }
    paramString1 = localBitmap;
    if (localBitmap != null)
    {
      paramString1 = localBitmap;
      if (paramBoolean) {
        paramString1 = paramQQAppInterface.a(localBitmap);
      }
    }
    if (paramString1 != null) {
      paramImageView.setImageBitmap(paramString1);
    }
    do
    {
      return;
      if (!HttpUtil.a(paramString2)) {
        break;
      }
      try
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramString1 = new ColorDrawable(0);
        paramQQAppInterface.mLoadingDrawable = paramString1;
        paramQQAppInterface.mFailedDrawable = paramString1;
        paramQQAppInterface.mPlayGifImage = false;
        paramQQAppInterface.mGifRoundCorner = 0.0F;
        paramQQAppInterface = URLDrawable.getDrawable(paramString2, paramQQAppInterface);
        if (paramBoolean) {
          paramQQAppInterface.setDecodeHandler(URLDrawableDecodeHandler.a);
        }
        paramQQAppInterface.startDownload();
        paramImageView.setImageDrawable(paramQQAppInterface);
        return;
      }
      catch (OutOfMemoryError paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "DecodeFile OutOfMemoryError:" + paramQQAppInterface.getMessage());
    return;
    paramImageView.setImageDrawable(null);
  }
  
  protected void a(Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new StoryPlayVideoActivity.StoryVideoDeleteReceiver(this), "");
    paramMap.put(new StoryPlayVideoActivity.GetWatcherListReceiver(this), "");
    paramMap.put(new StoryPlayVideoActivity.GetStoryListReceiver(this, this), "");
    paramMap.put(new StoryPlayVideoActivity.ReportVideoReceiver(this), "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      try
      {
        int i2 = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        int i1 = i2;
        if (i2 == 0) {
          i1 = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        }
        if (i1 == 0)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.getCount() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getCurrentItem() == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.getCount() - 1);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry != null)
    {
      Object localObject1 = this.app;
      Object localObject2 = this.app;
      localObject1 = (NowProxy)((QQAppInterface)localObject1).getManager(181);
      localObject2 = new NowFromData();
      ((NowFromData)localObject2).b = "story";
      ((NowFromData)localObject2).a = "story";
      ((NowProxy)localObject1).a(null, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry.roomId, (NowFromData)localObject2, 2, null);
      StoryListUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry.uin);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getCurrentItem() == 0;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.notifyDataSetChanged();
      return;
      TroopShareUtility.a(this.app, this, paramInt2, paramIntent);
    } while (paramInt2 != -1);
    paramIntent = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(this.K);
    ReportController.b(this.app, "dc00899", "grp_story", "", "ugc_video", "share_send", 0, 0, this.jdField_c_of_type_Long + "", this.K + "", this.x + "", paramIntent.mVid);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    getWindow().addFlags(128);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.setContentViewNoTitle(2130904502);
    paramBundle = super.getIntent();
    this.J = paramBundle.getIntExtra("EXTRA_VIDEO_MODE", 0);
    this.K = paramBundle.getIntExtra("EXTRA_CURRENT_INDEX", 0);
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("EXTRA_USER_UIN", 0L);
    this.v = paramBundle.getStringExtra("extra_default_title");
    this.w = paramBundle.getStringExtra("EXTRA_VIDEO_LABEL");
    this.u = paramBundle.getStringExtra("extra_union_id");
    this.A = paramBundle.getStringExtra("extra_vid");
    if (this.J == 4)
    {
      this.jdField_a_of_type_ArrayOfLong = paramBundle.getLongArrayExtra("extra_recent_uin_list");
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)super.findViewById(2131302725));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131302727));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302732));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302726);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager = ((CustomViewPager)super.findViewById(2131302967));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter = new StoryPlayVideoActivity.VideoViewPagerAdapter(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setPageMargin(10);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131302928));
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = ((SplitedProgressBar)super.findViewById(2131302839));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView = ((QQStoryWatcherListView)super.findViewById(2131302970));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)super.findViewById(2131302968));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setOnClickListener(new ioo(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)super.findViewById(2131302969));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302952));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new iou(this, null));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.setOnTouchListener(new iop(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ioq(this));
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    switch (this.J)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener);
      if (this.jdField_b_of_type_ArrayOfInt != null)
      {
        this.F = this.jdField_b_of_type_ArrayOfInt[0];
        this.G = this.jdField_b_of_type_ArrayOfInt[1];
        this.H = this.jdField_b_of_type_ArrayOfInt[2];
        this.I = this.jdField_b_of_type_ArrayOfInt[3];
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.e = this.H;
      int i1 = this.H;
      if (this.H > this.I) {
        i1 = this.H / 2;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.e = i1;
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
      paramBundle = (PreloadDownloaderManager)SuperManager.a(6);
      if (!paramBundle.a())
      {
        paramBundle.c();
        this.jdField_d_of_type_Boolean = true;
      }
      return true;
      if (!TextUtils.isEmpty(this.w))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(2, this.w, this.A, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        Object localObject = paramBundle.getExtras().getStringArrayList("EXTRA_VIDEO_ID_LIST");
        StoryManager localStoryManager;
        StoryVideoItem localStoryVideoItem;
        if (localObject != null)
        {
          paramBundle = new ArrayList();
          localStoryManager = (StoryManager)SuperManager.a(5);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localStoryVideoItem = localStoryManager.a((String)((Iterator)localObject).next());
            if (localStoryVideoItem != null) {
              paramBundle.add(localStoryVideoItem);
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a(paramBundle);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.notifyDataSetChanged();
          if ((StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter) != null) && (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() > 0))
          {
            paramBundle = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(0);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setShowMaxCount(1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(0, 1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(0);
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20L);
        }
        this.X = 1;
        this.jdField_c_of_type_Boolean = true;
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(1, this.jdField_b_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        if (this.jdField_a_of_type_ArrayOfLong.length == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.player.StoryPlayVideoActivity", 2, "VIDEO_MODE_RECENT get wrong data, mRecentUinList.length == 0");
          }
          finish();
          return false;
        }
        paramBundle = new iow(null);
        paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        this.T = 0;
        paramBundle.jdField_a_of_type_Long = this.jdField_a_of_type_ArrayOfLong[this.T];
        this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(4, paramBundle.jdField_a_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        a(1);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("extra_is_open_watchlist", false);
        localObject = paramBundle.getExtras().getStringArrayList("EXTRA_VIDEO_ID_LIST");
        if (localObject != null)
        {
          paramBundle = new ArrayList();
          localStoryManager = (StoryManager)SuperManager.a(5);
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localStoryVideoItem = localStoryManager.a((String)((Iterator)localObject).next());
            if (localStoryVideoItem != null) {
              paramBundle.add(localStoryVideoItem);
            }
          }
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a(paramBundle);
          if ((StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter) != null) && (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size() > 0))
          {
            paramBundle = (StoryVideoItem)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(0);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setShowMaxCount(1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(0, 1);
            this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter));
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 20L);
        }
        this.X = 1;
        this.jdField_c_of_type_Boolean = true;
        continue;
        a(2);
        this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("extra_is_show_info_card", true);
        ((QQStoryHandler)this.app.a(98)).a(1, this.u);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(1, this.jdField_b_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(1, this.jdField_b_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        this.jdField_c_of_type_Long = paramBundle.getLongExtra("extra_topic_id", 0L);
        this.x = paramBundle.getStringExtra("extra_topic_name");
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(5, this.jdField_c_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        this.jdField_c_of_type_Long = paramBundle.getLongExtra("extra_topic_id", 0L);
        this.x = paramBundle.getStringExtra("extra_topic_name");
        this.y = paramBundle.getStringExtra("extra_topic_cover");
        this.z = paramBundle.getStringExtra("extra_topic_logo");
        this.R = paramBundle.getIntExtra("extra_topic_color", 0);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(5, this.jdField_c_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        this.jdField_c_of_type_Long = paramBundle.getLongExtra("extra_topic_id", 0L);
        this.x = paramBundle.getStringExtra("extra_topic_name");
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(5, this.jdField_c_of_type_Long, this.t);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
        if (!TextUtils.isEmpty(this.w))
        {
          this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer = new DefaultPlayerVideoListSynchronizer(3, this.w, this.A, this.t);
          this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.a();
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.b();
    }
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidWidgetRelativeLayout).reset();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelDefaultPlayerVideoListSynchronizer.b();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.dismiss();
    }
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter != null) && (StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter) != null))
    {
      int i1 = 0;
      while (i1 < StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).size())
      {
        StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(i1);
        if ((localVideoViewHolder != null) && (localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView != null)) {
          localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerExploreAnimalView.c();
        }
        i1 += 1;
      }
    }
    if (this.jdField_d_of_type_Boolean) {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(0L);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder localVideoViewHolder = (StoryPlayVideoActivity.VideoViewPagerAdapter.VideoViewHolder)StoryPlayVideoActivity.VideoViewPagerAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter).get(this.K);
    if (localVideoViewHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null)
      {
        this.Q = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.getCurrentPosition();
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.pause();
      }
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a == null) || (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a.isShowing())) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.seekTo(this.Q);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.start();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView = null;
    }
    b();
  }
  
  public void finish()
  {
    super.finish();
    if ((this.J == 3) || (this.J == 7))
    {
      super.overridePendingTransition(0, 2130968593);
      return;
    }
    super.overridePendingTransition(0, 2130968621);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.S == 3)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a() == null) {
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
        if (this.J == 1) {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a(this.K, 0);
        }
        for (;;)
        {
          a(this.P);
          paramKeyEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, UIUtils.b(getActivity()));
          paramKeyEvent.setDuration(500L);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoWatcherlistQQStoryWatcherListView.setAnimation(paramKeyEvent);
          return true;
          if (this.J == 2) {
            this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoViewPagerAdapter.a(this.K, 5);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoStoryPlayVideoActivity$VideoControlListener.i(this.K);
      a();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\playvideo\StoryPlayVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
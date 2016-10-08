package com.tencent.mobileqq.activity.shortvideo;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountArticleHandler;
import com.tencent.biz.pubaccount.PublicAccountArticleObserver;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoListAdapter;
import com.tencent.biz.pubaccount.VideoListAdapter.VideoListEventListener;
import com.tencent.biz.pubaccount.VideoListView;
import com.tencent.biz.pubaccount.VideoListView.OnRefreshListener;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.VideoPlayRecommendObserver;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.pubaccount.util.VideoPlayUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.prediction.PredictionReporter;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import pjg;
import pjh;
import pji;
import pjk;
import pjm;
import pjn;
import pjo;
import pjp;
import pjq;
import pjr;
import pjs;
import pjt;
import pjw;
import pjx;
import pjy;
import pjz;
import pka;
import pkb;
import pkc;
import pkd;
import pke;
import pkf;
import pkg;
import pkh;
import pki;
import pkj;
import pkk;
import pkl;
import pkm;
import pkn;
import pko;
import pkp;
import pkq;
import pkr;

public class ShortVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, VideoListAdapter.VideoListEventListener, FileTransferManager.Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnNetVideoInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener, IVideoViewBase.IVideoViewCallBack
{
  public static final int a = 0;
  public static final String a = "ShortVideoPlayActivity";
  public static final int b = 1;
  public static final String b = "ShortVideoPlayerInner";
  static String[] jdField_b_of_type_ArrayOfJavaLangString;
  public static final int c = 2;
  public static final int f = 3;
  public static final int g = 3000;
  public static final int h = 4;
  public static final String l = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  static final int jdField_m_of_type_Int = 2500;
  static final String jdField_m_of_type_JavaLangString = "state_play_position";
  static final int jdField_n_of_type_Int = 100;
  public static final int o = 4;
  static String jdField_p_of_type_JavaLangString;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N = -1;
  private int O;
  private int P;
  private int Q;
  long jdField_a_of_type_Long;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Bundle a;
  public View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener;
  public SeekBar a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler;
  private PublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver;
  private VideoListAdapter jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter;
  private VideoListView jdField_a_of_type_ComTencentBizPubaccountVideoListView;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver;
  private ThirdVidoeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public MessageForShortVideo a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public final Runnable a;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private List jdField_a_of_type_JavaUtilList;
  public final MqqHandler a;
  boolean jdField_a_of_type_Boolean = false;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  public long b;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  public TextView b;
  final Runnable jdField_b_of_type_JavaLangRunnable;
  public boolean b;
  public long c;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  public RelativeLayout c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  long jdField_d_of_type_Long = -1L;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public String d;
  boolean jdField_d_of_type_Boolean = false;
  long jdField_e_of_type_Long = -1L;
  RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  String jdField_e_of_type_JavaLangString = "";
  boolean jdField_e_of_type_Boolean;
  public long f;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  String jdField_f_of_type_JavaLangString = "";
  public boolean f;
  public long g;
  private RelativeLayout jdField_g_of_type_AndroidWidgetRelativeLayout;
  String jdField_g_of_type_JavaLangString;
  boolean jdField_g_of_type_Boolean = false;
  private long jdField_h_of_type_Long;
  private RelativeLayout jdField_h_of_type_AndroidWidgetRelativeLayout;
  String jdField_h_of_type_JavaLangString;
  public boolean h;
  public int i;
  private long jdField_i_of_type_Long;
  public String i;
  boolean jdField_i_of_type_Boolean = false;
  public int j;
  private long jdField_j_of_type_Long;
  public String j;
  boolean jdField_j_of_type_Boolean;
  int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  public String k;
  private boolean jdField_k_of_type_Boolean;
  public int l;
  private long jdField_l_of_type_Long;
  private boolean jdField_l_of_type_Boolean;
  private long jdField_m_of_type_Long;
  private boolean jdField_m_of_type_Boolean;
  private long jdField_n_of_type_Long;
  public String n;
  private boolean jdField_n_of_type_Boolean;
  private long jdField_o_of_type_Long;
  String jdField_o_of_type_JavaLangString;
  private boolean jdField_o_of_type_Boolean = true;
  public int p;
  private long jdField_p_of_type_Long;
  private boolean jdField_p_of_type_Boolean = true;
  int jdField_q_of_type_Int;
  private long jdField_q_of_type_Long;
  private String jdField_q_of_type_JavaLangString;
  private boolean jdField_q_of_type_Boolean = true;
  public int r;
  private long jdField_r_of_type_Long;
  private String jdField_r_of_type_JavaLangString;
  private boolean jdField_r_of_type_Boolean;
  public int s;
  private long jdField_s_of_type_Long;
  private String jdField_s_of_type_JavaLangString;
  private boolean jdField_s_of_type_Boolean;
  int jdField_t_of_type_Int = 1;
  private long jdField_t_of_type_Long;
  private String jdField_t_of_type_JavaLangString;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int;
  private long jdField_u_of_type_Long;
  private String jdField_u_of_type_JavaLangString;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private long jdField_v_of_type_Long;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean = true;
  private int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean;
  private int y;
  private int z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_p_of_type_JavaLangString = SharedPreUtils.f(BaseApplication.getContext());
    if ((jdField_p_of_type_JavaLangString != null) && (jdField_p_of_type_JavaLangString.length() > 0)) {
      jdField_b_of_type_ArrayOfJavaLangString = jdField_p_of_type_JavaLangString.split("\\|");
    }
  }
  
  public ShortVideoPlayActivity()
  {
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_p_of_type_Int = -1;
    this.jdField_n_of_type_JavaLangString = "0";
    this.jdField_f_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new pjg(this));
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new pjt(this);
    this.jdField_a_of_type_JavaLangRunnable = new pko(this);
    this.jdField_b_of_type_JavaLangRunnable = new pkp(this);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pkq(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new pjs(this);
  }
  
  private void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startDownLoadVideoForPubAccount: " + this.jdField_g_of_type_JavaLangString);
    }
    Object localObject = Environment.getExternalStorageDirectory();
    int i1;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label112;
      }
      i1 = 1;
      label73:
      if (i1 != 0) {
        break label117;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131368967, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    }
    label112:
    label117:
    ShortVideoDownloadInfo localShortVideoDownloadInfo;
    do
    {
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label73;
      localObject = ShortVideoBusiManager.a(2, 0);
      localShortVideoDownloadInfo = a();
      if ((!AppNetConnInfo.isWifiConn()) && (localShortVideoDownloadInfo != null) && (localShortVideoDownloadInfo.jdField_b_of_type_Long > 204800L)) {
        a(DialogUtil.a(this, 230, getString(2131371552), getString(2131371551), new pjn(this), new pjo(this)));
      }
    } while (localShortVideoDownloadInfo == null);
    localShortVideoDownloadInfo.jdField_b_of_type_Boolean = true;
    ((ShortVideoReq)localObject).a = localShortVideoDownloadInfo;
    ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
    this.jdField_o_of_type_JavaLangString = localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString;
  }
  
  private void B()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.N == -1) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2003)) {
      break label28;
    }
    label28:
    while (!this.jdField_q_of_type_Boolean) {
      return;
    }
    this.jdField_q_of_type_Boolean = false;
    if (this.jdField_g_of_type_Long == 0L) {}
    for (int i1 = 0;; i1 = (int)(100L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress < 0) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = 0;
      }
      int i2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2002)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == this.N) && (i1 - i2 < 10)) {
        break;
      }
      if ((this.jdField_k_of_type_Int != 6) && (this.jdField_k_of_type_Int != 17) && (this.jdField_k_of_type_Int != 9))
      {
        i2 = i1;
        if (this.jdField_k_of_type_Int != 20) {}
      }
      else
      {
        if (this.N == 2002) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = ((int)this.jdField_f_of_type_Long);
        }
        i2 = i1;
        if (this.N == 2003)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize = 0;
          i2 = 100;
        }
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 2004) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)) && ((this.N == 1002) || (this.N == 2002))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = this.N;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.fileType = this.jdField_k_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress = i2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mPreUpload) && (this.N == 1003) && (this.jdField_i_of_type_JavaLangString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_i_of_type_JavaLangString;
      }
      if ((this.N == 2003) && (!StringUtil.b(this.jdField_d_of_type_JavaLangString)))
      {
        File localFile = new File(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.lastModified = localFile.lastModified();
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
      this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_l_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      return;
    }
  }
  
  private void D()
  {
    F();
    E();
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(Long.parseLong(super.getAppInterface().a()), str1);
  }
  
  private void E()
  {
    super.setRequestedOrientation(1);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = this.O;
    localLayoutParams.height = this.O;
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_h_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130904357, null, false));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(3, this.jdField_e_of_type_AndroidWidgetRelativeLayout.getId());
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidWidgetRelativeLayout);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new pkc(this));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302495));
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302512));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    G();
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth <= this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight)) {}
    for (this.Q = 0;; this.Q = 1)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)super.getAppInterface().a(90));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver = new pkd(this);
      super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)super.getAppInterface().a(93));
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new pke(this);
      super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
      if (!ReadInJoyHelper.d((QQAppInterface)getAppRuntime())) {
        break;
      }
      this.jdField_u_of_type_Boolean = true;
      return;
    }
    this.jdField_u_of_type_Boolean = false;
  }
  
  private void G()
  {
    Object localObject = super.getAppInterface();
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("VIDEO_LISTVIEW_CONFIG_HIDE_SHARE_BUTTON", true);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView = new VideoListView(getApplicationContext(), this, this.jdField_a_of_type_AndroidOsBundle, (QQAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setHeaderViewData(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setOverscrollHeader(getResources().getDrawable(2131427735));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setContentBackground(2131427735);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setVideoListEventListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter = new VideoListAdapter(getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter);
    localObject = new pkf(this, (AppInterface)localObject);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setOnRefreshListener((VideoListView.OnRefreshListener)localObject);
    this.jdField_h_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView, -1, -1);
  }
  
  private void H()
  {
    int i1 = ReadInJoyHelper.b((QQAppInterface)getAppRuntime());
    String str = ReadInJoyHelper.a((QQAppInterface)getAppRuntime());
    int i2 = ReadInJoyHelper.c((QQAppInterface)getAppRuntime());
    ReadInJoyActivityHelper.a(this, i1, str, i2, 2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "enterReadInJoyVideoChannel() channelID=" + i1 + ", channelName=" + str + ", channelType=" + i2);
    }
  }
  
  private void I()
  {
    Object localObject1 = (StructMsgForGeneralShare)StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("STRUCT_MSG_BYTES"));
    if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject1).mMsgBrief)) && (((StructMsgForGeneralShare)localObject1).mMsgBrief.indexOf("[视频]") == -1)) {
      ((StructMsgForGeneralShare)localObject1).mMsgBrief = ("[视频]" + ((StructMsgForGeneralShare)localObject1).mMsgBrief);
    }
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
    PAVideoStructMsgUtil.a((StructMsgForGeneralShare)localObject1);
    ((StructMsgForGeneralShare)localObject1).mSourceAction = "web";
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    String str4 = PAVideoStructMsgUtil.a(str3);
    String str5 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    ((StructMsgForGeneralShare)localObject1).mSourceAppid = Long.valueOf(str3).longValue();
    ((StructMsgForGeneralShare)localObject1).source_puin = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE") > 1) {
      if (!TextUtils.isEmpty(str1))
      {
        ((StructMsgForGeneralShare)localObject1).mSourceUrl = str1;
        if ((str2 == null) || ("".equals(str2))) {
          break label319;
        }
        ((StructMsgForGeneralShare)localObject1).mSourceName = str2;
        label217:
        if ((localObject2 == null) || ("".equals(localObject2))) {
          break label328;
        }
      }
    }
    label319:
    label328:
    for (((StructMsgForGeneralShare)localObject1).mSourceIcon = ((String)localObject2);; ((StructMsgForGeneralShare)localObject1).mSourceIcon = "http://q.url.cn/s/YnxqUe")
    {
      ((StructMsgForGeneralShare)localObject1).setFlag(0);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("forward_type", -3);
      ((Bundle)localObject2).putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject1).mMsgServiceID);
      ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject1).getBytes());
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      ForwardBaseOption.a(this, (Intent)localObject1, 21);
      return;
      ((StructMsgForGeneralShare)localObject1).mSourceUrl = "";
      break;
      ((StructMsgForGeneralShare)localObject1).mSourceUrl = str4;
      break;
      ((StructMsgForGeneralShare)localObject1).mSourceName = str5;
      break label217;
    }
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {}
    int i1;
    do
    {
      do
      {
        return -1;
        paramString = paramString.trim();
        i1 = paramString.indexOf(' ');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    paramString = paramString.trim();
    paramString = paramString.substring(0, paramString.indexOf(' '));
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private ShortVideoDownloadInfo a()
  {
    ShortVideoDownloadInfo localShortVideoDownloadInfo = new ShortVideoDownloadInfo();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_g_of_type_JavaLangString);
      if (localJSONObject != null)
      {
        localShortVideoDownloadInfo.jdField_a_of_type_Int = localJSONObject.getInt("busi_type");
        localShortVideoDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("file_uuid");
        String str = localJSONObject.getString("file_md5");
        localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString = str;
        this.jdField_i_of_type_JavaLangString = str;
        localShortVideoDownloadInfo.jdField_b_of_type_Long = localJSONObject.getInt("file_size");
        localShortVideoDownloadInfo.jdField_b_of_type_Int = this.jdField_p_of_type_Int;
        localShortVideoDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_c_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString;
        localShortVideoDownloadInfo.jdField_d_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString;
        localShortVideoDownloadInfo.g = 1001;
        this.jdField_k_of_type_Int = 1001;
        localShortVideoDownloadInfo.jdField_h_of_type_JavaLangString = a(localShortVideoDownloadInfo.jdField_e_of_type_JavaLangString);
        return localShortVideoDownloadInfo;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private String a(long paramLong)
  {
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L)
    {
      f1 = (float)paramLong / 1024.0F;
      return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "K";
    }
    float f1 = (float)paramLong / 1048576.0F;
    return String.format("%.2f", new Object[] { Float.valueOf(f1) }) + "M";
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bj);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("publicaccount");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    localStringBuilder.append("mp4");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    int i1 = 0;
    if (paramLong2 != 0L) {
      i1 = (int)(100L * paramLong1 / paramLong2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "updateUploadInfo " + i1 + " " + paramLong1 + " " + paramLong2);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong1) + "/" + a(paramLong2));
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
  }
  
  private void a(Dialog paramDialog)
  {
    if (!isFinishing()) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "innerPlayForMultiVideo()");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
    b(0);
    this.jdField_k_of_type_Boolean = true;
    this.jdField_b_of_type_Long = 0L;
    o();
    r();
    if (paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE") == 2)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager = ThirdVidoeManager.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a(new pkj(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
      {
        this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
        b(0L);
      }
      if (!this.jdField_g_of_type_Boolean)
      {
        u();
        a(true);
        C();
      }
      return;
      a(0L, paramBundle.getString("VIDEO_VID"), null);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_p_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_l_of_type_Boolean);
      if (this.M == 0) {
        paramBoolean = true;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null);
    this.jdField_p_of_type_Boolean = false;
    HashMap localHashMap = new HashMap();
    String str = "actShortVideoDownloadVideo";
    if (this.jdField_k_of_type_Int == 6) {
      str = "actShortVideoDownloadVideo";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "reportTag = " + str);
      }
      localHashMap.put("param_uuid", this.jdField_u_of_type_JavaLangString);
      localHashMap.put("param_picSize", String.valueOf(this.jdField_g_of_type_Long));
      localHashMap.put("param_fileMd5", this.jdField_i_of_type_JavaLangString);
      localHashMap.put("param_busiType", this.jdField_j_of_type_Int + "");
      localHashMap.put("param_videoDuration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
      if (!paramBoolean) {
        break;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
      return;
      if ((this.jdField_k_of_type_Int == 9) || (this.jdField_k_of_type_Int == 17))
      {
        str = "actShortVideoDiscussgroupDownloadVideo";
        localHashMap.put("param_grpUin", this.jdField_n_of_type_JavaLangString);
      }
    }
    if (this.M != 56009) {
      localHashMap.remove("param_rspHeader");
    }
    localHashMap.put("param_FailCode", String.valueOf(this.M));
    StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, this.jdField_q_of_type_Long, 0L, localHashMap, "");
  }
  
  private boolean a(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i1 = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i1 == 0)) {
        break label72;
      }
    }
    label72:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label77;
      }
      QQToast.a(paramContext, 1, 2131368967, 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
      return false;
      i1 = 0;
      break;
    }
    label77:
    return true;
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i1;
      do
      {
        return null;
        i1 = paramString.indexOf(':');
      } while ((i1 < 0) || (i1 + 1 >= paramString.length()));
      paramString = paramString.substring(i1 + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void b(String paramString)
  {
    if (StringUtil.b(paramString)) {}
    for (;;)
    {
      return;
      paramString = paramString.split("\r\n");
      if (paramString != null)
      {
        this.E = a(paramString[0]);
        int i1 = 1;
        Object localObject1;
        if (i1 < paramString.length)
        {
          localObject1 = paramString[i1];
          if (((String)localObject1).startsWith("User-ReturnCode")) {
            this.jdField_q_of_type_JavaLangString = b((String)localObject1);
          }
          for (;;)
          {
            i1 += 1;
            break;
            if (((String)localObject1).startsWith("X-RtFlag")) {
              this.jdField_r_of_type_JavaLangString = b((String)localObject1);
            } else if (((String)localObject1).startsWith("Content-Type")) {
              this.jdField_s_of_type_JavaLangString = b((String)localObject1);
            }
          }
        }
        if ((jdField_b_of_type_ArrayOfJavaLangString != null) && (jdField_b_of_type_ArrayOfJavaLangString.length > 0) && (this.jdField_s_of_type_JavaLangString != null) && (this.jdField_s_of_type_JavaLangString.length() > 0))
        {
          if ((jdField_b_of_type_ArrayOfJavaLangString.length == 1) && (jdField_b_of_type_ArrayOfJavaLangString[0] != null) && (jdField_b_of_type_ArrayOfJavaLangString[0].toLowerCase().equals("allin")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "check content all in");
            }
            i1 = 1;
          }
          while (i1 == 0)
          {
            paramString = new StringBuilder();
            localObject1 = jdField_b_of_type_ArrayOfJavaLangString;
            int i2 = localObject1.length;
            i1 = 0;
            while (i1 < i2)
            {
              localObject2 = localObject1[i1];
              if (localObject2 != null)
              {
                paramString.append((String)localObject2);
                paramString.append("|");
              }
              i1 += 1;
              continue;
              paramString = jdField_b_of_type_ArrayOfJavaLangString;
              i2 = paramString.length;
              i1 = 0;
              for (;;)
              {
                if (i1 >= i2) {
                  break label435;
                }
                localObject1 = paramString[i1];
                if ((localObject1 != null) && (this.jdField_s_of_type_JavaLangString.contains((CharSequence)localObject1)))
                {
                  i1 = 1;
                  break;
                }
                i1 += 1;
              }
            }
            localObject1 = "not accept content type: real:" + this.jdField_s_of_type_JavaLangString + ". whiteList_type :" + paramString.toString();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, (String)localObject1);
            }
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put(BaseConstants.RDM_NoChangeFailCode, "");
            ((HashMap)localObject2).put("Content-Type", this.jdField_s_of_type_JavaLangString);
            ((HashMap)localObject2).put("White-List", paramString.toString());
            StatisticCollector.a(BaseApplication.getContext()).a(null, "actSDKDownloadHijacked", true, 0L, 0L, (HashMap)localObject2, "");
            throw new IOException((String)localObject1);
            label435:
            i1 = 0;
          }
        }
      }
    }
  }
  
  private void e(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131298743);
    if ((paramInt == 0) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", false)) && (ReadInJoyHelper.d((QQAppInterface)getAppRuntime())) && (this.jdField_t_of_type_Boolean))
    {
      localRelativeLayout.setVisibility(0);
      localRelativeLayout.setOnClickListener(new pkm(this));
      return;
    }
    localRelativeLayout.setVisibility(8);
  }
  
  private void w()
  {
    if (this.jdField_f_of_type_Boolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((ShortVideoBusiManager.jdField_a_of_type_Boolean) || (System.currentTimeMillis() - ShortVideoBusiManager.jdField_a_of_type_Long < 300000L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "needRemind=false");
        }
        i1 = 0;
      }
      if (i1 != 0)
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131371550), 2131367259, 2131367258, new pkg(this), new pkn(this));
        k();
        this.jdField_h_of_type_Boolean = false;
        a(localQQCustomDialog);
      }
      return;
    }
  }
  
  private void x()
  {
    this.jdField_t_of_type_Long = System.currentTimeMillis();
    this.jdField_m_of_type_Boolean = true;
    TVK_SDKMgr.installPlugin(getApplicationContext(), new pji(this));
  }
  
  private void y()
  {
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject = this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if ((localObject instanceof ShortVideoUploadProcessor))
      {
        localObject = (ShortVideoUploadProcessor)localObject;
        a(((ShortVideoUploadProcessor)localObject).b(), ((ShortVideoUploadProcessor)localObject).a());
      }
      localObject = FileTransferManager.a(this.app);
      if (localObject != null) {
        ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      }
      this.jdField_d_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      if (new File(this.jdField_d_of_type_JavaLangString).exists())
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
        this.jdField_g_of_type_Long = l1;
        this.jdField_f_of_type_Long = l1;
        this.jdField_v_of_type_Int = 100;
      }
      for (;;)
      {
        a(this.jdField_c_of_type_Long);
        return;
        a("上传状态错误，文件不存在");
      }
    }
    m();
    if ((this.jdField_j_of_type_Int == 1) || (this.jdField_j_of_type_Int == 2) || (this.jdField_l_of_type_Int == 9501))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if ((this.jdField_j_of_type_Int != 2) || (this.jdField_g_of_type_JavaLangString == null)) {}
    }
    try
    {
      localObject = new JSONObject(this.jdField_g_of_type_JavaLangString);
      this.jdField_k_of_type_Int = 1001;
      this.jdField_d_of_type_JavaLangString = a(((JSONObject)localObject).getString("file_md5"));
      this.jdField_g_of_type_Long = ((JSONObject)localObject).getInt("file_size");
      this.jdField_u_of_type_JavaLangString = ((JSONObject)localObject).getString("file_uuid");
      localObject = new File(this.jdField_d_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        this.jdField_f_of_type_Long = ((File)localObject).length();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_STRUCT_MSG#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_g_of_type_Long);
        }
        if (this.jdField_f_of_type_Long < this.jdField_g_of_type_Long) {
          this.jdField_f_of_type_Boolean = true;
        }
        if (this.jdField_f_of_type_Boolean)
        {
          A();
          localObject = FileTransferManager.a(this.app);
          if (localObject != null) {
            ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          }
          this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_v_of_type_Int);
        }
      }
      label470:
      label881:
      label902:
      for (;;)
      {
        this.jdField_l_of_type_Boolean = this.jdField_f_of_type_Boolean;
        if (this.jdField_f_of_type_Boolean) {
          break label904;
        }
        a(this.jdField_c_of_type_Long);
        return;
        this.jdField_f_of_type_Boolean = true;
        break;
        if (this.jdField_j_of_type_Int == 0)
        {
          int i1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(1) == 0)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getBitValue(0) == 1)
            {
              i1 = 101;
              PredictionReporter.a(1000, i1);
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(1, (byte)1);
              ThreadManager.a().post(new pjm(this));
            }
          }
          else
          {
            this.jdField_d_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            localObject = new File(this.jdField_d_of_type_JavaLangString);
            if (!((File)localObject).exists()) {
              break label881;
            }
            this.jdField_f_of_type_Long = ((File)localObject).length();
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + this.jdField_f_of_type_Long + " msg.size=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize + " status=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus);
            }
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_v_of_type_Int = 100;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(100);
            this.jdField_e_of_type_Boolean = false;
            if (this.jdField_f_of_type_Long >= this.jdField_g_of_type_Long) {}
          }
          for (this.jdField_f_of_type_Boolean = true;; this.jdField_f_of_type_Boolean = true)
          {
            if (!this.jdField_f_of_type_Boolean) {
              break label902;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, need download, startDownload...");
            }
            if (a(this.jdField_a_of_type_AndroidContentContext))
            {
              localObject = ShortVideoBusiManager.a(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
              if (localObject != null)
              {
                ShortVideoBusiManager.a((ShortVideoReq)localObject, this.app);
                this.jdField_k_of_type_Int = ((ShortVideoReq)localObject).a.g;
                a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
              }
            }
            localObject = FileTransferManager.a(this.app);
            if (localObject != null) {
              ((FileTransferManager)localObject).a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
            }
            this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.transferedSize;
            this.jdField_g_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
            this.jdField_v_of_type_Int = ((int)(100L * this.jdField_f_of_type_Long / this.jdField_g_of_type_Long));
            this.jdField_u_of_type_Int = 0;
            this.jdField_h_of_type_Long = 0L;
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidWidgetSeekBar.setSecondaryProgress(this.jdField_v_of_type_Int);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ShortVideoPlayActivity", 2, "onCreateVideoSdkView() mCacheProgress=" + this.jdField_v_of_type_Int + ",mTransferredSize=" + this.jdField_f_of_type_Long);
            break;
            i1 = 102;
            break label470;
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoPlayActivity", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
            }
          }
        }
      }
      label904:
      q();
      b(4);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void z()
  {
    if ((VersionUtils.g()) && (!ShortVideoUtils.c()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(1284);
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i1 = paramString.getInt("callBackType");
      int i2 = paramString.getInt("fileSize");
      if (i2 != this.jdField_g_of_type_Long)
      {
        this.jdField_g_of_type_Long = i2;
        QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] OnDownloadCallback fileSize mismatched msg.file=" + this.jdField_g_of_type_Long);
      }
      int i3 = paramString.getInt("newFileSize");
      this.jdField_f_of_type_Long = paramString.getInt("offset");
      int i4 = paramString.getInt("httpDownloadSum");
      this.jdField_x_of_type_Int = i4;
      if (i4 > 0) {
        this.y += 1;
      }
      int i5 = paramString.getInt("dataFromCacheSize");
      if (this.z < i5) {
        this.z = i5;
      }
      this.jdField_w_of_type_Int = paramString.getInt("speedKBS");
      if ((i1 == 7) || (i1 == 3))
      {
        if (i1 == 7)
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_f_of_type_Long = this.jdField_g_of_type_Long;
          this.N = 2003;
        }
        if (this.jdField_r_of_type_Long != 0L)
        {
          this.jdField_q_of_type_Long = (System.currentTimeMillis() - this.jdField_r_of_type_Long);
          this.jdField_r_of_type_Long = 0L;
        }
      }
      for (;;)
      {
        if (this.H == 0) {
          this.H = paramString.getInt("httpRedirectNum");
        }
        if (this.I == 0) {
          this.I = paramString.getInt("httpRedirectCostMs");
        }
        if ((paramString.has("httpDNSCostMs")) && (this.J == 0)) {
          this.J = paramString.getInt("httpDNSCostMs");
        }
        if ((paramString.has("httpConnectCostMs")) && (this.K == 0)) {
          this.K = paramString.getInt("httpConnectCostMs");
        }
        if ((paramString.has("httpFirstRecvCostMs")) && (this.L == 0)) {
          this.L = paramString.getInt("httpFirstRecvCostMs");
        }
        if ((paramString.has("httpURL")) && (this.jdField_t_of_type_JavaLangString == null)) {
          this.jdField_t_of_type_JavaLangString = paramString.getString("httpURL");
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        paramString = new StringBuilder("[MediaPlayer] OnDownloadCallback:");
        paramString.append("callBackType=").append(i1).append("|");
        paramString.append("fileSize=").append(i2).append("|");
        paramString.append("newFileSize=").append(i3).append("|");
        paramString.append("offset=").append(this.jdField_f_of_type_Long).append("|");
        paramString.append("httpDownloadSum=").append(i4).append("|");
        paramString.append("dataFromCacheSize=").append(i5).append("|");
        paramString.append("speedKBS=").append(this.jdField_w_of_type_Int).append("|");
        paramString.append("HttpRedirectNum=").append(this.H).append("|");
        paramString.append("HttpRedirectCostMs=").append(this.I).append("|");
        paramString.append("HttpDNSCost=").append(this.J).append("|");
        paramString.append("HttpConnectCost=").append(this.K).append("|");
        paramString.append("HttpFirstRecvCost=").append(this.L).append("|");
        paramString.append("mHttpUrl=").append(this.jdField_t_of_type_JavaLangString).append("|");
        QLog.i("ShortVideoPlayActivity", 2, paramString.toString());
        return;
        if ((i1 == 1) && (paramString.has("httpHeader")))
        {
          String str = paramString.getString("httpHeader");
          try
          {
            b(str);
          }
          catch (IOException localIOException)
          {
            this.M = 9064;
            a("视频文件已损坏!");
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    case 3: 
      return " error ";
    }
    return " buffering ";
  }
  
  public void a()
  {
    int i1 = 1;
    if (!this.jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(getApplicationContext()))
    {
      b();
      return;
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    while (i1 != 0)
    {
      x();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365289), 0).b(BaseApplicationImpl.a().getResources().getDimensionPixelSize(2131492908));
      return;
      i1 = 0;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365287), new pkr(this), new pjh(this)).show();
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_u_of_type_Boolean) {}
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      localRelativeLayout = (RelativeLayout)findViewById(2131298743);
      localRelativeLayout.bringToFront();
      if ((paramInt == 0) && (!this.jdField_t_of_type_Boolean))
      {
        this.jdField_t_of_type_Boolean = true;
        localRelativeLayout.setVisibility(0);
        localRelativeLayout.setOnClickListener(new pkk(this));
        localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(400L);
        localRelativeLayout.startAnimation(localTranslateAnimation);
        return;
      }
    } while ((paramInt != 1) || (!this.jdField_t_of_type_Boolean));
    this.jdField_t_of_type_Boolean = false;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(400L);
    localRelativeLayout.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new pkl(this, localRelativeLayout));
    localRelativeLayout.setVisibility(8);
  }
  
  public void a(long paramLong)
  {
    this.jdField_o_of_type_Boolean = true;
    a(paramLong, null, null);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    l1 = paramLong;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          l1 = paramLong;
          QLog.d("ShortVideoPlayActivity", 2, "#play#, msec=" + paramLong);
        }
        l1 = paramLong;
        this.jdField_a_of_type_Long = paramLong;
        i1 = 0;
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
        {
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.jdField_b_of_type_AndroidViewView);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
          l1 = paramLong;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
          l1 = paramLong;
          this.jdField_m_of_type_Long = System.currentTimeMillis();
          i1 = 1;
        }
        l1 = paramLong;
        if (this.jdField_k_of_type_Boolean)
        {
          i1 = 1;
          l1 = paramLong;
          this.C += 1;
        }
        if (i1 == 0) {
          continue;
        }
        if (paramLong != 0L) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() <= 0) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() == 100) {
          continue;
        }
        l1 = paramLong;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
          continue;
        }
        l1 = paramLong;
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000 * this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() / 100;
        paramLong = i1;
      }
      catch (Exception paramString1)
      {
        Object localObject1;
        Object localObject2;
        paramLong = l1;
        continue;
        if ((i1 != 4) && (i1 != 3)) {
          continue;
        }
        paramString2 = "1";
        continue;
        paramString2 = "2";
        continue;
        int i1 = 1;
        continue;
      }
      try
      {
        if (!StringUtil.b(paramString1))
        {
          paramString2 = new TVK_UserInfo("", "");
          localObject1 = new TVK_PlayerVideoInfo(2, paramString1, "");
          ((TVK_PlayerVideoInfo)localObject1).setConfigMap("keep_last_frame", "true");
          localObject2 = VideoPlayUtils.a();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, paramString2, (TVK_PlayerVideoInfo)localObject1, (String)localObject2, paramLong, 0L);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "#play#, vid=" + paramString1);
          }
          l1 = paramLong;
          this.jdField_k_of_type_Boolean = false;
          l1 = paramLong;
          if (this.jdField_j_of_type_Int == 0)
          {
            l1 = paramLong;
            if (!this.jdField_b_of_type_Boolean)
            {
              l1 = paramLong;
              if (this.jdField_l_of_type_Int != 0) {
                continue;
              }
              l1 = paramLong;
              ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "1", "", "");
              l1 = paramLong;
              this.jdField_b_of_type_Boolean = true;
            }
          }
          l1 = paramLong;
          if (this.jdField_e_of_type_Long >= 0L)
          {
            l1 = paramLong;
            this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
          }
          l1 = paramLong;
          this.jdField_e_of_type_Long = System.currentTimeMillis();
          l1 = paramLong;
          if (this.jdField_j_of_type_Int == 0)
          {
            l1 = paramLong;
            if (this.jdField_r_of_type_Boolean)
            {
              l1 = paramLong;
              if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
              {
                l1 = paramLong;
                i1 = NetworkUtil.a(BaseApplication.getContext());
                if (i1 != 1) {
                  continue;
                }
                paramString2 = "0";
                l1 = paramLong;
                if (this.jdField_l_of_type_Int != 1) {
                  continue;
                }
                i1 = 0;
                l1 = paramLong;
                if (!this.jdField_s_of_type_Boolean) {
                  continue;
                }
                l1 = paramLong;
                ReportController.b(this.app, "CliOper", "", "", "0X8006DF0", "0X8006DF0", 0, 0, paramString2, String.valueOf(i1), "", paramString1);
              }
            }
          }
          return;
        }
        if (!StringUtil.b(paramString2))
        {
          localObject1 = new TVK_UserInfo("", "");
          localObject2 = new TVK_PlayerVideoInfo(2, "", "");
          ((TVK_PlayerVideoInfo)localObject2).setConfigMap("keep_last_frame", "true");
          String str = VideoPlayUtils.a();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (TVK_UserInfo)localObject1, (TVK_PlayerVideoInfo)localObject2, str, paramLong, 0L);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "#play#, vid=" + paramString1);
          }
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext, paramString2, paramLong, 0L, (TVK_PlayerVideoInfo)localObject2);
          continue;
        }
        if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (!this.jdField_f_of_type_Boolean)) {
          continue;
        }
        if (this.jdField_j_of_type_Int == 0)
        {
          paramString2 = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          localObject1 = new TVK_PlayerVideoInfo();
          ((TVK_PlayerVideoInfo)localObject1).setConfigMap("file_dir", paramString2);
          ((TVK_PlayerVideoInfo)localObject1).setConfigMap("cache_servers_type", "20160518");
          ((TVK_PlayerVideoInfo)localObject1).setConfigMap("keep_last_frame", "true");
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
            ((TVK_PlayerVideoInfo)localObject1).setConfigMap("duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime));
          }
          ((TVK_PlayerVideoInfo)localObject1).setVid(this.jdField_i_of_type_JavaLangString);
          ((TVK_PlayerVideoInfo)localObject1).setPlayMode("cache_extend_video");
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoPlayActivity", 2, "#play#, setVid =" + this.jdField_i_of_type_JavaLangString + " videoPath=" + paramString2);
            QLog.d("ShortVideoPlayActivity", 2, "#play#, url0 =" + this.jdField_a_of_type_ArrayOfJavaLangString[0]);
          }
          this.jdField_r_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ArrayOfJavaLangString, paramLong, 0L, (TVK_PlayerVideoInfo)localObject1, null);
          continue;
        }
        if ((this.jdField_j_of_type_Int == 2) && (this.jdField_g_of_type_JavaLangString != null))
        {
          paramString2 = this.jdField_o_of_type_JavaLangString;
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideo caller type not right:" + this.jdField_j_of_type_Int);
        return;
      }
      catch (Exception paramString1) {}
      QLog.d("ShortVideoPlayActivity", 1, "#play#, msec=" + paramLong, paramString1);
      j();
      d(0);
      return;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "#play#, videoPath=" + this.jdField_d_of_type_JavaLangString);
        }
        paramString2 = new TVK_PlayerVideoInfo();
        paramString2.setConfigMap("keep_last_frame", "true");
        paramString2.setPlayType(4);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_d_of_type_JavaLangString, paramLong, 0L, paramString2);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoPlayActivity", 2, "#play#, mVideoPath should not be null!");
        return;
        l1 = paramLong;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
        continue;
        l1 = paramLong;
        if (this.jdField_l_of_type_Int == 3000)
        {
          l1 = paramLong;
          ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "2", "", "");
          l1 = paramLong;
          this.jdField_b_of_type_Boolean = true;
        }
        else
        {
          l1 = paramLong;
          if (this.jdField_l_of_type_Int == 1)
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "3", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
          }
          else
          {
            l1 = paramLong;
            ReportController.b(this.app, "CliOper", "", "", "0X8004673", "0X8004673", 0, 0, "", "4", "", "");
            l1 = paramLong;
            this.jdField_b_of_type_Boolean = true;
            continue;
            l1 = paramLong;
            paramString1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
          }
        }
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    this.jdField_d_of_type_JavaLangString = paramIntent.getExtras().getString("file_send_path");
    this.jdField_j_of_type_Int = paramIntent.getExtras().getInt("video_play_caller", 0);
    this.jdField_e_of_type_JavaLangString = paramIntent.getExtras().getString("ad_gdt");
    this.jdField_f_of_type_JavaLangString = paramIntent.getExtras().getString("msg_id");
    this.jdField_p_of_type_Int = paramIntent.getExtras().getInt("from_uin_type");
    this.jdField_n_of_type_JavaLangString = paramIntent.getExtras().getString("from_session_uin");
    this.jdField_l_of_type_Int = paramIntent.getExtras().getInt("uintype");
    this.jdField_g_of_type_JavaLangString = paramIntent.getExtras().getString("struct_msg_video_info");
    this.jdField_h_of_type_JavaLangString = paramIntent.getExtras().getString("from_uin");
    this.jdField_k_of_type_Long = paramIntent.getExtras().getLong("message_click_start");
    this.jdField_u_of_type_JavaLangString = paramIntent.getExtras().getString("file_uuid");
    this.jdField_i_of_type_JavaLangString = paramIntent.getExtras().getString("file_shortvideo_md5");
    this.jdField_j_of_type_JavaLangString = paramIntent.getExtras().getString("thumbfile_md5");
    if (this.jdField_j_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramIntent.getExtras().getParcelable("key_message_for_shortvideo"));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)
      {
        QQToast.a(this, 1, "参数错误，传入的shortvideoMsg为空！", 0).b(getTitleBarHeight());
        finish();
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      paramIntent = Boolean.valueOf(ReadInJoyHelper.f(this.app));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoAttr == 1) && ((this.jdField_l_of_type_Int == 1) || (this.jdField_l_of_type_Int == 3000)) && (paramIntent.booleanValue())) {
        this.jdField_r_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "initData(), PLAY_CALLER_SHORT_VIDEO, msg = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.toLogString() + ", mUinType = " + this.jdField_l_of_type_Int + ", isSupportMultiVideoSwitch() = " + paramIntent + ", mIsMultiVideoMode = " + this.jdField_r_of_type_Boolean);
      }
    }
    QLog.d("ShortVideoPlayActivity", 2, "initData(): mVideoPath=" + this.jdField_d_of_type_JavaLangString + ", mPlayCallerType=" + this.jdField_j_of_type_Int + ", mCursessionType = " + this.jdField_p_of_type_Int + ", mCurSessionUin = " + this.jdField_n_of_type_JavaLangString + ", mUinType = " + this.jdField_l_of_type_Int + " mIsMultiVideoMode=" + this.jdField_r_of_type_Boolean);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramFileMsg.jdField_c_of_type_Long)) && (this.jdField_j_of_type_Int != 2)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
        }
        if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage msg.uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(paramFileMsg.e) + " ===> fileStatus:" + ShortVideoUtils.b(paramFileMsg.Z));
        }
      } while ((paramFileMsg.e != 6) && (paramFileMsg.e != 17) && (paramFileMsg.e != 9) && (paramFileMsg.e != 20));
      switch (paramFileMsg.Z)
      {
      case 2004: 
      default: 
        return;
      case 1002: 
        a(paramFileMsg.jdField_f_of_type_Long, paramFileMsg.jdField_a_of_type_Long);
        return;
      case 2003: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "handleMessage STATUS_RECV_FINISHED");
        }
        this.jdField_v_of_type_Int = 100;
        return;
      case 2005: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371526, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        this.M = paramFileMsg.aE;
        return;
      case 5001: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371527, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        this.M = paramFileMsg.aE;
        return;
      case 5002: 
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131371528, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        this.M = paramFileMsg.aE;
        return;
      case 2002: 
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "STATUS_RECV_PROCESS: get url finished");
        }
        this.jdField_q_of_type_Int = ((int)(System.currentTimeMillis() - this.jdField_e_of_type_Long));
      }
    } while (paramFileMsg.jdField_c_of_type_ArrayOfJavaLangString == null);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.jdField_c_of_type_ArrayOfJavaLangString;
    this.jdField_c_of_type_JavaLangString = paramFileMsg.w;
    this.jdField_u_of_type_Long = paramFileMsg.jdField_h_of_type_Long;
    paramInt1 = i1;
    while (paramInt1 < 1)
    {
      if (!StringUtil.b(this.jdField_c_of_type_JavaLangString))
      {
        paramView = new StringBuilder();
        paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
        paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + this.jdField_c_of_type_JavaLangString);
      }
      paramInt1 += 1;
    }
    a(0L);
    return;
    B();
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onVideoChanged()");
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    for (int i1 = 1; (i1 == 0) && (this.jdField_w_of_type_Boolean); i1 = 0)
    {
      DialogUtil.a(this, 232, getApplicationContext().getString(2131371551), getApplicationContext().getString(2131371552), getApplicationContext().getString(2131367262), "继续观看", new pkh(this, paramVideoInfo), new pki(this)).show();
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_H5_URL", paramVideoInfo.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_COVER", paramVideoInfo.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_VID", paramVideoInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_WIDTH", String.valueOf(paramVideoInfo.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_HEIGHT", String.valueOf(paramVideoInfo.jdField_b_of_type_Int));
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_TIME", String.valueOf(paramVideoInfo.jdField_c_of_type_Int));
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.jdField_j_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.jdField_i_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_SUMMARY", paramVideoInfo.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_TITLE", paramVideoInfo.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_CREATE_TIME", paramVideoInfo.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", paramVideoInfo.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_ICON", paramVideoInfo.m);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_NAME", paramVideoInfo.jdField_k_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_ACTION", paramVideoInfo.l);
    this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoInfo.jdField_d_of_type_Int);
    Bundle localBundle = new Bundle();
    localBundle.putString("VINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    localBundle.putString("TINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("PREVIEW_VIDEO_TIME", paramVideoInfo.jdField_c_of_type_Int);
    localBundle.putInt("PREVIEW_VIDEO_WIDTH", paramVideoInfo.jdField_a_of_type_Int);
    localBundle.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoInfo.jdField_b_of_type_Int);
    localBundle.putInt("FULL_VIDEO_TIME", paramVideoInfo.jdField_c_of_type_Int);
    localBundle.putString("ACCOUNT_UIN", paramVideoInfo.jdField_i_of_type_JavaLangString);
    localBundle.putString("source_puin", paramVideoInfo.jdField_i_of_type_JavaLangString);
    localBundle.putString("ACCOUNT_NAME", paramVideoInfo.jdField_j_of_type_JavaLangString);
    localBundle.putInt("TYPE", paramVideoInfo.jdField_d_of_type_Int);
    localBundle.putString("ARTICLE_ID", paramVideoInfo.jdField_g_of_type_JavaLangString);
    localBundle.putInt("layout_item", 5);
    localBundle.putBoolean("video_url_load", false);
    localBundle.putString("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
    localBundle.putString("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString);
    localBundle.putString("video_url", paramVideoInfo.jdField_a_of_type_JavaLangString);
    localBundle.putString("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
    localBundle.putString("req_create_time", paramVideoInfo.jdField_e_of_type_JavaLangString);
    localBundle.putString("brief_key", paramVideoInfo.jdField_c_of_type_JavaLangString);
    StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)StructMsgFactory.a(localBundle);
    this.jdField_a_of_type_AndroidOsBundle.putByteArray("STRUCT_MSG_BYTES", localStructMsgForGeneralShare.getBytes());
    this.jdField_s_of_type_Boolean = true;
    a(this.jdField_a_of_type_AndroidOsBundle);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setHeaderViewData(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(Long.parseLong(super.getAppInterface().a()), paramVideoInfo.jdField_g_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.c(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.d(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.e(0);
    this.jdField_t_of_type_Boolean = false;
    e(8);
    if (paramVideoInfo.jdField_a_of_type_Int <= paramVideoInfo.jdField_b_of_type_Int)
    {
      this.Q = 0;
      if ((this.jdField_r_of_type_Boolean) && ((paramVideoInfo.jdField_d_of_type_Int == 1) || (TextUtils.isEmpty(paramVideoInfo.jdField_k_of_type_JavaLangString)))) {
        break label894;
      }
    }
    for (;;)
    {
      try
      {
        i1 = paramVideoInfo.jdField_k_of_type_JavaLangString.hashCode();
        paramVideoInfo = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
        ReportController.b(this.app, "CliOper", "", "", "0X8006763", "0X8006763", 0, 0, "3", String.valueOf(i1), null, paramVideoInfo);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ShortVideoPlayActivity", 2, "onVideoChanged() mBundle=" + this.jdField_a_of_type_AndroidOsBundle.toString() + ", data=" + localBundle.toString());
        return;
        this.Q = 1;
      }
      catch (Exception paramVideoInfo)
      {
        i1 = 1;
        continue;
      }
      label894:
      i1 = 1;
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    String str = ShortVideoUtils.d(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "1", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 3000)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "2", str, "");
      return;
    }
    if (paramMessageForShortVideo.istroop == 1)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "3", str, "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004672", "0X8004672", 0, 0, "", "4", str, "");
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onCompletion(), mPlayProgress=" + this.jdField_u_of_type_Int + ", mCacheProgress=" + this.jdField_v_of_type_Int + ", mCurPlayPosition" + this.jdField_h_of_type_Long + ", mDuration=" + this.jdField_b_of_type_Long);
    }
    this.jdField_u_of_type_Int = 100;
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(100);
    if ((this.jdField_j_of_type_Int == 2) && (this.jdField_i_of_type_Int == 1)) {
      a(this.jdField_e_of_type_JavaLangString, 2, 1002, this.jdField_f_of_type_JavaLangString);
    }
    b(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidWidgetTextView.getText());
    d();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_e_of_type_Long >= 0L)
    {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      if (!this.jdField_d_of_type_Boolean)
      {
        new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_p_of_type_Int, this.jdField_n_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
        this.jdField_d_of_type_Boolean = true;
      }
    }
    u();
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.F = paramInt1;
    this.G = paramInt2;
    u();
    a(false);
    this.N = 2005;
    b(3);
    j();
    d(paramInt2);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new pjk(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    String str;
    if (!TextUtils.isEmpty(paramString1)) {
      str = "0";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      paramString1 = str;
      if (localJSONObject.has("ad_id")) {
        paramString1 = localJSONObject.getString("ad_id");
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "parse ad_id error");
        }
        paramString1 = "0";
      }
    }
    ReportController.b(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, paramString1, paramString2, "", "");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(paramString, paramBoolean);
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#resume#");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_i_of_type_Int == 2))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      b(1);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Long >= 0L) {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
      }
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).addViewCallBack(this);
        if (!this.jdField_r_of_type_Boolean) {
          this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        }
        for (;;)
        {
          y();
          return;
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidViewView, 0);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void b(int paramInt)
  {
    runOnUiThread(new pjq(this, paramInt));
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      long l1 = paramLong;
      if (paramLong < 0L) {
        l1 = 0L;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(l1));
    }
  }
  
  public boolean b()
  {
    return (this.jdField_i_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  void c()
  {
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)getLayoutInflater().inflate(2130904356, null, false));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131296895));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302506));
    z();
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302501);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302496));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302497));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302511));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302508));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302510));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302509));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302507));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302498));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302499));
    if ((this.jdField_j_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1001) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1002)) && (this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) != null))
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302502));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302504));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302503));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidWidgetRelativeLayout.findViewById(2131302505));
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131302493));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131302494));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
    localObject = (RelativeLayout)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131298744);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = ImmersiveUtils.a(getApplicationContext());
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131300191));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    b(0L);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(0L));
    o();
    p();
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
      break label24;
    }
    label24:
    do
    {
      do
      {
        return;
      } while (paramInt == this.jdField_i_of_type_Int);
      if (isFinishing())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, while finishing");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "changePlayState, " + a(this.jdField_i_of_type_Int) + " ==> " + a(paramInt));
      }
      if ((this.jdField_i_of_type_Int == 1) && (paramInt != 1)) {
        if (this.jdField_j_of_type_Long != 0L)
        {
          this.jdField_i_of_type_Long += System.currentTimeMillis() - this.jdField_j_of_type_Long;
          this.jdField_v_of_type_Long = this.jdField_i_of_type_Long;
        }
      }
      for (;;)
      {
        this.jdField_i_of_type_Int = paramInt;
        switch (paramInt)
        {
        default: 
          return;
        case 0: 
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841018);
          return;
          if ((this.jdField_i_of_type_Int == 4) && (paramInt != 4) && (this.jdField_p_of_type_Long != 0L)) {
            this.jdField_o_of_type_Long += System.currentTimeMillis() - this.jdField_p_of_type_Long;
          }
          break;
        }
      }
      this.jdField_j_of_type_Long = System.currentTimeMillis();
      this.A += 1;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841019);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
      e();
      q();
      r();
    } while (this.jdField_f_of_type_AndroidWidgetRelativeLayout == null);
    this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return;
    this.B += 1;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841018);
    return;
    this.jdField_p_of_type_Long = System.currentTimeMillis();
    this.D += 1;
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_f_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
    return;
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841018);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean c()
  {
    return this.jdField_i_of_type_Int == 4;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startShowing : mHidden = " + this.jdField_j_of_type_Boolean);
    }
    if (!this.jdField_j_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  void d(int paramInt)
  {
    this.jdField_t_of_type_Int = 0;
    this.M = 9001;
    String str1 = getString(2131371524);
    Object localObject;
    int i1;
    if ((paramInt == 101) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.b(this.jdField_c_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      i1 = localObject.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        String str2 = localObject[paramInt];
        if (!StringUtil.b(str2)) {
          InnerDns.a().a(this.jdField_c_of_type_JavaLangString, InnerDns.a(str2), 1005);
        }
        paramInt += 1;
      }
    }
    if (this.jdField_j_of_type_Int == 1)
    {
      q();
      r();
      str1 = getString(2131371541);
      a(DialogUtil.a(this, 232, null, str1, new pjr(this), null));
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "handleError，mPlayCallerType = " + this.jdField_j_of_type_Int);
      }
      this.jdField_d_of_type_Long = -1L;
      this.jdField_e_of_type_Long = -1L;
      return;
    }
    if (this.jdField_j_of_type_Int == 0)
    {
      if ((!this.jdField_r_of_type_Boolean) || (!this.jdField_s_of_type_Boolean)) {
        break label390;
      }
      str1 = "播放错误";
    }
    label390:
    for (;;)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        i1 = (int)(DeviceInfoUtil.d() / 1024L);
        if (!StringUtil.b(this.jdField_d_of_type_JavaLangString)) {}
        for (paramInt = (int)(new File(this.jdField_d_of_type_JavaLangString).length() / 1024L);; paramInt = 0)
        {
          localObject = DeviceInfoUtil.d();
          ReportController.b(this.app, "CliOper", "", "", "0X8004674", "0X8004674", 0, 0, "" + i1, "" + paramInt, (String)localObject, this.jdField_i_of_type_JavaLangString);
          this.jdField_c_of_type_Boolean = true;
          break;
          if (this.jdField_j_of_type_Int == 2)
          {
            a(this.jdField_e_of_type_JavaLangString, 0, 1002, this.jdField_f_of_type_JavaLangString);
            str1 = getString(2131371541);
            break;
          }
          break;
        }
      }
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 21) {}
    switch (paramInt2)
    {
    default: 
      return;
    }
    ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    g();
    overridePendingTransition(0, 2130968823);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130904355);
    getWindow().addFlags(128);
    this.O = getResources().getDisplayMetrics().widthPixels;
    this.P = getResources().getDisplayMetrics().heightPixels;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("ShortVideoPlayActivity", 2, localStringBuilder.toString());
    }
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Long = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onCreate(), savedInstanceState != null, mCurrentPosition : " + this.jdField_c_of_type_Long);
      }
    }
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getExtras();
    a(super.getIntent());
    c();
    if (this.jdField_r_of_type_Boolean) {
      D();
    }
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.app.a(ShortVideoPlayActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnDestroy");
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    g();
    TVK_SDKMgr.setOnLogListener(null);
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      ((IVideoViewBase)this.jdField_b_of_type_AndroidViewView).removeViewCallBack(this);
      this.jdField_b_of_type_AndroidViewView = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.app.a(ShortVideoPlayActivity.class);
      if (this.jdField_e_of_type_Long >= 0L)
      {
        this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_d_of_type_Boolean)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.app, 2002, (int)(this.jdField_b_of_type_Long / 1000L), this.jdField_p_of_type_Int, this.jdField_n_of_type_JavaLangString, this.jdField_d_of_type_Long / 1000L);
          this.jdField_d_of_type_Boolean = true;
        }
      }
      if (this.jdField_e_of_type_Boolean) {
        new DCShortVideo(BaseApplication.getContext()).a(true, this.jdField_q_of_type_Int, this.jdField_u_of_type_Int, this.jdField_v_of_type_Int, (int)this.jdField_b_of_type_Long, (int)this.jdField_g_of_type_Long, 0, this.jdField_r_of_type_Int, this.jdField_t_of_type_Int, this.jdField_d_of_type_Long);
      }
      long l1;
      long l2;
      long l3;
      if ((this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null))
      {
        l1 = this.jdField_v_of_type_Long;
        l2 = this.jdField_h_of_type_Long;
        l3 = this.jdField_b_of_type_Long;
        if (!this.jdField_s_of_type_Boolean) {
          break label416;
        }
      }
      label416:
      for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");; str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5())
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006DF1", "0X8006DF1", 0, 0, String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), str);
        if (!this.jdField_g_of_type_Boolean)
        {
          u();
          a(true);
          C();
        }
        if (this.jdField_r_of_type_Boolean)
        {
          super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
          super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a();
          }
          VideoReporter.a("3");
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    do
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    if (this.jdField_l_of_type_Int != 9501) {
      n();
    }
    return true;
  }
  
  public void doOnPause()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "pause mCurrentPosition:" + this.jdField_c_of_type_Long);
      }
    }
    for (;;)
    {
      super.doOnPause();
      return;
      if (c()) {
        this.jdField_h_of_type_Boolean = true;
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "doOnResume: mInterrupted = " + this.jdField_i_of_type_Boolean + ", mNeedPlay = " + this.jdField_h_of_type_Boolean + " mSurfaceViewDestroyed=" + this.jdField_x_of_type_Boolean);
    }
    z();
    if (this.jdField_i_of_type_Boolean)
    {
      if (!this.jdField_h_of_type_Boolean) {
        break label139;
      }
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!a())) {
        a(this.jdField_c_of_type_Long);
      }
    }
    label139:
    do
    {
      do
      {
        do
        {
          if ((this.jdField_r_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoListView != null)) {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.b();
          }
          return;
        } while (Build.VERSION.SDK_INT < 10);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause, mCurrentPosition=" + this.jdField_c_of_type_Long);
        }
        if ((!this.jdField_r_of_type_Boolean) || (!this.jdField_s_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mIsMultiVideoMode=" + this.jdField_r_of_type_Boolean + ", mIsPlayingPublicAccountVideo=" + this.jdField_s_of_type_Boolean + " RETURN");
      return;
      if (this.jdField_x_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoPlayActivity", 2, "onResume, restore last pause mIsMultiVideoMode=" + this.jdField_r_of_type_Boolean + ", mSurfaceViewDestroyed=" + this.jdField_x_of_type_Boolean);
    return;
    if (this.jdField_j_of_type_Int == 0) {
      if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!FileUtils.b(this.jdField_d_of_type_JavaLangString))) {}
    }
    for (;;)
    {
      try
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidGraphicsBitmap = localMediaMetadataRetriever.getFrameAtTime(this.jdField_c_of_type_Long * 1000L);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
        continue;
      }
      if (this.jdField_j_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      }
    }
  }
  
  protected void doOnStart()
  {
    MediaPlayerManager.a(this.app).a(true);
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.doOnStop();
  }
  
  void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "delayStartHiding");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    if ((this.jdField_i_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "startHiding : mHidden = " + this.jdField_j_of_type_Boolean + ",playState:" + a(this.jdField_i_of_type_Int));
    }
    if (this.jdField_j_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_i_of_type_Int != 1);
      this.jdField_j_of_type_Boolean = true;
    } while (((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_c_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)) || (Build.VERSION.SDK_INT < 11));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
    b(0);
  }
  
  public void h()
  {
    if (this.jdField_i_of_type_Int == 1) {
      k();
    }
    I();
    if (this.jdField_r_of_type_Boolean) {
      if (!this.jdField_s_of_type_Boolean) {
        break label70;
      }
    }
    label70:
    for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");; str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5())
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8006DF2", "0X8006DF2", 0, 0, "4", null, null, str);
      return;
    }
  }
  
  public void i()
  {
    long l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "initDuration: duration=" + l1);
    }
    if (l1 != 0L)
    {
      this.jdField_b_of_type_Long = ((int)l1);
      this.jdField_k_of_type_JavaLangString = ShortVideoUtils.a(this.jdField_b_of_type_Long);
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!this.jdField_b_of_type_AndroidWidgetTextView.getText().equals(this.jdField_k_of_type_JavaLangString))) {
        runOnUiThread(new pjp(this));
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void j()
  {
    b(0);
  }
  
  public void k()
  {
    if (b())
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    b(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "#pause# , mCurrentPosition = " + this.jdField_c_of_type_Long);
    }
    if (this.jdField_e_of_type_Long >= 0L) {
      this.jdField_d_of_type_Long += System.currentTimeMillis() - this.jdField_e_of_type_Long;
    }
  }
  
  void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "handleClick: mPlayState = " + a(this.jdField_i_of_type_Int) + ", mCurrentPosition = " + this.jdField_c_of_type_Long + ", mIsMultiVideoMode = " + this.jdField_r_of_type_Boolean + ", mIsPlayingPublicAccountVideo = " + this.jdField_s_of_type_Boolean);
    }
    switch (this.jdField_i_of_type_Int)
    {
    case 4: 
    default: 
    case 0: 
    case 1: 
    case 2: 
      do
      {
        return;
        if ((this.jdField_r_of_type_Boolean) && (this.jdField_s_of_type_Boolean))
        {
          a(this.jdField_a_of_type_AndroidOsBundle);
          return;
        }
        a(this.jdField_c_of_type_Long);
        return;
        k();
        return;
        a();
      } while ((this.jdField_c_of_type_Long == 0L) || (!this.jdField_x_of_type_Boolean));
      if ((this.jdField_r_of_type_Boolean) && (this.jdField_s_of_type_Boolean))
      {
        a(this.jdField_a_of_type_AndroidOsBundle);
        return;
      }
      a(this.jdField_c_of_type_Long);
      return;
    }
    if ((this.jdField_r_of_type_Boolean) && (this.jdField_s_of_type_Boolean))
    {
      a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    a(0L);
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onClick surfaceView, mHidden=" + this.jdField_j_of_type_Boolean);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      d();
      e();
    }
  }
  
  void n()
  {
    int i1 = 0;
    String str2 = getResources().getString(2131371540);
    String str3 = getResources().getString(2131371519);
    String str4 = getResources().getString(2131371523);
    String str5 = getResources().getString(2131367262);
    String str1;
    boolean bool1;
    ActionSheet localActionSheet;
    if (this.jdField_j_of_type_Int == 0)
    {
      str1 = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
      bool1 = FileUtils.a(str1);
      if (this.jdField_f_of_type_Boolean) {
        bool1 = false;
      }
      boolean bool2 = "1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"));
      if (getIntent().getIntExtra("from_busi_type", 0) == 2) {
        i1 = 1;
      }
      localActionSheet = ActionSheet.a(this);
      if ((bool2) && (this.jdField_l_of_type_Int != 9501) && (i1 == 0)) {
        localActionSheet.c(str2);
      }
      if ((this.jdField_j_of_type_Int != 3) && (!this.jdField_s_of_type_Boolean))
      {
        if (!bool1) {
          break label232;
        }
        localActionSheet.c(str3);
        localActionSheet.c(str4);
      }
    }
    for (;;)
    {
      localActionSheet.d(str5);
      localActionSheet.show();
      localActionSheet.a(new pjw(this, localActionSheet, str2, str3, bool1, str1, str4));
      return;
      str1 = this.jdField_d_of_type_JavaLangString;
      break;
      label232:
      localActionSheet.a(str3, 7);
      localActionSheet.a(str4, 7);
    }
  }
  
  void o()
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void onBackPressed()
  {
    if ((this.jdField_r_of_type_Boolean) && (this.jdField_v_of_type_Boolean))
    {
      v();
      return;
    }
    t();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131302501: 
    default: 
      return;
    case 2131302493: 
      t();
      return;
    case 2131302503: 
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      t();
      return;
    case 2131302507: 
      m();
      l();
      return;
    case 2131302495: 
    case 2131302511: 
      m();
      if (this.jdField_i_of_type_Int == 1) {
        k();
      }
      n();
      return;
    case 2131300191: 
      if (this.jdField_r_of_type_Boolean)
      {
        if (this.jdField_v_of_type_Boolean)
        {
          v();
          return;
        }
        t();
        return;
      }
      t();
      return;
    }
    v();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new pjz(this, paramTVK_IMediaPlayer));
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onError what=" + paramInt1 + ",extra=" + paramInt2 + ",mCacheProgress=" + this.jdField_v_of_type_Int + ", mPlayProgress=" + this.jdField_u_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    runOnUiThread(new pka(this, paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject));
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onInfo what=" + paramInt + ",extra=" + paramObject + ",mCacheProgress=" + this.jdField_v_of_type_Int + ", mPlayProgress=" + this.jdField_u_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video start buffering !");
      }
      b(4);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "video end buffering !");
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        b(1);
      } else {
        b(2);
      }
    }
  }
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=" + this.jdField_v_of_type_Int + ", mPlayProgress=" + this.jdField_u_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.jdField_k_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_h_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_c_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_c_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSeekComplete mCacheProgress=" + this.jdField_v_of_type_Int + ", mPlayProgress=" + this.jdField_u_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void onSurfaceDestory(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onSurfaceDestory");
    }
    this.jdField_x_of_type_Boolean = true;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPrepared: mDuration=" + this.jdField_b_of_type_Long + " mInterrupted" + this.jdField_i_of_type_Boolean + " mNeedPlay" + this.jdField_h_of_type_Boolean);
    }
    this.jdField_x_of_type_Boolean = false;
    runOnUiThread(new pkb(this));
    if (this.jdField_j_of_type_Int == 2) {
      a(this.jdField_e_of_type_JavaLangString, 1, 1002, this.jdField_f_of_type_JavaLangString);
    }
    if (this.jdField_k_of_type_Long != 0L)
    {
      this.jdField_l_of_type_Long = (System.currentTimeMillis() - this.jdField_k_of_type_Long);
      this.jdField_k_of_type_Long = 0L;
    }
    if (this.jdField_m_of_type_Long != 0L)
    {
      this.jdField_n_of_type_Long = (System.currentTimeMillis() - this.jdField_m_of_type_Long);
      this.jdField_m_of_type_Long = 0L;
    }
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = false;
      if (!this.jdField_h_of_type_Boolean) {
        return;
      }
    }
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_b_of_type_Long <= 0L) {
      i();
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    if (this.jdField_a_of_type_Long > 0L) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_a_of_type_Long);
    }
    b(1);
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=" + this.jdField_v_of_type_Int + ", mPlayProgress=" + this.jdField_u_of_type_Int + ", mCurPlayPosition=" + this.jdField_h_of_type_Long);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      z();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
  
  void p()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
    {
      localObject = ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, "jpg");
      if (!FileUtils.b((String)localObject)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(-16777216);
      localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "showLoadingImage crashed =" + localException.toString());
        }
      }
    }
  }
  
  public void q()
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void r()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    a(DialogUtil.a(this, 232, null, getString(2131371542), new pjx(this), new pjy(this)));
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "userBackPressed");
    }
    g();
    setResult(-1, getIntent());
    finish();
    try
    {
      overridePendingTransition(2130968620, 2130968621);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoPlayActivity", 2, "[MediaPlayer] overridePendingTransition=" + localException);
    }
  }
  
  public void u()
  {
    int i2 = -1;
    if (!this.jdField_o_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.jdField_f_of_type_Boolean)
    {
      i1 = 1;
      if (this.jdField_t_of_type_Int == 0) {
        i1 = 3;
      }
      localHashMap.put("player_state", String.valueOf(i1));
      localStringBuffer.append(" player_state " + i1);
      localHashMap.put("Download", String.valueOf(this.jdField_l_of_type_Boolean));
      localStringBuffer.append(" Download" + this.jdField_l_of_type_Boolean);
      localHashMap.put("FileSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" FileSize" + this.jdField_g_of_type_Long);
      localHashMap.put("HttpDownloadSum", String.valueOf(this.jdField_x_of_type_Int));
      localStringBuffer.append(" HttpDownloadSum" + this.jdField_x_of_type_Int);
      if (this.jdField_l_of_type_Boolean) {
        break label1190;
      }
      localHashMap.put("DataFromCacheSize", String.valueOf(this.jdField_g_of_type_Long));
      localStringBuffer.append(" DataFromCacheSize" + this.jdField_g_of_type_Long);
      label272:
      localHashMap.put("FileDuration", String.valueOf(this.jdField_b_of_type_Long));
      localStringBuffer.append(" FileDuration" + this.jdField_b_of_type_Long);
      localHashMap.put("PlayTime", String.valueOf(this.jdField_i_of_type_Long));
      localStringBuffer.append(" PlayTime" + this.jdField_i_of_type_Long);
      localHashMap.put("PlayStateCount", String.valueOf(this.A));
      localStringBuffer.append(" PlayStateCount" + this.A);
      localHashMap.put("PlayProgress", String.valueOf(this.jdField_u_of_type_Int));
      localStringBuffer.append(" PlayProgress" + this.jdField_u_of_type_Int);
      localHashMap.put("FirstPlayTime", String.valueOf(this.jdField_l_of_type_Long));
      localStringBuffer.append(" FirstPlayTime" + this.jdField_l_of_type_Long);
      localHashMap.put("FirstBufferTime", String.valueOf(this.jdField_n_of_type_Long));
      localStringBuffer.append(" FirstBufferTime" + this.jdField_n_of_type_Long);
      localHashMap.put("SeekTimes", String.valueOf(this.jdField_s_of_type_Int));
      localStringBuffer.append(" SeekTimes" + this.jdField_s_of_type_Int);
      if (this.D != 0) {
        break label1236;
      }
      i1 = this.D;
      label586:
      localHashMap.put("BufferTimes", String.valueOf(i1));
      localStringBuffer.append(" BufferTimes" + i1);
      localHashMap.put("BufferCostTime", String.valueOf(this.jdField_o_of_type_Long));
      localStringBuffer.append(" BufferCostTime" + this.jdField_o_of_type_Long);
      if (this.jdField_r_of_type_Long != 0L)
      {
        this.jdField_q_of_type_Long = (System.currentTimeMillis() - this.jdField_r_of_type_Long);
        this.jdField_r_of_type_Long = 0L;
      }
      if (this.y == 0) {
        break label2207;
      }
    }
    label766:
    label1190:
    label1236:
    label1253:
    label1263:
    label1933:
    label2001:
    label2189:
    label2195:
    label2201:
    label2207:
    for (int i1 = this.jdField_x_of_type_Int / (this.y * 1000);; i1 = 0)
    {
      localHashMap.put("SpeedKBS", String.valueOf(i1));
      localStringBuffer.append(" SpeedKBS" + i1);
      if (this.C > 0)
      {
        str1 = "1";
        localHashMap.put("IsRePlay", str1);
        localStringBuffer.append(" IsRePlay" + this.C);
        localHashMap.put("SuspendTimes", String.valueOf(this.B));
        localStringBuffer.append(" SuspendTimes" + this.B);
        if (this.M == 0) {
          break label1253;
        }
        localHashMap.put("param_FailCode", String.valueOf(this.M));
      }
      Object localObject;
      for (boolean bool = false;; bool = true)
      {
        localHashMap.put("ErrorCode", String.valueOf(this.F));
        localHashMap.put("ErrorDetailCode", String.valueOf(this.G));
        localHashMap.put("HttpStatus", String.valueOf(this.E));
        localStringBuffer.append(" HttpStatus" + this.E);
        localHashMap.put("User-ReturnCode", this.jdField_q_of_type_JavaLangString);
        localStringBuffer.append(" User-ReturnCode" + this.jdField_q_of_type_JavaLangString);
        localHashMap.put("X-RtFlag", this.jdField_r_of_type_JavaLangString);
        localStringBuffer.append(" X-RtFlag" + this.jdField_r_of_type_JavaLangString);
        localObject = new StringBuffer("");
        str1 = null;
        if (!StringUtil.b(this.jdField_t_of_type_JavaLangString)) {
          str1 = InnerDns.a(this.jdField_t_of_type_JavaLangString);
        }
        i1 = i2;
        if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {
          break label1263;
        }
        i1 = i2;
        if (this.jdField_a_of_type_ArrayOfJavaLangString.length <= 0) {
          break label1263;
        }
        i1 = 0;
        int i3;
        for (i2 = -1; i1 < this.jdField_a_of_type_ArrayOfJavaLangString.length; i2 = i3)
        {
          String str2 = InnerDns.a(this.jdField_a_of_type_ArrayOfJavaLangString[i1]);
          ((StringBuffer)localObject).append(str2 + ",");
          i3 = i2;
          if (i2 == -1)
          {
            i3 = i2;
            if (!StringUtil.b(str1))
            {
              i3 = i2;
              if (str1.equals(str2)) {
                i3 = i1;
              }
            }
          }
          i1 += 1;
        }
        i1 = 2;
        break;
        localHashMap.put("DataFromCacheSize", String.valueOf(this.z));
        localStringBuffer.append(" DataFromCacheSize" + this.z);
        break label272;
        i1 = this.D - 1;
        break label586;
        str1 = "0";
        break label766;
      }
      i1 = i2;
      localHashMap.put("IpList", ((StringBuffer)localObject).toString());
      i1 += 1;
      localHashMap.put("SuccIpIndex", String.valueOf(i1));
      localStringBuffer.append(" SuccIpIndex" + i1);
      localHashMap.put("HttpDomain", this.jdField_c_of_type_JavaLangString);
      localStringBuffer.append(" HttpDomain" + this.jdField_c_of_type_JavaLangString);
      localHashMap.put("HttpRedirectNum", String.valueOf(this.H));
      localStringBuffer.append(" HttpRedirectNum" + this.H);
      localHashMap.put("HttpRedirectCostMs", String.valueOf(this.I));
      localStringBuffer.append(" HttpRedirectCostMs" + this.I);
      localHashMap.put("HttpDnsCostMs", String.valueOf(this.J));
      localStringBuffer.append(" HttpDnsCostMs" + this.J);
      localHashMap.put("HttpConnectCostMs", String.valueOf(this.K));
      localStringBuffer.append(" HttpConnectCostMs" + this.K);
      localHashMap.put("HttpFirstRecvCostMs", String.valueOf(this.L));
      localStringBuffer.append(" HttpFirstRecvCostMs" + this.L);
      localHashMap.put("RetrySuccessTimes", "0");
      localHashMap.put("RetryFailedTimes", "0");
      localHashMap.put("ApplyCostTime", String.valueOf(this.jdField_u_of_type_Long));
      localStringBuffer.append(" ApplyCostTime" + this.jdField_u_of_type_Long);
      localHashMap.put("HttpCostTime", String.valueOf(this.jdField_q_of_type_Long));
      localStringBuffer.append(" HttpCostTime" + this.jdField_q_of_type_Long);
      localHashMap.put("DownType", "1");
      localHashMap.put("SceneType", "2");
      localHashMap.put("BusiType", String.valueOf(this.jdField_j_of_type_Int));
      localHashMap.put("SubBusiType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.subBusiType));
      localHashMap.put("FromUin", String.valueOf(this.jdField_h_of_type_JavaLangString));
      localHashMap.put("GrpUin", String.valueOf(this.jdField_n_of_type_JavaLangString));
      localHashMap.put("Uuid", String.valueOf(this.jdField_u_of_type_JavaLangString));
      localHashMap.put("MsgFileMd5", String.valueOf(this.jdField_i_of_type_JavaLangString));
      localHashMap.put("DownFileMd5", String.valueOf(this.jdField_i_of_type_JavaLangString));
      String str1 = String.valueOf(NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext()));
      localHashMap.put("NetworkInfo", str1);
      localStringBuffer.append(" NetworkInfo" + str1);
      localHashMap.put("ProductVersion", String.valueOf(this.app.a()));
      localHashMap.put("EncryptKey", "0");
      if (this.jdField_m_of_type_Boolean)
      {
        str1 = "1";
        localHashMap.put("IsUpdateSuit", str1);
        localObject = new StringBuilder().append(" IsUpdateSuit");
        if (!this.jdField_m_of_type_Boolean) {
          break label2189;
        }
        str1 = "1";
        localStringBuffer.append(str1);
        localHashMap.put("UpdateSuitCostTime", String.valueOf(this.jdField_s_of_type_Long));
        localStringBuffer.append(" UpdateSuitCostTime" + this.jdField_s_of_type_Long);
        if (!this.jdField_n_of_type_Boolean) {
          break label2195;
        }
        str1 = "1";
        localHashMap.put("UpdateSuitResult", str1);
        localObject = new StringBuilder().append(" UpdateSuitResult");
        if (!this.jdField_n_of_type_Boolean) {
          break label2201;
        }
      }
      for (str1 = "1";; str1 = "0")
      {
        localStringBuffer.append(str1);
        if (QLog.isColorLevel()) {
          QLog.w("ShortVideoPlayActivity", 2, localStringBuffer.toString());
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actStreamingVideoPlay", bool, this.jdField_q_of_type_Long, this.jdField_g_of_type_Long, localHashMap, "");
        this.jdField_o_of_type_Boolean = false;
        this.A = 0;
        this.jdField_s_of_type_Int = 0;
        this.D = 0;
        this.B = 0;
        this.jdField_o_of_type_Long = 0L;
        this.jdField_q_of_type_Long = 0L;
        this.jdField_i_of_type_Long = 0L;
        this.K = 0;
        this.J = 0;
        this.jdField_l_of_type_Long = 0L;
        this.jdField_n_of_type_Long = 0L;
        this.jdField_u_of_type_Long = 0L;
        this.L = 0;
        this.I = 0;
        this.jdField_s_of_type_Long = 0L;
        this.F = 0;
        this.G = 0;
        return;
        str1 = "0";
        break;
        str1 = "0";
        break label1933;
        str1 = "0";
        break label2001;
      }
    }
  }
  
  public void v()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_v_of_type_Boolean)
    {
      this.jdField_v_of_type_Boolean = false;
      super.setRequestedOrientation(1);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.width = this.O;
      localLayoutParams.height = this.O;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      e(0);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838917);
      return;
    }
    this.jdField_v_of_type_Boolean = true;
    if (this.Q == 0)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      e(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838918);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      super.setRequestedOrientation(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\shortvideo\ShortVideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
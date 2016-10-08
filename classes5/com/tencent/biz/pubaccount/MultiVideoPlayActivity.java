package com.tencent.biz.pubaccount;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import cooperation.readinjoy.ReadInJoyHelper;
import hoi;
import hoj;
import hok;
import hol;
import hom;
import hon;
import hoo;
import hop;
import hoq;
import hor;
import hos;
import hot;
import how;
import hox;
import hoy;
import hoz;
import hpa;
import hsn;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiVideoPlayActivity
  extends BaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, VideoListAdapter.VideoListEventListener, hsn
{
  public static final String a = "Q.pubaccount.video.MultiVideoPlayActivity";
  public static final String b = "param_needSmooth";
  public static final String c = "param_muteConfig";
  public static final String e = "1";
  public int a;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public AudioManager a;
  public Bundle a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public ViewGroup a;
  public ListView a;
  public PublicAccountArticleHandler a;
  public PublicAccountArticleObserver a;
  public VideoAudioManager a;
  public VideoListAdapter a;
  public VideoListView a;
  public VideoPlayMgr a;
  public VideoPlayRecommendHandler a;
  public VideoPlayRecommendObserver a;
  public AppInterface a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  public ActionSheet a;
  public HashSet a;
  public List a;
  public boolean a;
  public int b;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  public String d;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  public String f;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  
  public MultiVideoPlayActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_JavaLangString = "1";
    this.jdField_e_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new hoq(this);
  }
  
  private VideoInfo a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("VIDEO_VID");
    paramBundle = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_WIDTH");
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_HEIGHT");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME");
    if (paramBundle != null) {}
    try
    {
      localVideoInfo.jdField_a_of_type_Int = Integer.valueOf(paramBundle).intValue();
      if (str1 != null) {
        localVideoInfo.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
      }
      if (str2 != null) {
        localVideoInfo.jdField_c_of_type_Int = Integer.valueOf(str2).intValue();
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "finishActivityWithResult() e=" + paramBundle.getMessage());
        }
      }
    }
    localVideoInfo.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
    localVideoInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER");
    localVideoInfo.j = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    localVideoInfo.i = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    localVideoInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY");
    localVideoInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE");
    localVideoInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CREATE_TIME");
    localVideoInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT");
    localVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
    localVideoInfo.m = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
    localVideoInfo.k = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
    localVideoInfo.l = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
    localVideoInfo.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
    return localVideoInfo;
  }
  
  private void a(Bundle paramBundle)
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    int k = paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE", 1);
    if ((!TextUtils.isEmpty(str1)) && (2 == k))
    {
      String str2 = paramBundle.getString("VIDEO_THIRD_VID_URL");
      long l = paramBundle.getLong("VIDEO_THIRD_VID_URL_TIME");
      if ((!TextUtils.isEmpty(str2)) && (l > 0L)) {
        ThirdVidoeManager.a(str1, str2, l);
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296895);
    if ((VersionUtils.g()) && (!ShortVideoUtils.c()) && (localRelativeLayout != null))
    {
      if (!paramBoolean) {
        localRelativeLayout.setSystemUiVisibility(5894);
      }
    }
    else {
      return;
    }
    localRelativeLayout.setSystemUiVisibility(0);
  }
  
  private void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131298743);
    if ((paramInt == 0) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", false)) && (ReadInJoyHelper.d((QQAppInterface)getAppRuntime())) && (this.jdField_f_of_type_Boolean))
    {
      localRelativeLayout.setVisibility(0);
      localRelativeLayout.setOnClickListener(new hpa(this));
      return;
    }
    localRelativeLayout.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(90));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver = new hoi(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID");
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), str1);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler = ((PublicAccountArticleHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(93));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver = new hor(this);
    super.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.c(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.d(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new hos(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    l();
    int k;
    if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT"))
    {
      str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
      if (!TextUtils.isEmpty(str1)) {
        this.jdField_f_of_type_JavaLangString = Integer.toString(str1.hashCode());
      }
      this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_BIZ_SOURCE_DYH", this.jdField_f_of_type_JavaLangString);
      k = HttpUtil.a();
      if (k != 1) {
        break label305;
      }
      str1 = "0";
    }
    for (;;)
    {
      String str2 = "";
      if (this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID") != null) {
        str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
      }
      ReportController.b(null, "CliOper", "", "", "0X800675B", "0X800675B", 0, 0, str1, this.jdField_f_of_type_JavaLangString, "", str2);
      return;
      this.jdField_f_of_type_JavaLangString = "1";
      break;
      label305:
      if ((k == 4) || (k == 3)) {
        str1 = "1";
      } else if (k == 2) {
        str1 = "2";
      } else {
        str1 = "3";
      }
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.MultiVideoPlayActivity", 2, "showMobileNetHint()");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) && (this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.post(new hot(this));
    }
  }
  
  private void k()
  {
    m();
    n();
    if ((!this.jdField_a_of_type_AndroidOsBundle.getBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", false)) && (ReadInJoyHelper.d((QQAppInterface)getAppRuntime()))) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = (RelativeLayout)findViewById(2131298744);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.a(getApplicationContext());
        ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
      }
      Object localObject = (TextView)findViewById(2131298746);
      ((TextView)localObject).setText(getString(2131367975));
      ((View)localObject).setOnClickListener(this);
      localObject = (ImageView)findViewById(2131297392);
      ((ImageView)localObject).setImageResource(2130837505);
      ((ImageView)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(this);
      ((RelativeLayout)findViewById(2131296895)).setOnClickListener(new how(this));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hox(this), 5000L);
      return;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER"), null, null);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.pubaccount.video.MultiVideoPlayActivity", 2, "initVideoThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new hoy(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr = new VideoPlayMgr(getApplicationContext(), this, (QQAppInterface)getAppRuntime(), this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a();
    o();
    ((RelativeLayout)findViewById(2131298741)).addView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.b();
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a(this);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298798);
    if ((!this.j) && (localImageView != null))
    {
      localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298801)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setId(2131296593);
      VideoVolumeControl.a().a(localImageView);
      VideoVolumeControl.a().a(VideoVolumeControl.a().a(), "init view set mute itself FromMutiVideo");
    }
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.a("multi init");
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView = new VideoListView(getApplicationContext(), this, this.jdField_a_of_type_AndroidOsBundle, (QQAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setHeaderViewData(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(1);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setOverscrollHeader(new ColorDrawable(getResources().getColor(2131427735)));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setContentBackground(new ColorDrawable(getResources().getColor(2131427735)));
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setVideoListEventListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter = new VideoListAdapter(getApplicationContext());
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter);
    Object localObject = new hoz(this);
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setOnRefreshListener((VideoListView.OnRefreshListener)localObject);
    ((ViewGroup)findViewById(2131298742)).addView(this.jdField_a_of_type_ComTencentBizPubaccountVideoListView);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = -1;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_WIDTH");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_HEIGHT");
    if (localObject != null) {}
    try
    {
      this.jdField_f_of_type_Int = Integer.valueOf((String)localObject).intValue();
      if (str != null) {
        this.jdField_g_of_type_Int = Integer.valueOf(str).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int k;
        int m;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "finishActivityWithResult() e=" + localException.getMessage());
          continue;
          this.jdField_a_of_type_Int = 0;
        }
      }
    }
    k = this.jdField_b_of_type_Int;
    m = this.jdField_b_of_type_Int;
    if ((this.jdField_f_of_type_Int > this.jdField_g_of_type_Int) || (this.jdField_f_of_type_Int == 0) || (this.jdField_g_of_type_Int == 0))
    {
      this.jdField_a_of_type_Int = 1;
      localObject = new RelativeLayout.LayoutParams(k, m);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void p()
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
    if (!TextUtils.isEmpty(str3)) {
      ((StructMsgForGeneralShare)localObject1).mSourceAppid = Long.valueOf(str3).longValue();
    }
    ((StructMsgForGeneralShare)localObject1).source_puin = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE") > 1) {
      if (!TextUtils.isEmpty(str1))
      {
        ((StructMsgForGeneralShare)localObject1).mSourceUrl = str1;
        if ((str5 != null) && (!"".equals(str2))) {
          ((StructMsgForGeneralShare)localObject1).mSourceThirdName = str5;
        }
        label219:
        if ((str2 == null) || ("".equals(str2))) {
          break label345;
        }
        ((StructMsgForGeneralShare)localObject1).mSourceName = str2;
        label241:
        if ((localObject2 == null) || ("".equals(localObject2))) {
          break label354;
        }
      }
    }
    label345:
    label354:
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
      break label219;
      ((StructMsgForGeneralShare)localObject1).mSourceName = str5;
      break label241;
    }
  }
  
  private void q()
  {
    int k = ReadInJoyHelper.b((QQAppInterface)getAppRuntime());
    String str = ReadInJoyHelper.a((QQAppInterface)getAppRuntime());
    int m = ReadInJoyHelper.c((QQAppInterface)getAppRuntime());
    ReadInJoyActivityHelper.a(this, k, str, m, 2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "enterReadInJoyVideoChannel() channelID=" + k + ", channelName=" + str + ", channelType=" + m);
    }
  }
  
  public View a()
  {
    View localView = LayoutInflater.from(getApplicationContext()).inflate(2130903348, null);
    float f1 = getApplicationContext().getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131298208);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131298211);
    GridView localGridView2 = (GridView)localView.findViewById(2131298209);
    GridView localGridView1 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(new hok(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new hol(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label424;
      }
    }
    label424:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int k = ((List)localObject1).size();
      localGridView2.setNumColumns(k);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((k - 1) * 10 + k * 75 + 3) * f1));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(getApplicationContext(), 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      k = localLayoutParams.width;
      int m = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f1 * (m * 75 + (m - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(m);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(getApplicationContext(), 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new hom(this, localElasticHorScrView1, k, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public void a()
  {
    long l = this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a();
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"))))
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_f_of_type_Int);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (this.jdField_i_of_type_Boolean) {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("param_muteConfig", VideoVolumeControl.a().a());
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, localIntent);
      finish();
      if (QLog.isColorLevel()) {
        QLog.w("Q.pubaccount.video.MultiVideoPlayActivity", 2, "finishActivityWithResult() position=" + l + ", mVideoPlayStatus=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_f_of_type_Int);
      }
      return;
      this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 2);
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    RelativeLayout localRelativeLayout;
    do
    {
      return;
      localRelativeLayout = (RelativeLayout)findViewById(2131298743);
      if ((paramInt == 0) && (!this.jdField_f_of_type_Boolean))
      {
        this.jdField_f_of_type_Boolean = true;
        localRelativeLayout.setVisibility(0);
        localRelativeLayout.setOnClickListener(new hoo(this));
        localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(400L);
        localRelativeLayout.startAnimation(localTranslateAnimation);
        return;
      }
    } while ((paramInt != 1) || (!this.jdField_f_of_type_Boolean));
    this.jdField_f_of_type_Boolean = false;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(400L);
    localRelativeLayout.startAnimation(localTranslateAnimation);
    localTranslateAnimation.setAnimationListener(new hop(this, localRelativeLayout));
    localRelativeLayout.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0))
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131298039);
    TranslateAnimation localTranslateAnimation;
    if ((paramInt == 8) && (localRelativeLayout.getVisibility() == 0))
    {
      this.jdField_b_of_type_Boolean = true;
      localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, -1.0F);
      localTranslateAnimation.setDuration(600L);
      localRelativeLayout.startAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(new hoj(this, localRelativeLayout, paramBoolean));
    }
    while (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X8006766", "0X8006766", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      if ((paramInt == 0) && (localRelativeLayout.getVisibility() == 8))
      {
        localRelativeLayout.setVisibility(0);
        localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, -1.0F, 1, 0.0F);
        localTranslateAnimation.setDuration(600L);
        localRelativeLayout.startAnimation(localTranslateAnimation);
        if ((paramBoolean) && (ImmersiveUtils.isSupporImmersive() == 1) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.jdField_e_of_type_Boolean)) {
          super.getWindow().clearFlags(1024);
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X800675C", "0X800675C", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_f_of_type_JavaLangString;
      int k;
      label20:
      long l;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        k = 0;
        ReportController.b(null, "CliOper", "", "", "0X8006765", "0X8006765", 0, 0, "", (String)localObject, Integer.toString(k), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        localObject = this.jdField_f_of_type_JavaLangString;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 0L) {
          break label1235;
        }
        l = 0L;
        label80:
        ReportController.b(null, "CliOper", "", "", "0X80069C1", "0X80069C1", 0, 0, "", (String)localObject, Long.toString(l), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("isFromKandian")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromKandian")) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.b())) {
          VideoReporter.a(this.jdField_a_of_type_AndroidOsBundle.getString("innderId"), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("channelID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("algorithmID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("strategyId", 0L), 12, (int)this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a());
        }
        ReportController.b(null, "CliOper", "", "", "0X80069A9", "0X80069A9", 0, 0, "2", "", Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a()), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_H5_URL", paramVideoInfo.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_COVER", paramVideoInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_VID", paramVideoInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_WIDTH", String.valueOf(paramVideoInfo.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_HEIGHT", String.valueOf(paramVideoInfo.jdField_b_of_type_Int));
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_TIME", String.valueOf(paramVideoInfo.jdField_c_of_type_Int));
        if (paramVideoInfo.jdField_d_of_type_Int != 1) {
          break label1248;
        }
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.i);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.j);
        label395:
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_SUMMARY", paramVideoInfo.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_TITLE", paramVideoInfo.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_CREATE_TIME", paramVideoInfo.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", paramVideoInfo.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.g);
        this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_RECOMMEND_REASON", paramVideoInfo.h);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_ICON", paramVideoInfo.m);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_NAME", paramVideoInfo.k);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_THIRD_ACTION", paramVideoInfo.l);
        this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoInfo.jdField_d_of_type_Int);
        localObject = new Bundle();
        ((Bundle)localObject).putString("VINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putString("TINFO", paramVideoInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("PREVIEW_VIDEO_TIME", paramVideoInfo.jdField_c_of_type_Int);
        ((Bundle)localObject).putInt("PREVIEW_VIDEO_WIDTH", paramVideoInfo.jdField_a_of_type_Int);
        ((Bundle)localObject).putInt("PREVIEW_VIDEO_HEIGHT", paramVideoInfo.jdField_b_of_type_Int);
        ((Bundle)localObject).putInt("FULL_VIDEO_TIME", paramVideoInfo.jdField_c_of_type_Int);
        ((Bundle)localObject).putString("source_puin", paramVideoInfo.i);
        if (paramVideoInfo.jdField_d_of_type_Int != 1) {
          break label1277;
        }
        ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.i);
        ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.j);
        label650:
        ((Bundle)localObject).putInt("TYPE", paramVideoInfo.jdField_d_of_type_Int);
        ((Bundle)localObject).putString("ARTICLE_ID", paramVideoInfo.g);
        ((Bundle)localObject).putInt("layout_item", 5);
        ((Bundle)localObject).putBoolean("video_url_load", false);
        ((Bundle)localObject).putString("image_url_remote", paramVideoInfo.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject).putString("detail_url", paramVideoInfo.jdField_f_of_type_JavaLangString);
        ((Bundle)localObject).putString("video_url", paramVideoInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putString("title", paramVideoInfo.jdField_c_of_type_JavaLangString);
        ((Bundle)localObject).putString("req_create_time", paramVideoInfo.jdField_e_of_type_JavaLangString);
        ((Bundle)localObject).putString("brief_key", paramVideoInfo.jdField_c_of_type_JavaLangString);
        StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)StructMsgFactory.a((Bundle)localObject);
        this.jdField_a_of_type_AndroidOsBundle.putByteArray("STRUCT_MSG_BYTES", localStructMsgForGeneralShare.getBytes());
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("isFromKandian", true);
        this.jdField_a_of_type_AndroidOsBundle.putLong("channelID", 0L);
        this.jdField_a_of_type_AndroidOsBundle.putLong("algorithmID", paramVideoInfo.jdField_c_of_type_Long);
        this.jdField_a_of_type_AndroidOsBundle.putString("innderId", paramVideoInfo.g);
        this.jdField_a_of_type_AndroidOsBundle.putLong("strategyId", paramVideoInfo.jdField_e_of_type_Int);
        if ((paramVideoInfo.jdField_d_of_type_Int != 1) && (TextUtils.isEmpty(paramVideoInfo.k))) {}
      }
      try
      {
        this.jdField_f_of_type_JavaLangString = Integer.toString(paramVideoInfo.k.hashCode());
        label873:
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_BIZ_SOURCE_DYH", this.jdField_f_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "onVideoChanged() mBundle=" + this.jdField_a_of_type_AndroidOsBundle.toString() + ", data=" + ((Bundle)localObject).toString());
        }
        o();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a(this.jdField_a_of_type_AndroidOsBundle);
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        this.jdField_a_of_type_JavaUtilHashSet.clear();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setHeaderViewData(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()), paramVideoInfo.g);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.c(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.d(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.setCurrentStatus(1);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.e(0);
        this.jdField_f_of_type_Boolean = false;
        b(8);
        l();
        if (VersionUtils.d())
        {
          localObject = (MultiVideoContentLayout)findViewById(2131297013);
          ((MultiVideoContentLayout)localObject).setIsCatchTouchEvent(false);
          ((MultiVideoContentLayout)localObject).setIsInterceptTouchEvent(false);
          ((MultiVideoContentLayout)localObject).a();
          ((MultiVideoContentLayout)localObject).scrollTo(0, 0);
          this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
        }
        ReportController.b(null, "CliOper", "", "", "0X8006763", "0X8006763", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", ReadInJoyUtils.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g));
        k = HttpUtil.a();
        if (k == 1) {
          localObject = "0";
        }
        while (paramVideoInfo.jdField_a_of_type_JavaLangString != null)
        {
          ReportController.b(null, "CliOper", "", "", "0X800675B", "0X800675B", 0, 0, (String)localObject, this.jdField_f_of_type_JavaLangString, "", paramVideoInfo.jdField_a_of_type_JavaLangString);
          return;
          k = this.jdField_a_of_type_JavaUtilList.size();
          break label20;
          label1235:
          l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          break label80;
          label1248:
          this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.n);
          this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.o);
          break label395;
          label1277:
          ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_UIN", paramVideoInfo.n);
          ((Bundle)localObject).putString("VIDEO_PUB_ACCOUNT_NAME", paramVideoInfo.o);
          break label650;
          this.jdField_f_of_type_JavaLangString = "1";
          break label873;
          if ((k == 4) || (k == 3)) {
            localObject = "1";
          } else if (k == 2) {
            localObject = "2";
          } else {
            localObject = "3";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler == null)) {
      return;
    }
    ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleHandler.a(paramString, paramBoolean);
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364561);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838114;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364567);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838115;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364577);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838116;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364578);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838112;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = getString(2131364565);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130839505;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = getString(2131364576);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.u = 2130840304;
    localActionSheetItem.v = 6;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = getString(2131364563);
    localActionSheetItem.u = 2130838111;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 1;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = getString(2131364564);
    localActionSheetItem.u = 2130839494;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 11;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void b()
  {
    Object localObject1 = (TextView)findViewById(2131298746);
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_Boolean)
    {
      super.getWindow().clearFlags(1024);
      super.setRequestedOrientation(1);
      o();
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject2 = (RelativeLayout)findViewById(2131298744);
        localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.a(getApplicationContext());
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
      }
      ((TextView)localObject1).setText(getString(2131367975));
      ((RelativeLayout)findViewById(2131298039)).setVisibility(0);
      this.jdField_a_of_type_Boolean = false;
      a(true);
      b(0);
      localObject1 = this.jdField_f_of_type_JavaLangString;
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long < 0L) {}
      for (long l = 0L;; l = System.currentTimeMillis() - this.jdField_b_of_type_Long)
      {
        ReportController.b(null, "CliOper", "", "", "0X80069C2", "0X80069C2", 0, 0, "", (String)localObject1, Long.toString(l), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
      }
    }
    super.getWindow().setFlags(1024, 1024);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_Int == 1))
    {
      localObject2 = (RelativeLayout)findViewById(2131298744);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.topMargin = 0;
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = -1;
      ((RelativeLayout.LayoutParams)localObject2).height = -1;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      ((TextView)localObject1).setText("");
      ((RelativeLayout)findViewById(2131298039)).setVisibility(8);
      this.jdField_a_of_type_Boolean = true;
      a(false);
      b(8);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = -1;
      ((RelativeLayout.LayoutParams)localObject2).height = -1;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      super.setRequestedOrientation(0);
    }
  }
  
  public void c()
  {
    findViewById(2131297392).setVisibility(8);
  }
  
  public void d()
  {
    findViewById(2131297392).setVisibility(0);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramInt1 == 21) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return;
      ForwardUtils.a((QQAppInterface)getAppRuntime(), this, getApplicationContext(), paramIntent, null);
      return;
      if (paramInt1 == 100)
      {
        switch (paramInt2)
        {
        default: 
          return;
        }
        if (!paramIntent.getBooleanExtra("bFailed", false)) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a(bool1, false);
          return;
          bool1 = false;
        }
      }
    } while (paramInt1 != 101);
    switch (paramInt2)
    {
    default: 
      return;
    }
    bool1 = bool2;
    if (!paramIntent.getBooleanExtra("bFailed", false)) {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a(bool1, true);
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnBackPressed() isShowingFull=" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a();
      return;
    }
    a();
    super.doOnBackPressed();
    ReportController.b(null, "CliOper", "", "", "0X800675E", "0X800675E", 0, 0, "", "", this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnConfigurationChanged()");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnCreate()");
    }
    VideoVolumeControl.a().a(this);
    if (getIntent().hasExtra("param_needSmooth"))
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_h_of_type_Boolean = getIntent().getBooleanExtra("param_needSmooth", true);
      VideoVolumeControl.a().c(true);
      if (!this.jdField_h_of_type_Boolean) {
        VideoVolumeControl.a().a(getIntent().getBooleanExtra("param_muteConfig", false), "init 1t3 voice from readinjoy process");
      }
    }
    for (;;)
    {
      this.mActNeedImmersive = false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      super.doOnCreate(paramBundle);
      super.setContentView(2130903483);
      if (VersionUtils.d()) {
        getWindow().setFlags(16777216, 16777216);
      }
      setRequestedOrientation(1);
      this.jdField_b_of_type_Int = getResources().getDisplayMetrics().widthPixels;
      this.jdField_c_of_type_Int = getResources().getDisplayMetrics().heightPixels;
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
      a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = super.getAppInterface();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = new VideoAudioManager(getApplicationContext());
      k();
      i();
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnCreate() shouldSmoothAudio=" + this.jdField_h_of_type_Boolean + ", bundle=" + this.jdField_a_of_type_AndroidOsBundle.toString());
      }
      return true;
      VideoVolumeControl.a().c(false);
      this.jdField_h_of_type_Boolean = VideoVolumeControl.a().b();
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnDestroy()");
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver);
    super.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountArticleObserver);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.o();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager != null)
    {
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager.c();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoAudioManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    VideoReporter.a("2");
    super.doOnDestroy();
    VideoVolumeControl.a().b(this);
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnPause()");
    }
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.b(false);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
    super.doOnPause();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    long l1 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    if (l1 > 0L)
    {
      long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("channelID", 0L);
      int k = this.jdField_a_of_type_AndroidOsBundle.getInt("interactionType", 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "start to report video article read info:" + ReadInJoyUtils.a(l2, k));
      }
      ReportController.b(null, "CliOper", "", "", "0X80066FB", "0X80066FB", 0, 0, Long.toString(l1 / 1000L), "-1", "", ReadInJoyUtils.a(l2, k));
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnResume()");
    }
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.k();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoListView.b();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean) {
      a(false);
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "doOnStop()");
    }
    super.doOnStop();
  }
  
  public void e() {}
  
  public void f()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      if (ImmersiveUtils.isSupporImmersive() == -1)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this);
        localView = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
        {
          if ((VersionUtils.g()) && (!ShortVideoUtils.c()))
          {
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(8, 8);
            this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility());
            this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnShowListener(new hon(this));
          }
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "actionSheet.show exception=" + localException);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.b(false);
      }
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      break;
      localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
    }
  }
  
  public void g()
  {
    f();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.b(false);
    }
    p();
  }
  
  protected boolean isWrapContent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "isWrapContent() isShowingFull=" + this.jdField_a_of_type_Boolean);
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298746: 
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.a();
        ReportController.b(null, "CliOper", "", "", "0X8006768", "0X8006768", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800675E", "0X800675E", 0, 0, "", "", this.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      paramView = this.jdField_f_of_type_JavaLangString;
      int k;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        k = 0;
        ReportController.b(null, "CliOper", "", "", "0X8006765", "0X8006765", 0, 0, "", paramView, Integer.toString(k), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        paramView = this.jdField_f_of_type_JavaLangString;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 0L) {
          break label256;
        }
      }
      label256:
      for (long l = 0L;; l = System.currentTimeMillis() - this.jdField_a_of_type_Long)
      {
        ReportController.b(null, "CliOper", "", "", "0X80069C1", "0X80069C1", 0, 0, "", paramView, Long.toString(l), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        a();
        return;
        k = this.jdField_a_of_type_JavaUtilList.size();
        break;
      }
    }
    f();
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X800676A", "0X800676A", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X800675D", "0X800675D", 0, 0, "", this.jdField_f_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr.o();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayMgr = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt = 0;
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label60;
      }
    }
    label60:
    int k;
    do
    {
      return;
      bool = false;
      break;
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      k = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
      paramAdapterView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
      if (k == 1)
      {
        paramView = getApplicationContext();
        getApplicationContext();
        ((ClipboardManager)paramView.getSystemService("clipboard")).setText(paramAdapterView);
        QRUtils.a(2, 2131364463);
        return;
      }
      if (k == 11)
      {
        if (Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAdapterView).matches()) {
          paramInt = 1;
        }
        try
        {
          paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
          if (paramInt != 0)
          {
            paramView = String.valueOf(NetConnInfoCenter.getServerTime());
            String str = MD5Utils.b(paramAdapterView + 200 + paramView + "jubao@article@123").toLowerCase();
            paramAdapterView = "http://jubao.mp.qq.com/mobile/report?qq=" + ((QQAppInterface)getAppRuntime()).a() + "&mp_uin=" + this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN") + "&scene=200&sub_appname=article_webview&timestamp=" + paramView + "&sign=" + str + "&article_url=" + paramAdapterView;
            paramView = new Intent(this, QQBrowserActivity.class);
            paramView.putExtra("url", paramAdapterView);
            paramView.putExtra("hide_more_button", true);
            startActivity(paramView);
            return;
          }
        }
        catch (UnsupportedEncodingException paramAdapterView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.MultiVideoPlayActivity", 2, "encode url failed, because UTF-8 is unknown");
            }
            paramAdapterView = null;
            continue;
            paramAdapterView = "http://guanjia.qq.com/online_server/m_report.html?url=" + paramAdapterView + "&qq=" + ((QQAppInterface)getAppRuntime()).a() + "&_wv=7";
          }
        }
      }
      if (k == 2)
      {
        p();
        return;
      }
      if (k == 4)
      {
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
        paramAdapterView.putExtra("normal", true);
        try
        {
          startActivity(paramAdapterView);
          return;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          QRUtils.a(1, 2131364483);
          return;
        }
      }
      if (k == 3)
      {
        paramView = new Bundle();
        paramView.putString("title", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"));
        paramView.putString("desc", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"));
        paramView.putString("detail_url", paramAdapterView);
        paramAdapterView = new ArrayList(1);
        paramAdapterView.add(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER"));
        paramView.putStringArrayList("image_url", paramAdapterView);
        paramView.putLong("req_share_id", 0L);
        QZoneShareManager.a((QQAppInterface)getAppRuntime(), this, paramView, null);
        return;
      }
      if (k == 6)
      {
        paramAdapterView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
        paramView = ((QQAppInterface)getAppRuntime()).a();
        QfavBuilder.a(paramAdapterView).c(paramView).a(this, paramView, 101, null);
        return;
      }
    } while ((k != 9) && (k != 10));
    VideoShareUtils.a(this, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"), paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, k);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\MultiVideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
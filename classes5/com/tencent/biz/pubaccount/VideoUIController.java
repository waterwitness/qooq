package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover.DownLoad;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import hsq;
import hsr;
import hss;
import hst;
import hsv;
import hsw;
import hsx;
import hsy;
import hta;
import htb;
import htc;
import htd;
import hth;
import htj;
import htl;
import htm;
import htn;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;

public class VideoUIController
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final String A = "VIDEO_THIRD_URL";
  public static final String B = "VIDEO_ARTICLE_BUSITYPE";
  public static final String C = "VIDEO_THIRD_VID_URL";
  public static final String D = "VIDEO_THIRD_VID_URL_TIME";
  private static final String E = "Q.pubaccount.video.VideoUIController";
  public static final long a = 104857600L;
  public static final String a = "http://q.url.cn/s/YnxqUe";
  public static final String b = "IS_FROM_READINJOY_VIDEO_CHANNEL";
  public static final String c = "STRUCT_MSG_BYTES";
  public static final int d = 0;
  public static final String d = "VIDEO_VID";
  public static final int e = 1;
  public static final String e = "VIDEO_TIME";
  public static final int f = 2;
  public static final String f = "VIDEO_FILE_SIZE";
  public static final String g = "VIDEO_WIDTH";
  public static final int h = 1;
  public static final String h = "VIDEO_HEIGHT";
  public static final int i = 2;
  public static final String i = "VIDEO_TITLE";
  public static final int j = 3;
  public static final String j = "VIDEO_SUMMARY";
  public static final int k = 4;
  public static final String k = "VIDEO_CREATE_TIME";
  public static final String l = "VIDEO_H5_URL";
  public static final int m = -1;
  public static final String m = "VIDEO_COVER";
  public static final int n = 0;
  public static final String n = "VIDEO_IS_FROM_PUBLIC_ACCOUNT";
  public static final int o = 1;
  public static final String o = "VIDEO_PUB_ACCOUNT_UIN";
  public static final int p = 2;
  public static final String p = "VIDEO_PUB_ACCOUNT_NAME";
  public static final int q = 100;
  public static final String q = "VIDEO_PLAY_POSITION";
  public static final int r = 101;
  public static final String r = "VIDEO_PLAY_STATUS";
  public static final String s = "VIDEO_ARTICLE_ID";
  public static final String t = "VIDEO_RECOMMEND_REASON";
  public static final String u = "VIDEO_LISTVIEW_CONFIG_HIDE_SHARE_BUTTON";
  public static final String v = "VIDEO_AIO_UIN_TYPE";
  public static final String w = "VIDEO_BIZ_SOURCE_DYH";
  public static final String x = "VIDEO_THIRD_ICON";
  public static final String y = "VIDEO_THIRD_NAME";
  public static final String z = "VIDEO_THIRD_ACTION";
  public int a;
  public Activity a;
  public Context a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Bundle a;
  public Handler a;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public ViewGroup a;
  public SeekBar a;
  public TextView a;
  public QQAppInterface a;
  public TVK_IMediaPlayer a;
  public IVideoViewBase a;
  public ActionSheet a;
  public Timer a;
  public boolean a;
  public int b;
  public long b;
  public TextView b;
  public Timer b;
  public boolean b;
  public int c;
  private long c;
  public TextView c;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public int g;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public int l;
  public int s;
  public int t;
  
  public VideoUIController(Context paramContext, QQAppInterface paramQQAppInterface, Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.l = -1;
    this.s = 1;
    this.jdField_a_of_type_AndroidOsHandler = new hsv(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903498, null));
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_c_of_type_Int == 1) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.f = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "VideoUIController() data=" + this.jdField_a_of_type_AndroidOsBundle.toString());
    }
    this.s = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_BIZ_SOURCE_DYH");
    m();
    n();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "getPublicAccountName() uin=" + paramString);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("6.5.5,3,2880");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(paramString));
      localNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localNewIntent.setObserver(new hta(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoUIController", 2, "sendDetailInfoRequest exit");
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298764);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298827);
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView1.setText(paramString);
        localTextView2.setText(paramString);
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_PUB_ACCOUNT_NAME", paramString);
      }
    }
  }
  
  private void m()
  {
    a(0);
    if (this.jdField_c_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new hsq(this, this.jdField_a_of_type_AndroidAppActivity, 3);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
    }
    ((SeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298795)).setOnSeekBarChangeListener(new htb(this));
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
    this.t = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
    if ((this.t == 2) || (this.t == 3)) {}
    for (int i1 = 1;; i1 = 0)
    {
      Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298766);
      Object localObject3 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298828);
      if (i1 != 0)
      {
        ((TextView)localObject3).setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
      }
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      Object localObject2 = (AccountDetail)((EntityManager)localObject4).a(AccountDetail.class, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"));
      ((EntityManager)localObject4).a();
      if ((localObject2 != null) && (((AccountDetail)localObject2).followType == 1))
      {
        f();
        if ((localObject2 == null) && (i1 == 0)) {
          b(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"));
        }
        localObject1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298746);
        ((TextView)localObject1).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367975));
        ((TextView)localObject1).setOnClickListener(this);
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297392);
        ((ImageView)localObject1).setImageResource(2130837505);
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject1).setOnClickListener(this);
        ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298747)).setText(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"));
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298799).setOnClickListener(this);
        localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298762);
        localObject3 = ImageUtil.b();
        localObject4 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"), 3, (Drawable)localObject3, (Drawable)localObject3);
        if (i1 == 0) {
          break label909;
        }
        new StructMsgItemCover.DownLoad((ImageView)localObject1, this.jdField_a_of_type_AndroidAppActivity).execute(new String[] { str1 });
        ((ImageView)localObject1).setOnClickListener(this);
        label452:
        localObject3 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298764);
        Object localObject5 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label919;
        }
        ((TextView)localObject3).setText((CharSequence)localObject5);
        label493:
        if (i1 != 0)
        {
          ((TextView)localObject3).setText(str3);
          ((TextView)localObject3).setOnClickListener(this);
        }
        ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298819)).setText(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CREATE_TIME") + " 发布");
        if (i1 != 0)
        {
          localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298751);
          localObject5 = (RelativeLayout.LayoutParams)((LinearLayout)localObject2).getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject5).leftMargin = 0;
          ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"))) {
          break label948;
        }
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298818));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"));
        label645:
        b();
        c();
        localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298800);
        if (this.jdField_c_of_type_Int == 1) {
          ((View)localObject2).setOnClickListener(this);
        }
        localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298826);
        if (i1 == 0) {
          break label969;
        }
        new StructMsgItemCover.DownLoad((ImageView)localObject2, this.jdField_a_of_type_AndroidAppActivity).execute(new String[] { str1 });
      }
      for (;;)
      {
        localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298827);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME"));
        if (i1 != 0) {
          ((TextView)localObject2).setText(str3);
        }
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298820).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298821).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298822).setOnClickListener(this);
        ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298828)).setOnClickListener(this);
        localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298810);
        ((View)localObject2).setOnClickListener(this);
        if ((i1 != 0) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))) {
          ((View)localObject2).setVisibility(8);
        }
        if (i1 != 0)
        {
          ((ImageView)localObject1).setVisibility(8);
          ((TextView)localObject3).setVisibility(8);
        }
        return;
        ((TextView)localObject1).setOnClickListener(this);
        ((TextView)localObject3).setOnClickListener(this);
        break;
        label909:
        ((ImageView)localObject1).setBackgroundDrawable((Drawable)localObject4);
        break label452;
        label919:
        if ((localObject2 == null) || (TextUtils.isEmpty(((AccountDetail)localObject2).name))) {
          break label493;
        }
        ((TextView)localObject3).setText(((AccountDetail)localObject2).name);
        break label493;
        label948:
        ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298817)).setVisibility(8);
        break label645;
        label969:
        ((ImageView)localObject2).setBackgroundDrawable((Drawable)localObject4);
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER");
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      try
      {
        localObject = URLDrawable.getDrawable((String)localObject, null, null);
        if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof RegionDrawable))) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)((URLDrawable)localObject).getCurrDrawable()).getBitmap();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.pubaccount.video.VideoUIController", 2, "initData", localException);
    return;
    localException.setURLDrawableListener(new htc(this, localException));
    localException.startDownload();
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new htd(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new hth(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new htj(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new htl(this));
  }
  
  private void p()
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", str2);
    localIntent.putExtra("url", str1);
    localIntent.putExtra("assignBackText", this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367975));
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  protected View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903348, null);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131298208);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131298211);
    GridView localGridView2 = (GridView)localView.findViewById(2131298209);
    GridView localGridView1 = (GridView)localView.findViewById(2131298212);
    Object localObject1 = (TextView)localView.findViewById(2131296891);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f1));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131367262);
    ((TextView)localObject1).setOnClickListener(this);
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
        break label402;
      }
    }
    label402:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i1 = ((List)localObject1).size();
      localGridView2.setNumColumns(i1);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i1 - 1) * 10 + i1 * 75 + 3) * f1));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i1 = localLayoutParams.width;
      int i2 = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f1 * (i2 * 75 + (i2 - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(i2);
      localGridView1.setAdapter(new PublicAccountBrowser.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new hsx(this, localElasticHorScrView1, i1, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    long l1 = TrafficStats.getTotalRxBytes();
    long l2 = l1 - this.jdField_b_of_type_Long;
    String str;
    if ((l2 >= 0L) && (l2 < 104857600L)) {
      if (l2 > 1024L) {
        str = l2 / 1024L + "KB/s";
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = l1;
      return "加载中... " + str;
      str = l2 + "Bytes/s";
      continue;
      str = "0Bytes/s";
    }
  }
  
  public String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) });
  }
  
  public void a()
  {
    View localView;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this.jdField_a_of_type_AndroidAppActivity);
      localView = a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
    }
    try
    {
      for (;;)
      {
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        }
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())
        {
          this.l = 1;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
          ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setBackgroundResource(2130838928);
          this.f = false;
        }
        return;
        localView = a();
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(localView, null);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoUIController", 2, "actionSheet.show exception=" + localException);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298797);
      if (this.jdField_c_of_type_Int == 0)
      {
        ((View)localObject2).setVisibility(8);
        ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298796).getLayoutParams()).setMargins((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), 0);
      }
    }
    else
    {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298815);
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298751);
    LinearLayout localLinearLayout1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298792);
    localLinearLayout1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802);
    LinearLayout localLinearLayout2 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298804);
    LinearLayout localLinearLayout3 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298821);
    LinearLayout localLinearLayout4 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298822);
    View localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298824);
    View localView2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298825);
    View localView3 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298794);
    View localView4 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298795);
    if ((paramInt == 1) || (paramInt == 2))
    {
      ((View)localObject2).setBackgroundResource(2130838918);
      localRelativeLayout.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F), 0);
      localObject2 = (RelativeLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 19.0F));
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (LinearLayout.LayoutParams)localView3.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      localView3.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localView4.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
      localLinearLayout1.setPadding(0, 0, 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 26.0F));
      localLinearLayout4.setPadding(0, 0, 0, 0);
      ((LinearLayout.LayoutParams)localView1.getLayoutParams()).width = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 120.0F));
      ((LinearLayout.LayoutParams)localView2.getLayoutParams()).width = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 120.0F));
      ((LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams()).setMargins(0, 0, 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 80.0F));
      localLinearLayout2.setOrientation(0);
      ((LinearLayout.LayoutParams)localLinearLayout3.getLayoutParams()).setMargins((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 48.0F), 0, 0, 0);
      ((LinearLayout.LayoutParams)localLinearLayout4.getLayoutParams()).setMargins((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 48.0F), 0, 0, 0);
      return;
    }
    ((View)localObject2).setBackgroundResource(2130838917);
    localRelativeLayout.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0);
    Object localObject2 = (RelativeLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 25.0F));
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (LinearLayout.LayoutParams)localView3.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 23.0F));
    localView3.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localView4.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 2.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 7.0F), (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 23.0F));
    localLinearLayout1.setPadding(0, 0, 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 162.0F));
    if (this.k) {
      localLinearLayout4.setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0, 0, 0);
    }
    ((LinearLayout.LayoutParams)localView1.getLayoutParams()).width = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
    ((LinearLayout.LayoutParams)localView2.getLayoutParams()).width = ((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
    ((LinearLayout.LayoutParams)localLinearLayout2.getLayoutParams()).setMargins(0, 0, 0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 59.0F));
    localLinearLayout2.setOrientation(1);
    ((LinearLayout.LayoutParams)localLinearLayout3.getLayoutParams()).setMargins(0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 38.0F), 0, 0);
    ((LinearLayout.LayoutParams)localLinearLayout4.getLayoutParams()).setMargins(0, (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 38.0F), 0, 0);
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 2147483647L) {
      return;
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298796));
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(a(paramLong));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new hsr(this, paramView, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.j = true;
    paramView.startAnimation(localValueAnimation);
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer, IVideoViewBase paramIVideoViewBase)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = paramIVideoViewBase;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = paramTVK_IMediaPlayer;
    o();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "showErrorView() errorContent=" + paramString);
    }
    this.jdField_c_of_type_Boolean = true;
    this.e = false;
    d();
    if (this.jdField_b_of_type_JavaUtilTimer != null) {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298746);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297392);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298747);
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298815);
    if (localViewGroup.getVisibility() == 0) {
      return;
    }
    if (((View)localObject).getVisibility() == 8) {
      ((View)localObject).setVisibility(0);
    }
    localView.setVisibility(8);
    localTextView1.setText("");
    localImageView.setVisibility(8);
    localTextView2.setVisibility(8);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298787)).setVisibility(0);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298788);
    ((ImageView)localObject).setBackgroundResource(2130839553);
    ((ImageView)localObject).clearAnimation();
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298789)).setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g == true) {}
    Object localObject1;
    Object localObject5;
    Object localObject4;
    TextView localTextView1;
    ImageView localImageView;
    TextView localTextView2;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
      localObject5 = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802);
      localObject2 = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298817);
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298761);
      localObject3 = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298751);
      localObject4 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298039);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298747);
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297392);
      localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298746);
      localObject6 = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298815);
    } while ((this.jdField_b_of_type_Boolean == true) || (this.jdField_c_of_type_Boolean == true));
    this.g = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new htm(this), 600L);
    if (((View)localObject1).getVisibility() == 8)
    {
      this.d = true;
      if (paramBoolean)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setBackgroundDrawable(null);
        ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setVisibility(0);
        localViewGroup.setVisibility(8);
        ((ViewGroup)localObject2).setVisibility(8);
        ((ViewGroup)localObject3).setVisibility(8);
        ((RelativeLayout)localObject4).setVisibility(0);
        localImageView.setVisibility(8);
        localTextView2.setText("");
        localObject1 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject1).setDuration(600L);
        ((ViewGroup)localObject6).startAnimation((Animation)localObject1);
        localObject1 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, -1.0F, 1, 0.0F);
        ((TranslateAnimation)localObject1).setDuration(600L);
        ((RelativeLayout)localObject4).startAnimation((Animation)localObject1);
        return;
      }
      this.e = false;
      localTextView2.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367975));
      ((ViewGroup)localObject5).setVisibility(8);
      ((RelativeLayout)localObject4).setVisibility(0);
      localImageView.setVisibility(0);
      localObject5 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, -1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject5).setDuration(600L);
      ((RelativeLayout)localObject4).startAnimation((Animation)localObject5);
      localViewGroup.setVisibility(0);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"))) {
        ((ViewGroup)localObject2).setVisibility(0);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CREATE_TIME"))) {
        ((ViewGroup)localObject3).setVisibility(0);
      }
      ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297392)).setVisibility(0);
      ((ViewGroup)localObject6).setVisibility(0);
      localObject4 = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298792);
      ((ViewGroup)localObject4).setVisibility(0);
      localObject5 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject5).setDuration(600L);
      ((ViewGroup)localObject4).startAnimation((Animation)localObject5);
      ((View)localObject1).setBackgroundColor(2130706432);
      ((View)localObject1).setVisibility(0);
      a((View)localObject1, 0, 255, 200);
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(600L);
      localTextView1.startAnimation((Animation)localObject1);
      ((ViewGroup)localObject2).startAnimation((Animation)localObject1);
      localViewGroup.startAnimation((Animation)localObject1);
      ((ViewGroup)localObject3).startAnimation((Animation)localObject1);
      return;
    }
    this.d = false;
    this.e = false;
    if (((View)localObject1).getBackground() != null) {
      a((View)localObject1, 255, 0, 200);
    }
    Object localObject6 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject6).setDuration(600L);
    ((AlphaAnimation)localObject6).setFillAfter(true);
    ((ViewGroup)localObject2).startAnimation((Animation)localObject6);
    localViewGroup.startAnimation((Animation)localObject6);
    ((ViewGroup)localObject3).startAnimation((Animation)localObject6);
    localTextView1.startAnimation((Animation)localObject6);
    if (((ViewGroup)localObject5).getVisibility() == 0) {
      ((ViewGroup)localObject5).startAnimation((Animation)localObject6);
    }
    Object localObject2 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, -1.0F);
    ((TranslateAnimation)localObject2).setDuration(600L);
    ((RelativeLayout)localObject4).startAnimation((Animation)localObject2);
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298792);
    Object localObject3 = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, 1.0F);
    ((TranslateAnimation)localObject3).setDuration(600L);
    localViewGroup.startAnimation((Animation)localObject3);
    ((TranslateAnimation)localObject2).setAnimationListener(new htn(this, (ViewGroup)localObject5, (View)localObject1));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "doOnAddFavourate() result=" + paramBoolean1 + ", needShowSuccessToast=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.k = paramBoolean1;
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298822);
      Object localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298808);
      ((View)localObject2).setBackgroundResource(2130838912);
      if (VersionUtils.e()) {
        ((View)localObject2).setAlpha(0.5F);
      }
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298809);
      if (this.jdField_b_of_type_Int == 0) {
        ((View)localObject1).setPadding((int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 15.0F), 0, 0, 0);
      }
      ((TextView)localObject2).setText("已收藏");
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.5F);
      }
      ((View)localObject1).setClickable(false);
      if (paramBoolean2)
      {
        localObject1 = new QQToast(this.jdField_a_of_type_AndroidContentContext);
        ((QQToast)localObject1).c(2000);
        ((QQToast)localObject1).a(QQToast.a(2));
        ((QQToast)localObject1).b(2131365895);
        ((QQToast)localObject1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
      }
      return;
    }
    Object localObject1 = new QQToast(this.jdField_a_of_type_AndroidContentContext);
    ((QQToast)localObject1).c(2000);
    ((QQToast)localObject1).a(QQToast.a(1));
    ((QQToast)localObject1).b(2131365903);
    ((QQToast)localObject1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
  }
  
  public boolean a()
  {
    boolean bool = true;
    try
    {
      int i1 = Settings.System.getInt(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "accelerometer_rotation");
      if (i1 == 0) {
        bool = false;
      }
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=" + localException.getMessage());
    }
    return bool;
    return true;
  }
  
  protected List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364561);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838114;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 2;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364567);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838115;
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 3;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364577);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838116;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 9;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364578);
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838112;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 10;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new PublicAccountBrowser.ActionSheetItem();
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364565);
    ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
    ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130839505;
    ((PublicAccountBrowser.ActionSheetItem)localObject).v = 4;
    ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364576);
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.u = 2130840304;
    localActionSheetItem.v = 6;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364563);
    localActionSheetItem.u = 2130838111;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 1;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364564);
    localActionSheetItem.u = 2130839494;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.v = 11;
    localActionSheetItem.b = "";
    ((ArrayList)localObject).add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    if (this.jdField_b_of_type_JavaUtilTimer != null) {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_b_of_type_JavaUtilTimer = new Timer();
    this.jdField_b_of_type_JavaUtilTimer.schedule(new hss(this), 1000L, 1000L);
  }
  
  public void b(long paramLong)
  {
    if (paramLong >= 2147483647L) {}
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298794));
      }
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramLong));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new hst(this), 0L, 1000L);
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void f()
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298766);
    localTextView.setText("已关注");
    localTextView.setTextColor(Integer.MAX_VALUE);
    localTextView.setBackgroundResource(2130838916);
    localTextView.setOnClickListener(null);
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298828);
    localTextView.setText("已关注");
    localTextView.setTextColor(Integer.MAX_VALUE);
    localTextView.setBackgroundResource(2130838916);
    localTextView.setOnClickListener(null);
    this.h = true;
  }
  
  public void g()
  {
    PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"), new hsw(this));
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.e = false;
    d();
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298815)).setVisibility(8);
    ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297392)).setVisibility(8);
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298747)).setVisibility(0);
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298039)).setVisibility(0);
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298746)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131367975));
    if (((RelativeLayout)localObject2).getVisibility() == 0)
    {
      ((LinearLayout)localObject1).setVisibility(0);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(200L);
      ((LinearLayout)localObject1).startAnimation((Animation)localObject2);
      return;
    }
    ((LinearLayout)localObject1).setVisibility(0);
    ((RelativeLayout)localObject2).setVisibility(0);
    localObject1 = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject1).setDuration(200L);
    ((RelativeLayout)localObject2).startAnimation((Animation)localObject1);
    ((RelativeLayout)localObject2).setVisibility(0);
  }
  
  public void i()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "doOnResume() mMediaPlayer.isPauseing()=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPauseing() + ", mIsStartPlaying=" + this.f);
    }
    if ((!this.f) && (!this.d) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean)) {
      a(false);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.f))
    {
      this.l = 0;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
    c();
  }
  
  public void j()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "doOnPause() mMediaPlayer.isPlaying()=" + this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying() + ", mIsStartPlaying=" + this.f);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.l = 1;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    d();
    e();
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "doOnDestory()");
    }
  }
  
  public void l()
  {
    long l1 = 0L;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      l1 = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l1);
    this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", this.l);
    Intent localIntent = new Intent();
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, "finishActivityWithResult() position=" + l1 + ", mVideoPlayStatus=" + this.l);
    }
  }
  
  public void onClick(View paramView)
  {
    label437:
    String str;
    switch (paramView.getId())
    {
    default: 
    case 2131298766: 
    case 2131298828: 
    case 2131298746: 
    case 2131297392: 
    case 2131298799: 
    case 2131298800: 
    case 2131298820: 
    case 2131298821: 
    case 2131298822: 
      boolean bool;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (this.h);
                      g();
                    } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
                    paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
                    VideoReporter.a("0X80065F8", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
                    return;
                  } while (this.h);
                  g();
                } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
                paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
                VideoReporter.a("0X80065F9", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
                return;
                l();
              } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
              paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
              VideoReporter.a("0X80065FB", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
            } while (this.l == 2);
            int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE");
            int i2 = this.s;
            paramView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
            if (System.currentTimeMillis() - this.jdField_c_of_type_Long < 0L) {}
            for (long l1 = 0L;; l1 = System.currentTimeMillis() - this.jdField_c_of_type_Long)
            {
              VideoReporter.a("0X80069BE", i1, i2, paramView, Long.toString(l1));
              return;
            }
            if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
            {
              paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
              if (this.l != 2) {
                break label437;
              }
              VideoReporter.a("0X80065E8", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
            }
            for (;;)
            {
              a();
              return;
              VideoReporter.a("0X80065E7", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
            }
          } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
          paramView = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793);
          if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())
          {
            this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
            paramView.setBackgroundResource(2130838927);
            this.f = true;
            this.l = 0;
            this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
            return;
          }
          this.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(128);
          paramView.setBackgroundResource(2130838928);
          this.f = false;
          this.l = 1;
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
          return;
          if (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791).getVisibility() == 0) {
            a(false);
          }
          if (this.jdField_a_of_type_AndroidAppActivity.getRequestedOrientation() != 1)
          {
            this.jdField_a_of_type_Int = 1;
            this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
            a(0);
            return;
          }
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
          a(1);
        } while (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null);
        paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
        VideoReporter.a("0X80065F7", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), 1, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        ReportController.b(null, "CliOper", "", "", "0X8006698", "0X8006698", 0, 0, Integer.toString(this.s), "1", paramView, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
        this.jdField_b_of_type_Boolean = false;
        ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setBackgroundResource(2130838927);
        a(false);
        VideoReporter.a("0X80065FC", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), "");
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hsy(this), 200L);
        return;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          VideoReporter.a("0X80065E8", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        }
        a();
        return;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          VideoReporter.a("0X80065EC", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, paramView, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        }
        paramView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        bool = QfavBuilder.a(paramView).c(str).a(this.jdField_a_of_type_AndroidAppActivity, str, 100, null);
      } while (!bool);
      this.k = bool;
      return;
    case 2131298810: 
      VideoReporter.a("0X80065FD", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), "");
      if (this.t == 2)
      {
        p();
        return;
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), AccountDetailActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"));
      paramView.putExtra("uintype", 1008);
      paramView.addFlags(268435456);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext().startActivity(paramView);
      return;
    case 2131296891: 
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        str = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
        if (this.l != 2) {
          break label1166;
        }
      }
      for (paramView = "0X80065EA";; paramView = "0X80065E9")
      {
        VideoReporter.a(paramView, this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), str);
        if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
          break;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
    case 2131298762: 
      label1166:
      p();
      return;
    }
    p();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label52;
      }
    }
    label52:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.pubaccount.video.VideoUIController", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    paramInt = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
    paramAdapterView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
    Object localObject;
    if (paramInt == 1)
    {
      paramView = this.jdField_a_of_type_AndroidContentContext;
      localObject = this.jdField_a_of_type_AndroidContentContext;
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(paramAdapterView);
      QRUtils.a(2, 2131364463);
      return;
    }
    if (paramInt == 11) {
      if (!Pattern.compile("http://.*.mp.qq.com.*").matcher(paramAdapterView).matches()) {
        break label1480;
      }
    }
    label661:
    label683:
    label820:
    label830:
    label839:
    label848:
    label961:
    label1214:
    label1356:
    label1480:
    for (paramInt = 1;; paramInt = 0)
    {
      paramView = null;
      try
      {
        paramAdapterView = URLEncoder.encode(paramAdapterView, "UTF-8");
        if (paramInt != 0)
        {
          paramView = String.valueOf(NetConnInfoCenter.getServerTime());
          localObject = MD5Utils.b(paramAdapterView + 200 + paramView + "jubao@article@123").toLowerCase();
          paramAdapterView = "http://jubao.mp.qq.com/mobile/report?qq=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "&mp_uin=" + this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN") + "&scene=200&sub_appname=article_webview&timestamp=" + paramView + "&sign=" + (String)localObject + "&article_url=" + paramAdapterView;
          paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
          paramView.putExtra("url", paramAdapterView);
          paramView.putExtra("hide_more_button", true);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
          return;
        }
      }
      catch (UnsupportedEncodingException paramAdapterView)
      {
        for (;;)
        {
          paramAdapterView = paramView;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.pubaccount.video.VideoUIController", 2, "encode url failed, because UTF-8 is unknown");
            paramAdapterView = paramView;
            continue;
            paramAdapterView = "http://guanjia.qq.com/online_server/m_report.html?url=" + paramAdapterView + "&qq=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "&_wv=7";
          }
        }
      }
      if (paramInt == 2)
      {
        String str2;
        String str3;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramAdapterView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.l == 2)
          {
            ReportController.b(null, "CliOper", "", "", "0X80065EE", "0X80065EE", 0, 0, VideoReporter.a(this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE")), "", paramAdapterView, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
            ReportController.b(null, "CliOper", "", "", "0X800668E", "0X800668E", 0, 0, Integer.toString(this.s), "", paramAdapterView, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
          }
        }
        else
        {
          paramAdapterView = (StructMsgForGeneralShare)StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle.getByteArray("STRUCT_MSG_BYTES"));
          paramView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON");
          localObject = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
          String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
          PAVideoStructMsgUtil.a(paramAdapterView);
          paramAdapterView.mSourceAction = "web";
          str2 = PAVideoStructMsgUtil.a(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN"));
          str3 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
          paramAdapterView.source_puin = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
          paramAdapterView.mSourceIcon = "http://q.url.cn/s/YnxqUe";
          if (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE") <= 1) {
            break label830;
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label820;
          }
          paramAdapterView.mSourceUrl = ((String)localObject);
          if ((str1 == null) || ("".equals(str1))) {
            break label839;
          }
          paramAdapterView.mSourceName = str1;
          if ((paramView == null) || ("".equals(paramView))) {
            break label848;
          }
        }
        for (paramAdapterView.mSourceIcon = paramView;; paramAdapterView.mSourceIcon = "http://q.url.cn/s/YnxqUe")
        {
          paramAdapterView.setFlag(0);
          paramView = new Bundle();
          paramView.putInt("forward_type", -3);
          paramView.putInt("structmsg_service_id", paramAdapterView.mMsgServiceID);
          paramView.putByteArray("stuctmsg_bytes", paramAdapterView.getBytes());
          paramAdapterView = new Intent();
          paramAdapterView.putExtras(paramView);
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, 21);
          return;
          ReportController.b(null, "CliOper", "", "", "0X80065ED", "0X80065ED", 0, 0, VideoReporter.a(this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE")), "", paramAdapterView, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
          break;
          paramAdapterView.mSourceUrl = "";
          break label661;
          paramAdapterView.mSourceUrl = str2;
          break label661;
          paramAdapterView.mSourceName = str3;
          break label683;
        }
      }
      if (paramInt == 4)
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.l != 2) {
            break label961;
          }
          VideoReporter.a("0X80065F6", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        }
        for (;;)
        {
          paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(paramAdapterView));
          paramAdapterView.putExtra("normal", true);
          try
          {
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
            return;
          }
          catch (ActivityNotFoundException paramAdapterView)
          {
            QRUtils.a(1, 2131364483);
            return;
          }
          VideoReporter.a("0X80065F5", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        }
      }
      if (paramInt == 3)
      {
        paramView = new Bundle();
        paramView.putString("title", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"));
        paramView.putString("desc", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"));
        paramView.putString("detail_url", paramAdapterView);
        paramAdapterView = new ArrayList(1);
        paramAdapterView.add(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COVER"));
        paramView.putStringArrayList("image_url", paramAdapterView);
        paramView.putLong("req_share_id", 0L);
        QZoneShareManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramView, null);
        return;
      }
      if (paramInt == 6)
      {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramAdapterView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.l != 2) {
            break label1214;
          }
          VideoReporter.a("0X80065EC", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramAdapterView);
        }
        for (;;)
        {
          paramAdapterView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          bool = QfavBuilder.a(paramAdapterView).c(paramView).a(this.jdField_a_of_type_AndroidAppActivity, paramView, 101, null);
          if (!bool) {
            break;
          }
          this.k = bool;
          return;
          VideoReporter.a("0X80065EB", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramAdapterView);
        }
      }
      if ((paramInt != 9) && (paramInt != 10)) {
        break;
      }
      if (paramInt == 9) {
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.l != 2) {
            break label1356;
          }
          VideoReporter.a("0X80065F4", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        }
      }
      for (;;)
      {
        VideoShareUtils.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TITLE"), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SUMMARY"), paramAdapterView, this.jdField_a_of_type_AndroidGraphicsBitmap, paramInt);
        return;
        VideoReporter.a("0X80065F3", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
        continue;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          paramView = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
          if (this.l == 2) {
            VideoReporter.a("0X80065F2", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
          } else {
            VideoReporter.a("0X80065F1", this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_AIO_UIN_TYPE"), this.s, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), paramView);
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoUIController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.MultiVideoPlayActivity;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.KandianPopupWindow;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.readinjoy.ReadInJoyHelper;
import iau;
import iav;
import iaw;
import iax;
import iay;
import ibb;
import ibd;
import ibg;
import ibh;
import ibi;
import ibj;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class ReadInJoyBaseAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final int A = 1001;
  private static final int B = 9;
  private static int C = 0;
  private static int D = 20;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static boolean d = false;
  public static final int e = 4;
  public static final int f = 9091;
  protected static final int g = 0;
  protected static final int h = 1;
  protected static final int i = 2;
  protected static final int j = 3;
  protected static final int k = 4;
  protected static final int l = 5;
  protected static final int m = 6;
  protected static final int n = 7;
  protected static final int o = 8;
  protected static final int r = 0;
  protected static final int s = 1;
  public static int t = 0;
  public static int u = 0;
  public static final int v = 1;
  public static final int w = 2;
  public static final int x = 3;
  public static final int y = 4;
  private long jdField_a_of_type_Long;
  public Activity a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected LayoutInflater a;
  private VideoAutoPlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController;
  public VideoPlayManager a;
  protected VideoPreloadMgr a;
  protected ReadInJoyBaseAdapter.OnLastReadRefreshListener a;
  private ReadInJoyBaseAdapter.PrefetchListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener;
  public ReadInJoyBaseAdapter.VideoFeedsViewHolder a;
  public ReadInJoyXListView.OnDrawCompleteListener a;
  public ThreadPriorityUtil a;
  public INetInfoHandler a;
  public AbsListView.OnScrollListener a;
  public AbsListView.RecyclerListener a;
  private KandianPopupWindow jdField_a_of_type_ComTencentWidgetKandianPopupWindow;
  public ListView a;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoyBaseAdapter";
  public List a;
  protected Map a;
  protected Set a;
  public boolean a;
  public List b;
  protected boolean b;
  public List c;
  public boolean c;
  private boolean e;
  private boolean f;
  public int p = -1;
  protected int q;
  public int z = -1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    t = 1000;
    C = 10;
    d = true;
  }
  
  public ReadInJoyBaseAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener = new ibg(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewThreadPriorityUtil = new ThreadPriorityUtil();
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ibh(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener = new ibi(this);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ibj(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.p = paramInt;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetListView.setRecyclerListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$RecyclerListener);
    if ((this.jdField_a_of_type_ComTencentWidgetListView instanceof ReadInJoyXListView)) {
      ((ReadInJoyXListView)this.jdField_a_of_type_ComTencentWidgetListView).setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView$OnDrawCompleteListener);
    }
    this.jdField_a_of_type_AndroidOsHandler = new iau(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow = new KandianPopupWindow(this.jdField_a_of_type_AndroidAppActivity);
    i();
  }
  
  private ShapeDrawable a(int paramInt)
  {
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    Object localObject = new RectF(1.5F, 1.5F, 1.5F, 1.5F);
    float f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    localObject = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (RectF)localObject, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    ((ShapeDrawable)localObject).getPaint().setShader(localLinearGradient);
    return (ShapeDrawable)localObject;
  }
  
  private Bundle a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    boolean bool;
    label172:
    int i1;
    label269:
    Bundle localBundle2;
    if (paramVideoPlayParam.jdField_e_of_type_Int == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramVideoPlayParam.jdField_a_of_type_Int));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramVideoPlayParam.jdField_b_of_type_Int));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramVideoPlayParam.jdField_c_of_type_Int));
      localBundle1.putString("VIDEO_VID", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle1.putString("VIDEO_COVER", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle1.putLong("VIDEO_PLAY_POSITION", paramVideoPlayParam.jdField_b_of_type_Long);
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putBoolean("IS_FROM_READINJOY_VIDEO_CHANNEL", ReadInJoyHelper.a(this.q));
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label618;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label624;
      }
      i1 = 0;
      localBundle1.putInt("interactionType", i1);
      localBundle1.putString("VIDEO_THIRD_ICON", paramVideoPlayParam.jdField_c_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_NAME", paramVideoPlayParam.jdField_d_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramVideoPlayParam.jdField_e_of_type_JavaLangString);
      localBundle1.putString("VIDEO_THIRD_URL", paramVideoPlayParam.f);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("TINFO", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramVideoPlayParam.jdField_b_of_type_Int);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramVideoPlayParam.jdField_c_of_type_Int);
      localBundle2.putInt("FULL_VIDEO_TIME", paramVideoPlayParam.jdField_a_of_type_Int);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramVideoPlayParam.jdField_e_of_type_Int != 1) {
        break label630;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramVideoPlayParam.jdField_e_of_type_Int);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", ReadInJoyTimeUtils.d(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)StructMsgFactory.a(localBundle2)).getBytes());
      return localBundle1;
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label618:
      bool = false;
      break label172;
      label624:
      i1 = 1;
      break label269;
      label630:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  private String a(int paramInt)
  {
    int i1 = paramInt / 3600;
    int i2 = (paramInt - i1 * 60) / 60;
    paramInt %= 60;
    String str1;
    String str2;
    if (i2 >= 10)
    {
      str1 = String.valueOf(i2);
      if (paramInt < 10) {
        break label113;
      }
      str2 = String.valueOf(paramInt);
      label48:
      if (i1 <= 0) {
        break label157;
      }
      if (i1 < 10) {
        break label134;
      }
    }
    label113:
    label134:
    for (String str3 = String.valueOf(i1);; str3 = String.format("0%d", new Object[] { Integer.valueOf(i1) }))
    {
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
      str1 = String.format("0%d", new Object[] { Integer.valueOf(i2) });
      break;
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
      break label48;
    }
    label157:
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  private JSONArray a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if ((paramString1 == null) || (paramString1.length() <= 0)) {
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramString2 = paramString1.optJSONArray(paramString2);
      if (paramString2 == null) {
        break;
      }
      paramString1 = paramString2;
    } while (paramString2.length() > 0);
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l1 = System.currentTimeMillis();
    if (!NetworkUtil.i(this.jdField_a_of_type_AndroidAppActivity)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    ThreadManager.a(new iax(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  private void a(int paramInt1, ReadInJoyBaseAdapter.DefaultViewHolder paramDefaultViewHolder, int paramInt2)
  {
    int i3 = 1;
    if (((paramInt2 != 1) && (paramInt2 != 5) && (paramInt2 != 7)) || (paramInt1 + 1 >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    int i4 = getItemViewType(paramInt1 + 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i1;
    if ((i4 != 1) && (i4 != 5))
    {
      i1 = i3;
      if (i4 != 7) {}
    }
    else
    {
      if ((this.jdField_b_of_type_JavaUtilList == null) || (paramInt1 >= this.jdField_b_of_type_JavaUtilList.size())) {
        break label320;
      }
      if (((Integer)this.jdField_b_of_type_JavaUtilList.get(paramInt1)).intValue() != 1) {
        break label407;
      }
    }
    label320:
    label394:
    label400:
    label407:
    for (int i2 = 1;; i2 = 0)
    {
      if ((a(a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt1 + 1)).longValue()), i4)) || (a(a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).longValue()), paramInt2))) {
        i2 = 1;
      }
      i1 = i3;
      if (!b(a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt1 + 1)).longValue()), i4))
      {
        if (!b(a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).longValue()), paramInt2)) {
          break label400;
        }
        i1 = i3;
      }
      for (;;)
      {
        if (i1 == 0)
        {
          localLayoutParams.height = AIOUtils.a(0.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localLayoutParams.setMargins(0, 0, 0, AIOUtils.a(1.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        }
        for (;;)
        {
          paramDefaultViewHolder.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          return;
          if (!QLog.isColorLevel()) {
            break label394;
          }
          QLog.d("ReadInJoyBaseAdapter", 2, "dividerList get " + paramInt1 + " failed");
          i1 = 0;
          break;
          localLayoutParams.setMargins(0, 0, 0, 0);
          localLayoutParams.height = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131493814);
        }
        i1 = 0;
        continue;
        i1 = i2;
      }
    }
  }
  
  private void a(int paramInt1, ReadInJoyBaseAdapter.DefaultViewHolder paramDefaultViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt2)
  {
    String str;
    if (paramBaseArticleInfo != null)
    {
      if (a(this.p, paramBaseArticleInfo.mArticleID)) {
        break label383;
      }
      paramDefaultViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427409));
      if (TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText)) {
        break label467;
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptColor)) {
        break label406;
      }
      str = "#00a5e0";
      paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mArticleSubscriptText);
    }
    for (;;)
    {
      try
      {
        paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(str));
        ApiCompatibilityUtils.a(paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor(str)));
        paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        str = paramBaseArticleInfo.mSubscribeName;
        if (paramBaseArticleInfo.mSubscribeName.length() > 18) {
          str = paramBaseArticleInfo.mSubscribeName.substring(0, 17) + "…";
        }
        paramDefaultViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        paramDefaultViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
        paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (ReadInJoyUtils.a(paramBaseArticleInfo)) {
          paramDefaultViewHolder.f.setText(a(paramBaseArticleInfo.mVideoDuration));
        }
        if (!b(this.p, paramBaseArticleInfo.mArticleID)) {
          break label479;
        }
        paramDefaultViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427759));
        paramDefaultViewHolder.jdField_b_of_type_AndroidViewView.clearAnimation();
        paramDefaultViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramDefaultViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        a(paramDefaultViewHolder, paramBaseArticleInfo);
        a(paramInt2, paramDefaultViewHolder, paramInt1);
        if (paramDefaultViewHolder.jdField_a_of_type_Int != getCount() - 1) {
          break label502;
        }
        paramDefaultViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        a(paramDefaultViewHolder, paramBaseArticleInfo, paramInt1);
        b(paramDefaultViewHolder, paramBaseArticleInfo, paramInt1);
        c(paramDefaultViewHolder, paramBaseArticleInfo, paramInt2);
        if (paramInt1 != 3) {
          break label513;
        }
        a(paramDefaultViewHolder, paramBaseArticleInfo);
        if ((paramInt1 == 8) || (paramInt1 == 7)) {
          paramDefaultViewHolder.j.setText(String.valueOf(paramBaseArticleInfo.mGalleryPicNumber));
        }
        paramDefaultViewHolder.jdField_a_of_type_AndroidViewView.setTag(paramDefaultViewHolder);
        paramDefaultViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        return;
        label383:
        paramDefaultViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427758));
        break;
        label406:
        str = paramBaseArticleInfo.mArticleSubscriptColor;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyBaseAdapter", 2, "configDefaultItem: ", localException);
        }
        paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
        ApiCompatibilityUtils.a(paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView, a(Color.parseColor("#00a5e0")));
        continue;
      }
      label467:
      paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      label479:
      ApiCompatibilityUtils.a(paramDefaultViewHolder.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130838878));
      continue;
      label502:
      paramDefaultViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      continue;
      label513:
      if ((paramInt1 != 0) && (paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView != null)) {
        a(paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView, paramBaseArticleInfo.mSinglePicture);
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = (StructMsgForGeneralShare)StructMsgFactory.a(paramBundle.getByteArray("STRUCT_MSG_BYTES"));
    if ((!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject).mMsgBrief)) && (((StructMsgForGeneralShare)localObject).mMsgBrief.indexOf("[视频]") == -1)) {
      ((StructMsgForGeneralShare)localObject).mMsgBrief = ("[视频]" + ((StructMsgForGeneralShare)localObject).mMsgBrief);
    }
    String str1 = paramBundle.getString("VIDEO_THIRD_ICON");
    String str2 = paramBundle.getString("VIDEO_THIRD_ACTION");
    String str3 = paramBundle.getString("VIDEO_THIRD_NAME");
    String str4 = paramBundle.getString("VIDEO_PUB_ACCOUNT_UIN");
    String str5 = paramBundle.getString("VIDEO_PUB_ACCOUNT_NAME");
    String str6 = PAVideoStructMsgUtil.a(str4);
    PAVideoStructMsgUtil.a((StructMsgForGeneralShare)localObject);
    ((StructMsgForGeneralShare)localObject).mSourceAction = "web";
    long l1;
    if (TextUtils.isEmpty(str4))
    {
      l1 = 0L;
      ((StructMsgForGeneralShare)localObject).mSourceAppid = l1;
      ((StructMsgForGeneralShare)localObject).source_puin = str4;
      if (paramBundle.getInt("VIDEO_ARTICLE_BUSITYPE") <= 1) {
        break label305;
      }
      if (TextUtils.isEmpty(str2)) {
        break label295;
      }
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str2;
      label173:
      if (!TextUtils.isEmpty(str3)) {
        ((StructMsgForGeneralShare)localObject).mSourceName = str3;
      }
      if (!TextUtils.isEmpty(str1)) {
        ((StructMsgForGeneralShare)localObject).mSourceIcon = str1;
      }
      if (!TextUtils.isEmpty(str5)) {
        ((StructMsgForGeneralShare)localObject).mSourceThirdName = str5;
      }
    }
    for (;;)
    {
      ((StructMsgForGeneralShare)localObject).setFlag(0);
      paramBundle = new Bundle();
      paramBundle.putInt("forward_type", -3);
      paramBundle.putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject).mMsgServiceID);
      paramBundle.putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject).getBytes());
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle);
      ForwardBaseOption.a(a(), (Intent)localObject, 21);
      return;
      l1 = Long.valueOf(str4).longValue();
      break;
      label295:
      ((StructMsgForGeneralShare)localObject).mSourceUrl = "";
      break label173;
      label305:
      ((StructMsgForGeneralShare)localObject).mSourceUrl = str6;
      ((StructMsgForGeneralShare)localObject).mSourceName = str5;
      ((StructMsgForGeneralShare)localObject).mSourceIcon = "http://q.url.cn/s/YnxqUe";
    }
  }
  
  private void a(ReadInJoyBaseAdapter.DefaultViewHolder paramDefaultViewHolder, View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      if (paramInt == 0)
      {
        paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
        paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      paramDefaultViewHolder.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131299902));
      paramDefaultViewHolder.k = ((TextView)paramView.findViewById(2131299903));
      paramDefaultViewHolder.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131299901);
      paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299890));
      paramDefaultViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297123));
      paramDefaultViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramDefaultViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296829));
      paramDefaultViewHolder.h = ((TextView)paramView.findViewById(2131299892));
      if ((paramInt == 2) || (paramInt == 3) || (paramInt == 0)) {
        paramDefaultViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyEllipseTextView = ((ReadInJoyEllipseTextView)paramView.findViewById(2131299893));
      }
      paramDefaultViewHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299896));
      paramDefaultViewHolder.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299895));
      paramDefaultViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299894));
      paramDefaultViewHolder.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131299897);
      paramDefaultViewHolder.g = ((TextView)paramView.findViewById(2131299898));
      paramDefaultViewHolder.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131299899);
      paramDefaultViewHolder.i = ((TextView)paramView.findViewById(2131299900));
      paramDefaultViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131299891);
      return;
      ViewGroup localViewGroup = (ViewGroup)paramView.findViewById(2131299889);
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      paramDefaultViewHolder.jdField_d_of_type_ComTencentImageURLImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView, true);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView, true);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramDefaultViewHolder.jdField_d_of_type_ComTencentImageURLImageView, true);
      ((LinearLayout.LayoutParams)paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.a(1.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      ((LinearLayout.LayoutParams)paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams()).setMargins(0, 0, AIOUtils.a(1.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
      localViewGroup.addView(paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView);
      localViewGroup.addView(paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView);
      localViewGroup.addView(paramDefaultViewHolder.jdField_d_of_type_ComTencentImageURLImageView);
      continue;
      localViewGroup = (ViewGroup)paramView.findViewById(2131299889);
      localViewGroup.setVisibility(0);
      KandianUrlImageView localKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidAppActivity);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, localKandianUrlImageView);
      localViewGroup.addView(localKandianUrlImageView);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = localKandianUrlImageView;
      continue;
      localViewGroup = (ViewGroup)paramView;
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131296303));
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView, false);
      continue;
      localViewGroup = (ViewGroup)paramView;
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131296303));
      paramDefaultViewHolder.f = ((TextView)paramView.findViewById(2131297963));
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView, false);
      continue;
      localViewGroup = (ViewGroup)paramView;
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131296303));
      paramDefaultViewHolder.f = ((TextView)paramView.findViewById(2131297963));
      continue;
      localViewGroup = (ViewGroup)paramView;
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131296303));
      paramDefaultViewHolder.j = ((TextView)paramView.findViewById(2131299907));
      continue;
      localViewGroup = (ViewGroup)paramView;
      localViewGroup.setVisibility(0);
      paramDefaultViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localViewGroup.findViewById(2131296303));
      paramDefaultViewHolder.j = ((TextView)paramView.findViewById(2131299907));
    }
  }
  
  private void a(ReadInJoyBaseAdapter.DefaultViewHolder paramDefaultViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "image json preParse fail ! ");
      }
      JSONArray localJSONArray = a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
        return;
      }
      localObject = localJSONArray.optJSONObject(0);
      if (localObject == null)
      {
        localObject = paramBaseArticleInfo.mFirstPagePicUrl;
        a(paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView, ReadInJoyUtils.b((String)localObject));
        localObject = localJSONArray.optJSONObject(1);
        if (localObject != null) {
          break label154;
        }
        localObject = paramBaseArticleInfo.mFirstPagePicUrl;
        label102:
        a(paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView, ReadInJoyUtils.b((String)localObject));
        localObject = localJSONArray.optJSONObject(2);
        if (localObject != null) {
          break label165;
        }
      }
      label154:
      label165:
      for (paramBaseArticleInfo = paramBaseArticleInfo.mFirstPagePicUrl;; paramBaseArticleInfo = ((JSONObject)localObject).optString("picture"))
      {
        a(paramDefaultViewHolder.jdField_d_of_type_ComTencentImageURLImageView, ReadInJoyUtils.b(paramBaseArticleInfo));
        return;
        localObject = ((JSONObject)localObject).optString("picture");
        break;
        localObject = ((JSONObject)localObject).optString("picture");
        break label102;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject = paramBaseArticleInfo.mSinglePicture;
      a(paramDefaultViewHolder.jdField_b_of_type_ComTencentImageURLImageView, (URL)localObject);
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label283;
      }
      localObject = paramBaseArticleInfo.mSinglePicture;
      label231:
      a(paramDefaultViewHolder.jdField_c_of_type_ComTencentImageURLImageView, (URL)localObject);
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label293;
      }
    }
    label283:
    label293:
    for (paramBaseArticleInfo = paramBaseArticleInfo.mSinglePicture;; paramBaseArticleInfo = paramBaseArticleInfo.mPictures[2])
    {
      a(paramDefaultViewHolder.jdField_d_of_type_ComTencentImageURLImageView, paramBaseArticleInfo);
      return;
      localObject = paramBaseArticleInfo.mPictures[0];
      break;
      localObject = paramBaseArticleInfo.mPictures[1];
      break label231;
    }
  }
  
  private void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnKeyListener paramOnKeyListener)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources();
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    String str1 = ((Resources)localObject).getString(2131362970);
    String str2 = ((Resources)localObject).getString(2131362969);
    String str3 = ((Resources)localObject).getString(2131362971);
    localObject = ((Resources)localObject).getString(2131362972);
    if (paramOnClickListener1 != null)
    {
      paramVideoFeedsViewHolder = paramOnClickListener1;
      if (paramOnClickListener2 == null) {
        break label129;
      }
    }
    for (;;)
    {
      paramVideoFeedsViewHolder = DialogUtil.a(localActivity, 232, str1, str2, str3, (String)localObject, paramVideoFeedsViewHolder, paramOnClickListener2);
      if (paramOnKeyListener != null) {
        paramVideoFeedsViewHolder.setOnKeyListener(paramOnKeyListener);
      }
      paramVideoFeedsViewHolder.show();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "show flow alert dialog!");
      }
      return;
      paramVideoFeedsViewHolder = new iav(this, paramVideoFeedsViewHolder);
      break;
      label129:
      paramOnClickListener2 = new iaw(this);
    }
  }
  
  private void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    Object localObject1;
    label68:
    label87:
    Object localObject2;
    if (QLog.isColorLevel())
    {
      if ("configVideoItem : article.mVideoVid:" + paramBaseArticleInfo.mVideoVid + " article.busiType:" + paramBaseArticleInfo.busiType + " article.thirdName:" + paramBaseArticleInfo.thirdName == null)
      {
        localObject1 = "";
        QLog.d("Q.readinjoy.video", 2, (String)localObject1);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
        break label954;
      }
      localObject1 = null;
      if ((localObject1 != null) && (((VideoPlayManager.VideoPlayParam)localObject1).jdField_d_of_type_Long == this.p)) {
        break label982;
      }
      localObject2 = new VideoPlayManager.VideoPlayParam();
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_AndroidWidgetFrameLayout = paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_b_of_type_AndroidWidgetFrameLayout = paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetFrameLayout;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_AndroidWidgetRelativeLayout = paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Long = paramBaseArticleInfo.mArticleID;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Int = paramBaseArticleInfo.mVideoDuration;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_b_of_type_Int = paramBaseArticleInfo.mVideoJsonWidth;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_c_of_type_Int = paramBaseArticleInfo.mVideoJsonHeight;
      if (paramBaseArticleInfo.mVideoCoverUrl != null) {
        break label970;
      }
      localObject1 = null;
      label197:
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new ReadinjoyVideoReportData();
      ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_JavaLangLong = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.mVideoVid;
      ((ReadinjoyVideoReportData)localObject1).jdField_a_of_type_Int = paramBaseArticleInfo.busiType;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = ((ReadinjoyVideoReportData)localObject1);
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_c_of_type_JavaLangString = paramBaseArticleInfo.thirdIcon;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_d_of_type_JavaLangString = paramBaseArticleInfo.thirdName;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_e_of_type_JavaLangString = paramBaseArticleInfo.thirdAction;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_e_of_type_Int = paramBaseArticleInfo.busiType;
      ((VideoPlayManager.VideoPlayParam)localObject2).i = paramBaseArticleInfo.innerUniqueID;
      ((VideoPlayManager.VideoPlayParam)localObject2).jdField_d_of_type_Long = paramBaseArticleInfo.mChannelID;
      localObject1 = localObject2;
      label308:
      ((VideoPlayManager.VideoPlayParam)localObject1).g = paramVideoFeedsViewHolder.jdField_a_of_type_Int;
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mTitle);
      localObject2 = paramBaseArticleInfo.mSubscribeName;
      if (paramBaseArticleInfo.mSubscribeName.length() > 18) {
        localObject2 = paramBaseArticleInfo.mSubscribeName.substring(0, 17) + "…";
      }
      paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramVideoFeedsViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(a(((VideoPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_Int));
      if (TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText)) {
        break label1073;
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptColor)) {
        break label1012;
      }
      localObject2 = "#00a5e0";
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseArticleInfo.mArticleSubscriptText);
    }
    for (;;)
    {
      try
      {
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor((String)localObject2));
        ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView, a(Color.parseColor((String)localObject2)));
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (a(this.p, paramBaseArticleInfo.mArticleID)) {
          break label1085;
        }
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427409));
        if (!b(this.p, paramBaseArticleInfo.mArticleID)) {
          break label1108;
        }
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427759));
        if (paramVideoFeedsViewHolder.jdField_a_of_type_Int != getCount() - 1) {
          break label1131;
        }
        paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        a(paramVideoFeedsViewHolder, paramBaseArticleInfo);
        if (paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyEllipseTextView != null) {
          paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyEllipseTextView.setVisibility(8);
        }
        a(paramVideoFeedsViewHolder, paramBaseArticleInfo, getItemViewType(paramInt));
        b(paramVideoFeedsViewHolder, paramBaseArticleInfo, getItemViewType(paramInt));
        c(paramVideoFeedsViewHolder, paramBaseArticleInfo, paramInt);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam = ((VideoPlayManager.VideoPlayParam)localObject1);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) || (((VideoPlayManager.VideoPlayParam)localObject1).jdField_d_of_type_Int <= 0) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(((VideoPlayManager.VideoPlayParam)localObject1).jdField_d_of_type_Int))) {
          break label1142;
        }
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(((VideoPlayManager.VideoPlayParam)localObject1).jdField_d_of_type_Int));
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "set covel image with video captured bitmap!");
        }
        if (!ReadInJoyHelper.a(this.q)) {
          break label1213;
        }
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramVideoFeedsViewHolder);
        if (!ReadInJoyHelper.a(paramBaseArticleInfo.innerUniqueID)) {
          break label1200;
        }
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838800);
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {
          break;
        }
        paramBaseArticleInfo = (ResizeURLImageView)paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296590);
        if (paramBaseArticleInfo == null) {
          break label1249;
        }
        localObject1 = paramBaseArticleInfo.getAnimation();
        if (localObject1 != null) {
          ((Animation)localObject1).cancel();
        }
        paramBaseArticleInfo.clearAnimation();
        paramBaseArticleInfo.setImageResource(2130839556);
        paramBaseArticleInfo.setVisibility(0);
        paramInt = AIOUtils.a(62.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localObject1 = new FrameLayout.LayoutParams(paramInt, paramInt);
        ((FrameLayout.LayoutParams)localObject1).gravity = 17;
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramBaseArticleInfo, (ViewGroup.LayoutParams)localObject1);
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
        paramVideoFeedsViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout.setTag(paramVideoFeedsViewHolder);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
        paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setTag(paramVideoFeedsViewHolder);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(paramVideoFeedsViewHolder);
        return;
        localObject1 = paramBaseArticleInfo.thirdName;
        break label68;
        label954:
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramBaseArticleInfo.mArticleID);
        break label87;
        label970:
        localObject1 = paramBaseArticleInfo.mVideoCoverUrl.getFile();
        break label197;
        label982:
        ((VideoPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout = paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout;
        ((VideoPlayManager.VideoPlayParam)localObject1).jdField_b_of_type_AndroidWidgetFrameLayout = paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetFrameLayout;
        ((VideoPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout;
        break label308;
        label1012:
        localObject2 = paramBaseArticleInfo.mArticleSubscriptColor;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ReadInJoyBaseAdapter", 2, "configVideoItem: ", localException);
        }
        paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#00a5e0"));
        ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView, a(Color.parseColor("#00a5e0")));
        continue;
      }
      label1073:
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      continue;
      label1085:
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427758));
      continue;
      label1108:
      ApiCompatibilityUtils.a(paramVideoFeedsViewHolder.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2131427750));
      continue;
      label1131:
      paramVideoFeedsViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      continue;
      label1142:
      URLImageView localURLImageView = paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramBaseArticleInfo.mVideoCoverUrl != null) {
        localObject1 = paramBaseArticleInfo.mVideoCoverUrl;
      }
      for (;;)
      {
        a(localURLImageView, (URL)localObject1);
        break;
        if (paramBaseArticleInfo.mSinglePicture != null) {
          localObject1 = paramBaseArticleInfo.mSinglePicture;
        } else {
          localObject1 = ReadInJoyUtils.b(paramBaseArticleInfo.mFirstPagePicUrl);
        }
      }
      label1200:
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838907);
      continue;
      label1213:
      paramVideoFeedsViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewView.setTag(paramVideoFeedsViewHolder);
      paramVideoFeedsViewHolder.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      continue;
      label1249:
      paramBaseArticleInfo = new ResizeURLImageView(this.jdField_a_of_type_AndroidAppActivity);
      paramBaseArticleInfo.setId(2131296590);
    }
  }
  
  private void a(ReadInJoyBaseAdapter.ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mIsDispTimestamp == 0)
    {
      paramViewHolder.h.setText(null);
      paramViewHolder.h.setVisibility(4);
      return;
    }
    paramViewHolder.h.setText(ReadInJoyTimeUtils.a(paramBaseArticleInfo.mTime, true));
    paramViewHolder.h.setVisibility(0);
  }
  
  private void a(ReadInJoyBaseAdapter.ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if (!a(paramBaseArticleInfo, paramInt))
    {
      paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    paramViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
    paramViewHolder.jdField_c_of_type_AndroidViewView.setTag(paramBaseArticleInfo);
    paramViewHolder.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    paramViewHolder.g.setText(paramBaseArticleInfo.mChannelInfoDisplayName);
    paramViewHolder.g.setTag(paramBaseArticleInfo);
    paramViewHolder.g.setOnClickListener(this);
  }
  
  private void a(URLImageView paramURLImageView, URL paramURL)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramURLImageView.setImageResource(2130838862);
    }
    for (;;)
    {
      return;
      Drawable localDrawable = paramURLImageView.getDrawable();
      if ((localDrawable == null) || (!(localDrawable instanceof URLDrawable)) || (!((URLDrawable)localDrawable).getURL().equals(paramURL)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "load image " + paramURL);
        }
        ReadInJoyDisplayUtils.a(paramURLImageView, paramURL, null, null, this.jdField_a_of_type_AndroidAppActivity);
        paramURLImageView.setURLDrawableDownListener(new ibb(this, paramURLImageView));
        paramURLImageView.setVisibility(0);
        if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyBaseAdapter", 2, "cancelDownload image " + ((URLDrawable)localDrawable).getURL());
          }
          ((URLDrawable)localDrawable).cancelDownload();
        }
      }
      else if (((URLDrawable)localDrawable).getStatus() != 1)
      {
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
        for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidAppActivity, ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).app.a(), null, "qqsetting_kandian_download_pic_flag", false); (!NetworkUtil.i(this.jdField_a_of_type_AndroidAppActivity)) && (bool); bool = false)
        {
          paramURLImageView.setImageResource(2130838862);
          ((URLDrawable)localDrawable).cancelDownload();
          return;
        }
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if (!a()) {}
    label129:
    for (;;)
    {
      return;
      int i1 = 0;
      for (;;)
      {
        if (i1 >= paramAbsListView.getChildCount()) {
          break label129;
        }
        Object localObject1 = paramAbsListView.getChildAt(i1);
        Object localObject2 = (ReadInJoyBaseAdapter.ViewHolder)((View)localObject1).getTag();
        if (((localObject2 instanceof ReadInJoyBaseAdapter.VideoFeedsViewHolder)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a((View)localObject1)))
        {
          paramAbsListView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)localObject2;
          localObject1 = paramAbsListView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          if ((localObject2 != null) && (((VideoPlayManager.VideoPlayParam)localObject2).jdField_a_of_type_Long == ((VideoPlayManager.VideoPlayParam)localObject1).jdField_a_of_type_Long) && (((VideoPlayManager.VideoPlayParam)localObject2).jdField_d_of_type_Long == this.p) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b())) {
            break;
          }
          VideoVolumeControl.a().a();
          a(paramAbsListView);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.a()) && (paramAbsListView != null))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, paramInt);
    }
  }
  
  private void a(Long paramLong)
  {
    int i2 = 0;
    if ((paramLong != null) && (this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.add(paramLong)))
    {
      BaseArticleInfo localBaseArticleInfo = a(this.p, paramLong.longValue());
      if (localBaseArticleInfo == null) {
        break label180;
      }
      paramLong = new ReportData();
      paramLong.jdField_a_of_type_JavaLangLong = Long.valueOf(localBaseArticleInfo.mArticleID);
      paramLong.jdField_a_of_type_Int = localBaseArticleInfo.mStrategyId;
      paramLong.jdField_a_of_type_Long = localBaseArticleInfo.mAlgorithmID;
      if (!TextUtils.isEmpty(localBaseArticleInfo.mVideoVid)) {
        paramLong.jdField_a_of_type_JavaLangString = localBaseArticleInfo.mVideoVid;
      }
      paramLong.jdField_b_of_type_Int = ReadInJoyUtils.a(localBaseArticleInfo);
      if (!((ArticleInfo)localBaseArticleInfo).hasChannelInfo()) {
        break label170;
      }
      i1 = localBaseArticleInfo.mChannelInfoId;
      paramLong.jdField_c_of_type_Int = i1;
      if (!TextUtils.isEmpty(localBaseArticleInfo.mArticleFriendLikeText)) {
        break label175;
      }
      i1 = i2;
      paramLong.jdField_d_of_type_Int = i1;
      paramLong.jdField_a_of_type_ArrayOfByte = localBaseArticleInfo.mServerContext;
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localBaseArticleInfo.mArticleID), paramLong);
    }
    label170:
    label175:
    label180:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        int i1 = 0;
        continue;
        i1 = 1;
      }
    }
    QLog.d("Q.readinjoy.", 2, "getArticleInfo fail ! articleSeq : " + paramLong);
  }
  
  private boolean a(long paramLong)
  {
    BaseArticleInfo localBaseArticleInfo = a(this.p);
    return (this.jdField_b_of_type_Boolean) && (localBaseArticleInfo != null) && (localBaseArticleInfo.mArticleID == paramLong);
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    return (((ArticleInfo)paramBaseArticleInfo).hasChannelInfo()) && (paramInt != 0) && ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (this.p == 0);
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f2 = paramAbsListView.b();
    float f1;
    if (u == 3)
    {
      f1 = (float)DeviceInfoUtil.i() * 0.5F;
      if ((f2 <= 0.0F) || (f2 >= f1)) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("canLoadImg", 2, "loadImg:" + bool + " v:" + f2);
      return bool;
      f1 = (float)DeviceInfoUtil.i() * 0.2F;
      break;
    }
  }
  
  private void b(ReadInJoyBaseAdapter.ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramViewHolder.i != null) && (paramViewHolder.jdField_d_of_type_AndroidViewView != null))
    {
      if (b(paramBaseArticleInfo, paramInt))
      {
        paramViewHolder.i.setText(paramBaseArticleInfo.mArticleFriendLikeText);
        paramViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      switch (paramBaseArticleInfo.mCommentIconType)
      {
      default: 
        paramViewHolder.i.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
      }
      paramBaseArticleInfo = a().getResources().getDrawable(2130838913);
      paramViewHolder.i.setCompoundDrawablesWithIntrinsicBounds(paramBaseArticleInfo, null, null, null);
      return;
    }
    paramViewHolder.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean b()
  {
    return (d) && (this.z != 2);
  }
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    return (!a(paramBaseArticleInfo, paramInt)) && (paramBaseArticleInfo.mArticleFriendLikeText != null);
  }
  
  private void c(ReadInJoyBaseAdapter.ViewHolder paramViewHolder, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    BaseArticleInfo localBaseArticleInfo = a(this.p);
    if ((this.jdField_b_of_type_Boolean) && (localBaseArticleInfo != null) && (localBaseArticleInfo.mArticleID == paramBaseArticleInfo.mArticleID) && (paramInt > 0))
    {
      paramViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      return;
    }
    paramViewHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
    paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  private boolean c()
  {
    return (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity)) && (ReadInJoyHelper.a(this.q));
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "cpu:" + DeviceInfoUtil.b() + " mem:" + DeviceInfoUtil.c() + " fre:" + DeviceInfoUtil.a());
    }
    int i1 = DeviceInfoUtil.b();
    long l1 = DeviceInfoUtil.c();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((i1 >= 4) && (l1 >= 1.610612736E9D))
      {
        C = 6;
        u = 1;
        d = true;
        return;
      }
      C = 4;
      u = 3;
      d = true;
      return;
    }
    if ((i1 >= 4) && (l1 >= 1.610612736E9D))
    {
      u = 2;
      C = 4;
      d = true;
      return;
    }
    u = 4;
    C = 2;
    d = false;
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener.a();
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "show not network toast");
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "无网络连接,请检测网络配置!", 0).a();
  }
  
  public int a()
  {
    return this.p;
  }
  
  public abstract int a(int paramInt);
  
  protected int a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.length();
  }
  
  public abstract Activity a();
  
  public abstract BaseArticleInfo a(int paramInt);
  
  public abstract BaseArticleInfo a(int paramInt, long paramLong);
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentWidgetListView;
  }
  
  public JSONObject a(String paramString)
  {
    try
    {
      paramString = (JSONObject)new JSONTokener(paramString).nextValue();
      return paramString;
    }
    catch (JSONException paramString)
    {
      return null;
    }
    catch (NullPointerException paramString) {}
    return null;
  }
  
  public void a()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public abstract void a(int paramInt, long paramLong, ArrayList paramArrayList);
  
  public void a(int paramInt, Intent paramIntent)
  {
    int i2 = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {
      return;
    }
    long l1;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("param_muteConfig"))) {
        VideoVolumeControl.a().a(paramIntent.getBooleanExtra("param_muteConfig", false), "return readinjoy process from 1t3");
      }
      this.f = true;
      this.jdField_c_of_type_Boolean = false;
      l1 = -1L;
      if (paramIntent != null) {
        l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
      }
      break;
    }
    for (paramInt = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);; paramInt = -1)
    {
      int i1 = i2;
      if (paramInt != 0)
      {
        if (paramInt != 2) {
          break label237;
        }
        i1 = i2;
      }
      while ((i1 != 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b())) {
        if ((l1 >= 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null))
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int >= 0)
          {
            paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int);
            if (paramIntent != null) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramIntent);
            }
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a((int)l1, false);
          return;
          label237:
          i1 = 0;
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
          return;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder == null) {
        break;
      }
      long l2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(4);
      paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam;
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.jdField_b_of_type_Long = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int = -1;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_DETAIL");
      }
      a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "channel change! check playable");
      }
      a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "UI Adjust ! check playable");
      }
      a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "do nothing!");
      }
      a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
      return;
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X80069AE", "0X80069AE", 0, 0, "", "", "", paramBaseArticleInfo.mVideoVid);
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80069AF", "0X80069AF", 0, 0, "", "", "", paramBaseArticleInfo.mVideoVid);
  }
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramVideoPlayParam.jdField_b_of_type_Long + ",vid : " + paramVideoPlayParam.jdField_a_of_type_JavaLangString);
    }
    Bundle localBundle = a(paramVideoPlayParam, paramBaseArticleInfo);
    if (paramVideoPlayParam.jdField_e_of_type_Int == 2)
    {
      paramVideoPlayParam = ThirdVidoeManager.a(paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      if (paramVideoPlayParam != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", paramVideoPlayParam.jdField_b_of_type_JavaLangString);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", paramVideoPlayParam.jdField_a_of_type_Long);
      }
    }
    paramVideoPlayParam = a();
    Intent localIntent = new Intent(paramVideoPlayParam, MultiVideoPlayActivity.class);
    if (BaseApplicationImpl.i != 1)
    {
      localBundle.putBoolean("param_needSmooth", VideoVolumeControl.a().b());
      localBundle.putBoolean("param_muteConfig", VideoVolumeControl.a().a());
    }
    localIntent.putExtras(localBundle);
    int i1 = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i1 = 4;
    }
    paramVideoPlayParam.startActivityForResult(localIntent, i1);
    paramVideoPlayParam.overridePendingTransition(2130968620, 2130968621);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131427758));
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController = paramVideoAutoPlayController;
    if (VideoAutoPlayController.a(this.jdField_a_of_type_AndroidAppActivity)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null)
      {
        a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr = new VideoPreloadMgr(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPreloadMgr);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.b(false);
    }
  }
  
  public void a(ReadInJoyBaseAdapter.OnLastReadRefreshListener paramOnLastReadRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener = paramOnLastReadRefreshListener;
  }
  
  public void a(ReadInJoyBaseAdapter.PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$PrefetchListener = paramPrefetchListener;
  }
  
  public void a(ReadInJoyBaseAdapter.VideoFeedsViewHolder paramVideoFeedsViewHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(2);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int >= 0))
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_d_of_type_Int);
      if (localBitmap != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(localBitmap);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$VideoFeedsViewHolder = paramVideoFeedsViewHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(paramVideoFeedsViewHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam);
  }
  
  public void a(List paramList)
  {
    StringBuilder localStringBuilder;
    if ((paramList != null) && (this.jdField_a_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("setData ");
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localStringBuilder.append("recommendSeq = " + localObject + ",\n ");
        }
        QLog.d("ReadInJoyBaseAdapter", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      d();
      this.e = true;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setData:");
      if (paramList != null) {
        break label192;
      }
    }
    label192:
    for (int i1 = 0;; i1 = paramList.size())
    {
      QLog.d("ReadInJoyBaseAdapter", 2, i1);
      this.jdField_a_of_type_Long = System.nanoTime();
      return;
    }
  }
  
  public void a(Set paramSet, Map paramMap)
  {
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public abstract boolean a(String paramString);
  
  public int b()
  {
    return this.q;
  }
  
  public BaseArticleInfo b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return a(this.p, localLong.longValue());
    }
    return null;
  }
  
  public void b()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void b(List paramList)
  {
    if ((paramList != null) && (this.jdField_a_of_type_JavaUtilList.getClass().isInstance(paramList)) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
      d();
    }
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      b();
    }
    d();
    this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow = null;
  }
  
  public void d()
  {
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      if (t > 1) {
        break;
      }
      i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(1));
        i1 += 1;
      }
    }
    int i1 = -1;
    int i2 = 0;
    label73:
    int i3;
    int i4;
    if (i2 < this.jdField_a_of_type_JavaUtilList.size())
    {
      i3 = getItemViewType(i2);
      this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(i3));
      if ((i2 < t - 1) || (i2 - t + 1 <= i1) || ((i3 != 1) && (i3 != 5) && (i3 != 7))) {
        break label293;
      }
      i4 = 1;
      i3 = 0;
      label147:
      if (i4 >= t) {
        break label290;
      }
      if ((((Integer)this.jdField_c_of_type_JavaUtilList.get(i2 - i4)).intValue() == 1) || (((Integer)this.jdField_c_of_type_JavaUtilList.get(i2 - i4)).intValue() == 5) || (((Integer)this.jdField_c_of_type_JavaUtilList.get(i2 - i4)).intValue() == 7)) {
        break label250;
      }
    }
    for (;;)
    {
      if (i3 != 0) {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(1));
      }
      for (;;)
      {
        i2 += 1;
        break label73;
        break;
        label250:
        if (i4 == t - 1)
        {
          i1 = i2;
          i3 = 1;
        }
        i4 += 1;
        break label147;
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      label290:
      continue;
      label293:
      i3 = 0;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(new iay(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyBaseAdapter", 2, "mVideoPlayManager == null");
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    this.f = true;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return a(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    int i1 = getItemViewType(paramInt);
    label127:
    Object localObject;
    BaseArticleInfo localBaseArticleInfo;
    if (paramView == null) {
      switch (i1)
      {
      case 2: 
      case 3: 
      default: 
        paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903737, null);
        a(paramView, paramViewGroup, i1);
        paramView.jdField_b_of_type_AndroidViewView = paramViewGroup;
        paramView.jdField_a_of_type_Int = paramInt;
        paramViewGroup.setTag(paramView);
        paramViewGroup.setTag(2131296653, (AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidAppActivity, 2130968635));
        localObject = (Long)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localBaseArticleInfo = a(this.p, ((Long)localObject).longValue());
        switch (i1)
        {
        default: 
          a(i1, (ReadInJoyBaseAdapter.DefaultViewHolder)paramView, localBaseArticleInfo, paramInt);
          a((Long)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      QLog.e("ReadInJoyBaseAdapter", 2, "getView cost:" + (System.currentTimeMillis() - l1));
      return paramViewGroup;
      paramView = new ReadInJoyBaseAdapter.VideoFeedsViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903763, null);
      paramView.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131299985));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297123));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131296303));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296829));
      paramView.h = ((TextView)paramViewGroup.findViewById(2131299892));
      paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyEllipseTextView = ((ReadInJoyEllipseTextView)paramViewGroup.findViewById(2131299893));
      paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297963));
      paramView.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131299908));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131299890));
      paramView.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131298755));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298756));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298753));
      paramView.jdField_e_of_type_AndroidViewView = paramViewGroup.findViewById(2131299901);
      paramView.jdField_c_of_type_AndroidViewView = paramViewGroup.findViewById(2131299897);
      paramView.g = ((TextView)paramViewGroup.findViewById(2131299898));
      paramView.jdField_d_of_type_AndroidViewView = paramViewGroup.findViewById(2131299899);
      paramView.i = ((TextView)paramViewGroup.findViewById(2131299900));
      paramView.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131298741));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131299986));
      paramView.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131299902));
      paramView.k = ((TextView)paramViewGroup.findViewById(2131299903));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131299891);
      paramViewGroup.setTag(paramView);
      break;
      paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903750, null);
      a(paramView, paramViewGroup, i1);
      break;
      paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903747, null);
      a(paramView, paramViewGroup, i1);
      break;
      paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903740, null);
      a(paramView, paramViewGroup, i1);
      break;
      paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903739, null);
      a(paramView, paramViewGroup, i1);
      break;
      paramView = new ReadInJoyBaseAdapter.DefaultViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903746, null);
      a(paramView, paramViewGroup, i1);
      break;
      paramViewGroup = (ReadInJoyBaseAdapter.ViewHolder)paramView.getTag();
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      localObject = paramView;
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
      break label127;
      a((ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView, localBaseArticleInfo, paramInt);
      a((Long)localObject);
    }
  }
  
  public int getViewTypeCount()
  {
    return 9;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(9);
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = 0;
    boolean bool1 = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {
        continue;
      }
      Object localObject = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
      localObject = a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(((ReadInJoyBaseAdapter.VideoFeedsViewHolder)localObject).jdField_a_of_type_Int)).longValue());
      if ((((BaseArticleInfo)localObject).mVideoVid != null) && (!TextUtils.isEmpty(((BaseArticleInfo)localObject).mVideoVid)) && (this.q == 3)) {
        ReportController.b(null, "CliOper", "", "", "0X8006996", "0X8006996", 0, 0, "1", VideoReporter.a(), Long.toString(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()), ((BaseArticleInfo)localObject).mVideoVid);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager == null) {
        continue;
      }
      if (VideoVolumeControl.a(this.jdField_a_of_type_AndroidAppActivity))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "正在通话中,无法播放视频", 0).a();
        return;
      }
      paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoAutoPlayController.c()) {
        if (!HttpUtil.a(this.jdField_a_of_type_AndroidAppActivity)) {
          k();
        }
      }
      for (;;)
      {
        if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) || (this.p != 0)) {
          break label613;
        }
        paramView = getItem(0);
        if (!(paramView instanceof Long)) {
          break;
        }
        paramView = ReadInJoyLogicEngine.a().a(this.p, ((Long)paramView).longValue());
        if (paramView == null) {
          break;
        }
        PublicAccountUtil.a(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).app, paramView.mTitle, String.valueOf(NetConnInfoCenter.getServerTime()), true);
        return;
        a(paramView, null, null, null);
        continue;
        localObject = paramView.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131296590);
        if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (((View)localObject).getTag() != null)) {}
        int i2;
        switch (((Integer)((View)localObject).getTag()).intValue())
        {
        default: 
          i1 = 0;
          i2 = 0;
        }
        for (;;)
        {
          if ((i2 == 0) && (i1 == 0) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() != paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_a_of_type_Long) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a()))) {
            break label592;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b() > 0) {
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.b();
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a() > 0) {
            paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a();
          a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int)).longValue()));
          this.jdField_c_of_type_Boolean = true;
          break;
          i1 = 0;
          i2 = 1;
          continue;
          i1 = 1;
          i2 = 0;
        }
        label592:
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyBaseAdapter", 2, "click to play in video channel");
        }
        a(paramView);
      }
      label613:
      continue;
      ReportController.b(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, "", "", "", ReadInJoyUtils.c());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener == null) {
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$OnLastReadRefreshListener.L_();
      return;
      paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
      localObject = a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int)).longValue());
      boolean bool2 = ReadInJoyHelper.a(((BaseArticleInfo)localObject).innerUniqueID);
      if (!bool2) {
        paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838800);
      }
      for (;;)
      {
        if (!bool2) {
          bool1 = true;
        }
        a((BaseArticleInfo)localObject, bool1);
        return;
        paramView.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838907);
      }
      paramView = (ReadInJoyBaseAdapter.VideoFeedsViewHolder)paramView.getTag();
      localObject = a(this.p, ((Long)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int)).longValue());
      a(a(paramView.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, (BaseArticleInfo)localObject));
      if ((((BaseArticleInfo)localObject).mVideoVid == null) || (TextUtils.isEmpty(((BaseArticleInfo)localObject).mVideoVid)) || (this.q != 3)) {
        continue;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006995", "0X8006995", 0, 0, "0", "", "", ((BaseArticleInfo)localObject).mVideoVid);
      return;
      paramView = (BaseArticleInfo)paramView.getTag();
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidAppActivity, paramView.mChannelInfoId, paramView.mChannelInfoName, paramView.mChannelInfoType, 1);
      if (((ArticleInfo)paramView).hasChannelInfo()) {
        i1 = paramView.mChannelInfoId;
      }
      try
      {
        paramView = new JSONObject();
        paramView.put("feeds_channel_entrance", i1);
        ReportController.b(null, "CliOper", "", "", "0X8006DF3", "0X8006DF3", 0, 0, "", "", "", paramView.toString());
        return;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
        return;
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.p);
        if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", ReadInJoyUtils.l);
          ReportController.b(null, "CliOper", "", "", "0X8007058", "0X8007058", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        }
        for (;;)
        {
          localObject = (ReadInJoyBaseAdapter.ViewHolder)paramView.getTag();
          Long localLong = (Long)this.jdField_a_of_type_JavaUtilList.get(((ReadInJoyBaseAdapter.ViewHolder)localObject).jdField_a_of_type_Int);
          BaseArticleInfo localBaseArticleInfo = a(this.p, localLong.longValue());
          i1 = ((ReadInJoyBaseAdapter.ViewHolder)localObject).jdField_a_of_type_Int;
          if (!this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a(i1, localBaseArticleInfo.mDislikeInfos)) {
            break;
          }
          this.jdField_a_of_type_ComTencentWidgetKandianPopupWindow.a(paramView, new ibd(this, i1, (ReadInJoyBaseAdapter.ViewHolder)localObject, localLong));
          return;
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            ((JSONObject)localObject).put("folder_status", 1);
            ReportController.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", ((JSONObject)localObject).toString());
          }
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\view\ReadInJoyBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
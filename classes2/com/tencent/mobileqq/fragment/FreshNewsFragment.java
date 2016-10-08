package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.mobileqq.dating.AnchorageManager.Anchorage;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter.OnPublishTopicListener;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.freshnews.topic.TopicInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.flat.async.FreshLayoutLoader;
import com.tencent.mobileqq.nearby.smooth.AsyncListView;
import com.tencent.mobileqq.nearby.smooth.ItemManager.Builder;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;
import java.util.List;
import sml;
import smm;
import smn;
import smo;
import smp;
import smq;
import smr;
import sms;
import smt;
import smu;

public class FreshNewsFragment
  extends NearbyBaseFragment
  implements View.OnClickListener, FreshNewsFeedAdapter.OnPublishTopicListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  static final long jdField_a_of_type_Long = 180000L;
  static final String jdField_a_of_type_JavaLangString = "Q.nearby.freshNews";
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  private static final int jdField_h_of_type_Int = 0;
  private static final int jdField_i_of_type_Int = 1;
  private static final int j = 2;
  private static final int m = 3;
  public int a;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  public FreshNewsFeedAdapter a;
  FreshNewsManager.CUnpublishedFeedsListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener;
  public FreshNewsManager a;
  FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver;
  public TopicInfo a;
  public AsyncListView a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  public PullRefreshHeader a;
  public ActionSheet a;
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public long b;
  View b;
  public String b;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  View jdField_c_of_type_AndroidViewView;
  View d;
  public boolean d;
  public View e;
  public boolean e;
  boolean f;
  boolean g;
  boolean jdField_h_of_type_Boolean;
  boolean jdField_i_of_type_Boolean;
  
  public FreshNewsFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = false;
    this.f = false;
    this.g = false;
    this.h = false;
    this.jdField_c_of_type_Int = 0;
    this.i = true;
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new sml(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new smn(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener = new smo(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new smm(this);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(ThreadManager.a(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  }
  
  protected void a()
  {
    Object localObject1 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(null, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView = ((AsyncListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300958));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setActTAG("actFPSFreshNews");
    Object localObject2 = getResources().getDrawable(2130838317);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOverscrollHeader((Drawable)localObject2);
    localObject2 = getResources().getDrawable(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOverscrollFooter((Drawable)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)((LayoutInflater)localObject1).inflate(2130903729, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView, false));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_b_of_type_AndroidViewView = ((LayoutInflater)localObject1).inflate(2130904246, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301964);
    ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131302100)).setText("暂无更多新鲜事");
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301965);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter = new FreshNewsFeedAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 0, this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter);
    int k = StatisticConstants.a();
    float f1;
    int n;
    if (k == 0)
    {
      f1 = 1.0F;
      k = 1;
      n = 10;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
      localObject1 = new ItemManager.Builder(new FreshLayoutLoader((Context)localObject1, NearbyAppInterface.jdField_a_of_type_ComTencentMobileqqNearbyFlatAsyncUIElementCache, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter));
      if (NearbyAppInterface.b)
      {
        ((ItemManager.Builder)localObject1).a(true).a(n);
        ((ItemManager.Builder)localObject1).b(k);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby.freshNews", 2, "FreshNewsFragment  initViews .prolaodCount = " + n + ",threadSize = " + k + ",NearbyAppInterface.sEnableFreshPreload = " + NearbyAppInterface.b + ",NearbyAppInterface.sEnableFreshStaticLayout = " + NearbyAppInterface.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setItemManager(((ItemManager.Builder)localObject1).a());
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.getViewTreeObserver().addOnGlobalLayoutListener(new smq(this));
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setOnScrollChangeListener(this);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setFriction(f1 * ViewConfiguration.getScrollFriction());
      }
      return;
      if (k == 1)
      {
        f1 = 0.9F;
        n = 15;
        k = 2;
      }
      else if (k == 2)
      {
        n = 20;
        k = 3;
        f1 = 0.8F;
      }
      else
      {
        f1 = 1.0F;
        k = 1;
        n = 10;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.s() + paramInt2 != paramInt3) {
      this.f = false;
    }
    while ((this.jdField_d_of_type_Boolean) || (this.f) || (paramInt3 <= 0) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) || (this.jdField_c_of_type_Int == 1) || (!NetworkUtil.e(getActivity()))) {
      return;
    }
    this.f = true;
    this.jdField_d_of_type_AndroidViewView.performClick();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "FreshNewsFragment onDecodeTaskCompleted uin=" + paramString + ", type=" + paramInt2);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    while (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(Long.valueOf(paramString).longValue(), paramBitmap);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, paramInt, 0, paramString);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    a(true, false, paramLong);
  }
  
  public void a(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("doOnNewIntent, paths=");
      if (localArrayList != null) {
        break label110;
      }
    }
    label110:
    for (paramIntent = "null";; paramIntent = localArrayList.toString())
    {
      QLog.i("Q.nearby.freshNews", 4, paramIntent);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, FreshNewsEditActivity.class);
        paramIntent.putStringArrayListExtra("param_photo_paths", localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {
          paramIntent.putExtra("param_topic_info", this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
        }
        startActivity(paramIntent);
      }
      return;
    }
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo = paramTopicInfo;
    h();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      if (paramInt == 2)
      {
        URLDrawable.pause();
        return;
      }
      URLDrawable.resume();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
    URLDrawable.resume();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.b();
    }
    i();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean)
  {
    int n = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298469);
    if (paramBoolean)
    {
      k = 2131370686;
      localTextView.setText(k);
      if (!paramBoolean) {
        break label99;
      }
      k = 0;
      label69:
      localProgressBar.setVisibility(k);
      if (!paramBoolean) {
        break label106;
      }
    }
    label99:
    label106:
    for (int k = n;; k = 0)
    {
      localImageView.setVisibility(k);
      return;
      k = 2131368205;
      break;
      k = 8;
      break label69;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int n = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.hasMessages(1)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(1);
    }
    if (paramBoolean1) {}
    for (int k = 1;; k = 0)
    {
      if (paramBoolean2) {
        n = 1;
      }
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.obtainMessage(1, k, n, Long.valueOf(paramLong));
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessageDelayed(localMessage, paramLong);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int n = 1;
    if (!NetworkUtil.e(getActivity()))
    {
      a(0, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131369008), 1000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "requestFeedList|cookie:" + paramArrayOfByte);
    }
    if ((this.jdField_d_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby.freshNews", 2, "requestFeedList|return! requesting...");
    }
    this.jdField_d_of_type_Boolean = true;
    boolean bool;
    if (paramArrayOfByte == null)
    {
      bool = true;
      this.jdField_e_of_type_Boolean = bool;
      if (paramArrayOfByte == null) {
        break label169;
      }
      k = 1;
      label111:
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, k, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (!paramBoolean) {
        break label175;
      }
    }
    label169:
    label175:
    for (int k = n;; k = 0)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.obtainMessage(2, k, 0, paramArrayOfByte);
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(paramArrayOfByte);
      return;
      bool = false;
      break;
      k = 0;
      break label111;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setSelection(0);
    }
  }
  
  public void f()
  {
    if ((this.k) || (this.jdField_a_of_type_AndroidViewView == null) || (!this.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      return;
      this.k = true;
      a();
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c();
      if (!this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.d()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(0);
      }
      while (QLog.isColorLevel())
      {
        NearbyUtils.a("Q.nearby.freshNews", new Object[] { "init", Boolean.valueOf(this.k), Long.valueOf(this.jdField_b_of_type_Long), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.d()) });
        return;
        a(0L);
      }
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(getActivity());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369187);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131369188);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new smr(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new sms(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c())
    {
      g();
      return;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131558973);
    localQQCustomDialog.setContentView(2130904163);
    ((TextView)localQQCustomDialog.findViewById(2131301654)).setText(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a()) + "心");
    localQQCustomDialog.setNegativeButton("忽略", new smt(this, localQQCustomDialog));
    localQQCustomDialog.setPositiveButton("去看攻略", new smu(this));
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.show();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    }
    label552:
    do
    {
      return true;
      f();
      return true;
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.H();
      return true;
      Object localObject = (List)paramMessage.obj;
      Bundle localBundle = paramMessage.getData();
      boolean bool1 = localBundle.getBoolean("isSuccess", true);
      boolean bool2 = localBundle.getBoolean("hasMore", false);
      boolean bool3 = localBundle.getBoolean("isPullToRefresh", false);
      if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a((List)localObject);
      }
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a();
      long l;
      if (bool1)
      {
        if (bool3)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 300L);
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.d(this.jdField_b_of_type_Long);
        if ((this.jdField_e_of_type_Boolean) && (this.g))
        {
          this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.setSelection(0);
          if (QLog.isColorLevel()) {
            QLog.d("Q.nearby.freshNews", 2, "onGetFeed, setSelection(0)");
          }
        }
        if ((localObject == null) || (((List)localObject).size() <= 0))
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          if (this.i)
          {
            this.i = false;
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName());
            if ((paramMessage != null) && (paramMessage.a != null)) {
              this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.onRestoreInstanceState(paramMessage.a);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) && (!this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a())) {
              this.jdField_a_of_type_Int = 1;
            }
            l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a());
            if ((l <= 0L) || (l <= 180000L)) {
              break label552;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.nearby.freshNews", 2, "initData exceed 3 min");
            }
            a(null, false);
          }
        }
      }
      for (;;)
      {
        NearbyUtils.a("Q.nearby.freshNews", "firstFreshUI", new Object[] { paramMessage, Long.valueOf(l) });
        i();
        return true;
        if (bool2)
        {
          this.jdField_d_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          break;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        break;
        if (bool3)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 300L);
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        localObject = "加载失败";
        if ((paramMessage.obj instanceof String)) {
          localObject = (String)paramMessage.obj;
        }
        a(1, (String)localObject, 0L);
        break;
        if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)) {
          this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if (paramMessage.arg1 == 0) {}
      for (k = 0;; k = paramMessage.arg1)
      {
        if ((paramMessage.obj instanceof String))
        {
          paramMessage = (String)paramMessage.obj;
          QQToast.a(BaseApplication.getContext(), k, paramMessage, 0).b(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getTitleBarHeight());
        }
        if ((this.jdField_e_of_type_AndroidViewView == null) || (this.jdField_e_of_type_AndroidViewView.getVisibility() == 8)) {
          break;
        }
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        return true;
      }
      if (paramMessage.arg1 == 1) {
        k = 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a();
    } while (k == 0);
    a(true);
    return true;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.hasMessages(3)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(3);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(3);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (this.jdField_b_of_type_JavaLangString == null);
    paramIntent = new Intent(getActivity(), FreshNewsEditActivity.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    paramIntent.putStringArrayListExtra("param_photo_paths", localArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {
      paramIntent.putExtra("param_topic_info", this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
    }
    startActivity(paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
    if ((!this.k) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
      f();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(), false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904170, null);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131301684);
    }
    if ((this.j) && (!this.k)) {
      f();
    }
    paramLayoutInflater = new smp(this);
    this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.c(getString(2131369273)).a(false).b(getString(2131372396)).a(paramLayoutInflater).a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onDestroy");
    }
    super.onDestroy();
    if (!this.k) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c) && (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(getClass().getName(), this.jdField_a_of_type_ComTencentMobileqqNearbySmoothAsyncListView.onSaveInstanceState(), null, null);
    }
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800599B", "0X800599B", 0, 0, this.jdField_a_of_type_Int + "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(System.currentTimeMillis());
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onPause");
    }
    super.onPause();
    if (!this.k) {
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_Long > 0L))
    {
      long l = Math.abs(System.currentTimeMillis() - this.jdField_c_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X8005999", "0X8005999", 0, 0, String.valueOf(l), "", "", "");
    }
    this.g = false;
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby.freshNews", 2, "onResume, needDoAnim=" + this.h);
    }
    super.onResume();
    this.jdField_e_of_type_Boolean = false;
    this.g = true;
    if (!this.k) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_e_of_type_Boolean = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.c("CliOper", "", "", "0X800599A", "0X800599A", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c)) {
        break label173;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null) {
        break;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c = null;
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(str);
      return;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    label173:
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.d();
      return;
    }
    a(0L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\fragment\FreshNewsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
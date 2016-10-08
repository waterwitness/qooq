package com.tencent.mobileqq.freshnews.topic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FreshNewsEditActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.FreshNewsFeedAdapter;
import com.tencent.mobileqq.freshnews.FreshNewsHandler;
import com.tencent.mobileqq.freshnews.FreshNewsInfo;
import com.tencent.mobileqq.freshnews.FreshNewsManager;
import com.tencent.mobileqq.freshnews.FreshNewsManager.CUnpublishedFeedsListener;
import com.tencent.mobileqq.freshnews.FreshNewsObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTitleBarActivity;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import srw;
import srx;
import ssb;
import ssc;
import ssd;
import sse;
import ssh;
import ssj;

public class NearbyTopicFeedActivity
  extends NearbyTitleBarActivity
{
  static final int jdField_a_of_type_Int = 30;
  public static final String a;
  public static final String b = "topic_info";
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new srx(this);
  public LinearLayout a;
  public FreshNewsFeedAdapter a;
  FreshNewsManager.CUnpublishedFeedsListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener = new ssb(this);
  public FreshNewsManager a;
  FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new ssh(this);
  public TopicInfo a;
  public NearbyAppInterface a;
  public NearbyMyTabCard a;
  FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = new ssd(this);
  public FaceDecoder a;
  public PullRefreshHeader a;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ssc(this);
  OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new sse(this);
  public XListView a;
  public List a;
  boolean jdField_a_of_type_Boolean = true;
  public byte[] a;
  int jdField_b_of_type_Int;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  public int c;
  public String c;
  boolean c;
  int d;
  public boolean d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyTopicFeedActivity.class.getSimpleName();
  }
  
  public NearbyTopicFeedActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext, TopicInfo paramTopicInfo)
  {
    Intent localIntent = new Intent(paramContext, NearbyTopicFeedActivity.class);
    localIntent.putExtra("topic_info", paramTopicInfo);
    paramContext.startActivity(localIntent);
  }
  
  private void f()
  {
    ThreadManager.b().post(new ssj(this));
  }
  
  public FreshNewsInfo a(FreshNewsInfo paramFreshNewsInfo)
  {
    if (TextUtils.isEmpty(paramFreshNewsInfo.publisherNickname))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.nickName))) {
        paramFreshNewsInfo.publisherNickname = "我";
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard != null)
    {
      if (paramFreshNewsInfo.publisherAge < 0) {
        paramFreshNewsInfo.publisherAge = this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.age;
      }
      if (paramFreshNewsInfo.publisherGender < 0) {
        if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.gender != 2) {
          break label102;
        }
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      paramFreshNewsInfo.publisherGender = i;
      return paramFreshNewsInfo;
      paramFreshNewsInfo.publisherNickname = this.jdField_a_of_type_ComTencentMobileqqNearpeopleMytabNearbyMyTabCard.nickName;
      break;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131300958));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130838317));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(this).inflate(2130903408, null));
    this.jdField_a_of_type_ComTencentWidgetXListView.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(this.jdField_b_of_type_Int);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    TextView localTextView;
    ProgressBar localProgressBar;
    if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, -this.jdField_d_of_type_Int, 0, 0);
      this.jdField_a_of_type_Boolean = false;
      localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298457);
      localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131297005);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298469);
      if (localImageView.getVisibility() != 8) {
        localImageView.setVisibility(8);
      }
      if (!paramBoolean1) {
        break label203;
      }
      localTextView.setTextColor(getResources().getColor(2131428302));
      localTextView.setText("正在加载");
      localProgressBar.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      return;
      if ((this.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_Boolean = true;
      break;
      label203:
      if (paramBoolean2)
      {
        localTextView.setTextColor(getResources().getColor(2131428332));
        localTextView.setText("加载更多");
        localProgressBar.setVisibility(8);
      }
      else
      {
        localTextView.setTextColor(getResources().getColor(2131428302));
        localTextView.setText("没有更多数据");
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.jdField_a_of_type_JavaLangString)) {}
    for (String str = "说说你的新鲜事";; str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.jdField_a_of_type_JavaLangString)
    {
      setTitle(str);
      setLeftViewName(2131369273);
      setRightButton(2131372396, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  void c()
  {
    this.jdField_b_of_type_Int = getTitleBarHeight();
    this.jdField_d_of_type_Int = ((int)(this.mDensity * 60.0F + 0.5D));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter = new FreshNewsFeedAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 2, this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter);
    a(false, false);
    ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.jdField_a_of_type_Long, 30, null, false);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
    ThreadManager.a().post(new srw(this));
    d();
  }
  
  public void d()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a();
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      int j = 0;
      while (j < i)
      {
        FreshNewsInfo localFreshNewsInfo = (FreshNewsInfo)localList.get(j);
        if ((localFreshNewsInfo != null) && (localFreshNewsInfo.topicInfo != null) && (localFreshNewsInfo.topicInfo.jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.jdField_a_of_type_Long)) {
          this.jdField_a_of_type_JavaUtilList.add(localFreshNewsInfo);
        }
        j += 1;
      }
    }
    f();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 != paramInt2) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
    } while (this.jdField_c_of_type_JavaLangString == null);
    paramIntent = new Intent(this, FreshNewsEditActivity.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    paramIntent.putStringArrayListExtra("param_photo_paths", localArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {
      paramIntent.putExtra("param_topic_info", this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
    }
    startActivity(paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904258);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130837958));
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof NearbyAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = ((NearbyAppInterface)paramBundle);
      if (getIntent() != null) {
        break label105;
      }
    }
    label105:
    for (paramBundle = null;; paramBundle = (TopicInfo)getIntent().getParcelableExtra("topic_info"))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo = paramBundle;
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {
        break;
      }
      finish();
      return true;
      throw new NullPointerException("NearbyAppInterface is null, appRuntime = " + paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
    a();
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("doOnNewIntent, paths=");
      if (localArrayList != null) {
        break label108;
      }
    }
    label108:
    for (paramIntent = "null";; paramIntent = localArrayList.toString())
    {
      QLog.i("IphoneTitleBarActivity", 4, paramIntent);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramIntent = new Intent(this, FreshNewsEditActivity.class);
        paramIntent.putStringArrayListExtra("param_photo_paths", localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo != null) {
          paramIntent.putExtra("param_topic_info", this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo);
        }
        startActivity(paramIntent);
      }
      return;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_d_of_type_Boolean = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_d_of_type_Boolean = true;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a(str);
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.d();
      return;
    }
    f();
  }
  
  public void e()
  {
    ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsTopicTopicInfo.jdField_a_of_type_Long, 30, this.jdField_a_of_type_ArrayOfByte, false);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_c_of_type_Boolean) {
      overridePendingTransition(2130968587, 2130968588);
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      Intent localIntent = new Intent(this, NearbyActivity.class);
      localIntent.putExtra("TAB", 1);
      localIntent.putExtra("abp_flag", true);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\topic\NearbyTopicFeedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
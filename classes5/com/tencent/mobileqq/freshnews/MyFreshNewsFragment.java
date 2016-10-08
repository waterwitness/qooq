package com.tencent.mobileqq.freshnews;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;
import srd;
import sre;
import srf;
import srg;
import srh;
import sri;
import srj;
import srk;

public class MyFreshNewsFragment
  extends FreshNewsBaseFragment
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener, ListView.OnScrollChangeListener
{
  public static final int a = 20;
  private static final String jdField_a_of_type_JavaLangString = "MyFreshNewsFragment";
  private static final int jdField_b_of_type_Int = 10;
  private static final int jdField_c_of_type_Int = 11;
  private static final int jdField_d_of_type_Int = 12;
  private static final int jdField_e_of_type_Int = 13;
  private static final int h = 0;
  private static final int i = 1;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected Handler.Callback a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private FreshNewsFeedAdapter jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter;
  private FreshNewsHandler jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler;
  private FreshNewsManager.CUnpublishedFeedsListener jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener;
  private FreshNewsManager jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
  private FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver;
  public MyFreshNewsActivity a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private CustomHandler jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  public boolean a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  
  public MyFreshNewsFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 10;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_JavaLangString = "-1";
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener = new srg(this);
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new srh(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new sri(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new srj(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new srk(this);
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.initData()");
    }
    if (this.jdField_e_of_type_Boolean) {}
    for (long l = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_Long;; l = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.d)
    {
      this.jdField_a_of_type_Long = l;
      if (!this.jdField_e_of_type_Boolean) {
        break label83;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.d()) {
        break;
      }
      a(0L);
      return;
    }
    ThreadManager.a(new sre(this), 5, null, true);
    return;
    label83:
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.g();
    List localList;
    if (this.jdField_b_of_type_Long > 0L)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(Long.valueOf(this.jdField_b_of_type_Long));
      if (localList == null) {
        break label169;
      }
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c(localList, null, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new srf(this), 1000L);
      return;
      localList = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(Long.valueOf(Long.parseLong(this.jdField_c_of_type_JavaLangString)));
      break;
      label169:
      ((MyFreshNewsActivity)getActivity()).a("正在加载...");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int k = 8;
    TextView localTextView = (TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidViewView.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131298469);
    if (paramBoolean)
    {
      j = 2131370686;
      localTextView.setText(j);
      if (!paramBoolean) {
        break label94;
      }
      j = 0;
      label65:
      localProgressBar.setVisibility(j);
      if (!paramBoolean) {
        break label101;
      }
    }
    label94:
    label101:
    for (int j = k;; j = 0)
    {
      localImageView.setVisibility(j);
      return;
      j = 2131368205;
      break;
      j = 8;
      break label65;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.s() + paramInt2 != paramInt3) {
      this.jdField_d_of_type_Boolean = false;
    }
    while ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (paramInt3 <= 0) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) || (this.jdField_f_of_type_Int == 1) || (!NetworkUtil.e(getActivity()))) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewView.performClick();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.onDecodeTaskCompleted uin=" + paramString + ", type=" + paramInt2);
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
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(13, paramInt, 0, paramString);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramString, paramLong);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.hasMessages(0)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    }
    if (paramLong > 0L)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.obtainMessage(0, 0, 0, Long.valueOf(paramLong));
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(localMessage);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(0);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    if ((paramInt == 1) || (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      if (paramInt == 2) {
        URLDrawable.pause();
      }
    }
    do
    {
      return;
      URLDrawable.resume();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      URLDrawable.resume();
    } while (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter == null);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.b();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeader(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeight(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollListener(null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.a().clear();
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter.notifyDataSetChanged();
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    }
    ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131297535)).setImageResource(2130838205);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface)) {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2131427641);
    }
    for (;;)
    {
      TextView localTextView1 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131298153);
      TextView localTextView2 = (TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131298160);
      localTextView1.setTextColor(getResources().getColor(2131427365));
      localTextView1.setText(paramString);
      localTextView2.setVisibility(8);
      return;
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2131427640);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.hasMessages(1)) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(1);
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.obtainMessage(1, paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendMessage(paramArrayOfByte);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity != null) && ((paramActivity instanceof MyFreshNewsActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsMyFreshNewsActivity = ((MyFreshNewsActivity)paramActivity);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(true);
    if (this.jdField_e_of_type_Boolean) {}
    for (paramView = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b();; paramView = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.c())
    {
      a(paramView);
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.onCreateView()");
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(ThreadManager.a(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("parm_mode", 10);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_guest_nick");
      this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidContentIntent.getLongExtra("param_guest_tinyid", -1L);
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("param_guest_uin");
    }
    if (this.jdField_g_of_type_Int == 10) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Boolean = bool;
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_b_of_type_Long = 0L;
      }
      paramViewGroup = paramLayoutInflater.inflate(2130904179, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)paramViewGroup.findViewById(2131300958));
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramViewGroup.findViewById(2131301728));
      paramBundle = getResources().getDrawable(2130838317);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)paramLayoutInflater.inflate(2130903729, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
      this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904246, null);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301964);
      paramLayoutInflater = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131302100);
      if (paramLayoutInflater != null) {
        paramLayoutInflater.setText(getResources().getString(2131372183));
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301965);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b(this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler = ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter = new FreshNewsFeedAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, 1, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsFeedAdapter);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOnScrollChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getViewTreeObserver().addOnGlobalLayoutListener(new srd(this));
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.b(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager$CUnpublishedFeedsListener);
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.g();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.jdField_b_of_type_Boolean = false;
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.onResume()");
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_e_of_type_Boolean)
    {
      a(0L);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = true;
      getActivity().setResult(220);
      a("已屏蔽该用户新鲜事。");
      return;
    }
    a(0L);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("FreshNews", 2, "MyFreshNewsFragment.onViewCreated(), mode=" + this.jdField_g_of_type_Int + ", tinyid=" + this.jdField_b_of_type_Long);
    }
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\MyFreshNewsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
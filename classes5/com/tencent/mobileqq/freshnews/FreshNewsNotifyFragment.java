package com.tencent.mobileqq.freshnews;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.OverScrollViewListener;
import java.util.List;
import mqq.os.MqqHandler;
import sqr;
import sqs;
import sqt;
import squ;
import sqv;

public class FreshNewsNotifyFragment
  extends FreshNewsBaseFragment
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final int a = 100;
  private static final String jdField_a_of_type_JavaLangString = "FreshNewsNotifyFragment";
  private static final int jdField_b_of_type_Int = 10;
  private static final int jdField_c_of_type_Int = 11;
  private static final int jdField_d_of_type_Int = 12;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private FPSXListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView;
  private FreshNewsHandler jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler;
  private FreshNewsManager jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
  private FreshNewsNotifyAdapter jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter;
  private FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private OverScrollViewListener jdField_a_of_type_ComTencentWidgetOverScrollViewListener;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private int e;
  
  public FreshNewsNotifyFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new sqs(this);
    this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener = new sqt(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new squ(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = true;
    List localList = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.a(this.e, 100);
    if ((localList != null) && (localList.size() > 0)) {}
    for (int i = localList.size();; i = 0)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initData(). dbList size=");
        if (localList == null)
        {
          localObject = "null";
          QLog.i("FreshNewsNotifyFragment", 2, localObject);
        }
      }
      else
      {
        if (i != 100) {
          break label172;
        }
      }
      label172:
      for (boolean bool = true;; bool = false)
      {
        this.jdField_c_of_type_Boolean = bool;
        this.e = (i + this.e);
        a(false);
        b(this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter.a(localList, false);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter);
        a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.e, this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager.f);
        return;
        localObject = Integer.valueOf(localList.size());
        break;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler.a(paramLong1, paramLong2, 100, true);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 8;
    TextView localTextView = (TextView)this.d.findViewById(2131298457);
    ProgressBar localProgressBar = (ProgressBar)this.d.findViewById(2131297005);
    ImageView localImageView = (ImageView)this.d.findViewById(2131298469);
    if (paramBoolean)
    {
      i = 2131370686;
      localTextView.setText(i);
      if (!paramBoolean) {
        break label94;
      }
      i = 0;
      label65:
      localProgressBar.setVisibility(i);
      if (!paramBoolean) {
        break label101;
      }
    }
    label94:
    label101:
    for (int i = j;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
      i = 2131368205;
      break;
      i = 8;
      break label65;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter.a()))
    {
      this.d.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.d.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsNotifyFragment", 2, "FreshNewsNotifyFragment.onItemClick position=" + paramInt);
    }
    FreshNewsNotify localFreshNewsNotify = this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter.a(paramInt);
    if (localFreshNewsNotify != null)
    {
      FreshNewsInfo localFreshNewsInfo = new FreshNewsInfo();
      localFreshNewsInfo.feedId = localFreshNewsNotify.feedId;
      FreshNewsUtil.a(getActivity(), localFreshNewsInfo, 1);
      if (localFreshNewsNotify.readType != 0) {
        break label125;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800578C", "0X800578C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      localFreshNewsNotify.readType = 0;
      ThreadManager.a().post(new sqv(this, localFreshNewsNotify));
      return;
      label125:
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a("CliOper", "", "", "0X800578D", "0X800578D", 0, 0, "", "", "", "");
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FreshNewsNotifyFragment", 2, "FreshNewsNotifyFragment.onDecodeTaskCompleted uin=" + paramString + ", type=" + paramInt2);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())) {}
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.getChildAt(paramInt1);
        if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof FreshNewsNotifyAdapter.ViewHolder)))
        {
          localObject = (FreshNewsNotifyAdapter.ViewHolder)((View)localObject).getTag();
          this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter.a(Long.parseLong(paramString), (FreshNewsNotifyAdapter.ViewHolder)localObject, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    FreshNewsNotifyAdapter.ViewHolder localViewHolder = (FreshNewsNotifyAdapter.ViewHolder)paramView.getTag();
    if (localViewHolder != null) {
      a(localViewHolder.a);
    }
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Boolean = true;
    a(true);
    ThreadManager.a().post(new sqr(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = paramLayoutInflater.inflate(2130904180, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView = ((FPSXListView)paramViewGroup.findViewById(2131300958));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverscrollHeader(getResources().getDrawable(2130838317));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setContentBackground(getResources().getDrawable(2130837958), false, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)paramLayoutInflater.inflate(2130903729, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, false));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.setOverScrollListener(this.jdField_a_of_type_ComTencentWidgetOverScrollViewListener);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2130904246, null);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131301964);
    paramLayoutInflater = (TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131302100);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setText(getResources().getString(2131372184));
    }
    this.d = this.jdField_b_of_type_AndroidViewView.findViewById(2131301965);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView.b(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter = new FreshNewsNotifyAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSXListView, this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsHandler = ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = ((FreshNewsManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(211));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    return this.jdField_a_of_type_AndroidViewView;
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
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsNotifyAdapter.notifyDataSetChanged();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsNotifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
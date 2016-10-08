package com.tencent.mobileqq.activity.qqcard;

import LBS.LBSInfo;
import QCARD.CouponMobileFolder;
import QCARD.CouponMobileItem;
import QCARD.GetListRsp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQCardHandler;
import com.tencent.mobileqq.app.QQCardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.BaseFragment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import osp;
import osq;
import osr;

public class NearByQQCardFragment
  extends BaseFragment
  implements Handler.Callback, RefreshFooter.RefreshListener, AdapterView.OnItemClickListener, OverScrollViewListener
{
  public static final int a = 1;
  public static final String a;
  private long jdField_a_of_type_Long;
  private LBSInfo jdField_a_of_type_LBSLBSInfo;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQCardAdapter jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter;
  private RefreshFooter jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter;
  private QQCardHandler jdField_a_of_type_ComTencentMobileqqAppQQCardHandler;
  private QQCardObserver jdField_a_of_type_ComTencentMobileqqAppQQCardObserver;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean d;
  private boolean e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearByQQCardFragment.class.getSimpleName();
  }
  
  public static NearByQQCardFragment a(int paramInt)
  {
    NearByQQCardFragment localNearByQQCardFragment = new NearByQQCardFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("tabID", paramInt);
    localNearByQQCardFragment.setArguments(localBundle);
    return localNearByQQCardFragment;
  }
  
  private void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getNearCouponList, is requesting");
      }
      return;
    }
    this.d = true;
    if (!this.e) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter.a(0);
    }
    ThreadManager.a().post(new osr(this, paramBoolean));
  }
  
  private void a(boolean paramBoolean, GetListRsp paramGetListRsp)
  {
    this.d = false;
    Object localObject;
    int i;
    if (this.e)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (paramBoolean)
      {
        i = 0;
        ((PullRefreshHeader)localObject).a(i);
        label30:
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 800L);
        if ((paramBoolean) && (paramGetListRsp != null)) {
          break label82;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, "系统繁忙，请稍后重试！", 0).a();
      }
    }
    label82:
    label323:
    label325:
    do
    {
      return;
      i = 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter.a(0);
      break label30;
      this.jdField_a_of_type_Long = paramGetListRsp.sequence;
      this.jdField_a_of_type_JavaUtilMap = paramGetListRsp.map_folderid_nextindex;
      if ((paramGetListRsp.map_folderid_nextindex == null) || (paramGetListRsp.map_folderid_nextindex.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter.a(2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetNearbyCardList isSuccess=" + paramBoolean + ",isPullRefreshing=" + this.e + ",mFolderIndexMap=" + this.jdField_a_of_type_JavaUtilMap);
        }
        localObject = new ArrayList();
        paramGetListRsp = paramGetListRsp.folder_list.iterator();
      }
      for (;;)
      {
        if (!paramGetListRsp.hasNext()) {
          break label325;
        }
        CouponMobileFolder localCouponMobileFolder = (CouponMobileFolder)paramGetListRsp.next();
        Iterator localIterator = localCouponMobileFolder.coupon_list.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label323;
          }
          CouponMobileItem localCouponMobileItem = (CouponMobileItem)localIterator.next();
          if (this.b == 1)
          {
            ((List)localObject).add(new QQCardItem(localCouponMobileItem, 1, localCouponMobileFolder.folder_id));
            continue;
            this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter.a(0);
            break;
          }
          if (this.b == 0) {
            ((List)localObject).add(new QQCardItem(localCouponMobileItem, 5, localCouponMobileFolder.folder_id));
          }
        }
      }
    } while (((List)localObject).size() <= 0);
    if (this.e) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter.a((List)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter.b((List)localObject);
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (QQCardItem)this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter.getItem(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
      paramView.putExtra("url", paramAdapterView.jumpUrl);
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(paramView);
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onViewCompleteVisableAndReleased overScrollPosition=" + paramInt);
    }
    if (this.d)
    {
      paramListView.H();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    a(true);
    return true;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.d) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.jdField_a_of_type_ComTencentWidgetXListView.H();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreateView, reuse list view");
      }
      return this.jdField_a_of_type_ComTencentWidgetXListView;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler = ((QQCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.a(69));
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    paramViewGroup = this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, QQCardConstant.v, 0, 0);
      this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(paramViewGroup);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130838317));
      this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(getResources().getDrawable(2130837958), false, true);
      this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)paramLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131492895));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter = new RefreshFooter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, this, null);
      paramLayoutInflater = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      paramViewGroup = new LinearLayout.LayoutParams(-2, -2);
      paramViewGroup.gravity = 1;
      paramLayoutInflater.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter.a, paramViewGroup);
      this.jdField_a_of_type_ComTencentWidgetXListView.b(paramLayoutInflater);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardRefreshFooter);
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter = new QQCardAdapter(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardAdapter);
      this.b = getArguments().getInt("tabID");
      if (this.b != 0) {
        break label412;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver = new osp(this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
      a(true);
      return this.jdField_a_of_type_ComTencentWidgetXListView;
      paramViewGroup.width = -1;
      paramViewGroup.height = -1;
      break;
      label412:
      if (this.b == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver = new osq(this);
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.b(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\NearByQQCardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
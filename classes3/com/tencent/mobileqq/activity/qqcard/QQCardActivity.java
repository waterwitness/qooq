package com.tencent.mobileqq.activity.qqcard;

import QCARD.CouponMobileFolder;
import QCARD.CouponMobileItem;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQCardHandler;
import com.tencent.mobileqq.app.QQCardObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import oss;
import ost;
import osu;
import osv;

public class QQCardActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, QQCardExpandableAdapter.OnAddCardListener, QQCardHeader.QQCardHeaderListener, OverScrollViewListener
{
  public static final int a = 1;
  public static final String a = "QQCard.QQCardActivity";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  private long jdField_a_of_type_Long;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQCardExpandableAdapter jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter;
  private QQCardFooter jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter;
  private QQCardHeader jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader;
  private QQCardManager jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager;
  private QQCardHandler jdField_a_of_type_ComTencentMobileqqAppQQCardHandler;
  QQCardObserver jdField_a_of_type_ComTencentMobileqqAppQQCardObserver;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XExpandableListView jdField_a_of_type_ComTencentWidgetXExpandableListView;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private int n;
  private int o;
  
  public QQCardActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver = new ost(this);
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "requestCouponList, type=" + paramInt);
    }
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardActivity", 2, "requestCouponList, is requesting.");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    if ((paramInt == 3) && (l1 - this.jdField_a_of_type_Long < this.n))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardActivity", 2, "requestCouponList, frequency limit, " + this.jdField_a_of_type_Long + ", " + l1 + ", " + this.n);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
    }
    this.o = paramInt;
    this.jdField_a_of_type_Long = l1;
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    l1 = 0L;
    if ((paramInt == 4) || (paramInt == 3) || (paramInt == 2)) {
      l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a("qqcard_sequence_631");
    }
    if (paramInt == 2) {}
    for (Map localMap = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a();; localMap = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler.a(l1, 5, 1, localMap, null);
      this.c = true;
      return;
    }
  }
  
  private void a(long paramLong, CouponMobileFolder paramCouponMobileFolder)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCouponMobileFolder.coupon_list.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new QQCardItem((CouponMobileItem)localIterator.next(), 0, paramCouponMobileFolder.folder_id));
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleChange, seq" + paramLong + ", size=" + localArrayList.size());
    }
    paramCouponMobileFolder = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.a(localArrayList);
    if (paramCouponMobileFolder == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardActivity", 2, "handleChange, exception");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      return;
    }
    if (paramCouponMobileFolder.size() <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(0, TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      ThreadManager.a(new osv(this, paramCouponMobileFolder, paramLong), 8, null, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(8, TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    }
  }
  
  private void a(long paramLong, Map paramMap, CouponMobileFolder paramCouponMobileFolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleUpdate, seq" + paramLong + ", " + paramMap.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a(paramMap);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCouponMobileFolder.coupon_list.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new QQCardItem((CouponMobileItem)localIterator.next(), 0, paramCouponMobileFolder.folder_id));
    }
    this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
    if (!paramMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardActivity", 2, "handleUpdate, has more cards.");
      }
      a(2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleUpdate, has no more cards, " + this.jdField_b_of_type_JavaUtilList.size());
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.a(this.jdField_b_of_type_JavaUtilList);
    if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(0, TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(this.jdField_b_of_type_JavaLangString);
      ThreadManager.a(new osu(this, new ArrayList(this.jdField_b_of_type_JavaUtilList), paramLong), 8, null, true);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(8, TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    }
  }
  
  private void c()
  {
    setTitle(this.jdField_a_of_type_AndroidContentResResources.getString(2131366564));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)findViewById(2131303211));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOverscrollHeader(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130838317));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setNeedCheckSpringback(true);
    View localView = getLayoutInflater().inflate(2130904586, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader = new QQCardHeader(this, localView);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader.a(this);
    localView = getLayoutInflater().inflate(2130904585, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter = new QQCardFooter(this, this.app, localView);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2130903499, this.jdField_a_of_type_ComTencentWidgetXExpandableListView, false));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOverScrollHeight(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131492895));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter = new QQCardExpandableAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter);
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(i1);
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader.a();
  }
  
  private void d()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a("qqcard_expired_link");
    long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a("qqcard_sequence_631");
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "initData, localSeq=" + l1);
    }
    if (l1 != 0L)
    {
      ThreadManager.a(new oss(this), 8, null, true);
      return;
    }
    a(1);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleNoChange");
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a();
    }
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "onNotCompleteVisable, overScrollPosition=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "onViewCompleteVisableAndReleased, overScrollPosition=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    a(3);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.f(QQCardConstant.y, 1000);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "onViewCompleteVisable, overScrollPosition=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "onViewNotCompleteVisableAndReleased, overScrollPosition=" + paramInt);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904565);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler = ((QQCardHandler)this.app.a(69));
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager = ((QQCardManager)this.app.getManager(116));
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
    c();
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "handleMessage, " + i1);
    }
    switch (i1)
    {
    default: 
      return false;
    case 5: 
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.a(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        a(4);
        return false;
      }
      a(1);
      return false;
    case 1: 
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader.a()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardFooter.a(this.jdField_b_of_type_JavaLangString);
        return false;
        this.jdField_b_of_type_Boolean = true;
      }
    case 2: 
      QQToast.a(this, this.jdField_a_of_type_AndroidContentResResources.getString(2131366565), 0).b(getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
      return false;
    case 3: 
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.I();
      return false;
    case 4: 
      QQToast.a(this, this.jdField_a_of_type_AndroidContentResResources.getString(2131366565), 0).b(getTitleBarHeight());
      return false;
    }
    a(1);
    return false;
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardExpandableAdapter.a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
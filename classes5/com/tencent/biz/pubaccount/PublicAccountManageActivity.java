package com.tencent.biz.pubaccount;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import hpt;
import hpu;
import hpv;
import hpw;
import hpx;
import hqc;
import hqd;
import mqq.os.MqqHandler;

public class PublicAccountManageActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener
{
  public static final int a = 100;
  private static final String jdField_a_of_type_JavaLangString = "PublicAccountManageActivity";
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PublicAccountManageAdapter jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View c;
  
  public PublicAccountManageActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297392));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297635));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131298734).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)super.findViewById(2131297950));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130842940);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130903481, null);
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)super.findViewById(2131297951));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    View localView = this.jdField_b_of_type_AndroidViewView.findViewById(2131297887);
    if (ThemeUtil.isInNightMode(this.app))
    {
      localView.setBackgroundResource(2130837959);
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#f5f5f5"));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131372565);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131371914);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840081);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (AppSetting.j)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + "返回按钮");
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364687));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(paramBoolean);
    e();
    ThreadManager.c(new hpu(this, paramBoolean));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setContentBackground(getResources().getDrawable(2130837959), false);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130837959);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter = new PublicAccountManageAdapter(this.app, this, this.jdField_a_of_type_ComTencentWidgetSwipListView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (!paramBoolean) {
        break label84;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131372570);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      new MqqHandler().postDelayed(new hpw(this), 2000L);
      return;
      label84:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131372571);
    }
  }
  
  private void d()
  {
    View localView = super.findViewById(2131297082);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131296706);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131297083);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  private void e()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.app.getManager(55);
    if ((this.jdField_a_of_type_Boolean) && (localPublicAccountDataManager != null) && (localPublicAccountDataManager.b()))
    {
      long l = PublicAccountUtil.b(this.jdField_a_of_type_Long) / PublicAccountConfigUtil.c;
      if (PublicAccountUtil.b(NetConnInfoCenter.getServerTimeMillis()) / PublicAccountConfigUtil.c - l < 30L) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (i != 0) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
      }
      else {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
  }
  
  private void f()
  {
    ActionSheet localActionSheet;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131372567);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131372568, 5, this.jdField_a_of_type_Boolean);
      localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (this.jdField_a_of_type_Boolean) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      localActionSheet.a(2131372569, 5, bool);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new hpt(this));
      if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", "", "0X8006DE9", "0X8006DE9", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    ThreadManager.c(new hpx(this));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView)
  {
    d(false);
    hqc localhqc = ((hqd)paramView.getTag()).a;
    String str = "";
    if (localhqc != null) {
      str = localhqc.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin();
    }
    for (long l = localhqc.jdField_a_of_type_Long;; l = 0L)
    {
      if (paramView == this.c)
      {
        ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", str, "0X800679D", "0X800679D", 0, 0, String.valueOf(l), "", "", "");
        return;
      }
      ReportController.b(this.app, "dc00899", "Pb_account_lifeservice", str, "0X800679E", "0X800679E", 0, 0, String.valueOf(l), "", "", "");
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramAbsListView != this.jdField_a_of_type_ComTencentWidgetSwipListView);
        if ((paramInt != 0) && (paramInt != 1)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter == null);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter.a(false);
      ThreadPriorityManager.a(false);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter == null);
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter.a(true);
    ThreadPriorityManager.a(true);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break label77;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131364485);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      new MqqHandler().postDelayed(new hpv(this), 5000L);
    }
    label77:
    while ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  public void b(View paramView)
  {
    d(true);
    this.c = null;
  }
  
  public void c(View paramView)
  {
    this.c = paramView;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903479);
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    a();
    b();
    c();
    d();
    paramBundle = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.app.a(), 0);
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Boolean = paramBundle.getBoolean("public_account_manage_notify", true);
      this.jdField_a_of_type_Long = paramBundle.getLong("public_account_manage_status_close_time", 0L);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountManageActivity", 2, "doOnCreate->mReceiveNotify:" + this.jdField_a_of_type_Boolean + ", mLastCloseTime:" + this.jdField_a_of_type_Long);
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.app.a(getClass());
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManageAdapter.b();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297083: 
      finish();
      return;
    case 2131297392: 
      f();
      return;
    }
    g();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PublicAccountManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.av.ui;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import gtu;
import gtv;
import gtw;
import gtx;
import guc;
import gud;
import gue;
import java.util.ArrayList;

public class GAudioMembersCtrlActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "GAudioMembersCtrlActivity";
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  private GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  public VideoAppInterface a;
  public GAudioMemberListCtrl a;
  private PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private TextView b;
  private TextView c;
  
  public GAudioMembersCtrlActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gtx(this);
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(paramLong, paramBoolean);
    }
  }
  
  private void d()
  {
    Object localObject = (RelativeLayout)super.findViewById(2131296895);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131297139));
    this.b = ((TextView)super.findViewById(2131297083));
    this.c = ((TextView)super.findViewById(2131297183));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)super.findViewById(2131299166));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299167));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    localObject = super.getLayoutInflater().inflate(2130903552, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.a((View)localObject);
    this.b.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("发言管理");
    this.c.setText("关闭");
    this.c.setOnClickListener(new gtu(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "showMenuMuteAll");
    }
    b();
    ActionSheet localActionSheet = ActionSheet.c(this);
    View localView = super.getLayoutInflater().inflate(2130903548, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131299164);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localActionSheet.a(localView);
    localView = super.getLayoutInflater().inflate(2130903057, null);
    TextView localTextView2 = (TextView)localView.findViewById(2131296886);
    localView.setId(0);
    localView.setBackgroundDrawable(super.getResources().getDrawable(2130837523));
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().R)
    {
      localTextView2.setText(super.getString(2131363642));
      localTextView2.setTextColor(super.getResources().getColor(2131427486));
      localTextView1.setText(super.getString(2131363644));
    }
    for (;;)
    {
      localActionSheet.a(localView);
      localActionSheet.d(super.getResources().getString(2131367976));
      localView.setOnClickListener(new gtv(this, localActionSheet));
      localActionSheet.setOnDismissListener(new gtw(this));
      localActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
      try
      {
        this.jdField_a_of_type_AndroidAppDialog.show();
        return;
      }
      catch (Exception localException) {}
      localTextView2.setText(super.getString(2131363641));
      localTextView2.setTextColor(super.getResources().getColor(2131427487));
      localTextView1.setText(super.getString(2131363643));
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshGAFList");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_ComTencentAvVideoController.b().clone());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("GAudioMembersCtrlActivity", 2, "refreshGAFList-->mVideoContrl is null");
  }
  
  public void a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localSessionInfo != null)
    {
      if (localSessionInfo.R) {
        this.jdField_a_of_type_AndroidWidgetButton.setText(super.getString(2131363642));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(super.getString(2131363641));
  }
  
  public void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "drawUI-->type=" + paramInt1 + " uin=" + paramLong + " fresh=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    do
    {
      return;
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        c();
      }
      if (paramInt2 == 42)
      {
        a(paramLong, true);
        return;
      }
    } while (paramInt2 != 43);
    a(paramLong, false);
  }
  
  public void a(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "refreshUI-->uin=" + paramLong + " type=" + paramInt1 + " isRefreshTitle=" + paramBoolean + " originalType=" + paramInt2);
    }
    if (paramLong == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GAudioMembersCtrlActivity", 2, "refreshUI-->uin == 0");
      }
      return;
    }
    super.runOnUiThread(new gud(this, paramInt1, paramLong, paramBoolean, paramInt2));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void c()
  {
    f();
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl != null) {
      this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate start");
    }
    super.setTheme(2131559171);
    super.doOnCreate(paramBundle);
    super.setContentView(2130903550);
    if (TextUtils.isEmpty(super.getIntent().getStringExtra("discussUin")))
    {
      finish();
      return false;
    }
    d();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentAvVideoController.a().e;
    f();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = new GAudioMemberListCtrl(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, this.jdField_a_of_type_ComTencentAvVideoController.a().e, this.jdField_a_of_type_ComTencentAvVideoController.a().F);
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gue(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("GAudioMembersCtrlActivity", 2, "GAudioMembersCtrlActivity doOnCreate end , cost time : " + (System.currentTimeMillis() - l) + "ms");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl.b();
    this.jdField_a_of_type_ComTencentAvUiGAudioMemberListCtrl = null;
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = null;
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.b = null;
      this.c = null;
      this.jdField_a_of_type_AndroidWidgetButton = null;
      if (QLog.isColorLevel()) {
        QLog.d("GAudioMembersCtrlActivity", 2, "doOnDestroy");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GAudioMembersCtrlActivity", 2, "", localException);
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_JavaLangRunnable == null)
    {
      this.jdField_a_of_type_JavaLangRunnable = new guc(this, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
    a();
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2130968584);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131299167) {
      e();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\GAudioMembersCtrlActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
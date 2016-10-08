package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import vlu;

public class TroopAioTips
  extends TroopAioAgent
{
  public static final int d = 200;
  public long a;
  protected GestureDetector a;
  TroopAioBlueTipsView jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView;
  TroopAioMsgNavigateBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar;
  TroopAioNewMessageBar jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar;
  public long b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public TroopAioTips()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar = new TroopAioNewMessageBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar = new TroopAioMsgNavigateBar();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView = new TroopAioBlueTipsView();
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    }
    return -1;
  }
  
  public TroopAioMsgNavigateBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramInt);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramBoolean;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector != null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    j();
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramViewGroup, paramBoolean);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, AIOTipsController paramAIOTipsController, String paramString1, String paramString2, String paramString3)
  {
    if (this.d) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a(paramContext, paramAIOTipsController, paramString1, paramString2, paramString3);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "exp_notice", 0, 0, paramString1, "", "", "");
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(List paramList)
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(paramList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.b();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext, AIOTipsController paramAIOTipsController, String paramString1, int paramInt, String paramString2, View.OnClickListener paramOnClickListener)
  {
    if (this.d) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a(paramContext, paramAIOTipsController, paramString1, paramInt, paramString2, paramOnClickListener);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new vlu(this));
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.d();
    }
  }
  
  public void b(List paramList)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.b(paramList);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.c();
    }
    return false;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.a();
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.a();
    }
    return false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.f();
    }
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.a();
    }
    return false;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.e();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioMsgNavigateBar.h();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.c = true;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioNewMessageBar.c = false;
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioBlueTipsView.d();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopAioTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
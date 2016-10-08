package com.tencent.mobileqq.hotchat;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Observable;

public abstract class BaseHotChatControl
{
  protected Activity a;
  public Context a;
  protected RelativeLayout a;
  public HotChatPie a;
  public QQAppInterface a;
  
  public BaseHotChatControl(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, HotChatPie paramHotChatPie, RelativeLayout paramRelativeLayout)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie = paramHotChatPie;
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\hotchat\BaseHotChatControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
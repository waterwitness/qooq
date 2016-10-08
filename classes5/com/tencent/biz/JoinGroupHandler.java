package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import hef;
import heg;

public class JoinGroupHandler
{
  protected int a;
  public long a;
  protected Context a;
  public JoinGroupHandler.IJoinGroupCB a;
  protected QQAppInterface a;
  protected TroopObserver a;
  protected QQProgressDialog a;
  protected QQToastNotifier a;
  protected String a;
  
  public JoinGroupHandler(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString, JoinGroupHandler.IJoinGroupCB paramIJoinGroupCB)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new heg(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB = paramIJoinGroupCB;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908), 0, paramInt2);
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      paramTroopInfo = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, paramTroopInfo.troopuin, paramTroopInfo.troopname, paramTroopInfo.cGroupOption, this.jdField_a_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramTroopInfo);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.b();
      return;
    }
    a(2131368626, 1);
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
  }
  
  private void b(long paramLong)
  {
    try
    {
      TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      this.jdField_a_of_type_Long = paramLong;
      localTroopHandler.a(paramLong, 8390784);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(2131367430, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131369268);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new hef(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
  }
  
  public void a(long paramLong)
  {
    if (!NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext))
    {
      a(2131367481, 0);
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    if (0L == paramLong)
    {
      this.jdField_a_of_type_ComTencentBizJoinGroupHandler$IJoinGroupCB.a();
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
    c();
    b(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    d();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\JoinGroupHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
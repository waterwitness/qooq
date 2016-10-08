package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import oeo;
import oep;

public class GamePartyTipsBar
  implements TipsBarTask
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public GamePartyTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, SessionInfo paramSessionInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903091, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramVarArgs.findViewById(2131297044));
    a();
    paramVarArgs.setOnClickListener(new oeo(this));
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "", "", "2000", "2015", "0", false);
    return paramVarArgs;
  }
  
  public void a()
  {
    Object localObject = (GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    if (((GamePartyManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = ((GamePartyManager)localObject).d;
      this.jdField_a_of_type_Int = ((GamePartyManager)localObject).m;
      this.b = ((GamePartyManager)localObject).n;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((GamePartyManager)localObject).e)) {
        break label173;
      }
      if (this.jdField_a_of_type_Int >= this.b) {
        break label157;
      }
      localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372526), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) });
    }
    Looper localLooper;
    for (;;)
    {
      localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      label157:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372527);
      continue;
      label173:
      if ((((GamePartyManager)localObject).p == 3) || (((GamePartyManager)localObject).p == 4)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372530);
      } else if (this.jdField_a_of_type_Int < this.b) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372528);
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131372529);
      }
    }
    new Handler(localLooper).post(new oep(this, (String)localObject));
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    while (!((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 14;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\GamePartyTipsBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
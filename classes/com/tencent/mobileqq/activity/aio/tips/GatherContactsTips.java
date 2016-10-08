package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;

public class GatherContactsTips
  implements GrayTipsTask
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = GatherContactsTips.class.getSimpleName();
  public static final int b = 2;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public GatherContactsTips(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_b_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.a().b(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == 64510) {
        paramQQAppInterface.a().a(paramString, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      }
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = ((FriendsManager)paramQQAppInterface.getManager(50)).c(paramSessionInfo.jdField_a_of_type_JavaLangString);
    return (paramQQAppInterface != null) && (paramQQAppInterface.gathtertype == 1);
  }
  
  private void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.a().b(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.msgtype == 64509) {
        paramQQAppInterface.a().a(paramString, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
      }
    }
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    int i = ((Integer)paramVarArgs[0]).intValue();
    paramVarArgs = null;
    if (i == 1)
    {
      paramVarArgs = MessageRecordFactory.a(64510);
      l = MessageCache.a();
      paramVarArgs.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", l, 64510, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
      paramVarArgs.isread = true;
    }
    while (i != 2) {
      return paramVarArgs;
    }
    paramVarArgs = MessageRecordFactory.a(64509);
    long l = MessageCache.a();
    paramVarArgs.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", l, 64509, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { Integer.valueOf(paramInt) }))
    {
      if (paramInt != 1) {
        break label60;
      }
      this.jdField_a_of_type_Boolean = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
    }
    label60:
    while (paramInt != 2) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt == 1000) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
      a(1);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1003;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    while ((paramInt != 2) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\tips\GatherContactsTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
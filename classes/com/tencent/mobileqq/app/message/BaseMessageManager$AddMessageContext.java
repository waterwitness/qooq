package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import java.util.HashMap;
import java.util.Map;

public class BaseMessageManager$AddMessageContext
{
  public FriendsManager a;
  public ConversationFacade a;
  public RecentUserProxy a;
  public TroopInfoManager a;
  public Map a;
  public Map b;
  public Map c;
  public Map d;
  public Map e;
  public Map f;
  
  public BaseMessageManager$AddMessageContext(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)paramQQAppInterface.getManager(36));
    this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy = paramQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageConversationFacade = paramQQAppInterface.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\message\BaseMessageManager$AddMessageContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
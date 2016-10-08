package com.tencent.biz.qqstory.app;

import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryBoss;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader;
import com.tencent.biz.qqstory.support.QLogAdapter;
import com.tencent.biz.qqstory.support.logging.QQStoryLoggingDelegate;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StoryAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorFlowCount;
import com.tribe.async.async.Bosses;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class QQStoryContext
  implements IHttpCommunicatorFlowCount
{
  protected static final String a = "Q.qqstory.QQStoryRuntime";
  protected static MobileQQ a;
  public static boolean a;
  public static boolean b = true;
  protected QQStoryCmdHandler a;
  protected ImageLoader a;
  protected EntityManagerFactory a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
  }
  
  public static QQStoryContext a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime instanceof StoryAppInterface)) {
      return ((StoryAppInterface)localAppRuntime).a();
    }
    return ((QQStoryManager)BaseApplicationImpl.a().a().getManager(180)).a;
  }
  
  public long a()
  {
    return ((BaseApplicationImpl)jdField_a_of_type_MqqAppMobileQQ).a().getLongAccountUin();
  }
  
  public QQStoryCmdHandler a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler;
  }
  
  public ImageLoader a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageLoader == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageLoader = new ImageLoader();
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageLoader;
  }
  
  public AppInterface a()
  {
    return (AppInterface)((BaseApplicationImpl)jdField_a_of_type_MqqAppMobileQQ).a();
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)((BaseApplicationImpl)jdField_a_of_type_MqqAppMobileQQ).a();
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null)
      {
        localObject1 = new QQStoryEntityManagerFactory((String)localObject1);
        ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public String a()
  {
    return ((BaseApplicationImpl)jdField_a_of_type_MqqAppMobileQQ).a().getAccount();
  }
  
  public String a(String paramString)
  {
    return ContactUtils.l(a(), paramString);
  }
  
  public MobileQQ a()
  {
    return jdField_a_of_type_MqqAppMobileQQ;
  }
  
  public void a()
  {
    if (jdField_a_of_type_MqqAppMobileQQ == null) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_MqqAppMobileQQ = BaseApplicationImpl.a();
      if (jdField_a_of_type_Boolean)
      {
        com.tribe.async.log.SLog.init(new QLogAdapter());
        Bosses.initWithBoss(jdField_a_of_type_MqqAppMobileQQ, new StoryBoss(jdField_a_of_type_MqqAppMobileQQ));
        com.tencent.biz.qqstory.support.logging.SLog.a(QQStoryLoggingDelegate.a());
      }
      com.tencent.biz.qqstory.support.logging.SLog.b("Q.qqstory.QQStoryRuntime", "on create");
      this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler = new QQStoryCmdHandler();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageLoader = new ImageLoader();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a().a(a(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public String b()
  {
    TicketManager localTicketManager = (TicketManager)a().a().getManager(2);
    String str = a();
    return String.format("uid_uin=%s;uid_a2=%s;uid_type=%d;", new Object[] { str, localTicketManager.getA2(str), Integer.valueOf(2) });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\app\QQStoryContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
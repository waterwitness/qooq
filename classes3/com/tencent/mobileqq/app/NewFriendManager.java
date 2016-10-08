package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.ActivateFriendsListener;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.FriendAnniver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.newfriend.ActivateFriendMessage;
import com.tencent.mobileqq.newfriend.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.FriendAnniverMessage;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.Manager;
import qbm;
import qbn;
import qbp;
import qbq;
import qbr;
import qbs;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendManager
  extends Observable
  implements Handler.Callback, Manager
{
  public static final int a = 2130838598;
  public static final String a = "新朋友";
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "NewFriendManager";
  private static final int c = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  FriendAnniverManager jdField_a_of_type_ComTencentMobileqqAppFriendAnniverManager;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  MayknowRecommendManager jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager;
  PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  public QQAppInterface a;
  private ActivateFriendsManager.ActivateFriendsListener jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager$ActivateFriendsListener;
  ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private PhoneContactManager.IPhoneContactListener jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  
  public NewFriendManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager$ActivateFriendsListener = new qbm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new qbn(this);
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new qbp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager = ((MayknowRecommendManager)paramQQAppInterface.getManager(158));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)paramQQAppInterface.getManager(84));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendAnniverManager = ((FriendAnniverManager)paramQQAppInterface.getManager(177));
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager$ActivateFriendsListener);
    paramQQAppInterface = ThreadManager.a("NewFriend", 0);
    paramQQAppInterface.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(paramQQAppInterface.getLooper(), this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  private void a(NewFriendMessage paramNewFriendMessage)
  {
    if (!a(paramNewFriendMessage)) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | isShouldCreateOrGetRecentUser = true");
      }
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.a(AppConstants.an, 4000);
      if ((localRecentUser.msg == null) || ((localRecentUser.msg instanceof String))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendManager", 2, "wrong ru.msg error | type is :" + localRecentUser.msg.getClass().toString());
    return;
    localRecentUser.msgType = 15;
    localRecentUser.displayName = "新朋友";
    if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof MayKnowMessage)))
    {
      localRecentUser.lastmsgdrafttime = paramNewFriendMessage.jdField_a_of_type_Long;
      localRecentUser.msg = paramNewFriendMessage.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | temp str = " + localRecentUser.msg);
      }
    }
    for (;;)
    {
      if (localRecentUser.msgData == null) {
        localRecentUser.msgData = String.valueOf(localRecentUser.msg).getBytes();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "refreshRecentData | ru.msg = " + localRecentUser.msg);
      }
      localRecentUserProxy.a(localRecentUser);
      return;
      if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof FriendSystemMessage)) && (!TextUtils.isEmpty(paramNewFriendMessage.jdField_a_of_type_JavaLangString)))
      {
        if (paramNewFriendMessage.jdField_a_of_type_Long > 0L) {
          localRecentUser.lastmsgtime = paramNewFriendMessage.jdField_a_of_type_Long;
        }
        localRecentUser.msg = paramNewFriendMessage.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | ru.lastmsgtime = " + localRecentUser.lastmsgtime);
        }
      }
      else if ((paramNewFriendMessage != null) && ((paramNewFriendMessage instanceof FriendAnniverMessage)))
      {
        localRecentUser.lastmsgtime = paramNewFriendMessage.jdField_a_of_type_Long;
        localRecentUser.msg = paramNewFriendMessage.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendManager", 2, "resetRecentUserUnreadCount | FriendAnniverMessage str = " + localRecentUser.msg);
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      if ((paramString.equals(AppConstants.an)) || (paramString.equals(AppConstants.aX)) || (paramString.equals(AppConstants.av)) || (paramString.equals(AppConstants.bd))) {
        return true;
      }
    } while (!paramString.equals(AppConstants.aJ));
    return ActivateFriendsManager.a(paramQQAppInterface);
  }
  
  private boolean a(NewFriendMessage paramNewFriendMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    do
    {
      return false;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    } while ((paramNewFriendMessage == null) || (localRecentUserProxy == null) || ((paramNewFriendMessage.a()) && (!localRecentUserProxy.a(AppConstants.an, 4000))));
    return true;
  }
  
  private void g()
  {
    int i = b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new qbr(this, i));
  }
  
  private void h()
  {
    Object localObject = null;
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      if (localNewFriendMessage.a()) {
        break label80;
      }
      localObject = localNewFriendMessage;
      i += 1;
    }
    label80:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        a((NewFriendMessage)localObject);
        setChanged();
        notifyObservers(localObject);
      }
      for (;;)
      {
        g();
        return;
        d();
      }
    }
  }
  
  public int a()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.av, 0);
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (!(localMessageRecord instanceof MessageForSystemMsg)) {
            break label133;
          }
          if (((MessageForSystemMsg)localMessageRecord).isread)
          {
            j = 0;
            label85:
            i = j + i;
          }
        }
      }
    }
    label133:
    for (;;)
    {
      break;
      j = 1;
      break label85;
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendManager", 2, "getUnreadSystemMessageCount " + i);
      }
      return i;
    }
  }
  
  public NewFriendMessage a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localNewFriendMessage != null) && (!localNewFriendMessage.a())) {
        return localNewFriendMessage;
      }
      i += 1;
    }
    return null;
  }
  
  public ArrayList a()
  {
    return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
  }
  
  public void a()
  {
    b();
    h();
  }
  
  public void a(NewFriendManager.INewFriendListener paramINewFriendListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramINewFriendListener)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramINewFriendListener);
      }
      return;
    }
  }
  
  public void a(FriendSystemMessage paramFriendSystemMessage)
  {
    Object localObject = null;
    int i = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      if (localNewFriendMessage.a()) {
        break label106;
      }
      localObject = localNewFriendMessage;
      i += 1;
    }
    label106:
    for (;;)
    {
      break;
      if (localObject != null)
      {
        if ((localObject instanceof FriendSystemMessage))
        {
          ((NewFriendMessage)localObject).jdField_a_of_type_Long = paramFriendSystemMessage.jdField_a_of_type_Long;
          ((NewFriendMessage)localObject).jdField_a_of_type_JavaLangString = paramFriendSystemMessage.jdField_a_of_type_JavaLangString;
        }
        a((NewFriendMessage)localObject);
        setChanged();
        notifyObservers(localObject);
      }
      for (;;)
      {
        g();
        return;
        d();
      }
    }
  }
  
  public boolean a()
  {
    NewFriendMessage localNewFriendMessage = a();
    return (localNewFriendMessage != null) && (localNewFriendMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.b(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(paramEntity);
      }
    }
    QLog.d("NewFriendManager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public void addObserver(Observer paramObserver)
  {
    super.addObserver(paramObserver);
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = true;
    int i = 0;
    if (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      boolean bool2 = bool1;
      if (!(localNewFriendMessage instanceof ActivateFriendMessage))
      {
        bool2 = bool1;
        if (!(localNewFriendMessage instanceof FriendAnniverMessage))
        {
          bool2 = bool1;
          if (!localNewFriendMessage.a()) {
            bool2 = false;
          }
        }
      }
      if (localNewFriendMessage.a()) {}
      for (int j = 0;; j = 1)
      {
        i = j + i;
        bool1 = bool2;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onlyLowPriority " + bool1 + " total unread = " + i);
    }
    if (bool1) {
      return 0;
    }
    return i;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.b();
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("loadNewFriendMsg");
    }
    Object localObject1 = new HashSet();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.av, 0);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          localArrayList.add(new FriendSystemMessage((MessageForSystemMsg)localMessageRecord));
          ((MessageForSystemMsg)localMessageRecord).parse();
          if (((MessageForSystemMsg)localMessageRecord).structMsg.msg.sub_type.get() == 13) {
            ((HashSet)localObject1).add(String.valueOf(((MessageForSystemMsg)localMessageRecord).structMsg.req_uin.get()));
          }
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" sys").append(localMessageRecord.isread);
          }
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)((ArrayList)localObject2).clone()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PushRecommend)((Iterator)localObject2).next();
        if (!((HashSet)localObject1).contains(((PushRecommend)localObject3).uin))
        {
          localArrayList.add(new MayKnowMessage((PushRecommend)localObject3));
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" Push").append(((PushRecommend)localObject3).uin).append(((PushRecommend)localObject3).isReaded);
          }
        }
      }
    }
    localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().clone();
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof ContactMatch))
        {
          localArrayList.add(new ContactMatchMessage((ContactMatch)localObject2));
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" cm").append(((ContactMatch)localObject2).mobileNo).append(((ContactMatch)localObject2).isReaded);
          }
        }
        else if ((localObject2 instanceof ContactBinded))
        {
          localArrayList.add(new ContactBindedMessage((ContactBinded)localObject2));
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" cb").append(((ContactBinded)localObject2).isReaded);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aJ, 9002).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 2)
        {
          localObject2 = new ActivateFriendMessage((MessageForActivateFriends)localObject2);
          if (QLog.isColorLevel()) {
            localStringBuilder.append(" afm").append(((ActivateFriendMessage)localObject2).a()).append(((ActivateFriendMessage)localObject2).a());
          }
          if (((ActivateFriendMessage)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localArrayList.add(localObject2);
            if (QLog.isColorLevel()) {
              localStringBuilder.append(" needAvatar");
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendAnniverManager.a())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendAnniverManager.a();
      localArrayList.add(new FriendAnniverMessage((FriendAnniver)localObject1));
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" fAnniver").append(((FriendAnniver)localObject1).uin).append(((FriendAnniver)localObject1).isReed);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, localStringBuilder.toString());
    }
    Collections.sort(localArrayList, new qbq(this));
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public void b(NewFriendManager.INewFriendListener paramINewFriendListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramINewFriendListener);
      return;
    }
  }
  
  public int c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      if (localNewFriendMessage.a()) {
        break label72;
      }
      if ((localNewFriendMessage instanceof ActivateFriendMessage))
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.aJ)) {
          break label72;
        }
        i += 1;
      }
    }
    label72:
    for (;;)
    {
      break;
      i += 1;
      continue;
      return i;
    }
  }
  
  public void c()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      g();
      return;
    }
    ThreadManager.a(new qbs(this), null, false);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    RecentUserProxy localRecentUserProxy;
    RecentUser localRecentUser;
    do
    {
      return;
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localRecentUser = localRecentUserProxy.b(AppConstants.an, 4000);
    } while (localRecentUser == null);
    localRecentUserProxy.b(localRecentUser);
  }
  
  public void deleteObserver(Observer paramObserver)
  {
    try
    {
      super.deleteObserver(paramObserver);
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, true, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "HandleMessage what=" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return true;
    case 1: 
      b();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.av, 0, true, true);
    this.jdField_a_of_type_ComTencentMobileqqAppMayknowRecommendManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendAnniverManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.aJ, 9002);
    }
    a();
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager$ActivateFriendsListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\NewFriendManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
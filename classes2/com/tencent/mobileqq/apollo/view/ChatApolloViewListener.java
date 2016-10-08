package com.tencent.mobileqq.apollo.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import ptn;
import pto;

public class ChatApolloViewListener
  extends VasExtensionObserver
  implements OnApolloViewListener
{
  private static final String a = "ChatApolloViewListener";
  public WeakReference a;
  
  public ChatApolloViewListener(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
  }
  
  public void a(int paramInt)
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onNotifyStatusChanged], clickPart:" + paramInt);
    }
    if (this.a == null) {}
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = (BaseChatPie)this.a.get();
            } while ((localObject1 == null) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
            localObject2 = ((BaseChatPie)localObject1).a();
          } while (localObject2 == null);
          localObject2 = (XPanelContainer)((ViewGroup)localObject2).findViewById(2131296895);
          if (localObject2 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ChatApolloViewListener", 2, "errInfo->root is NULL.");
        return;
        int j = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a.get();
        if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a.get() == 8) {
          paramInt = 8;
        }
        switch (paramInt)
        {
        case 2: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        default: 
          return;
        case 1: 
          paramInt = ((BaseChatPie)localObject1).f();
          if (QLog.isColorLevel()) {
            QLog.d("ChatApolloViewListener", 2, "panelType:" + paramInt);
          }
          if (paramInt != 21)
          {
            ((XPanelContainer)localObject2).a(21);
            localObject2 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramInt = ApolloUtil.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
              break;
            }
          }
        case 3: 
          for (localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = ApolloActionManager.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "panel_open_clk", paramInt, 0, new String[] { localObject1 });
            return;
            if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a.get() == 3)
            {
              paramInt = 1;
              break;
            }
            paramInt = i;
            if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().a.get() == 1) {
              break;
            }
            paramInt = j;
            break;
            ((BaseChatPie)localObject1).ao();
            localObject2 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            paramInt = ApolloUtil.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
            for (localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = ApolloActionManager.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
            {
              VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "panel_open_clk", paramInt, 0, new String[] { localObject1 });
              return;
            }
          }
          ((BaseChatPie)localObject1).ah();
          localObject2 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          paramInt = ApolloUtil.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {}
          for (localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = ApolloActionManager.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
          {
            VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "panel_close_clk", paramInt, 0, new String[] { localObject1 });
            return;
          }
        case 8: 
          paramInt = ((BaseChatPie)localObject1).f();
          if (QLog.isColorLevel()) {
            QLog.d("ChatApolloViewListener", 2, "panelType:" + paramInt);
          }
          break;
        }
      } while (paramInt == 21);
      ((XPanelContainer)localObject2).a(21);
      return;
    } while ((ApolloActionManager.a().e == 0) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null));
    ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a(((BaseChatPie)localObject1).f());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    if (this.a == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.a.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    ThreadManager.a(new ptn(this, localBaseChatPie), 5, null, false);
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "TROOP, [onChangeUserApolloStatus], result:" + paramBoolean + ",data:" + paramObject);
    }
    if ((!paramBoolean) || (paramObject == null)) {}
    label48:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        break label48;
        do
        {
          return;
        } while (this.a == null);
        localBaseChatPie = (BaseChatPie)this.a.get();
      } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
        localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(paramBoolean, paramObject);
      }
      paramObject = (Pair)paramObject;
      if (((String)((Pair)paramObject).first).equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatApolloViewListener", 2, "my status changed, status:" + ((Pair)paramObject).second);
        }
        if ((2 == ((Integer)((Pair)paramObject).second).intValue()) || (((Integer)((Pair)paramObject).second).intValue() == 0))
        {
          ApolloActionManager.a().a(true, true, localBaseChatPie.f());
          if (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
            ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(8);
          }
        }
        for (;;)
        {
          if ((localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
            localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f());
          }
          localBaseChatPie.a(65536);
          if (ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences == null) {
            break;
          }
          ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("is_apollo_hide" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
          return;
          if (1 == ((Integer)((Pair)paramObject).second).intValue()) {
            if (ApolloActionManager.a().b())
            {
              if (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
                ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setVisibility(0);
              }
              ApolloActionManager.a().a(false, true, localBaseChatPie.f());
            }
            else if (!ApolloActionManager.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
            {
              paramObject = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ChatActivity.class);
              if (paramObject != null) {
                ((MqqHandler)paramObject).post(new pto(this, localBaseChatPie));
              }
            }
          }
        }
      }
      if (((localBaseChatPie instanceof FriendChatPie)) && (((String)((Pair)paramObject).first).equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatApolloViewListener", 2, "friend status changed, status:" + ((Pair)paramObject).second);
        }
        if (2 == ((Integer)((Pair)paramObject).second).intValue()) {
          QQToast.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "好友已关闭厘米秀功能", 0).a();
        }
        ApolloActionManager.a().b();
        return;
      }
    } while ((!(localBaseChatPie instanceof TroopChatPie)) && (!(localBaseChatPie instanceof DiscussChatPie)));
    ApolloActionManager.a().b();
  }
  
  protected void f(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    if (this.a == null) {
      return;
    }
    label48:
    label487:
    label492:
    for (;;)
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
      if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
      {
        ApolloActionManager localApolloActionManager = ApolloActionManager.a();
        if ((paramBoolean) && (paramObject != null))
        {
          Object localObject = (ArrayList)paramObject;
          paramObject = "";
          String str;
          if ((localBaseChatPie instanceof FriendChatPie))
          {
            paramObject = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            str = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          }
          for (;;)
          {
            if ((TextUtils.isEmpty((CharSequence)paramObject)) || (TextUtils.isEmpty(str))) {
              break label492;
            }
            Iterator localIterator = ((ArrayList)localObject).iterator();
            if (!localIterator.hasNext()) {
              break label48;
            }
            localObject = (String)localIterator.next();
            if ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals(paramObject)) && (!((String)localObject).equals(str)))) {
              break;
            }
            if ((!localApolloActionManager.b()) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {
              break label48;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ChatApolloViewListener", 2, "current dress changes.");
            }
            int i = -2;
            paramObject = ApolloActionHelper.a((String)localObject, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            int j = i;
            if (paramObject != null)
            {
              j = i;
              if (paramObject.length == 2) {
                j = ((Integer)paramObject[0]).intValue();
              }
            }
            if ((localApolloActionManager.jdField_a_of_type_ArrayOfInt != null) && (localApolloActionManager.jdField_a_of_type_ArrayOfInt.length == 2)) {
              if (((String)localObject).equals(str)) {
                i = localApolloActionManager.jdField_a_of_type_ArrayOfInt[0];
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatApolloViewListener", 2, "newRoleId:" + j + ",curUinRoleId:" + i);
              }
              if ((j == i) || (j <= 1000))
              {
                localApolloActionManager.b();
                return;
                if ((!(localBaseChatPie instanceof TroopChatPie)) && (!(localBaseChatPie instanceof DiscussChatPie))) {
                  break label487;
                }
                paramObject = localApolloActionManager.c;
                str = localApolloActionManager.b;
                break;
                i = localApolloActionManager.jdField_a_of_type_ArrayOfInt[1];
                continue;
              }
              if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() == 1)
              {
                localApolloActionManager.a(1, true);
                return;
              }
              if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() == 3)
              {
                localApolloActionManager.a(3, false);
                return;
              }
              localApolloActionManager.jdField_a_of_type_JavaUtilVector.add(localObject);
              return;
              i = -1;
            }
            str = "";
          }
        }
      }
    }
  }
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if (this.a == null)
    {
      com.tencent.mobileqq.apollo.ApolloManager.b = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.a.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b(paramBoolean, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ChatApolloViewListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
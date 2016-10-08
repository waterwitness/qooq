package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.List;
import ncs;

public class ChatAdapter1
  extends XBaseAdapter
{
  @Deprecated
  public static long a;
  @Deprecated
  public static String a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public ItemBuilderFactory a;
  public QQAppInterface a;
  public Boolean a;
  CharSequence jdField_a_of_type_JavaLangCharSequence = null;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  ncs jdField_a_of_type_Ncs = new ncs(this, null);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Long = -1L;
  }
  
  public ChatAdapter1(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory = new ItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a(long paramLong)
  {
    int j = getCount();
    int i = 0;
    while (i < j)
    {
      if (getItemId(i) == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public ncs a()
  {
    return this.jdField_a_of_type_Ncs;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a();
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
    if (i >= 0)
    {
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
        if ((localMessageForArkApp != null) && (localMessageForArkApp.arkContainer != null)) {
          localMessageForArkApp.arkContainer.b(2);
        }
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramChatMessage);
      b(i, i);
    }
  }
  
  public void a(List paramList)
  {
    ChatMessage localChatMessage;
    int i;
    int j;
    if (paramList.size() > 0)
    {
      localChatMessage = (ChatMessage)paramList.get(paramList.size() - 1);
      i = 1;
      for (;;)
      {
        if ((localChatMessage instanceof MessageForGrayTips))
        {
          i += 1;
          if (paramList.size() - i >= 0)
          {
            localChatMessage = (ChatMessage)paramList.get(paramList.size() - i);
          }
          else
          {
            j = 0;
            if ((localChatMessage instanceof MessageForMarketFace)) {
              break;
            }
          }
        }
      }
    }
    label87:
    label185:
    label394:
    label400:
    label419:
    for (;;)
    {
      return;
      int k = i + 1;
      Object localObject1;
      Object localObject2;
      if (paramList.size() - k >= 0)
      {
        for (localObject1 = (ChatMessage)paramList.get(paramList.size() - k);; localObject1 = (ChatMessage)paramList.get(paramList.size() - k))
        {
          localObject2 = localObject1;
          i = j;
          if (!(localObject1 instanceof MessageForGrayTips)) {
            break label185;
          }
          k += 1;
          if (paramList.size() - k < 0) {
            break;
          }
        }
        i = 0;
        localObject2 = localObject1;
        if (!(localObject2 instanceof MessageForMarketFace)) {
          break label394;
        }
        paramList = (List)localObject2;
      }
      for (;;)
      {
        if ((i == 0) || (localChatMessage == null) || (paramList == null)) {
          break label419;
        }
        localChatMessage.isMarketFaceFlow = false;
        paramList.isMarketFaceFlow = false;
        if ((localChatMessage.istroop != 1) && (localChatMessage.istroop != 3000)) {
          break label87;
        }
        localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        localObject2 = ((MessageForMarketFace)paramList).mMarkFaceMessage;
        if (localObject1 == null)
        {
          localChatMessage.parse();
          localObject1 = ((MessageForMarketFace)localChatMessage).mMarkFaceMessage;
        }
        for (;;)
        {
          if (localObject2 == null) {
            paramList.parse();
          }
          for (paramList = ((MessageForMarketFace)paramList).mMarkFaceMessage;; paramList = (List)localObject2)
          {
            if ((localObject1 == null) || (paramList == null) || (((MarkFaceMessage)localObject1).dwTabID != paramList.dwTabID) || (!EmosmUtils.a(((MarkFaceMessage)localObject1).sbufID, ((MarkFaceMessage)localObject1).mediaType).equals(EmosmUtils.a(paramList.sbufID, paramList.mediaType)))) {
              break label400;
            }
            localChatMessage.isMarketFaceFlow = true;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_show_follow", 0, 0, "", ((MarkFaceMessage)localObject1).dwTabID + "", "", "");
            return;
            localObject2 = null;
            i = 0;
            break label185;
            break;
          }
          break;
        }
        j = 1;
        break;
        paramList = null;
        localChatMessage = null;
        i = 1;
      }
    }
  }
  
  public void a(List paramList, CharSequence paramCharSequence)
  {
    int i = 0;
    Object localObject = null;
    ChatMessage localChatMessage;
    if (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if (((localObject == null) || (localChatMessage.time - ((ChatMessage)localObject).time > 180L)) && (MessageUtils.b(localChatMessage.msgtype))) {}
      for (localChatMessage.mNeedTimeStamp = true;; localChatMessage.mNeedTimeStamp = false)
      {
        if (i != paramList.size() - 1) {
          localChatMessage.isMarketFaceFlow = false;
        }
        i += 1;
        localObject = localChatMessage;
        break;
      }
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (paramCharSequence != null)
    {
      localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(0);
      localChatMessage.mNeedGrayTips = true;
      localChatMessage.mMessageSource = paramCharSequence;
    }
    if ((localObject != null) && (!((ChatMessage)localObject).isMarketFaceFlow)) {
      a(paramList);
    }
    super.notifyDataSetChanged();
  }
  
  public int b(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label58;
      }
      j = i;
      if (((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i)).uniseq == paramLong) {
        break;
      }
      i += 1;
    }
    label58:
    return -1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ncs.a != null) {
      this.jdField_a_of_type_Ncs.a.b();
    }
  }
  
  public int c(long paramLong)
  {
    int j;
    if (paramLong < 0L)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label73;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage.shmsgseq == paramLong)
      {
        j = i;
        if (!MsgProxyUtils.a(localChatMessage)) {
          break;
        }
      }
      i += 1;
    }
    label73:
    return -1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      l1 = l2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        l1 = ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
      }
    }
    return l1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      paramInt = this.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localChatMessage != null) {
        localChatMessage.parse();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage) == 61) {
        return -1;
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return paramView;
    }
    ChatMessage localChatMessage1 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    StartupTracker.a(null, "AIO_ChatAdapter_getView" + " | " + localChatMessage1.getClass().getName());
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(localChatMessage1, this);
    if (paramInt != 0)
    {
      ChatMessage localChatMessage2 = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      if ((localChatMessage2 != null) && ((localChatMessage2 instanceof MessageForTroopUnreadTips))) {
        localChatMessage1.mNeedTimeStamp = true;
      }
    }
    paramView = localChatItemBuilder.a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage1, paramView, paramViewGroup, this.jdField_a_of_type_Ncs);
    if (paramView != null) {
      paramView.setTag(2131296315, localChatMessage1);
    }
    StartupTracker.a("AIO_ChatAdapter_getView" + " | " + localChatMessage1.getClass().getName(), null);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 67;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\ChatAdapter1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
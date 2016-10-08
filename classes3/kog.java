import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class kog
  extends FriendListObserver
{
  public kog(BaseChatPie paramBaseChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a() {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while (((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
    String str = null;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
      str = ContactUtils.k(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = str;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onUpdateFriendInfo title" + Utils.a(str));
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (!AppSetting.j) {
        break;
      }
      paramString = this.a.b.getText().toString();
      this.a.b.setContentDescription(paramString);
      this.a.a().setTitle(this.a.b.getText());
      return;
      if (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        str = ContactUtils.l(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      UinFraudInfo.a().a(paramLong);
      return;
    }
    UinFraudInfo.a().a(paramLong, paramInt2);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new koh(this, paramLong));
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      this.a.v();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      this.a.a(1);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramString == null)) {
      return;
    }
    int i = 0;
    label18:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    ChatMessage localChatMessage;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        localChatMessage = AIOUtils.a((View)localObject);
        if ((localViewHolder != null) && (localChatMessage.senderuin != null) && (paramString.equals(localChatMessage.senderuin)))
        {
          if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
            break label192;
          }
          localObject = localChatMessage.frienduin;
          label136:
          if ((localChatMessage.istroop != 1010) && (localChatMessage.istroop != 1001)) {
            break label201;
          }
        }
      }
    }
    label192:
    label201:
    for (Object localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, (String)localObject, true);; localObject = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject))
    {
      localViewHolder.a.setHeaderIcon((Drawable)localObject);
      i += 1;
      break label18;
      break;
      localObject = localChatMessage.senderuin;
      break label136;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {}
    switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      } while (!AppSetting.j);
      paramString1 = this.a.b.getText().toString();
      this.a.b.setContentDescription(paramString1);
      this.a.a().setTitle(this.a.b.getText());
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = ContactUtils.l(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d != null) {}
      for (paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;; paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.d = paramString1;
        break;
      }
    case 1: 
      this.a.a(false, false);
      return;
    }
    this.a.a(false, false);
  }
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    if (!paramHashMap.containsKey(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int i = 0;
    label21:
    BaseBubbleBuilder.ViewHolder localViewHolder;
    if (i < this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
    {
      paramHashMap = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramHashMap != null) && ((paramHashMap instanceof BaseChatItemLayout)))
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramHashMap);
        paramHashMap = AIOUtils.a(paramHashMap);
        if ((localViewHolder != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000)) {
          if ((paramHashMap.istroop != 1010) && (paramHashMap.istroop != 1001)) {
            break label162;
          }
        }
      }
    }
    label162:
    for (paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramHashMap.senderuin, true);; paramHashMap = FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin))
    {
      localViewHolder.a.setHeaderIcon(paramHashMap);
      i += 1;
      break label21;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if ((!paramBoolean) && (this.a.o())) {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2130838442, this.a.jdField_a_of_type_AndroidContentContext.getString(2131368707), 0).b(this.a.a());
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    Set localSet = (Set)paramObject;
    int k = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i = 0;
    label46:
    Object localObject;
    ChatMessage localChatMessage;
    label106:
    int j;
    if (i < k)
    {
      paramObject = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i);
      if ((paramObject != null) && ((paramObject instanceof BaseChatItemLayout)))
      {
        localObject = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)paramObject);
        localChatMessage = AIOUtils.a((View)paramObject);
        if (!localChatMessage.isSend()) {
          break label244;
        }
        paramObject = localChatMessage.selfuin;
        FriendsManager localFriendsManager = (FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((localObject != null) && (((BaseBubbleBuilder.ViewHolder)localObject).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          paramObject = localFriendsManager.a((String)paramObject);
          if (paramObject != null)
          {
            paramObject = Long.valueOf(((ExtensionInfo)paramObject).pendantId);
            if (paramObject != null)
            {
              if (((Long)paramObject).longValue() == 0L) {
                break label301;
              }
              paramObject = ((AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a(((Long)paramObject).longValue());
              localObject = ((BaseBubbleBuilder.ViewHolder)localObject).a;
              if (i == k) {
                break label295;
              }
              j = 1;
              label222:
              ((PendantInfo)paramObject).a((View)localObject, j, localChatMessage.uniseq);
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      label244:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label106;
      }
      paramObject = localChatMessage.senderuin;
      break label106;
      label295:
      j = 2;
      break label222;
      label301:
      if (((BaseBubbleBuilder.ViewHolder)localObject).a.a != null)
      {
        ((BaseBubbleBuilder.ViewHolder)localObject).a.a.setImageDrawable(null);
        ((BaseBubbleBuilder.ViewHolder)localObject).a.a.setVisibility(8);
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!Utils.a(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      switch (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramString2;
      this.a.b.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if (AppSetting.j)
      {
        paramString1 = this.a.b.getText().toString();
        this.a.b.setContentDescription(paramString1);
        this.a.a().setTitle(this.a.b.getText());
      }
    } while (!QLog.isDevelopLevel());
    DatingUtil.a("Q.aio.BaseChatPie", new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  protected void b(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.v();
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    HashMap localHashMap;
    int i;
    if ((this.a.c == null) || (!this.a.c.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.a(BaseApplication.getContext()).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label298;
        }
        i = 1;
        break;
        this.a.c.dismiss();
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          MultiMsgManager.a().b.putAll((Map)paramObject);
        }
        if (MultiMsgManager.a().b.size() == 0) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131367671, 0).b(this.a.a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          this.a.a((Map)paramObject, MultiMsgManager.a().a);
        }
      }
      label298:
      i = 0;
    }
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (this.a.m != 0)) {}
    while ((RichStatItemBuilder.a == 0L) || (!(paramObject instanceof RichStatus.SigZanInfo))) {
      return;
    }
    ThreadManager.a(new koi(this, (RichStatus.SigZanInfo)paramObject), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
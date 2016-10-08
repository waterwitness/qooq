import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BaseTroopChatPie.BaseTroopMsgObserver;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class odu
  extends BaseTroopChatPie.BaseTroopMsgObserver
{
  public odu(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367301));
      this.a.b.sendMessage(paramString);
    }
    for (;;)
    {
      this.a.x();
      return;
      paramString = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367300));
      this.a.b.sendMessage(paramString);
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.TroopChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 1) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367301));
      this.a.b.sendMessage(paramString1);
      continue;
      paramString1 = this.a.b.obtainMessage(5, 1, 0, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131367300));
      this.a.b.sendMessage(paramString1);
      continue;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131364932);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      continue;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131364933);
      }
      paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString1);
      this.a.b.sendMessage(paramString1);
      continue;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = this.a.b.obtainMessage(5, 1, 0, paramString2);
        this.a.b.sendMessage(paramString1);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, "onGetSystemMsgFin.success");
      }
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.aw, 0);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() - 1 >= 0) {
          localObject1 = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((localObject1 != null) && ((localObject1 instanceof MessageForSystemMsg))) {
        break label95;
      }
    }
    label95:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          localObject1 = ((MessageForSystemMsg)localObject1).getSystemMsg();
        } while ((((structmsg.StructMsg)localObject1).msg_type.get() != 2) || (((structmsg.StructMsg)localObject1).msg.get() == null));
        i = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = ((structmsg.StructMsg)localObject1).msg.group_code.get();
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase("" + l)));
    this.a.aQ();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.a.J();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\odu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
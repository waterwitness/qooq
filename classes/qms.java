import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class qms
  implements ProtoReqManager.IProtoRespBack
{
  public qms(SystemMessageProcessor paramSystemMessageProcessor)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoResp.a.getResultCode() != 1000)
    {
      this.a.a(4006, false, null);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramProtoReq = this.a.a.getAccount();
        localObject = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject).mergeFrom((byte[])paramProtoResp.a.getWupBuffer());
        new StringBuilder();
        if ((localObject == null) || (((structmsg.RspNextSystemMsg)localObject).head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        paramProtoResp = new ArrayList();
        localList = ((structmsg.RspNextSystemMsg)localObject).msgs.get();
        j = localList.size();
        if (!QLog.isColorLevel()) {
          break label551;
        }
        QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg Resp : decode pb size = " + j);
      }
      catch (Exception paramProtoResp)
      {
        Object localObject;
        List localList;
        int j;
        MessageRecord localMessageRecord;
        MessageForSystemMsg localMessageForSystemMsg;
        long l2;
        long l1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramProtoResp);
        this.a.a(4006, false, null);
        return;
      }
      if (i < j)
      {
        localMessageRecord = MessageRecordFactory.a(63518);
        localMessageRecord.msgtype = 63518;
        localMessageRecord.selfuin = paramProtoReq;
        localMessageRecord.frienduin = AppConstants.av;
        localMessageRecord.senderuin = (((structmsg.StructMsg)localList.get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        localMessageRecord.isread = true;
        localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)localList.get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        paramProtoResp.add(localMessageForSystemMsg);
        i += 1;
      }
      else
      {
        if (paramProtoResp.size() > 0)
        {
          if (paramProtoResp.size() < 20) {
            FriendSystemMsgController.a().a(true, this.a.a);
          }
          l2 = ((structmsg.RspNextSystemMsg)localObject).following_friend_seq.get();
          l1 = l2;
          if (l2 <= 0L) {
            l1 = this.a.a.a().d("following_friend_seq_47");
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.systemmsg.", 2, "<---sendGetNextFriendSystemMsg : decode pb following_friend_seq" + l1);
          }
          this.a.a.a().d("following_friend_seq_47", l1);
          localObject = this.a.a.a();
          paramProtoReq = String.valueOf(paramProtoReq);
          if ((MessageHandlerUtils.a(paramProtoResp)) && (this.a.a.isBackground_Stop))
          {
            bool = true;
            ((QQMessageFacade)localObject).a(paramProtoResp, paramProtoReq, bool);
            this.a.a("handleGetSystemMsgResp", true, paramProtoResp.size(), false, false);
            this.a.a(4005, true, null);
            return;
          }
          boolean bool = false;
          continue;
        }
        FriendSystemMsgController.a().a(true, this.a.a);
        continue;
        label551:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
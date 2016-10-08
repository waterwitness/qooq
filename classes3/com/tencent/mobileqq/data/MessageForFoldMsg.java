package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg.FoldMsg;

public class MessageForFoldMsg
  extends MessageForText
{
  public boolean foldFlag;
  public boolean foldFlagTemp;
  public String redBagId;
  
  public MessageForFoldMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    doParse(false);
  }
  
  public void init(boolean paramBoolean1, String paramString, long paramLong, boolean paramBoolean2)
  {
    this.redBagId = paramString;
    this.mPasswdRedBagSender = paramLong;
    this.foldFlag = paramBoolean1;
    if (paramBoolean2) {
      if (!this.foldFlag) {
        break label43;
      }
    }
    label43:
    for (this.msgtype = 63530;; this.msgtype = 64536)
    {
      saveExtInfoToExtStr("redbag_fold_msg", "true");
      return;
    }
  }
  
  public boolean isSupportFTS()
  {
    if (!this.foldFlag) {
      return super.isSupportFTS();
    }
    return false;
  }
  
  protected void postRead()
  {
    boolean bool = true;
    RichMsg.FoldMsg localFoldMsg = new RichMsg.FoldMsg();
    for (;;)
    {
      try
      {
        localFoldMsg.mergeFrom(this.msgData);
        if (localFoldMsg.fold_flags.get() == 1)
        {
          this.foldFlag = bool;
          this.redBagId = localFoldMsg.redbag_id.get().toStringUtf8();
          this.msg = localFoldMsg.msg_content.get().toStringUtf8();
          this.mPasswdRedBagSender = localFoldMsg.redbag_sender_uin.get();
          init(this.foldFlag, this.redBagId, this.mPasswdRedBagSender, false);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("msgFold", 2, "MessageForFoldMsg postRead error， " + localException.getMessage());
      }
      bool = false;
    }
  }
  
  protected void prewrite()
  {
    RichMsg.FoldMsg localFoldMsg = new RichMsg.FoldMsg();
    PBUInt32Field localPBUInt32Field = localFoldMsg.fold_flags;
    if (this.foldFlag) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localFoldMsg.redbag_sender_uin.set(this.mPasswdRedBagSender);
      localFoldMsg.redbag_id.set(ByteStringMicro.copyFromUtf8(this.redBagId));
      localFoldMsg.msg_content.set(ByteStringMicro.copyFromUtf8(this.msg));
      this.msgData = localFoldMsg.toByteArray();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForFoldMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
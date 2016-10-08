package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
{
  public String authkey;
  private int channelId;
  public int conftype;
  public QQWalletTransferMsgElem elem;
  public String envelopeName;
  public int envelopeid;
  public boolean isOpened;
  public int msgFrom;
  public String redPacketId;
  public int redtype;
  private int resend;
  public int templateId;
  
  public QQWalletRedPacketMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQWalletRedPacketMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
    this.channelId = paramQQWalletAioBody.sint32_channelid.get();
    this.templateId = paramQQWalletAioBody.sint32_templateid.get();
    this.resend = paramQQWalletAioBody.uint32_resend.get();
    this.redtype = paramQQWalletAioBody.sint32_redtype.get();
    this.redPacketId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
    this.authkey = paramQQWalletAioBody.bytes_authkey.get().toStringUtf8();
    this.envelopeid = paramQQWalletAioBody.sint32_envelopeid.get();
    this.envelopeName = paramQQWalletAioBody.bytes_name.get().toStringUtf8();
    this.conftype = paramQQWalletAioBody.sint32_redtype.get();
    this.msgFrom = paramQQWalletAioBody.sint32_msg_from.get();
  }
  
  private void readVersionUpgradeFiled(ObjectInput paramObjectInput)
  {
    try
    {
      this.elem.iconUrl = paramObjectInput.readUTF();
      this.elem.contentColor = paramObjectInput.readInt();
      this.elem.contentBgColor = paramObjectInput.readInt();
      this.elem.aioImageLeft = paramObjectInput.readUTF();
      this.elem.aioImageRight = paramObjectInput.readUTF();
      this.elem.cftImage = paramObjectInput.readUTF();
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          this.envelopeid = paramObjectInput.readInt();
          this.envelopeName = paramObjectInput.readUTF();
          this.conftype = paramObjectInput.readInt();
          try
          {
            this.msgFrom = paramObjectInput.readInt();
            return;
          }
          catch (IOException paramObjectInput)
          {
            this.msgFrom = -1;
          }
          localIOException1 = localIOException1;
          this.elem.iconUrl = "";
          this.elem.contentColor = 13487565;
          this.elem.contentBgColor = -1;
          this.elem.aioImageLeft = "";
          this.elem.aioImageRight = "";
          this.elem.cftImage = "";
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          this.envelopeid = -1;
          this.envelopeName = "";
          this.conftype = -1;
        }
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.elem = new QQWalletTransferMsgElem();
    this.elem.background = paramObjectInput.readInt();
    this.elem.icon = paramObjectInput.readInt();
    this.elem.title = paramObjectInput.readUTF();
    this.elem.subTitle = paramObjectInput.readUTF();
    this.elem.content = paramObjectInput.readUTF();
    this.elem.linkUrl = paramObjectInput.readUTF();
    this.elem.blackStripe = paramObjectInput.readUTF();
    this.elem.notice = paramObjectInput.readUTF();
    this.channelId = paramObjectInput.readInt();
    this.templateId = paramObjectInput.readInt();
    this.resend = paramObjectInput.readInt();
    this.redtype = paramObjectInput.readInt();
    this.redPacketId = paramObjectInput.readUTF();
    this.authkey = paramObjectInput.readUTF();
    this.isOpened = paramObjectInput.readBoolean();
    this.elem.titleColor = paramObjectInput.readInt();
    this.elem.subtitleColor = paramObjectInput.readInt();
    this.elem.actionsPriority = paramObjectInput.readUTF();
    this.elem.jumpUrl = paramObjectInput.readUTF();
    this.elem.nativeAndroid = paramObjectInput.readUTF();
    readVersionUpgradeFiled(paramObjectInput);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.elem.background);
    paramObjectOutput.writeInt(this.elem.icon);
    paramObjectOutput.writeUTF(this.elem.title);
    paramObjectOutput.writeUTF(this.elem.subTitle);
    paramObjectOutput.writeUTF(this.elem.content);
    paramObjectOutput.writeUTF(this.elem.linkUrl);
    paramObjectOutput.writeUTF(this.elem.blackStripe);
    paramObjectOutput.writeUTF(this.elem.notice);
    paramObjectOutput.writeInt(this.channelId);
    paramObjectOutput.writeInt(this.templateId);
    paramObjectOutput.writeInt(this.resend);
    paramObjectOutput.writeInt(this.redtype);
    paramObjectOutput.writeUTF(this.redPacketId);
    paramObjectOutput.writeUTF(this.authkey);
    paramObjectOutput.writeBoolean(this.isOpened);
    paramObjectOutput.writeInt(this.elem.titleColor);
    paramObjectOutput.writeInt(this.elem.subtitleColor);
    paramObjectOutput.writeUTF(this.elem.actionsPriority);
    paramObjectOutput.writeUTF(this.elem.jumpUrl);
    paramObjectOutput.writeUTF(this.elem.nativeAndroid);
    paramObjectOutput.writeUTF(this.elem.iconUrl);
    paramObjectOutput.writeInt(this.elem.contentColor);
    paramObjectOutput.writeInt(this.elem.contentBgColor);
    paramObjectOutput.writeUTF(this.elem.aioImageLeft);
    paramObjectOutput.writeUTF(this.elem.aioImageRight);
    paramObjectOutput.writeUTF(this.elem.cftImage);
    paramObjectOutput.writeInt(this.envelopeid);
    paramObjectOutput.writeUTF(this.envelopeName);
    paramObjectOutput.writeInt(this.conftype);
    paramObjectOutput.writeInt(this.msgFrom);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\QQWalletRedPacketMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import localpb.richMsg.MarketFaceMsg.MarketFaceRec;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForMixedMsg
  extends ChatMessage
{
  private static final String TAG = "MessageForMixedMsg";
  public Object elemListSyncLock;
  public MessageForText.AtTroopMemberInfo mAtInfo;
  public int mForwardFromIsTroop;
  public String mForwardFromUin;
  public long mForwardFromUniSeq;
  protected boolean mHasReplyText;
  public boolean mIsResend;
  public int mRichTextLength;
  public List msgElemList;
  
  public MessageForMixedMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.elemListSyncLock = new Object();
  }
  
  public static void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageForMixedMsg paramMessageForMixedMsg)
  {
    paramMessageForPic.senderuin = paramMessageForMixedMsg.senderuin;
    paramMessageForPic.selfuin = paramMessageForMixedMsg.selfuin;
    paramMessageForPic.frienduin = paramMessageForMixedMsg.frienduin;
    paramMessageForPic.time = paramMessageForMixedMsg.time;
    paramMessageForPic.issend = paramMessageForMixedMsg.issend;
    paramMessageForPic.istroop = paramMessageForMixedMsg.istroop;
    paramMessageForPic.shmsgseq = paramMessageForMixedMsg.shmsgseq;
    paramMessageForPic.msgtype = 63536;
    paramMessageForPic.uniseq = paramMessageForMixedMsg.uniseq;
    paramMessageForPic.msgseq = paramMessageForMixedMsg.msgseq;
  }
  
  public static CharSequence getTextFromMixedMsg(ChatMessage arg0)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder("");
    int j;
    Object localObject5;
    if ((??? instanceof MessageForMixedMsg))
    {
      ??? = (MessageForMixedMsg)???;
      for (;;)
      {
        synchronized (((MessageForMixedMsg)???).elemListSyncLock)
        {
          j = ((MessageForMixedMsg)???).msgElemList.size();
          if (i >= j) {
            break label191;
          }
          ??? = (MessageRecord)((MessageForMixedMsg)???).msgElemList.get(i);
          if ((??? instanceof MessageForReplyText))
          {
            localObject5 = (MessageForReplyText)???;
            if (((MessageForReplyText)localObject5).sb != null)
            {
              ??? = ((MessageForReplyText)localObject5).sb.toString();
              localStringBuilder.append(???);
            }
            else
            {
              ??? = ???.msg;
              continue;
            }
          }
          else if ((??? instanceof MessageForText))
          {
            localObject5 = (MessageForText)???;
            if (((MessageForText)localObject5).sb != null)
            {
              ??? = ((MessageForText)localObject5).sb.toString();
              localStringBuilder.append(???);
            }
          }
        }
        ??? = ???.msg;
      }
      if ((??? instanceof MessageForPic)) {
        localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131367266));
      }
    }
    else
    {
      label191:
      label193:
      while (!(??? instanceof MessageForLongMsg)) {
        return localStringBuilder.toString();
      }
      ??? = (MessageForLongMsg)???;
      synchronized (((MessageForLongMsg)???).fragmentListSyncLock)
      {
        int k = ((MessageForLongMsg)???).longMsgFragmentList.size();
        i = 0;
        label231:
        if (i >= k) {
          break label478;
        }
        ??? = (MessageRecord)((MessageForLongMsg)???).longMsgFragmentList.get(i);
        if ((??? instanceof MessageForReplyText)) {
          localStringBuilder.append(((MessageForReplyText)???).msg);
        } else if ((??? instanceof MessageForText)) {
          localStringBuilder.append(((MessageForText)???).msg);
        }
      }
      if ((??? instanceof MessageForMixedMsg)) {
        localObject5 = (MessageForMixedMsg)???;
      }
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      synchronized (((MessageForMixedMsg)localObject5).elemListSyncLock)
      {
        int m = ((MessageForMixedMsg)localObject5).msgElemList.size();
        j = 0;
        if (j >= m) {
          break label450;
        }
        localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject5).msgElemList.get(j);
        if ((localMessageRecord instanceof MessageForReplyText))
        {
          if (!TextUtils.isEmpty(localMessageRecord.msg)) {
            ((StringBuilder)localObject1).append(((MessageForReplyText)localMessageRecord).msg);
          }
        }
        else if ((localMessageRecord instanceof MessageForText)) {
          ((StringBuilder)localObject1).append(((MessageForText)localMessageRecord).msg);
        }
      }
      if ((localMessageRecord instanceof MessageForPic))
      {
        ((StringBuilder)localObject2).append(BaseApplicationImpl.getContext().getString(2131367266));
        break label501;
        label450:
        break label492;
        if ((??? instanceof MessageForPic))
        {
          ((StringBuilder)localObject2).append(BaseApplicationImpl.getContext().getString(2131367266));
          break label492;
          label478:
          break label193;
          i += 1;
          break;
        }
        label492:
        i += 1;
        break label231;
      }
      label501:
      j += 1;
    }
  }
  
  public void doParse()
  {
    Object localObject5 = new MixedMsg.Msg();
    Object localObject6 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    int m;
    Object localObject1;
    try
    {
      ((MixedMsg.Msg)localObject5).mergeFrom(this.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse");
      }
      this.msgElemList = new CopyOnWriteArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list created");
      }
      if (((MixedMsg.Msg)localObject5).elems.get().size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse no element");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      m = ((MixedMsg.Msg)localObject5).elems.get().size();
      localObject1 = getExtInfoFromExtStr("disc_at_info_list");
      QLog.w("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse disc_at_info_list extStr " + (String)localObject1);
    }
    label355:
    label408:
    label696:
    label962:
    label965:
    label970:
    label973:
    for (;;)
    {
      int i;
      int j;
      Object localObject7;
      int k;
      boolean bool1;
      Object localObject8;
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label965;
        }
        localObject1 = new JSONObject((String)localObject1);
        i = 1;
        j = 0;
        localObject7 = this.elemListSyncLock;
        k = 0;
        if (k >= m) {
          break label696;
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          MixedMsg.Elem localElem = (MixedMsg.Elem)((MixedMsg.Msg)localObject5).elems.get().get(k);
          bool1 = localElem.sourceMsgInfo.has();
          if (!bool1) {
            break label408;
          }
          try
          {
            localObject8 = new MessageForReplyText();
            ((MessageForReplyText)localObject8).mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes(localElem.sourceMsgInfo.get())));
            if (localElem.textMsg.has())
            {
              ((MessageForReplyText)localObject8).msg = localElem.textMsg.get();
              ((MessageForReplyText)localObject8).sb = new QQText(((MessageForReplyText)localObject8).msg, 13, 32, this);
            }
            this.msgElemList.add(localObject8);
            if (((MessageForReplyText)localObject8).msg != null)
            {
              ((StringBuilder)localObject6).append(((MessageForReplyText)localObject8).msg);
              localStringBuilder.append(((MessageForReplyText)localObject8).msg);
            }
          }
          catch (Exception localException2)
          {
            Object localObject2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MessageForMixedMsg", 2, localException2.getMessage());
            continue;
          }
          this.mHasReplyText = true;
          k += 1;
          continue;
        }
        finally {}
        localJSONException = localJSONException;
        QLog.e("MessageForMixedMsg", 1, "get mixJSONO error:", localJSONException);
        localObject2 = null;
        continue;
      }
      JSONArray localJSONArray;
      if (localException2.textMsg.has())
      {
        localObject8 = new MessageForText();
        ((MessageForText)localObject8).frienduin = this.frienduin;
        ((MessageForText)localObject8).msg = localException2.textMsg.get();
        ((MessageForText)localObject8).msgData = ((MessageForText)localObject8).msg.getBytes();
        if (localObject3 == null) {
          break label962;
        }
        localJSONArray = ((JSONObject)localObject3).optJSONArray("" + i);
        if ((localJSONArray == null) || (TextUtils.isEmpty(localJSONArray.toString()))) {
          break label962;
        }
        ((MessageForText)localObject8).saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
        i += 1;
      }
      for (;;)
      {
        ((MessageForText)localObject8).doParse(true);
        this.msgElemList.add(localObject8);
        ((StringBuilder)localObject6).append(((MessageForText)localObject8).msg);
        if (!TextUtils.isEmpty(((MessageForText)localObject8).msg2))
        {
          j = 1;
          localStringBuilder.append(((MessageForText)localObject8).msg2);
          break label970;
          if (localJSONArray.picMsg.has())
          {
            localObject8 = new MessageForPic();
            ((MessageForPic)localObject8).msgData = ((RichMsg.PicRec)localJSONArray.picMsg.get()).toByteArray();
            ((MessageForPic)localObject8).doParse();
            ((MessageForPic)localObject8).subMsgId = k;
            copyBaseInfoFromMixedToPic((MessageForPic)localObject8, this);
            this.msgElemList.add(localObject8);
            ((StringBuilder)localObject6).append(BaseApplicationImpl.getContext().getString(2131367266));
            localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131367266));
            break label355;
          }
          if (!localJSONArray.markfaceMsg.has()) {
            break label973;
          }
          break label973;
          if (QLog.isColorLevel()) {
            QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.doParse list size is " + this.msgElemList.size());
          }
          this.msg = ((StringBuilder)localObject6).toString();
          if (j != 0) {
            this.msg2 = localStringBuilder.toString();
          }
          boolean bool2 = true;
          String str = getExtInfoFromExtStr("sens_msg_need_parse");
          bool1 = bool2;
          if (!TextUtils.isEmpty(str)) {}
          for (;;)
          {
            try
            {
              bool1 = Boolean.parseBoolean(str);
              bool2 = bool1;
              if (bool1) {
                if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
                {
                  bool2 = bool1;
                  if (!(BaseActivity.sTopActivity instanceof ChatHistoryForC2C)) {}
                }
                else
                {
                  bool2 = false;
                }
              }
              if (!bool2) {
                break;
              }
              str = getExtInfoFromExtStr("sens_msg_ctrl_info");
              if (TextUtils.isEmpty(str)) {
                break;
              }
              localObject5 = getExtInfoFromExtStr("sens_msg_confirmed");
              if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (((String)localObject5).equalsIgnoreCase("1")))
              {
                bool1 = true;
                if (!bool1)
                {
                  localObject5 = this.msgElemList.iterator();
                  if (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (MessageRecord)((Iterator)localObject5).next();
                    if (!(localObject6 instanceof MessageForText)) {
                      continue;
                    }
                    ((MessageRecord)localObject6).saveExtInfoToExtStr("sens_msg_original_text", ((MessageRecord)localObject6).msg);
                    continue;
                  }
                }
              }
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              bool1 = bool2;
              continue;
              MQPSensitiveMsgUtil.a(this, this.msgElemList, bool1, HexUtil.hexStr2Bytes(localException1));
              return;
            }
            bool1 = false;
          }
        }
        break label970;
      }
      Object localObject4 = null;
      continue;
    }
  }
  
  public String getContentForSearch()
  {
    for (;;)
    {
      MessageRecord localMessageRecord;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        synchronized (this.elemListSyncLock)
        {
          Iterator localIterator = this.msgElemList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localMessageRecord = (MessageRecord)localIterator.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            localStringBuilder.append("[图片]");
          }
        }
        if (!(localMessageRecord instanceof MessageForReplyText)) {
          break label122;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch failure: ", localThrowable);
        }
        return null;
      }
      if (!TextUtils.isEmpty(localMessageRecord.msg))
      {
        ((StringBuilder)localObject2).append(localMessageRecord.msg);
        continue;
        label122:
        if ((localMessageRecord instanceof MessageForText)) {
          ((StringBuilder)localObject2).append(localMessageRecord.msg);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MessageForMixedMsg", 2, "MessageForMixedMsg.getContentForSearch msg is " + Utils.a(((StringBuilder)localObject2).toString()));
    }
    String str = ((StringBuilder)localObject2).toString();
    return str;
  }
  
  public MessageRecord getSubMessage(long paramLong)
  {
    if ((this.msgElemList == null) || (paramLong < 0L) || (paramLong >= this.msgElemList.size())) {
      return null;
    }
    return (MessageRecord)this.msgElemList.get((int)paramLong);
  }
  
  public String getSummaryMsg()
  {
    return getTextFromMixedMsg(this).toString();
  }
  
  public boolean hasReplyText()
  {
    return this.mHasReplyText;
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void parse()
  {
    super.parse();
    synchronized (this.elemListSyncLock)
    {
      Iterator localIterator = this.msgElemList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (((localMessageRecord instanceof MessageForPic)) && (localMessageRecord.uniseq != this.uniseq))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MessageForMixedMsg", 2, " Error : Info not Equals : child : " + localMessageRecord.uniseq + " parent:" + this.uniseq);
          }
          copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, this);
        }
      }
    }
  }
  
  protected void postRead()
  {
    this.msgId = getLogicMsgID(getId(), this.versionCode);
    parse();
  }
  
  protected void prewrite()
  {
    if (this.msgElemList == null) {
      return;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    label267:
    label278:
    for (;;)
    {
      Object localObject4;
      MixedMsg.Elem localElem;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break label267;
        }
        localObject4 = localIterator.next();
        localElem = new MixedMsg.Elem();
        if ((localObject4 instanceof MessageForText))
        {
          String str = getExtInfoFromExtStr("sens_msg_original_text");
          if (!TextUtils.isEmpty(str)) {
            break label278;
          }
          str = ((MessageForText)localObject4).msg;
          localElem.textMsg.set(str);
          localMsg.elems.get().add(localElem);
        }
      }
      if ((localObject4 instanceof MessageForPic))
      {
        localElem.picMsg.set(((MessageForPic)localObject4).getSerialPB());
      }
      else if ((localObject4 instanceof MessageForReplyText))
      {
        Object localObject2 = (MessageForReplyText)localObject4;
        if (!TextUtils.isEmpty(((MessageForReplyText)localObject2).msg)) {
          localElem.textMsg.set(((MessageForReplyText)localObject2).msg);
        }
        try
        {
          localObject2 = MessagePkgUtils.a(((MessageForReplyText)localObject2).mSourceMsgInfo);
          localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject2));
          this.mHasReplyText = true;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("MessageForMixedMsg", 2, "MessagePkgUtils.getBytesFromObject get Exception:" + localException.getMessage());
            }
          }
        }
      }
      else if ((localObject4 instanceof MessageForMarketFace))
      {
        continue;
        this.msgData = localMsg.toByteArray();
        return;
      }
    }
  }
  
  public byte[] upateMessageForPic(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      return this.msgData;
    }
    if (this.msgElemList == null) {
      return this.msgData;
    }
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    Object localObject4;
    MixedMsg.Elem localElem;
    for (;;)
    {
      Object localObject1;
      synchronized (this.elemListSyncLock)
      {
        Iterator localIterator = this.msgElemList.iterator();
        if (!localIterator.hasNext()) {
          break label339;
        }
        localObject4 = localIterator.next();
        localElem = new MixedMsg.Elem();
        if (!(localObject4 instanceof MessageForReplyText)) {
          break label217;
        }
        String str = getExtInfoFromExtStr("sens_msg_original_text");
        localObject4 = (MessageForReplyText)localObject4;
        localObject1 = str;
        if (TextUtils.isEmpty(str)) {
          localObject1 = ((MessageForReplyText)localObject4).msg;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localElem.textMsg.set((String)localObject1);
        }
      }
      try
      {
        localObject1 = MessagePkgUtils.a(((MessageForReplyText)localObject4).mSourceMsgInfo);
        localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject1));
        localMsg.elems.get().add(localElem);
        continue;
        paramMessageForPic = finally;
        throw paramMessageForPic;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MessageForMixedMsg", 2, "MessagePkgUtils.getBytesFromObject get Exception:" + localException.getMessage());
          }
        }
      }
    }
    label217:
    Object localObject2;
    if ((localObject4 instanceof MessageForText))
    {
      localObject2 = getExtInfoFromExtStr("sens_msg_original_text");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label356;
      }
      localObject2 = ((MessageForText)localObject4).msg;
    }
    label339:
    label356:
    for (;;)
    {
      localElem.textMsg.set((String)localObject2);
      break;
      if ((localObject4 instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)localObject4;
        if ((((MessageForPic)localObject2).uniseq == paramMessageForPic.uniseq) && (((MessageForPic)localObject2).subMsgId == paramMessageForPic.subMsgId))
        {
          localElem.picMsg.set(paramMessageForPic.getSerialPB());
          break;
        }
        localElem.picMsg.set(((MessageForPic)localObject2).getSerialPB());
        break;
      }
      if (!(localObject4 instanceof MessageForMarketFace)) {
        break;
      }
      break;
      this.msgData = localMsg.toByteArray();
      return this.msgData;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForMixedMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
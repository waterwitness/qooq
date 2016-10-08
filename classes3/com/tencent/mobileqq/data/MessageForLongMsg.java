package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info.BankcodeElem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MessageForLongMsg
  extends ChatMessage
{
  public Object fragmentListSyncLock;
  public List longMsgFragmentList;
  public boolean mIsCutAtInfoLocal;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public CharSequence sb;
  public CharSequence sb2;
  
  public MessageForLongMsg()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.fragmentListSyncLock = new Object();
    this.longMsgFragmentList = new ArrayList();
  }
  
  public MessageForLongMsg(ArrayList paramArrayList)
  {
    this.fragmentListSyncLock = new Object();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.longMsgFragmentList = new ArrayList();
      this.longMsgFragmentList.addAll(paramArrayList);
      paramArrayList = (MessageRecord)this.longMsgFragmentList.get(0);
      MessageRecord.copyMessageRecordBaseField(this, paramArrayList);
      if ((paramArrayList instanceof MessageForReplyText)) {
        this.atInfoList = ((MessageForReplyText)paramArrayList).atInfoList;
      }
      this.msgtype = 64499;
      paramArrayList = this.longMsgFragmentList.iterator();
      while (paramArrayList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
        if ((!(localMessageRecord instanceof MessageForText)) && (!(localMessageRecord instanceof MessageForReplyText))) {
          this.msgtype = 64500;
        }
        if ((localMessageRecord.extraflag == 32768) && (localMessageRecord.isSendFromLocal())) {
          this.extraflag = 32768;
        }
      }
    }
  }
  
  protected void doParse()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int i = 0;
    int i1 = 0;
    Object localObject7 = this.fragmentListSyncLock;
    int m = i;
    for (;;)
    {
      boolean bool1;
      Object localObject5;
      Object localObject8;
      boolean bool2;
      Object localObject9;
      int k;
      int n;
      Object localObject10;
      try
      {
        if (this.longMsgFragmentList != null)
        {
          m = i;
          if (!this.longMsgFragmentList.isEmpty())
          {
            j = 0;
            bool1 = false;
            localObject5 = this.longMsgFragmentList.iterator();
            i = 0;
            if (((Iterator)localObject5).hasNext())
            {
              localObject8 = (MessageRecord)((Iterator)localObject5).next();
              Object localObject1 = ((MessageRecord)localObject8).getExtInfoFromExtStr("sens_msg_ctrl_info");
              bool2 = TextUtils.isEmpty((CharSequence)localObject1);
              if (bool2) {
                break label1137;
              }
              try
              {
                localObject9 = new bankcode_info.BankcodeCtrlInfo();
                ((bankcode_info.BankcodeCtrlInfo)localObject9).mergeFrom(HexUtil.hexStr2Bytes((String)localObject1));
                if (!((bankcode_info.BankcodeCtrlInfo)localObject9).msgtail_id.has()) {
                  break label1134;
                }
                k = ((bankcode_info.BankcodeCtrlInfo)localObject9).msgtail_id.get();
                i = k;
                if (i != 1) {
                  continue;
                }
                n = j;
                bool2 = bool1;
                k = i;
                m = j;
                bool3 = bool1;
              }
              catch (Exception localException1) {}
            }
          }
        }
      }
      finally {}
      try
      {
        if (!((bankcode_info.BankcodeCtrlInfo)localObject9).bankcode_elems.has()) {
          continue;
        }
        m = j;
        bool3 = bool1;
        localObject1 = ((bankcode_info.BankcodeCtrlInfo)localObject9).bankcode_elems.get();
        n = j;
        bool2 = bool1;
        k = i;
        if (localObject1 == null) {
          continue;
        }
        m = j;
        bool3 = bool1;
        localObject9 = ((List)localObject1).iterator();
        m = j;
        bool3 = bool1;
        if (((Iterator)localObject9).hasNext())
        {
          m = j;
          bool3 = bool1;
          localObject10 = (bankcode_info.BankcodeElem)((Iterator)localObject9).next();
          m = j;
          bool3 = bool1;
          if (!((bankcode_info.BankcodeElem)localObject10).bankcode_attr.has()) {
            break label1128;
          }
          m = j;
          bool3 = bool1;
          k = ((bankcode_info.BankcodeElem)localObject10).bankcode_attr.get();
          break label1152;
        }
        n = j;
        bool2 = bool1;
        k = i;
        if (j != 20) {
          continue;
        }
        m = j;
        bool3 = bool1;
        localObject9 = ((List)localObject1).iterator();
        n = j;
        bool2 = bool1;
        k = i;
        m = j;
        bool3 = bool1;
        if (!((Iterator)localObject9).hasNext()) {
          continue;
        }
        m = j;
        bool3 = bool1;
        localObject1 = (bankcode_info.BankcodeElem)((Iterator)localObject9).next();
        k = 0;
        m = j;
        bool3 = bool1;
        if (((bankcode_info.BankcodeElem)localObject1).bankcode_attr.has())
        {
          m = j;
          bool3 = bool1;
          k = ((bankcode_info.BankcodeElem)localObject1).bankcode_attr.get();
        }
        if (k != 20) {
          continue;
        }
        m = j;
        bool3 = bool1;
        if (!((bankcode_info.BankcodeElem)localObject1).clean_bankcode.has()) {
          break label1116;
        }
        m = j;
        bool3 = bool1;
        localObject1 = ((bankcode_info.BankcodeElem)localObject1).clean_bankcode.get();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          j = m;
          bool1 = bool3;
          break;
        }
        continue;
        localObject4 = null;
        continue;
      }
      m = j;
      boolean bool3 = bool1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        m = j;
        bool3 = bool1;
        bool2 = MQPSensitiveMsgUtil.a().a((String)localObject1);
        if (!bool2)
        {
          bool1 = true;
          continue;
          localException1.printStackTrace();
          k = i;
          bool2 = bool1;
          n = j;
          label550:
          String str;
          if (this.mSourceMsgInfo == null)
          {
            str = ((MessageRecord)localObject8).getExtInfoFromExtStr("sens_msg_source_msg_info");
            bool1 = TextUtils.isEmpty(str);
            if (bool1) {}
          }
          try
          {
            this.mSourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes(str)));
            i = k;
            j = n;
            bool1 = bool2;
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + localException2.getMessage());
            continue;
          }
          localObject8 = this.longMsgFragmentList.iterator();
          k = i1;
          for (;;)
          {
            m = k;
            if (!((Iterator)localObject8).hasNext()) {
              break;
            }
            localObject9 = (MessageRecord)((Iterator)localObject8).next();
            if ((localObject9 instanceof ChatMessage))
            {
              if (i == 1)
              {
                ((MessageRecord)localObject9).saveExtInfoToExtStr("sens_msg_attr", Integer.toString(j));
                ((MessageRecord)localObject9).saveExtInfoToExtStr("sens_msg_has_not_confirmed_msg", Boolean.toString(bool1));
              }
              ((ChatMessage)localObject9).doParse();
              Object localObject3;
              if ((localObject9 instanceof MessageForText))
              {
                localStringBuilder1.append(((MessageRecord)localObject9).msg);
                localObject3 = new StringBuilder(((MessageRecord)localObject9).msg);
                localObject5 = localObject3;
                m = k;
                if (this.istroop == 3000)
                {
                  localObject10 = ((MessageRecord)localObject9).getExtInfoFromExtStr("disc_at_info_list");
                  bool2 = TextUtils.isEmpty((CharSequence)localObject10);
                  localObject5 = localObject3;
                  m = k;
                  if (bool2) {}
                }
                for (;;)
                {
                  try
                  {
                    localObject5 = BaseApplicationImpl.a.a();
                    if (!QQAppInterface.class.isInstance(localObject5)) {
                      continue;
                    }
                    localObject5 = AtTroopMemberSpan.a((QQAppInterface)localObject5, (StringBuilder)localObject3, (String)localObject10, ((MessageRecord)localObject9).frienduin);
                    localObject3 = localObject5;
                    if (k != 0) {
                      break label1110;
                    }
                    k = 1;
                    m = k;
                    localObject5 = localObject3;
                  }
                  catch (Exception localException4)
                  {
                    QLog.e("MessageForLongMsg", 1, "replaceAtMsgByMarkName", localException4);
                    Object localObject6 = localObject3;
                    m = k;
                    continue;
                  }
                  localStringBuilder2.append(((StringBuilder)localObject5).toString());
                  k = m;
                  break;
                  if (QLog.isColorLevel()) {
                    QLog.e("MessageForLongMsg", 1, "We get error AppRuntime");
                  }
                }
              }
              if ((localObject9 instanceof MessageForReplyText))
              {
                localStringBuilder1.append(((MessageForReplyText)localObject9).msg);
                localStringBuilder2.append(((MessageForReplyText)localObject9).msg);
              }
              else if ((localObject9 instanceof MessageForMixedMsg))
              {
                localStringBuilder1.append(((MessageForMixedMsg)localObject9).msg);
                localStringBuilder2.append(((MessageForMixedMsg)localObject9).msg);
              }
              else if ((localObject9 instanceof MessageForPic))
              {
                localStringBuilder1.append(BaseApplicationImpl.getContext().getString(2131367266));
                localStringBuilder2.append(BaseApplicationImpl.getContext().getString(2131367266));
              }
            }
          }
          this.msg = localStringBuilder1.toString();
          this.sb = new QQText(this.msg, 13, 32, this.istroop);
          if (m != 0) {
            this.sb2 = new QQText(localStringBuilder2.toString(), 13, 32, this.istroop);
          }
          return;
        }
      }
      label1110:
      label1116:
      label1128:
      label1134:
      label1137:
      label1152:
      do
      {
        Object localObject4;
        k = j;
        break label1159;
        k = 0;
        continue;
        break;
        n = j;
        bool2 = bool1;
        k = i;
        break label550;
      } while (k <= j);
      label1159:
      int j = k;
    }
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.w(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public MessageRecord rebuildLongMsg()
  {
    Object localObject3;
    if (this.msgtype == 64499)
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      for (;;)
      {
        synchronized (this.fragmentListSyncLock)
        {
          localObject3 = this.longMsgFragmentList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          ??? = (MessageRecord)((Iterator)localObject3).next();
          if ((??? instanceof MessageForText)) {
            localStringBuilder.append(((MessageForText)???).msg);
          }
        }
        if ((??? instanceof MessageForReplyText)) {
          ((StringBuilder)localObject1).append(((MessageForReplyText)???).msg);
        }
      }
      ??? = (MessageForText)MessageRecordFactory.a(64536);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForText)???).msgtype = 64536;
      ((MessageForText)???).msg = ((StringBuilder)localObject1).toString();
      return (MessageRecord)???;
    }
    if (this.msgtype == 64500)
    {
      ??? = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      localObject3 = new StringBuffer();
      for (;;)
      {
        Object localObject5;
        synchronized (this.fragmentListSyncLock)
        {
          Iterator localIterator = this.longMsgFragmentList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject5 = (MessageRecord)localIterator.next();
          if ((localObject5 instanceof MessageForText)) {
            ((List)???).add(localObject5);
          }
        }
        Object localObject6;
        if ((localObject5 instanceof MessageForMixedMsg))
        {
          localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            if ((localObject6 instanceof MessageForText))
            {
              ((List)???).add(localObject6);
            }
            else if ((localObject6 instanceof MessageForPic))
            {
              if (!((List)???).isEmpty())
              {
                Object localObject7 = ((List)???).iterator();
                while (((Iterator)localObject7).hasNext()) {
                  ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)localObject7).next()).msg);
                }
                localObject7 = (MessageForText)MessageRecordFactory.a(64536);
                ((MessageForText)localObject7).msgtype = 64536;
                ((MessageForText)localObject7).msg = ((StringBuffer)localObject3).toString();
                ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
                localCollection.add(localObject7);
                ((List)???).clear();
              }
              localCollection.add((MessageForPic)((MessageRecord)localObject6).deepCopyByReflect());
            }
            else if ((localObject6 instanceof MessageForReplyText))
            {
              ((List)???).add(localObject6);
            }
          }
        }
        else if ((localObject5 instanceof MessageForPic))
        {
          if (!((List)???).isEmpty())
          {
            localObject6 = ((List)???).iterator();
            while (((Iterator)localObject6).hasNext()) {
              ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)localObject6).next()).msg);
            }
            localObject6 = (MessageForText)MessageRecordFactory.a(64536);
            ((MessageForText)localObject6).msgtype = 64536;
            ((MessageForText)localObject6).msg = ((StringBuffer)localObject3).toString();
            ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
            localCollection.add(localObject6);
            ((List)???).clear();
          }
          localCollection.add((MessageForPic)((MessageRecord)localObject5).deepCopyByReflect());
        }
        else if ((localObject5 instanceof MessageForReplyText))
        {
          ((List)???).add(localObject5);
        }
      }
      if (!((List)???).isEmpty())
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext()) {
          ((StringBuffer)localObject3).append(((MessageRecord)((Iterator)???).next()).msg);
        }
        ??? = (MessageForText)MessageRecordFactory.a(64536);
        ((MessageForText)???).msgtype = 64536;
        ((MessageForText)???).msg = ((StringBuffer)localObject3).toString();
        ((StringBuffer)localObject3).delete(0, ((StringBuffer)localObject3).length());
        localCollection.add(???);
        ((List)???).clear();
      }
      ??? = (MessageForMixedMsg)MessageRecordFactory.a(64501);
      copyMessageRecordBaseField((MessageRecord)???, this);
      ((MessageForMixedMsg)???).msgtype = 64501;
      ((MessageForMixedMsg)???).msgElemList = new CopyOnWriteArrayList();
      ((MessageForMixedMsg)???).msgElemList.addAll(localCollection);
      ((MessageForMixedMsg)???).prewrite();
      return (MessageRecord)???;
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForLongMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
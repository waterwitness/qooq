package com.tencent.mobileqq.graytip;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightClickableSpan;
import com.tencent.mobileqq.data.MessageForGrayTips.HightlightItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import localpb.uniteGrayTip.UniteGrayTip.HightlightParam;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import ssu;

public class MessageForUniteGrayTip
  extends ChatMessage
{
  public UniteGrayTipCallBack callback;
  public UniteGrayTipParam tipParam;
  
  public MessageForUniteGrayTip()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void doParse()
  {
    Object localObject = new UniteGrayTip.UniteGrayTipMsg();
    label472:
    label477:
    for (;;)
    {
      int k;
      String str2;
      String str1;
      int m;
      ArrayList localArrayList;
      try
      {
        ((UniteGrayTip.UniteGrayTipMsg)localObject).mergeFrom(this.msgData);
        int j = ((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_id.get();
        k = ((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_level.get();
        str2 = ((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_key.get();
        str1 = ((UniteGrayTip.UniteGrayTipMsg)localObject).content.get();
        m = ((UniteGrayTip.UniteGrayTipMsg)localObject).isLocalTroopMsg.get();
        if ((!((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_mutex_id.has()) || (((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_mutex_id.size() <= 0)) {
          break label472;
        }
        localArrayList = (ArrayList)((UniteGrayTip.UniteGrayTipMsg)localObject).graytip_mutex_id.get();
        int[] arrayOfInt = new int[localArrayList.size()];
        int i = 0;
        if (i >= localArrayList.size() - 1) {
          break label477;
        }
        arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
        continue;
        if ((((UniteGrayTip.UniteGrayTipMsg)localObject).hightlight_item.has()) && (((UniteGrayTip.UniteGrayTipMsg)localObject).hightlight_item.size() > 0))
        {
          localArrayList = new ArrayList();
          localObject = ((ArrayList)((UniteGrayTip.UniteGrayTipMsg)localObject).hightlight_item.get()).iterator();
          if (((Iterator)localObject).hasNext())
          {
            UniteGrayTip.HightlightParam localHightlightParam = (UniteGrayTip.HightlightParam)((Iterator)localObject).next();
            i = localHightlightParam.start.get();
            int n = localHightlightParam.end.get();
            long l = localHightlightParam.uin.get();
            int i1 = localHightlightParam.needUpdateNick.get();
            int i2 = localHightlightParam.actionType.get();
            String str3 = localHightlightParam.icon.get();
            int i3 = localHightlightParam.textColor.get();
            localArrayList.add(new MessageForGrayTips.HightlightItem(i, n, l, i1, i2, localHightlightParam.mMsgActionData.get(), localHightlightParam.mMsg_A_ActionData.get(), str3, null, i3));
            continue;
          }
          this.tipParam = new UniteGrayTipParam(this.frienduin, this.senderuin, str1, this.istroop, this.msgtype, j, this.time);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 1, "MessageForUniteGrayTip, doParese failed, " + localException.getMessage());
        return;
      }
      for (;;)
      {
        this.tipParam.d = str2;
        this.tipParam.k = k;
        this.tipParam.jdField_b_of_type_ArrayOfInt = localException;
        this.tipParam.jdField_a_of_type_JavaUtilArrayList = localArrayList;
        localUniteGrayTipParam = this.tipParam;
        if (m == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localUniteGrayTipParam.f = bool;
          this.msg = str1;
          return;
        }
        localArrayList = null;
      }
      UniteGrayTipParam localUniteGrayTipParam = null;
    }
  }
  
  public SpannableStringBuilder getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((this.tipParam == null) || (this.tipParam.jdField_a_of_type_JavaUtilArrayList == null) || (this.tipParam.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return new SpannableStringBuilder(this.msg);
    }
    Collections.sort(this.tipParam.jdField_a_of_type_JavaUtilArrayList, new ssu(this));
    Object localObject1 = this.msg;
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(51);
    Iterator localIterator = this.tipParam.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    Object localObject2 = "";
    int j = 0;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject3 = (MessageForGrayTips.HightlightItem)localIterator.next();
      String str1 = (String)localObject2 + ((String)localObject1).substring(0, ((MessageForGrayTips.HightlightItem)localObject3).start - j);
      String str2 = ((String)localObject1).substring(((MessageForGrayTips.HightlightItem)localObject3).start - j, ((MessageForGrayTips.HightlightItem)localObject3).end - j);
      localObject2 = ((String)localObject1).substring(((MessageForGrayTips.HightlightItem)localObject3).end - j, ((String)localObject1).length());
      j = ((MessageForGrayTips.HightlightItem)localObject3).end;
      ((MessageForGrayTips.HightlightItem)localObject3).start = str1.length();
      if (((MessageForGrayTips.HightlightItem)localObject3).needUpdateNick)
      {
        localObject1 = str1 + localTroopManager.a(this.frienduin, new StringBuilder().append("").append(((MessageForGrayTips.HightlightItem)localObject3).uin).toString());
        i = 1;
      }
      for (;;)
      {
        ((MessageForGrayTips.HightlightItem)localObject3).end = ((String)localObject1).length();
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
        localObject1 = str1 + str2;
      }
    }
    localObject1 = (String)localObject2 + (String)localObject1;
    if (i != 0)
    {
      this.msg = ((String)localObject1);
      this.tipParam.c = ((String)localObject1);
    }
    localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
    localObject2 = this.tipParam.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (MessageForGrayTips.HightlightItem)((Iterator)localObject2).next();
      if (localObject3 != null) {
        if (TextUtils.isEmpty(((MessageForGrayTips.HightlightItem)localObject3).icon)) {
          ((SpannableStringBuilder)localObject1).setSpan(new MessageForGrayTips.HightlightClickableSpan(paramQQAppInterface, ((MessageForGrayTips.HightlightItem)localObject3).textColor, paramContext, (MessageForGrayTips.HightlightItem)localObject3, this), ((MessageForGrayTips.HightlightItem)localObject3).start, ((MessageForGrayTips.HightlightItem)localObject3).end, 33);
        } else {
          MessageForGrayTips.decodeImageSpan(paramContext, (SpannableStringBuilder)localObject1, (MessageForGrayTips.HightlightItem)localObject3);
        }
      }
    }
    return (SpannableStringBuilder)localObject1;
  }
  
  public void initGrayTipMsg(QQAppInterface paramQQAppInterface, UniteGrayTipParam paramUniteGrayTipParam)
  {
    if ((paramUniteGrayTipParam == null) || (!paramUniteGrayTipParam.a()))
    {
      if (QLog.isColorLevel()) {
        if (paramUniteGrayTipParam != null) {
          break label53;
        }
      }
      label53:
      for (paramQQAppInterface = "null tipParam";; paramQQAppInterface = "msgtype: " + paramUniteGrayTipParam.j + " id: " + paramUniteGrayTipParam.i)
      {
        QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, "createGrayTipMsg failed, error: " + paramQQAppInterface);
        return;
      }
    }
    init(paramQQAppInterface.a(), paramUniteGrayTipParam.jdField_a_of_type_JavaLangString, paramUniteGrayTipParam.jdField_b_of_type_JavaLangString, paramUniteGrayTipParam.c, paramUniteGrayTipParam.jdField_a_of_type_Long, paramUniteGrayTipParam.j, paramUniteGrayTipParam.h, paramUniteGrayTipParam.jdField_a_of_type_Long);
    this.mIsParsed = true;
    this.isread = true;
    this.tipParam = paramUniteGrayTipParam;
    this.msgData = null;
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    int j = 1;
    UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
    localUniteGrayTipMsg.graytip_id.set(this.tipParam.i);
    localUniteGrayTipMsg.graytip_level.set(this.tipParam.k);
    if ((this.tipParam.jdField_b_of_type_ArrayOfInt != null) && (this.tipParam.jdField_b_of_type_ArrayOfInt.length > 0))
    {
      localObject = this.tipParam.jdField_b_of_type_ArrayOfInt;
      int k = localObject.length;
      i = 0;
      while (i < k)
      {
        int m = localObject[i];
        localUniteGrayTipMsg.graytip_mutex_id.add(Integer.valueOf(m));
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(this.tipParam.d)) {
      localUniteGrayTipMsg.graytip_key.set(this.tipParam.d);
    }
    if (!TextUtils.isEmpty(this.tipParam.c)) {
      localUniteGrayTipMsg.content.set(this.tipParam.c);
    }
    if ((this.tipParam.jdField_a_of_type_JavaUtilArrayList != null) && (!this.tipParam.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      localObject = this.tipParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        MessageForGrayTips.HightlightItem localHightlightItem = (MessageForGrayTips.HightlightItem)((Iterator)localObject).next();
        UniteGrayTip.HightlightParam localHightlightParam = new UniteGrayTip.HightlightParam();
        localHightlightParam.start.set(localHightlightItem.start);
        localHightlightParam.end.set(localHightlightItem.end);
        localHightlightParam.uin.set(localHightlightItem.uin);
        PBUInt32Field localPBUInt32Field = localHightlightParam.needUpdateNick;
        if (localHightlightItem.needUpdateNick) {}
        for (i = 1;; i = 0)
        {
          localPBUInt32Field.set(i);
          localHightlightParam.actionType.set(localHightlightItem.actionType);
          localHightlightParam.textColor.set(localHightlightItem.textColor);
          if (!TextUtils.isEmpty(localHightlightItem.icon)) {
            localHightlightParam.icon.set(localHightlightItem.icon);
          }
          if (!TextUtils.isEmpty(localHightlightItem.mMsgActionData)) {
            localHightlightParam.mMsgActionData.set(localHightlightItem.mMsgActionData);
          }
          if (!TextUtils.isEmpty(localHightlightItem.mMsg_A_ActionData)) {
            localHightlightParam.mMsg_A_ActionData.set(localHightlightItem.mMsg_A_ActionData);
          }
          localUniteGrayTipMsg.hightlight_item.add(localHightlightParam);
          break;
        }
      }
    }
    Object localObject = localUniteGrayTipMsg.isLocalTroopMsg;
    if (this.tipParam.f) {}
    for (int i = j;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      this.msgData = localUniteGrayTipMsg.toByteArray();
      return;
    }
  }
  
  public void updateUniteGrayTipMsg(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e(UniteGrayTipUtil.jdField_a_of_type_JavaLangString, 2, "updateUniteGrayTipMsg");
    }
    this.msg = paramString;
    if (this.tipParam != null)
    {
      this.tipParam.c = paramString;
      prewrite();
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, this.msgData);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\graytip\MessageForUniteGrayTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAVideo;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nqa
  implements Runnable
{
  public nqa(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa struct_public start:" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "structingMsgItem public forward");
    }
    MessageForStructing localMessageForStructing;
    AbsShareMsg localAbsShareMsg;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
    {
      localMessageForStructing = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localAbsShareMsg = (AbsShareMsg)localMessageForStructing.structingMsg;
        if ((!(localAbsShareMsg instanceof StructMsgForGeneralShare)) || (!((StructMsgForGeneralShare)localAbsShareMsg).mIsPAVideoStructMsg)) {
          break label251;
        }
        localObject1 = (StructMsgForGeneralShare)StructMsgFactory.a(localAbsShareMsg.getBytes());
        PAVideoStructMsgUtil.a((StructMsgForGeneralShare)localObject1);
        ((StructMsgForGeneralShare)localObject1).mSourceAction = "web";
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        ((StructMsgForGeneralShare)localObject1).mSourceUrl = PAVideoStructMsgUtil.a((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceName = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        ((StructMsgForGeneralShare)localObject1).source_puin = ((String)localObject2);
        ((StructMsgForGeneralShare)localObject1).mSourceIcon = "http://q.url.cn/s/YnxqUe";
        ((StructMsgForGeneralShare)localObject1).setFlag(0);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("forward_type", -3);
        ((Bundle)localObject2).putInt("structmsg_service_id", ((StructMsgForGeneralShare)localObject1).mMsgServiceID);
        ((Bundle)localObject2).putByteArray("stuctmsg_bytes", ((StructMsgForGeneralShare)localObject1).getBytes());
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
      }
    }
    return;
    label251:
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject3 = null;
    Object localObject10 = null;
    Object localObject2 = null;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    String str1 = localAbsShareMsg.mSourceIcon;
    Object localObject4 = localAbsShareMsg.mMsgUrl;
    Object localObject9 = localAbsShareMsg.mMsgAction;
    Object localObject7 = localAbsShareMsg.mMsgActionData;
    Object localObject6 = localAbsShareMsg.mMsg_A_ActionData;
    Object localObject5 = localAbsShareMsg.mMsg_I_ActionData;
    Object localObject8 = localAbsShareMsg.mMsgBrief;
    long l = localAbsShareMsg.msgId;
    String str3 = localAbsShareMsg.uin;
    int i;
    if ((localAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)localAbsShareMsg;
      StructingMsgItemBuilder.h = StructMsgForGeneralShare.clickedItemIndex;
      if (StructingMsgItemBuilder.h != 0)
      {
        i = 0;
        if (i < localAbsShareMsg.getItemCount())
        {
          localObject1 = localAbsShareMsg.getItemByIndex(i);
          if ((TextUtils.isEmpty(((AbsStructMsgElement)localObject1).m)) || (Integer.valueOf(((AbsStructMsgElement)localObject1).m).intValue() != StructingMsgItemBuilder.h) || ((!(localObject1 instanceof StructMsgItemLayout4)) && (!(localObject1 instanceof StructMsgItemLayout5)))) {}
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (!(localObject1 instanceof AbsStructMsgItem)) {
          break label1685;
        }
        localObject1 = (AbsStructMsgItem)localObject1;
        localObject9 = ((AbsStructMsgItem)localObject1).a;
        localObject6 = ((AbsStructMsgItem)localObject1).c;
        localObject8 = ((AbsStructMsgItem)localObject1).b;
        localObject11 = ((AbsStructMsgItem)localObject1).d;
        localObject10 = ((AbsStructMsgItem)localObject1).e;
        localObject7 = ((AbsStructMsgItem)localObject1).f;
        localObject5 = ((AbsStructMsgItem)localObject1).g;
        i = 0;
        localObject1 = localObject12;
        label493:
        if (i < ((ArrayList)localObject9).size())
        {
          localObject4 = (AbsStructMsgElement)((ArrayList)localObject9).get(i);
          if ((localObject4 instanceof StructMsgItemTitle))
          {
            localObject4 = ((StructMsgItemTitle)localObject4).b();
            localObject1 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          for (;;)
          {
            i += 1;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject4;
            break label493;
            i += 1;
            break;
            if ((localObject4 instanceof StructMsgItemSummary))
            {
              localObject4 = ((StructMsgItemSummary)localObject4).b();
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
            else
            {
              if (!(localObject4 instanceof StructMsgItemCover)) {
                break label1672;
              }
              localObject4 = ((StructMsgItemCover)localObject4).o;
              localObject2 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject4;
            }
          }
        }
        localObject4 = localObject7;
        localObject7 = localObject2;
        localObject9 = localObject1;
        localObject2 = localObject11;
        localObject1 = localObject8;
        localObject8 = localObject3;
        localObject3 = localObject10;
      }
      for (;;)
      {
        localObject10 = localMessageForStructing.senderuin;
        localObject11 = Long.toString(localAbsShareMsg.msgId);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, (String)localObject10, (String)localObject1, (String)localObject11, "");
        if ((str1 == null) || ("".equals(str1)))
        {
          localObject10 = "http://url.cn/JS8oE7";
          label725:
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject9, (String)localObject8, (String)localObject7, str2, (String)localObject1, (String)localObject10, (String)localObject6, (String)localObject2, (String)localObject3, (String)localObject4, (String)localObject5, l, str3);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005455", "0X8005455", 0, 0, str3, "" + l, "" + StructingMsgItemBuilder.h, "android");
          return;
          i = 0;
          localObject1 = localObject13;
          localObject2 = localObject11;
          localObject3 = localObject10;
          label858:
          if (i >= localAbsShareMsg.getItemCount()) {
            break label1571;
          }
          localObject10 = localAbsShareMsg.getItemByIndex(i);
          if ((localObject10 instanceof AbsStructMsgItem))
          {
            localObject12 = (AbsStructMsgItem)localObject10;
            localObject11 = ((AbsStructMsgItem)localObject12).a;
            if ((((AbsStructMsgItem)localObject12).c == null) || ("".equals(((AbsStructMsgItem)localObject12).c)) || ((localObject9 != null) && (!"".equals(localObject9)))) {
              break label1568;
            }
            localObject9 = ((AbsStructMsgItem)localObject12).c;
            label944:
            localObject10 = localObject4;
            if (((AbsStructMsgItem)localObject12).b != null)
            {
              localObject10 = localObject4;
              if (!"".equals(((AbsStructMsgItem)localObject12).b)) {
                if (localObject4 != null)
                {
                  localObject10 = localObject4;
                  if (!"".equals(localObject4)) {}
                }
                else
                {
                  localObject10 = ((AbsStructMsgItem)localObject12).b;
                }
              }
            }
            if ((((AbsStructMsgItem)localObject12).d == null) || ("".equals(((AbsStructMsgItem)localObject12).d)) || ((localObject7 != null) && (!"".equals(localObject7)))) {
              break label1561;
            }
            localObject4 = ((AbsStructMsgItem)localObject12).d;
            label1046:
            if ((((AbsStructMsgItem)localObject12).e == null) || (!"".equals(((AbsStructMsgItem)localObject12).e)) || ((localObject6 != null) && (!"".equals(localObject6)))) {
              break label1558;
            }
            localObject6 = ((AbsStructMsgItem)localObject12).e;
            label1091:
            if ((((AbsStructMsgItem)localObject12).f == null) || (!"".equals(((AbsStructMsgItem)localObject12).f)) || ((localObject5 != null) && (!"".equals(localObject5)))) {
              break label1555;
            }
            localObject5 = ((AbsStructMsgItem)localObject12).f;
            label1136:
            if ((((AbsStructMsgItem)localObject12).g == null) || (!"".equals(((AbsStructMsgItem)localObject12).g)) || ((localObject8 != null) && (!"".equals(localObject8)))) {
              break label1548;
            }
            localObject7 = ((AbsStructMsgItem)localObject12).g;
            label1181:
            int j = 0;
            if (j >= ((ArrayList)localObject11).size()) {
              break label1631;
            }
            localObject8 = (AbsStructMsgElement)((ArrayList)localObject11).get(j);
            if (("title".equals(((AbsStructMsgElement)localObject8).a)) && (localObject1 == null))
            {
              if (!(localObject8 instanceof StructMsgItemTitle)) {
                break label1620;
              }
              localObject8 = ((StructMsgItemTitle)localObject8).b();
              localObject1 = localObject3;
              localObject3 = localObject8;
            }
            for (;;)
            {
              label1247:
              j += 1;
              localObject8 = localObject3;
              localObject3 = localObject1;
              localObject1 = localObject8;
              break;
              if (("summary".equals(((AbsStructMsgElement)localObject8).a)) && (localObject2 == null))
              {
                if (!(localObject8 instanceof StructMsgItemSummary)) {
                  break label1620;
                }
                localObject2 = ((StructMsgItemSummary)localObject8).b();
                localObject8 = localObject1;
                localObject1 = localObject3;
                localObject3 = localObject8;
              }
              else if (("picture".equals(((AbsStructMsgElement)localObject8).a)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof StructMsgItemCover)) {
                  break label1620;
                }
                localObject8 = ((StructMsgItemCover)localObject8).o;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else if (("pavideo".equals(((AbsStructMsgElement)localObject8).a)) && (localObject3 == null))
              {
                if (!(localObject8 instanceof StructMsgItemPAVideo)) {
                  break label1620;
                }
                localObject8 = ((StructMsgItemPAVideo)localObject8).p;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
              else
              {
                if ((!"paaudio".equals(((AbsStructMsgElement)localObject8).a)) || (localObject3 != null) || (!(localObject8 instanceof StructMsgItemPAAudio))) {
                  break label1620;
                }
                localObject8 = ((StructMsgItemPAAudio)localObject8).o;
                localObject3 = localObject1;
                localObject1 = localObject8;
              }
            }
          }
          localObject10 = localObject8;
          localObject8 = localObject9;
          localObject9 = localObject1;
          localObject1 = localObject7;
          localObject7 = localObject3;
          localObject11 = localObject5;
          localObject3 = localObject9;
          localObject5 = localObject2;
          localObject9 = localObject4;
          localObject2 = localObject8;
          localObject4 = localObject1;
          localObject8 = localObject11;
          localObject1 = localObject10;
        }
        for (;;)
        {
          i += 1;
          localObject10 = localObject9;
          localObject9 = localObject8;
          localObject8 = localObject3;
          localObject11 = localObject2;
          localObject12 = localObject1;
          localObject3 = localObject7;
          localObject2 = localObject5;
          localObject1 = localObject8;
          localObject8 = localObject12;
          localObject5 = localObject9;
          localObject7 = localObject4;
          localObject9 = localObject11;
          localObject4 = localObject10;
          break label858;
          localObject10 = str1;
          break label725;
          label1548:
          localObject7 = localObject8;
          break label1181;
          label1555:
          break label1136;
          label1558:
          break label1091;
          label1561:
          localObject4 = localObject7;
          break label1046;
          label1568:
          break label944;
          label1571:
          localObject12 = localObject6;
          localObject6 = localObject9;
          localObject9 = localObject3;
          localObject10 = localObject2;
          localObject11 = localObject1;
          localObject2 = localObject7;
          localObject1 = localObject4;
          localObject3 = localObject12;
          localObject4 = localObject5;
          localObject5 = localObject8;
          localObject7 = localObject9;
          localObject8 = localObject10;
          localObject9 = localObject11;
          break;
          label1620:
          localObject8 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject8;
          break label1247;
          label1631:
          localObject8 = localObject7;
          localObject7 = localObject10;
          localObject10 = localObject1;
          localObject11 = localObject2;
          localObject1 = localObject8;
          localObject8 = localObject5;
          localObject2 = localObject9;
          localObject9 = localObject7;
          localObject7 = localObject3;
          localObject5 = localObject11;
          localObject3 = localObject10;
        }
        label1672:
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        break;
        label1685:
        localObject3 = localObject6;
        localObject6 = localObject9;
        localObject11 = null;
        localObject10 = null;
        localObject9 = null;
        localObject2 = localObject7;
        localObject1 = localObject4;
        localObject4 = localObject5;
        localObject5 = localObject8;
        localObject7 = localObject11;
        localObject8 = localObject10;
      }
      localObject1 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
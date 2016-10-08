package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MixedImageOnclickListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import nmm;
import nmn;
import nmo;
import nmp;

public class MixedMsgItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback
{
  private static final String jdField_b_of_type_JavaLangString = MixedMsgItemBuilder.class.getSimpleName();
  public long a;
  protected View.OnClickListener a;
  private MixedImageOnclickListener jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener = new MixedImageOnclickListener();
  private AnimationTextView.OnDoubleClick jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = new nmn(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new nmm(this);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MixedMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nmo(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder, List paramList)
  {
    if (paramSpannableStringBuilder.length() > 0)
    {
      MessageRecord localMessageRecord = MessageRecordFactory.a(64536);
      ((MessageForText)localMessageRecord).sb = new SpannableStringBuilder(paramSpannableStringBuilder);
      paramSpannableStringBuilder.clear();
      paramList.add(localMessageRecord);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if ((AbsDownloader.a(paramURLDrawable.getURL().toString())) && (paramURLDrawable.getStatus() != 1)) {}
    try
    {
      paramURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout arg4, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ??? = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((paramViewHolder != null) && (paramViewHolder.b == null)) {
      paramViewHolder.b = new StringBuilder();
    }
    int i;
    int j;
    if (!jdField_b_of_type_Boolean)
    {
      if (MixedMsgItemBuilder.MixedHolder.a(???) != null)
      {
        i = 1;
        if (MixedMsgItemBuilder.MixedHolder.a(???) != paramChatMessage.uniseq) {
          break label89;
        }
      }
      label89:
      for (j = 1;; j = 0)
      {
        if (((j & i) == 0) || (!android.text.TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))) {
          break label95;
        }
        return paramView;
        i = 0;
        break;
      }
    }
    label95:
    Object localObject2;
    if ((paramChatMessage instanceof MessageForMixedMsg))
    {
      localObject1 = (MessageForMixedMsg)paramChatMessage;
      if ((jdField_b_of_type_Boolean) && (paramViewHolder != null))
      {
        if (!MsgUtils.a(paramChatMessage.issend)) {
          break label239;
        }
        paramViewHolder.b.append("发出");
      }
      for (;;)
      {
        synchronized (((MessageForMixedMsg)localObject1).elemListSyncLock)
        {
          localObject2 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ??? = (MessageRecord)((Iterator)localObject2).next();
          if (!(??? instanceof MessageForPic)) {
            break label252;
          }
          if (jdField_b_of_type_Boolean) {
            paramViewHolder.b.append("图片");
          }
          ??? = (MessageForPic)???;
          if (((MessageForPic)???).time != 0L) {
            continue;
          }
          MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)???, (MessageForMixedMsg)localObject1);
        }
        label239:
        paramViewHolder.b.append("发来");
        continue;
        label252:
        if (jdField_b_of_type_Boolean) {
          paramViewHolder.b.append(com.tencent.mobileqq.text.TextUtils.a(((MessageRecord)???).msg));
        }
      }
      ??? = a(paramViewHolder, (MixedMsgLinearLayout)paramView, ((MessageForMixedMsg)localObject1).msgElemList, paramOnLongClickAndTouchListener);
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
    }
    do
    {
      do
      {
        do
        {
          paramChatMessage = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramView = ???;
          if (paramChatMessage == null) {
            break;
          }
          paramChatMessage.a(???, this);
          return (View)???;
          ??? = paramView;
        } while (!(paramChatMessage instanceof MessageForLongMsg));
        ??? = (MessageForLongMsg)paramChatMessage;
        if (jdField_b_of_type_Boolean) {
          paramViewHolder.b.append("说");
        }
        localObject2 = new ArrayList();
        ??? = paramView;
      } while (((MessageForLongMsg)???).longMsgFragmentList == null);
      ??? = paramView;
    } while (((MessageForLongMsg)???).longMsgFragmentList.isEmpty());
    Object localObject1 = new SpannableStringBuilder();
    ??? = ((MessageForLongMsg)???).longMsgFragmentList.iterator();
    label424:
    MessageForMixedMsg localMessageForMixedMsg;
    while (???.hasNext())
    {
      ??? = (MessageRecord)???.next();
      if ((??? instanceof MessageForText))
      {
        if (((MessageForText)???).sb != null) {
          ((SpannableStringBuilder)localObject1).append(((MessageForText)???).sb);
        }
      }
      else if ((??? instanceof MessageForPic))
      {
        a((SpannableStringBuilder)localObject1, (List)localObject2);
        ((List)localObject2).add(???);
      }
      else if ((??? instanceof MessageForMixedMsg))
      {
        localMessageForMixedMsg = (MessageForMixedMsg)???;
      }
    }
    for (;;)
    {
      MessageRecord localMessageRecord;
      synchronized (localMessageForMixedMsg.elemListSyncLock)
      {
        j = localMessageForMixedMsg.msgElemList.size();
        i = 0;
        if (i >= j) {
          break label671;
        }
        localMessageRecord = (MessageRecord)localMessageForMixedMsg.msgElemList.get(i);
        if ((localMessageRecord instanceof MessageForPic))
        {
          if (((MessageForPic)localMessageRecord).time == 0L) {
            MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, localMessageForMixedMsg);
          }
          a((SpannableStringBuilder)localObject1, (List)localObject2);
          ((List)localObject2).add(localMessageRecord);
        }
        else if ((localMessageRecord instanceof MessageForText))
        {
          ((SpannableStringBuilder)localObject1).append(((MessageForText)localMessageRecord).sb);
        }
      }
      ((List)localObject2).add(localMessageRecord);
      break label742;
      label671:
      break label424;
      a((SpannableStringBuilder)localObject1, (List)localObject2);
      paramView = a(paramViewHolder, (MixedMsgLinearLayout)paramView, (List)localObject2, paramOnLongClickAndTouchListener);
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramChatMessage.uniseq);
      ??? = paramView;
      if (!jdField_b_of_type_Boolean) {
        break;
      }
      paramViewHolder.b.append(com.tencent.mobileqq.text.TextUtils.c(((SpannableStringBuilder)localObject1).toString()));
      ??? = paramView;
      break;
      label742:
      i += 1;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new MixedMsgItemBuilder.MixedHolder(this);
  }
  
  public MixedMsgLinearLayout a(BaseBubbleBuilder.ViewHolder paramViewHolder, MixedMsgLinearLayout paramMixedMsgLinearLayout, List paramList, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = paramMixedMsgLinearLayout;
    if (paramMixedMsgLinearLayout == null)
    {
      paramList = new MixedMsgLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramList.setId(2131296328);
      paramList.setOrientation(1);
      paramList.setFocusable(false);
      paramList.setClickable(true);
      paramList.setMinimumHeight(AIOUtils.a(44.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramList.setPadding(2131493040, 2131493038, 2131493041, 2131493039);
      paramMixedMsgLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
      paramMixedMsgLinearLayout.addRule(1, 2131296790);
      paramMixedMsgLinearLayout.addRule(3, 2131297586);
      paramMixedMsgLinearLayout.leftMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramMixedMsgLinearLayout.rightMargin = AIOUtils.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramList.setLayoutParams(paramMixedMsgLinearLayout);
      paramList.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
      MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)paramViewHolder, paramList);
    }
    paramList.a(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = (MessageRecord)localArrayList.get(i);
      paramViewHolder = paramList.getChildAt(i);
      if (paramViewHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_b_of_type_JavaLangString, 2, "getMixedMsgLayout,child is null. size = " + j + ",i = " + i);
        }
        i += 1;
      }
      else
      {
        Object localObject2;
        Object localObject3;
        if ((localObject1 instanceof MessageForReplyText)) {
          if ((paramViewHolder instanceof LinearLayout))
          {
            localObject2 = (LinearLayout)paramViewHolder;
            paramMixedMsgLinearLayout = (TextView)((LinearLayout)localObject2).getChildAt(0);
            localObject2 = (TextView)((LinearLayout)localObject2).getChildAt(1);
            localObject1 = (MessageForReplyText)localObject1;
            if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(((MessageForReplyText)localObject1).senderuin)) && (((MessageForReplyText)localObject1).mSourceMsgInfo.mLocalAtInfoDone == 0))
            {
              ((MessageForReplyText)localObject1).mSourceMsgInfo.mLocalAtInfoDone = 1;
              if ((((MessageForReplyText)localObject1).atInfoList != null) && (((MessageForReplyText)localObject1).atInfoList.size() > 0))
              {
                localObject3 = (MessageForText.AtTroopMemberInfo)((MessageForReplyText)localObject1).atInfoList.remove(0);
                if (((MessageForReplyText)localObject1).msg.length() > ((MessageForText.AtTroopMemberInfo)localObject3).textLen + 1)
                {
                  ((MessageForReplyText)localObject1).msg = ((MessageForReplyText)localObject1).msg.substring(((MessageForText.AtTroopMemberInfo)localObject3).textLen + 1);
                  ((MessageForReplyText)localObject1).sb = new QQText(((MessageForReplyText)localObject1).msg, 13, 32, (MessageRecord)localObject1);
                }
              }
            }
            paramMixedMsgLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            if (!android.text.TextUtils.isEmpty(((MessageForReplyText)localObject1).sb))
            {
              ((TextView)localObject2).setText(((MessageForReplyText)localObject1).sb);
              ((TextView)localObject2).setVisibility(0);
              label487:
              ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMixedMsgLinearLayout, ((MessageForReplyText)localObject1).mSourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioMixedImageOnclickListener.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForReplyText)localObject1).istroop, ((MessageForReplyText)localObject1).uniseq);
            }
          }
          else
          {
            label524:
            paramMixedMsgLinearLayout = (LinearLayout.LayoutParams)paramViewHolder.getLayoutParams();
            paramMixedMsgLinearLayout.topMargin = BaseChatItemLayout.p;
            if (i != j - 1) {
              break label952;
            }
          }
        }
        label952:
        for (paramMixedMsgLinearLayout.bottomMargin = BaseChatItemLayout.p;; paramMixedMsgLinearLayout.bottomMargin = 0)
        {
          paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
          break;
          ((TextView)localObject2).setVisibility(8);
          break label487;
          if ((localObject1 instanceof MessageForText))
          {
            paramMixedMsgLinearLayout = (AnimationTextView)paramViewHolder;
            paramMixedMsgLinearLayout.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
            if (android.text.TextUtils.isEmpty(((MessageForText)localObject1).sb2))
            {
              paramMixedMsgLinearLayout.setText(((MessageForText)localObject1).sb);
              break label524;
            }
            paramMixedMsgLinearLayout.setText(((MessageForText)localObject1).sb2);
            break label524;
          }
          if ((localObject1 instanceof MessageForPic))
          {
            paramMixedMsgLinearLayout = (MessageForPic)localObject1;
            localObject1 = (ChatThumbView)paramViewHolder;
            localObject2 = new int[2];
            tmp677_675 = localObject2;
            tmp677_675[0] = 0;
            tmp681_677 = tmp677_675;
            tmp681_677[1] = 0;
            tmp681_677;
            localObject3 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramMixedMsgLinearLayout, (ChatThumbView)localObject1, (int[])localObject2);
            ((ChatThumbView)localObject1).setTag(2131296342, paramMixedMsgLinearLayout);
            ((ChatThumbView)localObject1).setImageDrawable((Drawable)localObject3);
            String str = ((URLDrawable)localObject3).getURL().getProtocol();
            URL localURL = URLDrawableHelper.a(paramMixedMsgLinearLayout, 65537);
            AbsDownloader.d(localURL.toString());
            if (PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(paramMixedMsgLinearLayout.imageType), str.equals("chatthumb"), localObject2[0], localObject2[1], localURL))
            {
              ((URLDrawable)localObject3).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
              ((URLDrawable)localObject3).setWatermarkVisibility(0);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(jdField_b_of_type_JavaLangString, 2, "getMixedMsgLayout,set picmsg, picDrawable " + localObject3 + ",picMsg = " + paramMixedMsgLinearLayout);
              }
              ((ChatThumbView)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
              a((URLDrawable)localObject3);
              if (paramMixedMsgLinearLayout.isSendFromLocal()) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMixedMsgLinearLayout, 2);
              break;
              ((URLDrawable)localObject3).setWatermarkVisibility(4);
            }
          }
          if (!QLog.isColorLevel()) {
            break label524;
          }
          QLog.e(jdField_b_of_type_JavaLangString, 2, "mixed type not support yet." + localObject1.getClass().getSimpleName());
          break label524;
        }
      }
    }
    paramList.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramList.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramList.b = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick;
    return paramList;
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return "";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131305411: 
      super.b(paramChatMessage);
      return;
    case 2131305407: 
      ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage));
      return;
    case 2131297425: 
      CharSequence localCharSequence = MessageForMixedMsg.getTextFromMixedMsg(paramChatMessage);
      paramContext = new Bundle();
      Object localObject = SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
      paramInt = i;
      if (localObject != null)
      {
        paramInt = i;
        if (((String)localObject).length() > 0)
        {
          localObject = ((String)localObject).split("\\|");
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (localObject.length <= 0) {}
          }
        }
      }
      for (;;)
      {
        try
        {
          paramInt = Integer.parseInt(localObject[0]);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "get mixMsgForward switch From config : configSwitch = " + paramInt);
          }
          if (paramInt != 1) {
            continue;
          }
          paramInt = i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          paramInt = i;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_b_of_type_JavaLangString, 2, "get mixMsgForward switch from config error", localNumberFormatException);
          paramInt = i;
          continue;
          paramContext.putInt("forward_type", -1);
          continue;
        }
        if (paramInt == 0) {
          continue;
        }
        paramContext.putInt("forward_type", -5);
        paramContext.putLong("FORWARD_MSG_UNISEQ", paramChatMessage.uniseq);
        ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173)).a.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
        paramContext.putString("forward_text", localCharSequence.toString());
        paramChatMessage = new Intent();
        paramChatMessage.putExtras(paramContext);
        ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005637", "0X8005637", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
        return;
        paramInt = 0;
      }
    case 2131299841: 
      QfavBuilder.b(paramChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      QfavReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 8);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    paramView = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
    if ((paramView.a instanceof MessageForMixedMsg))
    {
      paramView = (MessageForMixedMsg)paramView.a;
      if (paramView.isSendFromLocal())
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        localActionSheet.a(2131367889, 5);
        localActionSheet.d(2131367262);
        localActionSheet.a(new nmp(this, paramView, localActionSheet));
        localActionSheet.show();
      }
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2003) {}
    label68:
    label153:
    label232:
    label424:
    label478:
    label567:
    label577:
    label579:
    label585:
    label593:
    for (;;)
    {
      return;
      Object localObject1 = (MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView);
      paramView = null;
      Object localObject2;
      if ((((MixedMsgItemBuilder.MixedHolder)localObject1).a instanceof MessageForMixedMsg))
      {
        paramView = (MessageForMixedMsg)((MixedMsgItemBuilder.MixedHolder)localObject1).a;
        if ((MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1) != null) && (paramView != null) && (paramView.msgElemList != null)) {
          for (paramView = paramView.msgElemList.iterator(); paramView.hasNext(); paramView = (MessageForPic)localObject2)
          {
            localObject2 = (MessageRecord)paramView.next();
            if ((localObject2 == null) || (((MessageRecord)localObject2).uniseq != paramFileMsg.c) || (!(localObject2 instanceof MessageForPic)) || (((MessageForPic)localObject2).subMsgId != paramFileMsg.d)) {
              break label68;
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null) {
            break label593;
          }
          paramInt2 = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildCount();
          paramInt1 = 0;
          Object localObject3;
          Object localObject4;
          if (paramInt1 < paramInt2)
          {
            paramFileMsg = MixedMsgItemBuilder.MixedHolder.a((MixedMsgItemBuilder.MixedHolder)localObject1).getChildAt(paramInt1);
            if ((paramFileMsg instanceof ChatThumbView))
            {
              localObject2 = ((ChatThumbView)paramFileMsg).getTag(2131296342);
              if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).uniseq == paramView.uniseq) && (((MessageForPic)localObject2).subMsgId == paramView.subMsgId))
              {
                paramFileMsg = (ChatThumbView)paramFileMsg;
                if (paramFileMsg == null) {
                  break label577;
                }
                localObject1 = new int[2];
                tmp243_241 = localObject1;
                tmp243_241[0] = 0;
                tmp247_243 = tmp243_241;
                tmp247_243[1] = 0;
                tmp247_243;
                localObject2 = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramFileMsg, (int[])localObject1);
                localObject3 = ((URLDrawable)localObject2).getURL().getProtocol();
                localObject4 = URLDrawableHelper.a(paramView, 65537);
                boolean bool = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, PeakUtils.a(paramView.imageType), ((String)localObject3).equals("chatthumb"), localObject1[0], localObject1[1], (URL)localObject4);
                paramFileMsg.setImageDrawable((Drawable)localObject2);
                if (!bool) {
                  break label567;
                }
                ((URLDrawable)localObject2).setWatermarkDrawable(PicItemBuilder.a(), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                ((URLDrawable)localObject2).setWatermarkVisibility(0);
                return;
                if (!(((MixedMsgItemBuilder.MixedHolder)localObject1).a instanceof MessageForLongMsg)) {
                  break label585;
                }
                localObject2 = (MessageForLongMsg)((MixedMsgItemBuilder.MixedHolder)localObject1).a;
                if ((((MessageForLongMsg)localObject2).longMsgFragmentList == null) || (((MessageForLongMsg)localObject2).longMsgFragmentList.isEmpty())) {
                  break label585;
                }
                localObject2 = ((MessageForLongMsg)localObject2).longMsgFragmentList.iterator();
                do
                {
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  localObject3 = (MessageRecord)((Iterator)localObject2).next();
                } while (localObject3 == null);
                if (((MessageRecord)localObject3).uniseq != paramFileMsg.c) {
                  break label579;
                }
                if ((localObject3 instanceof MessageForPic)) {
                  paramView = (MessageForPic)localObject3;
                }
              }
            }
          }
          for (;;)
          {
            break label424;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = ((MessageForMixedMsg)localObject3).msgElemList.iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (MessageRecord)((Iterator)localObject3).next();
                  if (((localObject4 instanceof MessageForPic)) && (((MessageForPic)localObject4).subMsgId == paramFileMsg.d))
                  {
                    paramView = (MessageForPic)localObject4;
                    break label478;
                    paramInt1 += 1;
                    break label153;
                    ((URLDrawable)localObject2).setWatermarkVisibility(4);
                    return;
                    paramFileMsg = null;
                    break label232;
                    break;
                  }
                }
              }
            }
          }
          continue;
          paramView = null;
          continue;
          paramView = null;
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    MixedMsgItemBuilder.MixedHolder localMixedHolder = (MixedMsgItemBuilder.MixedHolder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        if (!paramChatMessage.isSend()) {
          break label79;
        }
      }
      label79:
      for (paramView = paramView.getColorStateList(2131428274);; paramView = paramView.getColorStateList(2131428273))
      {
        MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    paramViewHolder = ColorStateList.valueOf(-16777216);
    paramView = paramView.getResources().getColorStateList(2131428273);
    if (paramBubbleInfo.d != 0) {
      paramViewHolder = ColorStateList.valueOf(paramBubbleInfo.d);
    }
    if (paramBubbleInfo.e != 0) {
      paramView = ColorStateList.valueOf(paramBubbleInfo.e);
    }
    MixedMsgItemBuilder.MixedHolder.a(localMixedHolder).a(paramViewHolder, paramView);
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!paramChatMessage.isSendFromLocal()) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if (paramChatMessage.extraflag != 32772) {
          break;
        }
        bool1 = bool2;
      } while (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramChatMessage));
      bool1 = bool2;
    } while (paramChatMessage.extraflag == 32768);
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = ((MixedMsgItemBuilder.MixedHolder)AIOUtils.a(paramView)).a;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131367273));
    localQQCustomMenu.a(2131305407, this.jdField_a_of_type_AndroidContentContext.getString(2131367995));
    localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
    a(paramView, localQQCustomMenu);
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\MixedMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
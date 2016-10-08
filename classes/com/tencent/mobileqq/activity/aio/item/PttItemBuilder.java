package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.stt.SttManager.ISttListener;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.XListView;
import cooperation.qqfav.QfavUtil;
import cooperation.qqfav.widget.QfavMicroPhoneDialog;
import java.io.File;
import mqq.manager.ServerConfigManager.ConfigType;
import nng;
import nnh;

public class PttItemBuilder
  extends BaseBubbleBuilder
  implements FileTransferManager.Callback, MediaPlayerManager.Callback, SttManager.ISttListener
{
  public static final String b = "ConvertText_MaxPtt";
  public static final String c = "Normal_MaxPtt";
  public static final String d = "VIP_MaxPtt";
  private static final boolean d = AppSetting.j;
  public static final String e = "SVIP_MaxPtt";
  private static final String f = "PttItemBuilder";
  private static final String g = "param_FailCode";
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 4;
  public static final int k = 1;
  public static final int l = 2;
  private static final int m = 20;
  private static final int n = 1;
  private static final int o = 2;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SttManager jdField_a_of_type_ComTencentMobileqqSttSttManager;
  private SpannableString b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PttItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager = ((SttManager)paramQQAppInterface.getManager(16));
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public static int a(Context paramContext, int paramInt1, String paramString, Paint paramPaint, int paramInt2)
  {
    int i1 = Math.min(60, Math.max(1, paramInt1));
    int i2;
    float f1;
    if (i1 > 40)
    {
      i1 += 40;
      i2 = AIOUtils.a(i1 + 20, paramContext.getResources());
      if ((paramString == null) || (paramPaint == null)) {
        break label173;
      }
      i1 = BaseChatItemLayout.i - BaseChatItemLayout.m - BaseChatItemLayout.n - 32;
      f1 = paramPaint.measureText(paramString) + paramInt2;
      if (f1 <= i1) {
        break label176;
      }
      f1 = i1;
    }
    label173:
    label176:
    for (;;)
    {
      float f2;
      if (paramInt1 > 99)
      {
        f2 = 38.0F;
        int i3 = AIOUtils.a(f2, paramContext.getResources());
        paramInt2 = i2 + i3;
        paramInt1 = paramInt2;
        if (paramInt2 > i1) {
          paramInt1 = i1;
        }
        return Math.max(paramInt1, (int)f1) - i3;
        i1 *= 2;
        break;
      }
      if (paramInt1 > 9) {}
      for (paramInt1 = 34;; paramInt1 = 30)
      {
        f2 = paramInt1;
        break;
      }
      return i2;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt)
  {
    int i2 = 999;
    int i3 = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    int i1;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.bh))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i1 = 1003;
        }
      }
    }
    for (;;)
    {
      return i1;
      i1 = i3;
      if (paramMessageForPtt.fileSize != -1L) {
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt))
          {
            i1 = 999;
          }
          else
          {
            paramMessageForPtt.fileSize = -1L;
            i1 = i3;
          }
        }
        else
        {
          if (paramMessageForPtt.fileSize == -3L)
          {
            i3 = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
            if ((i3 == 1005) || (i3 == -1))
            {
              paramMessageForPtt.fileSize = -1L;
              i1 = 1005;
            }
            for (;;)
            {
              break;
              i1 = i2;
              if (i3 != 7000) {
                i1 = 1001;
              }
            }
          }
          i1 = paramQQAppInterface.a().b(paramMessageForPtt.frienduin, paramMessageForPtt.getLocalFilePath(), paramMessageForPtt.uniseq);
          continue;
          i1 = 1004;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PttItemBuilder", 2, "handlePttItem recieve friendUin " + paramMessageForPtt.frienduin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            i2 = PTTPreDownloader.a(paramQQAppInterface, paramMessageForPtt);
            i1 = i2;
            if (QLog.isColorLevel())
            {
              QLog.d("PttItemBuilder", 2, "handlePttItem recieve status " + i2 + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
              i1 = i2;
            }
          }
          else
          {
            i1 = 0;
          }
        }
      }
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i2 = 120;
    paramQQAppInterface = paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "key = " + paramString + ", time = " + paramQQAppInterface);
    }
    if (paramQQAppInterface != null) {}
    do
    {
      do
      {
        do
        {
          try
          {
            i1 = Integer.valueOf(paramQQAppInterface).intValue();
            if (i1 > 0) {
              return i1;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PttItemBuilder", 2, paramQQAppInterface.toString());
            }
          }
          i1 = i2;
        } while ("ConvertText_MaxPtt".equals(paramString));
        i1 = i2;
      } while ("Normal_MaxPtt".equals(paramString));
      if ("VIP_MaxPtt".equals(paramString)) {
        return 180;
      }
      int i1 = i2;
    } while (!"SVIP_MaxPtt".equals(paramString));
    return 300;
  }
  
  public static String a(int paramInt)
  {
    String str = "";
    int i1 = paramInt / 60;
    if (i1 > 0) {
      str = i1 + "'";
    }
    return str + paramInt % 60 + "\"";
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  protected static boolean a(MessageForPtt paramMessageForPtt)
  {
    String str = QQRecorder.a();
    return (paramMessageForPtt.fileSize == -2L) && (!TextUtils.isEmpty(str)) && (str.equals(paramMessageForPtt.getLocalFilePath()));
  }
  
  private boolean d(ChatMessage paramChatMessage)
  {
    return paramChatMessage.vipBubbleID >= 1L;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = b(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this);
    if (d) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setOnClickListener(this);
    }
    return paramChatMessage;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PttItemBuilder.Holder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出语音按钮";
    }
    return "发来语音按钮";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForPtt))) {}
    MessageForPtt localMessageForPtt;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localMessageForPtt = (MessageForPtt)paramChatMessage;
            if (2131299841 != paramInt) {
              break;
            }
            paramInt = QQRecorder.a(localMessageForPtt);
          } while (paramInt <= 0);
          paramContext = new QfavMicroPhoneDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt.voiceType, new nng(this, localMessageForPtt));
          if (paramContext.a(localMessageForPtt.getLocalFilePath(), paramInt)) {
            paramContext.show();
          }
          for (;;)
          {
            PttInfoCollector.a(1);
            return;
            QfavUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131365903, 1);
          }
          if (paramInt == 2131305401)
          {
            ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            PttInfoCollector.a(2);
            return;
          }
          if (paramInt == 2131305411)
          {
            PttInfoCollector.a(6);
            super.b(paramChatMessage);
            return;
          }
          if (paramInt == 2131305407)
          {
            if (TextUtils.isEmpty(localMessageForPtt.sttText)) {}
            for (paramContext = this.jdField_a_of_type_AndroidContentContext.getString(2131368058);; paramContext = localMessageForPtt.sttText)
            {
              PttInfoCollector.a(3);
              try
              {
                if (Build.VERSION.SDK_INT >= 11) {
                  break;
                }
                ((android.text.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramContext);
                return;
              }
              catch (Exception paramContext)
              {
                return;
              }
            }
            ((android.content.ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", paramContext));
            return;
          }
          if (paramInt == 2131297425)
          {
            PttInfoCollector.a(4);
            if ((localMessageForPtt.sttText != null) && (localMessageForPtt.sttText.length() > 0))
            {
              paramContext = new Bundle();
              paramContext.putInt("forward_type", -1);
              paramContext.putString("forward_text", localMessageForPtt.sttText);
              paramChatMessage = new Intent();
              paramChatMessage.putExtras(paramContext);
              ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
              return;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, "语音消息无文本内容", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            return;
          }
          if (paramInt != 2131305408) {
            break;
          }
          paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(localMessageForPtt);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.delmsg", 2, "pos is:" + paramInt);
          }
        } while (paramInt < 0);
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.s();
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt - i1);
      } while (paramContext == null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B40", "0X8005B40", 0, 0, "", "", "", "");
      paramContext = (PttItemBuilder.Holder)paramContext.getTag();
      PttInfoCollector.a(5);
      if (localMessageForPtt.sttAbility == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(localMessageForPtt);
        this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(this);
        a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
        return;
      }
    } while ((localMessageForPtt.sttAbility != 2) || (localMessageForPtt.expandStt));
    localMessageForPtt.expandStt = true;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(paramContext, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
    a(paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForPtt, paramContext.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
    return;
    if (paramInt == 2131296353)
    {
      if (c(localMessageForPtt)) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
      }
      super.a(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.a(2131367890);
      paramView.c(2131367889);
      paramView.d(2131367262);
      paramView.a(new nnh(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131367686, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131367687, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131492908));
      return;
    }
    a(paramView, localMessageForPtt, true);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if ((paramFileMsg.e != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localMessageForPtt = (MessageForPtt)AIOUtils.a(paramView);
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramFileMsg.c));
    paramView = (PttItemBuilder.Holder)AIOUtils.a(paramView);
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramFileMsg.b)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          a();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, c(localMessageForPtt));
      return;
      if ((paramFileMsg.Z == 1005) || (paramFileMsg.Z == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PttItemBuilder.Holder localHolder = (PttItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramViewHolder.getColorStateList(2131428275);
        if ((localHolder.jdField_a_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if ((localHolder.jdField_b_of_type_AndroidWidgetTextView != null) && (paramViewHolder != null)) {
          localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
      }
    }
    label135:
    do
    {
      do
      {
        return;
        paramViewHolder = paramViewHolder.getColorStateList(2131428272);
        break;
        if (paramBubbleInfo.d != 0) {
          break label135;
        }
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
      localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.d);
    } while (localHolder.jdField_b_of_type_AndroidWidgetTextView == null);
    localHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.d);
  }
  
  public void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    int i3 = 0;
    int i1 = 0;
    localObject1 = "";
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    if (paramHolder.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramHolder.c.setVisibility(8);
    }
    if (paramHolder.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
      paramHolder.d.setVisibility(8);
      paramHolder.e.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i2;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      i2 = 1;
      switch (paramInt)
      {
      default: 
        paramInt = i1;
        localObject2 = localObject3;
        label395:
        i1 = paramInt;
        if (paramMessageForPtt.sttAbility == 1)
        {
          i1 = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramMessageForPtt)) {
            i1 = 4;
          }
        }
        switch (i1)
        {
        case 2: 
        case 3: 
        default: 
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null) {
            paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      if (d)
      {
        paramHolder.jdField_a_of_type_AndroidViewViewGroup.setContentDescription("语音" + (String)localObject1 + "秒");
        if (paramHolder.jdField_a_of_type_JavaLangStringBuilder != null)
        {
          paramHolder.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
          if (localObject2 != null) {
            paramHolder.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
          }
        }
      }
      return;
      i2 = 0;
      break;
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, localResources), BaseChatItemLayout.p, AIOUtils.a(10.0F, localResources), BaseChatItemLayout.q);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      if (d(paramMessageForPtt))
      {
        localObject1 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
        if (i2 != 0) {}
        for (paramInt = 2130841651;; paramInt = 2130841658)
        {
          ((ImageView)localObject1).setImageResource(paramInt);
          paramInt = 1;
          localObject1 = "";
          break;
        }
      }
      localObject1 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (i2 != 0) {}
      for (paramInt = 2130843048;; paramInt = 2130843047)
      {
        ((ImageView)localObject1).setImageResource(paramInt);
        paramInt = 1;
        localObject1 = "";
        break;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(40.0F, localResources), BaseChatItemLayout.p, AIOUtils.a(40.0F, localResources), BaseChatItemLayout.q);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      paramInt = 0;
      localObject1 = "";
      break label395;
      if (QLog.isColorLevel()) {
        QLog.d("PttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "get a amr file length = 0 return now");
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(10.0F, localResources), BaseChatItemLayout.p, AIOUtils.a(10.0F, localResources), BaseChatItemLayout.q);
        return;
      }
      localObject1 = localObject4;
      label1035:
      label1143:
      label1161:
      label1278:
      int i4;
      int i5;
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt"))
      {
        if (paramMessageForPtt.longPttVipFlag == 1)
        {
          if (this.jdField_a_of_type_AndroidTextSpannableString == null)
          {
            this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
            localObject1 = localResources.getDrawable(2130838752);
            ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
            localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
            this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
          }
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
          localObject1 = "QQ会员专享长语音";
        }
      }
      else
      {
        if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
          paramMessageForPtt.sttAbility = 0;
        }
        if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
          paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
        }
        localObject3 = paramMessageForPtt.timeStr;
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
        paramHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        if (!paramMessageForPtt.isSend()) {
          break label1593;
        }
        if (!paramBoolean) {
          break label1517;
        }
        if (i2 == 0) {
          break label1501;
        }
        i1 = 2130968659;
        if (d(paramMessageForPtt))
        {
          if (i2 == 0) {
            break label1509;
          }
          i1 = 2130968766;
        }
        localObject2 = (AnimationDrawable)localResources.getDrawable(i1);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
        ((AnimationDrawable)localObject2).start();
        i2 = 1;
        if ((paramInt != 2003) && (paramInt != 1003)) {
          break label1747;
        }
        if ((!paramMessageForPtt.isSend()) && (!paramMessageForPtt.isReadPtt)) {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
        i1 = i2;
        paramInt = i3;
        if (paramMessageForPtt.sttAbility == 2)
        {
          i1 = i2;
          paramInt = i3;
          if (paramMessageForPtt.voiceChangeFlag != 1)
          {
            i1 = i2;
            paramInt = i3;
            if (paramMessageForPtt.expandStt)
            {
              i1 = 2;
              paramInt = i3;
            }
          }
        }
        i2 = AIOUtils.a(9.0F, localResources);
        i3 = AIOUtils.a(12.0F, localResources);
        i4 = localResources.getDrawable(2130840540).getIntrinsicHeight();
        i5 = AIOUtils.a(1.0F, localResources);
        if (i1 != 1) {
          break label1812;
        }
        i1 = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
        if (!paramMessageForPtt.isSend()) {
          break label1779;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i2, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.p, BaseChatItemLayout.u, BaseChatItemLayout.q);
      }
      for (;;)
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject1 = localObject4;
        if (paramMessageForPtt.longPttVipFlag != 2) {
          break label1035;
        }
        if (this.b == null)
        {
          this.b = new SpannableString("[v] 超级会员专享长语音");
          localObject1 = localResources.getDrawable(2130838751);
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
          localObject1 = new OffsetableImageSpan((Drawable)localObject1, 1).a(-0.05F);
          this.b.setSpan(localObject1, 0, 3, 17);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
        localObject1 = "超级会员专享长语音";
        break label1035;
        label1501:
        i1 = 2130968658;
        break label1143;
        label1509:
        i1 = 2130968765;
        break label1161;
        label1517:
        if (d(paramMessageForPtt))
        {
          localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
          if (i2 != 0) {}
          for (i1 = 2130841657;; i1 = 2130841659)
          {
            ((ImageView)localObject2).setImageResource(i1);
            break;
          }
        }
        localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
        if (i2 != 0) {}
        for (i1 = 2130843054;; i1 = 2130843055)
        {
          ((ImageView)localObject2).setImageResource(i1);
          break;
        }
        label1593:
        if (paramBoolean)
        {
          if (i2 != 0)
          {
            i1 = 2130968817;
            label1608:
            if (d(paramMessageForPtt)) {
              if (i2 == 0) {
                break label1663;
              }
            }
          }
          label1663:
          for (i1 = 2130968764;; i1 = 2130968763)
          {
            localObject2 = (AnimationDrawable)localResources.getDrawable(i1);
            paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
            ((AnimationDrawable)localObject2).start();
            break;
            i1 = 2130968816;
            break label1608;
          }
        }
        if (d(paramMessageForPtt))
        {
          localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
          if (i2 != 0) {}
          for (i1 = 2130841651;; i1 = 2130841658)
          {
            ((ImageView)localObject2).setImageResource(i1);
            break;
          }
        }
        localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
        if (i2 != 0) {}
        for (i1 = 2130843048;; i1 = 2130843047)
        {
          ((ImageView)localObject2).setImageResource(i1);
          break;
        }
        label1747:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          paramInt = 1;
          i1 = i2;
          break label1278;
        }
        paramInt = 4;
        i1 = i2;
        break label1278;
        label1779:
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.u, BaseChatItemLayout.p, i1, BaseChatItemLayout.q);
      }
      label1812:
      if (paramHolder.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        localObject4 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject4).setImageDrawable(new ColorDrawable(838860800));
        RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i5);
        ((ImageView)localObject4).setLayoutParams(localLayoutParams1);
        ((ImageView)localObject4).setId(2131296424);
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        if (paramMessageForPtt.isSend())
        {
          localObject2 = localResources.getColorStateList(2131428275);
          label1904:
          if (localObject2 != null) {
            localTextView.setTextColor((ColorStateList)localObject2);
          }
          localTextView.setId(2131296423);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
          localImageView.setLayoutParams(localLayoutParams2);
          localImageView.setImageResource(2130840540);
          localImageView.setScaleType(ImageView.ScaleType.FIT_END);
          localLayoutParams1.addRule(3, 2131296420);
          localLayoutParams1.addRule(14);
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131296424);
          localLayoutParams2.addRule(3, 2131296424);
          localLayoutParams2.addRule(14);
          localLayoutParams2.addRule(6, 2131296423);
          localLayoutParams2.addRule(8, 2131296423);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject4);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
          paramHolder.d = ((ImageView)localObject4);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView = localTextView;
          paramHolder.e = localImageView;
          label2099:
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnTouchListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
          localObject4 = paramMessageForPtt.sttText;
          localObject2 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368058);
          }
          if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
            this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          i1 = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject2, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
          i4 = AIOUtils.a(22.0F, localResources) + i4;
          if (!paramMessageForPtt.isSend()) {
            break label2479;
          }
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296420);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296420);
          localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296420);
          ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296420);
          paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, i2, 0);
          paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(i1, BaseChatItemLayout.p, BaseChatItemLayout.u, BaseChatItemLayout.q);
          paramHolder.d.setPadding(i2, 0, i2, 0);
          paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i2, BaseChatItemLayout.p, i2, i4);
          paramHolder.e.setPadding(0, 0, 0, i3);
        }
      }
      for (;;)
      {
        localObject4 = paramMessageForPtt.sttText;
        localObject2 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131368058);
        }
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        localObject2 = localResources.getColorStateList(2131428272);
        break label1904;
        paramHolder.d.setVisibility(0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramHolder.e.setVisibility(0);
        break label2099;
        label2479:
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296420);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296420);
        localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296420);
        ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296420);
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i2, 0, 0, 0);
        paramHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.u, BaseChatItemLayout.p, i1, BaseChatItemLayout.q);
        paramHolder.d.setPadding(i2, 0, i2, 0);
        paramHolder.jdField_b_of_type_AndroidWidgetTextView.setPadding(i2, BaseChatItemLayout.p, i2, i4);
        paramHolder.e.setPadding(0, 0, 0, i3);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      localObject3 = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = "重新发送语音消息";; paramMessageForPtt = "重新拉取语音消息")
      {
        ((ImageView)localObject3).setContentDescription(paramMessageForPtt);
        break;
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130838325, null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      ((Animatable)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
  }
  
  protected void a(PttItemBuilder.Holder paramHolder, MessageForPtt paramMessageForPtt, boolean paramBoolean)
  {
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      if (paramBoolean) {
        i1 = 2;
      }
    }
    for (int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f;; i2 = 0)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForPtt, false, i1, i2);
      return;
      i1 = 1;
      break;
      i1 = 5;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    if (paramView != null)
    {
      paramXListView = AIOUtils.a(paramView);
      if ((paramXListView instanceof PttItemBuilder.Holder))
      {
        paramXListView = (PttItemBuilder.Holder)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView), false);
        b();
      }
    }
  }
  
  public void a(boolean paramBoolean, MessageForPtt paramMessageForPtt)
  {
    if (!paramBoolean) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, "转文字失败，请稍候重试", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
    }
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = AIOUtils.a(paramView);
      if (!(paramView instanceof PttItemBuilder.Holder))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "play failed not Holder " + paramXListView.getLocalFilePath());
        }
        return false;
      }
      paramView = (PttItemBuilder.Holder)paramView;
      if (paramAudioPlayer.a(paramXListView.getLocalFilePath()))
      {
        a(paramXListView);
        if (paramView != null)
        {
          a(paramView, paramXListView, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView), true);
          a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout, paramXListView, paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo, 0);
        }
        PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label189;
          }
          paramInt = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        PttInfoCollector.a(paramXListView, paramInt, bool, 1);
        return true;
        label189:
        if (paramXListView.istroop == 1)
        {
          paramInt = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label297;
        }
        paramInt = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttItemBuilder", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label297:
      paramInt = 4;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (MessageForPtt)AIOUtils.a(paramView);
    if (!paramView.isReady())
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
    if (QQRecorder.a(paramView) <= 0)
    {
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
    }
    if (paramView.voiceChangeFlag != 1)
    {
      if (paramView.sttAbility != 1) {
        break label283;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(paramView)) && ((!paramView.isSend()) || ((paramView.extraflag != 32768) && (paramView.extraflag != 32768)))) {
        localQQCustomMenu.a(2131305408, this.jdField_a_of_type_AndroidContentContext.getString(2131372241));
      }
    }
    for (;;)
    {
      a(paramView, localQQCustomMenu);
      localQQCustomMenu.a(this.jdField_a_of_type_AndroidContentContext.getString(2131367270));
      localQQCustomMenu.a(2131299841, this.jdField_a_of_type_AndroidContentContext.getString(2131365886));
      if ((paramView.isSend()) && (paramView.extraflag != 32768) && (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView) == 1003) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
      return localQQCustomMenu.a();
      label283:
      if (paramView.sttAbility == 2) {
        if (paramView.expandStt)
        {
          localQQCustomMenu.a(2131305407, this.jdField_a_of_type_AndroidContentContext.getString(2131367996));
          localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131367997));
        }
        else
        {
          localQQCustomMenu.a(2131305408, this.jdField_a_of_type_AndroidContentContext.getString(2131372241));
        }
      }
    }
  }
  
  protected View b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (PttItemBuilder.Holder)paramViewHolder;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131296419);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131296418);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131428272));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131296420);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramViewHolder.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramViewHolder;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131296418);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int i2 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt);
      int i1 = i2;
      if (i2 == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt, false);
        i1 = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i1 + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i1, c(localMessageForPtt));
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localMessageForPtt);
      PttInfoCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1, paramChatMessage);
      return paramViewHolder;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131296419);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  public void c()
  {
    PttInfoCollector.a(7);
    super.c();
  }
  
  protected boolean c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqSttSttManager.a(null);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.l = true;
    int i1 = paramView.getId();
    if ((d) && (i1 == 2131296417)) {
      paramView.findViewById(2131296420).performClick();
    }
    PttItemBuilder.Holder localHolder;
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      localHolder = (PttItemBuilder.Holder)AIOUtils.a(paramView);
      localMessageForPtt = (MessageForPtt)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (i1 == 2131296420)
      {
        if (c(localMessageForPtt)) {
          MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
        }
        for (;;)
        {
          if (localMessageForPtt.istroop == 1008) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "");
          }
          if (localMessageForPtt.voiceChangeFlag != 1) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + localMessageForPtt.istroop, "", "", "");
          return;
          if ((localMessageForPtt != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (localMessageForPtt.isReady())) {
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131368056, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.a(paramView))) {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131368057, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908));
            }
          }
        }
      }
      if (i1 != 2131296423) {
        break;
      }
    } while (!localMessageForPtt.expandStt);
    localMessageForPtt.expandStt = false;
    localMessageForPtt.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForPtt.uniseq, localMessageForPtt.msgData);
    a(localHolder, localMessageForPtt, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPtt), c(localMessageForPtt));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
    return;
    if (i1 == 2131296329)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      paramView.putExtra("url", "http://m.vip.qq.com/freedom/freedom_longvoice.html");
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\PttItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
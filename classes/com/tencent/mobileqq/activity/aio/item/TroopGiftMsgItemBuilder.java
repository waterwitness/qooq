package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import nrd;
import nre;
import nrf;
import nrg;
import nrh;

public abstract class TroopGiftMsgItemBuilder
  extends BaseBubbleBuilder
{
  public static List a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilList = new LinkedList();
  }
  
  public TroopGiftMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!jdField_a_of_type_JavaUtilList.isEmpty()) {
      ThreadManager.a(new nrf(paramQQAppInterface.a().createEntityManager()), 5, null, true);
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView)
  {
    int i = 0;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool = false;; bool = true)
    {
      TransDiskCache localTransDiskCache;
      if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == 64536))
      {
        paramContext = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        localTransDiskCache = TranslateCache.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (localTransDiskCache == null) {
          break label309;
        }
      }
      label309:
      for (paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, paramContext);; paramContext = null)
      {
        if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend())) {}
        for (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool);; paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), null, bool))
        {
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
          }
          if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
          {
            j = paramChatMessage.vipBubbleDiyTextId;
            i = j;
            if (j <= 0) {
              i = SVIPHandler.b(paramChatMessage.vipBubbleID);
            }
            paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.isSend(), paramChatMessage.needVipBubble(), true, paramView, FontManager.a(paramChatMessage), i);
          }
          if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
          {
            paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
            if (paramContext != null) {
              paramContext.setAlpha(k_);
            }
          }
          super.a(paramView, paramChatMessage);
          return;
        }
        int j = SVIPHandler.a(paramChatMessage.vipBubbleID);
        if (!paramChatMessage.needVipBubble()) {}
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), null, bool);
          break;
          i = j;
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public abstract View a();
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    localnrh = (nrh)paramViewHolder;
    View localView = paramView;
    float f;
    if (paramView == null)
    {
      localView = a();
      localnrh.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView);
      localnrh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305151));
      localnrh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305152));
      localnrh.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305153));
      localnrh.jdField_a_of_type_AndroidWidgetButton = ((Button)localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305154));
      localnrh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305150));
      localnrh.jdField_b_of_type_AndroidViewView = localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305149);
      localnrh.jdField_c_of_type_AndroidViewView = localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131305155);
      i = (int)Math.min(BaseChatItemLayout.h - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 24.0F), DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 251.0F));
      f = i / DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 238.0F);
      if (f <= 1.0F) {
        break label860;
      }
      f = 1.0F;
    }
    label860:
    for (;;)
    {
      paramView = (LinearLayout.LayoutParams)localnrh.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramView.width = i;
      localnrh.jdField_b_of_type_AndroidViewView.setLayoutParams(paramView);
      paramView = (RelativeLayout.LayoutParams)localnrh.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramView.width = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, f * 110.0F));
      localnrh.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      localMessageForTroopGift = (MessageForTroopGift)paramChatMessage;
      localnrh.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = localMessageForTroopGift;
      localnrh.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.title);
      localnrh.jdField_b_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.subtitle);
      localnrh.jdField_c_of_type_AndroidWidgetTextView.setText(localMessageForTroopGift.message);
      localnrh.jdField_a_of_type_AndroidWidgetButton.setText(localMessageForTroopGift.comefrom);
      localnrh.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localMessageForTroopGift.comefrom);
      Object localObject = null;
      paramBaseChatItemLayout = null;
      paramChatMessage = paramBaseChatItemLayout;
      paramView = (View)localObject;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        paramChatMessage = paramBaseChatItemLayout;
        paramView = (View)localObject;
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843471);
        paramChatMessage = paramBaseChatItemLayout;
        paramView = (View)localObject;
        localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843471);
        paramChatMessage = paramBaseChatItemLayout;
        paramView = (View)localObject;
        paramBaseChatItemLayout = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), localURLDrawableOptions);
        paramChatMessage = paramBaseChatItemLayout;
        paramView = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setDownloadListener(new nrd(this));
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          paramBaseChatItemLayout = paramChatMessage;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, paramView.getMessage());
            paramBaseChatItemLayout = paramChatMessage;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;)
        {
          paramBaseChatItemLayout = paramView;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, paramChatMessage.getMessage());
            paramBaseChatItemLayout = paramView;
            continue;
            localnrh.jdField_c_of_type_AndroidViewView.setVisibility(8);
            paramChatMessage.b(localnrh);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(Long.valueOf(localMessageForTroopGift.receiverUin))) {
              i = 1;
            } else {
              i = 2;
            }
          }
        }
      }
      if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.getStatus() == 2)) {
        paramBaseChatItemLayout.restartDownload();
      }
      localnrh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBaseChatItemLayout);
      paramChatMessage = new nrg(this, localMessageForTroopGift, localnrh);
      localnrh.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramChatMessage);
      localnrh.jdField_b_of_type_AndroidViewView.setOnClickListener(paramChatMessage);
      localnrh.jdField_b_of_type_AndroidViewView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localnrh.jdField_b_of_type_AndroidViewView.setOnTouchListener(new nre(this, paramOnLongClickAndTouchListener));
      paramChatMessage = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
      if ((!localMessageForTroopGift.isLoading) || (!paramChatMessage.b(TroopGiftUtil.a(localMessageForTroopGift)))) {
        break;
      }
      paramChatMessage.a(localnrh);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "VISIBLE uniseq = " + localMessageForTroopGift.uniseq);
      }
      localnrh.jdField_c_of_type_AndroidViewView.setVisibility(0);
      a(localMessageForTroopGift, this.jdField_a_of_type_AndroidContentContext, paramViewHolder, localnrh.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296824));
      if (!localMessageForTroopGift.isReported)
      {
        localMessageForTroopGift.isReported = true;
        jdField_a_of_type_JavaUtilList.add(localMessageForTroopGift);
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(localMessageForTroopGift.senderuin)) {
          break label936;
        }
        i = 0;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
        if (TroopGiftUtil.a(localMessageForTroopGift)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i + "", localMessageForTroopGift.giftPicId + "", "");
        }
      }
      return localView;
    }
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopGift)paramChatMessage;
    return "发来来自送花的" + paramChatMessage.title + paramChatMessage.subtitle + paramChatMessage.message;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.l);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TroopGiftMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
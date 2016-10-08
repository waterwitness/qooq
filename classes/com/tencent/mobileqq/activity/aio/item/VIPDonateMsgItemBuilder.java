package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.qwallet.QQWalletTransferBubbleView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.VIPDonateMsg;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import nsg;
import nsh;

public class VIPDonateMsgItemBuilder
  extends BaseBubbleBuilder
{
  public static final String b;
  private static int h;
  private static int i;
  private static int j;
  private View.OnClickListener a;
  private Context b;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = VIPDonateMsgItemBuilder.class.getSimpleName();
  }
  
  public VIPDonateMsgItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nsg(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.k = ((int)(1.0F * f + 0.5F));
    this.l = ((int)(6.0F * f + 0.5F));
    this.m = ((int)(7.0F * f + 0.5F));
    this.o = ((int)(15.0F * f + 0.5F));
    this.q = ((int)(21.0F * f + 0.5F));
    this.p = ((int)(42.0F * f + 0.5F));
    this.n = ((int)(f * 230.0F + 0.5F));
    h = this.k * 2;
    i = this.k * 2;
    j = this.m;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    QQWalletTransferBubbleView localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localQQWalletTransferBubbleView.setLayoutParams(new RelativeLayout.LayoutParams(this.n, this.o * 5));
    localQQWalletTransferBubbleView.setId(2131296594);
    Object localObject1 = new ImageView(paramContext);
    Object localObject2 = new RelativeLayout.LayoutParams(this.p, this.p);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.q;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11);
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject1).setId(2131296595);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localObject1 = new LinearLayout(paramContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, 2131296595);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = this.q;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = this.l;
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new TextView(paramContext);
    ((TextView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(20.0F);
    ((TextView)localObject2).setId(2131296596);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localObject2 = new TextView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = this.k;
    ((TextView)localObject2).setLayoutParams(localLayoutParams);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextSize(14.0F);
    ((TextView)localObject2).setId(2131296597);
    ((LinearLayout)localObject1).addView((View)localObject2);
    localQQWalletTransferBubbleView.addView((View)localObject1);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    localQQWalletTransferBubbleView = new QQWalletTransferBubbleView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(this.n, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131296594);
    localQQWalletTransferBubbleView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localQQWalletTransferBubbleView.setBackgroundResource(2130841770);
    localQQWalletTransferBubbleView.setId(2131296598);
    paramContext = new TextView(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.q;
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.q;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.o;
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramContext.setSingleLine();
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setTextColor(-7500403);
    paramContext.setTextSize(12.0F);
    paramContext.setIncludeFontPadding(false);
    paramContext.setId(2131296599);
    localQQWalletTransferBubbleView.addView(paramContext);
    localRelativeLayout.addView(localQQWalletTransferBubbleView);
    return localRelativeLayout;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    boolean bool2 = true;
    paramView = (nsh)paramViewHolder;
    if (paramView.a == null) {
      paramView.a = a(this.jdField_b_of_type_AndroidContentContext);
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {}
    for (paramViewHolder = (MessageForVIPDonate)paramChatMessage;; paramViewHolder = null)
    {
      if (paramViewHolder == null)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "vipdonate msg empty");
        return null;
      }
      paramViewHolder.parse();
      paramViewHolder = paramViewHolder.donateMsg;
      if (paramViewHolder == null)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "donateMsg empty");
        return null;
      }
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131296596);
      paramBaseChatItemLayout.setText(paramViewHolder.title);
      paramBaseChatItemLayout.setTextColor(-1);
      paramBaseChatItemLayout = (TextView)paramView.a.findViewById(2131296597);
      paramBaseChatItemLayout.setText(paramViewHolder.subTitle);
      paramBaseChatItemLayout.setTextColor(-1);
      ((TextView)paramView.a.findViewById(2131296599)).setText(paramViewHolder.footer);
      ((ImageView)paramView.a.findViewById(2131296595)).setImageResource(2130843507);
      paramBaseChatItemLayout = (QQWalletTransferBubbleView)paramView.a.findViewById(2131296598);
      QQWalletTransferBubbleView localQQWalletTransferBubbleView = (QQWalletTransferBubbleView)paramView.a.findViewById(2131296594);
      int i1 = Color.rgb(255, 170, 57);
      if (!paramChatMessage.isSend())
      {
        bool1 = true;
        localQQWalletTransferBubbleView.setBubbleBackground(2130841769, i1, bool1);
        i1 = Color.rgb(255, 255, 255);
        if (paramChatMessage.isSend()) {
          break label349;
        }
      }
      label349:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramBaseChatItemLayout.setBubbleBackground(2130841770, i1, bool1);
        if (jdField_b_of_type_Boolean) {
          paramView.a.setContentDescription(paramViewHolder.subTitle + paramViewHolder.title);
        }
        paramView.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.a.setOnLongClickListener(paramOnLongClickAndTouchListener);
        paramView.a.setOnTouchListener(paramOnLongClickAndTouchListener);
        return paramView.a;
        bool1 = false;
        break;
      }
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nsh(this, null);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(i, j, h, 0);
      return;
    }
    paramView.setPadding(h, j, i, 0);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\VIPDonateMsgItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
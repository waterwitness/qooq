package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import nni;
import nnj;
import nnk;

public class QQStoryCommentItemBuilder
  extends BaseBubbleBuilder
{
  protected static final long a = 86400000L;
  public static final String b = QQStoryCommentItemBuilder.class.getSimpleName();
  static final String c = "的日迹";
  protected static final int h = BaseChatItemLayout.k + BaseChatItemLayout.p;
  protected static final int i = BaseChatItemLayout.l + BaseChatItemLayout.q;
  protected static final int j = BaseChatItemLayout.m + BaseChatItemLayout.r;
  protected static final int k = BaseChatItemLayout.n + BaseChatItemLayout.s;
  public static final int l = "的日迹".length();
  View.OnClickListener a;
  boolean d = false;
  final int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQStoryCommentItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nnj(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2130904500, null);
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131302965));
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131302964));
      paramViewHolder.jdField_b_of_type_AndroidViewView = paramChatMessage.findViewById(2131300561);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131298138));
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131297123));
      paramViewHolder.c = ((TextView)paramChatMessage.findViewById(2131299892));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131299896));
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = ThumbnailUrlHelper.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841382);
      if (HttpUtil.a(paramView))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        localURLDrawableOptions.mRequestWidth = this.m;
        localURLDrawableOptions.mRequestHeight = this.m;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramView = paramBaseChatItemLayout.getNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView + "的日迹");
        paramView = paramViewHolder.jdField_a_of_type_AndroidWidgetTextView;
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new nni(this, paramView));
        paramView = new SimpleDateFormat("M月d日 HH:mm");
        paramViewHolder.c.setText(paramView.format(new Long(paramBaseChatItemLayout.createTime * 1000L)));
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
    }
    for (;;)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new nnk(this, paramOnLongClickAndTouchListener));
      paramChatMessage.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramChatMessage.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if (!this.d)
      {
        ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "exp", 0, 0, "", "", "", "");
        this.d = true;
      }
      return paramChatMessage;
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new QQStoryCommentItemBuilder.QQStoryCommentViewHolder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "delete", 0, 0, "", "", "", "");
      return;
    case 2131305407: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "copy", 0, 0, "", "", "", "");
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(b, 2, paramContext.toString());
          }
        }
      }
    case 2131297425: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "forward", 0, 0, "", "", "", "");
      return;
    case 2131296353: 
      super.a(paramChatMessage);
      ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "recall", 0, 0, "", "", "", "");
      return;
    }
    super.b(paramChatMessage);
    ReportController.b(null, "dc00899", "grp_story", "", "aio_msg", "more", 0, 0, "", "", "", "");
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(k, h, j, i);
      return;
    }
    paramView.setPadding(j, h, k, i);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    paramViewHolder = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    if (paramBubbleInfo.d == 0)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramViewHolder.c.setTextColor(Color.argb(127, 0, 0, 0));
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int n = Color.red(paramBubbleInfo.d);
    int i1 = Color.green(paramBubbleInfo.d);
    int i2 = Color.blue(paramBubbleInfo.d);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, n, i1, i2));
    paramViewHolder.c.setTextColor(Color.argb(127, n, i1, i2));
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.d);
    paramViewHolder.jdField_b_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, n, i1, i2));
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage)
  {
    Object localObject = (QQStoryCommentItemBuilder.QQStoryCommentViewHolder)paramViewHolder;
    paramViewHolder = ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a(paramChatMessage);
    localObject = (ETTextView)((QQStoryCommentItemBuilder.QQStoryCommentViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramViewHolder != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramViewHolder.b, paramViewHolder.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131305407, this.jdField_a_of_type_AndroidContentContext.getString(2131369280));
    localQQCustomMenu.a(2131297425, this.jdField_a_of_type_AndroidContentContext.getString(2131369281));
    paramView = ((BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView)).a;
    if (paramView.isSend()) {
      super.a(localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    }
    BaseBubbleBuilder.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    super.b(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext);
    return localQQCustomMenu.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\QQStoryCommentItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
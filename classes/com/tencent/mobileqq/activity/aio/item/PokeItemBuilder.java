package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import nna;
import nnb;
import nnc;
import nnd;
import nne;
import nnf;

public class PokeItemBuilder
  extends BaseBubbleBuilder
{
  private View.OnClickListener a;
  public HashMap a;
  public QQAppInterface b;
  public HashMap b;
  
  public PokeItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nna(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  public AnimationDrawable a(Drawable[] paramArrayOfDrawable)
  {
    int k = 13;
    int m = 7;
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.addFrame(paramArrayOfDrawable[0], 350);
    int i = 1;
    while (i < 15)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i += 1;
    }
    i = 13;
    while (i >= 7)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i -= 1;
    }
    i = 7;
    while (i < 15)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i += 1;
    }
    i = 13;
    while (i >= 0)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i -= 1;
    }
    localAnimationDrawable.addFrame(paramArrayOfDrawable[0], 350);
    i = 1;
    while (i < 15)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i += 1;
    }
    int j = 13;
    for (;;)
    {
      i = m;
      if (j < 7) {
        break;
      }
      localAnimationDrawable.addFrame(paramArrayOfDrawable[j], 20);
      j -= 1;
    }
    for (;;)
    {
      j = k;
      if (i >= 15) {
        break;
      }
      localAnimationDrawable.addFrame(paramArrayOfDrawable[i], 20);
      i += 1;
    }
    while (j >= 0)
    {
      localAnimationDrawable.addFrame(paramArrayOfDrawable[j], 20);
      j -= 1;
    }
    localAnimationDrawable.addFrame(paramArrayOfDrawable[0], 350);
    localAnimationDrawable.setOneShot(true);
    return localAnimationDrawable;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForPoke localMessageForPoke = (MessageForPoke)paramChatMessage;
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
    {
      paramView = super.a(paramInt1, paramInt2, paramChatMessage, null, paramViewGroup, paramOnLongClickAndTouchListener);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramChatMessage, (BaseChatItemLayout)paramView);
      paramViewGroup = (PokeItemBuilder.Holder)paramView.getTag();
      if (QLog.isColorLevel()) {
        QLog.d("poke", 2, "getBubbleView msg isread=" + localMessageForPoke.isread + "isplayed=" + localMessageForPoke.isPlayed + "pos=" + paramViewGroup.jdField_b_of_type_Int + "mPokeViewCache size =" + this.jdField_b_of_type_JavaUtilHashMap.size());
      }
      if ((localMessageForPoke.isPlayed) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(localMessageForPoke.uniseq)))) {
        break label326;
      }
    }
    label326:
    for (boolean bool = true;; bool = false)
    {
      a(paramChatMessage, paramViewGroup, bool, (BaseChatItemLayout)paramView);
      if (this.jdField_b_of_type_JavaUtilHashMap.size() <= 10) {
        break label332;
      }
      paramChatMessage = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramChatMessage.hasNext())
      {
        paramViewGroup = paramChatMessage.next();
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramViewGroup)) {
          paramChatMessage.remove();
        }
      }
      paramView = (View)this.jdField_b_of_type_JavaUtilHashMap.get(paramChatMessage);
      if (b(paramChatMessage, (BaseChatItemLayout)paramView)) {
        ((BaseChatItemLayout)paramView).setProgressVisable(false);
      }
      for (;;)
      {
        a(paramChatMessage, (BaseChatItemLayout)paramView);
        b(paramChatMessage, (BaseChatItemLayout)paramView);
        a(paramChatMessage, (BaseChatItemLayout)paramView, paramInt1, paramInt2);
        break;
        c(paramChatMessage, (BaseChatItemLayout)paramView);
      }
    }
    label332:
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    PokeItemBuilder.Holder localHolder = (PokeItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new RelativeLayout(paramBaseChatItemLayout);
      paramView = new LinearLayout(paramBaseChatItemLayout);
      paramView.setId(2131296641);
      paramView.setOrientation(0);
      Object localObject1 = new ImageView(paramBaseChatItemLayout);
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(paramBaseChatItemLayout);
      ((TextView)localObject2).setTextColor(paramBaseChatItemLayout.getResources().getColorStateList(2131428272));
      ((TextView)localObject2).setMaxWidth(BaseChatItemLayout.i);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 16;
      paramView.addView((View)localObject2, localLayoutParams);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localHolder.jdField_a_of_type_AndroidWidgetLinearLayout = paramView;
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      paramView.setVisibility(4);
      paramView = new ImageView(paramBaseChatItemLayout);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      paramViewHolder.addView(paramView, (ViewGroup.LayoutParams)localObject1);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = paramView;
    }
    paramViewHolder.setTag(localHolder);
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    int k = BaseChatItemLayout.r;
    int j = BaseChatItemLayout.s;
    int i = BaseChatItemLayout.r;
    paramView = (RelativeLayout.LayoutParams)localHolder.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      k = BaseChatItemLayout.s;
      j = BaseChatItemLayout.r;
      i = BaseChatItemLayout.s;
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838138);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131367603));
      paramView.addRule(7, 2131296641);
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, 0, 0, 0);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setPadding(k, BaseChatItemLayout.p, j, BaseChatItemLayout.q);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (jdField_b_of_type_Boolean)
      {
        if ((localHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (localHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          localHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
        }
        paramView = new StringBuilder();
        if (paramChatMessage.time > 0L) {
          paramView.append(TimeFormatterUtils.a(paramBaseChatItemLayout, 3, paramChatMessage.time * 1000L)).append(" ");
        }
        if (!paramChatMessage.isSend()) {
          break label581;
        }
        paramView.append("你戳了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
      }
    }
    for (;;)
    {
      paramViewHolder.setContentDescription(paramView.toString());
      return paramViewHolder;
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838136);
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.getResources().getString(2131367604));
      paramView.addRule(5, 2131296641);
      break;
      label581:
      paramView.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("戳了你一下");
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new PokeItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    if (paramChatMessage.isSend()) {
      localStringBuilder.append("你戳了").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("一下");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("戳了你一下");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131305401: 
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForPoke)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131367889);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131367890);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new nnb(this, paramView), new nnc(this)).show();
    }
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    PokeItemBuilder.Holder localHolder = (PokeItemBuilder.Holder)paramViewHolder;
    if ((paramBubbleInfo.c == 0) || (!paramBubbleInfo.a()))
    {
      paramView = paramView.getResources();
      if (paramChatMessage.isSend())
      {
        paramViewHolder = paramView.getColorStateList(2131428275);
        if (paramViewHolder != null) {
          localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramViewHolder);
        }
        if (!paramChatMessage.isSend()) {
          break label90;
        }
      }
      label90:
      for (paramViewHolder = paramView.getColorStateList(2131428274);; paramViewHolder = paramView.getColorStateList(2131428273))
      {
        localHolder.jdField_a_of_type_AndroidWidgetTextView.setLinkTextColor(paramViewHolder);
        return;
        paramViewHolder = paramView.getColorStateList(2131428272);
        break;
      }
    }
    if (paramBubbleInfo.d == 0)
    {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      return;
    }
    localHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramBubbleInfo.d);
  }
  
  public void a(ChatMessage paramChatMessage, PokeItemBuilder.Holder paramHolder, boolean paramBoolean, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = (MessageForPoke)paramChatMessage;
    Drawable localDrawable = paramHolder.jdField_a_of_type_AndroidViewView.getBackground();
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {}
    for (boolean bool = ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).booleanValue();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("poke", 2, "refreshUI isPlaying=" + paramHolder.jdField_a_of_type_Boolean + "====neepPlay=" + paramBoolean + "===position=" + paramHolder.jdField_b_of_type_Int + "isInPlayMap=" + bool);
      }
      if ((paramHolder.jdField_a_of_type_Boolean) && (bool))
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        paramHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        if (paramBaseChatItemLayout != null) {
          paramBaseChatItemLayout.setProgressVisable(false);
        }
        return;
      }
      if (paramBoolean)
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        paramHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
        if (paramChatMessage.isSend()) {}
        for (AnimationDrawable localAnimationDrawable = a(PokeItemHelper.a());; localAnimationDrawable = a(PokeItemHelper.b()))
        {
          paramHolder.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, Boolean.valueOf(paramHolder.jdField_a_of_type_Boolean));
          ((MessageForPoke)localObject).setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(((MessageForPoke)localObject).uniseq));
          paramBaseChatItemLayout = new nnd(this, paramHolder, localDrawable, paramChatMessage, paramBaseChatItemLayout, (MessageForPoke)localObject);
          localObject = (Build.MANUFACTURER + "-" + Build.MODEL).toLowerCase();
          if ((Build.VERSION.SDK_INT >= 11) && (!((String)localObject).startsWith("oppo")) && (!((String)localObject).startsWith("vivo")) && (!((String)localObject).startsWith("bbk-vivo"))) {
            break label433;
          }
          if (!paramChatMessage.isSend()) {
            break;
          }
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.post(new nnf(paramHolder.jdField_b_of_type_AndroidWidgetImageView, PokeItemHelper.a(), paramBaseChatItemLayout));
          return;
        }
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.post(new nnf(paramHolder.jdField_b_of_type_AndroidWidgetImageView, PokeItemHelper.b(), paramBaseChatItemLayout));
        return;
        label433:
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
        paramChatMessage = new AlphaAnimation(0.1F, 1.0F);
        paramChatMessage.setDuration(300L);
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.startAnimation(paramChatMessage);
        jdField_a_of_type_AndroidOsHandler.postDelayed(new nne(this, paramHolder), 2470L);
        jdField_a_of_type_AndroidOsHandler.postDelayed(paramBaseChatItemLayout, 2770L);
        return;
      }
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      paramHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localDrawable);
      a(paramHolder.jdField_a_of_type_AndroidViewView, (ChatMessage)localObject);
      paramHolder.jdField_a_of_type_AndroidViewView.requestLayout();
      return;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.b(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\PokeItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
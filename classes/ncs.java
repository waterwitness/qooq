import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ArkUIView;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

public class ncs
  implements View.OnClickListener, OnLongClickAndTouchListener, BubblePopupWindow.OnDismissListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  View jdField_a_of_type_AndroidViewView;
  ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  public BubblePopupWindow a;
  boolean jdField_a_of_type_Boolean;
  View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean;
  
  private ncs(ChatAdapter1 paramChatAdapter1)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if ((localObject instanceof BaseBubbleBuilder)) {
        ((BaseBubbleBuilder)localObject).c();
      }
    }
    this.jdField_b_of_type_Boolean = false;
    BubbleContextMenu.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setPressed(false);
      localObject = this.jdField_a_of_type_AndroidViewView.getTag();
      if ((localObject == null) || (!(localObject instanceof AbsStructMsgItem))) {
        break label110;
      }
      ((AbsStructMsgItem)localObject).b(this.jdField_a_of_type_AndroidViewView);
    }
    label110:
    do
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewView = null;
        this.jdField_b_of_type_AndroidViewView = null;
        return;
        if ((!(localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder)) || (this.jdField_b_of_type_AndroidViewView == null)) {
          break;
        }
        localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
        ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        if (this.jdField_a_of_type_Boolean)
        {
          if (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
            ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend(), ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.needVipBubble(), true, ((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_AndroidViewView, false);
          }
          localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131296359);
          if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
            ((PAHighLightImageView)localObject).a();
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008)) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837662);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837656);
          }
        }
        localObject = this.jdField_b_of_type_AndroidViewView.findViewById(2131296504);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).a();
        }
      }
    } while (!(localObject instanceof StructMsgItemButton));
    Object localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    int i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
    int j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
    int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
    int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
    int n = ((Integer)this.jdField_b_of_type_AndroidViewView.getTag(2131296587)).intValue();
    if (n == 0) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837650);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
      break;
      if (n == 2) {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837654);
      } else {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837652);
      }
    }
  }
  
  void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null)
    {
      localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      localContext = paramView.getContext();
      localChatItemBuilder.a(paramView.getId(), localContext, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    }
    while (!QLog.isColorLevel())
    {
      ChatItemBuilder localChatItemBuilder;
      Context localContext;
      return;
    }
    QLog.d(ChatItemBuilder.a, 2, "bubble onClick() is called while the chatMessage is null.");
  }
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView instanceof AnimationTextView)) {
      ((AnimationTextView)paramView).setTag(2131296654, Boolean.valueOf(true));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      return true;
    }
    this.jdField_b_of_type_Boolean = true;
    AIOUtils.l = true;
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onLongClick() is called");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g()))
    {
      a(paramView);
      return false;
    }
    Object localObject = new QQCustomMenu();
    ChatItemBuilder localChatItemBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a(AIOUtils.a(paramView), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    QQCustomMenuItem[] arrayOfQQCustomMenuItem = localChatItemBuilder.a(paramView);
    int j;
    if ((arrayOfQQCustomMenuItem != null) && (arrayOfQQCustomMenuItem.length > 0))
    {
      j = arrayOfQQCustomMenuItem.length;
      i = 0;
      while (i < j)
      {
        ((QQCustomMenu)localObject).a(arrayOfQQCustomMenuItem[i]);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = AIOUtils.a(paramView);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing))) {
        break label740;
      }
    }
    label393:
    label511:
    label513:
    label526:
    label708:
    label740:
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, (QQCustomMenu)localObject, this);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(this);
      a(paramView);
      if (i != 0)
      {
        paramView.setPressed(true);
        this.jdField_a_of_type_AndroidViewView = paramView;
        localObject = this.jdField_a_of_type_AndroidViewView.getTag();
        if ((localObject instanceof AbsStructMsgItem)) {
          ((AbsStructMsgItem)localObject).c(this.jdField_a_of_type_AndroidViewView);
        }
      }
      else
      {
        if (!(localChatItemBuilder instanceof TextItemBuilder)) {
          break label708;
        }
        paramView = Integer.toString(0);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004044", "0X8004404", 0, 0, paramView, "", "", "");
        BubbleContextMenu.jdField_a_of_type_Boolean = true;
        return true;
        if ((localObject instanceof StructingMsgItemBuilder.StructingMsgViewHolder))
        {
          paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
          if ((localChatItemBuilder instanceof StructingMsgItemBuilder))
          {
            if (((StructingMsgItemBuilder)localChatItemBuilder).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage) == 0)
            {
              if ((paramView.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount() > 0)) {
                this.jdField_b_of_type_AndroidViewView = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
              }
              this.jdField_a_of_type_Boolean = false;
            }
          }
          else
          {
            if (this.jdField_b_of_type_AndroidViewView == null) {
              break label511;
            }
            localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
            i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
            j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
            k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
            m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
            if (!this.jdField_a_of_type_Boolean) {
              break label526;
            }
            if (!paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
              break label513;
            }
            paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130843068);
          }
          for (;;)
          {
            this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
            this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
            break;
            this.jdField_b_of_type_AndroidViewView = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout;
            this.jdField_a_of_type_Boolean = true;
            break label393;
            break;
            paramView.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130843000);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1008) {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837664);
            } else {
              this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837668);
            }
          }
        }
        if (!(localObject instanceof StructMsgItemButton)) {
          break;
        }
        this.jdField_b_of_type_AndroidViewView = paramView;
        localObject = this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        i = this.jdField_b_of_type_AndroidViewView.getPaddingLeft();
        j = this.jdField_b_of_type_AndroidViewView.getPaddingTop();
        int k = this.jdField_b_of_type_AndroidViewView.getPaddingRight();
        int m = this.jdField_b_of_type_AndroidViewView.getPaddingBottom();
        int n = ((Integer)paramView.getTag(2131296587)).intValue();
        if (n == 0) {
          this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837651);
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_b_of_type_AndroidViewView.setPadding(i, j, k, m);
          break;
          if (n == 2) {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837655);
          } else {
            this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837653);
          }
        }
        if ((localChatItemBuilder instanceof PicItemBuilder)) {
          paramView = Integer.toString(1);
        } else {
          paramView = Integer.toString(999);
        }
      }
      a(paramView);
      return false;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.a, 2, "bubble onTouch() is called,action is:" + paramMotionEvent.getAction());
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    if ((paramView instanceof ArkUIView)) {
      ((ArkUIView)paramView).a(paramView, paramMotionEvent);
    }
    View localView = paramView.findViewById(2131296359);
    if ((localView != null) && ((localView instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
      ((PAHighLightImageView)localView).a(paramView, paramMotionEvent);
    }
    for (;;)
    {
      return false;
      localView = paramView.findViewById(2131296504);
      if ((localView != null) && ((localView instanceof PAHighLightImageView)) && (!this.jdField_b_of_type_Boolean)) {
        ((PAHighLightImageView)localView).a(paramView, paramMotionEvent);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ncs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
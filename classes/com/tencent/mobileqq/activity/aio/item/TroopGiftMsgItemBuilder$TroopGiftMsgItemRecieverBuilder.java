package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import nrj;

public class TroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder
  extends TroopGiftMsgItemBuilder
{
  public TroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a()
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130905059, null);
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new nrj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
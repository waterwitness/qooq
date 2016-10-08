package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout18
  extends AbsStructMsgItem
{
  private QQAppInterface a;
  
  public StructMsgItemLayout18()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setGravity(17);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 1;
    localLayoutParams.setMargins(0, 0, 0, AIOUtils.a(20.0F, localResources));
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131296583);
    return paramContext;
  }
  
  protected int b()
  {
    return 18;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = BaseApplicationImpl.a().a();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    Object localObject1;
    Object localObject2;
    label58:
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramBundle = (LinearLayout)paramView;
      localObject1 = (StructMsgItemLayout18.ViewHolder)paramBundle.getTag();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = null;
      if (!((Iterator)localObject2).hasNext()) {
        break label114;
      }
      localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
      if (!"live".equals(((AbsStructMsgElement)localObject3).a)) {
        break label267;
      }
      paramView = (StructMsgItemLive)localObject3;
    }
    label114:
    label262:
    label267:
    for (;;)
    {
      break label58;
      paramBundle = a(paramContext);
      localObject1 = null;
      break;
      if (localObject1 == null)
      {
        localObject1 = new StructMsgItemLayout18.ViewHolder();
        if (paramView == null) {
          break label262;
        }
        localObject2 = paramView.a(paramContext, null, null);
        paramContext = (NowVideoLayout)((View)localObject2).findViewById(2131296580);
        paramContext.a(paramView);
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, 0, 0, 0);
        ((StructMsgItemLayout18.ViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgItemLive = paramView;
        ((StructMsgItemLayout18.ViewHolder)localObject1).jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramContext;
        paramBundle.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      for (;;)
      {
        paramBundle.setTag(localObject1);
        for (;;)
        {
          localObject1 = paramBundle.findViewById(2131296580);
          if ((localObject1 != null) && (paramView != null)) {
            ((View)localObject1).setOnClickListener(paramView.a);
          }
          if (paramContext != null) {
            paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
          }
          return paramBundle;
          paramContext = ((StructMsgItemLayout18.ViewHolder)localObject1).jdField_a_of_type_ComTencentBizNowNowVideoLayout;
        }
        paramContext = null;
      }
    }
  }
  
  public String b()
  {
    return "Layout18";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
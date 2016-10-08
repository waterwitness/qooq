package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout10
  extends AbsStructMsgItem
{
  public StructMsgItemLayout10()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(Context paramContext, View paramView, StructMsgItemLayout10.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramContext = paramContext.getResources();
      if (paramViewHolder.a != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -1);
        paramViewHolder.a.setId(2131299733);
        paramBundle.addRule(9, -1);
        ((RelativeLayout)paramView).addView(paramViewHolder.a);
      }
      if (paramViewHolder.b != null)
      {
        paramBundle = new RelativeLayout.LayoutParams(-1, -2);
        paramBundle.addRule(9);
        if (FontSettingManager.a() <= 16.0F) {
          break label146;
        }
      }
    }
    label146:
    for (int i = AIOUtils.a(5.0F, paramContext);; i = AIOUtils.a(10.0F, paramContext))
    {
      paramBundle.setMargins(AIOUtils.a(20.0F, paramContext), 0, AIOUtils.a(20.0F, paramContext), i);
      paramBundle.addRule(12);
      ((RelativeLayout)paramView).addView(paramViewHolder.b, paramBundle);
      return;
    }
  }
  
  protected int b()
  {
    return 10;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3;
    Object localObject4;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof StructMsgItemLayout10.ViewHolder)))
    {
      localObject3 = (StructMsgItemLayout10.ViewHolder)paramView.getTag();
      localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      Object localObject2 = localObject3;
      Object localObject1 = paramView;
      String str;
      int j;
      int i;
      if (((Iterator)localObject4).hasNext())
      {
        localObject1 = (AbsStructMsgElement)((Iterator)localObject4).next();
        ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject2 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject2))
        {
          localObject2 = (StructMsgItemTitle)localObject1;
          str = ((StructMsgItemTitle)localObject2).c();
          j = ((StructMsgItemTitle)localObject2).e();
          i = j;
          if (TextUtils.isEmpty(str)) {}
        }
      }
      try
      {
        i = Integer.parseInt(str);
        f = FontSettingManager.a() / 16.0F;
        if (i * f > 36.0F) {
          ((StructMsgItemTitle)localObject2).d("" + (int)(36.0F / f));
        }
        for (;;)
        {
          ((StructMsgItemLayout10.ViewHolder)localObject3).b = ((AbsStructMsgElement)localObject1).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject3).b, paramBundle);
          break;
          ((StructMsgItemTitle)localObject2).d(str);
        }
        if (!"paaudio".equals(localObject2)) {
          continue;
        }
        ((StructMsgItemLayout10.ViewHolder)localObject3).a = ((AbsStructMsgElement)localObject1).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject3).a, paramBundle);
        continue;
        paramView = paramContext.getResources();
        localObject2 = new StructMsgItemLayout10.ViewHolder();
        localObject1 = new RelativeLayout(paramContext);
        i = AIOUtils.a(15.0F, paramView);
        ((View)localObject1).setPadding(i, i, i, i);
        i = (int)((BaseChatItemLayout.e - AIOUtils.a(46.0F, paramView)) * 26.0F / 63.0F);
        ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.a(30.0F, paramView) + i));
        paramView = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (paramView.hasNext())
        {
          localObject3 = (AbsStructMsgElement)paramView.next();
          ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject4 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
          if ("title".equals(localObject4))
          {
            localObject4 = (StructMsgItemTitle)localObject3;
            str = ((StructMsgItemTitle)localObject4).c();
            j = ((StructMsgItemTitle)localObject4).e();
            i = j;
            if (TextUtils.isEmpty(str)) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            i = Integer.parseInt(str);
            float f = FontSettingManager.a() / 16.0F;
            if (i * f > 36.0F) {
              ((StructMsgItemTitle)localObject4).d("" + (int)(36.0F / f));
            }
            for (;;)
            {
              ((StructMsgItemLayout10.ViewHolder)localObject2).b = ((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject2).b, paramBundle);
              break;
              ((StructMsgItemTitle)localObject4).d(str);
            }
            if ("paaudio".equals(localObject4)) {
              ((StructMsgItemLayout10.ViewHolder)localObject2).a = ((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout10.ViewHolder)localObject2).a, paramBundle);
            }
          }
          a(paramContext, (View)localObject1, (StructMsgItemLayout10.ViewHolder)localObject2, paramBundle);
          ((View)localObject1).setTag(localObject2);
          return (View)localObject1;
          localException1 = localException1;
          i = j;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = j;
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout10";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
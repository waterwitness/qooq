package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout2
  extends AbsStructMsgItem
{
  protected boolean a;
  
  public StructMsgItemLayout2()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public StructMsgItemLayout2(int paramInt)
  {
    super(paramInt);
  }
  
  public StructMsgItemLayout2(Collection paramCollection)
  {
    super(paramCollection);
  }
  
  private TextViewWrapLayout a(Context paramContext)
  {
    paramContext = new TextViewWrapLayout(paramContext);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!TextUtils.isEmpty(this.c)) {
      paramContext.setBackgroundResource(2130838349);
    }
    d(paramContext);
    return paramContext;
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131493081);
    int n = localResources.getDimensionPixelSize(2131493082);
    int k = AIOUtils.a(5.0F, localResources);
    if (a(1)) {}
    for (int j = a(paramContext) + k;; j = k)
    {
      int i = k;
      if (a(2)) {
        i = k + a(paramContext);
      }
      if (this.jdField_a_of_type_Boolean) {
        i = AIOUtils.a(2.0F, localResources);
      }
      paramViewGroup.setPadding(m, j, n, i);
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup == null) || (paramView == null) || (paramLayoutParams == null)) {
      return;
    }
    paramViewGroup.addView(paramView, paramLayoutParams);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setMaxLines(paramInt);
  }
  
  protected int b()
  {
    return 2;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject4 = paramContext.getResources();
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isShowCommentLayout", false);
    View localView = null;
    Object localObject1 = null;
    TextView localTextView = null;
    Object localObject3 = null;
    TextViewWrapLayout localTextViewWrapLayout;
    Object localObject2;
    int i;
    Object localObject5;
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localTextViewWrapLayout = (TextViewWrapLayout)paramView;
      localObject2 = (RelativeLayout)paramView.findViewById(2131300560);
      localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      i = 0;
      paramView = (View)localObject3;
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (AbsStructMsgElement)((Iterator)localObject4).next();
        ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject5 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
        if ((("picture".equals(localObject5)) || ("vote".equals(localObject5)) || ("video".equals(localObject5))) && (localView == null)) {
          localView = ((AbsStructMsgElement)localObject3).a(paramContext, localTextViewWrapLayout.findViewById(2131296359), paramBundle);
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (("title".equals(localObject5)) && (localObject1 == null))
      {
        if ((localObject3 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject3).a(a(), this.l);
        }
        localObject1 = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, localTextViewWrapLayout.findViewById(2131296360), paramBundle);
      }
      else if (localTextView == null)
      {
        if (("summary".equals(localObject5)) || ("timer".equals(localObject5)))
        {
          localTextView = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, localTextViewWrapLayout.findViewById(2131296361), paramBundle);
        }
        else if ("checklist".equals(localObject5))
        {
          paramView = (LinearLayout)((AbsStructMsgElement)localObject3).a(paramContext, localTextViewWrapLayout.findViewById(2131296368), paramBundle);
          continue;
          localView = paramView;
          paramView = (View)localObject1;
          paramBundle = localTextViewWrapLayout;
          localObject1 = localObject2;
          a(paramContext, paramBundle);
          label346:
          label402:
          label458:
          label498:
          label544:
          label556:
          boolean bool;
          if (localObject1 != null)
          {
            if (this.jdField_a_of_type_Boolean) {
              ((RelativeLayout)localObject1).setVisibility(0);
            }
          }
          else
          {
            i = 0;
            int k = 0;
            int j = i;
            if (paramView != null)
            {
              paramContext = paramView.getTag();
              j = i;
              if ((paramContext instanceof StructMsgItemTitle))
              {
                paramContext = (StructMsgItemTitle)paramContext;
                j = i;
                if (paramContext != null)
                {
                  if (TextUtils.isEmpty(paramContext.b())) {
                    break label1503;
                  }
                  i = 1;
                  j = i;
                }
              }
            }
            i = k;
            if (localTextView != null)
            {
              paramContext = localTextView.getTag();
              i = k;
              if ((paramContext instanceof StructMsgItemSummary))
              {
                paramContext = (StructMsgItemSummary)paramContext;
                i = k;
                if (paramContext != null)
                {
                  if (TextUtils.isEmpty(paramContext.b())) {
                    break label1509;
                  }
                  i = 1;
                }
              }
            }
            if (localView == null) {
              break label1555;
            }
            paramContext = localView.getTag();
            if (!(paramContext instanceof StructMsgItemVote)) {
              break label1555;
            }
            paramContext = ((StructMsgItemVote)paramContext).jdField_a_of_type_JavaUtilArrayList;
            if ((paramContext == null) || (paramContext.isEmpty())) {
              break label1515;
            }
            i = 1;
            if (j == 0) {
              break label1521;
            }
            a(paramView, 2);
            a(paramView, 0);
            a(localTextView, 2);
            if ((this.k == 1) || (this.k == 3)) {
              paramView.setTextSize(16.0F);
            }
            if (i == 0) {
              break label1538;
            }
            a(localTextView, 0);
            if ((this.k == 1) || (this.k == 3))
            {
              if (localTextView != null) {
                localTextView.setSingleLine(true);
              }
              if (paramView != null) {
                paramView.setSingleLine(true);
              }
            }
            if ((this.k == 1) || (this.k == 3)) {
              break label1549;
            }
            bool = true;
            label611:
            paramBundle.a(bool);
            if (AppSetting.j)
            {
              paramContext = new StringBuilder();
              paramContext.append("结构化消息 ");
              if (paramView != null) {
                paramContext.append(paramView.getText());
              }
              paramBundle.setContentDescription(paramContext.toString());
            }
            return paramBundle;
            localTextViewWrapLayout = a(paramContext);
            localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            paramView = null;
            localObject1 = null;
            localTextView = null;
            localView = null;
            label688:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
              ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
              localObject5 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
              if ((("picture".equals(localObject5)) || ("vote".equals(localObject5)) || ("video".equals(localObject5))) && (localView == null)) {
                localView = ((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
              }
            }
          }
          for (;;)
          {
            break label688;
            if (("title".equals(localObject5)) && (localObject1 == null))
            {
              if ((localObject3 instanceof StructMsgItemTitle)) {
                ((StructMsgItemTitle)localObject3).a(a(), this.l);
              }
              localObject1 = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
            }
            else if (localTextView == null)
            {
              if (("summary".equals(localObject5)) || ("timer".equals(localObject5)))
              {
                localTextView = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
              }
              else if ("checklist".equals(localObject5))
              {
                paramView = (LinearLayout)((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
                continue;
                if (localView == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item failure.");
                  }
                  return null;
                }
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject2 = localObject1;
                  if (localTextView != null) {
                    localObject2 = (TextView)new StructMsgItemTitle(localTextView.getText().toString()).a(paramContext, null, paramBundle);
                  }
                }
                if (localObject2 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                  }
                  return null;
                }
                if (this.k == 1)
                {
                  paramBundle = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, (Resources)localObject4), AIOUtils.a(50.0F, (Resources)localObject4));
                  paramBundle.topMargin = AIOUtils.a(3.0F, (Resources)localObject4);
                  label1031:
                  paramBundle.addRule(9);
                  paramBundle.addRule(10);
                  localTextViewWrapLayout.addView(localView, paramBundle);
                  i = AIOUtils.a(10.0F, (Resources)localObject4);
                  paramBundle = new RelativeLayout.LayoutParams(-1, -2);
                  paramBundle.topMargin = 0;
                  paramBundle.addRule(10);
                  localObject1 = new RelativeLayout.LayoutParams(-1, -2);
                  ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
                  ((RelativeLayout.LayoutParams)localObject1).addRule(3, ((TextView)localObject2).getId());
                  if ((this.k != 1) && (this.k != 3)) {
                    break label1344;
                  }
                  localObject3 = new RelativeLayout(paramContext);
                  localObject5 = new RelativeLayout.LayoutParams(-1, -2);
                  if (this.k != 3) {
                    break label1328;
                  }
                  ((RelativeLayout.LayoutParams)localObject5).topMargin = AIOUtils.a(12.0F, (Resources)localObject4);
                }
                label1328:
                for (((RelativeLayout.LayoutParams)localObject1).topMargin = 5;; ((RelativeLayout.LayoutParams)localObject5).topMargin = AIOUtils.a(7.0F, (Resources)localObject4))
                {
                  ((RelativeLayout.LayoutParams)localObject5).addRule(10);
                  ((RelativeLayout.LayoutParams)localObject5).addRule(1, localView.getId());
                  ((RelativeLayout.LayoutParams)localObject5).leftMargin = i;
                  a((ViewGroup)localObject3, (View)localObject2, paramBundle);
                  a((ViewGroup)localObject3, localTextView, (RelativeLayout.LayoutParams)localObject1);
                  a((ViewGroup)localObject3, paramView, (RelativeLayout.LayoutParams)localObject1);
                  localTextViewWrapLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject5);
                  paramBundle = localTextViewWrapLayout;
                  localObject1 = null;
                  localView = paramView;
                  paramView = (View)localObject2;
                  break;
                  if (this.k == 3)
                  {
                    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.a(115.0F, (Resources)localObject4), AIOUtils.a(70.0F, (Resources)localObject4));
                    paramBundle.topMargin = AIOUtils.a(3.0F, (Resources)localObject4);
                    break label1031;
                  }
                  paramBundle = new RelativeLayout.LayoutParams(AIOUtils.a(70.0F, (Resources)localObject4), AIOUtils.a(70.0F, (Resources)localObject4));
                  break label1031;
                }
                label1344:
                ((RelativeLayout.LayoutParams)localObject1).leftMargin = i;
                paramBundle.leftMargin = i;
                paramBundle.addRule(1, localView.getId());
                paramBundle.addRule(11);
                paramBundle.addRule(6, localView.getId());
                ((RelativeLayout.LayoutParams)localObject1).addRule(11);
                ((RelativeLayout.LayoutParams)localObject1).addRule(1, localView.getId());
                a(localTextViewWrapLayout, (View)localObject2, paramBundle);
                a(localTextViewWrapLayout, localTextView, (RelativeLayout.LayoutParams)localObject1);
                a(localTextViewWrapLayout, paramView, (RelativeLayout.LayoutParams)localObject1);
                localObject1 = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2130903938, null);
                paramBundle = new RelativeLayout.LayoutParams(-1, -2);
                paramBundle.topMargin = 0;
                paramBundle.addRule(3, localView.getId());
                a(localTextViewWrapLayout, (View)localObject1, paramBundle);
                paramBundle = localTextViewWrapLayout;
                localView = paramView;
                paramView = (View)localObject2;
                break;
                ((RelativeLayout)localObject1).setVisibility(8);
                break label346;
                label1503:
                i = 0;
                break label402;
                label1509:
                i = 0;
                break label458;
                label1515:
                i = 0;
                break label498;
                label1521:
                a(paramView, 8);
                a(localTextView, 4);
                break label544;
                label1538:
                a(localTextView, 8);
                break label556;
                label1549:
                bool = false;
                break label611;
                label1555:
                break label498;
              }
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout2";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemLayout2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
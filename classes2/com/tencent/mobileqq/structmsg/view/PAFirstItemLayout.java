package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class PAFirstItemLayout
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AbsStructMsgItem jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public PAFirstItemLayout(AbsStructMsgItem paramAbsStructMsgItem, int paramInt, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem = paramAbsStructMsgItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private ImageView a(AbsStructMsgElement paramAbsStructMsgElement, Bundle paramBundle, View paramView)
  {
    paramBundle.putBoolean("useRadiusImage", true);
    paramAbsStructMsgElement = (ImageView)paramAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramBundle).findViewById(2131296359);
    if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof AnyScaleTypeImageView))) {
      ((AnyScaleTypeImageView)paramAbsStructMsgElement).setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    return paramAbsStructMsgElement;
  }
  
  private TextView a(StructMsgItemSummary paramStructMsgItemSummary, View paramView)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramView = new LinearLayout.LayoutParams(-1, -2);
      paramView.setMargins(0, 0, 0, 0);
      localTextView.setLayoutParams(paramView);
      localTextView.setMaxLines(3);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(2, 16.0F);
      localTextView.setLineSpacing(AIOUtils.a(2.5F, localResources), 1.0F);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      int i = AIOUtils.a(15.0F, localResources);
      int j = AIOUtils.a(12.0F, localResources);
      localTextView.setPadding(j, AIOUtils.a(18.0F, localResources), j, i);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramStructMsgItemSummary.b()))
      {
        localTextView.setText(paramStructMsgItemSummary.b());
        paramView = localTextView;
      }
    }
    do
    {
      return paramView;
      localTextView = (TextView)paramView;
      paramView = localTextView;
    } while (TextUtils.isEmpty(paramStructMsgItemSummary.b()));
    localTextView.setText(paramStructMsgItemSummary.b());
    return localTextView;
  }
  
  private TextView a(String paramString, View paramView)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131493121)));
      localTextView.setMaxLines(2);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 19.0F);
      localTextView.setMaxLines(2);
      localTextView.setLineSpacing(AIOUtils.a(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setBackgroundResource(2130838781);
      int i = AIOUtils.a(12.5F, localResources);
      int j = AIOUtils.a(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131296531);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView.setText(paramString);
        paramView = localTextView;
      }
    }
    do
    {
      return paramView;
      localTextView = (TextView)paramView;
      paramView = localTextView;
    } while (TextUtils.isEmpty(paramString));
    localTextView.setText(paramString);
    return localTextView;
  }
  
  public static boolean a(AbsStructMsgItem paramAbsStructMsgItem, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    if ((!paramBoolean) || (paramInt != 0)) {}
    int j;
    do
    {
      return false;
      int i = 0;
      j = 0;
      paramInt = 0;
      if (i < paramAbsStructMsgItem.jdField_a_of_type_JavaUtilArrayList.size())
      {
        String str = ((AbsStructMsgElement)paramAbsStructMsgItem.jdField_a_of_type_JavaUtilArrayList.get(i)).a;
        int m;
        int k;
        if ("picture".equals(str))
        {
          m = paramInt + 1;
          k = j;
        }
        for (;;)
        {
          i += 1;
          j = k;
          paramInt = m;
          break;
          k = j;
          m = paramInt;
          if ("summary".equals(str))
          {
            k = j;
            m = paramInt;
            if (paramInt != 0)
            {
              k = j + 1;
              m = paramInt;
            }
          }
        }
      }
      if (!(paramAbsStructMsgItem instanceof StructMsgItemLayout6)) {
        break;
      }
    } while ((paramInt != 1) || (j > 1));
    return true;
    if (paramInt >= 1) {}
    for (paramBoolean = bool;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    int j = 0;
    int m = 0;
    if (!a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean))
    {
      paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.a(paramContext, paramView, paramBundle);
      return paramContext;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    int k;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject2 = (LinearLayout)paramView;
      localObject1 = (FrameLayout)((LinearLayout)localObject2).findViewById(2131296533);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      if (localObject1 != null)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.jdField_a_of_type_JavaUtilArrayList.iterator();
        j = 0;
        i = 0;
        if (paramContext.hasNext())
        {
          paramView = (AbsStructMsgElement)paramContext.next();
          localObject3 = paramView.a;
          if ("title".equals(localObject3))
          {
            this.jdField_a_of_type_AndroidWidgetTextView = a(((StructMsgItemTitle)paramView).b(), ((FrameLayout)localObject1).findViewById(2131296531));
            k = j;
            j = i;
            i = k;
          }
          for (;;)
          {
            label169:
            k = j;
            j = i;
            i = k;
            break;
            if ("picture".equals(localObject3))
            {
              this.jdField_a_of_type_AndroidWidgetImageView = a(paramView, paramBundle, ((FrameLayout)localObject1).findViewById(2131296359));
              i = j;
              j = 1;
            }
            else
            {
              if (!"summary".equals(localObject3)) {
                break label800;
              }
              paramView = (StructMsgItemSummary)paramView;
              if ((i == 0) || (TextUtils.isEmpty(paramView.b()))) {
                break;
              }
              paramView = a(paramView, ((LinearLayout)localObject2).findViewById(j + 2131296529));
              this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
              k = j + 1;
              j = i;
              i = k;
            }
          }
        }
        ((LinearLayout)localObject2).removeViews(1, ((LinearLayout)localObject2).getChildCount() - 1);
        i = m;
        for (;;)
        {
          paramContext = (Context)localObject2;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          paramContext = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          paramContext.setId(2131296529 + i);
          ((LinearLayout)localObject2).addView(paramContext);
          i += 1;
        }
      }
      ((LinearLayout)localObject2).removeAllViews();
    }
    for (;;)
    {
      localObject3 = paramContext.getResources();
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        paramView = new LinearLayout(paramContext);
        paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        paramView.setOrientation(1);
        paramView.setId(2131296534);
      }
      if (localObject1 == null)
      {
        paramContext = new FrameLayout(paramContext);
        paramContext.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        paramContext.setId(2131296533);
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsgItem.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
          String str = ((AbsStructMsgElement)localObject2).a;
          if ("title".equals(str)) {
            this.jdField_a_of_type_AndroidWidgetTextView = a(((StructMsgItemTitle)localObject2).b(), null);
          }
          for (;;)
          {
            break;
            if ("picture".equals(str))
            {
              this.jdField_a_of_type_AndroidWidgetImageView = a((AbsStructMsgElement)localObject2, paramBundle, null);
              i = 1;
            }
            else if ("summary".equals(str))
            {
              localObject2 = (StructMsgItemSummary)localObject2;
              if ((i == 0) || (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).b()))) {
                break;
              }
              localObject2 = a((StructMsgItemSummary)localObject2, null);
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            }
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          paramView.addView(paramContext);
          paramBundle = new FrameLayout.LayoutParams(-1, ((Resources)localObject3).getDimensionPixelSize(2131493121));
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBundle);
          this.jdField_a_of_type_AndroidWidgetImageView.setMaxWidth(((Resources)localObject3).getDimensionPixelSize(2131493120));
          paramContext.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramBundle);
          if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
            this.jdField_a_of_type_AndroidWidgetTextView = a("", null);
          }
          paramContext.addView(this.jdField_a_of_type_AndroidWidgetTextView);
          i = j;
        }
        for (;;)
        {
          paramContext = paramView;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          paramContext = (TextView)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          paramContext.setId(2131296529 + i);
          paramView.addView(paramContext);
          i += 1;
          continue;
          i = j;
          if (this.jdField_a_of_type_AndroidWidgetTextView != null)
          {
            paramContext = new LinearLayout.LayoutParams(-2, -2);
            this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramContext);
            paramView.addView(this.jdField_a_of_type_AndroidWidgetTextView);
            i = j;
          }
        }
        paramContext = (Context)localObject1;
      }
      label800:
      k = i;
      i = j;
      j = k;
      break label169;
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\PAFirstItemLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
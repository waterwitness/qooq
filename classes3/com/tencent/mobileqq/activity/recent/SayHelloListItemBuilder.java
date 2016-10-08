package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloListItemBuilder
  extends RecentItemBaseBuilder
{
  public static final String b = "SayHelloListItemBuilder";
  private List a;
  
  public SayHelloListItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramOnDragModeChangedListener;
        if ((paramView.getTag() instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {
          paramViewGroup = (SayHelloListItemBuilder.SayHelloListItemHolder)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new SayHelloListItemBuilder.SayHelloListItemHolder();
      paramView = super.a(paramContext, 2130904325, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302334));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297741));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131298785));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131298402));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298510));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298398));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301428));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131301429));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131298400));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298505));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131298506));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131298502));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null) {
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof SayHelloListItemBuilder.SayHelloListItemHolder)) {}
    for (SayHelloListItemBuilder.SayHelloListItemHolder localSayHelloListItemHolder = (SayHelloListItemBuilder.SayHelloListItemHolder)localObject;; localSayHelloListItemHolder = null)
    {
      if (localSayHelloListItemHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      RecentSayHelloListItem localRecentSayHelloListItem;
      label141:
      label158:
      int i;
      if ((paramRecentBaseData instanceof RecentSayHelloListItem))
      {
        localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
        if (localRecentSayHelloListItem.P <= 0) {
          break label546;
        }
        localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (localRecentSayHelloListItem.P != 1) {
          break label532;
        }
        localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843363);
        localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131428329));
        localObject = localRecentSayHelloListItem.jdField_b_of_type_JavaLangString;
        CharSequence localCharSequence = localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        i = paramRecentBaseData.J;
        paramDrawable = paramRecentBaseData.c;
        if (paramDrawable == null) {
          break label576;
        }
        paramDrawable = paramDrawable.toString();
        if (!TextUtils.isEmpty(paramDrawable)) {
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
        localObject = localRecentSayHelloListItem.jdField_b_of_type_JavaLangCharSequence;
        localCharSequence = localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (paramDrawable.equals(localCharSequence)) {}
      }
      try
      {
        localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
        localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
        if (paramRecentBaseData.F == 4) {
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130838409), null);
        }
        paramDrawable = localRecentSayHelloListItem.c;
        localObject = localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText();
        paramContext = paramDrawable;
        if (paramDrawable == null) {
          paramContext = "";
        }
        if (!paramContext.equals(localObject)) {
          localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext);
        }
        m = localRecentSayHelloListItem.H;
        i = localRecentSayHelloListItem.G;
        if (m > 0) {
          if (i == 0)
          {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
            k = 99;
            m = 0;
            j = 0;
            i = 0;
            CustomWidgetUtil.a(localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
            if (localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
              localSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            a(localSayHelloListItemHolder, localRecentSayHelloListItem);
            if (!AppSetting.j) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.jdField_d_of_type_JavaLangString);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("SayHelloListItemBuilder", 2, "data is not RecentSayHelloItem");
            }
            throw new RuntimeException("data is null");
            label532:
            localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843496);
            break label141;
            label546:
            localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131428297));
            localSayHelloListItemHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
            break label158;
            label576:
            paramDrawable = "";
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int m;
          int k;
          int j;
          localException.printStackTrace();
          localSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
          continue;
          if (i == 2)
          {
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
            m = 0;
            j = 0;
            i = 1;
            k = 99;
          }
          else if (i == 3)
          {
            j = 2130843326;
            if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
            k = 99;
            i = 3;
          }
          else
          {
            j = 2130843325;
            localSayHelloListItemHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            k = 99;
            i = 3;
            continue;
            k = 99;
            m = 0;
            j = 0;
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(SayHelloListItemBuilder.SayHelloListItemHolder paramSayHelloListItemHolder, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int j;
    if (paramRecentSayHelloListItem.Q > 0)
    {
      paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(paramRecentSayHelloListItem.Q));
      i = 1;
      localStringBuilder.append(paramRecentSayHelloListItem.jdField_b_of_type_JavaLangString);
      switch (paramRecentSayHelloListItem.R)
      {
      default: 
        paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840964);
        j = 2130838639;
      }
    }
    for (;;)
    {
      label87:
      if ((AppSetting.j) && (paramRecentSayHelloListItem.Q > 0)) {
        localStringBuilder.append(paramRecentSayHelloListItem.Q).append("岁");
      }
      paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
      label143:
      label168:
      String str;
      if (i != 0)
      {
        paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        j = 1;
        if ((paramRecentSayHelloListItem.S > 0) && (paramRecentSayHelloListItem.S < 14)) {
          break label677;
        }
        paramSayHelloListItemHolder.d.setVisibility(8);
        str = ProfileCardUtil.a((byte)paramRecentSayHelloListItem.T);
        if (!TextUtils.isEmpty(str)) {
          break label757;
        }
        paramSayHelloListItemHolder.e.setVisibility(8);
        label195:
        if (!paramRecentSayHelloListItem.jdField_d_of_type_Boolean) {
          break label859;
        }
        if (paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        j += 1;
        switch (paramRecentSayHelloListItem.U)
        {
        default: 
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840884);
          label266:
          i = j;
          if (AppSetting.j)
          {
            localStringBuilder.append(",").append("拥有魅力勋章");
            i = j;
          }
          label294:
          if ((paramRecentSayHelloListItem.V > 0) && (!TextUtils.isEmpty(paramRecentSayHelloListItem.a)))
          {
            int m = i + 1;
            paramSayHelloListItemHolder.e.setVisibility(8);
            paramSayHelloListItemHolder.f.setVisibility(0);
            paramSayHelloListItemHolder.f.setText(paramRecentSayHelloListItem.a);
            paramSayHelloListItemHolder.f.setTag(Integer.valueOf(paramRecentSayHelloListItem.V));
            i = m;
            j = k;
            if (AppSetting.j)
            {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.a);
              j = k;
              i = m;
            }
          }
          break;
        }
      }
      for (;;)
      {
        if (j == 0)
        {
          paramSayHelloListItemHolder.f.setVisibility(8);
          paramSayHelloListItemHolder.f.setTag(Integer.valueOf(0));
        }
        if (i > 0) {
          paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          if (AppSetting.j)
          {
            if (paramRecentSayHelloListItem.H > 0) {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.H).append("条未读消息");
            }
            localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
            localStringBuilder.append(",").append(paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
            if (localStringBuilder.length() > 0) {
              paramRecentSayHelloListItem.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
            }
          }
          return;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
          i = 0;
          break;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840964);
          if (!AppSetting.j) {
            break label914;
          }
          localStringBuilder.append(",").append("男");
          j = 2130838639;
          i = 1;
          break label87;
          j = 2130838634;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130840963);
          if (!AppSetting.j) {
            break label908;
          }
          localStringBuilder.append(",").append("女");
          i = 1;
          break label87;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          j = 0;
          break label143;
          label677:
          i = j + 1;
          paramSayHelloListItemHolder.d.setText(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.S]);
          paramSayHelloListItemHolder.d.setBackgroundResource(com.tencent.mobileqq.util.NearbyProfileUtil.jdField_a_of_type_ArrayOfInt[paramRecentSayHelloListItem.S]);
          paramSayHelloListItemHolder.d.setVisibility(0);
          j = i;
          if (!AppSetting.j) {
            break label168;
          }
          localStringBuilder.append(",").append(com.tencent.mobileqq.util.NearbyProfileUtil.e[paramRecentSayHelloListItem.S]);
          j = i;
          break label168;
          label757:
          i = j + 1;
          paramSayHelloListItemHolder.e.setText(str);
          paramSayHelloListItemHolder.e.setBackgroundResource(2130840975);
          paramSayHelloListItemHolder.e.setVisibility(0);
          j = i;
          if (!AppSetting.j) {
            break label195;
          }
          localStringBuilder.append(",").append(str);
          j = i;
          break label195;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840889);
          break label266;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840890);
          break label266;
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840891);
          break label266;
          label859:
          i = j;
          if (paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8) {
            break label294;
          }
          paramSayHelloListItemHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          i = j;
          break label294;
          paramSayHelloListItemHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
        j = 0;
      }
      label908:
      i = 1;
      continue;
      label914:
      j = 2130838639;
      i = 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\SayHelloListItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
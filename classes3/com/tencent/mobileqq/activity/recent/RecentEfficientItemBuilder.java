package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class RecentEfficientItemBuilder
  extends RecentItemBaseBuilder
{
  public static final int a = 3;
  private static final String b = "RecentDefaultItemBuilder";
  private List a;
  
  public RecentEfficientItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    Object localObject;
    if ((paramView != null) && ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)))
    {
      paramOnDragModeChangedListener = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramOnDragModeChangedListener;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.j) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label511;
      }
      localObject = (RecentBaseData)paramObject;
      paramOnDragModeChangedListener = null;
      if (paramRecentFaceDecoder != null) {
        paramOnDragModeChangedListener = paramRecentFaceDecoder.a((RecentBaseData)localObject);
      }
      a(paramViewGroup, (RecentBaseData)localObject, paramContext, paramOnDragModeChangedListener);
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setOnClickListener(paramOnClickListener);
        paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.j) {
          paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setContentDescription(String.format("点击进入%1$s资料卡页面", new Object[] { ((RecentBaseData)localObject).jdField_b_of_type_JavaLangString }));
        }
      }
    }
    for (;;)
    {
      if ((PublicAccountConfigUtil.b) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramOnDragModeChangedListener = new RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder();
      localObject = a(paramContext, 2130904906, paramOnDragModeChangedListener);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131296790));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131298785));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject).findViewById(2131297123));
      paramOnDragModeChangedListener.b = ((SingleLineTextView)((View)localObject).findViewById(2131298722));
      paramOnDragModeChangedListener.b.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = DeviceInfoUtil.a();
      paramView = paramViewGroup.getColorStateList(2131428305);
      paramViewGroup = paramViewGroup.getColorStateList(2131428267);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramViewGroup);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
      paramOnDragModeChangedListener.b.setTextColor(paramView);
      paramOnDragModeChangedListener.b.setExtendTextPadding((int)(f * 2.0F), 1);
      paramOnDragModeChangedListener.b.setExtendTextSize(14.0F, 1);
      ((View)localObject).setTag(paramOnDragModeChangedListener);
      paramViewGroup = (ViewGroup)localObject;
      paramView = paramOnDragModeChangedListener;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
        break;
      }
      paramOnDragModeChangedListener.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
      paramViewGroup = (ViewGroup)localObject;
      paramView = paramOnDragModeChangedListener;
      break;
      label511:
      paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
      paramView.b.setText("");
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.K;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      j = i & 0xF0;
      if (j != 32) {
        break label115;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label115:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramDrawable == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder));
      paramView = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView;
    } while (paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView == null);
    paramView.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder));
      paramView = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView;
    } while (paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView == null);
    paramView.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_b_of_type_JavaLangString);
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
    if ((paramView.getTag() instanceof RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)) {}
    for (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder localRecentEfficientItemBuilderHolder = (RecentEfficientItemBuilder.RecentEfficientItemBuilderHolder)paramView.getTag();; localRecentEfficientItemBuilderHolder = null)
    {
      if (localRecentEfficientItemBuilderHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      String str;
      boolean bool;
      if (a(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecentDefaultItemBuilder", 2, "bindview user:" + paramRecentBaseData.a());
        }
        paramContext = ((BaseActivity)paramContext).app;
        j = ((Integer)RecentFaceDecoder.a(paramContext, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
        str = paramRecentBaseData.a();
        if (paramContext.a.a() == 1) {
          bool = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable(paramContext, paramDrawable, i, str, 100, false, bool, 0);
        label215:
        localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.I);
        paramContext = paramRecentBaseData.jdField_a_of_type_JavaLangCharSequence;
        if (paramContext != null)
        {
          paramContext = paramContext.toString();
          label244:
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramContext, 2);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramRecentBaseData.jdField_c_of_type_JavaLangString, 0);
          localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramRecentBaseData.jdField_b_of_type_JavaLangString);
          switch (paramRecentBaseData.F)
          {
          default: 
            i = 0;
            label319:
            localRecentEfficientItemBuilderHolder.b.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.J;
            paramContext = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence;
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              paramDrawable = paramContext;
              if (paramContext != null)
              {
                paramDrawable = paramContext;
                if (paramContext.length() > 0)
                {
                  paramDrawable = paramContext;
                  if (!paramContext.endsWith(" ")) {
                    paramDrawable = paramContext + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
                localRecentEfficientItemBuilderHolder.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              localRecentEfficientItemBuilderHolder.b.setExtendText(paramDrawable, 1);
            }
            break;
          }
        }
        try
        {
          localRecentEfficientItemBuilderHolder.b.setText(paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence);
          m = paramRecentBaseData.H;
          j = 0;
          i = paramRecentBaseData.G;
          if (m > 0) {
            if (i == 0)
            {
              i = 0;
              j = 0;
              m = 0;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              CustomWidgetUtil.a(localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if ((paramRecentBaseData.K & 0xF0) != 32) {
                break label805;
              }
              localRecentEfficientItemBuilderHolder.e.setBackgroundResource(2130838315);
              if (AppSetting.j) {
                paramView.setContentDescription(paramRecentBaseData.d);
              }
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.a(paramRecentBaseData.c());
              return;
              bool = false;
              continue;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
              break label215;
              paramContext = "";
              break label244;
              i = 2130839132;
              break label319;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130839138;
                break label319;
              }
              i = 2130839132;
              break label319;
              if (paramRecentBaseData.jdField_a_of_type_Boolean)
              {
                i = 2130839138;
                break label319;
              }
              i = 2130839139;
              break label319;
              i = 2130839139;
              break label319;
              i = 2130838409;
              break label319;
              paramContext = "";
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            int m;
            int k;
            paramContext.printStackTrace();
            localRecentEfficientItemBuilderHolder.b.setText(paramRecentBaseData.jdField_b_of_type_JavaLangCharSequence + " ");
            continue;
            if (i == 2)
            {
              i = 1;
              j = 0;
              m = 0;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
            }
            else if (i == 3)
            {
              i = 3;
              j = 2130843326;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
              k = 99;
            }
            else
            {
              i = 3;
              j = 2130843325;
              localRecentEfficientItemBuilderHolder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              k = 99;
              continue;
              label805:
              localRecentEfficientItemBuilderHolder.e.setBackgroundResource(2130838314);
              continue;
              m = 0;
              i = 0;
              k = 99;
            }
          }
        }
      }
    }
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 1021) || (i == 1022) || (i == 1023);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentEfficientItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
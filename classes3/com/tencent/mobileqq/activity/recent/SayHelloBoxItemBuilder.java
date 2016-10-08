package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.CustomWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class SayHelloBoxItemBuilder
  extends RecentItemBaseBuilder
{
  private static final int jdField_a_of_type_Int = -1;
  protected RecentFaceDecoder a;
  private List jdField_a_of_type_JavaUtilList;
  
  public SayHelloBoxItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = paramRecentFaceDecoder;
    paramViewGroup = null;
    paramRecentFaceDecoder = paramViewGroup;
    if (paramView != null)
    {
      paramRecentFaceDecoder = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramRecentFaceDecoder = paramViewGroup;
        if ((paramView.getTag() instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder)) {
          paramRecentFaceDecoder = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView.getTag();
        }
      }
    }
    if (paramRecentFaceDecoder == null)
    {
      paramViewGroup = new SayHelloBoxItemBuilder.SayHelloBoxItemHolder();
      paramOnDragModeChangedListener = super.a(paramContext, 2130904239, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramOnDragModeChangedListener.findViewById(2131301930));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramOnDragModeChangedListener.findViewById(2131300667));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramOnDragModeChangedListener.findViewById(2131301933));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramOnDragModeChangedListener.findViewById(2131301931));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramOnDragModeChangedListener.findViewById(2131301932));
      paramRecentFaceDecoder = paramContext.getResources();
      paramView = paramRecentFaceDecoder.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramRecentFaceDecoder.getDimensionPixelSize(2131493500);
      int k = paramRecentFaceDecoder.getDimensionPixelSize(2131493501);
      if (i <= 0)
      {
        i = 45;
        int j = k;
        if (k <= 0) {
          j = 10;
        }
        m /= (i + j);
        k = m;
        if (m > 6) {
          k = 6;
        }
        paramRecentFaceDecoder = new SayHelloBoxItemBuilder.MsgHeaderAdapter(this, paramContext, k, i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramRecentFaceDecoder);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        paramOnDragModeChangedListener.setTag(paramViewGroup);
        paramView = paramOnDragModeChangedListener;
        paramRecentFaceDecoder = paramViewGroup;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a());
          paramRecentFaceDecoder = paramViewGroup;
          paramView = paramOnDragModeChangedListener;
        }
      }
    }
    for (;;)
    {
      paramRecentFaceDecoder.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130840956);
      if ((paramRecentFaceDecoder != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramRecentFaceDecoder, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.j) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramRecentFaceDecoder != null)
        {
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
          paramRecentFaceDecoder.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramRecentFaceDecoder.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
      break;
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
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    label151:
    label262:
    label269:
    label411:
    for (;;)
    {
      return;
      Object localObject = paramView.getTag();
      if ((localObject instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder))
      {
        localObject = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject;
        RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131372098);
        int k = paramRecentBaseData.H;
        int i = 0;
        int j = 0;
        int m = paramRecentBaseData.G;
        if (k > 0)
        {
          if (m == 3)
          {
            i = 3;
            j = 2130843326;
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
          }
        }
        else
        {
          CustomWidgetUtil.a(((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
          i = paramRecentBaseData.J;
          paramDrawable = paramRecentBaseData.c;
          if (paramDrawable == null) {
            break label262;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          if (TextUtils.isEmpty(localRecentSayHelloBoxItem.b)) {
            break label269;
          }
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.b);
        }
        for (;;)
        {
          if (!AppSetting.j) {
            break label411;
          }
          paramView.setContentDescription(paramRecentBaseData.d);
          return;
          i = 3;
          j = 2130843325;
          ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
          break;
          paramDrawable = "";
          break label151;
          if ((localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList != null) && (localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList.size() > 0))
          {
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131428302));
            if (((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() != null) {
              SayHelloBoxItemBuilder.MsgHeaderAdapter.a((SayHelloBoxItemBuilder.MsgHeaderAdapter)((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.jdField_a_of_type_JavaUtilList);
            }
          }
          else
          {
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.b);
            ((SayHelloBoxItemBuilder.SayHelloBoxItemHolder)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131428302));
          }
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null) || (paramDrawable == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag();
      if ((paramView instanceof SayHelloBoxItemBuilder.SayHelloBoxItemHolder))
      {
        paramView = (SayHelloBoxItemBuilder.SayHelloBoxItemHolder)paramView;
        int j = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getCount();
        int i = 0;
        while (i < j)
        {
          paramRecentBaseData = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
          if ((paramRecentBaseData != null) && ((paramRecentBaseData.getTag(-1) instanceof String)))
          {
            String str = (String)paramRecentBaseData.getTag(-1);
            if (str.equals(paramMessageRecord.senderuin))
            {
              ((CustomImgView)paramRecentBaseData).setImageDrawable(paramDrawable);
              return;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SAYHELL_BOX", 4, "updateMsgHeader,childView uin:" + str);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\SayHelloBoxItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
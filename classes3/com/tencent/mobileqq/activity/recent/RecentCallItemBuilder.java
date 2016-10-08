package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.utils.PstnUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import cooperation.huangye.HuangyeImageUtils;
import java.util.ArrayList;
import java.util.List;
import oxq;

public class RecentCallItemBuilder
  extends RecentItemBaseBuilder
  implements View.OnTouchListener
{
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecentCallItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
  }
  
  public RecentCallItemBuilder(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramOnDragModeChangedListener = null;
    paramViewGroup = paramOnDragModeChangedListener;
    if (paramView != null)
    {
      paramViewGroup = paramOnDragModeChangedListener;
      if ((paramView.getTag() instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {
        paramViewGroup = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new RecentCallItemBuilder.RecentCallItemBuilderViewHolder();
      if (this.jdField_a_of_type_Int == 1)
      {
        paramView = a(paramContext, 2130904124, paramViewGroup);
        paramView.findViewById(2131299798).setPadding(0, 0, paramContext.getResources().getDisplayMetrics().widthPixels * 25 / 360, 0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131296816));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296790));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301463));
        paramViewGroup.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301464));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297741));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setMaxWidth(paramContext.getResources().getDisplayMetrics().widthPixels * 145 / 360);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301469));
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301471));
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908309));
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301466));
        paramViewGroup.f = ((TextView)paramView.findViewById(2131301467));
        paramViewGroup.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301470));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301465));
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      if (AppSetting.j) {
        paramView.setContentDescription(null);
      }
      if ((paramObject instanceof RecentBaseData))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramOnDragModeChangedListener = null;
        if (paramRecentFaceDecoder != null)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a() == 4) && ((localRecentBaseData instanceof RecentCallItem)) && (localRecentBaseData.a() == 3000)) {
            ((RecentCallItem)localRecentBaseData).c = true;
          }
          paramOnDragModeChangedListener = paramRecentFaceDecoder.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramOnDragModeChangedListener);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnLongClickListener(paramOnLongClickListener);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setTag(paramView);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(new oxq(this));
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramView = a(paramContext, 2130904120, paramViewGroup);
        break;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_e_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText("");
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public List a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(2131368306));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
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
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      paramView = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (paramView.jdField_a_of_type_AndroidWidgetImageView == null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    RecentCallItemBuilder.RecentCallItemBuilderViewHolder localRecentCallItemBuilderViewHolder;
    do
    {
      do
      {
        return;
        paramView = paramView.getTag();
      } while (!(paramView instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder));
      localRecentCallItemBuilderViewHolder = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)paramView;
    } while (localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView == null);
    paramView = paramRecentBaseData.b;
    if (((paramRecentBaseData instanceof RecentCallItem)) && (((RecentCallItem)paramRecentBaseData).b())) {
      paramView = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, paramRecentBaseData.a());
    }
    for (;;)
    {
      localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      return;
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
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof RecentCallItemBuilder.RecentCallItemBuilderViewHolder)) {}
    for (RecentCallItemBuilder.RecentCallItemBuilderViewHolder localRecentCallItemBuilderViewHolder = (RecentCallItemBuilder.RecentCallItemBuilderViewHolder)localObject1;; localRecentCallItemBuilderViewHolder = null)
    {
      if (localRecentCallItemBuilderViewHolder == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject1);
        return;
      }
      localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      int m = paramRecentBaseData.I;
      RecentCallItem localRecentCallItem = (RecentCallItem)paramRecentBaseData;
      long l = localRecentCallItem.a;
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallItemBuilder", 2, "zswzsw number = " + l);
      }
      Object localObject3 = localRecentCallItem.a();
      label280:
      int j;
      int i;
      if ((((QCallRecent)localObject3).type == 56938) || (((QCallRecent)localObject3).type == 3) || (((QCallRecent)localObject3).type == 4) || (((QCallRecent)localObject3).type == 5) || (((QCallRecent)localObject3).type == 2016) || ((((QCallRecent)localObject3).type == 26) && (!OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, ((QCallRecent)localObject3).uin))))
      {
        localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839106);
        if (localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          if (paramRecentBaseData.b != null) {
            localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.d(paramRecentBaseData.b));
          }
        }
        if (m != 0) {
          break label1277;
        }
        j = paramRecentBaseData.H;
        i = 2130840619;
      }
      for (;;)
      {
        label296:
        int k = i;
        if (l > 0L)
        {
          k = i;
          if (m != 3) {
            k = 2130840622;
          }
        }
        if (m == 6)
        {
          k = 2130840622;
          label334:
          if (k != 0) {
            break label1355;
          }
          localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          label349:
          if (m != 0) {
            break label1377;
          }
          i = 2131428331;
          label359:
          paramDrawable = paramRecentBaseData.b;
          if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
            break label2570;
          }
          paramDrawable = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a, paramRecentBaseData.a());
        }
        label530:
        label653:
        label661:
        label784:
        label945:
        label1277:
        label1355:
        label1377:
        label1540:
        label1563:
        label1585:
        label2013:
        label2126:
        label2170:
        label2260:
        label2452:
        label2495:
        label2555:
        label2561:
        label2570:
        for (;;)
        {
          localObject1 = localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getText();
          if (paramDrawable == null) {
            paramDrawable = "";
          }
          for (;;)
          {
            k = 0;
            if ((localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getTag() instanceof Integer)) {
              k = ((Integer)localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.getTag()).intValue();
            }
            if (k != i)
            {
              localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(i));
              localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(i));
            }
            if (!paramDrawable.equals(localObject1)) {
              localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
            }
            if ((m == 0) && (j >= 2)) {
              if (j > 99)
              {
                paramDrawable = " [99+]";
                if (!paramDrawable.equals(localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetTextView.getText())) {
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetTextView.setText(paramDrawable);
                }
                paramDrawable = (PstnManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(142);
                if ((paramDrawable == null) || (paramDrawable.a() != 1)) {
                  break label2561;
                }
              }
            }
            for (i = 1;; i = 0)
            {
              paramDrawable = null;
              k = paramRecentBaseData.K & 0xF000;
              if ((k == 12288) && (((QCallRecent)localObject3).isSystemCall != 1))
              {
                if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                }
                if (i != 0)
                {
                  j = 2131371106;
                  localObject1 = paramContext.getString(j);
                  CharSequence localCharSequence = localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText();
                  paramDrawable = (Drawable)localObject1;
                  if (localObject1 == null) {
                    paramDrawable = "";
                  }
                  if (!paramDrawable.equals(localCharSequence)) {
                    localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramDrawable);
                  }
                  if ((paramRecentBaseData.I == 3) || (l > 0L) || (paramRecentBaseData.I == 4) || (paramRecentBaseData.I == 5) || (paramRecentBaseData.I == 6) || (paramRecentBaseData.I == 7))
                  {
                    if (TextUtils.isEmpty(paramRecentBaseData.f)) {
                      break label1540;
                    }
                    localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.f);
                    localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("RecentCallItemBuilder", 2, "call.callType = " + ((QCallRecent)localObject3).callType + ", isVideo : " + ((QCallRecent)localObject3).isVideo());
                  }
                  if (i == 0) {
                    break label2126;
                  }
                  localRecentCallItemBuilderViewHolder.f.setText(paramRecentBaseData.c);
                  localRecentCallItemBuilderViewHolder.f.setVisibility(0);
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838970);
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131363976));
                  if ((paramRecentBaseData.I != 3) && (l <= 0L)) {
                    break label1585;
                  }
                  if ((TextUtils.isEmpty(((QCallRecent)localObject3).pstnInfo)) || (((QCallRecent)localObject3).pstnInfo.equals("[]"))) {
                    break label1563;
                  }
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                  paramDrawable = paramContext.getString(2131371146);
                }
              }
              try
              {
                localObject1 = localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getText().toString();
                if ((localObject1 == null) || ("".equals(localObject1))) {
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  continue;
                  Object localObject2 = null;
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("RecentCallItemBuilder", 2, "item.mAuthenIconId：" + paramRecentBaseData.I + ", item.mTitleName:" + paramRecentBaseData.b);
              }
              localObject1 = paramDrawable;
              if (((QCallRecent)localObject3).isSystemCall == 1)
              {
                if (((QCallRecent)localObject3).type != 26) {
                  break label2495;
                }
                localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                localObject1 = paramDrawable;
                if (!paramDrawable.equals(paramContext.getString(2131371152))) {
                  localObject1 = paramContext.getString(2131371158) + " " + paramDrawable;
                }
              }
              for (;;)
              {
                localObject3 = localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.getText();
                paramDrawable = (Drawable)localObject1;
                if (localObject1 == null) {
                  paramDrawable = "";
                }
                if (!paramDrawable.equals(localObject3)) {
                  localRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(paramDrawable);
                }
                a(localRecentCallItemBuilderViewHolder, paramRecentBaseData, paramContext);
                localRecentCallItemBuilderViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout.setVisibility(8);
                if (!AppSetting.j) {
                  break;
                }
                paramView.setContentDescription(paramRecentBaseData.d);
                return;
                if (((QCallRecent)localObject3).type == 9502)
                {
                  if (localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
                    localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                  }
                  HuangyeImageUtils.a(localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView, ((QCallRecent)localObject3).businessLogo, true, true, paramRecentBaseData.b);
                  break label280;
                }
                localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
                if (localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView == null) {
                  break label280;
                }
                localRecentCallItemBuilderViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                break label280;
                if (m <= 1)
                {
                  j = 0;
                  i = 2130840608;
                  break label296;
                }
                if (m <= 2)
                {
                  j = 0;
                  i = 2130840613;
                  break label296;
                }
                if (m > 3) {
                  break label2573;
                }
                j = 0;
                i = 2130840611;
                break label296;
                if ((m != 5) && (m != 4) && (m != 7)) {
                  break label334;
                }
                k = 2130840611;
                break label334;
                localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
                localRecentCallItemBuilderViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(k);
                break label349;
                i = 2131428267;
                break label359;
                paramDrawable = " [" + j + "]";
                break label530;
                paramDrawable = "";
                break label530;
                j = 2131371105;
                break label653;
                if ((k == 16384) && (((QCallRecent)localObject3).isSystemCall != 1))
                {
                  localObject1 = paramDrawable;
                  if (!QLog.isColorLevel()) {
                    break label661;
                  }
                  QLog.d("RecentCallItemBuilder", 2, "type = " + k + ", isVideo : " + ((QCallRecent)localObject3).isVideo());
                  localObject1 = paramDrawable;
                  break label661;
                }
                localObject1 = paramDrawable;
                if (localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                  break label661;
                }
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                localObject1 = paramDrawable;
                break label661;
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText("");
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                break label784;
                localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                paramDrawable = paramContext.getString(2131371145);
                break label945;
                if (paramRecentBaseData.I == 4)
                {
                  paramDrawable = paramContext.getString(2131371151);
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  break label945;
                }
                if ((paramRecentBaseData.I == 5) || (paramRecentBaseData.I == 7))
                {
                  paramDrawable = paramContext.getString(2131371152);
                  if (paramRecentBaseData.I == 7)
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    break label945;
                  }
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  break label945;
                }
                if (paramRecentBaseData.I == 6)
                {
                  paramDrawable = paramContext.getString(2131371153);
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  break label945;
                }
                if (((QCallRecent)localObject3).type == 3000)
                {
                  if ((!TextUtils.isEmpty(((QCallRecent)localObject3).pstnInfo)) && (!((QCallRecent)localObject3).pstnInfo.equals("[]")))
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    break label945;
                  }
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  paramDrawable = paramContext.getString(2131363439);
                  break label945;
                }
                if (((QCallRecent)localObject3).type == 26)
                {
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                  paramDrawable = OpenSDKUtils.a(((QCallRecent)localObject3).uin);
                  if (!paramDrawable.equals(localRecentCallItem.b)) {
                    break label945;
                  }
                  paramDrawable = "";
                  break label945;
                }
                if (((QCallRecent)localObject3).callType == 2)
                {
                  switch (((QCallRecent)localObject3).type)
                  {
                  }
                  for (;;)
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    break;
                    paramDrawable = ((QCallRecent)localObject3).displayName;
                    continue;
                    paramDrawable = PstnUtils.a(((QCallRecent)localObject3).displayName);
                    if (paramDrawable != null)
                    {
                      paramDrawable = paramDrawable.telInfo.mobile;
                    }
                    else
                    {
                      paramDrawable = ((QCallRecent)localObject3).displayName;
                      continue;
                      if (((QCallRecent)localObject3).phoneNumber != null) {}
                      for (localObject1 = ((QCallRecent)localObject3).phoneNumber;; localObject1 = ((PhoneContact)localObject1).mobileNo)
                      {
                        if (localObject1 == null) {
                          break label2013;
                        }
                        paramDrawable = PhoneContactHelper.a((String)localObject1);
                        break;
                        if (!(paramContext instanceof BaseActivity)) {
                          break label2555;
                        }
                        localObject1 = ((PhoneContactManager)((BaseActivity)paramContext).app.getManager(10)).a(((QCallRecent)localObject3).uin);
                        if (localObject1 == null) {
                          break label2555;
                        }
                      }
                    }
                  }
                }
                if ((((QCallRecent)localObject3).callType == 1) && (k != 12288))
                {
                  if (((QCallRecent)localObject3).type == 8)
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    paramDrawable = "";
                    break label945;
                  }
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  paramDrawable = paramContext.getString(2131363439);
                  break label945;
                }
                if ((k == 16384) && (((QCallRecent)localObject3).isSystemCall != 1))
                {
                  paramDrawable = paramContext.getString(2131363439);
                  break label945;
                }
                paramDrawable = "";
                localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                break label945;
                localRecentCallItemBuilderViewHolder.f.setVisibility(8);
                if (((QCallRecent)localObject3).isVideo())
                {
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841042);
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131363975));
                  if ((paramRecentBaseData.I != 3) && (l <= 0L)) {
                    break label2260;
                  }
                  localObject1 = paramContext.getString(2131371145);
                  localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                }
                for (;;)
                {
                  if (((QCallRecent)localObject3).isSystemCall != 1) {
                    break label2452;
                  }
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841343);
                  paramDrawable = (Drawable)localObject1;
                  break;
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839237);
                  localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(paramContext.getString(2131363974));
                  break label2170;
                  if (paramRecentBaseData.I == 4)
                  {
                    localObject1 = paramContext.getString(2131371151);
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                  else if (paramRecentBaseData.I == 5)
                  {
                    localObject1 = paramContext.getString(2131371152);
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                  else if (paramRecentBaseData.I == 6)
                  {
                    localObject1 = paramContext.getString(2131371153);
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                  else if (((QCallRecent)localObject3).type == 8)
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    localObject1 = paramRecentBaseData.c;
                  }
                  else if (((QCallRecent)localObject3).type == 26)
                  {
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
                    localObject1 = OpenSDKUtils.a(((QCallRecent)localObject3).uin);
                    if (((String)localObject1).equals(localRecentCallItem.b)) {
                      localObject1 = paramRecentBaseData.c;
                    }
                  }
                  else
                  {
                    localObject1 = paramRecentBaseData.c;
                    localRecentCallItemBuilderViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
                  }
                }
                if (((QCallRecent)localObject3).type != 9502)
                {
                  paramDrawable = (Drawable)localObject1;
                  if (((QCallRecent)localObject3).type != 26) {
                    break label945;
                  }
                }
                localRecentCallItemBuilderViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841343);
                paramDrawable = (Drawable)localObject1;
                break label945;
                if (i != 0) {
                  localObject1 = paramContext.getString(2131371158);
                } else {
                  localObject1 = paramContext.getString(2131371159) + " " + paramRecentBaseData.c;
                }
              }
            }
          }
        }
        label2573:
        j = 0;
        i = 0;
      }
    }
  }
  
  protected void a(RecentCallItemBuilder.RecentCallItemBuilderViewHolder paramRecentCallItemBuilderViewHolder, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentCallItemBuilderViewHolder == null) || (paramRecentBaseData == null)) {
      return;
    }
    if (paramRecentBaseData.N == 0)
    {
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    int i;
    switch (paramRecentBaseData.F)
    {
    default: 
      i = 0;
      label63:
      AccessibilityUtil.a(paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView);
      if (i == 0) {
        paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 1) {
        paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (!(paramRecentBaseData instanceof RecentCallItem)) {
        break;
      }
      paramContext = (PstnManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(142);
      if ((paramContext == null) || (paramContext.a() != 1)) {
        break;
      }
      paramRecentBaseData = ((RecentCallItem)paramRecentBaseData).a();
      if ((paramRecentBaseData == null) || ((paramRecentBaseData.callType != 2) && (paramRecentBaseData.type != 26))) {
        break;
      }
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      i = 2130840598;
      break label63;
      i = 2130840600;
      break label63;
      i = 2130840604;
      break label63;
      i = 2130840596;
      break label63;
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramRecentCallItemBuilderViewHolder.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      paramView.setDuplicateParentStateEnabled(false);
      paramView.setPressed(true);
      return true;
    }
    paramView.setDuplicateParentStateEnabled(true);
    paramView.setPressed(false);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentCallItemBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
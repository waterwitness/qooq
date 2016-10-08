package com.tencent.widget;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xsm;

public class ActionSheetAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  Context jdField_a_of_type_AndroidContentContext;
  final List jdField_a_of_type_JavaUtilList;
  
  public ActionSheetAdapter(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static ActionSheet a(Context paramContext, ActionSheetAdapter paramActionSheetAdapter, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ActionSheet.OnButtonClickListener paramOnButtonClickListener, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramActionSheetAdapter == null) {
        return null;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2130905086, null);
      paramContext.setBackgroundResource(2130837530);
      paramContext.setAdapter(paramActionSheetAdapter);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localActionSheet.a(paramContext);
      localActionSheet.d(2131367262);
      if (paramBoolean) {
        localActionSheet.setOnDismissListener(new xsm(paramOnDismissListener));
      }
      for (;;)
      {
        localActionSheet.a(paramOnButtonClickListener);
        return localActionSheet;
        localActionSheet.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static ActionSheetAdapter.ShareChanelInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 6) {
        localObject1 = new ActionSheetAdapter.ShareChanelInfo();
      }
    }
    switch (paramInt)
    {
    default: 
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 3: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 3;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131369513;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838112;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369540;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 2: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 2;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131369514;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838116;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369541;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 0: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 0;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131367599;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838114;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369542;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 1: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 1;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131369519;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838115;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369543;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 5: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 5;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131364457;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130839367;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131364427;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    case 4: 
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838111;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131369520;
      ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369544;
      return (ActionSheetAdapter.ShareChanelInfo)localObject1;
    }
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).a = 4;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).c = 2130838111;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).b = 2131369521;
    ((ActionSheetAdapter.ShareChanelInfo)localObject1).d = 2131369545;
    return (ActionSheetAdapter.ShareChanelInfo)localObject1;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)paramList.next();
        if ((localShareChanelInfo != null) && (localShareChanelInfo.a >= 0)) {
          this.jdField_a_of_type_JavaUtilList.add(localShareChanelInfo);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    if (localShareChanelInfo != null) {
      return localShareChanelInfo.a;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ActionSheetAdapter.ShareChanelInfo localShareChanelInfo = (ActionSheetAdapter.ShareChanelInfo)getItem(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130905063, null);
    }
    paramView = (ImageView)paramViewGroup.findViewById(2131299820);
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131298113);
    if (localShareChanelInfo != null)
    {
      paramView.setImageResource(localShareChanelInfo.c);
      localTextView.setText(localShareChanelInfo.b);
    }
    for (;;)
    {
      if (AppSetting.j)
      {
        if (localShareChanelInfo == null) {
          break;
        }
        paramViewGroup.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(localShareChanelInfo.d));
      }
      return paramViewGroup;
      paramView.setImageResource(2130842277);
      localTextView.setText("");
    }
    paramViewGroup.setContentDescription("");
    return paramViewGroup;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\widget\ActionSheetAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
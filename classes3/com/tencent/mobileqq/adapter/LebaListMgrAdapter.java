package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedTouchHandler;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import por;

public class LebaListMgrAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  protected Drawable a;
  protected LayoutInflater a;
  private LebaListMgrAdapter.LebaItemFilter jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter;
  private LebaListMgrAdapter.LebaPluginStateListener jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener;
  protected QQAppInterface a;
  protected HashMap a;
  protected List a;
  
  public LebaListMgrAdapter(QQAppInterface paramQQAppInterface, Context paramContext, List paramList, LebaListMgrAdapter.LebaItemFilter paramLebaItemFilter, LebaListMgrAdapter.LebaPluginStateListener paramLebaPluginStateListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840839);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter = paramLebaItemFilter;
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener = paramLebaPluginStateListener;
    a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_a_of_type_Int = 0;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof LebaViewItem)) {
          if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaItemFilter.a((LebaViewItem)localObject)) {
            localArrayList.add((LebaViewItem)localObject);
          } else {
            this.jdField_a_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new LebaUtil.LebaItemComparator());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  private void a(RedTouch paramRedTouch, LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    byte b = 0;
    if (paramLebaViewItem.jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true; paramBoolean == bool; bool = false) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      paramLebaViewItem.jdField_a_of_type_Byte = b;
      long l = NetConnInfoCenter.getServerTimeMillis();
      LebaShowListManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), Long.MIN_VALUE);
      ((RedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
        l = paramLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
        localRedTouchManager.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.b();
        }
      }
      a();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$LebaPluginStateListener.a(paramLebaViewItem);
      return;
      b = 1;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramAppInfo);
  }
  
  private void a(ArrayList paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((LebaViewItem)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((LebaViewItem)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((LebaViewItem)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((LebaViewItem)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(LebaListMgrAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem != null))
    {
      if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramViewHolder.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
    else {
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840839);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    a();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
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
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    if ((localLebaViewItem == null) || (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo == null)) {
      return paramView;
    }
    RedTouch localRedTouch;
    if (paramView == null)
    {
      paramView = new LebaListMgrAdapter.ViewHolder();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903324, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131298128));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298131));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131298129));
      paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131297678);
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131298130));
      localRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramViewGroup).c(100).a();
      localRedTouch.setTag(paramView);
      paramViewGroup = paramView;
      paramView = localRedTouch;
      switch (localLebaViewItem.jdField_a_of_type_Int)
      {
      default: 
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838349);
        label202:
        localRedTouch = (RedTouch)paramView;
        if (localLebaViewItem.jdField_a_of_type_Byte == 0)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
          label233:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
          if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap == null) {
            break label434;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        break;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new por(this, localRedTouch, localLebaViewItem));
      if (localLebaViewItem.jdField_a_of_type_Byte != 1) {
        break label446;
      }
      long l = localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId;
      a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      return paramView;
      paramViewGroup = (LebaListMgrAdapter.ViewHolder)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838349);
      break label202;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838357);
      break label202;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838352);
      break label202;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838355);
      break label202;
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label233;
      label434:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840839);
    }
    label446:
    ((RedTouch)paramView).b();
    return paramView;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\LebaListMgrAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
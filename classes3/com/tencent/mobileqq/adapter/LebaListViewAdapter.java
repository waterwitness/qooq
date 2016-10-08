package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import java.io.File;
import java.util.List;
import pos;
import pou;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class LebaListViewAdapter
  extends BaseAdapter
{
  public static final int a = -1;
  public static final String a = "LebaListViewAdapter";
  public static final int b = 0;
  public static final String b = "empty_normal";
  public static final int c = 1;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QQAppInterface a;
  private List jdField_a_of_type_JavaUtilList;
  String c;
  private int d;
  private int e;
  
  public LebaListViewAdapter(Context paramContext, List paramList, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = "";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void a(RedTouch paramRedTouch)
  {
    if (paramRedTouch == null) {
      return;
    }
    Object localObject = ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69)).a();
    if (localObject == null)
    {
      paramRedTouch.b();
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    int i;
    switch (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get())
    {
    case 10: 
    default: 
      i = -1;
    }
    while (i != -1)
    {
      localRedTypeInfo.red_type.set(i);
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localRedTypeInfo);
      return;
      i = 4;
      localRedTypeInfo.red_content.set(((oidb_0x791.RedDotInfo)localObject).str_custom_buffer.get().toStringUtf8() + "");
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      continue;
      i = 0;
      continue;
      String str = ((oidb_0x791.RedDotInfo)localObject).str_face_url.get().toStringUtf8();
      localObject = String.format("{'uin':'%s','dot':1, 'av':1}", new Object[] { ((oidb_0x791.RedDotInfo)localObject).uint64_cmd_uin.get() + "" });
      if (!TextUtils.isEmpty(str))
      {
        localObject = "{'av':1, 'dot':1}";
        localRedTypeInfo.red_content.set(str);
      }
      localRedTypeInfo.red_desc.set((String)localObject);
      i = 3;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    if ((paramString != null) && (ReadInJoyNotifyRedTouchInfo.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      b(paramRedTouch);
      return;
    }
    if ((paramString != null) && ((ReadInJoyNotifyRedTouchInfo.b.equals(paramString)) || (ReadInJoyNotifyRedTouchInfo.c.equals(paramString))))
    {
      c(paramRedTouch);
      return;
    }
    if (String.valueOf(3050).equals(paramString))
    {
      a(paramRedTouch);
      return;
    }
    paramString = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).a(paramString);
    paramRedTouch.a(paramString);
    ThreadManager.a(new pou(this, paramString), 2, null, true);
  }
  
  private void b(RedTouch paramRedTouch)
  {
    Object localObject;
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localObject = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(95);
      if (localObject != null)
      {
        localRedTypeInfo = ((ReadInJoyManager)localObject).a();
        localAppInfo = ((ReadInJoyManager)localObject).a();
        localObject = ((ReadInJoyManager)localObject).a();
      }
    }
    int i;
    switch (((ReadInJoyNotifyRedTouchInfo)localObject).o)
    {
    default: 
      return;
    case 1: 
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).p;
      if (i > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localAppInfo);
        return;
        localRedTypeInfo.red_content.set(i + "");
      }
    case 3: 
      localRedTypeInfo.red_type.set(3);
      i = ((ReadInJoyNotifyRedTouchInfo)localObject).q;
      localRedTypeInfo.red_desc.set("{'drawable':" + i + "}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 2: 
      localObject = ((ReadInJoyNotifyRedTouchInfo)localObject).d;
      localRedTypeInfo.red_content.set((String)localObject + "\000");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(9);
      localRedTypeInfo.red_content.set(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F) + "");
      localRedTypeInfo.red_desc.set("");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    case 4: 
      localObject = ((ReadInJoyNotifyRedTouchInfo)localObject).d;
      localRedTypeInfo.red_content.set((String)localObject + "\000");
      localRedTypeInfo.red_type.set(4);
      localRedTypeInfo.red_desc.set("{'cr':'#FF0000'}");
      localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
      localAppInfo.iNewFlag.set(1);
      paramRedTouch.a(localAppInfo);
      return;
    }
    paramRedTouch.b();
  }
  
  private void c(RedTouch paramRedTouch)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      new ReadInJoyNotifyRedTouchInfo();
      if (!TextUtils.isEmpty(PublicAccountHandler.c)) {
        break label249;
      }
    }
    label249:
    for (int i = 1;; i = 0)
    {
      switch (i)
      {
      default: 
        return;
      case 0: 
        String str = PublicAccountHandler.c;
        localRedTypeInfo.red_content.set(str + "\000");
        localRedTypeInfo.red_type.set(4);
        localRedTypeInfo.red_desc.set("{'cr':'#777777'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(9);
        localRedTypeInfo.red_content.set(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F) + "");
        localRedTypeInfo.red_desc.set("");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        paramRedTouch.a(localAppInfo);
        return;
      }
      paramRedTouch.b();
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected boolean a(LebaViewItem paramLebaViewItem)
  {
    return !TextUtils.isEmpty(paramLebaViewItem.jdField_a_of_type_JavaLangString);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) || (paramInt < 0)) {
      return null;
    }
    return (LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return 1;
    }
    if (TextUtils.isEmpty(((LebaViewItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItem(paramInt) == null) {
      return paramView;
    }
    LebaViewItem localLebaViewItem = (LebaViewItem)getItem(paramInt);
    int i = getItemViewType(paramInt);
    if (i == 0) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.d, null);
        paramViewGroup = new LebaListViewAdapter.CornerListItemHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298128));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298131));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298129));
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131297678));
        paramView = new RedTouch(this.jdField_a_of_type_AndroidContentContext, paramView).c(40).a();
        paramView.setTag(paramViewGroup);
        label140:
        if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428267));
        if (Build.VERSION.SDK_INT < 16) {
          break label422;
        }
        paramViewGroup.b.setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843182));
        label216:
        if (localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break label445;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap);
        label236:
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem = localLebaViewItem;
        switch (localLebaViewItem.jdField_a_of_type_Int)
        {
        default: 
          paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838351);
          label286:
          if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)) {
            a((RedTouch)paramView, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId + "");
          }
          if ((AppSetting.j) && (localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (!TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName)))
          {
            AccessibilityUtil.a(paramView, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName, Button.class.getName());
            paramViewGroup = paramView;
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramView = paramViewGroup;
      if (paramViewGroup == null) {
        break;
      }
      paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      return paramViewGroup;
      paramViewGroup = (LebaListViewAdapter.CornerListItemHolder)paramView.getTag();
      break label140;
      label422:
      paramViewGroup.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843182));
      break label216;
      label445:
      if (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LebaListViewAdapter", 2, "item.icon == null, info=" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
        }
        File localFile = LebaUtil.a(this.jdField_a_of_type_AndroidContentContext, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName, localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
        if (localFile != null)
        {
          String str = "LebaIcon://" + localFile.getAbsolutePath();
          Bitmap localBitmap = (Bitmap)BaseApplicationImpl.a.get(str);
          if (localBitmap != null)
          {
            localLebaViewItem.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
            if (!QLog.isColorLevel()) {
              break label236;
            }
            QLog.d("LebaListViewAdapter", 2, "found bitmap from cache, info=" + localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
            break label236;
          }
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840839);
          ThreadManager.a(new pos(this, localFile, localLebaViewItem, str, paramViewGroup), 5, null, true);
          break label236;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840839);
        break label236;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840839);
      break label236;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838351);
      break label286;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838358);
      break label286;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838356);
      break label286;
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838356);
      break label286;
      if (i == 1)
      {
        paramViewGroup = paramView;
        if (paramView == null) {
          paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.e, null);
        }
      }
      else
      {
        paramViewGroup = null;
        continue;
        paramViewGroup = paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getItem(paramInt) == null) {
      return false;
    }
    if (!a((LebaViewItem)getItem(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\LebaListViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
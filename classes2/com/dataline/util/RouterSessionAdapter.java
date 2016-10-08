package com.dataline.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.DLRouterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import du;
import dv;
import dw;
import dx;
import java.util.ArrayList;

public class RouterSessionAdapter
  extends TimeAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  public static String a;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new du(this);
  public View.OnLongClickListener a;
  public DLRouterActivity a;
  public RouterHandler a;
  public BubblePopupWindow a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "dataline.RouterSessionAdapter";
  }
  
  public RouterSessionAdapter(DLRouterActivity paramDLRouterActivity, RouterHandler paramRouterHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler = null;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new dw(this);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler = paramRouterHandler;
    this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity = paramDLRouterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramDLRouterActivity);
    b();
  }
  
  private void a(RouterMsgRecord paramRouterMsgRecord, RelativeLayout paramRelativeLayout, ItemHolder paramItemHolder)
  {
    if ((paramRouterMsgRecord.vipBubbleID == 100000L) && (paramRouterMsgRecord.msgtype == 64536))
    {
      Object localObject = LocaleUtil.a(this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getApplicationContext());
      localObject = TranslateCache.a(this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getApplicationContext()).a(paramRouterMsgRecord.msg, paramRouterMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((Trans_entity)localObject).a().booleanValue()) && (!paramRouterMsgRecord.isSendFromLocal()))
      {
        paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getResources(), this);
        if (paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
        {
          paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
          if (paramRouterMsgRecord.msgtype == 64536) {
            break label255;
          }
        }
      }
    }
    label255:
    for (boolean bool = true;; bool = false)
    {
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramRelativeLayout, null);
      int i = paramRouterMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        SVIPHandler.b(paramRouterMsgRecord.vipBubbleID);
      }
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app, paramRouterMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, FontManager.a(paramRouterMsgRecord), i);
      a(paramRelativeLayout, paramRouterMsgRecord);
      return;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getResources(), this);
      break;
      paramItemHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a((int)paramRouterMsgRecord.vipBubbleID, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app, this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.getResources(), this);
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((RouterMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.get(paramInt)).time;
  }
  
  protected void a(View paramView, RouterMsgRecord paramRouterMsgRecord)
  {
    if (paramRouterMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.n, BaseChatItemLayout.k, BaseChatItemLayout.m, BaseChatItemLayout.l);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.m, BaseChatItemLayout.k, BaseChatItemLayout.n, BaseChatItemLayout.l);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.g())) {
      return true;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ItemHolder)paramView.getTag();
    if (paramView != null)
    {
      localObject2 = paramView.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      localObject1 = paramView.a();
      if ((localObject2 == null) || (localObject1 == null)) {
        return false;
      }
    }
    else
    {
      return false;
    }
    Object localObject2 = ((RelativeLayout)localObject2).getContext();
    localQQCustomMenu.a(2131305406, ((Context)localObject2).getString(2131362156));
    Object localObject1 = new dx(this, (RouterMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localQQCustomMenu, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new dv(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((RouterMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.size() > paramInt) {
      return this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    RouterMsgRecord localRouterMsgRecord = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.size() > paramInt) {
      localRouterMsgRecord = (RouterMsgRecord)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.get(paramInt);
    }
    if (localRouterMsgRecord == null) {
      return 2;
    }
    boolean bool = localRouterMsgRecord.isSendFromLocal();
    switch (localRouterMsgRecord.msgtype)
    {
    default: 
      return 3;
    }
    if (bool) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a == null) || (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a.size() == 0))
    {
      if (paramView == null)
      {
        paramView = new ItemHolder();
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903281, null);
        localObject = (TextView)paramViewGroup.findViewById(2131297967);
        ((TextView)localObject).setTextSize(19.0F);
        ((TextView)localObject).setTextColor(-16777216);
        ((TextView)localObject).setText("无需数据线，手机轻松传文件到路由器。");
        paramViewGroup.setTag(paramView);
        return paramViewGroup;
      }
      paramViewGroup = (ItemHolder)paramView.getTag();
      return paramView;
    }
    RouterMsgRecord localRouterMsgRecord = (RouterMsgRecord)getItem(paramInt);
    if (localRouterMsgRecord == null) {
      return null;
    }
    label401:
    int i;
    if (paramView == null) {
      if (!localRouterMsgRecord.isSendFromLocal())
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903268, null);
        paramViewGroup = new ItemHolder();
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297922));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903254, null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject);
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131297880));
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297881));
        paramViewGroup.a().c = ((TextView)paramView.findViewById(2131297883));
        paramViewGroup.a().d = ((TextView)paramView.findViewById(2131297884));
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131297885));
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130843492);
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        paramViewGroup.a((ImageView)paramView.findViewById(2131297899));
        paramViewGroup.a().setVisibility(4);
        paramViewGroup.a((TextView)paramView.findViewById(2131297441));
        paramView.setTag(paramViewGroup);
        paramViewGroup.a(localRouterMsgRecord);
        localObject = FileUtil.a(localRouterMsgRecord.filename);
        if (localObject != null) {
          break label811;
        }
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130840398);
        String str = localRouterMsgRecord.filename;
        localObject = str;
        if (localRouterMsgRecord.filename != null)
        {
          i = localRouterMsgRecord.filename.lastIndexOf("/");
          localObject = str;
          if (i >= 0) {
            localObject = localRouterMsgRecord.filename.substring(i + 1);
          }
        }
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewGroup.a().c.setText(FileUtil.a(localRouterMsgRecord.fileSize));
        switch (localRouterMsgRecord.status)
        {
        }
      }
    }
    for (;;)
    {
      a(localRouterMsgRecord, paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout, paramViewGroup);
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.app))
      {
        localObject = (ChatBackgroundDrawable)this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity.a.getTag(2131296450);
        if (localObject != null)
        {
          i = ChatBackground.a(((ChatBackgroundDrawable)localObject).getBitmap());
          paramViewGroup.a().setTextColor(ColorStateList.valueOf(i));
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.time", 4, "time[" + localRouterMsgRecord.time + "], uniseq[" + localRouterMsgRecord.uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + localRouterMsgRecord.filename + "], position[" + paramInt + "], mapShowTime[" + a(localRouterMsgRecord.uniseq));
      }
      if (!a(localRouterMsgRecord.uniseq)) {
        break label1123;
      }
      localObject = TimeFormatterUtils.a(this.jdField_a_of_type_ComDatalineActivitiesDLRouterActivity, 3, localRouterMsgRecord.time * 1000L);
      paramViewGroup.a().setVisibility(0);
      paramViewGroup.a().setText((CharSequence)localObject);
      return paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903276, null);
      break;
      paramViewGroup = (ItemHolder)paramView.getTag();
      break label401;
      label811:
      paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(FileManagerUtil.b((String)localObject));
      switch (FileManagerUtil.a((String)localObject))
      {
      default: 
        i = FileManagerUtil.b((String)localObject);
        if (i == 0) {
          break;
        }
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
        break;
      case 0: 
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
        paramViewGroup.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(localRouterMsgRecord.filename);
        break;
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        continue;
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(localRouterMsgRecord.progress * 100.0D));
        if (!localRouterMsgRecord.isSendFromLocal())
        {
          paramViewGroup.a().d.setText(2131362804);
        }
        else
        {
          paramViewGroup.a().d.setText(2131362803);
          continue;
          paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          if (!localRouterMsgRecord.isSendFromLocal())
          {
            paramViewGroup.a().d.setText(2131362866);
          }
          else
          {
            paramViewGroup.a().d.setText(2131362868);
            continue;
            paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
            if (!localRouterMsgRecord.isSendFromLocal())
            {
              paramViewGroup.a().d.setText(2131362873);
            }
            else
            {
              paramViewGroup.a().d.setText(2131362872);
              continue;
              paramViewGroup.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
              paramViewGroup.a().d.setText(2131362222);
            }
          }
        }
        break;
      }
    }
    label1123:
    paramViewGroup.a().setVisibility(8);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\dataline\util\RouterSessionAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.qqstory.settings;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import iqc;
import java.util.ArrayList;

public class QQStoryShieldActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 1;
  public static final int f = 2;
  public static final int h = 1001;
  public static final int i = 1002;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  QQStoryHandler jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
  QQStoryManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public QQProgressNotifier a;
  public Switch a;
  String jdField_a_of_type_JavaLangString;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  public Switch b;
  int g;
  
  public QQStoryShieldActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.g = 1;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new iqc(this);
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2130904379, null);
    ((TextView)localView.findViewById(2131297123)).setText(paramString);
    ((TextView)localView.findViewById(2131297124)).setText("");
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString);
    super.startTitleProgress();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    this.g = super.getIntent().getIntExtra("from", 1);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(180));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130837959);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, AIOUtils.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = paramBundle;
    paramBundle = a(0, "查看个人资料卡");
    paramBundle.setBackgroundResource(2130838352);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    if (this.g == 1) {
      paramBundle.setVisibility(8);
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = paramBundle;
    paramBundle.setText("不看他（她）的日迹");
    paramBundle.setContentDescription("不看他（她）的日迹");
    paramBundle.setBgType(2);
    paramBundle.setTag(Integer.valueOf(1));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.b = paramBundle.a();
    this.b.setTag(Integer.valueOf(1));
    this.b.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = (LinearLayout.LayoutParams)paramBundle.getLayoutParams();
    if (this.g != 1) {
      paramBundle.topMargin = AIOUtils.a(20.0F, getResources());
    }
    paramBundle = new FormSwitchItem(this, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = paramBundle;
    paramBundle.setText("不让他（她）看我的日迹");
    paramBundle.setContentDescription("不让他（她）看我的日迹");
    paramBundle.setBgType(3);
    paramBundle.setTag(Integer.valueOf(2));
    paramBundle.a().setTextSize(1, 18.0F);
    paramBundle.setFocusable(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch = paramBundle.a();
    this.jdField_a_of_type_ComTencentWidgetSwitch.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a(this.jdField_a_of_type_JavaLangString);
    boolean bool;
    if (paramBundle != null)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramBundle.isAllowed == 1)
      {
        bool = true;
        ((Switch)localObject).setChecked(bool);
        localObject = this.b;
        if (paramBundle.isInterested != 1) {
          break label546;
        }
        bool = true;
        label451:
        ((Switch)localObject).setChecked(bool);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
      this.b.setOnCheckedChangeListener(this);
      super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
      if (this.g != 1) {
        break label551;
      }
      super.setTitle("日迹设置");
      label495:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130904317);
      if (NetworkUtil.h(this)) {
        break label561;
      }
      QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
      super.startTitleProgress();
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label546:
      bool = false;
      break label451;
      label551:
      super.setTitle("屏蔽");
      break label495;
      label561:
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = ((Integer)paramCompoundButton.getTag()).intValue();
    if (!NetworkUtil.h(this)) {
      QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
    }
    for (int j = 0;; j = 1)
    {
      paramCompoundButton = new ArrayList();
      paramCompoundButton.add(this.jdField_a_of_type_JavaLangString);
      switch (k)
      {
      default: 
        if (k == 2) {
          if (paramBoolean) {
            paramCompoundButton = "open_notletsee";
          }
        }
        break;
      }
      for (;;)
      {
        if (this.g != 1) {
          break label266;
        }
        ReportController.b(null, "dc00899", "grp_story", "", "person_data_set", paramCompoundButton, 0, 0, "", "", "", "");
        return;
        if (j != 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramCompoundButton, true, paramBoolean);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131367254, 0);
          break;
        }
        paramCompoundButton = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!paramBoolean) {}
        for (boolean bool = true;; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          break;
        }
        if (j != 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramCompoundButton, false, paramBoolean);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131367254, 0);
          break;
        }
        paramCompoundButton = this.b;
        if (!paramBoolean) {}
        for (bool = true;; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          break;
        }
        paramCompoundButton = "close_notletsee";
        continue;
        if (paramBoolean) {
          paramCompoundButton = "open_notsee";
        } else {
          paramCompoundButton = "close_notsee";
        }
      }
      label266:
      ReportController.b(null, "dc00899", "grp_story", "", "list_settings", paramCompoundButton, 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    }
    if (((FriendsManager)this.app.getManager(50)).b(this.jdField_a_of_type_JavaLangString)) {}
    for (int j = 1;; j = 19)
    {
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, j);
      ProfileActivity.b(getActivity(), paramView);
      ReportController.b(null, "dc00899", "grp_story", "", "list_settings", "clk_person_data", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\settings\QQStoryShieldActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
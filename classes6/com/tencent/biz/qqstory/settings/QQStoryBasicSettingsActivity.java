package com.tencent.biz.qqstory.settings;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import iqb;

public class QQStoryBasicSettingsActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public QQStoryHandler a;
  public QQStoryManager a;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  public QQProgressNotifier a;
  View[] jdField_a_of_type_ArrayOfAndroidViewView;
  View b;
  View c;
  public int e;
  public int f;
  
  public QQStoryBasicSettingsActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = 0;
    this.f = this.e;
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new iqb(this);
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 1001: 
    default: 
      return 0;
    case 3: 
      return 2;
    }
    return 1;
  }
  
  protected View a(int paramInt, String paramString)
  {
    View localView = View.inflate(this, 2130904379, null);
    ((TextView)localView.findViewById(2131297123)).setText(paramString);
    ((TextView)localView.findViewById(2131297124)).setText("");
    paramString = (ImageView)localView.findViewById(2131297122);
    paramString.setVisibility(4);
    paramString.setBackgroundResource(2130838206);
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this);
    return localView;
  }
  
  void a()
  {
    Object localObject = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    ((LinearLayout)localObject).setBackgroundResource(2130837959);
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setPadding(0, AIOUtils.a(20.0F, getResources()), 0, 0);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText("日迹自动加载");
    ((TextView)localObject).setPadding(getResources().getDimensionPixelSize(2131493191), 0, getResources().getDimensionPixelSize(2131493191), getResources().getDimensionPixelSize(2131493189));
    ((TextView)localObject).setTextSize(14.0F);
    ((TextView)localObject).setTextColor(getResources().getColor(2131427365));
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    localObject = a(0, "3G/4G和WiFi");
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localObject;
    ((View)localObject).setBackgroundResource(2130838357);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(1, "仅WiFi");
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130838355);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localObject = a(2, "关闭");
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = localObject;
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject);
    ((View)localObject).setBackgroundResource(2130838352);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130904317);
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
    {
      ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[i].findViewById(2131297122);
      if (i != paramInt) {
        localImageView.setVisibility(4);
      }
      for (;;)
      {
        i += 1;
        break;
        localImageView.setVisibility(0);
      }
    }
    this.e = paramInt;
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1001;
    case 2: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(180));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    a();
    int i = a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager.a());
    this.f = i;
    this.e = i;
    a(this.e);
    super.setTitle("日迹浏览设置");
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    if (!NetworkUtil.h(this))
    {
      QQToast.a(this, 1, 2131367256, 0).b(getTitleBarHeight());
      super.startTitleProgress();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b();
    super.startTitleProgress();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.h(this))
    {
      QQToast.a(this, 1, 2131367256, 0).b(getTitleBarHeight());
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    this.f = this.e;
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131367254, 0);
      a(i);
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(3);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(1);
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\settings\QQStoryBasicSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
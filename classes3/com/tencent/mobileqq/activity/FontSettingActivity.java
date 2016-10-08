package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FontSettingManager.FontLevel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import liu;
import liv;
import liw;
import lix;
import liy;
import lja;
import ljc;
import ljd;
import mqq.os.MqqHandler;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, FontSettingManager.FontLevel, RangeButtonView.OnChangeListener
{
  public static final String a = "2720152058";
  public static final String b = "2632129500";
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public SessionInfo a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public List a;
  private liy jdField_a_of_type_Liy;
  private lja jdField_a_of_type_Lja;
  private ljd jdField_a_of_type_Ljd;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ListView jdField_b_of_type_ComTencentWidgetListView;
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  public boolean b;
  private ViewGroup c;
  public boolean c;
  private boolean d;
  private float g;
  
  public FontSettingActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.g = 16.0F;
    this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new lix(this);
  }
  
  private int a()
  {
    int j = 2;
    this.g = FontSettingManager.a();
    int i;
    if (this.g == 13.92F) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (this.g == 15.0F) {
          return 1;
        }
        i = j;
      } while (this.g == 16.0F);
      if (this.g == 17.0F) {
        return 3;
      }
      i = j;
    } while (this.g != 18.0F);
    return 4;
  }
  
  private ListView a()
  {
    ListView localListView = new ListView(this);
    ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localListView.setDivider(null);
    localListView.setDividerHeight(0);
    return localListView;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131297083);
    localTextView.setText(2131370954);
    localTextView.setOnClickListener(new liu(this));
    ((TextView)paramView.findViewById(2131297139)).setText("字体大小");
    ((TextView)paramView.findViewById(2131297083)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131301651));
    this.jdField_a_of_type_Lja = new lja(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Lja);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131301652));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Liy = new liy(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Liy);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_Ljd = new ljd(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Ljd);
    this.jdField_a_of_type_Lja.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131298213));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title("小", TypedValue.applyDimension(1, 13.92F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 15.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("标准", TypedValue.applyDimension(1, 16.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("大", TypedValue.applyDimension(1, 18.0F, FontSettingManager.a)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131362111));
    localArrayList.add(getString(2131362112));
    localArrayList.add(getString(2131362113));
    localArrayList.add(getString(2131362114));
    localArrayList.add(getString(2131362115));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131301650));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getLayoutInflater().inflate(2130903231, this.jdField_b_of_type_AndroidViewViewGroup, false));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, 0);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewViewGroup.removeViewAt(0);
    e();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      MessageForText localMessageForText1 = new MessageForText();
      localMessageForText1.frienduin = "2720152058";
      localMessageForText1.senderuin = "2720152058";
      localMessageForText1.issend = 1000;
      localMessageForText1.msg = "拖动下方的滑块，可以设置界面中的字体大小";
      localMessageForText1.sb = "拖动下方的滑块，可以设置界面中的字体大小";
      MessageForText localMessageForText2 = new MessageForText();
      Object localObject = this.app.a();
      localMessageForText2.frienduin = ((String)localObject);
      localMessageForText2.selfuin = ((String)localObject);
      localMessageForText2.senderuin = ((String)localObject);
      localMessageForText2.issend = 1;
      localMessageForText2.msg = "设置字体大小";
      localMessageForText2.sb = "设置字体大小";
      localMessageForText2.vipBubbleID = ((SVIPHandler)this.app.a(13)).e();
      localObject = new MessageForText();
      ((MessageForText)localObject).frienduin = "2720152058";
      ((MessageForText)localObject).senderuin = "2720152058";
      ((MessageForText)localObject).issend = 1000;
      ((MessageForText)localObject).msg = "设置后，会改变聊天，消息列表，联系人列表和动态等中的字体大小";
      ((MessageForText)localObject).sb = "设置后，会改变聊天，消息列表，联系人列表和动态等中的字体大小";
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText1);
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText2);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      if (ChatBackground.a(this, this.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      }
    }
  }
  
  private void h()
  {
    ljc localljc1 = new ljc(this, 0, "QQ团队", "你好，如果你有任何关于QQ的意见或建议...", "下午3:28", "2720152058", 0);
    ljc localljc2 = new ljc(this, 2130838605, "关联QQ号", "验证密码后，才可接受新消息", "下午3:28", AppConstants.ah, 7000);
    ljc localljc3 = new ljc(this, 2130838607, "群助手", "查看“收进群助手且不提醒”的群", "下午3:28", AppConstants.am, 5000);
    ljc localljc4 = new ljc(this, 2130840319, "我的电脑", "[在线],无需数据线，手机轻松传...", "下午3:28", AppConstants.aj, 6000);
    ljc localljc5 = new ljc(this, 0, "吃喝玩乐", "吃喝玩乐全民升级，餐厅，KTV等", "下午3:28", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localljc1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localljc2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localljc3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localljc4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localljc5);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup2 = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup2.getChildAt(0);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localView != null)
      {
        localViewGroup1 = localViewGroup2;
        if ((localView instanceof ViewGroup)) {
          localViewGroup1 = (ViewGroup)localView;
        }
      }
      if ((localViewGroup1 instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
      }
    }
  }
  
  public void a()
  {
    if ((this.d) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      this.d = false;
      FontSettingManager.a(this);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.g, "", "", "");
      if (!FontSettingManager.a(this, this.g, false)) {
        bool = true;
      }
      this.d = bool;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_b_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
      this.jdField_a_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
      f();
      return;
      this.g = 13.92F;
      continue;
      this.g = 15.0F;
      continue;
      this.g = 16.0F;
      continue;
      this.g = 17.0F;
      continue;
      this.g = 18.0F;
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_ComTencentWidgetListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130837959);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.a(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130837959);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void c()
  {
    if (this.g == FontSettingManager.a()) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppDialog = CustomDialogFactory.a(this, 2131372139, 2131372142, 2131372141, 2131372140, new liv(this), new liw(this));
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130904162);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131296895));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      this.jdField_c_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.app.a(FontSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Ljd.a();
    this.app.a(FontSettingActivity.class);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\FontSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
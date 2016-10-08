package com.tencent.biz.qqstory.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import iqd;
import iqe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public static final int a = 1;
  public static final String a = "sheild_type";
  public static final int b = 2;
  public static final int c = 10;
  public static final int f = 1001;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQStoryHandler a;
  public QQStoryManager a;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  iqe jdField_a_of_type_Iqe;
  View b;
  public int d;
  int e;
  
  public QQStoryShieldListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new iqd(this);
  }
  
  public static void a(Activity paramActivity, ArrayList paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131368729));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_circle", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", "选择联系人");
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 1001);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Iqe.notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.b.setVisibility(8);
    this.jdField_a_of_type_Iqe.a(paramList);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1001))
    {
      localObject = paramIntent.getParcelableArrayListExtra("friendsSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {}
    }
    else
    {
      return;
    }
    paramIntent = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(((ResultRecord)((Iterator)localObject).next()).a);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
    if (this.d == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((QQStoryHandler)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131367254, 0);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.doOnCreate(paramBundle);
    this.d = getIntent().getIntExtra("sheild_type", 1);
    label68:
    boolean bool1;
    if (this.d == 2)
    {
      paramBundle = "不让他（她）看我的日迹";
      super.setContentView(2130904486);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298186));
      if (this.d != 2) {
        break label378;
      }
      paramBundle = "把好友添加到这里后，发日迹他（她）将无法看到。";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131302900));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130904317);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(180));
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
      paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
      if (this.d != 2) {
        break label385;
      }
      bool1 = true;
      label151:
      paramBundle = paramBundle.a(bool1);
      this.jdField_a_of_type_Iqe = new iqe(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Iqe);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131302899);
      this.b = findViewById(2131302901);
      if ((paramBundle != null) && (paramBundle.size() != 0)) {
        break label390;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.b.setVisibility(0);
      label233:
      if (this.d != 2) {
        break label410;
      }
      paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的日迹";
      label245:
      ((TextView)this.b.findViewById(2131300349)).setText(paramBundle);
      this.e = ((int)DisplayUtils.a(this, 20.0F));
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText("添加");
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.app);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      if (NetworkUtil.h(this)) {
        break label417;
      }
      QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = "不看他（她）的日迹";
      break;
      label378:
      paramBundle = "把好友添加到这里后，他（她）更新的故事将不会在日迹列表出现";
      break label68;
      label385:
      bool1 = false;
      break label151;
      label390:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b.setVisibility(8);
      break label233;
      label410:
      paramBundle = "把好友添加到这里后\r\n将不会看到该好友的日迹";
      break label245;
      label417:
      paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      bool1 = bool2;
      if (this.d == 2) {
        bool1 = true;
      }
      paramBundle.a(null, 10, bool1);
      super.startTitleProgress();
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (paramView == this.rightViewText)
      {
        if (NetworkUtil.h(this)) {
          break;
        }
        QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
      }
      return;
      if (!NetworkUtil.h(this))
      {
        QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
        return;
      }
      Object localObject2 = (QQStoryUserInfo)paramView.getTag();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((QQStoryUserInfo)localObject2).uin);
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      if (this.d == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        ((QQStoryHandler)localObject2).a((ArrayList)localObject1, bool1, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131367254, 0);
        if (this.d != 2) {
          break label192;
        }
        ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "move_notletsee", 0, 0, "", "", "", "");
        break;
      }
      label192:
      ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "move_notsee", 0, 0, "", "", "", "");
    }
    paramView = new ArrayList();
    paramView.add(this.app.a());
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
    if (this.d == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((QQStoryManager)localObject1).a(bool1);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    if (this.d == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      a(this, paramView, bool1);
      if (this.d != 2) {
        break;
      }
      ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "add_notletsee", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00899", "grp_story", "", "friend_story_settings", "add_notsee", 0, 0, "", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\settings\QQStoryShieldListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import cooperation.dingdong.DingdongOpenIdProvider;
import java.util.ArrayList;
import java.util.List;
import ojh;
import oji;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;

public class DiscussionView
  extends BaseTroopView
  implements View.OnClickListener, DiscussionListAdapter2.DiscussionListListener, SlideDetectListView.OnSlideListener, OverScrollViewListener
{
  private static final String jdField_a_of_type_JavaLangString = "DiscussionView";
  static final int jdField_b_of_type_Int = 100;
  private static final String jdField_b_of_type_JavaLangString = "rec_last_discussion_list_refresh_time";
  static final int c = 102;
  static final int d = 1000;
  private long jdField_a_of_type_Long;
  Button jdField_a_of_type_AndroidWidgetButton;
  public DiscussionListAdapter2 a;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public SlideDetectListView a;
  private DingdongOpenIdProvider jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider;
  private oji jdField_a_of_type_Oji;
  public boolean c;
  View e;
  
  public DiscussionView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = false;
    this.jdField_a_of_type_Oji = new oji(this, null);
  }
  
  private long a()
  {
    return a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    ThreadPriorityManager.a(true);
    Intent localIntent = AIOUtils.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", 3000);
    localIntent.putExtra("uinname", paramString2);
    a(localIntent);
  }
  
  private boolean c()
  {
    if (NetworkUtil.h(a()))
    {
      this.c = true;
      ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).g(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue());
      return true;
    }
    return false;
  }
  
  private void k()
  {
    this.e = findViewById(2131299603);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.e.findViewById(2131299605));
    this.e.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131299606));
    LayoutInflater localLayoutInflater = LayoutInflater.from(a());
    View localView = localLayoutInflater.inflate(2130904932, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
    localView.findViewById(2131300876).setVisibility(8);
    EditText localEditText = (EditText)localView.findViewById(2131300895);
    localEditText.setFocusableInTouchMode(false);
    localEditText.setOnClickListener(this);
    localEditText.setCursorVisible(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setContentBackground(2130837958);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.e);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setVisibility(8);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    }
  }
  
  private void l()
  {
    Intent localIntent = new Intent(a(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    b(localIntent, 1300);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    a().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", l).commit();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (paramIntent == null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a());
      return;
    }
    a(paramIntent.getStringExtra("contactSearchResultTroopUin"), paramIntent.getStringExtra("contactSearchResultName"));
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(a());
  }
  
  protected void a(Intent paramIntent, BaseTroopView.ITroopContext paramITroopContext)
  {
    super.a(paramIntent, paramITroopContext);
    a(2130903658);
    k();
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2 = new DiscussionListAdapter2(a(), this, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2);
    a(this.jdField_a_of_type_Oji);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      this.jdField_a_of_type_Int = 7;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent();
    Object localObject2;
    if (((Intent)localObject1).getBooleanExtra("param_from_dingdong_office", false))
    {
      localObject2 = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), getResources().getDimensionPixelSize(2131492908));
      ((QQProgressDialog)localObject2).show();
      ArrayList localArrayList = new ArrayList(1);
      oidb_0x589.GetUserOpenIdReq localGetUserOpenIdReq = new oidb_0x589.GetUserOpenIdReq();
      localGetUserOpenIdReq.setHasFlag(true);
      localGetUserOpenIdReq.uint32_req_flag.set(3);
      localGetUserOpenIdReq.uint64_req_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().a()));
      localGetUserOpenIdReq.uint64_req_host_uin.set(Long.parseLong(paramDiscussionInfo.uin));
      localArrayList.add(localGetUserOpenIdReq);
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider = new DingdongOpenIdProvider(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Long = this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a(((Intent)localObject1).getLongExtra("param_dingdong_appId", 0L), localArrayList, false, new ojh(this, (QQProgressDialog)localObject2));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a();
      if (localObject1 != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("uin", paramDiscussionInfo.uin);
        ((Bundle)localObject2).putInt("uintype", 3000);
        ((Bundle)localObject2).putString("uinname", ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo.discussionName, paramDiscussionInfo.uin));
        ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
        ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A12");
        ((ForwardBaseOption)localObject1).a(ForwardAbility.ForwardAbilityType.d.intValue(), (Bundle)localObject2);
      }
      paramDiscussionInfo = "";
      try
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getIntent().getLongExtra("req_share_id", 0L);
        if (l > 0L) {
          paramDiscussionInfo = String.valueOf(l);
        }
      }
      catch (Exception paramDiscussionInfo)
      {
        for (;;)
        {
          paramDiscussionInfo = "";
        }
      }
      ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "", paramDiscussionInfo, "1000", "32", "0", false);
      return;
    }
    a(paramDiscussionInfo.uin, paramDiscussionInfo.discussionName);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramDiscussionInfo.hasCollect) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006666", "0X8006666", i, 0, "", "", "", "");
      return;
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    DiscussionInfo localDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt);
    if (localDiscussionInfo == null) {}
    Button localButton;
    do
    {
      do
      {
        return;
        paramView = (ShaderAnimLayout)paramView.findViewById(2131298134);
      } while (paramView == null);
      localButton = (Button)paramView.findViewById(2131298135);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramSlideDetectListView = a();
    if (!localDiscussionInfo.hasCollect) {}
    for (paramInt = 2131364260;; paramInt = 2131364261)
    {
      paramSlideDetectListView = paramSlideDetectListView.getString(paramInt);
      localButton.setText(paramSlideDetectListView);
      localButton.setVisibility(0);
      localButton.setTag(localDiscussionInfo);
      if (AppSetting.j) {
        localButton.setContentDescription(paramSlideDetectListView);
      }
      paramView.a();
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(a());
    if (!c()) {
      a(102, 1000L);
    }
    return true;
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.H();
      b(2131368597);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(a());
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a(paramInt) == null) {}
    do
    {
      do
      {
        return;
        paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131298134);
      } while (paramSlideDetectListView == null);
      paramSlideDetectListView.d();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131298135);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setTag(null);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.notifyDataSetChanged();
  }
  
  protected void h()
  {
    super.h();
    b(this.jdField_a_of_type_Oji);
    this.jdField_a_of_type_ComTencentMobileqqAdapterDiscussionListAdapter2.a();
    if (this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider != null) {
      this.jdField_a_of_type_CooperationDingdongDingdongOpenIdProvider.a();
    }
  }
  
  public void j()
  {
    ContactSearchComponentActivity.a(a(), null, 5, 8, 561249);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300895: 
      j();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
      return;
    }
    l();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\troop\DiscussionView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
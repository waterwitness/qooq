package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import vff;
import vfg;
import vfh;
import vfi;
import vfl;
import vfm;

public class PubAccBindTroopListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1;
  protected static final String a = "PubAccBindTroopListActivity";
  public static final int b = 2;
  public static String b = "bind_troop_list";
  public static final int c = 3;
  public static String c = "unread_msg_count";
  protected long a;
  protected Handler a;
  public RecentAdapter a;
  public DragFrameLayout a;
  protected FriendListObserver a;
  protected MessageObserver a;
  protected TroopObserver a;
  public XListView a;
  protected ArrayList a;
  public MqqHandler a;
  private String d;
  private String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PubAccBindTroopListActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new vfg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vfi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new vfl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new vfm(this);
  }
  
  protected List a()
  {
    ArrayList localArrayList = new ArrayList();
    RecentUserProxy localRecentUserProxy = this.app.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      RecentItemTroopMsgData localRecentItemTroopMsgData = new RecentItemTroopMsgData(localRecentUserProxy.a((String)localIterator.next(), 1));
      localRecentItemTroopMsgData.c = true;
      localRecentItemTroopMsgData.a(this.app, BaseApplication.getContext());
      localArrayList.add(localRecentItemTroopMsgData);
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramView = paramRecentBaseData.a();
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramView);
    Object localObject = (TroopManager)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((TroopManager)localObject).a(paramView);
      if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
        localIntent.putExtra("troop_uin", ((TroopInfo)localObject).troopcode);
      }
      localIntent.putExtra("uintype", paramRecentBaseData.a());
      localIntent.putExtra("uinname", paramString);
    }
    startActivity(localIntent);
    int j = this.app.a().a(paramView, 1);
    int i;
    switch (this.app.b(paramView))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "Clk_talk", 0, 0, paramView, j + "", i + "", this.d);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {}
    do
    {
      return;
      paramRecentBaseData = paramRecentBaseData.a();
      TroopAssistantManager.a().b(paramRecentBaseData, this.app);
      a();
      RecentUtil.b(this.app, paramRecentBaseData, 1);
      this.app.a().c(paramRecentBaseData, 1);
      paramRecentBaseData = this.app.a(Conversation.class);
    } while (paramRecentBaseData == null);
    paramRecentBaseData.sendEmptyMessage(1014);
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    setContentView(2130905048);
    getWindow().setBackgroundDrawable(null);
    setTitle(2131365245);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayListExtra(b);
    int i = paramBundle.getIntExtra(c, 0);
    this.d = paramBundle.getStringExtra("pub_acc_uin");
    this.e = paramBundle.getStringExtra("pub_acc_name");
    ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_talk", 0, 0, "", i + "", "", this.d);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b(), this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298606));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new vff(this, this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 9);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 3) {
      return true;
    }
    for (;;)
    {
      try
      {
        paramMessage = a();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("MSG_UPDATE_TROOP_LIST|size");
          if (paramMessage != null) {
            break label96;
          }
          i = 0;
          QLog.i("PubAccBindTroopListActivity", 2, i);
        }
        runOnUiThread(new vfh(this, paramMessage));
        return true;
      }
      catch (Exception paramMessage) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PubAccBindTroopListActivity", 2, paramMessage.toString());
      return true;
      label96:
      int i = paramMessage.size();
    }
  }
  
  protected boolean onBackEvent()
  {
    setTitle("");
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    if (this.d != null) {
      localIntent.putExtra("uin", this.d);
    }
    if (this.e != null) {
      localIntent.putExtra("uinname", this.e);
    }
    localIntent.putExtra("uintype", 1008);
    startActivity(localIntent);
    overridePendingTransition(2130968587, 2130968588);
    finish();
    return super.onBackEvent();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != 63534)) {}
    }
    while (!(paramObject instanceof RecentUser))
    {
      return;
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 200L);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\PubAccBindTroopListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
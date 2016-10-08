package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import oix;
import oiy;
import oiz;
import oja;
import ojb;
import ojc;
import ojd;
import oje;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class SystemMsgListView
  extends BaseNewFriendView
  implements Observer
{
  public static final int a = 222;
  private static final String jdField_a_of_type_JavaLangString = "Q.newfriendSystemMsgListView";
  public static final int b = 223;
  public static final int c = 224;
  private static final int d = 1012;
  private static final int e = 1014;
  private static final int f = 1015;
  private static final int g = 1016;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  private View c;
  private final int h;
  private int i;
  
  public SystemMsgListView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new oix(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new oja(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ojb(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ojc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ojd(this);
    this.h = 0;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new oje(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void o()
  {
    super.a(2130904371);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131301443));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302565);
    this.b = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904372, null);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    q();
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter);
    i();
  }
  
  private void q()
  {
    if (this.c == null) {
      this.c = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130904370, null);
    }
    if (this.c.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.b(this.c);
    }
    this.c.setVisibility(8);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      List localList;
      do
      {
        return;
        if (!NetworkUtil.h(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367256), 0).b(a());
          return;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.av, 0);
      } while ((localList == null) || (localList.size() < 20) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.jdField_a_of_type_Boolean = true;
      this.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().f();
    } while (!QLog.isColorLevel());
    QLog.i("Q.newfriendSystemMsgListView", 2, "loadNextPage.get next page.");
  }
  
  private void s()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "stopLoadMore().");
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131492908);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.c();
    }
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    o();
    p();
    m();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    int j = paramStructMsg.msg.src_id.get();
    if ((paramStructMsg.msg.sub_type.get() != 6) && ((j == 3016) || (j == 2016)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("newfriend_sysmsg_game_add_friends_tips", true)))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1015);
      setIsShowGameAddFriendsTips(false);
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new oiy(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.g();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.f();
  }
  
  protected void g()
  {
    super.g();
    n();
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.e();
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("newfriend_sysmsg_game_add_friends_tips", true)) && (this.jdField_a_of_type_ComTencentWidgetSwipListView.m() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.a(this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.h();
    }
    FriendSystemMsgController.a().b();
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount() > 0)
      {
        this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131368647));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("title", this.jdField_a_of_type_AndroidContentContext.getString(2131370964));
    a(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void setIsShowGameAddFriendsTips(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("newfriend_sysmsg_game_add_friends_tips", paramBoolean).commit();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new oiz(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\newfriend\SystemMsgListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.dating;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView.RightIconMenuListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import rco;
import rcr;
import rcs;
import rct;

public class BaseMsgBoxActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, IFlingSwitch, AbsListView.OnScrollListener, SwipListView.RightIconMenuListener, Observer
{
  public static final int a = 0;
  protected static final String a = "Q.msg_box";
  public static final int b = 1;
  private static final int jdField_d_of_type_Int = 50;
  private static final int e = 0;
  public long a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback;
  public View a;
  public ViewStub a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public RecentAdapter a;
  public DragFrameLayout a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  FPSSwipListView jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView;
  public List a;
  public Map a;
  public MqqHandler a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  public boolean b;
  public int c;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int f;
  private int g;
  
  public BaseMsgBoxActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.f = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rco(this);
    this.jdField_a_of_type_AndroidOsHandler$Callback = new rcs(this);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    Object localObject = localViewGroup;
    if (localView != null)
    {
      localObject = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
    }
    localObject = ((ViewGroup)localObject).getChildAt(0);
    if ((localObject instanceof TopGestureLayout)) {
      return (TopGestureLayout)localObject;
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    }
  }
  
  protected List a(List paramList)
  {
    return null;
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramView = paramRecentBaseData.a();
    if (MsgProxyUtils.c(paramView))
    {
      paramRecentBaseData = new Intent(this, SayHelloMsgListActivity.class);
      paramRecentBaseData.putExtra("uin", paramView);
      paramRecentBaseData.putExtra("uintype", this.jdField_c_of_type_Int);
      startActivity(paramRecentBaseData);
      return;
    }
    paramString = (FriendsManager)this.app.getManager(50);
    if (paramString != null) {}
    for (paramBoolean = paramString.b(paramView);; paramBoolean = false)
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtra("uin", paramView);
      if (paramBoolean) {
        localIntent.putExtra("uintype", 0);
      }
      for (;;)
      {
        paramString = ContactUtils.o(this.app, paramRecentBaseData.a());
        paramView = paramString;
        if (TextUtils.isEmpty(paramString)) {
          paramView = ContactUtils.b(this.app, paramRecentBaseData.a(), false);
        }
        localIntent.putExtra("uinname", paramView);
        startActivity(localIntent);
        if (!(paramRecentBaseData instanceof RecentSayHelloListItem)) {
          break;
        }
        paramView = (RecentSayHelloListItem)paramRecentBaseData;
        if (paramView.V <= 0) {
          break;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005DEF", "0X8005DEF", paramView.V, 0, "", "", "", "");
        return;
        localIntent.putExtra("uintype", paramRecentBaseData.a());
        if (paramRecentBaseData.a() == 7100) {
          ReportController.b(this.app, "CliOper", "", "", "0X80050D6", "0X80050D6", 0, 0, "", "", "", "");
        }
      }
    }
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      int i = this.app.a().a(paramRecentBaseData.a(), paramRecentBaseData.a());
      this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, paramRecentBaseData.a(), this.app.a());
      if (i > 0)
      {
        if (!MsgProxyUtils.c(paramRecentBaseData.a())) {
          break label145;
        }
        ThreadManager.a(new rcr(this, paramRecentBaseData.a(), paramRecentBaseData.a()), 8, null, false);
      }
    }
    for (;;)
    {
      if ((AppConstants.aP.equals(paramRecentBaseData.a())) || (AppConstants.aO.equals(paramRecentBaseData.a()))) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005297", "0X8005297", 0, 0, "", "", "", "");
      }
      return;
      label145:
      this.jdField_c_of_type_JavaLangString = (paramRecentBaseData.a() + "_" + this.jdField_c_of_type_Int);
      RecentUtil.b(this.app, paramRecentBaseData.a(), this.jdField_c_of_type_Int);
      this.app.a().a(paramRecentBaseData.a(), this.jdField_c_of_type_Int, true, true);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramAbsListView.d_() - 1 == paramAbsListView.t()) {}
    for (int i = 1;; i = 0)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(false);
      }
      for (;;)
      {
        this.f = paramInt;
        if ((paramInt == 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
        {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
        }
        if ((i == 0) || (this.jdField_a_of_type_MqqOsMqqHandler == null)) {
          break;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(true);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2) {}
  
  protected void a(List paramList)
  {
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      localMessage.obj = paramList;
      this.jdField_b_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) {
      a();
    }
  }
  
  public boolean a()
  {
    return (this.f != 0) && (this.f != 1);
  }
  
  public void b(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void b(List paramList) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904219);
    getWindow().setBackgroundDrawable(null);
    this.jdField_c_of_type_Int = getIntent().getIntExtra("uintype", -1);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "BOX UIN:" + this.jdField_b_of_type_JavaLangString + "|BOX TYPE:" + this.jdField_c_of_type_Int);
    }
    if (!MsgProxyUtils.a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int))
    {
      this.jdField_b_of_type_JavaLangString = AppConstants.ar;
      this.jdField_c_of_type_Int = 1001;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131301867));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView = ((FPSSwipListView)findViewById(2131301863));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301864);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301865));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131301866));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2130903202, null);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.b(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setOnScrollListener(this);
    if (MsgProxyUtils.c(this.jdField_b_of_type_JavaLangString)) {}
    for (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 7);; this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView, this, 6))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
      this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(ThreadManager.b(), this);
      this.jdField_b_of_type_MqqOsMqqHandler = new CustomHandler(getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
      this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.a().addObserver(this);
      if (QLog.isColorLevel()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && ((AppConstants.aH.equals(this.jdField_b_of_type_JavaLangString)) || (AppConstants.ar.equals(this.jdField_b_of_type_JavaLangString))))
    {
      QQMessageFacade.Message localMessage = this.app.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
      if (localMessage != null) {
        this.app.a().a(this.jdField_c_of_type_Int, localMessage.time);
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    this.f = 0;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 50;
    long l1;
    int j;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      l1 = System.currentTimeMillis();
      this.jdField_b_of_type_JavaUtilList = this.app.a(this.jdField_c_of_type_Int).a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int);
      b(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg_box", 4, "cloneMsgBoxList cost time: " + (System.currentTimeMillis() - l1));
      }
      if (this.jdField_b_of_type_JavaUtilList == null)
      {
        i = 0;
        if (i > 50) {
          break label293;
        }
        j = i;
        label124:
        if ((this.g <= j) || (this.g > i)) {
          break label524;
        }
        j = this.g;
      }
      break;
    }
    label159:
    label293:
    label308:
    label371:
    label508:
    label519:
    label524:
    for (;;)
    {
      if (j > 50)
      {
        this.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "refresh_list|totalCount:" + i + ",curCount:" + this.g + ",loadCount:" + j);
        }
        LinkedList localLinkedList = new LinkedList();
        paramMessage = localLinkedList;
        if (this.jdField_b_of_type_JavaUtilList != null)
        {
          paramMessage = localLinkedList;
          if (i > 0) {
            paramMessage = this.jdField_b_of_type_JavaUtilList.subList(0, j);
          }
        }
        paramMessage = a(paramMessage);
        if (paramMessage == null) {
          break label308;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.g = i;
        a(paramMessage);
        return false;
        i = this.jdField_b_of_type_JavaUtilList.size();
        break;
        j = 50;
        break label124;
        this.jdField_d_of_type_Boolean = false;
        break label159;
      }
      l1 = System.currentTimeMillis();
      if ((this.g > 0) && (this.jdField_b_of_type_JavaUtilList != null))
      {
        int k = this.g;
        j = this.jdField_b_of_type_JavaUtilList.size() - this.g;
        if (j <= 0) {
          break;
        }
        if (j <= 50) {
          break label508;
        }
        this.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "loadNextPageData|totalCount:" + this.jdField_b_of_type_JavaUtilList.size() + ",loadCount:" + i);
        }
        paramMessage = a(this.jdField_b_of_type_JavaUtilList.subList(0, k - 1 + 1 + i));
        if (paramMessage == null) {
          break label519;
        }
      }
      for (i = paramMessage.size();; i = 0)
      {
        this.g = i;
        a(paramMessage);
        if (!QLog.isColorLevel()) {
          break;
        }
        long l2 = System.currentTimeMillis();
        QLog.d("Q.msg_box", 2, "loadNextPageData cost time:" + (l2 - l1));
        return false;
        this.jdField_d_of_type_Boolean = false;
        i = j;
        break label371;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramObservable.senderuin))) {}
    }
    else
    {
      return;
    }
    paramObject = paramObservable.senderuin + "_" + paramObservable.istroop;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg_box", 2, "update key:" + (String)paramObject + "|mDelItemKey:" + this.jdField_c_of_type_JavaLangString);
    }
    if (((String)paramObject).equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_c_of_type_JavaLangString = "";
      return;
    }
    boolean bool;
    if (((MsgProxyUtils.a(paramObservable.istroop) == 1010) && (this.jdField_c_of_type_Int == 1010)) || ((MsgProxyUtils.a(paramObservable.istroop) == 1001) && (this.jdField_c_of_type_Int == 1001))) {
      bool = true;
    }
    for (;;)
    {
      runOnUiThread(new rct(this, bool));
      return;
      if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
      {
        paramObject = new ArrayList(this.jdField_b_of_type_JavaUtilList).iterator();
        for (;;)
        {
          if (((Iterator)paramObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)paramObject).next();
            if (paramObservable.frienduin.equals(localMessageRecord.senderuin))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg_box", 2, "needRefresh update,uin:" + paramObservable.frienduin + ",type:" + paramObservable.istroop);
                bool = true;
                break;
              }
              bool = true;
              break;
            }
          }
        }
      }
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\BaseMsgBoxActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
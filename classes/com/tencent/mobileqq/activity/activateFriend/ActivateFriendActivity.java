package com.tencent.mobileqq.activity.activateFriend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import nbk;
import nbl;
import nbm;
import nbn;
import nbo;
import nbp;
import nbq;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneGeoGraphicFriend;

public class ActivateFriendActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, Observer
{
  public static final int a = 1;
  public static final String a = "af_key_from";
  public static final int b = 2;
  private static final String b = "ActivateFriends.MainActivity";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 1000;
  public static final int g = 1;
  private static final int h = 1;
  Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ActivatePageAdapter jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter;
  public BirthdayActivatePage a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver;
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private ActivateFriendsObserver jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private boolean jdField_a_of_type_Boolean;
  private int i;
  private int j;
  private int k;
  
  public ActivateFriendActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new nbm(this));
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new nbo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver = new nbp(this);
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
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, long[] paramArrayOfLong)
  {
    PositionActivatePage localPositionActivatePage = new PositionActivatePage(this);
    localPositionActivatePage.a(paramQQAppInterface, paramLong, paramString, paramArrayOfLong);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(localPositionActivatePage);
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, long[] paramArrayOfLong1, String[] paramArrayOfString, long[] paramArrayOfLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage = new BirthdayActivatePage(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.a(paramQQAppInterface, paramLong, paramArrayOfLong1, paramArrayOfString, paramArrayOfLong2);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage);
  }
  
  private boolean a()
  {
    if (getIntent().getExtras() != null) {}
    for (Object localObject1 = getIntent().getExtras().getString("leftViewText");; localObject1 = null)
    {
      if ((localObject1 != null) && (((String)localObject1).contains(getString(2131367566)))) {}
      for (int m = 1;; m = 0)
      {
        if (m != 0) {
          this.app.a().addObserver(this);
        }
        this.app.a().c(AppConstants.aJ, 9002);
        localObject1 = this.app.a().b(AppConstants.aJ, 9002);
        m = ((List)localObject1).size();
        if (QLog.isColorLevel()) {
          QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + m);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
        }
        if (m != 0) {
          break label251;
        }
        a(this.app, System.currentTimeMillis(), null, null, null);
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.c();
        a();
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.d();
      localObject1 = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.findViewById(2131299603);
      Object localObject2 = new SpannableString("启用一声问候，查看好友生日。");
      ((SpannableString)localObject2).setSpan(new nbk(this), 0, 2, 33);
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
      return false;
      label251:
      Collections.sort((List)localObject1, new nbl(this));
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
      }
      localObject2 = (MessageForActivateFriends)((List)localObject1).get(0);
      Object localObject3 = this.app;
      if (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() == 1)
      {
        m = 0;
        ReportController.b((QQAppInterface)localObject3, "CliOper", "", "", "0X8004E05", "0X8004E05", m, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
        localObject1 = ((List)localObject1).iterator();
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label834;
        }
        localObject3 = (MessageRecord)((Iterator)localObject1).next();
        localObject2 = ((MessageForActivateFriends)localObject3).getMsgBody();
        long l = 1000L * ((MessageRecord)localObject3).time;
        m = ((SubMsgType0x76.MsgBody)localObject2).uint32_msg_type.get();
        long[] arrayOfLong;
        if ((m == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.jdField_a_of_type_Boolean))
        {
          localObject3 = ((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.bytes_local_city.get().toStringUtf8();
          arrayOfLong = new long[((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.rpt_msg_one_friend.get().size()];
          m = 0;
          for (;;)
          {
            if (m < arrayOfLong.length)
            {
              arrayOfLong[m] = ((SubMsgType0x76.OneGeoGraphicFriend)((SubMsgType0x76.MsgBody)localObject2).msg_geographic_notify.rpt_msg_one_friend.get().get(m)).uint64_uin.get();
              m += 1;
              continue;
              m = 1;
              break;
            }
          }
          a(this.app, l, (String)localObject3, arrayOfLong);
        }
        else if (m == 2)
        {
          localObject3 = new long[((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().size()];
          arrayOfLong = new long[localObject3.length];
          String[] arrayOfString = new String[localObject3.length];
          m = 0;
          if (m < localObject3.length)
          {
            localObject3[m] = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint64_uin.get();
            int n = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_month.get();
            int i1 = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_date.get();
            int i2 = ActivateFriendsManager.a(((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint32_birth_year.get(), n, i1);
            arrayOfString[m] = ActivateFriendsManager.a(i2, n, i1);
            if ((i2 == 0) || (i2 == 1)) {
              arrayOfLong[m] = MessageCache.a();
            }
            for (;;)
            {
              m += 1;
              break;
              arrayOfLong[m] = ((SubMsgType0x76.OneBirthdayFriend)((SubMsgType0x76.MsgBody)localObject2).msg_birthday_notify.rpt_msg_one_friend.get().get(m)).uint64_msg_send_time.get();
            }
          }
          a(this.app, l, (long[])localObject3, arrayOfString, arrayOfLong);
        }
      }
      label834:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null) {}
      for (m = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.getCount();; m = 0)
      {
        this.k = m;
        if (this.k > 1)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.j = 0;
          a(this.j);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.d();
        }
        return true;
      }
    }
  }
  
  private void c()
  {
    super.setContentView(2130904066);
    super.setTitle(2131371386);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297392));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838587);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297083));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131301240));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131301239));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter = new ActivatePageAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(84));
    if (this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.jdField_a_of_type_Boolean) {
      super.setTitle(2131371387);
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true);
    this.i = getIntent().getIntExtra("af_key_from", 1);
    if (AppSetting.j) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131370943));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBirthdayActivatePage.c();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
  }
  
  void a(int paramInt)
  {
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + paramInt);
    }
    if (this.k <= 1)
    {
      paramInt = m;
      while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setVisibility(8);
        paramInt += 1;
      }
    }
    m = 0;
    while (m < this.k)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m).setVisibility(0);
      m += 1;
    }
    m = 0;
    if (m < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      if (m == paramInt) {
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m)).setImageResource(2130837549);
      }
      for (;;)
      {
        m += 1;
        break;
        ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(m)).setImageResource(2130837548);
      }
    }
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131371403), this.jdField_a_of_type_Boolean);
    localActionSheet.a(new nbn(this, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int m = -1;
    StringBuilder localStringBuilder = new StringBuilder("doOnActiResult").append(" | rs code = ").append(paramInt2);
    long[] arrayOfLong;
    if ((paramInt1 == 1000) && (paramInt2 == -1)) {
      if (paramIntent != null)
      {
        arrayOfLong = paramIntent.getLongArrayExtra("key_friend_list");
        paramInt2 = paramIntent.getIntExtra("key_msg_type", -1);
        if ((arrayOfLong != null) && (arrayOfLong.length > 0) && (paramInt2 != -1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(arrayOfLong, paramInt2);
        }
        paramIntent = localStringBuilder.append(" | uinArray len = ");
        if (arrayOfLong != null) {
          break label140;
        }
      }
    }
    label140:
    for (paramInt1 = m;; paramInt1 = arrayOfLong.length)
    {
      paramIntent.append(paramInt1).append(" | type = ").append(paramInt2);
      super.finish();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.MainActivity", 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsObserver);
    this.app.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(null);
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    setIntent(paramIntent);
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivatePageAdapter.a();
      a();
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.jdField_a_of_type_Boolean) && ((this.i == 3) || (this.i == 4)))
    {
      Intent localIntent = new Intent(this, NewFriendActivity.class);
      localIntent.putExtra("EntranceId", 1);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.j = paramInt;
    a(paramInt);
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      if (this.j == 0) {
        localTopGestureLayout.setInterceptTouchFlag(true);
      }
    }
    else {
      return;
    }
    localTopGestureLayout.setInterceptTouchFlag(false);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      int n = 1;
      int m = n;
      if ((paramObject instanceof ChatMessage))
      {
        m = n;
        if (((MessageRecord)paramObject).isSendFromLocal()) {
          m = 0;
        }
      }
      if (m != 0) {
        runOnUiThread(new nbq(this));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\activateFriend\ActivateFriendActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
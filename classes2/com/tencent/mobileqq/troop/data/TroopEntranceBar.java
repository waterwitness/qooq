package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.PubAccBindTroopListActivity;
import com.tencent.mobileqq.troop.activity.TransparentJumpAssistantActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;
import vmf;
import vmh;

public class TroopEntranceBar
  extends Observable
  implements View.OnClickListener
{
  public static final int a = -1;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public long a;
  public Context a;
  private LightingColorFilter jdField_a_of_type_AndroidGraphicsLightingColorFilter;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ChatAdapter1 a;
  public SessionInfo a;
  protected FriendListObserver a;
  public QQAppInterface a;
  public ChatXListView a;
  protected FaceDecoder a;
  public String a;
  public List a;
  public Map a;
  public Observer a;
  public boolean a;
  private LightingColorFilter jdField_b_of_type_AndroidGraphicsLightingColorFilter;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  public List b;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_c_of_type_AndroidViewView;
  private Drawable d;
  private Drawable e;
  public int g;
  public int h;
  public int i;
  private int j;
  private int k;
  
  public TroopEntranceBar()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaLangString = "http://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?scode=%1$s&chat=1&_wv=1027";
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new vmh(this);
  }
  
  public void a()
  {
    deleteObservers();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilObserver = null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
    localReqBody.uint32_channel.set(1);
    localReqBody.uint64_subscribe_code.set(paramLong);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new vmf(this, paramLong), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((this.h <= 0) && (this.g <= 0))
    {
      this.i = -1;
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Long = 0L;
    this.h = 0;
    Object localObject1 = ((TroopManager)paramQQAppInterface.getManager(51)).a();
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.h += 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
            if (paramQQAppInterface.b(((TroopInfo)localObject2).troopuin) == 3) {
              this.jdField_b_of_type_JavaUtilList.add(((TroopInfo)localObject2).troopuin);
            }
            this.jdField_a_of_type_JavaUtilMap.put(((TroopInfo)localObject2).troopuin, Integer.valueOf(paramQQAppInterface.a().a(((TroopInfo)localObject2).troopuin, 1)));
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      d();
      e();
      paramQQAppInterface.a().b(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131297418);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_JavaUtilObserver = paramObserver;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.j = paramContext.getResources().getColor(2131427861);
    this.k = paramContext.getResources().getColor(2131427862);
    this.jdField_a_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.j);
    this.jdField_b_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.k);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Boolean) || (this.i == -1)) {
      return;
    }
    if (this.jdField_c_of_type_AndroidViewView == null) {
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903875, null);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_c_of_type_AndroidViewView) == -1)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131297418);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 41.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131300533);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300535));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300536));
    Object localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
    ((LinearLayout.LayoutParams)localObject).height = m;
    ((LinearLayout.LayoutParams)localObject).width = m;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843458);
    }
    for (;;)
    {
      this.e = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840066);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_Boolean = true;
      c();
      return;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130843459);
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localObject = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300534);
      ((ImageView)localObject).setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localLayoutParams.height = -2;
      localLayoutParams.width = -2;
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 8.0F);
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840067);
      if ((this.i == 1) || (this.i == 3))
      {
        int m = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLayoutParams.height = m;
        localLayoutParams.width = m;
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(((TroopInfo)this.jdField_a_of_type_JavaUtilList.get(0)).troopuin));
        }
      }
      for (;;)
      {
        ((ImageView)localObject).setLayoutParams(localLayoutParams);
        if ((this.i != 4) && (this.i != 0)) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.j);
        if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.e.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
        }
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131365242);
        return;
        if ((this.i == 4) || (this.i == 0))
        {
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 11.0F);
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
        else if (this.i == 2)
        {
          localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 11.0F);
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localDrawable.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
          }
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_b_of_type_AndroidGraphicsLightingColorFilter);
          ((ImageView)localObject).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      if (this.i == 2)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.k);
        if (this.d == null) {
          this.d = this.e.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
        }
        this.d.setColorFilter(this.jdField_b_of_type_AndroidGraphicsLightingColorFilter);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.d);
        if (this.jdField_a_of_type_Long < 99L) {}
        for (localObject = this.jdField_a_of_type_Long + "";; localObject = "99+")
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365244), new Object[] { localObject }));
          return;
        }
      }
      if (this.i == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.j);
        if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = this.e.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
        }
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsLightingColorFilter);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131365243);
        return;
      }
    } while (this.i != 1);
    if (this.d == null) {
      this.d = this.e.getConstantState().newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources()).mutate();
    }
    this.d.setColorFilter(this.jdField_b_of_type_AndroidGraphicsLightingColorFilter);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.d);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.k);
    if (this.jdField_a_of_type_Long < 99L) {}
    for (Object localObject = this.jdField_a_of_type_Long + "";; localObject = "99+")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365244), new Object[] { localObject }));
      return;
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l += ((Integer)localIterator.next()).intValue()) {}
    this.jdField_a_of_type_Long = l;
  }
  
  public void e()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    if (this.h <= 0)
    {
      this.i = 0;
      str1 = "entry_none";
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label128;
      }
    }
    label128:
    for (String str2 = "";; str2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_public", "", "oper", str1, 0, 0, "", "", "", str2);
      return;
      if (this.h == 1)
      {
        if (this.jdField_a_of_type_Long <= 0L) {}
        for (this.i = 3;; this.i = 1)
        {
          str1 = "entry_one";
          break;
        }
      }
      if (this.jdField_a_of_type_Long <= 0L) {}
      for (this.i = 4;; this.i = 2)
      {
        str1 = "entry_more";
        break;
      }
    }
  }
  
  public void f()
  {
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.h += 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (this.i)
    {
    default: 
      return;
    case 0: 
      paramView = String.format(this.jdField_a_of_type_JavaLangString, new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString });
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    case 1: 
    case 3: 
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, TransparentJumpAssistantActivity.class);
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
      for (paramView = (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(0);; paramView = null)
      {
        ((Intent)localObject).putExtra("pub_acc_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("pub_acc_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        if (paramView != null)
        {
          if (paramView.troopuin != null) {
            ((Intent)localObject).putExtra("uin", paramView.troopuin);
          }
          if (paramView.troopcode != null) {
            ((Intent)localObject).putExtra("troop_uin", paramView.troopcode);
          }
          if (paramView.troopname != null) {
            ((Intent)localObject).putExtra("uinname", paramView.troopname);
          }
        }
        ((Intent)localObject).putExtra("uintype", 1);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) {
          ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).finish();
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_one_grp", 0, 0, "", this.jdField_a_of_type_Long + "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return;
      }
    }
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PubAccBindTroopListActivity.class);
    paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramView.putExtra("pub_acc_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramView.putExtra("pub_acc_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    Object localObject = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ArrayList)localObject).add(((TroopInfo)localIterator.next()).troopuin);
    }
    paramView.putStringArrayListExtra(PubAccBindTroopListActivity.b, (ArrayList)localObject);
    paramView.putExtra(PubAccBindTroopListActivity.c, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) {
      ((ChatActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_more_grp", 0, 0, "", this.jdField_a_of_type_Long + "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopEntranceBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
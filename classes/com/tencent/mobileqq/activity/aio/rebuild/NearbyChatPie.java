package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.NearbyMarketGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper;
import com.tencent.mobileqq.nearby.NearbyChatFlowerHelper.FlowerPlayable;
import com.tencent.mobileqq.nearby.NearbyRelevantObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.util.Observable;
import mqq.os.MqqHandler;
import nzh;
import nzi;
import nzj;
import nzk;
import nzl;
import nzm;
import nzn;
import nzo;

public class NearbyChatPie
  extends BaseChatPie
  implements NearbyChatFlowerHelper.FlowerPlayable
{
  static final int dP = -1;
  public boolean J;
  protected boolean K;
  boolean L;
  boolean M;
  protected MessageObserver a;
  ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver;
  public NearbyChatFlowerHelper a;
  NearbyRelevantObserver jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver;
  public final String al;
  public String am;
  String an;
  public String ao;
  protected String ap;
  int dQ;
  public int dR;
  protected int dS;
  
  public NearbyChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.al = NearbyChatPie.class.getSimpleName();
    this.dQ = 0;
    this.dR = -1;
    this.L = false;
    this.M = false;
    this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new nzl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new nzm(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver = new nzn(this);
    this.an = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("from_where_to_aio");
    this.J = true;
  }
  
  private void aD()
  {
    if (a().getIntent().getBooleanExtra("from_newer_guide", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("has_operation", this.M);
      localIntent.putExtra("uin", a().getIntent().getStringExtra("tinyId"));
      a().setResult(-1, localIntent);
    }
  }
  
  protected void A()
  {
    super.A();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.b();
    }
  }
  
  protected void B()
  {
    super.B();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.b();
    }
  }
  
  public void F()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper.c();
    }
    super.F();
  }
  
  protected void N()
  {
    aD();
    super.N();
  }
  
  protected void W()
  {
    super.W();
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new nzo(this), 200L);
  }
  
  public NearbyChatFlowerHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyChatFlowerHelper;
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    super.a(paramIntent, paramInt);
    if ((this.K) && (!this.L))
    {
      this.L = true;
      this.ap = paramIntent.getStringExtra("SHOWLOVE_PIC");
      this.ao = paramIntent.getStringExtra("SHOWLOVE_MSG");
      this.dS = paramIntent.getIntExtra("gender", -1);
      aC();
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop))));
  }
  
  void aC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_bank", 4, "doSendShowLoveMsg,picPath:" + this.ap + ",msg:" + this.ao + ",gender:" + this.dS);
    }
    if (TextUtils.isEmpty(this.ap)) {
      return;
    }
    if (this.dS == 0) {}
    for (Object localObject1 = "男";; localObject1 = "女")
    {
      Object localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131372096, new Object[] { localObject1, localObject1 });
      localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130904326, null);
      ((View)localObject1).setOnClickListener(this);
      ((TextView)((View)localObject1).findViewById(2131302335)).setText((CharSequence)localObject2);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131297409);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131297409);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.ap);
      if (TextUtils.isEmpty(this.ao)) {
        break;
      }
      this.q = true;
      localObject1 = new Message();
      ((Message)localObject1).what = 39;
      ((Message)localObject1).obj = this.ao;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 2000L);
      return;
    }
  }
  
  protected void ae()
  {
    super.ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
  }
  
  protected void af()
  {
    super.af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyRelevantObserver);
  }
  
  public void aq()
  {
    if (this.K) {
      return;
    }
    super.aq();
  }
  
  protected void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (TextUtils.isEmpty(str)) {
      paramIntent = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    this.b.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    if (QLog.isDevelopLevel()) {
      DatingUtil.a(this.al, new Object[] { "updateSession_updateTitle", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (String str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; str = null)
    {
      super.c();
      if ((this.am != null) && (this.am.length() > 0) && (this.am.equals(str))) {
        ThreadManager.a(new nzj(this, str), 5, null, false);
      }
      this.am = null;
      if ((this.an != null) && (this.an.equals("nearby_recommend_people")) && (this.J)) {
        ThreadManager.a(new nzk(this), 1, null, false);
      }
      this.M = true;
      return;
    }
  }
  
  protected void d(Intent paramIntent)
  {
    super.d(paramIntent);
    StartupTracker.a(null, "AIO_updateSession_business");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      localObject = paramIntent.getByteArrayExtra("rich_status_sig");
      if (QLog.isColorLevel()) {
        QLog.d(this.al, 2, "From chatActivity : sameState Sig--->" + HexUtil.a((byte[])localObject));
      }
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
      }
    }
    for (;;)
    {
      this.K = paramIntent.getBooleanExtra("IS_FROM_SHOWLOVE", false);
      this.r = this.K;
      if (-1 == this.dR) {
        ThreadManager.a(new nzh(this), 8, null, false);
      }
      StartupTracker.a("AIO_updateSession_business", null);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)
      {
        this.dR = paramIntent.getIntExtra("gender", -1);
        localObject = paramIntent.getByteArrayExtra("rich_accost_sig");
        if (QLog.isColorLevel()) {
          QLog.d(this.al, 2, "From chatActivity : accost Sig--->" + HexUtil.a((byte[])localObject));
        }
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
        if (2 == paramIntent.getExtras().getInt("cSpecialFlag"))
        {
          ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        else
        {
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (localObject == null)
          {
            if (StringUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte)1, 0);
            }
          }
          else if ((localObject != null) && (((Card)localObject).strCertificationInfo != null) && (!((Card)localObject).strCertificationInfo.equals(""))) {
            ChatActivityFacade.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010)
      {
        this.dR = paramIntent.getIntExtra("gender", -1);
        this.dQ = paramIntent.getIntExtra("dating_from_id", 0);
        localObject = paramIntent.getByteArrayExtra("rich_date_sig");
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().k(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (byte[])localObject);
        }
      }
    }
  }
  
  protected boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1010);
  }
  
  protected boolean e()
  {
    aD();
    return super.e();
  }
  
  protected void h()
  {
    if (this.K) {
      return;
    }
    super.h();
    NearbyMarketGrayTips localNearbyMarketGrayTips = new NearbyMarketGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
    localNearbyMarketGrayTips.a(this.dR);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localNearbyMarketGrayTips);
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1009)
    {
      super.n();
      return;
    }
    this.c.setOnClickListener(new nzi(this));
    this.c.setVisibility(0);
    this.c.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131367630));
  }
  
  public void o()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("add_friend_source_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  protected void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && ((paramObject instanceof ChatMessage)))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) && ((this.dQ == 2) || (this.dQ == 3)) && (paramObservable.isSendFromLocal()) && (Utils.a(paramObservable.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())))
      {
        if (this.dQ != 2) {
          break label265;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004946", "0X8004946", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.dQ = 0;
      if ((!paramObservable.isSendFromLocal()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramObservable.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramObservable.istroop)))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) && (paramObservable.msgtype == 62535))
      {
        paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if ((paramObservable != null) && (paramObservable.istroop == 1001) && (paramObservable.msgtype == 62535)) {
          OpenAppClient.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext(), paramObservable.action);
        }
      }
      return;
      label265:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004945", "0X8004945", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\rebuild\NearbyChatPie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
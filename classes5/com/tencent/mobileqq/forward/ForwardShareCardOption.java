package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.utils.AvatarTroopUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import mqq.manager.TicketManager;
import smg;
import smi;
import smj;

public class ForwardShareCardOption
  extends ForwardBaseOption
{
  public static final String a = "ForwardOption.ForwardShareCardOption";
  private static final int jdField_b_of_type_Int = -1;
  private static final int c = 0;
  private static final int d = 1;
  public static final String g = "business_card_ocr";
  public static final String h = "curent_aio_uin";
  public static final String i = "curent_aio_uin_type";
  public static final String j = "curent_aio_uinname";
  public static final String k = "curent_aio_troop_uin";
  DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver;
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private String ae;
  private String af;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private String ak;
  private String al;
  private DiscussionObserver jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver;
  private int e;
  private int f;
  private boolean g;
  
  public ForwardShareCardOption(Intent paramIntent)
  {
    super(paramIntent);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new smi(this);
    this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver = new smj(this);
  }
  
  private AbsStructMsgItem a(String paramString)
  {
    StructMsgItemLayoutDefault localStructMsgItemLayoutDefault = new StructMsgItemLayoutDefault();
    localStructMsgItemLayoutDefault.d(1);
    localStructMsgItemLayoutDefault.b(paramString);
    return localStructMsgItemLayoutDefault;
  }
  
  private void a(CardOCRInfo paramCardOCRInfo)
  {
    if (paramCardOCRInfo == null) {
      return;
    }
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    if (paramCardOCRInfo.a == null) {
      paramCardOCRInfo.a = "";
    }
    Object localObject1;
    if ((paramCardOCRInfo.jdField_b_of_type_JavaUtilList != null) && (paramCardOCRInfo.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = (String)paramCardOCRInfo.jdField_b_of_type_JavaUtilList.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      Object localObject3 = "url=" + paramCardOCRInfo.jdField_b_of_type_JavaLangString + ";name=" + paramCardOCRInfo.a + ";phone=" + (String)localObject1;
      localObject2 = ((AbsShareMsg.Builder)localObject2).c(73).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131371269, new Object[] { paramCardOCRInfo.a })).a(2).a("shareBusinessCard", "", (String)localObject3, (String)localObject3, (String)localObject3).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131371270)).a();
      localObject3 = new StructMsgItemLayoutDefault();
      ((AbsStructMsgItem)localObject3).d(1);
      ((AbsStructMsgItem)localObject3).b(this.jdField_a_of_type_AndroidAppActivity.getString(2131371268));
      StructMsgItemLayout2 localStructMsgItemLayout2 = new StructMsgItemLayout2();
      localStructMsgItemLayout2.d(3);
      localStructMsgItemLayout2.a(new StructMsgItemCover(paramCardOCRInfo.jdField_b_of_type_JavaLangString + "/?02"));
      localStructMsgItemLayout2.a(new StructMsgItemTitle(paramCardOCRInfo.a));
      localStructMsgItemLayout2.a(new StructMsgItemSummary((String)localObject1));
      ((AbsShareMsg)localObject2).addItem((AbsStructMsgElement)localObject3);
      ((AbsShareMsg)localObject2).addItem(localStructMsgItemLayout2);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("req_type", 5);
      ((Bundle)localObject1).putString("image_url", paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      BusinessCardUtils.a(paramCardOCRInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = StructMsgFactory.a(((StructMsgForImageShare)StructMsgFactory.a((Bundle)localObject1)).getBytes());
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      h();
      return;
      localObject1 = "";
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class);
    String str1 = "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramString1;
    String str2 = "AppCmd://OpenContactInfo/?uin=" + paramString1;
    Object localObject1 = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject1 = ((AbsShareMsg.Builder)localObject2).c(14).a("推荐了" + paramString2).a("plugin", "", str2, str1, str1).d(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131368043)).a();
      localObject2 = new StructMsgItemLayout2();
      ((AbsStructMsgItem)localObject2).d(1);
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemCover(str1));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemTitle(paramString2));
      ((AbsStructMsgItem)localObject2).a(new StructMsgItemSummary("帐号: " + paramString1));
      ((AbsShareMsg)localObject1).addItem(a("推荐联系人"));
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)localObject1);
      h();
      return;
      paramString2 = (String)localObject1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    int m = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
    localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ThreadManager.a(new smg(this, m, paramString, (String)localObject, paramBoolean), 8, null, false);
      return;
    }
    r();
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, "拉取多人聊天链接失败，请重试！", 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
  }
  
  private void b(String paramString1, String paramString2)
  {
    AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a("推荐多人聊天：" + this.ai).e(this.ag).a();
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      localObject = ((DiscussionManager)localObject).a(paramString1);
      if (localObject == null) {}
    }
    for (paramString1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, ((DiscussionInfo)localObject).ownerUin);; paramString1 = null)
    {
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = "创建者信息获取失败";
      }
      paramString1 = StructMsgElementFactory.a(2);
      paramString1.a(paramString2, this.ai, "创建人：" + (String)localObject, 1);
      localAbsShareMsg.addItem(a("推荐多人聊天"));
      localAbsShareMsg.addItem(paramString1);
      this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
      return;
    }
  }
  
  private void u()
  {
    String str1 = this.ai;
    if (TextUtils.isEmpty(str1)) {
      str1 = this.ah;
    }
    for (;;)
    {
      String str2 = AvatarTroopUtil.a("", this.ah, 0) + "100";
      AbsShareMsg localAbsShareMsg = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(15).a(this.jdField_a_of_type_AndroidAppActivity.getString(2131369531) + str1).e(this.ae).a();
      AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
      Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131369536);
      Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject2 != null) && (this.ah != null))
      {
        localObject2 = ((TroopManager)localObject2).a(this.ah);
        if (localObject2 != null)
        {
          if (TextUtils.isEmpty(((TroopInfo)localObject2).mRichFingerMemo)) {
            break label395;
          }
          localObject2 = ((TroopInfo)localObject2).mRichFingerMemo;
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("ForwardOption.ForwardShareCardOption", 2, "summary=" + (String)localObject2);
            localObject1 = localObject2;
          }
        }
      }
      label395:
      for (;;)
      {
        localAbsStructMsgItem.a(str2, str1, (String)localObject1, 1);
        localAbsShareMsg.addItem(a("推荐群"));
        localAbsShareMsg.addItem(localAbsStructMsgItem);
        this.jdField_a_of_type_AndroidOsBundle.putByteArray("stuctmsg_bytes", localAbsShareMsg.getBytes());
        this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = localAbsShareMsg;
        if (QLog.isColorLevel()) {
          QLog.i("ForwardOption.ForwardShareCardOption", 2, "createTroopCardMsg.mMsgServiceID:" + localAbsShareMsg.mMsgServiceID + " mMsgBrief:" + localAbsShareMsg.mMsgBrief + " mContentTitle:" + localAbsShareMsg.mContentTitle + " mContentSummary:" + localAbsShareMsg.mContentSummary + " mMsgUrl:" + localAbsShareMsg.mMsgUrl + " coverUrl:" + str2 + " mSourceName:" + localAbsShareMsg.mSourceName);
        }
        h();
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardShareCardOption", 2, "can't find troop info! summary use default");
        }
      }
    }
  }
  
  private void v()
  {
    boolean bool = false;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131367256), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardShareCardOption", 2, "tryToGetShareLink: net is not supported");
      }
      this.e = -1;
    }
    a(2131369268);
    TroopHandler localTroopHandler = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    String str = this.ah;
    if (this.e == 0) {
      bool = true;
    }
    localTroopHandler.a(str, bool);
  }
  
  protected void a()
  {
    if (k()) {
      this.jdField_a_of_type_JavaUtilSet.add(jdField_b_of_type_JavaLangInteger);
    }
    if (i()) {
      this.jdField_a_of_type_JavaUtilSet.add(d);
    }
    if (j()) {
      this.jdField_a_of_type_JavaUtilSet.add(c);
    }
    this.jdField_a_of_type_JavaUtilSet.add(m);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (!e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = null;
    int m = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("uin");
    String str2 = paramBundle.getString("uinname");
    paramBundle.getString("troop_uin");
    paramBundle = (CardOCRInfo)paramBundle.getParcelable("business_card_ocr");
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.aj);
    this.jdField_a_of_type_AndroidOsBundle.putInt("uintype", this.f);
    this.jdField_a_of_type_AndroidOsBundle.putString("troop_uin", this.al);
    this.jdField_a_of_type_AndroidOsBundle.putString("uinname", this.ak);
    switch (m)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", paramInt);
      return;
      this.ah = null;
      this.ai = null;
      a(paramBundle);
      continue;
      this.ah = null;
      this.ai = null;
      a(str1, str2);
      continue;
      this.ah = str1;
      this.ai = str2;
      this.e = 0;
      v();
      continue;
      this.ah = str1;
      this.ai = str2;
      this.g = true;
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getString(2131367256), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131492908));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(Long.parseLong(str1), true);
      a(2131369268);
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(6));
    this.aj = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uin");
    this.ak = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_uinname");
    this.f = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("curent_aio_uin_type", 0);
    this.al = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("curent_aio_troop_uin");
    return true;
  }
  
  protected boolean a(QQCustomDialog paramQQCustomDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
      paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, AIOUtils.a(-15.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShareCardOption", 2, "updateImageView addStructView");
        }
        paramQQCustomDialog.addView(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidAppActivity, null), localLayoutParams);
      }
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getString(2131369171);
  }
  
  public String c()
  {
    String str = null;
    if (!TextUtils.isEmpty(this.ak)) {
      str = "发送到 " + this.ak;
    }
    return str;
  }
  
  protected void k()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B4", "0X80056B4", 0, 0, "", "", "", "");
    super.k();
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_b_of_type_ComTencentMobileqqAppDiscussionObserver);
    }
    super.q();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\forward\ForwardShareCardOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
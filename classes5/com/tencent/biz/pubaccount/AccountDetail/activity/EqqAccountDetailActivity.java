package com.tencent.biz.pubaccount.AccountDetail.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PaConfigAttr;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import hkm;
import hkn;
import hko;
import hkp;
import hkr;
import hks;
import hkt;
import hkv;
import hkw;
import hkx;
import hky;
import hla;
import hlb;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class EqqAccountDetailActivity
  extends AccountDetailActivity
{
  public EqqDetail a;
  public mobileqq_mp.GetEqqAccountDetailInfoResponse a;
  public String a;
  
  public EqqAccountDetailActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "EqqAccountDetailActivity";
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = null;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramInt3 == 0) {
        if (paramInt3 == paramInt2 - 1) {
          if (paramInt1 != 1) {}
        }
      }
    }
    while (paramInt1 <= 1)
    {
      do
      {
        do
        {
          return 0;
        } while (paramInt1 <= 1);
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 2;
        }
        return 3;
        if (paramInt4 == 0) {
          return 1;
        }
        if (paramInt4 == paramInt1 - 1) {
          return 5;
        }
        return 3;
        if (paramInt3 > 0)
        {
          if (paramInt3 == paramInt2 - 1)
          {
            if (paramInt4 == paramInt1 - 1) {
              return 2;
            }
            if (paramInt4 == 0) {
              return 4;
            }
            return 3;
          }
          if (paramInt4 == 0) {
            return 4;
          }
          if (paramInt4 == paramInt1 - 1) {
            return 5;
          }
          return 3;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getItemBgType error groupId < 0");
      return 0;
    }
    if (paramInt4 == 0) {
      return 1;
    }
    if (paramInt4 == paramInt1 - 1) {
      return 5;
    }
    return 3;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade;
    }
    return 0;
  }
  
  protected View a(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130903117, null);
    ((ImageView)localView.findViewById(2131296821)).setImageResource(2130838008);
    ((ImageView)localView.findViewById(2131297122)).setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131297013);
    String str = paramPaConfigInfo.b;
    if (!TextUtils.isEmpty(str))
    {
      localTextView.setText(str);
      localView.setOnClickListener(new hla(this, paramPaConfigInfo, str));
      return localView;
    }
    return null;
  }
  
  protected ShareActionSheet.Detail a()
  {
    return new ShareActionSheet.Detail(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.uin, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.summary);
  }
  
  protected String a()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name;
    }
    return str;
  }
  
  protected void a()
  {
    int i = 0;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {}
    for (List localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);; localList = null)
    {
      if (localList != null)
      {
        int j = localList.size();
        boolean bool = false;
        while (i < j)
        {
          bool = a((PaConfigAttr)localList.get(i), i, j, true, bool);
          i += 1;
        }
      }
      b();
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mShowMsgFlag = paramInt;
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    if (paramInt == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsSyncLbs = true;
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.mIsAgreeSyncLbs = paramBoolean;
    }
    b(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
  }
  
  void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (b())
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      continue;
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility()) {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache");
    }
    Object localObject = (EqqDetailDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68);
    if (localObject != null) {
      ((EqqDetailDataManager)localObject).a(paramEqqDetail);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramEqqDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.clone(paramEqqDetail);
      if (!((EntityManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail)) {
        ((EntityManager)localObject).a(EqqDetail.class);
      }
    }
    for (;;)
    {
      ((EntityManager)localObject).a();
      if ((paramEqqDetail != null) && (paramEqqDetail.followType == 1))
      {
        localObject = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
        if (localObject != null) {
          ((PublicAccountDataManager)localObject).a(PublicAccountInfo.createPublicAccount(paramEqqDetail, 0L));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveEqqDetailToDBAndCache exit");
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
      ((EntityManager)localObject).a(paramEqqDetail);
    }
  }
  
  public void a(EqqDetail paramEqqDetail, boolean paramBoolean)
  {
    ThreadManager.b().postDelayed(new hkt(this, paramEqqDetail, paramBoolean), 10L);
  }
  
  void a(String paramString)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.c(2131368096);
    localActionSheet.c(getString(2131369290) + paramString);
    localActionSheet.d(2131367262);
    localActionSheet.a(new hkr(this, localActionSheet, paramString));
    localActionSheet.show();
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Class paramClass, boolean paramBoolean)
  {
    boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("need_finish", false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    if (bool)
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1)
    {
      paramString2 = new Intent(this, ChatActivity.class);
      paramString2.putExtra("chat_subType", 1);
      paramString2.putExtra("cSpecialFlag", this.jdField_a_of_type_AndroidContentIntent.getExtras().getInt("cSpecialFlag"));
      paramString2.putExtra("uin", paramString1);
      paramString2.putExtra("uintype", 0);
      paramString2.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      paramString2.putExtra("isforceRequestDetail", paramBoolean);
      paramString2.putExtra("jump_from", 2);
      startActivity(paramString2);
      return;
    }
    paramString2 = new Intent(this, ChatActivity.class);
    paramString2.putExtra("chat_subType", 1);
    paramString2.putExtra("uin", paramString1);
    paramString2.putExtra("uintype", 1024);
    paramString2.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    paramString2.putExtra("isforceRequestDetail", paramBoolean);
    paramString2.putExtra("jump_from", 2);
    startActivity(paramString2);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.isConfirmed = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      a(paramString);
    }
    do
    {
      do
      {
        return;
        if (paramBoolean1)
        {
          d(paramString);
          return;
        }
        if (!paramBoolean2) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null);
      CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, this.p, "IvrEnterpriseDetailEngineFalse");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showCallConfirm no phone ability and no ivr ability");
  }
  
  protected boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = ((EqqDetail)((EntityManager)localObject).a(EqqDetail.class, this.p));
    ((EntityManager)localObject).a();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.mergeFrom(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.config_group_info;
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList = ((PBRepeatMessageField)localObject).get();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return true;
  }
  
  boolean a(ViewGroup paramViewGroup, PaConfigAttr.PaConfigInfo paramPaConfigInfo, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem");
    }
    Object localObject1 = super.getLayoutInflater();
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    int k = (int)(15.0F * this.jdField_a_of_type_Float);
    int i;
    if (paramPaConfigInfo.jdField_a_of_type_Int == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 3)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
        return false;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 10)
      {
        i = 1;
        localObject1 = n(paramPaConfigInfo);
        if (localObject1 != null)
        {
          if (i == 0) {
            break label692;
          }
          switch (paramInt)
          {
          default: 
            ((View)localObject1).setBackgroundResource(2130837509);
          case 4: 
            label148:
            if (paramPaConfigInfo.jdField_a_of_type_Int == 4) {
              ((View)localObject1).setPadding(k, k, k, k);
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      paramViewGroup.addView((View)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addCrmDetailItem exit");
      }
      return true;
      return false;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        paramPaConfigInfo.g = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.latitude;
        paramPaConfigInfo.f = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.longitude;
        localObject1 = a(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        localObject1 = b(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      Object localObject2;
      if (paramPaConfigInfo.jdField_c_of_type_Int == 9)
      {
        i = 1;
        localObject2 = d(paramPaConfigInfo);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "unhandled event_id: " + paramPaConfigInfo.jdField_c_of_type_Int);
      }
      return false;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((LayoutInflater)localObject1).inflate(2130903117, null);
        ((ImageView)((View)localObject1).findViewById(2131296821)).setImageResource(2130838009);
        ((ImageView)((View)localObject1).findViewById(2131297122)).setVisibility(0);
        localObject2 = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return false;
        }
        ((TextView)((View)localObject1).findViewById(2131297013)).setText((CharSequence)localObject2);
        if (paramPaConfigInfo.jdField_a_of_type_JavaLangString.contains("历史")) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.p, "0X8004E45", "0X8004E45", 0, 0, "", "", "", "");
        }
        ((View)localObject1).setOnClickListener(new hkm(this, (String)localObject2, paramPaConfigInfo));
        i = 0;
        break;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        i = 1;
        localObject2 = o(paramPaConfigInfo);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 4)
      {
        localObject1 = c(paramPaConfigInfo);
        if (localObject1 != null)
        {
          i = 0;
          break;
        }
        return false;
      }
      if (paramPaConfigInfo.jdField_a_of_type_Int == 5) {
        return false;
      }
      localObject1 = ((LayoutInflater)localObject1).inflate(2130903117, null);
      i = 0;
      break;
      ((View)localObject1).setBackgroundResource(2130837509);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837512);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837510);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837511);
      break label148;
      ((View)localObject1).setBackgroundResource(2130837511);
      break label148;
      if (paramPaConfigInfo.jdField_a_of_type_Int == 2)
      {
        if (paramPaConfigInfo.e == 5) {
          ((View)localObject1).setPadding(k, j, k, k);
        } else {
          ((View)localObject1).setPadding(k, 0, k, 0);
        }
      }
      else {
        ((View)localObject1).setPadding(k, j, k, k);
      }
    }
    label692:
    paramPaConfigInfo = ((View)localObject1).findViewById(2131297206);
    switch (paramInt)
    {
    default: 
      paramPaConfigInfo.setBackgroundResource(2130837509);
    }
    for (;;)
    {
      paramPaConfigInfo.setPadding(0, k, k, k);
      break;
      paramPaConfigInfo.setBackgroundResource(2130837509);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837512);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837510);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837511);
      continue;
      paramPaConfigInfo.setBackgroundResource(2130837511);
    }
  }
  
  public boolean a(PaConfigAttr paramPaConfigAttr, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup start");
    }
    ViewGroup localViewGroup = a();
    paramPaConfigAttr = a(paramPaConfigAttr.a, paramBoolean1);
    Object localObject = paramPaConfigAttr.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((PaConfigAttr.PaConfigInfo)((Iterator)localObject).next()).e == 5) {
        ((Iterator)localObject).remove();
      }
    }
    int j = paramPaConfigAttr.size();
    if ((paramBoolean1) && (paramInt1 > 0) && (j > 0) && (paramBoolean2))
    {
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new LinearLayout.LayoutParams(-1, (int)(9.0F * this.jdField_a_of_type_Float)));
      ((View)localObject).setBackgroundColor(Color.parseColor("#f0f0f0"));
      localViewGroup.addView((View)localObject);
    }
    int i = 0;
    paramBoolean2 = false;
    if (i < j)
    {
      int k = a(j, paramInt2, paramInt1, i, paramBoolean1);
      if ((a(localViewGroup, (PaConfigAttr.PaConfigInfo)paramPaConfigAttr.get(i), k, paramBoolean1)) || (paramBoolean2)) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        i += 1;
        break;
      }
    }
    if ((!paramBoolean1) && (paramInt1 == paramInt2 - 1))
    {
      paramPaConfigAttr = new View(this);
      paramPaConfigAttr.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
      paramPaConfigAttr.setBackgroundColor(Color.parseColor("#d6d6d6"));
      localViewGroup.addView(paramPaConfigAttr);
    }
    a(localViewGroup, paramBoolean1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localViewGroup);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addGroup exit");
    }
    return paramBoolean2;
  }
  
  protected int b()
  {
    return 2;
  }
  
  protected View b(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return null;
    }
    View localView = super.getLayoutInflater().inflate(2130903117, null);
    ((ImageView)localView.findViewById(2131296821)).setImageResource(2130838011);
    ((ImageView)localView.findViewById(2131297122)).setVisibility(0);
    String str = paramPaConfigInfo.b;
    boolean bool1;
    boolean bool2;
    if (str != null)
    {
      str = str.trim();
      bool1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility();
      bool2 = Pattern.compile("[\\d-]+?").matcher(str).matches();
      if (!bool2) {
        break label158;
      }
      ((TextView)localView.findViewById(2131297013)).setText(str);
    }
    for (;;)
    {
      localView.setOnClickListener(new hlb(this, bool2, str, bool1, paramPaConfigInfo));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_call", 0, 0, this.p, "", "", "");
      return localView;
      return null;
      label158:
      if (!bool1) {
        break;
      }
      ((TextView)localView.findViewById(2131297013)).setText(2131368096);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "buildPhoneItem no phone ability and no ivr ability");
    }
    return null;
  }
  
  public String b()
  {
    if (this.t == null) {
      this.t = ("http://share.mp.qq.com/cgi/share.php?uin=" + this.p + "&account_flag=" + this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.eqqAccountFlag + "&jumptype=1&card_type=crm");
    }
    return this.t;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.realSummary))) {
      return;
    }
    TextView localTextView = new TextView(getActivity().getBaseContext());
    localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.realSummary);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(getActivity().getBaseContext().getResources().getColor(2131427409));
    int i = (int)(this.jdField_a_of_type_Float * 16.5D);
    int j = (int)(this.jdField_a_of_type_Float * 16.5D);
    int k = (int)(this.jdField_a_of_type_Float * 22.5D);
    int m = (int)(this.jdField_a_of_type_Float * 22.5D);
    int n = (int)(5.0F * this.jdField_a_of_type_Float);
    localTextView.setPadding(i, k, j, m);
    localTextView.setLineSpacing(n, 1.0F);
    localTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView);
  }
  
  void b(EqqDetail paramEqqDetail)
  {
    ThreadManager.b().postDelayed(new hkv(this, paramEqqDetail), 10L);
  }
  
  protected boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.hasIvrAbility());
  }
  
  protected int c()
  {
    return Color.parseColor("#3d7fe3");
  }
  
  protected View c(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    Object localObject = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals("消息公告"))) {
      return null;
    }
    localObject = super.getLayoutInflater().inflate(2130903117, null);
    ((ImageView)((View)localObject).findViewById(2131296821)).setImageResource(2130838010);
    ((TextView)((View)localObject).findViewById(2131297013)).setText(paramPaConfigInfo.jdField_a_of_type_JavaLangString + " " + paramPaConfigInfo.b);
    return (View)localObject;
  }
  
  public void c()
  {
    d();
  }
  
  public void c(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    localEntityManager.b(paramEqqDetail);
    localEntityManager.a();
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null;
  }
  
  protected View d(PaConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    View localView = super.getLayoutInflater().inflate(2130905003, null);
    TextView localTextView = (TextView)localView.findViewById(2131297123);
    String str2 = paramPaConfigInfo.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.startsWith("查看")) {
        str1 = str2.replaceFirst("查看", "");
      }
    }
    localTextView.setText(str1);
    ((TextView)localView.findViewById(2131297923)).setText(paramPaConfigInfo.b);
    localView.setOnClickListener(new hkn(this));
    return localView;
  }
  
  void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "sendCrmDetailInfoRequest, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendDetailInfoRequest");
    }
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), ProtoServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "EqqAccountSvc.get_eqq_detail");
    mobileqq_mp.GetEqqDetailInfoRequest localGetEqqDetailInfoRequest = new mobileqq_mp.GetEqqDetailInfoRequest();
    localGetEqqDetailInfoRequest.version.set(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      localGetEqqDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetEqqDetailInfoRequest.eqq_id.set((int)Long.parseLong(this.p));
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGetEqqDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new hks(this);
        this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        this.E += 1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendCrmDetailInfoRequest exit");
        }
        return;
        localGetEqqDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected boolean d()
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      i = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType;
    }
    return i == 1;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      a(this.p, this.B, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name, ChatActivity.class);
    }
  }
  
  protected boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.followType == 1);
  }
  
  protected void f()
  {
    ThreadManager.b().postDelayed(new hkw(this), 10L);
  }
  
  protected boolean f()
  {
    return false;
  }
  
  protected void g()
  {
    ThreadManager.b().postDelayed(new hkx(this), 10L);
  }
  
  public void h()
  {
    ThreadManager.b().postDelayed(new hky(this), 10L);
  }
  
  protected void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateView");
    }
    if (b())
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
    }
    for (;;)
    {
      l();
      j();
      E();
      H();
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(false);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter);
      return;
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  void j()
  {
    if (d())
    {
      a();
      return;
    }
    k();
  }
  
  protected void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList != null)
      {
        List localList = PaConfigAttr.a(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.groupInfoList);
        int j = localList.size();
        int i = 0;
        boolean bool = false;
        while (i < j)
        {
          bool = a((PaConfigAttr)localList.get(i), i, j, false, bool);
          i += 1;
        }
      }
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
      return;
    }
    R();
    m();
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    int i = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade;
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#3d7fe3"));
    if (i != 0) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840081);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131364687));
    F();
    this.jdField_d_of_type_AndroidWidgetButton.setText(2131371919);
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setNameText len: " + i);
      }
      if ((i > 11) && (i < 15)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
    }
  }
  
  protected void n()
  {
    PAStartupTracker.a(null, "pubAcc_follow_confirm", this.p);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow uin=" + this.p);
    }
    this.i = true;
    this.jdField_b_of_type_AndroidViewView.postDelayed(new hko(this), 3000L);
    b(2131364486);
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).b(this.p);
    this.jdField_b_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("cmd", "follow");
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    if ((!TextUtils.isEmpty(this.r)) && (this.g)) {
      localFollowRequest.ext.set(this.r);
    }
    localFollowRequest.uin.set((int)Long.parseLong(this.p));
    localFollowRequest.account_type.set(b());
    this.jdField_b_of_type_MqqAppNewIntent.putExtra("data", localFollowRequest.toByteArray());
    this.jdField_b_of_type_MqqObserverBusinessObserver = new hkp(this);
    this.jdField_b_of_type_MqqAppNewIntent.setObserver(this.jdField_b_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_b_of_type_MqqAppNewIntent);
    this.E += 1;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "follow exit");
    }
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.accountData = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetEqqAccountDetailInfoResponse.toByteArray();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\activity\EqqAccountDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
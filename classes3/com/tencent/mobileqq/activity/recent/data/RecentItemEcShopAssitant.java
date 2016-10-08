package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecentItemEcShopAssitant
  extends RecentUserBaseData
{
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.G = 2;
  }
  
  public void a(Context paramContext)
  {
    if (this.H > 0)
    {
      if (this.H > 99) {}
      for (this.jdField_c_of_type_JavaLangCharSequence = paramContext.getString(2131364526);; this.jdField_c_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131364521), new Object[] { Integer.valueOf(this.H) }))
      {
        this.J = paramContext.getResources().getColor(2131428324);
        return;
      }
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.F = 0;
    EcShopData localEcShopData = ((EcShopAssistantManager)paramQQAppInterface.getManager(87)).a();
    if ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localEcShopData.mUin, 1008);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.F = 4;
      return;
    }
    this.F = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.K &= 0xFFFFFFFE;
    if (EcShopAssistantManager.jdField_a_of_type_Boolean) {
      this.K |= 0x1;
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131372081);
    }
    if (!TextUtils.isEmpty(EcShopAssistantManager.n)) {
      this.jdField_b_of_type_JavaLangString = EcShopAssistantManager.n;
    }
    Object localObject2 = null;
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
    Object localObject3 = paramQQAppInterface.a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      EcShopData localEcShopData = localEcShopAssistantManager.a();
      localObject1 = localObject2;
      if (localEcShopData != null) {
        localObject1 = ((QQMessageFacade)localObject3).a(localEcShopData.mUin, 1008);
      }
    }
    localObject3 = super.a();
    int i;
    if (localObject1 != null)
    {
      this.H = localEcShopAssistantManager.a(paramQQAppInterface);
      this.jdField_b_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = localEcShopAssistantManager.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.a.type, (MsgSummary)localObject3, (String)localObject2, true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == 62530) || (i == 60532))
        {
          ((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence = "";
          ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = "";
          localObject2 = XMLMessageUtils.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label740;
          }
          a((QQMessageFacade.Message)localObject1, this.a.type, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
      }
      label280:
      localObject2 = paramQQAppInterface.a();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      if ((i <= this.jdField_b_of_type_Long) && ((!TextUtils.isEmpty(((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence)) || (!TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)))) {
        break label927;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("str_ecshop_diy", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label865;
      }
      ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject2);
      ((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence = null;
      ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence = null;
      label407:
      this.jdField_c_of_type_JavaLangCharSequence = "";
      if (((SharedPreferences)localObject1).getBoolean("folder_reddot", false))
      {
        int j = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
        int k = ((SharedPreferences)localObject1).getInt("reddot_start", 0);
        int m = ((SharedPreferences)localObject1).getInt("reddot_end", 0);
        int n = ((SharedPreferences)localObject1).getInt("max_reddot_time", 0);
        int i1 = (int)(System.currentTimeMillis() / 1000L);
        if ((i1 != 0) && (k != 0) && (m != 0) && (n != 0))
        {
          if ((i1 < k) || (i1 > m) || (i1 - j >= n)) {
            break label897;
          }
          localEcShopAssistantManager.b = true;
          if (i > this.jdField_b_of_type_Long) {
            this.jdField_b_of_type_Long = i;
          }
        }
      }
      label547:
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      if ((this.H == 0) && (localEcShopAssistantManager.b)) {
        this.H = 1;
      }
      if (AppSetting.j)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
        if (this.H > 0)
        {
          i = localEcShopAssistantManager.a();
          if ((i != 0) && (!localEcShopAssistantManager.b)) {
            break label935;
          }
        }
        label643:
        if (this.jdField_c_of_type_JavaLangCharSequence != null) {
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence + ",");
        }
        if (this.H <= 0) {
          break label996;
        }
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      this.d = paramQQAppInterface.toString();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence);
      return;
      label740:
      localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
      if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null)) {
        localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
      }
      for (;;)
      {
        ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
        break;
      }
      this.H = 0;
      this.jdField_b_of_type_Long = 0L;
      break label280;
      label865:
      if (!TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)) {
        break label407;
      }
      ((MsgSummary)localObject3).jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131372082);
      ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence = null;
      break label407;
      label897:
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
      }
      localEcShopAssistantManager.b = false;
      this.H = 0;
      break label547;
      label927:
      a(paramContext);
      break label547;
      label935:
      if (i == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label643;
      }
      if (i == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label643;
      }
      if (i <= 0) {
        break label643;
      }
      paramQQAppInterface.append("有").append(i).append("条未读,");
      break label643;
      label996:
      paramQQAppInterface.append(this.jdField_b_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.d = null;
    }
    Object localObject2 = paramQQAppInterface.a();
    if (localObject2 == null) {}
    label179:
    for (;;)
    {
      return;
      Object localObject1 = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
      if (localObject1 != null) {}
      for (localObject1 = ((EcShopAssistantManager)localObject1).a();; localObject1 = null)
      {
        if ((localObject1 == null) || (TextUtils.isEmpty(((EcShopData)localObject1).mUin)) || (this.jdField_b_of_type_Long >= ((EcShopData)localObject1).mLastDraftTime)) {
          break label179;
        }
        localObject2 = ((QQMessageFacade)localObject2).a(((EcShopData)localObject1).mUin, 1008);
        if ((localObject2 == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject2).getSummary()))) {
          break;
        }
        this.jdField_b_of_type_Long = ((DraftSummaryInfo)localObject2).getTime();
        localObject2 = ((DraftSummaryInfo)localObject2).getSummary();
        paramQQAppInterface = ContactUtils.a(paramQQAppInterface, ((EcShopData)localObject1).mUin, true);
        if (paramMsgSummary == null) {
          break;
        }
        paramMsgSummary.jdField_a_of_type_Boolean = true;
        paramMsgSummary.d = new QQText(paramQQAppInterface + ": " + (String)localObject2, 3, 16);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemEcShopAssitant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
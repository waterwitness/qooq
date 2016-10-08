package com.tencent.biz.pubaccount.ecshopassit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import tencent.im.oidb.qqshop.qqshop.SQQSHPNewUserRecmd;

public class EcShopHandler
  extends BusinessHandler
{
  public static double a = 0.0D;
  public static final int a = 0;
  public static double b = 0.0D;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  
  public EcShopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    qqshop.SQQSHPClientRsp localSQQSHPClientRsp = new qqshop.SQQSHPClientRsp();
    try
    {
      localSQQSHPClientRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localSQQSHPClientRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte.retcode.get() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("EcShopHandler", 2, "response from server error: " + paramArrayOfByte.retcode.get());
      return;
      if (!paramArrayOfByte.bindlist.has()) {
        break label122;
      }
      paramArrayOfByte = paramArrayOfByte.bindlist.get();
      if (paramArrayOfByte.size() <= 0) {
        break label114;
      }
      a(2, true, paramArrayOfByte);
      return;
      label114:
      a(2, false, null);
      return;
      label122:
      a(2, false, null);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqshop.SQQSHPClientRsp();
    try
    {
      ((qqshop.SQQSHPClientRsp)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
        if (paramArrayOfByte.retcode.get() == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("EcShopHandler", 2, "response from server error: " + paramArrayOfByte.retcode.get());
      return;
      if (!paramArrayOfByte.newusrrecmd.has()) {
        break label175;
      }
      localObject = (qqshop.SQQSHPNewUserRecmd)paramArrayOfByte.newusrrecmd.get();
      if ((!((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.has()) || (((qqshop.SQQSHPNewUserRecmd)localObject).recmdflag.get() != 1)) {
        break label175;
      }
      localObject = ((qqshop.SQQSHPNewUserRecmd)localObject).recmdurl.get();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label175;
      }
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.i("EcShopHandler", 2, "newusrrecmd url:" + (String)localObject);
      label167:
      a(0, true, localObject);
      return;
      label175:
      if (!paramArrayOfByte.recmdlist.has()) {
        break label210;
      }
      paramArrayOfByte = paramArrayOfByte.recmdlist.get();
      if (paramArrayOfByte.size() <= 0) {
        break label210;
      }
      a(0, true, paramArrayOfByte);
      return;
      label210:
      a(0, false, null);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    qqshop.SQQSHPClientRsp localSQQSHPClientRsp = new qqshop.SQQSHPClientRsp();
    try
    {
      localSQQSHPClientRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localSQQSHPClientRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      } while (!QLog.isColorLevel());
      QLog.i("EcShopHandler", 2, "no bind uin found!");
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.bindlist.has()))
    {
      paramArrayOfByte = paramArrayOfByte.bindlist.get();
      if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty()))
      {
        paramArrayOfByte = (qqshop.SQQSHPAccoutRelation)paramArrayOfByte.get(0);
        if ((!paramArrayOfByte.customerservice.has()) || (paramArrayOfByte.customerservice.get() != 1)) {
          break label148;
        }
        if ((paramArrayOfByte.binduin.has()) && (paramArrayOfByte.puin.has()))
        {
          EcShopAssistantManager.a.put(String.valueOf(paramArrayOfByte.puin.get()), String.valueOf(paramArrayOfByte.binduin.get()));
          a(3, true, null);
        }
      }
      return;
    }
    label148:
    a(3, false, null);
  }
  
  protected Class a()
  {
    return EcShopObserver.class;
  }
  
  public void a()
  {
    a(4, true, null);
  }
  
  public void a(int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), EcShopServlet.class);
    localNewIntent.putExtra("cmd", "UserEventReport");
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    if (paramInt == 1) {
      localSQQSHPClientReq.eventid.set(1);
    }
    for (;;)
    {
      localNewIntent.putExtra("data", localSQQSHPClientReq.toByteArray());
      localNewIntent.putExtra("timeout", 30000);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      String str1;
      do
      {
        do
        {
          return;
          if (paramInt != 2) {
            break;
          }
          localSQQSHPClientReq.eventid.set(2);
          String str2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = "noLogin";
          }
          str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("ecshop_sp" + str1, 0).getString("recommed_shop_uin", null);
        } while (TextUtils.isEmpty(str1));
        localSQQSHPClientReq.rcpuin.set(Long.parseLong(str1));
        break;
        if (paramInt != 3) {
          break;
        }
        localSQQSHPClientReq.eventid.set(3);
        str1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      } while (TextUtils.isEmpty(str1));
      long l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("ecshop_sp" + str1, 0).getLong("ad_id", 0L);
      localSQQSHPClientReq.ad_id.set(l);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EcShopHandler", 2, "onReceive data null.");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramIntent = paramIntent.getStringExtra("cmd");
        if (!TextUtils.isEmpty(paramIntent))
        {
          if (paramIntent.equals("GetFolderInfo"))
          {
            b(paramArrayOfByte);
            return;
          }
          if (paramIntent.equals("GetShopBindUin"))
          {
            a(paramArrayOfByte);
            return;
          }
          if (!paramIntent.equals("UserEventReport"))
          {
            if (paramIntent.equals("GetShopCustomerservice"))
            {
              c(paramArrayOfByte);
              return;
            }
            if (paramIntent.equals("GetRecommendShop"))
            {
              paramIntent = new qqshop.SQQSHPClientRsp();
              try
              {
                paramIntent.mergeFrom(paramArrayOfByte);
                if ((paramIntent != null) && (paramIntent.rcpuin.has()))
                {
                  a(5, true, String.valueOf(paramIntent.rcpuin.get()));
                  return;
                }
              }
              catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
              {
                for (;;)
                {
                  paramIntent = null;
                  paramFromServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("EcShopHandler", 2, "EcShopHandler onReceive cmd cannot be recognized");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcShopAssistantActivity", 2, "getShopUinServantInfo empty uin.");
      }
      return;
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.add(Long.valueOf(paramString));
    paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), EcShopServlet.class);
    paramString.putExtra("cmd", "GetShopCustomerservice");
    paramString.putExtra("data", localSQQSHPClientReq.toByteArray());
    paramString.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
  }
  
  public void a(List paramList)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), EcShopServlet.class);
    localNewIntent.putExtra("cmd", "GetShopBindUin");
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.addAll(paramList);
    paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (!TextUtils.isEmpty(paramList))
    {
      paramList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(paramList, 0);
      double d1 = paramList.getFloat("search_lbs_logitude", 0.0F);
      double d2 = paramList.getFloat("search_lbs_latitude", 0.0F);
      if ((d1 != 0.0D) && (d2 != 0.0D))
      {
        a = d2;
        jdField_b_of_type_Double = d1;
        localSQQSHPClientReq.latitude.set(d2);
        localSQQSHPClientReq.longitude.set(d1);
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "lat:" + d2 + ",lon:" + d1);
        }
      }
    }
    localNewIntent.putExtra("data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b()
  {
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), EcShopServlet.class);
    localNewIntent.putExtra("cmd", "GetRecommendShop");
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences((String)localObject, 0);
      double d1 = ((SharedPreferences)localObject).getFloat("search_lbs_logitude", 0.0F);
      double d2 = ((SharedPreferences)localObject).getFloat("search_lbs_latitude", 0.0F);
      if ((d1 != 0.0D) && (d2 != 0.0D))
      {
        localSQQSHPClientReq.latitude.set(d2);
        localSQQSHPClientReq.longitude.set(d1);
      }
    }
    localNewIntent.putExtra("data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcShopAssistantActivity", 2, "GetFolderInfo msglistlen = " + paramInt);
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.msglistlen.set(paramInt);
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), EcShopServlet.class);
    localNewIntent.putExtra("cmd", "GetFolderInfo");
    localNewIntent.putExtra("data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcShopHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
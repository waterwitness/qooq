package com.tencent.biz.pubaccount.AccountDetail.model;

import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListRequest;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.AccountDetailDynamicListResponse;
import com.tencent.mobileqq.mp.account_detail_dynamic_list.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class AccountDetailDynamicListModel
{
  public static final int a = 10;
  private static final String a = AccountDetailDynamicListModel.class.getSimpleName();
  private static final int b = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    label236:
    label398:
    try
    {
      localObject = new account_detail_dynamic_list.AccountDetailDynamicListResponse();
      try
      {
        ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).mergeFrom(paramArrayOfByte);
        i = j;
        if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.has())
        {
          i = j;
          if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).ret_info.ret_code.get() == 0)
          {
            if ((!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.has()) || (!((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.has())) {
              break label398;
            }
            l1 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).puin.get();
            l2 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).last_msg_id.get();
            l3 = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_cnt.get();
            if (QLog.isColorLevel()) {
              QLog.d(a, 2, "updateAccountDetailDynamicInfo puin:" + l1 + " last_msg_id:" + l2 + " msg_cnt:" + l3 + " isFirstEnter:" + paramBoolean1 + " isFromDB:" + paramBoolean2);
            }
            localArrayList = AccountDetailDynamicDataManager.a(paramQQAppInterface).a(l1);
            if ((!paramBoolean1) || (!paramBoolean2) || (localArrayList == null)) {
              break label236;
            }
            boolean bool = localArrayList.isEmpty();
            if (bool) {
              break label236;
            }
            i = 6;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          long l1;
          long l2;
          long l3;
          ArrayList localArrayList;
          int i = 2;
        }
      }
      return i;
    }
    finally {}
    localArrayList = new ArrayList();
    if (((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.has())
    {
      localObject = ((account_detail_dynamic_list.AccountDetailDynamicListResponse)localObject).msg_infos.get();
      if (localObject == null)
      {
        i = 0;
        break label417;
      }
    }
    for (;;)
    {
      if (j < i)
      {
        String str = ((ByteStringMicro)((List)localObject).get(j)).toStringUtf8();
        localArrayList.add(str);
        if (!QLog.isColorLevel()) {
          break label423;
        }
        QLog.d(a, 2, "updateAccountDetailDynamicInfo jsonBody" + str);
        break label423;
        i = ((List)localObject).size();
      }
      else
      {
        if (l3 == localArrayList.size())
        {
          i = AccountDetailDynamicDataManager.a(paramQQAppInterface).a(paramArrayOfByte, paramBoolean1, l1, l2, l3, localArrayList, paramBoolean2);
          break;
        }
        i = 5;
        break;
        i = 4;
        break;
      }
      label417:
      j = 0;
      continue;
      label423:
      j += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    AccountDetailDynamicDataManager.a(paramQQAppInterface).a(paramQQAppInterface, paramLong);
    a(paramQQAppInterface, paramLong, 0L, 10);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "pull_account_detail_dynamic_list");
    account_detail_dynamic_list.AccountDetailDynamicListRequest localAccountDetailDynamicListRequest = new account_detail_dynamic_list.AccountDetailDynamicListRequest();
    localAccountDetailDynamicListRequest.versionInfo.set("6.5.5,3,2880");
    localAccountDetailDynamicListRequest.puin.set(paramLong1);
    localAccountDetailDynamicListRequest.last_msg_id.set(paramLong2);
    localAccountDetailDynamicListRequest.msg_cnt.set(paramInt);
    localNewIntent.putExtra("data", localAccountDetailDynamicListRequest.toByteArray());
    if (paramLong2 == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localNewIntent.putExtra("isFirstEnter", bool);
      PublicAccountServlet.a(localNewIntent);
      paramQQAppInterface.startServlet(localNewIntent);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "getAccountDetailDynamicList last_msg_id:" + paramLong2 + " msg_cnt:" + paramInt);
      }
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    AccountDetailDynamicInfo localAccountDetailDynamicInfo = AccountDetailDynamicDataManager.a(paramQQAppInterface).a(paramLong);
    if ((localAccountDetailDynamicInfo != null) && (localAccountDetailDynamicInfo.b > 0L))
    {
      a(paramQQAppInterface, paramLong, localAccountDetailDynamicInfo.b, 10);
      return;
    }
    a(paramQQAppInterface, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\AccountDetail\model\AccountDetailDynamicListModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
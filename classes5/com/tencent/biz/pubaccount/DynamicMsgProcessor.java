package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.qphone.base.util.QLog;
import hog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class DynamicMsgProcessor
  extends C2CMessageProcessor
{
  static final String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = DynamicMsgProcessor.class.getSimpleName();
  }
  
  public DynamicMsgProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  public ArrayList a(long paramLong, List paramList)
  {
    paramList = b(paramLong, paramList);
    ArrayList localArrayList = new ArrayList();
    a(paramList, localArrayList, true);
    paramList.clear();
    return localArrayList;
  }
  
  public void a(long paramLong, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 4, "processResponse puin=" + paramLong + ", list.size = " + paramList.size());
    }
    paramList = a(paramLong, paramList);
    if ((paramList != null) && (paramList.size() > 0)) {
      Collections.sort(paramList, new hog(this));
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramList, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "handlePBGetRoamMsg exception ! ", localException);
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(jdField_a_of_type_JavaLangString, 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
        }
      }
    }
  }
  
  public ArrayList b(long paramLong, List paramList)
  {
    Object localObject1 = new ArrayList();
    a(paramList, (List)localObject1);
    paramList = new ArrayList();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), paramLong, true, true, false, false);
    localDecodeProtoPkgContext.h = true;
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (msg_comm.Msg)((Iterator)localObject1).next();
      try
      {
        localObject2 = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext);
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          continue;
        }
        paramList.addAll((Collection)localObject2);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "decodeSinglePBMsg_C2C error,", localException);
      }
    }
    return paramList;
  }
  
  public void b(long paramLong, List paramList)
  {
    paramList = a(paramLong, paramList);
    PublicAccountManager localPublicAccountManager;
    long l2;
    long l1;
    String str;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localPublicAccountManager = PublicAccountManager.a();
      l2 = localPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong));
      l1 = l2;
      if (l2 == 0L) {
        l1 = Long.MAX_VALUE;
      }
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        str = ((MessageRecord)localIterator.next()).getExtInfoFromExtStr("pa_msgId");
        if (TextUtils.isEmpty(str)) {
          break label176;
        }
      }
    }
    label176:
    for (;;)
    {
      try
      {
        long l3 = Long.parseLong(str);
        l2 = l1;
        if (l3 < l1)
        {
          l2 = l1;
          if (l3 != 0L)
          {
            localPublicAccountManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), l3);
            l2 = l3;
          }
        }
        l1 = l2;
      }
      catch (Exception localException)
      {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\DynamicMsgProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.bitapp;

import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.bitapp.bundle.BundleFacade;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.bundle.IBundleListener;
import com.tencent.bitapp.preDownload.RNPreDownloadFacade;
import com.tencent.biz.pubaccount.util.PAReportUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hdj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitAppHandlerThread
{
  public static final int a = 100003;
  public static final String a = "BitAppHandlerThread";
  public static final String b = "[\"'](https?\\:.*?)[\"']";
  public Handler a;
  private LruCache a;
  public BitAppManager a;
  public QQAppInterface a;
  public final Pattern a;
  
  public BitAppHandlerThread(QQAppInterface paramQQAppInterface, BitAppManager paramBitAppManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new hdj(this, ThreadManager.b());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBitappBitAppManager = paramBitAppManager;
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[\"'](https?\\:.*?)[\"']", 32);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(10);
  }
  
  private IBundleListener a(Set paramSet, MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    return new BitAppHandlerThread.HandlerBundleListener(this, paramSet, paramMessageForBitAppTmp);
  }
  
  private void a(MessageForBitApp paramMessageForBitApp)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForBitApp, true)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForBitApp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("BitAppHandlerThread", 2, "QQAppInterface is null, so can't add message");
  }
  
  private void a(BundleStruct paramBundleStruct, IBundleListener paramIBundleListener)
  {
    if (BaseApplication.getContext() != null)
    {
      paramIBundleListener.onLoadSuccess(paramBundleStruct.getKey(), null);
      BundleFacade.setBundleStruct(paramBundleStruct, false);
      if (RNPreDownloadFacade.a()) {
        BundleFacade.loadBundle(paramBundleStruct, null);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BitAppHandlerThread", 2, "bitapp not ready");
      return;
    }
    QLog.d("BitAppHandlerThread", 2, "BitAppMsgItemElement context is null");
  }
  
  private void a(List paramList, String paramString)
  {
    paramList.clear();
    paramString = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (paramString.find()) {
      paramList.add(paramString.group(1));
    }
  }
  
  private boolean a(String paramString)
  {
    return (String)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString) != null;
  }
  
  public void a(MessageForBitAppTmp paramMessageForBitAppTmp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppHandlerThread", 4, "dealMessageForBitApp" + paramMessageForBitAppTmp);
    }
    Object localObject1 = paramMessageForBitAppTmp.bitAppMsg;
    if (localObject1 != null)
    {
      if (paramMessageForBitAppTmp.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentBitappBitAppManager.a(paramMessageForBitAppTmp);
      }
      localObject2 = ((BitAppMsg)localObject1).mBitAppMsgItemLists;
      localArrayList = new ArrayList(15);
      i = ((List)localObject2).size();
      if (i > 0)
      {
        localObject1 = new HashSet(i);
        localHashSet = new HashSet(i);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BitAppMsgItemElement)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((BitAppMsgItemElement)localObject3).a() > 0) && (((BitAppMsgItemElement)localObject3).b() > 0))
          {
            str = String.valueOf(((BitAppMsgItemElement)localObject3).a());
            if (!localHashSet.contains(str))
            {
              localBundleStruct = new BundleStruct(((BitAppMsgItemElement)localObject3).a());
              localBundleStruct.module_version = ((BitAppMsgItemElement)localObject3).b();
              localBundleStruct.module_state = ((BitAppMsgItemElement)localObject3).c();
              ((Set)localObject1).add(localBundleStruct);
              localHashSet.add(str);
            }
            localObject3 = ((BitAppMsgItemElement)localObject3).b();
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (RNPreDownloadFacade.a()))
            {
              a(localArrayList, (String)localObject3);
              BundleFacade.preloadNetImage(BaseApplication.getContext(), localArrayList);
            }
          }
        }
        paramMessageForBitAppTmp = a(localHashSet, paramMessageForBitAppTmp);
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a((BundleStruct)((Iterator)localObject1).next(), paramMessageForBitAppTmp);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BitAppHandlerThread", 2, "MSG_BIT_APP_DOWNLOAD Error bit app msg, because no item, need DOWNLOAD");
      }
      paramMessageForBitAppTmp.saveExtInfoToExtStr("longMsg_State", "1");
      StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForBitAppTmp);
    }
    while (!QLog.isColorLevel())
    {
      Object localObject2;
      ArrayList localArrayList;
      int i;
      HashSet localHashSet;
      Object localObject3;
      String str;
      BundleStruct localBundleStruct;
      return;
    }
    QLog.d("BitAppHandlerThread", 2, "MSG_BIT_APP_DOWNLOAD Error bit app msg, because bitAppMsg null");
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BitAppHandlerThread", 2, "filter ... ");
    }
    if ((paramList == null) || (paramList.size() < 1)) {}
    label233:
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList(paramList.size());
      int i = 0;
      if (i < paramList.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        int j = i;
        if (localMessageRecord != null)
        {
          j = i;
          if ((localMessageRecord instanceof MessageForBitApp))
          {
            String str1 = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
            if (a(str1)) {
              break label233;
            }
            this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(str1, str1);
            if (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("ad_msgHasRead")))
            {
              str1 = localMessageRecord.getExtInfoFromExtStr("gdt_msgImp");
              String str2 = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
              String str3 = localMessageRecord.getExtInfoFromExtStr("gdt_view_id");
              ArrayList localArrayList2 = new ArrayList();
              localArrayList2.add(str2);
              PAReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "", localMessageRecord.senderuin, str1, str3, localArrayList2);
            }
            localArrayList1.add(localMessageRecord);
          }
        }
        for (;;)
        {
          paramList.remove(i);
          j = i - 1;
          i = j + 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("BitAppHandlerThread", 2, "duplicated bitapp mssage, ingrone");
          }
        }
      }
      if (localArrayList1.size() > 0)
      {
        paramList = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramList.what = 100003;
        paramList.obj = localArrayList1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramList);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(143);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BitAppHandlerThread", 2, "list don't contain MessageForBitApp");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppHandlerThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.biz.pubaccount.ecshopassit;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import huq;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogInfo;
import tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliLogReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPFolderAdMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsg;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgReq;
import tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPRichMsgRsp;

public class EcshopReportHandler
  extends BusinessHandler
{
  static String a;
  public static final String b = "SQQShopCliLog.RtReport";
  public static final String c = "SQQShopMsgSvc.GetRichMsgInfo";
  static final String d = "EcshopReportHandler";
  static final String e = BaseApplication.getContext().getFilesDir() + File.separator + "qqshp_client_log_wl_conf.json";
  public MessageObserver a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EcshopReportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new huq(this);
  }
  
  protected Class a()
  {
    return EcShopObserver.class;
  }
  
  public void a()
  {
    Object localObject1 = new File(e);
    if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
    {
      localObject1 = FileUtils.a((File)localObject1);
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject2).optJSONArray("report_list");
        localObject2 = ((JSONObject)localObject2).optJSONArray("gtk_list");
        EcShopAssistantManager.c = new ArrayList();
        EcShopAssistantManager.d = new ArrayList();
        int i;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          while (i < ((JSONArray)localObject1).length())
          {
            EcShopAssistantManager.c.add(String.valueOf(((JSONArray)localObject1).getLong(i)));
            i += 1;
          }
        }
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            EcShopAssistantManager.d.add(String.valueOf(((JSONArray)localObject2).getLong(i)));
            i += 1;
          }
        }
        if (EcShopAssistantManager.c != null) {
          break label197;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EcshopReportHandler", 2, localException, new Object[0]);
        }
      }
    }
    EcShopAssistantManager.c = new ArrayList();
    label197:
    if (EcShopAssistantManager.d == null) {
      EcShopAssistantManager.d = new ArrayList();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "real time report:[" + paramInt + "," + paramString1 + "," + paramString2 + "," + paramString3 + "," + paramString4 + "," + paramLong + "," + paramBoolean + "]");
    }
    try
    {
      i = NetworkUtil.a(this.b.a().getApplicationContext());
      if (this.b == null)
      {
        String str1 = "";
        qqshop_report.SQQSHPCliLogReq localSQQSHPCliLogReq = new qqshop_report.SQQSHPCliLogReq();
        qqshop_report.SQQSHPCliLogInfo localSQQSHPCliLogInfo = new qqshop_report.SQQSHPCliLogInfo();
        Object localObject = localSQQSHPCliLogInfo.puin;
        if (paramString1 != null) {
          break label408;
        }
        l = 0L;
        ((PBUInt64Field)localObject).set(l);
        localSQQSHPCliLogInfo.network.set(i);
        localSQQSHPCliLogInfo.cnt.set(1);
        localObject = localSQQSHPCliLogInfo.strp1;
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        ((PBStringField)localObject).set(paramString1);
        paramString2 = localSQQSHPCliLogInfo.strp2;
        paramString1 = paramString3;
        if (paramString3 == null) {
          paramString1 = "";
        }
        paramString2.set(paramString1);
        paramString2 = localSQQSHPCliLogInfo.strp3;
        paramString1 = paramString4;
        if (paramString4 == null) {
          paramString1 = "";
        }
        paramString2.set(paramString1);
        localSQQSHPCliLogInfo.tvalue.set(paramInt);
        localSQQSHPCliLogInfo.uintp1.set(paramLong);
        if (paramBoolean)
        {
          if ((jdField_a_of_type_JavaLangString == null) && (this.b != null) && (this.b.a() != null))
          {
            paramString1 = (WifiManager)this.b.a().getSystemService("wifi");
            if ((paramString1 != null) && (paramString1.getConnectionInfo() != null)) {
              jdField_a_of_type_JavaLangString = paramString1.getConnectionInfo().getMacAddress();
            }
          }
          if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
            break label417;
          }
          localSQQSHPCliLogInfo.wifimac.set(jdField_a_of_type_JavaLangString);
        }
        localSQQSHPCliLogReq.logs.add(localSQQSHPCliLogInfo);
        paramString1 = new ToServiceMsg("mobileqq.service", str1, "SQQShopCliLog.RtReport");
        paramString1.putWupBuffer(localSQQSHPCliLogReq.toByteArray());
        super.b(paramString1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        String str2 = this.b.a();
        continue;
        label408:
        long l = Long.parseLong(paramString1);
        continue;
        label417:
        if (jdField_a_of_type_JavaLangString != null) {}
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.b == null)) {}
    qqshop_richmsg.SQQSHPRichMsgReq localSQQSHPRichMsgReq;
    ArrayList localArrayList;
    do
    {
      return;
      EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.b.getManager(87);
      localSQQSHPRichMsgReq = new qqshop_richmsg.SQQSHPRichMsgReq();
      localArrayList = new ArrayList();
      String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
      Object localObject = new qqshop_richmsg.SQQSHPRichMsg();
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).msg_id.set(Long.parseLong(str));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).puin.set(Long.parseLong(paramMessageRecord.senderuin));
      ((qqshop_richmsg.SQQSHPRichMsg)localObject).sendtime.set(paramMessageRecord.time);
      localArrayList.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.i("EcshopReportHandler", 2, "get rich msg:" + str + "," + paramMessageRecord.senderuin + "," + paramMessageRecord.time);
      }
      localObject = localEcShopAssistantManager.a(paramMessageRecord.senderuin);
      ((EcShopData)localObject).mLastMsgTime = paramMessageRecord.time;
      paramMessageRecord = this.b.a().a(((EcShopData)localObject).mUin, 1008);
      if (paramMessageRecord != null)
      {
        long l = paramMessageRecord.time;
        if (l > ((EcShopData)localObject).mLastMsgTime) {
          ((EcShopData)localObject).mLastMsgTime = l;
        }
      }
      ((EcShopData)localObject).msgId = str;
      ((EcShopData)localObject).mImgInfo = "";
      localEcShopAssistantManager.a((EcShopData)localObject);
    } while (localArrayList.isEmpty());
    localSQQSHPRichMsgReq.rich_msgs.addAll(localArrayList);
    paramMessageRecord = new ToServiceMsg("mobileqq.service", this.b.a(), "SQQShopMsgSvc.GetRichMsgInfo");
    paramMessageRecord.putWupBuffer(localSQQSHPRichMsgReq.toByteArray());
    super.b(paramMessageRecord);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "on receive:" + paramToServiceMsg.getServiceCmd());
    }
    if ((!"SQQShopMsgSvc.GetRichMsgInfo".equals(paramToServiceMsg.getServiceCmd())) || (this.b == null) || (paramObject == null)) {}
    label449:
    do
    {
      do
      {
        do
        {
          return;
          paramFromServiceMsg = new qqshop_richmsg.SQQSHPRichMsgRsp();
          paramToServiceMsg = (EcShopAssistantManager)this.b.getManager(87);
          localObject1 = paramToServiceMsg.a();
          try
          {
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            paramObject = paramFromServiceMsg.rich_msgs.get();
            j = ((List)paramObject).size();
            int i = 0;
            for (;;)
            {
              if (i >= j) {
                break label449;
              }
              localObject2 = (qqshop_richmsg.SQQSHPRichMsg)((List)paramObject).get(i);
              if ((((qqshop_richmsg.SQQSHPRichMsg)localObject2).img_url.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject2).msg_id.has()) && (((qqshop_richmsg.SQQSHPRichMsg)localObject2).puin.has())) {
                break;
              }
              i += 1;
            }
          }
          catch (Exception paramObject)
          {
            int j;
            for (;;)
            {
              Object localObject2;
              if (QLog.isColorLevel())
              {
                QLog.e("EcshopReportHandler", 2, "merge exception:" + paramObject);
                continue;
                String str1 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject2).msg_id.get());
                String str2 = String.valueOf(((qqshop_richmsg.SQQSHPRichMsg)localObject2).puin.get());
                Object localObject3 = ((qqshop_richmsg.SQQSHPRichMsg)localObject2).img_url.get();
                localObject2 = new StringBuilder();
                Object localObject4 = ((List)localObject3).iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  ((StringBuilder)localObject2).append((String)((Iterator)localObject4).next());
                  ((StringBuilder)localObject2).append(",");
                }
                if (QLog.isColorLevel()) {
                  QLog.i("EcshopReportHandler", 2, "recv rich msg:" + str1 + "," + str2 + "," + localObject3.toString());
                }
                localObject3 = ((List)localObject1).iterator();
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject4 = (EcShopData)((Iterator)localObject3).next();
                } while ((!str1.equals(((EcShopData)localObject4).msgId)) || (!str2.equals(((EcShopData)localObject4).mUin)));
                ((EcShopData)localObject4).mImgInfo = ((StringBuilder)localObject2).substring(0, ((StringBuilder)localObject2).length() - 1).toString();
                paramToServiceMsg.a((EcShopData)localObject4);
              }
            }
            if (j > 0) {
              super.a(6, true, null);
            }
          }
        } while (!paramFromServiceMsg.ad_msgs.has());
        paramFromServiceMsg = (qqshop_richmsg.SQQSHPFolderAdMsg)paramFromServiceMsg.ad_msgs.get(0);
        localObject1 = this.b.a();
      } while (paramFromServiceMsg == null);
      paramObject = paramFromServiceMsg.pic_url.get();
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (paramObject == null) || (((List)paramObject).isEmpty()));
    Object localObject1 = this.b.a().getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
    long l = ((SharedPreferences)localObject1).getLong("ad_puin", 0L);
    EcShopAssistantManager.S = String.valueOf(l);
    localObject1 = ((SharedPreferences)localObject1).edit();
    if (l != 0L) {
      paramToServiceMsg.a(String.valueOf(l));
    }
    ((SharedPreferences.Editor)localObject1).putBoolean("is_ad_added", false);
    ((SharedPreferences.Editor)localObject1).putInt("ad_start", paramFromServiceMsg.begin_time.get());
    ((SharedPreferences.Editor)localObject1).putInt("ad_end", paramFromServiceMsg.end_time.get());
    ((SharedPreferences.Editor)localObject1).putLong("ad_id", paramFromServiceMsg.ad_id.get());
    ((SharedPreferences.Editor)localObject1).putLong("ad_puin", paramFromServiceMsg.puin.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_icon_url", paramFromServiceMsg.ad_url.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_title", paramFromServiceMsg.title.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_nick", paramFromServiceMsg.name.get());
    ((SharedPreferences.Editor)localObject1).putString("ad_url", paramFromServiceMsg.ad_content_url.get());
    if (paramFromServiceMsg.verify_flag.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((SharedPreferences.Editor)localObject1).putBoolean("ad_cert", bool);
      paramToServiceMsg = new StringBuilder();
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext())
      {
        paramToServiceMsg.append((String)((Iterator)paramObject).next());
        paramToServiceMsg.append(",");
      }
    }
    paramToServiceMsg = paramToServiceMsg.substring(0, paramToServiceMsg.length() - 1).toString();
    if (QLog.isColorLevel()) {
      QLog.i("EcshopReportHandler", 2, "v_flag" + paramFromServiceMsg.verify_flag.get() + ",puin:" + paramFromServiceMsg.puin.get() + ",ad pics:" + paramToServiceMsg);
    }
    ((SharedPreferences.Editor)localObject1).putString("ad_pics", paramToServiceMsg);
    ((SharedPreferences.Editor)localObject1).commit();
    a(134246435, null, null, null, null, paramFromServiceMsg.ad_id.get(), false);
  }
  
  public void a(boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
    if (paramBoolean)
    {
      a(134243864, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
      return;
    }
    if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
    {
      paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg");
      a(134243861, paramMessageRecord.senderuin, str, paramString, null, paramInt, true);
      return;
    }
    a(134243858, paramMessageRecord.senderuin, str, paramString, null, paramInt, false);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str1 = paramMessageRecord.getExtInfoFromExtStr("public_account_msg_id");
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      a(134243862, paramMessageRecord.senderuin, str1, null, null, 0L, false);
      return;
    }
    if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("is_AdArrive_Msg")))
    {
      String str2 = paramMessageRecord.getExtInfoFromExtStr("key");
      a(134243859, paramMessageRecord.senderuin, str1, str2, null, 0L, true);
      return;
    }
    a(134243856, paramMessageRecord.senderuin, str1, null, null, 0L, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\ecshopassit\EcshopReportHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class qgg
  implements Runnable
{
  public qgg(RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l3 = System.currentTimeMillis();
    long l1;
    do
    {
      do
      {
        do
        {
          try
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
            localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            bool = ((FriendsManager)localObject1).b(this.jdField_a_of_type_JavaLangString);
            if (!bool) {
              return;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Object localObject1;
              boolean bool;
              return;
              return;
              localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
              if (localObject5 == null) {
                return;
              }
              localObject4 = new JSONObject();
              try
              {
                ((JSONObject)localObject4).put("ver", "1.0");
                ((JSONObject)localObject4).put("time", String.valueOf(((RichStatus)localObject3).time));
                if ((((RichStatus)localObject3).actionText != null) && (((RichStatus)localObject3).actionText.trim().length() > 0))
                {
                  ((JSONObject)localObject4).put("aid", String.valueOf(((RichStatus)localObject3).actionId));
                  ((JSONObject)localObject4).put("actiontext", ((RichStatus)localObject3).actionText);
                }
                if ((((RichStatus)localObject3).dataText != null) && (((RichStatus)localObject3).dataText.trim().length() > 0))
                {
                  ((JSONObject)localObject4).put("did", String.valueOf(((RichStatus)localObject3).dataId));
                  ((JSONObject)localObject4).put("datatext", ((RichStatus)localObject3).dataText);
                }
                ((JSONObject)localObject4).put("loctextpos", String.valueOf(((RichStatus)localObject3).locationPosition));
                if ((((RichStatus)localObject3).plainText != null) && (((RichStatus)localObject3).plainText.size() > 0))
                {
                  j = ((RichStatus)localObject3).plainText.size();
                  localObject6 = new JSONArray();
                  i = 0;
                  if (i < j)
                  {
                    str = (String)((RichStatus)localObject3).plainText.get(i);
                    if (str == null) {
                      break label1599;
                    }
                    ((JSONArray)localObject6).put(str);
                    break label1599;
                  }
                  if (((JSONArray)localObject6).length() > 0) {
                    ((JSONObject)localObject4).put("plaintext", localObject6);
                  }
                }
                if ((((RichStatus)localObject3).locationText != null) && (((RichStatus)localObject3).locationText.trim().length() > 0)) {
                  ((JSONObject)localObject4).put("loctext", ((RichStatus)localObject3).locationText);
                }
                if (!TextUtils.isEmpty(((RichStatus)localObject3).feedsId)) {
                  ((JSONObject)localObject4).put("feedid", ((RichStatus)localObject3).feedsId);
                }
                ((JSONObject)localObject4).put("tplid", ((RichStatus)localObject3).tplId);
                k = 0;
                m = 0;
                j = m;
                i = k;
                if (((RichStatus)localObject3).sigZanInfo != null)
                {
                  j = m;
                  i = k;
                  if (((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255)) != null)
                  {
                    i = ((RichStatus.SigZanInfo)((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255))).b;
                    j = ((RichStatus.SigZanInfo)((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255))).c;
                  }
                }
                ((JSONObject)localObject4).put("count", i);
                ((JSONObject)localObject4).put("zanfalg", j);
                if (((JSONObject)localObject4).length() > 3) {
                  break label1152;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("SignatureManager", 2, "sign is empty,rs.actionText is:" + ((RichStatus)localObject3).actionText + ",rs.dataText is:" + ((RichStatus)localObject3).dataText + ",rs.plainText is:" + ((RichStatus)localObject3).plainText + ",rs.locationText is:" + ((RichStatus)localObject3).locationText);
                }
                return;
              }
              catch (JSONException localJSONException)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded failed,error msg is:" + localJSONException.getMessage(), localJSONException);
                }
              }
            }
            return;
            localObject4 = ((JSONObject)localObject4).toString();
            long l2 = ((RichStatus)localObject3).time;
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, ((RecentUser)localObject5).type);
            l1 = l2;
            if (localObject5 == null) {
              break label1231;
            }
            l1 = l2;
            if (((List)localObject5).size() <= 0) {
              break label1231;
            }
            l1 = ((MessageRecord)((List)localObject5).get(((List)localObject5).size() - 1)).time;
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { 64502 });
            if (localObject5 == null) {
              break label1365;
            }
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (MessageRecord)((Iterator)localObject5).next();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject6).frienduin, ((MessageRecord)localObject6).istroop, ((MessageRecord)localObject6).uniseq);
            }
          }
          finally
          {
            if (!QLog.isColorLevel()) {
              break label1363;
            }
            QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
          }
          if (localObject3 != null) {
            break label1594;
          }
          localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_JavaLangString);
          if (localObject1 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
        return;
        bool = ((ExtensionInfo)localObject1).isAdded2C2C;
        if (!bool) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      return;
      l1 = NetConnInfoCenter.getServerTime();
      l2 = ((ExtensionInfo)localObject1).richTime;
      l1 -= l2;
      if ((l1 <= 0L) || (l1 < 604800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
    return;
    Object localObject3 = ((ExtensionInfo)localObject1).getRichStatus();
    label273:
    if ((((RichStatus)localObject3).isEmpty()) || (TextUtils.isEmpty(((RichStatus)localObject3).feedsId)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { 64502 });
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 0, ((MessageRecord)localObject3).msgtype, ((MessageRecord)localObject3).uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      int j;
      Object localObject6;
      int i;
      String str;
      int k;
      int m;
      label1152:
      label1231:
      label1363:
      label1365:
      Object localObject5 = MessageRecordFactory.a(64502);
      ((MessageRecord)localObject5).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject4, l1, 64502, 0, l1);
      ((MessageRecord)localObject5).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d("SignatureManager", 2, "----------addFriendFeedMsg  friendUin: " + this.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject5).time);
      }
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject5, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject5, ((MessageRecord)localObject5).selfuin);
        if (localExtensionInfo != null)
        {
          localExtensionInfo.isAdded2C2C = true;
          ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(localExtensionInfo);
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(((RichStatus)localObject3).tplId), "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      return;
      label1594:
      Object localObject2 = null;
      break label273;
      label1599:
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
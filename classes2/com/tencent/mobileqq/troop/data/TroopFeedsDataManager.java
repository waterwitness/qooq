package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vmi;
import vmj;
import vmk;

public class TroopFeedsDataManager
  extends Observable
{
  public static final int A = 0;
  public static final int B = 1;
  public static final int C = 2;
  public static final String a = "TroopFeedsDataManager";
  public static final int b = 1;
  public static final String b = "http://web.qun.qq.com/cgi-bin/notice/get_data_new";
  public static final int c = 1000;
  public static final String c = "http://web.qun.qq.com/cgi-bin/announce/get_qun_instruction";
  public static final int d = 1002;
  public static final String d = "http://web.qun.qq.com/cgi-bin/announce/get_t_list";
  public static final int e = 1003;
  public static final String e = "http://web.qun.qq.com/cgi-bin/announce/get_ad?&cnt=1&ext=%S";
  public static final int f = 1004;
  public static final String f = "8020205751015455";
  public static final int g = 1005;
  public static String g;
  public static final int h = 1006;
  public static String h;
  public static final int i = 101;
  public static String i;
  public static final int j = 103;
  public static String j;
  public static final int k = 104;
  public static String k;
  public static final int l = 105;
  public static String l = "filterID";
  public static final int m = 106;
  public static String m = "src";
  public static final int n = 1007;
  public static final int o = 1008;
  public static final int p = 1009;
  public static final int q = 1010;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 5;
  public static final int v = 6;
  public static int w = 0;
  public static int x = 0;
  public static int y = 0;
  public static final int z = 1;
  public int a;
  public Handler a;
  public QQAppInterface a;
  protected TroopFeedItem a;
  public HttpWebCgiAsyncTask.Callback a;
  public Long a;
  public LinkedHashMap a;
  public List a;
  public JSONObject a;
  protected boolean a;
  public JSONObject b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    g = "controlType";
    h = "controlInfo";
    w = 1;
    i = "compress";
    x = 1;
    j = "validTime";
    k = "needFilter";
    y = 1;
  }
  
  public TroopFeedsDataManager(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsHandler = new vmi(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new vmk(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Object localObject1 = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = paramQQAppInterface.a();
    Object localObject2 = ((TicketManager)localObject1).getSkey(paramQQAppInterface);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("Cookie", "uin=o" + paramQQAppInterface + ";skey=" + (String)localObject2);
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("posid", "8020205751015455");
      ((JSONObject)localObject2).put("adposcount", 1);
      ((JSONObject)localObject2).put("count", 1);
      ((JSONObject)localObject2).put("posw", 100);
      ((JSONObject)localObject2).put("posh", 200);
      ((JSONObject)localObject2).put("uin", paramQQAppInterface);
      ((JSONObject)localObject2).put("muidtype", 1);
      ((JSONObject)localObject2).put("muid", MD5.toMD5(DeviceInfoUtil.a()));
      ((JSONObject)localObject2).put("carrier", DeviceInfoUtil.e());
      ((JSONObject)localObject2).put("conn", HttpUtil.a());
      ((JSONObject)localObject2).put("c_os", "android");
      ((JSONObject)localObject2).put("c_osver", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("datatype", 2);
      ((JSONObject)localObject2).put("c_devicetype", 1);
      paramQQAppInterface = String.format("http://web.qun.qq.com/cgi-bin/announce/get_ad?&cnt=1&ext=%S", new Object[] { URLEncoder.encode(((JSONObject)localObject2).toString()) });
      if (paramQQAppInterface != null)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("BUNDLE", localObject1);
        ((HashMap)localObject2).put("CONTEXT", paramContext);
        new HttpWebCgiAsyncTask(paramQQAppInterface, "GET", paramCallback, paramInt, null, true).execute(new HashMap[] { localObject2 });
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "get requstTroopNotify from server start: " + System.currentTimeMillis());
        }
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("requstTroopNotifyAd", 2, "get ad exera fail, " + paramQQAppInterface);
        }
        paramQQAppInterface = null;
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("requstTroopNotifyAd", 2, "get adURL ERROR empty!!!!");
        }
      }
    }
  }
  
  public TroopFeedItem a()
  {
    List localList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a("" + this.jdField_a_of_type_JavaLangLong);
    if (localList == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    }
    int i2 = localList.size() - 1;
    label260:
    label398:
    label459:
    label465:
    label471:
    label478:
    for (;;)
    {
      TroopNotificationCache localTroopNotificationCache;
      if (i2 >= 0)
      {
        localTroopNotificationCache = (TroopNotificationCache)localList.get(i2);
        if (localTroopNotificationCache == null) {}
      }
      else
      {
        try
        {
          TroopFeedItem localTroopFeedItem = new TroopFeedItem();
          int i1;
          Object localObject;
          TroopFeedsDataManager.ProclamationXmlHandler localProclamationXmlHandler;
          if (localTroopNotificationCache.serviceID == 27)
          {
            localTroopFeedItem.tag = "公告";
            localTroopFeedItem.type = 5;
            i1 = 0;
            localTroopFeedItem.id = localTroopNotificationCache.feedsId;
            localTroopFeedItem.orginType = localTroopNotificationCache.feedType;
            localTroopFeedItem.feedTime = ("" + localTroopNotificationCache.time);
            localTroopFeedItem.currentUin = localTroopNotificationCache.currentUin;
            localTroopFeedItem.troopUin = ("" + localTroopNotificationCache.troopUin);
            localObject = new ByteArrayInputStream(StructMsgUtils.a(localTroopNotificationCache.xmlBytes, i1));
            localProclamationXmlHandler = new TroopFeedsDataManager.ProclamationXmlHandler(this);
            SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject, localProclamationXmlHandler);
            ((InputStream)localObject).close();
            if (localTroopNotificationCache.serviceID == 20)
            {
              localTroopFeedItem.title = localProclamationXmlHandler.a;
              localTroopFeedItem.content = "";
              localTroopFeedItem.picPath = localProclamationXmlHandler.b;
              localTroopFeedItem.linkUrl = localProclamationXmlHandler.d;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem == null) || (localTroopNotificationCache.serviceID == 27)) {
                this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
              }
              i1 = localTroopNotificationCache.serviceID;
              if (i1 != 27) {
                break label478;
              }
              return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
            }
          }
          else
          {
            if ((localTroopNotificationCache.serviceID != 20) || (localTroopNotificationCache.ctrlStr == null)) {
              break label459;
            }
            localObject = new JSONObject(localTroopNotificationCache.ctrlStr);
            if ((!((JSONObject)localObject).has(g)) || (((JSONObject)localObject).getInt(g) != w)) {
              break label471;
            }
            localObject = ((JSONObject)localObject).getJSONObject(h);
            if (((JSONObject)localObject).getInt(i) != x) {
              break label465;
            }
            i1 = 1;
            long l1 = Long.parseLong(((JSONObject)localObject).getString(j));
            if (MessageCache.a() > l1) {
              return null;
            }
          }
          for (;;)
          {
            localTroopFeedItem.tag = "部落精华";
            localTroopFeedItem.type = 133;
            break;
            localTroopFeedItem.title = localTroopNotificationCache.title;
            localTroopFeedItem.content = localProclamationXmlHandler.c;
            break label260;
            i1 = 0;
            break;
            i1 = 0;
            break label398;
            i1 = 0;
          }
          i2 -= 1;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public String a(List paramList)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopFeedItem localTroopFeedItem = (TroopFeedItem)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fid", localTroopFeedItem.id);
        localJSONObject.put("mod_time", Long.parseLong(localTroopFeedItem.feedTime));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (JSONException paramList)
    {
      return "";
    }
    catch (NumberFormatException paramList)
    {
      return "";
    }
    catch (Exception paramList)
    {
      return "";
    }
  }
  
  public LinkedHashMap a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedHashMap;
  }
  
  public List a(List paramList1, List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 1;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null)
    {
      localObject1 = paramList2.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopFeedItem)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((TroopFeedItem)localObject2).id.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id))) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = ((TroopFeedItem)localObject2);
        }
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem);
      i1 = 0;
    }
    paramList1 = paramList1.iterator();
    do
    {
      if (paramList1.hasNext())
      {
        localObject1 = (String)paramList1.next();
        if (i1 > 0) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
        return localArrayList;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id)));
    Object localObject2 = paramList2.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)((Iterator)localObject2).next();
      if (((String)localObject1).equalsIgnoreCase(localTroopFeedItem.id))
      {
        localArrayList.add(localTroopFeedItem);
        i1 -= 1;
      }
    }
    for (;;)
    {
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1002) {}
    for (;;)
    {
      ThreadManager.a(new vmj(this, localArrayList, paramInt), 5, null, false);
      return;
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "setTroopNotificationCenterAutoPullDownFlag, troopUin:" + this.jdField_a_of_type_JavaLangLong + ",feedsId:" + paramString + ",status:" + paramInteger);
      }
    } while (paramInteger.intValue() != 1);
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, paramInteger);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void b(int paramInt)
  {
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("qid", "" + this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("ft", "23");
    ((Bundle)localObject2).putString("bkn", "" + TroopUtils.b(str));
    ((Bundle)localObject2).putString("ni", "1");
    if (paramInt == 1003) {
      ((Bundle)localObject2).putString("n", "1");
    }
    for (;;)
    {
      ((Bundle)localObject2).putString("i", "1");
      ((Bundle)localObject2).putString("s", "-1");
      ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
      ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
      new HttpWebCgiAsyncTask("http://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeedsDataManager", 2, "get recentNote from server start: " + System.currentTimeMillis());
      }
      return;
      ((Bundle)localObject2).putString("n", "2");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFeedsDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
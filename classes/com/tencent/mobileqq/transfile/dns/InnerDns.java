package com.tencent.mobileqq.transfile.dns;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.mobroute.DomainIp.DomainServerList;
import tencent.im.mobileqq.mobroute.DomainIp.DomainiplistInfo;
import tencent.im.mobileqq.mobroute.DomainIp.NameRspBody;
import tencent.im.mobileqq.mobroute.DomainIp.SubCmd_name_Rsp;
import vcp;
import vcq;

public class InnerDns
  extends QIPCModule
{
  public static final int a = 5;
  public static volatile InnerDns a;
  public static final String a;
  public static final int b = 1000;
  public static final String b = "domain_map";
  public static final int c = 1001;
  public static final String c = "net_identifier";
  public static final int d = 1002;
  public static final String d = "sp_domain";
  public static final int e = 1003;
  public static final String e = "sp_inner_dns";
  public static final int f = 1004;
  public static final String f = "InnerDnsModule";
  public static final int g = 1005;
  private static final String g = "reqDomain2IpList";
  public static final int h = 1010;
  private static final String h = "reportBadIp";
  private static final int jdField_i_of_type_Int = 0;
  private static final String jdField_i_of_type_JavaLangString = "domain";
  private static final int jdField_j_of_type_Int = 10;
  private static final String jdField_j_of_type_JavaLangString = "ip";
  private static final int jdField_k_of_type_Int = 20;
  private static final String jdField_k_of_type_JavaLangString = "businessType";
  private static final int jdField_l_of_type_Int = 30;
  private static final int m = 40;
  private static final int n = 50;
  private static final int o = 60;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  private String jdField_l_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = InnerDns.class.getSimpleName();
  }
  
  private InnerDns()
  {
    super("InnerDnsModule");
    if (BaseApplicationImpl.i == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label93;
      }
      HashMap localHashMap = a(BaseApplicationImpl.a().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localHashMap == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap(localHashMap);
      return;
      bool = false;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    return;
    label93:
    QIPCClientHelper.getInstance().getClient().connect(new vcp(this));
    QIPCClientHelper.getInstance().getClient().addListener(new vcq(this));
  }
  
  public static InnerDns a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns = new InnerDns();
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileDnsInnerDns;
    }
    finally {}
  }
  
  private String a()
  {
    Context localContext = BaseApplicationImpl.a().getApplicationContext();
    String str2 = String.valueOf(NetworkUtil.a(localContext));
    String str1 = str2;
    if (!StringUtil.b(str2))
    {
      str1 = str2;
      if (str2.equals(Integer.valueOf(1))) {
        str1 = PttIpSaver.a(localContext);
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    if (StringUtil.b(paramString)) {
      return paramString;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!StringUtil.b(paramString2))
    {
      str = paramString1;
      if (!StringUtil.b(paramString1)) {
        str = RichMediaUtil.a(paramString1, "http://" + paramString2 + "/");
      }
    }
    return str;
  }
  
  public static String a(HashMap paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (HashMap)((Map.Entry)localObject).getValue();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("net_identifier", str);
        localJSONObject.put("domain_map", DomainData.a((HashMap)localObject));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parse failed");
      }
      return null;
    }
    return paramHashMap;
  }
  
  private ArrayList a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        int i1 = paramArrayList.size();
        if (i1 == 0)
        {
          localObject = null;
          return (ArrayList)localObject;
        }
        localObject = paramArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((IpData)((Iterator)localObject).next()).b <= 0) {
            continue;
          }
          ((Iterator)localObject).remove();
          continue;
        }
        localObject = paramArrayList;
      }
      finally {}
      if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 10 == 0)
      {
        Collections.shuffle(paramArrayList);
        localObject = paramArrayList;
      }
    }
  }
  
  public static HashMap a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        HashMap localHashMap = new HashMap();
        paramString = new JSONArray(paramString);
        int i1 = 0;
        while (i1 < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i1);
          String str = ((JSONObject)localObject).getString("net_identifier");
          localObject = DomainData.a(((JSONObject)localObject).getString("domain_map"));
          if (localObject != null) {
            localHashMap.put(str, localObject);
          }
          i1 += 1;
        }
        return localHashMap;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "unParse failed");
    return null;
  }
  
  public String a(String paramString, int paramInt)
  {
    Object localObject = null;
    ArrayList localArrayList = a(paramString, paramInt);
    paramString = (String)localObject;
    if (localArrayList != null)
    {
      paramString = (String)localObject;
      if (localArrayList.size() > 0) {
        paramString = (String)localArrayList.get(0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reqDns after dns:" + paramString);
    }
    return paramString;
  }
  
  public ArrayList a(String paramString, int paramInt)
  {
    boolean bool = true;
    int i2 = 0;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reqDns, process:" + BaseApplicationImpl.i + " domain:" + paramString + " busiType:" + paramInt + " ServerProcName:" + this.l);
    }
    if (StringUtil.b(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      localObject = a();
    }
    label414:
    label424:
    label538:
    label541:
    label553:
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          break label424;
        }
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (!((HashMap)localObject).containsKey(paramString)) {
          break label414;
        }
        localObject = a(((DomainData)((HashMap)localObject).get(paramString)).a);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          if (((IpData)((ArrayList)localObject).get(0)).b <= 0) {
            break label538;
          }
          i1 = 1;
          break label541;
          localObject = new HashMap();
          ((HashMap)localObject).put("param_FailCode", String.valueOf(i1));
          ((HashMap)localObject).put("domain", paramString);
          ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actDnsReq", bool, BaseApplicationImpl.i, 0L, (HashMap)localObject, "");
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "reqDnsForIpList succeeded:" + bool + " retList=" + localArrayList);
          }
          return localArrayList;
        }
        i1 = 1;
      }
      finally {}
      Iterator localIterator = ((ArrayList)localObject).iterator();
      if (localIterator.hasNext())
      {
        IpData localIpData = (IpData)localIterator.next();
        localObject = localIpData.d;
        if (localIpData.a != 80)
        {
          localObject = (String)localObject + ":" + localIpData.a;
          localArrayList.add(localObject);
          continue;
          i1 = 50;
          bool = false;
          break label553;
          bool = false;
          i1 = 60;
          continue;
          if (this.b)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("domain", paramString);
            ((Bundle)localObject).putInt("businessType", paramInt);
            localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
            if (((EIPCResult)localObject).isSuccess()) {
              localArrayList = ((EIPCResult)localObject).data.getStringArrayList("ip");
            }
            for (;;)
            {
              break;
              bool = false;
              i1 = 20;
            }
          }
          bool = false;
          i1 = 10;
        }
        else {}
      }
      else
      {
        bool = true;
        i1 = i2;
        break label553;
        i1 = 0;
        if (i1 != 0)
        {
          i1 = 30;
          bool = false;
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      try
      {
        BaseApplicationImpl.a().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", a(this.jdField_a_of_type_JavaUtilHashMap)).commit();
        return;
      }
      finally {}
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceivePush:" + BaseApplicationImpl.i);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localObject1 = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject1).getInt() - 4];
        ((ByteBuffer)localObject1).get(paramFromServiceMsg);
        localObject1 = new DomainIp.NameRspBody();
        ((DomainIp.NameRspBody)localObject1).mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = (DomainIp.SubCmd_name_Rsp)((DomainIp.NameRspBody)localObject1).SubCmd_name_Rsp.get();
        if (paramFromServiceMsg != null) {
          continue;
        }
        i1 = 0;
      }
      catch (Exception paramFromServiceMsg)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        DomainIp.DomainServerList localDomainServerList;
        IpData localIpData;
        paramFromServiceMsg.printStackTrace();
        i1 = 0;
        continue;
        if (((ArrayList)localObject2).size() <= 0) {
          continue;
        }
        localHashMap.put(localObject1, new DomainData((String)localObject1, (ArrayList)localObject2));
        continue;
      }
      if (i1 != 0)
      {
        paramFromServiceMsg = a();
        try
        {
          if (!StringUtil.b(paramFromServiceMsg))
          {
            if ((this.jdField_a_of_type_JavaUtilHashMap.size() >= 5) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramFromServiceMsg))) {
              this.jdField_a_of_type_JavaUtilHashMap.clear();
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramFromServiceMsg, localHashMap);
          }
          BaseApplicationImpl.a().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", a(this.jdField_a_of_type_JavaUtilHashMap)).commit();
          return;
        }
        finally {}
        paramFromServiceMsg = paramFromServiceMsg.iplistInfo.get();
        if (paramFromServiceMsg == null)
        {
          i1 = 0;
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        if (!paramFromServiceMsg.hasNext()) {
          break label501;
        }
        localObject2 = (DomainIp.DomainiplistInfo)paramFromServiceMsg.next();
        localObject1 = ((DomainIp.DomainiplistInfo)localObject2).string_dname.get();
        if ((StringUtil.b((String)localObject1)) || (((DomainIp.DomainiplistInfo)localObject2).int32_result.get() != 0)) {
          break label501;
        }
        localObject3 = ((DomainIp.DomainiplistInfo)localObject2).ServerList_data.get();
        if (localObject3 == null) {
          break label501;
        }
        localObject2 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localDomainServerList = (DomainIp.DomainServerList)((Iterator)localObject3).next();
          localIpData = new IpData();
          localIpData.d = localDomainServerList.string_IP.get();
          localIpData.a = localDomainServerList.uint32_Port.get();
          ((ArrayList)localObject2).add(localIpData);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceivePush:" + (String)localObject1 + " " + localIpData.d + " " + localIpData.a);
          continue;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "decode failed.");
      return;
      label501:
      int i1 = 1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool = false;
    int i1 = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "reportBadIp domian: " + paramString1 + " ip:" + paramString2 + " busiType:" + paramInt + " ServerProcName:" + this.l);
    }
    Object localObject;
    if ((StringUtil.b(paramString1)) || (StringUtil.b(paramString2)) || (paramString1.equals(paramString2)))
    {
      bool = false;
      i1 = 40;
      localObject = new HashMap();
      ((HashMap)localObject).put("domain", paramString1);
      ((HashMap)localObject).put("ip", paramString2);
      ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i1));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "actDnsBadIp", bool, BaseApplicationImpl.i, 0L, (HashMap)localObject, "");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = a();
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        try
        {
          localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (((HashMap)localObject).containsKey(paramString1))
          {
            localObject = (DomainData)((HashMap)localObject).get(paramString1);
            if (((DomainData)localObject).a != null)
            {
              localObject = ((DomainData)localObject).a.iterator();
              while (((Iterator)localObject).hasNext())
              {
                IpData localIpData = (IpData)((Iterator)localObject).next();
                if (paramString2.equals(localIpData.d)) {
                  localIpData.b += 1;
                }
              }
            }
          }
        }
        finally {}
      }
      for (bool = true;; bool = false)
      {
        break;
        i1 = 60;
      }
    }
    if (this.b)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("domain", paramString1);
      ((Bundle)localObject).putString("ip", paramString2);
      ((Bundle)localObject).putInt("businessType", paramInt);
      if (QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject).isSuccess()) {
        break label412;
      }
      i1 = 20;
    }
    for (;;)
    {
      break;
      bool = false;
      i1 = 10;
      break;
      label412:
      i1 = 0;
      bool = true;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      localBundle.putStringArrayList("ip", a(paramBundle.getString("domain"), paramBundle.getInt("businessType")));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("reportBadIp".equals(paramString)) {
        a(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\transfile\dns\InnerDns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
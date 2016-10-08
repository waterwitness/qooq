package com.tencent.mobileqq.config;

import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PicIPManager
{
  public static final int a = 8;
  public static final String a;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static Hashtable[] jdField_a_of_type_ArrayOfJavaUtilHashtable;
  private static boolean[] jdField_a_of_type_ArrayOfBoolean;
  public static final String[][] a;
  public static final int b = 9;
  public static final String b = "QQHeadIPList";
  private static String[] b;
  public static final int c = 10;
  public static final int d = 11;
  public static final int e = 12;
  public static final int f = 13;
  public static final int g = 14;
  public static final int h = 15;
  public static final int i = 0;
  public static final int j = 1;
  public static final int k = 2;
  public static final int l = 3;
  public static final int m = 4;
  public static final int n = 5;
  public static final int o = 6;
  public static final int p = 7;
  public static final int q = 8;
  public static final int r = 9;
  public static final int s = 10;
  public static final int t = 11;
  public static final int u = 12;
  public static final int v = 13;
  public static final int w = 0;
  public static final int x = 1;
  public static final int y = 2;
  public static final int z = 3;
  
  static
  {
    int i1 = 0;
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PicIPManager.class.getSimpleName();
    String[] arrayOfString1 = { "p_qlogo_cn_2g", "p_qlogo_cn_3g", "p_plogo_cn_4g", "p_plogo_cn_wifi" };
    String[] arrayOfString2 = { "p_qpic_cn_2g", "p_qpic_cn_3g", "p_qpic_cn_4g", "p_qpic_cn_wifi" };
    String[] arrayOfString3 = { "sqimg_qq_com_2g", "sqimg_qq_com_3g", "sqimg_qq_com_4g", "sqimg_qq_com_wifi" };
    String[] arrayOfString4 = { "download_wegame_qq_com_2g", "download_wegame_qq_com_3g", "download_wegame_qq_com_4g", "download_wegame_qq_com_wifi" };
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "q_qlogo_cn_2g", "q_qlogo_cn_3g", "q_qlogo_cn_4g", "q_qlogo_cn_wifi" }, arrayOfString1, arrayOfString2, { "pgdt_gtimg_cn_2g", "pgdt_gtimg_cn_3g", "pgdt_gtimg_cn_4g", "pgdt_gtimg_cn_wifi" }, arrayOfString3, arrayOfString4, { "wfqqreader_3g_qq_cn_2g", "wfqqreader_3g_qq_cn_3g", "wfqqreader_3g_qq_cn_4g", "wfqqreader_3g_qq_cn_wifi" }, { "buluo_qq_com_2g", "buluo_qq_com_3g", "buluo_qq_com_4g", "buluo_qq_com_wifi" } };
    jdField_a_of_type_ArrayOfBoolean = new boolean[13];
    jdField_a_of_type_ArrayOfJavaLangString = new String[14];
    b = new String[14];
    jdField_a_of_type_ArrayOfJavaUtilHashtable = new Hashtable[11];
    while (i1 <= 7)
    {
      jdField_a_of_type_ArrayOfJavaUtilHashtable[i1] = new Hashtable(4);
      i1 += 1;
    }
    i1 = 8;
    while (i1 < 11)
    {
      jdField_a_of_type_ArrayOfJavaUtilHashtable[i1] = new Hashtable(3);
      i1 += 1;
    }
  }
  
  public static String a()
  {
    String str = String.valueOf(NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext()));
    if ((str.equals(b[12])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[12]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[12];
    }
    Object localObject = FMTSrvAddrProvider.a().a(12);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    b[12] = str;
    jdField_a_of_type_ArrayOfJavaLangString[12] = ((FileStorageServerListInfo)localObject).sIP;
    return jdField_a_of_type_ArrayOfJavaLangString[12];
  }
  
  public static String a(int paramInt)
  {
    int i1 = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
    if (i1 == 1) {
      i1 = 3;
    }
    while ((jdField_a_of_type_Array2dOfJavaLangString[paramInt][i1].equals(b[paramInt])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[paramInt])))
    {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      if (i1 == 2)
      {
        i1 = 0;
      }
      else if (i1 == 3)
      {
        i1 = 1;
      }
      else if (i1 == 4)
      {
        i1 = 2;
      }
      else
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "getIpList netType unknown netType=" + i1);
        return null;
      }
    }
    int i2;
    if (jdField_a_of_type_ArrayOfBoolean[paramInt] == 0)
    {
      localObject = BaseApplicationImpl.a().getSharedPreferences("QQHeadIPList", 4);
      if (localObject == null) {
        return null;
      }
      i2 = 0;
      while (i2 <= 3)
      {
        String str = ((SharedPreferences)localObject).getString(jdField_a_of_type_Array2dOfJavaLangString[paramInt][i2], null);
        if (!TextUtils.isEmpty(str))
        {
          String[] arrayOfString = str.split("\\|");
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int i3 = 0;
            while (i3 < arrayOfString.length)
            {
              localArrayList.add(arrayOfString[i3]);
              i3 += 1;
            }
            jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].put(jdField_a_of_type_Array2dOfJavaLangString[paramInt][i2], localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "getIpList array=" + str);
          }
        }
        i2 += 1;
      }
      jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    Object localObject = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(jdField_a_of_type_Array2dOfJavaLangString[paramInt][i1]);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      i2 = (int)(Math.random() * ((ArrayList)localObject).size());
      jdField_a_of_type_ArrayOfJavaLangString[paramInt] = ((String)((ArrayList)localObject).get(i2));
      b[paramInt] = jdField_a_of_type_Array2dOfJavaLangString[paramInt][i1];
    }
    return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "resetInitedFlag.");
    }
    int i1 = 0;
    while (i1 <= 7)
    {
      jdField_a_of_type_ArrayOfBoolean[i1] = false;
      i1 += 1;
    }
  }
  
  public static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    int i1 = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
    int i2;
    SharedPreferences localSharedPreferences;
    if (i1 == 1)
    {
      i2 = 3;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "saveQQHeadIpList netType=" + i1);
      }
      localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("QQHeadIPList", 4);
      if (localSharedPreferences == null) {
        break label792;
      }
    }
    label675:
    label792:
    for (Object localObject1 = localSharedPreferences.edit();; localObject1 = null)
    {
      i1 = 0;
      Object localObject2;
      for (;;)
      {
        if (i1 <= 7)
        {
          localObject2 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[i1].get(Integer.valueOf(i2));
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
            ((ArrayList)localObject2).clear();
          }
          if (localObject1 != null) {
            ((SharedPreferences.Editor)localObject1).putString(jdField_a_of_type_Array2dOfJavaLangString[i1][i2], null);
          }
          jdField_a_of_type_ArrayOfJavaLangString[i1] = null;
          b[i1] = null;
          i1 += 1;
          continue;
          if (i1 == 2)
          {
            i2 = 0;
            break;
          }
          if (i1 == 3)
          {
            i2 = 1;
            break;
          }
          if (i1 == 4)
          {
            i2 = 2;
            break;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 1, "saveQQHeadIpList netType unknown netType=" + i1);
          return;
        }
      }
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).commit();
      }
      if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.domainIpChannel != null) && (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
      {
        paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
        while (paramFileStoragePushFSSvcList.hasNext())
        {
          localObject1 = (DomainIpList)paramFileStoragePushFSSvcList.next();
          if ((((DomainIpList)localObject1).vIplist != null) && (((DomainIpList)localObject1).vIplist.size() != 0))
          {
            localObject2 = new StringBuilder();
            i1 = 0;
            while (i1 < ((DomainIpList)localObject1).vIplist.size())
            {
              ((StringBuilder)localObject2).append(NetworkUtil.a(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(i1)).uIp));
              if (i1 < ((DomainIpList)localObject1).vIplist.size() - 1) {
                ((StringBuilder)localObject2).append("|");
              }
              i1 += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "saveQQHeadIpList.uDomain_type=" + ((DomainIpList)localObject1).uDomain_type + ".strBuilder=" + ((StringBuilder)localObject2).toString());
            }
            if (((DomainIpList)localObject1).uDomain_type == 8) {
              i1 = 0;
            }
            ArrayList localArrayList;
            for (;;)
            {
              if ((((DomainIpList)localObject1).vIplist == null) || (((DomainIpList)localObject1).vIplist.size() == 0)) {
                break label675;
              }
              localObject2 = new StringBuilder();
              localArrayList = new ArrayList();
              int i3 = 0;
              while (i3 < ((DomainIpList)localObject1).vIplist.size())
              {
                String str = NetworkUtil.a(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(i3)).uIp);
                localArrayList.add(str);
                ((StringBuilder)localObject2).append(str);
                if (i3 < ((DomainIpList)localObject1).vIplist.size() - 1) {
                  ((StringBuilder)localObject2).append("|");
                }
                i3 += 1;
              }
              if (((DomainIpList)localObject1).uDomain_type == 9)
              {
                i1 = 1;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 10)
              {
                i1 = 2;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 11)
              {
                i1 = 3;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 12)
              {
                i1 = 4;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 13)
              {
                i1 = 5;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 14)
              {
                i1 = 6;
              }
              else
              {
                if (((DomainIpList)localObject1).uDomain_type != 15) {
                  break;
                }
                i1 = 7;
              }
            }
            continue;
            jdField_a_of_type_ArrayOfJavaUtilHashtable[i1].put(jdField_a_of_type_Array2dOfJavaLangString[i1][i2], localArrayList);
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "saveQQHeadIpList.sIpList=" + localArrayList + ",sb=" + ((StringBuilder)localObject2).toString());
            }
            if (localSharedPreferences != null) {
              localSharedPreferences.edit().putString(jdField_a_of_type_Array2dOfJavaLangString[i1][i2], ((StringBuilder)localObject2).toString()).commit();
            }
          }
        }
      }
      paramQQAppInterface.a().d();
      return;
    }
  }
  
  public static String b()
  {
    String str = String.valueOf(NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext()));
    if ((str.equals(b[13])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[13]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[13];
    }
    Object localObject = FMTSrvAddrProvider.a().a(14);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    b[13] = str;
    jdField_a_of_type_ArrayOfJavaLangString[13] = ((FileStorageServerListInfo)localObject).sIP;
    return jdField_a_of_type_ArrayOfJavaLangString[13];
  }
  
  public static String b(int paramInt)
  {
    String str1 = String.valueOf(DeviceInfoUtil.e());
    if ((str1.equals(b[paramInt])) && (!TextUtils.isEmpty(jdField_a_of_type_ArrayOfJavaLangString[paramInt]))) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    String str2;
    Object localObject1;
    if (jdField_a_of_type_ArrayOfBoolean[paramInt] == 0)
    {
      str2 = QzoneConfig.a().a("PhotoSvrList", "DownloadDirectIP");
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "getQzoneIp " + str2);
      }
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      localObject1 = "";
      if (paramInt == 10) {
        localObject1 = ".*qzonestyle.gtimg.cn";
      }
      while (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return null;
        if (paramInt == 8) {
          localObject1 = "ugc.qpic.cn";
        } else if (paramInt == 9) {
          localObject1 = "a[0-9].qpic.cn";
        } else if (paramInt == 11) {
          localObject1 = ".*qzs.qq.com";
        }
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = new JSONObject(str2).getJSONArray((String)localObject1);
        i1 = 0;
        if (i1 < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i1);
          str2 = ((JSONObject)localObject2).getString("apn");
          localObject2 = ((JSONObject)localObject2).getString("ip");
          ArrayList localArrayList2 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(str2);
          if (localArrayList2 == null)
          {
            localArrayList2 = new ArrayList();
            localArrayList2.add(localObject2);
            jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].put(str2, localArrayList2);
          }
          else
          {
            localArrayList2.add(localObject2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      for (;;)
      {
        ArrayList localArrayList1 = (ArrayList)jdField_a_of_type_ArrayOfJavaUtilHashtable[paramInt].get(str1);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          break;
        }
        i1 = (int)(Math.random() * localArrayList1.size());
        jdField_a_of_type_ArrayOfJavaLangString[paramInt] = ((String)localArrayList1.get(i1));
        b[paramInt] = str1;
        return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
        jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
      }
      return null;
      i1 += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\config\PicIPManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
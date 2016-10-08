package com.tencent.mobileqq.ark;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qpv;
import qpw;
import qpx;
import qpy;
import qpz;
import qqa;
import qqb;
import qqc;
import qqe;
import qqf;
import qqg;
import qqh;
import qqi;
import qqj;
import qqk;
import qql;
import qqm;

public class ArkAppCGI
  implements INetEngine.INetEngineListener
{
  private static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = "ArkApp.ArkAppCGI";
  private static PublicKey jdField_a_of_type_JavaSecurityPublicKey;
  private static final int b = 60;
  private static final int c = 300;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public ArkAppCGI(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = ((NetEngineFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    }
  }
  
  private ArkAppCGI.QueryAppInfoByAppNameBatchResult a(byte[] paramArrayOfByte)
  {
    localQueryAppInfoByAppNameBatchResult = new ArkAppCGI.QueryAppInfoByAppNameBatchResult();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppInfoByAppName, jsonBuffer is empty");
      return localQueryAppInfoByAppNameBatchResult;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
        str1 = paramArrayOfByte.getString("Ret");
        if (!str1.equalsIgnoreCase("200"))
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_QueryAppInfoByAppName, fail, retCode=%s", new Object[] { str1 }));
          return localQueryAppInfoByAppNameBatchResult;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONObject("Data");
        if (paramArrayOfByte == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppInfoByAppName, node 'Data' is null");
          return localQueryAppInfoByAppNameBatchResult;
        }
        localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = paramArrayOfByte.optInt("UpdateInterval", 300);
        if (localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int < 60) {
          localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_Int = 60;
        }
        localJSONObject = paramArrayOfByte.getJSONObject("AppList");
        if (localJSONObject == null)
        {
          ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppInfoByAppName, node 'AppList' is null");
          return localQueryAppInfoByAppNameBatchResult;
        }
        localIterator = localJSONObject.keys();
      }
      catch (JSONException paramArrayOfByte)
      {
        String str1;
        JSONObject localJSONObject;
        Iterator localIterator;
        String str2;
        int i;
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppInfoByAppName, Json Exception:" + paramArrayOfByte.getMessage());
        return localQueryAppInfoByAppNameBatchResult;
        paramArrayOfByte = "";
        continue;
        paramArrayOfByte = ((JSONObject)localObject).getString("appver");
        String str3 = ((JSONObject)localObject).getString("url");
        String str4 = ((JSONObject)localObject).getString("sign");
        int j = ((JSONObject)localObject).optInt("update-period", 1380);
        Object localObject = new ArkAppInfo.AppDownloadInfo();
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc = new ArkAppInfo.AppDesc();
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.jdField_a_of_type_JavaLangString = str2;
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDesc.c = paramArrayOfByte;
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_JavaLangString = str3;
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_ArrayOfByte = Base64.decode(str4, 0);
        ((ArkAppInfo.AppDownloadInfo)localObject).jdField_a_of_type_Int = j;
        paramArrayOfByte = new ArkAppCGI.QueryAppInfoResult();
        paramArrayOfByte.h = i;
        paramArrayOfByte.jdField_a_of_type_JavaLangString = str1;
        paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = ((ArkAppInfo.AppDownloadInfo)localObject);
        localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(str2, paramArrayOfByte);
        continue;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppInfoByAppName, Exception:" + paramArrayOfByte.getMessage());
        continue;
      }
      if (!localIterator.hasNext()) {
        continue;
      }
      str2 = (String)localIterator.next();
      localObject = localJSONObject.optJSONObject(str2);
      if (localObject != null)
      {
        i = ((JSONObject)localObject).optInt("err", -1);
        str1 = ((JSONObject)localObject).optString("msg");
        if (i == 0) {
          continue;
        }
        if (str1 == null) {
          continue;
        }
        paramArrayOfByte = str1;
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_QueryAppInfoByAppName, Query Fail, app=%s, err=%d, msg=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfByte }));
        paramArrayOfByte = new ArkAppCGI.QueryAppInfoResult();
        paramArrayOfByte.h = i;
        paramArrayOfByte.jdField_a_of_type_JavaLangString = str1;
        paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$AppDownloadInfo = null;
        localQueryAppInfoByAppNameBatchResult.jdField_a_of_type_JavaUtilHashMap.put(str2, paramArrayOfByte);
      }
    }
  }
  
  private ArkAppInfo.AppDesc a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppNameByMetaInfo: replyBuf is empty");
      return null;
    }
    Object localObject;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      localObject = paramArrayOfByte.getString("Ret");
      if (!((String)localObject).equalsIgnoreCase("200"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppNameByMetaInfo, reply fail, ret=" + (String)localObject);
        return null;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppNameByMetaInfo, Json Exception:" + paramArrayOfByte.getMessage());
      return null;
      localObject = new ArkAppInfo.AppDesc();
      paramArrayOfByte = paramArrayOfByte.getJSONObject("Data").getJSONObject("App");
      ((ArkAppInfo.AppDesc)localObject).jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("name");
      ((ArkAppInfo.AppDesc)localObject).d = paramArrayOfByte.getString("view");
      ((ArkAppInfo.AppDesc)localObject).jdField_b_of_type_JavaLangString = paramArrayOfByte.optString("des");
      ((ArkAppInfo.AppDesc)localObject).jdField_a_of_type_Int = paramArrayOfByte.optInt("disptype");
      if ((TextUtils.isEmpty(((ArkAppInfo.AppDesc)localObject).jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(((ArkAppInfo.AppDesc)localObject).d)))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppNameByMetaInfo, name or view is empty");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryAppNameByMetaInfo, Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    return (ArkAppInfo.AppDesc)localObject;
  }
  
  private ArkAppInfo.ContextWithMeta a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    String str1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      localObject1 = paramArrayOfByte.getString("Ret");
      if (!((String)localObject1).equalsIgnoreCase("200"))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("parseReply_QueryMetaByMessage: fail ret=%s", new Object[] { localObject1 }));
        return null;
      }
      localObject1 = paramArrayOfByte.getJSONObject("Data");
      if (localObject1 == null)
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryMetaByMessage: Data is Empty");
        return null;
      }
      paramArrayOfByte = new ArkAppInfo.ContextWithMeta();
      paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$Context.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("Context");
      paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$Context.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("Action");
      localObject2 = ((JSONObject)localObject1).optJSONObject("MetaList");
      if (localObject2 != null)
      {
        localObject3 = ((JSONObject)localObject2).keys();
        while (((Iterator)localObject3).hasNext())
        {
          str1 = (String)((Iterator)localObject3).next();
          String str2 = ((JSONObject)localObject2).optString(str1);
          paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$MetaValue.jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
        }
      }
      localObject1 = ((JSONObject)localObject1).optJSONObject("MetaListEx");
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_QueryMetaByMessage: Exception:" + paramArrayOfByte.getMessage());
      return null;
    }
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        str1 = ((JSONObject)localObject1).optString((String)localObject3);
        paramArrayOfByte.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$MetaValue.b.put(localObject3, str1);
      }
    }
    return paramArrayOfByte;
  }
  
  private String a(ArkAppInfo.Context paramContext, ArkAppInfo.Meta paramMeta)
  {
    Object localObject = new StringBuilder();
    if (paramMeta != null)
    {
      if ((paramMeta.jdField_a_of_type_JavaUtilArrayList != null) && (paramMeta.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = paramMeta.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ((StringBuilder)localObject).append((String)localIterator.next());
          ((StringBuilder)localObject).append('|');
        }
      }
      if ((paramMeta.jdField_b_of_type_JavaUtilArrayList != null) && (paramMeta.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        paramMeta = paramMeta.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (paramMeta.hasNext())
        {
          ((StringBuilder)localObject).append((String)paramMeta.next());
          ((StringBuilder)localObject).append('|');
        }
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    paramMeta = (ArkAppInfo.Meta)localObject;
    if (((String)localObject).endsWith("|")) {
      paramMeta = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    }
    return a("QueryAppByMeta", "1", new qqm[] { new qqm("Context", paramContext.jdField_a_of_type_JavaLangString), new qqm("Action", paramContext.jdField_b_of_type_JavaLangString), new qqm("MetaList", paramMeta) });
  }
  
  private String a(String paramString1, String paramString2, qqm... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new qqm("QQVersion", "6.5.5"));
    localArrayList.add(new qqm("Uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()));
    localArrayList.add(new qqm("Cmd", paramString1));
    localArrayList.add(new qqm("Ver", paramString2));
    localArrayList.add(new qqm("OS", "android"));
    localArrayList.add(new qqm("Framework", ArkAppCenter.a()));
    localArrayList.add(new qqm("MinFramework", ArkAppCenter.b()));
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramVarArgs[i]);
        i += 1;
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("http://ark.qq.com/cgi-bin/arkappcgi?");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      paramString2 = localArrayList.iterator();
      while (paramString2.hasNext())
      {
        paramVarArgs = (qqm)paramString2.next();
        try
        {
          paramString1.append(paramVarArgs.jdField_a_of_type_JavaLangString);
          paramString1.append('=');
          paramString1.append(URLEncoder.encode(paramVarArgs.jdField_b_of_type_JavaLangString, "UTF-8"));
          paramString1.append('&');
        }
        catch (Exception paramVarArgs)
        {
          paramVarArgs.printStackTrace();
        }
      }
      paramString1.setLength(paramString1.length() - 1);
    }
    return paramString1.toString();
  }
  
  private static String a(ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append('|');
      }
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static PublicKey a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 382	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   6: ifnull +12 -> 18
    //   9: getstatic 382	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 384	java/security/spec/X509EncodedKeySpec
    //   21: dup
    //   22: ldc_w 386
    //   25: iconst_0
    //   26: invokestatic 218	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   29: invokespecial 389	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   32: astore_0
    //   33: ldc_w 391
    //   36: invokestatic 397	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   39: aload_0
    //   40: invokevirtual 401	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: putstatic 382	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   46: getstatic 382	com/tencent/mobileqq/ark/ArkAppCGI:jdField_a_of_type_JavaSecurityPublicKey	Ljava/security/PublicKey;
    //   49: astore_0
    //   50: goto -37 -> 13
    //   53: astore_0
    //   54: ldc 12
    //   56: new 175	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 403
    //   66: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   73: invokevirtual 182	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 68	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: goto -36 -> 46
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	38	0	localObject1	Object
    //   53	17	0	localException	Exception
    //   85	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	46	53	java/lang/Exception
    //   3	13	85	finally
    //   18	33	85	finally
    //   33	46	85	finally
    //   46	50	85	finally
    //   54	82	85	finally
  }
  
  private void a(qqh paramqqh, qqf arg2)
  {
    paramqqh.jdField_a_of_type_Qqf = ???;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqqh);
      ThreadManager.a(new qqc(this, paramqqh), 5, null, true);
      return;
    }
  }
  
  private void a(qqh paramqqh, qqf arg2, boolean paramBoolean)
  {
    paramqqh.jdField_a_of_type_Qqf = ???;
    paramqqh.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
    if (!paramBoolean) {}
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramqqh);
      ??? = new HttpNetReq();
      ???.a(paramqqh);
      ???.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      ???.c = 0;
      ???.jdField_a_of_type_JavaLangString = paramqqh.jdField_a_of_type_JavaLangString;
      ???.m = 1;
      ???.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      ???.d = 30L;
      ???.jdField_a_of_type_JavaIoOutputStream = paramqqh.jdField_a_of_type_JavaIoByteArrayOutputStream;
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) || (!NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext())))
      {
        ArkAppCenter.c("ArkApp.ArkAppCGI", "runTask_retry, network not available");
        ThreadManager.a(new qqb(this, paramqqh), 5, null, true);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(???);
  }
  
  private void a(qqh paramqqh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    new Handler(Looper.getMainLooper()).post(new qqe(this, paramqqh, paramBoolean, paramArrayOfByte));
  }
  
  private void a(qqi paramqqi, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    int i;
    label32:
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: net fail, url=%s", new Object[] { paramqqi.jdField_a_of_type_JavaLangString }));
      arrayOfByte = null;
      i = 0;
      if (i >= paramqqi.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      paramArrayOfByte = paramqqi.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramqqi.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (arrayOfByte == null) {
          break label148;
        }
      }
    }
    label148:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, arrayOfByte, paramArrayOfByte);
      i += 1;
      break label32;
      if (paramqqi.jdField_a_of_type_ArrayOfByte != null)
      {
        arrayOfByte = paramArrayOfByte;
        if (a(paramArrayOfByte, paramqqi.jdField_a_of_type_ArrayOfByte)) {
          break;
        }
      }
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onDownloadAppPackage: verifyAppPackage fail, url=%s", new Object[] { paramqqi.jdField_a_of_type_JavaLangString }));
      arrayOfByte = null;
      break;
    }
  }
  
  private void a(qqj paramqqj, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryAppInfoByAppName: fail, appName=%s, url=%s", new Object[] { paramqqj.jdField_b_of_type_JavaLangString, paramqqj.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
    }
    while (i < paramqqj.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Object localObject = paramqqj.jdField_a_of_type_JavaUtilArrayList.get(i);
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramqqj.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.a(paramArrayOfByte, localObject);
      }
      i += 1;
      continue;
      paramArrayOfByte = a(paramArrayOfByte);
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryAppInfoByAppName: appName=%s, url=%s, result=%d/%d", new Object[] { paramqqj.jdField_b_of_type_JavaLangString, paramqqj.jdField_a_of_type_JavaLangString, Integer.valueOf(paramqqj.c.size()), Integer.valueOf(paramArrayOfByte.jdField_a_of_type_JavaUtilHashMap.size()) }));
    }
  }
  
  private void a(qqk paramqqk, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryAppNameByMetaInfo: fail, url=%s", new Object[] { paramqqk.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramqqk.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramqqk.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramqqk.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label132;
        }
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryAppNameByMetaInfo: parseReply fail, url=%s", new Object[] { paramqqk.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private void a(qql paramqql, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i;
    label31:
    Object localObject;
    ArkAppCGI.ArkAppCGICallback localArkAppCGICallback;
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryMetaByMessage, net fail, url=%s, err=%d, %s", new Object[] { paramqql.jdField_a_of_type_JavaLangString }));
      paramArrayOfByte = null;
      i = 0;
      if (i >= paramqql.jdField_b_of_type_JavaUtilArrayList.size()) {
        return;
      }
      localObject = paramqql.jdField_a_of_type_JavaUtilArrayList.get(i);
      localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramqql.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localArkAppCGICallback != null) {
        if (paramArrayOfByte == null) {
          break label132;
        }
      }
    }
    label132:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localArkAppCGICallback.a(paramBoolean, paramArrayOfByte, localObject);
      i += 1;
      break label31;
      paramArrayOfByte = a(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        ArkAppCenter.c("ArkApp.ArkAppCGI", String.format("onQueryMetaByMessage, parseReply fail, url=%s", new Object[] { paramqql.jdField_a_of_type_JavaLangString }));
      }
      break;
    }
  }
  
  private void a(byte[] paramArrayOfByte, ArrayList paramArrayList)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayList == null))
    {
      ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_PredownloadAppList: replyBuf is empty");
      return;
    }
    paramArrayList.clear();
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte = new JSONObject(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.optJSONArray("update_applist");
        if (paramArrayOfByte == null) {
          break;
        }
        int j = paramArrayOfByte.length();
        i = 0;
        if (i >= j) {
          break;
        }
        String str = paramArrayOfByte.getString(i);
        if ((!TextUtils.isEmpty(str)) && (!paramArrayList.contains(str)) && (ArkLocalAppMgr.a(str))) {
          paramArrayList.add(str);
        }
      }
      catch (JSONException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_PredownloadAppList, Json Exception:" + paramArrayOfByte.getMessage());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ArkAppCenter.c("ArkApp.ArkAppCGI", "parseReply_PredownloadAppList, Exception:" + paramArrayOfByte.getMessage());
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        qqh localqqh = (qqh)localIterator.next();
        if (localqqh.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))
        {
          localqqh.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
          localqqh.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
          return true;
        }
      }
      return false;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    PublicKey localPublicKey = a();
    if (localPublicKey == null) {
      return true;
    }
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(localPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return true;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return true;
  }
  
  private void b(ArrayList paramArrayList, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramArrayList == null) || (paramArrayList.size() > 10)) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = a(paramArrayList);
      str2 = a("QueryAppInfoBatch", "1", new qqm[] { new qqm("App", str1) });
    } while (a(str2, paramObject, paramArkAppCGICallback));
    qqj localqqj = new qqj(null);
    localqqj.jdField_a_of_type_JavaLangString = str2;
    localqqj.c = paramArrayList;
    localqqj.jdField_b_of_type_JavaLangString = str1;
    localqqj.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localqqj.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localqqj, new qpw(this));
  }
  
  public void a(ArkAppInfo.Context paramContext, ArkAppInfo.Meta paramMeta, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    String str = a(paramContext, paramMeta);
    if (a(str, paramObject, paramArkAppCGICallback)) {
      return;
    }
    qqk localqqk = new qqk(null);
    localqqk.jdField_a_of_type_JavaLangString = str;
    localqqk.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$Context = paramContext;
    localqqk.jdField_a_of_type_ComTencentMobileqqArkArkAppInfo$Meta = paramMeta;
    localqqk.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localqqk.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localqqk, new qpx(this));
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    qqh localqqh = (qqh)paramNetResp.a.a();
    if (paramNetResp.e == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramNetResp = null;
      if (bool) {
        paramNetResp = localqqh.jdField_a_of_type_JavaIoByteArrayOutputStream.toByteArray();
      }
      a(localqqh, bool, paramNetResp);
      return;
    }
  }
  
  public void a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString, paramObject, paramArkAppCGICallback)) {
      return;
    }
    qqh localqqh = new qqh(null);
    localqqh.jdField_a_of_type_JavaLangString = paramString;
    localqqh.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localqqh.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localqqh, new qpz(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if (a(paramString, paramObject, paramArkAppCGICallback)) {
      return;
    }
    qqi localqqi = new qqi(null);
    localqqi.jdField_a_of_type_JavaLangString = paramString;
    localqqi.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localqqi.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localqqi.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localqqi, new qpy(this));
  }
  
  public void a(ArrayList paramArrayList, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    int i = 0;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    qqg localqqg;
    do
    {
      return;
      localqqg = new qqg(null);
      localqqg.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localqqg.b = 0;
      int j = paramArrayList.size() / 10;
      if (paramArrayList.size() % 10 > 0) {
        i = 1;
      }
      localqqg.jdField_a_of_type_Int = (i + j);
      localqqg.jdField_a_of_type_JavaLangObject = paramObject;
      localqqg.jdField_a_of_type_ComTencentMobileqqArkArkAppCGI$ArkAppCGICallback = paramArkAppCGICallback;
      paramArkAppCGICallback = new qpv(this);
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = null;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramObject = paramArrayList;
        if (paramArrayList == null) {
          paramObject = new ArrayList();
        }
        ((ArrayList)paramObject).add(str);
        paramArrayList = (ArrayList)paramObject;
        if (((ArrayList)paramObject).size() >= 10)
        {
          b((ArrayList)paramObject, localqqg, paramArkAppCGICallback);
          paramArrayList = null;
        }
      }
    } while ((paramArrayList == null) || (paramArrayList.size() <= 0));
    b(paramArrayList, localqqg, paramArkAppCGICallback);
  }
  
  public void b(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    String str = a("QueryMetaByMessage", "1", new qqm[] { new qqm("Message", paramString) });
    if (a(str, paramObject, paramArkAppCGICallback)) {
      return;
    }
    qql localqql = new qql(null);
    localqql.jdField_a_of_type_JavaLangString = str;
    localqql.jdField_b_of_type_JavaLangString = paramString;
    localqql.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    localqql.jdField_b_of_type_JavaUtilArrayList.add(paramArkAppCGICallback);
    a(localqql, new qqa(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\ark\ArkAppCGI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
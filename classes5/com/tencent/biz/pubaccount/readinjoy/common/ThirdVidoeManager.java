package com.tencent.biz.pubaccount.readinjoy.common;

import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidRequest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import hxm;
import java.util.Hashtable;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ThirdVidoeManager
{
  private static MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(120);
  private static ThirdVidoeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager;
  public static final String a = "THIRD_VIDEO_TAG";
  public static final String b = "PubAccountArticleCenter.GetUrlByVid";
  private ThirdVidoeManager.UUIDToUrlCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback;
  public Long a;
  public Hashtable a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private ThirdVidoeManager()
  {
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  }
  
  public static ThirdVidoeManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager = new ThirdVidoeManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager;
  }
  
  public static VidUrl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    VidUrl localVidUrl;
    do
    {
      return paramString;
      localVidUrl = (VidUrl)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      if (localVidUrl == null) {
        break;
      }
      paramString = localVidUrl;
    } while (localVidUrl.a(NetConnInfoCenter.getServerTime()));
    return null;
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, NetConnInfoCenter.getServerTime());
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("THIRD_VIDEO_TAG", 2, "cache setVidUrl vid : " + paramString1 + " url:" + paramString2);
    }
    VidUrl localVidUrl = new VidUrl();
    localVidUrl.b = paramString2;
    localVidUrl.jdField_a_of_type_JavaLangString = paramString1;
    localVidUrl.jdField_a_of_type_Long = paramLong;
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString1, localVidUrl);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback = null;
  }
  
  public void a(ThirdVidoeManager.UUIDToUrlCallback paramUUIDToUrlCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback = paramUUIDToUrlCallback;
  }
  
  public void a(String paramString)
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback.a("", paramString);
      }
    }
    do
    {
      return;
      localObject = a(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("THIRD_VIDEO_TAG", 2, "cache getUrlByVid vid : " + paramString + " url:" + (String)localObject);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback == null);
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager$UUIDToUrlCallback.a((String)localObject, paramString);
    return;
    long l = System.currentTimeMillis();
    Object localObject = new NewIntent(localAppRuntime.getApplication(), PublicAccountServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "PubAccountArticleCenter.GetUrlByVid");
    ArticleCenter.GetUrlByVidRequest localGetUrlByVidRequest = new ArticleCenter.GetUrlByVidRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
    localGetUrlByVidRequest.vid.set(localByteStringMicro);
    ((NewIntent)localObject).putExtra("data", localGetUrlByVidRequest.toByteArray());
    ((NewIntent)localObject).setObserver(new hxm(this, l, paramString, localAppRuntime, (NewIntent)localObject));
    localAppRuntime.startServlet((NewIntent)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\common\ThirdVidoeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
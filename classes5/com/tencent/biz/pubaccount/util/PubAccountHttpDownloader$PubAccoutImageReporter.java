package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class PubAccountHttpDownloader$PubAccoutImageReporter
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "2909288299" };
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private final String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public PubAccountHttpDownloader$PubAccoutImageReporter(BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_Int = ReadInJoyUtils.a();
    this.jdField_a_of_type_JavaLangString = ("PubAccountHttpDownloader." + this.jdField_a_of_type_Int);
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (paramString != null)
    {
      arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
  {
    return new PubAccountHttpDownloader.PubAccoutImageReporter.WrapURLDrawableHandler(paramURLDrawableHandler, this);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, DownloadParams paramDownloadParams)
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey("puin"))
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get("puin");
      paramDownloadParams = (String)this.jdField_a_of_type_JavaUtilMap.get("msgid");
    }
    for (;;)
    {
      if (a((String)localObject1)) {}
      Object localObject2;
      do
      {
        return;
        if ((paramDownloadParams.mExtraInfo == null) || (!(paramDownloadParams.mExtraInfo instanceof MessageRecord))) {
          break label800;
        }
        paramDownloadParams = (MessageRecord)paramDownloadParams.mExtraInfo;
        localObject1 = paramDownloadParams.frienduin;
        if (((paramDownloadParams instanceof MessageForStructing)) && (((MessageForStructing)paramDownloadParams).structingMsg != null))
        {
          paramDownloadParams = "" + ((MessageForStructing)paramDownloadParams).structingMsg.msgId;
          break;
        }
        if ((!(paramDownloadParams instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramDownloadParams).mPAMessage == null)) {
          break label795;
        }
        paramDownloadParams = "" + ((MessageForPubAccount)paramDownloadParams).mPAMessage.mMsgId;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
        if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {
          break label328;
        }
        localObject2 = (QQAppInterface)localObject2;
        if (localObject1 == null) {
          break label307;
        }
        switch (PublicAccountUtil.a((QQAppInterface)localObject2, (String)localObject1))
        {
        }
      } while (this.jdField_b_of_type_Int == 0);
      int i = 0;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_acc_type", "" + i);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", localObject1);
      label307:
      localObject1 = ((QQAppInterface)localObject2).a();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", localObject1);
      }
      label328:
      if (paramDownloadParams != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_msgid", paramDownloadParams);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("picRetryCount", "" + paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put("picFormat", this.d);
      this.jdField_a_of_type_JavaUtilHashMap.put("netType", this.g);
      this.jdField_a_of_type_JavaUtilHashMap.put("plateform", this.f);
      this.jdField_a_of_type_JavaUtilHashMap.put("pixDensity", this.h);
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_a_of_type_Boolean)
      {
        paramDownloadParams = String.valueOf(1);
        label445:
        ((HashMap)localObject1).put("picSucc", paramDownloadParams);
        this.jdField_a_of_type_JavaUtilHashMap.put("picTotalCost", Long.toString(this.jdField_b_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("picType", this.e);
        this.jdField_a_of_type_JavaUtilHashMap.put("picSize", String.valueOf(this.jdField_c_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("picErrDesc", this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("picErrCode", this.jdField_c_of_type_Int + "");
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilHashMap.put("picErrorUrl", this.jdField_b_of_type_JavaLangString);
        }
        paramDownloadParams = "actSubscriptionUnkonw";
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportTag:").append(paramDownloadParams).append(", success:").append(this.jdField_a_of_type_Boolean).append(", time:").append(this.jdField_b_of_type_Long).append(", size:").append(this.jdField_c_of_type_Long).append(", url:").append(this.jdField_b_of_type_JavaLangString).append(", exInfo:").append(this.jdField_a_of_type_JavaUtilHashMap.toString());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, ((StringBuilder)localObject1).toString());
        }
        StatisticCollector.a(BaseApplication.getContext()).a(null, paramDownloadParams, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        i = 4;
        break;
        paramDownloadParams = String.valueOf(0);
        break label445;
        paramDownloadParams = "actSubscriptionAIO";
        continue;
        paramDownloadParams = "actSubscriptionDetail";
        continue;
        paramDownloadParams = "actSubscriptionFolder";
        continue;
        paramDownloadParams = "actKandianImage";
      }
      label795:
      paramDownloadParams = null;
      continue;
      label800:
      paramDownloadParams = null;
      localObject1 = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = paramInt;
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(DownloadParams paramDownloadParams, Map paramMap)
  {
    long l = NetworkCenter.a().a();
    this.g = "None";
    if ((l > 0L) && (l < AppConstants.b.length)) {
      this.g = AppConstants.b[((int)l)];
    }
    this.f = ("ANDROID.MOBILE-" + Build.MODEL + ".SDK-" + Build.VERSION.SDK);
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.a().getApplicationContext().getResources().getDisplayMetrics();
    this.h = (localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
    this.jdField_b_of_type_JavaLangString = paramDownloadParams.urlStr;
    this.d = "none";
    int i = this.jdField_b_of_type_JavaLangString.lastIndexOf("/");
    if ((i != -1) && (i + 1 <= this.jdField_b_of_type_JavaLangString.length()) && (i + 1 < this.jdField_b_of_type_JavaLangString.length()))
    {
      this.d = this.jdField_b_of_type_JavaLangString.substring(i + 1);
      i = this.d.indexOf("?");
      if (i != -1) {
        this.d = this.d.substring(0, i);
      }
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString)
  {
    if (paramHttpResponse != null)
    {
      paramString = paramHttpResponse.getFirstHeader("Content-Type");
      this.e = "none";
      if ((paramString != null) && (paramString.getValue().startsWith("image/"))) {
        this.e = paramString.getValue().replace("image/", "");
      }
      paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Length");
      if (paramHttpResponse != null) {}
      try
      {
        this.jdField_c_of_type_Long = Long.valueOf(paramHttpResponse.getValue()).longValue();
        return;
      }
      catch (NumberFormatException paramHttpResponse)
      {
        paramHttpResponse.printStackTrace();
        return;
      }
    }
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "download task finish, ret : " + paramBoolean + ", errCode : " + paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start download pic , url : " + this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\util\PubAccountHttpDownloader$PubAccoutImageReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
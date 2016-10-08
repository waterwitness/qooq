import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class hhc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private AsyncCallBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  hhc(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if ((TextUtils.isEmpty(paramString)) || (paramAsyncCallBack == null))
    {
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "new TransUrl error");
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack = paramAsyncCallBack;
    this.b = Uri.parse(paramString).getQueryParameter("_bid");
  }
  
  private void a(String paramString, int paramInt)
  {
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "transThread callback mode:" + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack.a(paramInt, paramString);
    }
  }
  
  private boolean a()
  {
    String str = HtmlOffline.b(this.b);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, "html5/" + this.b + "/" + this.b + ".zip", str + this.b + ".zip");
  }
  
  public void a()
  {
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl start:" + this.b);
    }
    HtmlOffline.K = 0;
    long l3 = System.currentTimeMillis();
    Object localObject1 = HtmlOffline.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,html root dir is null!");
      }
      a(this.jdField_a_of_type_JavaLangString, 0);
      HtmlOffline.a(this.b, 2, 0L, -1, "lixian_cover", "0");
      return;
    }
    String str1 = (String)localObject1 + this.b;
    Object localObject3 = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    Object localObject2 = HtmlOffline.a(this.b);
    int j;
    long l1;
    if (localObject2 != null)
    {
      j = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
      i = j;
      if (j != 1)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        i = j;
        if (l1 > 0L)
        {
          i = j;
          if (l3 > l1) {
            i = 1;
          }
        }
      }
      if (i == 1)
      {
        HtmlOffline.K = 1;
        Util.a(str1);
        HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
        if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
        }
      }
    }
    if (!HtmlOffline.d(this.b))
    {
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = HtmlOffline.a(this.b);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        localObject1 = localObject2;
        if (l1 > 0L)
        {
          localObject1 = localObject2;
          if (l3 > l1)
          {
            if (HtmlOffline.K == 0) {
              HtmlOffline.K = 1;
            }
            Util.a(HtmlOffline.l + this.b);
            localObject1 = localObject2;
            if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
            {
              HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,zip expire =1");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    int i = 0;
    int k = 0;
    int n = 0;
    if (localObject3 != null)
    {
      j = ((JSONObject)localObject3).optInt("version", 0);
      l1 = ((JSONObject)localObject3).optLong("expired", 0L);
      i = j;
      if (l1 > 0L)
      {
        i = j;
        if (l3 > l1) {
          n = 1;
        }
      }
    }
    for (int m = j;; m = i)
    {
      if (localObject1 != null) {
        k = ((JSONObject)localObject1).optInt("version", 0);
      }
      if ((m == 0) && (k == 0))
      {
        if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl:no package in both asset and data dir!");
        }
        if (HtmlOffline.K == 0) {
          HtmlOffline.K = 3;
        }
        HtmlOffline.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject2 = this.b;
        i = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject1 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          HtmlOffline.a((String)localObject2, 5, 0L, i, "lixian_cover", (String)localObject1);
          return;
        }
      }
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:getVersion :" + String.valueOf(m) + "," + String.valueOf(k));
      }
      int i1 = 6;
      i = i1;
      localObject2 = localObject1;
      j = k;
      if (k < m)
      {
        i = i1;
        localObject2 = localObject1;
        j = k;
        if (n == 0)
        {
          if (!a()) {
            break label834;
          }
          if (!HtmlOffline.d(this.b)) {
            break label821;
          }
          localObject1 = HtmlOffline.a(this.b);
          if (localObject1 == null) {
            break label808;
          }
          j = ((JSONObject)localObject1).optInt("version", 0);
          localObject2 = localObject1;
          i = i1;
        }
      }
      if (j < m)
      {
        if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline,doTransUrl:SD card update fail.");
        }
        if (HtmlOffline.K == 0) {
          HtmlOffline.K = 4;
        }
        HtmlOffline.a(str1, this.b);
        a(this.jdField_a_of_type_JavaLangString, 0);
        localObject3 = this.b;
        l1 = j;
        j = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
        if (localObject2 == null) {}
        for (localObject1 = "0";; localObject1 = "1")
        {
          HtmlOffline.a((String)localObject3, i, l1, j, "lixian_cover", (String)localObject1);
          return;
          label808:
          i = 10;
          localObject2 = localObject1;
          j = k;
          break;
          label821:
          i = 9;
          localObject2 = localObject1;
          j = k;
          break;
          label834:
          i = 8;
          localObject2 = localObject1;
          j = k;
          break;
        }
      }
      i = 1;
      if (localObject2 != null) {
        i = ((JSONObject)localObject2).optInt("loadmode", 1);
      }
      localObject3 = this.jdField_a_of_type_JavaLangString;
      String str2 = HtmlOffline.g(this.jdField_a_of_type_JavaLangString);
      if (i == 2)
      {
        localObject1 = localObject3;
        if (!((String)localObject3).contains("_lv=")) {
          localObject1 = HtmlOffline.a((String)localObject3, "_lv=" + j);
        }
      }
      label925:
      label1009:
      label1020:
      label1474:
      label1477:
      label1492:
      for (;;)
      {
        k = 0;
        if (localObject2 != null) {
          k = ((JSONObject)localObject2).optInt("verifyType", 0);
        }
        boolean bool;
        long l2;
        if (new File(str1).exists())
        {
          if (HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          }
          l1 = System.currentTimeMillis();
          if ((i == 2) && (k == 1))
          {
            if (TextUtils.isEmpty(str2)) {
              break label1477;
            }
            bool = OfflineSecurity.b(str2, str1, this.b);
            i = 3;
            l2 = System.currentTimeMillis() - l1;
            l1 = 0L;
            if (bool) {
              break label1474;
            }
            if (HtmlOffline.K == 0) {
              HtmlOffline.K = 5;
            }
            HtmlOffline.a(str1, this.b);
            localObject1 = this.jdField_a_of_type_JavaLangString;
            if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:trans VerifyFile fail :" + this.b);
            }
            i = 0;
            j = 0;
          }
        }
        for (;;)
        {
          a((String)localObject1, i);
          if (j > 0)
          {
            long l4 = System.currentTimeMillis();
            HtmlOffline.a(this.b, 0, j, -1, "lixian_cover", "" + (l4 - l3));
            if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
              HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "trans time:" + (l4 - l3));
            }
            if (l2 > 0L)
            {
              HtmlOffline.a(this.b, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
              return;
              k = this.jdField_a_of_type_JavaLangString.indexOf(":");
              localObject1 = this.jdField_a_of_type_JavaLangString.substring(k + 3);
              localObject3 = "file://" + HtmlOffline.l + this.b + "/" + (String)localObject1;
              localObject1 = localObject3;
              if (!((String)localObject3).contains("_lv=")) {
                localObject1 = HtmlOffline.a((String)localObject3, "_lv=" + j + "&_t=" + System.currentTimeMillis());
              }
              if (new File(HtmlOffline.l + this.b + "/" + str2).exists()) {
                break label1492;
              }
              localObject1 = this.jdField_a_of_type_JavaLangString;
              break label925;
              bool = OfflineSecurity.a(str1, this.b);
              l4 = System.currentTimeMillis();
              l2 = 0L;
              l1 = l4 - l1;
              break label1020;
            }
            if (l1 <= 0L) {
              break;
            }
            HtmlOffline.a(this.b, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
            return;
          }
          HtmlOffline.a(this.b, 7, j, NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext), "lixian_cover", "0");
          return;
          continue;
          bool = false;
          break label1009;
          l2 = 0L;
          l1 = 0L;
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import rjc;

public class EPRecommendTask
{
  public static final String c = "3";
  public static final String d = "http://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/xydata.json";
  public static final String e = "http://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/";
  private static final String f = EPRecommendTask.class.getSimpleName();
  Runnable a;
  public String a;
  public WeakReference a;
  public String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EPRecommendTask(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRunnable = new rjc(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static MagicPromotionInfo a(String paramString)
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = new JSONObject(paramString).getJSONObject("data").getJSONArray("emojiAioConfig");
      if (localObject1 != null)
      {
        if (((JSONArray)localObject1).length() == 0) {
          return null;
        }
        paramString = new MagicPromotionInfo();
      }
      return null;
    }
    catch (Exception localException1)
    {
      try
      {
        localObject1 = (JSONObject)((JSONArray)localObject1).get(0);
        if (((JSONObject)localObject1).has("hide")) {
          paramString.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("hide");
        }
        if (((JSONObject)localObject1).has("version")) {
          paramString.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("version");
        }
        if (((JSONObject)localObject1).has("url")) {
          paramString.c = ((JSONObject)localObject1).getString("url");
        }
        if (((JSONObject)localObject1).has("gifUrl")) {
          paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("gifUrl");
        }
        if (((JSONObject)localObject1).has("imgUrl")) {
          paramString.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("imgUrl");
        }
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
      paramString = (String)localObject2;
      localException1.printStackTrace();
      return paramString;
    }
  }
  
  public EPRecommendTask a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    return this;
  }
  
  public void a()
  {
    ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 5, null, true);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = a(new String(paramArrayOfByte, "utf-8"));
        if (paramArrayOfByte != null)
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("mobileQQ", 0);
          localSharedPreferences.edit().putInt("magic_promotion_hide", paramArrayOfByte.jdField_a_of_type_Int).commit();
          if (QLog.isColorLevel()) {
            QLog.d(f, 2, "promotionInfo:[hide]:" + paramArrayOfByte.jdField_a_of_type_Int + ",[ver]:" + paramArrayOfByte.jdField_b_of_type_Int);
          }
          if ((1 != paramArrayOfByte.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramArrayOfByte.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArrayOfByte.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArrayOfByte.c)))
          {
            localSharedPreferences.edit().putString("magic_promotion_jump_url", paramArrayOfByte.c).commit();
            localSharedPreferences.edit().putString("magic_promotion_imgUrl", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/" + paramArrayOfByte.jdField_b_of_type_JavaLangString).commit();
            localSharedPreferences.edit().putString("magic_promotion_gifUrl", "http://i.gtimg.cn/qqshow/admindata/comdata/vip_emoji_aio_android_config/" + paramArrayOfByte.jdField_a_of_type_JavaLangString).commit();
            if (localSharedPreferences.getInt("magic_promotion_old_ver_" + EarlyDownloadManager.a(), -1) < paramArrayOfByte.jdField_b_of_type_Int)
            {
              localSharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + EarlyDownloadManager.a(), true).commit();
              localSharedPreferences.edit().putInt("magic_promotion_old_ver_" + EarlyDownloadManager.a(), paramArrayOfByte.jdField_b_of_type_Int).commit();
              return;
            }
          }
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\EPRecommendTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
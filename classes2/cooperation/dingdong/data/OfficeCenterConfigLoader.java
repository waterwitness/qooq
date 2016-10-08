package cooperation.dingdong.data;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.json.JSONException;
import org.json.JSONObject;

public class OfficeCenterConfigLoader
{
  private static volatile OfficeCenterConfigLoader jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader;
  public static final String a = "OfficeCenterConfigLoader";
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public OfficeCenterConfigLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = "";
    this.c = "";
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  public static OfficeCenterConfigLoader a()
  {
    if (jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader == null) {}
    try
    {
      if (jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader == null) {
        jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader = new OfficeCenterConfigLoader();
      }
      return jdField_a_of_type_CooperationDingdongDataOfficeCenterConfigLoader;
    }
    finally {}
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtra("reqCode", 3);
    paramQQAppInterface.putExtra("hasUpdate", paramBoolean);
    DingdongPluginHelper.a(2, paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (!a(paramArrayOfByte, this.b)) {
      if (QLog.isColorLevel()) {
        QLog.i("OfficeCenterConfigLoader", 2, "failed to check md5, hash: " + this.b);
      }
    }
    for (;;)
    {
      return;
      try
      {
        paramArrayOfByte = new String(a(a(paramArrayOfByte, this.c.getBytes())), "UTF-8");
        if (paramArrayOfByte == null) {
          continue;
        }
        OfficeCenterSharedPref.a().a("officecenter_apps_list_txt", paramArrayOfByte);
        a(paramQQAppInterface, true);
        return;
      }
      catch (DataFormatException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
  }
  
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    paramArrayOfByte = b(paramArrayOfByte);
    if (paramArrayOfByte == null) {}
    while (a(paramArrayOfByte).compareToIgnoreCase(paramString) != 0) {
      return false;
    }
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[a(paramArrayOfByte, 0)];
    Inflater localInflater = new Inflater();
    localInflater.setInput(paramArrayOfByte, 4, paramArrayOfByte.length - 4);
    localInflater.inflate(arrayOfByte);
    localInflater.end();
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return OfficeCenterSharedPref.a().a("officecenter_push_cfg_txt", null);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    QLog.d("OfficeCenterConfigLoader", 1, "begin to get config, mbConfigGetting = " + this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("OfficeCenterConfigLoader", 4, "officecenter: get config is doing.");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ConfigServlet.e(paramQQAppInterface, paramQQAppInterface.a());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramString != null)
    {
      localObject1 = paramString;
      if (OfficeCenterSharedPref.a().a("officecenter_push_cfg_txt", paramString)) {
        SharedPreUtils.c(paramQQAppInterface.getApplication(), paramInt);
      }
    }
    for (Object localObject1 = paramString;; localObject1 = a())
    {
      QLog.d("OfficeCenterConfigLoader", 4, "onGetConfig, str context size: " + (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.i("OfficeCenterConfigLoader", 2, "onGetConfig, ctx: " + (String)localObject1);
      }
      try
      {
        this.jdField_a_of_type_Boolean = false;
        if ((localObject1 != null) && (!((String)localObject1).equals("")) && (NetworkUtil.h(BaseApplication.getContext()))) {
          break;
        }
        QLog.i("OfficeCenterConfigLoader", 1, "failed: " + (String)localObject1);
        return;
      }
      finally {}
    }
    OfficeCenterSharedPref.a().a("officecenter_cfg", (String)localObject1);
    Object localObject4;
    Object localObject3;
    label213:
    String str1;
    Object localObject2;
    String str2;
    try
    {
      localObject4 = new JSONObject((String)localObject1);
      localObject3 = ((JSONObject)localObject4).optJSONObject("file_show_app_list");
      if (localObject3 != null) {
        break label963;
      }
      localObject3 = ((JSONObject)localObject4).optJSONObject("file");
      paramInt = 1;
      str1 = "";
      paramString = "";
      localObject2 = "";
      if (localObject3 != null)
      {
        str1 = ((JSONObject)localObject3).optString("hash");
        paramString = ((JSONObject)localObject3).optString("name");
        localObject2 = ((JSONObject)localObject3).optString("ver");
        this.c = ((JSONObject)localObject3).optString("key");
      }
      str2 = ((JSONObject)localObject4).optString("data_base_url");
      localObject5 = ((JSONObject)localObject4).optString("res_base_url");
      str3 = ((JSONObject)localObject4).optString("redirect_base_url");
      str4 = ((JSONObject)localObject4).optString("test_strategy");
      if (paramInt == 0) {
        break label507;
      }
      localObject3 = ((JSONObject)localObject4).optString("update_icon_ver");
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        String str3;
        String str4;
        paramQQAppInterface.printStackTrace();
        QLog.e("OfficeCenterConfigLoader", 2, "json exception, " + paramQQAppInterface.getMessage());
        return;
        localObject3 = ((JSONObject)localObject3).optString("update_icon_ver");
        continue;
        QLog.e("OfficeCenterConfigLoader", 1, "failed to get res base url");
      }
    }
    catch (MalformedURLException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        QLog.e("OfficeCenterConfigLoader", 2, "applite list url exception, " + paramQQAppInterface.getMessage());
        return;
        QLog.e("OfficeCenterConfigLoader", 1, "failed to get redirect base url");
      }
    }
    catch (IOException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("OfficeCenterConfigLoader", 2, "applite list io exception, " + paramQQAppInterface.getMessage());
      return;
    }
    OfficeCenterSharedPref.a().a("officecenter_test_strategy", str4);
    if (((String)localObject5).length() > 0)
    {
      OfficeCenterSharedPref.a().a("officecenter_res_base_url", (String)localObject5);
      if (str3.length() <= 0) {
        break label567;
      }
      OfficeCenterSharedPref.a().a("officecenter_redirect_base_url", str3);
      localObject4 = OfficeCenterSharedPref.a().a("officecenter_update_icon_ver", "");
      if ((localObject4 != null) && (((String)localObject4).length() != 0)) {
        break label614;
      }
      OfficeCenterSharedPref.a().a("officecenter_update_icon_ver", "0.0");
      OfficeCenterSharedPref.a().b("officecenter_update_icon_flag", true);
      label426:
      localObject3 = OfficeCenterSharedPref.a().a("officecenter_apps_list_txt", "");
      if ((localObject3 == null) || (((String)localObject3).equals("")) || (!this.b.equals(str1))) {
        break label646;
      }
      a(paramQQAppInterface, false);
    }
    label507:
    label567:
    label614:
    Object localObject5 = OfficeCenterSharedPref.a();
    if (((String)localObject3).compareTo((String)localObject4) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((OfficeCenterSharedPref)localObject5).b("officecenter_update_icon_flag", bool);
      break label426;
      label646:
      this.b = str1;
      str1 = OfficeCenterSharedPref.a().a("officecenter_apps_list_ver", "");
      if ((localObject3 != null) && (!((String)localObject3).equals("")) && (str1.length() > 0) && (str1.compareTo((String)localObject2) >= 0))
      {
        a(paramQQAppInterface, false);
        return;
      }
      if (((String)localObject2).length() > 0) {
        OfficeCenterSharedPref.a().a("officecenter_apps_list_ver", (String)localObject2);
      }
      localObject2 = "" + new Random().nextFloat() + System.currentTimeMillis();
      localObject2 = (HttpURLConnection)new URL(str2 + "/" + paramString + "?v=" + (String)localObject2).openConnection();
      ((HttpURLConnection)localObject2).connect();
      paramInt = ((HttpURLConnection)localObject2).getContentLength();
      if (paramInt <= 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("OfficeCenterConfigLoader", 2, "failed to download config file: " + (String)localObject1);
        return;
      }
      QLog.d("OfficeCenterConfigLoader", 1, "download successfully, size: " + paramInt);
      paramString = new ByteArrayOutputStream(paramInt);
      localObject1 = ((HttpURLConnection)localObject2).getInputStream();
      localObject2 = new byte['Ѐ'];
      for (;;)
      {
        paramInt = ((InputStream)localObject1).read((byte[])localObject2);
        if (paramInt <= 0)
        {
          paramString.flush();
          localObject1 = paramString.toByteArray();
          if (paramString != null) {
            paramString.close();
          }
          a(paramQQAppInterface, (byte[])localObject1);
          return;
        }
        paramString.write((byte[])localObject2, 0, paramInt);
        paramString.flush();
      }
      label963:
      paramInt = 0;
      break label213;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\data\OfficeCenterConfigLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
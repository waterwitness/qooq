package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yrp;

public class QzonePhotoWallPlugin
  extends QzoneInternalWebViewPlugin
{
  public static final String a = "QZImagePicker";
  private static final String b;
  public static final int f = 0;
  public static final int g = 2;
  public static final int h = 3;
  private byte jdField_a_of_type_Byte = 115;
  public int a;
  JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  int c = 0;
  int d = 3;
  int e = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = QzonePhotoWallPlugin.class.getSimpleName();
  }
  
  public QzonePhotoWallPlugin()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 4;
  }
  
  private double a(QzoneDynamicAlbumPlugin.Size paramSize)
  {
    if (paramSize != null)
    {
      int i = paramSize.jdField_a_of_type_Int;
      int j = paramSize.jdField_b_of_type_Int;
      int k;
      if (i < j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        paramSize = QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), k, j, this.e, false);
        double d3;
        if ((paramSize == null) || ((k <= paramSize.width) && (j <= paramSize.height)))
        {
          d3 = 0.0D;
          return d3;
        }
        double d1;
        if (k > j) {
          d1 = k / paramSize.width;
        }
        for (double d2 = j / paramSize.height;; d2 = k / paramSize.height)
        {
          d3 = d1;
          if (d1 > d2) {
            break;
          }
          return d2;
          d1 = j / paramSize.width;
        }
        k = i;
      }
    }
    return 0.0D;
  }
  
  private int a()
  {
    if (this.d > 1) {
      return 1;
    }
    return 2;
  }
  
  private int a(JSONObject paramJSONObject)
  {
    switch (paramJSONObject.optInt("compressType", 0))
    {
    default: 
      return 0;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.getInt("pickerType");
      this.d = paramString.getInt("maxPickCount");
      this.e = a(paramString);
      this.jdField_a_of_type_OrgJsonJSONObject = paramString.optJSONObject("userInfo");
      this.jdField_a_of_type_Boolean = paramString.optBoolean("clipByH5");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(ArrayList paramArrayList)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
        }
        localJSONObject.put("userInfo", this.jdField_a_of_type_OrgJsonJSONObject);
        if (paramArrayList != null) {
          continue;
        }
        i = 0;
        localJSONObject.put("totalPickCount", i);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZImagePickerJSInterface.doSelectPhoto(" + localJSONObject.toString() + ")");
      }
      catch (JSONException localJSONException)
      {
        int i;
        localJSONException.printStackTrace();
        continue;
      }
      ThreadManager.a(new yrp(this, paramArrayList), 8, null, false);
      return;
      i = paramArrayList.size();
    }
  }
  
  private void b(String paramString)
  {
    if ("MobileAlbum".equals(paramString))
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), PhotoListActivity.class);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("PhotoConst.MAXUM_SELECTED_NUM", this.d);
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", QQBrowserActivity.class.getName());
      ((Bundle)localObject).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      if (this.d > 1)
      {
        bool = false;
        ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
        ((Bundle)localObject).putBoolean("PhotoConst.IS_SINGLE_DERECTBACK_MODE", this.jdField_a_of_type_Boolean);
        paramString.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        ((Bundle)localObject).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        ((Bundle)localObject).putInt("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
        ((Bundle)localObject).putInt("uintype", 0);
        paramString.putExtras((Bundle)localObject);
        ((AbsBaseWebViewActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a()).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, paramString, this.jdField_a_of_type_Byte);
      }
    }
    while (!"QzoneAlbum".equals(paramString)) {
      for (;;)
      {
        return;
        boolean bool = true;
      }
    }
    paramString = new Bundle();
    paramString.putInt("key_personal_album_enter_model", a());
    paramString.putInt("_input_max", this.d);
    paramString.putBoolean("key_multiple_model_need_download_img", true);
    Object localObject = QZoneHelper.UserInfo.a();
    ((QZoneHelper.UserInfo)localObject).a = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getAccount();
    paramString.putString("keyAction", "actionSelectPicture");
    QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), (QZoneHelper.UserInfo)localObject, paramString, this.jdField_a_of_type_Byte);
  }
  
  private void b(ArrayList paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          String str = (String)paramArrayList.get(i);
          if (!TextUtils.isEmpty(str))
          {
            QzoneDynamicAlbumPlugin.Size localSize = QzoneDynamicAlbumPlugin.a(str);
            if (localSize != null)
            {
              if (this.e != 3)
              {
                double d1 = a(localSize);
                if (d1 > 0.0D)
                {
                  localSize.jdField_a_of_type_Int = ((int)(localSize.jdField_a_of_type_Int / d1));
                  localSize.jdField_b_of_type_Int = ((int)(localSize.jdField_b_of_type_Int / d1));
                }
              }
              str = QzoneDynamicAlbumPlugin.a(str, localSize.jdField_a_of_type_Int, localSize.jdField_b_of_type_Int);
              boolean bool = TextUtils.isEmpty(str);
              if (!bool) {
                try
                {
                  JSONObject localJSONObject = new JSONObject();
                  localJSONObject.put("currentIndex", i);
                  localJSONObject.put("data", "" + "data:image/jpg;base64," + str);
                  this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs("window.QZImagePickerJSInterface.onReceive(" + localJSONObject.toString() + ")");
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  QLog.e(jdField_b_of_type_JavaLangString, 1, "imageBase64 size=" + str.length() + ",compressType=" + this.e + ",width=" + localSize.jdField_a_of_type_Int + ",height=" + localSize.jdField_b_of_type_Int + "," + localOutOfMemoryError);
                  ToastUtil.a().a("内存不足，你可以清理内存后再试", 1);
                }
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramArrayList)
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "toBase64: " + paramArrayList);
      }
      i += 1;
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.a(paramIntent, paramByte, paramInt);
    if ((paramByte == this.jdField_a_of_type_Byte) && (paramInt == -1))
    {
      ArrayList localArrayList2 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      ArrayList localArrayList1;
      if (localArrayList2 != null)
      {
        localArrayList1 = localArrayList2;
        if (!localArrayList2.isEmpty()) {}
      }
      else
      {
        localArrayList2 = new ArrayList(1);
        paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        localArrayList1 = localArrayList2;
        if (!TextUtils.isEmpty(paramIntent))
        {
          localArrayList2.add(paramIntent);
          localArrayList1 = localArrayList2;
        }
      }
      a(localArrayList1);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("QZImagePicker")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!paramString3.equals("choosePhoto")) {
      return false;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      a(paramVarArgs[0]);
      if (this.c != 0) {
        break label73;
      }
      b("MobileAlbum");
    }
    for (;;)
    {
      return true;
      label73:
      b("QzoneAlbum");
    }
  }
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934600L) && (Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue() == this.jdField_a_of_type_Byte))
    {
      int i = Integer.valueOf(String.valueOf(paramMap.get("requestCode"))).intValue();
      Intent localIntent = (Intent)paramMap.get("data");
      int j = Integer.valueOf(String.valueOf(paramMap.get("resultCode"))).intValue();
      if ((i == this.jdField_a_of_type_Byte) && (j == -1))
      {
        if (a() != 1) {
          break label130;
        }
        paramString = localIntent.getStringArrayListExtra("key_cover_selected_img_path");
      }
      for (;;)
      {
        a(paramString);
        return true;
        label130:
        paramString = new ArrayList();
        paramMap = localIntent.getStringExtra("key_cover_selected_img_path");
        if (!TextUtils.isEmpty(paramMap)) {
          paramString.add(paramMap);
        }
      }
    }
    return super.a(paramString, paramLong, paramMap);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzonePhotoWallPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
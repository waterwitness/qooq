package com.tencent.open.appcommon.js;

import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.UpdateManager.OnCheckUpdateListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadInterface$JsCheckUpdateCallback
  implements UpdateManager.OnCheckUpdateListener
{
  protected String a;
  
  public DownloadInterface$JsCheckUpdateCallback(DownloadInterface paramDownloadInterface, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    LogUtility.e(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "JsCheckUpdateCallback onException >>> " + paramString);
    paramString = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.jdField_a_of_type_JavaLangString + "\"," + "\"r\":\"-1\"});}void(0);";
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramString);
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    LogUtility.a(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "JsCheckUpdateCallback onResult >>> " + paramArrayList.size());
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("packageName", localApkUpdateDetail.packageName);
        localJSONObject2.put("newapksize", localApkUpdateDetail.newapksize);
        localJSONObject2.put("patchsize", localApkUpdateDetail.patchsize);
        localJSONObject2.put("updatemethod", localApkUpdateDetail.updatemethod);
        localJSONObject2.put("versioncode", localApkUpdateDetail.versioncode);
        localJSONObject2.put("versionname", localApkUpdateDetail.versionname);
        localJSONObject2.put("fileMd5", localApkUpdateDetail.fileMd5);
        localJSONObject2.put("sigMd5", localApkUpdateDetail.sigMd5);
        localJSONObject2.put("url", localApkUpdateDetail.url);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("guid", this.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("content", localJSONArray.toString());
      localJSONObject1.put("resultCode", "0");
      paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'" + localJSONArray.toString() + "'});}void(0);";
    }
    catch (JSONException paramArrayList)
    {
      for (;;)
      {
        paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.jdField_a_of_type_JavaLangString + "\"," + "\"r\":\"-1\"});}void(0);";
      }
    }
    LogUtility.b(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, ">>checkUpdate jsUrl:" + paramArrayList);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramArrayList);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\js\DownloadInterface$JsCheckUpdateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
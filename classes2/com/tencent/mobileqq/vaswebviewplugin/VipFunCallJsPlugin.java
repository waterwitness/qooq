package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.vipav.VipFunCallPreviewActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class VipFunCallJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "funCall";
  public static final int DOWNLOAD_DONE = 3;
  public static final int DOWNLOAD_ERROR = -4;
  public static final int DOWNLOAD_PARAM_ERR = -2;
  public static final int DOWNLOAD_PROGRESS = 2;
  public static final int DOWNLOAD_START = 1;
  public static final String Tag = "VipFunCallJsPlugin";
  String SetFuncallCallBack;
  SparseIntArray down_bgprogress;
  SparseIntArray down_bgstatus;
  SparseIntArray down_progress;
  SparseIntArray down_ringProgress;
  SparseIntArray down_ringStatus;
  SparseIntArray down_status;
  
  public VipFunCallJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.SetFuncallCallBack = "";
    this.down_progress = new SparseIntArray();
    this.down_status = new SparseIntArray();
    this.down_bgprogress = new SparseIntArray();
    this.down_bgstatus = new SparseIntArray();
    this.down_ringProgress = new SparseIntArray();
    this.down_ringStatus = new SparseIntArray();
    this.mPluginNameSpace = "funCall";
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallJsPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected long getPluginBusiness()
  {
    return 2148007936L;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipFunCallJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"funCall".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    try
    {
      i = paramString1.indexOf("=");
      if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
        throw new Exception("Invalid Url Parameters");
      }
    }
    catch (JSONException paramJsBridgeListener)
    {
      QLog.e("VipFunCallJsPlugin", 1, "handleJsRequest, JSONException=" + paramJsBridgeListener.getMessage() + ", url=" + paramString1);
      for (;;)
      {
        return true;
        localObject3 = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "UTF-8"));
        if (!((JSONObject)localObject3).has("callback")) {
          break;
        }
        paramJsBridgeListener = ((JSONObject)localObject3).getString("callback");
        if (!((JSONObject)localObject3).has("callId")) {
          break label2295;
        }
        i = ((JSONObject)localObject3).getInt("callId");
        if (!((JSONObject)localObject3).has("ringId")) {
          break label2301;
        }
        j = ((JSONObject)localObject3).getInt("ringId");
        if (!((JSONObject)localObject3).has("feeType")) {
          break label2307;
        }
        k = ((JSONObject)localObject3).getInt("feeType");
        if (!((JSONObject)localObject3).has("mediaUrl")) {
          break label2313;
        }
        paramString2 = ((JSONObject)localObject3).getString("mediaUrl");
        if (!((JSONObject)localObject3).has("fuzzImageUrl")) {
          break label2319;
        }
        paramVarArgs = ((JSONObject)localObject3).getString("fuzzImageUrl");
        if (!((JSONObject)localObject3).has("imageUrl")) {
          break label2326;
        }
        localObject1 = ((JSONObject)localObject3).getString("imageUrl");
        if (!((JSONObject)localObject3).has("ringUrl")) {
          break label2333;
        }
        str = ((JSONObject)localObject3).getString("ringUrl");
        if (!((JSONObject)localObject3).has("thumbnailUrl")) {
          break label2340;
        }
        localObject2 = ((JSONObject)localObject3).getString("thumbnailUrl");
        if (!((JSONObject)localObject3).has("name")) {
          break label2347;
        }
        localObject3 = ((JSONObject)localObject3).getString("name");
        localBundle = new Bundle();
        localBundle.putInt("callId", i);
        localBundle.putInt("ringId", j);
        localBundle.putInt("feeType", k);
        localBundle.putString("url_Video", paramString2);
        localBundle.putString("url_Fuzz", paramVarArgs);
        localBundle.putString("url_Picture", (String)localObject1);
        localBundle.putString("url_Ring", str);
        localBundle.putString("url_call_thum", (String)localObject2);
        localBundle.putString("url_call_thum", (String)localObject2);
        localBundle.putString("name", (String)localObject3);
        if ((QLog.isColorLevel()) && (!"queryDownloadInfo".equals(paramString3))) {
          QLog.d("VipFunCallJsPlugin", 2, "handleJsRequest callid=" + i + ", ringid=" + j + ", feeType" + k + ", mediaUrl=" + paramString2 + ", fuzzImageUrl" + paramVarArgs + ", imageUrl=" + (String)localObject1 + ", ringUrl" + str);
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("code", 0);
        ((JSONObject)localObject1).put("errorMessage", paramString3 + " has done.");
        if (!"openPreview".equals(paramString3)) {
          break label780;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VipFunCallJsPlugin", 2, "openPreview ringId=" + j + ", callId=" + i);
        }
        paramString2 = this.mRuntime.a();
        paramString3 = new Intent(paramString2, VipFunCallPreviewActivity.class);
        paramString3.putExtra("key_to_uin", this.mRuntime.a().getAccount());
        paramString3.putExtra("callId", i);
        paramString3.putExtra("ringId", j);
        paramString3.putExtra("bundle", localBundle);
        paramString2.startActivity(paramString3);
        callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        int i;
        Object localObject3;
        int j;
        int k;
        Object localObject1;
        String str;
        Object localObject2;
        Bundle localBundle;
        QLog.e("VipFunCallJsPlugin", 1, "handleJsRequest, Exception=" + paramJsBridgeListener.getMessage() + ", url=" + paramString1);
        continue;
        paramJsBridgeListener = "";
        continue;
        label780:
        if ("setFunCallMedia".equals(paramString3))
        {
          this.SetFuncallCallBack = paramJsBridgeListener;
          localBundle.putInt("callId", i);
          localBundle.putInt("ringId", j);
          localBundle.putInt("feeType", k);
          sendRemoteReq(DataFactory.a("funcall_set", paramJsBridgeListener, this.mOnRemoteResp.key, localBundle), false, false);
        }
        else if ("downloadFunCallMedia".equals(paramString3))
        {
          paramString3 = ColorRingManager.a(j, 3);
          k = testResStatus(j, paramString3, this.down_ringStatus, this.down_ringProgress, "down_ring");
          if (QLog.isColorLevel()) {
            QLog.d("VipFunCallJsPlugin", 2, "startDownload, ringPath=" + paramString3 + ", ringId=" + j + ", ringUrl in=" + str + ", resStatus:" + k);
          }
          paramString3 = VipFunCallManager.a(null, i, VipFunCallManager.a(), paramString2);
          j = testResStatus(i, paramString3, this.down_status, this.down_progress, "down_fcVideo");
          if (QLog.isColorLevel()) {
            QLog.d("VipFunCallJsPlugin", 2, "startDownload, mediaUrl=" + paramString2 + ", fcPath=" + paramString3 + ", callId=" + i + ", resStatus:" + j);
          }
          if (TextUtils.isEmpty(paramString3))
          {
            QLog.e("VipFunCallJsPlugin", 1, "startDownload queryDownloadInfo no mediaUrl , fcPath=null.");
            ((JSONObject)localObject1).put("code", VipFunCallManager.l);
            ((JSONObject)localObject1).put("errorMessage", "no mediaUrl , fcPath=null");
            callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
            return true;
          }
          paramString2 = VipFunCallManager.a(null, i, 9, paramVarArgs);
          j = testResStatus(i, paramString2, this.down_bgstatus, this.down_bgprogress, "down_fuzzpic");
          if (QLog.isColorLevel()) {
            QLog.d("VipFunCallJsPlugin", 2, "startDownload, fuzzUrl=" + paramVarArgs + ", fuzzPath=" + paramString2 + ", callId=" + i + ", resStatus:" + j);
          }
          if (!Utils.b())
          {
            QLog.e("VipFunCallJsPlugin", 1, "startDownload SDCard not available.");
            ((JSONObject)localObject1).put("code", VipFunCallManager.n);
            ((JSONObject)localObject1).put("errorMessage", "no sdcard");
            callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
            return true;
          }
          long l = Utils.b();
          if (l < 1048576)
          {
            QLog.e("VipFunCallJsPlugin", 1, "startDownload Insufficient SDCard space, required: reserved:" + 1048576 + "|available:" + l);
            ((JSONObject)localObject1).put("code", VipFunCallManager.m);
            ((JSONObject)localObject1).put("errorMessage", "SDCard is full");
            callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
            return true;
          }
          sendRemoteReq(DataFactory.a("funcall_download", paramJsBridgeListener, this.mOnRemoteResp.key, localBundle), false, false);
          ((JSONObject)localObject1).put("errorMessage", "id is downloading");
          callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
        }
        else
        {
          if ("queryDownloadInfo".equals(paramString3))
          {
            localObject2 = new JSONObject();
            if (this.down_status.get(i) <= 0)
            {
              localObject3 = VipFunCallManager.a(null, i, VipFunCallManager.a(), paramString2);
              k = testResStatus(i, (String)localObject3, this.down_status, this.down_progress, "query_fcVideo");
              if (QLog.isColorLevel()) {
                QLog.d("VipFunCallJsPlugin", 2, "queryDownloadInfo video, mediaUrl=" + paramString2 + ", fcPath=" + (String)localObject3 + ", callId=" + i + ", resStatus:" + k);
              }
              if (TextUtils.isEmpty((CharSequence)localObject3))
              {
                QLog.e("VipFunCallJsPlugin", 1, "queryDownloadInfo Error no mediaUrl , fcPath=null.");
                ((JSONObject)localObject1).put("code", VipFunCallManager.l);
                ((JSONObject)localObject1).put("errorMessage", paramString3 + " no mediaUrl , fcPath=null");
                callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
                return true;
              }
            }
            if (this.down_bgstatus.get(i) <= 0)
            {
              paramString2 = VipFunCallManager.a(null, i, 9, paramVarArgs);
              k = testResStatus(i, paramString2, this.down_bgstatus, this.down_bgprogress, "query_fuzzpic");
              if (QLog.isColorLevel()) {
                QLog.d("VipFunCallJsPlugin", 2, "queryDownloadInfo bg, fuzzUrl=" + paramVarArgs + ", fuzzPath=" + paramString2 + ", callId=" + i + ", resStatus:" + k);
              }
            }
            if (this.down_ringStatus.get(j) <= 0)
            {
              paramString2 = ColorRingManager.a(j, 3);
              k = testResStatus(j, paramString2, this.down_ringStatus, this.down_ringProgress, "query_ring");
              if (QLog.isColorLevel()) {
                QLog.d("VipFunCallJsPlugin", 2, "queryDownloadInfo ring, ringPath=" + paramString2 + ", ringId=" + j + ", ringUrl=" + str + ", resStatus:" + k + ", callId=" + i);
              }
            }
            if ((this.down_status.get(i) == 1) && (this.down_bgstatus.get(i) == 1) && (this.down_ringStatus.get(j) == 1))
            {
              ((JSONObject)localObject2).put("status", 1);
              ((JSONObject)localObject2).put("onProgress", 0);
              if (QLog.isColorLevel()) {
                QLog.d("VipFunCallJsPlugin", 2, "queryDownloadInfo DOWNLOAD_START, ringId=" + j + ", callId=" + i);
              }
            }
            for (;;)
            {
              ((JSONObject)localObject1).put("data", localObject2);
              callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
              break;
              if ((this.down_status.get(i) == 3) && (this.down_bgstatus.get(i) == 3) && (this.down_ringStatus.get(j) == 3))
              {
                ((JSONObject)localObject2).put("status", 3);
                ((JSONObject)localObject2).put("onProgress", 100);
                if (QLog.isColorLevel()) {
                  QLog.d("VipFunCallJsPlugin", 2, "queryDownloadInfo DOWNLOAD_DONE, ringId=" + j + ", callId=" + i);
                }
              }
              else
              {
                i = (this.down_progress.get(i) * 6 + this.down_bgprogress.get(i) * 1 + this.down_ringProgress.get(j) * 3) / 10;
                ((JSONObject)localObject2).put("status", 2);
                ((JSONObject)localObject2).put("onProgress", i);
              }
            }
          }
          if ("delFunCallGroup".equals(paramString3))
          {
            this.SetFuncallCallBack = paramJsBridgeListener;
            if (QLog.isColorLevel()) {
              QLog.d("VipFunCallJsPlugin", 2, "handleJsRequest delFunCallGroup, url=" + paramString1);
            }
            sendRemoteReq(DataFactory.a("funcall_delete", paramJsBridgeListener, this.mOnRemoteResp.key, localBundle), false, false);
          }
          else
          {
            QLog.e("VipFunCallJsPlugin", 1, "handleJsRequest, url=" + paramString1);
            ((JSONObject)localObject1).put("code", -1);
            ((JSONObject)localObject1).put("errorMessage", paramString3 + " is Error method.");
            callJs(paramJsBridgeListener, new String[] { ((JSONObject)localObject1).toString() });
            continue;
            label2295:
            i = 0;
            continue;
            label2301:
            j = 0;
            continue;
            label2307:
            k = 1;
            continue;
            label2313:
            paramString2 = "";
            continue;
            label2319:
            paramVarArgs = "";
            continue;
            label2326:
            localObject1 = "";
            continue;
            label2333:
            str = "";
            continue;
            label2340:
            localObject2 = "";
            continue;
            label2347:
            localObject3 = "";
          }
        }
      }
    }
  }
  
  public void onPushMsg(Bundle paramBundle)
  {
    if (paramBundle != null) {
      for (;;)
      {
        String str;
        int j;
        SparseIntArray localSparseIntArray2;
        SparseIntArray localSparseIntArray1;
        try
        {
          str = paramBundle.getString("callbackId");
          i = paramBundle.getInt("srcType");
          if (i != 6) {
            break label526;
          }
          j = paramBundle.getInt("resourceType");
          localSparseIntArray2 = null;
          localSparseIntArray1 = null;
          if (j == 6)
          {
            localSparseIntArray2 = this.down_progress;
            localSparseIntArray1 = this.down_status;
            break label703;
            QLog.e("VipFunCallJsPlugin", 1, "onPushMsg Error0: resourceType=" + j);
          }
          else if (j == 9)
          {
            localSparseIntArray2 = this.down_bgprogress;
            localSparseIntArray1 = this.down_bgstatus;
          }
          else if (j == 3)
          {
            localSparseIntArray2 = this.down_ringProgress;
            localSparseIntArray1 = this.down_ringStatus;
          }
          else if (j == 7)
          {
            QLog.d("VipFunCallJsPlugin", 1, "onPushMsg resourceType = TYPE_PICTURE:" + j);
            localSparseIntArray2 = this.down_progress;
            localSparseIntArray1 = this.down_status;
          }
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          return;
        }
        int k = paramBundle.getInt("fcStatus");
        int m = paramBundle.getInt("callId");
        if (2 == k)
        {
          localSparseIntArray2.put(m, paramBundle.getInt("progress"));
          localSparseIntArray1.put(m, 2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("VipFunCallJsPlugin", 2, "onProgress, id=" + m + ",srcType=" + i + ",resourceType=" + j + ",progress=" + localSparseIntArray2.get(m));
          return;
        }
        if (3 == k)
        {
          boolean bool = paramBundle.getBoolean("result_boo", true);
          if (QLog.isColorLevel()) {
            QLog.d("VipFunCallJsPlugin", 2, "onDone, id=" + m + ",srcType=" + i + ",resourceType=" + j + ",result=" + bool);
          }
          if (bool)
          {
            localSparseIntArray2.put(m, 100);
            localSparseIntArray1.put(m, 3);
            if (TextUtils.isEmpty(str)) {
              break;
            }
            super.callJs(str, new String[] { "{'result':0, 'message':'OK'}" });
            return;
          }
          localSparseIntArray2.put(m, 100);
          localSparseIntArray1.put(m, -4);
          if (TextUtils.isEmpty(str)) {
            break;
          }
          super.callJs(str, new String[] { "{'result':-4, 'message':'download Error'}" });
          return;
        }
        if ((1 != k) || (!QLog.isColorLevel())) {
          break;
        }
        QLog.d("VipFunCallJsPlugin", 2, "onStart, id=" + m + ",srcType=" + i + ",resourceType=" + j);
        return;
        label526:
        if (i != 7) {
          break;
        }
        int i = paramBundle.getInt("isSuccess");
        if (QLog.isColorLevel()) {
          QLog.d("VipFunCallJsPlugin", 2, "setMedia, result=" + i);
        }
        paramBundle = new JSONObject();
        if (i == 0) {}
        for (;;)
        {
          try
          {
            paramBundle.put("code", i);
            paramBundle.put("errorMessage", "sucess");
            if (!TextUtils.isEmpty(str)) {
              QLog.d("VipFunCallJsPlugin", 2, "setMedia, callbackId=" + str + ", sid=" + this.SetFuncallCallBack);
            }
            callJs(this.SetFuncallCallBack, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          paramBundle.put("code", i);
          paramBundle.put("errorMessage", "set funcall err");
        }
        label703:
        if (localSparseIntArray2 != null) {
          if (localSparseIntArray1 != null) {}
        }
      }
    }
  }
  
  int testResStatus(int paramInt, String paramString1, SparseIntArray paramSparseIntArray1, SparseIntArray paramSparseIntArray2, String paramString2)
  {
    int i = 3;
    if (TextUtils.isEmpty(paramString1))
    {
      paramSparseIntArray2.put(paramInt, 100);
      paramSparseIntArray1.put(paramInt, 3);
      int j = -2;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("VipFunCallJsPlugin", 1, "testResStatus path isEmpty, id=" + paramInt + ", path=" + paramString1 + ", from=" + paramString2 + ", local=" + -2);
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallJsPlugin", 2, "testResStatus, id=" + paramInt + ", path=" + paramString1 + ", from=" + paramString2 + ", local=" + i);
      }
      return i;
      File localFile = new File(paramString1);
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramSparseIntArray2.put(paramInt, 100);
        paramSparseIntArray1.put(paramInt, 3);
      }
      else
      {
        paramSparseIntArray2.put(paramInt, 0);
        paramSparseIntArray1.put(paramInt, 1);
        i = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VipFunCallJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

class ThemeDIYActivity$1
  implements Runnable
{
  ThemeDIYActivity$1(ThemeDIYActivity paramThemeDIYActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 10;
    Object localObject1 = ClubContentJsonTask.a(this.this$0.app, ClubContentJsonTask.h, false);
    if (localObject1 == null) {
      if (this.val$isInitLoad)
      {
        localObject1 = new File(this.this$0.mContext.getFilesDir(), ClubContentJsonTask.h.b);
        localObject1 = new DownloadTask(ClubContentJsonTask.h.c, (File)localObject1);
        ((DownloadTask)localObject1).l = true;
        ((DownloadTask)localObject1).b = true;
        ((DownloadTask)localObject1).a = ClubContentJsonTask.h.c;
        ((DownloaderFactory)this.this$0.app.getManager(46)).a(1).a((DownloadTask)localObject1, this.this$0.resDownloadListener, ThemeDIYActivity.getLoadParam(2, 0, 0));
      }
    }
    label383:
    Object localObject4;
    do
    {
      try
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_key", ClubContentJsonTask.h.b);
        ((HashMap)localObject1).put("param_ifromet", "inApp");
        StatisticCollector.a(this.this$0.app.getApplication().getApplicationContext()).a(this.this$0.app.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, (HashMap)localObject1, "", false);
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ThemeDIYActivity", 1, "downloadFile, loadResJson error=" + localException1.toString());
        return;
      }
      QLog.e("ThemeDIYActivity", 1, "loadResJson: null == resJson");
      return;
      try
      {
        JSONObject localJSONObject = localException1.getJSONObject("data");
        if ((!this.val$isInitLoad) && (localJSONObject.has("timeStamp")))
        {
          localObject3 = localJSONObject.getString("timeStamp");
          if (((String)localObject3).length() < 10) {
            break label383;
          }
        }
        for (;;)
        {
          localObject3 = ((String)localObject3).substring(0, i);
          ClubContentJsonTask.a(this.this$0.mContext, ClubContentJsonTask.h.e, Integer.valueOf((String)localObject3).intValue());
          localObject3 = localJSONObject.getJSONArray("bgList");
          i = 0;
          if (i >= ((JSONArray)localObject3).length()) {
            break label512;
          }
          if ((!((JSONArray)localObject3).getJSONObject(i).getJSONObject("data").getJSONArray("diyThemeBg").getJSONObject(0).has("valid")) || (((JSONArray)localObject3).getJSONObject(i).getJSONObject("data").getJSONArray("diyThemeBg").getJSONObject(0).getInt("valid") != 0)) {
            break;
          }
          break label1010;
          i = ((String)localObject3).length();
        }
        localObject4 = new ResItemHolder(0, 2, ((JSONArray)localObject3).getJSONObject(i));
        ((ResItemHolder)localObject4).decodeJson(((JSONArray)localObject3).getJSONObject(i));
        ((ResItemHolder)localObject4).index = this.this$0.bgAdapter.mData.size();
        this.this$0.bgAdapter.mData.add(localObject4);
        if ((!this.this$0.isDIYThemeBefore) || (this.this$0.bgAdapter.resUsedID != ((ResItemHolder)localObject4).id)) {
          break label1010;
        }
        this.this$0.bgAdapter.resTryOnPosition = ((ResItemHolder)localObject4).index;
      }
      catch (Exception localException2) {}
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDIYActivity", 2, localException2.getMessage());
    return;
    label512:
    label525:
    int j;
    if (this.this$0.isDIYThemeBefore)
    {
      i = 0;
      if (i < this.this$0.showData.length)
      {
        j = 2;
        label541:
        if (j >= this.this$0.bgAdapter.mData.size()) {
          break label1019;
        }
        if (this.this$0.showData[i].intoDiyPic.id != ((ResItemHolder)this.this$0.bgAdapter.mData.get(j)).id) {
          break label1028;
        }
        this.this$0.showData[i].bgTryOnPosition = j;
        break label1019;
      }
    }
    Object localObject3 = localException2.getJSONArray("styleList");
    i = 0;
    label628:
    Object localObject2;
    if (i < ((JSONArray)localObject3).length())
    {
      localObject4 = ((JSONArray)localObject3).getJSONObject(i).getJSONObject("data").getJSONArray("operateAndroid");
      localObject2 = ((JSONArray)localObject3).getJSONObject(i).getJSONObject("data").getJSONArray("baseInfo").getJSONObject(0);
      if ((((JSONObject)localObject2).has("status")) && (((JSONObject)localObject2).getInt("status") == 0)) {
        break label1037;
      }
      j = ((JSONArray)localObject4).length() - 1;
    }
    for (;;)
    {
      if (j >= 0)
      {
        localObject2 = ((JSONArray)localObject4).getJSONObject(j);
        if ((this.this$0.compareVersion("6.5.5", ((JSONObject)localObject2).getString("minVersion")) > 0) || (this.this$0.compareVersion("6.5.5", ((JSONObject)localObject2).getString("maxVersion")) < 0)) {
          break label1046;
        }
        ResItemHolder localResItemHolder = new ResItemHolder(1, 2, ((JSONArray)localObject3).getJSONObject(i));
        localResItemHolder.themeJson = ((JSONObject)localObject2);
        localResItemHolder.index = this.this$0.themeAdapter.mData.size();
        localResItemHolder.decodeJson(((JSONArray)localObject3).getJSONObject(i));
        this.this$0.themeAdapter.mData.add(localResItemHolder);
        if ((!this.this$0.isDIYThemeBefore) || (this.this$0.themeAdapter.resUsedID != localResItemHolder.id)) {
          break label1046;
        }
        this.this$0.themeAdapter.selectResItem = localResItemHolder;
        this.this$0.themeAdapter.resTryOnPosition = localResItemHolder.index;
        int k = 0;
        if (k >= this.this$0.showData.length) {
          break label1046;
        }
        if (k == 0) {
          localObject2 = localResItemHolder.screen0ResData;
        }
        for (;;)
        {
          this.this$0.showData[k].screenShot = ((ResData)localObject2);
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 23, Integer.valueOf(k)));
          k += 1;
          break;
          if (k == 1) {
            localObject2 = localResItemHolder.screen1ResData;
          } else {
            localObject2 = localResItemHolder.screen2ResData;
          }
        }
        this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 21, null));
        return;
        label1010:
        i += 1;
        break;
        label1019:
        i += 1;
        break label525;
        label1028:
        j += 1;
        break label541;
      }
      label1037:
      i += 1;
      break label628;
      label1046:
      j -= 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
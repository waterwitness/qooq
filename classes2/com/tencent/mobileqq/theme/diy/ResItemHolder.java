package com.tencent.mobileqq.theme.diy;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResItemHolder
{
  static final int ITEM_TYPE_LOCAL = 0;
  static final int ITEM_TYPE_NET = 2;
  static final int RES_TYPE_BG = 0;
  static final int RES_TYPE_THEME = 1;
  static final String TAG = "ResItemHolder";
  String appName;
  View convertView;
  int id;
  int index;
  int itemType;
  String pageUrl;
  ResData previewResData;
  String resFileName;
  JSONObject resJson;
  String resThumName;
  int resType;
  ResData screen0ResData;
  ResData screen1ResData;
  ResData screen2ResData;
  ThemeUtil.ThemeInfo themeInfo;
  JSONObject themeJson;
  ResData thumResData;
  
  public ResItemHolder(int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.resType = paramInt1;
    this.itemType = paramInt2;
    this.resJson = paramJSONObject;
  }
  
  void decodeJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      try
      {
        this.appName = paramJSONObject.getString("app");
        this.id = paramJSONObject.getInt("id");
        this.pageUrl = ("http://i.gtimg.cn/qqshow/admindata/comdata/" + this.appName + "/");
        if (this.resType != 0) {
          break;
        }
        this.resThumName = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg").getJSONObject(0).getString("thumbnail");
        this.resFileName = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg").getJSONObject(0).getString("aioImg");
        paramJSONObject = paramJSONObject.getJSONObject("data").getJSONArray("diyThemeBg").getJSONObject(0).getString("previewImg");
        this.thumResData = new ResData(this.resThumName, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_BG, this.pageUrl + this.resThumName, 0, 0, 4, 0);
        this.previewResData = new ResData(paramJSONObject, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_BG, this.pageUrl + paramJSONObject, 0, 0, 1, 0);
        this.previewResData.name = ThemeDiyStyleLogic.getPreviewBgFileName(this.previewResData);
        return;
      }
      catch (Exception paramJSONObject) {}
    } while (!QLog.isColorLevel());
    QLog.e("ResItemHolder", 2, "DoBrightnessTask1 " + paramJSONObject.getMessage());
    return;
    this.resThumName = paramJSONObject.getJSONObject("data").getJSONArray("baseInfo").getJSONObject(0).getString("image");
    this.thumResData = new ResData(this.resThumName, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_THEME + this.id + "/", this.pageUrl + this.resThumName, 0, 0, 4, 0);
    String str = paramJSONObject.getJSONObject("data").getJSONArray("baseInfo").getJSONObject(0).getString("setFrontImg");
    this.screen0ResData = new ResData(str, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_THEME, this.pageUrl + str, 0, 0, 2, 0);
    str = paramJSONObject.getJSONObject("data").getJSONArray("baseInfo").getJSONObject(0).getString("msgFrontImg");
    this.screen1ResData = new ResData(str, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_THEME, this.pageUrl + str, 0, 0, 2, 0);
    paramJSONObject = paramJSONObject.getJSONObject("data").getJSONArray("baseInfo").getJSONObject(0).getString("chatFrontImg");
    this.screen2ResData = new ResData(paramJSONObject, this.id, this.index, ThemeDiyStyleLogic.DIR_SCREENSHOT_THEME, this.pageUrl + paramJSONObject, 0, 0, 2, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ResItemHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
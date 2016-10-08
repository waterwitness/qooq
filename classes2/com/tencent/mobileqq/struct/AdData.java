package com.tencent.mobileqq.struct;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class AdData
  implements Serializable, Comparable
{
  public static final int UI_PICTURE = 2;
  public static final int UI_PICTURE_and_TEXT = 3;
  public String actionData;
  public int ad_source;
  public String avatarBgGif;
  public int bgColor;
  public String content;
  public String content2;
  public String contentColor;
  public String distance;
  public String expose_url;
  public int fontColor;
  public String hasAvatarAnimation;
  public boolean hasShow;
  public long id;
  public int idType;
  public String img_url;
  public String jump_url;
  public String logo_url;
  public String nowBoardcastGif;
  public String nowBoardcastWording;
  public int picType;
  public int position;
  public String title;
  public int typeUI;
  public String wording;
  
  public AdData()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.picType = 1;
  }
  
  public static String getWording(int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    switch (paramInt)
    {
    default: 
      paramString = BaseApplicationImpl.getContext().getString(2131364992);
    }
    for (;;)
    {
      return paramString;
      paramString = BaseApplicationImpl.getContext().getString(2131371679);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131367546);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131371999);
      continue;
      paramString = BaseApplicationImpl.getContext().getString(2131371458);
    }
  }
  
  public static int parseAdColor(int paramInt, boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i;
    if (paramString == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        try
        {
          i = Integer.parseInt(paramString, 16);
          i |= 0xFF000000;
          j = 1;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            label33:
            i = -1;
          }
        }
        if (j == 0) {
          break label105;
        }
      }
      String str;
      label105:
      while (!paramBoolean)
      {
        return i;
        str = paramString;
        if (paramString.startsWith("#")) {
          str = paramString.replace("#", "");
        }
        if (str.length() <= 6) {
          break label163;
        }
        paramString = str.substring(str.length() - 6, str.length());
        i = 1;
        break;
        i = -1;
        break label33;
      }
      switch (paramInt)
      {
      default: 
        return i;
      case 0: 
        return -33153;
      case 1: 
        return 42312;
      case 2: 
        return -10249473;
      case 3: 
        return -627103;
      }
      return -35755;
      label163:
      i = 1;
      paramString = str;
    }
  }
  
  public static final void reportTValue(AppInterface paramAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    switch (paramInt2)
    {
    case 6: 
    case 7: 
    default: 
      str = null;
      if (str == null) {
        return;
      }
      break;
    case 0: 
      if (paramBoolean) {}
      for (str = "0X8005B64";; str = "0X8005B65") {
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (str = "0X8005684";; str = "0X8005685") {
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (str = "0X8005682";; str = "0X8005683") {
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (str = "0X8005680";; str = "0X8005681") {
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (str = "0X800567E";; str = "0X800567F") {
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (str = "0X8005ADA";; str = "0X8005ADB") {
        break;
      }
    case 8: 
      if (paramBoolean) {}
      for (str = "0X800621F";; str = "0X8006220") {
        break;
      }
    case 9: 
      if (paramBoolean) {}
      for (str = "0X8006833";; str = "0X8006834") {
        break;
      }
    }
    paramAppInterface.a("CliOper", "", "", str, str, 0, 0, Integer.toString(paramInt1), "", "", "");
  }
  
  public int compareTo(AdData paramAdData)
  {
    if (this.position > paramAdData.position) {
      return 1;
    }
    if (this.position == paramAdData.position) {
      return 0;
    }
    return -1;
  }
  
  public boolean parseJson(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      String str = paramString;
      if (paramString.endsWith(",}"))
      {
        paramString = paramString.substring(0, paramString.length() - 2);
        str = paramString + "}";
      }
      try
      {
        paramString = new JSONObject(str);
        this.title = paramString.optString("title");
        this.content = paramString.optString("content");
        this.content2 = paramString.optString("content2");
        this.typeUI = paramString.optInt("type");
        this.img_url = paramString.optString("img_url");
        if (this.img_url != null) {
          this.img_url = this.img_url.trim();
        }
        this.jump_url = paramString.optString("jump_url");
        this.actionData = paramString.optString("actionData");
        this.expose_url = paramString.optString("expose_url");
        str = paramString.optString("bg_color");
        this.bgColor = parseAdColor(this.ad_source, true, str);
        str = paramString.optString("font_color");
        this.fontColor = parseAdColor(this.ad_source, false, str);
        str = paramString.optString("corner_wording");
        this.wording = getWording(this.ad_source, str);
        this.distance = paramString.optString("distance");
        this.id = paramString.optLong("id");
        this.idType = paramString.optInt("id_type");
        if (paramString.has("pic_type")) {
          this.picType = paramString.optInt("pic_type");
        }
        this.logo_url = paramString.optString("logo_url");
        if (paramString.has("content_color")) {
          this.contentColor = paramString.optString("content_color");
        }
        if (paramString.has("content_color")) {
          this.hasAvatarAnimation = paramString.optString("hasAvatarAnimation");
        }
        if (paramString.has("content_color")) {
          this.avatarBgGif = paramString.optString("avatarBgGif");
        }
        if (paramString.has("content_color")) {
          this.nowBoardcastWording = paramString.optString("nowBoardcastWording");
        }
        if (paramString.has("content_color")) {
          this.nowBoardcastGif = paramString.optString("nowBoardcastGif");
        }
        if ((this.img_url == null) || (!this.img_url.startsWith("http"))) {
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w(AdData.class.getSimpleName(), 2, paramString.getMessage());
        }
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\struct\AdData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
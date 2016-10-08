package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import rbs;

public class MessageForNearbyMarketGrayTips
  extends ChatMessage
{
  public static final int ACTION_AUTO_INPUT = 3;
  public static final int ACTION_DEFAULT = 0;
  public static final int ACTION_JUMP_NATIVE = 2;
  public static final int ACTION_JUMP_WEB = 1;
  private static final String NAME_CONTENT = "content";
  private static final String NAME_HIGHTLIGHT = "high_light";
  private static final String NAME_ID = "id";
  private static final String NAME_LINK = "link";
  private static final String NAME_SCENE = "scene";
  public static final int SCENE_AIO = 8;
  public static final int SCENE_DEFAULT = 0;
  public static final int SCENE_KEYWORD = 4;
  public static final int SCENE_SAY_HI = 1;
  public static final int SCENE_SAY_HI_FREQ = 2;
  public static final String TAG = MessageForNearbyMarketGrayTips.class.getSimpleName();
  private String mContent;
  private String mHighLight;
  private int mId;
  private String mLink;
  private int mScene;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String makeGrayTipMsg(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("content", paramString1);
      localJSONObject.put("high_light", paramString2);
      localJSONObject.put("scene", paramInt2);
      localJSONObject.put("link", paramString3);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected void doParse()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(TAG, 4, "doParse: " + this.msg);
    }
    String str = this.msg;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        this.mId = localJSONObject.getInt("id");
        this.mContent = localJSONObject.getString("content");
        if (localJSONObject.has("high_light"))
        {
          this.mHighLight = localJSONObject.getString("high_light");
          if (localJSONObject.has("scene"))
          {
            this.mScene = localJSONObject.getInt("scene");
            if (!localJSONObject.has("link")) {
              break;
            }
            this.mLink = localJSONObject.getString("link");
          }
        }
        else
        {
          this.mHighLight = null;
          continue;
        }
        this.mScene = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.mContent = str;
        this.mHighLight = null;
        this.mScene = 0;
        this.mLink = null;
        return;
      }
    }
    this.mLink = null;
  }
  
  public SpannableString getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((!TextUtils.isEmpty(this.mContent)) && (!TextUtils.isEmpty(this.mHighLight))) {}
    for (int j = this.mContent.indexOf(this.mHighLight);; j = -1)
    {
      if (j >= 0) {}
      for (int k = this.mHighLight.length() + j;; k = 0)
      {
        SpannableString localSpannableString = new SpannableString(this.mContent);
        int i;
        if ((j >= 0) && (k > j)) {
          switch (this.mScene)
          {
          case 3: 
          case 5: 
          case 6: 
          case 7: 
          default: 
            i = 0;
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new rbs(paramQQAppInterface, paramContext, this.mId, Color.rgb(26, 144, 240), i, this.mLink, this.mScene, this), j, k, 33);
          return localSpannableString;
          if (TextUtils.isEmpty(this.mLink)) {
            break;
          }
          if (this.mLink.startsWith("mqqapi://"))
          {
            i = 2;
          }
          else
          {
            i = 1;
            continue;
            i = 3;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForNearbyMarketGrayTips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
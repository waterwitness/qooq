package cooperation.qzone.webviewplugin.ugcsetting;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class UgcSettingUtil
{
  public static final int a = 1;
  public static final String a = "permission_code";
  public static final int b = 4;
  public static final String b = "uin_list";
  public static final int c = 16;
  public static final String c = "key_nicknames";
  public static final int d = 64;
  public static final String d = "key_selected_tag";
  public static final int e = 128;
  public static final String e = "key_question";
  public static final int f = 512;
  public static final String f = "key_answer";
  public static final int g = 9999;
  public static final String g = "key_parse_json_status";
  private static final int h = 0;
  public static final String h = "key_setting_raw_json";
  private static final int i = 1;
  private static final int j = 2;
  private static final int k = 3;
  private static final int l = 4;
  private static final int m = 5;
  private static final int n = 6;
  
  public UgcSettingUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    try
    {
      paramString = new JSONObject(paramString);
      i1 = paramString.getInt("id");
      switch (i1)
      {
      case 1: 
        localBundle.putInt("permission_code", 1);
      }
    }
    catch (Exception paramBundle)
    {
      label90:
      Iterator localIterator;
      localBundle.putInt("permission_code", 1);
      localBundle.putString("key_parse_json_status", paramBundle.getMessage());
      paramBundle.printStackTrace();
    }
    paramBundle = "";
    if (paramString.has("msg")) {
      paramBundle = paramString.optString("msg");
    }
    localBundle.putString("key_selected_tag", paramBundle);
    paramBundle = new StringBuilder();
    if (i1 == 4) {
      paramBundle.append("除了 ");
    }
    paramString = paramString.getJSONObject("uinList");
    Object localObject = new ArrayList();
    localIterator = paramString.keys();
    for (int i1 = 1;; i1 = 0)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((ArrayList)localObject).add(str);
        if (i1 == 0) {
          paramBundle.append("、");
        }
        if (paramBundle.length() >= 15) {
          continue;
        }
        paramBundle.append(paramString.getString(str));
        continue;
        localBundle.putInt("permission_code", 4);
      }
      label406:
      do
      {
        return localBundle;
        localBundle.putInt("permission_code", 64);
        break label406;
        localBundle.putInt("permission_code", 16);
        break label406;
        localBundle.putInt("permission_code", 128);
        break label406;
        localBundle.putInt("permission_code", 9999);
        paramBundle = paramString.optString("question");
        localObject = paramString.optString("answer");
        localBundle.putString("key_question", paramBundle);
        localBundle.putString("key_answer", (String)localObject);
        break label406;
        localBundle.putInt("permission_code", 512);
        break label406;
        paramString = paramBundle.toString();
        paramBundle = paramString;
        if (paramString.length() > 15) {
          paramBundle = paramString.substring(0, 15) + "...";
        }
        localBundle.putStringArrayList("uin_list", (ArrayList)localObject);
        localBundle.putString("key_nicknames", paramBundle);
        return localBundle;
        break;
        if (i1 == 3) {
          break label90;
        }
      } while (i1 != 4);
      break label90;
    }
  }
  
  public static String a(Bundle paramBundle)
  {
    int i1 = 1;
    int i2 = 0;
    if (paramBundle == null) {
      return "";
    }
    Object localObject = paramBundle.getString("key_setting_raw_json");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return (String)localObject;
    }
    switch (paramBundle.getInt("permission_code", 1))
    {
    default: 
      i1 = 0;
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", i1);
        if ((i1 == 3) || (i1 == 4))
        {
          ArrayList localArrayList = paramBundle.getStringArrayList("uin_list");
          paramBundle = paramBundle.getStringArrayList("key_nicknames");
          if ((localArrayList == null) || (localArrayList.isEmpty())) {
            return ((JSONObject)localObject).toString();
          }
          if ((paramBundle == null) || (paramBundle.size() != localArrayList.size())) {
            return ((JSONObject)localObject).toString();
          }
          JSONObject localJSONObject = new JSONObject();
          int i3 = localArrayList.size();
          i1 = i2;
          while (i1 < i3)
          {
            localJSONObject.put((String)localArrayList.get(i1), paramBundle.get(i1));
            i1 += 1;
          }
          ((JSONObject)localObject).put("uinList", localJSONObject);
        }
        for (;;)
        {
          return ((JSONObject)localObject).toString();
          if (i1 == 5)
          {
            ((JSONObject)localObject).put("question", paramBundle.getString("key_question"));
            ((JSONObject)localObject).put("answer", paramBundle.getString("key_answer"));
          }
        }
        i1 = 0;
      }
      catch (Exception paramBundle)
      {
        return "";
      }
      continue;
      i1 = 2;
      continue;
      i1 = 5;
      continue;
      i1 = 3;
      continue;
      i1 = 4;
      continue;
      i1 = 6;
    }
  }
  
  public static Bundle b(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localBundle.putInt("permission_flag", paramString.getInt("flag"));
        paramBundle = "";
        if (paramString.has("msg")) {
          paramBundle = paramString.optString("msg");
        }
        localBundle.putString("key_selected_tag", paramBundle);
        paramBundle = paramString.getJSONObject("uinList");
        ArrayList localArrayList = new ArrayList();
        paramString = paramBundle.keys();
        i1 = 1;
        if (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localArrayList.add(str);
          if (i1 == 0) {
            localStringBuilder.append("、");
          }
          if (localStringBuilder.length() < 15) {
            localStringBuilder.append(paramBundle.getString(str));
          }
        }
        else
        {
          paramString = localStringBuilder.toString();
          paramBundle = paramString;
          if (paramString.length() > 15) {
            paramBundle = paramString.substring(0, 15) + "...";
          }
          localBundle.putStringArrayList("uin_list", localArrayList);
          localBundle.putString("key_nicknames", paramBundle);
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        localBundle.putInt("permission_flag", 1);
        localBundle.putString("key_parse_json_status", paramBundle.getMessage());
        paramBundle.printStackTrace();
        return localBundle;
      }
      int i1 = 0;
    }
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return (String)localObject1;
      localObject2 = paramBundle.getString("key_setting_raw_json");
      localObject1 = localObject2;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("flag", paramBundle.getInt("permission_flag"));
      localObject2 = paramBundle.getStringArrayList("uin_list");
      paramBundle = paramBundle.getStringArrayList("key_nicknames");
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return ((JSONObject)localObject1).toString();
      }
      if ((paramBundle == null) || (paramBundle.size() != ((ArrayList)localObject2).size())) {
        return ((JSONObject)localObject1).toString();
      }
      JSONObject localJSONObject = new JSONObject();
      int i2 = ((ArrayList)localObject2).size();
      int i1 = 0;
      while (i1 < i2)
      {
        localJSONObject.put((String)((ArrayList)localObject2).get(i1), paramBundle.get(i1));
        i1 += 1;
      }
      ((JSONObject)localObject1).put("uinList", localJSONObject);
      return ((JSONObject)localObject1).toString();
    }
    catch (Exception paramBundle) {}
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\ugcsetting\UgcSettingUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
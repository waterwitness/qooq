package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PaConfigAttr
{
  public static final int a = 0;
  public static final String a = "certified_description";
  public static final int b = 1;
  public static final String b = "config_arr";
  public static final String c = "background_color";
  public static final String d = "certified_weixin";
  public static final String e = "certified_enterprise";
  public List a;
  public int c;
  
  public PaConfigAttr()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = 0;
    this.a = new ArrayList();
  }
  
  public PaConfigAttr(int paramInt, mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this.c = paramInt;
    if (paramConfigGroupInfo == null) {}
    for (;;)
    {
      return;
      paramConfigGroupInfo = paramConfigGroupInfo.config_info.get();
      this.a = new ArrayList(paramConfigGroupInfo.size());
      paramConfigGroupInfo = paramConfigGroupInfo.iterator();
      while (paramConfigGroupInfo.hasNext()) {
        this.a.add(new PaConfigAttr.PaConfigInfo((mobileqq_mp.ConfigInfo)paramConfigGroupInfo.next()));
      }
    }
  }
  
  public PaConfigAttr(mobileqq_mp.ConfigGroupInfo paramConfigGroupInfo)
  {
    this(0, paramConfigGroupInfo);
  }
  
  public static List a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new PaConfigAttr((mobileqq_mp.ConfigGroupInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    for (;;)
    {
      try
      {
        int k = paramJSONArray.length();
        int i = 0;
        if (i >= k) {
          break;
        }
        Object localObject = paramJSONArray.getJSONObject(i);
        PaConfigAttr localPaConfigAttr = new PaConfigAttr();
        localPaConfigAttr.c = ((JSONObject)localObject).optInt("type");
        localObject = ((JSONObject)localObject).getJSONArray("config");
        int m = ((JSONArray)localObject).length();
        int j = 0;
        if (j < m)
        {
          PaConfigAttr.PaConfigInfo localPaConfigInfo = PaConfigAttr.PaConfigInfo.a(((JSONArray)localObject).getJSONObject(j));
          if (localPaConfigInfo != null) {
            localPaConfigAttr.a.add(localPaConfigInfo);
          }
        }
        else
        {
          localArrayList.add(localPaConfigAttr);
          i += 1;
          continue;
        }
        j += 1;
      }
      catch (Exception paramJSONArray)
      {
        paramJSONArray.printStackTrace();
        return localArrayList;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\PaConfigAttr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
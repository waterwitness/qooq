package com.tencent.av.funchat.magicface;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ViewGroup;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ghj;
import ghk;
import ghm;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MagicfaceManagerForAV
{
  static int jdField_a_of_type_Int = 1;
  private static MagicfaceManagerForAV jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV;
  static String jdField_a_of_type_JavaLangString;
  static int jdField_b_of_type_Int = 2;
  static String jdField_b_of_type_JavaLangString;
  static String c;
  static String d;
  static String e;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences(jdField_b_of_type_JavaLangString, 0);
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  private String f = "EmotionMapLock";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = MagicfaceManagerForAV.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "emotion_config_file_av";
    c = "emotion_infos";
    d = "icon_hash";
    e = "res_hash";
  }
  
  public static MagicfaceManagerForAV a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV == null) {
        jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV = new MagicfaceManagerForAV();
      }
      return jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceManagerForAV;
    }
    finally {}
  }
  
  private void a()
  {
    Map localMap = a();
    if ((localMap == null) || (localMap.size() == 0)) {
      return;
    }
    ThreadManager.a(new ghj(this, localMap), 5, null, true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(c, null);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(e + paramString, null);
  }
  
  public ArrayList a()
  {
    Object localObject = a();
    if ((localObject == null) || (((Map)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((Map)localObject).size());
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MagicfaceManagerForAV.EmotionInfo localEmotionInfo = (MagicfaceManagerForAV.EmotionInfo)((Iterator)localObject).next();
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = new PtvTemplateManager.PtvTemplateInfo();
      localPtvTemplateInfo.id = localEmotionInfo.jdField_a_of_type_JavaLangString;
      localPtvTemplateInfo.iconurl = localEmotionInfo.c;
      localPtvTemplateInfo.resurl = localEmotionInfo.e;
      localPtvTemplateInfo.md5 = localEmotionInfo.f;
      localPtvTemplateInfo.usable = a(localEmotionInfo);
      localPtvTemplateInfo.predownload = localEmotionInfo.jdField_a_of_type_Boolean;
      localArrayList.add(localPtvTemplateInfo);
    }
    return localArrayList;
  }
  
  public Map a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
      b(a());
    }
    return this.jdField_a_of_type_JavaUtilLinkedHashMap;
  }
  
  public void a(MagicfaceManagerForAV.EmotionInfo paramEmotionInfo, MagicfaceManagerForAV.GetResListener paramGetResListener)
  {
    if (paramEmotionInfo == null)
    {
      c("downLoadResources| PtvTemplateInfo is null.");
      return;
    }
    c("downLoadResources| PtvTemplateInfo = " + paramEmotionInfo);
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new ghm(this, paramGetResListener);
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramEmotionInfo.e;
    localHttpNetReq.c = 0;
    localHttpNetReq.jdField_b_of_type_JavaLangString = (EmoticonUtils.j.replace("[epId]", paramEmotionInfo.jdField_a_of_type_JavaLangString) + "res.zip");
    localHttpNetReq.a(paramEmotionInfo);
    AVNetEngine.a().a(localHttpNetReq);
  }
  
  public void a(String arg1)
  {
    c("saveConfig|context = " + ???);
    if ((??? == null) || (???.equals(""))) {
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(c, ???).commit();
    synchronized (this.f)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap = null;
      a();
      return;
    }
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    a(paramString, new ghk(this, paramViewGroup, paramString));
  }
  
  public void a(String paramString, MagicfaceManagerForAV.GetResListener paramGetResListener)
  {
    Object localObject = a();
    if ((localObject == null) || (((Map)localObject).size() == 0) || (!((Map)localObject).containsKey(paramString)))
    {
      d("getMagicfaceRes|no this magicface. id =" + paramString);
      if (paramGetResListener != null) {
        paramGetResListener.a(paramString, 0);
      }
    }
    do
    {
      return;
      localObject = (MagicfaceManagerForAV.EmotionInfo)((Map)localObject).get(paramString);
      if (!a((MagicfaceManagerForAV.EmotionInfo)localObject)) {
        break;
      }
      d("getMagicfaceRes|magicface is already download. id =" + paramString);
    } while (paramGetResListener == null);
    paramGetResListener.a(paramString, 2);
    return;
    a((MagicfaceManagerForAV.EmotionInfo)localObject, paramGetResListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(e + paramString1, paramString2);
  }
  
  public boolean a(MagicfaceManagerForAV.EmotionInfo paramEmotionInfo)
  {
    String str = a(paramEmotionInfo.jdField_a_of_type_JavaLangString);
    if ((str == null) || (!paramEmotionInfo.f.equals(str))) {}
    while (!b(EmoticonUtils.j.replace("[epId]", paramEmotionInfo.jdField_a_of_type_JavaLangString) + "res.zip")) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    c("isInBlackList|name=" + paramString);
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      b(a());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return true;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  void b(String paramString)
  {
    int j = 0;
    if ((paramString == null) || (paramString.equals("")))
    {
      c("parseConfig|context is empty.");
      return;
    }
    synchronized (this.f)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap == null) {
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      try
      {
        Object localObject1 = new JSONObject(paramString);
        Object localObject2;
        if (((JSONObject)localObject1).has("black_list"))
        {
          localObject2 = ((JSONObject)localObject1).getJSONArray("black_list");
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            String str2 = ((JSONArray)localObject2).getString(i);
            this.jdField_a_of_type_JavaUtilArrayList.add(str2);
            i += 1;
          }
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("resources");
        int i = j;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new MagicfaceManagerForAV.EmotionInfo(this, ((JSONArray)localObject1).getJSONObject(i));
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(((MagicfaceManagerForAV.EmotionInfo)localObject2).jdField_a_of_type_JavaLangString, localObject2);
          i += 1;
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        d("parseConfig|parse failed.context = " + paramString);
        return;
      }
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  void c(String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public void d(String paramString)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceManagerForAV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeSubPatch
{
  private static final String b = "KingKongSubPatch";
  private static final String c = "fingerprints";
  private static final String d = "fingerprints_value";
  private static final String e = "parameters";
  private static final String f = "hook_point";
  private static final String g = "patch_file";
  private static final String h = "isThumb2";
  public int a;
  public String a;
  public ArrayList a;
  public ArrayList b;
  public ArrayList c;
  public ArrayList d;
  
  public NativeSubPatch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.jdField_a_of_type_Int = 1;
  }
  
  public static ArrayList a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONArray(Utils.a(paramString));
      int i = 0;
      while (i < paramString.length())
      {
        Common.Log.b("KingKongSubPatch", "Parsing sub patch " + i);
        NativeSubPatch localNativeSubPatch = new NativeSubPatch();
        if (localNativeSubPatch.a(paramString.getJSONObject(i)))
        {
          localNativeSubPatch.a();
          localArrayList.add(localNativeSubPatch);
          i += 1;
        }
        else
        {
          Common.Log.a("KingKongSubPatch", "Parse sub patch failed, give up");
          return null;
        }
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      Common.Log.a("KingKongSubPatch", "Parse SubPatch List exception : " + paramString);
    }
    return null;
  }
  
  public void a()
  {
    int k = 0;
    int i = 0;
    while (i < this.c.size())
    {
      Common.Log.b("KingKongSubPatch", "--> HookPoints : " + this.c.get(i));
      i += 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      Common.Log.b("KingKongSubPatch", "--> Parameters : " + ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).toString());
      i += 1;
    }
    while (j < this.b.size())
    {
      Common.Log.b("KingKongSubPatch", "--> FingerPrint : " + (String)this.b.get(j) + ", " + this.d.get(j));
      j += 1;
    }
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    int i;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("patch_file").trim();
        JSONArray localJSONArray1 = paramJSONObject.getJSONArray("parameters");
        localJSONArray2 = paramJSONObject.getJSONArray("fingerprints");
        localJSONArray3 = paramJSONObject.getJSONArray("hook_point");
        localJSONArray4 = paramJSONObject.getJSONArray("fingerprints_value");
        int m = localJSONArray1.length();
        k = localJSONArray2.length();
        int n = localJSONArray4.length();
        j = localJSONArray3.length();
        i = 0;
        if (i < m)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localJSONArray1.getInt(i)));
          i += 1;
          continue;
        }
        if (n == k) {
          break;
        }
        Common.Log.a("KingKongSubPatch", "Fingerprint value count mismatch " + n + ", " + k);
        return false;
      }
      catch (JSONException paramJSONObject)
      {
        JSONArray localJSONArray2;
        JSONArray localJSONArray3;
        JSONArray localJSONArray4;
        int k;
        int j;
        Common.Log.a("KingKongSubPatch", "Parse SubPatch error : " + paramJSONObject);
        return false;
      }
      catch (Exception paramJSONObject)
      {
        return false;
      }
      if (i >= k) {
        break label283;
      }
      this.b.add(localJSONArray2.getString(i).trim());
      this.d.add(Integer.valueOf(localJSONArray4.getInt(i)));
      i += 1;
    }
    for (;;)
    {
      if (i < j)
      {
        this.c.add(Integer.valueOf(localJSONArray3.getInt(i)));
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_Int = paramJSONObject.optInt("isThumb2", 1);
        return true;
        i = 0;
        break;
        label283:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\NativeSubPatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
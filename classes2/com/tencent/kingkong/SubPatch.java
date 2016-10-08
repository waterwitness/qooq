package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubPatch
{
  private static final String b = "SubPatch";
  private static final String c = "fingerprints";
  private static final String d = "parameters";
  private static final String e = "hook_point";
  private static final String f = "jumper_point";
  private static final String g = "patch_file";
  public int a;
  public String a;
  public ArrayList a;
  public int b;
  public ArrayList b;
  
  public SubPatch()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    int k = 0;
    Common.Log.a("SubPatch", "--> HookPoint : " + this.jdField_a_of_type_Int + " ; JumperPoint : " + this.jdField_b_of_type_Int + "\n");
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break;
      }
      Common.Log.a("SubPatch", "--> Parameters : " + ((Integer)this.jdField_a_of_type_JavaUtilArrayList.get(i)).toString());
      i += 1;
    }
    while (j < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Common.Log.a("SubPatch", "--> FingerPrint : " + (String)this.jdField_b_of_type_JavaUtilArrayList.get(j));
      j += 1;
    }
  }
  
  public boolean a(SubPatches paramSubPatches, JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_JavaLangString = paramJSONObject.getString("patch_file").trim();
        this.jdField_a_of_type_Int = paramJSONObject.getInt("hook_point");
        this.jdField_b_of_type_Int = paramJSONObject.getInt("jumper_point");
        k = paramSubPatches.c;
        j = paramSubPatches.jdField_b_of_type_Int;
        paramSubPatches = paramJSONObject.getJSONArray("parameters");
        paramJSONObject = paramJSONObject.getJSONArray("fingerprints");
        if (paramSubPatches.length() == k) {
          break label191;
        }
        Common.Log.a("SubPatch", "Parameter count error!");
        return false;
      }
      catch (JSONException paramSubPatches)
      {
        int k;
        int j;
        int m;
        Common.Log.a("SubPatch", "Parse subpatch error : " + paramSubPatches);
        return false;
        i = 0;
        if (i >= j) {
          continue;
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(paramJSONObject.getString(i).trim());
        i += 1;
        continue;
        return true;
      }
      catch (Exception paramSubPatches)
      {
        return false;
      }
      if (i < k)
      {
        m = paramSubPatches.getInt(i);
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
        i += 1;
      }
      else
      {
        if (paramJSONObject.length() != j)
        {
          Common.Log.a("SubPatch", "Fingerprint count error!");
          return false;
        }
        label191:
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\SubPatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.kingkong;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.ArrayList;

public abstract class Patch
{
  public static final String a = "KingKongPatchInfo";
  public static final String b = "Native";
  public static final String c = "java";
  public static final String d = "DVM";
  public static final String e = "art";
  public static final String f = "arbitrary";
  public static String g = File.separator;
  public PatchInfo a;
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static ArrayList a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
      return localArrayList;
    }
    if (paramString2.equals("DVM"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add(paramString1 + ".jar");
      return localArrayList;
    }
    return null;
  }
  
  public static Patch b(String paramString, PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.f;
    if (str.equals("Native"))
    {
      paramString = NativePatch.a(paramString, paramPatchInfo);
      if (paramString == null) {
        return null;
      }
    }
    else
    {
      Common.Log.a("KingKongPatchInfo", "Unsupported patch type : " + str);
      return null;
    }
    if ((!paramString.i.equals(paramPatchInfo.a)) || (!paramString.j.equals(paramPatchInfo.b)) || (!paramString.k.equals(paramPatchInfo.f)) || (!paramString.k.equals("Native")))
    {
      Common.Log.a("KingKongPatchInfo", "Patch name, version or type mismatch : " + paramString.i + ", " + paramString.j + ", " + paramString.k);
      return null;
    }
    paramString.a = paramPatchInfo;
    return paramString;
  }
  
  public static ArrayList b(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString2.equals("Native"))
    {
      localArrayList.add(paramString1 + ".cfg");
      localArrayList.add("lib" + paramString1 + ".so");
      localArrayList.add(paramString1 + ".subpatch");
    }
    while (!paramString2.equals("DVM")) {
      return localArrayList;
    }
    localArrayList.add(paramString1 + ".cfg");
    localArrayList.add(paramString1 + ".jar");
    localArrayList.add(paramString1 + ".dex");
    return localArrayList;
  }
  
  public abstract int a(Context paramContext);
  
  public String a()
  {
    return this.h + g + this.i + ".cfg";
  }
  
  public ArrayList a()
  {
    return a(this.i, this.k);
  }
  
  public abstract boolean a();
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\Patch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
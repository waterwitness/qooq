package com.tencent.kingkong;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PatchManager
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static final String jdField_a_of_type_JavaLangString = "KingKongPatchManager";
  private static final String b = ".cfg";
  private static final String c = "KingkongPatch.apk";
  private static final String d = "libkkfixerdriver.so";
  private static final String e = "libPatchDispatcher.so";
  private static String f = "";
  private static String g = "";
  private static String h = "/";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static ArrayList a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = MainConfig.a(a).a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PatchInfo)((Iterator)localObject1).next();
      if (((PatchInfo)localObject2).g.equals("READY"))
      {
        localObject2 = Patch.b(g, (PatchInfo)localObject2);
        if (localObject2 != null) {
          localArrayList1.add(localObject2);
        }
      }
    }
    localObject1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < localArrayList1.size())
      {
        localObject2 = localArrayList1.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Patch localPatch = (Patch)((Iterator)localObject2).next();
          if (!localArrayList2.contains(localPatch))
          {
            String str1 = localPatch.a.k;
            String str2 = localPatch.a.a;
            if (str1.equals(""))
            {
              Common.Log.a("KingKongPatchManager", "Patch is ready -->" + str2);
              localArrayList2.add(localPatch);
              ((ArrayList)localObject1).add(str2);
            }
            else if (((ArrayList)localObject1).contains(str1))
            {
              Common.Log.a("KingKongPatchManager", "Patch is ready -->" + str2 + ", previous patch is " + str1);
              localArrayList2.add(localPatch);
              ((ArrayList)localObject1).add(str2);
            }
          }
        }
        if (localArrayList2.size() != localArrayList1.size()) {}
      }
      else
      {
        return localArrayList2;
      }
      i += 1;
    }
  }
  
  public static void a()
  {
    Common.a(true);
    Object localObject1 = a();
    Common.a(true);
    HashMap localHashMap = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Patch localPatch = (Patch)((Iterator)localObject1).next();
      Object localObject2 = localPatch.a;
      String str = ((PatchInfo)localObject2).k;
      localObject2 = ((PatchInfo)localObject2).a;
      if ((!str.equals("")) && ((!localHashMap.containsKey(str)) || (((Integer)localHashMap.get(str)).intValue() != 0)))
      {
        Common.Log.a("KingKongPatchManager", "Previouse patch " + str + " of " + (String)localObject2 + " failed");
      }
      else
      {
        int i = localPatch.a(a);
        localHashMap.put(localObject2, Integer.valueOf(i));
        Common.a(i, localPatch.i, localPatch.k, localPatch.j, "");
      }
    }
  }
  
  public static boolean a()
  {
    if (Common.a() == 1) {
      return true;
    }
    try
    {
      Object localObject = new File(f);
      if (!((File)localObject).exists())
      {
        if (((File)localObject).mkdirs()) {
          Common.Log.a("KingKongPatchManager", "Create patch download folder : " + f + " OK");
        }
      }
      else
      {
        localObject = new File(g);
        if (!((File)localObject).exists())
        {
          if (!((File)localObject).mkdirs()) {
            break label212;
          }
          Common.Log.a("KingKongPatchManager", "Create patch folder : " + g + " OK");
        }
        localObject = new File(f + h + "KingkongPatch.apk");
        if ((!((File)localObject).exists()) || (((File)localObject).delete())) {
          break label245;
        }
        Common.Log.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      Common.Log.a("KingKongPatchManager", "Create patch download folder : " + f + " failed");
      return false;
      label212:
      Common.Log.a("KingKongPatchManager", "Create patch folder : " + g + " failed");
      return false;
      label245:
      if (!((File)localObject).exists())
      {
        if (!Utils.a(a, "KingkongPatch.apk", ((File)localObject).getAbsolutePath()))
        {
          Common.Log.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset failed");
          return false;
        }
        Common.Log.a("KingKongPatchManager", "Copy KingkongPatch.apk from asset OK");
      }
      localObject = f + h + "KingkongPatch.apk";
      if (!Utils.a(g + h + "libkkfixerdriver.so", (String)localObject, "libkkfixerdriver.so", false)) {
        return false;
      }
      localObject = f + h + "KingkongPatch.apk";
      if (!Utils.a(g + h + "libPatchDispatcher.so", (String)localObject, "libPatchDispatcher.so", false)) {
        return false;
      }
      localObject = new File(f + h + "KingkongPatch.apk");
      if ((((File)localObject).exists()) && (!((File)localObject).delete()))
      {
        Common.Log.a("KingKongPatchManager", "Delete asset file failed");
        return false;
      }
      Common.a(1);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = true;
    if (paramContext == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        a = paramContext.getApplicationContext();
        f = Common.a();
        g = Common.b();
        Common.a(true);
        if (!a())
        {
          bool1 = false;
          continue;
        }
        Common.a(true);
        boolean bool2 = b();
        if (bool2) {
          continue;
        }
        bool1 = false;
      }
      finally {}
    }
  }
  
  private static boolean b()
  {
    String str1 = g + h + "libkkfixerdriver.so";
    String str2 = g + h + "libPatchDispatcher.so";
    try
    {
      System.load(str2);
      System.load(str1);
      Common.Log.a("KingKongPatchManager", "Load library " + str1 + " OK");
      return true;
    }
    catch (Exception localException)
    {
      Common.Log.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localException);
      return false;
    }
    catch (Throwable localThrowable)
    {
      Common.Log.a("KingKongPatchManager", "Load library " + str1 + " failed : " + localThrowable);
    }
    return false;
  }
  
  public static native int nativeCalcGotHookPoint(String paramString);
  
  public static native int nativeCalcJumperPoint(String paramString);
  
  public static native int nativeCalcParameter(int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public static native boolean nativeDoPatch(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt, int paramInt4, int paramInt5);
  
  public static native byte[] nativeGetFingerprint(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public static native boolean nativeHoldLibStrongRef(String paramString);
  
  public static native boolean nativeVerifyPatchParams(String paramString, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\PatchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
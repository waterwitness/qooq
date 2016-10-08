package com.tencent.kingkong;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kfc;
import org.json.JSONObject;

public class UpdateManager
{
  public static Context a;
  public static UpdateManager.UpdateThread a;
  public static final String a = "KingKongUpdateManager";
  public static String b = "";
  public static String c = "";
  public static final String d = "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    Object localObject1 = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    Common.a(true);
    Object localObject2 = ((MainConfig)localObject1).a();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)((Iterator)localObject2).next();
      if ((localPatchInfo.g.equals("UPDATED")) || (localPatchInfo.g.equals("DISABLED"))) {
        ((ArrayList)localObject1).add(localPatchInfo);
      }
    }
    if ((!a((ArrayList)localObject1)) || (!b((ArrayList)localObject1))) {
      Common.Log.a("KingKongUpdateManager", "Do Install updates failed");
    }
    for (;;)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((PatchInfo)((Iterator)localObject1).next());
      }
      Common.Log.a("KingKongUpdateManager", "Install updates success!");
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
    b = Common.a();
    c = DataReport.b();
    Constant.c += c;
    Constant.e = Constant.e + c + ".apk";
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread = new UpdateManager.UpdateThread();
    jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread.start();
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!Common.a()) {}
    do
    {
      return;
      if ((jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread != null) && (UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread) != null)) {
        break;
      }
      Common.Log.a("KingKongUpdateManager", "System or Update Thread not ready yet");
      Common.SetContext(paramContext);
      Common.b();
    } while (!Common.a.a());
    try
    {
      paramJSONObject = PatchInfo.a(new JSONObject(paramJSONObject.toString()));
      paramContext = MainConfig.a(paramContext);
      if (a(paramContext, paramJSONObject, paramBoolean))
      {
        Common.Log.a("KingKongUpdateManager", "--> Updating patch : " + paramJSONObject);
        paramContext.b(paramJSONObject);
      }
      Common.a.a();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Common.Log.a("KingKongUpdateManager", "Update Exception : " + paramContext);
      }
    }
    paramContext = paramJSONObject.toString();
    paramJSONObject = UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).obtainMessage();
    Bundle localBundle = new Bundle();
    localBundle.putString("PATCH_JSON_STRING", paramContext);
    localBundle.putBoolean("PATCH_FORCE_UPDATE", paramBoolean);
    paramJSONObject.setData(localBundle);
    UpdateManager.UpdateThread.a(jdField_a_of_type_ComTencentKingkongUpdateManager$UpdateThread).sendMessage(paramJSONObject);
  }
  
  public static void a(PatchInfo paramPatchInfo)
  {
    Object localObject = paramPatchInfo.a;
    paramPatchInfo = paramPatchInfo.f;
    Common.Log.a("KingKongUpdateManager", "Clear update patch files " + (String)localObject);
    paramPatchInfo = Patch.b((String)localObject, paramPatchInfo).iterator();
    while (paramPatchInfo.hasNext())
    {
      String str = Common.a((String)paramPatchInfo.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        Common.Log.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
    paramPatchInfo = Common.a((String)localObject + ".apk");
    localObject = new File(paramPatchInfo);
    if (!((File)localObject).exists()) {}
    while (((File)localObject).delete()) {
      return;
    }
    Common.Log.a("KingKongUpdateManager", "Delete file failed " + paramPatchInfo);
  }
  
  public static void a(PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    String str = paramPatchInfo.a;
    if (a(localMainConfig, paramPatchInfo, paramBoolean))
    {
      Common.Log.a("KingKongUpdateManager", "--> Updating patch : " + paramPatchInfo);
      localMainConfig.b(paramPatchInfo);
      if ("DISABLED".equals(paramPatchInfo.g)) {
        localMainConfig.b(paramPatchInfo);
      }
    }
    else
    {
      return;
    }
    if (!a(paramPatchInfo))
    {
      localMainConfig.b(paramPatchInfo);
      a(paramPatchInfo);
      Common.Log.a("KingKongUpdateManager", "--> Download patch exception : " + str);
      return;
    }
    if ((!b(paramPatchInfo)) || (Patch.b(b, paramPatchInfo) == null))
    {
      Common.Log.a("KingKongUpdateManager", "--> Update got damaged patch, disable " + str);
      paramPatchInfo.g = "DISABLED";
      localMainConfig.b(paramPatchInfo);
      return;
    }
    paramPatchInfo.g = "UPDATED";
    localMainConfig.b(paramPatchInfo);
    Common.Log.a("KingKongUpdateManager", "--> Updated " + str);
  }
  
  public static boolean a()
  {
    if (!Utils.a(jdField_a_of_type_AndroidContentContext).equals(Utils.b(jdField_a_of_type_AndroidContentContext))) {
      return false;
    }
    Iterator localIterator = MainConfig.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      String str = ((PatchInfo)localIterator.next()).g;
      if ((str.equals("DISABLED")) || (str.equals("UPDATED"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MainConfig paramMainConfig, PatchInfo paramPatchInfo, boolean paramBoolean)
  {
    PatchInfo localPatchInfo = paramMainConfig.a(paramPatchInfo.a);
    StringBuilder localStringBuilder1 = Utils.a();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("Check update : ").append(" forceUpdate " + paramBoolean).append(", enabled " + paramPatchInfo.a()).append(", support " + paramPatchInfo.b());
    StringBuilder localStringBuilder3 = new StringBuilder().append(", old version ");
    if (localPatchInfo == null)
    {
      paramMainConfig = "None";
      localStringBuilder2.append(paramMainConfig).append(", new version " + paramPatchInfo.b);
      if ((!paramBoolean) && (paramPatchInfo.a()) && (paramPatchInfo.b()) && (localPatchInfo != null) && (localPatchInfo.b.equals(paramPatchInfo.b))) {
        break label399;
      }
      if ((paramPatchInfo.a()) && (paramPatchInfo.b())) {
        break label304;
      }
      if (localPatchInfo != null)
      {
        Common.Log.a("KingKongUpdateManager", "close old patch : " + localPatchInfo.a + " , " + localPatchInfo.b);
        Common.a(2084, localPatchInfo.a, localPatchInfo.b);
      }
    }
    for (paramPatchInfo.g = "DISABLED";; paramPatchInfo.g = "UPDATING")
    {
      Common.Log.a("KingKongUpdateManager", " --> Passed");
      return true;
      paramMainConfig = localPatchInfo.b;
      break;
      label304:
      if ((localPatchInfo != null) && (!localPatchInfo.b.equals(paramPatchInfo.b))) {
        Common.Log.a("KingKongUpdateManager", "upgrade patch : from " + localPatchInfo.a + " , " + localPatchInfo.b + " to " + paramPatchInfo.a + " , " + paramPatchInfo.b);
      }
    }
    label399:
    Common.Log.a("KingKongUpdateManager", " --> Refused");
    return false;
  }
  
  private static boolean a(Patch paramPatch)
  {
    return paramPatch.a();
  }
  
  public static boolean a(PatchInfo paramPatchInfo)
  {
    String str1 = paramPatchInfo.e;
    String str2 = Common.a(paramPatchInfo.a + ".apk");
    if (!Utils.c(str1, str2)) {}
    while (!Utils.a(str2, "30820254308201bda00302010202044c5eafe7300d06092a864886f70d01010b0500305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e74301e170d3134313033313038333935345a170d3135313033313038333935345a305d310b300906035504061302434e310b3009060355040813024744310b300906035504071302535a3110300e060355040a130754656e63656e743110300e060355040b130754656e63656e743110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100b293a98fe569b7f9ba099e041c25038d8230e6fcbcee332499723e7d3c635795f6f8c04cdb25683080390119c4e5575bdf9d94b1969caeae09927ee38eb8e3ad9a5003a3dcc9055196341a50f5b06a6ec6e8c415ea8e42dee8d8838096022c3b54b299aafe3d2f934b65864506b379210382f826103476087d47c5191fb00e4b0203010001a321301f301d0603551d0e04160414b049af36c79e57278b3fda5ff8b1152ede6c83ca300d06092a864886f70d01010b0500038181003820e8817688a08d8bfef1cc3c5e7fe3343fa5786db96680d55a6d89145498fa1ae7f2de349e9deecd8ae9499e95a870f5810a1d9d81662f41ff29c23c0ddb51878b6926943fd5771d0e3dc463a7f0deb881355df3a45a206508ae5bc2c818038b0cd8fff3f52aeac3c70464c886917c67bc391fdae70a79fe02b9657190e6d4")) {
      return false;
    }
    Common.a(2085, paramPatchInfo.a, paramPatchInfo.b);
    return true;
  }
  
  private static boolean a(ArrayList paramArrayList)
  {
    Common.Log.a("KingKongUpdateManager", "Removing obsoleted patches");
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)paramArrayList.next();
      String str = localPatchInfo.a;
      b(localPatchInfo);
      Common.a(str);
      localMainConfig.a(str);
    }
    return true;
  }
  
  public static void b()
  {
    Iterator localIterator = MainConfig.a(jdField_a_of_type_AndroidContentContext).a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (PatchInfo)localIterator.next();
      if (((PatchInfo)localObject).g.equals("UPDATING"))
      {
        Common.Log.a("KingKongUpdateManager", "Continue udpating " + ((PatchInfo)localObject).a);
        localObject = ((PatchInfo)localObject).a();
        a(jdField_a_of_type_AndroidContentContext, (JSONObject)localObject, true);
      }
    }
  }
  
  public static void b(PatchInfo paramPatchInfo)
  {
    String str = paramPatchInfo.a;
    paramPatchInfo = paramPatchInfo.f;
    Common.Log.a("KingKongUpdateManager", "Clear update patch files " + str);
    paramPatchInfo = Patch.b(str, paramPatchInfo).iterator();
    while (paramPatchInfo.hasNext())
    {
      str = Common.b((String)paramPatchInfo.next());
      File localFile = new File(str);
      if ((localFile.exists()) && (!localFile.delete())) {
        Common.Log.a("KingKongUpdateManager", "Delete file failed " + str);
      }
    }
  }
  
  public static boolean b()
  {
    return Utils.a(jdField_a_of_type_AndroidContentContext).equals(Utils.b(jdField_a_of_type_AndroidContentContext));
  }
  
  private static boolean b(PatchInfo paramPatchInfo)
  {
    String str1 = paramPatchInfo.a;
    paramPatchInfo = Patch.a(str1, paramPatchInfo.f);
    if ((paramPatchInfo == null) || (paramPatchInfo.size() == 0))
    {
      Common.Log.a("KingKongUpdateManager", "Empty file list in " + str1);
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramPatchInfo.size()) {
        break label118;
      }
      String str2 = (String)paramPatchInfo.get(i);
      String str3 = Common.a(str2);
      if (!Utils.a(Common.a(str1 + ".apk"), str2, str3)) {
        break;
      }
      i += 1;
    }
    label118:
    return true;
  }
  
  private static boolean b(ArrayList paramArrayList)
  {
    Common.Log.a("KingKongUpdateManager", "Installing updated patches");
    MainConfig localMainConfig = MainConfig.a(jdField_a_of_type_AndroidContentContext);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)paramArrayList.next();
      Object localObject = localPatchInfo.g;
      String str1 = localPatchInfo.a;
      if (((String)localObject).equals("DISABLED"))
      {
        Common.Log.a("KingKongUpdateManager", "Removed " + str1);
      }
      else
      {
        Common.Log.a("KingKongUpdateManager", "--> Installing " + str1);
        localObject = Patch.a(str1, localPatchInfo.f).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str3 = (String)((Iterator)localObject).next();
          String str2 = Common.a(str3);
          str3 = Common.b(str3);
          if (!Utils.b(str3, str2))
          {
            Common.Log.a("KingKongUpdateManager", "Install patch failed : " + str1 + ", " + str3 + " <-- " + str2);
            localPatchInfo.g = "UPDATING";
            localMainConfig.b(localPatchInfo);
            return false;
          }
        }
        localObject = Patch.b(b, localPatchInfo);
        if ((localObject == null) || (!a((Patch)localObject))) {
          Common.Log.a("KingKongUpdateManager", "Init patch failed " + str1);
        }
        localPatchInfo.g = "READY";
        localMainConfig.b(localPatchInfo);
        Common.Log.a("KingKongUpdateManager", "Installed " + str1);
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\UpdateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
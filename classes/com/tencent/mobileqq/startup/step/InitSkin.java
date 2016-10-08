package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.color;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import mqq.os.MqqHandler;
import utr;
import uts;
import utt;

public class InitSkin
  extends Step
{
  public static int a = 0;
  public static final Object a;
  public static final String a = "tool_process_profile";
  public static boolean a;
  private static final int[] a;
  public static boolean b;
  private static final int[] b;
  private static final String jdField_c_of_type_JavaLangString = InitSkin.class.getSimpleName();
  public static volatile boolean c;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2130837524, 2130837525, 2130837527, 2130837528, 2130837530, 2130837531, 2130837533, 2130837534, 2130837544, 2130837571, 2130837630, 2130837701, 2130843576, 2130843573, 2130843574, 2130843571, 2130843572, 2130843578, 2130837955, 2130837956, 2130837957, 2130838106, 2130838126, 2130838128, 2130838185, 2130838186, 2130838189, 2130838190, 2130838196, 2130838197, 2130838199, 2130838200, 2130838299, 2130838300, 2130838303, 2130838320, 2130838324, 2130838326, 2130838360, 2130838366, 2130838379, 2130838411, 2130838424, 2130838440, 2130839941, 2130838490, 2130838507, 2130837760, 2130843575, 2130843566, 2130838582, 2130842345, 2130842346, 2130842347, 2130838611, 2130838612, 2130842428, 2130838706, 2130838731, 2130839296, 2130839297, 2130839298, 2130839299, 2130839697, 2130839698, 2130839758, 2130840390, 2130840391, 2130841064, 2130841065, 2130841069, 2130841070, 2130841072, 2130841073, 2130841074, 2130841075, 2130841085, 2130841901, 2130841902, 2130841903, 2130843581, 2130841931, 2130841932, 2130841933, 2130841966, 2130841967, 2130841970, 2130841997, 2130842000, 2130842001, 2130842002, 2130842006, 2130842011, 2130842019, 2130842020, 2130842021, 2130842022, 2130842023, 2130842024, 2130842025, 2130842027, 2130842028, 2130842030, 2130842032, 2130842033, 2130842034, 2130842035, 2130842036, 2130842038, 2130842039, 2130842041, 2130842044, 2130842048, 2130842049, 2130842050, 2130842059, 2130842075, 2130842078, 2130842079, 2130842080, 2130842081, 2130842082, 2130842083, 2130842084, 2130843585, 2130842085, 2130842086, 2130842087, 2130842088, 2130842089, 2130842098, 2130842099, 2130842100, 2130842101, 2130842110, 2130842111, 2130842114, 2130843239, 2130843237, 2130843238, 2130843242, 2130843240, 2130843243, 2130842136, 2130842137, 2130842138, 2130842139, 2130842140, 2130842152, 2130837530, 2130842153, 2130842154, 2130842155, 2130842156, 2130842157, 2130842158, 2130842162, 2130842163, 2130843568, 2130843569, 2130842171, 2130842180, 2130843580, 2130842195, 2130842196, 2130842197, 2130842204, 2130842205, 2130842206, 2130842207, 2130842208, 2130843582, 2130843584, 2130842209, 2130842210, 2130842211, 2130842212, 2130842221, 2130842228, 2130842229, 2130842240, 2130842241, 2130842242, 2130842243, 2130842245, 2130842246, 2130842247, 2130842250, 2130842253, 2130842254, 2130842255, 2130842256, 2130842260, 2130842261, 2130842262, 2130842274, 2130842275, 2130842276, 2130842277, 2130842279, 2130842280, 2130842281, 2130842282, 2130842284, 2130842288, 2130842290, 2130842294, 2130842297, 2130842298, 2130842301, 2130842305, 2130842308, 2130842312, 2130842313, 2130842314, 2130842315, 2130842316, 2130842317, 2130842324, 2130842326, 2130842327, 2130842340, 2130842341, 2130842342, 2130842343, 2130842344, 2130842351, 2130842355, 2130842356, 2130842360, 2130842362, 2130842367, 2130842368, 2130842369, 2130842378, 2130842394, 2130842395, 2130842396, 2130842397, 2130842398, 2130842399, 2130842400, 2130842401, 2130842402, 2130842403, 2130842404, 2130842407, 2130842413, 2130842416, 2130842418, 2130842419, 2130842421, 2130842422, 2130842423, 2130842424, 2130842425, 2130842426, 2130842427, 2130842456, 2130842464, 2130842466, 2130842469, 2130842471, 2130842480, 2130842483, 2130842484, 2130842485, 2130842486, 2130842487, 2130842488, 2130842491, 2130842494, 2130842497, 2130840680, 2130842519, 2130842520, 2130842530, 2130842531, 2130842532, 2130842534, 2130838262, 2130838261, 2130843227, 2130842536, 2130842537, 2130842538, 2130842539, 2130842540, 2130842541, 2130842542, 2130842543, 2130842544, 2130842545, 2130842546, 2130842567, 2130842625, 2130842626, 2130842645, 2130842652, 2130842718, 2130842729, 2130842730, 2130842732, 2130842734, 2130842735, 2130842737, 2130842740, 2130842741, 2130842747, 2130842757, 2130842759, 2130842797, 2130842798, 2130842802, 2130842803, 2130842810, 2130842811, 2130842812, 2130842813, 2130842814, 2130842816, 2130842823, 2130842824, 2130842825, 2130842826, 2130842827, 2130842828, 2130842829, 2130842831, 2130842832, 2130842833, 2130842834, 2130842835, 2130842836, 2130842837, 2130842854, 2130842855, 2130842856, 2130842857, 2130842859, 2130842861, 2130842894, 2130842912, 2130842913, 2130842914, 2130842936, 2130842934, 2130842935, 2130842937, 2130842938, 2130842940, 2130843088, 2130843108, 2130843109, 2130843110, 2130843111, 2130843112, 2130843116, 2130843117, 2130843118, 2130843124, 2130843125, 2130843126, 2130843127, 2130843134, 2130843135, 2130843136, 2130843150, 2130843153, 2130843158, 2130843159, 2130843160, 2130843161, 2130843162, 2130843163, 2130843164, 2130843165, 2130843171, 2130843172, 2130843173, 2130843174, 2130843175, 2130843176, 2130843177, 2130843180, 2130843181, 2130843187, 2130843188, 2130843196, 2130843230, 2130843231, 2130843232, 2130843233, 2130843234, 2130843235, 2130843236, 2130843244, 2130843246, 2130843247, 2130843248, 2130843249, 2130843250, 2130843257, 2130843260, 2130843262, 2130843264, 2130843266, 2130843268, 2130843271, 2130843273, 2130843275, 2130843277, 2130843284, 2130843286, 2130843290, 2130843292, 2130843324, 2130843325, 2130843354, 2130843446, 2130843448, 2130843449, 2130843451, 2130843452, 2130843453, 2130843537, 2130843464, 2130843466, 2130843535, 2130842328 };
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Int = 3000;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837562, 2130837649, 2130837648, 2130837647, 2130838196, 2130838300, 2130838299, 2130838320, 2130838322, 2130838326, 2130838312, 2130838411, 2130838506, 2130838592, 2130838711, 2130839432, 2130840286, 2130841075, 2130841074, 2130841070, 2130841069, 2130841065, 2130841064, 2130840266, 2130840271, 2130840272, 2130840273, 2130840274, 2130840275, 2130840276, 2130840277, 2130840278, 2130840279, 2130840282, 2130840281, 2130840283, 2130840284, 2130840285, 2130840287, 2130840286, 2130840288, 2130840289, 2130840290, 2130840291, 2130840292, 2130840293, 2130840294, 2130840295, 2130840296, 2130840297, 2130840298, 2130840998, 2130840390, 2130840391, 2130840272, 2130840342, 2130840390, 2130840391, 2130840271, 2130842853, 2130843009, 2130843000, 2130842999, 2130843016, 2130843015, 2130843273, 2130843200, 2130843196, 2130843088, 2130843150, 2130843325, 2130843159, 2130843158, 2130843160, 2130843164, 2130843163, 2130843153, 2130843118, 2130843124, 2130843125, 2130843136, 2130843273, 2130843232, 2130843233, 2130843244, 2130843260, 2130843264, 2130843262, 2130843268, 2130843266, 2130838587, 2130838588, 2130843181, 2130840311, 2130840310, 2130838314, 2130838315, 2130843202, 2130843198 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130837524, 2130837525, 2130837527, 2130837528, 2130837530, 2130837531, 2130837533, 2130837534, 2130838300, 2130838299, 2130843009, 2130843338, 2130843337, 2130842535, 2130838589, 2130838588, 2130843454, 2130843150, 2130843153, 2130843158, 2130843159, 2130843160, 2130843161, 2130843162, 2130843163, 2130843164, 2130843457, 2130843508, 2130838618, 2130838616, 2130838617, 2130838615, 2130838613, 2130838614, 2130840303, 2130840301, 2130840302, 2130838621, 2130838619, 2130838620, 2130837955, 2130843537, 2130838945, 2130838946, 2130838947, 2130838948, 2130843316, 2130843088, 2130843134, 2130843136, 2130839391, 2130839390, 2130839395, 2130843200, 2130843196, 2130843203, 2130839396, 2130839398, 2130843148, 2130839402, 2130839401, 2130843092, 2130843268, 2130843266, 2130843260, 2130838411, 2130843275, 2130843277, 2130843226, 2130843223 };
  }
  
  private static MqqHandler a()
  {
    HandlerThread localHandlerThread = new HandlerThread("initSkin4QZone", 0);
    localHandlerThread.start();
    return new utr(localHandlerThread.getLooper(), localHandlerThread);
  }
  
  public static void a()
  {
    if ((jdField_b_of_type_Boolean) && (!jdField_c_of_type_Boolean)) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "start waitAsynInitSkin");
      }
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      boolean bool = jdField_c_of_type_Boolean;
      if (!bool) {}
      try
      {
        jdField_a_of_type_JavaLangObject.wait(jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_c_of_type_JavaLangString, 2, "end waitAsynInitSkin InitSkin.sToolProcessInitComplete = " + jdField_c_of_type_Boolean);
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_c_of_type_JavaLangString, 2, localInterruptedException.toString());
          }
        }
      }
    }
  }
  
  public static final boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/web_config");
        localFile2 = new File(localFile2, "/skin/web_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new utt("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"229354".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837958);
      SkinEngine.getInstances().addDrawableResource(2130838317);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label489;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "web skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_b_of_type_ArrayOfInt, R.color.class, 2131427328, null);
      ThreadManager.b().postDelayed(new utt("/skin/web_config", "/skin/web_skin_cache"), 10000L);
    }
  }
  
  private void b()
  {
    jdField_b_of_type_Boolean = false;
    Object localObject2 = BaseApplicationImpl.a().getSharedPreferences("dpcConfig", 4).getString("tool_process_profile", "");
    boolean bool;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject1 = localObject2;
      if (((String)localObject2).indexOf('{', 0) == 0)
      {
        localObject1 = localObject2;
        if (((String)localObject2).lastIndexOf('}') == ((String)localObject2).length() - 1) {
          localObject1 = ((String)localObject2).substring(1, ((String)localObject2).length() - 1);
        }
      }
      localObject2 = new Integer[2];
      Arrays.fill((Object[])localObject2, Integer.valueOf(0));
      if (DeviceProfileManager.a((String)localObject1, (Object[])localObject2, new DeviceProfileManager.StringToIntParser()) >= 2)
      {
        if (localObject2[0].intValue() != 1) {
          break label209;
        }
        bool = true;
        jdField_b_of_type_Boolean = bool;
        if (localObject2[1].intValue() <= 0) {
          break label215;
        }
        i = localObject2[1].intValue();
        label136:
        jdField_a_of_type_Int = i;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "ToolAsynInitDPC = " + jdField_b_of_type_Boolean + "  sToolInitTimeout = " + jdField_a_of_type_Int);
    }
    if (jdField_b_of_type_Boolean) {
      ThreadManager.a(new uts(this), 8, null, false);
    }
    label209:
    label215:
    do
    {
      return;
      bool = false;
      break;
      i = 0;
      break label136;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_c_of_type_JavaLangString, 2, "start synInitSkin");
      }
      initSkin(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      jdField_c_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_c_of_type_JavaLangString, 2, "end synInitSkin");
  }
  
  public static final boolean b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qqfav_config");
        localFile2 = new File(localFile2, "/skin/qqfav_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new utt("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"229354".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qqfav skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837958);
      SkinEngine.getInstances().addDrawableResource(2130838119);
      SkinEngine.getInstances().addDrawableResource(2130838317);
      SkinEngine.getInstances().addDrawableResource(2130838127);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label507;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qqfav skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
      ThreadManager.b().postDelayed(new utt("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
    }
  }
  
  public static final boolean c(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        SkinEngine.SWITCH_DEBUG = false;
        SkinEngine.DEBUG = false;
        localFile1 = new File(localFile2, "/skin/qzone_config");
        localFile2 = new File(localFile2, "/skin/qzone_skin_cache");
      }
      catch (Exception localException1)
      {
        File localFile2;
        long l1;
        File localFile1;
        Object localObject1;
        int i;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SkinEngine", 2, "", localException1);
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          continue;
        }
        if (paramContext.getParentFile().exists()) {
          continue;
        }
        paramContext.getParentFile().mkdirs();
        try
        {
          paramContext.createNewFile();
        }
        catch (IOException paramContext) {}
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        localMqqHandler = a();
        Object localObject2 = Message.obtain();
        ((Message)localObject2).obj = new Pair("/skin/qzone_config", "/skin/qzone_skin_cache");
        localMqqHandler.sendMessageDelayed((Message)localObject2, 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          continue;
        }
        localObject1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = ((ObjectInputStream)localObject1).readInt();
        localObject2 = ((ObjectInputStream)localObject1).readUTF();
        ((ObjectInputStream)localObject1).close();
        if ((i != AppSetting.jdField_a_of_type_Int) || (!"229354".equals(localObject2))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localFile1.exists()) {
          continue;
        }
        localFile1.delete();
        if (localFile2.exists()) {
          continue;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SkinEngine", 2, "qzone skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837958);
      SkinEngine.getInstances().addDrawableResource(2130838119);
      SkinEngine.getInstances().addDrawableResource(2130838317);
      SkinEngine.getInstances().addDrawableResource(2130838127);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qzone skin init skin engine cost: " + (l2 - l1));
        }
        return true;
      }
      catch (Exception localException2)
      {
        MqqHandler localMqqHandler;
        if (!QLog.isColorLevel()) {
          break label535;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SkinEngine", 2, "qzone skin cache time out");
      }
      SkinEngine.init(paramContext, jdField_c_of_type_ArrayOfInt, R.color.class, 2131427328, null);
      localObject1 = a();
      localObject2 = Message.obtain();
      ((Message)localObject2).obj = new Pair("/skin/qzone_config", "/skin/qzone_skin_cache");
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 10000L);
    }
  }
  
  /* Error */
  public static final boolean initSkin(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 631	android/content/Context:getCacheDir	()Ljava/io/File;
    //   4: astore_3
    //   5: invokestatic 637	android/os/SystemClock:uptimeMillis	()J
    //   8: lstore 7
    //   10: iconst_0
    //   11: putstatic 642	com/tencent/theme/SkinEngine:SWITCH_DEBUG	Z
    //   14: iconst_0
    //   15: putstatic 645	com/tencent/theme/SkinEngine:DEBUG	Z
    //   18: new 711	com/tencent/common/app/OOMHandler
    //   21: dup
    //   22: invokestatic 716	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   25: invokespecial 719	com/tencent/common/app/OOMHandler:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 928	com/tencent/theme/SkinEngine:setSKLog	(Lcom/tencent/theme/ISkinEngineLog;)V
    //   33: getstatic 871	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   36: astore_2
    //   37: aload_2
    //   38: invokevirtual 934	android/app/Application:getPackageManager	()Landroid/content/pm/PackageManager;
    //   41: aload_2
    //   42: invokevirtual 937	android/app/Application:getPackageName	()Ljava/lang/String;
    //   45: sipush 128
    //   48: invokevirtual 943	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   51: getfield 949	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   54: ldc_w 951
    //   57: invokevirtual 957	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   60: ifeq +45 -> 105
    //   63: ldc 48
    //   65: invokestatic 834	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: putstatic 961	com/tencent/theme/SkinEngine:mIconResourceID	Ljava/lang/Integer;
    //   71: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +31 -> 105
    //   77: ldc_w 693
    //   80: iconst_2
    //   81: new 606	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 607	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 963
    //   91: invokevirtual 613	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 48
    //   96: invokevirtual 858	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 619	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 698	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: new 647	java/io/File
    //   108: dup
    //   109: aload_3
    //   110: ldc_w 965
    //   113: invokespecial 652	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   116: astore_2
    //   117: new 647	java/io/File
    //   120: dup
    //   121: aload_3
    //   122: ldc_w 967
    //   125: invokespecial 652	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   128: astore_3
    //   129: aload_2
    //   130: invokevirtual 657	java/io/File:exists	()Z
    //   133: ifeq +525 -> 658
    //   136: new 659	java/io/ObjectInputStream
    //   139: dup
    //   140: new 661	java/io/BufferedInputStream
    //   143: dup
    //   144: new 663	java/io/FileInputStream
    //   147: dup
    //   148: aload_2
    //   149: invokespecial 666	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: invokespecial 669	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   155: invokespecial 670	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   158: astore 4
    //   160: aload 4
    //   162: invokevirtual 674	java/io/ObjectInputStream:readInt	()I
    //   165: istore 6
    //   167: aload 4
    //   169: invokevirtual 677	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   172: astore 5
    //   174: aload 4
    //   176: invokevirtual 680	java/io/ObjectInputStream:close	()V
    //   179: iload 6
    //   181: getstatic 683	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   184: if_icmpne +351 -> 535
    //   187: ldc_w 685
    //   190: aload 5
    //   192: invokevirtual 691	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +340 -> 535
    //   198: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +13 -> 214
    //   204: ldc_w 693
    //   207: iconst_2
    //   208: ldc_w 969
    //   211: invokestatic 698	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_0
    //   215: ldc_w 971
    //   218: ldc_w 734
    //   221: ldc_w 700
    //   224: ldc_w 701
    //   227: aload_3
    //   228: invokestatic 974	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   231: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   234: aload_1
    //   235: invokevirtual 723	com/tencent/theme/SkinEngine:setSkinEngineHandler	(Lcom/tencent/theme/SkinEngineHandler;)V
    //   238: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   241: ldc_w 724
    //   244: invokevirtual 728	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   247: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   250: ldc_w 883
    //   253: invokevirtual 728	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   256: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   259: ldc_w 975
    //   262: invokevirtual 728	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   265: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   268: ldc_w 729
    //   271: invokevirtual 728	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   274: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   277: ldc_w 884
    //   280: invokevirtual 728	com/tencent/theme/SkinEngine:addDrawableResource	(I)V
    //   283: invokestatic 637	android/os/SystemClock:uptimeMillis	()J
    //   286: lstore 9
    //   288: new 977	com/tencent/theme/SkinEngine$BackupForOOMData
    //   291: dup
    //   292: ldc_w 978
    //   295: ldc_w 979
    //   298: getstatic 985	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   301: invokespecial 988	com/tencent/theme/SkinEngine$BackupForOOMData:<init>	(IILandroid/graphics/Bitmap$Config;)V
    //   304: astore_1
    //   305: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   308: ldc_w 978
    //   311: invokestatic 834	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   314: aload_1
    //   315: invokevirtual 992	com/tencent/theme/SkinEngine:addBackupForOOMData	(Ljava/lang/Integer;Lcom/tencent/theme/SkinEngine$BackupForOOMData;)V
    //   318: new 977	com/tencent/theme/SkinEngine$BackupForOOMData
    //   321: dup
    //   322: ldc_w 993
    //   325: ldc_w 979
    //   328: getstatic 985	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   331: invokespecial 988	com/tencent/theme/SkinEngine$BackupForOOMData:<init>	(IILandroid/graphics/Bitmap$Config;)V
    //   334: astore_1
    //   335: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   338: ldc_w 993
    //   341: invokestatic 834	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aload_1
    //   345: invokevirtual 992	com/tencent/theme/SkinEngine:addBackupForOOMData	(Ljava/lang/Integer;Lcom/tencent/theme/SkinEngine$BackupForOOMData;)V
    //   348: new 977	com/tencent/theme/SkinEngine$BackupForOOMData
    //   351: dup
    //   352: ldc_w 994
    //   355: ldc_w 979
    //   358: getstatic 985	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   361: invokespecial 988	com/tencent/theme/SkinEngine$BackupForOOMData:<init>	(IILandroid/graphics/Bitmap$Config;)V
    //   364: astore_1
    //   365: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   368: ldc_w 994
    //   371: invokestatic 834	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: aload_1
    //   375: invokevirtual 992	com/tencent/theme/SkinEngine:addBackupForOOMData	(Ljava/lang/Integer;Lcom/tencent/theme/SkinEngine$BackupForOOMData;)V
    //   378: new 977	com/tencent/theme/SkinEngine$BackupForOOMData
    //   381: dup
    //   382: ldc_w 995
    //   385: ldc_w 979
    //   388: getstatic 985	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   391: invokespecial 988	com/tencent/theme/SkinEngine$BackupForOOMData:<init>	(IILandroid/graphics/Bitmap$Config;)V
    //   394: astore_1
    //   395: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   398: ldc_w 995
    //   401: invokestatic 834	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aload_1
    //   405: invokevirtual 992	com/tencent/theme/SkinEngine:addBackupForOOMData	(Ljava/lang/Integer;Lcom/tencent/theme/SkinEngine$BackupForOOMData;)V
    //   408: aload_0
    //   409: invokevirtual 733	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   412: ldc_w 734
    //   415: invokevirtual 740	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   418: pop
    //   419: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +315 -> 737
    //   425: ldc_w 693
    //   428: iconst_2
    //   429: new 606	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 607	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 997
    //   439: invokevirtual 613	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: lload 9
    //   444: lload 7
    //   446: lsub
    //   447: invokevirtual 745	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: invokevirtual 619	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 698	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: goto +281 -> 737
    //   459: astore_2
    //   460: aload_2
    //   461: invokevirtual 1000	android/content/pm/PackageManager$NameNotFoundException:printStackTrace	()V
    //   464: goto -359 -> 105
    //   467: astore_1
    //   468: iconst_0
    //   469: putstatic 774	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_Boolean	Z
    //   472: ldc_w 693
    //   475: iconst_1
    //   476: ldc_w 1002
    //   479: aload_1
    //   480: invokestatic 779	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   483: new 647	java/io/File
    //   486: dup
    //   487: aload_0
    //   488: invokevirtual 631	android/content/Context:getCacheDir	()Ljava/io/File;
    //   491: ldc_w 781
    //   494: invokespecial 652	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   497: astore_0
    //   498: aload_0
    //   499: invokevirtual 657	java/io/File:exists	()Z
    //   502: ifne +235 -> 737
    //   505: aload_0
    //   506: invokevirtual 784	java/io/File:getParentFile	()Ljava/io/File;
    //   509: invokevirtual 657	java/io/File:exists	()Z
    //   512: ifne +11 -> 523
    //   515: aload_0
    //   516: invokevirtual 784	java/io/File:getParentFile	()Ljava/io/File;
    //   519: invokevirtual 787	java/io/File:mkdirs	()Z
    //   522: pop
    //   523: aload_0
    //   524: invokevirtual 790	java/io/File:createNewFile	()Z
    //   527: pop
    //   528: goto +209 -> 737
    //   531: astore_0
    //   532: goto +205 -> 737
    //   535: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +13 -> 551
    //   541: ldc_w 693
    //   544: iconst_2
    //   545: ldc_w 1004
    //   548: invokestatic 698	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload_0
    //   552: ldc_w 971
    //   555: ldc_w 734
    //   558: ldc_w 700
    //   561: ldc_w 701
    //   564: aconst_null
    //   565: invokestatic 974	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   568: invokestatic 751	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   571: new 753	utt
    //   574: dup
    //   575: ldc_w 965
    //   578: ldc_w 967
    //   581: invokespecial 756	utt:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: ldc2_w 757
    //   587: invokevirtual 764	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   590: pop
    //   591: goto -360 -> 231
    //   594: astore 4
    //   596: aload_2
    //   597: invokevirtual 657	java/io/File:exists	()Z
    //   600: ifeq +8 -> 608
    //   603: aload_2
    //   604: invokevirtual 767	java/io/File:delete	()Z
    //   607: pop
    //   608: aload_3
    //   609: invokevirtual 657	java/io/File:exists	()Z
    //   612: ifeq +8 -> 620
    //   615: aload_3
    //   616: invokevirtual 767	java/io/File:delete	()Z
    //   619: pop
    //   620: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   623: ifeq +15 -> 638
    //   626: ldc_w 693
    //   629: iconst_2
    //   630: ldc_w 1006
    //   633: aload 4
    //   635: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload_0
    //   639: ldc_w 971
    //   642: ldc_w 734
    //   645: ldc_w 700
    //   648: ldc_w 701
    //   651: aconst_null
    //   652: invokestatic 974	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   655: goto -424 -> 231
    //   658: invokestatic 594	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +13 -> 674
    //   664: ldc_w 693
    //   667: iconst_2
    //   668: ldc_w 792
    //   671: invokestatic 698	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: ldc_w 971
    //   678: ldc_w 734
    //   681: ldc_w 700
    //   684: ldc_w 701
    //   687: aconst_null
    //   688: invokestatic 974	com/tencent/theme/SkinEngine:init	(Landroid/content/Context;Ljava/lang/Class;ILjava/lang/Class;ILjava/io/File;)V
    //   691: invokestatic 751	com/tencent/mobileqq/app/ThreadManager:b	()Lmqq/os/MqqHandler;
    //   694: new 753	utt
    //   697: dup
    //   698: ldc_w 965
    //   701: ldc_w 967
    //   704: invokespecial 756	utt:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   707: ldc2_w 757
    //   710: invokevirtual 764	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   713: pop
    //   714: goto -483 -> 231
    //   717: astore_1
    //   718: ldc_w 693
    //   721: iconst_1
    //   722: ldc_w 1008
    //   725: aload_1
    //   726: invokestatic 779	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   729: invokestatic 709	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   732: invokevirtual 795	com/tencent/theme/SkinEngine:unInit	()V
    //   735: aload_1
    //   736: athrow
    //   737: iconst_1
    //   738: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	739	0	paramContext	Context
    //   28	377	1	localObject1	Object
    //   467	13	1	localException1	Exception
    //   717	19	1	localException2	Exception
    //   36	113	2	localObject2	Object
    //   459	145	2	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   4	612	3	localFile	File
    //   158	17	4	localObjectInputStream	ObjectInputStream
    //   594	40	4	localException3	Exception
    //   172	19	5	str	String
    //   165	20	6	i	int
    //   8	437	7	l1	long
    //   286	157	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   33	105	459	android/content/pm/PackageManager$NameNotFoundException
    //   0	33	467	java/lang/Exception
    //   33	105	467	java/lang/Exception
    //   105	129	467	java/lang/Exception
    //   231	408	467	java/lang/Exception
    //   419	456	467	java/lang/Exception
    //   460	464	467	java/lang/Exception
    //   596	608	467	java/lang/Exception
    //   608	620	467	java/lang/Exception
    //   620	638	467	java/lang/Exception
    //   638	655	467	java/lang/Exception
    //   718	737	467	java/lang/Exception
    //   523	528	531	java/io/IOException
    //   129	214	594	java/lang/Exception
    //   214	231	594	java/lang/Exception
    //   535	551	594	java/lang/Exception
    //   551	591	594	java/lang/Exception
    //   658	674	594	java/lang/Exception
    //   674	714	594	java/lang/Exception
    //   408	419	717	java/lang/Exception
  }
  
  protected boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return true;
      jdField_a_of_type_Boolean = true;
      String[] arrayOfString = BaseApplicationImpl.processName.split(":");
      str = null;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
      if ((str == null) || (str.endsWith("map")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")) || (str.equals("readinjoy")) || (str.endsWith("nearby")) || (str.equals("tool")))
      {
        if ("tool".equals(str))
        {
          b();
          return true;
        }
        initSkin(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
      if (str.equals("qzone"))
      {
        c(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
      if (str.equals("web"))
      {
        a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
    } while (!str.equals("qqfav"));
    b(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\InitSkin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
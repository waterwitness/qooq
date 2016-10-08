package com.tencent.mobileqq.shortvideo.common;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GloableValue
{
  public static final int a = 51408;
  public static long a = 0L;
  public static Context a;
  public static final String a;
  public static final boolean a = false;
  public static final int[] a;
  public static final int b = 1064;
  public static String b;
  public static final int[] b;
  public static int c = 0;
  public static String c;
  public static final int[] c;
  public static int d = 0;
  private static String d;
  public static final int[] d;
  public static int e = 0;
  private static String e;
  public static final int[] e;
  public static int f = 0;
  private static String f;
  public static final int[] f;
  public static final int g = 1;
  private static String g;
  public static final int[] g;
  public static final int h = 320;
  private static String h;
  public static final int[] h;
  public static final int i = 4;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = GloableValue.class.getSimpleName();
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.a();
    jdField_a_of_type_Long = -1L;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 1;
    jdField_e_of_type_Int = 640;
    jdField_f_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_g_of_type_ArrayOfInt = new int[] { 1280, 800 };
    jdField_h_of_type_ArrayOfInt = new int[] { 720, 480 };
  }
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.a().getSystemService("audio");
      int k = localAudioManager.requestAudioFocus(null, 3, 2);
      int j = k;
      if (k == 0) {
        j = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (j == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              bool1 = FileUtils.a();
              if (!bool1)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
                }
                return bool1;
              }
              paramContext = StorageManager.a().jdField_d_of_type_JavaLangString;
              if (!TextUtils.isEmpty(paramContext)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("initDirs", 2, "sdcardDirPath = empty");
            return false;
            if (QLog.isColorLevel()) {
              QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + paramContext);
            }
            localFile = new File(paramContext);
            if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite())) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
          return false;
          jdField_b_of_type_JavaLangString = paramContext + File.separator + "Cover" + File.separator + paramLong;
          localFile = new File(jdField_b_of_type_JavaLangString);
          bool1 = localFile.mkdirs();
          bool2 = localFile.isDirectory();
          if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "coverFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
          }
        } while ((!bool1) && (!bool2));
        jdField_c_of_type_JavaLangString = paramContext + File.separator + "trimvideo" + File.separator + paramLong;
        File localFile = new File(jdField_c_of_type_JavaLangString);
        bool1 = localFile.mkdirs();
        bool2 = localFile.isDirectory();
        if (QLog.isColorLevel()) {
          QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
        }
      } while ((!bool1) && (!bool2));
      jdField_g_of_type_JavaLangString = paramContext + "/Product";
      jdField_f_of_type_JavaLangString = paramContext + "/Material";
      jdField_h_of_type_JavaLangString = jdField_f_of_type_JavaLangString + "/ProcessedMaterial";
      jdField_d_of_type_JavaLangString = paramContext + "/log.txt";
      jdField_e_of_type_JavaLangString = paramContext + File.separator + "Source" + File.separator + paramLong;
      paramContext = new File(jdField_e_of_type_JavaLangString);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
      }
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public static boolean a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "GloableValue[init]context=" + paramContext);
      }
    }
    do
    {
      return false;
      if ((jdField_a_of_type_Long > 0L) && ((paramLong <= 0L) || (jdField_a_of_type_Long == paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "GloableValue[init]sUin=" + jdField_a_of_type_Long + "uin=" + paramLong);
        }
        return true;
      }
      jdField_a_of_type_Long = paramLong;
    } while ((!a(paramLong, paramContext)) || (!a(paramLong + "", paramContext, paramInt1, paramInt2)));
    return true;
  }
  
  public static boolean a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    String str = StorageManager.a().jdField_d_of_type_JavaLangString;
    Object localObject = new MessageStruct(6);
    ((MessageStruct)localObject).mObj0 = ("{\"uin\":\"" + paramString + "\",\"maxVideoMainPath\":\"" + str + "\",\"logFilePath\":\"" + jdField_d_of_type_JavaLangString + "\",\"avSourceFilesDirPath\":\"" + jdField_e_of_type_JavaLangString + "\",\"avProductFilesDirPath\":\"" + jdField_g_of_type_JavaLangString + "\",\"materialFilesDirPath\":\"" + jdField_f_of_type_JavaLangString + "\",\"processedMaterialDirPath\":\"" + jdField_h_of_type_JavaLangString + "\",\"maxDuration\":" + CodecParam.jdField_d_of_type_Int + ",\"defaultFPS\":" + CodecParam.g + ",\"videoWidth\":" + paramInt1 + ",\"videoHeight\":" + paramInt2 + ",\"avBatchVersion\":" + 0 + ",\"isUseOpenGLDraw\":" + "true" + "}");
    GlobalInit.nativeSyncProcessMsg((MessageStruct)localObject, null, null);
    try
    {
      localObject = paramContext.getResources().openRawResource(2131165211);
      paramString = new byte[((InputStream)localObject).available()];
      ((InputStream)localObject).read(paramString);
      ((InputStream)localObject).close();
      localObject = new FileOutputStream(new File(str + "/videoplayer_vp.vp"));
      ((FileOutputStream)localObject).write(paramString);
      ((FileOutputStream)localObject).close();
      paramContext = paramContext.getResources().openRawResource(2131165210);
      paramString = new byte[paramContext.available()];
      paramContext.read(paramString);
      paramContext.close();
      paramContext = new FileOutputStream(new File(str + "/videoplayer_fp.fp"));
      paramContext.write(paramString);
      paramContext.close();
      return true;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    catch (FileNotFoundException paramString)
    {
      for (;;) {}
    }
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)VideoEnvironment.a().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void c()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    jdField_a_of_type_Long = -1L;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\common\GloableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
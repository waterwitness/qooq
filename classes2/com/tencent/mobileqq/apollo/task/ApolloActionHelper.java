package com.tencent.mobileqq.apollo.task;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ApolloActionHelper
{
  public static final int a = 5;
  public static final String a = "ApolloActionHelper";
  public static final int b = 6;
  public static final String b = "music.amr";
  public static final int c = 21;
  public static final int d = 0;
  public static final int e = 1000;
  public static final int f = 40;
  public static final int g = 40;
  
  public ApolloActionHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRandomActionId], roleId:" + paramInt);
    }
    File localFile = new File(ApolloConstant.n, paramInt + "/" + ApolloConstant.A + "/");
    if (!localFile.exists()) {}
    for (;;)
    {
      return -1;
      Object localObject = localFile.list();
      if ((localObject == null) || (localObject.length == 0))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloActionHelper", 2, "no any action file.");
          return -1;
        }
      }
      else
      {
        paramInt = PngFrameUtil.a(localObject.length);
        localObject = localObject[paramInt];
        try
        {
          int i = Integer.parseInt((String)localObject);
          if (!new File(localFile.getPath(), (String)localObject + "/" + ApolloConstant.r).exists())
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloActionHelper", 2, "json not exist.");
              return -1;
            }
          }
          else if (!new File(localFile.getPath(), (String)localObject + "/" + ApolloConstant.q).exists())
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloActionHelper", 2, "png not exist.");
              return -1;
            }
          }
          else if (!new File(localFile.getPath(), (String)localObject + "/" + ApolloConstant.s).exists())
          {
            if (QLog.isColorLevel())
            {
              QLog.d("ApolloActionHelper", 2, "atlas not exist.");
              return -1;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloActionHelper", 2, "value:" + paramInt + ",actionId:" + (String)localObject);
            }
            return i;
          }
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    return -1;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloFuncSwitch], uin:" + paramString);
    }
    paramString = ((ApolloManager)paramQQAppInterface.getManager(152)).b(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
  
  public static String a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRoleLuaString], roleType:" + paramInt1 + ",roleId:" + paramInt2);
    }
    String str1 = "";
    String str2 = a(0, paramInt1, paramInt2);
    if (1 == paramInt1) {
      str1 = String.format("%s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s');", new Object[] { "me", "me", str2, str2, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(0.0F), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null" });
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, str1);
      }
      return str1;
      if (2 == paramInt1) {
        str1 = String.format("%s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s');", new Object[] { "friend", "friend", str2, str2, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(180.0F), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null" });
      }
    }
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloRsc], roleType:" + paramInt2 + ",roleType:" + paramInt2 + ",id:" + paramInt3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "rsc:" + localStringBuilder);
      }
      return localStringBuilder.toString();
    case 1: 
      if (paramInt3 < 21) {
        localStringBuilder.append("def/dress/");
      }
      for (;;)
      {
        localStringBuilder.append(paramInt3);
        localStringBuilder.append("/dress");
        break;
        localStringBuilder.append("dress/");
      }
    }
    if (paramInt3 == 0) {
      localStringBuilder.append("def/role/");
    }
    for (;;)
    {
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("/role");
      break;
      localStringBuilder.append("role/");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getBubbleLuaString], roleType:" + paramInt1 + ",bubbleId" + paramInt2 + ",roleId:" + paramInt3);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt3 == 0) || (!ApolloUtil.b(paramInt3, paramInt2)))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
      localStringBuilder.append("/");
      localStringBuilder.append(ApolloConstant.z);
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      if (2 != paramInt1) {
        break label196;
      }
    }
    label196:
    for (String str = "friend";; str = "me")
    {
      paramString = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { str, localStringBuilder, localStringBuilder, paramString });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, paramString);
      }
      return paramString;
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt3);
      break;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveBubbleLuaString], roleType:" + paramInt + ",bubbleName" + paramString);
    }
    if (2 == paramInt) {}
    for (String str = "friend";; str = "me")
    {
      paramString = String.format("%s:removeAccessory('%s');", new Object[] { str, paramString });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, paramString);
      }
      return paramString;
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new StringTokenizer(paramString, "@$");
    int i = PngFrameUtil.a(paramString.countTokens());
    while (paramString.hasMoreTokens())
    {
      i -= 1;
      if (i < 0) {
        return paramString.nextToken();
      }
      paramString.nextToken();
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ApolloTaskParam paramApolloTaskParam, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[doActionReport], isHasUsrText:" + paramBoolean1 + ",isBarrage:" + paramBoolean2);
    }
    if ((paramApolloTaskParam == null) || (paramQQAppInterface == null)) {}
    ApolloActionData localApolloActionData;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "taskParam:" + paramApolloTaskParam.toString());
      }
      localApolloActionData = ((ApolloDaoManager)paramQQAppInterface.getManager(154)).a(paramApolloTaskParam.b);
    } while (localApolloActionData == null);
    String str1 = "";
    int i = 0;
    int j;
    label126:
    String str4;
    String str2;
    if (ApolloActionManager.a().a() == null)
    {
      j = 0;
      str4 = Integer.toString(paramApolloTaskParam.b);
      if (!paramBoolean1) {
        break label620;
      }
      if (!paramBoolean2) {
        break label350;
      }
      str2 = "2";
    }
    for (;;)
    {
      label148:
      label160:
      label178:
      String str3;
      if (paramApolloTaskParam.e == 0)
      {
        str1 = "action_play";
        if (paramApolloTaskParam.d != 2) {
          break label398;
        }
        if (!paramApolloTaskParam.a) {
          break label392;
        }
        i = 2;
        if (localApolloActionData.hasSound) {
          break label425;
        }
        str3 = "0";
        label191:
        if (a(localApolloActionData.vibrate) != null) {
          break label558;
        }
        paramApolloTaskParam = "0";
      }
      for (;;)
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", str1, i, j, new String[] { str4, str2, str3, paramApolloTaskParam });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloActionHelper", 2, "actionName:" + str1 + ",entry:" + i + ",result:" + j + ",r2:" + str4 + ",r3:" + str2 + ",r4:" + str3 + ",r5:" + paramApolloTaskParam);
        return;
        j = 1;
        break label126;
        label350:
        str2 = "1";
        break label148;
        if (paramApolloTaskParam.e == 1)
        {
          str1 = "g_action_play";
          break label160;
        }
        if (paramApolloTaskParam.e != 3000) {
          break label160;
        }
        str1 = "d_action_play";
        break label160;
        label392:
        i = 3;
        break label178;
        label398:
        if (paramApolloTaskParam.d == 0)
        {
          i = 0;
          break label178;
        }
        if (paramApolloTaskParam.d != 1) {
          break label178;
        }
        i = 1;
        break label178;
        label425:
        if ((1 == paramQQAppInterface.d()) && (((paramApolloTaskParam.e != 1) && (paramApolloTaskParam.e != 3000)) || (((1 == paramQQAppInterface.b()) || (paramApolloTaskParam.e == 0)) && (!paramQQAppInterface.k()) && (!paramQQAppInterface.l()) && (paramQQAppInterface.m()) && (!MediaPlayerManager.a(paramQQAppInterface).b()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().f())) && (!paramQQAppInterface.d()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().g())))))
        {
          str3 = "1";
          break label191;
        }
        str3 = "2";
        break label191;
        label558:
        if ((1 == paramQQAppInterface.e()) && (((paramApolloTaskParam.e != 1) && (paramApolloTaskParam.e != 3000)) || (((1 == paramQQAppInterface.c()) || (paramApolloTaskParam.e == 0)) && (!paramQQAppInterface.l())))) {
          paramApolloTaskParam = "1";
        } else {
          paramApolloTaskParam = "2";
        }
      }
      label620:
      str2 = "0";
    }
  }
  
  public static void a(ApolloActionData paramApolloActionData, QQAppInterface paramQQAppInterface)
  {
    if ((paramApolloActionData == null) || (paramQQAppInterface == null)) {
      if (!QLog.isColorLevel()) {}
    }
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (paramApolloActionData.hasSound) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("audio_switch", 2, "NO sound config.");
                  return;
                  if (1 == paramQQAppInterface.d()) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("audio_switch", 2, "getALLGeneralSettingRing == 1");
                return;
                if (!paramQQAppInterface.k()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("audio_switch", 2, "isRingerVibrate == true");
              return;
              if (paramQQAppInterface.m()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("audio_switch", 2, "isCallIdle == false");
            return;
            if (!MediaPlayerManager.a(paramQQAppInterface).b()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("audio_switch", 2, "ptt is playing");
          return;
          if ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().f())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("audio_switch", 2, "isRecordingOrPlaying == true");
        return;
        if ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().g())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("audio_switch", 2, "isPTVRecording == true");
      return;
      if (!paramQQAppInterface.d()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("audio_switch", 2, "isVideoChatting == true");
    return;
    QLog.d("audio_switch", 2, "CM sound can be played now.");
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface)
  {
    return a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, null);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface, ApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[isRscValid], roleId:" + paramInt + ",dressId:" + paramArrayOfInt);
    }
    if (paramArrayOfInt == null) {
      return false;
    }
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = true;
    if (!ApolloUtil.c(paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "need download role id:" + paramInt);
      }
      bool = false;
    }
    for (;;)
    {
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        if (ApolloUtil.b(paramArrayOfInt[i])) {
          break label328;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "need download dress id:" + paramArrayOfInt[i]);
        }
        bool = false;
      }
      label325:
      label328:
      for (;;)
      {
        i += 1;
        break;
        if (!bool)
        {
          paramArrayOfInt = arrayOfInt;
          if (localArrayList.size() > 0)
          {
            arrayOfInt = new int[localArrayList.size()];
            i = 0;
            for (;;)
            {
              paramArrayOfInt = arrayOfInt;
              if (i >= localArrayList.size()) {
                break;
              }
              arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
              i += 1;
            }
          }
          if (paramQQAppInterface != null)
          {
            if (paramOnApolloDownLoadListener != null) {
              break label325;
            }
            paramOnApolloDownLoadListener = ((ApolloManager)paramQQAppInterface.getManager(152)).a();
          }
        }
        for (;;)
        {
          ApolloResDownloader.a(paramQQAppInterface, paramString, paramOnApolloDownLoadListener, paramInt, paramArrayOfInt, -1, -1, false);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "ret:" + bool);
          }
          return bool;
        }
      }
      paramInt = -1;
    }
  }
  
  public static long[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long[] arrayOfLong;
    for (;;)
    {
      return null;
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length != 0))
      {
        arrayOfLong = new long[paramString.length];
        i = 0;
        try
        {
          while (i < paramString.length)
          {
            arrayOfLong[i] = Integer.parseInt(paramString[i].trim());
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramString) {}
      }
    }
    QLog.d("ApolloActionHelper", 2, "errInfo->NumberFormatException, e:" + paramString.getMessage());
    return null;
    int i = paramString.length - 2;
    while (i >= 2)
    {
      arrayOfLong[i] = (arrayOfLong[i] - arrayOfLong[(i - 1)] - arrayOfLong[(i - 2)]);
      i -= 2;
    }
    return arrayOfLong;
  }
  
  public static Object[] a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRoldIdByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    Object localObject1 = ApolloResDownloader.a(0);
    Object localObject2 = ((ApolloManager)paramQQAppInterface.getManager(152)).b(paramString);
    int i;
    ApolloDress[] arrayOfApolloDress;
    int j;
    if (localObject2 != null)
    {
      i = ((ApolloBaseInfo)localObject2).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + ((ApolloBaseInfo)localObject2).uin + ", funcSwitch:" + i);
      }
      if (1 != i) {
        return new Object[] { Integer.valueOf(0), localObject1 };
      }
      arrayOfApolloDress = ((ApolloBaseInfo)localObject2).getApolloDress(false);
      if ((arrayOfApolloDress != null) && (arrayOfApolloDress.length > 0))
      {
        j = arrayOfApolloDress.length;
        i = 0;
        if (i >= j) {
          break label564;
        }
        ApolloDress localApolloDress = arrayOfApolloDress[i];
        localObject2 = localApolloDress.a();
        if (a(paramString, localApolloDress.a, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid role and dress RSC.");
          }
          i = localApolloDress.a;
          localObject1 = localObject2;
          j = 1;
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = ApolloResDownloader.a(arrayOfApolloDress[0].a);
        if (a(paramString, arrayOfApolloDress[0].a, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid basic dress.");
          }
          j = arrayOfApolloDress[0].a;
          paramString = (String)localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
            i = j;
            paramString = (String)localObject2;
          }
        }
      }
      for (;;)
      {
        label328:
        localObject1 = paramString;
        for (;;)
        {
          paramString = new StringBuilder();
          paramString.append("******roleId:[");
          paramString.append(i);
          paramString.append("],");
          paramString.append("dress:[");
          j = 0;
          while (j < localObject1.length)
          {
            if (j != 0) {
              paramString.append(",");
            }
            paramString.append(localObject1[j]);
            j += 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "try to get history dress ....");
          }
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "uin: " + paramString + " dress is null");
          }
          paramString = (String)localObject1;
          i = 0;
          break label328;
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject2);
          }
          i = 0;
        }
        paramString.append("]****");
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, paramString.toString());
        }
        return new Object[] { Integer.valueOf(i), localObject1 };
        paramString = (String)localObject1;
      }
      label564:
      j = 0;
      i = 0;
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getActionLuaString], roleType:" + paramInt1 + ",actionId:" + paramInt2 + ",taskId:" + paramInt3 + ",animName:" + paramString2 + ",actionRscName:" + paramString1);
    }
    String[] arrayOfString = new String[2];
    if (2 == paramInt1) {}
    for (String str1 = "friend";; str1 = "me")
    {
      String str2 = paramString2;
      if (paramString1.contains("_peer")) {
        str2 = paramString2 + "_peer";
      }
      arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { str1, paramString1, paramString1, str2 });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, arrayOfString[0]);
      }
      arrayOfString[1] = String.format("%s:setAnimation(%d, '%s', false);", new Object[] { str1, Integer.valueOf(paramInt3), str2 });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, arrayOfString[1]);
      }
      return arrayOfString;
    }
  }
  
  public static String[] a(int paramInt, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getDressLuaString], roleType:" + paramInt + ",dressId:" + paramArrayOfInt);
    }
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->dressId is null");
      }
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfInt.length];
    if (2 == paramInt) {}
    for (String str1 = "friend";; str1 = "me")
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        String str2 = a(1, paramInt, paramArrayOfInt[i]);
        arrayOfString[i] = String.format("setAccessory(%s, '%s', '%s');", new Object[] { str1, str2, str2 });
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, arrayOfString[i]);
        }
        i += 1;
      }
    }
    return arrayOfString;
  }
  
  public static String b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveActionLuaString], roleType:" + paramInt + ",actionName" + paramString);
    }
    if (2 == paramInt) {}
    for (String str = "friend";; str = "me")
    {
      paramString = String.format("%s:removeAccessoryAnimation('%s');", new Object[] { str, paramString });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, paramString);
      }
      return paramString;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloActionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
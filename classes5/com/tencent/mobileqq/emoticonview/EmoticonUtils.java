package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import mqq.os.MqqHandler;

public class EmoticonUtils
{
  public static String a = "http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].gif";
  public static String b = "http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json";
  public static String c = "http://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/[eId].png";
  public static String d = "http://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/ring.amr";
  public static String e = "http://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/pngframe.zip";
  public static String f = "http://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/126x126.png";
  public static String g = "http://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]";
  public static String h = "http://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]x[height].png";
  public static String i = AppConstants.cW + "[epId]" + File.separator;
  public static String j = AppConstants.bU + "[epId]" + File.separator;
  public static String k = j + "[eId].amr";
  public static String l = j + "[eId]_thu.png";
  public static String m = j + "[eId]_aio.png";
  public static String n = j + "[epId].jtmp";
  public static String o = j + "[eId]";
  public static String p = j + "h5magic" + File.separator;
  public static String q = p + "index.html";
  public static String r = p + "fileList";
  public static String s = j + "[epId].zip";
  public static String t = j + "pngframe/";
  private static final String u = "EmoticonUtils";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(new EmotionPanelInfo(7, 7, null));
    paramQQAppInterface.add(new EmotionPanelInfo(4, 4, null));
    return paramQQAppInterface;
  }
  
  public static void a(QQText.EmotcationSpan[] paramArrayOfEmotcationSpan, float paramFloat1, float paramFloat2, boolean paramBoolean1, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Activity paramActivity, boolean paramBoolean2)
  {
    if ((paramArrayOfEmotcationSpan == null) || (paramQQAppInterface == null) || (paramSessionInfo == null) || (paramActivity == null)) {}
    Object localObject1;
    int i2;
    do
    {
      return;
      localObject1 = new TreeSet();
      int i1 = 0;
      i2 = paramInt1;
      paramInt1 = i1;
      while (paramInt1 < paramArrayOfEmotcationSpan.length)
      {
        Object localObject2 = paramArrayOfEmotcationSpan[paramInt1];
        boolean bool = paramBoolean1;
        int i3 = i2;
        i1 = paramInt2;
        if ((localObject2 instanceof QQText.SmallEmojiSpan))
        {
          localObject2 = (QQText.SmallEmojiSpan)localObject2;
          float f1 = ((QQText.SmallEmojiSpan)localObject2).a;
          float f2 = ((QQText.SmallEmojiSpan)localObject2).b;
          float f3 = ((QQText.SmallEmojiSpan)localObject2).c;
          float f4 = ((QQText.SmallEmojiSpan)localObject2).d;
          int i4 = ((QQText.SmallEmojiSpan)localObject2).f;
          int i5 = ((QQText.SmallEmojiSpan)localObject2).g;
          ((TreeSet)localObject1).add(Integer.valueOf(i4));
          bool = paramBoolean1;
          i3 = i2;
          i1 = paramInt2;
          if (!paramBoolean2)
          {
            bool = paramBoolean1;
            i3 = i2;
            i1 = paramInt2;
            if (paramFloat1 >= f1)
            {
              bool = paramBoolean1;
              i3 = i2;
              i1 = paramInt2;
              if (paramFloat1 <= f3)
              {
                bool = paramBoolean1;
                i3 = i2;
                i1 = paramInt2;
                if (paramFloat2 >= f2)
                {
                  bool = paramBoolean1;
                  i3 = i2;
                  i1 = paramInt2;
                  if (paramFloat2 <= f4)
                  {
                    bool = paramBoolean1;
                    i3 = i2;
                    i1 = paramInt2;
                    if (!paramBoolean1)
                    {
                      bool = true;
                      i1 = i5;
                      i3 = i4;
                    }
                  }
                }
              }
            }
          }
        }
        paramInt1 += 1;
        paramBoolean1 = bool;
        i2 = i3;
        paramInt2 = i1;
      }
    } while (!paramBoolean1);
    if (((TreeSet)localObject1).size() == 1)
    {
      if ((((EmoticonManager)paramQQAppInterface.getManager(13)).b(String.valueOf(i2)) != null) && (paramSessionInfo.a != 1008) && (paramSessionInfo.a != 1000) && (paramSessionInfo.a != 1001) && (paramSessionInfo.a != 1002) && (paramSessionInfo.a != 1003) && (paramSessionInfo.a != 1004) && (paramSessionInfo.a != 1005) && (paramSessionInfo.a != 1006))
      {
        paramArrayOfEmotcationSpan = paramQQAppInterface.a(ChatActivity.class);
        if (paramArrayOfEmotcationSpan != null) {
          paramArrayOfEmotcationSpan.obtainMessage(22, String.valueOf(i2)).sendToTarget();
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8006FFE", 0, 0, String.valueOf(i2), String.valueOf(paramInt2), "", "");
        return;
      }
      EmojiHomeUiPlugin.openEmojiDetailPage(paramActivity, paramQQAppInterface.getAccount(), 8, String.valueOf(i2), false, true);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8006FFF", 0, 0, String.valueOf(i2), String.valueOf(paramInt2), "", "");
      return;
    }
    paramSessionInfo = ((TreeSet)localObject1).iterator();
    for (paramArrayOfEmotcationSpan = ""; paramSessionInfo.hasNext(); paramArrayOfEmotcationSpan = paramArrayOfEmotcationSpan + localObject1 + ",") {
      localObject1 = (Integer)paramSessionInfo.next();
    }
    paramSessionInfo = paramArrayOfEmotcationSpan;
    if (!paramArrayOfEmotcationSpan.equals("")) {
      paramSessionInfo = paramArrayOfEmotcationSpan.substring(0, paramArrayOfEmotcationSpan.length() - 1);
    }
    EmojiHomeUiPlugin.openSmallEmojiListPage(paramActivity, paramQQAppInterface.getAccount(), 11, paramSessionInfo);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8007000", 0, 0, String.valueOf(i2), String.valueOf(paramInt2), "", "");
  }
  
  public static boolean a()
  {
    int i1 = NetworkUtil.a(BaseApplication.getContext());
    return (i1 == 1) || (i1 == 3) || (i1 == 4);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static byte[] a(String paramString)
  {
    int i2 = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfByte[i1] = Integer.valueOf(paramString.substring(i1 * 2, i1 * 2 + 2), 16).byteValue();
      i1 += 1;
    }
    return arrayOfByte;
  }
  
  public static List b(QQAppInterface paramQQAppInterface)
  {
    long l1 = System.currentTimeMillis();
    List localList = Collections.synchronizedList(new ArrayList());
    paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(13);
    Object localObject = paramQQAppInterface.a();
    localList.add(new EmotionPanelInfo(7, 7, null));
    localList.add(new EmotionPanelInfo(4, 4, null));
    if (paramQQAppInterface.a(false).size() > 0) {
      localList.add(new EmotionPanelInfo(8, 3, null));
    }
    int i1;
    EmoticonPackage localEmoticonPackage;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i1 = 0;
      if (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if ((localEmoticonPackage.type != 1) && (3 != localEmoticonPackage.jobType) && (1 != localEmoticonPackage.jobType) && (5 != localEmoticonPackage.jobType)) {
          if (localEmoticonPackage.jobType == 4) {
            paramQQAppInterface = new EmotionPanelInfo(10, 7, localEmoticonPackage);
          }
        }
      }
    }
    for (;;)
    {
      label184:
      int i2 = i1;
      if (paramQQAppInterface != null)
      {
        localList.add(paramQQAppInterface);
        i2 = i1;
      }
      for (;;)
      {
        EmoticonTabAdapter.a(localEmoticonPackage.epId);
        i1 = i2;
        break;
        if (localEmoticonPackage.jobType != 0) {
          break label337;
        }
        paramQQAppInterface = new EmotionPanelInfo(6, 4, localEmoticonPackage);
        break label184;
        if (3 != localEmoticonPackage.jobType)
        {
          i2 = i1;
          if (5 != localEmoticonPackage.jobType) {}
        }
        else
        {
          i2 = i1;
          if (i1 == 0)
          {
            localList.add(new EmotionPanelInfo(9, 4, localEmoticonPackage));
            i2 = 1;
          }
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonUtils", 2, "prepare data cost time:" + (l2 - l1));
      }
      return localList;
      label337:
      paramQQAppInterface = null;
    }
  }
  
  public static boolean b()
  {
    return NetworkUtil.a(BaseApplication.getContext()) == 1;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean c()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    int i1 = NetworkUtil.a(localBaseApplication);
    boolean bool = SettingCloneUtil.readValue(localBaseApplication, null, localBaseApplication.getString(2131367826), "qqsetting_auto_receive_magic_face_key", true);
    return ((i1 == 3) || (i1 == 4)) && (!bool);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
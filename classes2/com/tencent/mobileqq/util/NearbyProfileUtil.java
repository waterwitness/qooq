package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;
import vyv;
import vyw;

public class NearbyProfileUtil
{
  public static final int a = -1;
  public static final int[] a;
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "男", "女" };
    b = new String[] { "保密", "单身", "恋爱中", "已婚" };
    c = new String[] { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    d = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    e = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841115, 2130840545, 2130840545, 2130840545, 2130840989, 2130840989, 2130841180, 2130841180, 2130840875, 2130840875, 2130840875, 2130841115, 2130841115, 2130841007, 2130841115 };
  }
  
  public static final int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return jdField_a_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = j;
    flower_info.SFlowerInfoRsp localSFlowerInfoRsp;
    if (paramArrayOfByte != null) {
      localSFlowerInfoRsp = new flower_info.SFlowerInfoRsp();
    }
    try
    {
      localSFlowerInfoRsp.mergeFrom(paramArrayOfByte);
      i = j;
      if (localSFlowerInfoRsp.num.has()) {
        i = localSFlowerInfoRsp.num.get();
      }
      return i;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private static final long a()
  {
    return 0L | 0x4 | 0x800 | 0x1000;
  }
  
  public static final String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < b.length)) {
      return b[paramInt];
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localBundle.putShort("key_flower_visible_switch", (short)i);
      localBundle.putBoolean("key_nearby_people_card_force_update", true);
      NearbyCardHandler localNearbyCardHandler = (NearbyCardHandler)paramQQAppInterface.a(60);
      if (localNearbyCardHandler == null) {
        break;
      }
      paramQQAppInterface.a(new vyw(localNearbyCardHandler, localBundle));
      return;
    }
  }
  
  public static final void a(NearbyCardHandler paramNearbyCardHandler, QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt)
  {
    paramQQAppInterface.a(new vyv(paramQQAppInterface, paramLong, paramString, paramNearbyCardHandler, paramInt));
  }
  
  public static final void a(NearbyCardHandler paramNearbyCardHandler, QQAppInterface paramQQAppInterface, long paramLong1, String paramString, int paramInt, byte[] paramArrayOfByte, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    if (paramLong1 > 0L) {
      if (ProfileActivity.c(paramInt)) {
        paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 45, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
      }
    }
    while (StringUtil.b(paramString))
    {
      return;
      if (ProfileActivity.a(paramInt))
      {
        paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 39, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
        return;
      }
      if (paramInt == 16)
      {
        paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 46, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
        return;
      }
      if (paramInt == 38)
      {
        paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 47, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
        return;
      }
      if (paramInt == 100)
      {
        paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 49, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
        return;
      }
      paramNearbyCardHandler.a(paramQQAppInterface.a(), "0", 41, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean, paramLong3);
      return;
    }
    if (paramString.equals(paramQQAppInterface.a()))
    {
      paramNearbyCardHandler.a(paramQQAppInterface.a(), paramQQAppInterface.a(), 0, 0L, (byte)0, 0L, 0L, null, "", a(), 10004, null, 0L, true, paramBoolean, paramLong3);
      return;
    }
    int i = 6;
    if (ProfileActivity.b(paramInt)) {
      i = 42;
    }
    for (;;)
    {
      paramNearbyCardHandler.a(paramQQAppInterface.a(), paramString, i, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, 0L, true, paramBoolean, paramLong3);
      return;
      if (ProfileActivity.c(paramInt)) {
        i = 45;
      } else if (ProfileActivity.a(paramInt)) {
        i = 39;
      } else if (paramInt == 16) {
        i = 46;
      } else if (paramInt == 38) {
        i = 47;
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt >= 0) && (paramInt < d.length));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return true;
    }
    String str = paramQQAppInterface.a();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    paramQQAppInterface = null;
    Object localObject = null;
    if (localEntityManager != null)
    {
      paramQQAppInterface = (QQAppInterface)localObject;
      if (!StringUtil.b(str)) {
        paramQQAppInterface = (NearbyPeopleCard)localEntityManager.a(NearbyPeopleCard.class, "uin=?", new String[] { str });
      }
      localEntityManager.a();
    }
    boolean bool;
    if (paramQQAppInterface != null) {
      if (paramQQAppInterface.switchGiftVisible == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  public static final String[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    label159:
    label164:
    label167:
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = new flower_info.SFlowerInfoRsp();
        ((flower_info.SFlowerInfoRsp)localObject).mergeFrom(paramArrayOfByte);
        if (!((flower_info.SFlowerInfoRsp)localObject).rpt_flower_url.has()) {
          break label159;
        }
        paramArrayOfByte = ((flower_info.SFlowerInfoRsp)localObject).rpt_flower_url.get();
        if (!((flower_info.SFlowerInfoRsp)localObject).flower_msg_tips.has()) {
          break label164;
        }
        localObject = ((flower_info.SFlowerInfoRsp)localObject).flower_msg_tips.get();
      }
      catch (Throwable paramArrayOfByte)
      {
        int i;
        String[] arrayOfString;
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyProfileUtil", 2, "getFlowerInfo, catch exception", paramArrayOfByte);
        return null;
      }
      if (paramArrayOfByte.size() > 3)
      {
        i = 3;
        arrayOfString = new String[i + 1];
        arrayOfString[0] = localObject;
        j = 0;
        if (j < i)
        {
          arrayOfString[(j + 1)] = ((String)paramArrayOfByte.get(j));
          j += 1;
          continue;
        }
      }
      else
      {
        i = paramArrayOfByte.size();
        continue;
      }
      return arrayOfString;
      for (;;)
      {
        if ((paramArrayOfByte != null) && (localObject != null)) {
          break label167;
        }
        return null;
        paramArrayOfByte = null;
        break;
        localObject = null;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    if (ProfileActivity.b(paramInt)) {
      return 3;
    }
    if (paramInt == 21) {
      return 4;
    }
    if (ProfileActivity.c(paramInt)) {
      return 5;
    }
    return 99;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "";
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return c[paramInt];
    }
    return "";
  }
  
  public static final String d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return e[paramInt];
    }
    return "";
  }
  
  public static final String e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 14)) {
      return d[paramInt];
    }
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\util\NearbyProfileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
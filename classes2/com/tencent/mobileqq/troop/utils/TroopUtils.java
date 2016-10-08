package com.tencent.mobileqq.troop.utils;

import NearbyGroup.GroupInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.RecommendTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import mqq.manager.TicketManager;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopUtils
{
  public static final int a = 4194304;
  public static final long a = 259200000L;
  public static final String a = "vistor_type";
  protected static HashSet a;
  private static boolean a = false;
  public static final int b = 0;
  public static final String b = "TroopUtils";
  public static final int c = 1;
  public static final String c = "bid = ?";
  public static final int d = 1000;
  protected static String d;
  public static final int e = 1001;
  protected static String e;
  public static final int f = 1;
  public static final String f = "TroopContactsGrayConfig";
  public static final int g = 2;
  public static final String g = "http://qinfo.clt.qq.com/cgi-bin/qun_office/set_group_officemode";
  public static final String h = "http://qinfo.clt.qq.com/cgi-bin/qun_office/get_group_officemode";
  public static final String i = "getTroopContactsmode_onetime";
  public static final String j = "showbluetipsofmodifytroopmembercard_";
  public static final String k = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final String l = "t_s_f";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    d = "http://qqweb.qq.com/m/qunopen/appstore/index.html?_wv=1031&_bid=2195&gc=";
    e = "http://qqweb.qq.com/m/qunactivity/index.html?_wv=3&_bid=244&from=aio&groupuin=";
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 3;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
    if (paramString != null)
    {
      if (paramString.isTroopOwner(paramQQAppInterface.a())) {
        return 0;
      }
      if (paramString.isTroopAdmin(paramQQAppInterface.a())) {
        return 1;
      }
      if (TroopInfo.isTroopMember(paramQQAppInterface, paramQQAppInterface.a())) {
        return 2;
      }
    }
    return 3;
  }
  
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public static BitmapFactory.Options a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i2 = localOptions.outHeight;
    int i1 = localOptions.outWidth;
    int i3 = i2 * i1 * 4;
    int n;
    if (i2 > i1)
    {
      m = i1;
      n = m;
      if (i3 > 4194304)
      {
        double d1 = Math.sqrt(i3 / 4194304.0D);
        n = (int)(m / d1);
      }
      m = i2;
      i3 = 1;
      i2 = i1;
      i1 = i3;
      label96:
      if ((m > n) && (i2 > n))
      {
        if (Math.min(Math.round(m / n), Math.round(i2 / n)) < 2) {
          break label237;
        }
        i2 /= 2;
        m /= 2;
        if ((i2 >= n) && (m >= n)) {
          break label203;
        }
        localOptions.inSampleSize = i1;
      }
      label169:
      localOptions.inJustDecodeBounds = false;
      if (localOptions.inSampleSize < 1) {
        break label246;
      }
    }
    label203:
    label237:
    label246:
    for (int m = localOptions.inSampleSize;; m = 1)
    {
      localOptions.inSampleSize = m;
      return localOptions;
      m = i2;
      break;
      if ((i2 == n) || (m == n))
      {
        localOptions.inSampleSize = (i1 * 2);
        break label169;
      }
      i1 *= 2;
      break label96;
      localOptions.inSampleSize = i1;
      break label169;
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    Drawable localDrawable = paramResources.getDrawable(2130842955);
    if (Build.VERSION.SDK_INT <= 10) {}
    for (paramResources = localDrawable.getConstantState().newDrawable(paramResources);; paramResources = localDrawable.getConstantState().newDrawable(paramResources).mutate())
    {
      paramResources.setColorFilter(new LightingColorFilter(-16777216, paramInt));
      paramResources.setAlpha(paramInt >>> 24);
      return paramResources;
    }
  }
  
  public static Bundle a(int paramInt1, GroupInfo paramGroupInfo, int paramInt2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.lCode));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.lUin));
    localBundle.putString("troop_info_name", paramGroupInfo.strName);
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.iFaceId);
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.strIntro);
    localBundle.putString("troop_info_loca", paramGroupInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwCertType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.iMemberCnt);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", (int)paramGroupInfo.dwGroupActiveGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, RecommendTroopInfo paramRecommendTroopInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramRecommendTroopInfo.uin));
    localBundle.putString("troop_code", String.valueOf(paramRecommendTroopInfo.code));
    localBundle.putString("troop_info_name", paramRecommendTroopInfo.name);
    localBundle.putByte("troop_info_opt", (byte)paramRecommendTroopInfo.option);
    localBundle.putString("troop_info_owner", String.valueOf(paramRecommendTroopInfo.ownerUin));
    localBundle.putLong("troop_info_classext", paramRecommendTroopInfo.classId);
    localBundle.putShort("troop_info_faceid", (short)paramRecommendTroopInfo.faceId);
    localBundle.putString("troop_info_fingermemo", paramRecommendTroopInfo.fingerMemo);
    localBundle.putString("troop_info_loca", paramRecommendTroopInfo.location);
    localBundle.putBoolean("troop_info_is_member", paramRecommendTroopInfo.isTroopIn);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramRecommendTroopInfo.flagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramRecommendTroopInfo.authType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramRecommendTroopInfo.curMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramRecommendTroopInfo.hotDegree);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, TroopInfo paramTroopInfo, int paramInt2, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", paramTroopInfo.troopuin);
    localBundle.putString("troop_code", paramTroopInfo.troopcode);
    localBundle.putString("troop_info_name", paramTroopInfo.troopname);
    localBundle.putByte("troop_info_opt", (byte)paramTroopInfo.cGroupOption);
    localBundle.putString("troop_info_owner", paramTroopInfo.troopowneruin);
    localBundle.putString("troop_info_admi", paramTroopInfo.Administrator);
    localBundle.putLong("troop_info_classext", paramTroopInfo.dwGroupClassExt);
    localBundle.putShort("troop_info_faceid", paramTroopInfo.troopface);
    localBundle.putString("troop_info_fingermemo", paramTroopInfo.fingertroopmemo);
    localBundle.putString("troop_info_loca", paramTroopInfo.strLocation);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramTroopInfo.dwGroupFlagExt);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramTroopInfo.dwAuthGroupType);
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramTroopInfo.wMemberNum);
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramTroopInfo.nTroopGrade);
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static Bundle a(int paramInt1, SearchGroup.GroupInfo paramGroupInfo, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putString("troop_uin", String.valueOf(paramGroupInfo.dwGroupCode.get()));
    localBundle.putString("troop_code", String.valueOf(paramGroupInfo.dwGroupUin.get()));
    localBundle.putString("troop_info_name", paramGroupInfo.sGroupName.get());
    localBundle.putByte("troop_info_opt", (byte)SearchTroopListActivity.a(paramGroupInfo));
    localBundle.putString("troop_info_owner", String.valueOf(paramGroupInfo.dwGroupOwnerId.get()));
    localBundle.putLong("troop_info_classext", paramGroupInfo.dwGroupClass.get());
    localBundle.putShort("troop_info_faceid", (short)paramGroupInfo.dwGroupFaceId.get());
    localBundle.putString("troop_info_fingermemo", paramGroupInfo.sGroupFingerMem.get());
    localBundle.putString("troop_info_loca", paramGroupInfo.sGroupLocation.get());
    localBundle.putBoolean("troop_info_is_member", paramGroupInfo.bGroupIn.get());
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramGroupInfo.dwGroupFlagExt.get());
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramGroupInfo.dwAuthGroupType.get());
    localBundle.putInt("TROOP_INFO_MEMBER_NUM", paramGroupInfo.dwCurMemberNum.get());
    localBundle.putInt("TROOP_INFO_TROOP_GRADE", paramGroupInfo.dwGroupHotDegree.get());
    localBundle.putInt("troop_info_from_ex", paramInt2);
    return localBundle;
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
  }
  
  public static String a(String paramString)
  {
    int m = paramString.indexOf("_");
    String str = paramString;
    if (m > 0) {
      str = "troopOrg_" + paramString.substring(m + 1);
    }
    return str;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        paramString = null;
      }
    }
    do
    {
      return paramString;
      str = paramString.replace("%req_uin%", str);
      paramString = str;
      if (str.contains("%action_uin%"))
      {
        paramString = paramStructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(paramString)) {
          return null;
        }
        paramString = str.replace("%action_uin%", paramString);
      }
      str = paramString;
      if (paramString.contains("%actor_uin%"))
      {
        str = paramStructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = paramString.replace("%actor_uin%", str);
      }
      paramString = str;
    } while (!str.contains("%group_name%"));
    paramStructMsg = paramStructMsg.msg.group_name.get();
    if (TextUtils.isEmpty(paramStructMsg)) {
      return null;
    }
    return str.replace("%group_name%", paramStructMsg);
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: getstatic 526	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Boolean	Z
    //   9: ifne +171 -> 180
    //   12: iconst_1
    //   13: putstatic 526	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Boolean	Z
    //   16: new 528	java/io/File
    //   19: dup
    //   20: new 471	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   27: invokestatic 534	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 540	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   33: invokevirtual 543	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 545
    //   42: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 30
    //   47: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 548	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 551	java/io/File:exists	()Z
    //   61: ifeq +141 -> 202
    //   64: aload_0
    //   65: invokevirtual 555	java/io/File:length	()J
    //   68: lstore 5
    //   70: lload 5
    //   72: lconst_0
    //   73: lcmp
    //   74: ifle +128 -> 202
    //   77: new 557	java/io/FileInputStream
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 560	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: aload_1
    //   89: invokevirtual 563	java/io/FileInputStream:available	()I
    //   92: newarray <illegal type>
    //   94: astore_2
    //   95: aload_1
    //   96: astore_0
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 567	java/io/FileInputStream:read	([B)I
    //   102: pop
    //   103: aload_1
    //   104: astore_0
    //   105: new 214	java/lang/String
    //   108: dup
    //   109: aload_2
    //   110: ldc_w 569
    //   113: invokespecial 572	java/lang/String:<init>	([BLjava/lang/String;)V
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull +76 -> 194
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: ldc_w 574
    //   127: invokevirtual 578	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   130: astore_2
    //   131: iconst_0
    //   132: istore 4
    //   134: aload_1
    //   135: astore_0
    //   136: iload 4
    //   138: aload_2
    //   139: arraylength
    //   140: if_icmpge +54 -> 194
    //   143: aload_1
    //   144: astore_0
    //   145: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   148: aload_2
    //   149: iload 4
    //   151: aaload
    //   152: invokevirtual 581	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   155: ifne +16 -> 171
    //   158: aload_1
    //   159: astore_0
    //   160: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   163: aload_2
    //   164: iload 4
    //   166: aaload
    //   167: invokevirtual 584	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: iload 4
    //   173: iconst_1
    //   174: iadd
    //   175: istore 4
    //   177: goto -43 -> 134
    //   180: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   183: invokevirtual 587	java/util/HashSet:clear	()V
    //   186: goto -170 -> 16
    //   189: astore_0
    //   190: aload_3
    //   191: monitorexit
    //   192: aload_0
    //   193: athrow
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 590	java/io/FileInputStream:close	()V
    //   202: aload_3
    //   203: monitorexit
    //   204: return
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: astore_0
    //   210: aload_2
    //   211: invokevirtual 593	java/lang/Exception:printStackTrace	()V
    //   214: aload_1
    //   215: ifnull -13 -> 202
    //   218: aload_1
    //   219: invokevirtual 590	java/io/FileInputStream:close	()V
    //   222: goto -20 -> 202
    //   225: astore_0
    //   226: goto -24 -> 202
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_0
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 590	java/io/FileInputStream:close	()V
    //   240: aload_1
    //   241: athrow
    //   242: astore_0
    //   243: goto -41 -> 202
    //   246: astore_0
    //   247: goto -7 -> 240
    //   250: astore_1
    //   251: goto -19 -> 232
    //   254: astore_2
    //   255: goto -47 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	104	0	localObject1	Object
    //   189	4	0	localObject2	Object
    //   209	1	0	localObject3	Object
    //   225	1	0	localIOException1	java.io.IOException
    //   231	6	0	localObject4	Object
    //   242	1	0	localIOException2	java.io.IOException
    //   246	1	0	localIOException3	java.io.IOException
    //   85	134	1	localFileInputStream	java.io.FileInputStream
    //   229	12	1	localObject5	Object
    //   250	1	1	localObject6	Object
    //   94	70	2	localObject7	Object
    //   205	6	2	localException1	Exception
    //   254	1	2	localException2	Exception
    //   3	200	3	localHashSet	HashSet
    //   132	44	4	m	int
    //   68	3	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   6	16	189	finally
    //   16	70	189	finally
    //   180	186	189	finally
    //   190	192	189	finally
    //   198	202	189	finally
    //   202	204	189	finally
    //   218	222	189	finally
    //   236	240	189	finally
    //   240	242	189	finally
    //   77	86	205	java/lang/Exception
    //   218	222	225	java/io/IOException
    //   77	86	229	finally
    //   198	202	242	java/io/IOException
    //   236	240	246	java/io/IOException
    //   88	95	250	finally
    //   97	103	250	finally
    //   105	117	250	finally
    //   123	131	250	finally
    //   136	143	250	finally
    //   145	158	250	finally
    //   160	171	250	finally
    //   210	214	250	finally
    //   88	95	254	java/lang/Exception
    //   97	103	254	java/lang/Exception
    //   105	117	254	java/lang/Exception
    //   123	131	254	java/lang/Exception
    //   136	143	254	java/lang/Exception
    //   145	158	254	java/lang/Exception
    //   160	171	254	java/lang/Exception
  }
  
  public static void a(Context paramContext, Bundle paramBundle, int paramInt)
  {
    if (paramContext != null) {}
    try
    {
      Intent localIntent = new Intent(paramContext, ChatSettingForTroop.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("vistor_type", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopUtils", 2, paramContext.toString());
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    String str2 = paramBaseActivity.app.getAccount();
    String str3 = ((TicketManager)paramBaseActivity.app.getManager(2)).getSkey(str2);
    String str1 = "";
    if (str3 != null)
    {
      localBundle = new Bundle();
      localBundle.putString("version", "6.5.5");
      localBundle.putString("platform", "android");
      localBundle.putString("mType", "qb_other");
      localBundle.putString("gc", paramString);
      localBundle.putString("bkn", TroopNoticeJsHandler.a(str3));
      localBundle.putString("src", "1");
      localBundle.putString("Cookie", "uin=o" + str2 + ";skey=" + str3);
      paramString = new HashMap();
      paramString.put("BUNDLE", localBundle);
      paramString.put("CONTEXT", paramBaseActivity.getApplicationContext());
      paramBaseActivity = str1;
      if (paramInt1 == 1)
      {
        if (paramInt2 != 0) {
          break label238;
        }
        localBundle.putString("mode", "0");
      }
    }
    label238:
    while (!QLog.isColorLevel())
    {
      Bundle localBundle;
      for (;;)
      {
        paramBaseActivity = "http://qinfo.clt.qq.com/cgi-bin/qun_office/set_group_officemode";
        if (paramInt1 == 0) {
          paramBaseActivity = "http://qinfo.clt.qq.com/cgi-bin/qun_office/get_group_officemode";
        }
        new HttpWebCgiAsyncTask2(paramBaseActivity, "", paramCallback, paramInt2, localBundle).a(paramString);
        return;
        if (paramInt2 == 1) {
          localBundle.putString("mode", "1");
        }
      }
    }
    QLog.w("TroopUtils", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2 = (TroopAppMgr)paramQQAppInterface.getManager(108);
    if (paramString2 != null)
    {
      paramString2 = paramString2.a(1104864064);
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.url))) {}
    }
    for (paramString2 = paramString2.url.replace("$GCODE$", paramString1);; paramString2 = null)
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = d + paramString1;
      }
      localIntent.putExtra("url", str);
      paramActivity.startActivityForResult(localIntent, 12001);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, paramString1, "", "", "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Bundle paramBundle)
  {
    String str = paramBundle.getString("troop_uin");
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", e + str);
    localIntent.putExtras(paramBundle);
    paramContext.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_app", "Clk_grpapp", 0, 0, str, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2)
  {
    paramBaseActivity.getSharedPreferences("showbluetipsofmodifytroopmembercard_" + paramString1, 0).edit().putLong("showbluetipsofmodifytroopmembercard_" + paramString2, System.currentTimeMillis()).commit();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, AvatarWallAdapter paramAvatarWallAdapter)
  {
    if (paramAvatarWallAdapter != null) {
      paramAvatarWallAdapter.a(paramArrayList, paramString3, paramString1, paramString2);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, HashMap paramHashMap, AvatarWallAdapter paramAvatarWallAdapter)
  {
    if (paramAvatarWallAdapter != null) {
      paramAvatarWallAdapter.a(paramArrayList, paramString3, paramString1, paramString2, paramHashMap);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (paramString == null)) {
      return false;
    }
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramLong + "");
    return (paramQQAppInterface != null) && (((paramQQAppInterface.troopowneruin != null) && (paramString.equals(paramQQAppInterface.troopowneruin))) || ((paramQQAppInterface.Administrator != null) && (paramQQAppInterface.Administrator.contains(paramString))));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = (TroopManager)paramQQAppInterface.getManager(51);
    long l2;
    long l1;
    if (paramString3 != null)
    {
      paramString3 = paramString3.a(paramString2);
      if (paramString3 != null)
      {
        l2 = paramString3.dwOfficeMode;
        l1 = paramString3.dwGroupClassExt;
      }
    }
    for (;;)
    {
      if (0L == l2) {
        return false;
      }
      if (!a(Long.toString(l1))) {
        return false;
      }
      l1 = paramBaseActivity.getSharedPreferences("showbluetipsofmodifytroopmembercard_" + paramString1, 0).getLong("showbluetipsofmodifytroopmembercard_" + paramString2, 0L);
      l1 = Math.abs(System.currentTimeMillis() - l1);
      if (QLog.isColorLevel()) {
        QLog.w("TroopUtils", 2, "NeedshowBlueTipsOfSelfTroopCard() timeDiff:  " + l1);
      }
      if (l1 <= 259200000L) {
        return false;
      }
      int m = new Random().nextInt(72000);
      paramString3 = Calendar.getInstance();
      int n = paramString3.get(11);
      int i1 = paramString3.get(12);
      if (paramString3.get(13) + (n * 60 * 60 + i1 * 60) < m % 43201 + 28800) {
        return false;
      }
      a(paramQQAppInterface, paramBaseActivity, paramString1, paramString2);
      return true;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: getstatic 526	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Boolean	Z
    //   11: ifne +179 -> 190
    //   14: iconst_1
    //   15: putstatic 526	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_Boolean	Z
    //   18: new 528	java/io/File
    //   21: dup
    //   22: new 471	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   29: invokestatic 534	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 540	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   35: invokevirtual 543	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 545
    //   44: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 30
    //   49: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 548	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 551	java/io/File:exists	()Z
    //   63: ifeq +127 -> 190
    //   66: aload_1
    //   67: invokevirtual 555	java/io/File:length	()J
    //   70: lstore 6
    //   72: lload 6
    //   74: lconst_0
    //   75: lcmp
    //   76: ifle +114 -> 190
    //   79: new 557	java/io/FileInputStream
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 560	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore_2
    //   88: aload_2
    //   89: astore_1
    //   90: aload_2
    //   91: invokevirtual 563	java/io/FileInputStream:available	()I
    //   94: newarray <illegal type>
    //   96: astore_3
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: aload_3
    //   101: invokevirtual 567	java/io/FileInputStream:read	([B)I
    //   104: pop
    //   105: aload_2
    //   106: astore_1
    //   107: new 214	java/lang/String
    //   110: dup
    //   111: aload_3
    //   112: ldc_w 569
    //   115: invokespecial 572	java/lang/String:<init>	([BLjava/lang/String;)V
    //   118: astore_3
    //   119: aload_3
    //   120: ifnull +62 -> 182
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: ldc_w 574
    //   129: invokevirtual 578	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   132: astore_3
    //   133: iconst_0
    //   134: istore 5
    //   136: aload_2
    //   137: astore_1
    //   138: iload 5
    //   140: aload_3
    //   141: arraylength
    //   142: if_icmpge +40 -> 182
    //   145: aload_2
    //   146: astore_1
    //   147: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   150: aload_3
    //   151: iload 5
    //   153: aaload
    //   154: invokevirtual 581	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   157: ifne +16 -> 173
    //   160: aload_2
    //   161: astore_1
    //   162: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   165: aload_3
    //   166: iload 5
    //   168: aaload
    //   169: invokevirtual 584	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: iload 5
    //   175: iconst_1
    //   176: iadd
    //   177: istore 5
    //   179: goto -43 -> 136
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 590	java/io/FileInputStream:close	()V
    //   190: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   193: ldc_w 825
    //   196: invokevirtual 581	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   199: ifeq +51 -> 250
    //   202: aload 4
    //   204: monitorexit
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: aload_2
    //   211: astore_1
    //   212: aload_3
    //   213: invokevirtual 593	java/lang/Exception:printStackTrace	()V
    //   216: aload_2
    //   217: ifnull -27 -> 190
    //   220: aload_2
    //   221: invokevirtual 590	java/io/FileInputStream:close	()V
    //   224: goto -34 -> 190
    //   227: astore_1
    //   228: goto -38 -> 190
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_1
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 590	java/io/FileInputStream:close	()V
    //   242: aload_0
    //   243: athrow
    //   244: astore_0
    //   245: aload 4
    //   247: monitorexit
    //   248: aload_0
    //   249: athrow
    //   250: getstatic 71	com/tencent/mobileqq/troop/utils/TroopUtils:jdField_a_of_type_JavaUtilHashSet	Ljava/util/HashSet;
    //   253: aload_0
    //   254: invokevirtual 581	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   257: istore 8
    //   259: aload 4
    //   261: monitorexit
    //   262: iload 8
    //   264: ireturn
    //   265: astore_1
    //   266: goto -76 -> 190
    //   269: astore_1
    //   270: goto -28 -> 242
    //   273: astore_0
    //   274: goto -40 -> 234
    //   277: astore_3
    //   278: goto -68 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   58	154	1	localObject1	Object
    //   227	1	1	localIOException1	java.io.IOException
    //   233	6	1	localObject2	Object
    //   265	1	1	localIOException2	java.io.IOException
    //   269	1	1	localIOException3	java.io.IOException
    //   87	134	2	localFileInputStream	java.io.FileInputStream
    //   96	70	3	localObject3	Object
    //   207	6	3	localException1	Exception
    //   277	1	3	localException2	Exception
    //   3	257	4	localHashSet	HashSet
    //   134	44	5	m	int
    //   70	3	6	l1	long
    //   257	6	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   79	88	207	java/lang/Exception
    //   220	224	227	java/io/IOException
    //   79	88	231	finally
    //   8	72	244	finally
    //   186	190	244	finally
    //   190	205	244	finally
    //   220	224	244	finally
    //   238	242	244	finally
    //   242	244	244	finally
    //   245	248	244	finally
    //   250	262	244	finally
    //   186	190	265	java/io/IOException
    //   238	242	269	java/io/IOException
    //   90	97	273	finally
    //   99	105	273	finally
    //   107	119	273	finally
    //   125	133	273	finally
    //   138	145	273	finally
    //   147	160	273	finally
    //   162	173	273	finally
    //   212	216	273	finally
    //   90	97	277	java/lang/Exception
    //   99	105	277	java/lang/Exception
    //   107	119	277	java/lang/Exception
    //   125	133	277	java/lang/Exception
    //   138	145	277	java/lang/Exception
    //   147	160	277	java/lang/Exception
    //   162	173	277	java/lang/Exception
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() < 1);
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    int m = 0;
    if (StringUtil.b(paramString)) {
      return 0;
    }
    int n = 5381;
    while (m < paramString.length())
    {
      n += (n << 5) + paramString.charAt(m);
      m += 1;
    }
    return 0x7FFFFFFF & n;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3)
  {
    paramBaseActivity = DBUtils.a().a(paramQQAppInterface, paramString2, paramString1);
    if (paramBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopUtils", 2, "getTroopMemberCardInfo is null " + paramString2);
      }
      return false;
    }
    if (TextUtils.getTrimmedLength(ContactUtils.g(paramQQAppInterface, paramString2, paramString1)) <= 0) {}
    for (int n = 1;; n = 0)
    {
      int m;
      if (paramBaseActivity.tel != null)
      {
        m = n;
        if (TextUtils.getTrimmedLength(paramBaseActivity.tel) > 0) {}
      }
      else
      {
        m = n + 1;
      }
      if (paramBaseActivity.email != null)
      {
        n = m;
        if (TextUtils.getTrimmedLength(paramBaseActivity.email) > 0) {}
      }
      else
      {
        n = m + 1;
      }
      if (paramBaseActivity.job != null)
      {
        m = n;
        if (TextUtils.getTrimmedLength(paramBaseActivity.job) > 0) {}
      }
      else
      {
        m = n + 1;
      }
      if (m < 2) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TroopUtils", 2, "NeedshowBlueTipsOfSelfTroopCard is true  " + paramString2);
      }
      return true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
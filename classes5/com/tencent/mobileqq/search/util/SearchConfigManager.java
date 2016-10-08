package com.tencent.mobileqq.search.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SearchConfigManager
{
  private static final String a = "sp_search_config";
  private static final String b = "0|100|1|3,101|500|7|15";
  private static String c = "";
  public static String configSwitch;
  public static int contactSearchFieldBaseBit;
  public static int contactSearchIndexBaseBit;
  public static int contactSearchPinyinBaseBit;
  public static int contactSearchRecentBaseBit;
  public static int contactSearchTypeBaseBit;
  public static int engineOrderFavorite;
  public static int engineOrderFile;
  public static int engineOrderMessage;
  public static int engineOrderNetSearch;
  public static int engineOrderPeople;
  public static int engineOrderPublicAccount;
  public static long fieldAlias;
  public static long fieldDiscussionMemberRemark;
  public static long fieldInteRemark;
  public static long fieldMobileNo;
  public static long fieldNickName;
  public static long fieldPhoneContactName;
  public static long fieldPublicAccountDisplayName;
  public static long fieldPublicAccountMark;
  public static long fieldPublicAccountName;
  public static long fieldPublicAccountSummary;
  public static long fieldRemark;
  public static long fieldTroopCard;
  public static long fieldTroopName;
  public static long fieldUin;
  public static long filedDiscussionName;
  public static long indexEqual;
  public static long indexMiddle;
  public static long indexStart;
  public static long recentTrue;
  public static Map searchEngineOrder;
  public static long stringOrigin;
  public static long stringPinyin;
  public static int troopDurationUnderNotWifi;
  public static int troopDurationUnderWifi;
  public static int troopMemberLimit;
  public static String troopMemberUpdateConfigStr;
  public static ArrayList troopMemberUpdateConfigs;
  public static long typeCircleContact;
  public static long typeDiscussion;
  public static long typeDiscussionConversation;
  public static long typeDiscussionConversationMatchMember;
  public static long typeDiscussionConversationMatchTitle;
  public static long typeDiscussionMatchMemberFull;
  public static long typeDiscussionMember;
  public static long typeFriend;
  public static long typeFriendConversation;
  public static long typeFriendNotOftenContact;
  public static long typeFriendSpecialCare;
  public static long typeGlobalTroop;
  public static long typeGlobalTroopConversation;
  public static long typeGlobalTroopMember;
  public static long typePhoneContact;
  public static long typePublicAccount;
  public static long typePublicAccountConversation;
  public static long typeTool;
  public static long typeTroop;
  public static long typeTroopConversation;
  public static long typeTroopMember;
  public static long typeUnbindPhoneContact;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    engineOrderPeople = 6;
    engineOrderMessage = 5;
    engineOrderPublicAccount = 4;
    engineOrderFavorite = 3;
    engineOrderFile = 2;
    engineOrderNetSearch = 1;
    contactSearchPinyinBaseBit = 58;
    contactSearchRecentBaseBit = 48;
    contactSearchIndexBaseBit = 40;
    contactSearchTypeBaseBit = 32;
    contactSearchFieldBaseBit = 24;
    stringOrigin = 2L;
    stringPinyin = 1L;
    recentTrue = 1L;
    indexEqual = 3L;
    indexStart = 2L;
    indexMiddle = 1L;
    fieldPublicAccountName = 12L;
    fieldPublicAccountMark = 11L;
    fieldPublicAccountSummary = 10L;
    fieldPublicAccountDisplayName = 9L;
    filedDiscussionName = 8L;
    fieldTroopName = 8L;
    fieldRemark = 8L;
    fieldDiscussionMemberRemark = 7L;
    fieldInteRemark = 6L;
    fieldNickName = 5L;
    fieldPhoneContactName = 4L;
    fieldAlias = 3L;
    fieldUin = 2L;
    fieldMobileNo = 1L;
    fieldTroopCard = 6L;
    typeFriendConversation = 15L;
    typeTroopConversation = 15L;
    typeDiscussionConversationMatchTitle = 15L;
    typeDiscussionConversation = 15L;
    typeFriendSpecialCare = 14L;
    typeFriend = 13L;
    typeFriendNotOftenContact = 12L;
    typeDiscussionMember = 11L;
    typePhoneContact = 10L;
    typeDiscussionMatchMemberFull = 9L;
    typeDiscussionConversationMatchMember = 8L;
    typeDiscussion = 7L;
    typeTroop = 7L;
    typeTroopMember = 6L;
    typeTool = 4L;
    typePublicAccountConversation = 4L;
    typePublicAccount = 3L;
    typeUnbindPhoneContact = 2L;
    typeCircleContact = 1L;
    typeGlobalTroopMember = 9L;
    typeGlobalTroop = 7L;
    typeGlobalTroopConversation = 8L;
    troopMemberLimit = 70;
    troopDurationUnderWifi = 24;
    troopDurationUnderNotWifi = 72;
    searchEngineOrder = new HashMap();
    troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
    troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
  }
  
  private static ArrayList a(String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SearchConfigManager", 2, "parseTroopMemberUpdateSetting, config: " + paramString);
    }
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      return (ArrayList)localObject1;
      ArrayList localArrayList = new ArrayList();
      try
      {
        String[] arrayOfString = paramString.split(",");
        localObject1 = localArrayList;
        if (arrayOfString != null)
        {
          localObject1 = localArrayList;
          if (arrayOfString.length > 0)
          {
            int j = arrayOfString.length;
            for (;;)
            {
              localObject1 = localArrayList;
              if (i >= j) {
                break;
              }
              localObject1 = arrayOfString[i].trim().split("\\|");
              if ((localObject1 != null) && (localObject1.length == 4))
              {
                SearchConfigManager.TroopMemberSetting localTroopMemberSetting = new SearchConfigManager.TroopMemberSetting();
                localTroopMemberSetting.a = Integer.valueOf(localObject1[0]).intValue();
                localTroopMemberSetting.b = Integer.valueOf(localObject1[1]).intValue();
                localTroopMemberSetting.c = (Integer.valueOf(localObject1[2]).intValue() * 24);
                localTroopMemberSetting.d = (Integer.valueOf(localObject1[3]).intValue() * 24);
                localArrayList.add(localTroopMemberSetting);
              }
              i += 1;
            }
            Object localObject2;
            if (paramString.equals("0|100|1|3,101|500|7|15")) {}
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("SearchConfigManager", 2, "parseTroopMemberUpdateSetting error");
        }
        localObject2 = localArrayList;
      }
    }
    return a("0|100|1|3,101|500|7|15");
  }
  
  private static void a()
  {
    engineOrderPeople = 6;
    engineOrderMessage = 5;
    engineOrderPublicAccount = 4;
    engineOrderFavorite = 3;
    engineOrderFile = 2;
    engineOrderNetSearch = 1;
    contactSearchPinyinBaseBit = 58;
    contactSearchRecentBaseBit = 48;
    contactSearchIndexBaseBit = 40;
    contactSearchTypeBaseBit = 32;
    contactSearchFieldBaseBit = 24;
    stringOrigin = 2L;
    stringPinyin = 1L;
    recentTrue = 1L;
    indexEqual = 3L;
    indexStart = 2L;
    indexMiddle = 1L;
    fieldPublicAccountName = 12L;
    fieldPublicAccountMark = 11L;
    fieldPublicAccountSummary = 10L;
    fieldPublicAccountDisplayName = 9L;
    filedDiscussionName = 8L;
    fieldTroopName = 8L;
    fieldRemark = 8L;
    fieldDiscussionMemberRemark = 7L;
    fieldInteRemark = 6L;
    fieldNickName = 5L;
    fieldPhoneContactName = 4L;
    fieldAlias = 3L;
    fieldUin = 2L;
    fieldMobileNo = 1L;
    fieldTroopCard = 6L;
    typeFriendConversation = 15L;
    typeTroopConversation = 15L;
    typeDiscussionConversationMatchTitle = 15L;
    typeDiscussionConversation = 15L;
    typeFriendSpecialCare = 14L;
    typeFriend = 13L;
    typeFriendNotOftenContact = 12L;
    typeDiscussionMember = 11L;
    typePhoneContact = 10L;
    typeDiscussionMatchMemberFull = 9L;
    typeDiscussionConversationMatchMember = 8L;
    typeDiscussion = 7L;
    typeTroop = 7L;
    typeTroopMember = 6L;
    typeTool = 4L;
    typePublicAccountConversation = 4L;
    typePublicAccount = 3L;
    typeUnbindPhoneContact = 2L;
    typeCircleContact = 1L;
    typeGlobalTroopMember = 9L;
    typeGlobalTroop = 7L;
    typeGlobalTroopConversation = 8L;
    troopMemberLimit = 70;
    troopDurationUnderWifi = 24;
    troopDurationUnderNotWifi = 72;
    troopMemberUpdateConfigStr = "0|100|1|3,101|500|7|15";
    troopMemberUpdateConfigs = a("0|100|1|3,101|500|7|15");
    searchEngineOrder = new HashMap();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:f	()Ljava/lang/String;
    //   4: astore_0
    //   5: aload_0
    //   6: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +629 -> 638
    //   12: aload_0
    //   13: getstatic 245	com/tencent/mobileqq/search/util/SearchConfigManager:c	Ljava/lang/String;
    //   16: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifne +619 -> 638
    //   22: aload_0
    //   23: putstatic 245	com/tencent/mobileqq/search/util/SearchConfigManager:c	Ljava/lang/String;
    //   26: invokestatic 351	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   29: new 259	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 353
    //   43: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 8
    //   48: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: iconst_0
    //   55: invokevirtual 357	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   58: astore_0
    //   59: aload_0
    //   60: ldc_w 358
    //   63: ldc -13
    //   65: invokeinterface 364 3 0
    //   70: putstatic 366	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   73: ldc_w 368
    //   76: getstatic 366	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   79: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne +10 -> 92
    //   85: invokestatic 370	com/tencent/mobileqq/search/util/SearchConfigManager:a	()V
    //   88: invokestatic 373	com/tencent/mobileqq/search/IContactSearchable:a	()V
    //   91: return
    //   92: aload_0
    //   93: invokeinterface 377 1 0
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +252 -> 352
    //   103: aload_0
    //   104: invokeinterface 383 1 0
    //   109: invokeinterface 389 1 0
    //   114: astore_1
    //   115: aload_1
    //   116: invokeinterface 394 1 0
    //   121: ifeq +231 -> 352
    //   124: aload_1
    //   125: invokeinterface 398 1 0
    //   130: checkcast 287	java/lang/String
    //   133: astore_2
    //   134: ldc 2
    //   136: aload_2
    //   137: invokevirtual 404	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   140: astore_3
    //   141: aload_0
    //   142: aload_2
    //   143: invokeinterface 408 2 0
    //   148: checkcast 287	java/lang/String
    //   151: astore 4
    //   153: aload 4
    //   155: ifnull -40 -> 115
    //   158: aload_3
    //   159: invokevirtual 414	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   162: ldc_w 287
    //   165: if_acmpne +27 -> 192
    //   168: aload_3
    //   169: aconst_null
    //   170: aload 4
    //   172: invokevirtual 418	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   175: goto -60 -> 115
    //   178: astore_2
    //   179: aload_2
    //   180: invokevirtual 419	java/lang/NoSuchFieldException:printStackTrace	()V
    //   183: goto -68 -> 115
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   191: return
    //   192: aload_3
    //   193: invokevirtual 414	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   196: getstatic 423	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   199: if_acmpne +33 -> 232
    //   202: aload_3
    //   203: aconst_null
    //   204: aload 4
    //   206: invokestatic 427	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   209: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokevirtual 418	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   215: goto -100 -> 115
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 431	java/lang/IllegalAccessException:printStackTrace	()V
    //   223: goto -108 -> 115
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 432	java/lang/Error:printStackTrace	()V
    //   231: return
    //   232: aload_3
    //   233: invokevirtual 414	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   236: getstatic 435	java/lang/Long:TYPE	Ljava/lang/Class;
    //   239: if_acmpne -124 -> 115
    //   242: aload 4
    //   244: invokestatic 439	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   247: lstore 7
    //   249: lload 7
    //   251: lconst_0
    //   252: lcmp
    //   253: ifle +36 -> 289
    //   256: lload 7
    //   258: ldc2_w 440
    //   261: lcmp
    //   262: ifge +27 -> 289
    //   265: aload_3
    //   266: aconst_null
    //   267: aload 4
    //   269: invokestatic 439	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   272: invokestatic 444	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: invokevirtual 418	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   278: goto -163 -> 115
    //   281: astore_2
    //   282: aload_2
    //   283: invokevirtual 445	java/lang/NumberFormatException:printStackTrace	()V
    //   286: goto -171 -> 115
    //   289: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq -177 -> 115
    //   295: ldc_w 257
    //   298: iconst_2
    //   299: new 259	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 447
    //   309: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_2
    //   313: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 449
    //   319: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 4
    //   324: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: goto -218 -> 115
    //   336: astore_2
    //   337: aload_2
    //   338: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   341: goto -226 -> 115
    //   344: astore_2
    //   345: aload_2
    //   346: invokevirtual 432	java/lang/Error:printStackTrace	()V
    //   349: goto -234 -> 115
    //   352: invokestatic 451	com/tencent/mobileqq/search/util/SearchConfigManager:b	()V
    //   355: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   358: ldc_w 453
    //   361: getstatic 87	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderPeople	I
    //   364: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   367: invokeinterface 457 3 0
    //   372: pop
    //   373: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   376: ldc_w 459
    //   379: getstatic 89	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderMessage	I
    //   382: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   385: invokeinterface 457 3 0
    //   390: pop
    //   391: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   394: ldc_w 461
    //   397: getstatic 89	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderMessage	I
    //   400: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: invokeinterface 457 3 0
    //   408: pop
    //   409: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   412: ldc_w 463
    //   415: getstatic 91	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderPublicAccount	I
    //   418: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: invokeinterface 457 3 0
    //   426: pop
    //   427: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   430: ldc_w 465
    //   433: getstatic 93	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFavorite	I
    //   436: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: invokeinterface 457 3 0
    //   444: pop
    //   445: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   448: ldc_w 467
    //   451: getstatic 95	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderFile	I
    //   454: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: invokeinterface 457 3 0
    //   462: pop
    //   463: getstatic 234	com/tencent/mobileqq/search/util/SearchConfigManager:searchEngineOrder	Ljava/util/Map;
    //   466: ldc_w 469
    //   469: getstatic 97	com/tencent/mobileqq/search/util/SearchConfigManager:engineOrderNetSearch	I
    //   472: invokestatic 430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: invokeinterface 457 3 0
    //   480: pop
    //   481: invokestatic 373	com/tencent/mobileqq/search/IContactSearchable:a	()V
    //   484: getstatic 236	com/tencent/mobileqq/search/util/SearchConfigManager:troopMemberUpdateConfigStr	Ljava/lang/String;
    //   487: invokestatic 239	com/tencent/mobileqq/search/util/SearchConfigManager:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   490: putstatic 241	com/tencent/mobileqq/search/util/SearchConfigManager:troopMemberUpdateConfigs	Ljava/util/ArrayList;
    //   493: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +142 -> 638
    //   499: new 259	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   506: astore_0
    //   507: aload_0
    //   508: ldc_w 257
    //   511: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_0
    //   516: ldc_w 471
    //   519: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: ldc 2
    //   525: invokevirtual 475	java/lang/Class:getFields	()[Ljava/lang/reflect/Field;
    //   528: astore_1
    //   529: aload_1
    //   530: arraylength
    //   531: istore 6
    //   533: iconst_0
    //   534: istore 5
    //   536: iload 5
    //   538: iload 6
    //   540: if_icmpge +60 -> 600
    //   543: aload_1
    //   544: iload 5
    //   546: aaload
    //   547: astore_2
    //   548: aload_0
    //   549: aload_2
    //   550: invokevirtual 478	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   553: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload_0
    //   558: ldc_w 449
    //   561: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_0
    //   566: aload_2
    //   567: aconst_null
    //   568: invokevirtual 479	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   571: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_0
    //   576: ldc_w 484
    //   579: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: iload 5
    //   585: iconst_1
    //   586: iadd
    //   587: istore 5
    //   589: goto -53 -> 536
    //   592: astore_2
    //   593: aload_2
    //   594: invokevirtual 431	java/lang/IllegalAccessException:printStackTrace	()V
    //   597: goto -22 -> 575
    //   600: aload_0
    //   601: ldc_w 486
    //   604: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: ldc_w 257
    //   611: iconst_2
    //   612: new 259	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 488
    //   622: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_0
    //   626: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   638: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramQQAppInterface	QQAppInterface
    //   114	430	1	localObject1	Object
    //   133	10	2	str1	String
    //   178	2	2	localNoSuchFieldException	NoSuchFieldException
    //   218	2	2	localIllegalAccessException1	IllegalAccessException
    //   281	32	2	localNumberFormatException	NumberFormatException
    //   336	2	2	localException	Exception
    //   344	2	2	localError	Error
    //   547	20	2	localObject2	Object
    //   592	2	2	localIllegalAccessException2	IllegalAccessException
    //   140	126	3	localField	java.lang.reflect.Field
    //   151	172	4	str2	String
    //   534	54	5	i	int
    //   531	10	6	j	int
    //   247	10	7	l	long
    // Exception table:
    //   from	to	target	type
    //   134	153	178	java/lang/NoSuchFieldException
    //   158	175	178	java/lang/NoSuchFieldException
    //   192	215	178	java/lang/NoSuchFieldException
    //   232	249	178	java/lang/NoSuchFieldException
    //   265	278	178	java/lang/NoSuchFieldException
    //   289	333	178	java/lang/NoSuchFieldException
    //   0	91	186	java/lang/Exception
    //   92	99	186	java/lang/Exception
    //   103	115	186	java/lang/Exception
    //   115	134	186	java/lang/Exception
    //   179	183	186	java/lang/Exception
    //   219	223	186	java/lang/Exception
    //   282	286	186	java/lang/Exception
    //   337	341	186	java/lang/Exception
    //   345	349	186	java/lang/Exception
    //   352	533	186	java/lang/Exception
    //   548	565	186	java/lang/Exception
    //   565	575	186	java/lang/Exception
    //   575	583	186	java/lang/Exception
    //   593	597	186	java/lang/Exception
    //   600	638	186	java/lang/Exception
    //   134	153	218	java/lang/IllegalAccessException
    //   158	175	218	java/lang/IllegalAccessException
    //   192	215	218	java/lang/IllegalAccessException
    //   232	249	218	java/lang/IllegalAccessException
    //   265	278	218	java/lang/IllegalAccessException
    //   289	333	218	java/lang/IllegalAccessException
    //   0	91	226	java/lang/Error
    //   92	99	226	java/lang/Error
    //   103	115	226	java/lang/Error
    //   115	134	226	java/lang/Error
    //   179	183	226	java/lang/Error
    //   219	223	226	java/lang/Error
    //   282	286	226	java/lang/Error
    //   337	341	226	java/lang/Error
    //   345	349	226	java/lang/Error
    //   352	533	226	java/lang/Error
    //   548	565	226	java/lang/Error
    //   565	575	226	java/lang/Error
    //   575	583	226	java/lang/Error
    //   593	597	226	java/lang/Error
    //   600	638	226	java/lang/Error
    //   134	153	281	java/lang/NumberFormatException
    //   158	175	281	java/lang/NumberFormatException
    //   192	215	281	java/lang/NumberFormatException
    //   232	249	281	java/lang/NumberFormatException
    //   265	278	281	java/lang/NumberFormatException
    //   289	333	281	java/lang/NumberFormatException
    //   134	153	336	java/lang/Exception
    //   158	175	336	java/lang/Exception
    //   192	215	336	java/lang/Exception
    //   232	249	336	java/lang/Exception
    //   265	278	336	java/lang/Exception
    //   289	333	336	java/lang/Exception
    //   134	153	344	java/lang/Error
    //   158	175	344	java/lang/Error
    //   192	215	344	java/lang/Error
    //   232	249	344	java/lang/Error
    //   265	278	344	java/lang/Error
    //   289	333	344	java/lang/Error
    //   565	575	592	java/lang/IllegalAccessException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = BaseApplicationImpl.a().getSharedPreferences(paramString + "_" + "sp_search_config", 0).edit();
    paramQQAppInterface.clear();
    paramQQAppInterface.commit();
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 257
    //   9: iconst_2
    //   10: new 259	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 506
    //   20: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 274	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_2
    //   34: invokestatic 280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +4 -> 41
    //   40: return
    //   41: invokestatic 351	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: new 259	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   51: aload_1
    //   52: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 353
    //   58: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 8
    //   63: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: iconst_0
    //   70: invokevirtual 357	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   73: invokeinterface 493 1 0
    //   78: astore_0
    //   79: new 508	org/json/JSONObject
    //   82: dup
    //   83: aload_2
    //   84: invokespecial 511	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: aload_1
    //   89: ldc_w 358
    //   92: invokevirtual 514	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: putstatic 366	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   98: ldc_w 368
    //   101: getstatic 366	com/tencent/mobileqq/search/util/SearchConfigManager:configSwitch	Ljava/lang/String;
    //   104: invokevirtual 332	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +30 -> 137
    //   110: aload_0
    //   111: ldc_w 358
    //   114: ldc_w 516
    //   117: invokeinterface 520 3 0
    //   122: pop
    //   123: aload_0
    //   124: invokeinterface 501 1 0
    //   129: pop
    //   130: return
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual 521	org/json/JSONException:printStackTrace	()V
    //   136: return
    //   137: aload_1
    //   138: invokevirtual 524	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   141: astore_2
    //   142: aload_2
    //   143: invokeinterface 394 1 0
    //   148: ifeq +68 -> 216
    //   151: aload_2
    //   152: invokeinterface 398 1 0
    //   157: checkcast 287	java/lang/String
    //   160: astore_3
    //   161: aload_0
    //   162: aload_3
    //   163: aload_1
    //   164: aload_3
    //   165: invokevirtual 527	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   168: checkcast 287	java/lang/String
    //   171: invokeinterface 520 3 0
    //   176: pop
    //   177: goto -35 -> 142
    //   180: astore_3
    //   181: aload_3
    //   182: invokevirtual 521	org/json/JSONException:printStackTrace	()V
    //   185: goto -43 -> 142
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   193: return
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual 324	java/lang/Exception:printStackTrace	()V
    //   199: goto -57 -> 142
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 432	java/lang/Error:printStackTrace	()V
    //   207: return
    //   208: astore_3
    //   209: aload_3
    //   210: invokevirtual 432	java/lang/Error:printStackTrace	()V
    //   213: goto -71 -> 142
    //   216: aload_0
    //   217: invokeinterface 501 1 0
    //   222: pop
    //   223: ldc -13
    //   225: putstatic 245	com/tencent/mobileqq/search/util/SearchConfigManager:c	Ljava/lang/String;
    //   228: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramQQAppInterface	QQAppInterface
    //   0	229	1	paramString1	String
    //   0	229	2	paramString2	String
    //   160	5	3	str	String
    //   180	2	3	localJSONException	org.json.JSONException
    //   194	2	3	localException	Exception
    //   208	2	3	localError	Error
    // Exception table:
    //   from	to	target	type
    //   41	130	131	org/json/JSONException
    //   137	142	131	org/json/JSONException
    //   142	161	131	org/json/JSONException
    //   181	185	131	org/json/JSONException
    //   195	199	131	org/json/JSONException
    //   209	213	131	org/json/JSONException
    //   216	228	131	org/json/JSONException
    //   161	177	180	org/json/JSONException
    //   41	130	188	java/lang/Exception
    //   137	142	188	java/lang/Exception
    //   142	161	188	java/lang/Exception
    //   181	185	188	java/lang/Exception
    //   195	199	188	java/lang/Exception
    //   209	213	188	java/lang/Exception
    //   216	228	188	java/lang/Exception
    //   161	177	194	java/lang/Exception
    //   41	130	202	java/lang/Error
    //   137	142	202	java/lang/Error
    //   142	161	202	java/lang/Error
    //   181	185	202	java/lang/Error
    //   195	199	202	java/lang/Error
    //   209	213	202	java/lang/Error
    //   216	228	202	java/lang/Error
    //   161	177	208	java/lang/Error
  }
  
  private static void b()
  {
    int k = 1;
    if ((contactSearchPinyinBaseBit <= 0) || (contactSearchPinyinBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchPinyinBaseBit=" + contactSearchPinyinBaseBit);
      }
      contactSearchPinyinBaseBit = 58;
    }
    if ((contactSearchRecentBaseBit <= 0) || (contactSearchRecentBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchRecentBaseBit=" + contactSearchRecentBaseBit);
      }
      contactSearchRecentBaseBit = 48;
    }
    if ((contactSearchIndexBaseBit <= 0) || (contactSearchIndexBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchIndexBaseBit=" + contactSearchIndexBaseBit);
      }
      contactSearchIndexBaseBit = 40;
    }
    if ((contactSearchTypeBaseBit <= 0) || (contactSearchTypeBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchTypeBaseBit=" + contactSearchTypeBaseBit);
      }
      contactSearchTypeBaseBit = 32;
    }
    if ((contactSearchFieldBaseBit <= 0) || (contactSearchFieldBaseBit >= 64))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchConfigManager", 2, "Value is invalid : contactSearchFieldBaseBit=" + contactSearchFieldBaseBit);
      }
      contactSearchFieldBaseBit = 24;
    }
    int[] arrayOfInt = new int[6];
    arrayOfInt[0] = contactSearchPinyinBaseBit;
    arrayOfInt[1] = contactSearchRecentBaseBit;
    arrayOfInt[2] = contactSearchIndexBaseBit;
    arrayOfInt[3] = contactSearchTypeBaseBit;
    arrayOfInt[4] = contactSearchFieldBaseBit;
    arrayOfInt[5] = 64;
    Arrays.sort(arrayOfInt);
    int i = 1;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] - arrayOfInt[(i - 1)] < 6) {
          j = 0;
        }
      }
      else
      {
        if (j == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SearchConfigManager", 2, "Value is invalid : interval < 6 : contactSearchPinyinBaseBit=" + contactSearchPinyinBaseBit + ";" + "contactSearchRecentBaseBit=" + contactSearchRecentBaseBit + ";" + "contactSearchIndexBaseBit=" + contactSearchIndexBaseBit + ";" + "contactSearchTypeBaseBit=" + contactSearchTypeBaseBit + ";" + "contactSearchFieldBaseBit=" + contactSearchFieldBaseBit);
          }
          contactSearchPinyinBaseBit = 58;
          contactSearchRecentBaseBit = 48;
          contactSearchIndexBaseBit = 40;
          contactSearchTypeBaseBit = 32;
          contactSearchFieldBaseBit = 24;
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\util\SearchConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
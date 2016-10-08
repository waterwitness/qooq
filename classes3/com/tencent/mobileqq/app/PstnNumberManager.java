package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class PstnNumberManager
{
  private static final int jdField_a_of_type_Int = 30;
  static final String jdField_a_of_type_JavaLangString;
  private static final List jdField_a_of_type_JavaUtilList = Arrays.asList((Object[])jdField_c_of_type_ArrayOfJavaLangString.clone());
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final int jdField_b_of_type_Int = 2;
  private static String jdField_b_of_type_JavaLangString;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  private static String jdField_c_of_type_JavaLangString;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static String d;
  private static String e;
  private static final String f = "update_fixed_location";
  private static final String g = "update_float_location";
  private static final String h = "callbackPhone_";
  private static final String i = "callbackPhone_f_";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PstnNumberManager.class.getSimpleName();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "data1" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "contact_id" };
    jdField_b_of_type_JavaLangString = "来电专线";
    jdField_c_of_type_JavaLangString = "专线电话";
    d = "回拨电话";
    e = "这是“来电”回拨模式专线号码。";
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "4008016062", "4009180338", "07507841000", "02886544200", "059528394996", "4008257119", "4008640166", "075583765566", "02886544201", "02886544226", "059522564190", "059528394740" };
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.a();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    int j;
    do
    {
      return;
      j = localBaseApplicationImpl.getContentResolver().delete(ContactsContract.Data.CONTENT_URI, "raw_contact_id=? AND mimetype = ? AND data1=?", new String[] { paramString2, "vnd.android.cursor.item/phone_v2", paramString1 });
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "delete success, num:" + paramString1 + ", result:" + j);
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2, String paramString3)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.a();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "updateOldNumber|element null!");
      }
    }
    int j;
    do
    {
      return;
      paramBaseApplicationImpl = new ContentValues();
      paramBaseApplicationImpl.put("data1", paramString1);
      paramBaseApplicationImpl.put("data2", Integer.valueOf(0));
      paramBaseApplicationImpl.put("data3", d);
      j = localBaseApplicationImpl.getContentResolver().update(ContactsContract.Data.CONTENT_URI, paramBaseApplicationImpl, "raw_contact_id=? AND mimetype = ? AND data1=?", new String[] { paramString3, "vnd.android.cursor.item/phone_v2", paramString2 });
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "update success, oldNum:" + paramString2 + ",phoneNew:" + paramString1 + ",result:" + j);
      }
    } while (j != 0);
    a(localBaseApplicationImpl, paramString2, paramString3);
    b(localBaseApplicationImpl, paramString1, paramString3);
  }
  
  private static void a(BaseApplicationImpl paramBaseApplicationImpl, String paramString, List paramList1, List paramList2)
  {
    int k = 0;
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.a();
    }
    if ((paramList1 == null) || (paramList1.size() == 0) || (paramList2 == null) || (paramList2.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = 0;
    while (j < paramList1.size())
    {
      a(localBaseApplicationImpl, (String)paramList1.get(j), paramString);
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "delete when setup > 30");
    }
    paramBaseApplicationImpl = SharedPreUtils.b(localBaseApplicationImpl.a().getAccount()).edit();
    j = k;
    if (j < paramList2.size())
    {
      paramList1 = (String)paramList2.get(j);
      if (!TextUtils.isEmpty(paramList1))
      {
        b(localBaseApplicationImpl, paramList1, paramString);
        if (j >= 6) {
          break label206;
        }
        paramBaseApplicationImpl.putString("callbackPhone_" + j, paramList1);
      }
      for (;;)
      {
        j += 1;
        break;
        label206:
        paramBaseApplicationImpl.putString("callbackPhone_f_" + (j - 6), paramList1);
      }
    }
    paramBaseApplicationImpl.commit();
  }
  
  /* Error */
  private static void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 130	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   8: astore_1
    //   9: getstatic 136	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   12: astore_2
    //   13: getstatic 57	com/tencent/mobileqq/app/PstnNumberManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: astore 4
    //   18: aload_1
    //   19: aload_2
    //   20: iconst_1
    //   21: anewarray 45	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 257
    //   29: aastore
    //   30: ldc_w 259
    //   33: iconst_1
    //   34: anewarray 45	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload 4
    //   41: aastore
    //   42: aconst_null
    //   43: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +61 -> 109
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokeinterface 268 1 0
    //   59: ifeq +50 -> 109
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokeinterface 271 1 0
    //   70: pop
    //   71: aload_2
    //   72: astore_1
    //   73: aload_2
    //   74: aload_2
    //   75: ldc_w 257
    //   78: invokeinterface 275 2 0
    //   83: invokeinterface 279 2 0
    //   88: astore 4
    //   90: aload_2
    //   91: astore_1
    //   92: aload 4
    //   94: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +12 -> 109
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: aload_0
    //   104: aload 4
    //   106: invokestatic 209	com/tencent/mobileqq/app/PstnNumberManager:b	(Lcom/tencent/common/app/BaseApplicationImpl;Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 282 1 0
    //   119: return
    //   120: astore_0
    //   121: aload_0
    //   122: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   125: return
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +16 -> 150
    //   137: aload_2
    //   138: astore_1
    //   139: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: iconst_2
    //   143: ldc_w 287
    //   146: aload_0
    //   147: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: ifnull -32 -> 119
    //   154: aload_2
    //   155: invokeinterface 282 1 0
    //   160: return
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +9 -> 180
    //   174: aload_1
    //   175: invokeinterface 282 1 0
    //   180: aload_0
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: astore_0
    //   191: goto -21 -> 170
    //   194: astore_0
    //   195: goto -66 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   8	167	1	localObject1	Object
    //   182	2	1	localException	Exception
    //   12	143	2	localObject2	Object
    //   3	100	3	localBaseApplicationImpl	BaseApplicationImpl
    //   16	89	4	str	String
    // Exception table:
    //   from	to	target	type
    //   113	119	120	java/lang/Exception
    //   4	47	126	java/lang/Throwable
    //   154	160	161	java/lang/Exception
    //   4	47	167	finally
    //   174	180	182	java/lang/Exception
    //   53	62	190	finally
    //   64	71	190	finally
    //   73	90	190	finally
    //   92	100	190	finally
    //   102	109	190	finally
    //   131	137	190	finally
    //   139	150	190	finally
    //   53	62	194	java/lang/Throwable
    //   64	71	194	java/lang/Throwable
    //   73	90	194	java/lang/Throwable
    //   92	100	194	java/lang/Throwable
    //   102	109	194	java/lang/Throwable
  }
  
  /* Error */
  public static void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +20 -> 24
    //   7: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: iconst_2
    //   17: ldc_w 293
    //   20: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: return
    //   24: invokestatic 295	com/tencent/mobileqq/app/PstnNumberManager:a	()Z
    //   27: ifne -4 -> 23
    //   30: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: iconst_2
    //   34: new 154	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 297
    //   44: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   60: astore 14
    //   62: new 299	java/util/ArrayList
    //   65: dup
    //   66: invokespecial 300	java/util/ArrayList:<init>	()V
    //   69: astore 15
    //   71: aconst_null
    //   72: astore_2
    //   73: aconst_null
    //   74: astore 10
    //   76: aconst_null
    //   77: astore 4
    //   79: aconst_null
    //   80: astore 11
    //   82: aconst_null
    //   83: astore 12
    //   85: aconst_null
    //   86: astore 9
    //   88: aconst_null
    //   89: astore 13
    //   91: aload 11
    //   93: astore 8
    //   95: aload 10
    //   97: astore 7
    //   99: aload_2
    //   100: astore 6
    //   102: aload 14
    //   104: invokevirtual 130	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   107: astore_3
    //   108: aload 11
    //   110: astore 8
    //   112: aload 10
    //   114: astore 7
    //   116: aload_2
    //   117: astore 6
    //   119: getstatic 136	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   122: astore 5
    //   124: aload 11
    //   126: astore 8
    //   128: aload 10
    //   130: astore 7
    //   132: aload_2
    //   133: astore 6
    //   135: getstatic 57	com/tencent/mobileqq/app/PstnNumberManager:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   138: astore 16
    //   140: aload 11
    //   142: astore 8
    //   144: aload 10
    //   146: astore 7
    //   148: aload_2
    //   149: astore 6
    //   151: aload_3
    //   152: aload 5
    //   154: iconst_1
    //   155: anewarray 45	java/lang/String
    //   158: dup
    //   159: iconst_0
    //   160: ldc_w 257
    //   163: aastore
    //   164: ldc_w 259
    //   167: iconst_1
    //   168: anewarray 45	java/lang/String
    //   171: dup
    //   172: iconst_0
    //   173: aload 16
    //   175: aastore
    //   176: aconst_null
    //   177: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   180: astore_2
    //   181: aload 12
    //   183: astore_3
    //   184: aload 13
    //   186: astore 5
    //   188: aload_2
    //   189: ifnull +260 -> 449
    //   192: aload 12
    //   194: astore_3
    //   195: aload 13
    //   197: astore 5
    //   199: aload 11
    //   201: astore 8
    //   203: aload 10
    //   205: astore 7
    //   207: aload_2
    //   208: astore 6
    //   210: aload_2
    //   211: invokeinterface 268 1 0
    //   216: ifeq +233 -> 449
    //   219: aload 11
    //   221: astore 8
    //   223: aload 10
    //   225: astore 7
    //   227: aload_2
    //   228: astore 6
    //   230: aload_2
    //   231: invokeinterface 271 1 0
    //   236: pop
    //   237: aload 11
    //   239: astore 8
    //   241: aload 10
    //   243: astore 7
    //   245: aload_2
    //   246: astore 6
    //   248: aload_2
    //   249: aload_2
    //   250: ldc_w 257
    //   253: invokeinterface 275 2 0
    //   258: invokeinterface 279 2 0
    //   263: astore 5
    //   265: aload 11
    //   267: astore 8
    //   269: aload 10
    //   271: astore 7
    //   273: aload_2
    //   274: astore 6
    //   276: aload 14
    //   278: invokevirtual 130	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   281: getstatic 136	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   284: iconst_1
    //   285: anewarray 45	java/lang/String
    //   288: dup
    //   289: iconst_0
    //   290: ldc 47
    //   292: aastore
    //   293: ldc_w 302
    //   296: iconst_2
    //   297: anewarray 45	java/lang/String
    //   300: dup
    //   301: iconst_0
    //   302: aload 5
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: ldc -116
    //   309: aastore
    //   310: aconst_null
    //   311: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   314: astore_3
    //   315: aload_3
    //   316: ifnull +133 -> 449
    //   319: aload_3
    //   320: invokeinterface 305 1 0
    //   325: ifeq +124 -> 449
    //   328: aload_3
    //   329: aload_3
    //   330: ldc 47
    //   332: invokeinterface 275 2 0
    //   337: invokeinterface 279 2 0
    //   342: astore 6
    //   344: aload 6
    //   346: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   349: ifne -30 -> 319
    //   352: aload 15
    //   354: aload 6
    //   356: invokeinterface 309 2 0
    //   361: pop
    //   362: goto -43 -> 319
    //   365: astore 5
    //   367: aload_3
    //   368: astore_0
    //   369: aconst_null
    //   370: astore_3
    //   371: aconst_null
    //   372: astore 6
    //   374: aload_2
    //   375: astore 4
    //   377: aload_0
    //   378: astore_2
    //   379: aload 6
    //   381: astore_0
    //   382: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +15 -> 400
    //   388: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   391: iconst_2
    //   392: ldc_w 311
    //   395: aload 5
    //   397: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 4
    //   402: ifnull +10 -> 412
    //   405: aload 4
    //   407: invokeinterface 282 1 0
    //   412: aload_2
    //   413: ifnull +9 -> 422
    //   416: aload_2
    //   417: invokeinterface 282 1 0
    //   422: aload_3
    //   423: ifnull +9 -> 432
    //   426: aload_3
    //   427: invokeinterface 282 1 0
    //   432: aload_0
    //   433: ifnull -410 -> 23
    //   436: aload_0
    //   437: invokeinterface 282 1 0
    //   442: return
    //   443: astore_0
    //   444: aload_0
    //   445: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   448: return
    //   449: aload_3
    //   450: astore 8
    //   452: aload 10
    //   454: astore 7
    //   456: aload_2
    //   457: astore 6
    //   459: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +77 -> 539
    //   465: aload_3
    //   466: astore 8
    //   468: aload 10
    //   470: astore 7
    //   472: aload_2
    //   473: astore 6
    //   475: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   478: iconst_2
    //   479: new 154	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   486: ldc_w 313
    //   489: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: ldc_w 315
    //   499: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: iload_1
    //   503: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   506: ldc_w 317
    //   509: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 5
    //   514: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: ldc_w 319
    //   520: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload 15
    //   525: invokeinterface 216 1 0
    //   530: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   533: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: aload_3
    //   540: astore 8
    //   542: aload 10
    //   544: astore 7
    //   546: aload_2
    //   547: astore 6
    //   549: aload 15
    //   551: invokeinterface 216 1 0
    //   556: ifne +680 -> 1236
    //   559: aload_3
    //   560: astore 8
    //   562: aload 10
    //   564: astore 7
    //   566: aload_2
    //   567: astore 6
    //   569: aload 14
    //   571: invokevirtual 130	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   574: astore 4
    //   576: aload_3
    //   577: astore 8
    //   579: aload 10
    //   581: astore 7
    //   583: aload_2
    //   584: astore 6
    //   586: getstatic 136	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   589: astore 11
    //   591: aload_3
    //   592: astore 8
    //   594: aload 10
    //   596: astore 7
    //   598: aload_2
    //   599: astore 6
    //   601: getstatic 61	com/tencent/mobileqq/app/PstnNumberManager:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   604: astore 12
    //   606: aload_3
    //   607: astore 8
    //   609: aload 10
    //   611: astore 7
    //   613: aload_2
    //   614: astore 6
    //   616: aload 4
    //   618: aload 11
    //   620: iconst_1
    //   621: anewarray 45	java/lang/String
    //   624: dup
    //   625: iconst_0
    //   626: ldc_w 257
    //   629: aastore
    //   630: ldc_w 259
    //   633: iconst_1
    //   634: anewarray 45	java/lang/String
    //   637: dup
    //   638: iconst_0
    //   639: aload 12
    //   641: aastore
    //   642: aconst_null
    //   643: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   646: astore 4
    //   648: aload 4
    //   650: ifnull +568 -> 1218
    //   653: aload_3
    //   654: astore 8
    //   656: aload 4
    //   658: astore 7
    //   660: aload_2
    //   661: astore 6
    //   663: aload 4
    //   665: invokeinterface 268 1 0
    //   670: ifeq +548 -> 1218
    //   673: aload_3
    //   674: astore 8
    //   676: aload 4
    //   678: astore 7
    //   680: aload_2
    //   681: astore 6
    //   683: aload 4
    //   685: invokeinterface 271 1 0
    //   690: pop
    //   691: aload_3
    //   692: astore 8
    //   694: aload 4
    //   696: astore 7
    //   698: aload_2
    //   699: astore 6
    //   701: aload 4
    //   703: aload 4
    //   705: ldc_w 257
    //   708: invokeinterface 275 2 0
    //   713: invokeinterface 279 2 0
    //   718: astore 5
    //   720: aload_3
    //   721: astore 8
    //   723: aload 4
    //   725: astore 7
    //   727: aload_2
    //   728: astore 6
    //   730: aload 14
    //   732: invokevirtual 130	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   735: getstatic 136	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   738: iconst_1
    //   739: anewarray 45	java/lang/String
    //   742: dup
    //   743: iconst_0
    //   744: ldc 47
    //   746: aastore
    //   747: ldc_w 302
    //   750: iconst_2
    //   751: anewarray 45	java/lang/String
    //   754: dup
    //   755: iconst_0
    //   756: aload 5
    //   758: aastore
    //   759: dup
    //   760: iconst_1
    //   761: ldc -116
    //   763: aastore
    //   764: aconst_null
    //   765: invokevirtual 263	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   768: astore 10
    //   770: aload 10
    //   772: astore 6
    //   774: aload 6
    //   776: ifnull +72 -> 848
    //   779: aload 6
    //   781: invokeinterface 305 1 0
    //   786: ifeq +62 -> 848
    //   789: aload 6
    //   791: aload 6
    //   793: ldc 47
    //   795: invokeinterface 275 2 0
    //   800: invokeinterface 279 2 0
    //   805: astore 7
    //   807: aload 7
    //   809: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne -33 -> 779
    //   815: aload 15
    //   817: aload 7
    //   819: invokeinterface 309 2 0
    //   824: pop
    //   825: goto -46 -> 779
    //   828: astore 5
    //   830: aload_2
    //   831: astore 7
    //   833: aload 6
    //   835: astore_0
    //   836: aload_3
    //   837: astore_2
    //   838: aload 4
    //   840: astore_3
    //   841: aload 7
    //   843: astore 4
    //   845: goto -463 -> 382
    //   848: aload 5
    //   850: astore 7
    //   852: aload 4
    //   854: astore 5
    //   856: aload 6
    //   858: astore 4
    //   860: aload 7
    //   862: astore 6
    //   864: aload 15
    //   866: invokeinterface 216 1 0
    //   871: ifne +84 -> 955
    //   874: getstatic 110	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   877: invokestatic 322	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/util/List;)Z
    //   880: pop
    //   881: aload_0
    //   882: iload_1
    //   883: aload 6
    //   885: invokestatic 324	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   888: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq +13 -> 904
    //   894: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   897: iconst_2
    //   898: ldc_w 326
    //   901: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   904: aload_2
    //   905: ifnull +9 -> 914
    //   908: aload_2
    //   909: invokeinterface 282 1 0
    //   914: aload_3
    //   915: ifnull +9 -> 924
    //   918: aload_3
    //   919: invokeinterface 282 1 0
    //   924: aload 5
    //   926: ifnull +10 -> 936
    //   929: aload 5
    //   931: invokeinterface 282 1 0
    //   936: aload 4
    //   938: ifnull -915 -> 23
    //   941: aload 4
    //   943: invokeinterface 282 1 0
    //   948: return
    //   949: astore_0
    //   950: aload_0
    //   951: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   954: return
    //   955: aload 15
    //   957: aload_0
    //   958: invokeinterface 329 2 0
    //   963: ifeq +22 -> 985
    //   966: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   969: ifeq -65 -> 904
    //   972: getstatic 43	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   975: iconst_2
    //   976: ldc_w 331
    //   979: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   982: goto -78 -> 904
    //   985: aload 15
    //   987: invokeinterface 216 1 0
    //   992: bipush 30
    //   994: if_icmple +15 -> 1009
    //   997: aload 14
    //   999: aload 6
    //   1001: aload 15
    //   1003: getstatic 110	com/tencent/mobileqq/app/PstnNumberManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1006: invokestatic 333	com/tencent/mobileqq/app/PstnNumberManager:a	(Lcom/tencent/common/app/BaseApplicationImpl;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   1009: aload_0
    //   1010: iload_1
    //   1011: aload 6
    //   1013: invokestatic 324	com/tencent/mobileqq/app/PstnNumberManager:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   1016: goto -112 -> 904
    //   1019: astore 6
    //   1021: aload 4
    //   1023: astore_0
    //   1024: aload 5
    //   1026: astore 4
    //   1028: aload_0
    //   1029: astore 5
    //   1031: aload 6
    //   1033: astore_0
    //   1034: aload_2
    //   1035: ifnull +9 -> 1044
    //   1038: aload_2
    //   1039: invokeinterface 282 1 0
    //   1044: aload_3
    //   1045: ifnull +9 -> 1054
    //   1048: aload_3
    //   1049: invokeinterface 282 1 0
    //   1054: aload 4
    //   1056: ifnull +10 -> 1066
    //   1059: aload 4
    //   1061: invokeinterface 282 1 0
    //   1066: aload 5
    //   1068: ifnull +10 -> 1078
    //   1071: aload 5
    //   1073: invokeinterface 282 1 0
    //   1078: aload_0
    //   1079: athrow
    //   1080: astore_2
    //   1081: aload_2
    //   1082: invokevirtual 285	java/lang/Exception:printStackTrace	()V
    //   1085: goto -7 -> 1078
    //   1088: astore_0
    //   1089: aload 9
    //   1091: astore 5
    //   1093: aload 8
    //   1095: astore_3
    //   1096: aload 7
    //   1098: astore 4
    //   1100: aload 6
    //   1102: astore_2
    //   1103: goto -69 -> 1034
    //   1106: astore_0
    //   1107: aload 9
    //   1109: astore 5
    //   1111: goto -77 -> 1034
    //   1114: astore_0
    //   1115: aload 6
    //   1117: astore 5
    //   1119: goto -85 -> 1034
    //   1122: astore 8
    //   1124: aload_0
    //   1125: astore 5
    //   1127: aload_3
    //   1128: astore 6
    //   1130: aload 4
    //   1132: astore 7
    //   1134: aload 8
    //   1136: astore_0
    //   1137: aload_2
    //   1138: astore_3
    //   1139: aload 6
    //   1141: astore 4
    //   1143: aload 7
    //   1145: astore_2
    //   1146: goto -112 -> 1034
    //   1149: astore 5
    //   1151: aconst_null
    //   1152: astore_0
    //   1153: aconst_null
    //   1154: astore_2
    //   1155: aconst_null
    //   1156: astore_3
    //   1157: aconst_null
    //   1158: astore 4
    //   1160: goto -778 -> 382
    //   1163: astore 5
    //   1165: aconst_null
    //   1166: astore_0
    //   1167: aconst_null
    //   1168: astore 6
    //   1170: aconst_null
    //   1171: astore_3
    //   1172: aload_2
    //   1173: astore 4
    //   1175: aload 6
    //   1177: astore_2
    //   1178: goto -796 -> 382
    //   1181: astore 5
    //   1183: aconst_null
    //   1184: astore_0
    //   1185: aconst_null
    //   1186: astore 6
    //   1188: aload_2
    //   1189: astore 4
    //   1191: aload_3
    //   1192: astore_2
    //   1193: aload 6
    //   1195: astore_3
    //   1196: goto -814 -> 382
    //   1199: astore 5
    //   1201: aconst_null
    //   1202: astore_0
    //   1203: aload_2
    //   1204: astore 6
    //   1206: aload_3
    //   1207: astore_2
    //   1208: aload 4
    //   1210: astore_3
    //   1211: aload 6
    //   1213: astore 4
    //   1215: goto -833 -> 382
    //   1218: aload 5
    //   1220: astore 6
    //   1222: aconst_null
    //   1223: astore 7
    //   1225: aload 4
    //   1227: astore 5
    //   1229: aload 7
    //   1231: astore 4
    //   1233: goto -369 -> 864
    //   1236: aconst_null
    //   1237: astore 4
    //   1239: aconst_null
    //   1240: astore 7
    //   1242: aload 5
    //   1244: astore 6
    //   1246: aload 7
    //   1248: astore 5
    //   1250: goto -386 -> 864
    //   1253: astore_0
    //   1254: aload 5
    //   1256: astore 6
    //   1258: aload_2
    //   1259: astore 7
    //   1261: aload_3
    //   1262: astore_2
    //   1263: aload_0
    //   1264: astore 5
    //   1266: aload 4
    //   1268: astore_0
    //   1269: aload 6
    //   1271: astore_3
    //   1272: aload 7
    //   1274: astore 4
    //   1276: goto -894 -> 382
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1279	0	paramString	String
    //   0	1279	1	paramInt	int
    //   72	967	2	localObject1	Object
    //   1080	2	2	localException	Exception
    //   1102	161	2	localObject2	Object
    //   107	1165	3	localObject3	Object
    //   77	1198	4	localObject4	Object
    //   122	181	5	localObject5	Object
    //   365	148	5	localThrowable1	Throwable
    //   718	39	5	str1	String
    //   828	21	5	localThrowable2	Throwable
    //   854	272	5	localObject6	Object
    //   1149	1	5	localThrowable3	Throwable
    //   1163	1	5	localThrowable4	Throwable
    //   1181	1	5	localThrowable5	Throwable
    //   1199	20	5	localThrowable6	Throwable
    //   1227	38	5	localObject7	Object
    //   100	912	6	localObject8	Object
    //   1019	97	6	localObject9	Object
    //   1128	142	6	localObject10	Object
    //   97	1176	7	localObject11	Object
    //   93	1001	8	localObject12	Object
    //   1122	13	8	localObject13	Object
    //   86	1022	9	localObject14	Object
    //   74	697	10	localCursor	android.database.Cursor
    //   80	539	11	localUri	Uri
    //   83	557	12	str2	String
    //   89	107	13	localObject15	Object
    //   60	938	14	localBaseApplicationImpl	BaseApplicationImpl
    //   69	933	15	localArrayList	java.util.ArrayList
    //   138	36	16	str3	String
    // Exception table:
    //   from	to	target	type
    //   319	362	365	java/lang/Throwable
    //   405	412	443	java/lang/Exception
    //   416	422	443	java/lang/Exception
    //   426	432	443	java/lang/Exception
    //   436	442	443	java/lang/Exception
    //   779	825	828	java/lang/Throwable
    //   908	914	949	java/lang/Exception
    //   918	924	949	java/lang/Exception
    //   929	936	949	java/lang/Exception
    //   941	948	949	java/lang/Exception
    //   864	904	1019	finally
    //   955	982	1019	finally
    //   985	1009	1019	finally
    //   1009	1016	1019	finally
    //   1038	1044	1080	java/lang/Exception
    //   1048	1054	1080	java/lang/Exception
    //   1059	1066	1080	java/lang/Exception
    //   1071	1078	1080	java/lang/Exception
    //   102	108	1088	finally
    //   119	124	1088	finally
    //   135	140	1088	finally
    //   151	181	1088	finally
    //   210	219	1088	finally
    //   230	237	1088	finally
    //   248	265	1088	finally
    //   276	315	1088	finally
    //   459	465	1088	finally
    //   475	539	1088	finally
    //   549	559	1088	finally
    //   569	576	1088	finally
    //   586	591	1088	finally
    //   601	606	1088	finally
    //   616	648	1088	finally
    //   663	673	1088	finally
    //   683	691	1088	finally
    //   701	720	1088	finally
    //   730	770	1088	finally
    //   319	362	1106	finally
    //   779	825	1114	finally
    //   382	400	1122	finally
    //   102	108	1149	java/lang/Throwable
    //   119	124	1149	java/lang/Throwable
    //   135	140	1149	java/lang/Throwable
    //   151	181	1149	java/lang/Throwable
    //   210	219	1163	java/lang/Throwable
    //   230	237	1163	java/lang/Throwable
    //   248	265	1163	java/lang/Throwable
    //   276	315	1163	java/lang/Throwable
    //   459	465	1181	java/lang/Throwable
    //   475	539	1181	java/lang/Throwable
    //   549	559	1181	java/lang/Throwable
    //   569	576	1181	java/lang/Throwable
    //   586	591	1181	java/lang/Throwable
    //   601	606	1181	java/lang/Throwable
    //   616	648	1181	java/lang/Throwable
    //   663	673	1199	java/lang/Throwable
    //   683	691	1199	java/lang/Throwable
    //   701	720	1199	java/lang/Throwable
    //   730	770	1199	java/lang/Throwable
    //   864	904	1253	java/lang/Throwable
    //   955	982	1253	java/lang/Throwable
    //   985	1009	1253	java/lang/Throwable
    //   1009	1016	1253	java/lang/Throwable
  }
  
  private static void a(String paramString1, int paramInt, String paramString2)
  {
    String str2 = "update_fixed_location";
    String str1 = "callbackPhone_";
    if (paramInt != 2)
    {
      str2 = "update_float_location";
      str1 = "callbackPhone_f_";
    }
    Object localObject = SharedPreUtils.b(BaseApplicationImpl.a().a().getAccount());
    int j = (((SharedPreferences)localObject).getInt(str2, 0) + 1) % 6;
    String str3 = ((SharedPreferences)localObject).getString(str1 + j, "");
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "numberType:" + paramInt + ",location:" + j + ",oldNum:" + str3 + ",newNum:" + paramString1);
    }
    if (!TextUtils.isEmpty(str3))
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(str2, j);
      ((SharedPreferences.Editor)localObject).putString(str1 + j, paramString1);
      ((SharedPreferences.Editor)localObject).commit();
      a(null, paramString1, str3, paramString2);
    }
    do
    {
      return;
      a(paramString1);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "number from sp is empty");
  }
  
  private static boolean a()
  {
    try
    {
      String str = BaseApplicationImpl.a().a().getAccount();
      if (1 == BaseApplicationImpl.getContext().getSharedPreferences(str, 0).getInt("key_gray_switch_no_need_add_address", 0))
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "updatePstnContact csBackPhoneNum gray switch break");
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }
  
  private static boolean a(List paramList)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    for (;;)
    {
      ContentValues localContentValues;
      Object localObject;
      long l;
      int j;
      try
      {
        localContentValues = new ContentValues();
        localObject = localBaseApplicationImpl.getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues);
        if (localObject == null) {
          return false;
        }
        l = ContentUris.parseId((Uri)localObject);
        localContentValues.clear();
        localContentValues.put("raw_contact_id", Long.valueOf(l));
        localContentValues.put("mimetype", "vnd.android.cursor.item/name");
        localContentValues.put("data1", jdField_c_of_type_JavaLangString);
        localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
        localObject = SharedPreUtils.b(localBaseApplicationImpl.a().getAccount()).edit();
        j = 0;
        if (j < paramList.size())
        {
          String str = (String)paramList.get(j);
          if (TextUtils.isEmpty(str)) {
            break label374;
          }
          localContentValues.clear();
          localContentValues.put("raw_contact_id", Long.valueOf(l));
          localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
          localContentValues.put("data1", str);
          localContentValues.put("data2", Integer.valueOf(0));
          localContentValues.put("data3", d);
          localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
          if (j < 6) {
            ((SharedPreferences.Editor)localObject).putString("callbackPhone_" + j, str);
          } else {
            ((SharedPreferences.Editor)localObject).putString("callbackPhone_f_" + (j - 6), str);
          }
        }
      }
      catch (Throwable paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "insert default_number exception ", paramList);
        }
        return false;
      }
      ((SharedPreferences.Editor)localObject).commit();
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/website");
      localContentValues.put("data1", "http://www.lightalk.com");
      localContentValues.put("data2", Integer.valueOf(1));
      localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "insert default number");
      }
      return true;
      label374:
      j += 1;
    }
  }
  
  private static void b(BaseApplicationImpl paramBaseApplicationImpl, String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localBaseApplicationImpl = BaseApplicationImpl.a();
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      paramBaseApplicationImpl = new ContentValues();
      paramBaseApplicationImpl.put("raw_contact_id", paramString2);
      paramBaseApplicationImpl.put("mimetype", "vnd.android.cursor.item/phone_v2");
      paramBaseApplicationImpl.put("data1", paramString1);
      paramBaseApplicationImpl.put("data2", Integer.valueOf(0));
      paramBaseApplicationImpl.put("data3", d);
      localBaseApplicationImpl.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, paramBaseApplicationImpl);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "insert success,num:" + paramString1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\PstnNumberManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
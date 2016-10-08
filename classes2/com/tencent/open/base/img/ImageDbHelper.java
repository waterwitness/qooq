package com.tencent.open.base.img;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ImageDbHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 4;
  public static final String a;
  protected static final byte[] a;
  protected static final String[] a;
  protected static final int b = 0;
  protected static final String b = "appcenterImagedb.db";
  protected static final int c = 1;
  protected static String c;
  protected static final int d = 2;
  protected static final String d = "key";
  protected static final int e = 3;
  protected static final String e = "maxage";
  protected static final int f = 4;
  protected static final String f = "updatetime";
  protected static final String g = "modified";
  protected static final String h = "local";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = ImageDbHelper.class.getSimpleName();
    jdField_c_of_type_JavaLangString = "sys_image";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key", "maxage", "updatetime", "modified", "local" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public ImageDbHelper(Context paramContext)
  {
    super(paramContext, "appcenterImagedb.db", null, 4);
  }
  
  protected ImageInfo a(Cursor paramCursor)
  {
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.jdField_a_of_type_JavaLangString = paramCursor.getString(0);
    localImageInfo.jdField_a_of_type_Long = paramCursor.getLong(1);
    localImageInfo.b = paramCursor.getLong(2);
    localImageInfo.jdField_c_of_type_Long = paramCursor.getLong(3);
    localImageInfo.jdField_c_of_type_JavaLangString = paramCursor.getString(4);
    return localImageInfo;
  }
  
  /* Error */
  public ImageInfo a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 59	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 96	com/tencent/open/base/img/ImageDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_2
    //   22: aload_2
    //   23: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   26: getstatic 57	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc 98
    //   31: iconst_1
    //   32: anewarray 55	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload 6
    //   48: astore_1
    //   49: aload_3
    //   50: invokeinterface 108 1 0
    //   55: ifle +16 -> 71
    //   58: aload_3
    //   59: invokeinterface 112 1 0
    //   64: pop
    //   65: aload_0
    //   66: aload_3
    //   67: invokevirtual 114	com/tencent/open/base/img/ImageDbHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/base/img/ImageInfo;
    //   70: astore_1
    //   71: aload_3
    //   72: ifnull +9 -> 81
    //   75: aload_3
    //   76: invokeinterface 117 1 0
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_1
    //   92: astore_3
    //   93: aload 7
    //   95: monitorexit
    //   96: aload_3
    //   97: areturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload_2
    //   112: invokeinterface 117 1 0
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: ifnull -28 -> 93
    //   124: aload_1
    //   125: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   128: aload 5
    //   130: astore_3
    //   131: goto -38 -> 93
    //   134: astore_1
    //   135: aload 7
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 4
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +9 -> 156
    //   150: aload_3
    //   151: invokeinterface 117 1 0
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_3
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: astore_3
    //   174: goto -28 -> 146
    //   177: astore 4
    //   179: aload_2
    //   180: astore_1
    //   181: aload 4
    //   183: astore_2
    //   184: goto -38 -> 146
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -48 -> 146
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -99 -> 103
    //   205: astore 6
    //   207: aload_3
    //   208: astore_1
    //   209: aload_2
    //   210: astore 4
    //   212: aload 6
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload 4
    //   219: astore_1
    //   220: goto -117 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	ImageDbHelper
    //   0	223	1	paramString	String
    //   21	91	2	localSQLiteDatabase	SQLiteDatabase
    //   140	28	2	localObject1	Object
    //   170	47	2	localObject2	Object
    //   45	52	3	localObject3	Object
    //   98	6	3	localException1	Exception
    //   119	32	3	localObject4	Object
    //   166	4	3	localObject5	Object
    //   173	18	3	localObject6	Object
    //   197	11	3	localException2	Exception
    //   214	1	3	localException3	Exception
    //   4	168	4	localObject7	Object
    //   177	5	4	localObject8	Object
    //   187	5	4	localObject9	Object
    //   210	8	4	localObject10	Object
    //   1	128	5	localObject11	Object
    //   7	40	6	localObject12	Object
    //   205	8	6	localException4	Exception
    //   12	124	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	98	java/lang/Exception
    //   75	81	134	finally
    //   87	91	134	finally
    //   93	96	134	finally
    //   111	117	134	finally
    //   124	128	134	finally
    //   135	138	134	finally
    //   150	156	134	finally
    //   160	164	134	finally
    //   164	166	134	finally
    //   17	22	140	finally
    //   22	46	166	finally
    //   49	71	177	finally
    //   103	107	187	finally
    //   22	46	197	java/lang/Exception
    //   49	71	205	java/lang/Exception
  }
  
  /* Error */
  public java.util.List a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 59	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore 5
    //   9: aload 5
    //   11: monitorenter
    //   12: new 124	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 125	java/util/ArrayList:<init>	()V
    //   19: astore 6
    //   21: aload_0
    //   22: invokevirtual 96	com/tencent/open/base/img/ImageDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: astore_1
    //   26: aload_1
    //   27: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   30: getstatic 57	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 104	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_3
    //   42: aload_3
    //   43: invokeinterface 108 1 0
    //   48: ifle +36 -> 84
    //   51: aload_3
    //   52: invokeinterface 112 1 0
    //   57: pop
    //   58: aload 6
    //   60: aload_0
    //   61: aload_3
    //   62: invokevirtual 114	com/tencent/open/base/img/ImageDbHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/base/img/ImageInfo;
    //   65: invokeinterface 131 2 0
    //   70: pop
    //   71: aload_3
    //   72: invokeinterface 134 1 0
    //   77: istore 7
    //   79: iload 7
    //   81: ifne -23 -> 58
    //   84: aload_3
    //   85: ifnull +9 -> 94
    //   88: aload_3
    //   89: invokeinterface 117 1 0
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   102: aload 5
    //   104: monitorexit
    //   105: aload 6
    //   107: areturn
    //   108: astore_3
    //   109: aconst_null
    //   110: astore 4
    //   112: aload_2
    //   113: astore_1
    //   114: aload 4
    //   116: astore_2
    //   117: aload_3
    //   118: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   121: aload_2
    //   122: ifnull +9 -> 131
    //   125: aload_2
    //   126: invokeinterface 117 1 0
    //   131: aload_1
    //   132: ifnull -30 -> 102
    //   135: aload_1
    //   136: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   139: goto -37 -> 102
    //   142: astore_1
    //   143: aload 5
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: astore_2
    //   149: aconst_null
    //   150: astore 4
    //   152: aload_3
    //   153: astore_1
    //   154: aload 4
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull +9 -> 167
    //   161: aload_3
    //   162: invokeinterface 117 1 0
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aload_2
    //   176: athrow
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_3
    //   180: goto -23 -> 157
    //   183: astore_2
    //   184: goto -27 -> 157
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -37 -> 157
    //   197: astore_3
    //   198: aconst_null
    //   199: astore_2
    //   200: goto -83 -> 117
    //   203: astore_2
    //   204: aload_3
    //   205: astore 4
    //   207: aload_2
    //   208: astore_3
    //   209: aload 4
    //   211: astore_2
    //   212: goto -95 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	ImageDbHelper
    //   25	111	1	localObject1	Object
    //   142	5	1	localObject2	Object
    //   153	19	1	localException1	Exception
    //   3	123	2	localObject3	Object
    //   148	28	2	localObject4	Object
    //   177	1	2	localObject5	Object
    //   183	7	2	localObject6	Object
    //   193	7	2	localObject7	Object
    //   203	5	2	localException2	Exception
    //   211	1	2	localObject8	Object
    //   1	88	3	localCursor	Cursor
    //   108	45	3	localException3	Exception
    //   156	35	3	localObject9	Object
    //   197	8	3	localException4	Exception
    //   208	1	3	localObject10	Object
    //   110	45	4	localObject11	Object
    //   187	5	4	localObject12	Object
    //   205	5	4	localException5	Exception
    //   7	137	5	arrayOfByte	byte[]
    //   19	87	6	localArrayList	java.util.ArrayList
    //   77	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	26	108	java/lang/Exception
    //   12	21	142	finally
    //   88	94	142	finally
    //   98	102	142	finally
    //   102	105	142	finally
    //   125	131	142	finally
    //   135	139	142	finally
    //   143	146	142	finally
    //   161	167	142	finally
    //   171	175	142	finally
    //   175	177	142	finally
    //   21	26	148	finally
    //   26	42	177	finally
    //   42	58	183	finally
    //   58	79	183	finally
    //   117	121	187	finally
    //   26	42	197	java/lang/Exception
    //   42	58	203	java/lang/Exception
    //   58	79	203	java/lang/Exception
  }
  
  /* Error */
  public void a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 59	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore 6
    //   9: aload 6
    //   11: monitorenter
    //   12: aload_1
    //   13: ifnonnull +7 -> 20
    //   16: aload 6
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 138	com/tencent/open/base/img/ImageDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: aload 4
    //   28: astore_2
    //   29: aload 4
    //   31: astore_3
    //   32: new 140	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 141	android/content/ContentValues:<init>	()V
    //   39: astore 7
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_3
    //   47: aload 7
    //   49: ldc 20
    //   51: aload_1
    //   52: getfield 77	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 145	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: aload 7
    //   66: ldc 24
    //   68: aload_1
    //   69: getfield 84	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_Long	J
    //   72: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: invokevirtual 154	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload 7
    //   86: ldc 27
    //   88: aload_1
    //   89: getfield 86	com/tencent/open/base/img/ImageInfo:b	J
    //   92: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: invokevirtual 154	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: ldc 30
    //   108: aload_1
    //   109: getfield 88	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   112: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: invokevirtual 154	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   118: aload 4
    //   120: astore_2
    //   121: aload 4
    //   123: astore_3
    //   124: aload 7
    //   126: ldc 33
    //   128: aload_1
    //   129: getfield 89	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokevirtual 145	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: astore_2
    //   138: aload 4
    //   140: astore_3
    //   141: getstatic 49	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: astore 8
    //   146: aload 4
    //   148: astore_2
    //   149: aload 4
    //   151: astore_3
    //   152: new 156	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   159: ldc -97
    //   161: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore 9
    //   166: aload_1
    //   167: ifnonnull +106 -> 273
    //   170: ldc -91
    //   172: astore 5
    //   174: aload 4
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: aload 8
    //   182: aload 9
    //   184: aload 5
    //   186: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 172	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 4
    //   197: astore_3
    //   198: aload 4
    //   200: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   203: new 156	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   210: ldc -82
    //   212: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: getfield 77	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -80
    //   224: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: aconst_null
    //   231: invokevirtual 180	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   234: pop
    //   235: aload 4
    //   237: astore_2
    //   238: aload 4
    //   240: astore_3
    //   241: aload 4
    //   243: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   246: aconst_null
    //   247: aload 7
    //   249: invokevirtual 184	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   252: pop2
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   263: aload 6
    //   265: monitorexit
    //   266: return
    //   267: astore_1
    //   268: aload 6
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: aload 4
    //   275: astore_2
    //   276: aload 4
    //   278: astore_3
    //   279: aload_1
    //   280: getfield 77	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   283: astore 5
    //   285: goto -111 -> 174
    //   288: astore_1
    //   289: aload 4
    //   291: astore_2
    //   292: aload 4
    //   294: astore_3
    //   295: aload_1
    //   296: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   299: goto -64 -> 235
    //   302: astore_1
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 49	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: ldc -70
    //   310: aload_1
    //   311: invokestatic 189	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: ifnull -52 -> 263
    //   318: aload_2
    //   319: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   322: goto -59 -> 263
    //   325: astore_1
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 118	android/database/sqlite/SQLiteDatabase:close	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	ImageDbHelper
    //   0	336	1	paramImageInfo	ImageInfo
    //   3	316	2	localObject1	Object
    //   1	330	3	localObject2	Object
    //   24	269	4	localSQLiteDatabase	SQLiteDatabase
    //   172	112	5	str1	String
    //   7	262	6	arrayOfByte	byte[]
    //   39	209	7	localContentValues	android.content.ContentValues
    //   144	37	8	str2	String
    //   164	19	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	19	267	finally
    //   258	263	267	finally
    //   263	266	267	finally
    //   268	271	267	finally
    //   318	322	267	finally
    //   330	334	267	finally
    //   334	336	267	finally
    //   198	235	288	java/lang/Exception
    //   20	26	302	java/lang/Exception
    //   32	41	302	java/lang/Exception
    //   47	58	302	java/lang/Exception
    //   64	78	302	java/lang/Exception
    //   84	98	302	java/lang/Exception
    //   104	118	302	java/lang/Exception
    //   124	135	302	java/lang/Exception
    //   141	146	302	java/lang/Exception
    //   152	166	302	java/lang/Exception
    //   180	195	302	java/lang/Exception
    //   241	253	302	java/lang/Exception
    //   279	285	302	java/lang/Exception
    //   295	299	302	java/lang/Exception
    //   20	26	325	finally
    //   32	41	325	finally
    //   47	58	325	finally
    //   64	78	325	finally
    //   84	98	325	finally
    //   104	118	325	finally
    //   124	135	325	finally
    //   141	146	325	finally
    //   152	166	325	finally
    //   180	195	325	finally
    //   198	235	325	finally
    //   241	253	325	finally
    //   279	285	325	finally
    //   295	299	325	finally
    //   305	314	325	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + jdField_c_of_type_JavaLangString + " (" + "key" + " VARCHAR(50)," + "local" + " VARCHAR(50)," + "maxage" + " BIGINT," + "updatetime" + " BIGINT," + "modified" + " BIGINT,PRIMARY KEY(" + "key" + "))");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + jdField_c_of_type_JavaLangString + ";");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\img\ImageDbHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
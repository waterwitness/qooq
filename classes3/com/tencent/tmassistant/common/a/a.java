package com.tencent.tmassistant.common.a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements c
{
  /* Error */
  public b a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 17	com/tencent/tmassistant/common/a/b
    //   6: dup
    //   7: invokespecial 18	com/tencent/tmassistant/common/a/b:<init>	()V
    //   10: astore 4
    //   12: aload 4
    //   14: new 20	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 21	java/util/ArrayList:<init>	()V
    //   21: putfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   24: aload 4
    //   26: new 20	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 21	java/util/ArrayList:<init>	()V
    //   33: putfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   36: iload_1
    //   37: ifle +216 -> 253
    //   40: new 29	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   47: ldc 32
    //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore_2
    //   60: aload_0
    //   61: invokevirtual 47	com/tencent/tmassistant/common/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   64: invokevirtual 53	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +129 -> 198
    //   72: aload_3
    //   73: aload_0
    //   74: invokevirtual 56	com/tencent/tmassistant/common/a/a:d	()Ljava/lang/String;
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: ldc 58
    //   84: aload_2
    //   85: invokevirtual 64	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull +98 -> 188
    //   93: aload_3
    //   94: astore_2
    //   95: aload_3
    //   96: invokeinterface 70 1 0
    //   101: ifeq +87 -> 188
    //   104: aload_3
    //   105: astore_2
    //   106: aload_3
    //   107: aload_3
    //   108: ldc 72
    //   110: invokeinterface 76 2 0
    //   115: invokeinterface 80 2 0
    //   120: lstore 7
    //   122: aload_3
    //   123: astore_2
    //   124: aload 4
    //   126: getfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   129: lload 7
    //   131: invokestatic 86	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: invokeinterface 92 2 0
    //   139: pop
    //   140: aload_3
    //   141: astore_2
    //   142: aload_3
    //   143: aload_3
    //   144: ldc 94
    //   146: invokeinterface 76 2 0
    //   151: invokeinterface 98 2 0
    //   156: astore 6
    //   158: aload_3
    //   159: astore_2
    //   160: aload 4
    //   162: getfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   165: aload 6
    //   167: invokeinterface 92 2 0
    //   172: pop
    //   173: aload_3
    //   174: astore_2
    //   175: aload_3
    //   176: invokeinterface 101 1 0
    //   181: istore 9
    //   183: iload 9
    //   185: ifne -81 -> 104
    //   188: aload_3
    //   189: ifnull +9 -> 198
    //   192: aload_3
    //   193: invokeinterface 104 1 0
    //   198: aload 4
    //   200: astore_2
    //   201: aload_2
    //   202: areturn
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_3
    //   207: aload_3
    //   208: astore_2
    //   209: aload 4
    //   211: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   214: aload 5
    //   216: astore_2
    //   217: aload_3
    //   218: ifnull -17 -> 201
    //   221: aload_3
    //   222: invokeinterface 104 1 0
    //   227: aconst_null
    //   228: areturn
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_2
    //   232: aload_2
    //   233: ifnull +9 -> 242
    //   236: aload_2
    //   237: invokeinterface 104 1 0
    //   242: aload_3
    //   243: athrow
    //   244: astore_3
    //   245: goto -13 -> 232
    //   248: astore 4
    //   250: goto -43 -> 207
    //   253: aconst_null
    //   254: astore_2
    //   255: goto -195 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	a
    //   0	258	1	paramInt	int
    //   59	196	2	localObject1	Object
    //   67	155	3	localObject2	Object
    //   229	14	3	localObject3	Object
    //   244	1	3	localObject4	Object
    //   10	189	4	localb	b
    //   203	7	4	localException1	Exception
    //   248	1	4	localException2	Exception
    //   1	214	5	localObject5	Object
    //   156	10	6	arrayOfByte	byte[]
    //   120	10	7	l	long
    //   181	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   72	89	203	java/lang/Exception
    //   72	89	229	finally
    //   95	104	244	finally
    //   106	122	244	finally
    //   124	140	244	finally
    //   142	158	244	finally
    //   160	173	244	finally
    //   175	183	244	finally
    //   209	214	244	finally
    //   95	104	248	java/lang/Exception
    //   106	122	248	java/lang/Exception
    //   124	140	248	java/lang/Exception
    //   142	158	248	java/lang/Exception
    //   160	173	248	java/lang/Exception
    //   175	183	248	java/lang/Exception
  }
  
  public String a()
  {
    return d();
  }
  
  public boolean a(List<byte[]> paramList)
  {
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = c().getWritableDatabase();
        if (localSQLiteDatabase != null) {
          try
          {
            localSQLiteDatabase.beginTransaction();
            SQLiteStatement localSQLiteStatement = localSQLiteDatabase.compileStatement(f());
            paramList = paramList.iterator();
            if (paramList.hasNext())
            {
              localSQLiteStatement.bindBlob(1, (byte[])paramList.next());
              localSQLiteStatement.executeInsert();
              continue;
            }
            paramList = finally;
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
            bool = false;
            try
            {
              localSQLiteDatabase.endTransaction();
              return bool;
            }
            catch (Exception paramList) {}
            localSQLiteDatabase.setTransactionSuccessful();
          }
          finally
          {
            localSQLiteDatabase.endTransaction();
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 157	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 158	android/content/ContentValues:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc 94
    //   13: aload_1
    //   14: invokevirtual 162	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   17: aload_0
    //   18: invokevirtual 47	com/tencent/tmassistant/common/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   21: invokevirtual 111	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: aload_0
    //   25: invokevirtual 56	com/tencent/tmassistant/common/a/a:d	()Ljava/lang/String;
    //   28: aconst_null
    //   29: aload_2
    //   30: invokevirtual 166	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   33: lstore_3
    //   34: lload_3
    //   35: lconst_0
    //   36: lcmp
    //   37: ifle +11 -> 48
    //   40: iconst_1
    //   41: istore 5
    //   43: aload_0
    //   44: monitorexit
    //   45: iload 5
    //   47: ireturn
    //   48: iconst_0
    //   49: istore 5
    //   51: goto -8 -> 43
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	a
    //   0	59	1	paramArrayOfByte	byte[]
    //   9	21	2	localContentValues	android.content.ContentValues
    //   33	2	3	l	long
    //   41	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	34	54	finally
  }
  
  public String[] a(int paramInt1, int paramInt2)
  {
    return b(paramInt2);
  }
  
  public String b()
  {
    return e();
  }
  
  public boolean b(List<Long> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      StringBuffer localStringBuffer;
      try
      {
        int i = paramList.size();
        if (i <= 0)
        {
          bool = false;
          return bool;
        }
        localStringBuffer = new StringBuffer("(");
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localStringBuffer.append((Long)paramList.next());
          localStringBuffer.append(",");
          continue;
        }
        if (localStringBuffer.length() <= 0) {
          break label98;
        }
      }
      finally {}
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      label98:
      localStringBuffer.append(")");
      paramList = c().getWritableDatabase();
      if (paramList != null) {
        paramList.delete(d(), "_id in " + localStringBuffer, null);
      }
      boolean bool = true;
    }
  }
  
  protected abstract String[] b(int paramInt);
  
  public d c()
  {
    return com.tencent.tmassistantsdk.internal.d.a.a.c();
  }
  
  protected abstract String d();
  
  protected abstract String e();
  
  protected abstract String f();
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\tmassistant\common\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
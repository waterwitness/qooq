package com.weiyun.sdk.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.util.Utils;

public class TaskDBHelper
  extends LibFileDatabaseHelper.NativeDBHelper
{
  protected static final String FILE_ID_SELECTION = "task_file_id=? AND task_uin=? AND task_type=?";
  protected static final String[] ID_PROJECTION = { "_id" };
  protected static final String PATH_SELECTION = "task_file_path=? AND task_uin=? AND task_type=?";
  public static final int TASK_TYPE_DOWNLOAD = 2;
  public static final int TASK_TYPE_UPLOAD = 1;
  
  public TaskDBHelper(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    super("lib_task", paramSQLiteOpenHelper);
  }
  
  public static TaskDBHelper newDBHelper()
  {
    return new TaskDBHelper(LibFileDatabaseHelper.getInstance(SdkContext.getInstance().getContext()));
  }
  
  public DownloadJobContext getDownloadJobContext(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = Integer.toString(2);
    paramString1 = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_id", "task_file_name", "task_local_name", "task_file_md5" }, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, str });
    if (paramString1 == null) {
      return null;
    }
    try
    {
      if (paramString1.moveToNext())
      {
        long l = paramString1.getLong(0);
        paramString2 = new DownloadJobContext(Long.parseLong(paramString2), l, paramString3, paramString4);
        paramString2.setCurSize(paramString1.getLong(1));
        paramString2.setTotalSize(paramString1.getLong(2));
        paramString2.setModifyTime(paramString1.getLong(3));
        paramString2.setFileId(paramString1.getString(4));
        paramString2.setFileName(paramString1.getString(5));
        paramString2.setDestFileName(paramString1.getString(6));
        paramString2.setMd5(paramString1.getString(7));
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  /* Error */
  public String getDownloadNewFileName(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: bipush 47
    //   3: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   6: istore 5
    //   8: aload_1
    //   9: astore_2
    //   10: iload 5
    //   12: iflt +12 -> 24
    //   15: aload_1
    //   16: iload 5
    //   18: iconst_1
    //   19: iadd
    //   20: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: astore_3
    //   26: ldc -112
    //   28: astore_1
    //   29: aload_2
    //   30: bipush 46
    //   32: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   35: istore 5
    //   37: iload 5
    //   39: iflt +19 -> 58
    //   42: aload_2
    //   43: iload 5
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_2
    //   52: iload 5
    //   54: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   57: astore_1
    //   58: new 146	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   65: astore 4
    //   67: aload 4
    //   69: ldc 73
    //   71: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc -102
    //   76: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: aload_3
    //   83: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc -100
    //   88: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc -98
    //   97: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 4
    //   103: ldc -96
    //   105: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 73
    //   110: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc -94
    //   115: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 4
    //   121: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_1
    //   125: aload_0
    //   126: iconst_1
    //   127: anewarray 22	java/lang/String
    //   130: dup
    //   131: iconst_0
    //   132: ldc 73
    //   134: aastore
    //   135: aload_1
    //   136: iconst_1
    //   137: anewarray 22	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: aload_2
    //   143: aastore
    //   144: ldc -89
    //   146: aconst_null
    //   147: invokevirtual 170	com/weiyun/sdk/store/TaskDBHelper:query	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   150: astore_1
    //   151: aload_1
    //   152: ifnonnull +5 -> 157
    //   155: aload_2
    //   156: areturn
    //   157: iconst_m1
    //   158: istore 5
    //   160: aload_1
    //   161: invokeinterface 85 1 0
    //   166: ifeq +111 -> 277
    //   169: aload_1
    //   170: iconst_0
    //   171: invokeinterface 113 2 0
    //   176: astore_3
    //   177: aload_3
    //   178: aload_2
    //   179: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: istore 7
    //   184: iload 7
    //   186: ifeq +17 -> 203
    //   189: iload 5
    //   191: ifle +6 -> 197
    //   194: goto -34 -> 160
    //   197: iconst_0
    //   198: istore 5
    //   200: goto -6 -> 194
    //   203: aload_3
    //   204: aload_3
    //   205: ldc -80
    //   207: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   210: iconst_1
    //   211: iadd
    //   212: aload_3
    //   213: ldc -75
    //   215: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   218: invokevirtual 184	java/lang/String:substring	(II)Ljava/lang/String;
    //   221: invokestatic 188	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   224: invokevirtual 192	java/lang/Integer:intValue	()I
    //   227: istore 6
    //   229: iload 5
    //   231: iload 6
    //   233: if_icmple +6 -> 239
    //   236: goto -76 -> 160
    //   239: iload 6
    //   241: istore 5
    //   243: goto -7 -> 236
    //   246: astore_3
    //   247: ldc -62
    //   249: aload_3
    //   250: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   253: pop
    //   254: goto -94 -> 160
    //   257: astore_2
    //   258: aload_1
    //   259: invokeinterface 129 1 0
    //   264: aload_2
    //   265: athrow
    //   266: astore_3
    //   267: ldc -62
    //   269: aload_3
    //   270: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   273: pop
    //   274: goto -114 -> 160
    //   277: iload 5
    //   279: iflt +20 -> 299
    //   282: aload_2
    //   283: iload 5
    //   285: iconst_1
    //   286: iadd
    //   287: invokestatic 206	com/weiyun/sdk/util/Utils:fileRename	(Ljava/lang/String;I)Ljava/lang/String;
    //   290: astore_2
    //   291: aload_1
    //   292: invokeinterface 129 1 0
    //   297: aload_2
    //   298: areturn
    //   299: aload_1
    //   300: invokeinterface 129 1 0
    //   305: aload_2
    //   306: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	TaskDBHelper
    //   0	307	1	paramString	String
    //   9	170	2	str1	String
    //   257	26	2	str2	String
    //   290	16	2	str3	String
    //   25	188	3	str4	String
    //   246	4	3	localNumberFormatException	NumberFormatException
    //   266	4	3	localIndexOutOfBoundsException	IndexOutOfBoundsException
    //   65	55	4	localStringBuilder	StringBuilder
    //   6	281	5	i	int
    //   227	13	6	j	int
    //   182	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   203	229	246	java/lang/NumberFormatException
    //   160	184	257	finally
    //   203	229	257	finally
    //   247	254	257	finally
    //   267	274	257	finally
    //   282	291	257	finally
    //   203	229	266	java/lang/IndexOutOfBoundsException
  }
  
  public long getDownloadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }));
  }
  
  protected long getId(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return 0L;
    }
    int i = paramCursor.getColumnIndex("_id");
    try
    {
      if (paramCursor.moveToNext())
      {
        long l = paramCursor.getLong(i);
        return l;
      }
      return 0L;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public UploadJobContext getUploadJobContext(String paramString1, String paramString2)
  {
    Object localObject = Integer.toString(1);
    localObject = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_md5", "task_file_sha", "task_file_id" }, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, localObject });
    if (localObject == null) {
      return null;
    }
    try
    {
      if (((Cursor)localObject).moveToNext())
      {
        long l = ((Cursor)localObject).getLong(0);
        paramString2 = new UploadJobContext(Long.parseLong(paramString2), l, paramString1);
        paramString2.setCurSize(((Cursor)localObject).getLong(1));
        paramString2.setTotalSize(((Cursor)localObject).getLong(2));
        paramString2.setModifyTime(((Cursor)localObject).getLong(3));
        paramString2.setMd5(((Cursor)localObject).getString(4));
        paramString2.setSha(((Cursor)localObject).getString(5));
        paramString2.setFileId(((Cursor)localObject).getString(6));
        paramString2.setFileName(Utils.getFileNameFromPath(paramString1));
        return paramString2;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public long getUploadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }));
  }
  
  public long initDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(2));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_id", paramString1);
    localContentValues.put("task_file_name", paramString3);
    localContentValues.put("task_local_name", paramString3);
    return insertItem(localContentValues);
  }
  
  public long initUploadTask(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(1));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_path", paramString1);
    return insertItem(localContentValues);
  }
  
  public boolean isFileDownloading(String paramString1, String paramString2)
  {
    return getCount("task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }) == 1;
  }
  
  public boolean isFileUplading(String paramString1, String paramString2)
  {
    return getCount("task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }) == 1;
  }
  
  public boolean updateDownloadContext(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_local_name", paramString1);
    localContentValues.put("task_file_md5", paramString2);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateDownloadFileSizeAndModifyTime(long paramLong1, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong2));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong3));
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadContext(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong4));
    localContentValues.put("task_file_id", paramString);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadFileMd5(long paramLong, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_file_md5", paramString1);
    localContentValues.put("task_file_sha", paramString2);
    return updateItem(localContentValues, paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\weiyun\sdk\store\TaskDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
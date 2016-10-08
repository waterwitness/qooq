package cooperation.weiyun.albumstatus;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyBizManager;
import com.weiyun.sdk.IWyFileSystem;
import cooperation.weiyun.AlbumBackupInfo;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunProxyBroadcastReceiver;
import java.lang.reflect.Field;
import mqq.app.AppRuntime;
import yug;

public class AlbumStatus
{
  public AlbumStatus()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  private static int a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 25	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 31	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   7: iconst_1
    //   8: anewarray 33	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: ldc 35
    //   15: aastore
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 41	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +36 -> 60
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: invokeinterface 47 1 0
    //   35: ifeq +25 -> 60
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: iconst_0
    //   42: invokeinterface 51 2 0
    //   47: istore_3
    //   48: aload_1
    //   49: ifnull +9 -> 58
    //   52: aload_1
    //   53: invokeinterface 54 1 0
    //   58: iload_3
    //   59: ireturn
    //   60: aload_1
    //   61: ifnull +9 -> 70
    //   64: aload_1
    //   65: invokeinterface 54 1 0
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +30 -> 110
    //   83: aload_1
    //   84: astore_0
    //   85: ldc 61
    //   87: iconst_2
    //   88: new 63	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   95: ldc 66
    //   97: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 81	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_1
    //   111: ifnull -41 -> 70
    //   114: aload_1
    //   115: invokeinterface 54 1 0
    //   120: goto -50 -> 70
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +9 -> 136
    //   130: aload_0
    //   131: invokeinterface 54 1 0
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -13 -> 126
    //   142: astore_2
    //   143: goto -68 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramContext	Context
    //   22	93	1	localCursor	android.database.Cursor
    //   123	14	1	localObject1	Object
    //   138	1	1	localObject2	Object
    //   72	29	2	localSQLiteException1	android.database.sqlite.SQLiteException
    //   142	1	2	localSQLiteException2	android.database.sqlite.SQLiteException
    //   47	12	3	i	int
    // Exception table:
    //   from	to	target	type
    //   0	23	72	android/database/sqlite/SQLiteException
    //   0	23	123	finally
    //   29	38	138	finally
    //   40	48	138	finally
    //   77	83	138	finally
    //   85	110	138	finally
    //   29	38	142	android/database/sqlite/SQLiteException
    //   40	48	142	android/database/sqlite/SQLiteException
  }
  
  private static long a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext, 0);
      if (Build.VERSION.SDK_INT >= 9) {
        return paramContext.firstInstallTime;
      }
      long l = PackageInfo.class.getField("firstInstallTime").getLong(paramContext);
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public static void a(Context paramContext)
  {
    if (AlbumBackupInfo.a(paramContext, BaseApplicationImpl.a().a().getAccount()))
    {
      WeiyunProxyBroadcastReceiver.a(paramContext, "com.weiyun.plugin.albumbackup.receiver.AlbumStatusBroadcastReceiver", null);
      return;
    }
    b(paramContext);
  }
  
  private static void b(Context paramContext)
  {
    int i = a(paramContext);
    long l = System.currentTimeMillis() - a(paramContext);
    WeiyunHelper.a().getBizManager().reportAlbumStatus(false, i, i, l, new yug());
    if (QLog.isColorLevel()) {
      QLog.i("Weiyun.AlbumBackup", 2, "report album status immediately: false, " + i + ", " + i + ", " + l / 1000L / 3600L + "h");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\weiyun\albumstatus\AlbumStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
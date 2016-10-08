import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gsk
  extends AsyncTask
{
  gsk(DoubleVideoCtrlUI paramDoubleVideoCtrlUI)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  protected Bitmap a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +30 -> 35
    //   8: ldc 33
    //   10: iconst_2
    //   11: new 35	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   18: ldc 38
    //   20: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: iconst_0
    //   25: aaload
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 50	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   39: getfield 55	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   42: invokevirtual 60	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   45: getfield 65	com/tencent/av/app/SessionInfo:a	Lcom/tencent/av/app/SessionInfo$Anychat_Info;
    //   48: getfield 70	com/tencent/av/app/SessionInfo$Anychat_Info:a	Landroid/graphics/Bitmap;
    //   51: ifnull +20 -> 71
    //   54: aload_0
    //   55: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   58: getfield 55	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   61: invokevirtual 60	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   64: getfield 65	com/tencent/av/app/SessionInfo:a	Lcom/tencent/av/app/SessionInfo$Anychat_Info;
    //   67: getfield 70	com/tencent/av/app/SessionInfo$Anychat_Info:a	Landroid/graphics/Bitmap;
    //   70: areturn
    //   71: new 35	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   78: aload_0
    //   79: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   82: getfield 73	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   85: invokevirtual 79	com/tencent/av/app/VideoAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   88: invokevirtual 85	mqq/app/MobileQQ:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   91: getfield 91	android/content/pm/ApplicationInfo:dataDir	Ljava/lang/String;
    //   94: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 93
    //   99: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: iconst_0
    //   104: aaload
    //   105: invokestatic 99	com/tencent/mobileqq/mqsafeedit/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 101
    //   113: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_3
    //   120: aload_3
    //   121: invokestatic 106	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   124: ifne +90 -> 214
    //   127: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +11 -> 141
    //   133: ldc 33
    //   135: iconst_2
    //   136: ldc 108
    //   138: invokestatic 50	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: new 110	java/io/File
    //   144: dup
    //   145: aload_3
    //   146: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 4
    //   151: aload_0
    //   152: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   155: getfield 73	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvAppVideoAppInterface	Lcom/tencent/av/app/VideoAppInterface;
    //   158: aload_1
    //   159: iconst_0
    //   160: aaload
    //   161: aload 4
    //   163: invokestatic 118	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)Z
    //   166: istore 5
    //   168: aload_2
    //   169: astore_1
    //   170: iload 5
    //   172: iconst_1
    //   173: if_icmpne +8 -> 181
    //   176: aload_3
    //   177: invokestatic 124	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   180: astore_1
    //   181: aload_1
    //   182: ifnull +78 -> 260
    //   185: aload_0
    //   186: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   189: getfield 55	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   192: ifnull +68 -> 260
    //   195: aload_0
    //   196: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   199: getfield 55	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   202: invokevirtual 60	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   205: getfield 65	com/tencent/av/app/SessionInfo:a	Lcom/tencent/av/app/SessionInfo$Anychat_Info;
    //   208: aload_1
    //   209: putfield 70	com/tencent/av/app/SessionInfo$Anychat_Info:a	Landroid/graphics/Bitmap;
    //   212: aload_1
    //   213: areturn
    //   214: aload_3
    //   215: invokestatic 124	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   218: astore_1
    //   219: goto -38 -> 181
    //   222: astore_1
    //   223: aload_0
    //   224: getfield 10	gsk:a	Lcom/tencent/av/ui/DoubleVideoCtrlUI;
    //   227: getfield 55	com/tencent/av/ui/DoubleVideoCtrlUI:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   230: invokevirtual 60	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/SessionInfo;
    //   233: getfield 65	com/tencent/av/app/SessionInfo:a	Lcom/tencent/av/app/SessionInfo$Anychat_Info;
    //   236: aconst_null
    //   237: putfield 70	com/tencent/av/app/SessionInfo$Anychat_Info:a	Landroid/graphics/Bitmap;
    //   240: aconst_null
    //   241: areturn
    //   242: astore_1
    //   243: aload_2
    //   244: astore_1
    //   245: goto -64 -> 181
    //   248: astore_1
    //   249: aload_2
    //   250: astore_1
    //   251: goto -70 -> 181
    //   254: astore_1
    //   255: aload_2
    //   256: astore_1
    //   257: goto -76 -> 181
    //   260: aload_1
    //   261: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	gsk
    //   0	262	1	paramVarArgs	String[]
    //   1	255	2	localObject	Object
    //   119	96	3	str	String
    //   149	13	4	localFile	java.io.File
    //   166	8	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	35	222	java/lang/OutOfMemoryError
    //   35	71	222	java/lang/OutOfMemoryError
    //   71	141	222	java/lang/OutOfMemoryError
    //   141	168	222	java/lang/OutOfMemoryError
    //   176	181	242	java/lang/OutOfMemoryError
    //   214	219	248	java/lang/OutOfMemoryError
    //   2	35	254	java/lang/Exception
    //   35	71	254	java/lang/Exception
    //   71	141	254	java/lang/Exception
    //   141	168	254	java/lang/Exception
    //   176	181	254	java/lang/Exception
    //   214	219	254	java/lang/Exception
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    try
    {
      this.a.a(paramBitmap);
      return;
    }
    catch (Exception paramBitmap) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
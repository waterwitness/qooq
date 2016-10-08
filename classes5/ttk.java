import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegDataDest;
import java.io.File;

public final class ttk
  implements JpegDataDest
{
  public ttk(File paramFile, CompressInfo paramCompressInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public void dataArrived(java.nio.ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 31	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 13	ttk:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   10: iconst_1
    //   11: invokespecial 34	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   14: invokevirtual 38	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore 5
    //   19: aload 5
    //   21: astore_3
    //   22: aload 5
    //   24: astore 4
    //   26: aload 5
    //   28: aload_1
    //   29: invokevirtual 44	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   32: pop
    //   33: aload 5
    //   35: ifnull +55 -> 90
    //   38: iload_2
    //   39: ifeq +46 -> 85
    //   42: aload 5
    //   44: iconst_1
    //   45: invokevirtual 48	java/nio/channels/FileChannel:force	(Z)V
    //   48: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +34 -> 85
    //   54: ldc 56
    //   56: iconst_2
    //   57: new 58	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   64: ldc 61
    //   66: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: getfield 13	ttk:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   73: invokevirtual 71	java/io/File:length	()J
    //   76: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 82	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 85	java/nio/channels/FileChannel:close	()V
    //   90: return
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   96: return
    //   97: astore_1
    //   98: aload_3
    //   99: astore 4
    //   101: aload_0
    //   102: getfield 15	ttk:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   105: ifnull +14 -> 119
    //   108: aload_3
    //   109: astore 4
    //   111: aload_0
    //   112: getfield 15	ttk:jdField_a_of_type_ComTencentMobileqqPicCompressInfo	Lcom/tencent/mobileqq/pic/CompressInfo;
    //   115: iconst_1
    //   116: invokevirtual 93	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   119: aload_3
    //   120: ifnull -30 -> 90
    //   123: iload_2
    //   124: ifeq +45 -> 169
    //   127: aload_3
    //   128: iconst_1
    //   129: invokevirtual 48	java/nio/channels/FileChannel:force	(Z)V
    //   132: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +34 -> 169
    //   138: ldc 56
    //   140: iconst_2
    //   141: new 58	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   148: ldc 61
    //   150: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 13	ttk:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   157: invokevirtual 71	java/io/File:length	()J
    //   160: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   163: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 82	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_3
    //   170: invokevirtual 85	java/nio/channels/FileChannel:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: ifnull +55 -> 241
    //   189: iload_2
    //   190: ifeq +46 -> 236
    //   193: aload 4
    //   195: iconst_1
    //   196: invokevirtual 48	java/nio/channels/FileChannel:force	(Z)V
    //   199: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +34 -> 236
    //   205: ldc 56
    //   207: iconst_2
    //   208: new 58	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   215: ldc 61
    //   217: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_0
    //   221: getfield 13	ttk:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   224: invokevirtual 71	java/io/File:length	()J
    //   227: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 82	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 4
    //   238: invokevirtual 85	java/nio/channels/FileChannel:close	()V
    //   241: aload_1
    //   242: athrow
    //   243: astore_3
    //   244: aload_3
    //   245: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   248: goto -7 -> 241
    //   251: astore_1
    //   252: goto -68 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	ttk
    //   0	255	1	paramByteBuffer	java.nio.ByteBuffer
    //   0	255	2	paramBoolean	boolean
    //   0	255	3	paramObject	Object
    //   24	213	4	localObject	Object
    //   17	69	5	localFileChannel	java.nio.channels.FileChannel
    // Exception table:
    //   from	to	target	type
    //   42	85	91	java/io/IOException
    //   85	90	91	java/io/IOException
    //   2	19	97	java/io/IOException
    //   26	33	97	java/io/IOException
    //   127	169	174	java/io/IOException
    //   169	173	174	java/io/IOException
    //   2	19	180	finally
    //   193	236	243	java/io/IOException
    //   236	241	243	java/io/IOException
    //   26	33	251	finally
    //   101	108	251	finally
    //   111	119	251	finally
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ttk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
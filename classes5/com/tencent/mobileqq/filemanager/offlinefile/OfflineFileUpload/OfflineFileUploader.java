package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.NetResp;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class OfflineFileUploader
  implements IOfflineFileHttpUploderSink
{
  long jdField_a_of_type_Long;
  FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public OfflineFileUploader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = null;
  }
  
  public long a(NetResp paramNetResp)
  {
    paramNetResp = new ByteArrayInputStream(paramNetResp.a);
    DataInputStream localDataInputStream = new DataInputStream(paramNetResp);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        b();
      }
    }
    catch (IOException localIOException)
    {
      int i;
      int j;
      long l;
      localIOException.printStackTrace();
    }
    finally
    {
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return -1L;
        localObject = finally;
        try
        {
          paramNetResp.close();
          localDataInputStream.close();
          throw ((Throwable)localObject);
        }
        catch (Exception paramNetResp)
        {
          for (;;) {}
        }
      }
      catch (Exception paramNetResp)
      {
        for (;;) {}
      }
    }
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      j = localDataInputStream.readInt();
      l = j;
      l = i | l << 32;
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return l;
      }
      catch (Exception paramNetResp)
      {
        return l;
      }
    }
    if (i == 1)
    {
      a();
      try
      {
        paramNetResp.close();
        localDataInputStream.close();
        return 0L;
      }
      catch (Exception paramNetResp)
      {
        return 0L;
      }
    }
    b();
    try
    {
      paramNetResp.close();
      localDataInputStream.close();
      return 0L;
    }
    catch (Exception paramNetResp)
    {
      return 0L;
    }
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver.a(paramLong1, paramLong2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong, FileTransferObserver paramFileTransferObserver)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = paramFileTransferObserver;
  }
  
  public void a(boolean paramBoolean) {}
  
  /* Error */
  public byte[] a(byte[] paramArrayOfByte, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	Ljava/lang/String;
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload 5
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: getfield 87	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:c	Ljava/lang/String;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   25: ifnull +26 -> 51
    //   28: aload 4
    //   30: ifnull +21 -> 51
    //   33: aload_0
    //   34: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokevirtual 96	java/lang/String:length	()I
    //   40: ifeq +11 -> 51
    //   43: aload 4
    //   45: invokevirtual 96	java/lang/String:length	()I
    //   48: ifne +23 -> 71
    //   51: invokestatic 102	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   54: ifeq +11 -> 65
    //   57: new 104	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 105	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: aload_0
    //   66: invokevirtual 57	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 4
    //   73: invokestatic 111	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   76: astore 6
    //   78: aload_0
    //   79: getfield 83	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 111	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   85: astore 7
    //   87: aload 7
    //   89: arraylength
    //   90: iconst_2
    //   91: iadd
    //   92: iconst_2
    //   93: iadd
    //   94: aload 6
    //   96: arraylength
    //   97: iadd
    //   98: bipush 20
    //   100: iadd
    //   101: aload_1
    //   102: arraylength
    //   103: iadd
    //   104: istore 8
    //   106: new 113	java/io/ByteArrayOutputStream
    //   109: dup
    //   110: iload 8
    //   112: bipush 16
    //   114: iadd
    //   115: invokespecial 116	java/io/ByteArrayOutputStream:<init>	(I)V
    //   118: astore 4
    //   120: new 118	java/io/DataOutputStream
    //   123: dup
    //   124: aload 4
    //   126: invokespecial 121	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   129: astore 5
    //   131: aload 5
    //   133: ldc 122
    //   135: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   138: aload 5
    //   140: sipush 1007
    //   143: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   146: aload 5
    //   148: iconst_0
    //   149: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   152: aload 5
    //   154: iload 8
    //   156: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   159: aload 5
    //   161: aload 7
    //   163: arraylength
    //   164: invokevirtual 128	java/io/DataOutputStream:writeShort	(I)V
    //   167: aload 5
    //   169: aload 7
    //   171: invokevirtual 131	java/io/DataOutputStream:write	([B)V
    //   174: aload 5
    //   176: aload 6
    //   178: arraylength
    //   179: invokevirtual 128	java/io/DataOutputStream:writeShort	(I)V
    //   182: aload 5
    //   184: aload 6
    //   186: invokevirtual 131	java/io/DataOutputStream:write	([B)V
    //   189: aload 5
    //   191: aload_0
    //   192: getfield 89	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   195: ldc2_w 132
    //   198: land
    //   199: l2i
    //   200: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   203: aload 5
    //   205: lload_2
    //   206: ldc2_w 132
    //   209: land
    //   210: l2i
    //   211: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   214: aload 5
    //   216: aload_1
    //   217: arraylength
    //   218: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   221: aload 5
    //   223: aload_0
    //   224: getfield 89	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:jdField_a_of_type_Long	J
    //   227: bipush 32
    //   229: lshr
    //   230: l2i
    //   231: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   234: aload 5
    //   236: lload_2
    //   237: bipush 32
    //   239: lshr
    //   240: l2i
    //   241: invokevirtual 125	java/io/DataOutputStream:writeInt	(I)V
    //   244: aload 5
    //   246: aload_1
    //   247: iconst_0
    //   248: aload_1
    //   249: arraylength
    //   250: invokevirtual 136	java/io/DataOutputStream:write	([BII)V
    //   253: aload 4
    //   255: invokevirtual 140	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   258: astore_1
    //   259: aload 4
    //   261: invokevirtual 141	java/io/ByteArrayOutputStream:close	()V
    //   264: aload 5
    //   266: invokevirtual 142	java/io/DataOutputStream:close	()V
    //   269: aload_1
    //   270: areturn
    //   271: astore 4
    //   273: aload_1
    //   274: areturn
    //   275: astore_1
    //   276: aload_0
    //   277: invokevirtual 57	com/tencent/mobileqq/filemanager/offlinefile/OfflineFileUpload/OfflineFileUploader:b	()V
    //   280: aload 4
    //   282: invokevirtual 141	java/io/ByteArrayOutputStream:close	()V
    //   285: aload 5
    //   287: invokevirtual 142	java/io/DataOutputStream:close	()V
    //   290: aconst_null
    //   291: areturn
    //   292: astore_1
    //   293: aload 4
    //   295: invokevirtual 141	java/io/ByteArrayOutputStream:close	()V
    //   298: aload 5
    //   300: invokevirtual 142	java/io/DataOutputStream:close	()V
    //   303: aload_1
    //   304: athrow
    //   305: astore 4
    //   307: goto -4 -> 303
    //   310: astore_1
    //   311: goto -21 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	OfflineFileUploader
    //   0	314	1	paramArrayOfByte	byte[]
    //   0	314	2	paramLong	long
    //   8	252	4	localObject1	Object
    //   271	23	4	localException1	Exception
    //   305	1	4	localException2	Exception
    //   4	295	5	localObject2	Object
    //   76	109	6	arrayOfByte1	byte[]
    //   85	85	7	arrayOfByte2	byte[]
    //   104	51	8	i	int
    // Exception table:
    //   from	to	target	type
    //   259	269	271	java/lang/Exception
    //   131	259	275	java/io/IOException
    //   131	259	292	finally
    //   276	280	292	finally
    //   293	303	305	java/lang/Exception
    //   280	290	310	java/lang/Exception
  }
  
  public void b() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\offlinefile\OfflineFileUpload\OfflineFileUploader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
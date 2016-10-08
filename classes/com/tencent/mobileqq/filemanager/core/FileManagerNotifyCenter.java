package com.tencent.mobileqq.filemanager.core;

import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Observable;
import mqq.os.MqqHandler;
import rwr;
import rws;

public class FileManagerNotifyCenter
  extends Observable
{
  public static final int a = 10001;
  protected static final String a = "FileManagerNotifyCenter<FileAssistant>";
  public QQAppInterface a;
  MqqHandler a;
  
  public FileManagerNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new rwr(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  /* Error */
  private tencent.im.msg.im_msg_body.RichText a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    // Byte code:
    //   0: new 55	tencent/im/msg/im_msg_body$NotOnlineFile
    //   3: dup
    //   4: invokespecial 56	tencent/im/msg/im_msg_body$NotOnlineFile:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: getfield 60	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14: iconst_0
    //   15: invokevirtual 66	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   18: aload 6
    //   20: getfield 70	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   23: aload_2
    //   24: invokevirtual 76	java/lang/String:getBytes	()[B
    //   27: invokestatic 82	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 87	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   33: aload 6
    //   35: getfield 91	tencent/im/msg/im_msg_body$NotOnlineFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   38: lload 4
    //   40: invokevirtual 96	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   43: aload 6
    //   45: getfield 99	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   48: aload_3
    //   49: invokevirtual 76	java/lang/String:getBytes	()[B
    //   52: invokestatic 82	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   55: invokevirtual 87	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   58: new 101	tencent/im/msg/im_msg_body$RichText
    //   61: dup
    //   62: invokespecial 102	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   65: astore_1
    //   66: aload_1
    //   67: getfield 106	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   70: aload 6
    //   72: invokevirtual 109	tencent/im/msg/im_msg_body$NotOnlineFile:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   75: aload_1
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +11 -> 94
    //   86: ldc 10
    //   88: iconst_2
    //   89: ldc 117
    //   91: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: goto -21 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	FileManagerNotifyCenter
    //   0	104	1	paramString1	String
    //   0	104	2	paramString2	String
    //   0	104	3	paramString3	String
    //   0	104	4	paramLong	long
    //   7	64	6	localNotOnlineFile	tencent.im.msg.im_msg_body.NotOnlineFile
    // Exception table:
    //   from	to	target	type
    //   0	66	77	java/lang/Exception
    //   66	75	100	java/lang/Exception
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("averageSpeed", String.valueOf(0.0F));
    ((HashMap)localObject).put("peerUin", String.valueOf(paramFileManagerEntity.peerUin));
    ((HashMap)localObject).put("fileType", FileUtil.a(paramFileManagerEntity.fileName));
    switch (paramInt)
    {
    default: 
      QLog.e("FileManagerNotifyCenter<FileAssistant>", 1, "what type is report?!nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],may be not report!");
      return;
    case 5: 
      return;
    case 6: 
      localObject = "actFileOf2Of";
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, (String)localObject, 1L, paramString, paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, paramFileManagerEntity.fileSize, 0, null);
      return;
      localObject = "actFileOf2Wy";
      continue;
      localObject = "actFileWy2Of";
      continue;
      localObject = "actFileDisc2Of";
      continue;
      localObject = "actFileDisc2Disc";
      continue;
      localObject = "actFileTroop2Of";
      continue;
      localObject = "actFileTroop2Disc";
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    setChanged();
    if (paramObject == null)
    {
      notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString2 });
      return;
    }
    notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), paramObject });
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    b(paramFileManagerEntity, paramInt, paramString);
    ThreadManager.a(new rws(this, paramFileManagerEntity, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, int paramInt, Object paramObject)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject });
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\filemanager\core\FileManagerNotifyCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
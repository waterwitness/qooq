package com.tencent.mobileqq.app.utils;

import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MessagePkgUtils
{
  private static final String a = "MessagePkgUtils";
  
  public MessagePkgUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Object a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    return new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject();
  }
  
  public static byte[] a(int paramInt, long paramLong)
  {
    byte[] arrayOfByte = new byte[12];
    PkgTools.a(arrayOfByte, 0, (short)2052);
    PkgTools.a(arrayOfByte, 2, 0L);
    PkgTools.a(arrayOfByte, 6, (int)paramLong);
    PkgTools.a(arrayOfByte, 10, (short)paramInt);
    return arrayOfByte;
  }
  
  public static byte[] a(long paramLong, MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    paramMarkFaceMessage = a(paramMarkFaceMessage, paramString);
    short s = (short)(paramMarkFaceMessage.length + 8);
    paramString = new byte[s + 5];
    paramString[0] = 1;
    PkgTools.a(paramString, 1, (short)4);
    PkgTools.a(paramString, 3, s);
    PkgTools.a(paramString, 5, (short)2052);
    PkgTools.a(paramString, 7, paramLong);
    PkgTools.a(paramString, 11, (short)2);
    PkgTools.a(paramString, 13, paramMarkFaceMessage, paramMarkFaceMessage.length);
    return paramString;
  }
  
  public static byte[] a(MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    if (paramMarkFaceMessage == null) {
      paramMarkFaceMessage = null;
    }
    byte[] arrayOfByte2;
    byte[] arrayOfByte1;
    do
    {
      return paramMarkFaceMessage;
      arrayOfByte2 = new byte[47];
      arrayOfByte2[0] = 2;
      PkgTools.a(arrayOfByte2, 1, (short)44);
      PkgTools.b(arrayOfByte2, 3, paramMarkFaceMessage.dwMSGItemType);
      arrayOfByte2[7] = ((byte)paramMarkFaceMessage.cFaceInfo);
      PkgTools.a(arrayOfByte2, 8, (short)paramMarkFaceMessage.wSize);
      i = paramMarkFaceMessage.sbufID.length;
      PkgTools.a(arrayOfByte2, 10, paramMarkFaceMessage.sbufID, i);
      PkgTools.a(arrayOfByte2, 26, paramMarkFaceMessage.dwTabID);
      arrayOfByte2[30] = ((byte)paramMarkFaceMessage.cSubType);
      i = paramMarkFaceMessage.sbfKey.length;
      PkgTools.a(arrayOfByte2, 31, paramMarkFaceMessage.sbfKey, i);
      i = arrayOfByte2.length;
      arrayOfByte1 = new byte[i + 3];
      arrayOfByte1[0] = 12;
      PkgTools.a(arrayOfByte1, 1, (short)i);
      PkgTools.a(arrayOfByte1, 3, arrayOfByte2, arrayOfByte2.length);
      arrayOfByte2 = PkgTools.d(paramString);
      int j = arrayOfByte1.length;
      i = j;
      if (arrayOfByte2 != null) {
        i = j + (arrayOfByte2.length + 1 + 2);
      }
      paramString = new byte[i];
      PkgTools.a(paramString, 0, arrayOfByte1, arrayOfByte1.length);
      paramMarkFaceMessage = paramString;
    } while (arrayOfByte2 == null);
    int i = arrayOfByte1.length;
    paramString[i] = 11;
    i += 1;
    PkgTools.a(paramString, i, (short)arrayOfByte2.length);
    PkgTools.a(paramString, i + 2, arrayOfByte2, arrayOfByte2.length);
    return paramString;
  }
  
  public static byte[] a(Serializable paramSerializable)
  {
    if (paramSerializable == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializable);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] b(long paramLong, MarkFaceMessage paramMarkFaceMessage, String paramString)
  {
    byte[] arrayOfByte = a(2, paramLong);
    paramMarkFaceMessage = a(paramMarkFaceMessage, paramString);
    paramString = new byte[arrayOfByte.length + 5 + paramMarkFaceMessage.length];
    paramString[0] = 1;
    PkgTools.a(paramString, 1, (short)119);
    PkgTools.a(paramString, 3, (short)(arrayOfByte.length + paramMarkFaceMessage.length));
    PkgTools.a(paramString, 5, arrayOfByte, arrayOfByte.length);
    PkgTools.a(paramString, arrayOfByte.length + 5, paramMarkFaceMessage, paramMarkFaceMessage.length);
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "hex =" + PkgTools.b(paramString));
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\utils\MessagePkgUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
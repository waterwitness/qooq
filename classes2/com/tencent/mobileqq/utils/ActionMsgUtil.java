package com.tencent.mobileqq.utils;

import ActionMsg.MsgBody;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class ActionMsgUtil
{
  private static final String a = "ActionMsgUtil";
  private static final String b = ActionMsgUtil.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MsgBody a(String paramString)
  {
    MsgBody localMsgBody = new MsgBody();
    try
    {
      JceInputStream localJceInputStream = new JceInputStream(HexUtil.hexStr2Bytes(paramString));
      localJceInputStream.setServerEncoding("utf-8");
      localMsgBody.readFrom(localJceInputStream);
      return localMsgBody;
    }
    catch (Exception localException)
    {
      QLog.w("ActionMsgUtil", 2, "decode error msg = " + paramString);
      QLog.w("ActionMsgUtil", 2, localException.toString());
      localMsgBody.msg = "";
      localMsgBody.action = "";
      localMsgBody.shareAppID = 0L;
      localMsgBody.actMsgContentValue = "";
    }
    return localMsgBody;
  }
  
  public static ActionMsgUtil.AppShareCookie a(byte[] paramArrayOfByte)
  {
    ActionMsgUtil.AppShareCookie localAppShareCookie = new ActionMsgUtil.AppShareCookie();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    for (;;)
    {
      try
      {
        paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
        localAppShareCookie.jdField_a_of_type_Int = paramArrayOfByte.get();
        if (paramArrayOfByte.get() != 0) {
          continue;
        }
        i = 62532;
        localAppShareCookie.b = i;
        if (paramArrayOfByte.hasRemaining())
        {
          i = paramArrayOfByte.get();
          byte[] arrayOfByte = new byte[paramArrayOfByte.getShort()];
          paramArrayOfByte.get(arrayOfByte);
          localAppShareCookie.c = i;
          localAppShareCookie.jdField_a_of_type_JavaLangString = new String(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "decodeAppShareCookie succes appShareCookie.buissnessType =" + localAppShareCookie.jdField_a_of_type_Int + "appShareCookie.action" + localAppShareCookie.b + "appShareCookie.actionType" + localAppShareCookie.c + "appShareCookie.actionValue" + localAppShareCookie.jdField_a_of_type_JavaLangString);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        int i;
        paramArrayOfByte.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(b, 2, "decodeAppShareCookie", paramArrayOfByte);
      }
      return localAppShareCookie;
      i = 62531;
    }
    return localAppShareCookie;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 0L, null);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramString2, paramLong, null);
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      str = "";
      QLog.w("ActionMsgUtil", 2, "encode msg is null");
    }
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = "";
      QLog.w("ActionMsgUtil", 2, "encode action is null");
    }
    paramString2 = new MsgBody();
    paramString2.msg = str;
    paramString2.action = paramString1;
    paramString2.shareAppID = paramLong;
    paramString2.actMsgContentValue = paramString3;
    paramString1 = new JceOutputStream();
    paramString1.setServerEncoding("utf-8");
    paramString2.writeTo(paramString1);
    return HexUtil.bytes2HexStr(paramString1.toByteArray());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 62536) || (paramInt == 62532) || (paramInt == 62531);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 63527) || (paramInt == 62524);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 63520;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 63529;
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == 63497;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\ActionMsgUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
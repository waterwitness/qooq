package com.tencent.av.gaudio;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AVInvitePSTNPhone
{
  private static final String a = "AVInvitePSTNPhone";
  private static int c = 28;
  public int a;
  public TelInfo a;
  public int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AVInvitePSTNPhone()
  {
    this.jdField_a_of_type_ComTencentAvGaudioTelInfo = new TelInfo();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i + paramInt)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
  
  private static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i + paramInt)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  public static ArrayList a(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = null;
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer detail is null");
        localObject = localArrayList;
      }
    }
    do
    {
      return (ArrayList)localObject;
      if (paramInt != 0) {
        break;
      }
      localObject = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer buflen == 0");
    return null;
    int i = paramInt / c;
    QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer buflen == " + Long.toString(paramInt) + " count=" + Long.toString(i));
    localArrayList = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i) {
        break;
      }
      localObject = new AVInvitePSTNPhone();
      ((AVInvitePSTNPhone)localObject).jdField_a_of_type_Int = a(paramArrayOfByte, c * paramInt);
      try
      {
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.a = new String(paramArrayOfByte, c * paramInt + 4, 5, "UTF-8");
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.b = new String(paramArrayOfByte, c * paramInt + 9, 5, "UTF-8");
        ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.c = new String(paramArrayOfByte, c * paramInt + 14, 12, "UTF-8");
        QLog.e("AVInvitePSTNPhone", 2, "getListFromBuffer bytes_nation == " + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.a + " ,bytes_prefix=" + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.b + " ,bytes_mobile=" + ((AVInvitePSTNPhone)localObject).jdField_a_of_type_ComTencentAvGaudioTelInfo.c);
        localArrayList.add(localObject);
        paramInt += 1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\gaudio\AVInvitePSTNPhone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
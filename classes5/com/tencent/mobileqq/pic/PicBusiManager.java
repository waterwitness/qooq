package com.tencent.mobileqq.pic;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.StringToIntParser;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;

public class PicBusiManager
{
  public static final int a = 1;
  private static final String a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PicBusiManager.class.getSimpleName();
  }
  
  static BasePicOprerator a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator(paramQQAppInterface);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  static InfoBuilder a(int paramInt)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    }
    return new AioPicOperator();
  }
  
  public static PicDownloadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static PicFowardInfo a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static PicReq a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static PicReq a(int paramInt1, int paramInt2, int paramInt3)
  {
    PicReq localPicReq = new PicReq();
    localPicReq.n = paramInt1;
    localPicReq.p = paramInt2;
    localPicReq.o = paramInt3;
    return localPicReq;
  }
  
  public static PicUploadInfo a(int paramInt, Intent paramIntent)
  {
    InfoBuilder localInfoBuilder = a(paramInt);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramIntent);
  }
  
  public static ArrayList a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    InfoBuilder localInfoBuilder = a(paramInt1);
    if (localInfoBuilder == null) {
      return null;
    }
    return localInfoBuilder.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static void a(PicReq paramPicReq, QQAppInterface paramQQAppInterface)
  {
    if (paramPicReq == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,req == null");
      return;
    }
    Object localObject = a(paramPicReq.o, paramQQAppInterface);
    if (localObject == null)
    {
      Logger.b(jdField_a_of_type_JavaLangString, "launch", "error,busiInterface == null,req.busiType:" + paramPicReq.o);
      return;
    }
    ((BasePicOprerator)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ((BasePicOprerator)localObject).jdField_a_of_type_ComTencentMobileqqPicPicReq = paramPicReq;
    ((BasePicOprerator)localObject).jdField_a_of_type_JavaLangString = paramPicReq.jdField_a_of_type_JavaLangString;
    ((BasePicOprerator)localObject).b = paramPicReq.b;
    ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicUiCallBack);
    Logger.a(jdField_a_of_type_JavaLangString, "launch", "cmd:" + paramPicReq.n + ",busiType" + paramPicReq.o + "localUUID:" + paramPicReq.jdField_a_of_type_JavaLangString);
    switch (paramPicReq.n)
    {
    default: 
      return;
    case 1: 
      paramQQAppInterface = a(paramQQAppInterface);
      localObject = new Intent(BaseApplication.getContext(), PeakService.class);
      ((Intent)localObject).putExtra("ServiceAction", 1);
      ((Intent)localObject).putExtra("CompressInfo", paramPicReq.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      ((Intent)localObject).putExtra("CompressConfig", paramQQAppInterface);
      if (paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack != null) {
        ((Intent)localObject).putExtra("CompressCallback", new BinderWarpper(paramPicReq.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoICompressionCallBack.asBinder()));
      }
      BaseApplication.getContext().startService((Intent)localObject);
      return;
    case 5: 
    case 6: 
    case 7: 
      ((BasePicOprerator)localObject).b(paramPicReq);
      return;
    case 2: 
      ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    case 3: 
      ((BasePicOprerator)localObject).a(paramPicReq);
      return;
    case 4: 
      ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo);
      return;
    }
    ((BasePicOprerator)localObject).a(paramPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    Logger.a(jdField_a_of_type_JavaLangString, "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.StringToIntParser()) >= arrayOfInteger.length)
        {
          paramQQAppInterface = paramQQAppInterface.f();
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            PicType.j = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            PicType.k = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            PicType.l = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            PicType.m = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            PicType.n = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            PicType.o = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            PicType.e = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            PicType.f = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            PicType.g = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = PicType.j;
      paramQQAppInterface[1] = PicType.k;
      paramQQAppInterface[2] = PicType.l;
      paramQQAppInterface[3] = PicType.m;
      paramQQAppInterface[4] = PicType.n;
      paramQQAppInterface[5] = PicType.o;
      paramQQAppInterface[6] = PicType.e;
      paramQQAppInterface[7] = PicType.f;
      paramQQAppInterface[8] = PicType.g;
      Logger.a(jdField_a_of_type_JavaLangString, "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      Logger.a(jdField_a_of_type_JavaLangString, "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\PicBusiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
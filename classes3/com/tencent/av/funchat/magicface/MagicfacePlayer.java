package com.tencent.av.funchat.magicface;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.service.SoundPoolUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import ghn;
import java.io.File;

public class MagicfacePlayer
{
  private static final String jdField_c_of_type_JavaLangString = "AVMagicfacePlayer";
  public MagicfaceBaseDecoder.MagicPlayListener a;
  public MagicfaceBaseDecoder.MagicfaceRenderListener a;
  private MagicfaceBaseDecoder jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder;
  public MagicfaceData a;
  private SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  public String a;
  public MagicfaceBaseDecoder.MagicPlayListener b;
  public String b;
  MagicfaceBaseDecoder.MagicPlayListener jdField_c_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener;
  
  public MagicfacePlayer()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = new ghn(this);
    a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder == null)
    {
      if (DeviceInfoUtil.d())
      {
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
        b("initDecoder| use [MagicfaceNormalDecoder]");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder = new MagicfaceNormalDecoder();
    b("initDecoder|use [MagicfaceNormalDecoder]");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, MagicfaceData paramMagicfaceData, MagicfaceBaseDecoder.MagicfaceRenderListener paramMagicfaceRenderListener, MagicfaceBaseDecoder.MagicPlayListener paramMagicPlayListener)
  {
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a) {
      try
      {
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData = paramMagicfaceData;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = paramMagicfaceRenderListener;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.b();
        return;
      }
      finally {}
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = (paramString + "audio" + File.separator + paramMagicfaceData.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener = paramMagicPlayListener;
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener = null;
      if ((paramMagicfaceData.jdField_b_of_type_JavaLangString != null) && (!paramMagicfaceData.jdField_b_of_type_JavaLangString.equals(""))) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
      }
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a(paramString + "video" + File.separator);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a(paramMagicfaceData);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a(paramMagicfaceRenderListener);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a(this.c);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.a;
  }
  
  public void b()
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceData = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicfaceRenderListener = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder$MagicPlayListener = null;
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.b();
      return;
    }
    finally {}
  }
  
  void b(String paramString)
  {
    QLog.i("AVMagicfacePlayer", 2, paramString);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder != null) {
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceBaseDecoder.f();
    }
  }
  
  public void c(String paramString)
  {
    QLog.e("AVMagicfacePlayer", 1, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfacePlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
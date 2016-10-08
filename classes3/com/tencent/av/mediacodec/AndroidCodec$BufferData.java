package com.tencent.av.mediacodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;

public class AndroidCodec$BufferData
{
  public int a;
  public MediaCodec.BufferInfo a;
  public MediaFormat a;
  public ByteBuffer a;
  public boolean a;
  
  public AndroidCodec$BufferData(AndroidCodec paramAndroidCodec)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\mediacodec\AndroidCodec$BufferData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
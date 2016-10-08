package com.tencent.mobileqq.shortvideo.hwcodec;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;

public class SVHwCodec$BufferData
{
  public int a;
  public MediaCodec.BufferInfo a;
  public MediaFormat a;
  public ByteBuffer a;
  public boolean a;
  
  public SVHwCodec$BufferData(SVHwCodec paramSVHwCodec)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\hwcodec\SVHwCodec$BufferData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
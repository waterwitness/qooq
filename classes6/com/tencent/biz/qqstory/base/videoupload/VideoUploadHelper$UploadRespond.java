package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class VideoUploadHelper$UploadRespond
{
  public int a;
  public String a;
  public ByteBuffer a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public VideoUploadHelper$UploadRespond(HashMap paramHashMap)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = a((ByteBuffer)paramHashMap.get("ver"));
    this.b = a((ByteBuffer)paramHashMap.get("seq"));
    this.c = a((ByteBuffer)paramHashMap.get("fileid"));
    this.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)paramHashMap.get("filebitmap"));
    this.d = a((ByteBuffer)paramHashMap.get("rangestart"));
    this.e = a((ByteBuffer)paramHashMap.get("rangeend"));
    String str = a((ByteBuffer)paramHashMap.get("retcode"));
    try
    {
      this.jdField_a_of_type_Int = Integer.valueOf(str).intValue();
      this.f = a((ByteBuffer)paramHashMap.get("cdnurl"));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        SLog.b("Q.qqstory.publish:VideoUploadHelper", "decode int", localException);
      }
    }
  }
  
  private static String a(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return "";
    }
    return new String(paramByteBuffer.array());
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int m = paramArrayOfByte[i];
      int j = 0;
      if (j < 8)
      {
        int k;
        if ((m & 0x1) > 0)
        {
          k = 1;
          label44:
          if (k == 0) {
            break label73;
          }
        }
        label73:
        for (String str = "1";; str = "0")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
          k = 0;
          break label44;
        }
      }
      i += 1;
    }
    SLog.a("Q.qqstory.publish:VideoUploadHelper", "fileBitmap:%s", localStringBuilder.toString());
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {}
    label102:
    label111:
    label116:
    for (;;)
    {
      return false;
      this.jdField_a_of_type_JavaNioByteBuffer.rewind();
      byte[] arrayOfByte = this.jdField_a_of_type_JavaNioByteBuffer.array();
      a(arrayOfByte);
      int n = paramInt / 8192;
      paramInt = 0;
      int i = 0;
      for (;;)
      {
        if (paramInt >= arrayOfByte.length) {
          break label116;
        }
        int k = arrayOfByte[paramInt];
        int j = 0;
        for (;;)
        {
          if (j >= 8) {
            break label111;
          }
          if ((k & 0x1) > 0) {}
          for (int m = 1; m != 0; m = 0)
          {
            k = (byte)(k >>> 1);
            i += 1;
            if (n != i) {
              break label102;
            }
            return true;
          }
          break;
          j += 1;
        }
        paramInt += 1;
      }
    }
  }
  
  public String toString()
  {
    return "UploadRespond{ ver='" + this.jdField_a_of_type_JavaLangString + '\'' + ", seq='" + this.b + '\'' + ", fileId='" + this.c + '\'' + ", filebitmap='" + this.jdField_a_of_type_JavaNioByteBuffer + '\'' + ", rangestart='" + this.d + '\'' + ", rangeend='" + this.e + '\'' + ", retcode=" + this.jdField_a_of_type_Int + "，cdnurl='" + this.f + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\VideoUploadHelper$UploadRespond.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
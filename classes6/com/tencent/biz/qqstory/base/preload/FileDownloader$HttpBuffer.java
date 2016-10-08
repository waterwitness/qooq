package com.tencent.biz.qqstory.base.preload;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class FileDownloader$HttpBuffer
{
  protected int a;
  protected long a;
  protected File a;
  protected RandomAccessFile a;
  protected String a;
  protected byte[] a;
  protected int b;
  protected long b;
  protected String b;
  protected int c;
  
  public FileDownloader$HttpBuffer(FileDownloader paramFileDownloader, RandomAccessFile paramRandomAccessFile, String paramString1, int paramInt1, String paramString2, File paramFile, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaIoRandomAccessFile = paramRandomAccessFile;
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_b_of_type_Int];
  }
  
  public int a(InputStream arg1)
  {
    int i = ???.read(this.jdField_a_of_type_ArrayOfByte, this.c, this.jdField_a_of_type_ArrayOfByte.length - this.c);
    if (i > 0) {
      this.c += i;
    }
    if ((i != -1) && (this.c < this.jdField_b_of_type_Int)) {
      return i;
    }
    this.jdField_a_of_type_JavaIoRandomAccessFile.write(this.jdField_a_of_type_ArrayOfByte, 0, this.c);
    this.jdField_a_of_type_Long += this.c;
    this.c = 0;
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a != null)
    {
      int j = (int)(this.jdField_a_of_type_Long / this.jdField_b_of_type_Long * 100.0D);
      synchronized (PreloadDownloader.a)
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadFileDownloader.a.iterator();
        while (localIterator.hasNext())
        {
          IVideoPreloader.OnPreloadListener localOnPreloadListener = (IVideoPreloader.OnPreloadListener)((WeakReference)localIterator.next()).get();
          if (localOnPreloadListener != null) {
            localOnPreloadListener.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaIoFile, j);
          }
        }
      }
    }
    return i;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\FileDownloader$HttpBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
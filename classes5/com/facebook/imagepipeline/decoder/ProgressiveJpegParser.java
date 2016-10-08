package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteArrayBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser
{
  private static final int BUFFER_SIZE = 16384;
  private static final int NOT_A_JPEG = 6;
  private static final int READ_FIRST_JPEG_BYTE = 0;
  private static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
  private static final int READ_MARKER_SECOND_BYTE = 3;
  private static final int READ_SECOND_JPEG_BYTE = 1;
  private static final int READ_SIZE_FIRST_BYTE = 4;
  private static final int READ_SIZE_SECOND_BYTE = 5;
  private int mBestScanEndOffset;
  private int mBestScanNumber;
  private final ByteArrayPool mByteArrayPool;
  private int mBytesParsed;
  private int mLastByteRead;
  private int mNextFullScanNumber;
  private int mParserState;
  
  public ProgressiveJpegParser(ByteArrayPool paramByteArrayPool)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mBytesParsed = 0;
    this.mLastByteRead = 0;
    this.mNextFullScanNumber = 0;
    this.mBestScanEndOffset = 0;
    this.mBestScanNumber = 0;
    this.mParserState = 0;
  }
  
  private boolean doParseMoreData(InputStream paramInputStream)
  {
    int i = this.mBestScanNumber;
    int j;
    try
    {
      if (this.mParserState != 6)
      {
        j = paramInputStream.read();
        if (j != -1) {
          break label43;
        }
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        label43:
        label100:
        Throwables.propagate(paramInputStream);
        continue;
        if (j == 255)
        {
          this.mParserState = 1;
        }
        else
        {
          this.mParserState = 6;
          continue;
          if (j == 216)
          {
            this.mParserState = 2;
          }
          else
          {
            this.mParserState = 6;
            continue;
            if (j == 255)
            {
              this.mParserState = 3;
              continue;
              if (j != 255) {
                break;
              }
              this.mParserState = 3;
            }
          }
        }
      }
      if (j != 0) {
        break label293;
      }
    }
    if ((this.mParserState != 6) && (this.mBestScanNumber != i))
    {
      return true;
      this.mBytesParsed += 1;
      switch (this.mParserState)
      {
      case 0: 
        Preconditions.checkState(false);
      case 1: 
      case 2: 
      case 3: 
        for (;;)
        {
          this.mLastByteRead = j;
          break;
          this.mParserState = 2;
        }
      }
    }
    for (;;)
    {
      label207:
      newScanOrImageEndFound(this.mBytesParsed - 2);
      label293:
      do
      {
        if (doesMarkerStartSegment(j))
        {
          this.mParserState = 4;
          break label100;
        }
        this.mParserState = 2;
        break label100;
        this.mParserState = 5;
        break label100;
        int k = (this.mLastByteRead << 8) + j - 2;
        StreamUtil.skip(paramInputStream, k);
        this.mBytesParsed += k;
        this.mParserState = 2;
        break label100;
        return false;
        break;
        if (j == 218) {
          break label207;
        }
      } while (j != 217);
    }
  }
  
  private static boolean doesMarkerStartSegment(int paramInt)
  {
    if (paramInt == 1) {}
    while (((paramInt >= 208) && (paramInt <= 215)) || (paramInt == 217) || (paramInt == 216)) {
      return false;
    }
    return true;
  }
  
  private void newScanOrImageEndFound(int paramInt)
  {
    if (this.mNextFullScanNumber > 0) {
      this.mBestScanEndOffset = paramInt;
    }
    paramInt = this.mNextFullScanNumber;
    this.mNextFullScanNumber = (paramInt + 1);
    this.mBestScanNumber = paramInt;
  }
  
  public int getBestScanEndOffset()
  {
    return this.mBestScanEndOffset;
  }
  
  public int getBestScanNumber()
  {
    return this.mBestScanNumber;
  }
  
  public boolean isJpeg()
  {
    return (this.mBytesParsed > 1) && (this.mParserState != 6);
  }
  
  public boolean parseMoreData(EncodedImage paramEncodedImage)
  {
    if (this.mParserState == 6) {
      return false;
    }
    if (paramEncodedImage.getSize() <= this.mBytesParsed) {
      return false;
    }
    paramEncodedImage = new PooledByteArrayBufferedInputStream(paramEncodedImage.getInputStream(), (byte[])this.mByteArrayPool.get(16384), this.mByteArrayPool);
    try
    {
      StreamUtil.skip(paramEncodedImage, this.mBytesParsed);
      boolean bool = doParseMoreData(paramEncodedImage);
      return bool;
    }
    catch (IOException localIOException)
    {
      Throwables.propagate(localIOException);
      return false;
    }
    finally
    {
      Closeables.closeQuietly(paramEncodedImage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\decoder\ProgressiveJpegParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
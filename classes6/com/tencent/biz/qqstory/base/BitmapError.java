package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.reactive.Optional;

public class BitmapError
  extends Error
{
  public static final int REASON_BITMAP_COPY_FAIL = 3;
  public static final int REASON_BITMAP_ERR_WIDTH_HEIGHT = 8;
  public static final int REASON_BITMAP_GET_ERR = 7;
  public static final int REASON_BITMAP_LOAD_FAIL = 2;
  public static final int REASON_DECODE_ERROR = 6;
  public static final int REASON_FILE_NOT_FOUND = 4;
  public static final int REASON_IO_ERROR = 4;
  public static final int REASON_OUT_OF_MEM = 5;
  public static final int REASON_UNKNOWN = 0;
  public static final int REASON_URL_EMPTY = 1;
  public Optional detail;
  public final int reason;
  public final String source;
  
  public BitmapError(String paramString, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.detail = Optional.empty();
    this.reason = paramInt;
    this.source = paramString;
  }
  
  public void setDetail(String paramString)
  {
    this.detail = Optional.ofNullable(paramString);
  }
  
  public String toString()
  {
    return "BimapError { reason = " + this.reason + ", source = " + this.source + ", detail = " + (String)this.detail.orElse("(no detail)") + " }";
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\BitmapError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
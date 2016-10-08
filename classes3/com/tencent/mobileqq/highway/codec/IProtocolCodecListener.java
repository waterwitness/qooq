package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import java.util.List;

public abstract interface IProtocolCodecListener
{
  public abstract void onDecodeInvalidData(int paramInt);
  
  public abstract void onDecodeSucessfully(List<HwResponse> paramList);
  
  public abstract void onEncodePkgError(HwRequest paramHwRequest, int paramInt);
  
  public static abstract interface CODEC_ERROR_CODE
  {
    public static final int DECODE_DATA_EXCEED = 1;
    public static final int DECODE_DATA_INVALID_FORMAT = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\codec\IProtocolCodecListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
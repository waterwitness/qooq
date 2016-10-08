package com.tencent.maxvideo.common;

public class ControlFlagEnum
{
  public static final ControlFlagEnum NONE = new ControlFlagEnum(0);
  public static final ControlFlagEnum OPEN_FILE_AND_WRITE_FRAME_DATA = new ControlFlagEnum(1);
  public static final ControlFlagEnum WRITE_FRAME_DATA = new ControlFlagEnum(2);
  public static final ControlFlagEnum WRITE_FRAME_DATA_AND_CLOSE_FILE = new ControlFlagEnum(3);
  int mValue;
  
  private ControlFlagEnum(int paramInt)
  {
    this.mValue = paramInt;
  }
  
  public int getValue()
  {
    return this.mValue;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\maxvideo\common\ControlFlagEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
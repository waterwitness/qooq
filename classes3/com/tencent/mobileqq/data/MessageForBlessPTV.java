package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class MessageForBlessPTV
  extends MessageForShortVideo
{
  public static String BLESS_REQ_UIN = "0";
  public static final int PTV_SUB_BUSITYPE = 1;
  public ArrayList uinList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForBlessPTV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
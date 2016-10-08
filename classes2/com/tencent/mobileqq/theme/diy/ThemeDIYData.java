package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ThemeDIYData
{
  public static final int ITEM_SAVE_ERR = -1;
  public static final int ITEM_SAVE_ING = 4;
  public static final int ITEM_SAVE_OK = 6;
  public static final int ITEM_SET_CHANGE = 2;
  public static final int ITEM_SET_INIT = 0;
  public String bgBig;
  ResData bgDefaultPic;
  ResData bgDiyPic;
  ResData bgDiyPicRes;
  public String bgSmall;
  int bgTryOnPosition;
  public int dealInt;
  public String dealSpkey;
  public String defaultButtonText;
  public String imgBig;
  public String imgSmall;
  ResData intoDiyPic;
  public int mSaveStatus;
  public int mSetStatus;
  public int orgMarkColor;
  public String orgSpKey;
  public String pageName;
  public int position;
  ResData screenShot;
  
  public ThemeDIYData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, int paramInt2, String paramString8, int paramInt3)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.pageName = paramString1;
    this.imgBig = paramString2;
    this.bgBig = paramString3;
    this.imgSmall = paramString4;
    this.bgSmall = paramString5;
    this.orgSpKey = paramString6;
    this.orgMarkColor = paramInt1;
    this.dealSpkey = paramString7;
    this.dealInt = paramInt2;
    this.defaultButtonText = paramString8;
    this.position = paramInt3;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
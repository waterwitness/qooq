package com.tencent.mobileqq.theme.diy;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ResData
{
  static final String BUNDLE_KEY_INDEX = "index";
  static final int BUNDLE_KEY_PIC_Bg_DEFAULT = 3;
  static final int BUNDLE_KEY_PIC_Bg_THUM = 4;
  static final int BUNDLE_KEY_PIC_DIY = 0;
  static final int BUNDLE_KEY_PIC_DIY_PREVIEW = 1;
  static final int BUNDLE_KEY_PIC_SCREEN = 2;
  static final String BUNDLE_KEY_PIC_TYPE = "picType";
  static final String BUNDLE_KEY_TYPE = "type";
  static final int RES_DATA_FROM_LOCAL = 1;
  static final int RES_DATA_FROM_NET = 0;
  static final int RES_DATA_FROM_RESOURCE = 2;
  static final int RES_DATA_STATE_DEALED = 5;
  static final int RES_DATA_STATE_DEALING = 4;
  static final int RES_DATA_STATE_ERROR = -1;
  static final int RES_DATA_STATE_INIT = 0;
  static final int RES_DATA_STATE_LOADED = 2;
  static final int RES_DATA_STATE_LOADING = 1;
  static final int RES_DATA_STATE_OK = 2;
  static final int RES_DATA_TYPE_JSON = 2;
  static final int RES_DATA_TYPE_PIC = 0;
  static final int RES_DATA_TYPE_ZIP = 1;
  String dealedName;
  int from;
  int id;
  int index;
  String name;
  String path;
  int picType;
  int state;
  int type;
  String url;
  
  public ResData(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.name = paramString1;
    this.id = paramInt1;
    this.index = paramInt2;
    this.path = paramString2;
    this.url = paramString3;
    this.state = paramInt3;
    this.type = paramInt4;
    this.picType = paramInt5;
    this.from = paramInt6;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ResData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
package com.tencent.ttpic.util;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.view.FilterDefault;

public class RGBATexSaveProcess
  implements TexSaveProcess
{
  private byte[] mData;
  private BaseFilter mFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mRenderFrame = new Frame();
  
  private void initData(int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt1 * paramInt2 * 4;
    if ((this.mData == null) || (this.mData.length < paramInt1)) {
      this.mData = new byte[paramInt1];
    }
  }
  
  public void clear()
  {
    this.mFilter.clearGLSLSelf();
    this.mRenderFrame.clear();
    this.mData = null;
  }
  
  public void init()
  {
    this.mFilter.ApplyGLSLFilter();
  }
  
  public byte[] retrieveData(int paramInt1, int paramInt2, int paramInt3)
  {
    init();
    initData(paramInt2, paramInt3);
    this.mRenderFrame.bindFrame(-1, paramInt2, paramInt3, 0.0D);
    this.mFilter.OnDrawFrameGLSL();
    this.mFilter.renderTexture(paramInt1, paramInt2, paramInt3);
    if (FilterDefault.currentShareIndex < 0) {
      GLSLRender.nativeToRGBData(this.mData, paramInt2, paramInt3);
    }
    for (;;)
    {
      return this.mData;
      GLSLRender.nativePushDataFromTexture(this.mData, paramInt2, paramInt3, FilterDefault.currentShareIndex);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\RGBATexSaveProcess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */
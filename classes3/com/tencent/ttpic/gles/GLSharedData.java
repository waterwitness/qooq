package com.tencent.ttpic.gles;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import com.tencent.filter.Frame;

public class GLSharedData
{
  public EGLContext mSharedContext;
  private final Frame[] mTexFrames;
  public int[] mTexId;
  public TextureDataPipe[] mTexturePile;
  
  public GLSharedData(EGLContext paramEGLContext, int[] paramArrayOfInt, Frame[] paramArrayOfFrame)
  {
    this.mSharedContext = paramEGLContext;
    this.mTexturePile = new TextureDataPipe[2];
    this.mTexId = paramArrayOfInt;
    this.mTexFrames = paramArrayOfFrame;
    this.mTexturePile[0] = new TextureDataPipe(paramArrayOfInt[0], paramArrayOfFrame[0]);
    this.mTexturePile[1] = new TextureDataPipe(paramArrayOfInt[1], paramArrayOfFrame[1]);
  }
  
  public void clear()
  {
    int i = 0;
    GLES20.glDeleteTextures(this.mTexId.length, this.mTexId, 0);
    if (this.mTexFrames != null)
    {
      Frame[] arrayOfFrame = this.mTexFrames;
      int j = arrayOfFrame.length;
      while (i < j)
      {
        arrayOfFrame[i].clear();
        i += 1;
      }
    }
  }
  
  public TextureDataPipe getCurrentTexturePile()
  {
    TextureDataPipe localTextureDataPipe = null;
    int i;
    int j;
    if (this.mTexturePile[0].getTexureCurrentStatus() == 2)
    {
      i = 1;
      if (this.mTexturePile[1].getTexureCurrentStatus() != 2) {
        break label76;
      }
      j = 1;
      label32:
      if ((i == 0) || (j == 0)) {
        break label88;
      }
      if (this.mTexturePile[0].mTimestamp >= this.mTexturePile[1].mTimestamp) {
        break label81;
      }
      localTextureDataPipe = this.mTexturePile[0];
    }
    label76:
    label81:
    label88:
    do
    {
      return localTextureDataPipe;
      i = 0;
      break;
      j = 0;
      break label32;
      return this.mTexturePile[1];
      if (i != 0) {
        return this.mTexturePile[0];
      }
    } while (j == 0);
    return this.mTexturePile[1];
  }
  
  public TextureDataPipe getFreeTexturePileMakeBusy()
  {
    Object localObject2 = null;
    int i = 0;
    for (;;)
    {
      Object localObject1 = localObject2;
      if (i < this.mTexturePile.length)
      {
        if (this.mTexturePile[i].getTexureCurrentStatus() == 0)
        {
          localObject1 = this.mTexturePile[i];
          ((TextureDataPipe)localObject1).makeBusy();
        }
      }
      else {
        return (TextureDataPipe)localObject1;
      }
      i += 1;
    }
  }
  
  public boolean judgeBrotherTextureIsReady(TextureDataPipe paramTextureDataPipe)
  {
    TextureDataPipe localTextureDataPipe = this.mTexturePile[0];
    if (this.mTexturePile[0] == paramTextureDataPipe) {
      localTextureDataPipe = this.mTexturePile[1];
    }
    return localTextureDataPipe.getTexureCurrentStatus() == 2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\gles\GLSharedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */